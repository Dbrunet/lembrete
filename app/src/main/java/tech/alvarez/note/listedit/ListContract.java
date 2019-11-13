package tech.alvarez.note.listedit;

import java.util.List;

import tech.alvarez.note.BasePresenter;
import tech.alvarez.note.BaseView;
import tech.alvarez.note.data.db.entity.Note;

public interface ListContract {

    interface Presenter extends BasePresenter {

        void addNewPerson();

        void result(int requestCode, int resultCode);

        void populatePeople();

        void openEditScreen(Note person);

        void openConfirmDeleteDialog(Note person);

        void delete(long personId);
    }

    interface View extends BaseView<ListContract.Presenter> {

        void showAddPerson();

        void setPersons(List<Note> persons);

        void showEditScreen(long id);

        void showDeleteConfirmDialog(Note person);

        void showEmptyMessage();
    }

    interface OnItemClickListener {

        void clickItem(Note person);

        void clickLongItem(Note person);
    }

    interface DeleteListener {

        void setConfirm(boolean confirm, long personId);

    }
}
