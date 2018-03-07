package com.facebook.http.protocol;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: releaseFromParent() has been called with refCount == 0 */
class ApiResponseHandler<PARAMS, RESULT> implements ResponseHandler<ApiResponseAndResult<RESULT>> {
    private final ApiRequest f7677a;
    @Nullable
    private final PARAMS f7678b;
    private final ApiMethod<PARAMS, RESULT> f7679c;
    private final ApiResponseChecker f7680d;
    private final JsonFactory f7681e;
    private final ObjectMapper f7682f;

    public ApiResponseHandler(ApiRequest apiRequest, @Nullable PARAMS params, ApiMethod<PARAMS, RESULT> apiMethod, ApiResponseChecker apiResponseChecker, JsonFactory jsonFactory, ObjectMapper objectMapper) {
        this.f7677a = (ApiRequest) Preconditions.checkNotNull(apiRequest);
        this.f7678b = params;
        this.f7679c = (ApiMethod) Preconditions.checkNotNull(apiMethod);
        this.f7680d = (ApiResponseChecker) Preconditions.checkNotNull(apiResponseChecker);
        this.f7681e = (JsonFactory) Preconditions.checkNotNull(jsonFactory);
        this.f7682f = (ObjectMapper) Preconditions.checkNotNull(objectMapper);
    }

    public Object handleResponse(HttpResponse httpResponse) {
        ApiResponse b = m12222b(httpResponse);
        try {
            ApiResponseAndResult apiResponseAndResult = new ApiResponseAndResult(b, this.f7679c.mo673a(this.f7678b, b));
            b.m22210h();
            return apiResponseAndResult;
        } catch (Exception e) {
            throw IOExecutionExceptionWrapper.a(e);
        } catch (Throwable th) {
            b.m22210h();
        }
    }

    private ApiResponse m12222b(HttpResponse httpResponse) {
        ApiResponseType apiResponseType;
        boolean a = UDPPrimingHelper.m9446a(httpResponse);
        if ((httpResponse.getFirstHeader("x-flatbuffer-fallback-json") != null ? 1 : null) != null) {
            apiResponseType = ApiResponseType.JSONPARSER;
        } else {
            apiResponseType = this.f7677a.f7506k;
        }
        if (apiResponseType == ApiResponseType.JSONPARSER) {
            this.f7680d.m11768a(httpResponse);
            JsonParser a2 = this.f7681e.m7162a(httpResponse.getEntity().getContent());
            a2.mo1763a(this.f7682f);
            return new ApiResponse(this.f7677a, httpResponse.getStatusLine().getStatusCode(), a2, this.f7680d, a);
        } else if (apiResponseType == ApiResponseType.STREAM || apiResponseType == ApiResponseType.FLATBUFFER) {
            this.f7680d.m11768a(httpResponse);
            return new ApiResponse(this.f7677a, httpResponse.getStatusLine().getStatusCode(), httpResponse.getEntity().getContent(), this.f7680d, a);
        } else if (apiResponseType == ApiResponseType.JSON) {
            return new ApiResponse(this.f7677a, httpResponse.getStatusLine().getStatusCode(), new JsonResponseHandler(this.f7682f, this.f7680d).m32207a(httpResponse), this.f7680d, a);
        } else if (apiResponseType == ApiResponseType.STRING) {
            return new ApiResponse(this.f7677a, httpResponse.getStatusLine().getStatusCode(), new StringResponseHandler(this.f7680d).a(httpResponse), this.f7680d, a);
        } else {
            throw new IllegalArgumentException("Unknown api response type");
        }
    }
}
