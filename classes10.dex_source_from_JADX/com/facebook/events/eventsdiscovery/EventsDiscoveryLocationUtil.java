package com.facebook.events.eventsdiscovery;

import android.app.Activity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.FbLocationOperationParams.Builder;
import com.facebook.location.ImmutableLocation;
import com.facebook.nearby.v2.typeahead.NearbyPlacesLocationTypeaheadRunner;
import com.facebook.nearby.v2.typeahead.NearbyPlacesTypeaheadParams;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesLocationResult;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.internal.preferences.APP_SETTINGS */
public class EventsDiscoveryLocationUtil {
    private static final String[] f17302a = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    public final FbLocationOperationParams f17303b;
    private ActivityRuntimePermissionsManagerProvider f17304c;
    public FbLocationOperation f17305d;
    public TasksManager f17306e;
    public NearbyPlacesLocationTypeaheadRunner f17307f;

    public static EventsDiscoveryLocationUtil m17593b(InjectorLike injectorLike) {
        return new EventsDiscoveryLocationUtil((ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), IdBasedProvider.a(injectorLike, 2481), TasksManager.b(injectorLike), NearbyPlacesLocationTypeaheadRunner.m4645b(injectorLike));
    }

    public static EventsDiscoveryLocationUtil m17592a(InjectorLike injectorLike) {
        return m17593b(injectorLike);
    }

    @Inject
    public EventsDiscoveryLocationUtil(ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, Provider<FbLocationOperation> provider, TasksManager tasksManager, NearbyPlacesLocationTypeaheadRunner nearbyPlacesLocationTypeaheadRunner) {
        Builder c = FbLocationOperationParams.a(Priority.HIGH_ACCURACY).c(60000);
        c.b = 20000;
        this.f17303b = c.a();
        this.f17304c = activityRuntimePermissionsManagerProvider;
        this.f17305d = (FbLocationOperation) provider.get();
        this.f17306e = tasksManager;
        this.f17307f = nearbyPlacesLocationTypeaheadRunner;
    }

    public final void m17594a(Activity activity, final AbstractDisposableFutureCallback<ImmutableLocation> abstractDisposableFutureCallback, final CallerContext callerContext) {
        this.f17304c.a(activity).a(f17302a, new AbstractRuntimePermissionsListener(this) {
            final /* synthetic */ EventsDiscoveryLocationUtil f17301c;

            /* compiled from: com.facebook.internal.preferences.APP_SETTINGS */
            class C24411 implements Callable<ListenableFuture> {
                final /* synthetic */ C24421 f17298a;

                C24411(C24421 c24421) {
                    this.f17298a = c24421;
                }

                public Object call() {
                    return this.f17298a.f17301c.f17305d;
                }
            }

            public final void m17591a() {
                if (this.f17301c.f17306e.a("event_discovery_get_location_task_key")) {
                    this.f17301c.f17306e.c("event_discovery_get_location_task_key");
                }
                if (this.f17301c.f17305d.isDone()) {
                    abstractDisposableFutureCallback.onSuccess(this.f17301c.f17305d.f());
                    return;
                }
                this.f17301c.f17305d.a(this.f17301c.f17303b, callerContext);
                this.f17301c.f17306e.a("event_discovery_get_location_task_key", new C24411(this), abstractDisposableFutureCallback);
            }
        });
    }

    public final void m17595a(String str, FutureCallback<NearbyPlacesLocationResult> futureCallback) {
        this.f17307f.m4647a(new NearbyPlacesTypeaheadParams(str), futureCallback);
    }
}
