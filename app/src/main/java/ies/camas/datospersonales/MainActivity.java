package ies.camas.datospersonales;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText txtNombre,txtApellidos,txtEmail,txtTelefono;
    ImageButton imgBAbajo,imgBArriba;
    Switch swtLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefono = findViewById(R.id.txtTelefono);

        imgBAbajo = findViewById(R.id.imgBAbajo);
        imgBArriba = findViewById(R.id.imgBArriba);

        swtLog = findViewById(R.id.swtLog);

        //Un array para poner los EditText juntos y poder mover el foco
        EditText[] textos = {txtNombre,txtApellidos,txtEmail,txtTelefono};

        imgBAbajo.setOnClickListener(view -> bajar(textos));
        imgBArriba.setOnClickListener(view -> subir(textos));


    }
    private void bajar(EditText[] textos){
        View dondeEstaFoco = getCurrentFocus();
        int indice = -1;
        if(dondeEstaFoco != null && dondeEstaFoco instanceof EditText){
            for (int i = 0; i < textos.length; i++) {
                if(textos[i].getId() == dondeEstaFoco.getId()){
                    indice = i;
                    break;
                }
            }
        }
        if(indice < textos.length -1){
            textos[indice + 1].requestFocus();
        }
    }

    private void subir(EditText[] textos){
        View dondeEstaFoco = getCurrentFocus();
        int indice = -1;
        if(dondeEstaFoco != null && dondeEstaFoco instanceof  EditText){
            for (int i = 0; i <textos.length ; i++) {
                if(textos[i].getId() == dondeEstaFoco.getId()){
                    indice = i;
                    break;
                }
            }
        }
        if(indice > 0){
            textos[indice -1].requestFocus();
        }
    }


}