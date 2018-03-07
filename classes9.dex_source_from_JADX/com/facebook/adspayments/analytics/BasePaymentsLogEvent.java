package com.facebook.adspayments.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import javax.annotation.Nullable;

/* compiled from: sender_name */
public abstract class BasePaymentsLogEvent<T extends BasePaymentsLogEvent> extends HoneyClientEvent {
    public PaymentsFlowContext f3975c;
    private Throwable f3976d;
    private String f3977e;

    protected abstract String mo130w();

    public BasePaymentsLogEvent(String str, PaymentsFlowContext paymentsFlowContext) {
        super(str);
        this.f3975c = paymentsFlowContext;
        this.c = mo130w();
        a("flow_context_id", paymentsFlowContext.f3968c);
        m3867c("payment_account_id", paymentsFlowContext.f3969d);
    }

    public final void m3867c(String str, @Nullable String str2) {
        if (!StringUtil.a(str2)) {
            b(str, str2);
        }
    }

    public final T m3868o(String str) {
        Preconditions.checkState(this.f3976d == null);
        this.f3977e = str;
        a("error_code", 0);
        b("error_message", str);
        return this;
    }

    public final T m3866a(Throwable th) {
        Preconditions.checkState(this.f3977e == null);
        this.f3976d = th;
        String str = "error_stacktrace";
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (String h : m3865d(th)) {
            arrayNode.h(h);
        }
        a(str, arrayNode);
        ApiException apiException = (ApiException) ExceptionUtil.a(th, ApiException.class);
        if (apiException != null) {
            ApiErrorResult b = apiException.b();
            a("error_code", b.a());
            b("error_message", b.c());
            b("exception_domain", "FBAPIErrorDomain");
        } else {
            b("error_message", Throwables.getRootCause(th).getMessage());
            ServiceException serviceException = (ServiceException) ExceptionUtil.a(th, ServiceException.class);
            if (serviceException != null) {
                a("error_code", serviceException.errorCode.getAsInt());
                b("exception_domain", "FBServiceErrorDomain");
            } else {
                a("error_code", 0);
                b("exception_domain", "FBAdsPaymentsDomain");
            }
        }
        return this;
    }

    @VisibleForTesting
    public static String[] m3865d(Throwable th) {
        return Throwables.getStackTraceAsString(th).split("\n");
    }
}
