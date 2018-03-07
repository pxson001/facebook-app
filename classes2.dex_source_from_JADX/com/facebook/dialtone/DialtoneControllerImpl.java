package com.facebook.dialtone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.DialtoneController.PlaceholderState;
import com.facebook.dialtone.DialtoneWhitelist.WhitelistType;
import com.facebook.dialtone.DialtoneWhitelistRegexes.WhitelistSetType;
import com.facebook.dialtone.activity.DialtoneUnsupportedCarrierInterstitialActivity;
import com.facebook.dialtone.activity.DialtoneWifiInterstitialActivity;
import com.facebook.dialtone.activitylistener.DialtoneActivityListener;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.dialtone.common.STATICDI_MULTIBIND_PROVIDER$DialtoneStateChangedListener;
import com.facebook.dialtone.protocol.DialtoneGraphQL.DialtonePhotoUnblockMutationString;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.FetchDialtonePhotoQuotaModel.DialtonePhotoQuotaModel;
import com.facebook.dialtone.protocol.DialtonePhotoQuotaAPIHandler;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ImageUnblockForDialtoneInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.internal.InternalIntentSigner;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.DialogToShow;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.nodex.startup.signal.DialtoneSignalFile;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.ui.futures.TasksManager;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sms_favorites */
public class DialtoneControllerImpl extends DialtoneController {
    private static volatile DialtoneControllerImpl f4554D;
    static final /* synthetic */ boolean f4555a = (!DialtoneControllerImpl.class.desiredAssertionStatus());
    private Bitmap f4556A;
    private Bitmap f4557B;
    private boolean f4558C = false;
    private final Context f4559b;
    private final Lazy<FbBroadcastManager> f4560c;
    private final Lazy<FbBroadcastManager> f4561d;
    public final Lazy<SecureContextHelper> f4562e;
    private final Lazy<InternalIntentSigner> f4563f;
    private final Lazy<AnalyticsLogger> f4564g;
    public final Lazy<DialtonePhotoCapController> f4565h;
    private final Lazy<DialtonePhotoQuotaAPIHandler> f4566i;
    public final Lazy<DialtoneUiFeaturesAccessor> f4567j;
    private final Lazy<FbErrorReporter> f4568k;
    public final Lazy<FbSharedPreferences> f4569l;
    private final Lazy<TasksManager> f4570m;
    private final Lazy<ZeroDialogController> f4571n;
    private final Provider<TriState> f4572o;
    public final Provider<Boolean> f4573p;
    private final DialtoneSignalFile f4574q;
    private final Lazy<DialtoneNewsFeedIntentUriBuilder> f4575r;
    private final DialtoneWhitelist f4576s;
    private Optional<DialtoneActivityListener> f4577t;
    private Lazy<Set<DialtoneStateChangedListener>> f4578u;
    private Set<DialtoneStateChangedListener> f4579v;
    public DialogFragment f4580w;
    private Bitmap f4581x;
    private Bitmap f4582y;
    private Bitmap f4583z;

