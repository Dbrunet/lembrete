package tech.alvarez.note.listedit;

import java.util.List;

import tech.alvarez.note.BasePresenter;
import tech.alvarez.note.BaseView;
import tech.alvarez.note.data.db.entity.Note;

public interface ListContract {

    interface Presenter extends BasePresenter {

        void addNewNote();

        void result(int requestCode, int resultCode);

        void populateNote();

        void openEditScreen(Note note);

        void openConfirmDeleteDialog(Note note);

        void delete(long noteId);
    }

    interface View extends BaseView<ListContract.Presenter> {

        void showAddNote();

        void setNotes(List<Note> notes);

        void showEditScreen(long id);

        void showDeleteConfirmDialog(Note note);

        void showEmptyMessage();
    }

    interface OnItemClickListener {

        void clickItem(Note note);

        void clickLongItem(Note note);
    }

    interface DeleteListener {

        void setConfirm(boolean confirm, long noteId);

    }
}
