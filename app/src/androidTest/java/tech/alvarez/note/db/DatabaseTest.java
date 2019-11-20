package tech.alvarez.note.db;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import tech.alvarez.note.data.db.AppDatabase;
import tech.alvarez.note.data.db.dao.NoteDao;
import tech.alvarez.note.data.db.entity.Note;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private NoteDao mPersonDao;
    private AppDatabase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mPersonDao = mDb.noteModel();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {

        mDb.noteModel().deleteAll();

        List<Note> notes = mPersonDao.getAllChannels();
        assertThat(notes.size(), equalTo(0));

        Note person = addPerson(mDb, 1, "Name 1", "Address 1", "111111", Calendar.getInstance().getTime());
        addPerson(mDb, 2, "Name 2", "Address 2", "22222", Calendar.getInstance().getTime());
        addPerson(mDb, 3, "Name 3", "Address 3", "33333", Calendar.getInstance().getTime());

        notes = mPersonDao.getAllChannels();
        assertThat(notes.size(), equalTo(3));
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    private static Note addPerson(final AppDatabase db, final long id, final String name,
                                  final String address, final String phone, final Date birthday) {
        Note note = new Note();
        note.id = id;
        note.name = name;
        db.noteModel().insertNote(note);
        return note;
    }

}
