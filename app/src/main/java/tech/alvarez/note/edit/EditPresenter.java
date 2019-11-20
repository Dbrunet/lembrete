package tech.alvarez.note.edit;

import tech.alvarez.note.data.db.dao.NoteDao;
import tech.alvarez.note.data.db.entity.Note;
import tech.alvarez.note.utils.Constants;
import tech.alvarez.note.utils.Util;

public class EditPresenter implements EditContract.Presenter {

    private final EditContract.View mView;
    private final NoteDao noteDao;

    public EditPresenter(EditContract.View mMainView, NoteDao noteDao) {
        this.mView = mMainView;
        this.mView.setPresenter(this);
        this.noteDao = noteDao;
    }

    @Override
    public void start() {

    }

    @Override
    public void save(Note note) {
        long ids = this.noteDao.insertNote(note);
        mView.close();
    }

    @Override
    public boolean validate(Note note) {
        mView.clearPreErrors();
        if (note.name.isEmpty() || !Util.isValidName(note.name)) {
            mView.showErrorMessage(Constants.FIELD_NAME);
            return false;
        }
        if (note.description.isEmpty()) {
            mView.showErrorMessage(Constants.FIELD_DESCRIPTION);
            return false;
        }
        if (note.tag.isEmpty() ) {
            mView.showErrorMessage(Constants.FIELD_TAG);
            return false;
        }
        if (note.color.isEmpty()) {
            mView.showErrorMessage(Constants.FIELD_COLOR);
            return false;
        }
        if (note.dateAlert == null) {
            mView.showErrorMessage(Constants.FIELD_DATE);
            return false;
        }

        return true;
    }

    @Override
    public void showDateDialog() {
        mView.openDateDialog();
    }

    @Override
    public void getPersonAndPopulate(long id) {
        Note note = noteDao.findNote(id);
        if (note != null) {
            mView.populate(note);
        }
    }

    @Override
    public void update(Note note) {
        int ids = this.noteDao.updateNote(note);
        mView.close();
    }
}
