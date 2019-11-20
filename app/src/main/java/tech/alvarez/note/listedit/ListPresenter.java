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
    public void addNewNote() {
        mView.showAddNote();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void populateNote() {
        noteDao.findAllNotes().observeForever(new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                mView.setNotes(notes);
                if (notes == null || notes.size() < 1) {
                    mView.showEmptyMessage();
                }
            }
        });
    }

    @Override
    public void openEditScreen(Note note) {
        mView.showEditScreen(note.id);
    }

    @Override
    public void openConfirmDeleteDialog(Note note) {
        mView.showDeleteConfirmDialog(note);
    }

    @Override
    public void delete(long noteId) {
        Note note = noteDao.findNote(noteId);
        noteDao.deleteNote(note);
    }
}
