package com.facebook.timeline.favmediapicker.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.RecyclerListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.environment.impl.HasContextImplProvider;
import com.facebook.feed.environment.impl.HasPersistentStateImpl;
import com.facebook.feed.environment.impl.HasPrefetcherNoOpImpl;
import com.facebook.feed.photoreminder.model.MediaModel;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.timeline.favmediapicker.models.FavoriteMediaPickerData;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestions.FavoriteMediaSuggestionsQueryString;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsModels.SuggestedMediasetModel;
import com.facebook.timeline.favmediapicker.rows.FavoriteMediaPickerAdapterFactory;
import com.facebook.timeline.favmediapicker.rows.environments.FavoriteMediaPickerEnvironmentGenerated;
import com.facebook.timeline.favmediapicker.rows.environments.FavoriteMediaPickerEnvironmentGeneratedProvider;
import com.facebook.timeline.favmediapicker.rows.environments.HasRowKeyImplEmpty;
import com.facebook.timeline.favmediapicker.utils.CameraRollDataFetcher;
import com.facebook.timeline.favmediapicker.utils.CameraRollDataFetcher.C16131;
import com.facebook.timeline.favmediapicker.utils.FavoriteMediaSuggestionsDataFetcher;
import com.facebook.timeline.favmediapicker.utils.FavoriteMediaSuggestionsDataFetcher.C16141;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.RecyclerViewAdapterWithHeadersAndFooters;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friends_nearby_replace_precise_location_sharing_delete_outgoing_ping_failure */
public class FavoriteMediaPickerFragment extends FbFragment {
    @Inject
    ActivityRuntimePermissionsManagerProvider f11121a;
    private AbstractDisposableFutureCallback<List<MediaModel>> al;
    private AbstractDisposableFutureCallback<ImmutableList<SuggestedMediasetModel>> am;
    @Inject
    @ForUiThread
    private Executor f11122b;
    @Inject
    private FavoriteMediaPickerEnvironmentGeneratedProvider f11123c;
    @Inject
    public MultipleRowsStoriesRecycleCallback f11124d;
    @Inject
    private FavoriteMediaPickerAdapterFactory f11125e;
    @Inject
    private CameraRollDataFetcher f11126f;
    @Inject
    private FavoriteMediaSuggestionsDataFetcher f11127g;
    @Inject
    public FavoriteMediaPickerData f11128h;
    public MultiRowRecyclerViewAdapter f11129i;

    /* compiled from: friends_nearby_replace_precise_location_sharing_delete_outgoing_ping_failure */
    public class C16091 extends AbstractDisposableFutureCallback<List<MediaModel>> {
        final /* synthetic */ FavoriteMediaPickerFragment f11117a;

        public C16091(FavoriteMediaPickerFragment favoriteMediaPickerFragment) {
            this.f11117a = favoriteMediaPickerFragment;
        }

        public final void m11277a(Object obj) {
            this.f11117a.f11128h.f11020b.f11016a = (List) obj;
            this.f11117a.f11129i.notifyDataSetChanged();
        }

        public final void m11278a(Throwable th) {
        }
    }

    /* compiled from: friends_nearby_replace_precise_location_sharing_delete_outgoing_ping_failure */
    public class C16102 extends AbstractDisposableFutureCallback<ImmutableList<SuggestedMediasetModel>> {
        final /* synthetic */ FavoriteMediaPickerFragment f11118a;

        public C16102(FavoriteMediaPickerFragment favoriteMediaPickerFragment) {
            this.f11118a = favoriteMediaPickerFragment;
        }

        public final void m11279a(@Nullable Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            if (immutableList != null) {
                this.f11118a.f11128h.f11019a.addAll(immutableList);
                this.f11118a.f11129i.notifyDataSetChanged();
            }
        }

        public final void m11280a(Throwable th) {
        }
    }

    /* compiled from: friends_nearby_replace_precise_location_sharing_delete_outgoing_ping_failure */
    class C16113 implements RuntimePermissionsListener {
        final /* synthetic */ FavoriteMediaPickerFragment f11119a;

        C16113(FavoriteMediaPickerFragment favoriteMediaPickerFragment) {
            this.f11119a = favoriteMediaPickerFragment;
        }

        public final void m11281a() {
            FavoriteMediaPickerFragment.ar(this.f11119a);
        }

        public final void m11282a(String[] strArr, String[] strArr2) {
        }

        public final void m11283b() {
        }
    }

    /* compiled from: friends_nearby_replace_precise_location_sharing_delete_outgoing_ping_failure */
    public class C16124 implements RecyclerListener {
        final /* synthetic */ FavoriteMediaPickerFragment f11120a;

        public C16124(FavoriteMediaPickerFragment favoriteMediaPickerFragment) {
            this.f11120a = favoriteMediaPickerFragment;
        }

        public final void m11284a(ViewHolder viewHolder) {
            MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback = this.f11120a.f11124d;
            MultipleRowsStoriesRecycleCallback.a(viewHolder.a);
        }
    }

