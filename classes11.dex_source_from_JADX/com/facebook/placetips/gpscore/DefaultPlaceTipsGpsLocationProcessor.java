package com.facebook.placetips.gpscore;

import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.TimeConversions;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery.ViewerCoordinates;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationAgeUtil;
import com.facebook.places.checkin.protocol.LocationExtraDataRetriever;
import com.facebook.placetips.bootstrap.ConfidenceLevel;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel;
import com.facebook.placetips.gpscore.graphql.GravitySuggestifierQuery.GravitySuggestifierQueryString;
import com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryInterfaces.GravitySuggestifierQuery.Suggestions.Edges;
import com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel;
import com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel;
import com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel;
import com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel.SuggestionsModel.EdgesModel.NodeModel;
import com.facebook.placetips.logging.PlaceTipsEmptyResponseException;
import com.facebook.placetips.presence.PagePresenceManager;
import com.facebook.placetips.presence.PagePresenceManager.PresenceUpdateBuilder;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipsFeedUnitFragmentModel;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Tip Manager not available */
public class DefaultPlaceTipsGpsLocationProcessor {
    private final Executor f10592a;
    public final GraphQLQueryExecutor f10593b;
    public final QuickPerformanceLogger f10594c;
    public final LocationExtraDataRetriever f10595d;
    public final LocationAgeUtil f10596e;

    /* compiled from: Tip Manager not available */
    class C12471 implements AsyncFunction<ImmutableLocation, Edges> {
        final /* synthetic */ DefaultPlaceTipsGpsLocationProcessor f10587a;

        C12471(DefaultPlaceTipsGpsLocationProcessor defaultPlaceTipsGpsLocationProcessor) {
            this.f10587a = defaultPlaceTipsGpsLocationProcessor;
        }

        public final ListenableFuture m11084a(Object obj) {
            ViewerCoordinates viewerCoordinates;
            ImmutableLocation immutableLocation = (ImmutableLocation) obj;
            DefaultPlaceTipsGpsLocationProcessor defaultPlaceTipsGpsLocationProcessor = this.f10587a;
            LocationAgeUtil locationAgeUtil = defaultPlaceTipsGpsLocationProcessor.f10596e;
            if (immutableLocation == null) {
                viewerCoordinates = null;
            } else {
                ViewerCoordinates b = new ViewerCoordinates().a(Double.valueOf(immutableLocation.a())).b(Double.valueOf(immutableLocation.b()));
                if (immutableLocation.c().isPresent()) {
                    b.c(Double.valueOf(((Float) immutableLocation.c().get()).doubleValue()));
                }
                Optional f = immutableLocation.f();
                if (f.isPresent()) {
                    b.d(Double.valueOf(((Float) f.get()).doubleValue()));
                }
                long a = locationAgeUtil.a(immutableLocation);
                if (a >= 0) {
                    b.e(Double.valueOf(TimeConversions.n(a)));
                }
                viewerCoordinates = b;
            }
            ViewerCoordinates viewerCoordinates2 = viewerCoordinates;
            CheckinSearchQueryInputCheckinSearchQuery a2 = new CheckinSearchQueryInputCheckinSearchQuery().a("");
            if (viewerCoordinates2 != null) {
                a2.a(viewerCoordinates2);
            }
            if (immutableLocation != null) {
                defaultPlaceTipsGpsLocationProcessor.f10595d.a(a2);
            }
            GraphQlQueryString gravitySuggestifierQueryString = new GravitySuggestifierQueryString();
            gravitySuggestifierQueryString.a("gravity_query_data", a2).a("gravity_checkin_context", "places_feed_gps");
            GraphQLRequest a3 = GraphQLRequest.a(gravitySuggestifierQueryString).a(GraphQLCachePolicy.c);
            int hashCode = SafeUUIDGenerator.a().hashCode();
            defaultPlaceTipsGpsLocationProcessor.f10594c.e(1966085, hashCode);
            ListenableFuture b2 = Futures.b(defaultPlaceTipsGpsLocationProcessor.f10593b.a(a3), new C12482(defaultPlaceTipsGpsLocationProcessor, hashCode), MoreExecutors.a());
            Futures.a(b2, new C12493(defaultPlaceTipsGpsLocationProcessor, hashCode), MoreExecutors.a());
            return b2;
        }
    }

    /* compiled from: Tip Manager not available */
    public class C12482 implements AsyncFunction<GraphQLResult<GravitySuggestifierQueryModel>, Edges> {
        final /* synthetic */ int f10588a;
        final /* synthetic */ DefaultPlaceTipsGpsLocationProcessor f10589b;

        public C12482(DefaultPlaceTipsGpsLocationProcessor defaultPlaceTipsGpsLocationProcessor, int i) {
            this.f10589b = defaultPlaceTipsGpsLocationProcessor;
            this.f10588a = i;
        }

