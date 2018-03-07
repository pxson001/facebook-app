package com.facebook.appirater.api;

import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import javax.inject.Inject;

/* compiled from: cta_lead_gen_back_button_click */
public class AppiraterServiceHandler implements BlueServiceHandler {
    private final ApiMethodRunnerImpl f16480a;
    private final AppRaterShouldAskUserApiMethod f16481b;
    private final AppRaterCreateApiMethod f16482c;

    @Inject
    public AppiraterServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, AppRaterShouldAskUserApiMethod appRaterShouldAskUserApiMethod, AppRaterCreateApiMethod appRaterCreateApiMethod) {
        this.f16480a = apiMethodRunnerImpl;
        this.f16481b = appRaterShouldAskUserApiMethod;
        this.f16482c = appRaterCreateApiMethod;
    }

    private OperationResult m20541a() {
        try {
            return OperationResult.a((FetchISRConfigResult) this.f16480a.a(this.f16481b, null));
        } catch (ApiException e) {
            return OperationResult.a(ErrorCode.API_ERROR, e);
        }
    }

    private OperationResult m20542b(OperationParams operationParams) {
        try {
            this.f16480a.a(this.f16482c, (AppRaterReport) operationParams.b().getParcelable("app_rater_report"));
            return OperationResult.a();
        } catch (ApiException e) {
            return OperationResult.a(ErrorCode.API_ERROR, e);
        }
    }

    public final OperationResult m20543a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("appirater_should_show_dialog".equals(str)) {
            return m20541a();
        }
        if ("appirater_create_report".equals(str)) {
            return m20542b(operationParams);
        }
        throw new ApiMethodNotFoundException(str);
    }
}
