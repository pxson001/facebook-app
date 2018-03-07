package com.facebook.zero.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbProcessBroadcast;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.text.linkify.SafeLinkifier;
import com.facebook.zero.MessageCapAccessor;
import com.facebook.zero.capping.IsMessageCapEligibleGK;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentResult;
import com.facebook.zero.sdk.token.ZeroTokenFetcher;
import com.facebook.zero.sdk.util.StringListDataSerializer;
import com.facebook.zero.sdk.util.ZeroOptinInterstitialContentFetcher;
import com.facebook.zero.service.FbZeroTokenFetcher;
import com.facebook.zero.service.FbZeroTokenManager;
import com.facebook.zero.util.ZeroDefaultOptinStore;
import com.facebook.zero.util.ZeroDefaultOptinStore.Builder;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.photos.upload.service.success. */
public class ZeroOptinInterstitialActivity extends FbFragmentActivity {
    protected static final CallerContext f20281s = CallerContext.a(ZeroOptinInterstitialActivity.class, "zero_optin_interstitial");
    @Inject
    FbSharedPreferences f20282A;
    @Inject
    StringListDataSerializer f20283B;
    @Inject
    Lazy<MessageCapAccessor> f20284C;
    @IsMessageCapEligibleGK
    @Inject
    Provider<Boolean> f20285D;
    @Inject
    Lazy<AnalyticsLogger> f20286E;
    @Inject
    GatekeeperStoreImpl f20287F;
    protected ProgressBar f20288G;
    protected LinearLayout f20289H;
    protected FbButton f20290I;
    protected ViewGroup f20291J;
    protected FbTextView f20292K;
    protected FbTextView f20293L;
    protected ScrollView f20294M;
    protected FbDraweeView f20295N;
    protected FbTextView f20296O;
    protected FacepileView f20297P;
    protected FbTextView f20298Q;
    protected String f20299R;
    protected String f20300S;
    protected String f20301T;
    protected Uri f20302U;
    protected boolean f20303V;
    protected ImmutableList<String> f20304W;
    protected String f20305X;
    protected String f20306Y;
    protected String f20307Z;
    protected Uri aa;
    protected String ab;
    protected String ac;
    protected String ad;
    protected String ae;
    protected String af;
    protected String ag;
    protected String ah;
    protected String ai;
    protected boolean aj;
    protected String ak;
    private FbButton f20308p;
    @Inject
    @CrossFbProcessBroadcast
    BaseFbBroadcastManager f20309t;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager f20310u;
    @DefaultExecutorService
    @Inject
    ScheduledExecutorService f20311v;
    @Inject
    SecureContextHelper f20312w;
    @Inject
    ZeroTokenFetcher f20313x;
    @Inject
    FbZeroTokenManager f20314y;
    @Inject
    ZeroOptinInterstitialContentFetcher f20315z;

    private static <T extends Context> void m28875a(Class<T> cls, T t) {
        m28876a((Object) t, (Context) t);
    }

