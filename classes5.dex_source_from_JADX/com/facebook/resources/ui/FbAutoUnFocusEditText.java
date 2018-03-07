package com.facebook.resources.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: contacts */
public class FbAutoUnFocusEditText extends FbEditText implements OnEditorActionListener {
    private boolean f5260b;

    public FbAutoUnFocusEditText(Context context) {
        super(context);
    }

    public FbAutoUnFocusEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10164a(context, attributeSet, false, 0);
    }

    public FbAutoUnFocusEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10164a(context, attributeSet, true, i);
    }

    private void m10164a(Context context, AttributeSet attributeSet, boolean z, int i) {
        TypedArray obtainStyledAttributes = z ? context.obtainStyledAttributes(attributeSet, R.styleable.FbAutoUnFocusEditText, i, 0) : context.obtainStyledAttributes(attributeSet, R.styleable.FbAutoUnFocusEditText);
        this.f5260b = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2037154036);
        super.onAttachedToWindow();
        setOnEditorActionListener(this);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2040036540, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1389443239);
        setOnEditorActionListener(null);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -751459051, a);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && (i == 4 || i == 66)) {
            clearFocus();
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (textView == this && i == 6) {
            clearFocus();
            if (this.f5260b) {
                ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
        return false;
    }
}
