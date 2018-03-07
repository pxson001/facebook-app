package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.UpdatePinnedThreadsParams;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: creative_spec */
public class UpdatePinnedThreadsMethod implements ApiMethod<UpdatePinnedThreadsParams, Void> {
    private final PinnedThreadsUtils f16992a;

    public final ApiRequest m17073a(Object obj) {
        UpdatePinnedThreadsParams updatePinnedThreadsParams = (UpdatePinnedThreadsParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("tids", PinnedThreadsUtils.m17001a(updatePinnedThreadsParams.f17343a).toString()));
        a.add(new BasicNameValuePair("removed_tids", PinnedThreadsUtils.m17001a(updatePinnedThreadsParams.f17344b).toString()));
        return new ApiRequest("updatePinnedThreads", "POST", "me/pinned_threads", a, ApiResponseType.STRING);
    }

    @Inject
    public UpdatePinnedThreadsMethod(PinnedThreadsUtils pinnedThreadsUtils) {
        this.f16992a = pinnedThreadsUtils;
    }

    public final Object m17074a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
