package com.facebook.widget.text;

import android.content.Context;
import android.widget.TextView.BufferType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: com.facebook.fragment.PUSH_BACK_STACK */
public class SpanSafeTextView extends BetterTextView {
    public SpanSafeTextView(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -712104663);
        try {
            super.onMeasure(i, i2);
        } catch (ArrayIndexOutOfBoundsException e) {
            setText(getText().toString());
            super.onMeasure(i, i2);
        }
        LogUtils.g(1563509419, a);
    }

    public void setGravity(int i) {
        try {
            super.setGravity(i);
        } catch (ArrayIndexOutOfBoundsException e) {
            setText(getText().toString());
            super.setGravity(i);
        }
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        try {
            super.setText(charSequence, bufferType);
        } catch (ArrayIndexOutOfBoundsException e) {
            setText(charSequence.toString());
        }
    }
}
