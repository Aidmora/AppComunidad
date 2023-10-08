package com.example.appcomunidad.userInterface.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcomunidad.BusinessLogic.entities.IngresosEnero;
import com.example.appcomunidad.BusinessLogic.entities.UsuarioComunidad;
import com.example.appcomunidad.BusinessLogic.managers.IngresoEneroBL;
import com.example.appcomunidad.R;
import com.example.appcomunidad.framework.AppException;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class InformacionDetalleUsuarioCActivity extends AppCompatActivity {
    private IngresoEneroBL ingresoEneroBL;
    private String [] valoresAportadosMasser, valoresAportadosRoshJodesh, valoresAportadosTerumahYeladim, valoresAportadosTerreno,valoresAportadosShuljan, valoresAportadosTzedaqah,valoresAportadosKaparah,valoresAportadosArriendo, valoresAportadosSemanaTotal;
    private String [] valoresMostrar,valoresMostrar2,valoresMostrar3,valoresMostrar4,valoresMostrar5,valoresMostrar6,valoresMostrar7,valoresMostrar8, valoresMostrar9;
    private String [] listaMeses={"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
    private ImageView fotoJaverInfoDetalle;
    private TextView nombreJaverInfoDetalle, apellidoJaverInfoDetalle,cedulaJaverInfoDetalle;
    private Button mostrarTransacciones;
    private UsuarioComunidad usuarioComunidad;
    private NumberPicker listaAportesMasserNP, listaMesesNp,listaAportesRoshJodeshNP,listaAportesTerumahYeladimNP,listaAportesTerrenoNP,listaAportesShuljanNP,listaAportesTzedaqahNP,listaAportesKaparahNP,listaAportesArriendoNP, listaAportesSemanaTotalNP;
    private List<IngresosEnero> ingresosEneroList;
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
        valoresMostrar=new String[0];
        if(mesSeleccionado.trim().toLowerCase().equals("enero")){
            try {
                ingresosEneroList= ingresoEneroBL.leerRegistroPorId(usuarioComunidad.getIdUsuarioComunidad());
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
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
        }else if(mesSeleccionado.trim().toLowerCase().equals("abril")){
            Toast.makeText(this,"Entre a abril",Toast.LENGTH_SHORT).show();
            valoresMostrar= listaMeses;
        }
        listaAportesMasserNP.setMinValue(0);
        listaAportesMasserNP.setMaxValue((valoresMostrar.length)-1);
        listaAportesMasserNP.setDisplayedValues(valoresMostrar);

        listaAportesRoshJodeshNP.setMinValue(0);
        listaAportesRoshJodeshNP.setMaxValue((valoresMostrar2.length)-1);
        listaAportesRoshJodeshNP.setDisplayedValues(valoresMostrar2);

        listaAportesTerumahYeladimNP.setMinValue(0);
        listaAportesTerumahYeladimNP.setMaxValue((valoresMostrar3.length)-1);
        listaAportesTerumahYeladimNP.setDisplayedValues(valoresMostrar3);

        listaAportesTerrenoNP.setMinValue(0);
        listaAportesTerrenoNP.setMaxValue((valoresMostrar4.length)-1);
        listaAportesTerrenoNP.setDisplayedValues(valoresMostrar4);

        listaAportesShuljanNP.setMinValue(0);
        listaAportesShuljanNP.setMaxValue((valoresMostrar5.length)-1);
        listaAportesShuljanNP.setDisplayedValues(valoresMostrar5);

        listaAportesTzedaqahNP.setMinValue(0);
        listaAportesTzedaqahNP.setMaxValue((valoresMostrar6.length)-1);
        listaAportesTzedaqahNP.setDisplayedValues(valoresMostrar6);

        listaAportesKaparahNP.setMinValue(0);
        listaAportesKaparahNP.setMaxValue((valoresMostrar7.length)-1);
        listaAportesKaparahNP.setDisplayedValues(valoresMostrar7);

        listaAportesArriendoNP.setMinValue(0);
        listaAportesArriendoNP.setMaxValue((valoresMostrar8.length)-1);
        listaAportesArriendoNP.setDisplayedValues(valoresMostrar8);

        listaAportesSemanaTotalNP.setMinValue(0);
        listaAportesSemanaTotalNP.setMaxValue((valoresMostrar9.length)-1);
        listaAportesSemanaTotalNP.setDisplayedValues(valoresMostrar9);
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