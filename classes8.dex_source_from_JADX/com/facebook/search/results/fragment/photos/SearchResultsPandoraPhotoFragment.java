package com.facebook.search.results.fragment.photos;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.pandora.common.data.GraphSearchPandoraInstanceId;
import com.facebook.photos.pandora.common.events.PandoraEventBus;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEvent;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEventSubscriber;
import com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererResult;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererConfiguration;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererMixedMediaGridConfiguration;
import com.facebook.photos.pandora.common.ui.views.PandoraBennyLoadingSpinnerView;
import com.facebook.photos.pandora.ui.PandoraAdapter;
import com.facebook.photos.pandora.ui.PandoraPhotoCollageAdapter;
import com.facebook.photos.pandora.ui.PandoraPhotoCollageAdapter.PhotoCollageLoadingListener;
import com.facebook.photos.pandora.ui.PandoraPhotoCollageAdapterProvider;
import com.facebook.photos.pandora.ui.listview.PandoraFeedListView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.fragment.GraphSearchChildFragment.OnResultClickListener;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.protocol.Fb4aGraphSearchPhotoQueryModels.Fb4aGraphSearchPhotoQueryModel;
import com.facebook.search.results.fragment.SearchResultsBaseFragment;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SENTRY_FAIL */
public class SearchResultsPandoraPhotoFragment extends SearchResultsBaseFragment {
    private static final Function<String, String> as = new C24751();
    private final ConsumptionGalleryEventSubscriber aA = new ConsumptionGalleryEventSubscriber(this);
    private final SearchResultsContextFutureCallback aB = new SearchResultsContextFutureCallback(this);
    @Inject
    @LoggedInUserId
    String al;
    @Inject
    GraphSearchFetchPhotosFutureGeneratorProvider am;
    @Inject
    Lazy<PandoraEventBus> an;
    @Inject
    Lazy<MediaGalleryLauncher> ao;
    @Inject
    Lazy<PandoraRendererMixedMediaGridConfiguration> ap;
    @Inject
    FullscreenVideoPlayerLauncher aq;
    @Inject
    GatekeeperStoreImpl ar;
    public OnResultClickListener at;
    public PandoraPhotoCollageAdapter au;
    public LinearLayout av;
    public PandoraBennyLoadingSpinnerView aw;
    public int ax;
    public boolean ay = false;
    private final PhotoCollageDataSetObserver az = new PhotoCollageDataSetObserver(this);
    @Inject
    SearchResultsLogger f23077h;
    @Inject
    PandoraPhotoCollageAdapterProvider f23078i;

    /* compiled from: SENTRY_FAIL */
    final class C24751 implements Function<String, String> {
        C24751() {
        }

        @Nullable
        public final Object apply(@Nullable Object obj) {
            return SearchQueryFunctions.s((String) obj);
        }
    }

    /* compiled from: SENTRY_FAIL */
    class C24762 implements PhotoCollageLoadingListener {
        final /* synthetic */ SearchResultsPandoraPhotoFragment f23073a;

        C24762(SearchResultsPandoraPhotoFragment searchResultsPandoraPhotoFragment) {
            this.f23073a = searchResultsPandoraPhotoFragment;
        }

        public final void mo904a() {
        }

        public final void mo905a(PandoraRendererResult pandoraRendererResult) {
            this.f23073a.ay = true;
            SearchResultsLogger searchResultsLogger = this.f23073a.f23077h;
            SearchResultsMutableContext searchResultsMutableContext = this.f23073a.f22960h;
            SearchResultsPandoraPhotoFragment searchResultsPandoraPhotoFragment = this.f23073a;
            int i = searchResultsPandoraPhotoFragment.ax;
            searchResultsPandoraPhotoFragment.ax = i + 1;
            searchResultsLogger.m25470a(searchResultsMutableContext, i, pandoraRendererResult.f17472a.size(), null, null);
        }
    }

    /* compiled from: SENTRY_FAIL */
    class ConsumptionGalleryEventSubscriber extends LaunchConsumptionGalleryEventSubscriber {
        final /* synthetic */ SearchResultsPandoraPhotoFragment f23074a;

        public ConsumptionGalleryEventSubscriber(SearchResultsPandoraPhotoFragment searchResultsPandoraPhotoFragment) {
            this.f23074a = searchResultsPandoraPhotoFragment;
        }

