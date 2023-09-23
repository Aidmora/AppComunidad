package com.example.appcomunidad.userInterface.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.appcomunidad.BusinessLogic.entities.Usuario;
import com.example.appcomunidad.BusinessLogic.entities.UsuarioRol;
import com.example.appcomunidad.BusinessLogic.managers.RegistroSesionBL;
import com.example.appcomunidad.BusinessLogic.managers.UsuarioBL;
import com.example.appcomunidad.BusinessLogic.managers.UsuarioRolBL;
import com.example.appcomunidad.R;
import com.example.appcomunidad.framework.AppException;

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
        try {
            establecerDatosPerfil();
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
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
}