    public static void m28876a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ZeroOptinInterstitialActivity) obj).m28869a((BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(fbInjector), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (ZeroTokenFetcher) FbZeroTokenFetcher.a(fbInjector), FbZeroTokenManager.b(fbInjector), ZeroOptinInterstitialContentFetcher.b(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), StringListDataSerializer.b(fbInjector), IdBasedLazy.a(fbInjector, 11785), IdBasedProvider.a(fbInjector, 4390), IdBasedSingletonScopeProvider.b(fbInjector, 175), GatekeeperStoreImplMethodAutoProvider.a(fbInjector));
    }

    protected void mo1526b(Bundle bundle) {
        super.b(bundle);
        Class cls = ZeroOptinInterstitialActivity.class;
        m28876a((Object) this, (Context) this);
        mo1527i();
        if (this.f20287F.a(510) == TriState.YES) {
            m28874a(ZeroDefaultOptinStore.a(this.f20282A, this.f20283B));
            m28879r(this);
            return;
        }
        m28878a("0", "", null, null, null);
    }

    protected void mo1527i() {
        setTheme(2131624474);
        setContentView(2130907807);
        this.f20288G = (ProgressBar) a(2131560985);
        this.f20291J = (ViewGroup) a(2131560986);
        this.f20292K = (FbTextView) a(2131560987);
        this.f20293L = (FbTextView) a(2131560989);
        this.f20294M = (ScrollView) a(2131560990);
        this.f20295N = (FbDraweeView) a(2131560994);
        this.f20296O = (FbTextView) a(2131560993);
        this.f20297P = (FacepileView) a(2131560992);
        this.f20298Q = (FbTextView) a(2131567903);
        this.f20289H = (LinearLayout) a(2131560991);
        this.f20308p = (FbButton) a(2131568576);
        this.f20308p.setOnClickListener(new 1(this));
        this.f20290I = (FbButton) a(2131560995);
        this.f20290I.setOnClickListener(new 2(this));
    }

    public void onBackPressed() {
        m28881a(mo1531m());
        if ((this.f20308p == null || this.f20308p.getVisibility() != 0) && !this.aj) {
            finish();
        } else {
            m28884d(null);
        }
    }

    public void finish() {
        m28880s();
        super.finish();
    }

    protected CallerContext mo1531m() {
        return f20281s;
    }

    private void m28877a(@Nullable String str, @Nullable Bundle bundle) {
        if (!StringUtil.a(str)) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str));
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.setFlags(335544320);
            this.f20312w.a(intent, getApplicationContext());
        }
    }

    private void m28874a(ZeroDefaultOptinStore zeroDefaultOptinStore) {
        this.f20299R = zeroDefaultOptinStore.h;
        this.f20300S = zeroDefaultOptinStore.i;
        this.f20301T = zeroDefaultOptinStore.j;
        this.f20302U = Uri.parse(zeroDefaultOptinStore.k);
        this.f20303V = zeroDefaultOptinStore.l;
        this.f20305X = zeroDefaultOptinStore.m;
        this.f20304W = zeroDefaultOptinStore.n;
        this.f20306Y = zeroDefaultOptinStore.o;
        this.f20307Z = zeroDefaultOptinStore.p;
        this.aa = Uri.parse(zeroDefaultOptinStore.q);
        this.ab = zeroDefaultOptinStore.r;
        this.ac = zeroDefaultOptinStore.t;
        this.ad = zeroDefaultOptinStore.u;
        this.ae = zeroDefaultOptinStore.s;
        this.af = zeroDefaultOptinStore.v;
        this.ag = zeroDefaultOptinStore.x;
        this.ah = zeroDefaultOptinStore.y;
        this.ai = zeroDefaultOptinStore.w;
        this.aj = zeroDefaultOptinStore.z;
        this.ak = zeroDefaultOptinStore.A;
    }

    protected void m28892p() {
        if (this.f20289H != null) {
            this.f20289H.setVisibility(8);
        }
        if (this.f20291J != null) {
            this.f20291J.setVisibility(8);
        }
        if (this.f20294M != null) {
            this.f20294M.setVisibility(8);
        }
        mo1533o();
        this.f20288G.setVisibility(0);
    }

    private void m28878a(String str, String str2, @Nullable String str3, @Nullable Bundle bundle, @Nullable String str4) {
        m28892p();
        this.f20315z.a(new 3(this, str4, str3, bundle));
        this.f20315z.a(SizeUtil.a(getResources()), str, str2);
    }

    private void m28869a(FbBroadcastManager fbBroadcastManager, FbBroadcastManager fbBroadcastManager2, ScheduledExecutorService scheduledExecutorService, SecureContextHelper secureContextHelper, ZeroTokenFetcher zeroTokenFetcher, FbZeroTokenManager fbZeroTokenManager, ZeroOptinInterstitialContentFetcher zeroOptinInterstitialContentFetcher, FbSharedPreferences fbSharedPreferences, StringListDataSerializer stringListDataSerializer, Lazy<MessageCapAccessor> lazy, Provider<Boolean> provider, Lazy<AnalyticsLogger> lazy2, GatekeeperStore gatekeeperStore) {
        this.f20309t = fbBroadcastManager;
        this.f20310u = fbBroadcastManager2;
        this.f20311v = scheduledExecutorService;
        this.f20312w = secureContextHelper;
        this.f20313x = zeroTokenFetcher;
        this.f20314y = fbZeroTokenManager;
        this.f20315z = zeroOptinInterstitialContentFetcher;
        this.f20282A = fbSharedPreferences;
        this.f20283B = stringListDataSerializer;
        this.f20284C = lazy;
        this.f20285D = provider;
        this.f20286E = lazy2;
        this.f20287F = gatekeeperStore;
    }

    private void m28873a(FetchZeroInterstitialContentResult fetchZeroInterstitialContentResult) {
        Builder builder = new Builder(this.f20282A, this.f20283B);
        builder.a = this.f20282A.a(ZeroPrefKeys.x, "");
        builder = builder;
        builder.b = this.f20282A.a(ZeroPrefKeys.y, "");
        builder = builder;
        builder.c = this.f20282A.a(ZeroPrefKeys.z, 0);
        builder = builder;
        builder.d = this.f20282A.a(ZeroPrefKeys.A, 0);
        builder = builder;
        builder.e = fetchZeroInterstitialContentResult.a();
        builder = builder;
        builder.f = fetchZeroInterstitialContentResult.b();
        builder = builder;
        builder.g = fetchZeroInterstitialContentResult.c();
        builder = builder;
        builder.h = fetchZeroInterstitialContentResult.d().toString();
        builder = builder;
        builder.i = fetchZeroInterstitialContentResult.e();
        builder = builder;
        builder.j = fetchZeroInterstitialContentResult.f();
        builder = builder;
        builder.k = fetchZeroInterstitialContentResult.g();
        builder = builder;
        builder.l = fetchZeroInterstitialContentResult.h();
        builder = builder;
        builder.m = fetchZeroInterstitialContentResult.i();
        builder = builder;
        builder.n = fetchZeroInterstitialContentResult.j().toString();
        builder = builder;
        builder.o = fetchZeroInterstitialContentResult.k();
        builder = builder;
        builder.p = fetchZeroInterstitialContentResult.l();
        builder = builder;
        builder.q = fetchZeroInterstitialContentResult.m();
        builder = builder;
        builder.r = fetchZeroInterstitialContentResult.n();
        builder = builder;
        builder.s = fetchZeroInterstitialContentResult.o();
        builder = builder;
        builder.t = fetchZeroInterstitialContentResult.p();
        builder = builder;
        builder.u = fetchZeroInterstitialContentResult.q();
        builder = builder;
        builder.v = fetchZeroInterstitialContentResult.r();
        builder = builder;
        builder.w = fetchZeroInterstitialContentResult.s();
        builder = builder;
        builder.x = fetchZeroInterstitialContentResult.t();
        ZeroDefaultOptinStore a = builder.a();
        a.a();
        m28874a(a);
    }

    protected final void m28883c(@Nullable Bundle bundle) {
        m28878a(this.ac, this.ad, this.ae, bundle, this.ak);
    }

    protected final void m28884d(@Nullable Bundle bundle) {
        m28878a(this.ag, this.ah, this.ai, bundle, this.ak);
    }

    public static void m28879r(ZeroOptinInterstitialActivity zeroOptinInterstitialActivity) {
        zeroOptinInterstitialActivity.f20288G.setVisibility(8);
        zeroOptinInterstitialActivity.mo1532n();
        zeroOptinInterstitialActivity.mo1528j();
        zeroOptinInterstitialActivity.mo1529k();
        zeroOptinInterstitialActivity.mo1530l();
        if (((zeroOptinInterstitialActivity.f20291J == null || zeroOptinInterstitialActivity.f20291J.getVisibility() != 8) && zeroOptinInterstitialActivity.f20291J != null) || (((zeroOptinInterstitialActivity.f20294M == null || zeroOptinInterstitialActivity.f20294M.getVisibility() != 8) && zeroOptinInterstitialActivity.f20294M != null) || ((zeroOptinInterstitialActivity.f20289H == null || zeroOptinInterstitialActivity.f20289H.getVisibility() != 8) && zeroOptinInterstitialActivity.f20289H != null))) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("iorg_optin_interstitial_shown");
            honeyClientEvent.a("caller_context", zeroOptinInterstitialActivity.mo1531m());
            ((AnalyticsLogger) zeroOptinInterstitialActivity.f20286E.get()).a(honeyClientEvent);
            return;
        }
        ZeroDefaultOptinStore.a(zeroOptinInterstitialActivity.f20282A);
        zeroOptinInterstitialActivity.finish();
    }

    protected void mo1532n() {
    }

    protected void mo1533o() {
    }

    protected void mo1528j() {
        int i;
        int i2 = 1;
        this.f20291J.setVisibility(8);
        this.f20292K.setVisibility(8);
        if (StringUtil.a(this.f20299R)) {
            i = 0;
        } else {
            this.f20292K.setText(this.f20299R);
            this.f20292K.setContentDescription(this.f20299R);
            this.f20292K.setVisibility(0);
            i = 1;
        }
        this.f20293L.setVisibility(8);
        if (StringUtil.a(this.f20301T)) {
            i2 = i;
        } else {
            this.f20293L.setText(this.f20301T);
            this.f20293L.setContentDescription(this.f20301T);
            this.f20293L.setVisibility(0);
        }
        if (i2 != 0) {
            this.f20291J.setVisibility(0);
        }
    }

    protected void mo1529k() {
        int i;
        this.f20294M.setVisibility(8);
        this.f20295N.setVisibility(8);
        if (!StringUtil.a(this.f20302U.toString())) {
            this.f20295N.a(this.f20302U, f20281s);
            this.f20295N.setVisibility(0);
            i = 1;
        } else if (this.f20303V) {
            this.f20295N.a(null, f20281s);
            this.f20295N.setVisibility(0);
            i = 1;
        } else {
            i = 0;
        }
        this.f20296O.setVisibility(8);
        if (!StringUtil.a(this.f20305X)) {
            this.f20296O.setText(this.f20305X);
            this.f20296O.setContentDescription(this.f20305X);
            this.f20296O.setVisibility(0);
            i = 1;
        }
        this.f20297P.setVisibility(8);
        if (!this.f20304W.isEmpty()) {
            this.f20297P.setFaceStrings(this.f20304W);
            this.f20297P.setVisibility(0);
            i = 1;
        }
        this.f20298Q.setVisibility(8);
        if (!(StringUtil.a(this.f20306Y) || StringUtil.a(this.f20307Z))) {
            this.f20298Q.setText(this.f20306Y);
            this.f20298Q.setContentDescription(this.f20306Y);
            SafeLinkifier.m25594a(this.f20298Q, Pattern.compile(Pattern.quote(this.f20307Z)), null, null, new 4(this));
            this.f20298Q.setVisibility(0);
            i = 1;
        }
        if (i != 0) {
            this.f20294M.setVisibility(0);
        }
    }

    protected void mo1530l() {
        int i;
        this.f20289H.setVisibility(8);
        this.f20290I.setVisibility(8);
        if (StringUtil.a(this.ab)) {
            i = 0;
        } else {
            this.f20290I.setText(this.ab);
            this.f20290I.setContentDescription(this.ab);
            this.f20290I.setVisibility(0);
            i = 1;
        }
        this.f20308p.setVisibility(8);
        if (!(StringUtil.a(this.af) || this.aj)) {
            this.f20308p.setText(this.af);
            this.f20308p.setContentDescription(this.af);
            this.f20308p.setVisibility(0);
            i = 1;
        }
        if (i != 0) {
            this.f20289H.setVisibility(0);
        }
    }

    private void m28880s() {
        this.f20311v.schedule(new 5(this), 10000, TimeUnit.MILLISECONDS);
    }

    protected final void m28881a(CallerContext callerContext) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("optin_interstitial_back_pressed");
        honeyClientEvent.a("caller_context", callerContext);
        ((AnalyticsLogger) this.f20286E.get()).a(honeyClientEvent);
    }

    protected final Intent m28893q() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(this.aa);
        intent.setFlags(335544320);
        return intent;
    }
}
