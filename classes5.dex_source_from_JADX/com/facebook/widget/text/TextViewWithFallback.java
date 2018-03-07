package com.facebook.widget.text;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;

/* compiled from: com.facebook.fragment.POP_EXIT_ANIM */
public class TextViewWithFallback extends FbTextView {
    public CharSequence f5887a;

    public TextViewWithFallback(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setFallbackText(CharSequence charSequence) {
        this.f5887a = charSequence;
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1044267839);
        super.onMeasure(i, i2);
        if (getLineCount() > 1 && !this.f5887a.toString().equals(getText().toString())) {
            setText(this.f5887a);
            super.onMeasure(i, i2);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1368487732, a);
    }
}
