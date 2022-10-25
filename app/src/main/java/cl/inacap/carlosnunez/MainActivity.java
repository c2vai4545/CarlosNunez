package cl.inacap.carlosnunez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import cl.inacap.carlosnunez.modelo.Jugador;
import cl.inacap.carlosnunez.modelo.ListaJugadores;

public class MainActivity extends AppCompatActivity {

    private ListaJugadores listaJugadores= ListaJugadores.getInstancia();
    private ArrayList<Jugador> jugadores=listaJugadores.getListaJugadores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ver_lista=(Button) findViewById(R.id.ver_lista);
        ver_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(jugadores.size()>0) {
                    Intent intent = new Intent(MainActivity.this, ListaJugadoresActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "La lista está vacía", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button botonNuevo=(Button) findViewById(R.id.botonNuevo);
        botonNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, NuevoJugadorActivity.class);
                startActivity(intent);
            }
        });

        Button botonEliminar=(Button) findViewById(R.id.botonEliminar);
        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaJugadores.eliminarInactivos();
                Toast.makeText(MainActivity.this, "Se han eliminado todos los jugadores inactivos", Toast.LENGTH_SHORT).show();
            }
        });

    }
}