        public final void m26735b(FbEvent fbEvent) {
            LaunchConsumptionGalleryEvent launchConsumptionGalleryEvent = (LaunchConsumptionGalleryEvent) fbEvent;
            if ((this.f23074a.at == null || !this.f23074a.at.mo1202a(launchConsumptionGalleryEvent)) && !Strings.isNullOrEmpty(launchConsumptionGalleryEvent.f17374a) && this.f23074a.au != null) {
                int i = -1;
                ImmutableList d = this.f23074a.au.f17457i.m21444d();
                int size = d.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    int i4;
                    if (Objects.equal(launchConsumptionGalleryEvent.f17374a, ((SizeAwareMedia) d.get(i2)).d())) {
                        i4 = i3;
                    } else {
                        i4 = i;
                    }
                    i2++;
                    i3++;
                    i = i4;
                }
                if (launchConsumptionGalleryEvent.f17379f != null) {
                    this.f23074a.f23077h.m25476a(this.f23074a.f22960h, i, launchConsumptionGalleryEvent.f17379f.J());
                    this.f23074a.aq.m11256a(launchConsumptionGalleryEvent.f17379f, this.f23074a.getContext(), PlayerOrigin.RESULTS_PAGE_MIXED_MEDIA);
                    return;
                }
                this.f23074a.f23077h.m25476a(this.f23074a.f22960h, i, launchConsumptionGalleryEvent.f17374a);
                ((MediaGalleryLauncher) this.f23074a.ao.get()).a(this.f23074a.getContext(), MediaGalleryLauncherParamsFactory.c(this.f23074a.au.f17457i.m21444d()).a(launchConsumptionGalleryEvent.f17374a).a(ImageRequest.a(launchConsumptionGalleryEvent.f17375b)).a(FullscreenGallerySource.SEARCH_PHOTO_RESULTS_PAGE).b(), null);
            }
        }
    }

    /* compiled from: SENTRY_FAIL */
    public class PhotoCollageDataSetObserver extends DataSetObserver {
        public final /* synthetic */ SearchResultsPandoraPhotoFragment f23075a;

        public PhotoCollageDataSetObserver(SearchResultsPandoraPhotoFragment searchResultsPandoraPhotoFragment) {
            this.f23075a = searchResultsPandoraPhotoFragment;
        }

        public void onChanged() {
            int i;
            LinearLayout linearLayout = this.f23075a.av;
            Object obj = null;
            if (!(this.f23075a.au == null || this.f23075a.au.f17457i == null || this.f23075a.au.f17457i.f17469a == null || this.f23075a.au.f17457i.f17469a.isEmpty())) {
                obj = 1;
            }
            if (obj == null) {
                i = 0;
            } else {
                i = 8;
            }
            linearLayout.setVisibility(i);
            this.f23075a.aw.setVisibility(8);
        }
    }

    /* compiled from: SENTRY_FAIL */
    class SearchResultsContextFutureCallback implements FutureCallback<GraphQLResult<Fb4aGraphSearchPhotoQueryModel>> {
        final /* synthetic */ SearchResultsPandoraPhotoFragment f23076a;

        public SearchResultsContextFutureCallback(SearchResultsPandoraPhotoFragment searchResultsPandoraPhotoFragment) {
            this.f23076a = searchResultsPandoraPhotoFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((Fb4aGraphSearchPhotoQueryModel) graphQLResult.e).m8490a() != null) {
                this.f23076a.f22960h.m27092c(((Fb4aGraphSearchPhotoQueryModel) graphQLResult.e).m8490a().m8486l());
                this.f23076a.f22960h.m27093d(((Fb4aGraphSearchPhotoQueryModel) graphQLResult.e).m8490a().m8484j());
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    public static void m26737a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SearchResultsPandoraPhotoFragment) obj).m26736a(SearchResultsLogger.m25460a(injectorLike), (PandoraPhotoCollageAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PandoraPhotoCollageAdapterProvider.class), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), (GraphSearchFetchPhotosFutureGeneratorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphSearchFetchPhotosFutureGeneratorProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 9375), IdBasedLazy.a(injectorLike, 9351), IdBasedLazy.a(injectorLike, 9386), FullscreenVideoPlayerLauncher.m11255b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    private void m26736a(SearchResultsLogger searchResultsLogger, PandoraPhotoCollageAdapterProvider pandoraPhotoCollageAdapterProvider, String str, GraphSearchFetchPhotosFutureGeneratorProvider graphSearchFetchPhotosFutureGeneratorProvider, Lazy<PandoraEventBus> lazy, Lazy<MediaGalleryLauncher> lazy2, Lazy<PandoraRendererMixedMediaGridConfiguration> lazy3, FullscreenVideoPlayerLauncher fullscreenVideoPlayerLauncher, GatekeeperStore gatekeeperStore) {
        this.f23077h = searchResultsLogger;
        this.f23078i = pandoraPhotoCollageAdapterProvider;
        this.al = str;
        this.am = graphSearchFetchPhotosFutureGeneratorProvider;
        this.an = lazy;
        this.ao = lazy2;
        this.ap = lazy3;
        this.aq = fullscreenVideoPlayerLauncher;
        this.ar = gatekeeperStore;
    }

    protected final Class<?> mo1294e() {
        return SearchResultsPandoraPhotoFragment.class;
    }

    public final void mo1290c(Bundle bundle) {
        super.mo1290c(bundle);
        Class cls = SearchResultsPandoraPhotoFragment.class;
        m26737a(this, getContext());
    }

    public final View m26740a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 154009595);
        CustomFrameLayout customFrameLayout = new CustomFrameLayout(getContext());
        customFrameLayout.setBackgroundDrawable(new ColorDrawable(jW_().getColor(2131363277)));
        PandoraFeedListView pandoraFeedListView = new PandoraFeedListView(viewGroup.getContext());
        pandoraFeedListView.setId(2131558616);
        this.au = this.f23078i.m21647a(this.am.m26731a(this.ar.a(429, false) ? as : Functions.identity(), this.aB), Boolean.valueOf(false), Boolean.valueOf(false), (PandoraRendererConfiguration) this.ap.get());
        this.au.m21428a(this.al, new GraphSearchPandoraInstanceId(ax().mo1212b(), ax().m27100o().b), "LoadScreenImagesSearch", false, false, false);
        this.au.m21640a(new C24762(this));
        this.au.registerDataSetObserver(this.az);
        PandoraAdapter pandoraAdapter = new PandoraAdapter(this.au);
        pandoraFeedListView.setAdapter(pandoraAdapter);
        pandoraFeedListView.f17748a = pandoraAdapter;
        customFrameLayout.addView(pandoraFeedListView, new LayoutParams(-1, -1));
        this.av = (LinearLayout) layoutInflater.inflate(2130906971, null);
        this.av.setVisibility(8);
        FbTextView fbTextView = (FbTextView) FindViewUtil.b(this.av, 2131563455);
        ((ImageView) FindViewUtil.b(this.av, 2131567264)).setImageResource(2130839468);
        fbTextView.setText(jW_().getString(2131237653));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        customFrameLayout.addView(this.av, layoutParams);
        this.aw = new PandoraBennyLoadingSpinnerView(getContext());
        layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        customFrameLayout.addView(this.aw, layoutParams);
        LogUtils.f(849759120, a);
        return customFrameLayout;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2014552693);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 771741806, a);
    }

    public final void mo1282G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1037215350);
        super.mo1282G();
        ((PandoraEventBus) this.an.get()).a(this.aA);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1644820661, a);
    }

    public final void mo1283H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 647316577);
        super.mo1283H();
        ((PandoraEventBus) this.an.get()).b(this.aA);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2083919627, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1958841340);
        super.mY_();
        this.au.unregisterDataSetObserver(this.az);
        this.au.m21437i();
        this.ay = false;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 234192685, a);
    }

    public final String am_() {
        return "graph_search_results_page_pandora_photo";
    }

    protected final void aq() {
        PandoraBasicFeedAdapter pandoraBasicFeedAdapter = this.au;
        pandoraBasicFeedAdapter.f17464p = true;
        pandoraBasicFeedAdapter.mo1054d();
    }

    protected final boolean ar() {
        return this.ay;
    }

    public final void mo1190a(OnResultClickListener onResultClickListener) {
        this.at = onResultClickListener;
    }
}
