package com.facebook.redspace.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.pagerindicator.SwipeImagePageIndicator;
import com.facebook.ui.statusbar.StatusBarUtil;
import com.facebook.ultralight.Inject;
import com.google.common.base.Preconditions;

/* compiled from: PROCESS_LOCATION */
public class RedSpaceFeedVerticalScrollHelper {
    public SwipeImagePageIndicator f12298a;
    private int f12299b;
    public int f12300c;
    public int f12301d;
    public int f12302e;

    /* compiled from: PROCESS_LOCATION */
    public interface HasFeedScrollListener {
        OnFeedScrolledListener mo348c();

        void mo349d();
    }

    /* compiled from: PROCESS_LOCATION */
    public abstract class OnFeedScrolledListener extends OnScrollListener {
        public abstract void mo347a(int i);

        public final void m12731a(RecyclerView recyclerView, int i, int i2) {
            mo347a(i2);
        }
    }

    public static RedSpaceFeedVerticalScrollHelper m12732a(InjectorLike injectorLike) {
        return new RedSpaceFeedVerticalScrollHelper(StatusBarUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RedSpaceFeedVerticalScrollHelper(StatusBarUtil statusBarUtil, Resources resources) {
        int dimension = (int) resources.getDimension(2131430581);
        int dimension2 = (int) resources.getDimension(2131430545);
        this.f12300c = (dimension - ((int) resources.getDimension(2131430579))) - (VERSION.SDK_INT >= 19 ? statusBarUtil.a(null) : 0);
        this.f12301d = this.f12300c / 2;
        this.f12302e = dimension + dimension2;
    }

    public final void m12734a(int i) {
        Preconditions.checkNotNull(this.f12298a, "The indicator needs to be set up. Please call setIndicator(...) beforehand.");
        if (this.f12299b != i) {
            m12733c();
        }
        this.f12299b = i;
    }

    public final void m12735b() {
        Preconditions.checkNotNull(this.f12298a, "The indicator needs to be set up. Please call setIndicator(...) beforehand.");
        m12733c();
    }

    private void m12733c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f12298a, "translationY", new float[]{0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f12298a.f12154f, "alpha", new float[]{1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(200);
        animatorSet.start();
    }
}
