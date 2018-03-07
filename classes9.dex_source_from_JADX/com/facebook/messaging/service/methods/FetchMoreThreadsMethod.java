package com.facebook.messaging.service.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ListUtil;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.ThreadsResult;
import com.facebook.messaging.service.model.FetchMoreThreadsParams;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: dailyBudget */
public class FetchMoreThreadsMethod implements ApiMethod<FetchMoreThreadsParams, FetchMoreThreadsResult> {
    private static final Class<?> f16884a = FetchMoreThreadsMethod.class;
    public final FetchThreadsFqlHelper f16885b;

    public final ApiRequest m16906a(Object obj) {
        FetchMoreThreadsParams fetchMoreThreadsParams = (FetchMoreThreadsParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        FolderName folderName = fetchMoreThreadsParams.f17083a;
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        this.f16885b.m16949a(fqlMultiQueryHelper, StringFormatUtil.formatStrLocaleSafe("folder='%1$s' AND archived=0 AND timestamp <= %2$d", folderName, Long.valueOf(fetchMoreThreadsParams.f17085c)), fetchMoreThreadsParams.f17087e + 1, true);
        a.add(new BasicNameValuePair("q", fqlMultiQueryHelper.a().toString()));
        return new ApiRequest("fetchMoreThreads", "GET", "fql", a, ApiResponseType.JSON);
    }

    public final Object m16907a(Object obj, ApiResponse apiResponse) {
        boolean z;
        FetchMoreThreadsParams fetchMoreThreadsParams = (FetchMoreThreadsParams) obj;
        FqlResultHelper fqlResultHelper = new FqlResultHelper(apiResponse.c());
        int i = fetchMoreThreadsParams.f17087e;
        ThreadsResult c = this.f16885b.m16955c(fqlResultHelper);
        if (c.f16914a.size() < fetchMoreThreadsParams.f17087e + 1) {
            z = true;
        } else {
            z = false;
        }
        return new FetchMoreThreadsResult(DataFetchDisposition.b, fetchMoreThreadsParams.f17083a, new ThreadsCollection((ImmutableList) ListUtil.a(c.f16914a, 0, i), z), c.f16916c, System.currentTimeMillis());
    }

    @Inject
    public FetchMoreThreadsMethod(FetchThreadsFqlHelper fetchThreadsFqlHelper) {
        this.f16885b = fetchThreadsFqlHelper;
    }
}
