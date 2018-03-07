package com.facebook.messaging.service.methods;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.time.Clock;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.PinnedThreadIdsResult;
import com.facebook.messaging.service.model.FetchPinnedThreadsParams;
import com.facebook.messaging.service.model.FetchPinnedThreadsResult;
import com.facebook.messaging.service.model.FetchPinnedThreadsResultBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: d_tm */
public class FetchPinnedThreadsMethod implements ApiMethod<FetchPinnedThreadsParams, FetchPinnedThreadsResult> {
    public static final Class<?> f16888a = FetchPinnedThreadsMethod.class;
    private final Clock f16889b;
    public final FetchThreadsFqlHelper f16890c;
    public final AbstractFbErrorReporter f16891d;

    public final ApiRequest m16911a(Object obj) {
        FetchPinnedThreadsParams fetchPinnedThreadsParams = (FetchPinnedThreadsParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        FetchThreadsFqlHelper.m16934a(fqlMultiQueryHelper, fetchPinnedThreadsParams.f17096c, 60);
        FetchThreadsFqlHelper.m16939b(fqlMultiQueryHelper);
        this.f16890c.m16949a(fqlMultiQueryHelper, "thread_id IN (SELECT thread_id FROM #pinned_thread_ids) AND folder='inbox'", 60, true);
        a.add(new BasicNameValuePair("q", fqlMultiQueryHelper.a().toString()));
        return new ApiRequest("fetchPinnedThreads", "GET", "fql", a, ApiResponseType.JSON);
    }

    @Inject
    public FetchPinnedThreadsMethod(Clock clock, FetchThreadsFqlHelper fetchThreadsFqlHelper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f16889b = clock;
        this.f16890c = fetchThreadsFqlHelper;
        this.f16891d = abstractFbErrorReporter;
    }

    public final Object m16912a(Object obj, ApiResponse apiResponse) {
        FqlResultHelper fqlResultHelper = new FqlResultHelper(apiResponse.c());
        PinnedThreadIdsResult b = FetchThreadsFqlHelper.m16937b(fqlResultHelper);
        ImmutableMap immutableMap = this.f16890c.m16955c(fqlResultHelper).f16915b;
        ImmutableList<String> immutableList = b.f16907a;
        Builder builder = ImmutableList.builder();
        for (String str : immutableList) {
            ThreadSummary threadSummary = (ThreadSummary) immutableMap.get(str);
            if (threadSummary == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("missing thread id: ");
                stringBuilder.append(str);
                stringBuilder.append("\n");
                stringBuilder.append(Arrays.toString(immutableMap.keySet().toArray()));
                this.f16891d.a(SoftError.a(f16888a.getSimpleName(), stringBuilder.toString()).g());
            } else if (threadSummary.A != FolderName.NONE) {
                builder.c(threadSummary);
            }
        }
        List b2 = builder.b();
        FetchPinnedThreadsResultBuilder newBuilder = FetchPinnedThreadsResult.newBuilder();
        newBuilder.f17104a = b2;
        FetchPinnedThreadsResultBuilder fetchPinnedThreadsResultBuilder = newBuilder;
        fetchPinnedThreadsResultBuilder.f17105b = b.f16909c;
        fetchPinnedThreadsResultBuilder = fetchPinnedThreadsResultBuilder;
        fetchPinnedThreadsResultBuilder.f17106c = b.f16908b;
        FetchPinnedThreadsResultBuilder fetchPinnedThreadsResultBuilder2 = fetchPinnedThreadsResultBuilder;
        fetchPinnedThreadsResultBuilder2.f17107d = this.f16889b.a();
        return fetchPinnedThreadsResultBuilder2.m17097e();
    }
}
