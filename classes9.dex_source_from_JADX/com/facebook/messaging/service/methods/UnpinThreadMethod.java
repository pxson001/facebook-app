package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.UnpinThreadParams;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: creator_id */
public class UnpinThreadMethod implements ApiMethod<UnpinThreadParams, Void> {
    public final ApiRequest m17071a(Object obj) {
        UnpinThreadParams unpinThreadParams = (UnpinThreadParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("tid", "t_" + unpinThreadParams.f17335a.i()));
        return new ApiRequest("unpinThread", "DELETE", "me/pinned_threads", a, ApiResponseType.STRING);
    }

    @Inject
    public UnpinThreadMethod(PinnedThreadsUtils pinnedThreadsUtils) {
    }

    public final Object m17072a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
