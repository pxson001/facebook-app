package com.facebook.pager.renderers.standard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: risk_flow_exit_confirm_dialog_fragment_tag */
public abstract class PagerViewItem<T> extends CustomFrameLayout {
    private boolean f4779a;

    public abstract void mo163a();

    public abstract void mo164a(ViewGroup viewGroup, T t, int i, float f, float f2, float f3, boolean z);

    public abstract void mo165a(boolean z);

    public abstract void mo166b();

    public abstract void mo167e();

    public PagerViewItem(Context context) {
        this(context, null);
    }

    private PagerViewItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private PagerViewItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setIsInViewport(boolean z) {
        if (z != this.f4779a) {
            this.f4779a = z;
            if (this.f4779a) {
                mo166b();
            } else {
                mo167e();
            }
        }
    }

    public boolean getIsInViewport() {
        return this.f4779a;
    }
}
