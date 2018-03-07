package com.facebook.addresstypeahead.fetcher;

import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import com.facebook.addresstypeahead.protocol.AddressTypeAheadQuery.AddressTypeAheadQueryString;
import com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel;
import com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel;
import com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel.StreetResultsModel.EdgesModel.NodeModel;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.graphql.calls.CityStreetSearchInputQueryParams;
import com.facebook.graphql.calls.CityStreetSearchInputQueryParams.Caller;
import com.facebook.graphql.calls.CityStreetSearchInputQueryParams.IntegrationStrategy;
import com.facebook.graphql.calls.CityStreetSearchInputQueryParams.Provider;
import com.facebook.graphql.calls.CityStreetSearchInputQueryParams.ResultOrdering;
import com.facebook.graphql.calls.CityStreetSearchInputQueryParams.SearchType;
import com.facebook.graphql.calls.CityStreetSearchInputQueryParams.ViewerCoordinates;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.location.GooglePlayGoogleApiClientFactory;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.data.DataBufferUtils;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sentByDevice */
public class AddressTypeAheadFetcher {
    public static final LatLngBounds f3909a = new LatLngBounds(new LatLng(-180.0d, -90.0d), new LatLng(180.0d, 90.0d));
    public final GooglePlayGoogleApiClientFactory f3910b;
    public final AbstractFbErrorReporter f3911c;
    private final GraphQLQueryExecutor f3912d;
    public final ExecutorService f3913e;
    public final Locale f3914f;

    /* compiled from: sentByDevice */
    class C03471 implements Function<GraphQLResult<AddressTypeAheadQueryModel>, ImmutableList<Address>> {
        final /* synthetic */ AddressTypeAheadFetcher f3903a;

