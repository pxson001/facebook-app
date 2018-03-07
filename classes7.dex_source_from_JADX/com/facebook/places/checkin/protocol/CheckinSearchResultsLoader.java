package com.facebook.places.checkin.protocol;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.FbLocationOperationParams.Builder;
import com.facebook.location.ImmutableLocation;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.checkin.models.SearchResults.ListType;
import com.facebook.places.checkin.protocol.PlacePickerCache.C09761;
import com.facebook.places.checkin.protocol.PlacePickerCache.C09772;
import com.facebook.places.checkin.protocol.PlacePickerCache.Entry;
import com.facebook.places.future.PlacesTasksManager;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinSearchQuery;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinSearchQueryModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinSearchQueryModel.PlaceResultsModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinSearchQueryModel.PlaceResultsModel.EdgesModel;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.EvictingQueue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: initial_units_wait_time_start_reason */
public class CheckinSearchResultsLoader {
    private static final Class<?> f11063a = CheckinSearchResultsLoader.class;
    private static final FbLocationOperationParams f11064b;
    private static final FbLocationOperationParams f11065c;
    public final PlacePickerCache f11066d;
    private final CheckinSearchQueryHelper f11067e;
    private final GraphQLQueryExecutor f11068f;
    public final PlacesTasksManager<Task> f11069g;
    private final Provider<FbLocationOperation> f11070h;
    private final Executor f11071i;
    public final Function<SearchResults, SearchResults> f11072j = new C09711(this);

    /* compiled from: initial_units_wait_time_start_reason */
    class C09711 implements Function<SearchResults, SearchResults> {
        final /* synthetic */ CheckinSearchResultsLoader f11060a;

        C09711(CheckinSearchResultsLoader checkinSearchResultsLoader) {
            this.f11060a = checkinSearchResultsLoader;
        }

        public Object apply(Object obj) {
            SearchResults searchResults = (SearchResults) obj;
            searchResults.e = true;
            return searchResults;
        }
    }

    /* compiled from: initial_units_wait_time_start_reason */
    public enum Task {
        NEARBY_LOCATION,
        NEARBY_PLACES
    }

    public static CheckinSearchResultsLoader m13043b(InjectorLike injectorLike) {
        return new CheckinSearchResultsLoader(PlacePickerCache.m13054a(injectorLike), CheckinSearchQueryHelper.m13026a(injectorLike), GraphQLQueryExecutor.a(injectorLike), PlacesTasksManager.c(injectorLike), IdBasedProvider.a(injectorLike, 2481), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike));
    }

    static {
        Builder a = FbLocationOperationParams.a(Priority.HIGH_ACCURACY);
        a.d = 1000;
        a = a;
        a.c = 1000.0f;
        a = a;
        a.b = 300000;
        f11064b = a.a();
        a = FbLocationOperationParams.a(Priority.HIGH_ACCURACY);
        a.d = 10000;
        a = a;
        a.c = 1000.0f;
        a = a;
        a.b = 1000;
        f11065c = a.a();
    }

    @Inject
    public CheckinSearchResultsLoader(PlacePickerCache placePickerCache, CheckinSearchQueryHelper checkinSearchQueryHelper, GraphQLQueryExecutor graphQLQueryExecutor, PlacesTasksManager placesTasksManager, Provider<FbLocationOperation> provider, Executor executor) {
        this.f11066d = placePickerCache;
        this.f11067e = checkinSearchQueryHelper;
        this.f11068f = graphQLQueryExecutor;
        this.f11069g = placesTasksManager;
        this.f11070h = provider;
        this.f11071i = executor;
    }

    public final void m13045a(FutureCallback<ImmutableLocation> futureCallback) {
        m13042a(f11064b, (FutureCallback) futureCallback);
    }

    public final void m13047b(FutureCallback<ImmutableLocation> futureCallback) {
        m13042a(f11065c, (FutureCallback) futureCallback);
    }

    public final void m13044a(PlacePickerFetchParams placePickerFetchParams, FutureCallback<SearchResults> futureCallback) {
        ListenableFuture listenableFuture;
        AbstractDisposableFutureCallback a = AbstractDisposableFutureCallback.a(futureCallback);
        PlacePickerCache placePickerCache = this.f11066d;
        placePickerCache.f11106a.a();
        Iterables.a(placePickerCache.f11107b, new C09772(placePickerCache));
        EvictingQueue evictingQueue = placePickerCache.f11107b;
        Optional f = Iterators.f(evictingQueue.iterator(), new C09761(placePickerCache, placePickerFetchParams));
        if (f.isPresent()) {
            listenableFuture = ((Entry) f.get()).f11104b;
        } else {
            listenableFuture = null;
        }
        ListenableFuture listenableFuture2 = listenableFuture;
        if (listenableFuture2 != null) {
            listenableFuture2 = Futures.a(listenableFuture2, this.f11072j, MoreExecutors.a());
        }
        ListenableFuture listenableFuture3 = listenableFuture2;
        if (listenableFuture3 != null) {
            Futures.a(listenableFuture3, a, this.f11071i);
            return;
        }
        listenableFuture3 = m13041a(placePickerFetchParams);
        this.f11066d.m13056a(placePickerFetchParams, listenableFuture3);
        this.f11069g.a(Task.NEARBY_PLACES, listenableFuture3, a);
    }

    public final void m13046b() {
        this.f11069g.c();
    }

    private void m13042a(FbLocationOperationParams fbLocationOperationParams, FutureCallback<ImmutableLocation> futureCallback) {
        FbLocationOperation fbLocationOperation = (FbLocationOperation) this.f11070h.get();
        fbLocationOperation.a(fbLocationOperationParams, CallerContext.b(f11063a, "checkin"));
        this.f11069g.a(Task.NEARBY_LOCATION, fbLocationOperation, AbstractDisposableFutureCallback.a(futureCallback));
    }

    private ListenableFuture<SearchResults> m13041a(final PlacePickerFetchParams placePickerFetchParams) {
        return Futures.a(GraphQLQueryExecutor.a(this.f11068f.a(this.f11067e.m13028a(placePickerFetchParams))), new Function<CheckinSearchQuery, SearchResults>(this) {
            final /* synthetic */ CheckinSearchResultsLoader f11062b;

            public Object apply(Object obj) {
                CheckinSearchQueryModel checkinSearchQueryModel = (CheckinSearchQueryModel) obj;
                PlacePickerFetchParams placePickerFetchParams = placePickerFetchParams;
                PlaceResultsModel b = checkinSearchQueryModel.b();
                ImmutableList a = b.a();
                int size = a.size();
                List arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    arrayList.add(((EdgesModel) a.get(i)).a());
                }
                SearchResults searchResults = new SearchResults();
                searchResults.a = arrayList;
                searchResults.b = arrayList;
                searchResults.d = placePickerFetchParams.f11108a;
                searchResults.c = checkinSearchQueryModel.d();
                searchResults.g = ListType.TRADITIONAL;
                searchResults.h = checkinSearchQueryModel.c();
                searchResults.f = b.b();
                searchResults.i = checkinSearchQueryModel.a();
                return searchResults;
            }
        }, MoreExecutors.a());
    }
}
