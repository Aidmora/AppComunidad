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

import com.example.appcomunidad.BusinessLogic.entities.IngresosEnero;
import com.example.appcomunidad.BusinessLogic.entities.UsuarioComunidad;
import com.example.appcomunidad.BusinessLogic.managers.IngresoEneroBL;
import com.example.appcomunidad.BusinessLogic.utilities.ValidarDatos;
import com.example.appcomunidad.BusinessLogic.utilities.VerificarDatos;
import com.example.appcomunidad.R;

public class usuarioComunidadPagoDetalle extends AppCompatActivity {
    private ImageView fotoJaverInfor;
    private ImageButton botonInstrucciones;
    private EditText ingresoMasserBaitHaM, ingresoRoshJodesh, ingresoTerumahYeladim, ingresoTerreno, ingresoShuljan, ingresoTzedaqah, ingresoKaparah, ingresoArriendo, ingresoFechaRegistro;
    private TextView nombreJaverInfo, apellidoJaverInfo;
    private Button botonGuardarInfo;
    private UsuarioComunidad usuarioComunidad;
    private IngresoEneroBL ingresoEneroBL;
    private VerificarDatos verificarDatos;
    private NumberPicker listaAnnosNP;
    private String [] listaAnnosStr= {"2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_comunidad_pago_detalle);
        inicializarRecuros();
        establecerDatos();
        listaAnnosNP.setMinValue(0);
        listaAnnosNP.setMaxValue(11);
        listaAnnosNP.setDisplayedValues(listaAnnosStr);
        botonInstrucciones.setOnClickListener(this::botonInstrucciones);
        botonGuardarInfo.setOnClickListener(this::irPagoDetalleUsuario);
    }
    public void inicializarRecuros(){
        verificarDatos= new VerificarDatos(this);
        usuarioComunidad= new UsuarioComunidad();
        ingresoEneroBL= new IngresoEneroBL(this);
        fotoJaverInfor= findViewById(R.id.foto_javerInfo);
        nombreJaverInfo=findViewById(R.id.nombre_javerInfo);
        apellidoJaverInfo=findViewById(R.id.apellido_javerInfo);
        botonInstrucciones=findViewById(R.id.importanteInstrucciones);
        ingresoMasserBaitHaM=findViewById(R.id.ingresarMasserBaitHaM);
        ingresoRoshJodesh= findViewById(R.id.ingresarRoshJodesh);
        ingresoTerumahYeladim= findViewById(R.id.ingresarTerumahYeladim);
        ingresoTerreno=findViewById(R.id.ingresarTerreno);
        ingresoShuljan=findViewById(R.id.ingresarShuljan);
        ingresoTzedaqah=findViewById(R.id.ingresarTzedaqah);
        ingresoKaparah=findViewById(R.id.ingresarKaparah);
        ingresoArriendo=findViewById(R.id.ingresarArriendo);
        botonGuardarInfo= findViewById(R.id.guardarRegistros);
        listaAnnosNP=findViewById(R.id.listaAnnos);
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

                ingresoEneroBL.insertarRegistro(
                        "Enero",
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
                Toast.makeText(alertaConfirmacionDatos.getContext(),"Se han guardado los datos correctamente!!",Toast.LENGTH_SHORT).show();
                finish();
                Intent intent= new Intent(alertaConfirmacionDatos.getContext(), InformacionDetalleUsuarioCActivity.class);
                intent.putExtra("usuarioCom_seleccionado2",  usuarioComunidad);
                startActivity(intent);

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

}