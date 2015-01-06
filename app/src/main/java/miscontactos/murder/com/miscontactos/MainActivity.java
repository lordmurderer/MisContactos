package miscontactos.murder.com.miscontactos;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import miscontactos.murder.com.miscontactos.util.TextChangedListener;


public class MainActivity extends ActionBarActivity {

    private EditText txtNombre, txtTelefono, txtDireccion, txtEmail;
    private Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponenteUI();
    }

    private void inicializarComponenteUI() {
        txtNombre = (EditText) findViewById(R.id.cmpNombre);
        txtTelefono = (EditText) findViewById(R.id.cmpTelefono);
        txtDireccion = (EditText) findViewById(R.id.cmpDireccion);
        txtEmail = (EditText) findViewById(R.id.cmpEmail);

        txtNombre.addTextChangedListener(new TextChangedListener(){
            @Override
            public void onTextChanged(CharSequence seq, int start, int before, int count) {
                btnAgregar = (Button) findViewById(R.id.btnAgregar);
                btnAgregar.setEnabled(!seq.toString().trim().isEmpty());
            }

            );
    }


}

    public void onClick(View view) {
        String msg = String.format("%s ha sido agregado a la lista", txtNombre.getText());
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        btnAgregar.setEnabled(false);
        limpiarCampo();
    }

    private void limpiarCampo() {
        txtNombre.getText().clear();
        txtEmail.getText().clear();
        txtDireccion.getText().clear();
        txtTelefono.getText().clear();
        txtNombre.requestFocus();

    }
}
