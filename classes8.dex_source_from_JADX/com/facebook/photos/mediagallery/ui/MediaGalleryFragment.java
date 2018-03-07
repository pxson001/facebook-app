package com.facebook.photos.mediagallery.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.hardware.FbViewConfigurationCompat;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.feed.analytics.vpvlogging.VpvEventHelper;
import com.facebook.feed.rows.photosfeed.PhotosFeedFragment;
import com.facebook.feed.rows.photosfeed.PhotosFeedFragment.PhotosFeedMediaGalleryScrollListener;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.MediaLogger;
import com.facebook.photos.base.analytics.constants.ConsumptionLoggingConstants.ContentViewingSurface;
import com.facebook.photos.base.analytics.constants.ConsumptionLoggingConstants.UserAction;
import com.facebook.photos.base.util.CachedDrawableProvider;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.ExplicitPlaceModel;
import com.facebook.photos.dialog.PhotoAnimationContentFragment;
import com.facebook.photos.dialog.PhotoAnimationContentFragment.EmptySetListener;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment.2;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment.3;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment.State;
import com.facebook.photos.dialog.util.PhotosDialogPerfUtil;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.galleryutil.MediaGalleryDeepLinkViewGroup;
import com.facebook.photos.galleryutil.PhotoViewController;
import com.facebook.photos.galleryutil.STATICDI_MULTIBIND_PROVIDER;
import com.facebook.photos.galleryutil.VisibilityAnimator;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.MediaGalleryFragmentVisibilityChangeEvent;
import com.facebook.photos.mediafetcher.MediaFetcherFactory;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher.MediaFetcherListener;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher.Status;
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.photos.mediagallery.ui.MediaGalleryDataSource.Subscriber;
import com.facebook.photos.mediagallery.ui.MediaGalleryVideoPageFragment.C02902;
import com.facebook.photos.mediagallery.ui.tagging.DefaultSuggestionController;
import com.facebook.photos.mediagallery.ui.tagging.TaggingStateController;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryChromeController;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryFooterView;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryVideoChromeController;
import com.facebook.photos.mediagallery.util.MediaMetadataParcelUtil;
import com.facebook.photos.mediagallery.util.WarmupImageHelper;
import com.facebook.photos.mediagallery.util.WarmupImageHelperProvider;
import com.facebook.photos.tagging.shared.FamilyTagTypeaheadUtil;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration.Builder;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.launcher.PlacePickerLauncher;
import com.facebook.places.checkin.launcher.PlacePickerResultHandler;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.intent.TimelineIntentFactory;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.animations.ViewAnimatorFactory;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoResolution;
import com.facebook.widget.images.zoomableimageview.SimpleZoomableImageViewListener;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: snap_low_range */
public class MediaGalleryFragment extends PhotoAnimationContentFragment implements AnalyticsFragment {
    public static final String aE = MediaGalleryFragment.class.getSimpleName();
    @Inject
    Lazy<FamilyTagTypeaheadUtil> f2390a;
    @Inject
    public FunnelLoggerImpl aA;
    @Inject
    LocalStatsLoggerImpl aB;
    @BackgroundExecutorService
    @Inject
    ListeningExecutorService aC;
    @Inject
    @ForUiThread
    Executor aD;
    public MediaGalleryLauncherParams aF;
    @Nullable
    private CallerContext aG;
    public ViewGroup aH;
    private ViewStub aI;
    private View aJ;
    private ViewStub aK;
    public MediaGalleryFooterView aL;
    public ViewPager aM;
    public MediaGalleryPagerAdapter aN;
    public MediaFetcher aO;
    private long aP;
    public Optional<ImmutableList<MediaMetadata>> aQ = Absent.INSTANCE;
    private Optional<WarmupImageHelper> aR;
    public Optional<String> aS = Absent.INSTANCE;
    public Optional<EmptySetListener> aT = Absent.INSTANCE;
    private VisibilityAnimator aU;
    public 3 aV;
    private ImmutableList<MediaMetadata> aW;
    private boolean aX;
    private final MediaListener aY = new MediaListener(this);
    public final MediaPaginator aZ = new MediaPaginator(this);
    @Inject
    MediaGalleryChromeController al;
    @Inject
    MediaGalleryVideoChromeController am;
    @Inject
    TaggingStateController an;
    @Inject
    Lazy<DefaultSuggestionController> ao;
    @Inject
    Lazy<MediaMetadataParcelUtil> ap;
    @Inject
    Clock aq;
    @Inject
    VpvEventHelper ar;
    @Inject
    FbViewConfigurationCompat as;
    @Inject
    Set<GalleryDeepLinkBinder> at;
    @Inject
    ConsumptionPhotoEventBus au;
    @Inject
    public Provider<SecureContextHelper> av;
    @Inject
    Lazy<PlacePickerLauncher> aw;
    @Inject
    public Lazy<PlacePickerResultHandler> ax;
    @Inject
    public TimelineIntentFactory ay;
    @Inject
    QeAccessor az;
    @Inject
    Lazy<MediaFetcherFactory> f2391b;
    public boolean ba;
    private boolean bb;
    private boolean bc;
    public boolean bd;
    private final OnClickListener be = new C02877(this);
    @Inject
    MediaGalleryDataSource f2392c;
    @Inject
    AnalyticsTagger f2393d;
    @Inject
    Lazy<NavigationLogger> f2394e;
    @Inject
    WarmupImageHelperProvider f2395f;
    @Inject
    PhotosDialogPerfUtil f2396g;
    @Inject
    MediaLogger f2397h;
    @Inject
    ViewHelperViewAnimatorFactory f2398i;

