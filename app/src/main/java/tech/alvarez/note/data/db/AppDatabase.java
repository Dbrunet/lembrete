package tech.alvarez.note.data.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

import tech.alvarez.note.data.db.dao.NoteDao;
import tech.alvarez.note.data.db.entity.Note;
import tech.alvarez.note.utils.Util;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract NoteDao noteDao();

    //cria um singleton do banco de dados (uma instancia unica)
    public synchronized static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = getDatabase(context);
        }
        return INSTANCE;
    }

    public static AppDatabase getDatabase(final Context context) {
        //cria o banco atribuindo seu nome
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "notedb")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            //executa uma thread para uma inserção inicial
                            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                @Override
                                public void run() {
                                    getInstance(context).noteDao().insertNotes(Note.populateData());
                                }
                            });
                        }
                    })
                    .build();
    }

    //metodo não usado
    public static AppDatabase getMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    //metodo não usado
    public static void destroyInstance() {
        INSTANCE = null;
    }

}
