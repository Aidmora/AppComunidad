package com.example.appcomunidad.userInterface.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcomunidad.BusinessLogic.entities.IngresosAbril;
import com.example.appcomunidad.BusinessLogic.entities.IngresosEnero;
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
import com.example.appcomunidad.BusinessLogic.managers.UsuarioIngresosHistorialBL;
import com.example.appcomunidad.BusinessLogic.utilities.ValidarDatos;
import com.example.appcomunidad.BusinessLogic.utilities.VerificarDatos;
import com.example.appcomunidad.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class usuarioComunidadPagoDetalle extends AppCompatActivity {
    private ImageView fotoJaverInfor;
    private FloatingActionButton botonIngresosUsuario;
    private UsuarioIngresosHistorialBL ingresosHistorialBL;
    private ImageButton botonInstrucciones;
    private EditText ingresoMasserBaitHaM, ingresoRoshJodesh, ingresoTerumahYeladim, ingresoTerreno, ingresoShuljan, ingresoTzedaqah, ingresoKaparah, ingresoArriendo, ingresoFechaRegistro;
    private TextView nombreJaverInfo, apellidoJaverInfo;
    private Button botonGuardarInfo;
    private UsuarioComunidad usuarioComunidad;
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
    private VerificarDatos verificarDatos;
    private NumberPicker listaAnnosNP, listaMesesNP;
    private String [] listaAnnosStr= {"2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034"};
    private String [] listaMeses={"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_comunidad_pago_detalle);
        inicializarRecuros();
        establecerDatos();
        listaAnnosNP.setMinValue(0);
        listaAnnosNP.setMaxValue(11);
        listaAnnosNP.setDisplayedValues(listaAnnosStr);
        listaMesesNP.setMinValue(0);
        listaMesesNP.setMaxValue((listaMeses.length)-1);
        listaMesesNP.setDisplayedValues(listaMeses);
        botonIngresosUsuario.setOnClickListener(this::irIngresosDetalleUsuario);
        botonInstrucciones.setOnClickListener(this::botonInstrucciones);
        botonGuardarInfo.setOnClickListener(this::irPagoDetalleUsuario);
    }
    public void inicializarRecuros(){
        verificarDatos= new VerificarDatos(this);
        usuarioComunidad= new UsuarioComunidad();
        ingresoEneroBL= new IngresoEneroBL(this);
        ingresoFebreroBL=new IngresoFebreroBL(this);
        ingresoMarzoBL=new IngresoMarzoBL(this);
        ingresoAbrilBL= new IngresoAbrilBL(this);
        ingresoMayoBL= new IngresoMayoBL(this);
        ingresoJunioBL= new IngresoJunioBL(this);
        ingresoJulioBL= new IngresoJulioBL(this);
        ingresoAgostoBL= new IngresoAgostoBL(this);
        ingresoSeptiembreBL= new IngresoSeptiembreBL(this);
        ingresoOctubreBL= new IngresoOctubreBL(this);
        ingresoNoviembreBL= new IngresoNoviembreBL(this);
        ingresoDiciembreBL= new IngresoDiciembreBL(this);
        ingresosHistorialBL= new UsuarioIngresosHistorialBL(this);
        fotoJaverInfor= findViewById(R.id.foto_javerInfo);
        nombreJaverInfo=findViewById(R.id.nombre_javerInfo);
        apellidoJaverInfo=findViewById(R.id.apellido_javerInfo);
        botonInstrucciones=findViewById(R.id.importanteInstrucciones);
        ingresoMasserBaitHaM=findViewById(R.id.ingresarMasserBaitHaM);
        ingresoRoshJodesh= findViewById(R.id.ingresarRoshJodesh);
        ingresoTerumahYeladim= findViewById(R.id.ingresarTerumahYeladim);
        botonIngresosUsuario= findViewById(R.id.botonIngresosUsuario);
        ingresoTerreno=findViewById(R.id.ingresarTerreno);
        ingresoShuljan=findViewById(R.id.ingresarShuljan);
        ingresoTzedaqah=findViewById(R.id.ingresarTzedaqah);
        ingresoKaparah=findViewById(R.id.ingresarKaparah);
        ingresoArriendo=findViewById(R.id.ingresarArriendo);
        botonGuardarInfo= findViewById(R.id.guardarRegistros);
        listaAnnosNP=findViewById(R.id.listaAnnos);
        listaMesesNP=findViewById(R.id.listaMesesActivityPago);
        ingresoFechaRegistro=findViewById(R.id.ingresarFechaRegistro);
    }
    public void establecerDatos(){
        usuarioComunidad=(UsuarioComunidad) getIntent().getSerializableExtra("usuarioCom_seleccionado");
        int imagenResource = this.getResources().getIdentifier(usuarioComunidad.getFotoJaver(), "drawable", this.getPackageName());
        fotoJaverInfor.setImageResource(imagenResource);
        nombreJaverInfo.setText(usuarioComunidad.getNombreJaver());
        apellidoJaverInfo.setText(usuarioComunidad.getApellidoJaver());


    }
    public void botonInstrucciones (View view){
        Toast.makeText(this, "Ingresar los decimales con (punto). Colocar (cero) si no hay valor para ingresar. ",Toast.LENGTH_LONG ).show();
    }
    public void irPagoDetalleUsuario(View view){
        if(!ValidarDatos.campoLleno(this,ingresoMasserBaitHaM)||
                !ValidarDatos.campoLleno(this,ingresoRoshJodesh)||
                !ValidarDatos.campoLleno(this,ingresoTerumahYeladim)||
                !ValidarDatos.campoLleno(this,ingresoTerreno)||
                !ValidarDatos.campoLleno(this,ingresoShuljan)||
                !ValidarDatos.campoLleno(this,ingresoTzedaqah)||
                !ValidarDatos.campoLleno(this,ingresoKaparah)||
                !ValidarDatos.campoLleno(this,ingresoFechaRegistro)||
                !ValidarDatos.campoLleno(this,ingresoArriendo))
            return;
        if(!ValidarDatos.validarNumero(this,ingresoMasserBaitHaM)||
                !ValidarDatos.validarNumero(this,ingresoRoshJodesh)||
                !ValidarDatos.validarNumero(this,ingresoTerumahYeladim)||
                !ValidarDatos.validarNumero(this,ingresoTerreno)||
                !ValidarDatos.validarNumero(this,ingresoShuljan)||
                !ValidarDatos.validarNumero(this,ingresoTzedaqah)||
                !ValidarDatos.validarNumero(this,ingresoKaparah)||
                !ValidarDatos.validarNumero(this,ingresoArriendo))
            return;
        Log.i("Verificar","Esta entrando a validar valor");
        if(!ValidarDatos.validarValor(this,ingresoMasserBaitHaM)||
                !ValidarDatos.validarValor(this,ingresoRoshJodesh)||
                !ValidarDatos.validarValor(this,ingresoTerumahYeladim)||
                !ValidarDatos.validarValor(this,ingresoTerreno)||
                !ValidarDatos.validarValor(this,ingresoShuljan)||
                !ValidarDatos.validarValor(this,ingresoTzedaqah)||
                !ValidarDatos.validarValor(this,ingresoKaparah)||
                !ValidarDatos.validarValor(this,ingresoArriendo))
            return;
        Log.i("Verificar","Esta entrando a validar el numero");


        AlertDialog.Builder alertaConfirmacionDatos= new AlertDialog.Builder(usuarioComunidadPagoDetalle.this);
        alertaConfirmacionDatos.setMessage("Está seguro de guardar la información?");
        alertaConfirmacionDatos.setCancelable(false);
        alertaConfirmacionDatos.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(listaMeses[listaMesesNP.getValue()].equals("enero")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();

                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoEneroBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }else if(listaMeses[listaMesesNP.getValue()].equals("febrero")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();
                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoFebreroBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }else if(listaMeses[listaMesesNP.getValue()].equals("marzo")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();
                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoMarzoBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }else if(listaMeses[listaMesesNP.getValue()].equals("abril")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();
                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoAbrilBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }else if (listaMeses[listaMesesNP.getValue()].equals("mayo")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();
                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoMayoBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }else if(listaMeses[listaMesesNP.getValue()].equals("junio")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();
                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoJunioBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }else if(listaMeses[listaMesesNP.getValue()].equals("julio")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();
                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoJulioBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }else if(listaMeses[listaMesesNP.getValue()].equals("agosto")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();
                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoAgostoBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }else if(listaMeses[listaMesesNP.getValue()].equals("septiembre")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();
                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoSeptiembreBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }else if(listaMeses[listaMesesNP.getValue()].equals("octubre")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();
                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoOctubreBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }else if(listaMeses[listaMesesNP.getValue()].equals("noviembre")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();
                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoNoviembreBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }else if(listaMeses[listaMesesNP.getValue()].equals("diciembre")){
                    String MasserBaitHaMStr = ingresoMasserBaitHaM.getText().toString();
                    double MasserBaitHaMDb = verificarDatos.valorRegistroIngresado(MasserBaitHaMStr);

                    String RoshJodeshStr = ingresoRoshJodesh.getText().toString();
                    double RoshJodeshDb = verificarDatos.valorRegistroIngresado(RoshJodeshStr);

                    String TerumahYeladimStr = ingresoTerumahYeladim.getText().toString();
                    double TerumahYeladimDb = verificarDatos.valorRegistroIngresado(TerumahYeladimStr);

                    String TerrenoStr = ingresoTerreno.getText().toString();
                    double TerrenoDb = verificarDatos.valorRegistroIngresado(TerrenoStr);

                    String ShuljanStr = ingresoShuljan.getText().toString();
                    double ShuljanDb = verificarDatos.valorRegistroIngresado(ShuljanStr);

                    String TzedaqahStr = ingresoTzedaqah.getText().toString();
                    double TzedaqahDb = verificarDatos.valorRegistroIngresado(TzedaqahStr);

                    String KaparahStr = ingresoKaparah.getText().toString();
                    double KaparahDb = verificarDatos.valorRegistroIngresado(KaparahStr);

                    String ArriendoStr = ingresoArriendo.getText().toString();
                    double ArriendoDb = verificarDatos.valorRegistroIngresado(ArriendoStr);

                    String mesAñoStr = listaAnnosStr[listaAnnosNP.getValue()];
                    String fechaRegistro = ingresoFechaRegistro.getText().toString();
                    double semanaTotal = MasserBaitHaMDb + RoshJodeshDb + TerumahYeladimDb + TerrenoDb + ShuljanDb + TzedaqahDb + KaparahDb + ArriendoDb;

                    ingresoDiciembreBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],
                            mesAñoStr,
                            usuarioComunidad.getIdUsuarioComunidad(),
                            usuarioComunidad.getNombreJaver(),
                            usuarioComunidad.getApellidoJaver(),
                            usuarioComunidad.getCedula(),
                            fechaRegistro,
                            MasserBaitHaMStr,
                            RoshJodeshStr,
                            TerumahYeladimStr,
                            TerrenoStr,
                            ShuljanStr,
                            TzedaqahStr,
                            KaparahStr,
                            ArriendoStr,
                            semanaTotal
                    );
                    ingresosHistorialBL.insertarRegistro(listaMeses[listaMesesNP.getValue()],mesAñoStr,usuarioComunidad.getNombreJaver(),usuarioComunidad.getApellidoJaver(),usuarioComunidad.getCedula(),fechaRegistro);
                    Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                    intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                    startActivity(intent);
                }
            }
        });
        alertaConfirmacionDatos.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog title= alertaConfirmacionDatos.create();
        title.setTitle("Confirmación de Información");
        title.show();

    }
    public void irIngresosDetalleUsuario(View view){
        Intent intent= new Intent(this, InformacionDetalleUsuarioCActivity.class);
        intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
        startActivity(intent);
    }
}