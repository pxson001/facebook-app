package com.facebook.gk.internal;

import android.os.Bundle;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.counter.GenericAnalyticsCounters;
import com.facebook.analytics.logger.AnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsConfig.Level;
import com.facebook.common.hashcode.HashCodeBuilder;
import com.facebook.common.preconditions.Preconditions;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.internal.FetchGatekeepersParams.Session;
import com.facebook.gk.store.GatekeeperStoreConfig;
import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.FallbackBehavior;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

@NotThreadSafe
/* compiled from: timeline_disk_cache_eviction_counters */
public class FetchMobileGatekeepersMethod implements ApiMethod<FetchGatekeepersParams, Bundle> {
    private final Provider<String> f1004a;
    private final FbSharedPreferences f1005b;
    private final GenericAnalyticsCounters f1006c;
    private final BaseAnalyticsConfig f1007d;
    private final GatekeeperStoreConfig f1008e;
    private final GatekeeperStoreConfig f1009f;
    private String f1010g;

    public final ApiRequest m1321a(Object obj) {
        boolean z;
        String a;
        if (((FetchGatekeepersParams) obj).f1003b == Session.IS_SESSIONLESS) {
            z = true;
        } else {
            z = false;
        }
        String c = m1317a(z).c();
        this.f1010g = c;
        List a2 = Lists.a();
        a2.add(new BasicNameValuePair("format", "json"));
        a2.add(new BasicNameValuePair("query_hash", c));
        if (z) {
            a = this.f1005b.a(SessionlessGkPrefKeys.f45c, "");
        } else {
            a = this.f1005b.a(GkPrefKeys.f, "");
        }
        if (!a.equalsIgnoreCase(c)) {
            a2.add(new BasicNameValuePair("query", Joiner.on(',').join(m1317a(z).b())));
        }
        if (z) {
            a = (String) this.f1004a.get();
            if (!StringUtil.a(a)) {
                a2.add(new BasicNameValuePair("hash_id", a));
            }
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        if (z) {
            newBuilder.b = BootstrapRequestName.SESSIONLESS_GK.requestNameString;
            newBuilder.t = true;
        } else {
            newBuilder.b = BootstrapRequestName.GK_INFO.requestNameString;
        }
        newBuilder.c = TigonRequest.POST;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.d = "method/mobile.gatekeepers";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = a2;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder.v = FallbackBehavior.FALLBACK_REQUIRED;
        return new ApiRequest(newBuilder);
    }

    public final Object m1322a(Object obj, ApiResponse apiResponse) {
        boolean z = ((FetchGatekeepersParams) obj).f1003b == Session.IS_SESSIONLESS;
        try {
            JsonNode c = apiResponse.c();
            m1320a(z, this.f1010g);
            String B = c.b("result").B();
            String B2 = c.b("hash").B();
            String a = m1318a(B);
            Bundle bundle = new Bundle();
            if (B2.equalsIgnoreCase(a)) {
                char[] toCharArray = B.toCharArray();
                Preconditions.b(toCharArray.length == m1317a(z).a());
                boolean[] zArr = new boolean[toCharArray.length];
                for (int i = 0; i < toCharArray.length; i++) {
                    boolean z2;
                    if (toCharArray[i] == '1') {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zArr[i] = z2;
                }
                bundle.putBooleanArray("gatekeepers", zArr);
                if (!z) {
                    m1319a(a, B);
                }
            }
            return bundle;
        } catch (ApiException e) {
            m1320a(z, "");
            throw e;
        }
    }

    @Inject
    public FetchMobileGatekeepersMethod(Provider<String> provider, FbSharedPreferences fbSharedPreferences, GenericAnalyticsCounters genericAnalyticsCounters, AnalyticsConfig analyticsConfig, GatekeeperStoreConfig gatekeeperStoreConfig, GatekeeperStoreConfig gatekeeperStoreConfig2) {
        this.f1004a = provider;
        this.f1005b = fbSharedPreferences;
        this.f1006c = genericAnalyticsCounters;
        this.f1007d = analyticsConfig;
        this.f1008e = gatekeeperStoreConfig;
        this.f1009f = gatekeeperStoreConfig2;
    }

    private GatekeeperStoreConfig m1317a(boolean z) {
        return z ? this.f1009f : this.f1008e;
    }

    @VisibleForTesting
    private void m1319a(String str, String str2) {
        if (this.f1007d.a() == Level.CORE_AND_SAMPLED) {
            int a = this.f1005b.a(GkPrefKeys.d, 0);
            int hashCode = HashCodeBuilder.a().a(str).a(str2).hashCode();
            this.f1006c.a("gatekeepes_fetches", 1);
            if (a == hashCode) {
                this.f1006c.a("gatekeepes_unchanged", 1);
            } else {
                this.f1005b.edit().a(GkPrefKeys.d, hashCode).commit();
            }
        }
    }

    @VisibleForTesting
    private void m1320a(boolean z, String str) {
        Editor edit = this.f1005b.edit();
        if (z) {
            edit.a(SessionlessGkPrefKeys.f45c, str);
        } else {
            edit.a(GkPrefKeys.f, str);
        }
        edit.commit();
    }

    @VisibleForTesting
    private static String m1318a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte valueOf : digest) {
                stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%02X", Byte.valueOf(valueOf)));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (UnsupportedEncodingException e2) {
            return "";
        }
    }
}
