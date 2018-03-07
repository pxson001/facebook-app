package com.facebook.messaging.location.sending;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.ImmutableLocation;
import com.facebook.messaging.location.sending.graphql.NearbyPlacesGraphQLModels.NearbyPlacesQueryModel;
import com.facebook.messaging.location.sending.graphql.NearbyPlacesGraphQLModels.NearbyPlacesQueryModel.PlaceResultsModel.EdgesModel;
import com.facebook.messaging.location.sending.graphql.NearbyPlacesGraphQLModels.NearbyPlacesQueryModel.PlaceResultsModel.EdgesModel.NodeModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mIsZipVerified */
public class NearbyPlacesLoader {
    private static final CallerContext f11464a = CallerContext.b(NearbyPlacesLoader.class, "nearby_places");
    private static final FbLocationOperationParams f11465b;
    public final NearbyPlaceGraphQLFetcher f11466c;
    private final Provider<FbLocationOperation> f11467d;
    public final TasksManager<NearbyPlacesTask> f11468e;
    public LoadListener f11469f;

    /* compiled from: mIsZipVerified */
    public class C12792 extends AbstractDisposableFutureCallback<NearbyPlacesQueryModel> {
        final /* synthetic */ NearbyPlacesLoader f11463a;

        public C12792(NearbyPlacesLoader nearbyPlacesLoader) {
            this.f11463a = nearbyPlacesLoader;
        }

        protected final void m12058a(Object obj) {
            NearbyPlacesQueryModel nearbyPlacesQueryModel = (NearbyPlacesQueryModel) obj;
            if (this.f11463a.f11469f != null) {
                ImmutableList immutableList;
                LoadListener loadListener = this.f11463a.f11469f;
                if (nearbyPlacesQueryModel.m12151a() == null || nearbyPlacesQueryModel.m12151a().m12147a() == null) {
                    immutableList = RegularImmutableList.a;
                } else {
                    Builder builder = ImmutableList.builder();
                    ImmutableList a = nearbyPlacesQueryModel.m12151a().m12147a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        EdgesModel edgesModel = (EdgesModel) a.get(i);
                        Object obj2 = null;
                        if (edgesModel != null) {
                            NodeModel j = edgesModel.m12143j();
                            if (!(j == null || j.m12135k() == null || j.m12137m() == null || j.m12138n() == null || j.m12138n().m12125a() == null || j.m12136l() == null)) {
                                obj2 = 1;
                            }
                        }
                        if (obj2 != null) {
                            builder.c(NearbyPlacesGraphQLTransformer.m12055b(edgesModel));
                        }
                    }
                    immutableList = builder.b();
                }
                loadListener.mo441a(immutableList);
            }
        }

        protected final void m12059a(Throwable th) {
            if (this.f11463a.f11469f != null) {
                LoadListener loadListener = this.f11463a.f11469f;
                LoadFailureType loadFailureType = LoadFailureType.PLACES_FETCH_FAILED;
                loadListener.mo440a();
            }
        }
    }

    /* compiled from: mIsZipVerified */
    public enum LoadFailureType {
        LOCATION_FETCH_FAILED,
        PLACES_FETCH_FAILED
    }

    /* compiled from: mIsZipVerified */
    public interface LoadListener {
        void mo440a();

        void mo441a(ImmutableList<NearbyPlace> immutableList);
    }

    /* compiled from: mIsZipVerified */
    public enum NearbyPlacesTask {
        GET_LOCATION,
        GET_PLACES
    }

    public static NearbyPlacesLoader m12062b(InjectorLike injectorLike) {
        return new NearbyPlacesLoader(new NearbyPlaceGraphQLFetcher(GraphQLQueryExecutor.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike)), IdBasedProvider.a(injectorLike, 2481), TasksManager.b(injectorLike));
    }

    static {
        FbLocationOperationParams.Builder a = FbLocationOperationParams.a(Priority.HIGH_ACCURACY);
        a.b = 900000;
        a = a;
        a.c = 1200.0f;
        a = a;
        a.d = 15000;
        f11465b = a.a();
    }

    @Inject
    public NearbyPlacesLoader(NearbyPlaceGraphQLFetcher nearbyPlaceGraphQLFetcher, Provider<FbLocationOperation> provider, TasksManager tasksManager) {
        this.f11466c = nearbyPlaceGraphQLFetcher;
        this.f11467d = provider;
        this.f11468e = tasksManager;
    }

    public final void m12064a() {
        this.f11468e.c();
    }

    public final void m12066b() {
        m12063b(null);
    }

    public final void m12065a(String str) {
        m12063b(str);
    }

    private void m12063b(@Nullable final String str) {
        this.f11468e.c();
        FbLocationOperation fbLocationOperation = (FbLocationOperation) this.f11467d.get();
        fbLocationOperation.a(f11465b, f11464a);
        this.f11468e.a(NearbyPlacesTask.GET_LOCATION, fbLocationOperation, new AbstractDisposableFutureCallback<ImmutableLocation>(this) {
            final /* synthetic */ NearbyPlacesLoader f11462b;

            protected final void m12056a(Object obj) {
                ImmutableLocation immutableLocation = (ImmutableLocation) obj;
                NearbyPlacesLoader nearbyPlacesLoader = this.f11462b;
                nearbyPlacesLoader.f11468e.a(NearbyPlacesTask.GET_PLACES, nearbyPlacesLoader.f11466c.m12052a(immutableLocation.l(), str), new C12792(nearbyPlacesLoader));
            }

            protected final void m12057a(Throwable th) {
                if (this.f11462b.f11469f != null) {
                    LoadListener loadListener = this.f11462b.f11469f;
                    LoadFailureType loadFailureType = LoadFailureType.LOCATION_FETCH_FAILED;
                    loadListener.mo440a();
                }
            }
        });
    }
}
