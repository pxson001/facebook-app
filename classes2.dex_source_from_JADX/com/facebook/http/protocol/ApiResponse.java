package com.facebook.http.protocol;

import com.facebook.common.io.FbCloseables;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.InputStream;

/* compiled from: mFrameCount */
public class ApiResponse {
    public final ApiRequest f15570a;
    public final int f15571b;
    public final Object f15572c;
    private final ApiResponseChecker f15573d;
    private final boolean f15574e;

    public ApiResponse(ApiRequest apiRequest, int i, String str, ApiResponseChecker apiResponseChecker, boolean z) {
        this(apiRequest, i, (Object) str, apiResponseChecker, z);
    }

    public ApiResponse(ApiRequest apiRequest, int i, JsonNode jsonNode, ApiResponseChecker apiResponseChecker, boolean z) {
        this(apiRequest, i, (Object) jsonNode, apiResponseChecker, z);
    }

    public ApiResponse(ApiRequest apiRequest, int i, JsonParser jsonParser, ApiResponseChecker apiResponseChecker, boolean z) {
        this(apiRequest, i, (Object) jsonParser, apiResponseChecker, z);
    }

    public ApiResponse(ApiRequest apiRequest, int i, InputStream inputStream, ApiResponseChecker apiResponseChecker, boolean z) {
        this(apiRequest, i, (Object) inputStream, apiResponseChecker, z);
    }

    @VisibleForTesting
    private ApiResponse(ApiRequest apiRequest, int i, Object obj, ApiResponseChecker apiResponseChecker, boolean z) {
        this.f15570a = apiRequest;
        this.f15571b = i;
        this.f15572c = obj;
        this.f15573d = apiResponseChecker;
        this.f15574e = z;
    }

    public final int m22203a() {
        return this.f15571b;
    }

    public final String m22204b() {
        Preconditions.checkState(this.f15572c instanceof String, "No response body.");
        m22211i();
        return (String) this.f15572c;
    }

    public final JsonNode m22205c() {
        Preconditions.checkState(this.f15572c instanceof JsonNode, "No response json node.");
        m22211i();
        return (JsonNode) this.f15572c;
    }

    public final JsonParser m22206d() {
        Preconditions.checkState(this.f15572c instanceof JsonParser, "No response json parser.");
        return (JsonParser) this.f15572c;
    }

    public final InputStream m22207e() {
        Preconditions.checkState(this.f15572c instanceof InputStream, "No response input stream.");
        return (InputStream) this.f15572c;
    }

    public final Object m22208f() {
        return this.f15572c;
    }

    public final boolean m22209g() {
        return this.f15574e;
    }

    final void m22210h() {
        if ((this.f15572c instanceof JsonParser) || (this.f15572c instanceof InputStream)) {
            FbCloseables.m25418a((Closeable) this.f15572c);
        }
    }

    public final void m22211i() {
        if (this.f15572c instanceof String) {
            this.f15573d.m11767a((String) this.f15572c);
        } else if (this.f15572c instanceof JsonNode) {
            this.f15573d.m11766a((JsonNode) this.f15572c);
        }
    }
}
