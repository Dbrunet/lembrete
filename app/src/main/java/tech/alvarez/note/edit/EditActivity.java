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

    private Note person;
    private boolean mEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        person = new Note();
        checkMode();

        AppDatabase db = AppDatabase.getDatabase(getApplication());
        mPresenter = new EditPresenter(this, db.personModel());

        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mEditMode) {
            mPresenter.getPersonAndPopulate(person.id);
        }
    }

    private void checkMode() {
        if (getIntent().getExtras() != null) {
            person.id = getIntent().getLongExtra(Constants.PERSON_ID, 0);
            mEditMode = true;
        }
    }

    private void initViews() {
        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mDescriptionEditText = (EditText) findViewById(R.id.descriptionEditText);
        mTagEditText = (EditText) findViewById(R.id.tagEditText);
        mColorEditText = (EditText) findViewById(R.id.birthdayEditText);
        mDateCreateEditText = (EditText) findViewById(R.id.da);

        mNameTextInputLayout = (TextInputLayout) findViewById(R.id.nameTextInputLayout);
        mDescriptionInputLayout = (TextInputLayout) findViewById(R.id.descriptionTextInputLayout);
        mTagInputLayout = (TextInputLayout) findViewById(R.id.emailTextInputLayout);
        mDateCreateInputLayout = (TextInputLayout) findViewById(R.id.birthdayTextInputLayout);
        mColorTextInputLayout = (TextInputLayout) findViewById(R.id.phoneTextInputLayout);

        mDateCreateInputLayout.setOnClickListener(new View.OnClickListener() {
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

                person.name = mNameEditText.getText().toString();
                person.description = mDescriptionEditText.getText().toString();
                person.color = mColorEditText.getText().toString();
                person.tag = mTagEditText.getText().toString();

                boolean valid = mPresenter.validate(person);

                if (!valid) return;

                if (mEditMode) {
                    mPresenter.update(person);
                } else {
                    mPresenter.save(person);
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
        } else if (field == Constants.FIELD_EMAIL) {
            mEmailInputLayout.setError(getString(R.string.invalid_email));
        } else if (field == Constants.FIELD_PHONE) {
            mPhoneTextInputLayout.setError(getString(R.string.invalid_phone));
        } else if (field == Constants.FIELD_ADDRESS) {
            mAddressInputLayout.setError(getString(R.string.invalid_address));
        } else if (field == Constants.FIELD_BIRTHDAY) {
            mBirthdayInputLayout.setError(getString(R.string.invalid_birthday));
        }
    }

    @Override
    public void clearPreErrors() {
        mNameTextInputLayout.setErrorEnabled(false);
        mEmailInputLayout.setErrorEnabled(false);
        mPhoneTextInputLayout.setErrorEnabled(false);
        mAddressInputLayout.setErrorEnabled(false);
        mBirthdayInputLayout.setErrorEnabled(false);
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
    public void populate(Note person) {
        this.person = person;
        mNameEditText.setText(person.name);
        mAddressEditText.setText(person.address);
        mEmailEditText.setText(person.email);
        mBirthdayEditText.setText(Util.format(person.birthday));
        mPhoneEditText.setText(person.phone);
    }

    @Override
    public void setSelectedDate(Date date) {
        person.birthday = date;
        mBirthdayEditText.setText(Util.format(date));
    }
}
