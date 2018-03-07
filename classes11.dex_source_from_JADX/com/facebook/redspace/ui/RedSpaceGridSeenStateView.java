package com.facebook.redspace.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitFragmentModel;
import com.facebook.ui.animations.BaseAnimatorListener;
import com.facebook.ui.animations.SpringAnimator;
import com.facebook.widget.CustomFrameLayout;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: PRIVACY_REVIEW_WRITE_SUCCESS */
public class RedSpaceGridSeenStateView extends CustomFrameLayout {
    private static final CallerContext f12326a = CallerContext.a(RedSpaceGridSeenStateView.class, "red_space_grid");
    private List<FbDraweeView> f12327b;
    private View f12328c;
    public TextView f12329d;
    private AnimatorSet f12330e;
    private List<Animator> f12331f;

    /* compiled from: PRIVACY_REVIEW_WRITE_SUCCESS */
    class C14571 extends BaseAnimatorListener {
        final /* synthetic */ RedSpaceGridSeenStateView f12325a;

        C14571(RedSpaceGridSeenStateView redSpaceGridSeenStateView) {
            this.f12325a = redSpaceGridSeenStateView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f12325a.f12329d.setVisibility(8);
        }

        public void onAnimationStart(@Nullable Animator animator) {
            this.f12325a.f12329d.setVisibility(0);
        }
    }

    public RedSpaceGridSeenStateView(Context context) {
        super(context);
        m12751a();
    }

    public RedSpaceGridSeenStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12751a();
    }

    public RedSpaceGridSeenStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12751a();
    }

    private void m12751a() {
        setContentView(2130906780);
        this.f12327b = new ArrayList();
        this.f12327b.add((FbDraweeView) c(2131566877));
        this.f12327b.add((FbDraweeView) c(2131566878));
        this.f12327b.add((FbDraweeView) c(2131566879));
        this.f12328c = c(2131566880);
        this.f12329d = (TextView) c(2131566881);
        this.f12331f = new ArrayList(this.f12327b.size() + 1);
    }

    public final void m12754a(List<RedSpaceVisitFragmentModel> list, int i) {
        int i2 = 8;
        boolean a = m12752a(i);
        this.f12331f.clear();
        for (int i3 = 0; i3 < this.f12327b.size(); i3++) {
            int i4;
            FbDraweeView fbDraweeView = (FbDraweeView) this.f12327b.get(i3);
            if (i3 < list.size()) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            fbDraweeView.setVisibility(i4);
            if (i3 < list.size()) {
                fbDraweeView.a(Uri.parse(((RedSpaceVisitFragmentModel) list.get(i3)).j().j().b()), f12326a);
                if (a) {
                    this.f12331f.add(m12749a(fbDraweeView, true, i3 * 200));
                }
            }
        }
        View view = this.f12328c;
        if (list.size() > this.f12327b.size()) {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (a) {
            this.f12329d.setText(getResources().getQuantityString(2131689634, i, new Object[]{Integer.valueOf(i)}));
            if (list.size() > this.f12327b.size()) {
                this.f12331f.add(m12749a(this.f12328c, true, this.f12327b.size() * 200));
            }
            new AnimatorSet().playTogether(this.f12331f);
            this.f12330e = new AnimatorSet();
            this.f12330e.playSequentially(new Animator[]{m12753b(), r0});
            this.f12330e.start();
        }
    }

    private AnimatorSet m12753b() {
        this.f12331f.clear();
        this.f12331f.add(m12749a(this.f12329d, true, 0));
        this.f12331f.add(m12749a(this.f12329d, false, 1000));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(this.f12331f);
        animatorSet.addListener(new C14571(this));
        return animatorSet;
    }

    private boolean m12752a(int i) {
        return i > 0 && (this.f12330e == null || !this.f12330e.isStarted());
    }

    private static Animator m12749a(View view, boolean z, int i) {
        float f = 1.0f;
        if (z) {
            view.setAlpha(0.0f);
        }
        float f2 = z ? 0.0f : 1.0f;
        if (!z) {
            f = 0.0f;
        }
        SpringAnimator a = SpringAnimator.a(view, "scaleX", f2, f);
        SpringAnimator a2 = SpringAnimator.a(view, "scaleY", f2, f);
        SpringAnimator a3 = SpringAnimator.a(view, "alpha", f2, f);
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{a, a2, a3});
        animatorSet.setStartDelay((long) i);
        return animatorSet;
    }
}