        public final ListenableFuture m11085a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                throw new PlaceTipsEmptyResponseException("result is null");
            }
            GravitySuggestifierQueryModel gravitySuggestifierQueryModel = (GravitySuggestifierQueryModel) graphQLResult.e;
            if (gravitySuggestifierQueryModel == null) {
                throw new PlaceTipsEmptyResponseException("model is null");
            }
            SuggestionsModel a = gravitySuggestifierQueryModel.m11143a();
            if (a == null) {
                throw new PlaceTipsEmptyResponseException("suggestions is null");
            } else if (a.m11136a() <= 0) {
                throw new PlaceTipsEmptyResponseException("suggestions count is < 1");
            } else {
                ImmutableList b = a.m11140b();
                if (b.isEmpty()) {
                    throw new PlaceTipsEmptyResponseException("edges is empty");
                }
                EdgesModel edgesModel = (EdgesModel) b.get(0);
                if (edgesModel == null) {
                    throw new PlaceTipsEmptyResponseException("first edge is null");
                }
                this.f10589b.f10594c.b(1966085, this.f10588a, "logging_id", edgesModel.m11134c());
                NodeModel b2 = edgesModel.m11133b();
                if (b2 == null) {
                    throw new PlaceTipsEmptyResponseException("first edge.getNode() is null");
                }
                PlaceTipsFeedUnitFragmentModel oh_ = b2.oh_();
                if (oh_ == null) {
                    throw new PlaceTipsEmptyResponseException("reactionStories' feedUnitFragment is null");
                } else if (oh_.c() != null) {
                    return Futures.a(edgesModel);
                } else {
                    throw new PlaceTipsEmptyResponseException("reactionStories' feedUnitFragment's title is null");
                }
            }
        }
    }

    /* compiled from: Tip Manager not available */
    public class C12493 implements FutureCallback<Edges> {
        final /* synthetic */ int f10590a;
        final /* synthetic */ DefaultPlaceTipsGpsLocationProcessor f10591b;

        public C12493(DefaultPlaceTipsGpsLocationProcessor defaultPlaceTipsGpsLocationProcessor, int i) {
            this.f10591b = defaultPlaceTipsGpsLocationProcessor;
            this.f10590a = i;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f10591b.f10594c.b(1966085, this.f10590a, (short) 2);
        }

        public void onFailure(Throwable th) {
            this.f10591b.f10594c.b(1966085, this.f10590a, (short) 3);
        }
    }

    public final void m11089a(@Nullable ImmutableLocation immutableLocation, Object obj, PagePresenceManager pagePresenceManager, String str, @Nullable LocationTriggerWithReactionUnitsModel locationTriggerWithReactionUnitsModel) {
        boolean z;
        DefaultTextWithEntitiesLongFields b;
        EdgesModel edgesModel = (EdgesModel) obj;
        DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields = null;
        NodeModel b2 = edgesModel.m11133b();
        PlaceTipsFeedUnitFragmentModel oh_ = b2.oh_();
        PresenceUpdateBuilder a = pagePresenceManager.a(PlaceTipsGpsHelper.m11092a(immutableLocation));
        a.c = b2.m11126c();
        a = a;
        a.d = b2.m11127d();
        a = a;
        a.e = b2.m11125b();
        PresenceUpdateBuilder presenceUpdateBuilder = a;
        presenceUpdateBuilder.g = oh_.c();
        presenceUpdateBuilder = presenceUpdateBuilder;
        presenceUpdateBuilder.h = oh_.b();
        a = presenceUpdateBuilder;
        if (oh_.a() != null) {
            z = true;
        } else {
            z = false;
        }
        a.i = z;
        a = a;
        if (oh_.a() != null) {
            b = oh_.a().b();
        } else {
            b = null;
        }
        a.j = b;
        a = a;
        if (oh_.a() != null) {
            b = oh_.a().a();
        } else {
            b = null;
        }
        a.k = b;
        presenceUpdateBuilder = a;
        if (oh_.a() != null) {
            defaultTextWithEntitiesLongFields = oh_.a().c();
        }
        presenceUpdateBuilder.l = defaultTextWithEntitiesLongFields;
        presenceUpdateBuilder = presenceUpdateBuilder;
        presenceUpdateBuilder.n = m11086a(edgesModel);
        presenceUpdateBuilder = presenceUpdateBuilder;
        presenceUpdateBuilder.p = ConfidenceLevel.from(edgesModel.m11131a());
        presenceUpdateBuilder = presenceUpdateBuilder;
        presenceUpdateBuilder.q = locationTriggerWithReactionUnitsModel;
        presenceUpdateBuilder.a();
    }

    @Inject
    public DefaultPlaceTipsGpsLocationProcessor(Executor executor, GraphQLQueryExecutor graphQLQueryExecutor, QuickPerformanceLogger quickPerformanceLogger, LocationExtraDataRetriever locationExtraDataRetriever, LocationAgeUtil locationAgeUtil) {
        this.f10592a = executor;
        this.f10593b = graphQLQueryExecutor;
        this.f10594c = quickPerformanceLogger;
        this.f10595d = locationExtraDataRetriever;
        this.f10596e = locationAgeUtil;
    }

    public final ListenableFuture<Edges> m11087a(@Nullable ImmutableLocation immutableLocation) {
        return Futures.b(Futures.a(immutableLocation), new C12471(this), this.f10592a);
    }

    private static String m11086a(EdgesModel edgesModel) {
        return edgesModel.m11134c();
    }
}
