package com.facebook.contactlogs.protocol;

import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.contactlogs.data.ContactLogMetadata;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: profile_nux_entry_point_close_button_tapped */
public class UploadContactLogsMethod implements ApiMethod<ImmutableMap<String, ImmutableList<ContactLogMetadata>>, ServerStatusCode> {
    private ContactLogsUploadHelper f6172a;

    /* compiled from: profile_nux_entry_point_close_button_tapped */
    public enum ServerStatusCode {
        SUCCESS(0),
        FAIL(1),
        RETRY(2),
        UNKNOWN(3);
        
        public final int statusCode;

        private ServerStatusCode(int i) {
            this.statusCode = i;
        }
    }

    public static UploadContactLogsMethod m6511b(InjectorLike injectorLike) {
        return new UploadContactLogsMethod(new ContactLogsUploadHelper(JsonFactoryMethodAutoProvider.a(injectorLike)));
    }

    public final ApiRequest m6512a(Object obj) {
        ImmutableMap immutableMap = (ImmutableMap) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "MobileUploadContactLog";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "method/friendFinder.mobilecalllogsync";
        newBuilder = newBuilder;
        newBuilder.g = this.f6172a.m6503a(immutableMap);
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Inject
    public UploadContactLogsMethod(ContactLogsUploadHelper contactLogsUploadHelper) {
        this.f6172a = contactLogsUploadHelper;
    }

    public final Object m6513a(Object obj, ApiResponse apiResponse) {
        return ServerStatusCode.values()[JSONUtil.a(apiResponse.c().b("server_status"), ServerStatusCode.UNKNOWN.ordinal())];
    }
}
