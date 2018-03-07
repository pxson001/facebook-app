package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.InstantShoppingPrefKeys;
import com.facebook.instantshopping.abtest.ExperimentsForInstantShoppingAbtestModule;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.utils.InstantShoppingDocumentContext;
import com.facebook.instantshopping.view.InstantShoppingVideoPlayAudioPolicy;
import com.facebook.instantshopping.view.transition.InstantShoppingTransitionStrategyFactory;
import com.facebook.instantshopping.view.widget.InstantShoppingVideoPlayer;
import com.facebook.instantshopping.view.widget.media.AnimatingGlyphPlugin;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.model.block.VideoBlockInput;
import com.facebook.richdocument.view.block.impl.VideoBlockViewImpl;
import com.facebook.richdocument.view.transition.AbstractTransitionStrategy;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory.StrategyType;
import com.facebook.richdocument.view.widget.RichDocumentVideoPlayer;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.video.VideoPlayingAudioPolicy;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.Video360IndicatorPlugin;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;

/* compiled from: STANDALONE */
public class InstantShoppingVideoBlockViewImpl extends VideoBlockViewImpl {
    @Inject
    InstantShoppingDocumentContext f23790a;
    @Inject
    VideoAutoPlaySettingsChecker f23791b;
    @Inject
    InstantShoppingAnalyticsLogger f23792c;
    @Inject
    InstantShoppingTransitionStrategyFactory f23793d;
    @Inject
    QeAccessor f23794j;
    @Inject
    FbSharedPreferences f23795k;
    private InstantShoppingVideoPlayAudioPolicy f23796l;
    public boolean f23797m;
    public AnimatingGlyphPlugin f23798n;
    public boolean f23799o;
    public boolean f23800p;
    public boolean f23801q;

    public static void m25078a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((InstantShoppingVideoBlockViewImpl) obj).m25077a(InstantShoppingDocumentContext.a(injectorLike), VideoAutoPlaySettingsChecker.a(injectorLike), InstantShoppingAnalyticsLogger.m24853a(injectorLike), InstantShoppingTransitionStrategyFactory.m25135b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    private void m25077a(InstantShoppingDocumentContext instantShoppingDocumentContext, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger, InstantShoppingTransitionStrategyFactory instantShoppingTransitionStrategyFactory, QeAccessor qeAccessor, FbSharedPreferences fbSharedPreferences) {
        this.f23790a = instantShoppingDocumentContext;
        this.f23791b = videoAutoPlaySettingsChecker;
        this.f23792c = instantShoppingAnalyticsLogger;
        this.f23793d = instantShoppingTransitionStrategyFactory;
        this.f23794j = qeAccessor;
        this.f23795k = fbSharedPreferences;
    }

    protected final /* synthetic */ RichDocumentVideoPlayer m25082D() {
        return m25079k();
    }

    public InstantShoppingVideoBlockViewImpl(MediaFrame mediaFrame, View view) {
        super(mediaFrame, view);
        Class cls = InstantShoppingVideoBlockViewImpl.class;
        m25078a((Object) this, getContext());
        this.I = this.f23794j.a(ExperimentsForInstantShoppingAbtestModule.t, 20);
        m25081m();
    }

    public final void m25089a(Bundle bundle) {
        this.f23798n.m25207a();
        super.a(bundle);
        this.a.setOverlayBackgroundColor(0);
    }

    protected final RichVideoPlayerParams m25088a(VideoPlayerParams videoPlayerParams, Builder<String, Object> builder) {
        VideoPlayerParamsBuilder a = VideoPlayerParams.newBuilder().a(videoPlayerParams);
        a.e = (ArrayNode) this.f23790a.c;
        VideoPlayerParamsBuilder videoPlayerParamsBuilder = a;
        videoPlayerParamsBuilder.f = true;
        VideoPlayerParams m = videoPlayerParamsBuilder.m();
        RichVideoPlayerParams.Builder builder2 = new RichVideoPlayerParams.Builder();
        builder2.a = m;
        return builder2.a(builder.b()).b();
    }

    protected final void m25091a(MediaFrame mediaFrame) {
        this.F = false;
        super.a(mediaFrame);
        this.f23798n = new AnimatingGlyphPlugin(mediaFrame);
        a(this.f23798n);
    }

    public final void m25090a(VideoBlockInput videoBlockInput, String str) {
        super.a(videoBlockInput, str);
        if (videoBlockInput.i) {
            m25080l();
        }
    }

    protected final AbstractTransitionStrategy m25086a(MediaFrame mediaFrame, StrategyType strategyType, boolean z) {
        boolean z2 = false;
        InstantShoppingTransitionStrategyFactory instantShoppingTransitionStrategyFactory = this.f23793d;
        Context context = getContext();
        if (this.f23797m && this.f23794j.a(ExperimentsForInstantShoppingAbtestModule.i, false)) {
            z2 = true;
        }
        return instantShoppingTransitionStrategyFactory.m25137a(strategyType, context, mediaFrame, z, z2, this.f23801q);
    }

    public final void m25092e(Bundle bundle) {
        this.f23798n.m25211k();
        super.e(bundle);
    }

    public final boolean m25083E() {
        return this.f23791b.a() && this.f23800p;
    }

    private InstantShoppingVideoPlayer m25079k() {
        return (InstantShoppingVideoPlayer) h();
    }

    public final void m25093h(boolean z) {
        if (z) {
            m25079k().m25203x();
        }
    }

    protected final VideoPlayingAudioPolicy m25087a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        if (this.f23796l == null) {
            this.f23796l = new InstantShoppingVideoPlayAudioPolicy(gatekeeperStoreImpl);
        }
        return this.f23796l;
    }

    protected final boolean m25084G() {
        return false;
    }

    protected final boolean m25085H() {
        return false;
    }

    private void m25080l() {
        m25079k().a(new Video360IndicatorPlugin(getContext()));
    }

    private void m25081m() {
        boolean z;
        boolean z2 = true;
        if (this.f23795k == null || !this.f23795k.a((PrefKey) InstantShoppingPrefKeys.f23464f.a(this.f23790a.a))) {
            z = true;
        } else {
            this.f23795k.a((PrefKey) InstantShoppingPrefKeys.f23464f.a(this.f23790a.a), m25079k());
            z = this.f23795k.a((PrefKey) InstantShoppingPrefKeys.f23464f.a(this.f23790a.a), false);
        }
        InstantShoppingVideoPlayer k = m25079k();
        if (z) {
            z2 = false;
        }
        k.a(z2, EventTriggerType.BY_ANDROID);
    }

    public final void m25094i(boolean z) {
        m25079k().f23931l = z;
    }
}
