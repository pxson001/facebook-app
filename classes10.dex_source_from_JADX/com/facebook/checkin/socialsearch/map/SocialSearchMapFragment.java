package com.facebook.checkin.socialsearch.map;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.base.fragment.FbFragment;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQL.FetchPlaceListForMapQueryString;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLModels.PlaceListDetailsModel;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLModels.PlaceListDetailsModel.ListItemsModel.NodesModel;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLModels.PlaceRecommendationPageFieldsModel;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbMapFragmentDelegate;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapFragmentDelegate;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.story.GraphQLStoryHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: deleted_request_ids */
public class SocialSearchMapFragment extends FbFragment implements OnMapReadyDelegateCallback {
    public static String f15114a = "place_list_id";
    public static String f15115b = "map_center";
    @Inject
    public PlaceListFetcher f15116c;
    @Inject
    @ForUiThread
    public Executor f15117d;
    public MapFragmentDelegate f15118e;

    /* compiled from: deleted_request_ids */
    public class C21031 implements FutureCallback<GraphQLResult<PlaceListDetailsModel>> {
        final /* synthetic */ SocialSearchMapFragment f15113a;

        public C21031(SocialSearchMapFragment socialSearchMapFragment) {
            this.f15113a = socialSearchMapFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((PlaceListDetailsModel) graphQLResult.e).j() != null) {
                final ImmutableList a = ((PlaceListDetailsModel) graphQLResult.e).j().a();
                this.f15113a.f15118e.a(new OnMapReadyDelegateCallback(this) {
                    final /* synthetic */ C21031 f15112b;

                    public final void m15631a(MapDelegate mapDelegate) {
                        SocialSearchMapFragment socialSearchMapFragment = this.f15112b.f15113a;
                        ImmutableList immutableList = a;
                        int size = immutableList.size();
                        for (int i = 0; i < size; i++) {
                            PlaceRecommendationPageFieldsModel j = ((NodesModel) immutableList.get(i)).j();
                            if (j != null) {
                                DefaultLocationFieldsModel j2 = j.j();
                                if (j2 != null) {
                                    MarkerOptions markerOptions = new MarkerOptions();
                                    markerOptions.b = new LatLng(j2.a(), j2.b());
                                    MarkerOptions markerOptions2 = markerOptions;
                                    markerOptions2.i = j.k();
                                    MarkerOptions markerOptions3 = markerOptions2;
                                    markerOptions3.c = BitmapDescriptorFactory.a(2130841141);
                                    mapDelegate.a(markerOptions3);
                                }
                            }
                        }
                    }
                });
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    public static void m15632a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SocialSearchMapFragment socialSearchMapFragment = (SocialSearchMapFragment) obj;
        PlaceListFetcher placeListFetcher = new PlaceListFetcher(GraphQLQueryExecutor.a(fbInjector), GraphQLStoryHelper.a(fbInjector), GraphQLImageHelper.a(fbInjector));
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        socialSearchMapFragment.f15116c = placeListFetcher;
        socialSearchMapFragment.f15117d = executor;
    }

    public final void m15637c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = SocialSearchMapFragment.class;
        m15632a(this, getContext());
    }

    public final View m15634a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1161225604);
        View inflate = layoutInflater.inflate(2130906249, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1598414126, a);
        return inflate;
    }

    public final void m15635a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof FbMapFragmentDelegate) {
            this.f15118e = (MapFragmentDelegate) fragment;
            this.f15118e.a(this);
            String string = this.s.getString(f15114a);
            PlaceListFetcher placeListFetcher = this.f15116c;
            FetchPlaceListForMapQueryString fetchPlaceListForMapQueryString = new FetchPlaceListForMapQueryString();
            fetchPlaceListForMapQueryString.a("place_list_id", string);
            fetchPlaceListForMapQueryString.a("profile_image_size", GraphQLStoryHelper.a());
            fetchPlaceListForMapQueryString.a("profile_pic_media_type", placeListFetcher.f15110c.b());
            Futures.a(placeListFetcher.f15108a.a(GraphQLRequest.a(fetchPlaceListForMapQueryString).a(GraphQLCachePolicy.c)), new C21031(this), this.f15117d);
        }
    }

    public final void m15633I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1772389655);
        this.f15118e = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1752342126, a);
    }

    public final void m15636a(MapDelegate mapDelegate) {
        GraphQLLocation az = ((GraphQLPage) FlatBufferModelHelper.a(this.s, f15115b)).az();
        mapDelegate.a(CameraUpdateFactoryDelegate.a(new LatLng(az.a(), az.b()), 13.0f));
    }
}
