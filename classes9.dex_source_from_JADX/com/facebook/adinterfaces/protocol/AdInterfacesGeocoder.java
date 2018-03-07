package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.protocol.AdInterfacesGeocodeQuery.AdInterfacesGeocodeQueryString;
import com.facebook.adinterfaces.protocol.AdInterfacesGeocodeQueryModels.AdInterfacesGeocodeQueryModel;
import com.facebook.adinterfaces.protocol.AdInterfacesGeocodeQueryModels.AdInterfacesGeocodeQueryModel.GeocodeAddressDataModel.EdgesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeocodeAddressDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.ReverseGeocodeDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesReverseGeocodeQuery.AdInterfacesReverseGeocodeQueryString;
import com.facebook.adinterfaces.protocol.AdInterfacesReverseGeocodeQueryModels.AdInterfacesReverseGeocodeQueryModel;
import com.facebook.adinterfaces.ui.AdInterfacesPhoneNumberViewController.C26614;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.GeocodeAddressInputQueryParams;
import com.facebook.graphql.calls.GeocodeAddressInputQueryParams.Addresses;
import com.facebook.graphql.calls.ReverseGeocodeInputQueryParams;
import com.facebook.graphql.calls.ReverseGeocodeInputQueryParams.GpsPoints;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ZZZZ */
public class AdInterfacesGeocoder {
    private final TasksManager f21928a;
    private AdInterfacesErrorReporter f21929b;
    private final GraphQLQueryExecutor f21930c;

    /* compiled from: ZZZZ */
    public interface GeocodeCallbacks {
        void mo986a(double d, double d2);

        void mo987a(Throwable th);
    }

    @VisibleForTesting
    /* compiled from: ZZZZ */
    public enum Key {
        TASK_GEOCODE_ADDRESS,
        TASK_REVERSE_GEOCODE
    }

    public static AdInterfacesGeocoder m23047b(InjectorLike injectorLike) {
        return new AdInterfacesGeocoder(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike));
    }

    @Inject
    public AdInterfacesGeocoder(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AdInterfacesErrorReporter adInterfacesErrorReporter) {
        this.f21930c = graphQLQueryExecutor;
        this.f21928a = tasksManager;
        this.f21929b = adInterfacesErrorReporter;
    }

    public final void m23050a(String str, final GeocodeCallbacks geocodeCallbacks) {
        this.f21928a.a(Key.TASK_GEOCODE_ADDRESS, this.f21930c.a(GraphQLRequest.a((AdInterfacesGeocodeQueryString) new AdInterfacesGeocodeQueryString().a("addresses", new GeocodeAddressInputQueryParams().a(ImmutableList.of(new Addresses().a(str)))))), new AbstractDisposableFutureCallback<GraphQLResult<AdInterfacesGeocodeQueryModel>>(this) {
            final /* synthetic */ AdInterfacesGeocoder f21925b;

            protected final void m23040a(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.d() == null || ((AdInterfacesGeocodeQueryModel) graphQLResult.d()).m23034a() == null || ((AdInterfacesGeocodeQueryModel) graphQLResult.d()).m23034a().m23031a().isEmpty()) {
                    geocodeCallbacks.mo987a(new Throwable("Location not found"));
                    return;
                }
                EdgesModel edgesModel = (EdgesModel) ((AdInterfacesGeocodeQueryModel) graphQLResult.d()).m23034a().m23031a().get(0);
                if (edgesModel == null || edgesModel.m23025a() == null) {
                    geocodeCallbacks.mo987a(new Throwable("Location not found"));
                    return;
                }
                GeocodeAddressDataModel a = edgesModel.m23025a();
                if (StringUtil.a(a.m23456a()) || StringUtil.a(a.m23457j())) {
                    geocodeCallbacks.mo987a(new Throwable("Invalid location data"));
                    return;
                }
                try {
                    geocodeCallbacks.mo986a(Double.parseDouble(a.m23456a()), Double.parseDouble(a.m23457j()));
                } catch (Throwable e) {
                    AdInterfacesGeocoder.m23046a(this.f21925b, e);
                    geocodeCallbacks.mo987a(e);
                }
            }

            protected final void m23041a(Throwable th) {
                geocodeCallbacks.mo987a(th);
            }
        });
    }

    public final void m23049a(double d, double d2, final C26614 c26614) {
        this.f21928a.a(Key.TASK_REVERSE_GEOCODE, this.f21930c.a(GraphQLRequest.a((AdInterfacesReverseGeocodeQueryString) new AdInterfacesReverseGeocodeQueryString().a("coordinates", new ReverseGeocodeInputQueryParams().a(ImmutableList.of(new GpsPoints().a(Double.valueOf(d)).b(Double.valueOf(d2))))))), new AbstractDisposableFutureCallback<GraphQLResult<AdInterfacesReverseGeocodeQueryModel>>(this) {
            final /* synthetic */ AdInterfacesGeocoder f21927b;

            protected final void m23042a(Object obj) {
                try {
                    ReverseGeocodeDataModel reverseGeocodeDataModel = (ReverseGeocodeDataModel) ((AdInterfacesReverseGeocodeQueryModel) ((GraphQLResult) obj).d()).m23947a().m23944a().get(0);
                    C26614 c26614 = c26614;
                    reverseGeocodeDataModel.m23607a();
                    c26614.m24819a(reverseGeocodeDataModel.m23608j());
                } catch (Throwable e) {
                    AdInterfacesGeocoder.m23046a(this.f21927b, e);
                    c26614.m24818a();
                }
            }

            protected final void m23043a(Throwable th) {
                AdInterfacesGeocoder.m23046a(this.f21927b, th);
                c26614.m24818a();
            }
        });
    }

    public static void m23046a(AdInterfacesGeocoder adInterfacesGeocoder, Throwable th) {
        adInterfacesGeocoder.f21929b.m22727a(AdInterfacesGeocoder.class.getClass(), "GraphQL error", th);
    }

    public final void m23048a() {
        this.f21928a.c(Key.TASK_REVERSE_GEOCODE);
        this.f21928a.c(Key.TASK_GEOCODE_ADDRESS);
    }
}
