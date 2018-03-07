package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.DeleteMessagesParams;
import com.facebook.messaging.threads.util.MessagingIdUtil.C21032;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: date>= */
public class DeleteMessagesMethod implements ApiMethod<DeleteMessagesParams, Void> {
    public final ApiRequest m16879a(Object obj) {
        String join = Joiner.on(",").skipNulls().join(ImmutableList.copyOf(Lists.a(ImmutableList.copyOf(((DeleteMessagesParams) obj).f17026b), new C21032())));
        List a = Lists.a();
        a.add(new BasicNameValuePair("ids", join));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("deleteMessages", "DELETE", "", a, ApiResponseType.STRING);
    }

    public final Object m16880a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
