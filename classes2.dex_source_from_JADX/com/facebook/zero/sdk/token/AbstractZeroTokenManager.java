package com.facebook.zero.sdk.token;

import com.facebook.inject.Lazy;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.rewrite.ZeroRewriteRulesManager;
import com.facebook.zero.sdk.rewrite.ZeroRewriteRulesManagerBase;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRule;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRuleSerialization;
import com.facebook.zero.sdk.util.UiFeatureDataSerializer;
import com.facebook.zero.sdk.util.ZeroSharedPreferences;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: source_module */
public abstract class AbstractZeroTokenManager implements ZeroTokenFetchListener {
    private static final Class<?> f4306j = AbstractZeroTokenManager.class;
    public final ZeroSharedPreferences f4307a;
    protected final Lazy<UiFeatureDataSerializer> f4308b;
    protected final Lazy<ZeroUrlRewriteRuleSerialization> f4309c;
    public final Provider<ZeroTokenType> f4310d;
    protected final Provider<Boolean> f4311e;
    protected final Provider<Boolean> f4312f;
    protected final ZeroRewriteRulesManagerBase f4313g;
    protected boolean f4314h = true;
    public volatile ImmutableSet<ZeroFeatureKey> f4315i;

    protected abstract void mo1184b(boolean z);

    protected abstract boolean mo1190c();

    protected abstract void mo1191d();

    public abstract void mo1192h();

    public abstract Map<String, Object> mo1186i();

    public AbstractZeroTokenManager(ZeroSharedPreferences zeroSharedPreferences, Lazy<UiFeatureDataSerializer> lazy, Lazy<ZeroUrlRewriteRuleSerialization> lazy2, Provider<ZeroTokenType> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, ZeroRewriteRulesManager zeroRewriteRulesManager) {
        this.f4307a = zeroSharedPreferences;
        this.f4308b = lazy;
        this.f4309c = lazy2;
        this.f4310d = provider;
        this.f4311e = provider2;
        this.f4312f = provider3;
        this.f4313g = zeroRewriteRulesManager;
    }

    public final ImmutableSet<ZeroFeatureKey> m7964e() {
        if (this.f4315i == null) {
            m7960a();
        }
        return this.f4315i;
    }

    private synchronized void m7960a() {
        this.f4315i = ((UiFeatureDataSerializer) this.f4308b.get()).m8055a(((ZeroTokenType) this.f4310d.get()).getUIFeaturesKey());
    }

    public final ImmutableList<ZeroUrlRewriteRule> m7965f() {
        if (((Boolean) this.f4311e.get()).booleanValue() || ((Boolean) this.f4312f.get()).booleanValue()) {
            if (this.f4314h) {
                this.f4314h = false;
                mo1184b(true);
                mo1192h();
            }
            if (mo1190c()) {
                return this.f4313g.m8006b();
            }
        }
        return this.f4313g.m8004a();
    }

    protected final void m7966g() {
        this.f4313g.m8008c();
        m7960a();
        mo1191d();
    }
}
