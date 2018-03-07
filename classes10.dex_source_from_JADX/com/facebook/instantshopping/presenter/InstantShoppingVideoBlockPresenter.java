package com.facebook.instantshopping.presenter;

import android.content.Context;
import android.os.Bundle;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.logging.InstantShoppingElementDwellTimeLogger;
import com.facebook.instantshopping.logging.InstantShoppingLoggingUtils;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.data.impl.InstantShoppingVideoBlockDataImpl;
import com.facebook.instantshopping.view.block.impl.InstantShoppingVideoBlockViewImpl;
import com.facebook.instantshopping.view.widget.media.AnimatingGlyphPlugin.GlyphType;
import com.facebook.richdocument.model.data.VideoBlockData;
import com.facebook.richdocument.presenter.VideoBlockPresenter;
import com.facebook.richdocument.view.block.impl.VideoBlockViewImpl;
import javax.inject.Inject;

/* compiled from: STOREFRONT_FETCH */
public class InstantShoppingVideoBlockPresenter extends VideoBlockPresenter {
    @Inject
    public InstantShoppingLoggingUtils f23685f;
    @Inject
    public InstantShoppingElementDwellTimeLogger f23686g;
    private LoggingParams f23687h;

    public static void m25013a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        InstantShoppingVideoBlockPresenter instantShoppingVideoBlockPresenter = (InstantShoppingVideoBlockPresenter) obj;
        InstantShoppingLoggingUtils a = InstantShoppingLoggingUtils.m24879a(injectorLike);
        InstantShoppingElementDwellTimeLogger a2 = InstantShoppingElementDwellTimeLogger.m24873a(injectorLike);
        instantShoppingVideoBlockPresenter.f23685f = a;
        instantShoppingVideoBlockPresenter.f23686g = a2;
    }

    public InstantShoppingVideoBlockPresenter(VideoBlockViewImpl videoBlockViewImpl) {
        super(videoBlockViewImpl);
        Class cls = InstantShoppingVideoBlockPresenter.class;
        m25013a(this, getContext());
    }

    public final void m25016a(VideoBlockData videoBlockData) {
        boolean z = true;
        InstantShoppingVideoBlockDataImpl instantShoppingVideoBlockDataImpl = (InstantShoppingVideoBlockDataImpl) videoBlockData;
        InstantShoppingVideoBlockViewImpl instantShoppingVideoBlockViewImpl = (InstantShoppingVideoBlockViewImpl) this.d;
        instantShoppingVideoBlockViewImpl.f23797m = instantShoppingVideoBlockDataImpl.mo1012b();
        instantShoppingVideoBlockViewImpl.f23801q = instantShoppingVideoBlockDataImpl.ny_();
        instantShoppingVideoBlockViewImpl.m25093h(instantShoppingVideoBlockDataImpl.f23658b);
        ((VideoBlockViewImpl) this.d).l = false;
        super.a(instantShoppingVideoBlockDataImpl);
        this.f23687h = instantShoppingVideoBlockDataImpl.mo1008C();
        boolean nx_ = instantShoppingVideoBlockDataImpl.nx_();
        instantShoppingVideoBlockViewImpl.f23799o = nx_;
        if (!nx_) {
            instantShoppingVideoBlockViewImpl.f23798n.m25208a(GlyphType.HIDDEN);
        }
        this.f23687h = instantShoppingVideoBlockDataImpl.mo1008C();
        nx_ = instantShoppingVideoBlockDataImpl.m() == GraphQLDocumentMediaPresentationStyle.FULL_SCREEN;
        if (instantShoppingVideoBlockViewImpl.f23799o) {
            instantShoppingVideoBlockViewImpl.f23798n.m25208a(nx_ ? GlyphType.TILT_TO_PAN : GlyphType.EXPANDABLE);
            if (!instantShoppingVideoBlockViewImpl.m25083E()) {
                instantShoppingVideoBlockViewImpl.f23798n.m25207a();
            }
        } else {
            instantShoppingVideoBlockViewImpl.f23798n.m25208a(GlyphType.HIDDEN);
        }
        if (instantShoppingVideoBlockDataImpl.r() != GraphQLDocumentVideoAutoplayStyle.AUTOPLAY) {
            z = false;
        }
        instantShoppingVideoBlockViewImpl.f23800p = z;
        instantShoppingVideoBlockViewImpl.m25094i(instantShoppingVideoBlockDataImpl.nv_());
    }

    public final void m25014a(Bundle bundle) {
        super.a(bundle);
        this.f23685f.m24884b("video_element_start", this.f23687h.toString());
        this.f23686g.m24876a(this.f23687h.toString());
    }

    public final void m25017b(Bundle bundle) {
        super.b(bundle);
        this.f23685f.m24884b("video_element_end", this.f23687h.toString());
        this.f23686g.m24877b(this.f23687h.toString());
    }
}
