package com.facebook.instantshopping.presenter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.instantshopping.logging.InstantShoppingElementDwellTimeLogger;
import com.facebook.instantshopping.logging.InstantShoppingLoggingUtils;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.data.InstantShoppingSlideshowBlockData;
import com.facebook.instantshopping.model.data.impl.InstantShoppingSlideshowBlockDataImpl;
import com.facebook.instantshopping.view.block.InstantShoppingSlideshowBlockView;
import com.facebook.instantshopping.view.block.impl.InstantShoppingSlideshowBlockViewImpl;
import com.facebook.instantshopping.view.widget.InstantShoppingSlideshowView;
import com.facebook.instantshopping.view.widget.slideup.SlideshowIndicatorPlugin;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.PresenterUtils;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory.StrategyType;
import javax.inject.Inject;

/* compiled from: STORY_EDGE_NARROW_OR_AGG */
public class InstantShoppingSlideshowBlockPresenter extends AbstractBlockPresenter<InstantShoppingSlideshowBlockView, InstantShoppingSlideshowBlockData> {
    @Inject
    public InstantShoppingLoggingUtils f23677d;
    @Inject
    public InstantShoppingElementDwellTimeLogger f23678e;
    @Inject
    public Lazy<RichDocumentInfo> f23679f;
    private LoggingParams f23680g;

    public static void m25005a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        InstantShoppingSlideshowBlockPresenter instantShoppingSlideshowBlockPresenter = (InstantShoppingSlideshowBlockPresenter) obj;
        InstantShoppingLoggingUtils a = InstantShoppingLoggingUtils.m24879a(injectorLike);
        InstantShoppingElementDwellTimeLogger a2 = InstantShoppingElementDwellTimeLogger.m24873a(injectorLike);
        Lazy a3 = IdBasedLazy.a(injectorLike, 10295);
        instantShoppingSlideshowBlockPresenter.f23677d = a;
        instantShoppingSlideshowBlockPresenter.f23678e = a2;
        instantShoppingSlideshowBlockPresenter.f23679f = a3;
    }

    public final void m25007a(BlockData blockData) {
        InstantShoppingSlideshowBlockDataImpl instantShoppingSlideshowBlockDataImpl = (InstantShoppingSlideshowBlockDataImpl) blockData;
        Bundle a = PresenterUtils.a(instantShoppingSlideshowBlockDataImpl);
        InstantShoppingSlideshowBlockViewImpl instantShoppingSlideshowBlockViewImpl = (InstantShoppingSlideshowBlockViewImpl) this.d;
        if (instantShoppingSlideshowBlockDataImpl.nA_()) {
            a.putString("strategyType", StrategyType.NON_ADJUSTED_FIT_TO_WIDTH_SLIDE.name());
        }
        instantShoppingSlideshowBlockViewImpl.f23781n = instantShoppingSlideshowBlockDataImpl.mo1012b();
        ((InstantShoppingSlideshowBlockViewImpl) this.d).a(a);
        instantShoppingSlideshowBlockViewImpl.f23780m = instantShoppingSlideshowBlockDataImpl.nx_();
        this.f23680g = instantShoppingSlideshowBlockDataImpl.mo1008C();
        instantShoppingSlideshowBlockViewImpl = (InstantShoppingSlideshowBlockViewImpl) this.d;
        RichDocumentBlocksImpl a2 = instantShoppingSlideshowBlockDataImpl.a();
        instantShoppingSlideshowBlockViewImpl.a(BlockViewUtil.a(instantShoppingSlideshowBlockDataImpl.m()));
        SlideshowIndicatorPlugin slideshowIndicatorPlugin = instantShoppingSlideshowBlockViewImpl.f23779l;
        int c = a2.c();
        slideshowIndicatorPlugin.f23959a.setCount(c > 1 ? c : 0);
        slideshowIndicatorPlugin.f23959a.setMaxCircles(c);
        slideshowIndicatorPlugin.f23959a.setCurrentItem(0);
        ((InstantShoppingSlideshowView) instantShoppingSlideshowBlockViewImpl.c()).setInstantShoppingSlides(a2);
        int i = instantShoppingSlideshowBlockDataImpl.f23649b;
        if (i != -1) {
            instantShoppingSlideshowBlockViewImpl = (InstantShoppingSlideshowBlockViewImpl) this.d;
            instantShoppingSlideshowBlockViewImpl.c().setBackground(new ColorDrawable(i));
            instantShoppingSlideshowBlockViewImpl.a.setOverlayBackgroundColor(i);
        }
        PresenterUtils.a(this.d, instantShoppingSlideshowBlockDataImpl, ((RichDocumentInfo) this.f23679f.get()).g, instantShoppingSlideshowBlockDataImpl.iQ_());
    }

    public InstantShoppingSlideshowBlockPresenter(InstantShoppingSlideshowBlockViewImpl instantShoppingSlideshowBlockViewImpl) {
        super(instantShoppingSlideshowBlockViewImpl);
        Class cls = InstantShoppingSlideshowBlockPresenter.class;
        m25005a(this, getContext());
    }

    public final void m25006a(Bundle bundle) {
        super.a(bundle);
        if (this.f23680g != null) {
            this.f23677d.m24884b("slideshow_element_start", this.f23680g.toString());
            this.f23678e.m24876a(this.f23680g.toString());
        }
    }

    public final void m25008b(Bundle bundle) {
        super.b(bundle);
        if (this.f23680g != null) {
            this.f23677d.m24884b("slideshow_element_end", this.f23680g.toString());
            this.f23678e.m24877b(this.f23680g.toString());
        }
    }
}
