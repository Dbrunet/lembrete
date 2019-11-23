package tech.alvarez.note.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import tech.alvarez.note.data.db.converter.DateConverter;
import tech.alvarez.note.utils.Util;

/**
 * Entidade Note
 */

//para dar o nome a tabela
@Entity(tableName = "tb_note")
//para dizer que existe um conversor de data
@TypeConverters(DateConverter.class)
public class Note {

    //para o identificador da entidade ter um autoIncremento
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String description;
    public String color;
    public String tag;
    public Date dateAlert;

    //construtor será ignorado pelo banco
    @Ignore
    public Note() {
        this.name = "";
        this.description = "";
        this.dateAlert = null;
        this.color = "";
        this.tag = "";
    }

    public Note(String name, String description, String color, String tag, Date dateAlert) {
        this.name = name;
        this.description = description;
        this.color = color;
        this.tag = tag;
        this.dateAlert = dateAlert;
    }

    @Ignore
    public Note(long id, String name, String description, String color, String tag, Date dateAlert) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
        this.tag = tag;
        this.dateAlert = dateAlert;
    }

    public synchronized static Note[] populateData() {

        return new Note[]{

                new Note("Local 1", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 2", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 3", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 4", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 5", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 6", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 7", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 8", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 9", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 10", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 11", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 12", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 13", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 15", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 16", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 17", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 18", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 19", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 20", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 21", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 22", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 23", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 24", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 25", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 26", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 27", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 28", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 29", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 30", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 31", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 32", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 33", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 34", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 35", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 36", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 37", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 38", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 39", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 40", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 41", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 42", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 43", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 44", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 45", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 46", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 47", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 48", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 49", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 50", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 51", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 52", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 53", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 54", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 55", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 56", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 57", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 58", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 59", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 60", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 61", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 62", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 63", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 64", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 65", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 66", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 67", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 68", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 69", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 70", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 71", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 72", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 73", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 74", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 75", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 76", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 77", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 78", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 79", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 80", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 81", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 82", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 83", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 84", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 85", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 86", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 87", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 88", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 89", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 90", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 91", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 92", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 93", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 94", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 95", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 96", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 97", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 98", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 99", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),
                new Note("Local 100", "Descrição 1", String.valueOf(Util.getRandomColor()), "tag 1", new Date()),


        };
    }
}
