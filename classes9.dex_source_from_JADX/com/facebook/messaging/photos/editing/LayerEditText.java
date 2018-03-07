package com.facebook.messaging.photos.editing;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: displayed_page_presence_online_values */
public class LayerEditText extends EditText {
    public OnBackPressedListener f16033a;

    /* compiled from: displayed_page_presence_online_values */
    public interface OnBackPressedListener {
        void mo677a();
    }

    public LayerEditText(Context context) {
        super(context);
    }

    public LayerEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LayerEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.f16033a = onBackPressedListener;
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1039067277);
        super.onFocusChanged(z, i, rect);
        if (!z) {
            setTextIsSelectable(false);
            setFocusable(false);
            setFocusableInTouchMode(false);
            setEnabled(false);
            setClickable(false);
            setLongClickable(false);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1927157086, a);
    }

    public boolean onKeyPreIme(int i, @NonNull KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1 || this.f16033a == null) {
            return super.onKeyPreIme(i, keyEvent);
        }
        this.f16033a.mo677a();
        return true;
    }
}
