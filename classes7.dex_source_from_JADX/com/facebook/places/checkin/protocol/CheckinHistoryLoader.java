package com.facebook.places.checkin.protocol;

import android.content.Context;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.checkin.models.SearchResults.ListType;
import com.facebook.places.db.PlacesModelTable;
import com.facebook.places.graphql.PlacesGraphQL;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinHistoryMostRecentQueryModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinHistoryMostRecentQueryModel.PlaceVisitsModel.NodesModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.HashSet;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: instagram_fb */
public class CheckinHistoryLoader {
    private static volatile CheckinHistoryLoader f11029e;
    public final CheckinHistoryStore f11030a;
    public final ListeningExecutorService f11031b;
    public final GraphQLQueryExecutor f11032c;
    public final DefaultAndroidThreadUtil f11033d;

    /* compiled from: instagram_fb */
    public class C09621 implements Callable<SearchResults> {
        final /* synthetic */ CheckinHistoryLoader f11027a;

        public C09621(CheckinHistoryLoader checkinHistoryLoader) {
            this.f11027a = checkinHistoryLoader;
        }

        public Object call() {
            int i = 0;
            CheckinHistoryMostRecentQueryModel a = this.f11027a.f11030a.m13016a();
            if (a == null) {
                CheckinHistoryLoader checkinHistoryLoader = this.f11027a;
                checkinHistoryLoader.f11033d.b();
                CheckinHistoryMostRecentQueryModel checkinHistoryMostRecentQueryModel = (CheckinHistoryMostRecentQueryModel) ((GraphQLResult) FutureDetour.a(checkinHistoryLoader.f11032c.a(GraphQLRequest.a(PlacesGraphQL.e())), 886356722)).e;
                Preconditions.checkState(checkinHistoryMostRecentQueryModel != null);
                this.f11027a.f11030a.m13017a(checkinHistoryMostRecentQueryModel);
                a = checkinHistoryMostRecentQueryModel;
            }
            Iterable a2 = Lists.a();
            HashSet a3 = Sets.a();
            ImmutableList a4 = a.a().a();
            int size = a4.size();
            while (i < size) {
                CheckinPlaceModel a5 = ((NodesModel) a4.get(i)).a();
                String cf_ = a5.cf_();
                if (!a3.contains(cf_)) {
                    a2.add(a5);
                    a3.add(cf_);
                }
                i++;
            }
            SearchResults searchResults = new SearchResults(Lists.a(a2));
            searchResults.g = ListType.RECENT;
            return searchResults;
        }
    }

    /* compiled from: instagram_fb */
    public class C09632 implements Callable<Void> {
        final /* synthetic */ CheckinHistoryLoader f11028a;

        public C09632(CheckinHistoryLoader checkinHistoryLoader) {
            this.f11028a = checkinHistoryLoader;
        }

        public Object call() {
            this.f11028a.f11030a.m13017a((CheckinHistoryMostRecentQueryModel) ((GraphQLResult) FutureDetour.a(this.f11028a.f11032c.a(GraphQLRequest.a(PlacesGraphQL.e())), -1669076066)).e);
            return null;
        }
    }

    public static com.facebook.places.checkin.protocol.CheckinHistoryLoader m13012a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11029e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.places.checkin.protocol.CheckinHistoryLoader.class;
        monitor-enter(r1);
        r0 = f11029e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13013b(r0);	 Catch:{ all -> 0x0035 }
        f11029e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11029e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.checkin.protocol.CheckinHistoryLoader.a(com.facebook.inject.InjectorLike):com.facebook.places.checkin.protocol.CheckinHistoryLoader");
    }

    private static CheckinHistoryLoader m13013b(InjectorLike injectorLike) {
        return new CheckinHistoryLoader(new CheckinHistoryStore(FbObjectMapperMethodAutoProvider.a(injectorLike), new PlacesModelTable((Context) injectorLike.getInstance(Context.class)), DefaultAndroidThreadUtil.b(injectorLike)), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public CheckinHistoryLoader(CheckinHistoryStore checkinHistoryStore, ListeningExecutorService listeningExecutorService, GraphQLQueryExecutor graphQLQueryExecutor, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f11030a = checkinHistoryStore;
        this.f11031b = listeningExecutorService;
        this.f11032c = graphQLQueryExecutor;
        this.f11033d = defaultAndroidThreadUtil;
    }
}