    public static com.facebook.dialtone.DialtoneControllerImpl m8272a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4554D;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.dialtone.DialtoneControllerImpl.class;
        monitor-enter(r1);
        r0 = f4554D;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8276b(r0);	 Catch:{ all -> 0x0035 }
        f4554D = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4554D;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.DialtoneControllerImpl.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.DialtoneControllerImpl");
    }

    private static DialtoneControllerImpl m8276b(InjectorLike injectorLike) {
        return new DialtoneControllerImpl((Context) injectorLike.getInstance(Context.class), DialtoneAsyncSignalFile.m4394a(injectorLike), DialtoneWhitelist.m8345a(injectorLike), STATICDI_MULTIBIND_PROVIDER$DialtoneStateChangedListener.m8357a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), IdBasedProvider.m1811a(injectorLike, 664), IdBasedLazy.m1808a(injectorLike, 393), IdBasedLazy.m1808a(injectorLike, 401), IdBasedSingletonScopeProvider.m1810b(injectorLike, 968), IdBasedSingletonScopeProvider.m1810b(injectorLike, 5486), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2400), IdBasedLazy.m1808a(injectorLike, 2365), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1090), IdBasedLazy.m1808a(injectorLike, 1102), IdBasedLazy.m1808a(injectorLike, 3561), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3078), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1093), IdBasedProvider.m1811a(injectorLike, 3957));
    }

    @Inject
    public DialtoneControllerImpl(Context context, DialtoneAsyncSignalFile dialtoneAsyncSignalFile, DialtoneWhitelist dialtoneWhitelist, Lazy<Set<DialtoneStateChangedListener>> lazy, Lazy<AnalyticsLogger> lazy2, Lazy<FbErrorReporter> lazy3, Provider<TriState> provider, Lazy<FbBroadcastManager> lazy4, Lazy<FbBroadcastManager> lazy5, Lazy<SecureContextHelper> lazy6, Lazy<DialtoneNewsFeedIntentUriBuilder> lazy7, Lazy<InternalIntentSigner> lazy8, Lazy<ZeroDialogController> lazy9, Lazy<DialtonePhotoCapController> lazy10, Lazy<DialtonePhotoQuotaAPIHandler> lazy11, Lazy<TasksManager> lazy12, Lazy<FbSharedPreferences> lazy13, Lazy<DialtoneUiFeaturesAccessor> lazy14, Provider<Boolean> provider2) {
        this.f4559b = context;
        this.f4572o = provider;
        this.f4574q = dialtoneAsyncSignalFile;
        this.f4576s = dialtoneWhitelist;
        this.f4578u = lazy;
        this.f4564g = lazy2;
        this.f4568k = lazy3;
        this.f4560c = lazy4;
        this.f4561d = lazy5;
        this.f4562e = lazy6;
        this.f4575r = lazy7;
        this.f4563f = lazy8;
        this.f4565h = lazy10;
        this.f4569l = lazy13;
        this.f4567j = lazy14;
        this.f4577t = Absent.withType();
        this.f4571n = lazy9;
        this.f4566i = lazy11;
        this.f4570m = lazy12;
        this.f4573p = provider2;
    }

    public final void mo1209a(DialtoneActivityListener dialtoneActivityListener) {
        this.f4577t = Optional.of(dialtoneActivityListener);
    }

    public static void m8280e(DialtoneControllerImpl dialtoneControllerImpl, String str) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "dialtone";
        HoneyAnalyticsEvent honeyAnalyticsEvent = honeyClientEvent;
        honeyAnalyticsEvent.m5090b("carrier_id", ((FbSharedPreferences) dialtoneControllerImpl.f4569l.get()).mo278a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        ((AnalyticsLogger) dialtoneControllerImpl.f4564g.get()).mo526a(honeyAnalyticsEvent);
    }

    private void m8274a(String str, String str2) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "dialtone";
        HoneyAnalyticsEvent honeyAnalyticsEvent = honeyClientEvent;
        honeyAnalyticsEvent.m5090b("ref", str2);
        honeyAnalyticsEvent.m5090b("carrier_id", ((FbSharedPreferences) this.f4569l.get()).mo278a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        ((AnalyticsLogger) this.f4564g.get()).mo526a(honeyAnalyticsEvent);
    }

    private void m8273a(String str, WhitelistType whitelistType, String str2, CallerContext callerContext) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "dialtone";
        HoneyAnalyticsEvent honeyAnalyticsEvent = honeyClientEvent;
        honeyAnalyticsEvent.m5090b("whitelist_type", whitelistType.getType());
        honeyAnalyticsEvent.m5090b("whitelisted_element", str2);
        if (callerContext != null) {
            honeyAnalyticsEvent.m5090b("whitelisted_callercontext", callerContext.f5181b);
        }
        honeyAnalyticsEvent.m5090b("carrier_id", ((FbSharedPreferences) this.f4569l.get()).mo278a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        ((AnalyticsLogger) this.f4564g.get()).mo526a(honeyAnalyticsEvent);
    }

    public final boolean mo1213a() {
        return ((TriState) this.f4572o.get()).asBoolean(true);
    }

    public final boolean mo1214a(Context context, Intent intent) {
        Uri data = intent.getData();
        String host = data != null ? data.getHost() : null;
        if ((host != null && host.equals("start")) || intent.hasExtra("start")) {
            m8274a("dialtone_explicitly_entered", intent.getStringExtra("ref"));
            if (!mo1221b() || (this.f4577t.isPresent() && ((DialtoneActivityListener) this.f4577t.get()).f8427g)) {
                mo1223c();
                mo1208a(context);
            } else if (this.f4577t.isPresent()) {
                return false;
            } else {
                ((SecureContextHelper) this.f4562e.get()).mo662a(new Intent("android.intent.action.VIEW").setData(Uri.parse(FBLinks.bT)), context);
            }
            return true;
        } else if ((host != null && host.equals("switch_to_dialtone")) || intent.hasExtra("switch_to_dialtone")) {
            String stringExtra = intent.getStringExtra("ref");
            m8274a("switched_to_dialtone_via_intent", stringExtra);
            mo1223c();
            if (stringExtra == null && !((DialtoneUiFeaturesAccessor) this.f4567j.get()).m4680c() && ((DialtoneUiFeaturesAccessor) this.f4567j.get()).m4682a(ZeroFeatureKey.OPTIN_GROUP_INTERSTITIAL)) {
                ((FbSharedPreferences) this.f4569l.get()).edit().putBoolean(DialtonePrefKeys.f2495r, true).commit();
            }
            mo1208a(context);
            if (stringExtra != null && stringExtra.equals("force_switch_to_dialtone")) {
                ((FbSharedPreferences) this.f4569l.get()).edit().putBoolean(DialtonePrefKeys.f2471A, true).commit();
                Intent intent2 = new Intent("com.facebook.zero.ACTION_ZERO_UPDATE_STATUS");
                intent2.putExtra("zero_status_to_update", "force_switch_to_dialtone");
                ((BaseFbBroadcastManager) this.f4561d.get()).mo406a(intent2);
            }
            ((BaseFbBroadcastManager) this.f4561d.get()).m2955a("com.facebook.zero.ACTION_ZERO_INTERSTITIAL_REFRESH");
            return true;
        } else if ((host == null || !host.equals("switch_to_full_fb")) && !intent.hasExtra("switch_to_full_fb")) {
            return false;
        } else {
            m8274a("switched_to_full_fb_via_intent", "");
            mo1217a("switch_to_full_fb");
            return true;
        }
    }

    public final boolean mo1221b() {
        if (mo1213a()) {
            return m8282n();
        }
        return false;
    }

    private boolean m8282n() {
        if (this.f4574q.m4404c()) {
            return true;
        }
        boolean z;
        if (((DialtoneUiFeaturesAccessor) this.f4567j.get()).m4682a(ZeroFeatureKey.DIALTONE_STICKY_MODE) && ((FbSharedPreferences) this.f4569l.get()).mo286a(ZeroPrefKeys.ad, false)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        this.f4574q.mo637a();
        m8274a("dialtone_explicitly_entered", "dialtone_sticky");
        return true;
    }

    public final boolean mo1223c() {
        if (!mo1213a()) {
            ((AbstractFbErrorReporter) this.f4568k.get()).m2340a("dialtone".toString(), "gatekeeper check failed");
            this.f4574q.mo638b();
            return false;
        } else if (mo1221b()) {
            return false;
        } else {
            m8283p();
            return true;
        }
    }

    private void m8277b(boolean z) {
        ((FbSharedPreferences) this.f4569l.get()).edit().putBoolean(ZeroPrefKeys.ad, z).commit();
    }

    private void m8283p() {
        String str;
        m8278c(true);
        if (!this.f4577t.isPresent() || ((DialtoneActivityListener) this.f4577t.get()).f8427g) {
            str = "dialtone_enabled_cold";
        } else {
            str = "dialtone_enabled_warm";
        }
        m8280e(this, str);
        this.f4574q.mo637a();
        m8277b(true);
        m8279d(this.f4574q.m4404c());
    }

    public final boolean mo1217a(@Nullable String str) {
        if (!m8282n()) {
            return false;
        }
        m8281f(str);
        return true;
    }

    private void m8281f(@Nullable String str) {
        m8278c(false);
        String str2 = "dialtone_disabled";
        if (str == null) {
            str = "";
        }
        m8274a(str2, str);
        this.f4574q.mo638b();
        m8277b(false);
        m8279d(this.f4574q.m4404c());
    }

    private void m8278c(boolean z) {
        for (DialtoneStateChangedListener iw_ : m8284q()) {
            iw_.iw_();
        }
    }

    private void m8279d(boolean z) {
        for (DialtoneStateChangedListener b_ : m8284q()) {
            b_.b_(z);
        }
    }

    public final void mo1208a(Context context) {
        Parcelable a = ((DialtoneNewsFeedIntentUriBuilder) this.f4575r.get()).a(context, FBLinks.bT);
        Intent intent = new Intent();
        intent.putExtra("tabbar_target_intent", a);
        intent.putExtra("extra_launch_uri", FBLinks.bT);
        intent.putExtra("POP_TO_ROOT", true);
        intent.setComponent(((InternalIntentSigner) this.f4563f.get()).mo1177a());
        ((InternalIntentSigner) this.f4563f.get()).mo1178a(intent);
        ((SecureContextHelper) this.f4562e.get()).mo662a(intent, context);
    }

    public final void mo1210a(DialtoneStateChangedListener dialtoneStateChangedListener) {
        if (dialtoneStateChangedListener != null) {
            m8284q().add(dialtoneStateChangedListener);
        }
    }

    public final void mo1220b(DialtoneStateChangedListener dialtoneStateChangedListener) {
        if (dialtoneStateChangedListener != null) {
            m8284q().remove(dialtoneStateChangedListener);
        }
    }

    private synchronized Set<DialtoneStateChangedListener> m8284q() {
        if (this.f4579v == null) {
            this.f4579v = Collections.newSetFromMap(new ConcurrentHashMap());
            this.f4579v.addAll((Collection) this.f4578u.get());
        }
        return this.f4579v;
    }

    public final boolean mo1215a(Uri uri, CallerContext callerContext) {
        boolean z = this.f4576s.m8349a(uri) || ((DialtonePhotoCapController) this.f4565h.get()).m23079a(uri);
        if (z) {
            m8273a("dialtone_whitelisted_impression", WhitelistType.URI, uri.toString(), callerContext);
        }
        return z;
    }

    public final boolean mo1218a(String str, CallerContext callerContext) {
        boolean a = DialtoneWhitelist.m8346a(str, this.f4576s.f4586b.m8356a(WhitelistSetType.PHOTO));
        if (a) {
            m8273a("dialtone_whitelisted_impression", WhitelistType.FEATURE_TAG, str, callerContext);
        }
        return a;
    }

    public final boolean mo1224c(String str) {
        boolean a = DialtoneWhitelist.m8346a(str, this.f4576s.f4586b.m8356a(WhitelistSetType.FACEWEB));
        if (a) {
            m8273a("dialtone_whitelisted_impression", WhitelistType.FACEWEB, str, null);
        }
        return a;
    }

    public final boolean mo1222b(String str) {
        return DialtoneWhitelist.m8346a(str, this.f4576s.f4586b.m8356a(WhitelistSetType.VIDEO));
    }

    public final Bitmap mo1207a(float f, float f2, PlaceholderState placeholderState) {
        Bitmap b = m8275b(placeholderState);
        if (b != null && ((float) b.getWidth()) <= f && ((float) b.getHeight()) <= f2) {
            return b;
        }
        b = m8271a(placeholderState);
        return ((float) b.getWidth()) > f ? m8285r() : b;
    }

    private Bitmap m8285r() {
        if (this.f4557B == null) {
            View view = (LinearLayout) LayoutInflater.from(this.f4559b).inflate(2130903909, null, false);
            ((TextView) view.findViewById(2131561030)).setVisibility(8);
            ((TextView) view.findViewById(2131561031)).setVisibility(8);
            GlyphView glyphView = (GlyphView) view.findViewById(2131561029);
            int dimensionPixelSize = this.f4559b.getResources().getDimensionPixelSize(2131428055);
            glyphView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            glyphView.setGlyphColor(this.f4559b.getResources().getColor(2131362570));
            glyphView.setBackgroundDrawable(this.f4559b.getResources().getDrawable(2130838404));
            dimensionPixelSize = SizeUtil.m19191a(this.f4559b, 50.0f);
            glyphView.setLayoutParams(new LayoutParams(dimensionPixelSize, dimensionPixelSize));
            glyphView.setScaleType(ScaleType.CENTER_INSIDE);
            this.f4557B = m8270a(view);
        }
        return this.f4557B;
    }

    private Bitmap m8271a(PlaceholderState placeholderState) {
        View view = (LinearLayout) LayoutInflater.from(this.f4559b).inflate(2130903909, null, false);
        ((ImageView) view.findViewById(2131561029)).setVisibility(8);
        ((TextView) view.findViewById(2131561030)).setVisibility(8);
        TextView textView = (TextView) view.findViewById(2131561031);
        CharSequence string;
        switch (3.a[placeholderState.c.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (this.f4556A == null) {
                    string = this.f4559b.getString(2131232562);
                    textView.setText(string);
                    textView.setContentDescription(string);
                    this.f4556A = m8270a(view);
                }
                return this.f4556A;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                string = this.f4559b.getString(2131232563);
                textView.setText(string);
                textView.setContentDescription(string);
                break;
            case 3:
                string = this.f4559b.getString(2131232564);
                textView.setText(string);
                textView.setContentDescription(string);
                break;
        }
        return m8270a(view);
    }

    private Bitmap m8275b(PlaceholderState placeholderState) {
        View view = (LinearLayout) LayoutInflater.from(this.f4559b).inflate(2130903909, null, false);
        GlyphView glyphView = (GlyphView) view.findViewById(2131561029);
        TextView textView = (TextView) view.findViewById(2131561030);
        TextView textView2 = (TextView) view.findViewById(2131561031);
        CharSequence string;
        switch (3.a[placeholderState.c.ordinal()]) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (this.f4583z == null) {
                    string = this.f4559b.getString(2131232563);
                    textView2.setText(string);
                    textView2.setContentDescription(string);
                    glyphView.setImageResource(2130839952);
                    this.f4583z = m8270a(view);
                }
                return this.f4583z;
            case 3:
                if (this.f4582y == null) {
                    CharSequence string2 = this.f4559b.getString(2131232558);
                    textView.setText(string2);
                    textView.setContentDescription(string2);
                    string = this.f4559b.getString(2131232564);
                    textView2.setText(string);
                    textView2.setContentDescription(string);
                    glyphView.setImageResource(2130840148);
                    this.f4582y = m8270a(view);
                }
                return this.f4582y;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                if (placeholderState.b > 0) {
                    CharSequence string3 = this.f4559b.getString(2131232561, new Object[]{Integer.valueOf(placeholderState.b)});
                    textView2.setText(string3);
                    textView2.setContentDescription(string3);
                    return m8270a(view);
                }
                break;
        }
        if (this.f4581x == null) {
            this.f4581x = m8270a(view);
        }
        return this.f4581x;
    }

    private Bitmap m8270a(View view) {
        int a = SizeUtil.m19191a(this.f4559b, 300.0f);
        view.measure(a, a);
        a = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        view.layout(0, 0, a, measuredHeight);
        Bitmap createBitmap = Bitmap.createBitmap(a, measuredHeight, Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @Nullable
    public final Activity mo1227f() {
        if (this.f4577t.isPresent()) {
            return ((DialtoneActivityListener) this.f4577t.get()).f8426f;
        }
        ((AbstractFbErrorReporter) this.f4568k.get()).m2340a("dialtone".toString(), "trying to switch to dialtone without any activity present!");
        return null;
    }

    public final boolean mo1228g() {
        if (this.f4577t.isPresent()) {
            return ((DialtoneActivityListener) this.f4577t.get()).f8428h;
        }
        return this.f4574q.m4404c();
    }

    public final boolean mo1219a(boolean z) {
        Activity f = mo1227f();
        if (f == null) {
            m8287t(this);
            return false;
        } else if (f instanceof FragmentActivity) {
            m8288u();
            ZeroFeatureKey zeroFeatureKey = (mo1232k() && z) ? ZeroFeatureKey.DIALTONE_PHOTO_CAPPING : ZeroFeatureKey.DIALTONE_PHOTO;
            ((ZeroDialogController) this.f4571n.get()).m8429a(zeroFeatureKey, ((FragmentActivity) f).kO_(), null);
            m8280e(this, "dialtone_upgrade_dialog_impression");
            return true;
        } else {
            ((AbstractFbErrorReporter) this.f4568k.get()).m2340a("dialtone".toString(), "Attempting to show upgrade dialog but current activity is not a fragment activity: " + f.getClass());
            return false;
        }
    }

    public final boolean mo1216a(DialtoneStateChangedListener dialtoneStateChangedListener, @Nullable Uri uri, boolean z) {
        if (!mo1232k() || !z) {
            return mo1219a(z);
        }
        m8280e(this, "dialtone_photocapping_degraded_image_click");
        if (uri == null) {
            m8286s(this);
            return true;
        }
        DialtonePhotoQuotaAPIHandler dialtonePhotoQuotaAPIHandler = (DialtonePhotoQuotaAPIHandler) this.f4566i.get();
        String uri2 = uri.toString();
        ImageUnblockForDialtoneInputData imageUnblockForDialtoneInputData = new ImageUnblockForDialtoneInputData();
        imageUnblockForDialtoneInputData.m11397a("url", uri2);
        ListenableFuture a = dialtonePhotoQuotaAPIHandler.f16258a.m10448a(GraphQLRequest.m11588a((DialtonePhotoUnblockMutationString) new DialtonePhotoUnblockMutationString().m11310a("input", (GraphQlCallInput) imageUnblockForDialtoneInputData)));
        DisposableFutureCallback 1 = new 1(this, dialtoneStateChangedListener, uri, z);
        ((ZeroDialogController) this.f4571n.get()).m8431a(ZeroFeatureKey.DIALTONE_PHOTOCAP_SPINNER, uri.toString(), a, 1, DialogToShow.SPINNER);
        Activity f = mo1227f();
        if (f == null) {
            m8287t(this);
            return true;
        }
        this.f4580w = ((ZeroDialogController) this.f4571n.get()).m8429a(ZeroFeatureKey.DIALTONE_PHOTOCAP_SPINNER, ((FragmentActivity) f).kO_(), null);
        ((TasksManager) this.f4570m.get()).m14553a(uri.toString(), a, 1);
        return true;
    }

    public static void m8286s(DialtoneControllerImpl dialtoneControllerImpl) {
        ((ZeroDialogController) dialtoneControllerImpl.f4571n.get()).m8432a(ZeroFeatureKey.DIALTONE_PHOTOCAP_ERROR, "", dialtoneControllerImpl.f4559b.getResources().getString(2131232552), DialogToShow.SPINNER);
        Activity f = dialtoneControllerImpl.mo1227f();
        if (f == null) {
            m8287t(dialtoneControllerImpl);
        } else {
            ((ZeroDialogController) dialtoneControllerImpl.f4571n.get()).m8429a(ZeroFeatureKey.DIALTONE_PHOTOCAP_ERROR, ((FragmentActivity) f).kO_(), null);
        }
    }

    public static void m8287t(DialtoneControllerImpl dialtoneControllerImpl) {
        ((AbstractFbErrorReporter) dialtoneControllerImpl.f4568k.get()).m2340a("dialtone".toString(), "currentAcitvity is null");
    }

    private void m8288u() {
        if (!this.f4558C) {
            Listener 2 = new 2(this);
            ((ZeroDialogController) this.f4571n.get()).m8433a(ZeroFeatureKey.DIALTONE_PHOTO, this.f4559b.getResources().getString(2131232547), this.f4559b.getResources().getString(2131232548, new Object[]{((FbSharedPreferences) this.f4569l.get()).mo278a(ZeroPrefKeys.f2635j, StringUtil.m3598c(this.f4559b.getResources().getString(2131232601)))}), 2);
            ((ZeroDialogController) this.f4571n.get()).m8433a(ZeroFeatureKey.DIALTONE_PHOTO_CAPPING, this.f4559b.getResources().getString(2131232550), this.f4559b.getResources().getString(2131232551), 2);
            this.f4558C = true;
        }
    }

    protected final void mo1229h() {
        if (this.f4577t.isPresent() && !((DialtoneActivityListener) this.f4577t.get()).m12976a()) {
            Activity f = mo1227f();
            if (f == null) {
                m8287t(this);
                return;
            }
            Intent intent = new Intent(f, DialtoneWifiInterstitialActivity.class);
            intent.addFlags(67108864);
            ((SecureContextHelper) this.f4562e.get()).mo660a(intent, 1000, f);
        }
    }

    protected final void mo1225d(String str) {
        if (this.f4577t.isPresent() && !((DialtoneActivityListener) this.f4577t.get()).m12976a()) {
            Activity f = mo1227f();
            if (f == null) {
                m8287t(this);
                return;
            }
            Intent intent = new Intent(f, DialtoneUnsupportedCarrierInterstitialActivity.class);
            intent.addFlags(67108864);
            boolean z = true;
            switch (str.hashCode()) {
                case -843027230:
                    if (str.equals("not_in_region")) {
                        z = true;
                        break;
                    }
                    break;
                case 862561006:
                    if (str.equals("unsupported_carrier")) {
                        z = false;
                        break;
                    }
                    break;
                case 1014790088:
                    if (str.equals("unsupported_category")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    intent.putExtra("dialtone_wrong_carrier_flag", true);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    intent.putExtra("dialtone_not_in_region_flag", true);
                    break;
                default:
                    intent.putExtra("dialtone_wrong_carrier_flag", false);
                    break;
            }
            ((SecureContextHelper) this.f4562e.get()).mo660a(intent, 1000, f);
        }
    }

    protected final void mo1230i() {
        if (mo1221b()) {
            m8279d(true);
        }
    }

    protected final void mo1212a(TokenRequestReason tokenRequestReason) {
        ((BaseFbBroadcastManager) this.f4560c.get()).mo406a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", tokenRequestReason));
    }

    public final boolean mo1231j() {
        return mo1221b() && ((ZeroDialogController) this.f4571n.get()).m8437a(ZeroFeatureKey.DIALTONE_PHOTO);
    }

    public final boolean mo1232k() {
        return mo1221b() && ((ZeroDialogController) this.f4571n.get()).m8437a(ZeroFeatureKey.DIALTONE_PHOTO_CAPPING);
    }

    public final boolean mo1233l() {
        return mo1221b() && ((ZeroDialogController) this.f4571n.get()).m8437a(ZeroFeatureKey.DIALTONE_FEED_CAPPING);
    }

    public final boolean mo1234m() {
        return mo1221b() && ((ZeroDialogController) this.f4571n.get()).m8437a(ZeroFeatureKey.DIALTONE_FACEWEB);
    }

    public final void mo1211a(DialtonePhotoQuotaModel dialtonePhotoQuotaModel) {
        ((DialtonePhotoCapController) this.f4565h.get()).m23078a(dialtonePhotoQuotaModel);
    }

    public final int mo1226e() {
        return SizeUtil.m19191a(this.f4559b, 176.0f);
    }
}
