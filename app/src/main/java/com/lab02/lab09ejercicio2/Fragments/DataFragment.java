package com.lab02.lab09ejercicio2.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lab02.lab09ejercicio2.R;

public class DataFragment extends Fragment {

    private EditText edt_data;
    private Button btn_enviar;

    private DataListener callback;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            callback = (DataListener) context;
        } catch(Exception e) {
            throw new ClassCastException(context.toString() + " se debe implementar DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_data, container, false);

        // Lógica para capturar los elementos de la UI
        edt_data = (EditText) view.findViewById(R.id.edt_data);
        btn_enviar = (Button) view.findViewById(R.id.btn_enviar);



        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto_origen = edt_data.getText().toString();
                callback.enviarData(texto_origen);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public interface DataListener {
        void enviarData(String mensaje);
    }
}