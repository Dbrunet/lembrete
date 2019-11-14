package tech.alvarez.note.edit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

import tech.alvarez.note.R;
import tech.alvarez.note.data.db.AppDatabase;
import tech.alvarez.note.data.db.entity.Note;
import tech.alvarez.note.utils.Constants;
import tech.alvarez.note.utils.Util;

public class EditActivity extends AppCompatActivity implements EditContract.View, EditContract.DateListener {

    private EditContract.Presenter mPresenter;

    private EditText mNameEditText;
    private EditText mDescriptionEditText;
    private EditText mColorEditText;
    private EditText mDateCreateEditText;
    private EditText mTagEditText;

    private TextInputLayout mNameTextInputLayout;
    private TextInputLayout mDescriptionInputLayout;
    private TextInputLayout mTagInputLayout;
    private TextInputLayout mDateCreateInputLayout;
    private TextInputLayout mColorTextInputLayout;

    private FloatingActionButton mFab;

    private Note note;
    private boolean mEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        note = new Note();
        checkMode();

        AppDatabase db = AppDatabase.getDatabase(getApplication());
        mPresenter = new EditPresenter(this, db.personModel());

        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mEditMode) {
            mPresenter.getPersonAndPopulate(note.id);
        }
    }

    private void checkMode() {
        if (getIntent().getExtras() != null) {
            note.id = getIntent().getLongExtra(Constants.PERSON_ID, 0);
            mEditMode = true;
        }
    }

    private void initViews() {
        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mDescriptionEditText = (EditText) findViewById(R.id.descriptionEditText);
        mTagEditText = (EditText) findViewById(R.id.tagEditText);
        mColorEditText = (EditText) findViewById(R.id.tagEditText);
        mDateCreateEditText = (EditText) findViewById(R.id.dateCreateEditText);

        mNameTextInputLayout = (TextInputLayout) findViewById(R.id.nameTextInputLayout);
        mDescriptionInputLayout = (TextInputLayout) findViewById(R.id.descriptionTextInputLayout);
        mTagInputLayout = (TextInputLayout) findViewById(R.id.tagTextInputLayout);
        mDateCreateInputLayout = (TextInputLayout) findViewById(R.id.dateCreateTextInputLayout);
        mColorTextInputLayout = (TextInputLayout) findViewById(R.id.colorTextInputLayout);

        mDateCreateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.showDateDialog();
            }
        });

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setImageResource(mEditMode ? R.drawable.ic_refresh : R.drawable.ic_done);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                note.name = mNameEditText.getText().toString();
                note.description = mDescriptionEditText.getText().toString();
                note.color = mColorEditText.getText().toString();
                note.tag = mTagEditText.getText().toString();

                boolean valid = mPresenter.validate(note);

                if (!valid) return;

                if (mEditMode) {
                    mPresenter.update(note);
                } else {
                    mPresenter.save(note);
                }
            }
        });
    }

    @Override
    public void setPresenter(EditContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showErrorMessage(int field) {
        if (field == Constants.FIELD_NAME) {
            mNameTextInputLayout.setError(getString(R.string.invalid_name));
        } else if (field == Constants.FIELD_DESCRIPTION) {
            mDescriptionInputLayout.setError(getString(R.string.invalid_email));
        } else if (field == Constants.FIELD_TAG) {
            mTagInputLayout.setError(getString(R.string.invalid_phone));
        } else if (field == Constants.FIELD_COLOR) {
            mColorTextInputLayout.setError(getString(R.string.invalid_address));
        } else if (field == Constants.FIELD_DATE) {
            mDateCreateInputLayout.setError(getString(R.string.invalid_birthday));
        }
    }

    @Override
    public void clearPreErrors() {
        mNameTextInputLayout.setErrorEnabled(false);
        mDescriptionInputLayout.setErrorEnabled(false);
        mTagInputLayout.setErrorEnabled(false);
        mColorTextInputLayout.setErrorEnabled(false);
        mDateCreateInputLayout.setErrorEnabled(false);
    }

    @Override
    public void openDateDialog() {
        DateDialogFragment fragment = new DateDialogFragment();
        fragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void close() {
        finish();
    }

    @Override
    public void populate(Note note) {
        this.note = note;
        mNameEditText.setText(note.name);
        mDescriptionEditText.setText(note.description);
        mColorEditText.setText(note.color);
        mDateCreateEditText.setText(Util.format(note.dateCreate));
        mTagEditText.setText(note.tag);
    }

    @Override
    public void setSelectedDate(Date date) {
        note.dateCreate = date;
        mDateCreateEditText.setText(Util.format(date));
    }
}
