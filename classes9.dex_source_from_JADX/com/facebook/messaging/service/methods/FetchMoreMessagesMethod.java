package com.facebook.messaging.service.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.MessageTable;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.MessagesResult;
import com.facebook.messaging.service.model.FetchMoreMessagesParams;
import com.facebook.messaging.service.model.FetchMoreMessagesResult;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: daily_budget */
public class FetchMoreMessagesMethod implements ApiMethod<FetchMoreMessagesParams, FetchMoreMessagesResult> {
    private final FetchThreadsFqlHelper f16883a;

    public static FetchMoreMessagesMethod m16901b(InjectorLike injectorLike) {
        return new FetchMoreMessagesMethod(FetchThreadsFqlHelper.m16938b(injectorLike));
    }

    public final ApiRequest m16904a(Object obj) {
        FetchMoreMessagesParams fetchMoreMessagesParams = (FetchMoreMessagesParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        if (fetchMoreMessagesParams.f17066a.a == Type.GROUP) {
            arrayList.add(new BasicNameValuePair("q", m16902b(fetchMoreMessagesParams)));
        } else {
            arrayList.add(new BasicNameValuePair("q", m16903c(fetchMoreMessagesParams)));
        }
        return new ApiRequest("fetchMoreMessages", "GET", "fql", arrayList, ApiResponseType.JSON);
    }

    public final Object m16905a(Object obj, ApiResponse apiResponse) {
        FetchMoreMessagesParams fetchMoreMessagesParams = (FetchMoreMessagesParams) obj;
        ThreadKey threadKey = fetchMoreMessagesParams.f17066a;
        MessagesResult a = this.f16883a.m16946a(new FqlResultHelper(apiResponse.c()), fetchMoreMessagesParams.f17069d, threadKey);
        boolean z = false;
        if (a.f16906b < fetchMoreMessagesParams.f17069d + 1) {
            z = true;
        }
        return new FetchMoreMessagesResult(DataFetchDisposition.b, new MessagesCollection(threadKey, a.f16905a, z), System.currentTimeMillis());
    }

    @Inject
    public FetchMoreMessagesMethod(FetchThreadsFqlHelper fetchThreadsFqlHelper) {
        this.f16883a = fetchThreadsFqlHelper;
    }

    public static FetchMoreMessagesMethod m16900a(InjectorLike injectorLike) {
        return m16901b(injectorLike);
    }

    private String m16902b(FetchMoreMessagesParams fetchMoreMessagesParams) {
        long j = fetchMoreMessagesParams.f17066a.b;
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        fqlMultiQueryHelper.a("thread_fbid", StringFormatUtil.formatStrLocaleSafe("SELECT thread_id FROM unified_thread WHERE thread_fbid = %1$d LIMIT 1", Long.valueOf(j)));
        if (fetchMoreMessagesParams.f17068c == -1) {
            this.f16883a.m16950a(fqlMultiQueryHelper, StringFormatUtil.formatStrLocaleSafe("thread_id IN (SELECT thread_id FROM #thread_fbid) AND timestamp >= %1$d", Integer.valueOf(0)), "timestamp DESC", fetchMoreMessagesParams.f17069d + 1, MessageTable.Normal);
        } else {
            this.f16883a.m16950a(fqlMultiQueryHelper, StringFormatUtil.formatStrLocaleSafe("thread_id IN (SELECT thread_id FROM #thread_fbid) AND timestamp >= %1$d AND timestamp <= %2$d", Integer.valueOf(0), Long.valueOf(fetchMoreMessagesParams.f17068c)), "timestamp DESC", fetchMoreMessagesParams.f17069d + 1, MessageTable.Normal);
        }
        return fqlMultiQueryHelper.a().toString();
    }

    private String m16903c(FetchMoreMessagesParams fetchMoreMessagesParams) {
        String l = Long.toString(fetchMoreMessagesParams.f17066a.d);
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        fqlMultiQueryHelper.a("canonical_thread_id", StringFormatUtil.formatStrLocaleSafe("SELECT thread_id FROM unified_thread WHERE single_recipient = %1$s LIMIT 1", l));
        if (fetchMoreMessagesParams.f17068c == -1) {
            this.f16883a.m16950a(fqlMultiQueryHelper, StringFormatUtil.formatStrLocaleSafe("thread_id IN (SELECT thread_id FROM #canonical_thread_id) AND timestamp >= %1$d", Integer.valueOf(0)), "timestamp DESC", fetchMoreMessagesParams.f17069d + 1, MessageTable.Normal);
        } else {
            this.f16883a.m16950a(fqlMultiQueryHelper, StringFormatUtil.formatStrLocaleSafe("thread_id IN (SELECT thread_id FROM #canonical_thread_id) AND timestamp >= %1$d AND timestamp <= %2$d", Integer.valueOf(0), Long.valueOf(fetchMoreMessagesParams.f17068c)), "timestamp DESC", fetchMoreMessagesParams.f17069d + 1, MessageTable.Normal);
        }
        return fqlMultiQueryHelper.a().toString();
    }
}
