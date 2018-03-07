package com.facebook.zero.rewrite;

import android.content.Intent;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.mqttlite.MqttConnectionConfigManager;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.rewrite.ZeroRewriteRulesManagerBase;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRule;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRuleSerialization;
import com.facebook.zero.sdk.util.ZeroSharedPreferences;
import com.facebook.zero.util.FbZeroSharedPreferences;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: sort_key */
public class FbZeroRewriteRulesManager extends ZeroRewriteRulesManagerBase {
    private Lazy<ZeroMqttRewriter> f4330g;

    /* compiled from: sort_key */
    class C02261 implements Provider<ZeroTokenType> {
        final /* synthetic */ Provider f4338a;

        C02261(Provider provider) {
            this.f4338a = provider;
        }

        public Object get() {
            return ((FbZeroTokenType) this.f4338a.get()).getBaseToken();
        }
    }

    public static FbZeroRewriteRulesManager m7999c(InjectorLike injectorLike) {
        return new FbZeroRewriteRulesManager(IdBasedProvider.m1811a(injectorLike, 814), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3785), FbZeroSharedPreferences.m7971a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3791), IdBasedProvider.m1811a(injectorLike, 3759));
    }

    @Inject
    public FbZeroRewriteRulesManager(Provider<TriState> provider, Lazy<ZeroMqttRewriter> lazy, ZeroSharedPreferences zeroSharedPreferences, Lazy<ZeroUrlRewriteRuleSerialization> lazy2, Provider<FbZeroTokenType> provider2) {
        super(provider, zeroSharedPreferences, lazy2, new C02261(provider2));
        this.f4330g = lazy;
    }

    public static FbZeroRewriteRulesManager m7998b(InjectorLike injectorLike) {
        return m7999c(injectorLike);
    }

    public final void mo1201d() {
        ImmutableList b;
        Object obj;
        if (this.f4333b.mo1198a("zero_rating2/clearable/zero_unknown_state", true)) {
            b = m8006b();
        } else {
            b = m8004a();
        }
        ZeroMqttRewriter zeroMqttRewriter = (ZeroMqttRewriter) this.f4330g.get();
        if (((Boolean) zeroMqttRewriter.f23515b.get()).booleanValue()) {
            String str = ((MqttConnectionConfigManager) zeroMqttRewriter.f23514a.get()).f23397k.b;
            String d = ((MqttConnectionConfigManager) zeroMqttRewriter.f23514a.get()).m31673d();
            Intent intent = new Intent("com.facebook.rti.mqtt.ACTION_ZR_SWITCH");
            int size = b.size();
            int i = 0;
            while (i < size) {
                ZeroUrlRewriteRule zeroUrlRewriteRule = (ZeroUrlRewriteRule) b.get(i);
                if (zeroUrlRewriteRule.m31808a(d)) {
                    String b2 = zeroUrlRewriteRule.m31810b(d);
                    if (b2.equals(str)) {
                        obj = null;
                    } else {
                        intent.putExtra("extra_mqtt_endpoint", b2);
                        zeroMqttRewriter.f23516c.mo406a(intent);
                        obj = 1;
                    }
                } else {
                    i++;
                }
            }
            obj = null;
        } else {
            obj = null;
        }
        if (obj == null) {
            zeroMqttRewriter = (ZeroMqttRewriter) this.f4330g.get();
            zeroMqttRewriter.f23516c.mo406a(new Intent("com.facebook.rti.mqtt.ACTION_ZR_SWITCH"));
        }
    }
}
