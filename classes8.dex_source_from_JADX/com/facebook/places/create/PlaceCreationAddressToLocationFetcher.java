package com.facebook.places.create;

import android.location.Location;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.places.create.graphql.GeocodeAddressModels.GeocodeAddressToLocationModel;
import com.facebook.places.create.graphql.GeocodeAddressModels.GeocodeAddressToLocationModel.GeocodeAddressDataModel.EdgesModel;
import com.facebook.places.create.graphql.GeocodeAddressModels.GeocodeAddressToLocationModel.GeocodeAddressDataModel.EdgesModel.NodeModel;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: centerCrop */
public class PlaceCreationAddressToLocationFetcher {
    public final GraphQLQueryExecutor f18184a;
    public final ListeningExecutorService f18185b;

    /* compiled from: centerCrop */
    public class C19741 implements Function<GraphQLResult<GeocodeAddressToLocationModel>, Optional<Location>> {
        final /* synthetic */ PlaceCreationAddressToLocationFetcher f18183a;

        public C19741(PlaceCreationAddressToLocationFetcher placeCreationAddressToLocationFetcher) {
            this.f18183a = placeCreationAddressToLocationFetcher;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((GeocodeAddressToLocationModel) graphQLResult.e).m22207a() == null || ((GeocodeAddressToLocationModel) graphQLResult.e).m22207a().m22203a().isEmpty()) {
                return Absent.INSTANCE;
            }
            NodeModel a = ((EdgesModel) ((GeocodeAddressToLocationModel) graphQLResult.e).m22207a().m22203a().get(0)).m22198a();
            Location location = new Location("");
            location.setLatitude(Double.parseDouble(a.m22193a()));
            location.setLongitude(Double.parseDouble(a.m22194j()));
            return Optional.of(location);
        }
    }

    @Inject
    public PlaceCreationAddressToLocationFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f18184a = graphQLQueryExecutor;
        this.f18185b = listeningExecutorService;
    }
}
