package com.facebook.messaging.cache;

import android.os.Bundle;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.inject.Assisted;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummary.MergedList;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.model.FetchPinnedThreadsResult;
import com.facebook.messaging.service.model.FetchPinnedThreadsResultBuilder;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadListResultBuilder;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collections;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: minimumSize must be at least 1 */
public class CacheFetchThreadsHandler {
    private static final Class<?> f9442a = CacheFetchThreadsHandler.class;
    public final ThreadsCache f9443b;
    private final ThreadsCacheUpdateRateLimiter f9444c;
    private final UserCache f9445d;

    /* compiled from: minimumSize must be at least 1 */
    public /* synthetic */ class C11051 {
        public static final /* synthetic */ int[] f9441a = new int[DataFreshnessParam.values().length];

        static {
            try {
                f9441a[DataFreshnessParam.STALE_DATA_OKAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9441a[DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9441a[DataFreshnessParam.DO_NOT_CHECK_SERVER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9441a[DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public CacheFetchThreadsHandler(@Assisted ThreadsCache threadsCache, ThreadsCacheUpdateRateLimiter threadsCacheUpdateRateLimiter, UserCache userCache) {
        this.f9443b = threadsCache;
        this.f9444c = threadsCacheUpdateRateLimiter;
        this.f9445d = userCache;
    }

    public final FetchThreadListParams m9905a(FetchThreadListParams fetchThreadListParams) {
        DataFreshnessParam a = this.f9444c.m10196a(fetchThreadListParams.f17118b, fetchThreadListParams.f17117a);
        if (a == fetchThreadListParams.f17117a) {
            return fetchThreadListParams;
        }
        FetchThreadListParamsBuilder a2 = FetchThreadListParams.newBuilder().m17115a(fetchThreadListParams);
        a2.f17124a = a;
        FetchThreadListParamsBuilder fetchThreadListParamsBuilder = a2;
        fetchThreadListParamsBuilder.f17130g = fetchThreadListParams.f17123g;
        return fetchThreadListParamsBuilder.m17116h();
    }

    public final boolean m9908a(FolderName folderName, DataFreshnessParam dataFreshnessParam) {
        switch (C11051.f9441a[dataFreshnessParam.ordinal()]) {
            case 1:
                return this.f9443b.a(folderName);
            case 2:
            case 3:
                return this.f9443b.b(folderName);
            default:
                return false;
        }
    }

    public final FetchThreadListResult m9906a(FolderName folderName) {
        ThreadsCollection d = this.f9443b.d(folderName);
        ImmutableList copyOf = ImmutableList.copyOf(Collections.unmodifiableCollection(this.f9445d.b.values()));
        DataFetchDisposition dataFetchDisposition = this.f9443b.b(folderName) ? DataFetchDisposition.c : DataFetchDisposition.d;
        FolderCounts e = this.f9443b.e(folderName);
        FetchThreadListResultBuilder newBuilder = FetchThreadListResult.newBuilder();
        newBuilder.f17143a = dataFetchDisposition;
        FetchThreadListResultBuilder fetchThreadListResultBuilder = newBuilder;
        fetchThreadListResultBuilder.f17144b = folderName;
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17145c = d;
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17146d = copyOf;
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17149g = e;
        return fetchThreadListResultBuilder.m17129m();
    }

    public final FetchPinnedThreadsResult m9904a() {
        boolean z;
        ImmutableList b = this.f9443b.b();
        FetchPinnedThreadsResultBuilder newBuilder = FetchPinnedThreadsResult.newBuilder();
        newBuilder.f17104a = b;
        newBuilder = newBuilder;
        newBuilder.f17107d = this.f9443b.c();
        newBuilder = newBuilder;
        if (b.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        newBuilder.f17105b = z;
        return newBuilder.m17097e();
    }

    public final FetchThreadResult m9907a(OperationParams operationParams) {
        MessagesCollection messagesCollection;
        ThreadKey threadKey;
        Bundle bundle = operationParams.c;
        FetchThreadParams fetchThreadParams = (FetchThreadParams) bundle.getParcelable("fetchThreadParams");
        ThreadSummary a = m9903a(fetchThreadParams.f17155a);
        if (a == null) {
            messagesCollection = null;
        } else {
            messagesCollection = this.f9443b.b(a.a);
        }
        MessagesCollection messagesCollection2 = messagesCollection;
        if (a != null) {
            threadKey = a.a;
        } else {
            threadKey = null;
        }
        fetchThreadParams = m9901a(fetchThreadParams, threadKey);
        bundle.putParcelable("fetchThreadParams", fetchThreadParams);
        boolean z = false;
        if (a != null) {
            switch (C11051.f9441a[fetchThreadParams.f17156b.ordinal()]) {
                case 1:
                    if (messagesCollection2 != null && messagesCollection2.a(fetchThreadParams.f17160f)) {
                        z = true;
                        break;
                    }
                case 2:
                case 3:
                    z = this.f9443b.a(a.a, fetchThreadParams.f17160f);
                    break;
                default:
                    break;
            }
        }
        if (z) {
            return m9902a(a, messagesCollection2);
        }
        return null;
    }

    public final ThreadSummary m9903a(ThreadCriteria threadCriteria) {
        return this.f9443b.a(threadCriteria);
    }

    private FetchThreadParams m9901a(FetchThreadParams fetchThreadParams, @Nullable ThreadKey threadKey) {
        FetchThreadParamsBuilder a = FetchThreadParams.newBuilder().m17138a(fetchThreadParams);
        DataFreshnessParam a2 = this.f9444c.m10197a(threadKey, fetchThreadParams.f17156b);
        if (a2 != fetchThreadParams.f17156b) {
            a.f17164b = a2;
            a.f17165c = fetchThreadParams.f17156b;
        }
        if (threadKey == null) {
            return a.m17140i();
        }
        long e = this.f9443b.e(threadKey);
        if (e > this.f9443b.f(threadKey)) {
            a.f17167e = true;
            a.f17166d = e;
        }
        return a.m17140i();
    }

    private FetchThreadResult m9902a(@Nullable ThreadSummary threadSummary, @Nullable MessagesCollection messagesCollection) {
        if (threadSummary == null) {
            return FetchThreadResult.f17178a;
        }
        Builder builder = ImmutableList.builder();
        for (ThreadParticipant b : new MergedList(threadSummary.h, threadSummary.i, threadSummary.j)) {
            User a = this.f9445d.a(b.b());
            if (a != null) {
                builder.c(a);
            }
        }
        DataFetchDisposition dataFetchDisposition = this.f9443b.a(threadSummary.a, messagesCollection == null ? 0 : messagesCollection.g()) ? DataFetchDisposition.c : DataFetchDisposition.d;
        FetchThreadResult.Builder b2 = FetchThreadResult.m17150b();
        b2.f17171a = dataFetchDisposition;
        FetchThreadResult.Builder builder2 = b2;
        builder2.f17172b = threadSummary;
        builder2 = builder2;
        builder2.f17173c = messagesCollection;
        builder2 = builder2;
        builder2.f17174d = builder.b();
        builder2 = builder2;
        builder2.f17176f = -1;
        return builder2.m17147a();
    }
}
