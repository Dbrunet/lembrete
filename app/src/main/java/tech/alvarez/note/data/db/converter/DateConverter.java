package tech.alvarez.note.data.db.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Classe para conversão de data do banco de dados Room
 */
public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}