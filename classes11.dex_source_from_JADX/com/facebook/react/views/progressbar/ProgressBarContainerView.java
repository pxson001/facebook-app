package com.facebook.react.views.progressbar;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import javax.annotation.Nullable;

/* compiled from: Reset Content */
public class ProgressBarContainerView extends FrameLayout {
    @Nullable
    public Integer f11483a;
    public boolean f11484b = true;
    public boolean f11485c = true;
    public double f11486d;
    @Nullable
    private ProgressBar f11487e;

    public ProgressBarContainerView(Context context) {
        super(context);
    }

    public final void m11906a(@Nullable String str) {
        this.f11487e = ReactProgressBarViewManager.m11916a(getContext(), ReactProgressBarViewManager.m11915a(str));
        this.f11487e.setMax(1000);
        removeAllViews();
        addView(this.f11487e, new LayoutParams(-1, -1));
    }

    public final void m11905a(@Nullable Integer num) {
        this.f11483a = num;
    }

    public final void m11907a(boolean z) {
        this.f11484b = z;
    }

    public final void m11904a(double d) {
        this.f11486d = d;
    }

    public final void m11908b(boolean z) {
        this.f11485c = z;
    }

    public final void m11903a() {
        if (this.f11487e == null) {
            throw new JSApplicationIllegalArgumentException("setStyle() not called");
        }
        this.f11487e.setIndeterminate(this.f11484b);
        m11902a(this.f11487e);
        this.f11487e.setProgress((int) (this.f11486d * 1000.0d));
        if (this.f11485c) {
            this.f11487e.setVisibility(0);
        } else {
            this.f11487e.setVisibility(8);
        }
    }

    private void m11902a(ProgressBar progressBar) {
        Drawable indeterminateDrawable;
        if (progressBar.isIndeterminate()) {
            indeterminateDrawable = progressBar.getIndeterminateDrawable();
        } else {
            indeterminateDrawable = progressBar.getProgressDrawable();
        }
        if (indeterminateDrawable != null) {
            if (this.f11483a != null) {
                indeterminateDrawable.setColorFilter(this.f11483a.intValue(), Mode.SRC_IN);
            } else {
                indeterminateDrawable.clearColorFilter();
            }
        }
    }
}
