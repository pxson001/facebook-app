package com.facebook.feed.ui.inlinevideoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.ui.inlinevideoplayer.plugins.InlineCallToActionEndscreenPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.InlineSaveButtonPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.LiveVideoStatusPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.VideoBroadcastPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.VideoLiveScribeButtonPlugin;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.gating.feature.ExperimentsForSavedGatingModule;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.commercialbreak.abtest.CommercialBreakConfig;
import com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin;
import com.facebook.video.commercialbreak.plugins.CommercialBreakTransitionPlugin;
import com.facebook.video.commercialbreak.plugins.CommercialBreakVideoPluginNew;
import com.facebook.video.player.InlineVideoPlayer2;
import com.facebook.video.player.plugins.CommercialBreakVideoPlugin;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import javax.inject.Inject;

@Deprecated
/* compiled from: The privacyUpdatedHandler is null */
public class FeedInlineVideoPlayer2 extends InlineVideoPlayer2 {
    @Inject
    public QeAccessor f22230c;
    @Inject
    public GatekeeperStoreImpl f22231d;
    @Inject
    public CommercialBreakConfig f22232e;
    private InlineCallToActionEndscreenPlugin f22233f;
    private OnClickListener f22234g;

    private static <T extends View> void m24869a(Class<T> cls, T t) {
        m24870a((Object) t, t.getContext());
    }

    private static void m24870a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FeedInlineVideoPlayer2 feedInlineVideoPlayer2 = (FeedInlineVideoPlayer2) obj;
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        GatekeeperStoreImpl a = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        CommercialBreakConfig a2 = CommercialBreakConfig.a(fbInjector);
        feedInlineVideoPlayer2.f22230c = qeAccessor;
        feedInlineVideoPlayer2.f22231d = a;
        feedInlineVideoPlayer2.f22232e = a2;
    }

    public FeedInlineVideoPlayer2(Context context) {
        this(context, null, 0);
    }

    public FeedInlineVideoPlayer2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedInlineVideoPlayer2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24869a(FeedInlineVideoPlayer2.class, (View) this);
        m24868a(context);
    }

    private void m24868a(Context context) {
        this.f22233f = new InlineCallToActionEndscreenPlugin(context);
        this.a.a(this.f22233f);
        this.a.a(new CommercialBreakPlugin(context));
        this.a.a(new CommercialBreakTransitionPlugin(context));
        if (this.f22232e.i) {
            this.a.a(new CommercialBreakVideoPluginNew(context));
        } else {
            this.a.a(new CommercialBreakVideoPlugin(context));
        }
        if (m24872m()) {
            this.a.a(new VideoLiveScribeButtonPlugin(context));
        }
        if (m24871l()) {
            this.a.a(new InlineSaveButtonPlugin(context));
        }
        this.a.a(this.f22231d.a(VideoAbTestGatekeepers.f, false) ? new LiveVideoStatusPlugin(context) : new VideoBroadcastPlugin(context));
    }

    public void setOnClickPlayerListener(OnClickListener onClickListener) {
        super.setOnClickPlayerListener(onClickListener);
        this.f22234g = onClickListener;
        this.f22233f.o = onClickListener;
    }

    private boolean m24871l() {
        return this.f22230c.a(ExperimentsForSavedGatingModule.f, false);
    }

    private boolean m24872m() {
        return !this.f22230c.a(ExperimentsForVideoHomeAbTestModule.p, false);
    }
}
