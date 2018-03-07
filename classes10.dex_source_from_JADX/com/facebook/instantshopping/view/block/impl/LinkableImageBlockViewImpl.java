package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.abtest.ExperimentsForInstantShoppingAbtestModule;
import com.facebook.instantshopping.action.InstantShoppingActionUtils;
import com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher.PrefetchMonitor;
import com.facebook.instantshopping.links.InstantShoppingLinkHandler;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.InstantShoppingLoggingUtils;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.view.transition.InstantShoppingTransitionStrategyFactory;
import com.facebook.instantshopping.view.widget.PhotoOverlayPlugin;
import com.facebook.instantshopping.view.widget.media.AnimatingGlyphPlugin;
import com.facebook.instantshopping.view.widget.media.AnimatingGlyphPlugin.GlyphType;
import com.facebook.instantshopping.view.widget.media.TiltToPanPlugin;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.view.block.impl.ImageBlockViewImpl;
import com.facebook.richdocument.view.transition.AbstractTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory.StrategyType;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.RichDocumentImageView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: STALE_DATA_NEEDS_INCREMENTAL_SERVER_FETCH */
public class LinkableImageBlockViewImpl extends ImageBlockViewImpl {
    @Inject
    InstantShoppingTransitionStrategyFactory f23806j;
    @Inject
    InstantShoppingAnalyticsLogger f23807k;
    @Inject
    InstantShoppingActionUtils f23808l;
    @Inject
    InstantShoppingLinkHandler f23809m;
    @Inject
    QeAccessor f23810n;
    @Inject
    InstantShoppingLoggingUtils f23811o;
    public AnimatingGlyphPlugin f23812p;
    public TiltToPanPlugin f23813q;
    public PhotoOverlayPlugin f23814r;
    public String f23815s;
    public boolean f23816t;
    private StrategyType f23817u;

    /* compiled from: STALE_DATA_NEEDS_INCREMENTAL_SERVER_FETCH */
    public class C34161 implements OnClickListener {
        final /* synthetic */ InstantShoppingActionFragmentModel f23802a;
        final /* synthetic */ LoggingParams f23803b;
        final /* synthetic */ boolean f23804c;
        final /* synthetic */ LinkableImageBlockViewImpl f23805d;

        /* compiled from: STALE_DATA_NEEDS_INCREMENTAL_SERVER_FETCH */
        class C34151 extends HashMap<String, Object> {
            C34151() {
                put("action_type", "No-Op");
            }
        }

