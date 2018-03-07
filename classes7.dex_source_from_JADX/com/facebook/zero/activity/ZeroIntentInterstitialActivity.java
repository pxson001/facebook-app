package com.facebook.zero.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.CrossFbAppBroadcast;
import com.facebook.base.broadcast.CrossFbAppBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.MultiBinderSet;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: …  */
public class ZeroIntentInterstitialActivity extends FbFragmentActivity {
    private static final Class<?> f15x = ZeroIntentInterstitialActivity.class;
    @Inject
    Product f16p;
    @Inject
    ZeroDialogController f17q;
    @Inject
    @CrossFbAppBroadcast
    BaseFbBroadcastManager f18r;
    @Inject
    Set<Observer> f19s;
    @Inject
    AbstractFbErrorReporter f20t;
    protected Intent f21u;
    protected ZeroFeatureKey f22v;
    protected boolean f23w;
    private SelfRegistrableReceiverImpl f24y;
    private int f25z;

    /* compiled from: …  */
    public interface Observer {
        void mo1a(Intent intent);

        void mo2b(Intent intent);
    }

    /* compiled from: …  */
    class C00051 implements ActionReceiver {
        final /* synthetic */ ZeroIntentInterstitialActivity f13a;

        C00051(ZeroIntentInterstitialActivity zeroIntentInterstitialActivity) {
            this.f13a = zeroIntentInterstitialActivity;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -859882832);
            this.f13a.m29j();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1598261980, a);
        }
    }

    /* compiled from: …  */
    class C00062 implements Listener {
        final /* synthetic */ ZeroIntentInterstitialActivity f14a;

        C00062(ZeroIntentInterstitialActivity zeroIntentInterstitialActivity) {
            this.f14a = zeroIntentInterstitialActivity;
        }

        public final void m20a(Object obj) {
            this.f14a.m28i();
        }

        public final void m19a() {
            this.f14a.m29j();
        }
    }

    private static <T extends Context> void m22a(Class<T> cls, T t) {
        m23a((Object) t, (Context) t);
    }

    public static void m23a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ZeroIntentInterstitialActivity) obj).m21a(ProductMethodAutoProvider.b(fbInjector), (ZeroDialogController) FbZeroDialogController.b(fbInjector), (BaseFbBroadcastManager) CrossFbAppBroadcastManager.a(fbInjector), new MultiBinderSet(fbInjector.getScopeAwareInjector(), new C0000x67d39c18(fbInjector)), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector));
    }

    protected final void m27b(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        super.b(bundle);
        Class cls = ZeroIntentInterstitialActivity.class;
        m23a((Object) this, (Context) this);
        this.f24y = this.f18r.a().a("android.intent.action.SCREEN_OFF", new C00051(this)).a();
        this.f24y.b();
        Intent intent = getIntent();
        this.f21u = (Intent) intent.getParcelableExtra("destination_intent");
        String stringExtra = intent.getStringExtra("zero_feature_key_string");
        this.f22v = ZeroFeatureKey.fromString(stringExtra);
        if (this.f22v == ZeroFeatureKey.UNKNOWN) {
            this.f20t.a(f15x.getSimpleName(), "Error parsing feature key extra: " + stringExtra);
            this.f22v = ZeroFeatureKey.EXTERNAL_URLS_INTERSTITIAL;
        }
        if (this.f21u == null || this.f22v == null) {
            this.f20t.b(f15x.toString(), this.f21u == null ? "destination intent was null" : "zero feature key was null");
            finish();
            return;
        }
        this.f21u.setExtrasClassLoader(getClass().getClassLoader());
        this.f23w = intent.getBooleanExtra("start_for_result", false);
        this.f25z = intent.getIntExtra("request_code", 0);
        m24k();
    }

    private void m24k() {
        this.f17q.a(this.f22v, m25l(), m26m(), new C00062(this));
        if (kO_().a(this.f22v.prefString) == null) {
            this.f17q.a(this.f22v, kO_(), this.f21u);
        }
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1930397782);
        super.onDestroy();
        if (this.f24y != null) {
            this.f24y.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 2031492209, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 7979) {
            setResult(i2, intent);
            finish();
        }
    }

    protected final void m28i() {
        LinkshimIntentTransformer linkshimIntentTransformer = new LinkshimIntentTransformer();
        Intent a = LinkshimIntentTransformer.a(this.f21u);
        for (Observer a2 : this.f19s) {
            a2.mo1a(a);
        }
        if (this.f23w) {
            try {
                startActivityForResult(a, this.f25z);
                return;
            } catch (ActivityNotFoundException e) {
                BLog.b(f15x, "Activity not found for intent: [%s]", new Object[]{a});
                return;
            }
        }
        try {
            startActivity(a);
        } catch (ActivityNotFoundException e2) {
            BLog.b(f15x, "Activity not found for intent: [%s]", new Object[]{a});
        }
        finish();
    }

    protected final void m29j() {
        for (Observer b : this.f19s) {
            b.mo2b(this.f21u);
        }
        if (this.f23w) {
            setResult(0);
        }
        finish();
    }

    private String m25l() {
        if (this.f22v == ZeroFeatureKey.VIEW_MAP_INTERSTITIAL) {
            return getString(2131232926);
        }
        return getString(2131232869);
    }

    private String m26m() {
        if (this.f22v == ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL) {
            return getString(2131232930);
        }
        if (this.f22v == ZeroFeatureKey.CHECKIN_INTERSTITIAL) {
            return getString(2131232930);
        }
        if (this.f22v == ZeroFeatureKey.VOIP_CALL_INTERSTITIAL) {
            return getString(2131232083);
        }
        if (this.f22v == ZeroFeatureKey.VIEW_MAP_INTERSTITIAL) {
            return getString(2131232927);
        }
        if (this.f22v == ZeroFeatureKey.VIDEO_UPLOAD_INTERSTITIAL) {
            return getString(2131232931);
        }
        String string;
        if (this.f16p == Product.MESSENGER) {
            string = getString(2131232920);
        } else if (this.f16p == Product.FB4A) {
            string = getString(2131232921);
        } else if (this.f16p == Product.PAA) {
            string = getString(2131232922);
        } else if (this.f16p == Product.GROUPS) {
            string = getString(2131232923);
        } else {
            throw new RuntimeException("Zero-rating isn't supported in the product: " + this.f16p);
        }
        return getString(2131232868, new Object[]{string});
    }

    private void m21a(Product product, ZeroDialogController zeroDialogController, FbBroadcastManager fbBroadcastManager, Set<Observer> set, FbErrorReporter fbErrorReporter) {
        this.f16p = product;
        this.f17q = zeroDialogController;
        this.f18r = fbBroadcastManager;
        this.f19s = set;
        this.f20t = fbErrorReporter;
    }
}
