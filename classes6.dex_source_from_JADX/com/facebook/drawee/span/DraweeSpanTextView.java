package com.facebook.drawee.span;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: object_tracking_data */
public class DraweeSpanTextView extends BetterTextView {
    public DraweeSpanStringBuilder f8892a;
    public boolean f8893b = false;

    public DraweeSpanTextView(Context context) {
        super(context);
    }

    public DraweeSpanTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DraweeSpanTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1822698873);
        super.onAttachedToWindow();
        this.f8893b = true;
        if (this.f8892a != null) {
            this.f8892a.m12684a(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1453411180, a);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f8893b = true;
        if (this.f8892a != null) {
            this.f8892a.m12684a(this);
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1016064172);
        this.f8893b = false;
        if (this.f8892a != null) {
            this.f8892a.m12686b(this);
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1063532413, a);
    }

    public void onStartTemporaryDetach() {
        this.f8893b = false;
        if (this.f8892a != null) {
            this.f8892a.m12686b(this);
        }
        super.onStartTemporaryDetach();
    }

    public final void m12687b() {
        if (this.f8892a != null) {
            this.f8892a.m12686b(this);
        }
        this.f8892a = null;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m12687b();
    }
}
