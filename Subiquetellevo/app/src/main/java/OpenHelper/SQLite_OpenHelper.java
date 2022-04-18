package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.subiquetellevo.utilidades.Utilidades;

import io.grpc.okhttp.internal.Util;

public class SQLite_OpenHelper extends SQLiteOpenHelper {



    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory ,int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_PERSONA);
 //       String query1="create table Usuario(_ID integer primary key autoincrement, Correo text, Contraseña text,IDPasajero integer);";
   //        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS Persona");
        onCreate(db);
    }
    //METODO ABRIR BASE DE DATOS

    public void abrir(){
        this.getReadableDatabase();
    }

    public void cerrar(){
        this.close();
    }

    //METODO PARA INSERTAR REGISTROS EN TABLA PERSONA.

    public void insertarRegistroPersona(String nombre, String correo, String contrasenia){
        ContentValues valores = new ContentValues();
        valores.put(Utilidades.CAMPO_NOMBRE,nombre);
        valores.put(Utilidades.CAMPO_CORREO, correo);
        valores.put(Utilidades.CAMPO_CONTRASENIA,contrasenia);
        this.getWritableDatabase().insert(Utilidades.TABLA_PERSONA, null, valores);
    }



    //METODO PARA VALIDAR USUARIO EXISTENTE
    public Cursor consultarUsuarioContrasenia(String usuario, String contraseña) throws SQLiteException {
        Cursor mcursor=null;
        mcursor=this.getReadableDatabase().query(Utilidades.TABLA_PERSONA,new String[]{Utilidades.CAMPO_ID,Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_CORREO,Utilidades.CAMPO_CONTRASENIA},"Nombre like '"+usuario+"' and Contrasenia like '"+contraseña+"'",null,null,null,null);
        return mcursor;
    }

}
