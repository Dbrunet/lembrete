package tech.alvarez.note.edit;

import tech.alvarez.note.data.db.dao.NoteDao;
import tech.alvarez.note.data.db.entity.Note;
import tech.alvarez.note.utils.Constants;
import tech.alvarez.note.utils.Util;

public class EditPresenter implements EditContract.Presenter {

    private final EditContract.View mView;
    private final NoteDao personDao;

    public EditPresenter(EditContract.View mMainView, NoteDao personDao) {
        this.mView = mMainView;
        this.mView.setPresenter(this);
        this.personDao = personDao;
    }

    @Override
    public void start() {

    }

    @Override
    public void save(Note person) {
        long ids = this.personDao.insertPerson(person);
        mView.close();
    }

    @Override
    public boolean validate(Note person) {
        mView.clearPreErrors();
        if (person.name.isEmpty() || !Util.isValidName(person.name)) {
            mView.showErrorMessage(Constants.FIELD_NAME);
            return false;
        }
        if (person.description.isEmpty()) {
            mView.showErrorMessage(Constants.FIELD_DESCRIPTION);
            return false;
        }
        if (person.tag.isEmpty() ) {
            mView.showErrorMessage(Constants.FIELD_TAG);
            return false;
        }
        if (person.color.isEmpty()) {
            mView.showErrorMessage(Constants.FIELD_COLOR);
            return false;
        }
        if (person.dateCreate == null) {
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
        Note person = personDao.findPerson(id);
        if (person != null) {
            mView.populate(person);
        }
    }

    @Override
    public void update(Note person) {
        int ids = this.personDao.updatePerson(person);
        mView.close();
    }
}
