package tech.alvarez.note.edit;

import java.util.Date;

import tech.alvarez.note.BasePresenter;
import tech.alvarez.note.BaseView;
import tech.alvarez.note.data.db.entity.Note;

public interface EditContract {

    interface Presenter extends BasePresenter {
        void save(Note person);

        boolean validate(Note person);

        void showDateDialog();

        void getPersonAndPopulate(long id);

        void update(Note person);
    }

    interface View extends BaseView<EditContract.Presenter> {

        void showErrorMessage(int field);

        void clearPreErrors();

        void openDateDialog();

        void close();

        void populate(Note person);
    }

    interface DateListener {

        void setSelectedDate(Date date);

    }
}
