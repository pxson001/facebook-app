package com.facebook.abtest.qe.protocol.sync.Logging;

import com.facebook.abtest.qe.protocol.sync.QuickExperimentApiMethodsHelper;
import com.facebook.abtest.qe.protocol.sync.QuickExperimentLoggingParams;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.FallbackBehavior;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: time= */
public class QuickExperimentLoggingMethod implements ApiMethod<QuickExperimentLoggingParams, Void> {
    private static final Class<?> f1048a = QuickExperimentLoggingMethod.class;
    private final QuickExperimentApiMethodsHelper f1049b;

    public final ApiRequest m1346a(Object obj) {
        QuickExperimentLoggingParams quickExperimentLoggingParams = (QuickExperimentLoggingParams) obj;
        List a = Lists.a();
        m1345a(a, "experiment", QuickExperimentApiMethodsHelper.m1348a(quickExperimentLoggingParams.b));
        m1345a(a, "hash", quickExperimentLoggingParams.c);
        m1345a(a, "log_event", quickExperimentLoggingParams.d);
        m1345a(a, "log_event_name", quickExperimentLoggingParams.e);
        m1345a(a, "log_data", quickExperimentLoggingParams.f);
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "log_to_qe";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "/me/test_experiments";
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.c = TigonRequest.POST;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.g = a;
        ApiRequestBuilder a2 = apiRequestBuilder2.a(RequestPriority.CAN_WAIT);
        a2.k = ApiResponseType.JSON;
        a2 = a2;
        a2.v = FallbackBehavior.FALLBACK_REQUIRED;
        return a2.C();
    }

    @Inject
    public QuickExperimentLoggingMethod(QuickExperimentApiMethodsHelper quickExperimentApiMethodsHelper) {
        this.f1049b = quickExperimentApiMethodsHelper;
    }

    private static void m1345a(List<NameValuePair> list, String str, String str2) {
        if (str2 != null) {
            list.add(new BasicNameValuePair(str, str2));
        }
    }

    public final Object m1347a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
