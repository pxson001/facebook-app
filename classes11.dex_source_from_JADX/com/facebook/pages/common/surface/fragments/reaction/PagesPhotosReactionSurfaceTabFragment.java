package com.facebook.pages.common.surface.fragments.reaction;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.CategoryInputCategoryName;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLPhotosByCategoryEntryPoint;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbum.Builder;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.profile.TimelinePhotoEditMode;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.localcontent.photos.PhotoCategoryFetchPhotosFutureGenerator;
import com.facebook.localcontent.photos.PhotosByCategoryPandoraInstanceId;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.photos.PageMixedReactionPandoraAdapter;
import com.facebook.pages.common.photos.PageMixedReactionPandoraAdapter.PandoraHeaderViewHolder;
import com.facebook.pages.common.photos.PageMixedReactionPandoraAdapter.PandoraRowSimpleViewHolder;
import com.facebook.pages.common.recyclerview.PageBetterLinearLayoutManagerWithBindHack;
import com.facebook.pages.common.recyclerview.SelectiveVerticalSpaceDecorator;
import com.facebook.pages.common.surface.fragments.common.PagesFragmentWithUuid;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.fb4a.abtest.qe.ExperimentsForPagesFb4aAbTestModule;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albumcreator.AlbumCreatorSourceType;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumCreatedEventSubscriber;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumDeletedEventSubscriber;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumTitleRenamedEventSubscriber;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.intent.PhotosViewIntentBuilder;
import com.facebook.photos.intent.PhotosViewIntentProvider;
import com.facebook.photos.pandora.common.events.PandoraEventBus;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEvent;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEventSubscriber;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererResult;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererGridConfiguration;
import com.facebook.photos.pandora.ui.PandoraPhotoCollageAdapter;
import com.facebook.photos.pandora.ui.PandoraPhotoCollageAdapter.PhotoCollageLoadingListener;
import com.facebook.photos.pandora.ui.PandoraPhotoCollageAdapterProvider;
import com.facebook.photos.photoset.launcher.PhotoSetConsumptionGalleryPhotoLauncher;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.ReactionSessionListener;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.event.ReactionEventBus;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPageViewPhotosOfPageAlbumEvent;
import com.facebook.reaction.ui.fragment.BaseReactionFragment;
import com.facebook.reaction.ui.recyclerview.AbstractReactionRecyclerViewAdapter;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapter;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: results_fragment */
public class PagesPhotosReactionSurfaceTabFragment extends BaseReactionFragment implements AnalyticsFragment, PagesFragmentWithUuid, PagesSurfaceTabFragment, ReactionSessionListener, ReactionCardContainer {
    public static final Surface f2452a = Surface.ANDROID_PAGE_PHOTOS_TAB;
    @Inject
    Lazy<PhotosViewIntentBuilder> aA;
    @Inject
    Lazy<SecureContextHelper> aB;
    @Inject
    Lazy<AlbumCreatorIntentBuilder> aC;
    @Inject
    Lazy<PagesAnalytics> aD;
    private PagesSurfaceFragment aE;
    private int aF = 0;
    private int aG;
    private boolean aH = true;
    public PandoraPhotoCollageAdapter aI;
    private ReactionMixedRecyclerViewAdapter aJ;
    public PageMixedReactionPandoraAdapter aK;
    private View aL;
    private final PhotoCollageDataSetObserver aM = new PhotoCollageDataSetObserver(this);
    private final LaunchPhotoGalleryEventSubscriber aN = new LaunchPhotoGalleryEventSubscriber(this);
    private final ReactionPageViewPhotosOfPageAlbumEventSubscriber aO = new ReactionPageViewPhotosOfPageAlbumEventSubscriber(this);
    private final ReactionPageCreatePhotoAlbumEventSubscriber aP = new ReactionPageCreatePhotoAlbumEventSubscriber(this);
    private final AlbumCreatedEventSubscriber aQ = new C03181(this);
    private final AlbumDeletedEventSubscriber aR = new C03192(this);
    private final AlbumTitleRenamedEventSubscriber aS = new C03203(this);
    public String aT;
    public ParcelUuid aU;
    @Inject
    public PhotoSetConsumptionGalleryPhotoLauncher am;
    @Inject
    PandoraPhotoCollageAdapterProvider an;
    @Inject
    PandoraRendererGridConfiguration ao;
    @Inject
    PhotoCategoryFetchPhotosFutureGenerator ap;
    @Inject
    PandoraEventBus aq;
    @Inject
    ReactionEventBus ar;
    @Inject
    ViewerContext as;
    @Inject
    ViewerContextManager at;
    @Inject
    AlbumsEventBus au;
    @Inject
    QeAccessor av;
    @Inject
    Lazy<ReactionSessionHelper> aw;
    @Inject
    Lazy<ReactionSessionManager> ax;
    @Inject
    Lazy<FbErrorReporter> ay;
    @Inject
    Lazy<AdminedPagesRamCache> az;

