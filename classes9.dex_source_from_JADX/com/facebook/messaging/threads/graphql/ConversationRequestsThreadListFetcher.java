package com.facebook.messaging.threads.graphql;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.SystemClock;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.messaging.graphql.fetch.GQLUserConverter;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MoreThreadsQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadListQueryModel;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.model.FetchMoreThreadsParams;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadListResultBuilder;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.messaging.payment.ACTION_NEW_TRANSFER */
public class ConversationRequestsThreadListFetcher {
    private final GQLUserConverter f17789a;
    private final GQLThreadsConverter f17790b;
    private final GQLThreadQueryHelper f17791c;
    private final Provider<User> f17792d;
    private final GQLThreadsLogger f17793e;
    @Nullable
    private ThreadInfoModel f17794f;

    @Inject
    public ConversationRequestsThreadListFetcher(GQLUserConverter gQLUserConverter, GQLThreadsConverter gQLThreadsConverter, GQLThreadQueryHelper gQLThreadQueryHelper, Provider<User> provider, GQLThreadsLogger gQLThreadsLogger) {
        this.f17789a = gQLUserConverter;
        this.f17790b = gQLThreadsConverter;
        this.f17791c = gQLThreadQueryHelper;
        this.f17792d = provider;
        this.f17793e = gQLThreadsLogger;
    }

    public final FetchThreadListResult m17730a(FetchThreadListParams fetchThreadListParams, @Nullable CallerContext callerContext) {
        boolean z = true;
        ThreadListQueryModel a = this.f17791c.m17769a(fetchThreadListParams, callerContext);
        this.f17793e.m17805a("Fetch-other-threads null response", a.a());
        this.f17793e.m17805a("Page info missing", a.a().k());
        ImmutableList j = a.a().j();
        if (!j.isEmpty()) {
            this.f17794f = (ThreadInfoModel) j.get(j.size() - 1);
        }
        if (fetchThreadListParams.f17118b == FolderName.OTHER) {
            j = m17726a(j);
        }
        GQLThreadsConverter gQLThreadsConverter = this.f17790b;
        if (a.a().j().size() >= fetchThreadListParams.m17109f()) {
            z = false;
        }
        ThreadsCollection a2 = gQLThreadsConverter.m17790a(j, z, (User) this.f17792d.get());
        if (fetchThreadListParams.f17118b == FolderName.OTHER && a2.e() < 4 && j.size() == fetchThreadListParams.m17109f()) {
            a2 = ThreadsCollection.a(a2, m17725a(4 - a2.e(), callerContext, fetchThreadListParams.f17118b).f17091c);
        }
        FetchThreadListResultBuilder newBuilder = FetchThreadListResult.newBuilder();
        newBuilder.f17143a = DataFetchDisposition.b;
        newBuilder = newBuilder;
        newBuilder.f17144b = fetchThreadListParams.f17118b;
        newBuilder = newBuilder;
        newBuilder.f17145c = a2;
        FetchThreadListResultBuilder fetchThreadListResultBuilder = newBuilder;
        fetchThreadListResultBuilder.f17151i = false;
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17152j = SystemClock.a.a();
        fetchThreadListResultBuilder = fetchThreadListResultBuilder;
        fetchThreadListResultBuilder.f17154l = Long.parseLong(a.a().l());
        return fetchThreadListResultBuilder.m17129m();
    }

    private static ImmutableList<ThreadInfoModel> m17726a(ImmutableList<ThreadInfoModel> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadInfoModel threadInfoModel = (ThreadInfoModel) immutableList.get(i);
            if (!threadInfoModel.w()) {
                builder.c(threadInfoModel);
            }
        }
        return builder.b();
    }

    private long m17724a() {
        this.f17793e.m17805a("Last thread info is missing", this.f17794f);
        this.f17793e.m17805a("Last thread time is missing", this.f17794f.N());
        return Long.parseLong(this.f17794f.N());
    }

    private FetchMoreThreadsResult m17725a(int i, @Nullable CallerContext callerContext, FolderName folderName) {
        return m17729a(new FetchMoreThreadsParams(folderName, m17724a() - 1, m17728b(), i), callerContext);
    }

    private void m17727a(List<ThreadInfoModel> list, ImmutableList<ThreadInfoModel> immutableList) {
        if (!immutableList.isEmpty()) {
            this.f17794f = (ThreadInfoModel) immutableList.get(immutableList.size() - 1);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadInfoModel threadInfoModel = (ThreadInfoModel) immutableList.get(i);
                if (threadInfoModel.m()) {
                    list.add(threadInfoModel);
                }
            }
        }
    }

    private long m17728b() {
        this.f17793e.m17805a("Last thread info is missing", this.f17794f);
        ThreadKey a = this.f17790b.m17787a(this.f17794f, (User) this.f17792d.get());
        if (a != null) {
            return a.i();
        }
        this.f17793e.m17805a("Last thread info empty thread key", this.f17794f.J());
        this.f17793e.m17805a("Last thread info thread key empty fbid ", this.f17794f.J().j());
        return Long.parseLong(this.f17794f.J().j());
    }

    public final FetchMoreThreadsResult m17729a(FetchMoreThreadsParams fetchMoreThreadsParams, @Nullable CallerContext callerContext) {
        List arrayList = new ArrayList();
        int i = fetchMoreThreadsParams.f17087e;
        MoreThreadsQueryModel a = this.f17791c.m17768a(fetchMoreThreadsParams, callerContext);
        this.f17793e.m17805a("Fetch-more-other-threads null response", a.a());
        this.f17793e.m17805a("Page info missing", a.a().j());
        ImmutableList a2 = m17726a(a.a().a());
        m17727a(arrayList, a2);
        MoreThreadsQueryModel moreThreadsQueryModel = a;
        while (arrayList.size() < i && !r0.isEmpty()) {
            FetchMoreThreadsParams fetchMoreThreadsParams2 = new FetchMoreThreadsParams(fetchMoreThreadsParams.m17089a(), m17724a() - 1, m17728b(), 4);
            MoreThreadsQueryModel a3 = this.f17791c.m17768a(fetchMoreThreadsParams2, callerContext);
            this.f17793e.m17805a("Fetch-more-other-threads null response", a3.a());
            this.f17793e.m17805a("Page info missing", a3.a().j());
            ImmutableList a4 = m17726a(a3.a().a());
            m17727a(arrayList, a4);
            moreThreadsQueryModel = a3;
            fetchMoreThreadsParams = fetchMoreThreadsParams2;
            a2 = a4;
        }
        DataFetchDisposition dataFetchDisposition = DataFetchDisposition.b;
        FolderName a5 = fetchMoreThreadsParams.m17089a();
        GQLThreadsConverter gQLThreadsConverter = this.f17790b;
        ImmutableList copyOf = ImmutableList.copyOf(arrayList);
        boolean z = arrayList.size() < i ? true : !moreThreadsQueryModel.a().j().a();
        return new FetchMoreThreadsResult(dataFetchDisposition, a5, gQLThreadsConverter.m17789a(copyOf, null, z, (User) this.f17792d.get()), this.f17789a.a(arrayList), SystemClock.b().a());
    }
}
