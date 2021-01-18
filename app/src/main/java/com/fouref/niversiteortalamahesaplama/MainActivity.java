package com.fouref.niversiteortalamahesaplama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button b1;
    Spinner sp1;
    Spinner sp2;
    double tr[]=new double[11];

    EditText H[]=new EditText[11];

    TextView tv;
    EditText K[]=new EditText[11];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sp1=(Spinner)findViewById(R.id.spinner);
        sp2=(Spinner)findViewById(R.id.spinner2);
        b1=(Button)findViewById(R.id.Hesapla);
        H[0] = (EditText) findViewById(R.id.h1);
        H[1] = (EditText) findViewById(R.id.h2);
        H[2] = (EditText) findViewById(R.id.h3);
        H[3] = (EditText) findViewById(R.id.h4);
        H[4] = (EditText) findViewById(R.id.h5);
        H[5] = (EditText) findViewById(R.id.h6);
        H[6] = (EditText) findViewById(R.id.h7);
        H[7] = (EditText) findViewById(R.id.h8);
        H[8] = (EditText) findViewById(R.id.h9);
        H[9] = (EditText) findViewById(R.id.h10);
        H[10] = (EditText) findViewById(R.id.h11);
        tv=(TextView)findViewById(R.id.textView4);
        K[0]= (EditText) findViewById(R.id.k1);
        K[1]= (EditText) findViewById(R.id.k2);
        K[2] = (EditText) findViewById(R.id.k3);
        K[3] = (EditText) findViewById(R.id.k4);
        K[4]= (EditText) findViewById(R.id.k5);
        K[5]= (EditText) findViewById(R.id.k6);
        K[6] = (EditText) findViewById(R.id.k7);
        K[7] = (EditText) findViewById(R.id.k8);
        K[8] = (EditText) findViewById(R.id.k9);
        K[9] = (EditText) findViewById(R.id.k10);
        K[10] = (EditText) findViewById(R.id.k11);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ders_sayisi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.harf_sistemi, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp2.getSelectedItem().toString().equals("AA Sistemi")){
                    for(int i=0;i<sp1.getSelectedItemPosition()+3;i++) {
                        tr[i] = cevir(String.valueOf(H[i].getText()));

                    }
                }
                if(sp2.getSelectedItem().toString().equals("A+ A- Sistemi")){
                    for(int i=0;i<sp1.getSelectedItemPosition()+3;i++) {
                        tr[i] = cevir2(String.valueOf(H[i].getText()));

                    }
                }
                if(sp2.getSelectedItem().toString().equals("A+ A Sistemi")){
                    for(int i=0;i<sp1.getSelectedItemPosition()+3;i++) {
                        tr[i] = cevir3(String.valueOf(H[i].getText()));

                    }
                }
                sonuc();

            }
        });

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                switch(position){

                    case 0:
                        K[0].setVisibility(View.VISIBLE);
                        H[0].setVisibility(View.VISIBLE);
                        K[1].setVisibility(View.VISIBLE);
                        H[1].setVisibility(View.VISIBLE);
                        K[2].setVisibility(View.VISIBLE);
                        H[2].setVisibility(View.VISIBLE);
                        K[3].setVisibility(View.INVISIBLE);
                        H[3].setVisibility(View.INVISIBLE);
                        K[4].setVisibility(View.INVISIBLE);
                        H[4].setVisibility(View.INVISIBLE);
                        K[5].setVisibility(View.INVISIBLE);
                        H[5].setVisibility(View.INVISIBLE);
                        K[6].setVisibility(View.INVISIBLE);
                        H[6].setVisibility(View.INVISIBLE);
                        K[7].setVisibility(View.INVISIBLE);
                        H[7].setVisibility(View.INVISIBLE);
                        K[8].setVisibility(View.INVISIBLE);
                        H[8].setVisibility(View.INVISIBLE);
                        K[9].setVisibility(View.INVISIBLE);
                        H[9].setVisibility(View.INVISIBLE);
                        K[10].setVisibility(View.INVISIBLE);
                        H[10].setVisibility(View.INVISIBLE);
                        break;

                    case 1:
                        K[0].setVisibility(View.VISIBLE);
                        H[0].setVisibility(View.VISIBLE);
                        K[1].setVisibility(View.VISIBLE);
                        H[1].setVisibility(View.VISIBLE);
                        K[2].setVisibility(View.VISIBLE);
                        H[2].setVisibility(View.VISIBLE);
                        K[3].setVisibility(View.VISIBLE);
                        H[3].setVisibility(View.VISIBLE);
                        K[4].setVisibility(View.INVISIBLE);
                        H[4].setVisibility(View.INVISIBLE);
                        K[5].setVisibility(View.INVISIBLE);
                        H[5].setVisibility(View.INVISIBLE);
                        K[6].setVisibility(View.INVISIBLE);
                        H[6].setVisibility(View.INVISIBLE);
                        K[7].setVisibility(View.INVISIBLE);
                        H[7].setVisibility(View.INVISIBLE);
                        K[8].setVisibility(View.INVISIBLE);
                        H[8].setVisibility(View.INVISIBLE);
                        K[9].setVisibility(View.INVISIBLE);
                        H[9].setVisibility(View.INVISIBLE);
                        K[10].setVisibility(View.INVISIBLE);
                        H[10].setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        K[0].setVisibility(View.VISIBLE);
                        H[0].setVisibility(View.VISIBLE);
                        K[1].setVisibility(View.VISIBLE);
                        H[1].setVisibility(View.VISIBLE);
                        K[2].setVisibility(View.VISIBLE);
                        H[2].setVisibility(View.VISIBLE);
                        K[3].setVisibility(View.VISIBLE);
                        H[3].setVisibility(View.VISIBLE);
                        K[4].setVisibility(View.VISIBLE);
                        H[4].setVisibility(View.VISIBLE);
                        K[5].setVisibility(View.INVISIBLE);
                        H[5].setVisibility(View.INVISIBLE);
                        K[6].setVisibility(View.INVISIBLE);
                        H[6].setVisibility(View.INVISIBLE);
                        K[7].setVisibility(View.INVISIBLE);
                        H[7].setVisibility(View.INVISIBLE);
                        K[8].setVisibility(View.INVISIBLE);
                        H[8].setVisibility(View.INVISIBLE);
                        K[9].setVisibility(View.INVISIBLE);
                        H[9].setVisibility(View.INVISIBLE);
                        K[10].setVisibility(View.INVISIBLE);
                        H[10].setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        K[0].setVisibility(View.VISIBLE);
                        H[0].setVisibility(View.VISIBLE);
                        K[1].setVisibility(View.VISIBLE);
                        H[1].setVisibility(View.VISIBLE);
                        K[2].setVisibility(View.VISIBLE);
                        H[2].setVisibility(View.VISIBLE);
                        K[3].setVisibility(View.VISIBLE);
                        H[3].setVisibility(View.VISIBLE);
                        K[4].setVisibility(View.VISIBLE);
                        H[4].setVisibility(View.VISIBLE);
                        K[5].setVisibility(View.VISIBLE);
                        H[5].setVisibility(View.VISIBLE);
                        K[6].setVisibility(View.INVISIBLE);
                        H[6].setVisibility(View.INVISIBLE);
                        K[7].setVisibility(View.INVISIBLE);
                        H[7].setVisibility(View.INVISIBLE);
                        K[8].setVisibility(View.INVISIBLE);
                        H[8].setVisibility(View.INVISIBLE);
                        K[9].setVisibility(View.INVISIBLE);
                        H[9].setVisibility(View.INVISIBLE);
                        K[10].setVisibility(View.INVISIBLE);
                        H[10].setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        K[0].setVisibility(View.VISIBLE);
                        H[0].setVisibility(View.VISIBLE);
                        K[1].setVisibility(View.VISIBLE);
                        H[1].setVisibility(View.VISIBLE);
                        K[2].setVisibility(View.VISIBLE);
                        H[2].setVisibility(View.VISIBLE);
                        K[3].setVisibility(View.VISIBLE);
                        H[3].setVisibility(View.VISIBLE);
                        K[4].setVisibility(View.VISIBLE);
                        H[4].setVisibility(View.VISIBLE);
                        K[5].setVisibility(View.VISIBLE);
                        H[5].setVisibility(View.VISIBLE);
                        K[6].setVisibility(View.VISIBLE);
                        H[6].setVisibility(View.VISIBLE);
                        K[7].setVisibility(View.INVISIBLE);
                        H[7].setVisibility(View.INVISIBLE);
                        K[8].setVisibility(View.INVISIBLE);
                        H[8].setVisibility(View.INVISIBLE);
                        K[9].setVisibility(View.INVISIBLE);
                        H[9].setVisibility(View.INVISIBLE);
                        K[10].setVisibility(View.INVISIBLE);
                        H[10].setVisibility(View.INVISIBLE);
                        break;
                    case 5:
                        K[0].setVisibility(View.VISIBLE);
                        H[0].setVisibility(View.VISIBLE);
                        K[1].setVisibility(View.VISIBLE);
                        H[1].setVisibility(View.VISIBLE);
                        K[2].setVisibility(View.VISIBLE);
                        H[2].setVisibility(View.VISIBLE);
                        K[3].setVisibility(View.VISIBLE);
                        H[3].setVisibility(View.VISIBLE);
                        K[4].setVisibility(View.VISIBLE);
                        H[4].setVisibility(View.VISIBLE);
                        K[5].setVisibility(View.VISIBLE);
                        H[5].setVisibility(View.VISIBLE);
                        K[6].setVisibility(View.VISIBLE);
                        H[6].setVisibility(View.VISIBLE);
                        K[7].setVisibility(View.VISIBLE);
                        H[7].setVisibility(View.VISIBLE);
                        K[8].setVisibility(View.INVISIBLE);
                        H[8].setVisibility(View.INVISIBLE);
                        K[9].setVisibility(View.INVISIBLE);
                        H[9].setVisibility(View.INVISIBLE);
                        K[10].setVisibility(View.INVISIBLE);
                        H[10].setVisibility(View.INVISIBLE);
                        break;
                    case 6:
                        K[0].setVisibility(View.VISIBLE);
                        H[0].setVisibility(View.VISIBLE);
                        K[1].setVisibility(View.VISIBLE);
                        H[1].setVisibility(View.VISIBLE);
                        K[2].setVisibility(View.VISIBLE);
                        H[2].setVisibility(View.VISIBLE);
                        K[3].setVisibility(View.VISIBLE);
                        H[3].setVisibility(View.VISIBLE);
                        K[4].setVisibility(View.VISIBLE);
                        H[4].setVisibility(View.VISIBLE);
                        K[5].setVisibility(View.VISIBLE);
                        H[5].setVisibility(View.VISIBLE);
                        K[6].setVisibility(View.VISIBLE);
                        H[6].setVisibility(View.VISIBLE);
                        K[7].setVisibility(View.VISIBLE);
                        H[7].setVisibility(View.VISIBLE);
                        K[8].setVisibility(View.VISIBLE);
                        H[8].setVisibility(View.VISIBLE);
                        K[9].setVisibility(View.INVISIBLE);
                        H[9].setVisibility(View.INVISIBLE);
                        K[10].setVisibility(View.INVISIBLE);
                        H[10].setVisibility(View.INVISIBLE);
                        break;
                    case 7:
                        K[0].setVisibility(View.VISIBLE);
                        H[0].setVisibility(View.VISIBLE);
                        K[1].setVisibility(View.VISIBLE);
                        H[1].setVisibility(View.VISIBLE);
                        K[2].setVisibility(View.VISIBLE);
                        H[2].setVisibility(View.VISIBLE);
                        K[3].setVisibility(View.VISIBLE);
                        H[3].setVisibility(View.VISIBLE);
                        K[4].setVisibility(View.VISIBLE);
                        H[4].setVisibility(View.VISIBLE);
                        K[5].setVisibility(View.VISIBLE);
                        H[5].setVisibility(View.VISIBLE);
                        K[6].setVisibility(View.VISIBLE);
                        H[6].setVisibility(View.VISIBLE);
                        K[7].setVisibility(View.VISIBLE);
                        H[7].setVisibility(View.VISIBLE);
                        K[8].setVisibility(View.VISIBLE);
                        H[8].setVisibility(View.VISIBLE);
                        K[9].setVisibility(View.VISIBLE);
                        H[9].setVisibility(View.VISIBLE);
                        K[10].setVisibility(View.INVISIBLE);
                        H[10].setVisibility(View.INVISIBLE);
                        break;
                    case 8:
                        K[0].setVisibility(View.VISIBLE);
                        H[0].setVisibility(View.VISIBLE);
                        K[1].setVisibility(View.VISIBLE);
                        H[1].setVisibility(View.VISIBLE);
                        K[2].setVisibility(View.VISIBLE);
                        H[2].setVisibility(View.VISIBLE);
                        K[3].setVisibility(View.VISIBLE);
                        H[3].setVisibility(View.VISIBLE);
                        K[4].setVisibility(View.VISIBLE);
                        H[4].setVisibility(View.VISIBLE);
                        K[5].setVisibility(View.VISIBLE);
                        H[5].setVisibility(View.VISIBLE);
                        K[6].setVisibility(View.VISIBLE);
                        H[6].setVisibility(View.VISIBLE);
                        K[7].setVisibility(View.VISIBLE);
                        H[7].setVisibility(View.VISIBLE);
                        K[8].setVisibility(View.VISIBLE);
                        H[8].setVisibility(View.VISIBLE);
                        K[9].setVisibility(View.VISIBLE);
                        H[9].setVisibility(View.VISIBLE);
                        K[10].setVisibility(View.VISIBLE);
                        H[10].setVisibility(View.VISIBLE);
                        break;

                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    double cevir(String harf){
        if(harf.equals("AA")||harf.equals("Aa")||harf.equals("aA")||harf.equals("aa")){
            return 4.0;
        }
        if(harf.equals("BB")||harf.equals("Bb")||harf.equals("bB")||harf.equals("bb")){
            return 3.0;
        }
        if(harf.equals("Ba")||harf.equals("BA")||harf.equals("ba")||harf.equals("bA")||harf.equals("AB")||harf.equals("ab")||harf.equals("aB")||harf.equals("Ab")){
            return 3.5;
        }
        if(harf.equals("BC")||harf.equals("Bc")||harf.equals("bC")||harf.equals("bc")||harf.equals("CB")||harf.equals("Cb")||harf.equals("cB")||harf.equals("cb")){
            return 2.5;
        }
        if(harf.equals("CC")||harf.equals("Cc")||harf.equals("cC")||harf.equals("cc")){
            return 2.0;
        }
        if(harf.equals("CD")||harf.equals("Cd")||harf.equals("cD")||harf.equals("cd")||harf.equals("DC")||harf.equals("Dc")||harf.equals("dC")||harf.equals("dc")){
            return 1.5;
        }

        if(harf.equals("DD")||harf.equals("Dd")||harf.equals("dD")||harf.equals("dd")){
            return 1.0;
        }
        if(harf.equals("FF")||harf.equals("Ff")||harf.equals("fF")||harf.equals("ff")){
            return 0.0;
        }
        return 0.0;
    }

    double cevir2(String harf){ //A+ A-
        if(harf.equals("A+")||harf.equals("a+")||harf.equals("+a")||harf.equals("+A")){
            return 4.0;
        }
        if(harf.equals("A-")||harf.equals("a-")||harf.equals("-a")||harf.equals("-A")){
            return 3.7;
        }
        if(harf.equals("B+")||harf.equals("b+")||harf.equals("+B")||harf.equals("4b")){
            return 3.3;
        }
        if(harf.equals("B")||harf.equals("b")){
            return 3.0;
        }
        if(harf.equals("b-")||harf.equals("-b")||harf.equals("B-")||harf.equals("-B")){
            return 2.7;
        }
        if(harf.equals("C+")||harf.equals("+C")||harf.equals("c+")||harf.equals("+c")){
            return 2.3;
        }

        if(harf.equals("c")||harf.equals("C")){
            return 2.0;
        }
        if(harf.equals("C-")||harf.equals("c-")||harf.equals("-c")||harf.equals("-C")){
            return 1.7;
        }
        if(harf.equals("D+")||harf.equals("+D")||harf.equals("d+")||harf.equals("+d")){
            return 1.3;
        }
        if(harf.equals("D")||harf.equals("d")){
            return 1.0;
        }
        if(harf.equals("F")||harf.equals("f")){
            return 0.0;
        }
        return 0.0;
    }

    double cevir3(String harf){ //A+ A
        if(harf.equals("A+")||harf.equals("a+")||harf.equals("+a")||harf.equals("+A")){
            return 4.0;
        }
        if(harf.equals("A")||harf.equals("a")||harf.equals("a")||harf.equals("A")){
            return 3.75;
        }
        if(harf.equals("B+")||harf.equals("b+")||harf.equals("+B")||harf.equals("4b")){
            return 3.5;
        }
        if(harf.equals("B")||harf.equals("b")){
            return 3.0;
        }
        if(harf.equals("c")||harf.equals("C")){
            return 2.0;
        }
        if(harf.equals("C+")||harf.equals("+C")||harf.equals("c+")||harf.equals("+c")){
            return 2.5;
        }

        if(harf.equals("D+")||harf.equals("+D")||harf.equals("d+")||harf.equals("+d")){
            return 1.5;
        }
        if(harf.equals("D-")||harf.equals("d-")||harf.equals("-d")||harf.equals("-D")){
            return 1.0;
        }
        if(harf.equals("F")||harf.equals("f")){
            return 0.0;
        }

        return 0.0;
    }

    double sonuc(){


        double toplam=0;
        double ktoplam=0;
        String s;
        int i=0;
        for(i=0;i<sp1.getSelectedItemPosition()+3;i++){

            s= String.valueOf(K[i].getText());
            toplam+=(Double.parseDouble(s)*tr[i]);
            ktoplam+=Double.parseDouble(s);
            System.out.println(toplam);
        }
        toplam=toplam/ktoplam;
        String end=String.valueOf(toplam);
        tv.setText(end);
        return toplam;

    }



}
