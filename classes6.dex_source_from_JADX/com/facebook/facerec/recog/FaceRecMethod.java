package com.facebook.facerec.recog;

import com.facebook.debug.log.BLog;
import com.facebook.facerec.manager.LocalSuggestionsStore;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.ByteArrayBody;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.base.tagging.FaceBox;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: no_source */
public class FaceRecMethod implements ApiMethod<FaceRecParams, FaceRecResponse> {
    private final LocalSuggestionsStore f9945a;
    private final PerformanceLogger f9946b;

    private static FaceRecMethod m15662b(InjectorLike injectorLike) {
        return new FaceRecMethod(LocalSuggestionsStore.m15642b(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    public final ApiRequest m15663a(Object obj) {
        FaceRecParams faceRecParams = (FaceRecParams) obj;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("format", "JSON"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "facerec";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "method/photos.getSuggestedTags";
        newBuilder = newBuilder;
        List a = Lists.a();
        for (FaceBox faceBox : faceRecParams.f9948b) {
            if (!(faceBox == null || faceBox.f12774j == null)) {
                a.add(new FormBodyPart(faceBox.f12765a, new ByteArrayBody(faceBox.f12774j, "image/jpeg", faceBox.f12765a)));
            }
        }
        newBuilder.l = a;
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m15664a(Object obj, ApiResponse apiResponse) {
        FaceRecParams faceRecParams = (FaceRecParams) obj;
        ((ObjectNode) apiResponse.c).toString();
        Object faceRecResponse = new FaceRecResponse(this.f9945a);
        if (apiResponse.b == 200) {
            return faceRecResponse.m15665a(apiResponse, faceRecParams.f9947a);
        }
        BLog.b("FaceRecMethod", "HTTP Error: " + apiResponse.b);
        this.f9946b.a(3866625, "FaceRecServerCommunication");
        faceRecParams.f9947a.a("FaceRecMethod", "HTTP Error: " + apiResponse.c.toString());
        return faceRecResponse;
    }

    @Inject
    public FaceRecMethod(LocalSuggestionsStore localSuggestionsStore, PerformanceLogger performanceLogger) {
        this.f9945a = localSuggestionsStore;
        this.f9946b = performanceLogger;
    }
}
