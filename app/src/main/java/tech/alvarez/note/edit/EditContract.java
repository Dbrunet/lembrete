package tech.alvarez.note.edit;

import java.util.Date;

import tech.alvarez.note.BasePresenter;
import tech.alvarez.note.BaseView;
import tech.alvarez.note.data.db.entity.Note;

/**
 * Interface de View e Presenter
 */
public interface EditContract {

    //Presenter - cuida das validações e controle dos dados via banco de dados para a view. É
    //implementado pela classe Presenter
    interface Presenter extends BasePresenter {
        void save(Note note);

        boolean validate(Note note);

        void showDateDialog();

        void getNoteAndPopulate(long id);

        void update(Note note);
    }

    //View - tudo ligado a interface. É implementado pela Activity
    interface View extends BaseView<EditContract.Presenter> {

        void showErrorMessage(int field);

        void clearPreErrors();

        void openDateDialog();

        void close();

        void populate(Note note);
    }

    interface DateListener {

        void setSelectedDate(Date date);

    }
}
