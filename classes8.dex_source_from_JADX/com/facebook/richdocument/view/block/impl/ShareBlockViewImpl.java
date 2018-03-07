package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.presenter.ShareBlockPresenter;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.block.ShareBlockView;
import com.facebook.richdocument.view.widget.ScalableImageWithTextView;
import com.facebook.springs.SpringConfig;
import com.facebook.widget.springbutton.TouchSpring;
import com.facebook.widget.springbutton.TouchSpring.TouchSpringUpdateListener;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: page_context_item_type */
public class ShareBlockViewImpl extends AbstractBlockView<ShareBlockPresenter> implements ShareBlockView, TouchSpringUpdateListener {
    @Inject
    public Provider<TouchSpring> f6788a;
    @Inject
    public HamViewUtils f6789b;
    private final float f6790c = 0.8f;
    private final float f6791d = 1.0f;
    private final double f6792e = 15.0d;
    private final double f6793f = 5.0d;
    @Nullable
    public TouchSpring f6794g;
    public final FrameLayout f6795h;
    private ScalableImageWithTextView f6796i;

    /* compiled from: page_context_item_type */
    class C07621 implements OnTouchListener {
        final /* synthetic */ ShareBlockViewImpl f6787a;

        C07621(ShareBlockViewImpl shareBlockViewImpl) {
            this.f6787a = shareBlockViewImpl;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f6787a.f6794g != null && this.f6787a.f6794g.onTouch(view, motionEvent);
        }
    }

    public static void m7088a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ShareBlockViewImpl shareBlockViewImpl = (ShareBlockViewImpl) obj;
        Provider a = IdBasedProvider.a(fbInjector, 3736);
        HamViewUtils a2 = HamViewUtils.m5278a(fbInjector);
        shareBlockViewImpl.f6788a = a;
        shareBlockViewImpl.f6789b = a2;
    }

    public ShareBlockViewImpl(View view) {
        super(view);
        Class cls = ShareBlockViewImpl.class;
        m7088a(this, getContext());
        this.f6789b.m5280a(view, 0, 2131558728);
        this.f6795h = (FrameLayout) view.findViewById(2131567043);
        this.f6796i = (ScalableImageWithTextView) view.findViewById(2131563024);
        this.f6795h.setOnTouchListener(new C07621(this));
        this.f6794g = (TouchSpring) this.f6788a.get();
        this.f6794g.b = 0.8f;
        this.f6794g.c = 1.0f;
        this.f6794g.a(SpringConfig.b(15.0d, 5.0d));
        this.f6794g.a(this);
        BlockViewUtil.m6919a(this.f6796i.getDrawable(), getContext().getResources().getColor(2131363470));
    }

    public boolean isPressed() {
        return iY_().isPressed();
    }

    public boolean performClick() {
        return iY_().performClick();
    }

    public final void m7089a(float f) {
        this.f6796i.setScaleX(f);
        this.f6796i.setScaleY(f);
    }
}
