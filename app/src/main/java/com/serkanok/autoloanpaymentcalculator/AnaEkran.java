package com.serkanok.autoloanpaymentcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class AnaEkran extends AppCompatActivity {

    int krediTutari;
    double faizOrani;
    int vade;
    TextView aylikOdemeOutput;
    TextView odenenFaizOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ana_ekran);

        krediTutari = 0;
        faizOrani = 0;
        vade = 0;
        EditText krediTutariGirdi = findViewById(R.id.kredi_tutari_input);
        EditText faizOraniGirdi = findViewById(R.id.faiz_orani_input);
        EditText vadeGirdi = findViewById(R.id.vade_input);
        aylikOdemeOutput = findViewById(R.id.aylik_odeme_output);
        odenenFaizOutput = findViewById(R.id.odenen_faiz_output);
        krediTutariGirdi.addTextChangedListener(krediTutariGirdiIzleyici);
        faizOraniGirdi.addTextChangedListener(faizOraniGirdiIzleyici);
        vadeGirdi.addTextChangedListener(vadeGirdiIzleyici);
    }

    private void sonucGoster() {
        double a = Math.pow((1 + faizOrani), vade);
        aylikOdemeOutput.setText(String.format("%.1f", (krediTutari * (faizOrani * a) / (a - 1))));
        odenenFaizOutput.setText(String.format("%.1f", (((krediTutari * (faizOrani * a) / (a - 1)) * vade) - krediTutari)));
    }

    private TextWatcher krediTutariGirdiIzleyici = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                krediTutari = Integer.parseInt(s.toString());
                sonucGoster();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher faizOraniGirdiIzleyici = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                faizOrani = Double.parseDouble(s.toString());
                sonucGoster();
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher vadeGirdiIzleyici = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                vade = Integer.parseInt(s.toString());
                sonucGoster();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
