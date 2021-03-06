package br.com.fiap.exemplobancodedadossqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

      private MeuBanco db;
      private ListView lstClientes;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            db = new MeuBanco(this);
      }


      @Override
      protected void onStart() {
            super.onStart();

            lstClientes = (ListView) findViewById(R.id.lstClientes);

            ArrayAdapter<Cliente> adapter =
                    new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, db.listarTodos());

            lstClientes.setAdapter(adapter);
      }


      public void novoCadastro(View view) {
            Intent it = new Intent(this, CadastroActivity.class);
            startActivity(it);
      }
}
