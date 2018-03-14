package com.example.ramonsl.shwoviews;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edToast = findViewById(R.id.edToast);
        final Button btnToas = findViewById(R.id.btnToast);













        addListenerOnRatingBar();
       btnToas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edToast.getText().length()==0 ){
                    Toast.makeText(getApplicationContext(), "Digita algo!", Toast.LENGTH_LONG).show();
                }


                Context contexto = getApplicationContext();
                String texto = edToast.getText().toString();
                int duracao = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(contexto, texto,duracao);
                //toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                toast.show();




            }
        });



        final EditText edAlert = findViewById(R.id.edAlert);
        final Button btnAlert = findViewById(R.id.btnAlert);

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerta(edAlert);
            }
        });

        seek(); //funcao seekbar



        final Button btnAviso= findViewById(R.id.btnAviso);
        btnAviso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton r;
                radio();
            }
        });


    }

    protected void alerta(EditText edAlert){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);//Cria o gerador do AlertDialog
        builder.setTitle("Isso é Um Alerta");//define o titulo
        builder.setMessage(edAlert.getText().toString());//define a mensagem
        //define um botão como positivo

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this, "Você clicou no botão Ok", Toast.LENGTH_SHORT).show();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this, "Você clicou no botão Cancelar", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create();//cria o AlertDialog
        builder.show();//Exibe
    }



    protected void seek(){
        SeekBar seekbr;
        final TextView mostraSeek;
        seekbr =(SeekBar)findViewById(R.id.seek);
        mostraSeek= findViewById(R.id.mostraSeek);
        // perform seek bar change listener event used for getting the progress value
        seekbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            Integer valor = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valor = progress;
                mostraSeek.setText(valor.toString());//mostra no arrasto
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
          ///      mostraSeek.setText(valor.toString());
                Toast.makeText(MainActivity.this, valor.toString(), Toast.LENGTH_SHORT).show(); //no inicio

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                mostraSeek.setText(valor.toString()); //ao fim
                Toast.makeText(MainActivity.this, "FIM", Toast.LENGTH_SHORT).show(); //no inicio

            }
        });

    }


    protected void radio(){

        RadioButton sim= findViewById(R.id.radio_sim);
        RadioButton nao= findViewById(R.id.radio_nao);
          if (sim.isChecked())
                Toast.makeText(MainActivity.this, "Glenn jamais morre!", Toast.LENGTH_SHORT).show(); //no inicio
          if (nao.isChecked())
                Toast.makeText(MainActivity.this, "Aguarde o proximo episodio!", Toast.LENGTH_SHORT).show(); //no inicio

            if(!sim.isChecked() && !nao.isChecked()){
                Toast.makeText(MainActivity.this, "Decide ai!!!", Toast.LENGTH_SHORT).show(); //no inicio

            }

    }
      public void addListenerOnRatingBar() {

	RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);
	final TextView mostraStar = (TextView) findViewById(R.id.mostraStar);

	//se o valor mudar...altera  valor
	ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
		public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromUser) {

			mostraStar.setText(String.valueOf(rating));

		}
	});
  }






}
