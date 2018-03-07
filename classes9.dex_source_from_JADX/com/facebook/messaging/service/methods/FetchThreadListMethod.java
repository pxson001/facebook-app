package com.facebook.messaging.service.methods;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ListUtil;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.ThreadListIdsResult;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.ThreadTable;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.ThreadsResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadListResultBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: d905824ca4ae1ee9b3277236404b2685 */
public class FetchThreadListMethod implements ApiMethod<FetchThreadListParams, FetchThreadListResult> {
    public static final Class<?> f16895a = FetchThreadListMethod.class;
    private final FetchThreadsFqlHelper f16896b;
    public final AbstractFbErrorReporter f16897c;
    private final Provider<Boolean> f16898d;

    public final ApiRequest m16919a(Object obj) {
        FetchThreadListParams fetchThreadListParams = (FetchThreadListParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        if (fetchThreadListParams.f17121e == -1) {
            a.add(new BasicNameValuePair("q", m16917b(fetchThreadListParams)));
        } else {
            a.add(new BasicNameValuePair("q", m16918c(fetchThreadListParams)));
        }
        return new ApiRequest("fetchThreadList", "GET", "fql", fetchThreadListParams.f17123g, a, ApiResponseType.JSON);
    }

    public final Object m16920a(Object obj, ApiResponse apiResponse) {
        boolean z;
        boolean z2;
        FetchThreadListParams fetchThreadListParams = (FetchThreadListParams) obj;
        FqlResultHelper fqlResultHelper = new FqlResultHelper(apiResponse.c());
        if (fetchThreadListParams.f17121e != -1) {
            z = true;
        } else {
            z = false;
        }
        int f = fetchThreadListParams.m17109f();
        ThreadListIdsResult a = FetchThreadsFqlHelper.m16931a(fqlResultHelper);
        ThreadsResult a2 = this.f16896b.m16947a(fqlResultHelper, a.f16913d);
        if (z || a.f16910a.size() >= fetchThreadListParams.m17109f() + 1) {
            z2 = false;
        } else {
            z2 = true;
        }
        ThreadsCollection threadsCollection = new ThreadsCollection(m16916a(a2.f16915b, (ImmutableList) ListUtil.a(a.f16910a, 0, f)), z2);
        FolderName e = FetchThreadsFqlHelper.m16942e(fqlResultHelper);
        FolderCounts f2 = FetchThreadsFqlHelper.m16943f(fqlResultHelper);
        NotificationSetting g = FetchThreadsFqlHelper.m16944g(fqlResultHelper);
        FetchThreadListResultBuilder newBuilder = FetchThreadListResult.newBuilder();
        newBuilder.f17143a = DataFetchDisposition.b;
        newBuilder = newBuilder;
        newBuilder.f17144b = e;
        FetchThreadListResultBuilder fetchThreadListResultBuilder = newBuilder;
        fetchThreadListResultBuilder.f17145c = threadsCollection;
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17146d = a2.f16916c;
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17147e = a.f16911b;
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17148f = a.f16912c;
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17149g = f2;
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17150h = g;
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17151i = z;
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17152j = System.currentTimeMillis();
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17153k = Math.max(fetchThreadListParams.m17108e(), a2.f16917d);
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17154l = a.f16913d;
        return fetchThreadListResultBuilder.m17129m();
    }

    @Inject
    public FetchThreadListMethod(FetchThreadsFqlHelper fetchThreadsFqlHelper, FbErrorReporter fbErrorReporter, Provider<Boolean> provider) {
        this.f16896b = fetchThreadsFqlHelper;
        this.f16897c = fbErrorReporter;
        this.f16898d = provider;
    }

    private String m16917b(FetchThreadListParams fetchThreadListParams) {
        FolderName folderName = fetchThreadListParams.f17118b;
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        FetchThreadsFqlHelper.m16933a(fqlMultiQueryHelper);
        FetchThreadsFqlHelper.m16935a(fqlMultiQueryHelper, folderName);
        this.f16896b.m16948a(fqlMultiQueryHelper, StringFormatUtil.formatStrLocaleSafe("folder='%1$s' AND archived=0", folderName), fetchThreadListParams.m17109f() + 1, ThreadTable.Normal);
        int f = fetchThreadListParams.m17109f() + 1;
        this.f16896b.m16949a(fqlMultiQueryHelper, new StringBuilder("thread_id IN (SELECT thread_id FROM #thread_list_ids)").toString(), f, true);
        return fqlMultiQueryHelper.a().toString();
    }

    private String m16918c(FetchThreadListParams fetchThreadListParams) {
        String formatStrLocaleSafe;
        FolderName folderName = fetchThreadListParams.f17118b;
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        FetchThreadsFqlHelper.m16933a(fqlMultiQueryHelper);
        FetchThreadsFqlHelper.m16935a(fqlMultiQueryHelper, folderName);
        if (((Boolean) this.f16898d.get()).booleanValue()) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("folder='%1$s' AND timestamp > %2$d", folderName, Long.valueOf(ActionIdHelper.c(fetchThreadListParams.f17121e)));
        } else {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("folder='%1$s' AND action_id > %2$d", folderName, Long.valueOf(fetchThreadListParams.f17121e));
        }
        this.f16896b.m16948a(fqlMultiQueryHelper, formatStrLocaleSafe, 100, ThreadTable.Sync);
        this.f16896b.m16949a(fqlMultiQueryHelper, new StringBuilder("thread_id IN (SELECT thread_id FROM #thread_list_ids WHERE sync_change_type!='deleted')").toString(), 100, true);
        return fqlMultiQueryHelper.a().toString();
    }

    private ImmutableList<ThreadSummary> m16916a(Map<String, ThreadSummary> map, List<String> list) {
        String str = "for_thread_list";
        Builder builder = ImmutableList.builder();
        for (String str2 : list) {
            ThreadSummary threadSummary = (ThreadSummary) map.get(str2);
            if (threadSummary == null) {
                StringBuilder stringBuilder = new StringBuilder(str);
                stringBuilder.append("\nmissing thread id: ");
                stringBuilder.append(str2);
                stringBuilder.append("\n");
                stringBuilder.append(Arrays.toString(map.keySet().toArray()));
                this.f16897c.a(SoftError.a(f16895a.getSimpleName(), stringBuilder.toString()).g());
            } else if (threadSummary.A != FolderName.NONE) {
                builder.c(threadSummary);
            }
        }
        return builder.b();
    }
}
