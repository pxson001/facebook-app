package com.facebook.resources.impl.loading;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.impl.FbResourcesLogger;
import com.facebook.resources.impl.loading.LanguageRequest.Type;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_DELETE_POSTS */
public class GetLanguagePackInfoMethod implements ApiMethod<Params, LanguagePackInfo> {
    private final FbResourcesLogger f12515a;

    /* compiled from: PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_DELETE_POSTS */
    public abstract class LanguagePackInfoException extends Exception {
    }

    /* compiled from: PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_DELETE_POSTS */
    public class InvalidLanguagePackInfoException extends LanguagePackInfoException {
    }

    /* compiled from: PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_DELETE_POSTS */
    public class NoLanguagePackInfoException extends LanguagePackInfoException {
    }

    /* compiled from: PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_DELETE_POSTS */
    public class Params {
        public final LanguageRequest f12514a;

        public Params(LanguageRequest languageRequest) {
            this.f12514a = languageRequest;
        }

        public static List m12916b(Params params) {
            List a = Lists.a();
            a.add(new BasicNameValuePair("app_locale", m12917c(params)));
            if (!params.f12514a.b.d()) {
                a.add(new BasicNameValuePair("release_number", Integer.toString(params.f12514a.c())));
            }
            a.add(new BasicNameValuePair("release_package", params.f12514a.a.getPackageName()));
            if (params.f12514a.d == Type.PREFETCH) {
                a.add(new BasicNameValuePair("is_prefetch", "true"));
            }
            ArrayNode b = JsonNodeFactory.a.b();
            b.h("download_url");
            b.h("download_checksum");
            b.h("release_number");
            a.add(new BasicNameValuePair("fields", b.toString()));
            return a;
        }

        public static String m12917c(Params params) {
            return params.f12514a.d();
        }

        @VisibleForTesting
        final Map<String, String> m12918a() {
            List<NameValuePair> b = m12916b(this);
            Map<String, String> hashMap = new HashMap();
            for (NameValuePair nameValuePair : b) {
                hashMap.put("request_" + nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        }
    }

    public static GetLanguagePackInfoMethod m12920b(InjectorLike injectorLike) {
        return new GetLanguagePackInfoMethod(FbResourcesLogger.a(injectorLike));
    }

    public final ApiRequest m12921a(Object obj) {
        Params params = (Params) obj;
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "getLanguagePackInfo";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "language_packs";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "GET";
        apiRequestBuilder = apiRequestBuilder.a(params.f12514a.g());
        apiRequestBuilder.g = Params.m12916b(params);
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m12922a(Object obj, ApiResponse apiResponse) {
        Params params = (Params) obj;
        ArrayNode arrayNode = (ArrayNode) apiResponse.c().b("data");
        m12919a(arrayNode, params);
        String c = Params.m12917c(params);
        try {
            JsonNode a = arrayNode.a(0);
            String s = a.b("download_url").s();
            String s2 = a.b("download_checksum").s();
            int b = a.b("release_number").b(0);
            if (s != null && b != 0 && s2 != null && c != null) {
                return new LanguagePackInfo(s, b, s2, c);
            }
            this.f12515a.c(params.m12918a());
            throw new InvalidLanguagePackInfoException();
        } catch (Exception e) {
            this.f12515a.b(params.m12918a());
            throw e;
        }
    }

    @Inject
    public GetLanguagePackInfoMethod(FbResourcesLogger fbResourcesLogger) {
        this.f12515a = fbResourcesLogger;
    }

    private void m12919a(ArrayNode arrayNode, Params params) {
        if (arrayNode == null) {
            this.f12515a.c(params.m12918a());
            throw new InvalidLanguagePackInfoException();
        } else if (arrayNode.e() == 0) {
            if (params.f12514a.d != Type.PREFETCH) {
                this.f12515a.d(params.m12918a());
            }
            throw new NoLanguagePackInfoException();
        } else if (arrayNode.e() > 1) {
            this.f12515a.a(params.m12918a());
        }
    }
}