    /* compiled from: results_fragment */
    class C03181 extends AlbumCreatedEventSubscriber {
        final /* synthetic */ PagesPhotosReactionSurfaceTabFragment f2442a;

        C03181(PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment) {
            this.f2442a = pagesPhotosReactionSurfaceTabFragment;
        }

        public final void m3394b(FbEvent fbEvent) {
            this.f2442a.m3425j();
        }
    }

    /* compiled from: results_fragment */
    class C03192 extends AlbumDeletedEventSubscriber {
        final /* synthetic */ PagesPhotosReactionSurfaceTabFragment f2443a;

        C03192(PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment) {
            this.f2443a = pagesPhotosReactionSurfaceTabFragment;
        }

        public final void m3395b(FbEvent fbEvent) {
            this.f2443a.m3425j();
        }
    }

    /* compiled from: results_fragment */
    class C03203 extends AlbumTitleRenamedEventSubscriber {
        final /* synthetic */ PagesPhotosReactionSurfaceTabFragment f2444a;

        C03203(PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment) {
            this.f2444a = pagesPhotosReactionSurfaceTabFragment;
        }

        public final void m3396b(FbEvent fbEvent) {
            this.f2444a.m3425j();
        }
    }

    /* compiled from: results_fragment */
    class C03225 extends OnScrollListener {
        final /* synthetic */ PagesPhotosReactionSurfaceTabFragment f2446a;

        C03225(PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment) {
            this.f2446a = pagesPhotosReactionSurfaceTabFragment;
        }

        public final void m3398a(RecyclerView recyclerView, int i) {
        }

        public final void m3399a(RecyclerView recyclerView, int i, int i2) {
            if (this.f2446a.aK != null) {
                LayoutManagerWithKeepAttachedHack layoutManagerWithKeepAttachedHack = (LayoutManagerWithKeepAttachedHack) recyclerView.getLayoutManager();
                if (layoutManagerWithKeepAttachedHack.n() + 3 > layoutManagerWithKeepAttachedHack.D()) {
                    this.f2446a.aK.f1686e.d();
                }
            }
        }
    }

    /* compiled from: results_fragment */
    class C03236 implements PhotoCollageLoadingListener {
        final /* synthetic */ PagesPhotosReactionSurfaceTabFragment f2447a;

        C03236(PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment) {
            this.f2447a = pagesPhotosReactionSurfaceTabFragment;
        }

        public final void m3400a() {
            if (this.f2447a.aK != null) {
                this.f2447a.aK.notifyDataSetChanged();
            }
        }

        public final void m3401a(PandoraRendererResult pandoraRendererResult) {
        }
    }

    /* compiled from: results_fragment */
    class LaunchPhotoGalleryEventSubscriber extends LaunchConsumptionGalleryEventSubscriber {
        final /* synthetic */ PagesPhotosReactionSurfaceTabFragment f2448a;

        public LaunchPhotoGalleryEventSubscriber(PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment) {
            this.f2448a = pagesPhotosReactionSurfaceTabFragment;
        }

