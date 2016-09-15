package br.com.heiderlopes.starwarsapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.heiderlopes.starwarsapp.model.Character;
import br.com.heiderlopes.starwarsapp.network.CharacterAPI;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PesquisaActivity extends AppCompatActivity {

    private EditText etIdPersonagem;
    private TextView tvNome;
    private TextView tvAltura;
    private TextView tvPeso;

    private Character personagem;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        etIdPersonagem = (EditText)findViewById(R.id.etIdPersonagem);
        tvNome = (TextView) findViewById(R.id.tvNome);
        tvAltura = (TextView)findViewById(R.id.tvAltura);
        tvPeso = (TextView)findViewById(R.id.tvPeso);
    }

    public void pesquisar(View v) {

        exibirProgress();

        //URL base do servico
        final RestAdapter restadapter = new RestAdapter.Builder()
                .setEndpoint("http://swapi.co/api")
                .build();

        CharacterAPI api = restadapter.create(CharacterAPI.class);

        //Consumindo a API
        api.getCharacter(Integer.parseInt(etIdPersonagem.getText().toString()),
                new Callback<Character>() {
            @Override
            public void success(Character character, Response response) {
                personagem = character;
                tvNome.setText(personagem.getName());
                tvAltura.setText(personagem.getHeight());
                tvPeso.setText(personagem.getWeight());
                fecharProgress();
            }

            @Override
            public void failure(RetrofitError error) {
                //Exibe mensagem de erro caso ocorra
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void exibirProgress() {
        progress = new ProgressDialog(this);
        progress.setMessage("Pesquisando...");
        progress.setIndeterminate(true);
        progress.show();
    }

    private void fecharProgress() {
        if(progress != null) {
            if(progress.isShowing()) {
                progress.dismiss();
            }
        }

    }
}
