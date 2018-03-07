package com.facebook.placetips.gpscore;

import android.content.Context;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.location.LocationAgeUtil;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLInterfaces.LocationTriggerWithReactionUnits;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TinyResProfilePic */
public class LocationTriggerFetchProcessor {
    public final Context f10601a;
    public final GraphQLQueryExecutor f10602b;
    public final LocationAgeUtil f10603c;
    public final Supplier<String> f10604d;

    /* compiled from: TinyResProfilePic */
    public class C12512 implements AsyncFunction<GraphQLResult<LocationTriggerWithReactionUnitsModel>, LocationTriggerWithReactionUnits> {
        final /* synthetic */ LocationTriggerFetchProcessor f10600a;

        public C12512(LocationTriggerFetchProcessor locationTriggerFetchProcessor) {
            this.f10600a = locationTriggerFetchProcessor;
        }

        public final ListenableFuture m11090a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            Preconditions.checkNotNull(graphQLResult);
            return Futures.a((LocationTriggerWithReactionUnitsModel) Preconditions.checkNotNull(graphQLResult.e));
        }
    }

    @Inject
    public LocationTriggerFetchProcessor(Context context, GraphQLQueryExecutor graphQLQueryExecutor, LocationAgeUtil locationAgeUtil, final Provider<ObjectMapper> provider, final QeAccessor qeAccessor) {
        this.f10601a = context;
        this.f10602b = graphQLQueryExecutor;
        this.f10603c = locationAgeUtil;
        this.f10604d = Suppliers.memoize(new Supplier<String>(this) {
            final /* synthetic */ LocationTriggerFetchProcessor f10599c;

            public Object get() {
                Builder builder = ImmutableMap.builder();
                builder.b("newsfeed", ImmutableList.of("location_upsell", "event"));
                if (qeAccessor.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForSearchAbTestModule.aS, false)) {
                    builder.b("search_null_state", ImmutableList.of("place", "location_upsell"));
                }
                try {
                    return ((ObjectMapper) provider.get()).a(builder.b());
                } catch (JsonProcessingException e) {
                    throw Throwables.propagate(e);
                }
            }
        });
    }
}
