package com.facebook.places.create.citypicker;

import android.location.Location;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fql.FqlHelper;
import com.facebook.fql.FqlHelper.Field;
import com.facebook.fql.FqlHelper.Table;
import com.facebook.fql.FqlQueryRunner;
import com.facebook.inject.InjectorLike;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.Builder;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.LocationModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: see_more_events */
public class PlaceCreationCityAtLocationQuery {
    public static final Field f3592a = new Field("full_name");
    public static final Field f3593b = new Field("type");
    public static final Field f3594c = new Field("page_fbid");
    public static final Field f3595d = new Field("latitude");
    public static final Field f3596e = new Field("longitude");
    public final FqlQueryRunner f3597f;
    private final ListeningExecutorService f3598g;

    public static PlaceCreationCityAtLocationQuery m3504b(InjectorLike injectorLike) {
        return new PlaceCreationCityAtLocationQuery(FqlQueryRunner.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    PlaceCreationCityAtLocationQuery(FqlQueryRunner fqlQueryRunner, ListeningExecutorService listeningExecutorService) {
        this.f3597f = fqlQueryRunner;
        this.f3598g = listeningExecutorService;
    }

    public final ListenableFuture<Optional<? extends CheckinPlace>> m3505a(final Location location) {
        return this.f3598g.a(new Callable<Optional<? extends CheckinPlace>>(this) {
            final /* synthetic */ PlaceCreationCityAtLocationQuery f3591b;

            /* compiled from: see_more_events */
            class C04601 implements Function<JsonNode, Optional<CheckinPlaceModel>> {
                final /* synthetic */ C04611 f3589a;

                C04601(C04611 c04611) {
                    this.f3589a = c04611;
                }

                public Object apply(Object obj) {
                    JsonNode jsonNode = (JsonNode) obj;
                    if (jsonNode.e() == 0) {
                        return Absent.INSTANCE;
                    }
                    JsonNode a = jsonNode.a(0);
                    Builder builder = new Builder();
                    builder.f = a.b(PlaceCreationCityAtLocationQuery.f3594c.a).B();
                    builder = builder;
                    builder.h = a.b(PlaceCreationCityAtLocationQuery.f3592a.a).B();
                    Builder builder2 = builder;
                    LocationModel.Builder builder3 = new LocationModel.Builder();
                    builder3.a = location.getLatitude();
                    builder3 = builder3;
                    builder3.b = location.getLongitude();
                    builder2.g = builder3.a();
                    return Optional.of(builder2.a());
                }
            }

            public Object call() {
                FqlQueryRunner fqlQueryRunner = this.f3591b.f3597f;
                Location location = location;
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                return (Optional) fqlQueryRunner.a(FqlHelper.a("current_location_city").a(new Field[]{PlaceCreationCityAtLocationQuery.f3592a, PlaceCreationCityAtLocationQuery.f3594c}).a(Table.GEO_REGION).a(PlaceCreationCityAtLocationQuery.f3595d.a(latitude).a(PlaceCreationCityAtLocationQuery.f3596e.a(longitude)).a(PlaceCreationCityAtLocationQuery.f3593b.a("city"))), new C04601(this), CallerContext.a(PlaceCreationCityAtLocationQuery.class));
            }
        });
    }
}
