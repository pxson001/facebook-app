package com.facebook.messaging.business.nativesignup.protocol;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.messaging.business.nativesignup.protocol.methods.ProxyLoginMethod;
import com.facebook.messaging.business.nativesignup.protocol.methods.ThirdPartyRegistrationMethod;
import com.facebook.messaging.business.nativesignup.protocol.methods.ThirdPartyRegistrationMethod.Params;
import javax.inject.Inject;

/* compiled from: multipart/mixed */
public class NativeSignUpServiceHandler implements BlueServiceHandler {
    public final ApiMethodRunnerImpl f8904a;
    public final ProxyLoginMethod f8905b;
    public final ThirdPartyRegistrationMethod f8906c;

    @Inject
    public NativeSignUpServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, ProxyLoginMethod proxyLoginMethod, ThirdPartyRegistrationMethod thirdPartyRegistrationMethod) {
        this.f8904a = apiMethodRunnerImpl;
        this.f8905b = proxyLoginMethod;
        this.f8906c = thirdPartyRegistrationMethod;
    }

    public final OperationResult m9168a(OperationParams operationParams) {
        String str = operationParams.b;
        if (str.equals("create_account")) {
            Batch a = this.f8904a.a();
            Params params = (Params) operationParams.c.getParcelable("third_party_registration_params");
            Builder a2 = BatchOperation.a(this.f8905b, (ProxyLoginMethod.Params) operationParams.c.getParcelable("proxy_login_params"));
            a2.c = "proxy_login";
            a.a(a2.a());
            a2 = BatchOperation.a(this.f8906c, params);
            a2.c = "third_party_registration";
            a2 = a2;
            a2.d = "proxy_login";
            a2 = a2;
            a2.g = "?access_token={result=proxy_login:$.access_token}";
            a.a(a2.a());
            a.a("nativeSignUpCreateAccount", CallerContext.a(getClass()));
            return OperationResult.a;
        }
        throw new IllegalArgumentException("Unrecognized operation type: " + str);
    }
}
