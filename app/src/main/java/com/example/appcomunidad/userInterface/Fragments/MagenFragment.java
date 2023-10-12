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
import android.widget.TextView;

import com.example.appcomunidad.BusinessLogic.entities.IngresosAbril;
import com.example.appcomunidad.BusinessLogic.entities.IngresosAgosto;
import com.example.appcomunidad.BusinessLogic.entities.IngresosDiciembre;
import com.example.appcomunidad.BusinessLogic.entities.IngresosEnero;
import com.example.appcomunidad.BusinessLogic.entities.IngresosFebrero;
import com.example.appcomunidad.BusinessLogic.entities.IngresosJulio;
import com.example.appcomunidad.BusinessLogic.entities.IngresosJunio;
import com.example.appcomunidad.BusinessLogic.entities.IngresosMarzo;
import com.example.appcomunidad.BusinessLogic.entities.IngresosMayo;
import com.example.appcomunidad.BusinessLogic.entities.IngresosNoviembre;
import com.example.appcomunidad.BusinessLogic.entities.IngresosOctubre;
import com.example.appcomunidad.BusinessLogic.entities.IngresosSeptiembre;
import com.example.appcomunidad.BusinessLogic.entities.UsuarioComunidad;
import com.example.appcomunidad.BusinessLogic.managers.IngresoAbrilBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoAgostoBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoDiciembreBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoEneroBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoFebreroBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoJulioBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoJunioBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoMarzoBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoMayoBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoNoviembreBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoOctubreBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoSeptiembreBL;
import com.example.appcomunidad.R;
import com.example.appcomunidad.framework.AppException;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

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
    private TextView valorIngresoET,valorIngresoFT,valorIngresoMT,valorIngresoAT,valorIngresoMAT,valorIngresoJT,valorIngresoJUT,valorIngresoAGT,valorIngresoST,valorIngresoOT,valorIngresoNT,valorIngresoDT;
    private Animation
            rotateOpen,
            rotateClose,
            fromBottom,
            toBottom;
    private FloatingActionButton  MagenBoton, googleMapsBoton;
    private boolean botonesVisibles = false;
    private IngresoEneroBL ingresoEneroBL;
    private IngresoFebreroBL ingresoFebreroBL;
    private IngresoMarzoBL ingresoMarzoBL;
    private IngresoAbrilBL ingresoAbrilBL;
    private IngresoMayoBL ingresoMayoBL;
    private IngresoJunioBL ingresoJunioBL;
    private IngresoJulioBL ingresoJulioBL;
    private IngresoAgostoBL ingresoAgostoBL;
    private IngresoSeptiembreBL ingresoSeptiembreBL;
    private IngresoOctubreBL ingresoOctubreBL;
    private IngresoNoviembreBL ingresoNoviembreBL;
    private IngresoDiciembreBL ingresoDiciembreBL;
    private List<IngresosEnero> ingresosEneroList;
    private List<IngresosFebrero> ingresosFebreroList;
    private List<IngresosMarzo>  ingresosMarzoList;
    private List<IngresosAbril> ingresosAbrilList;
    private List<IngresosMayo> ingresosMayoList;
    private List<IngresosJunio> ingresosJunioList;
    private List<IngresosJulio> ingresosJulioList;
    private List<IngresosAgosto> ingresosAgostoList;
    private List<IngresosSeptiembre> ingresosSeptiembreList;
    private List <IngresosOctubre> ingresosOctubreList;
    private List<IngresosNoviembre> ingresosNoviembreList;
    private List<IngresosDiciembre> ingresosDiciembreList;
    private double [] valoresSemanaTotalE,valoresSemanaTotalF,valoresSemanaTotalM,valoresSemanaTotalA,valoresSemanaTotalMA,valoresSemanaTotalJ,valoresSemanaTotalJU,valoresSemanaTotalAG,ValoresSemanaTotalS,valoresSemanaTotalOC,valoresSemanaTotalN,valoresSemanaTotalD;
    private double valorIngresoE,valorIngresoF,valorIngresoM,valorIngresoA,valorIngresoMA,valorIngresoJ,valorIngresoJU,valorIngresoAG,valorIngresoS,valorIngresoOC,valorIngresoN,valorIngresoD;
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
        valorIngresoET= tools.findViewById(R.id.valorIngresoEnero);
        valorIngresoFT=tools.findViewById(R.id.valorIngresoFebrero);
        valorIngresoMT=tools.findViewById(R.id.valorIngresoMarzo);
        valorIngresoAT= tools.findViewById(R.id.valorIngresoAbril);
        valorIngresoMAT=tools.findViewById(R.id.valorIngresoMayo);
        valorIngresoJT=tools.findViewById(R.id.valorIngresoJunio);
        valorIngresoJUT=tools.findViewById(R.id.valorIngresoJulio);
        valorIngresoAGT= tools.findViewById(R.id.valorIngresAgosto);
        valorIngresoST=tools.findViewById(R.id.valorIngresSeptiembre);
        valorIngresoOT= tools.findViewById(R.id.valorIngresOctubre);
        valorIngresoNT=tools.findViewById(R.id.valorIngresoNoviembre);
        valorIngresoDT=tools.findViewById(R.id.valorIngresoDiciembre);
        googleMapsBoton=tools.findViewById(R.id.googleMaps_FButtonVentanaPrincipal);
        rotateOpen = AnimationUtils.loadAnimation(requireContext(), R.anim.rotacion_abrir_boton);
        rotateClose= AnimationUtils.loadAnimation(requireContext(),R.anim.rotacion_cerrar_boton);
        fromBottom=AnimationUtils.loadAnimation(requireContext(),R.anim.from_bottom_anim);
        toBottom=AnimationUtils.loadAnimation(requireContext(),R.anim.to_bottom_anim);
        MagenBoton.setOnClickListener(this::mostrarFloatingButtons);

        inicializarRecursos();
        establecerValoresIngresoEgreso();
        return tools;
    }
    public void inicializarRecursos (){
        ingresoEneroBL= new IngresoEneroBL(getContext());
        ingresoFebreroBL=new IngresoFebreroBL(getContext());
        ingresoMarzoBL= new IngresoMarzoBL(getContext());
        ingresoAbrilBL= new IngresoAbrilBL(getContext());
        ingresoMayoBL= new IngresoMayoBL(getContext());
        ingresoJunioBL=  new IngresoJunioBL(getContext());
        ingresoJulioBL= new IngresoJulioBL(getContext());
        ingresoAgostoBL= new IngresoAgostoBL(getContext()) ;
        ingresoSeptiembreBL= new IngresoSeptiembreBL(getContext());
        ingresoOctubreBL= new IngresoOctubreBL(getContext());
        ingresoNoviembreBL= new IngresoNoviembreBL(getContext() );
        ingresoDiciembreBL= new IngresoDiciembreBL(getContext());
        ingresosEneroList=new ArrayList<>();
        ingresosFebreroList= new ArrayList<>();
        ingresosMarzoList= new ArrayList<>();
        ingresosAbrilList= new ArrayList<>();
        ingresosMayoList= new ArrayList<>();
        ingresosJunioList= new ArrayList<>();
        ingresosJulioList= new ArrayList<>();
        ingresosAgostoList= new ArrayList<>();
        ingresosSeptiembreList = new ArrayList<>();
        ingresosOctubreList= new ArrayList<>();
        ingresosNoviembreList= new ArrayList<>();
        ingresosDiciembreList= new ArrayList<>();
    }
    public void establecerValoresIngresoEgreso(){
        valoresSemanaTotalE= new double[0];
        valoresSemanaTotalF= new double[0];
        valoresSemanaTotalM= new double[0];
        valoresSemanaTotalA= new double[0];
        valoresSemanaTotalMA= new double[0];
        valoresSemanaTotalJ= new double[0];
        valoresSemanaTotalJU= new double[0];
        valoresSemanaTotalAG= new double[0];
        ValoresSemanaTotalS= new double[0];
        valoresSemanaTotalOC= new double[0];
        valoresSemanaTotalN= new double[0];
        valoresSemanaTotalD= new double[0];
        valorIngresoE=0;
        valorIngresoF=0;
        valorIngresoM=0;
        valorIngresoA=0;
        valorIngresoMA=0;
        valorIngresoJ=0;
        valorIngresoJU=0;
        valorIngresoAG=0;
        valorIngresoS=0;
        valorIngresoOC=0;
        valorIngresoN=0;
        valorIngresoD=0;
        try {
            ingresosEneroList= ingresoEneroBL.leerTodosRegistros();
            ingresosFebreroList= ingresoFebreroBL.leerTodosRegistros();
            ingresosMarzoList= ingresoMarzoBL.leerTodosRegistros();
            ingresosAbrilList= ingresoAbrilBL.leerTodosRegistros();
            ingresosMayoList= ingresoMayoBL.leerTodosRegistros();
            ingresosJunioList= ingresoJunioBL.leerTodosRegistros();
            ingresosJulioList= ingresoJulioBL.leerTodosRegistros();
            ingresosAgostoList= ingresoAgostoBL.leerTodosRegistros();
            ingresosSeptiembreList= ingresoSeptiembreBL.leerTodosRegistros();
            ingresosOctubreList= ingresoOctubreBL.leerTodosRegistros();
            ingresosNoviembreList= ingresoNoviembreBL.leerTodosRegistros();
            ingresosDiciembreList= ingresoDiciembreBL.leerTodosRegistros();
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
        if(ingresosEneroList.size()!= 0){
            valoresSemanaTotalE= new double[ingresosEneroList.size()];
            for (int i = 0; i < ingresosEneroList.size(); i++) {
                valoresSemanaTotalE[i]= ingresosEneroList.get(i).getTotalSemana();
            }
            for (int i = 0; i < valoresSemanaTotalE.length; i++) {
                valorIngresoE += valoresSemanaTotalE[i];
            }
            valorIngresoET.setText(valorIngresoE +"");
        }else if(ingresosEneroList.size()==0){
            valorIngresoET.setText(0.0 +"");
        }
        if(ingresosFebreroList.size()!= 0){
            valoresSemanaTotalF= new double[ingresosFebreroList.size()];
            for (int i = 0; i < ingresosFebreroList.size(); i++) {
                valoresSemanaTotalF[i]= ingresosFebreroList.get(i).getTotalSemana();
            }
            for (int i = 0; i < valoresSemanaTotalF.length; i++) {
                valorIngresoF += valoresSemanaTotalF[i];
            }
            valorIngresoFT.setText(valorIngresoF +"");
        }else if(ingresosFebreroList.size()==0){
            valorIngresoFT.setText(0.0 +"");
        }
        if(ingresosMarzoList.size()!= 0){
            valoresSemanaTotalM= new double[ingresosMarzoList.size()];
            for (int i = 0; i < ingresosMarzoList.size(); i++) {
                valoresSemanaTotalM[i]= ingresosMarzoList.get(i).getTotalSemana();
            }
            for (int i = 0; i < valoresSemanaTotalM.length; i++) {
                valorIngresoM += valoresSemanaTotalM[i];
            }
            valorIngresoMT.setText(valorIngresoM +"");
        }else if(ingresosMarzoList.size()==0){
            valorIngresoMT.setText(0.0 +"");
        }
        if(ingresosAbrilList.size()!= 0){
            valoresSemanaTotalA= new double[ingresosAbrilList.size()];
            for (int i = 0; i < ingresosAbrilList.size(); i++) {
                valoresSemanaTotalA[i]= ingresosAbrilList.get(i).getTotalSemana();
            }
            for (int i = 0; i < valoresSemanaTotalA.length; i++) {
                valorIngresoA += valoresSemanaTotalA[i];
            }
            valorIngresoAT.setText(valorIngresoA +"");
        }else if(ingresosAbrilList.size()==0){
            valorIngresoAT.setText(0.0 +"");
        }
        if(ingresosMayoList.size()!= 0){
            valoresSemanaTotalMA= new double[ingresosMayoList.size()];
            for (int i = 0; i < ingresosMayoList.size(); i++) {
                valoresSemanaTotalMA[i]= ingresosMayoList.get(i).getTotalSemana();
            }
            for (int i = 0; i < valoresSemanaTotalMA.length; i++) {
                valorIngresoMA += valoresSemanaTotalMA[i];
            }
            valorIngresoMAT.setText(valorIngresoMA +"");
        }else if(ingresosMayoList.size()==0){
            valorIngresoMAT.setText(0.0 +"");
        }
        if(ingresosJunioList.size()!= 0){
            valoresSemanaTotalJ= new double[ingresosJunioList.size()];
            for (int i = 0; i < ingresosJunioList.size(); i++) {
                valoresSemanaTotalJ[i]= ingresosJunioList.get(i).getTotalSemana();
            }
            for (int i = 0; i < valoresSemanaTotalJ.length; i++) {
                valorIngresoJ += valoresSemanaTotalJ[i];
            }
            valorIngresoJT.setText(valorIngresoJ +"");
        }else if(ingresosJunioList.size()==0){
            valorIngresoJT.setText(0.0 +"");
        }
        if(ingresosJulioList.size()!= 0){
            valoresSemanaTotalJU= new double[ingresosJulioList.size()];
            for (int i = 0; i < ingresosJulioList.size(); i++) {
                valoresSemanaTotalJU[i]= ingresosJulioList.get(i).getTotalSemana();
            }
            for (int i = 0; i < valoresSemanaTotalJU.length; i++) {
                valorIngresoJU += valoresSemanaTotalJU[i];
            }
            valorIngresoJUT.setText(valorIngresoJU +"");
        }else if(ingresosJulioList.size()==0){
            valorIngresoJUT.setText(0.0 +"");
        }
        if(ingresosAgostoList.size()!= 0){
            valoresSemanaTotalAG= new double[ingresosAgostoList.size()];
            for (int i = 0; i < ingresosAgostoList.size(); i++) {
                valoresSemanaTotalAG[i]= ingresosAgostoList.get(i).getTotalSemana();
            }
            for (int i = 0; i < valoresSemanaTotalAG.length; i++) {
                valorIngresoAG += valoresSemanaTotalAG[i];
            }
            valorIngresoAGT.setText(valorIngresoAG +"");
        }else if(ingresosAgostoList.size()==0){
            valorIngresoAGT.setText(0.0 +"");
        }
        if(ingresosSeptiembreList.size()!= 0){
            ValoresSemanaTotalS= new double[ingresosSeptiembreList.size()];
            for (int i = 0; i < ingresosSeptiembreList.size(); i++) {
                ValoresSemanaTotalS[i]= ingresosSeptiembreList.get(i).getTotalSemana();
            }
            for (int i = 0; i < ValoresSemanaTotalS.length; i++) {
                valorIngresoS += ValoresSemanaTotalS[i];
            }
            valorIngresoST.setText(valorIngresoS +"");
        }else if(ingresosSeptiembreList.size()==0){
            valorIngresoST.setText(0.0 +"");
        }
        if(ingresosOctubreList.size()!= 0){
            valoresSemanaTotalOC= new double[ingresosOctubreList.size()];
            for (int i = 0; i < ingresosOctubreList.size(); i++) {
                valoresSemanaTotalOC[i]= ingresosOctubreList.get(i).getTotalSemana();
            }
            for (int i = 0; i < valoresSemanaTotalOC.length; i++) {
                valorIngresoOC += valoresSemanaTotalOC[i];
            }
            valorIngresoOT.setText(valorIngresoOC +"");
        }else if(ingresosOctubreList.size()==0){
            valorIngresoOT.setText(0.0 +"");
        }
        if(ingresosNoviembreList.size()!= 0){
            valoresSemanaTotalN= new double[ingresosNoviembreList.size()];
            for (int i = 0; i < ingresosNoviembreList.size(); i++) {
                valoresSemanaTotalN[i]= ingresosNoviembreList.get(i).getTotalSemana();
            }
            for (int i = 0; i < valoresSemanaTotalN.length; i++) {
                valorIngresoN += valoresSemanaTotalN[i];
            }
            valorIngresoNT.setText(valorIngresoN +"");
        }else if(ingresosNoviembreList.size()==0){
            valorIngresoNT.setText(0.0 +"");
        }
        if(ingresosDiciembreList.size()!= 0){
            valoresSemanaTotalD= new double[ingresosDiciembreList.size()];
            for (int i = 0; i < ingresosDiciembreList.size(); i++) {
                valoresSemanaTotalD[i]= ingresosDiciembreList.get(i).getTotalSemana();
            }
            for (int i = 0; i < valoresSemanaTotalD.length; i++) {
                valorIngresoD += valoresSemanaTotalD[i];
            }
            valorIngresoDT.setText(valorIngresoD +"");
        }else if(ingresosDiciembreList.size()==0){
            valorIngresoDT.setText(0.0 +"");
        }
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