package com.facebook.messaging.service.methods;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodEvents;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.MessageTable;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.MessagesResult;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.ThreadsResult;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.FetchThreadResult.Builder;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: d5dc583103fffabefa7d169924de42e3 */
public class FetchThreadMethod implements ApiMethod<FetchThreadParams, FetchThreadResult>, ApiMethodEvents<FetchThreadParams> {
    private static final Class<?> f16899a = FetchThreadMethod.class;
    private final FetchThreadsFqlHelper f16900b;
    private final MessagesReliabilityLogger f16901c;
    private final AbstractFbErrorReporter f16902d;
    private final Provider<Boolean> f16903e;
    private final Provider<User> f16904f;

    public static FetchThreadMethod m16924b(InjectorLike injectorLike) {
        return new FetchThreadMethod(FetchThreadsFqlHelper.m16938b(injectorLike), MessagesReliabilityLogger.m7941b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4060), IdBasedProvider.a(injectorLike, 3596));
    }

    public final ApiRequest m16926a(Object obj) {
        FetchThreadParams fetchThreadParams = (FetchThreadParams) obj;
        String str = "fql";
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        ThreadKey a = fetchThreadParams.f17155a.a();
        if (a == null) {
            arrayList.add(new BasicNameValuePair("q", m16923a(fetchThreadParams.f17155a.a, fetchThreadParams.f17160f, fetchThreadParams.f17161g)));
        } else if (a.a == Type.ONE_TO_ONE) {
            arrayList.add(new BasicNameValuePair("q", m16925b(a.d, fetchThreadParams.f17160f, fetchThreadParams.f17161g)));
        } else {
            arrayList.add(new BasicNameValuePair("q", m16922a(a.b, fetchThreadParams.f17160f, fetchThreadParams.f17161g)));
        }
        return new ApiRequest("fetchThread", "GET", str, arrayList, ApiResponseType.JSON);
    }

    public final Object m16927a(Object obj, ApiResponse apiResponse) {
        FetchThreadParams fetchThreadParams = (FetchThreadParams) obj;
        boolean z = true;
        FqlResultHelper fqlResultHelper = new FqlResultHelper(apiResponse.c());
        ThreadsResult c = this.f16900b.m16955c(fqlResultHelper);
        ThreadKey a = fetchThreadParams.f17155a.a();
        boolean z2 = a != null && a.a == Type.ONE_TO_ONE;
        Object obj2 = null;
        if (z2) {
            obj2 = this.f16900b.m16956d(fqlResultHelper);
            if (obj2 == null) {
                throw new Exception("Couldn't find canonical user");
            }
        }
        Builder b;
        Builder builder;
        if (c.f16914a.size() == 0) {
            if (z2) {
                b = FetchThreadResult.m17150b();
                b.f17171a = DataFetchDisposition.b;
                b = b;
                b.f17174d = ImmutableList.of(obj2, this.f16904f.get());
                builder = b;
                builder.f17176f = System.currentTimeMillis();
                return builder.m17147a();
            }
            this.f16902d.a("FetchThreadMethod_threadNotFound", "fetchThreadParams=" + fetchThreadParams);
            throw new Exception("Couldn't find thread");
        } else if (c.f16914a.size() > 1) {
            throw new Exception("Invalid api response - multiple threads in fetchThread");
        } else {
            ThreadSummary threadSummary = (ThreadSummary) c.f16914a.get(0);
            MessagesResult a2 = this.f16900b.m16946a(fqlResultHelper, fetchThreadParams.f17160f, threadSummary.a);
            if (fetchThreadParams.f17161g >= 0 || a2.f16906b >= fetchThreadParams.f17160f) {
                z = false;
            }
            MessagesCollection messagesCollection = new MessagesCollection(threadSummary.a, a2.f16905a, z);
            b = FetchThreadResult.m17150b();
            b.f17171a = DataFetchDisposition.b;
            b = b;
            b.f17172b = threadSummary;
            builder = b;
            builder.f17173c = messagesCollection;
            builder = builder;
            builder.f17174d = c.f16916c;
            builder = builder;
            builder.f17176f = System.currentTimeMillis();
            return builder.m17147a();
        }
    }

    public final void m16928a(Object obj, Exception exception) {
        FetchThreadParams fetchThreadParams = (FetchThreadParams) obj;
        this.f16901c.m7946a(fetchThreadParams.f17155a.a(), fetchThreadParams.f17161g, (Throwable) exception);
    }

    public final /* bridge */ /* synthetic */ void m16930c(Object obj) {
    }

    public static FetchThreadMethod m16921a(InjectorLike injectorLike) {
        return m16924b(injectorLike);
    }

    @Inject
    public FetchThreadMethod(FetchThreadsFqlHelper fetchThreadsFqlHelper, MessagesReliabilityLogger messagesReliabilityLogger, FbErrorReporter fbErrorReporter, Provider<Boolean> provider, Provider<User> provider2) {
        this.f16900b = fetchThreadsFqlHelper;
        this.f16901c = messagesReliabilityLogger;
        this.f16902d = fbErrorReporter;
        this.f16903e = provider;
        this.f16904f = provider2;
    }

    private String m16923a(String str, int i, long j) {
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        this.f16900b.m16951a(fqlMultiQueryHelper, "thread_id='" + str + "'", "1", true, true);
        if (i != 0) {
            String str2;
            MessageTable messageTable = MessageTable.Normal;
            if (j == -1) {
                str2 = "thread_id='" + str + "'";
            } else if (((Boolean) this.f16903e.get()).booleanValue()) {
                str2 = StringFormatUtil.formatStrLocaleSafe("thread_id='%1$s' AND timestamp > %2$d", str, Long.valueOf(ActionIdHelper.c(j)));
                messageTable = MessageTable.Sync;
            } else {
                str2 = StringFormatUtil.formatStrLocaleSafe("thread_id='%1$s' AND action_id > %2$d", str, Long.valueOf(j));
                messageTable = MessageTable.Sync;
            }
            this.f16900b.m16950a(fqlMultiQueryHelper, str2, "timestamp DESC", i + 1, messageTable);
        }
        return fqlMultiQueryHelper.a().toString();
    }

    private String m16922a(long j, int i, long j2) {
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        this.f16900b.m16951a(fqlMultiQueryHelper, "thread_fbid='" + j + "'", "1", true, true);
        if (i != 0) {
            String str;
            MessageTable messageTable = MessageTable.Normal;
            if (j2 == -1) {
                str = "thread_id IN (SELECT thread_id FROM #threads)";
            } else if (((Boolean) this.f16903e.get()).booleanValue()) {
                str = StringFormatUtil.formatStrLocaleSafe("thread_id IN (SELECT thread_id FROM #threads) AND timestamp > %1$d", Long.valueOf(ActionIdHelper.c(j2)));
                messageTable = MessageTable.Sync;
            } else {
                str = StringFormatUtil.formatStrLocaleSafe("thread_id IN (SELECT thread_id FROM #threads) AND action_id > %1$d", Long.valueOf(j2));
                messageTable = MessageTable.Sync;
            }
            this.f16900b.m16950a(fqlMultiQueryHelper, str, "timestamp DESC", i + 1, messageTable);
        }
        return fqlMultiQueryHelper.a().toString();
    }

    private String m16925b(long j, int i, long j2) {
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        this.f16900b.m16953b(fqlMultiQueryHelper, Long.toString(j));
        this.f16900b.m16951a(fqlMultiQueryHelper, "single_recipient='" + j + "'", "1", true, true);
        if (i != 0) {
            String str;
            MessageTable messageTable = MessageTable.Normal;
            if (j2 == -1) {
                str = "thread_id IN (SELECT thread_id FROM #threads)";
            } else if (((Boolean) this.f16903e.get()).booleanValue()) {
                str = StringFormatUtil.formatStrLocaleSafe("thread_id IN (SELECT thread_id FROM #threads) AND timestamp > %1$d", Long.valueOf(ActionIdHelper.c(j2)));
                messageTable = MessageTable.Sync;
            } else {
                str = StringFormatUtil.formatStrLocaleSafe("thread_id IN (SELECT thread_id FROM #threads) AND action_id > %1$d", Long.valueOf(j2));
                messageTable = MessageTable.Sync;
            }
            this.f16900b.m16950a(fqlMultiQueryHelper, str, "timestamp DESC", i + 1, messageTable);
        }
        return fqlMultiQueryHelper.a().toString();
    }
}
