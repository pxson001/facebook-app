package com.facebook.katana.common;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.common.util.StringUtil;

/* compiled from: p2p_pin_entered */
public class SoftKeyboardHelper {
    public final void m7835a(TextEnteredListener textEnteredListener, Context context, EditText editText, String str) {
        final EditText editText2 = editText;
        final Context context2 = context;
        final String str2 = str;
        final TextEnteredListener textEnteredListener2 = textEnteredListener;
        editText.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ SoftKeyboardHelper f7552e;

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 || textView != editText2) {
                    return true;
                }
                boolean z;
                SoftKeyboardHelper softKeyboardHelper = this.f7552e;
                String obj = editText2.getText().toString();
                SoftKeyboardHelper softKeyboardHelper2 = this.f7552e;
                if (StringUtil.a(obj)) {
                    z = false;
                } else {
                    z = true;
                }
                if (Boolean.valueOf(z).booleanValue()) {
                    textEnteredListener2.m7836a(obj);
                    return true;
                }
                Toast.makeText(context2, str2, 1).show();
                editText2.setText("");
                return false;
            }
        });
    }
}
