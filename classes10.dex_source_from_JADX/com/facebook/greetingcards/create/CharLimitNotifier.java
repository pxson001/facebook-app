package com.facebook.greetingcards.create;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

/* compiled from: {post_id} */
public class CharLimitNotifier implements TextWatcher {
    private final int f45a;
    private final String f46b;
    private final EditText f47c;
    private final Context f48d;
    private Toast f49e;

    public CharLimitNotifier(Context context, EditText editText, int i, String str) {
        this.f48d = context;
        this.f47c = editText;
        this.f45a = i;
        this.f46b = str;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (editable.length() > this.f45a) {
            if (this.f49e != null) {
                this.f49e.cancel();
            }
            this.f49e = Toast.makeText(this.f48d, this.f46b, 0);
            this.f49e.setGravity(17, 0, 0);
            this.f49e.show();
            int selectionEnd = this.f47c.getSelectionEnd();
            this.f47c.setText(this.f47c.getText().subSequence(0, this.f45a));
            this.f47c.setSelection(Math.min(this.f45a, selectionEnd));
        }
    }
}
