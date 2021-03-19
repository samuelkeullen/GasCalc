package com.sklinfotechnologies.gascalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.*;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    Button button, calc;
    TextView tv1, tv2, tv3;

    /*
    Como calcular combustível por quilômetro rodado?
Valor do litro de combustível / quilômetros rodados = valor do reembolso por quilômetro.
R$ 4,50 / 25 KM = R$ 0, 18 por quilômetro rodado.
R$ 3,50 / 10 KM = R$ 0,35 por quilômetro rodado.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-3934514205212604/1090539400");

        /*
        ADS
         */
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Toast.makeText(MainActivity.this, "carregooooo", Toast.LENGTH_SHORT);
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        button = (Button) findViewById(R.id.config);
        //button.setOnClickListener(new View.OnClickListener() {

       //     @Override
       //     public void onClick(View v) {
                //Creating the instance of PopupMenu
      //          Toast.makeText(MainActivity.this, "Escolha o tipo de combusítvel.", Toast.LENGTH_SHORT);
                //PopupMenu popup = new PopupMenu(MainActivity.this, button);
                //Inflating the Popup using xml file
                //popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                //popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                //    public boolean onMenuItemClick(MenuItem item) {
                //        Toast.makeText(MainActivity.this,"Você escolheu : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                //        return true;
                //    }
                //});

               // popup.show();//showing popup menu
            //}
        //});//closing the setOnClickListener method

        tv1 = (TextView) findViewById(R.id.gasolina);//valor da gasolina
        tv2 = (TextView) findViewById(R.id.km);//km rodado
        tv3 = (TextView) findViewById(R.id.h);//valor total
        calc = (Button) findViewById(R.id.calc);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gasosa, kmRodado, valorTotal;
                double novaGasosa, novoKmRodado, calculo;
                gasosa = tv1.getText().toString();
                kmRodado = tv2.getText().toString();

                novaGasosa = Double.parseDouble(gasosa);
                novoKmRodado = Double.parseDouble(kmRodado);

                calculo = novaGasosa / novoKmRodado;

                valorTotal = "" + calculo;

                tv3.setText(valorTotal);
            }
        });
    }
}