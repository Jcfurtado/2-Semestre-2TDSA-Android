package br.com.fiap.tdsa_revisaonac;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PreferenciasActivity extends AppCompatActivity {

      RadioGroup rgCores;
      RadioButton rbVermelho;
      RadioButton rbVerde;
      RadioButton rbAzul;
      SharedPreferences sp;
      LinearLayout llPrincipal;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_preferencias);

            llPrincipal = (LinearLayout) findViewById(R.id.llPrincipal);

            rgCores = (RadioGroup) findViewById(R.id.rgCores);
            rbAzul = (RadioButton) findViewById(R.id.rbAzul);
            rbVerde = (RadioButton) findViewById(R.id.rbVerde);
            rbVermelho = (RadioButton) findViewById(R.id.rbVermelho);

            sp = getPreferences(MODE_PRIVATE);

            int cor = sp.getInt("cor", 0);

            alterarCor( cor );
            marcaCheckboxCor( cor );
      }

      public void salvar(View view) {
            SharedPreferences.Editor e = sp.edit();
            e.putInt("cor", rgCores.getCheckedRadioButtonId());
            e.commit();

            alterarCor( rgCores.getCheckedRadioButtonId() );
      }

      public void alterarCor( int cor ) {
            switch ( cor ) {
                  case R.id.rbVermelho:
                        llPrincipal.setBackgroundColor( Color.RED );
                        break;
                  case R.id.rbVerde:
                        llPrincipal.setBackgroundColor( Color.GREEN );
                        break;
                  case R.id.rbAzul:
                        llPrincipal.setBackgroundColor( Color.BLUE );
                        break;
            }
      }

      public void marcaCheckboxCor( int cor ) {
            switch ( cor ) {
                  case R.id.rbVermelho:
                        rbVermelho.setChecked(true);
                        break;
                  case R.id.rbVerde:
                        rbVerde.setChecked(true);
                        break;
                  case R.id.rbAzul:
                        rbAzul.setChecked(true);
                        break;
            }
      }
}
