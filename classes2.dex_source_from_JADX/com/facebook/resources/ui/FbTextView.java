package com.facebook.resources.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: sim_country */
public class FbTextView extends FbResourcesTextView {
    private boolean f4758a = false;

    public FbTextView(Context context) {
        super(context);
    }

    public FbTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FbTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = this.f4758a && getVisibility() == 0;
        mo2813a(z);
    }

    protected void onAttachedToWindow() {
        boolean z = true;
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 115317600);
        super.onAttachedToWindow();
        this.f4758a = true;
        if (getVisibility() != 0) {
            z = false;
        }
        mo2813a(z);
        LogUtils.g(-2049096741, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 696275721);
        super.onDetachedFromWindow();
        this.f4758a = false;
        mo2813a(false);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -400404299, a);
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        boolean z = false;
        mo2813a(false);
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        if (this.f4758a && getVisibility() == 0) {
            z = true;
        }
        mo2813a(z);
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        boolean z = false;
        mo2813a(false);
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        if (this.f4758a && getVisibility() == 0) {
            z = true;
        }
        mo2813a(z);
    }

    private void mo2813a(boolean z) {
        for (Drawable drawable : getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setVisible(z, false);
            }
        }
    }
}
