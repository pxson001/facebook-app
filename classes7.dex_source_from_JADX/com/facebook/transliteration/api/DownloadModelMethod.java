package com.facebook.transliteration.api;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: experience_type */
public class DownloadModelMethod implements ApiMethod<DownloadModelParams, TransliterationModelResponse> {
    public final ApiRequest m19144a(Object obj) {
        DownloadModelParams downloadModelParams = (DownloadModelParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("algorithm", String.valueOf(downloadModelParams.f15148a)));
        arrayList.add(new BasicNameValuePair("language", String.valueOf(downloadModelParams.f15149b)));
        arrayList.add(new BasicNameValuePair("version", String.valueOf(downloadModelParams.f15151d)));
        arrayList.add(new BasicNameValuePair("dictionary", String.valueOf(downloadModelParams.f15150c)));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "TransliterationGetModel";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "transliteration_model";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        return apiRequestBuilder.C();
    }

    public final Object m19145a(Object obj, ApiResponse apiResponse) {
        if (apiResponse.a() != 200) {
            return null;
        }
        try {
            return (TransliterationModelResponse) apiResponse.d().a(TransliterationModelResponse.class);
        } catch (IOException e) {
            return null;
        }
    }
}
