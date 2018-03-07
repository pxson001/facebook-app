package com.facebook.devicebasedlogin.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.resources.ui.FbEditText;

/* compiled from: permissions_friends_header */
public class PinCodeView extends FrameLayout {
    public FbEditText f6670a;
    public FbEditText f6671b;
    public FbEditText f6672c;
    public FbEditText f6673d;
    public EditText f6674e;
    public PasscodeViewListener f6675f;
    public PasswordTransformationMethod f6676g;
    public boolean f6677h = false;

    /* compiled from: permissions_friends_header */
    class C06861 implements TextWatcher {
        final /* synthetic */ PinCodeView f6669a;

        C06861(PinCodeView pinCodeView) {
            this.f6669a = pinCodeView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            m6973a(0, editable, this.f6669a.f6670a);
            m6973a(1, editable, this.f6669a.f6671b);
            m6973a(2, editable, this.f6669a.f6672c);
            m6973a(3, editable, this.f6669a.f6673d);
            if (editable.length() == 4) {
                this.f6669a.f6675f.mo1134a(editable.toString());
            }
        }

        private void m6973a(int i, Editable editable, TextView textView) {
            int length = editable.length();
            if (length > i) {
                textView.setText(editable.subSequence(i, i + 1));
            } else {
                textView.setText("");
            }
            PinCodeView.m6977b(textView, false);
            if (this.f6669a.f6677h) {
                textView.setTransformationMethod(this.f6669a.f6676g);
            }
            if (length == i) {
                PinCodeView.m6977b(textView, true);
            }
        }
    }

    public PinCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130906241, this, true);
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        this.f6670a = (FbEditText) linearLayout.getChildAt(0);
        this.f6671b = (FbEditText) linearLayout.getChildAt(1);
        this.f6672c = (FbEditText) linearLayout.getChildAt(2);
        this.f6673d = (FbEditText) linearLayout.getChildAt(3);
        this.f6674e = (EditText) getChildAt(1);
        this.f6674e.addTextChangedListener(m6980e());
        m6977b(this.f6670a, true);
        this.f6676g = new PasswordTransformationMethod();
    }

    public void setPasscodeViewListener(PasscodeViewListener passcodeViewListener) {
        this.f6675f = passcodeViewListener;
    }

    private TextWatcher m6980e() {
        return new C06861(this);
    }

    public String getText() {
        return this.f6674e.getText().toString();
    }

    public EditText getEditText() {
        return this.f6674e;
    }

    public final void m6984a() {
        this.f6677h = true;
    }

    public final void m6985b() {
        this.f6670a.setText("");
        this.f6671b.setText("");
        this.f6672c.setText("");
        this.f6673d.setText("");
        this.f6674e.setText("");
    }

    public final void m6986c() {
        this.f6670a.setVisibility(4);
        this.f6671b.setVisibility(4);
        this.f6672c.setVisibility(4);
        this.f6673d.setVisibility(4);
    }

    public final void m6987d() {
        this.f6670a.setVisibility(0);
        this.f6671b.setVisibility(0);
        this.f6672c.setVisibility(0);
        this.f6673d.setVisibility(0);
        m6977b(this.f6670a, true);
    }

    public static void m6977b(TextView textView, boolean z) {
        if (VERSION.SDK_INT >= 11) {
            textView.setActivated(z);
        }
    }
}
