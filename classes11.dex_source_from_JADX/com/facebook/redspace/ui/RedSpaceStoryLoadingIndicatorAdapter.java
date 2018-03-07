package com.facebook.redspace.ui;

import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.widget.loadingindicator.LoadingIndicator.State;
import com.facebook.widget.loadingindicator.LoadingIndicatorAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;

/* compiled from: PRIVACY_REVIEW_CANCEL */
public class RedSpaceStoryLoadingIndicatorAdapter extends LoadingIndicatorAdapter {
    public final int f12382a;
    public LayoutParams f12383b;

    /* compiled from: PRIVACY_REVIEW_CANCEL */
    /* synthetic */ class C14631 {
        static final /* synthetic */ int[] f12381a = new int[State.values().length];

        static {
            try {
                f12381a[State.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public RedSpaceStoryLoadingIndicatorAdapter(Resources resources) {
        this.f12382a = Math.abs(resources.getDimensionPixelOffset(2131430545));
    }

    public final View m12801a(int i, ViewGroup viewGroup) {
        View a = super.a(i, viewGroup);
        this.f12383b = (LayoutParams) a.getLayoutParams();
        return a;
    }

    protected final void m12802a(@Nullable State state, LoadingIndicatorView loadingIndicatorView) {
        super.a(state, loadingIndicatorView);
        if (state != null) {
            switch (C14631.f12381a[state.ordinal()]) {
                case 1:
                    if (this.f12383b != null) {
                        this.f12383b.topMargin = this.f12382a;
                    }
                    return;
                default:
                    if (this.f12383b != null) {
                        this.f12383b.topMargin = 0;
                        return;
                    }
                    return;
            }
        }
    }
}
