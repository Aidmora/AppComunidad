package com.example.appcomunidad.userInterface.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.appcomunidad.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MagenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MagenFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Animation
            rotateOpen,
            rotateClose,
            fromBottom,
            toBottom;
    private FloatingActionButton  MagenBoton, googleMapsBoton;
    private boolean botonesVisibles = false;

    public MagenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MagenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MagenFragment newInstance(String param1, String param2) {
        MagenFragment fragment = new MagenFragment();
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
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tools=inflater.inflate(R.layout.fragment_magen, container, false);
        MagenBoton=tools.findViewById(R.id.magen_FButtonVentanPrincipal);
        googleMapsBoton=tools.findViewById(R.id.googleMaps_FButtonVentanaPrincipal);
        rotateOpen = AnimationUtils.loadAnimation(requireContext(), R.anim.rotacion_abrir_boton);
        rotateClose= AnimationUtils.loadAnimation(requireContext(),R.anim.rotacion_cerrar_boton);
        fromBottom=AnimationUtils.loadAnimation(requireContext(),R.anim.from_bottom_anim);
        toBottom=AnimationUtils.loadAnimation(requireContext(),R.anim.to_bottom_anim);
        MagenBoton.setOnClickListener(this::mostrarFloatingButtons);
        return tools;
    }
    public void mostrarFloatingButtons(View view){
        mostrarOcultarBotones();
        animacionBontones();
    }
    public void mostrarOcultarBotones() {
        if (botonesVisibles) {
            googleMapsBoton.hide();
            botonesVisibles = false;
        } else {
            googleMapsBoton.show();
            botonesVisibles = true;
        }
    }

    public void animacionBontones(){
        if(!botonesVisibles){
            MagenBoton.startAnimation(rotateClose);
            googleMapsBoton.startAnimation(toBottom);

        }else{
            MagenBoton.startAnimation(rotateOpen);
            googleMapsBoton.startAnimation(fromBottom);

        }
    }
}