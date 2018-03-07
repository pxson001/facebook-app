package com.facebook.feed.ui.inlinevideoplayer.plugins;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.content.event.FbEvent;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.facecastdisplay.LiveEventsLogger;
import com.facebook.facecastdisplay.LiveVideoStatusView.IndicatorType;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.events.RVPLiveVideoControlFadeEvent;
import com.facebook.video.player.events.RVPLiveVideoControlFadeEvent.State;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: The number of re-created SuggestEditsFieldHolders didn't match the number of savedSuggestEditFields */
public class FullScreenLiveVideoStatusPlugin extends LiveVideoStatusPlugin implements OnDismissListener {
    private static final PrefKey f22239w = ((PrefKey) SharedPrefKeys.h.a("viewer_watching_video_broadcast_tool_tip_has_shown"));
    @Inject
    public FbSharedPreferences f22240a;
    @Inject
    public LiveEventsLogger f22241b;
    @Inject
    @ForUiThread
    public Handler f22242d;
    @Inject
    public FacecastUtil f22243l;
    public final Runnable f22244x;
    @Nullable
    private NoArrowTooltip f22245y;

    /* compiled from: The number of re-created SuggestEditsFieldHolders didn't match the number of savedSuggestEditFields */
    class C19011 implements Runnable {
        final /* synthetic */ FullScreenLiveVideoStatusPlugin f22235a;

        C19011(FullScreenLiveVideoStatusPlugin fullScreenLiveVideoStatusPlugin) {
            this.f22235a = fullScreenLiveVideoStatusPlugin;
        }

        public void run() {
            FullScreenLiveVideoStatusPlugin.m24879n(this.f22235a);
        }
    }

