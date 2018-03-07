package com.facebook.feedplugins.localad;

import android.app.Activity;
import com.facebook.adinterfaces.protocol.AdInterfacesGeocoder;
import com.facebook.adinterfaces.protocol.AdInterfacesGeocoder.GeocodeCallbacks;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryBuilder;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsInterfaces.AdGeoCircle;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdGeoCircleModel;
import com.facebook.adinterfaces.protocol.FetchRecommendedRadiusMethod;
import com.facebook.adinterfaces.ui.AdInterfacesMapPreviewViewController;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureUtils;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.FbLocationOperationParams.Builder;
import com.facebook.location.ImmutableLocation;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: a8ec7a4ddbc6f57bc28fc18c5eda56c7 */
public class AdInterfacesLocationFetcher {
    private static final String[] f24668a = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    public static final Class<?> f24669b = AdInterfacesLocationFetcher.class;
    private static final CallerContext f24670c = CallerContext.b(AdInterfacesMapPreviewViewController.class, "location_fetcher");
    private static final FbLocationOperationParams f24671d;
    private ActivityRuntimePermissionsManagerProvider f24672e;
    public final AbstractFbErrorReporter f24673f;
    private final Provider<FbLocationOperation> f24674g;
    private FetchRecommendedRadiusMethod f24675h;
    public final TasksManager f24676i;
    public AdInterfacesGeocoder f24677j;

    /* compiled from: a8ec7a4ddbc6f57bc28fc18c5eda56c7 */
    public interface LocationFetcherListener {
        void mo945a(@Nullable AdGeoCircleModel adGeoCircleModel);
    }

    /* compiled from: a8ec7a4ddbc6f57bc28fc18c5eda56c7 */
    public class C29751 implements GeocodeCallbacks {
        final /* synthetic */ LocationFetcherListener f24660a;
        final /* synthetic */ AdInterfacesLocationFetcher f24661b;

        public C29751(AdInterfacesLocationFetcher adInterfacesLocationFetcher, LocationFetcherListener locationFetcherListener) {
            this.f24661b = adInterfacesLocationFetcher;
            this.f24660a = locationFetcherListener;
        }

        public final void mo986a(double d, double d2) {
            this.f24661b.m26560a(d, d2, this.f24660a);
        }

        public final void mo987a(Throwable th) {
            this.f24660a.mo945a(null);
            this.f24661b.f24673f.a(AdInterfacesLocationFetcher.f24669b.getSimpleName(), "Failed to geocode", th);
        }
    }

    /* compiled from: a8ec7a4ddbc6f57bc28fc18c5eda56c7 */
    public enum Key {
        FETCH_LOCATION,
        FETCH_RADIUS
    }

    public static AdInterfacesLocationFetcher m26563b(InjectorLike injectorLike) {
        return new AdInterfacesLocationFetcher((ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), TasksManager.b(injectorLike), IdBasedProvider.a(injectorLike, 2481), new FetchRecommendedRadiusMethod(GraphQLQueryExecutor.a(injectorLike), AdInterfacesQueryBuilder.m23051a(injectorLike)), AdInterfacesGeocoder.m23047b(injectorLike));
    }

    static {
        Builder c = FbLocationOperationParams.a(Priority.HIGH_ACCURACY).c(900000);
        c.b = 180000;
        c = c;
        c.c = 500.0f;
        c = c;
        c.d = 5000;
        f24671d = c.a();
    }

    @Inject
    public AdInterfacesLocationFetcher(ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, FbErrorReporter fbErrorReporter, TasksManager tasksManager, Provider<FbLocationOperation> provider, FetchRecommendedRadiusMethod fetchRecommendedRadiusMethod, AdInterfacesGeocoder adInterfacesGeocoder) {
        this.f24672e = activityRuntimePermissionsManagerProvider;
        this.f24673f = fbErrorReporter;
        this.f24674g = provider;
        this.f24675h = fetchRecommendedRadiusMethod;
        this.f24676i = tasksManager;
        this.f24677j = adInterfacesGeocoder;
    }

    public final void m26565a(final LocationFetcherListener locationFetcherListener, Activity activity) {
        this.f24672e.a(activity).a(f24668a, new RuntimePermissionsListener(this) {
            final /* synthetic */ AdInterfacesLocationFetcher f24663b;

            public final void m26553a() {
                AdInterfacesLocationFetcher.m26562a(this.f24663b, locationFetcherListener);
            }

            public final void m26554a(String[] strArr, String[] strArr2) {
                locationFetcherListener.mo945a(null);
            }

            public final void m26555b() {
                locationFetcherListener.mo945a(null);
            }
        });
    }

    public static void m26562a(AdInterfacesLocationFetcher adInterfacesLocationFetcher, final LocationFetcherListener locationFetcherListener) {
        adInterfacesLocationFetcher.f24676i.c(Key.FETCH_RADIUS);
        FbLocationOperation fbLocationOperation = (FbLocationOperation) adInterfacesLocationFetcher.f24674g.get();
        fbLocationOperation.a(f24671d, f24670c);
        if (fbLocationOperation.isDone()) {
            ImmutableLocation immutableLocation = (ImmutableLocation) FutureUtils.a(fbLocationOperation);
            if (immutableLocation != null) {
                adInterfacesLocationFetcher.m26560a(immutableLocation.a(), immutableLocation.b(), locationFetcherListener);
                return;
            }
        }
        adInterfacesLocationFetcher.f24676i.a(Key.FETCH_LOCATION, fbLocationOperation, new AbstractDisposableFutureCallback<ImmutableLocation>(adInterfacesLocationFetcher) {
            final /* synthetic */ AdInterfacesLocationFetcher f24665b;

            protected final void m26556a(Object obj) {
                ImmutableLocation immutableLocation = (ImmutableLocation) obj;
                if (immutableLocation != null) {
                    this.f24665b.m26560a(immutableLocation.a(), immutableLocation.b(), locationFetcherListener);
                } else {
                    locationFetcherListener.mo945a(null);
                }
            }

            protected final void m26557a(Throwable th) {
                locationFetcherListener.mo945a(null);
                this.f24665b.f24673f.a(AdInterfacesLocationFetcher.f24669b.getSimpleName(), "Failed to get location", th);
            }
        });
    }

    private void m26560a(double d, double d2, final LocationFetcherListener locationFetcherListener) {
        this.f24676i.a(Key.FETCH_RADIUS, this.f24675h.m24235a(d, d2), new AbstractDisposableFutureCallback<GraphQLResult<AdGeoCircle>>(this) {
            final /* synthetic */ AdInterfacesLocationFetcher f24667b;

            protected final void m26558a(Object obj) {
                AdGeoCircleModel adGeoCircleModel;
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                LocationFetcherListener locationFetcherListener = locationFetcherListener;
                if (graphQLResult == null) {
                    adGeoCircleModel = null;
                } else {
                    adGeoCircleModel = (AdGeoCircleModel) graphQLResult.e;
                }
                locationFetcherListener.mo945a(adGeoCircleModel);
            }

            protected final void m26559a(Throwable th) {
                this.f24667b.f24673f.a(AdInterfacesLocationFetcher.f24669b.getSimpleName(), "Failed to get radius", th);
            }
        });
    }

    public final void m26564a() {
        this.f24676i.c(Key.FETCH_LOCATION);
        this.f24676i.c(Key.FETCH_RADIUS);
    }
}
