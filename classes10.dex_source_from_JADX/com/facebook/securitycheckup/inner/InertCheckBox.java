package com.facebook.securitycheckup.inner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.CheckBox;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: impression_id */
public class InertCheckBox extends CheckBox {
    public InertCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InertCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InertCheckBox(Context context) {
        super(context);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Logger.a(2, EntryType.UI_INPUT_END, 1413113179, Logger.a(2, EntryType.UI_INPUT_START, -957261446));
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return false;
    }
}
