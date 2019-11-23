package tech.alvarez.note.listedit;

import java.util.List;

import tech.alvarez.note.BasePresenter;
import tech.alvarez.note.BaseView;
import tech.alvarez.note.data.db.entity.Note;

public interface ListContract {

    //Presenter - cuida das validações e controle dos dados via banco de dados para a view. É
    //usado pela classe Presenter
    interface Presenter extends BasePresenter {

        void addNewNote();

        void populateNote();

        void openEditScreen(Note note);

        void openConfirmDeleteDialog(Note note);

        void delete(long noteId);
    }

    //View - tudo ligado a interface. É implementado pela Activity
    interface View extends BaseView<ListContract.Presenter> {

        void showAddNote();

        void setNotes(List<Note> notes);

        void showEditScreen(long id);

        void showDeleteConfirmDialog(Note note);

        void showEmptyMessage();
    }

    //Metodos usados para evendos de click
    interface OnItemClickListener {

        void clickItem(Note note);

        void clickLongItem(Note note);
    }

    //metodo usado para confirmação de remoção
    interface DeleteListener {

        void setConfirm(boolean confirm, long noteId);

    }
}
