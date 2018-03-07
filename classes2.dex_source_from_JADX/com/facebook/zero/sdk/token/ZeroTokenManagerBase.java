package com.facebook.zero.sdk.token;

import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.zero.rewrite.FbZeroRewriteRulesManager;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.logging.ZeroLogger;
import com.facebook.zero.sdk.rewrite.ZeroRewriteRulesManager;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRuleSerialization;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.facebook.zero.sdk.util.UiFeatureDataSerializer;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.facebook.zero.sdk.util.ZeroSharedPreferences;
import com.facebook.zero.sdk.util.ZeroSharedPreferences.Editor;
import com.facebook.zero.service.FbZeroTokenFetcher;
import com.facebook.zero.util.FbZeroSharedPreferences;
import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: source_module_class */
public class ZeroTokenManagerBase extends AbstractZeroTokenManager {
    private static final Class<?> f4297p = ZeroTokenManagerBase.class;
    private static volatile ZeroTokenManagerBase f4298q;
    protected final Lazy<Clock> f4299i;
    protected final Lazy<ZeroNetworkAndTelephonyHelper> f4300j;
    protected final Lazy<FbBroadcastManager> f4301k;
    protected final Provider<TriState> f4302l;
    protected final Provider<Boolean> f4303m;
    protected final ZeroTokenFetcher f4304n;
    protected final Lazy<ZeroLogger> f4305o;

