package com.facebook.katana.server.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: toti95memproupdodidfde0109wiisitikil585750swelen1110umjkja606869hjamalasazfyfi242521yf76757470kakypuphpibebabi8084quvavfpete4740 */
public class FetchFacewebComponentsMethod implements ApiMethod<Void, FacewebComponentsStore> {
    private final JsonFactory f1171a;

    @Inject
    public FetchFacewebComponentsMethod(JsonFactory jsonFactory) {
        this.f1171a = jsonFactory;
    }

    public final ApiRequest m1195a(Object obj) {
        return new ApiRequest("fetchFwComponents", "GET", "method/fwcomponents.get", ImmutableList.of(new BasicNameValuePair("format", "json")), ApiResponseType.STRING);
    }

    public final Object m1196a(Object obj, ApiResponse apiResponse) {
        return FacewebComponentsStore.a(apiResponse.b(), this.f1171a);
    }
}
