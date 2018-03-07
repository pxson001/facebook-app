package com.facebook.captcha.service;

import android.os.Bundle;
import com.facebook.captcha.protocol.RequestCaptchaMethod;
import com.facebook.captcha.protocol.RequestCaptchaMethod.Result;
import com.facebook.captcha.protocol.SolveCaptchaMethod;
import com.facebook.captcha.protocol.SolveCaptchaMethod.Params;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: isDefaultLandingPage */
public class CaptchaServiceHandler implements BlueServiceHandler {
    public final Provider<SingleMethodRunner> f10674a;
    public final Lazy<RequestCaptchaMethod> f10675b;
    public final Lazy<SolveCaptchaMethod> f10676c;

    @Inject
    public CaptchaServiceHandler(Provider<SingleMethodRunner> provider, Lazy<RequestCaptchaMethod> lazy, Lazy<SolveCaptchaMethod> lazy2) {
        this.f10674a = provider;
        this.f10675b = lazy;
        this.f10676c = lazy2;
    }

    public final OperationResult m12610a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("request_captcha".equals(str)) {
            return OperationResult.a((Result) ((AbstractSingleMethodRunner) this.f10674a.get()).a((ApiMethod) this.f10675b.get(), null));
        }
        if ("solve_captcha".equals(str)) {
            OperationResult a;
            Bundle bundle = operationParams.c;
            if (bundle == null) {
                a = OperationResult.a(ErrorCode.OTHER, "operation params are null");
            } else {
                a = ((Boolean) ((AbstractSingleMethodRunner) this.f10674a.get()).a((ApiMethod) this.f10676c.get(), (Params) bundle.getParcelable("solveCaptchaParamsKey"), operationParams.e)).booleanValue() ? OperationResult.a : OperationResult.a(ErrorCode.OTHER);
            }
            return a;
        }
        throw new ApiMethodNotFoundException(str);
    }
}
