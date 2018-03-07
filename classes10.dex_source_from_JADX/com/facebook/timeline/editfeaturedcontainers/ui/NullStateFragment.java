package com.facebook.timeline.editfeaturedcontainers.ui;

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
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.timeline.editfeaturedcontainers.models.NullStateData;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQL.NullStateQueryString;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.IntroCardModel;
import com.facebook.timeline.editfeaturedcontainers.rows.adapter.AddFeaturedContainerAdapterFactory;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.HasRowKeyImplEmpty;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.NullStateEnvironmentGenerated;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.NullStateEnvironmentGeneratedProvider;
import com.facebook.timeline.editfeaturedcontainers.utils.CameraRollDataFetcher;
import com.facebook.timeline.editfeaturedcontainers.utils.CameraRollDataFetcher.C15901;
import com.facebook.timeline.editfeaturedcontainers.utils.NullStateMorePageSuggestionsFetcher;
import com.facebook.timeline.editfeaturedcontainers.utils.NullStateSuggestionsDataFetcher;
import com.facebook.timeline.editfeaturedcontainers.utils.NullStateSuggestionsDataFetcher.C15921;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.RecyclerViewAdapterWithHeadersAndFooters;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: geofence_requested_start */
public class NullStateFragment extends FbFragment {
    @Inject
    public ActivityRuntimePermissionsManagerProvider f10934a;
    private NullStateEnvironmentGenerated al;
    private AbstractDisposableFutureCallback<List<MediaModel>> am;
    private AbstractDisposableFutureCallback<IntroCardModel> an;
    @Inject
    @ForUiThread
    private Executor f10935b;
    @Inject
    private NullStateEnvironmentGeneratedProvider f10936c;
    @Inject
    public MultipleRowsStoriesRecycleCallback f10937d;
    @Inject
    private AddFeaturedContainerAdapterFactory f10938e;
    @Inject
    private CameraRollDataFetcher f10939f;
    @Inject
    private NullStateSuggestionsDataFetcher f10940g;
    @Inject
    public NullStateData f10941h;
    public MultiRowRecyclerViewAdapter f10942i;

    /* compiled from: geofence_requested_start */
    public class C15861 implements RuntimePermissionsListener {
        final /* synthetic */ NullStateFragment f10930a;

        public C15861(NullStateFragment nullStateFragment) {
            this.f10930a = nullStateFragment;
        }

        public final void m11062a() {
            NullStateFragment.m11072e(this.f10930a);
        }

        public final void m11063a(String[] strArr, String[] strArr2) {
        }

        public final void m11064b() {
        }
    }

    /* compiled from: geofence_requested_start */
    public class C15872 extends AbstractDisposableFutureCallback<List<MediaModel>> {
        final /* synthetic */ NullStateFragment f10931a;

        public C15872(NullStateFragment nullStateFragment) {
            this.f10931a = nullStateFragment;
        }

        public final void m11065a(Object obj) {
            this.f10931a.f10941h.f10769b.f10765a = (List) obj;
            this.f10931a.f10942i.notifyDataSetChanged();
        }

        public final void m11066a(Throwable th) {
        }
    }

    /* compiled from: geofence_requested_start */
    public class C15883 extends AbstractDisposableFutureCallback<IntroCardModel> {
        final /* synthetic */ NullStateFragment f10932a;

        public C15883(NullStateFragment nullStateFragment) {
            this.f10932a = nullStateFragment;
        }

        public final void m11067a(@Nullable Object obj) {
            IntroCardModel introCardModel = (IntroCardModel) obj;
            if (!(introCardModel == null || introCardModel.m10878j() == null)) {
                this.f10932a.f10941h.f10770c.f10771a = introCardModel.m10878j().m10873a();
            }
            if (!(introCardModel == null || introCardModel.m10877a() == null)) {
                NullStateData nullStateData = this.f10932a.f10941h;
                nullStateData.f10768a.addAll(introCardModel.m10877a().m10868a());
            }
            this.f10932a.f10942i.notifyDataSetChanged();
        }

        public final void m11068a(Throwable th) {
        }
    }

    /* compiled from: geofence_requested_start */
    public class C15894 implements RecyclerListener {
        final /* synthetic */ NullStateFragment f10933a;

        public C15894(NullStateFragment nullStateFragment) {
            this.f10933a = nullStateFragment;
        }

        public final void m11069a(ViewHolder viewHolder) {
            MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback = this.f10933a.f10937d;
            MultipleRowsStoriesRecycleCallback.a(viewHolder.a);
        }
    }

