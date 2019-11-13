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
        if (person.address.isEmpty()) {
            mView.showErrorMessage(Constants.FIELD_ADDRESS);
            return false;
        }
        if (person.phone.isEmpty() || !Util.isValidPhone(person.phone)) {
            mView.showErrorMessage(Constants.FIELD_PHONE);
            return false;
        }
        if (person.email.isEmpty() || !Util.isValidEmail(person.email)) {
            mView.showErrorMessage(Constants.FIELD_EMAIL);
            return false;
        }
        if (person.birthday == null) {
            mView.showErrorMessage(Constants.FIELD_BIRTHDAY);
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
