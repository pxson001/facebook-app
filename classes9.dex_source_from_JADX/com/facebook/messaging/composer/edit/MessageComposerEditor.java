package com.facebook.messaging.composer.edit;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import com.facebook.inject.Assisted;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.widget.text.BetterEditTextView;
import javax.inject.Inject;

/* compiled from: messenger_pay/ */
public class MessageComposerEditor {
    public final EmojiUtil f9785a;
    public final InputMethodManager f9786b;
    public final BetterEditTextView f9787c;

    @Inject
    public MessageComposerEditor(EmojiUtil emojiUtil, InputMethodManager inputMethodManager, @Assisted BetterEditTextView betterEditTextView) {
        this.f9785a = emojiUtil;
        this.f9786b = inputMethodManager;
        this.f9787c = betterEditTextView;
    }

    public final void m10358a(CharSequence charSequence) {
        this.f9787c.setText(charSequence);
    }

    public final Editable m10355a() {
        return this.f9787c.getText();
    }

    public final void m10357a(TextWatcher textWatcher) {
        this.f9787c.addTextChangedListener(textWatcher);
    }

    public final void m10356a(int i) {
        if (i >= 0 && i <= this.f9787c.length()) {
            this.f9787c.setSelection(i);
        }
    }

    public final boolean m10359a(int i, int i2) {
        return this.f9785a.a(this.f9787c.getText(), (int) this.f9787c.getTextSize(), i, i2);
    }

    public final void m10360d() {
        if (this.f9787c.getText().length() > 0) {
            this.f9787c.setText("");
        }
    }
}
