package com.facebook.messaging.service.methods;

import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.facebook.ui.media.attachments.MediaResourceBody;
import com.facebook.ui.media.attachments.MediaResourceBodyFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: crudoNet cannot be null */
public class SetThreadImageMethod implements ApiMethod<ModifyThreadParams, Void> {
    private final MediaResourceBodyFactory f16984a;

    public final ApiRequest m17044a(Object obj) {
        ModifyThreadParams modifyThreadParams = (ModifyThreadParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("tid", modifyThreadParams.m17156q()));
        Object obj2 = null;
        if (modifyThreadParams.f17225e != null) {
            obj2 = m17043b(modifyThreadParams);
        } else {
            a.add(new BasicNameValuePair("delete", "1"));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "setThreadImage";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "method/messaging.setthreadimage";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.STRING;
        apiRequestBuilder = apiRequestBuilder;
        if (obj2 != null) {
            apiRequestBuilder.l = ImmutableList.of(obj2);
        }
        return apiRequestBuilder.C();
    }

    @Inject
    public SetThreadImageMethod(MediaResourceBodyFactory mediaResourceBodyFactory) {
        this.f16984a = mediaResourceBodyFactory;
    }

    public final Object m17045a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }

    private FormBodyPart m17043b(ModifyThreadParams modifyThreadParams) {
        MediaResourceBody a = this.f16984a.a(modifyThreadParams.f17225e);
        if (a != null) {
            return new FormBodyPart("image", a);
        }
        throw new Exception("Failed to attach image");
    }
}
