package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.RemoveMemberParams;
import com.facebook.user.model.UserFbidIdentifier;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: ctor */
public class RemoveMemberMethod implements ApiMethod<RemoveMemberParams, Void> {
    public final Provider<String> f16968a;
    private final PickedUserUtils f16969b;

    public final ApiRequest m17018a(Object obj) {
        RemoveMemberParams removeMemberParams = (RemoveMemberParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("id", "t_" + removeMemberParams.f17277b.i()));
        int i = 0;
        if (removeMemberParams.f17278c.size() == 1) {
            i = Objects.equal(((UserFbidIdentifier) removeMemberParams.f17278c.get(0)).a(), this.f16968a.get());
        }
        if (i == 0) {
            a.add(new BasicNameValuePair("to", PickedUserUtils.m16999b(removeMemberParams.f17278c).toString()));
        }
        return new ApiRequest("removeMembers", "DELETE", "/participants", a, ApiResponseType.STRING);
    }

    @Inject
    public RemoveMemberMethod(Provider<String> provider, PickedUserUtils pickedUserUtils) {
        this.f16968a = provider;
        this.f16969b = pickedUserUtils;
    }

    public final Object m17019a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