        public C34161(LinkableImageBlockViewImpl linkableImageBlockViewImpl, InstantShoppingActionFragmentModel instantShoppingActionFragmentModel, LoggingParams loggingParams, boolean z) {
            this.f23805d = linkableImageBlockViewImpl;
            this.f23802a = instantShoppingActionFragmentModel;
            this.f23803b = loggingParams;
            this.f23804c = z;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1777390165);
            if (this.f23802a != null) {
                this.f23805d.f23811o.m24884b("image_link_click", this.f23803b.toString() + this.f23802a.toString());
                this.f23805d.f23808l.m24802a(this.f23805d.getContext(), this.f23802a, this.f23803b, null);
            } else if (this.f23804c) {
                this.f23805d.f23807k.m24857a(this.f23803b, null);
                this.f23805d.a.a(Event.CLICK_MEDIA);
                if (LinkableImageBlockViewImpl.m25099n(this.f23805d) && this.f23805d.f23813q != null) {
                    TiltToPanPlugin tiltToPanPlugin = this.f23805d.f23813q;
                    if (!(tiltToPanPlugin.a == null || tiltToPanPlugin.a.getTransitionStrategy() == null || !tiltToPanPlugin.f23945a.getTransitionStrategy().l())) {
                        MediaTransitionState j = tiltToPanPlugin.j();
                        if (j == MediaTransitionState.a) {
                            tiltToPanPlugin.m25218a();
                        } else if (j == MediaTransitionState.b) {
                            if (tiltToPanPlugin.f23945a.b(MediaTransitionState.b)) {
                                tiltToPanPlugin.m25218a();
                            } else if (tiltToPanPlugin.f23945a.b(MediaTransitionState.a)) {
                                tiltToPanPlugin.m25220k();
                            }
                        }
                    }
                }
            } else {
                this.f23805d.f23807k.m24857a(this.f23803b, new C34151());
            }
            LogUtils.a(-1766815762, a);
        }
    }

    public static void m25096a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LinkableImageBlockViewImpl) obj).m25095a(InstantShoppingTransitionStrategyFactory.m25135b(injectorLike), InstantShoppingAnalyticsLogger.m24853a(injectorLike), InstantShoppingActionUtils.m24796a(injectorLike), InstantShoppingLinkHandler.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), InstantShoppingLoggingUtils.m24879a(injectorLike));
    }

    private void m25095a(InstantShoppingTransitionStrategyFactory instantShoppingTransitionStrategyFactory, InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger, InstantShoppingActionUtils instantShoppingActionUtils, InstantShoppingLinkHandler instantShoppingLinkHandler, QeAccessor qeAccessor, InstantShoppingLoggingUtils instantShoppingLoggingUtils) {
        this.f23806j = instantShoppingTransitionStrategyFactory;
        this.f23807k = instantShoppingAnalyticsLogger;
        this.f23808l = instantShoppingActionUtils;
        this.f23809m = instantShoppingLinkHandler;
        this.f23810n = qeAccessor;
        this.f23811o = instantShoppingLoggingUtils;
    }

    public LinkableImageBlockViewImpl(MediaFrame mediaFrame, View view) {
        super(mediaFrame, view);
        Class cls = LinkableImageBlockViewImpl.class;
        m25096a(this, getContext());
        this.f23814r = new PhotoOverlayPlugin(mediaFrame);
        a(this.f23814r);
        this.f23812p = new AnimatingGlyphPlugin(mediaFrame);
        a(this.f23812p);
        if (m25099n(this)) {
            this.f23813q = new TiltToPanPlugin(mediaFrame);
            a(this.f23813q);
        }
    }

    public final void m25101a(Bundle bundle) {
        this.f23812p.m25207a();
        PhotoOverlayPlugin photoOverlayPlugin = this.f23814r;
        if (photoOverlayPlugin.f23932a != null) {
            photoOverlayPlugin.f23932a.setVisibility(8);
        }
        this.a.setOverlayBackgroundColor(0);
        if (m25099n(this) && this.f23813q != null) {
            this.f23813q.m25220k();
        }
        super.a(bundle);
    }

    public static ImageBlockViewImpl m25097b(View view) {
        return new LinkableImageBlockViewImpl((MediaFrame) view, view);
    }

    protected final AbstractTransitionStrategy m25100a(MediaFrame mediaFrame, StrategyType strategyType, boolean z) {
        this.f23817u = strategyType;
        if (strategyType == StrategyType.FULLSCREEN || strategyType == StrategyType.FULLSCREEN_SLIDE || strategyType == StrategyType.FULLSCREEN_SLIDESHOW) {
            this.f23812p.m25208a(GlyphType.TILT_TO_PAN);
        }
        InstantShoppingTransitionStrategyFactory instantShoppingTransitionStrategyFactory = this.f23806j;
        Context context = getContext();
        boolean z2 = this.f23816t && this.f23810n.a(ExperimentsForInstantShoppingAbtestModule.i, false);
        return instantShoppingTransitionStrategyFactory.m25137a(strategyType, context, mediaFrame, z, z2, false);
    }

    public void mo1032a(LoggingParams loggingParams) {
        this.f23807k.m24856a(loggingParams);
    }

    public final void m25104b(Bundle bundle) {
        super.b(bundle);
        if (m25098l()) {
            this.f23809m.a(getContext(), this.f23815s);
        }
        if (this.f23817u == StrategyType.FULLSCREEN && m25099n(this) && this.f23813q != null) {
            this.f23813q.m25218a();
        }
    }

    public final void m25105c(Bundle bundle) {
        super.c(bundle);
        if (m25098l()) {
            InstantShoppingLinkHandler instantShoppingLinkHandler = this.f23809m;
            if (instantShoppingLinkHandler.b != null) {
                PrefetchMonitor prefetchMonitor = instantShoppingLinkHandler.b;
                if (prefetchMonitor.b != null) {
                    prefetchMonitor.b.g();
                }
                if (prefetchMonitor.d != null) {
                    prefetchMonitor.a.e.c(prefetchMonitor.d.m());
                }
                instantShoppingLinkHandler.b = null;
            }
        }
    }

    private boolean m25098l() {
        return this.f23810n.a(ExperimentsForInstantShoppingAbtestModule.n, false);
    }

    public final void m25103a(String str, int i, int i2) {
        if (this.f23810n.a(ExperimentsForInstantShoppingAbtestModule.f, true)) {
            ((RichDocumentImageView) h()).a(str, i, i2);
        }
    }

    public final boolean m25106c() {
        return false;
    }

    public static boolean m25099n(LinkableImageBlockViewImpl linkableImageBlockViewImpl) {
        return linkableImageBlockViewImpl.f23810n.a(ExperimentsForInstantShoppingAbtestModule.s, true);
    }
}
