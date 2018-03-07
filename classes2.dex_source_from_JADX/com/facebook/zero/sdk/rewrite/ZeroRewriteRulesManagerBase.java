package com.facebook.zero.sdk.rewrite;

import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.token.ZeroToken;
import com.facebook.zero.sdk.token.ZeroTokenFetchListener;
import com.facebook.zero.sdk.util.ZeroSharedPreferences;
import com.facebook.zero.util.FbZeroSharedPreferences;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: sonar. */
public class ZeroRewriteRulesManagerBase {
    private static final Class<?> f4331g = ZeroRewriteRulesManagerBase.class;
    protected volatile Map<String, ImmutableList<ZeroUrlRewriteRule>> f4332a = new HashMap();
    public final ZeroSharedPreferences f4333b;
    protected final Provider<ZeroTokenType> f4334c;
    protected final Lazy<ZeroUrlRewriteRuleSerialization> f4335d;
    protected final Provider<TriState> f4336e;
    protected ZeroTokenFetchListener f4337f;

    /* compiled from: sonar. */
    class C02291 implements ZeroTokenFetchListener {
        final /* synthetic */ ZeroRewriteRulesManagerBase f4362a;

        C02291(ZeroRewriteRulesManagerBase zeroRewriteRulesManagerBase) {
            this.f4362a = zeroRewriteRulesManagerBase;
        }

        public final void mo1183a(Throwable th, ZeroTokenType zeroTokenType) {
            th.getMessage();
        }

        public final void mo1182a(ZeroToken zeroToken, ZeroTokenType zeroTokenType) {
            if (zeroTokenType.equals(this.f4362a.f4334c.get()) && !zeroToken.equals(ZeroToken.f23324a)) {
                this.f4362a.m8005a(zeroToken.f23333j);
                if (!zeroToken.f23335l.isEmpty()) {
                    this.f4362a.m8007b(zeroToken.f23335l);
                    ImmutableList immutableList = zeroToken.f23333j;
                }
            }
        }
    }

    private static ZeroRewriteRulesManagerBase m8001b(InjectorLike injectorLike) {
        return new ZeroRewriteRulesManagerBase(IdBasedProvider.m1811a(injectorLike, 818), FbZeroSharedPreferences.m7971a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3791), IdBasedProvider.m1811a(injectorLike, 3786));
    }

    @Inject
    public ZeroRewriteRulesManagerBase(Provider<TriState> provider, ZeroSharedPreferences zeroSharedPreferences, Lazy<ZeroUrlRewriteRuleSerialization> lazy, Provider<ZeroTokenType> provider2) {
        this.f4333b = zeroSharedPreferences;
        this.f4335d = lazy;
        this.f4334c = provider2;
        this.f4336e = provider;
    }

    public final ZeroTokenFetchListener m8010e() {
        if (this.f4337f == null) {
            this.f4337f = new C02291(this);
        }
        return this.f4337f;
    }

    public void mo1201d() {
    }

    public final void m8005a(ImmutableList<ZeroUrlRewriteRule> immutableList) {
        this.f4332a.put("regular", immutableList);
        mo1201d();
    }

    public final void m8007b(ImmutableList<ZeroUrlRewriteRule> immutableList) {
        this.f4332a.put("backup", immutableList);
    }

    public final synchronized ImmutableList<ZeroUrlRewriteRule> m8004a() {
        if (this.f4332a.get("regular") == null) {
            m8002f();
        }
        return (ImmutableList) this.f4332a.get("regular");
    }

    public final synchronized ImmutableList<ZeroUrlRewriteRule> m8006b() {
        ImmutableList<ZeroUrlRewriteRule> immutableList;
        if (this.f4336e.get() == TriState.UNSET) {
            immutableList = ZeroUrlRewriter.f23493a;
        } else {
            if (this.f4332a.get("backup") == null) {
                m8003g();
            }
            immutableList = (ImmutableList) this.f4332a.get("backup");
        }
        return immutableList;
    }

    public final void m8008c() {
        m8002f();
        m8003g();
    }

    private synchronized void m8002f() {
        try {
            String a = this.f4333b.mo1196a(((ZeroTokenType) this.f4334c.get()).getRewriteRulesKey(), "");
            if (StringUtil.m3589a((CharSequence) a)) {
                m8005a(ImmutableList.of());
            } else {
                m8005a(ImmutableList.copyOf(((ZeroUrlRewriteRuleSerialization) this.f4335d.get()).m31826a(a)));
            }
        } catch (Throwable e) {
            BLog.b(f4331g, e, "Error deserializing rewrite rules: %s", new Object[]{e.getMessage()});
        }
    }

    private synchronized void m8003g() {
        ZeroTokenType zeroTokenType = (ZeroTokenType) this.f4334c.get();
        try {
            if (this.f4333b.mo1197a(zeroTokenType.getBackupRewriteRulesKey())) {
                String a = this.f4333b.mo1196a(zeroTokenType.getBackupRewriteRulesKey(), "");
                if (StringUtil.m3589a((CharSequence) a)) {
                    m8007b(ZeroUrlRewriter.f23493a);
                } else {
                    m8007b(ImmutableList.copyOf(((ZeroUrlRewriteRuleSerialization) this.f4335d.get()).m31826a(a)));
                }
            } else {
                m8007b(ZeroUrlRewriter.f23493a);
            }
        } catch (Throwable e) {
            BLog.b(f4331g, e, "Error deserializing backup rewrite rules: %s", new Object[]{e.getMessage()});
        }
    }
}
