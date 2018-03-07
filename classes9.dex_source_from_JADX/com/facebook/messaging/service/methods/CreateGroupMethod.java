package com.facebook.messaging.service.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.CreateGroupParams;
import com.facebook.user.model.UserFbidIdentifier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: payments_select_new_payment_method_initiated */
public class CreateGroupMethod implements ApiMethod<CreateGroupParams, String> {
    private final Provider<String> f16864a;
    private final PickedUserUtils f16865b;

    public final ApiRequest m16865a(Object obj) {
        CreateGroupParams createGroupParams = (CreateGroupParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("name", createGroupParams.f17017a));
        ImmutableList immutableList = createGroupParams.f17019c;
        List arrayList = new ArrayList(immutableList.size() + 1);
        arrayList.add(new UserFbidIdentifier((String) this.f16864a.get()));
        arrayList.addAll(immutableList);
        a.add(new BasicNameValuePair("recipients", PickedUserUtils.m16998a(arrayList).toString()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "createGroup";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/group_threads";
        newBuilder = newBuilder;
        newBuilder.g = a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Inject
    public CreateGroupMethod(Provider<String> provider, PickedUserUtils pickedUserUtils) {
        this.f16865b = pickedUserUtils;
        this.f16864a = provider;
    }

    public final Object m16866a(Object obj, ApiResponse apiResponse) {
        return JSONUtil.b(apiResponse.c().b("thread_id"));
    }
}
