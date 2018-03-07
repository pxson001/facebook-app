package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.RadioButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: discard_draft */
public class InertRadioButton extends RadioButton {
    public InertRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InertRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InertRadioButton(Context context) {
        super(context);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Logger.a(2, EntryType.UI_INPUT_END, -757934261, Logger.a(2, EntryType.UI_INPUT_START, -646458547));
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
