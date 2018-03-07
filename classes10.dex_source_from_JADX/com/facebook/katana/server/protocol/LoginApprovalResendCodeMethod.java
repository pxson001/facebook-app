package com.facebook.katana.server.protocol;

import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.katana.server.LoginApprovalResendCodeParams;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: total_friends_sharing */
public class LoginApprovalResendCodeMethod implements ApiMethod<LoginApprovalResendCodeParams, Void> {
    public final ApiRequest m1197a(Object obj) {
        LoginApprovalResendCodeParams loginApprovalResendCodeParams = (LoginApprovalResendCodeParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("first_factor", loginApprovalResendCodeParams.b));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "login_approval_resend_code";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = loginApprovalResendCodeParams.a + "/twofacsms";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder a = newBuilder.a(RequestPriority.INTERACTIVE);
        a.k = ApiResponseType.JSON;
        return a.C();
    }

    public final Object m1198a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
