package com.example.appcomunidad.userInterface.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.appcomunidad.userInterface.Activity.historialActivity;
import com.example.appcomunidad.userInterface.Activity.infoAppActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.appcomunidad.BusinessLogic.entities.Usuario;
import com.example.appcomunidad.BusinessLogic.entities.UsuarioRol;
import com.example.appcomunidad.BusinessLogic.managers.RegistroSesionBL;
import com.example.appcomunidad.BusinessLogic.managers.UsuarioBL;
import com.example.appcomunidad.BusinessLogic.managers.UsuarioRolBL;
import com.example.appcomunidad.R;
import com.example.appcomunidad.framework.AppException;
import com.example.appcomunidad.userInterface.Activity.ActualizarDatosActivity;
import com.example.appcomunidad.userInterface.Activity.IniciarSesionActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Animation
            rotateOpen,
            rotateClose,
            fromBottom,
            toBottom;

    private Button
            editPerfil,
            cerrarSesion;

    private TextView
            nomUsuario,
            nomUsuario2,
            correoUs,

            rolUs,
            celularUs;
    private UsuarioBL usuarioBL;
    private UsuarioRol usuarioRol;
    private RegistroSesionBL registroSesionBL;
    private Usuario usuario;
    private UsuarioRolBL usuarioRolBL;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int idRolUsuario;
    private String rolUsuario;
    private Context contexto;
    private FloatingActionButton  infoBoton, historialBoton, MagenBoton;
    private boolean botonesVisibles = false;
    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tools=inflater.inflate(R.layout.fragment_perfil, container, false);
        nomUsuario2=tools.findViewById(R.id.nombre_usuario2);
        correoUs=tools.findViewById(R.id.correo_usuario);
        celularUs=tools.findViewById(R.id.celular_usuario);
        rolUs=tools.findViewById(R.id.rol_usuario);
        editPerfil = tools.findViewById(R.id.edit_perfil_button);
        cerrarSesion=tools.findViewById(R.id.cerrar_sesion);
        MagenBoton=tools.findViewById(R.id.magen_FButton);
        infoBoton=tools.findViewById(R.id.info_FButton);
        historialBoton=tools.findViewById(R.id.historial_FButton);
        rotateOpen = AnimationUtils.loadAnimation(requireContext(), R.anim.rotacion_abrir_boton);
        rotateClose= AnimationUtils.loadAnimation(requireContext(),R.anim.rotacion_cerrar_boton);
        fromBottom=AnimationUtils.loadAnimation(requireContext(),R.anim.from_bottom_anim);
        toBottom=AnimationUtils.loadAnimation(requireContext(),R.anim.to_bottom_anim);

        try {
            establecerDatosPerfil();
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
        editPerfil.setOnClickListener(this::irEditarPerfil);
        MagenBoton.setOnClickListener(this::mostrarFloatingButtons);
        infoBoton.setOnClickListener(this::irInfoApp);
        historialBoton.setOnClickListener(this::irHisotrial);
        cerrarSesion.setOnClickListener(vista -> {
            try {
                cerrarSesion(vista);
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
        });

        return tools;
    }
    public void establecerDatosPerfil() throws AppException {
        Context context = getActivity();
        usuarioBL = new UsuarioBL(context);
        usuarioRolBL=new UsuarioRolBL(context);
        registroSesionBL = new RegistroSesionBL(context);


        int idUsuarioActivo= registroSesionBL.obtenerIdUsuarioConectado();
        usuario = usuarioBL.obtenerPorId(idUsuarioActivo);
        idRolUsuario= usuario.getIdRol();
        Log.i("establecerDatos","Si esta sacando el id del usuario conectado"+ idUsuarioActivo);
        usuarioRol=usuarioRolBL.obtenerRolUsuario(idRolUsuario);
        rolUsuario= usuarioRol.getNombre();
        nomUsuario2.setText(usuario.getNombre());
        correoUs.setText(usuario.getCorreo());
        celularUs.setText(usuario.getCelular());
        rolUs.setText(rolUsuario);
    }
    public void cerrarSesion(View view ) throws AppException {
        Context contexto = getActivity();
        Log.i("establecerDatos","Esta entrando a RegistroSesionBL");
        registroSesionBL = new RegistroSesionBL(contexto);
        Log.i("establecerDatos","Paso registro Sesion BL ");
        if(registroSesionBL.desconectarUsuario()){
            Log.i("establecerDatos","Entro al If ");
            Intent intent= new Intent(contexto, IniciarSesionActivity.class);
            startActivity(intent);
            requireActivity().finish();
        }
        Log.i("establecerDatos","salio del If ");
    }
    public void irEditarPerfil(View view){
        Intent intent= new Intent(getContext(), ActualizarDatosActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }
    public void mostrarFloatingButtons(View view){
        mostrarOcultarBotones();
        animacionBontones();
    }
    public void mostrarOcultarBotones() {
        if (botonesVisibles) {
            infoBoton.hide();
            historialBoton.hide();
            botonesVisibles = false;
        } else {
            infoBoton.show();
            historialBoton.show();
            botonesVisibles = true;
        }
    }

    public void animacionBontones(){
        if(!botonesVisibles){
            MagenBoton.startAnimation(rotateClose);
            infoBoton.startAnimation(toBottom);
            historialBoton.startAnimation(toBottom);

        }else{
            MagenBoton.startAnimation(rotateOpen);
            infoBoton.startAnimation(fromBottom);
            historialBoton.startAnimation(fromBottom);

        }
    }
    public void irInfoApp(View view){
        Intent intent= new Intent(getContext(), infoAppActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }
    public void irHisotrial(View view){
        Intent intent= new Intent(getContext(), historialActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }

}