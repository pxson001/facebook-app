package com.facebook.rtc.activities;

import android.content.Context;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.messaging.chatheads.ipc.ChatHeadsBroadcaster;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.rtc.helpers.RtcCallStartParams;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.rtcpresence.RtcAbortedCallReasonIds;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: availability */
public class RtcZeroRatingActivity extends FbFragmentActivity {
    private static final Class f19121t = RtcZeroRatingActivity.class;
    @Inject
    RtcCallHandler f19122p;
    @Inject
    WebrtcLoggingHandler f19123q;
    @Inject
    ZeroDialogController f19124r;
    @Inject
    ChatHeadsBroadcaster f19125s;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f19126u = UltralightRuntime.b;

    /* compiled from: availability */
    class C22522 implements Listener {
        final /* synthetic */ RtcZeroRatingActivity f19118a;

        C22522(RtcZeroRatingActivity rtcZeroRatingActivity) {
            this.f19118a = rtcZeroRatingActivity;
        }

        public final void m19110a(Object obj) {
            this.f19118a.setResult(-1);
            this.f19118a.finish();
        }

        public final void m19109a() {
            this.f19118a.finish();
        }
    }

    public static void m19114a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RtcZeroRatingActivity) obj).m19113a(RtcCallHandler.a(fbInjector), WebrtcLoggingHandler.a(fbInjector), (ZeroDialogController) FbZeroDialogController.b(fbInjector), ChatHeadsBroadcaster.a(fbInjector), IdBasedLazy.a(fbInjector, 10375));
    }

    private void m19113a(RtcCallHandler rtcCallHandler, WebrtcLoggingHandler webrtcLoggingHandler, ZeroDialogController zeroDialogController, ChatHeadsBroadcaster chatHeadsBroadcaster, com.facebook.inject.Lazy<WebrtcUiHandler> lazy) {
        this.f19122p = rtcCallHandler;
        this.f19123q = webrtcLoggingHandler;
        this.f19124r = zeroDialogController;
        this.f19125s = chatHeadsBroadcaster;
        this.f19126u = lazy;
    }

    protected final void m19115b(@Nullable Bundle bundle) {
        Listener c22511;
        super.b(bundle);
        Class cls = RtcZeroRatingActivity.class;
        m19114a(this, this);
        final boolean booleanExtra = getIntent().getBooleanExtra("EXTRA_DIRECT_VIDEO", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("EXTRA_AFTER_INCOMING_CALL_SCREEN", false);
        if (booleanExtra2) {
            getWindow().addFlags(524416);
        }
        this.f19125s.b();
        final RtcCallStartParams rtcCallStartParams = (RtcCallStartParams) getIntent().getParcelableExtra("EXTRA_CALL_PARAMS");
        CharSequence action = getIntent().getAction();
        if (StringUtil.a(action)) {
            finish();
        }
        if ("ACTION_START_CALL".equals(action)) {
            if (rtcCallStartParams == null || !rtcCallStartParams.m19554a()) {
                finish();
            }
            c22511 = new Listener(this) {
                final /* synthetic */ RtcZeroRatingActivity f19117b;

                public final void m19108a(Object obj) {
                    this.f19117b.f19122p.a(rtcCallStartParams, true);
                    this.f19117b.finish();
                }

                public final void m19107a() {
                    this.f19117b.f19123q.a(Long.toString(rtcCallStartParams.f19777a), rtcCallStartParams.f19780d, rtcCallStartParams.f19782f, RtcAbortedCallReasonIds.n);
                    this.f19117b.finish();
                }
            };
        } else if (!"ACTION_INCOMING_CALL".equals(action)) {
            finish();
            c22511 = null;
        } else if (booleanExtra2) {
            c22511 = new C22522(this);
        } else {
            ((WebrtcUiHandler) this.f19126u.get()).m19472g(booleanExtra);
            c22511 = new Listener(this) {
                final /* synthetic */ RtcZeroRatingActivity f19120b;

                public final void m19112a(Object obj) {
                    ((WebrtcUiHandler) this.f19120b.f19126u.get()).m19461a(booleanExtra, true);
                    this.f19120b.finish();
                }

                public final void m19111a() {
                    ((WebrtcUiHandler) this.f19120b.f19126u.get()).m19446X();
                    ((WebrtcUiHandler) this.f19120b.f19126u.get()).ag();
                    this.f19120b.finish();
                }
            };
        }
        this.f19124r.a(ZeroFeatureKey.VOIP_CALL_INTERSTITIAL, getString(2131232160), getString(2131232083), c22511);
        this.f19124r.a(ZeroFeatureKey.VOIP_CALL_INTERSTITIAL, kO_());
    }
}
