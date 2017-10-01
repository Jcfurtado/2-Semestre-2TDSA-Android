package br.com.fiap.exemplobancodedadossqlite;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

      private EditText nome;
      private EditText email;
      private MeuBanco db;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro);

            nome  = (EditText) findViewById(R.id.edtNome);
            email = (EditText) findViewById(R.id.edtEmail);

            db = new MeuBanco(this);
      }


      public void salvar(View view) {
            long dataCadastro = System.currentTimeMillis() / 1000L ;

            Cliente cliente = new Cliente();
            cliente.setNome( nome.getText().toString() );
            cliente.setEmail( email.getText().toString() );
            cliente.setDataCadastro(dataCadastro);

            db.inserir(cliente);

            Toast.makeText(this, R.string.inserido_com_sucesso, Toast.LENGTH_SHORT).show();

            finish();
      }
}
