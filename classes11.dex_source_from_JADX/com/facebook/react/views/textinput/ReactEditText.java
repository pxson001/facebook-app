package com.facebook.react.views.textinput;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.views.text.CustomStyleSpan;
import com.facebook.react.views.text.ReactTagSpan;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: REPORT_GENERIC */
public class ReactEditText extends EditText {
    public static final KeyListener f11572o = QwertyKeyListener.getInstanceForFullKeyboard();
    private final InputMethodManager f11573a;
    public boolean f11574b;
    private boolean f11575c;
    private int f11576d;
    private int f11577e;
    private int f11578f;
    @Nullable
    public ArrayList<TextWatcher> f11579g;
    @Nullable
    private TextWatcherDelegator f11580h;
    public int f11581i;
    private boolean f11582j = true;
    private boolean f11583k;
    public boolean f11584l;
    @Nullable
    public SelectionWatcher f11585m;
    private final InternalKeyListener f11586n;

    /* compiled from: REPORT_GENERIC */
    public class InternalKeyListener implements KeyListener {
        public int f11570a = 0;

        public final void m12048a(int i) {
            this.f11570a = i;
        }

        public int getInputType() {
            return this.f11570a;
        }

        public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
            return ReactEditText.f11572o.onKeyDown(view, editable, i, keyEvent);
        }