    public static void m11070a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((NullStateFragment) obj).m11071a((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (NullStateEnvironmentGeneratedProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NullStateEnvironmentGeneratedProvider.class), MultipleRowsStoriesRecycleCallback.a(injectorLike), AddFeaturedContainerAdapterFactory.m11003a(injectorLike), CameraRollDataFetcher.m11081a(injectorLike), NullStateSuggestionsDataFetcher.m11090a(injectorLike), NullStateData.m10787a(injectorLike));
    }

    public final void m11075c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = NullStateFragment.class;
        m11070a(this, getContext());
        InjectorLike injectorLike = this.f10936c;
        this.al = new NullStateEnvironmentGenerated(getContext(), HasPrefetcherNoOpImpl.a(injectorLike), HasPersistentStateImpl.b(injectorLike), HasRowKeyImplEmpty.m11008a(injectorLike), (HasContextImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(HasContextImplProvider.class), NullStateMorePageSuggestionsFetcher.m11085a(injectorLike));
        AddFeaturedContainerAdapterFactory addFeaturedContainerAdapterFactory = this.f10938e;
        NullStateEnvironmentGenerated nullStateEnvironmentGenerated = this.al;
        Builder a = addFeaturedContainerAdapterFactory.f10900a.a(addFeaturedContainerAdapterFactory.f10901b, addFeaturedContainerAdapterFactory.f10902c);
        a.f = nullStateEnvironmentGenerated;
        this.f10942i = a.d();
        this.al.mo518a(this.f10942i);
        this.am = new C15872(this);
        this.an = new C15883(this);
        if (VERSION.SDK_INT < 16) {
            m11072e(this);
        } else {
            this.f10934a.a(o()).a(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new C15861(this));
        }
        aq();
    }

    public final View m11074a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1315122549);
        View inflate = layoutInflater.inflate(2130905502, viewGroup, false);
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) inflate.findViewById(16908298);
        betterRecyclerView.setLayoutManager(new BetterLinearLayoutManager(betterRecyclerView.getContext()));
        betterRecyclerView.l();
        betterRecyclerView.setRecyclerListener(new C15894(this));
        betterRecyclerView.setAdapter(new RecyclerViewAdapterWithHeadersAndFooters(this.f10942i));
        betterRecyclerView.setEmptyView(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1123534058, a);
        return inflate;
    }

    public final void m11073I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1881833796);
        this.al.mo516a();
        this.am.jc_();
        this.an.jc_();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -610735245, a);
    }

    public static void m11072e(NullStateFragment nullStateFragment) {
        CameraRollDataFetcher cameraRollDataFetcher = nullStateFragment.f10939f;
        Futures.a(cameraRollDataFetcher.f10953d.a(new C15901(cameraRollDataFetcher)), nullStateFragment.am, nullStateFragment.f10935b);
    }

    private void aq() {
        int dimensionPixelSize = jW_().getDimensionPixelSize(2131433938);
        int dimensionPixelSize2 = jW_().getDimensionPixelSize(2131427471);
        NullStateSuggestionsDataFetcher nullStateSuggestionsDataFetcher = this.f10940g;
        GraphQlQueryString nullStateQueryString = new NullStateQueryString();
        nullStateQueryString.a("photo_size", Integer.valueOf(dimensionPixelSize)).a("page_icon_size", Integer.valueOf(dimensionPixelSize2));
        GraphQLRequest a = GraphQLRequest.a(nullStateQueryString);
        a.f = NullStateSuggestionsDataFetcher.f10966a;
        a = a.a(RequestPriority.INTERACTIVE).a(86400).a(GraphQLCachePolicy.a);
        a.e = ImmutableSet.of("com.facebook.timeline.editfeaturedcontainers.utils.nullStateSuggestionsCacheTag");
        Futures.a(Futures.a(nullStateSuggestionsDataFetcher.f10969b.a(a), new C15921(nullStateSuggestionsDataFetcher), DirectExecutor.INSTANCE), this.an, this.f10935b);
    }

    private void m11071a(Executor executor, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, NullStateEnvironmentGeneratedProvider nullStateEnvironmentGeneratedProvider, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, AddFeaturedContainerAdapterFactory addFeaturedContainerAdapterFactory, CameraRollDataFetcher cameraRollDataFetcher, NullStateSuggestionsDataFetcher nullStateSuggestionsDataFetcher, NullStateData nullStateData) {
        this.f10935b = executor;
        this.f10934a = activityRuntimePermissionsManagerProvider;
        this.f10936c = nullStateEnvironmentGeneratedProvider;
        this.f10937d = multipleRowsStoriesRecycleCallback;
        this.f10938e = addFeaturedContainerAdapterFactory;
        this.f10939f = cameraRollDataFetcher;
        this.f10940g = nullStateSuggestionsDataFetcher;
        this.f10941h = nullStateData;
    }
}
