package br.com.fiap.tdsa_revisaonac;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

      EditText edtUsuario;
      EditText edtSenha;
      CheckBox chkSalvar;

      SharedPreferences sp;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            sp = getPreferences(MODE_PRIVATE);

            edtUsuario = (EditText) findViewById(R.id.edtUsuario);
            edtSenha = (EditText) findViewById(R.id.edtSenha);
            chkSalvar = (CheckBox) findViewById(R.id.chkSalvar);


            edtUsuario.setText( sp.getString("usuario", "") );
            edtSenha.setText( sp.getString("senha", "") );
            chkSalvar.setChecked( sp.getBoolean("salvar", false) );
      }

      public void login(View view) {

            String usuario = edtUsuario.getText().toString();
            String senha = edtSenha.getText().toString();

            if ( usuario.toUpperCase().equals("FIAP") && senha.equals("123456") ) {

                  SharedPreferences.Editor e = sp.edit();

                  if (chkSalvar.isChecked()) {
                        e.putString("usuario", usuario);
                        e.putString("senha", senha);
                        e.putBoolean("salvar", true);
                  } else {
                        e.remove("usuario");
                        e.remove("senha");
                        e.remove("salvar");
                  }

                  e.commit();

                  Intent it  = new Intent(this, PreferenciasActivity.class);
                  startActivity(it);

                  return;
            }

            Toast.makeText(this, "Usuário e senha inválidos", Toast.LENGTH_SHORT).show();

      }
}
