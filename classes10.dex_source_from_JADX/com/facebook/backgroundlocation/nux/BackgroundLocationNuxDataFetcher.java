package com.facebook.backgroundlocation.nux;

import android.content.Context;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLInterfaces.BackgroundLocationNowNuxQuery.Actor;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLInterfaces.BackgroundLocationNuxFriendsSharingLocation;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLModels.BackgroundLocationNowNuxQueryModel;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLModels.BackgroundLocationNowNuxQueryModel.LocationSharingModel;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLInterfaces.BackgroundLocationPrivacyPickerOptions;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLModels.BackgroundLocationUpsellProfileModel;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.location.FbLocationCache;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: download_not_started_due_to_no_wifi_connected */
public class BackgroundLocationNuxDataFetcher {
    private static BackgroundLocationNuxDataFetcher f14749f;
    private static final Object f14750g = new Object();
    public final GraphQLQueryExecutor f14751a;
    public final FbLocationCache f14752b;
    public final GatekeeperStoreImpl f14753c;
    public ListenableFuture<GraphQLResult<BackgroundLocationNowNuxQueryModel>> f14754d;
    public ListenableFuture<GraphQLResult<BackgroundLocationUpsellProfileModel>> f14755e;

    /* compiled from: download_not_started_due_to_no_wifi_connected */
    public class C20641 implements Function<GraphQLResult<BackgroundLocationNowNuxQueryModel>, Boolean> {
        final /* synthetic */ BackgroundLocationNuxDataFetcher f14745a;

        public C20641(BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher) {
            this.f14745a = backgroundLocationNuxDataFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || ((BackgroundLocationNowNuxQueryModel) graphQLResult.e).m15261j() == null) {
                return Boolean.valueOf(false);
            }
            boolean z;
            LocationSharingModel j = ((BackgroundLocationNowNuxQueryModel) graphQLResult.e).m15261j();
            boolean b = j.m15247b();
            int a;
            if (j.m15248c() != null && j.m15248c().m15274a() != null) {
                a = j.m15248c().m15274a().m15266a();
            } else if (j.m15244a() == null || j.m15244a().m15274a() == null) {
                a = 0;
            } else {
                a = j.m15244a().m15274a().m15266a();
            }
            if (!b || r0 <= 0) {
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* compiled from: download_not_started_due_to_no_wifi_connected */
    public class C20652 implements Function<GraphQLResult<BackgroundLocationNowNuxQueryModel>, Actor> {
        final /* synthetic */ BackgroundLocationNuxDataFetcher f14746a;

        public C20652(BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher) {
            this.f14746a = backgroundLocationNuxDataFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return (graphQLResult == null || graphQLResult.e == null) ? null : ((BackgroundLocationNowNuxQueryModel) graphQLResult.e).m15259a();
        }
    }

    /* compiled from: download_not_started_due_to_no_wifi_connected */
    public class C20663 implements Function<GraphQLResult<BackgroundLocationNowNuxQueryModel>, BackgroundLocationPrivacyPickerOptions> {
        final /* synthetic */ BackgroundLocationNuxDataFetcher f14747a;

        public C20663(BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher) {
            this.f14747a = backgroundLocationNuxDataFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            Preconditions.checkNotNull(graphQLResult);
            return ((BackgroundLocationNowNuxQueryModel) graphQLResult.e).m15262k().m15254a();
        }
    }

    /* compiled from: download_not_started_due_to_no_wifi_connected */
    public class C20674 implements Function<GraphQLResult<BackgroundLocationNowNuxQueryModel>, BackgroundLocationNuxFriendsSharingLocation> {
        final /* synthetic */ BackgroundLocationNuxDataFetcher f14748a;

        public C20674(BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher) {
            this.f14748a = backgroundLocationNuxDataFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            Preconditions.checkNotNull(graphQLResult);
            LocationSharingModel j = ((BackgroundLocationNowNuxQueryModel) graphQLResult.e).m15261j();
            if (j == null) {
                return null;
            }
            if (j.m15250k() != null) {
                return j.m15250k();
            }
            return j.m15249j() != null ? j.m15249j() : null;
        }
    }

    private static BackgroundLocationNuxDataFetcher m15118b(InjectorLike injectorLike) {
        return new BackgroundLocationNuxDataFetcher(GraphQLQueryExecutor.a(injectorLike), FbLocationCache.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BackgroundLocationNuxDataFetcher(GraphQLQueryExecutor graphQLQueryExecutor, FbLocationCache fbLocationCache, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f14751a = graphQLQueryExecutor;
        this.f14752b = fbLocationCache;
        this.f14753c = gatekeeperStoreImpl;
    }

    public static BackgroundLocationNuxDataFetcher m15117a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BackgroundLocationNuxDataFetcher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14750g) {
                BackgroundLocationNuxDataFetcher backgroundLocationNuxDataFetcher;
                if (a2 != null) {
                    backgroundLocationNuxDataFetcher = (BackgroundLocationNuxDataFetcher) a2.a(f14750g);
                } else {
                    backgroundLocationNuxDataFetcher = f14749f;
                }
                if (backgroundLocationNuxDataFetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15118b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14750g, b3);
                        } else {
                            f14749f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = backgroundLocationNuxDataFetcher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
