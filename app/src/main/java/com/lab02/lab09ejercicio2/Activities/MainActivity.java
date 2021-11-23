package com.lab02.lab09ejercicio2.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.lab02.lab09ejercicio2.Fragments.DataFragment;
import com.lab02.lab09ejercicio2.Fragments.DetailsFragment;
import com.lab02.lab09ejercicio2.R;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void enviarData(String mensaje) {
        // Llamar al método renderizarTexto del Fragment Details,
        // pasándole el texto que recibimos por parámetro en este mismo método.

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(mensaje);
    }
}