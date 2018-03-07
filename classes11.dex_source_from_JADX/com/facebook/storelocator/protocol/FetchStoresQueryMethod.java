package com.facebook.storelocator.protocol;

import android.content.Context;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.calls.StoreLocatorInputStoreLocatorArgs;
import com.facebook.graphql.calls.StoreLocatorInputStoreLocatorArgs.GeoBoundingBox;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.storelocator.protocol.StoreLocatorQuery.StoreLocatorNearbyLocationsQueryString;
import com.facebook.storelocator.protocol.StoreLocatorQueryModels.StoreLocatorNearbyLocationsQueryModel;
import com.facebook.storelocator.protocol.StoreLocatorQueryModels.StoreLocatorNearbyLocationsQueryModel.LocationsModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Null VideoItem for Uri %s */
public class FetchStoresQueryMethod {
    private static FetchStoresQueryMethod f12910d;
    private static final Object f12911e = new Object();
    private ProgressDialog f12912a;
    public final TasksManager f12913b;
    private final GraphQLQueryExecutor f12914c;

    /* compiled from: Null VideoItem for Uri %s */
    public interface OnNewLocationsListener {
        void mo363a(ImmutableList<LocationsModel> immutableList);

        void mo364i();
    }

    /* compiled from: Null VideoItem for Uri %s */
    public enum Tasks {
        FETCH_LOCATIONS_TASK
    }

    private static FetchStoresQueryMethod m13583b(InjectorLike injectorLike) {
        return new FetchStoresQueryMethod(TasksManager.b(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public FetchStoresQueryMethod(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f12913b = tasksManager;
        this.f12914c = graphQLQueryExecutor;
    }

    public static FetchStoresQueryMethod m13582a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FetchStoresQueryMethod b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12911e) {
                FetchStoresQueryMethod fetchStoresQueryMethod;
                if (a2 != null) {
                    fetchStoresQueryMethod = (FetchStoresQueryMethod) a2.a(f12911e);
                } else {
                    fetchStoresQueryMethod = f12910d;
                }
                if (fetchStoresQueryMethod == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m13583b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12911e, b3);
                        } else {
                            f12910d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fetchStoresQueryMethod;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m13585a(String str, String str2, String str3, double d, double d2, double d3, double d4, ProgressDialog progressDialog, OnNewLocationsListener onNewLocationsListener) {
        this.f12912a = progressDialog;
        StoreLocatorInputStoreLocatorArgs a = new StoreLocatorInputStoreLocatorArgs().a(new GeoBoundingBox().d(Double.valueOf(d4)).a(Double.valueOf(d)).c(Double.valueOf(d3)).b(Double.valueOf(d2)));
        if (!str.equals("NOT_SET")) {
            a.a(str);
        } else if (!str2.equals("NOT_SET")) {
            a.b(str2);
        } else if (!str3.equals("NOT_SET")) {
            a.c(str3);
        } else {
            return;
        }
        final OnNewLocationsListener onNewLocationsListener2 = onNewLocationsListener;
        this.f12913b.a(Tasks.FETCH_LOCATIONS_TASK, this.f12914c.a(GraphQLRequest.a((StoreLocatorNearbyLocationsQueryString) StoreLocatorQuery.m13588a().a("2", GraphQlQueryDefaults.a()).a("store_locator_args", a))), new AbstractDisposableFutureCallback<GraphQLResult<StoreLocatorNearbyLocationsQueryModel>>(this) {
            final /* synthetic */ FetchStoresQueryMethod f12909b;

            protected final void m13580a(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null) {
                    onNewLocationsListener2.mo364i();
                    return;
                }
                FetchStoresQueryMethod.m13584b(this.f12909b);
                onNewLocationsListener2.mo363a(((StoreLocatorNearbyLocationsQueryModel) graphQLResult.e).m13618a());
            }

            protected final void m13581a(Throwable th) {
                FetchStoresQueryMethod.m13584b(this.f12909b);
                onNewLocationsListener2.mo364i();
            }
        });
    }

    public static void m13584b(FetchStoresQueryMethod fetchStoresQueryMethod) {
        if (fetchStoresQueryMethod.f12912a != null) {
            fetchStoresQueryMethod.f12912a.dismiss();
            fetchStoresQueryMethod.f12912a = null;
        }
    }
}
