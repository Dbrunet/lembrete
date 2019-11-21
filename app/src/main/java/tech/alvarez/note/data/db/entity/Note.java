package tech.alvarez.note.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import tech.alvarez.note.data.db.converter.DateConverter;
import tech.alvarez.note.utils.Util;

@Entity(tableName = "tb_note")
@TypeConverters(DateConverter.class)
public class Note {

    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String description;
    public String color;
    public String tag;
    public Date dateAlert;

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

    public static Note[] populateData() {
        return new Note[] {
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),
                new Note("Local 1", "Descrição 1", "tag 1", String.valueOf(Util.getRandomColor()), new Date()),



        };
    }
}