        public final void m3402b(FbEvent fbEvent) {
            LaunchConsumptionGalleryEvent launchConsumptionGalleryEvent = (LaunchConsumptionGalleryEvent) fbEvent;
            PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment = this.f2448a;
            CharSequence charSequence = launchConsumptionGalleryEvent.a;
            Uri uri = launchConsumptionGalleryEvent.b;
            if (!(StringUtil.a(charSequence) || pagesPhotosReactionSurfaceTabFragment.aI == null)) {
                pagesPhotosReactionSurfaceTabFragment.am.a(pagesPhotosReactionSurfaceTabFragment.ao(), charSequence, uri, pagesPhotosReactionSurfaceTabFragment.aI.i.d(), FullscreenGallerySource.PAGE_PHOTOS_TAB, false);
            }
            ((PagesAnalytics) this.f2448a.aD.get()).a(Long.parseLong(this.f2448a.aT), "pages_photos_tab", false);
        }
    }

    /* compiled from: results_fragment */
    class PhotoCollageDataSetObserver extends DataSetObserver {
        final /* synthetic */ PagesPhotosReactionSurfaceTabFragment f2449a;

        public PhotoCollageDataSetObserver(PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment) {
            this.f2449a = pagesPhotosReactionSurfaceTabFragment;
        }

