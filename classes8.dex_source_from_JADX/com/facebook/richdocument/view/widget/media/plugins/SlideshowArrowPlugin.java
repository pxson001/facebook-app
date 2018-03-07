package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.facebook.android.maps.internal.ValueAnimator;
import com.facebook.android.maps.internal.ValueAnimator.AnimatorUpdateListener;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.widget.SlideshowView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Inject;

/* compiled from: num_friends_you_may_invite */
public class SlideshowArrowPlugin extends BaseMediaFramePlugin<Void> {
    @Inject
    public HamDimensions f7640a;
    protected final SlideshowView f7641b;
    public final ImageView f7642c = ((ImageView) this.f7646g.findViewById(2131563263));
    private final int f7643d = this.f7640a.m5276b(2131558650);
    public final ValueAnimator f7644e = ValueAnimator.a(0.0f, 1.0f);
    public final int f7645f = Math.round(TypedValue.applyDimension(1, (float) RichDocumentUIConfig.f6563p, getContext().getResources().getDisplayMetrics()));
    private final View f7646g = m7893g();

    /* compiled from: num_friends_you_may_invite */
    class C08861 implements AnimatorUpdateListener {
        final /* synthetic */ SlideshowArrowPlugin f7697a;

        C08861(SlideshowArrowPlugin slideshowArrowPlugin) {
            this.f7697a = slideshowArrowPlugin;
        }

        public final void m7980a(ValueAnimator valueAnimator) {
            double d = (double) this.f7697a.f7645f;
            this.f7697a.f7642c.setTranslationX((float) ((int) Math.round(Math.sin((((double) valueAnimator.C) * 3.141592653589793d) * 2.0d) * d)));
        }
    }

    /* compiled from: num_friends_you_may_invite */
    class C08872 extends OnScrollListener {
        final /* synthetic */ SlideshowArrowPlugin f7698a;

        C08872(SlideshowArrowPlugin slideshowArrowPlugin) {
            this.f7698a = slideshowArrowPlugin;
        }

        public final void m7981a(RecyclerView recyclerView, int i, int i2) {
            this.f7698a.mo511a(i);
            if (this.f7698a.f7642c.getAlpha() == 0.0f && this.f7698a.f7644e.e()) {
                this.f7698a.f7644e.d();
            } else if (this.f7698a.f7642c.getAlpha() > 0.0f && !this.f7698a.f7644e.e()) {
                this.f7698a.f7644e.c();
            }
        }
    }

    public static void m7917a(Object obj, Context context) {
        ((SlideshowArrowPlugin) obj).f7640a = HamDimensions.m5268a(FbInjector.get(context));
    }

    public SlideshowArrowPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        Class cls = SlideshowArrowPlugin.class;
        m7917a(this, getContext());
        this.f7644e.a(new LinearInterpolator());
        this.f7644e.x = -1;
        this.f7644e.a((long) RichDocumentUIConfig.f6562o);
        this.f7644e.A = this.f7642c;
        this.f7644e.a(new C08861(this));
        this.f7641b = (SlideshowView) this.f7617a.getMediaView().getView();
        this.f7641b.a(new C08872(this));
    }

    protected void mo511a(int i) {
        if (((LinearLayoutManager) this.f7641b.getLayoutManager()).l() == 0) {
            m7921b(this.f7641b.getChildAt(0).getLeft() * -1);
        } else {
            m7918a();
        }
    }

    protected final void m7921b(int i) {
        this.f7642c.setAlpha(Math.max(0.0f, 1.0f - (((float) i) / ((float) (this.f7646g.getWidth() / 2)))));
        this.f7646g.requestLayout();
    }

    protected final void m7918a() {
        if (this.f7642c.getAlpha() > 0.0f) {
            this.f7642c.setAlpha(0.0f);
            this.f7646g.requestLayout();
        }
    }

    public final void mo509d() {
        this.f7644e.c();
    }

    public final void mo510e() {
        this.f7644e.d();
    }

    public final void mo504a(ViewLayout viewLayout) {
        Rect rect = BaseMediaFramePlugin.m7881a(viewLayout, m7895i()).f7004a;
        int width = (rect.width() - this.f7642c.getMeasuredWidth()) - this.f7643d;
        int height = ((rect.height() / 2) + rect.top) - (this.f7642c.getMeasuredHeight() / 2);
        this.f7617a.m7802a(this.f7642c, new Rect(width, height, this.f7642c.getMeasuredWidth() + width, this.f7642c.getMeasuredHeight() + height));
    }
}
