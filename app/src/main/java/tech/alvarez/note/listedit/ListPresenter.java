package tech.alvarez.note.listedit;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;

import tech.alvarez.note.data.db.dao.NoteDao;
import tech.alvarez.note.data.db.entity.Note;

public class ListPresenter implements ListContract.Presenter {

    private final ListContract.View mView;
    private final NoteDao noteDao;

    public ListPresenter(ListContract.View view, NoteDao noteDao) {
        this.mView = view;
        this.mView.setPresenter(this);
        this.noteDao = noteDao;
    }

    @Override
    public void start() {

    }

    @Override
    public void addNewPerson() {
        mView.showAddPerson();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void populatePeople() {
        noteDao.findAllPersons().observeForever(new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> persons) {
                mView.setPersons(persons);
                if (persons == null || persons.size() < 1) {
                    mView.showEmptyMessage();
                }
            }
        });
    }

    @Override
    public void openEditScreen(Note person) {
        mView.showEditScreen(person.id);
    }

    @Override
    public void openConfirmDeleteDialog(Note person) {
        mView.showDeleteConfirmDialog(person);
    }

    @Override
    public void delete(long personId) {
        Note person = noteDao.findPerson(personId);
        noteDao.deletePerson(person);
    }
}
