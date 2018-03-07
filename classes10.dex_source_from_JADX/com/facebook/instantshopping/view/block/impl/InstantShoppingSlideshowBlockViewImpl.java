package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.facebook.inject.FbInjector;
import com.facebook.instantshopping.abtest.ExperimentsForInstantShoppingAbtestModule;
import com.facebook.instantshopping.view.transition.InstantShoppingTransitionStrategyFactory;
import com.facebook.instantshopping.view.widget.slideup.SlideshowIndicatorPlugin;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.view.block.SlideshowBlockView;
import com.facebook.richdocument.view.block.impl.SlideshowBlockViewImpl;
import com.facebook.richdocument.view.transition.AbstractTransitionStrategy;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory.StrategyType;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.plugins.InstantShoppingSlideshowArrowPlugin;
import javax.inject.Inject;

/* compiled from: STARTS_DISABLED */
public class InstantShoppingSlideshowBlockViewImpl extends SlideshowBlockViewImpl implements SlideshowBlockView {
    @Inject
    public InstantShoppingTransitionStrategyFactory f23776d;
    @Inject
    public QeAccessor f23777j;
    private InstantShoppingSlideshowArrowPlugin f23778k;
    public SlideshowIndicatorPlugin f23779l;
    public boolean f23780m;
    public boolean f23781n;

    public static void m25070a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        InstantShoppingSlideshowBlockViewImpl instantShoppingSlideshowBlockViewImpl = (InstantShoppingSlideshowBlockViewImpl) obj;
        InstantShoppingTransitionStrategyFactory b = InstantShoppingTransitionStrategyFactory.m25135b(fbInjector);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        instantShoppingSlideshowBlockViewImpl.f23776d = b;
        instantShoppingSlideshowBlockViewImpl.f23777j = qeAccessor;
    }

    public InstantShoppingSlideshowBlockViewImpl(MediaFrame mediaFrame, View view, ImageView imageView) {
        super(mediaFrame, view, imageView);
        Class cls = InstantShoppingSlideshowBlockViewImpl.class;
        m25070a(this, getContext());
    }

    public final void m25072a(Bundle bundle) {
        super.a(bundle);
        if (this.f23780m) {
            this.f23778k.c();
        }
        this.f23779l.c();
    }

    protected final void m25073a(MediaFrame mediaFrame) {
        if (this.f23780m) {
            this.f23778k = new InstantShoppingSlideshowArrowPlugin(mediaFrame);
            a(this.f23778k);
        }
        this.f23779l = new SlideshowIndicatorPlugin(mediaFrame);
        a(this.f23779l);
    }

    protected final AbstractTransitionStrategy m25071a(MediaFrame mediaFrame, StrategyType strategyType, boolean z) {
        InstantShoppingTransitionStrategyFactory instantShoppingTransitionStrategyFactory = this.f23776d;
        Context context = getContext();
        boolean z2 = this.f23781n && this.f23777j.a(ExperimentsForInstantShoppingAbtestModule.r, false);
        return instantShoppingTransitionStrategyFactory.m25137a(strategyType, context, mediaFrame, z, z2, false);
    }
}
