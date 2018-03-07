package com.facebook.instantshopping.presenter;

import android.content.Context;
import android.os.Bundle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.logging.InstantShoppingElementDwellTimeLogger;
import com.facebook.instantshopping.logging.InstantShoppingLoggingUtils;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.data.LinkableMediaSection;
import com.facebook.instantshopping.model.data.MediaHasOverlay;
import com.facebook.instantshopping.model.data.impl.InstantShoppingImageBlockDataImpl;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.utils.GridUtils;
import com.facebook.instantshopping.view.block.impl.LinkableImageBlockViewImpl;
import com.facebook.instantshopping.view.block.impl.LinkableImageBlockViewImpl.C34161;
import com.facebook.instantshopping.view.transition.GridMediaTransitionStrategy;
import com.facebook.instantshopping.view.transition.InstantShoppingExpandedOnlytransitionStrategy;
import com.facebook.instantshopping.view.widget.media.AnimatingGlyphPlugin.GlyphType;
import com.facebook.richdocument.model.data.ImageBlockData;
import com.facebook.richdocument.presenter.ImageBlockPresenter;
import com.facebook.richdocument.view.block.impl.ImageBlockViewImpl;
import com.facebook.richdocument.view.widget.RichDocumentImageView;
import javax.inject.Inject;

/* compiled from: STOPPING */
public class LinkableImageBlockPresenter extends ImageBlockPresenter {
    @Inject
    public InstantShoppingLoggingUtils f23688g;
    @Inject
    public InstantShoppingElementDwellTimeLogger f23689h;
    private LoggingParams f23690i;
    private LinkableImageBlockViewImpl f23691j;

    public static void m25018a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        LinkableImageBlockPresenter linkableImageBlockPresenter = (LinkableImageBlockPresenter) obj;
        InstantShoppingLoggingUtils a = InstantShoppingLoggingUtils.m24879a(injectorLike);
        InstantShoppingElementDwellTimeLogger a2 = InstantShoppingElementDwellTimeLogger.m24873a(injectorLike);
        linkableImageBlockPresenter.f23688g = a;
        linkableImageBlockPresenter.f23689h = a2;
    }

    public LinkableImageBlockPresenter(ImageBlockViewImpl imageBlockViewImpl) {
        super(imageBlockViewImpl);
        Class cls = LinkableImageBlockPresenter.class;
        m25018a(this, getContext());
    }

    public void mo1026a(ImageBlockData imageBlockData) {
        InstantShoppingImageBlockDataImpl instantShoppingImageBlockDataImpl = (InstantShoppingImageBlockDataImpl) imageBlockData;
        this.f23691j = (LinkableImageBlockViewImpl) this.d;
        this.f23691j.f23816t = instantShoppingImageBlockDataImpl.mo1012b();
        super.a(instantShoppingImageBlockDataImpl);
        if ((this.d instanceof LinkableImageBlockViewImpl) && (instantShoppingImageBlockDataImpl instanceof LinkableMediaSection)) {
            this.f23690i = instantShoppingImageBlockDataImpl.mo1008C();
            LinkableImageBlockViewImpl linkableImageBlockViewImpl = this.f23691j;
            InstantShoppingActionFragmentModel x = instantShoppingImageBlockDataImpl.mo1020x();
            boolean nv_ = instantShoppingImageBlockDataImpl.nv_();
            LoggingParams loggingParams = this.f23690i;
            linkableImageBlockViewImpl.mo1032a(loggingParams);
            if (x != null) {
                linkableImageBlockViewImpl.f23812p.m25208a(GlyphType.LINK);
                linkableImageBlockViewImpl.f23815s = x.iG_();
            }
            if (nv_) {
                linkableImageBlockViewImpl.f23812p.m25208a(GlyphType.EXPANDABLE);
            }
            ((RichDocumentImageView) linkableImageBlockViewImpl.h()).setOnClickListener(new C34161(linkableImageBlockViewImpl, x, loggingParams, nv_));
            if (instantShoppingImageBlockDataImpl instanceof MediaHasOverlay) {
                linkableImageBlockViewImpl = this.f23691j;
                if (instantShoppingImageBlockDataImpl.nw_()) {
                    linkableImageBlockViewImpl.f23814r.f23932a.setVisibility(0);
                }
            }
            int B = instantShoppingImageBlockDataImpl.mo1000B();
            LinkableImageBlockViewImpl linkableImageBlockViewImpl2 = this.f23691j;
            if (linkableImageBlockViewImpl2.a.getTransitionStrategy() instanceof GridMediaTransitionStrategy) {
                ((GridMediaTransitionStrategy) linkableImageBlockViewImpl2.a.getTransitionStrategy()).f23847a = 4 / GridUtils.a(B);
            }
            linkableImageBlockViewImpl = this.f23691j;
            boolean F = instantShoppingImageBlockDataImpl.mo1011F();
            if (linkableImageBlockViewImpl.a.getTransitionStrategy() instanceof InstantShoppingExpandedOnlytransitionStrategy) {
                ((InstantShoppingExpandedOnlytransitionStrategy) linkableImageBlockViewImpl.a.getTransitionStrategy()).f23849a = F;
            }
            this.f23691j.mo1032a(this.f23690i);
            boolean nx_ = instantShoppingImageBlockDataImpl.nx_();
            linkableImageBlockViewImpl2 = this.f23691j;
            if (!nx_) {
                linkableImageBlockViewImpl2.f23812p.m25208a(GlyphType.HIDDEN);
            }
            this.f23691j.a(instantShoppingImageBlockDataImpl.mo1019v(), this.d.bD_(), this.d.a());
        }
    }

    public final void m25019a(Bundle bundle) {
        LinkableImageBlockViewImpl linkableImageBlockViewImpl = this.f23691j;
        boolean z = bundle.getBoolean("isTiltToPanGlyphShown");
        if (LinkableImageBlockViewImpl.m25099n(linkableImageBlockViewImpl) && linkableImageBlockViewImpl.f23813q != null) {
            linkableImageBlockViewImpl.f23813q.f23950f = z;
        }
        super.a(bundle);
        this.f23688g.m24884b("image_element_start", this.f23690i.toString());
        this.f23689h.m24876a(this.f23690i.toString());
    }

    public final void m25022b(Bundle bundle) {
        super.b(bundle);
        this.f23688g.m24884b("image_element_end", this.f23690i.toString());
        this.f23689h.m24877b(this.f23690i.toString());
        String str = "isTiltToPanGlyphShown";
        LinkableImageBlockViewImpl linkableImageBlockViewImpl = this.f23691j;
        boolean z = linkableImageBlockViewImpl.f23813q != null && linkableImageBlockViewImpl.f23813q.f23950f;
        bundle.putBoolean(str, z);
    }
}
