package com.facebook.feedback.ui;

import android.text.TextWatcher;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: rotation must be multiple of 90 degree */
public class ProgressiveMentionAutocompleteEditTextHelper {
    public final AtomicBoolean f4651a = new AtomicBoolean(false);
    public EditText f4652b;
    public MentionsAutoCompleteTextView f4653c;
    public OnFocusChangeListener f4654d;
    public TextWatcher f4655e;
    public TagTypeaheadDataSource f4656f;
    public TaggingProfile f4657g;
    public Long f4658h;

    public ProgressiveMentionAutocompleteEditTextHelper(EditText editText) {
        if (editText instanceof MentionsAutoCompleteTextView) {
            this.f4651a.set(true);
            this.f4653c = (MentionsAutoCompleteTextView) editText;
            return;
        }
        this.f4652b = editText;
    }

    public final EditText m5188a() {
        if (this.f4651a.get()) {
            return this.f4653c;
        }
        return this.f4652b;
    }

    public final String m5189c() {
        if (this.f4651a.get()) {
            return this.f4653c.getEncodedText();
        }
        return this.f4652b.getEditableText().toString();
    }
}
