package com.example.appcomunidad.userInterface.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appcomunidad.BusinessLogic.entities.UsuarioComunidad;
import com.example.appcomunidad.BusinessLogic.managers.UsuarioComunidadBL;
import com.example.appcomunidad.BusinessLogic.utilities.AdaptadorUsuarioComunidad;
import com.example.appcomunidad.R;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UsuarioComunidadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsuarioComunidadFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView usuarioComunidadRC;
    List<UsuarioComunidad> listaUsuarioComunidad= new ArrayList<>();;

    public UsuarioComunidadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UsuarioComunidadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UsuarioComunidadFragment newInstance(String param1, String param2) {
        UsuarioComunidadFragment fragment = new UsuarioComunidadFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        try {
            Log.i("VerificarCuentaUsuario","Esta entrando a sacar los registros activos");
           listaUsuarioComunidad=new UsuarioComunidadBL(getContext()).obtenerRegistrosActivos();
            Log.i("VerificarCuentaUsuario","obtuvo los  registros activos");
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista= inflater.inflate(R.layout.fragment_usuario_comunidad, container, false);
        usuarioComunidadRC= vista.findViewById(R.id.recycler_UsuarioCom);
        usuarioComunidadRC.setLayoutManager(new LinearLayoutManager(getContext()));
        AdaptadorUsuarioComunidad adaptadorUsuarioComunidad= new AdaptadorUsuarioComunidad(listaUsuarioComunidad,getContext());
        usuarioComunidadRC.setAdapter(adaptadorUsuarioComunidad);
        return vista;
    }
}