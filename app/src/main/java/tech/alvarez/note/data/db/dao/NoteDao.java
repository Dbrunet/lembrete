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


    @Query("SELECT * FROM Note ORDER BY name ASC")
    LiveData<List<Note>> findAllPersons();

    @Query("SELECT * FROM Note")
    List<Note> getAllChannels();

    @Query("SELECT * FROM Note WHERE id=:id")
    Note findPersonById(String id);

    @Query("SELECT * FROM Note WHERE id=:id")
    Note findPerson(long id);

    @Insert(onConflict = IGNORE)
    long insertPerson(Note person);

    @Update
    int updatePerson(Note person);

    @Update
    void updatePerson(List<Note> people);

    @Delete
    void deletePerson(Note person);

    @Query("DELETE FROM Note")
    void deleteAll();
}
