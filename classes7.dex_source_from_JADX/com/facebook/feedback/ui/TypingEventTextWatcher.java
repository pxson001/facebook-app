package com.facebook.feedback.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: rotate */
public class TypingEventTextWatcher implements TextWatcher {
    private final TextEventsListener f4781a;
    public boolean f4782b = true;

    /* compiled from: rotate */
    public interface TextEventsListener {
        void mo241a(CharSequence charSequence, int i, int i2, int i3);

        void mo254o();

        void mo255p();

        void mo256q();
    }

    public TypingEventTextWatcher(TextEventsListener textEventsListener) {
        this.f4781a = textEventsListener;
    }

    public void afterTextChanged(Editable editable) {
        if (this.f4782b && this.f4781a != null) {
            this.f4781a.mo256q();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f4782b && this.f4781a != null) {
            if (charSequence.length() != 0 || i != 0 || i2 != 0 || i3 != 0) {
                if (charSequence.length() == 0) {
                    this.f4781a.mo255p();
                    this.f4781a.mo254o();
                    return;
                }
                this.f4781a.mo241a(charSequence, i, i2, i3);
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