    /* compiled from: The number of re-created SuggestEditsFieldHolders didn't match the number of savedSuggestEditFields */
    /* synthetic */ class C19022 {
        static final /* synthetic */ int[] f22236a = new int[State.values().length];
        static final /* synthetic */ int[] f22237b = new int[RVPCommercialBreakStateChangeEvent.State.values().length];

        static {
            try {
                f22237b[RVPCommercialBreakStateChangeEvent.State.LIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22237b[RVPCommercialBreakStateChangeEvent.State.TRANSITION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22237b[RVPCommercialBreakStateChangeEvent.State.WAIT_FOR_ADS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22237b[RVPCommercialBreakStateChangeEvent.State.STATIC_COUNTDOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f22237b[RVPCommercialBreakStateChangeEvent.State.VIDEO_AD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f22236a[State.FADE_IN.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f22236a[State.FADE_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: The number of re-created SuggestEditsFieldHolders didn't match the number of savedSuggestEditFields */
    class LiveVideoControlFadeSubscriber extends RichVideoPlayerEventSubscriber<RVPLiveVideoControlFadeEvent> {
        final /* synthetic */ FullScreenLiveVideoStatusPlugin f22238a;

        public LiveVideoControlFadeSubscriber(FullScreenLiveVideoStatusPlugin fullScreenLiveVideoStatusPlugin) {
            this.f22238a = fullScreenLiveVideoStatusPlugin;
        }

        public final void m24874b(FbEvent fbEvent) {
            switch (C19022.f22236a[((RVPLiveVideoControlFadeEvent) fbEvent).a.ordinal()]) {
                case 1:
                    FullScreenLiveVideoStatusPlugin.m24878m(this.f22238a);
                    return;
                case 2:
                    this.f22238a.s.m22564c();
                    HandlerDetour.a(this.f22238a.f22242d, this.f22238a.f22244x);
                    return;
                default:
                    return;
            }
        }

        public final Class<RVPLiveVideoControlFadeEvent> m24873a() {
            return RVPLiveVideoControlFadeEvent.class;
        }
    }

    /* compiled from: The number of re-created SuggestEditsFieldHolders didn't match the number of savedSuggestEditFields */
    class NoArrowTooltip extends Tooltip {
        public NoArrowTooltip(Context context, int i) {
            super(context, i);
        }

        protected final void m24875a(View view, boolean z, LayoutParams layoutParams) {
            super.a(view, z, layoutParams);
            View findViewById = this.f.findViewById(2131561860);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public static void m24876a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FullScreenLiveVideoStatusPlugin fullScreenLiveVideoStatusPlugin = (FullScreenLiveVideoStatusPlugin) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        LiveEventsLogger b = LiveEventsLogger.b(fbInjector);
        Handler b2 = Handler_ForUiThreadMethodAutoProvider.b(fbInjector);
        FacecastUtil b3 = FacecastUtil.m3107b(fbInjector);
        fullScreenLiveVideoStatusPlugin.f22240a = fbSharedPreferences;
        fullScreenLiveVideoStatusPlugin.f22241b = b;
        fullScreenLiveVideoStatusPlugin.f22242d = b2;
        fullScreenLiveVideoStatusPlugin.f22243l = b3;
    }

    @DoNotStrip
    public FullScreenLiveVideoStatusPlugin(Context context) {
        this(context, null);
    }

    private FullScreenLiveVideoStatusPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Integer.valueOf(0));
    }

    private FullScreenLiveVideoStatusPlugin(Context context, AttributeSet attributeSet, Integer num) {
        super(context, attributeSet, num.intValue());
        Class cls = FullScreenLiveVideoStatusPlugin.class;
        m24876a((Object) this, getContext());
        this.f.add(new LiveVideoControlFadeSubscriber(this));
        this.f22244x = new C19011(this);
    }

    protected int getLayout() {
        return 2130904543;
    }

    protected final void m24880a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        boolean z2 = false;
        super.a(richVideoPlayerParams, z);
        boolean a = this.f22240a.a(f22239w, false);
        GraphQLMedia a2 = RichVideoPlayerParamsUtil.a(richVideoPlayerParams);
        if (a2 != null && a2.aq() && (a2.br() == GraphQLVideoBroadcastStatus.LIVE_STOPPED || a2.br() == GraphQLVideoBroadcastStatus.SEAL_STARTED)) {
            z2 = true;
        }
        if (a || r0) {
            m24877l();
        } else {
            this.f22245y = new NoArrowTooltip(getContext(), 2);
            this.f22245y.t = 8000;
            this.f22245y.b(2131232831);
            this.f22245y.c(this.s);
            this.f22245y.H = this;
            this.f22245y.d();
            this.f22240a.edit().putBoolean(f22239w, true).commit();
        }
        if (z) {
            m24878m(this);
        }
        d();
    }

    public final void m24884c() {
        if (this.f22245y != null && this.f22245y.r) {
            this.f22245y.H = null;
            this.f22245y.l();
        }
        this.s.m22565d();
        HandlerDetour.a(this.f22242d, this.f22244x);
        super.c();
    }

    public final boolean m24883a(PopoverWindow popoverWindow) {
        m24877l();
        return true;
    }

    protected final void m24882a(PlaybackController.State state) {
    }

    private void m24877l() {
        this.f22241b.a(this.t, 0);
    }

    public static void m24878m(FullScreenLiveVideoStatusPlugin fullScreenLiveVideoStatusPlugin) {
        if (fullScreenLiveVideoStatusPlugin.f22243l.m3114j()) {
            m24879n(fullScreenLiveVideoStatusPlugin);
            fullScreenLiveVideoStatusPlugin.s.m22562a(false);
        }
    }

    public static void m24879n(FullScreenLiveVideoStatusPlugin fullScreenLiveVideoStatusPlugin) {
        if (fullScreenLiveVideoStatusPlugin.h != null && fullScreenLiveVideoStatusPlugin.h.g() > 0) {
            fullScreenLiveVideoStatusPlugin.s.setTimeElapsed((long) fullScreenLiveVideoStatusPlugin.h.g());
        }
        HandlerDetour.a(fullScreenLiveVideoStatusPlugin.f22242d, fullScreenLiveVideoStatusPlugin.f22244x);
        HandlerDetour.b(fullScreenLiveVideoStatusPlugin.f22242d, fullScreenLiveVideoStatusPlugin.f22244x, 200, 1526708603);
    }

    protected final void m24881a(RVPCommercialBreakStateChangeEvent.State state) {
        switch (C19022.f22237b[state.ordinal()]) {
            case 1:
                this.y = true;
                this.s.setVisibility(0);
                this.s.setIndicatorType(IndicatorType.LIVE);
                return;
            case 2:
            case 3:
            case 4:
                this.y = false;
                this.s.setVisibility(8);
                return;
            case 5:
                this.s.setIndicatorType(IndicatorType.VIEWER_COMMERCIAL_BREAK);
                return;
            default:
                return;
        }
    }
}
