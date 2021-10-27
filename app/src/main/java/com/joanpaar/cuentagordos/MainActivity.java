package com.joanpaar.cuentagordos;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_suma;

    private TextView text_respuesta;

    private EditText edit_numero_uno;
    private EditText edit_numero_dos;
    int aux, full, medias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_respuesta = findViewById(R.id.respuesta);

        edit_numero_uno = findViewById(R.id.numeroFull);
        edit_numero_dos = findViewById(R.id.numeroMedias);

        btn_suma = findViewById(R.id.button_suma);
        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText(cuantos2x1(Integer.parseInt(edit_numero_uno.getText().toString()), Integer.parseInt(edit_numero_dos.getText().toString())) + "");
            }
        });

    }

    public String cuantos2x1(int a, int b) {
        String respuesta = "Son " + ((a * 2 + b) / 4) + " 2x1";
        int i = (a * 2 + b);
        if (i % 4 != 0) {
            this.aux = i;
            this.medias = 0;
            this.full = 0;
            while (true) {
                int i2 = this.aux;
                if (i2 % 4 == 0) {
                    break;
                }
                this.aux = i2 + 1;
                this.medias++;
            }
            this.full = this.medias / 2;
            respuesta = "Falta: " + System.getProperty("line.separator")
                    + "·" + this.full + " full y " + (this.medias - (this.full * 2)) + " mitad." + System.getProperty("line.separator")
                    + "·" + this.medias + " mitad" + System.getProperty("line.separator");
            int i3 = this.medias;
            if (i3 == 1) {
                int i4 = i3 + 2;
                this.medias = i4;
                this.full = i4 / 2;
            } else if (i3 == 3) {
                this.medias = i3 - 2;
                this.full = 0;
            }
            respuesta = respuesta + "Echar:" + System.getProperty("line.separator")
                    + "·" + this.full + " full y " + (this.medias - (this.full * 2)) + " mitad" + System.getProperty("line.separator")
                    + "·" + this.medias + " mitad";
            return respuesta;
        }
        return respuesta;
    }

}