    public static void m11285a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FavoriteMediaPickerFragment) obj).m11286a((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (FavoriteMediaPickerEnvironmentGeneratedProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FavoriteMediaPickerEnvironmentGeneratedProvider.class), MultipleRowsStoriesRecycleCallback.a(injectorLike), FavoriteMediaPickerAdapterFactory.m11203a(injectorLike), CameraRollDataFetcher.m11291a(injectorLike), FavoriteMediaSuggestionsDataFetcher.m11293a(injectorLike), FavoriteMediaPickerData.m11147a(injectorLike));
    }

    public final void m11289c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = FavoriteMediaPickerFragment.class;
        m11285a(this, getContext());
        FavoriteMediaPickerAdapterFactory favoriteMediaPickerAdapterFactory = this.f11125e;
        FavoriteMediaPickerEnvironmentGeneratedProvider favoriteMediaPickerEnvironmentGeneratedProvider = this.f11123c;
        AnyEnvironment favoriteMediaPickerEnvironmentGenerated = new FavoriteMediaPickerEnvironmentGenerated(getContext(), HasPrefetcherNoOpImpl.a(favoriteMediaPickerEnvironmentGeneratedProvider), HasPersistentStateImpl.b(favoriteMediaPickerEnvironmentGeneratedProvider), new HasRowKeyImplEmpty(), (HasContextImplProvider) favoriteMediaPickerEnvironmentGeneratedProvider.getOnDemandAssistedProviderForStaticDi(HasContextImplProvider.class));
        Builder a = favoriteMediaPickerAdapterFactory.f11034a.a(favoriteMediaPickerAdapterFactory.f11035b, favoriteMediaPickerAdapterFactory.f11036c);
        a.f = favoriteMediaPickerEnvironmentGenerated;
        this.f11129i = a.d();
        this.al = new C16091(this);
        this.am = new C16102(this);
        aq();
        as();
    }

    public final View m11288a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -716291221);
        View inflate = layoutInflater.inflate(2130904245, viewGroup, false);
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) inflate.findViewById(16908298);
        betterRecyclerView.setLayoutManager(new BetterLinearLayoutManager(betterRecyclerView.getContext()));
        betterRecyclerView.l();
        betterRecyclerView.setRecyclerListener(new C16124(this));
        betterRecyclerView.setAdapter(new RecyclerViewAdapterWithHeadersAndFooters(this.f11129i));
        betterRecyclerView.setEmptyView(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1292155345, a);
        return inflate;
    }

    public final void m11287I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1260185219);
        this.al.jc_();
        this.am.jc_();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1856746266, a);
    }

    private void aq() {
        if (VERSION.SDK_INT < 16) {
            ar(this);
            return;
        }
        this.f11121a.a(o()).a(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new C16113(this));
    }

    public static void ar(FavoriteMediaPickerFragment favoriteMediaPickerFragment) {
        CameraRollDataFetcher cameraRollDataFetcher = favoriteMediaPickerFragment.f11126f;
        Futures.a(cameraRollDataFetcher.f11138d.a(new C16131(cameraRollDataFetcher)), favoriteMediaPickerFragment.al, favoriteMediaPickerFragment.f11122b);
    }

    private void as() {
        int dimensionPixelSize = jW_().getDimensionPixelSize(2131433945);
        FavoriteMediaSuggestionsDataFetcher favoriteMediaSuggestionsDataFetcher = this.f11127g;
        GraphQlQueryString favoriteMediaSuggestionsQueryString = new FavoriteMediaSuggestionsQueryString();
        favoriteMediaSuggestionsQueryString.a("photo_size", Integer.valueOf(dimensionPixelSize));
        GraphQLRequest a = GraphQLRequest.a(favoriteMediaSuggestionsQueryString);
        a.f = FavoriteMediaSuggestionsDataFetcher.f11141a;
        a = a.a(RequestPriority.INTERACTIVE).a(86400).a(GraphQLCachePolicy.a);
        a.e = Collections.singleton("com.facebook.timeline.favmediapicker.utils.favoriteMediaSuggestionsCacheTag");
        Futures.a(Futures.a(favoriteMediaSuggestionsDataFetcher.f11144b.a(a), new C16141(favoriteMediaSuggestionsDataFetcher), DirectExecutor.INSTANCE), this.am, this.f11122b);
    }

    private void m11286a(Executor executor, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, FavoriteMediaPickerEnvironmentGeneratedProvider favoriteMediaPickerEnvironmentGeneratedProvider, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, FavoriteMediaPickerAdapterFactory favoriteMediaPickerAdapterFactory, CameraRollDataFetcher cameraRollDataFetcher, FavoriteMediaSuggestionsDataFetcher favoriteMediaSuggestionsDataFetcher, FavoriteMediaPickerData favoriteMediaPickerData) {
        this.f11122b = executor;
        this.f11121a = activityRuntimePermissionsManagerProvider;
        this.f11123c = favoriteMediaPickerEnvironmentGeneratedProvider;
        this.f11124d = multipleRowsStoriesRecycleCallback;
        this.f11125e = favoriteMediaPickerAdapterFactory;
        this.f11126f = cameraRollDataFetcher;
        this.f11127g = favoriteMediaSuggestionsDataFetcher;
        this.f11128h = favoriteMediaPickerData;
    }
}
