package com.example.appcomunidad.userInterface.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcomunidad.BusinessLogic.entities.IngresosAbril;
import com.example.appcomunidad.BusinessLogic.entities.IngresosEnero;
import com.example.appcomunidad.BusinessLogic.entities.IngresosFebrero;
import com.example.appcomunidad.BusinessLogic.entities.IngresosMarzo;
import com.example.appcomunidad.BusinessLogic.entities.IngresosMayo;
import com.example.appcomunidad.BusinessLogic.entities.UsuarioComunidad;
import com.example.appcomunidad.BusinessLogic.managers.IngresoAbrilBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoEneroBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoFebreroBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoMarzoBL;
import com.example.appcomunidad.BusinessLogic.managers.IngresoMayoBL;
import com.example.appcomunidad.R;
import com.example.appcomunidad.framework.AppException;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class InformacionDetalleUsuarioCActivity extends AppCompatActivity {
    private IngresoEneroBL ingresoEneroBL;
    private IngresoFebreroBL ingresoFebreroBL;
    private IngresoMarzoBL ingresoMarzoBL;
    private IngresoAbrilBL ingresoAbrilBL;
    private IngresoMayoBL ingresoMayoBL;
    private String [] valoresAportadosMasser, valoresAportadosRoshJodesh, valoresAportadosTerumahYeladim, valoresAportadosTerreno,valoresAportadosShuljan, valoresAportadosTzedaqah,valoresAportadosKaparah,valoresAportadosArriendo, valoresAportadosSemanaTotal;
    private String [] valoresMostrar,valoresMostrar2,valoresMostrar3,valoresMostrar4,valoresMostrar5,valoresMostrar6,valoresMostrar7,valoresMostrar8, valoresMostrar9;
    private String [] listaMeses={"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
    private String [] listaSinValor={"0"};
    private ImageView fotoJaverInfoDetalle;
    private TextView nombreJaverInfoDetalle, apellidoJaverInfoDetalle,cedulaJaverInfoDetalle;
    private Button mostrarTransacciones;
    private UsuarioComunidad usuarioComunidad;
    private NumberPicker listaAportesMasserNP, listaMesesNp,listaAportesRoshJodeshNP,listaAportesTerumahYeladimNP,listaAportesTerrenoNP,listaAportesShuljanNP,listaAportesTzedaqahNP,listaAportesKaparahNP,listaAportesArriendoNP, listaAportesSemanaTotalNP;
    private List<IngresosEnero> ingresosEneroList;
    private List<IngresosFebrero> ingresosFebreroList;
    private List<IngresosMarzo>  ingresosMarzoList;
    private List<IngresosAbril> ingresosAbrilList;
    private List<IngresosMayo> ingresosMayoList;
    private Animation
            rotateOpen,
            rotateClose,
            fromBottom,
            toBottom;
    private FloatingActionButton MagenBoton, salirBoton;
    private boolean botonesVisibles = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_detalle_usuario_cactivity);
        inicializarRecuros();
        establecerDatos();
        listaMesesNp.setMinValue(0);
        listaMesesNp.setMaxValue(11);
        listaMesesNp.setDisplayedValues(listaMeses);
        MagenBoton.setOnClickListener(this::mostrarFloatingButtons);
        salirBoton.setOnClickListener(this::cerrarActivity);
        mostrarTransacciones.setOnClickListener(this::mostrarTransacciones);
    }
    public void inicializarRecuros(){
        ingresoEneroBL= new IngresoEneroBL(this);
        usuarioComunidad= new UsuarioComunidad();
        ingresosEneroList=new ArrayList<>();
        ingresosFebreroList= new ArrayList<>();
        ingresoFebreroBL=new IngresoFebreroBL(this);
        ingresoMarzoBL= new IngresoMarzoBL(this);
        ingresoAbrilBL= new IngresoAbrilBL(this);
        ingresoMayoBL= new IngresoMayoBL(this);
        mostrarTransacciones= findViewById(R.id.mostrarInformacionDetallada);
        fotoJaverInfoDetalle=findViewById(R.id.foto_javerVentanaInfoDetalle);
        nombreJaverInfoDetalle=findViewById(R.id.nombre_javerInfo);
        apellidoJaverInfoDetalle=findViewById(R.id.apellido_javerInfo);
        cedulaJaverInfoDetalle=findViewById(R.id.cedula_javerInfo);
        listaAportesMasserNP = findViewById(R.id.NPlistaValorMasser);
        listaAportesRoshJodeshNP=findViewById(R.id.NPlistaValorRoshJodesh);
        listaAportesTerumahYeladimNP=findViewById(R.id.NPlistaValorTerumahYeladim);
        listaAportesTerrenoNP=findViewById(R.id.NPlistaValorTerreno);
        listaAportesShuljanNP=findViewById(R.id.NPlistaValorShuljan);
        listaAportesTzedaqahNP=findViewById(R.id.NPlistaValorTzedaqah);
        listaAportesKaparahNP=findViewById(R.id.NPlistaValorKaparah);
        listaAportesArriendoNP=findViewById(R.id.NPlistaValorArriendo);
        listaAportesSemanaTotalNP= findViewById(R.id.NPlistaValorSemanaTotal);
        listaMesesNp= findViewById(R.id.listaMeses);
        MagenBoton=findViewById(R.id.magen_FButtonVentanaInfoDetalle);
        salirBoton=findViewById(R.id.cerrarInfoDetalle_FButtonVentanaInfoDetalle);
        rotateOpen = AnimationUtils.loadAnimation(this, R.anim.rotacion_abrir_boton);
        rotateClose= AnimationUtils.loadAnimation(this,R.anim.rotacion_cerrar_boton);
        fromBottom=AnimationUtils.loadAnimation(this,R.anim.from_bottom_anim);
        toBottom=AnimationUtils.loadAnimation(this,R.anim.to_bottom_anim);


    }
    public void establecerDatos(){
        usuarioComunidad=(UsuarioComunidad) getIntent().getSerializableExtra("usuarioCom_seleccionado2");
        int imagenResource = this.getResources().getIdentifier(usuarioComunidad.getFotoJaver(), "drawable", this.getPackageName());
        fotoJaverInfoDetalle.setImageResource(imagenResource);
        nombreJaverInfoDetalle.setText(usuarioComunidad.getNombreJaver());
        apellidoJaverInfoDetalle.setText(usuarioComunidad.getApellidoJaver());
        cedulaJaverInfoDetalle.setText(usuarioComunidad.getCedula());

    }
    public void mostrarTransacciones(View view){
        String mesSeleccionado= listaMeses[listaMesesNp.getValue()];
        Log.i("mostrarTransac","Esta ingresando ");
        valoresMostrar=new String[0];
        valoresMostrar2=new String[0];
        valoresMostrar3=new String[0];
        valoresMostrar4=new String[0];
        valoresMostrar5=new String[0];
        valoresMostrar6=new String[0];
        valoresMostrar7=new String[0];
        valoresMostrar8=new String[0];
        valoresMostrar9=new String[0];
        Log.i("mostrarTransac","la longitud del arreglo es"+ valoresMostrar.length+"");
        if(mesSeleccionado.trim().toLowerCase().equals("enero")){
            Log.i("mostrarTransac","Entro al mes de enero");
            try {
                ingresosEneroList= ingresoEneroBL.leerRegistroPorId(usuarioComunidad.getIdUsuarioComunidad());
                Log.i("mostrarTransac","obtuvo una lista vacia");
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
            Log.i("mostrarTransac","va a entrar al if para verificar si la lista esta vacia. " + ingresosEneroList.size()+"");
            if(ingresosEneroList.size() !=0){
                Log.i("mostrarTransac","entro al if de la lista que es diferente a vacio");
                valoresAportadosMasser =new String[ingresosEneroList.size()];
                valoresAportadosRoshJodesh=new String[ingresosEneroList.size()];
                valoresAportadosTerumahYeladim=new String[ingresosEneroList.size()];
                valoresAportadosTerreno=new String[ingresosEneroList.size()];
                valoresAportadosShuljan=new String[ingresosEneroList.size()];
                valoresAportadosTzedaqah=new String[ingresosEneroList.size()];
                valoresAportadosKaparah=new String[ingresosEneroList.size()];
                valoresAportadosArriendo=new String[ingresosEneroList.size()];
                valoresAportadosSemanaTotal=new String[ingresosEneroList.size()];
                for (int i = 0; i < ingresosEneroList.size(); i++) {
                    String numPago= (i+1)+"";
                    valoresAportadosMasser[i]="Pago " + numPago  +": "  + ingresosEneroList.get(i).getMasserBaitHaM();
                    valoresAportadosRoshJodesh[i]="Pago " + numPago  +": "  + ingresosEneroList.get(i).getRoshJodesh();
                    valoresAportadosTerumahYeladim[i]="Pago " + numPago  +": "  + ingresosEneroList.get(i).getTerumahYeladim();
                    valoresAportadosTerreno[i]="Pago " + numPago  +": "  + ingresosEneroList.get(i).getTerreno();
                    valoresAportadosShuljan[i]="Pago " + numPago  +": "  + ingresosEneroList.get(i).getShuljan();
                    valoresAportadosTzedaqah[i]="Pago " + numPago  +": "  + ingresosEneroList.get(i).getTzedaqah();
                    valoresAportadosKaparah[i]="Pago " + numPago  +": "  + ingresosEneroList.get(i).getKaparah();
                    valoresAportadosArriendo[i]="Pago " + numPago  +": "  + ingresosEneroList.get(i).getArriendo();
                    valoresAportadosSemanaTotal[i]= ingresosEneroList.get(i).getSemanaFechaIng()+" "+": "+ingresosEneroList.get(i).getTotalSemana()+"";
                }
                valoresMostrar= valoresAportadosMasser;
                valoresMostrar2=valoresAportadosRoshJodesh;
                valoresMostrar3=valoresAportadosTerumahYeladim;
                valoresMostrar4=valoresAportadosTerreno;
                valoresMostrar5=valoresAportadosShuljan;
                valoresMostrar6=valoresAportadosTzedaqah;
                valoresMostrar7=valoresAportadosKaparah;
                valoresMostrar8=valoresAportadosArriendo;
                valoresMostrar9=valoresAportadosSemanaTotal;
                Log.i("mostrarTransac","la longitud del arreglo es"+ valoresMostrar.length+"");
            }else {
                Log.i("mostrarTransac","Esta ingresando por que la lista es nula");
                Toast.makeText(this, "No hay registros de este mes", Toast.LENGTH_SHORT).show();
            }
        }else if(mesSeleccionado.trim().toLowerCase().equals("febrero")) {
            Log.i("mostrarTransac","Entro al mes de febrero");
            try {
                ingresosFebreroList = ingresoFebreroBL.leerRegistroPorId(usuarioComunidad.getIdUsuarioComunidad());
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
            if(ingresosFebreroList.size() !=0){
                valoresAportadosMasser =new String[ingresosFebreroList.size()];
                valoresAportadosRoshJodesh=new String[ingresosFebreroList.size()];
                valoresAportadosTerumahYeladim=new String[ingresosFebreroList.size()];
                valoresAportadosTerreno=new String[ingresosFebreroList.size()];
                valoresAportadosShuljan=new String[ingresosFebreroList.size()];
                valoresAportadosTzedaqah=new String[ingresosFebreroList.size()];
                valoresAportadosKaparah=new String[ingresosFebreroList.size()];
                valoresAportadosArriendo=new String[ingresosFebreroList.size()];
                valoresAportadosSemanaTotal=new String[ingresosFebreroList.size()];
                for (int i = 0; i < ingresosFebreroList.size(); i++) {
                    String numPago= (i+1)+"";
                    valoresAportadosMasser[i]="Pago " + numPago  +": "  + ingresosFebreroList.get(i).getMasserBaitHaM();
                    valoresAportadosRoshJodesh[i]="Pago " + numPago  +": "  + ingresosFebreroList.get(i).getRoshJodesh();
                    valoresAportadosTerumahYeladim[i]="Pago " + numPago  +": "  + ingresosFebreroList.get(i).getTerumahYeladim();
                    valoresAportadosTerreno[i]="Pago " + numPago  +": "  + ingresosFebreroList.get(i).getTerreno();
                    valoresAportadosShuljan[i]="Pago " + numPago  +": "  + ingresosFebreroList.get(i).getShuljan();
                    valoresAportadosTzedaqah[i]="Pago " + numPago  +": "  + ingresosFebreroList.get(i).getTzedaqah();
                    valoresAportadosKaparah[i]="Pago " + numPago  +": "  + ingresosFebreroList.get(i).getKaparah();
                    valoresAportadosArriendo[i]="Pago " + numPago  +": "  + ingresosFebreroList.get(i).getArriendo();
                    valoresAportadosSemanaTotal[i]= ingresosFebreroList.get(i).getSemanaFechaIng()+" "+": "+ingresosFebreroList.get(i).getTotalSemana()+"";
                }
                valoresMostrar= valoresAportadosMasser;
                valoresMostrar2=valoresAportadosRoshJodesh;
                valoresMostrar3=valoresAportadosTerumahYeladim;
                valoresMostrar4=valoresAportadosTerreno;
                valoresMostrar5=valoresAportadosShuljan;
                valoresMostrar6=valoresAportadosTzedaqah;
                valoresMostrar7=valoresAportadosKaparah;
                valoresMostrar8=valoresAportadosArriendo;
                valoresMostrar9=valoresAportadosSemanaTotal;
                Log.i("mostrarTransac","la longitud del arreglo es"+ valoresMostrar.length+"");
            }
        }else if (mesSeleccionado.trim().toLowerCase().equals("marzo")){
            Log.i("mostrarTransac","Entro al mes de Marzo");
            try {
                ingresosMarzoList = ingresoMarzoBL.leerRegistroPorId(usuarioComunidad.getIdUsuarioComunidad());
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
            if(ingresosMarzoList.size() !=0){
                valoresAportadosMasser =new String[ingresosMarzoList.size()];
                valoresAportadosRoshJodesh=new String[ingresosMarzoList.size()];
                valoresAportadosTerumahYeladim=new String[ingresosMarzoList.size()];
                valoresAportadosTerreno=new String[ingresosMarzoList.size()];
                valoresAportadosShuljan=new String[ingresosMarzoList.size()];
                valoresAportadosTzedaqah=new String[ingresosMarzoList.size()];
                valoresAportadosKaparah=new String[ingresosMarzoList.size()];
                valoresAportadosArriendo=new String[ingresosMarzoList.size()];
                valoresAportadosSemanaTotal=new String[ingresosMarzoList.size()];
                for (int i = 0; i < ingresosMarzoList.size(); i++) {
                    String numPago= (i+1)+"";
                    valoresAportadosMasser[i]="Pago " + numPago  +": "  + ingresosMarzoList.get(i).getMasserBaitHaM();
                    valoresAportadosRoshJodesh[i]="Pago " + numPago  +": "  + ingresosMarzoList.get(i).getRoshJodesh();
                    valoresAportadosTerumahYeladim[i]="Pago " + numPago  +": "  + ingresosMarzoList.get(i).getTerumahYeladim();
                    valoresAportadosTerreno[i]="Pago " + numPago  +": "  + ingresosMarzoList.get(i).getTerreno();
                    valoresAportadosShuljan[i]="Pago " + numPago  +": "  + ingresosMarzoList.get(i).getShuljan();
                    valoresAportadosTzedaqah[i]="Pago " + numPago  +": "  + ingresosMarzoList.get(i).getTzedaqah();
                    valoresAportadosKaparah[i]="Pago " + numPago  +": "  + ingresosMarzoList.get(i).getKaparah();
                    valoresAportadosArriendo[i]="Pago " + numPago  +": "  + ingresosMarzoList.get(i).getArriendo();
                    valoresAportadosSemanaTotal[i]= ingresosMarzoList.get(i).getSemanaFechaIng()+" "+": "+ingresosMarzoList.get(i).getTotalSemana()+"";
                }
                valoresMostrar= valoresAportadosMasser;
                valoresMostrar2=valoresAportadosRoshJodesh;
                valoresMostrar3=valoresAportadosTerumahYeladim;
                valoresMostrar4=valoresAportadosTerreno;
                valoresMostrar5=valoresAportadosShuljan;
                valoresMostrar6=valoresAportadosTzedaqah;
                valoresMostrar7=valoresAportadosKaparah;
                valoresMostrar8=valoresAportadosArriendo;
                valoresMostrar9=valoresAportadosSemanaTotal;
                Log.i("mostrarTransac","la longitud del arreglo es"+ valoresMostrar.length+"");
                }
            }else if(mesSeleccionado.trim().toLowerCase().equals("abril")){
            Log.i("mostrarTransac","Entro al mes de Abril");
            try {
                ingresosAbrilList = ingresoAbrilBL.leerRegistroPorId(usuarioComunidad.getIdUsuarioComunidad());
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
            if(ingresosAbrilList.size() !=0){
                valoresAportadosMasser =new String[ingresosAbrilList.size()];
                valoresAportadosRoshJodesh=new String[ingresosAbrilList.size()];
                valoresAportadosTerumahYeladim=new String[ingresosAbrilList.size()];
                valoresAportadosTerreno=new String[ingresosAbrilList.size()];
                valoresAportadosShuljan=new String[ingresosAbrilList.size()];
                valoresAportadosTzedaqah=new String[ingresosAbrilList.size()];
                valoresAportadosKaparah=new String[ingresosAbrilList.size()];
                valoresAportadosArriendo=new String[ingresosAbrilList.size()];
                valoresAportadosSemanaTotal=new String[ingresosAbrilList.size()];
                for (int i = 0; i < ingresosAbrilList.size(); i++) {
                    String numPago= (i+1)+"";
                    valoresAportadosMasser[i]="Pago " + numPago  +": "  + ingresosAbrilList.get(i).getMasserBaitHaM();
                    valoresAportadosRoshJodesh[i]="Pago " + numPago  +": "  + ingresosAbrilList.get(i).getRoshJodesh();
                    valoresAportadosTerumahYeladim[i]="Pago " + numPago  +": "  + ingresosAbrilList.get(i).getTerumahYeladim();
                    valoresAportadosTerreno[i]="Pago " + numPago  +": "  + ingresosAbrilList.get(i).getTerreno();
                    valoresAportadosShuljan[i]="Pago " + numPago  +": "  + ingresosAbrilList.get(i).getShuljan();
                    valoresAportadosTzedaqah[i]="Pago " + numPago  +": "  + ingresosAbrilList.get(i).getTzedaqah();
                    valoresAportadosKaparah[i]="Pago " + numPago  +": "  + ingresosAbrilList.get(i).getKaparah();
                    valoresAportadosArriendo[i]="Pago " + numPago  +": "  + ingresosAbrilList.get(i).getArriendo();
                    valoresAportadosSemanaTotal[i]= ingresosAbrilList.get(i).getSemanaFechaIng()+" "+": "+ingresosAbrilList.get(i).getTotalSemana()+"";
                }
                valoresMostrar= valoresAportadosMasser;
                valoresMostrar2=valoresAportadosRoshJodesh;
                valoresMostrar3=valoresAportadosTerumahYeladim;
                valoresMostrar4=valoresAportadosTerreno;
                valoresMostrar5=valoresAportadosShuljan;
                valoresMostrar6=valoresAportadosTzedaqah;
                valoresMostrar7=valoresAportadosKaparah;
                valoresMostrar8=valoresAportadosArriendo;
                valoresMostrar9=valoresAportadosSemanaTotal;
                Log.i("mostrarTransac","la longitud del arreglo es"+ valoresMostrar.length+"");
                }
            }else if(mesSeleccionado.trim().toLowerCase().equals("mayo")){
            Log.i("mostrarTransac","Entro al mes de Mayo");
            try {
                ingresosMayoList = ingresoMayoBL.leerRegistroPorId(usuarioComunidad.getIdUsuarioComunidad());
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
            if(ingresosMayoList.size() !=0){
                valoresAportadosMasser =new String[ingresosMayoList.size()];
                valoresAportadosRoshJodesh=new String[ingresosMayoList.size()];
                valoresAportadosTerumahYeladim=new String[ingresosMayoList.size()];
                valoresAportadosTerreno=new String[ingresosMayoList.size()];
                valoresAportadosShuljan=new String[ingresosMayoList.size()];
                valoresAportadosTzedaqah=new String[ingresosMayoList.size()];
                valoresAportadosKaparah=new String[ingresosMayoList.size()];
                valoresAportadosArriendo=new String[ingresosMayoList.size()];
                valoresAportadosSemanaTotal=new String[ingresosMayoList.size()];
                for (int i = 0; i < ingresosMayoList.size(); i++) {
                    String numPago= (i+1)+"";
                    valoresAportadosMasser[i]="Pago " + numPago  +": "  + ingresosMayoList.get(i).getMasserBaitHaM();
                    valoresAportadosRoshJodesh[i]="Pago " + numPago  +": "  + ingresosMayoList.get(i).getRoshJodesh();
                    valoresAportadosTerumahYeladim[i]="Pago " + numPago  +": "  + ingresosMayoList.get(i).getTerumahYeladim();
                    valoresAportadosTerreno[i]="Pago " + numPago  +": "  + ingresosMayoList.get(i).getTerreno();
                    valoresAportadosShuljan[i]="Pago " + numPago  +": "  + ingresosMayoList.get(i).getShuljan();
                    valoresAportadosTzedaqah[i]="Pago " + numPago  +": "  + ingresosMayoList.get(i).getTzedaqah();
                    valoresAportadosKaparah[i]="Pago " + numPago  +": "  +ingresosMayoList.get(i).getKaparah();
                    valoresAportadosArriendo[i]="Pago " + numPago  +": "  + ingresosMayoList.get(i).getArriendo();
                    valoresAportadosSemanaTotal[i]= ingresosMayoList.get(i).getSemanaFechaIng()+" "+": "+ingresosMayoList.get(i).getTotalSemana()+"";
                }
                valoresMostrar= valoresAportadosMasser;
                valoresMostrar2=valoresAportadosRoshJodesh;
                valoresMostrar3=valoresAportadosTerumahYeladim;
                valoresMostrar4=valoresAportadosTerreno;
                valoresMostrar5=valoresAportadosShuljan;
                valoresMostrar6=valoresAportadosTzedaqah;
                valoresMostrar7=valoresAportadosKaparah;
                valoresMostrar8=valoresAportadosArriendo;
                valoresMostrar9=valoresAportadosSemanaTotal;
                Log.i("mostrarTransac","la longitud del arreglo es"+ valoresMostrar.length+"");
                }
            }
        Log.i("mostrarTransac","la longitud del arreglo es"+ valoresMostrar.length+"");
        if(valoresMostrar.length >= 1 ){
            Log.i("mostrarTransac","la longitud del arreglo mostrar es : "+ valoresMostrar.length+ " ");
            listaAportesMasserNP.setDisplayedValues(null);
            listaAportesMasserNP.setMinValue(0);
            Log.i("mostrarTransac","la longitud del arreglo mostrar es : "+ valoresMostrar.length+ " ");
            listaAportesMasserNP.setMaxValue((valoresMostrar.length)-1);
            Log.i("mostrarTransac","la longitud del arreglo mostrar es : "+ valoresMostrar.length+ " ");
            listaAportesMasserNP.setDisplayedValues(valoresMostrar);
            valoresMostrar=new String[0];
            Log.i("mostrarTransac","la longitud del arreglo mostrar es : "+ valoresMostrar.length+ " ");
        }else if (valoresMostrar.length == 0){
            listaAportesMasserNP.setMinValue(0);
            listaAportesMasserNP.setMaxValue((listaSinValor.length)-1);
            listaAportesMasserNP.setDisplayedValues(listaSinValor);
        }

        if(valoresMostrar2.length >= 1 ){
            listaAportesRoshJodeshNP.setDisplayedValues(null);
            listaAportesRoshJodeshNP.setMinValue(0);
            listaAportesRoshJodeshNP.setMaxValue((valoresMostrar2.length)-1);
            listaAportesRoshJodeshNP.setDisplayedValues(valoresMostrar2);
        }else if(valoresMostrar2.length == 0){
            listaAportesRoshJodeshNP.setMinValue(0);
            listaAportesRoshJodeshNP.setMaxValue((listaSinValor.length)-1);
            listaAportesRoshJodeshNP.setDisplayedValues(listaSinValor);
        }

        if(valoresMostrar3.length >= 1 ){
            listaAportesTerumahYeladimNP.setDisplayedValues(null);
            listaAportesTerumahYeladimNP.setMinValue(0);
            listaAportesTerumahYeladimNP.setMaxValue((valoresMostrar3.length)-1);
            listaAportesTerumahYeladimNP.setDisplayedValues(valoresMostrar3);
        }else if(valoresMostrar3.length == 0){
            listaAportesTerumahYeladimNP.setMinValue(0);
            listaAportesTerumahYeladimNP.setMaxValue((listaSinValor.length)-1);
            listaAportesTerumahYeladimNP.setDisplayedValues(listaSinValor);
        }

        if(valoresMostrar4.length >= 1 ){
            listaAportesTerrenoNP.setDisplayedValues(null);
            listaAportesTerrenoNP.setMinValue(0);
            listaAportesTerrenoNP.setMaxValue((valoresMostrar4.length)-1);
            listaAportesTerrenoNP.setDisplayedValues(valoresMostrar4);
        }else if(valoresMostrar4.length== 0 ){
            listaAportesTerrenoNP.setMinValue(0);
            listaAportesTerrenoNP.setMaxValue((listaSinValor.length)-1);
            listaAportesTerrenoNP.setDisplayedValues(listaSinValor);
        }

        if(valoresMostrar5.length >= 1 ){
            listaAportesShuljanNP.setDisplayedValues(null);
            listaAportesShuljanNP.setMinValue(0);
            listaAportesShuljanNP.setMaxValue((valoresMostrar5.length)-1);
            listaAportesShuljanNP.setDisplayedValues(valoresMostrar5);
        }else if(valoresMostrar5.length == 0){
            listaAportesShuljanNP.setMinValue(0);
            listaAportesShuljanNP.setMaxValue((listaSinValor.length)-1);
            listaAportesShuljanNP.setDisplayedValues(listaSinValor);
        }

        if(valoresMostrar6.length >= 1 ){
            listaAportesTzedaqahNP.setDisplayedValues(null);
            listaAportesTzedaqahNP.setMinValue(0);
            listaAportesTzedaqahNP.setMaxValue((valoresMostrar6.length)-1);
            listaAportesTzedaqahNP.setDisplayedValues(valoresMostrar6);

        }else if (valoresMostrar6.length == 0){
            listaAportesTzedaqahNP.setMinValue(0);
            listaAportesTzedaqahNP.setMaxValue((listaSinValor.length)-1);
            listaAportesTzedaqahNP.setDisplayedValues(listaSinValor);
        }

        if(valoresMostrar7.length >= 1 ){
            listaAportesKaparahNP.setDisplayedValues(null);
            listaAportesKaparahNP.setMinValue(0);
            listaAportesKaparahNP.setMaxValue((valoresMostrar7.length)-1);
            listaAportesKaparahNP.setDisplayedValues(valoresMostrar7);

        }else if(valoresMostrar7.length == 0){
            listaAportesKaparahNP.setMinValue(0);
            listaAportesKaparahNP.setMaxValue((listaSinValor.length)-1);
            listaAportesKaparahNP.setDisplayedValues(listaSinValor);
        }

        if(valoresMostrar8.length >= 1 ){
            listaAportesArriendoNP.setDisplayedValues(null);
            listaAportesArriendoNP.setMinValue(0);
            listaAportesArriendoNP.setMaxValue((valoresMostrar8.length)-1);
            listaAportesArriendoNP.setDisplayedValues(valoresMostrar8);
        }else if(valoresMostrar8.length == 0 ){
            listaAportesArriendoNP.setMinValue(0);
            listaAportesArriendoNP.setMaxValue((listaSinValor.length)-1);
            listaAportesArriendoNP.setDisplayedValues(listaSinValor);
        }

        if(valoresMostrar9.length >= 1 ){
            listaAportesSemanaTotalNP.setDisplayedValues(null);
            listaAportesSemanaTotalNP.setMinValue(0);
            listaAportesSemanaTotalNP.setMaxValue((valoresMostrar9.length)-1);
            listaAportesSemanaTotalNP.setDisplayedValues(valoresMostrar9);
        }else if(valoresMostrar9.length == 0 ){
            listaAportesSemanaTotalNP.setMinValue(0);
            listaAportesSemanaTotalNP.setMaxValue((listaSinValor.length)-1);
            listaAportesSemanaTotalNP.setDisplayedValues(listaSinValor);
        }

    }
    public void mostrarFloatingButtons(View view){
        mostrarOcultarBotones();
        animacionBontones();
    }
    public void mostrarOcultarBotones() {
        if (botonesVisibles) {
            salirBoton.hide();
            botonesVisibles = false;
        } else {
            salirBoton.show();
            botonesVisibles = true;
        }
    }

    public void animacionBontones(){
        if(!botonesVisibles){
            MagenBoton.startAnimation(rotateClose);
            salirBoton.startAnimation(toBottom);

        }else{
            MagenBoton.startAnimation(rotateOpen);
            salirBoton.startAnimation(fromBottom);

        }
    }
    public void cerrarActivity(View view){
        finish();
    }
}