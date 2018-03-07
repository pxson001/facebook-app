package com.facebook.events.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;

/* compiled from: audio_recorder_button */
public class EditEventMethod implements ApiMethod<EditEventParams, Boolean> {
    public final ApiRequest m19252a(Object obj) {
        EditEventParams editEventParams = (EditEventParams) obj;
        return new ApiRequest("graphEventEdit", "POST", editEventParams.f19046a, editEventParams.mo855a(), ApiResponseType.JSON);
    }

    public final Object m19253a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
