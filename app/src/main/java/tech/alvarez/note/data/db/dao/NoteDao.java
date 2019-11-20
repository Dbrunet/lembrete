package tech.alvarez.note.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import tech.alvarez.note.data.db.entity.Note;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface NoteDao {


    @Query("SELECT * FROM tb_note ORDER BY name ASC")
    LiveData<List<Note>> findAllNotes();

    @Query("SELECT * FROM tb_note")
    List<Note> getAllChannels();

    @Query("SELECT * FROM tb_note WHERE id=:id")
    Note findNoteById(String id);

    @Query("SELECT * FROM tb_note WHERE id=:id")
    Note findNote(long id);

    @Insert(onConflict = IGNORE)
    long insertNote(Note note);

    @Update
    int updateNote(Note note);

    @Update
    void updateNote(List<Note> notes);

    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM tb_note")
    void deleteAll();
}