        C03471(AddressTypeAheadFetcher addressTypeAheadFetcher) {
            this.f3903a = addressTypeAheadFetcher;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((AddressTypeAheadQueryModel) graphQLResult.e).m3811a() == null || ((AddressTypeAheadQueryModel) graphQLResult.e).m3811a().m3809a().isEmpty()) {
                return RegularImmutableList.a;
            }
            Builder builder = ImmutableList.builder();
            ImmutableList a = ((AddressTypeAheadQueryModel) graphQLResult.e).m3811a().m3809a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                NodeModel a2 = ((EdgesModel) a.get(i)).m3804a();
                if (!(a2 == null || a2.m3798a() == null)) {
                    Address address = new Address(this.f3903a.f3914f);
                    address.setLocality(a2.m3800j());
                    address.setAddressLine(0, a2.m3801k());
                    address.setLatitude(a2.m3798a().m3787a());
                    address.setLongitude(a2.m3798a().m3791j());
                    builder.c(address);
                }
            }
            return builder.b();
        }
    }

    /* compiled from: sentByDevice */
    public class C03493 implements Function<GoogleApiClient, LatLng> {
        final /* synthetic */ String f3907a;
        final /* synthetic */ AddressTypeAheadFetcher f3908b;

        public C03493(AddressTypeAheadFetcher addressTypeAheadFetcher, String str) {
            this.f3908b = addressTypeAheadFetcher;
            this.f3907a = str;
        }

        public Object apply(@Nullable Object obj) {
            GoogleApiClient googleApiClient = (GoogleApiClient) obj;
            if (googleApiClient == null) {
                this.f3908b.f3911c.a("AddressTypeAheadFetcher", "Can't connect to Google API client.");
                return null;
            }
            PlaceBuffer placeBuffer = (PlaceBuffer) Places.e.a(googleApiClient, new String[]{this.f3907a}).a(10, TimeUnit.SECONDS);
            if (placeBuffer.cp_().e()) {
                ArrayList a = DataBufferUtils.a(placeBuffer);
                if (!a.isEmpty()) {
                    return ((Place) a.get(0)).b();
                }
                this.f3908b.f3911c.a("AddressTypeAheadFetcher", "Can't get place detail from google place id.");
                return null;
            }
            this.f3908b.f3911c.a("AddressTypeAheadFetcher", "Error getting place detail API call.");
            placeBuffer.c();
            return null;
        }
    }

    public static AddressTypeAheadFetcher m3768b(InjectorLike injectorLike) {
        return new AddressTypeAheadFetcher(GooglePlayGoogleApiClientFactory.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), Locales.a(injectorLike));
    }

    @Inject
    public AddressTypeAheadFetcher(GooglePlayGoogleApiClientFactory googlePlayGoogleApiClientFactory, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, Locales locales) {
        this.f3910b = googlePlayGoogleApiClientFactory;
        this.f3911c = abstractFbErrorReporter;
        this.f3912d = graphQLQueryExecutor;
        this.f3913e = executorService;
        this.f3914f = locales.a();
    }

    public final ListenableFuture<ImmutableList<Address>> m3769a(final String str, @Nullable Location location, int i, boolean z) {
        if (!z) {
            return m3767a(str, location, i);
        }
        final LatLngBounds a = location == null ? f3909a : LatLngBounds.b().a(new LatLng(location.getLatitude(), location.getLongitude())).a();
        return Futures.a(this.f3910b.a(Places.c), new Function<GoogleApiClient, ImmutableList<Address>>(this) {
            final /* synthetic */ AddressTypeAheadFetcher f3906c;

            public Object apply(Object obj) {
                AutocompletePredictionBuffer autocompletePredictionBuffer = (AutocompletePredictionBuffer) Places.e.a((GoogleApiClient) obj, str, a, null).a(10, TimeUnit.SECONDS);
                if (autocompletePredictionBuffer.cp_().e()) {
                    ArrayList a = DataBufferUtils.a(autocompletePredictionBuffer);
                    Builder builder = ImmutableList.builder();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        AutocompletePrediction autocompletePrediction = (AutocompletePrediction) a.get(i);
                        Address address = new Address(this.f3906c.f3914f);
                        address.setAddressLine(0, autocompletePrediction.a(null).toString());
                        address.setLocality(autocompletePrediction.b(null).toString());
                        Bundle bundle = new Bundle();
                        bundle.putString("google_place_id", autocompletePrediction.b());
                        address.setExtras(bundle);
                        builder.c(address);
                    }
                    return builder.b();
                }
                this.f3906c.f3911c.a("AddressTypeAheadFetcher", "Error getting autocomplete prediction API call");
                autocompletePredictionBuffer.c();
                return RegularImmutableList.a;
            }
        }, this.f3913e);
    }

    private ListenableFuture<ImmutableList<Address>> m3767a(String str, @Nullable Location location, int i) {
        GraphQlCallInput graphQlCallInput;
        CityStreetSearchInputQueryParams cityStreetSearchInputQueryParams = new CityStreetSearchInputQueryParams();
        cityStreetSearchInputQueryParams.a("query", str);
        GraphQlCallInput graphQlCallInput2 = cityStreetSearchInputQueryParams;
        if (location != null) {
            ViewerCoordinates viewerCoordinates = new ViewerCoordinates();
            viewerCoordinates.a("latitude", Double.valueOf(location.getLatitude()));
            graphQlCallInput = viewerCoordinates;
            graphQlCallInput.a("longitude", Double.valueOf(location.getLongitude()));
            graphQlCallInput2.a("viewer_coordinates", graphQlCallInput);
        }
        graphQlCallInput2.a("search_type", SearchType.STREET_PLACE_TYPEAHEAD);
        graphQlCallInput = graphQlCallInput2;
        graphQlCallInput.a("provider", Provider.HERE_THRIFT);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("caller", Caller.MESSENGER_TRANSPORTATION_ANDROID);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("result_ordering", ResultOrdering.INTERLEAVE);
        graphQlCallInput.a("integration_strategy", IntegrationStrategy.STRING_MATCH);
        return Futures.a(this.f3912d.a(GraphQLRequest.a((AddressTypeAheadQueryString) new AddressTypeAheadQueryString().a("address", graphQlCallInput2).a("limit", Integer.valueOf(i)))), new C03471(this), MoreExecutors.a());
    }
}
