package com.facebook.abtest.qe.protocol.sync.user;

import com.facebook.abtest.qe.protocol.sync.QuickExperimentApiMethodsHelper;
import com.facebook.abtest.qe.protocol.sync.SyncMultiQuickExperimentParams;
import com.facebook.abtest.qe.protocol.sync.SyncQuickExperimentParams;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.FallbackBehavior;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.security.MessageDigest;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: thumbnail_size */
public class SyncMultiQuickExperimentUserInfoMethod implements ApiMethod<SyncMultiQuickExperimentParams, SyncMultiQuickExperimentUserInfoResult> {
    private static final PrefKey f1068a = ((PrefKey) SharedPrefKeys.d.a("qe_last_fetch_ids_hash"));
    private final GatekeeperStoreImpl f1069b;
    private final LoggedInUserSessionManager f1070c;
    private final SyncMultiQuickExperimentUserInfoResultHelper f1071d;
    private final FbSharedPreferences f1072e;
    private String f1073f;
    private boolean f1074g;

    public static SyncMultiQuickExperimentUserInfoMethod m1361a(InjectorLike injectorLike) {
        return new SyncMultiQuickExperimentUserInfoMethod(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), new SyncMultiQuickExperimentUserInfoResultHelper(), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    public final ApiRequest m1364a(Object obj) {
        String a;
        ApiRequestBuilder newBuilder;
        ApiRequestBuilder apiRequestBuilder;
        SyncMultiQuickExperimentParams syncMultiQuickExperimentParams = (SyncMultiQuickExperimentParams) obj;
        this.f1073f = "";
        this.f1074g = syncMultiQuickExperimentParams.f1112c;
        List a2 = Lists.a();
        a2.add(new BasicNameValuePair("format", "json"));
        a2.add(new BasicNameValuePair("member", syncMultiQuickExperimentParams.f1111b));
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        ArrayNode arrayNode2 = new ArrayNode(JsonNodeFactory.a);
        ImmutableList immutableList = syncMultiQuickExperimentParams.f1110a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SyncQuickExperimentParams syncQuickExperimentParams = (SyncQuickExperimentParams) immutableList.get(i);
            arrayNode.h(QuickExperimentApiMethodsHelper.m1348a(syncQuickExperimentParams.f1108a));
            arrayNode2.h(syncQuickExperimentParams.f1109b);
        }
        boolean z = this.f1069b.a(1067, false) && !this.f1074g && this.f1070c.b() && !this.f1070c.d();
        if (z) {
            a = this.f1072e.a(f1068a, "");
            this.f1073f = m1363c(arrayNode.toString());
            if (!StringUtil.c(this.f1073f)) {
                z = this.f1073f.equalsIgnoreCase(a);
                a2.add(new BasicNameValuePair("quick_experiment_ids_hash", this.f1073f));
                a2.add(new BasicNameValuePair("suppress_http_code", ""));
                if (!z) {
                    a2.add(new BasicNameValuePair("quick_experiment_ids", arrayNode.toString()));
                }
                a2.add(new BasicNameValuePair("quick_experiment_hashes", arrayNode2.toString()));
                if (syncMultiQuickExperimentParams.f1112c) {
                    a = "/test_experiment_members";
                } else {
                    a = "/sessionless_test_experiment_members";
                }
                newBuilder = ApiRequest.newBuilder();
                newBuilder.b = "syncUserQE";
                newBuilder = newBuilder;
                newBuilder.c = TigonRequest.GET;
                newBuilder = newBuilder;
                newBuilder.d = a;
                apiRequestBuilder = newBuilder;
                apiRequestBuilder.g = a2;
                apiRequestBuilder = apiRequestBuilder;
                apiRequestBuilder.k = ApiResponseType.JSON;
                apiRequestBuilder = apiRequestBuilder;
                apiRequestBuilder.v = FallbackBehavior.FALLBACK_REQUIRED;
                return apiRequestBuilder.C();
            }
        }
        z = false;
        if (z) {
            a2.add(new BasicNameValuePair("quick_experiment_ids", arrayNode.toString()));
        }
        a2.add(new BasicNameValuePair("quick_experiment_hashes", arrayNode2.toString()));
        if (syncMultiQuickExperimentParams.f1112c) {
            a = "/test_experiment_members";
        } else {
            a = "/sessionless_test_experiment_members";
        }
        newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "syncUserQE";
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.GET;
        newBuilder = newBuilder;
        newBuilder.d = a;
        apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = a2;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.v = FallbackBehavior.FALLBACK_REQUIRED;
        return apiRequestBuilder.C();
    }

    public final Object m1365a(Object obj, ApiResponse apiResponse) {
        SyncMultiQuickExperimentParams syncMultiQuickExperimentParams = (SyncMultiQuickExperimentParams) obj;
        try {
            JsonNode c = apiResponse.c();
            if (!this.f1074g) {
                m1362b(this.f1073f);
            }
            return this.f1071d.m1368a(c, syncMultiQuickExperimentParams);
        } catch (ApiException e) {
            if (!this.f1074g) {
                m1362b("");
            }
            throw e;
        }
    }

    @Inject
    public SyncMultiQuickExperimentUserInfoMethod(GatekeeperStoreImpl gatekeeperStoreImpl, LoggedInUserSessionManager loggedInUserSessionManager, SyncMultiQuickExperimentUserInfoResultHelper syncMultiQuickExperimentUserInfoResultHelper, FbSharedPreferences fbSharedPreferences) {
        this.f1069b = gatekeeperStoreImpl;
        this.f1070c = loggedInUserSessionManager;
        this.f1071d = syncMultiQuickExperimentUserInfoResultHelper;
        this.f1072e = fbSharedPreferences;
    }

    private void m1362b(String str) {
        Editor edit = this.f1072e.edit();
        edit.a(f1068a, str);
        edit.commit();
    }

    private static String m1363c(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte valueOf : digest) {
                stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%02X", Byte.valueOf(valueOf)));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