        public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
            return ReactEditText.f11572o.onKeyUp(view, editable, i, keyEvent);
        }

        public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
            return ReactEditText.f11572o.onKeyOther(view, editable, keyEvent);
        }

        public void clearMetaKeyState(View view, Editable editable, int i) {
            ReactEditText.f11572o.clearMetaKeyState(view, editable, i);
        }
    }

    /* compiled from: REPORT_GENERIC */
    class TextWatcherDelegator implements TextWatcher {
        final /* synthetic */ ReactEditText f11571a;

        public TextWatcherDelegator(ReactEditText reactEditText) {
            this.f11571a = reactEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.f11571a.f11574b && this.f11571a.f11579g != null) {
                Iterator it = this.f11571a.f11579g.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).beforeTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.f11571a.f11574b && this.f11571a.f11579g != null) {
                Iterator it = this.f11571a.f11579g.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).onTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public void afterTextChanged(Editable editable) {
            if (!this.f11571a.f11574b && this.f11571a.f11579g != null) {
                Iterator it = this.f11571a.f11579g.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).afterTextChanged(editable);
                }
            }
        }
    }

    public ReactEditText(Context context) {
        super(context);
        setFocusableInTouchMode(false);
        this.f11573a = (InputMethodManager) Assertions.b(getContext().getSystemService("input_method"));
        this.f11576d = getGravity() & 8388615;
        this.f11577e = getGravity() & 112;
        this.f11578f = 0;
        this.f11574b = false;
        this.f11575c = false;
        this.f11584l = true;
        this.f11579g = null;
        this.f11580h = null;
        this.f11581i = getInputType();
        this.f11586n = new InternalKeyListener();
    }

    public boolean isLayoutRequested() {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 66 || (getInputType() & 131072) != 0) {
            return super.onKeyUp(i, keyEvent);
        }
        m12055g();
        return true;
    }

    public void clearFocus() {
        setFocusableInTouchMode(false);
        super.clearFocus();
        m12055g();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (isFocused()) {
            return true;
        }
        if (!this.f11575c) {
            return false;
        }
        setFocusableInTouchMode(true);
        boolean requestFocus = super.requestFocus(i, rect);
        m12054f();
        return requestFocus;
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        if (this.f11579g == null) {
            this.f11579g = new ArrayList();
            super.addTextChangedListener(getTextWatcherDelegator());
        }
        this.f11579g.add(textWatcher);
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        if (this.f11579g != null) {
            this.f11579g.remove(textWatcher);
            if (this.f11579g.isEmpty()) {
                this.f11579g = null;
                super.removeTextChangedListener(getTextWatcherDelegator());
            }
        }
    }

    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.f11585m != null && hasFocus()) {
            this.f11585m.mo323a(i, i2);
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1637399900);
        super.onFocusChanged(z, i, rect);
        if (z && this.f11585m != null) {
            this.f11585m.mo323a(getSelectionStart(), getSelectionEnd());
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1883698654, a);
    }

    public void setSelectionWatcher(SelectionWatcher selectionWatcher) {
        this.f11585m = selectionWatcher;
    }

    public void setBlurOnSubmit(boolean z) {
        this.f11584l = z;
    }

    public boolean getBlurOnSubmit() {
        return this.f11584l;
    }

    int getStagedInputType() {
        return this.f11581i;
    }

    void setStagedInputType(int i) {
        this.f11581i = i;
    }

    final void m12056a() {
        if (getInputType() != this.f11581i) {
            setInputType(this.f11581i);
        }
    }

    public void setInputType(int i) {
        Typeface typeface = super.getTypeface();
        super.setInputType(i);
        this.f11581i = i;
        super.setTypeface(typeface);
        this.f11586n.f11570a = i;
        setKeyListener(this.f11586n);
    }

    public void setTextIsSelectable(boolean z) {
        this.f11582j = z;
        super.setTextIsSelectable(z);
    }

    public final void m12058b() {
        this.f11575c = true;
        requestFocus();
        this.f11575c = false;
    }

    final void m12059c() {
        clearFocus();
    }

    public final int m12060d() {
        int i = this.f11578f + 1;
        this.f11578f = i;
        return i;
    }

    public final void m12057a(ReactTextUpdate reactTextUpdate) {
        if (reactTextUpdate.f11547b >= this.f11578f) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(reactTextUpdate.f11546a);
            m12049a(spannableStringBuilder);
            this.f11583k = reactTextUpdate.f11548c;
            this.f11574b = true;
            getText().replace(0, length(), spannableStringBuilder);
            this.f11574b = false;
        }
    }

    private void m12049a(SpannableStringBuilder spannableStringBuilder) {
        int i = 0;
        Object[] spans = getText().getSpans(0, length(), Object.class);
        while (i < spans.length) {
            if (ForegroundColorSpan.class.isInstance(spans[i]) || BackgroundColorSpan.class.isInstance(spans[i]) || AbsoluteSizeSpan.class.isInstance(spans[i]) || CustomStyleSpan.class.isInstance(spans[i]) || ReactTagSpan.class.isInstance(spans[i])) {
                getText().removeSpan(spans[i]);
            }
            if ((getText().getSpanFlags(spans[i]) & 33) == 33) {
                Object obj = spans[i];
                int spanStart = getText().getSpanStart(spans[i]);
                int spanEnd = getText().getSpanEnd(spans[i]);
                int spanFlags = getText().getSpanFlags(spans[i]);
                getText().removeSpan(spans[i]);
                if (m12050a(getText(), spannableStringBuilder, spanStart, spanEnd)) {
                    spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                }
            }
            i++;
        }
    }

    private static boolean m12050a(Editable editable, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        if (i > spannableStringBuilder.length() || i2 > spannableStringBuilder.length()) {
            return false;
        }
        while (i < i2) {
            if (editable.charAt(i) != spannableStringBuilder.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean m12054f() {
        return this.f11573a.showSoftInput(this, 0);
    }

    private void m12055g() {
        this.f11573a.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private TextWatcherDelegator getTextWatcherDelegator() {
        if (this.f11580h == null) {
            this.f11580h = new TextWatcherDelegator(this);
        }
        return this.f11580h;
    }

    void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.f11576d;
        }
        setGravity(((getGravity() & -8) & -8388616) | i);
    }

    void setGravityVertical(int i) {
        if (i == 0) {
            i = this.f11577e;
        }
        setGravity((getGravity() & -113) | i);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        int i = 0;
        if (this.f11583k && (getText() instanceof Spanned)) {
            Spanned text = getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                if (textInlineImageSpanArr[i].mo317a() == drawable) {
                    return true;
                }
                i++;
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        int i = 0;
        if (this.f11583k && (getText() instanceof Spanned)) {
            Spanned text = getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                if (textInlineImageSpanArr[i].mo317a() == drawable) {
                    invalidate();
                }
                i++;
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onDetachedFromWindow() {
        int i = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -722712408);
        super.onDetachedFromWindow();
        if (this.f11583k && (getText() instanceof Spanned)) {
            Spanned text = getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].mo319b();
                i++;
            }
        }
        LogUtils.g(-776997778, a);
    }

    public void onStartTemporaryDetach() {
        int i = 0;
        super.onStartTemporaryDetach();
        if (this.f11583k && (getText() instanceof Spanned)) {
            Spanned text = getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].mo320c();
                i++;
            }
        }
    }

    public void onAttachedToWindow() {
        int i = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1536873527);
        super.onAttachedToWindow();
        if (this.f11583k && (getText() instanceof Spanned)) {
            Spanned text = getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].mo321d();
                i++;
            }
        }
        LogUtils.g(1112628646, a);
    }

    public void onFinishTemporaryDetach() {
        int i = 0;
        super.onFinishTemporaryDetach();
        if (this.f11583k && (getText() instanceof Spanned)) {
            Spanned text = getText();
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].mo322e();
                i++;
            }
        }
    }
}
