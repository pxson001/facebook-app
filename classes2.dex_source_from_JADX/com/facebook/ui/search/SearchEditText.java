package com.facebook.ui.search;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterEditTextView;
import com.google.common.base.Strings;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: reqs_succeed */
public class SearchEditText extends BetterEditTextView implements OnEditorActionListener {
    private final ResultReceiver f7443b = new ResultReceiver(this, new Handler(Looper.getMainLooper())) {
        final /* synthetic */ SearchEditText f7465a;

        protected void onReceiveResult(int i, Bundle bundle) {
            if (i == 2 || i == 0) {
                this.f7465a.f7448g.a();
            }
        }
    };
    public final Set<OnTouchListener> f7444c = new HashSet();
    @GuardedBy("this")
    @Nullable
    private InputMethodManager f7445d;
    private boolean f7446e;
    public OnSubmitListener f7447f;
    public SoftKeyboardListener f7448g;
    private String f7449h;
    private CharSequence f7450i;
    private boolean f7451j;

    /* compiled from: reqs_succeed */
    class C03152 implements OnTouchListener {
        final /* synthetic */ SearchEditText f7466a;

        C03152(SearchEditText searchEditText) {
            this.f7466a = searchEditText;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z = false;
            for (OnTouchListener onTouch : this.f7466a.f7444c) {
                z = onTouch.onTouch(view, motionEvent);
                if (z) {
                    break;
                }
            }
            return z;
        }
    }

    public SearchEditText(Context context) {
        super(context);
        m12046d();
    }

    public SearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12046d();
    }

    public SearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12046d();
    }

    private void m12046d() {
        setOnEditorActionListener(this);
        super.setOnTouchListener(new C03152(this));
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        editorInfo.imeOptions &= -1073741825;
        return onCreateInputConnection;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (m12038a(keyEvent.getKeyCode())) {
            postDelayed(new 3(this), 250);
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    private static boolean m12038a(int i) {
        return i == 4;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (!m12043b(i)) {
            return false;
        }
        m12047e();
        return true;
    }

    private static boolean m12043b(int i) {
        return i == 6 || i == 3;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!m12039a(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        m12047e();
        return true;
    }

    private boolean m12039a(int i, KeyEvent keyEvent) {
        return keyEvent.getAction() == 0 && m12045c(i);
    }

    private static boolean m12045c(int i) {
        return i == 23 || i == 66 || i == 160;
    }

    private void m12047e() {
        if (this.f7447f != null) {
            this.f7447f.a();
        }
        m12050h();
    }

    public void setOnSubmitListener(OnSubmitListener onSubmitListener) {
        this.f7447f = onSubmitListener;
    }

    public void setSoftKeyboardListener(SoftKeyboardListener softKeyboardListener) {
        this.f7448g = softKeyboardListener;
    }

    public static void m12048f(SearchEditText searchEditText) {
        searchEditText.clearFocus();
    }

    public final boolean mo1662b() {
        return m12041a(false);
    }

    private boolean m12041a(boolean z) {
        boolean z2 = requestFocus() && m12049g();
        if (!z2 && !z) {
            postDelayed(new 4(this), 100);
        } else if (z2 && this.f7451j) {
            setText(this.f7450i);
        }
        return z2;
    }

    public final void mo1663c() {
        m12050h();
    }

    public void clearFocus() {
        setFocusableInTouchMode(false);
        super.clearFocus();
        setFocusableInTouchMode(true);
        if (this.f7449h != null) {
            m12055a(this.f7450i, this.f7449h);
        }
    }

    private boolean m12049g() {
        boolean showSoftInput;
        boolean z = false;
        if (this.f7448g == null) {
            showSoftInput = getInputMethodManager().showSoftInput(this, 0);
        } else {
            showSoftInput = getInputMethodManager().showSoftInput(this, 0, this.f7443b);
        }
        if (!showSoftInput) {
            z = true;
        }
        this.f7446e = z;
        return showSoftInput;
    }

    private void m12050h() {
        getInputMethodManager().hideSoftInputFromWindow(getWindowToken(), 0);
        this.f7446e = false;
        clearFocus();
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        m12051i();
        this.f7451j = false;
        this.f7449h = null;
        this.f7450i = charSequence;
    }

    public final void mo1661a() {
        super.mo1661a();
        this.f7450i = null;
        this.f7449h = null;
        this.f7451j = false;
    }

    public final void m12055a(CharSequence charSequence, String str) {
        setText(m12037a(getContext(), charSequence, str, getHintTextColors().getDefaultColor()));
        this.f7450i = charSequence;
        this.f7449h = str;
        this.f7451j = true;
        if (this.f7450i != null) {
            setSelection(this.f7450i.length());
        }
    }

    private static CharSequence m12037a(Context context, CharSequence charSequence, String str, int i) {
        if (Strings.isNullOrEmpty(str)) {
            return charSequence;
        }
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        CharSequence string = context.getString(2131238211, new Object[]{str});
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(string);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), charSequence.length(), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    private void m12051i() {
        setSelection(getText().length());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f7446e) {
            this.f7446e = false;
            m12049g();
        }
    }

    public Editable getText() {
        if (!this.f7451j || this.f7450i == null) {
            return super.getText();
        }
        return Factory.getInstance().newEditable(this.f7450i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1083089118);
        if (motionEvent.getAction() == 0) {
            m12052j();
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -1795704185, a);
        return onTouchEvent;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        throw new UnsupportedOperationException("Use addOnTouchListener instead.");
    }

    public final void m12054a(OnTouchListener onTouchListener) {
        this.f7444c.add(onTouchListener);
    }

    public final void m12056b(OnTouchListener onTouchListener) {
        this.f7444c.remove(onTouchListener);
    }

    private void m12052j() {
        if (this.f7451j && this.f7450i != null) {
            setText(this.f7450i);
        }
    }

    private synchronized InputMethodManager getInputMethodManager() {
        if (this.f7445d == null) {
            this.f7445d = (InputMethodManager) getContext().getSystemService("input_method");
        }
        return this.f7445d;
    }
}