    /* compiled from: snap_low_range */
    class C02822 implements FutureCallback<View> {
        final /* synthetic */ MediaGalleryFragment f2379a;

        C02822(MediaGalleryFragment mediaGalleryFragment) {
            this.f2379a = mediaGalleryFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            View view = (View) obj;
            if (!this.f2379a.ba) {
                MediaGalleryFragment mediaGalleryFragment = this.f2379a;
                ViewGroup viewGroup = (ViewGroup) view;
                ViewGroup viewGroup2 = this.f2379a.aH;
                int i = 0;
                View[] viewArr = new View[viewGroup.getChildCount()];
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    viewArr[i2] = viewGroup.getChildAt(i2);
                }
                viewGroup.removeAllViews();
                while (i < viewArr.length) {
                    viewGroup2.addView(viewArr[i]);
                    i++;
                }
                MediaGalleryFragment.m2511b(this.f2379a, this.f2379a.aH);
                MediaGalleryFragment.av(this.f2379a);
                if (this.f2379a.aV != null) {
                    3 3 = this.f2379a.aV;
                    3.a.aW = true;
                    if (3.a.aV == State.ANIMATE_WAIT) {
                        PhotoAnimationDialogFragment.aB(3.a);
                    }
                }
            }
        }

        public void onFailure(Throwable th) {
            BLog.b(MediaGalleryFragment.aE, "error inflating media gallery", th);
        }
    }

    /* compiled from: snap_low_range */
    class C02833 implements Runnable {
        final /* synthetic */ MediaGalleryFragment f2380a;

        C02833(MediaGalleryFragment mediaGalleryFragment) {
            this.f2380a = mediaGalleryFragment;
        }

        public void run() {
            if (this.f2380a.aV != null) {
                this.f2380a.aV.a(false);
            }
        }
    }

    /* compiled from: snap_low_range */
    class C02844 implements Runnable {
        final /* synthetic */ MediaGalleryFragment f2381a;

        C02844(MediaGalleryFragment mediaGalleryFragment) {
            this.f2381a = mediaGalleryFragment;
        }

        public void run() {
            ((FamilyTagTypeaheadUtil) this.f2381a.f2390a.get()).b();
            ((DefaultSuggestionController) this.f2381a.ao.get()).f2447e = this.f2381a.aF.z;
            ((DefaultSuggestionController) this.f2381a.ao.get()).m2571b();
            if (MediaGalleryFragment.aD(this.f2381a) && this.f2381a.aM.k < this.f2381a.aN.b()) {
                MediaGalleryVideoChromeController mediaGalleryVideoChromeController = this.f2381a.am;
                String c = MediaGalleryFragment.m2513c(this.f2381a.aN.m2544e(this.f2381a.aM.k));
                for (C02902 c02902 : mediaGalleryVideoChromeController.f2835c.keySet()) {
                    if (c02902 != null) {
                        MediaGalleryVideoPageFragment.as(c02902.f2420a);
                    }
                }
            }
        }
    }

    /* compiled from: snap_low_range */
    public class C02855 extends SimpleZoomableImageViewListener {
        final /* synthetic */ MediaGalleryFragment f2382a;

        public C02855(MediaGalleryFragment mediaGalleryFragment) {
            this.f2382a = mediaGalleryFragment;
        }

        public final void m2492a(PointF pointF, PointF pointF2) {
            super.a(pointF, pointF2);
            if (this.f2382a.aL != null && this.f2382a.aL.m2788b() && !this.f2382a.an.f2565c) {
                this.f2382a.aA.b(FunnelRegistry.z, "single_tap_on_photo");
                MediaGalleryFragment.aE(this.f2382a).b();
            }
        }

        public final void m2494b(PointF pointF, PointF pointF2) {
            if (this.f2382a.aL != null && !this.f2382a.an.f2565c) {
                this.f2382a.aA.b(FunnelRegistry.z, "long_press_on_photo");
                this.f2382a.aL.m2784a(UserAction.LONGPRESS, (Optional) Absent.INSTANCE);
            }
        }

        public final void m2493b() {
            this.f2382a.aA.b(FunnelRegistry.z, "double_tap_on_photo");
        }

        public final void m2495f() {
            this.f2382a.aA.b(FunnelRegistry.z, "drag_to_scale_photo");
        }
    }

    /* compiled from: snap_low_range */
    public class C02866 {
        public final /* synthetic */ MediaGalleryFragment f2383a;

        public C02866(MediaGalleryFragment mediaGalleryFragment) {
            this.f2383a = mediaGalleryFragment;
        }

        public final void m2497a(String str, int i, int i2, CharSequence charSequence, CharSequence charSequence2) {
            if (MediaGalleryFragment.m2509a(this.f2383a, str)) {
                this.f2383a.aL.m2782a(i, i2, charSequence, charSequence2);
            }
        }

        public final void m2496a() {
            MediaGalleryFragment.aE(this.f2383a).d();
        }

        public final void m2498a(boolean z, VideoResolution videoResolution) {
            this.f2383a.aL.m2786a(z, videoResolution);
        }
    }

    /* compiled from: snap_low_range */
    class C02877 implements OnClickListener {
        final /* synthetic */ MediaGalleryFragment f2384a;

        C02877(MediaGalleryFragment mediaGalleryFragment) {
            this.f2384a = mediaGalleryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 389400777);
            MediaMetadata e = this.f2384a.aN.m2544e(this.f2384a.aM.k);
            PlacePickerLauncher placePickerLauncher;
            String e2;
            ExplicitPlaceModel A;
            MediaGalleryFragment mediaGalleryFragment;
            Builder a2;
            if (e.p()) {
                placePickerLauncher = (PlacePickerLauncher) this.f2384a.aw.get();
                e2 = this.f2384a.e();
                A = e.A();
                mediaGalleryFragment = this.f2384a;
                a2 = PlacePickerLauncher.a(SearchType.PHOTO, "edit_photo_location", A);
                a2.l = e2;
                ((SecureContextHelper) placePickerLauncher.a.get()).a(CheckinIntentCreator.a(mediaGalleryFragment.getContext(), a2.a()), 5002, mediaGalleryFragment);
            } else {
                placePickerLauncher = (PlacePickerLauncher) this.f2384a.aw.get();
                e2 = this.f2384a.e();
                A = e.A();
                mediaGalleryFragment = this.f2384a;
                a2 = PlacePickerLauncher.a(SearchType.PHOTO, "suggest_photo_location", A);
                a2.l = e2;
                ((SecureContextHelper) placePickerLauncher.a.get()).a(CheckinIntentCreator.a(mediaGalleryFragment.getContext(), a2.a()), 5002, mediaGalleryFragment);
            }
            LogUtils.a(562349405, a);
        }
    }

    /* compiled from: snap_low_range */
    class MediaListener implements MediaFetcherListener<MediaMetadata> {
        final /* synthetic */ MediaGalleryFragment f2385a;

        public MediaListener(MediaGalleryFragment mediaGalleryFragment) {
            this.f2385a = mediaGalleryFragment;
        }

        public final void m2500a(ImmutableList<MediaMetadata> immutableList) {
            Object obj = this.f2385a.aN.b() == 0 ? 1 : null;
            MediaGalleryDataSource mediaGalleryDataSource = this.f2385a.f2392c;
            mediaGalleryDataSource.f2364c.a();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                MediaMetadata mediaMetadata = (MediaMetadata) immutableList.get(i);
                Subscriber subscriber = (Subscriber) mediaGalleryDataSource.f2362a.get(mediaMetadata.d());
                if (subscriber != null) {
                    subscriber.mo118a(mediaMetadata);
                }
            }
            mediaGalleryDataSource.f2363b = immutableList;
            this.f2385a.aN.kR_();
            if (!(obj == null || immutableList.isEmpty())) {
                MediaGalleryFragment mediaGalleryFragment = this.f2385a;
                if (mediaGalleryFragment.aS.isPresent()) {
                    int i2 = 0;
                    while (i2 < mediaGalleryFragment.aN.b()) {
                        if (mediaGalleryFragment.aF.f.equals(mediaGalleryFragment.aN.m2544e(i2).d())) {
                            mediaGalleryFragment.aM.a(i2, false);
                            if (i2 == 0) {
                                mediaGalleryFragment.aZ.e_(0);
                            }
                            mediaGalleryFragment.aS = Absent.INSTANCE;
                        } else {
                            i2++;
                        }
                    }
                    mediaGalleryFragment.aS = Absent.INSTANCE;
                }
            }
            if (this.f2385a.aM.k < this.f2385a.aN.b()) {
                MediaMetadata e = this.f2385a.aN.m2544e(this.f2385a.aM.k);
                String c = MediaGalleryFragment.m2513c(e);
                if (MediaGalleryFragment.aD(this.f2385a)) {
                    this.f2385a.am.m2876c(c);
                }
                MediaGalleryFragment.aC(this.f2385a).m2783a(this.f2385a, e);
                if (MediaGalleryFragment.aD(this.f2385a)) {
                    this.f2385a.am.m2875a(c, this.f2385a.bd);
                }
                MediaGalleryFragment.m2512b(this.f2385a, e);
            } else if (this.f2385a.aL != null) {
                this.f2385a.aL.setVisibility(8);
            }
            if (immutableList.isEmpty() && this.f2385a.aO.e == Status.DONE && this.f2385a.aT.isPresent()) {
                2 2 = (2) this.f2385a.aT.get();
                if (2.a.aV == State.ANIMATE_IN) {
                    2.a.aF.c.a();
                    PhotoAnimationDialogFragment.az(2.a);
                }
                2.a.aV = State.ANIMATE_OUT;
                2.a.aG.l = false;
                PhotoAnimationDialogFragment.a(2.a, 1.0f);
            }
        }

        public final void m2499a(Status status) {
            if (status != Status.LOADING) {
                MediaGalleryFragment.m2507a(this.f2385a, false);
            } else if (this.f2385a.aN.b() != 0 || (this.f2385a.aQ.isPresent() && !((ImmutableList) this.f2385a.aQ.get()).isEmpty())) {
                MediaGalleryFragment.m2507a(this.f2385a, false);
                this.f2385a.aB.a(1310742);
            } else {
                MediaGalleryFragment.m2507a(this.f2385a, true);
                this.f2385a.aB.a(1310741);
            }
            if (status == Status.DONE) {
                PhotosDialogPerfUtil photosDialogPerfUtil = this.f2385a.f2396g;
                if (photosDialogPerfUtil.h) {
                    photosDialogPerfUtil.c.d("DataFetch");
                }
            }
        }
    }

    /* compiled from: snap_low_range */
    public class MediaPaginator extends SimpleOnPageChangeListener {
        final /* synthetic */ MediaGalleryFragment f2386a;
        private int f2387b = -1;
        private int f2388c = 0;
        private final Interpolator f2389d = new AccelerateInterpolator();

        public MediaPaginator(MediaGalleryFragment mediaGalleryFragment) {
            this.f2386a = mediaGalleryFragment;
        }

        public final void e_(int i) {
            UserAction userAction;
            MediaMetadata e = this.f2386a.aN.m2544e(i);
            String d = e.d();
            if (MediaGalleryFragment.aD(this.f2386a)) {
                this.f2386a.am.m2876c(d);
            }
            MediaGalleryFragment.aC(this.f2386a).m2783a(this.f2386a, e);
            if (MediaGalleryFragment.aD(this.f2386a)) {
                this.f2386a.am.m2875a(d, this.f2386a.bd);
            }
            MediaGalleryFragment.m2512b(this.f2386a, e);
            if (this.f2386a.aO.d() && i > this.f2386a.aN.b() - 3) {
                this.f2386a.aO.a(this.f2386a.aF.v);
            }
            if (this.f2387b != -1) {
                if (this.f2386a.aM.B != 2) {
                    this.f2386a.aM.setOffscreenPageLimit(2);
                }
                this.f2386a.aA.b(FunnelRegistry.z, this.f2387b < i ? "swipe_to_next_photo" : "swipe_to_previous_photo");
                this.f2386a.f2396g.a.e(1310731, PhotosDialogPerfUtil.a(e.d()));
                ((NavigationLogger) this.f2386a.f2394e.get()).a("swipe");
            } else {
                ((NavigationLogger) this.f2386a.f2394e.get()).a("tap_photo");
            }
            MediaLogger mediaLogger = this.f2386a.f2397h;
            String d2 = e.d();
            String c = e.N() != null ? e.N().c() : null;
            if (this.f2387b == -1) {
                userAction = UserAction.CLICK;
            } else {
                userAction = UserAction.SWIPE;
            }
            mediaLogger.a(d2, c, userAction);
            Map hashMap = new HashMap();
            if (d != null) {
                hashMap.put("photo_id", d);
            }
            if (!(e.N() == null || e.N().c() == null)) {
                hashMap.put("author_id", e.N().c());
            }
            ((NavigationLogger) this.f2386a.f2394e.get()).a(this.f2386a, hashMap);
            if (this.f2386a.aF.e != null) {
                PhotoViewController photoViewController = this.f2386a.aF.e;
                Long.parseLong(e.d());
                photoViewController.a(i);
            }
            if (!(this.f2386a.aF.u == null || this.f2387b == -1)) {
                PhotosFeedMediaGalleryScrollListener photosFeedMediaGalleryScrollListener = this.f2386a.aF.u;
                int b = PhotosFeedFragment.b(photosFeedMediaGalleryScrollListener.a, d);
                if (b >= 0) {
                    photosFeedMediaGalleryScrollListener.a.aD.d(PhotosFeedFragment.h(photosFeedMediaGalleryScrollListener.a, b), PhotosFeedFragment.a(photosFeedMediaGalleryScrollListener.a, PhotosMetadataConversionHelper.a(photosFeedMediaGalleryScrollListener.a.aM.b(b))));
                }
            }
            this.f2387b = i;
        }

        public final void m2501a(int i, float f, int i2) {
            float f2 = 0.0f;
            if (i == this.f2386a.aM.k) {
                f = 1.0f - f;
            }
            if (f > 0.0f && f < 1.0f) {
                if (f > 0.5f) {
                    f2 = this.f2389d.getInterpolation((f - 0.5f) * 2.0f);
                }
                MediaGalleryFragment.aC(this.f2386a).setVideoControlAlpha(f2);
            }
        }

        public final void m2502b(int i) {
            if (this.f2388c == 0 && i == 1 && MediaGalleryFragment.aD(this.f2386a)) {
                MediaMetadata e = this.f2386a.aN.m2544e(this.f2386a.aM.k);
                MediaGalleryVideoChromeController mediaGalleryVideoChromeController = this.f2386a.am;
                String c = MediaGalleryFragment.m2513c(e);
                for (C02902 c02902 : mediaGalleryVideoChromeController.f2835c.keySet()) {
                    if (c02902 != null) {
                        if (MediaGalleryVideoPageFragment.at(c02902.f2420a)) {
                            c02902.f2420a.f2428e.b(EventTriggerType.BY_PLAYER);
                        }
                    }
                }
            }
            this.f2388c = i;
        }
    }

    public static void m2508a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MediaGalleryFragment) obj).m2506a(IdBasedLazy.a(injectorLike, 9434), IdBasedLazy.a(injectorLike, 2974), MediaGalleryDataSource.m2473a(injectorLike), AnalyticsTagger.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137), (WarmupImageHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(WarmupImageHelperProvider.class), PhotosDialogPerfUtil.a(injectorLike), MediaLogger.a(injectorLike), ViewHelperViewAnimatorFactory.a(injectorLike), MediaGalleryChromeController.m2720a(injectorLike), MediaGalleryVideoChromeController.m2873a(injectorLike), TaggingStateController.m2663a(injectorLike), IdBasedLazy.a(injectorLike, 9355), IdBasedLazy.a(injectorLike, 9371), (Clock) SystemClockMethodAutoProvider.a(injectorLike), VpvEventHelper.a(injectorLike), FbViewConfigurationCompat.a(injectorLike), STATICDI_MULTIBIND_PROVIDER.GalleryDeepLinkBinder.a(injectorLike), ConsumptionPhotoEventBus.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 968), IdBasedLazy.a(injectorLike, 9520), IdBasedLazy.a(injectorLike, 2998), TimelineIntentFactory.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FunnelLoggerImpl.a(injectorLike), LocalStatsLoggerMethodAutoProvider.a(injectorLike), ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    private void m2506a(Lazy<FamilyTagTypeaheadUtil> lazy, Lazy<MediaFetcherFactory> lazy2, MediaGalleryDataSource mediaGalleryDataSource, AnalyticsTagger analyticsTagger, Lazy<NavigationLogger> lazy3, WarmupImageHelperProvider warmupImageHelperProvider, PhotosDialogPerfUtil photosDialogPerfUtil, MediaLogger mediaLogger, ViewAnimatorFactory viewAnimatorFactory, MediaGalleryChromeController mediaGalleryChromeController, MediaGalleryVideoChromeController mediaGalleryVideoChromeController, TaggingStateController taggingStateController, Lazy<DefaultSuggestionController> lazy4, Lazy<MediaMetadataParcelUtil> lazy5, Clock clock, VpvEventHelper vpvEventHelper, FbViewConfigurationCompat fbViewConfigurationCompat, Set<GalleryDeepLinkBinder> set, ConsumptionPhotoEventBus consumptionPhotoEventBus, Provider<SecureContextHelper> provider, Lazy<PlacePickerLauncher> lazy6, Lazy<PlacePickerResultHandler> lazy7, TimelineIntentFactory timelineIntentFactory, QeAccessor qeAccessor, FunnelLogger funnelLogger, LocalStatsLogger localStatsLogger, ListeningExecutorService listeningExecutorService, Executor executor) {
        this.f2390a = lazy;
        this.f2391b = lazy2;
        this.f2392c = mediaGalleryDataSource;
        this.f2393d = analyticsTagger;
        this.f2394e = lazy3;
        this.f2395f = warmupImageHelperProvider;
        this.f2396g = photosDialogPerfUtil;
        this.f2397h = mediaLogger;
        this.f2398i = viewAnimatorFactory;
        this.al = mediaGalleryChromeController;
        this.am = mediaGalleryVideoChromeController;
        this.an = taggingStateController;
        this.ao = lazy4;
        this.ap = lazy5;
        this.aq = clock;
        this.ar = vpvEventHelper;
        this.as = fbViewConfigurationCompat;
        this.at = set;
        this.au = consumptionPhotoEventBus;
        this.av = provider;
        this.aw = lazy6;
        this.ax = lazy7;
        this.ay = timelineIntentFactory;
        this.az = qeAccessor;
        this.aA = funnelLogger;
        this.aB = localStatsLogger;
        this.aC = listeningExecutorService;
        this.aD = executor;
    }

    public static MediaGalleryFragment m2505a(MediaGalleryLauncherParams mediaGalleryLauncherParams, MediaFetcherFactory mediaFetcherFactory, PhotosDialogPerfUtil photosDialogPerfUtil, @Nullable CallerContext callerContext, QeAccessor qeAccessor) {
        MediaGalleryFragment mediaGalleryFragment = new MediaGalleryFragment();
        mediaGalleryFragment.m2510b(mediaGalleryLauncherParams, mediaFetcherFactory, photosDialogPerfUtil, callerContext, qeAccessor);
        mediaGalleryFragment.aX = qeAccessor.a(ExperimentsForMediaGalleryAbTestModule.d, false);
        MediaGalleryLauncherParams.Builder builder = new MediaGalleryLauncherParams.Builder(mediaGalleryLauncherParams);
        builder.c = null;
        MediaGalleryLauncherParams b = builder.b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("EXTRA_LAUNCH_PARAM", b);
        mediaGalleryFragment.g(bundle);
        return mediaGalleryFragment;
    }

    public final void m2525c(Bundle bundle) {
        ArrayList arrayList;
        Object obj;
        super.c(bundle);
        Class cls = MediaGalleryFragment.class;
        m2508a((Object) this, getContext());
        this.aF = (MediaGalleryLauncherParams) this.s.getParcelable("EXTRA_LAUNCH_PARAM");
        this.aS = Optional.fromNullable(this.aF.f);
        MediaMetadataParcelUtil mediaMetadataParcelUtil = (MediaMetadataParcelUtil) this.ap.get();
        if (bundle == null) {
            arrayList = null;
        } else {
            arrayList = bundle.getParcelableArrayList("MG_EXTRA_MEDIA");
        }
        this.aW = mediaMetadataParcelUtil.a(arrayList, false);
        if (this.aO == null) {
            this.f2396g.a();
            this.aO = ((MediaFetcherFactory) this.f2391b.get()).a(this.aF.b, this.aG);
            if (bundle != null) {
                this.aO.a(Math.max(bundle.getInt("MG_EXTRA_NUM_ITEMS"), this.aF.v));
            } else {
                int size;
                int i = this.aF.v;
                if (this.aQ.isPresent()) {
                    size = ((ImmutableList) this.aQ.get()).size();
                } else {
                    size = 0;
                }
                this.aO.a(m2503a(this.az, Math.max(i, size)), this.aS);
            }
        }
        if (this.aF.f == null || this.aF.g == null) {
            obj = null;
        } else {
            obj = new WarmupImageHelper(this.aF.f, this.aF.g, CachedDrawableProvider.b(this.f2395f));
        }
        this.aR = Optional.fromNullable(obj);
        this.aS = Optional.fromNullable(this.aF.f);
        if (this.aF.f == null || this.aF.g == null) {
            BLog.a(aE, "Start media params are incomplete - flickering or other artifacts may occur");
        }
        MediaLogger a = this.f2397h.a(this.aF.a).a(this.aF.q);
        a.g = null;
        a.a(ContentViewingSurface.FULL_SCREEN_GALLERY);
        TaggingStateController taggingStateController = this.an;
        boolean z = this.aF.n;
        boolean z2 = taggingStateController.f2563a == TriState.UNSET || taggingStateController.f2563a == TriState.valueOf(z);
        Preconditions.checkState(z2);
        taggingStateController.f2563a = TriState.valueOf(z);
        e(true);
    }

    public final View m2517a(final LayoutInflater layoutInflater, final ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -811823097);
        if (this.aX) {
            this.aH = new FrameLayout(getContext());
            Futures.a(this.aC.a(new Callable<View>(this) {
                final /* synthetic */ MediaGalleryFragment f2378c;

                public Object call() {
                    return MediaGalleryFragment.m2504a(this.f2378c, layoutInflater, viewGroup);
                }
            }), new C02822(this), this.aD);
            GlobalOnLayoutHelper.a(this.aH, new C02833(this));
        } else {
            this.aH = (ViewGroup) m2504a(this, layoutInflater, viewGroup);
        }
        View view = this.aH;
        LogUtils.f(1683859546, a);
        return view;
    }

    public final void m2521a(View view, Bundle bundle) {
        super.a(view, bundle);
        if (!this.aX) {
            m2511b(this, view);
        }
    }

    public final void m2528h(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 62532750);
        super.h(bundle);
        if (!this.aX) {
            av(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1125094717, a);
    }

    public static View m2504a(MediaGalleryFragment mediaGalleryFragment, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        mediaGalleryFragment.f2396g.e();
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(mediaGalleryFragment.getContext(), 2131626064)).inflate(2130905171, viewGroup, false);
        mediaGalleryFragment.aI = (ViewStub) inflate.findViewById(2131563707);
        mediaGalleryFragment.aK = (ViewStub) inflate.findViewById(2131563706);
        if (!mediaGalleryFragment.az.a(ExperimentsForMediaGalleryAbTestModule.g, false)) {
            mediaGalleryFragment.aJ = mediaGalleryFragment.aI.inflate();
        }
        if (!mediaGalleryFragment.az.a(ExperimentsForMediaGalleryAbTestModule.h, true)) {
            aC(mediaGalleryFragment);
        }
        mediaGalleryFragment.f2396g.f();
        return inflate;
    }

    public static void m2511b(MediaGalleryFragment mediaGalleryFragment, View view) {
        mediaGalleryFragment.f2393d.a(view, "photos_view", mediaGalleryFragment);
        mediaGalleryFragment.aM = (ViewPager) view.findViewById(2131563705);
        mediaGalleryFragment.aM.setPageMargin(20);
        mediaGalleryFragment.al.f2637a = new C02855(mediaGalleryFragment);
        if (aD(mediaGalleryFragment)) {
            mediaGalleryFragment.am.f2833a = new C02866(mediaGalleryFragment);
        }
        mediaGalleryFragment.aM.post(new C02844(mediaGalleryFragment));
    }

    public static void av(MediaGalleryFragment mediaGalleryFragment) {
        Uri uri;
        if (mediaGalleryFragment.aF.g == null) {
            uri = null;
        } else {
            uri = mediaGalleryFragment.aF.g.c;
        }
        mediaGalleryFragment.aN = new MediaGalleryPagerAdapter(mediaGalleryFragment.s(), mediaGalleryFragment.f2392c, mediaGalleryFragment.aR, mediaGalleryFragment.aF.f, uri, mediaGalleryFragment.az.a(ExperimentsForMediaGalleryAbTestModule.a, false), aD(mediaGalleryFragment), mediaGalleryFragment.aF.x, mediaGalleryFragment.aF.y, mediaGalleryFragment.aF.z);
        mediaGalleryFragment.aM.setAdapter(mediaGalleryFragment.aN);
        mediaGalleryFragment.aM.setOnPageChangeListener(mediaGalleryFragment.aZ);
        mediaGalleryFragment.aY.m2500a(mediaGalleryFragment.aA());
        mediaGalleryFragment.aY.m2499a(mediaGalleryFragment.aO.e);
        mediaGalleryFragment.aO.a(mediaGalleryFragment.aY);
        mediaGalleryFragment.f2396g.a(false);
        mediaGalleryFragment.aA.a(FunnelRegistry.z);
        mediaGalleryFragment.bb = true;
        if (mediaGalleryFragment.bc) {
            mediaGalleryFragment.bc = false;
            mediaGalleryFragment.aw();
        }
    }

    public final void m2519a(int i, int i2, Intent intent) {
        switch (i) {
            case 5001:
                if (i2 == -1) {
                    Intent a = this.ay.a((EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a), null, intent.getLongExtra("extra_profile_pic_expiration", 0), intent.getStringExtra("staging_ground_photo_caption"), "existing");
                    a.putExtra("force_create_new_activity", true);
                    ((SecureContextHelper) this.av.get()).a(a, getContext());
                }
                return;
            case 5002:
                if (i2 == -1) {
                    ((PlacePickerResultHandler) this.ax.get()).a(intent);
                }
                return;
            default:
                Iterator it = this.at.iterator();
                while (it.hasNext()) {
                    it.next();
                    if (null != null) {
                        return;
                    }
                }
                return;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bb) {
            aw();
        } else {
            this.bc = true;
        }
    }

    private void aw() {
        this.aO.b(this.aY);
        this.aO.c();
        this.aO = ((MediaFetcherFactory) this.f2391b.get()).a(this.aF.b, this.aG);
        this.aO.a(this.aY);
        this.aO.a(this.aN.b() != 0 ? this.aN.b() : this.aF.v);
    }

    public final void m2527e(Bundle bundle) {
        ArrayList a = ((MediaMetadataParcelUtil) this.ap.get()).a(this.f2392c.f2363b, false);
        bundle.putParcelableArrayList("MG_EXTRA_MEDIA", a);
        bundle.putInt("MG_EXTRA_NUM_ITEMS", a.size());
        super.e(bundle);
    }

    public final void mY_() {
        int i;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1287527188);
        super.mY_();
        if (this.aM != null) {
            this.aM.setAdapter(null);
            this.aM.setOnPageChangeListener(null);
        }
        MediaGalleryDataSource mediaGalleryDataSource = this.f2392c;
        mediaGalleryDataSource.f2364c.a();
        mediaGalleryDataSource.f2362a.clear();
        mediaGalleryDataSource.f2363b = RegularImmutableList.a;
        if (this.aO != null) {
            this.aO.b(this.aY);
        }
        if (this.aL != null) {
            this.aL.m2781a();
            this.aL = null;
        }
        this.aM = null;
        this.aJ = null;
        this.aN = null;
        this.f2396g.g();
        this.al.f2637a = null;
        if (aD(this)) {
            this.am.f2833a = null;
        }
        ConsumptionPhotoEventBus consumptionPhotoEventBus = this.au;
        if (this.aF == null) {
            i = -1;
        } else {
            i = this.aF.p;
        }
        consumptionPhotoEventBus.a(new MediaGalleryFragmentVisibilityChangeEvent(false, i));
        for (GalleryDeepLinkBinder b : this.at) {
            b.b();
        }
        this.aA.b(FunnelRegistry.z);
        this.ba = true;
        LogUtils.f(-1351131545, a);
    }

    public final void m2516I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2103810561);
        super.I();
        aq();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1182165371, a);
    }

    public final void m2520a(Menu menu) {
        if (this.as.a()) {
            aC(this).m2784a(UserAction.HARDWARE_CLICK, (Optional) Absent.INSTANCE);
        }
    }

    @Nullable
    public final String m2526e() {
        if (this.aN == null || this.aN.b() == 0) {
            return null;
        }
        return this.aN.m2544e(this.aM.k).d();
    }

    public static boolean m2509a(MediaGalleryFragment mediaGalleryFragment, String str) {
        return StringUtil.a(str, mediaGalleryFragment.e());
    }

    public final void m2522a(2 2) {
        this.aT = Optional.of(2);
    }

    public final void m2514G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -829278334);
        super.G();
        this.ar.a();
        this.aP = this.aq.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1220012268, a);
    }

    public final void m2515H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1964252377);
        super.H();
        this.ar.a(this.aF != null ? this.aF.h : null, this.aq.a() - this.aP, "photo_gallery");
        LogUtils.f(60637921, a);
    }

    public final void aq() {
        if (this.aO != null) {
            this.aO.c();
            this.aO = null;
        }
        this.ba = true;
    }

    public final boolean ar() {
        return this.aX;
    }

    public final String as() {
        return PhotoAnimationDialogFragment.an;
    }

    @Nullable
    public final DrawingRule m2518a(Drawable drawable, Rect rect) {
        return DrawingRule.a(drawable, rect, ScaleType.CENTER_INSIDE);
    }

    public final boolean m2524a(3 3) {
        if (!this.aX) {
            return false;
        }
        this.aV = 3;
        return true;
    }

    public final void m2523a(ConsumptionPhotoEventBus consumptionPhotoEventBus, boolean z, int i) {
        consumptionPhotoEventBus.a(new MediaGalleryFragmentVisibilityChangeEvent(z, i));
    }

    private void m2510b(MediaGalleryLauncherParams<MediaMetadata> mediaGalleryLauncherParams, MediaFetcherFactory mediaFetcherFactory, PhotosDialogPerfUtil photosDialogPerfUtil, @Nullable CallerContext callerContext, QeAccessor qeAccessor) {
        this.aQ = Optional.of(Preconditions.checkNotNull(mediaGalleryLauncherParams.c));
        this.aG = callerContext;
        this.aO = mediaFetcherFactory.a(mediaGalleryLauncherParams.b, callerContext);
        photosDialogPerfUtil.a();
        if (mediaGalleryLauncherParams.d != null) {
            this.aO.a(mediaGalleryLauncherParams.d);
        }
        this.aO.a(m2503a(qeAccessor, Math.max(mediaGalleryLauncherParams.v, ((ImmutableList) this.aQ.get()).size())), Optional.fromNullable(mediaGalleryLauncherParams.f));
    }

    private static int m2503a(QeAccessor qeAccessor, int i) {
        return qeAccessor.a(ExperimentsForMediaGalleryAbTestModule.c, false) ? Math.min(qeAccessor.a(ExperimentsForMediaGalleryAbTestModule.b, 128), i) : i;
    }

    private ImmutableList<MediaMetadata> aA() {
        MediaFetcher mediaFetcher = this.aO;
        Preconditions.checkState(mediaFetcher.e != Status.CLOSED, "Calling method of closed() fetcher");
        ImmutableList<MediaMetadata> immutableList = mediaFetcher.d;
        if (!immutableList.isEmpty()) {
            return immutableList;
        }
        if (!this.aW.isEmpty()) {
            return this.aW;
        }
        if (this.aQ.isPresent()) {
            return (ImmutableList) this.aQ.get();
        }
        return immutableList;
    }

    public final String am_() {
        return "photo_viewer";
    }

    public static void m2512b(MediaGalleryFragment mediaGalleryFragment, MediaMetadata mediaMetadata) {
        MediaGalleryDeepLinkViewGroup mediaGalleryDeepLinkViewGroup = aC(mediaGalleryFragment).f2672R;
        mediaGalleryDeepLinkViewGroup.setVisibility(8);
        for (GalleryDeepLinkBinder a : mediaGalleryFragment.at) {
            if (a.a(mediaMetadata, mediaGalleryDeepLinkViewGroup, mediaGalleryFragment, mediaGalleryFragment.aF.r)) {
                mediaGalleryDeepLinkViewGroup.setVisibility(0);
                return;
            }
        }
    }

    public static MediaGalleryFooterView aC(MediaGalleryFragment mediaGalleryFragment) {
        if (mediaGalleryFragment.aL == null) {
            mediaGalleryFragment.aL = (MediaGalleryFooterView) mediaGalleryFragment.aK.inflate();
            mediaGalleryFragment.aL.setShowAttribution(mediaGalleryFragment.aF.m);
            mediaGalleryFragment.aL.ap = mediaGalleryFragment.aF.i;
            mediaGalleryFragment.aL.aq = mediaGalleryFragment.aF.k;
            mediaGalleryFragment.aL.ax = mediaGalleryFragment.aF.l;
            mediaGalleryFragment.aL.ar = mediaGalleryFragment.aF.j;
            mediaGalleryFragment.aL.setLocationButtonOnClickListener(mediaGalleryFragment.be);
            mediaGalleryFragment.aL.m2785a(mediaGalleryFragment.aF.o);
            mediaGalleryFragment.aL.az = mediaGalleryFragment.aF.q;
            mediaGalleryFragment.aL.aA = mediaGalleryFragment.f2397h;
            mediaGalleryFragment.aL.setTrackingCodes(mediaGalleryFragment.aF.h);
            if (mediaGalleryFragment.aF.x == 69076575) {
                mediaGalleryFragment.aL.as = mediaGalleryFragment.aF.y;
            }
        }
        return mediaGalleryFragment.aL;
    }

    public static void m2507a(MediaGalleryFragment mediaGalleryFragment, boolean z) {
        View view;
        int i = 0;
        if (mediaGalleryFragment.aJ != null) {
            view = mediaGalleryFragment.aJ;
            if (!z) {
                i = 8;
            }
        } else if (z) {
            mediaGalleryFragment.aJ = mediaGalleryFragment.aI.inflate();
            view = mediaGalleryFragment.aJ;
        } else {
            return;
        }
        view.setVisibility(i);
    }

    public static boolean aD(MediaGalleryFragment mediaGalleryFragment) {
        return mediaGalleryFragment.az.a(Liveness.Live, ExposureLogging.Off, ExperimentsForMediaGalleryAbTestModule.m, false);
    }

    public static String m2513c(MediaMetadata mediaMetadata) {
        return mediaMetadata == null ? null : mediaMetadata.d();
    }

    public static VisibilityAnimator aE(MediaGalleryFragment mediaGalleryFragment) {
        if (mediaGalleryFragment.aU == null) {
            mediaGalleryFragment.aU = new VisibilityAnimator(mediaGalleryFragment.aL, 200, true, mediaGalleryFragment.f2398i);
        }
        return mediaGalleryFragment.aU;
    }
}