        public void onChanged() {
            if (this.f2449a.aK != null) {
                this.f2449a.aK.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: results_fragment */
    class ReactionPageCreatePhotoAlbumEventSubscriber extends com.facebook.reaction.event.ReactionUiEvents.ReactionPageCreatePhotoAlbumEventSubscriber {
        final /* synthetic */ PagesPhotosReactionSurfaceTabFragment f2450a;

        public ReactionPageCreatePhotoAlbumEventSubscriber(PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment) {
            this.f2450a = pagesPhotosReactionSurfaceTabFragment;
        }

        public final void m3403b(FbEvent fbEvent) {
            this.f2450a.m3410e();
        }
    }

    /* compiled from: results_fragment */
    class ReactionPageViewPhotosOfPageAlbumEventSubscriber extends com.facebook.reaction.event.ReactionUiEvents.ReactionPageViewPhotosOfPageAlbumEventSubscriber {
        final /* synthetic */ PagesPhotosReactionSurfaceTabFragment f2451a;

        public ReactionPageViewPhotosOfPageAlbumEventSubscriber(PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment) {
            this.f2451a = pagesPhotosReactionSurfaceTabFragment;
        }

        public final void m3404b(FbEvent fbEvent) {
            ReactionPageViewPhotosOfPageAlbumEvent reactionPageViewPhotosOfPageAlbumEvent = (ReactionPageViewPhotosOfPageAlbumEvent) fbEvent;
            PagesPhotosReactionSurfaceTabFragment.m3407a(this.f2451a, reactionPageViewPhotosOfPageAlbumEvent.b, reactionPageViewPhotosOfPageAlbumEvent.c);
        }
    }

    public static void m3409a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PagesPhotosReactionSurfaceTabFragment) obj).m3408a(PhotoSetConsumptionGalleryPhotoLauncher.a(fbInjector), (PandoraPhotoCollageAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PandoraPhotoCollageAdapterProvider.class), PandoraRendererGridConfiguration.a(fbInjector), PhotoCategoryFetchPhotosFutureGenerator.a(fbInjector), PandoraEventBus.a(fbInjector), ReactionEventBus.a(fbInjector), ViewerContextMethodAutoProvider.a(fbInjector), ViewerContextManagerProvider.a(fbInjector), AlbumsEventBus.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 9835), IdBasedSingletonScopeProvider.b(fbInjector, 9836), IdBasedSingletonScopeProvider.b(fbInjector, 494), IdBasedSingletonScopeProvider.b(fbInjector, 2928), IdBasedLazy.a(fbInjector, 9340), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedLazy.a(fbInjector, 9243), IdBasedSingletonScopeProvider.b(fbInjector, 8930));
    }

    private void m3408a(PhotoSetConsumptionGalleryPhotoLauncher photoSetConsumptionGalleryPhotoLauncher, PandoraPhotoCollageAdapterProvider pandoraPhotoCollageAdapterProvider, PandoraRendererGridConfiguration pandoraRendererGridConfiguration, PhotoCategoryFetchPhotosFutureGenerator photoCategoryFetchPhotosFutureGenerator, PandoraEventBus pandoraEventBus, ReactionEventBus reactionEventBus, ViewerContext viewerContext, ViewerContextManager viewerContextManager, AlbumsEventBus albumsEventBus, QeAccessor qeAccessor, Lazy<ReactionSessionHelper> lazy, Lazy<ReactionSessionManager> lazy2, Lazy<FbErrorReporter> lazy3, Lazy<AdminedPagesRamCache> lazy4, Lazy<PhotosViewIntentBuilder> lazy5, Lazy<SecureContextHelper> lazy6, Lazy<AlbumCreatorIntentBuilder> lazy7, Lazy<PagesAnalytics> lazy8) {
        this.am = photoSetConsumptionGalleryPhotoLauncher;
        this.an = pandoraPhotoCollageAdapterProvider;
        this.ao = pandoraRendererGridConfiguration;
        this.ap = photoCategoryFetchPhotosFutureGenerator;
        this.aq = pandoraEventBus;
        this.ar = reactionEventBus;
        this.as = viewerContext;
        this.at = viewerContextManager;
        this.au = albumsEventBus;
        this.av = qeAccessor;
        this.aw = lazy;
        this.ax = lazy2;
        this.ay = lazy3;
        this.az = lazy4;
        this.aA = lazy5;
        this.aB = lazy6;
        this.aC = lazy7;
        this.aD = lazy8;
    }

    public static PagesPhotosReactionSurfaceTabFragment m3405a(long j, ParcelUuid parcelUuid) {
        Preconditions.checkNotNull(parcelUuid);
        Bundle bundle = new Bundle();
        PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment = new PagesPhotosReactionSurfaceTabFragment();
        bundle.putLong("com.facebook.katana.profile.id", j);
        bundle.putParcelable("page_fragment_uuid", parcelUuid);
        pagesPhotosReactionSurfaceTabFragment.g(bundle);
        return pagesPhotosReactionSurfaceTabFragment;
    }

    public final void m3423c(Bundle bundle) {
        Class cls = PagesPhotosReactionSurfaceTabFragment.class;
        m3409a((Object) this, getContext());
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            m3411n(bundle2);
        }
        super.c(bundle);
        this.au.a(this.aQ);
        this.au.a(this.aR);
        this.au.a(this.aS);
    }

    private void m3411n(Bundle bundle) {
        long j = bundle.getLong("com.facebook.katana.profile.id", -1);
        if (j == -1) {
            throw new IllegalArgumentException("Invalid page id " + j);
        }
        this.aT = String.valueOf(j);
        ParcelUuid parcelUuid = (ParcelUuid) bundle.getParcelable("page_fragment_uuid");
        if (parcelUuid == null) {
            throw new IllegalArgumentException("Invalid fragment uuid");
        }
        this.aU = parcelUuid;
    }

    public final void m3419a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.aE = pagesSurfaceFragment;
    }

    public final void D_(int i) {
        this.aG = i;
        PagesScrollUtils.a(this.aq, this.aG);
    }

    protected final void m3420a(BetterRecyclerView betterRecyclerView, AbstractReactionRecyclerViewAdapter abstractReactionRecyclerViewAdapter, Context context) {
        Preconditions.checkNotNull(abstractReactionRecyclerViewAdapter);
        betterRecyclerView.a(new SelectiveVerticalSpaceDecorator(this, context.getResources().getDimensionPixelSize(2131430943), new ColorDrawable(context.getResources().getColor(2131363277))) {
            final /* synthetic */ PagesPhotosReactionSurfaceTabFragment f2445a;

            protected final boolean mo56a(View view, RecyclerView recyclerView) {
                ViewHolder a = recyclerView.a(view);
                return (a instanceof PandoraRowSimpleViewHolder) || (a instanceof PandoraHeaderViewHolder);
            }
        });
        if (this.aI == null) {
            this.aI = this.an.a(this.ap, Boolean.valueOf(false), Boolean.valueOf(false), this.ao);
            this.aI.a(this.aT, new PhotosByCategoryPandoraInstanceId(this.aT, 0, CategoryInputCategoryName.ALL, GraphQLPhotosByCategoryEntryPoint.UNSET_OR_UNRECOGNIZED_ENUM_VALUE), "PagesPhotosReactionSurfaceTabFragment", true, true, false);
        }
        this.aJ = (ReactionMixedRecyclerViewAdapter) abstractReactionRecyclerViewAdapter;
        Preconditions.checkNotNull(this.aJ);
        Preconditions.checkNotNull(this.aI);
        this.aL = new View(getContext());
        E_(this.aF);
        ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter = this.aJ;
        PandoraPhotoCollageAdapter pandoraPhotoCollageAdapter = this.aI;
        View view = this.aL;
        if (!(view == null || view.getParent() == null)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.aK = new PageMixedReactionPandoraAdapter(betterRecyclerView, reactionMixedRecyclerViewAdapter, pandoraPhotoCollageAdapter, view);
        betterRecyclerView.a(new C03225(this));
        betterRecyclerView.setAdapter(this.aK);
    }

    protected final BetterLinearLayoutManager m3415a(BetterRecyclerView betterRecyclerView) {
        if (this.av.a(Liveness.Live, ExperimentsForPagesFb4aAbTestModule.b, false)) {
            return new PageBetterLinearLayoutManagerWithBindHack(betterRecyclerView);
        }
        return super.a(betterRecyclerView);
    }

    protected final AbstractReactionRecyclerViewAdapter m3421b(Context context) {
        if (this.aJ == null) {
            return super.b(context);
        }
        return this.aJ;
    }

    public final void m3417a(View view, @Nullable Bundle bundle) {
        view.setBackgroundResource(0);
        this.aq.setVerticalScrollBarEnabled(false);
        E_(this.aF);
        D_(this.aG);
        this.aI.registerDataSetObserver(this.aM);
        this.aI.a(new C03236(this));
    }

    public final void m3412G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 637962488);
        super.G();
        this.ar.a(this.aP);
        this.ar.a(this.aO);
        this.aq.a(this.aN);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2059591870, a);
    }

    public final void m3413H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2146370568);
        this.ar.b(this.aP);
        this.ar.b(this.aO);
        this.aq.b(this.aN);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2069779301, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -667054255);
        this.aI.unregisterDataSetObserver(this.aM);
        this.aI.a(null);
        this.aL = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1646167012, a);
    }

    public final void m3414I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1657074712);
        this.au.b(this.aQ);
        this.au.b(this.aR);
        this.au.b(this.aS);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -352444499, a);
    }

    public final void E_(int i) {
        this.aF = i;
        if (this.aL != null) {
            this.aL.setLayoutParams(new LayoutParams(-1, this.aF));
        }
    }

    public final void m3418a(C05581 c05581) {
    }

    public final String am_() {
        return "page_reaction_fragment";
    }

    protected final ReactionSession ax() {
        ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
        reactionQueryParams.t = Long.valueOf(Long.parseLong(this.aT));
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.b = 5;
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.o = RequestPriority.INTERACTIVE;
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.y = f2452a.toString();
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.w = am_();
        ReactionSession a = ((ReactionSessionHelper) this.aw.get()).a(f2452a, reactionQueryParams);
        a.a(this);
        return a;
    }

    protected final void m3416a(RecyclerView recyclerView) {
        if (this.aE != null && D()) {
            this.aE.m5039a((ViewGroup) recyclerView, aK());
        }
    }

    public final void m3425j() {
        ((ReactionSessionManager) this.ax.get()).g(getSessionId());
        this.aH = true;
        this.aI.c();
        az();
        aA();
        this.at.b(this.av);
    }

    public final boolean aD() {
        return false;
    }

    public final boolean kq_() {
        return this.aH;
    }

    public final void kQ_() {
        super.kQ_();
        this.aH = false;
        if (this.aK != null) {
            this.aK.notifyDataSetChanged();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.at.a(configuration);
    }

    public final void kp_() {
        super.kp_();
        this.aH = false;
    }

    protected final void m3422b(String str) {
    }

    public final ParcelUuid mo55h() {
        return this.aU;
    }

    private void m3410e() {
        ViewerContext ar = ar();
        if (ar != null) {
            ((SecureContextHelper) this.aB.get()).a(((AlbumCreatorIntentBuilder) this.aC.get()).a(AlbumCreatorSourceType.ALBUMSTAB, ar), getContext());
            return;
        }
        ((AbstractFbErrorReporter) this.ay.get()).b("getCreateAlbumIntent", "not page context");
    }

    public static void m3407a(PagesPhotosReactionSurfaceTabFragment pagesPhotosReactionSurfaceTabFragment, String str, String str2) {
        String str3 = null;
        boolean z = false;
        Context ao = pagesPhotosReactionSurfaceTabFragment.ao();
        Builder builder = new Builder();
        builder.o = str2;
        GraphQLAlbum a = builder.a();
        Intent a2 = ((PhotosViewIntentProvider) pagesPhotosReactionSurfaceTabFragment.aA.get()).a(ao, a.u());
        FlatBufferModelHelper.a(a2, "extra_album_selected", a);
        a2.putExtra("extra_photo_tab_mode_params", new TimelinePhotoTabModeParams(TimelinePhotoEditMode.VIEWING_MODE, Long.parseLong(pagesPhotosReactionSurfaceTabFragment.as.mUserId)));
        a2.putExtra("is_page", true);
        a2.putExtra("owner_id", Long.parseLong(str));
        a2.putExtra("pick_hc_pic", false);
        a2.putExtra("pick_pic_lite", false);
        a2.putExtra("disable_adding_photos_to_albums", false);
        AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) ((AdminedPagesRamCache) pagesPhotosReactionSurfaceTabFragment.az.get()).b(str);
        if (adminedPagesPrefetchNode == null || !adminedPagesPrefetchNode.b().isPresent()) {
            ((SecureContextHelper) pagesPhotosReactionSurfaceTabFragment.aB.get()).a(a2, ao);
            return;
        }
        String a3;
        ArrayList arrayList = new ArrayList();
        ImmutableList g = adminedPagesPrefetchNode.a().g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            arrayList.add((String) g.get(i));
        }
        if (adminedPagesPrefetchNode.a().km_() != null) {
            a3 = adminedPagesPrefetchNode.a().km_().a();
        } else {
            a3 = null;
        }
        if (adminedPagesPrefetchNode.a().d() != null) {
            z = true;
        }
        if (z) {
            str3 = adminedPagesPrefetchNode.a().d();
        }
        ComposerTargetData.Builder builder2 = new ComposerTargetData.Builder(Long.parseLong(str), TargetType.PAGE);
        builder2.f = true;
        builder2 = builder2;
        builder2.c = str3;
        builder2 = builder2;
        builder2.d = a3;
        ComposerTargetData a4 = builder2.a();
        ViewerContext ar = pagesPhotosReactionSurfaceTabFragment.ar();
        if (ar != null) {
            a2.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", ar);
            if (!arrayList.isEmpty()) {
                a2.putStringArrayListExtra("extra_pages_admin_permissions", arrayList);
            }
            a2.putExtra("extra_composer_target_data", a4);
        }
        ((SecureContextHelper) pagesPhotosReactionSurfaceTabFragment.aB.get()).a(a2, ao);
    }

    @Nullable
    private ViewerContext ar() {
        if (this.as.mIsPageContext) {
            return this.as;
        }
        Object obj;
        ViewerContext b = this.at.b();
        if (b == null || !b.mIsPageContext) {
            obj = null;
        } else {
            obj = 1;
        }
        return obj == null ? null : b;
    }
}