    public static com.facebook.zero.sdk.token.ZeroTokenManagerBase m7941a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4298q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.sdk.token.ZeroTokenManagerBase.class;
        monitor-enter(r1);
        r0 = f4298q;	 Catch:{ all -> 0x003a }
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
        r0 = m7942b(r0);	 Catch:{ all -> 0x0035 }
        f4298q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4298q;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.sdk.token.ZeroTokenManagerBase.a(com.facebook.inject.InjectorLike):com.facebook.zero.sdk.token.ZeroTokenManagerBase");
    }

    private static ZeroTokenManagerBase m7942b(InjectorLike injectorLike) {
        return new ZeroTokenManagerBase(IdBasedSingletonScopeProvider.m1810b(injectorLike, 609), FbZeroSharedPreferences.m7971a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3799), IdBasedLazy.m1808a(injectorLike, 401), IdBasedLazy.m1808a(injectorLike, 3798), IdBasedLazy.m1808a(injectorLike, 3791), IdBasedProvider.m1811a(injectorLike, 818), IdBasedProvider.m1811a(injectorLike, 4397), FbZeroTokenFetcher.m7986a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4397), IdBasedProvider.m1811a(injectorLike, 4397), IdBasedProvider.m1811a(injectorLike, 3786), IdBasedLazy.m1808a(injectorLike, 3768), FbZeroRewriteRulesManager.m7999c(injectorLike));
    }

    @Inject
    public ZeroTokenManagerBase(Lazy<Clock> lazy, ZeroSharedPreferences zeroSharedPreferences, Lazy<ZeroNetworkAndTelephonyHelper> lazy2, Lazy<FbBroadcastManager> lazy3, Lazy<UiFeatureDataSerializer> lazy4, Lazy<ZeroUrlRewriteRuleSerialization> lazy5, Provider<TriState> provider, Provider<Boolean> provider2, ZeroTokenFetcher zeroTokenFetcher, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<ZeroTokenType> provider5, Lazy<ZeroLogger> lazy6, ZeroRewriteRulesManager zeroRewriteRulesManager) {
        super(zeroSharedPreferences, lazy4, lazy5, provider5, provider3, provider4, zeroRewriteRulesManager);
        this.f4299i = lazy;
        this.f4300j = lazy2;
        this.f4301k = lazy3;
        this.f4302l = provider;
        this.f4303m = provider2;
        this.f4304n = zeroTokenFetcher;
        this.f4305o = lazy6;
        this.f4304n.m7993a(this.f4313g.m8010e());
        this.f4304n.m7993a(this);
    }

    public void mo1188j() {
        Boolean bool = (Boolean) this.f4303m.get();
        Editor a = this.f4307a.mo1195a();
        for (ZeroTokenType clearablePreferencesRoot : ZeroTokenType.values()) {
            a.mo2847a(clearablePreferencesRoot.getClearablePreferencesRoot());
        }
        a.mo2852a();
        if (bool != this.f4303m.get()) {
            mo1191d();
        }
        m7945a(TokenRequestReason.DEBUG);
    }

    protected final boolean m7957k() {
        return ((ZeroNetworkAndTelephonyHelper) this.f4300j.get()).m22189b().equals("wifi") && !this.f4307a.mo1198a("zero_rating2/allow_zero_rating_on_wifi", false);
    }

    public final void m7945a(TokenRequestReason tokenRequestReason) {
        mo1181a((ZeroTokenType) this.f4310d.get(), tokenRequestReason);
    }

    protected void mo1181a(ZeroTokenType zeroTokenType, TokenRequestReason tokenRequestReason) {
        this.f4304n.m7991a(zeroTokenType, tokenRequestReason);
    }

    @VisibleForTesting
    public final void m7958l() {
        mo1184b(true);
    }

    protected void mo1184b(boolean z) {
        this.f4307a.mo1195a().mo2851a("zero_rating2/clearable/zero_unknown_state", z).mo2852a();
        if (!z) {
            this.h = false;
        }
        this.f4313g.mo1201d();
    }

    public final void mo1192h() {
        m7943b((ZeroTokenType) this.f4310d.get());
    }

    private void m7943b(ZeroTokenType zeroTokenType) {
        if (this.f4302l.get() != TriState.YES) {
            m7949a("disabled");
            return;
        }
        String b = ((ZeroNetworkAndTelephonyHelper) this.f4300j.get()).m22189b();
        if (!b.equals("none")) {
            if (m7957k()) {
                m7949a("disabled");
                ((BaseFbBroadcastManager) this.f4301k.get()).m2955a("com.facebook.zero.ZERO_RATING_DISABLED_ON_WIFI");
                return;
            }
            String a = this.f4307a.mo1196a("zero_rating2/clearable/code_pairs", String.valueOf((int) ((Math.random() * 9000.0d) + 1000.0d)).replaceAll(".(?!$)", "$0:"));
            CarrierAndSimMccMnc carrierAndSimMccMnc = new CarrierAndSimMccMnc(a);
            if (carrierAndSimMccMnc.equals(CarrierAndSimMccMnc.f23517a)) {
                ((ZeroLogger) this.f4305o.get()).mo3439c(a, null);
            }
            CarrierAndSimMccMnc a2 = ((ZeroNetworkAndTelephonyHelper) this.f4300j.get()).m22188a();
            String a3 = this.f4307a.mo1196a("zero_rating2/clearable/network_type", "none");
            if (!m7944c(zeroTokenType)) {
                mo1181a(zeroTokenType, TokenRequestReason.TTL_EXPIRED);
            } else if (((Boolean) this.f4311e.get()).booleanValue() && mo1190c()) {
                mo1180a(zeroTokenType);
            } else if (a2.equals(carrierAndSimMccMnc) && b.equals(a3)) {
                m7949a("enabled");
            } else {
                this.f4307a.mo1195a().mo2850a("zero_rating2/clearable/code_pairs", a2.f23518b.f23520a + ":" + a2.f23518b.f23521b + ":" + a2.f23519c.f23520a + ":" + a2.f23519c.f23521b).mo2850a("zero_rating2/clearable/network_type", b).mo2852a();
                mo1181a(zeroTokenType, TokenRequestReason.MCCMNC_CHANGED);
            }
        }
    }

    protected void mo1180a(ZeroTokenType zeroTokenType) {
        mo1181a(zeroTokenType, TokenRequestReason.UNKNOWN_STATE);
    }

    private boolean m7944c(ZeroTokenType zeroTokenType) {
        return ((Clock) this.f4299i.get()).mo211a() - this.f4307a.mo1194a(zeroTokenType.getLastTimeCheckedKey(), Long.MIN_VALUE) < ((long) this.f4307a.mo1193a(zeroTokenType.getTokenTTLKey(), 3600)) * 1000;
    }

    public void mo1183a(Throwable th, ZeroTokenType zeroTokenType) {
        th.getMessage();
        if (zeroTokenType == this.f4310d.get()) {
            m7949a("unknown");
        } else {
            this.f4307a.mo1195a().mo2850a(zeroTokenType.getStatusKey(), "unknown").mo2852a();
        }
        ((ZeroLogger) this.f4305o.get()).mo3437a(th, null);
    }

    public void mo1182a(ZeroToken zeroToken, ZeroTokenType zeroTokenType) {
        zeroToken.toString();
        if (zeroToken.equals(ZeroToken.f23324a)) {
            mo1184b(false);
            m7949a("enabled");
            return;
        }
        ZeroToken.m31485a(zeroTokenType, zeroToken, this.f4307a, (UiFeatureDataSerializer) this.f4308b.get(), (ZeroUrlRewriteRuleSerialization) this.f4309c.get());
        if (zeroTokenType == this.f4310d.get()) {
            this.f4315i = zeroToken.f23332i;
            m7964e();
            mo1184b(false);
            m7949a("enabled");
        }
    }

    public final void m7949a(String str) {
        this.f4307a.mo1195a().mo2850a(((ZeroTokenType) this.f4310d.get()).getStatusKey(), str).mo2852a();
        mo1191d();
        mo1189m();
    }

    protected final void mo1191d() {
        ((BaseFbBroadcastManager) this.f4301k.get()).m2955a("com.facebook.zero.ZERO_RATING_STATE_CHANGED");
    }

    protected void mo1189m() {
        String a = this.f4307a.mo1196a(((ZeroTokenType) this.f4310d.get()).getUnregisteredReasonKey(), "unavailable");
        Intent intent = new Intent("com.facebook.zero.ZERO_RATING_STATE_UNREGISTERED_REASON");
        intent.putExtra("unregistered_reason", a);
        ((BaseFbBroadcastManager) this.f4301k.get()).mo406a(intent);
    }

    protected final boolean mo1190c() {
        return this.f4307a.mo1198a("zero_rating2/clearable/zero_unknown_state", true);
    }

    public Map<String, Object> mo1186i() {
        ZeroTokenType zeroTokenType = (ZeroTokenType) this.f4310d.get();
        String a = this.f4307a.mo1196a(zeroTokenType.getStatusKey(), "unknown");
        String a2 = this.f4307a.mo1196a(zeroTokenType.getRegistrationStatusKey(), "unknown");
        String a3 = this.f4307a.mo1196a(zeroTokenType.getUnregisteredReasonKey(), "unavailable");
        String a4 = this.f4307a.mo1196a(zeroTokenType.getCampaignIdKey(), "");
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("campaign_id", a4);
        hashMap.put("zero_rating_status", a);
        hashMap.put("registration_status", a2);
        hashMap.put("unregistered_reason", a3);
        hashMap.put("zero_unknown_state", Boolean.valueOf(mo1190c()));
        return hashMap;
    }
}
