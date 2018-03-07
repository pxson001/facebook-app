package com.facebook.timeline.header.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView.StandardHeaderSizingType;
import com.facebook.caspian.ui.standardheader.StandardCoverPhotoView;
import com.facebook.caspian.ui.standardheader.StandardCoverType;
import com.facebook.caspian.ui.standardheader.StandardProfileImageViewBinder;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThreadImmediate;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLTimelineContextListItemType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelineContext.TimelineType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sequencelogger.Sequence;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.data.NeedsFragmentCleanup;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.TimelineContextItemHelper.C16411;
import com.facebook.timeline.header.TimelineHeaderTooltipController;
import com.facebook.timeline.header.TimelineProfileImageFrameController;
import com.facebook.timeline.header.TimelineProfileImageFrameControllerProvider;
import com.facebook.timeline.header.controllers.TimelineHeaderImagesController;
import com.facebook.timeline.header.coverphoto.TimelineCoverPhotoControllerListener;
import com.facebook.timeline.header.coverphoto.TimelineCoverPhotoControllerListenerProvider;
import com.facebook.timeline.header.coverphoto.TimelineCoverPhotoLoggingHelper;
import com.facebook.timeline.header.data.TimelineHeaderProfilePictureData;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.menus.TimelineCoverPhotoMenuBuilder;
import com.facebook.timeline.header.menus.TimelineCoverPhotoMenuBuilder.C16911;
import com.facebook.timeline.header.menus.TimelineCoverPhotoMenuBuilder.C16922;
import com.facebook.timeline.header.menus.TimelineProfilePicMenuBuilder;
import com.facebook.timeline.header.util.TimelineHeaderViewHelper;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.logging.TimelineSequenceLogger;
import com.facebook.timeline.logging.TimelineSequences;
import com.facebook.timeline.prefs.TimelinePreferencesKeys;
import com.facebook.timeline.profilevideo.playback.ProfileVideoController;
import com.facebook.timeline.profilevideo.playback.ProfileVideoControllerProvider;
import com.facebook.timeline.profilevideo.playback.ProfileVideoPlaybackExperimentAccessor;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemsConnectionFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderCoverPhotoFieldsModel;
import com.facebook.timeline.tempprofilepic.ProfileImageTemporaryAffordanceView;
import com.facebook.timeline.tempprofilepic.TemporaryAffordanceViewBinder;
import com.facebook.timeline.tempprofilepic.TemporaryAffordanceViewController;
import com.facebook.timeline.tempprofilepic.TemporaryAffordanceViewControllerProvider;
import com.facebook.timeline.util.IsWorkUserBadgeEnabled;
import com.facebook.timeline.util.TimelineViewHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.LazyView;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Locale;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetchThreadsForSync */
public class CaspianTimelineStandardHeader extends StandardCoverHeaderView implements NeedsFragmentCleanup, RecyclerViewKeepAttached {
    private static final CallerContext f11952B = CallerContext.a(StandardCoverPhotoView.class, "timeline", "cover_photo");
    @Inject
    @ForUiThreadImmediate
    Executor f11953A;
    private TimelineProfileImageFrameController f11954C;
    private ProfileVideoController f11955D;
    public TimelineUserContext f11956E;
    private TimelineHeaderUserData f11957F;
    public boolean f11958G;
    private int f11959H;
    private int f11960I = -1;
    private LazyView<? extends View> f11961J;
    private LazyView<? extends View> f11962K;
    private OnClickListener f11963L;
    private ProfileVideoPlaybackExperimentAccessor f11964M;
    private final OnClickListener f11965N = new C17211(this);
    @Inject
    Lazy<TimelineHeaderImagesController> f11966k;
    @Inject
    TimelineHeaderTooltipController f11967l;
    @Inject
    TimelineProfilePicMenuBuilder f11968m;
    @Inject
    Lazy<TimelineCoverPhotoMenuBuilder> f11969n;
    @Inject
    TemporaryAffordanceViewControllerProvider f11970o;
    @Inject
    TimelineProfileImageFrameControllerProvider f11971p;
    @Inject
    TimelinePerformanceLogger f11972q;
    @Inject
    ProfileVideoControllerProvider f11973r;
    @Inject
    QeAccessor f11974s;
    @Inject
    Locales f11975t;
    @Inject
    ProfileControllerDelegate f11976u;
    @Inject
    ProfileDebugControllerOverlayProvider f11977v;
    @Inject
    FbSharedPreferences f11978w;
    @Inject
    TimelineCoverPhotoControllerListenerProvider f11979x;
    @Inject
    @IsWorkUserBadgeEnabled
    Provider<TriState> f11980y;
    @Inject
    TimelineCoverPhotoLoggingHelper f11981z;

    /* compiled from: fetchThreadsForSync */
    class C17211 implements OnClickListener {
        final /* synthetic */ CaspianTimelineStandardHeader f11939a;

        C17211(CaspianTimelineStandardHeader caspianTimelineStandardHeader) {
            this.f11939a = caspianTimelineStandardHeader;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1961630608);
            CaspianTimelineStandardHeader.m12015t(this.f11939a);
            Logger.a(2, EntryType.UI_INPUT_END, -720192197, a);
        }
    }

    /* compiled from: fetchThreadsForSync */
    class C17222 implements FutureCallback<Drawable> {
        final /* synthetic */ CaspianTimelineStandardHeader f11940a;

        C17222(CaspianTimelineStandardHeader caspianTimelineStandardHeader) {
            this.f11940a = caspianTimelineStandardHeader;
        }

        public void onSuccess(Object obj) {
            Drawable drawable = (Drawable) obj;
            if (this.f11940a.f11956E != null && this.f11940a.f11981z != null && this.f11940a.g != null) {
                this.f11940a.g.setPlaceholderDrawable(drawable);
                this.f11940a.f11981z.m11736d();
            }
        }

        public void onFailure(Throwable th) {
            if (this.f11940a.f11956E != null && this.f11940a.f11981z != null) {
                this.f11940a.f11981z.m11737e();
            }
        }
    }

    /* compiled from: fetchThreadsForSync */
    class C17233 implements OnClickListener {
        final /* synthetic */ CaspianTimelineStandardHeader f11941a;

        C17233(CaspianTimelineStandardHeader caspianTimelineStandardHeader) {
            this.f11941a = caspianTimelineStandardHeader;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -184139161);
            if (CaspianTimelineStandardHeader.getProfileVideoController(this.f11941a).b()) {
                CaspianTimelineStandardHeader.m12010o(this.f11941a);
            } else {
                CaspianTimelineStandardHeader.m12011p(this.f11941a);
            }
            LogUtils.a(1928947690, a);
        }
    }

    /* compiled from: fetchThreadsForSync */
    class C17244 implements OnMenuItemClickListener {
        final /* synthetic */ CaspianTimelineStandardHeader f11942a;

        C17244(CaspianTimelineStandardHeader caspianTimelineStandardHeader) {
            this.f11942a = caspianTimelineStandardHeader;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            CaspianTimelineStandardHeader.m12012q(this.f11942a);
            return true;
        }
    }

    /* compiled from: fetchThreadsForSync */
    class C17277 implements ProfileVideoPlaybackExperimentAccessor {
        final /* synthetic */ CaspianTimelineStandardHeader f11951a;

        C17277(CaspianTimelineStandardHeader caspianTimelineStandardHeader) {
            this.f11951a = caspianTimelineStandardHeader;
        }

        public final boolean m11982a() {
            return this.f11951a.f11974s.a(ExperimentsForTimelineAbTestModule.aS, false);
        }

        public final boolean m11983b() {
            return true;
        }
    }

    /* compiled from: fetchThreadsForSync */
    enum PhotoType {
        COVER_PHOTO,
        PROFILE_PHOTO
    }

    private static <T extends View> void m11988a(Class<T> cls, T t) {
        m11989a((Object) t, t.getContext());
    }

    private static void m11989a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CaspianTimelineStandardHeader) obj).m11985a(IdBasedLazy.a(injectorLike, 11262), TimelineHeaderTooltipController.m11471a(injectorLike), TimelineProfilePicMenuBuilder.m11972a(injectorLike), IdBasedLazy.a(injectorLike, 11281), (TemporaryAffordanceViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TemporaryAffordanceViewControllerProvider.class), (TimelineProfileImageFrameControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineProfileImageFrameControllerProvider.class), TimelinePerformanceLogger.a(injectorLike), (ProfileVideoControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProfileVideoControllerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), Locales.a(injectorLike), ProfileControllerDelegate.m10751a(injectorLike), (ProfileDebugControllerOverlayProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProfileDebugControllerOverlayProvider.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (TimelineCoverPhotoControllerListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineCoverPhotoControllerListenerProvider.class), IdBasedProvider.a(injectorLike, 781), TimelineCoverPhotoLoggingHelper.m11726a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike));
    }

    private void m11985a(Lazy<TimelineHeaderImagesController> lazy, TimelineHeaderTooltipController timelineHeaderTooltipController, TimelineProfilePicMenuBuilder timelineProfilePicMenuBuilder, Lazy<TimelineCoverPhotoMenuBuilder> lazy2, TemporaryAffordanceViewControllerProvider temporaryAffordanceViewControllerProvider, TimelineProfileImageFrameControllerProvider timelineProfileImageFrameControllerProvider, TimelinePerformanceLogger timelinePerformanceLogger, ProfileVideoControllerProvider profileVideoControllerProvider, QeAccessor qeAccessor, Locales locales, ProfileControllerDelegate profileControllerDelegate, ProfileDebugControllerOverlayProvider profileDebugControllerOverlayProvider, FbSharedPreferences fbSharedPreferences, TimelineCoverPhotoControllerListenerProvider timelineCoverPhotoControllerListenerProvider, Provider<TriState> provider, TimelineCoverPhotoLoggingHelper timelineCoverPhotoLoggingHelper, Executor executor) {
        this.f11966k = lazy;
        this.f11967l = timelineHeaderTooltipController;
        this.f11968m = timelineProfilePicMenuBuilder;
        this.f11969n = lazy2;
        this.f11970o = temporaryAffordanceViewControllerProvider;
        this.f11971p = timelineProfileImageFrameControllerProvider;
        this.f11972q = timelinePerformanceLogger;
        this.f11973r = profileVideoControllerProvider;
        this.f11974s = qeAccessor;
        this.f11975t = locales;
        this.f11976u = profileControllerDelegate;
        this.f11977v = profileDebugControllerOverlayProvider;
        this.f11978w = fbSharedPreferences;
        this.f11979x = timelineCoverPhotoControllerListenerProvider;
        this.f11980y = provider;
        this.f11981z = timelineCoverPhotoLoggingHelper;
        this.f11953A = executor;
    }

    public CaspianTimelineStandardHeader(Context context) {
        super(context);
        m12002h();
    }

    public CaspianTimelineStandardHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12002h();
    }

    public CaspianTimelineStandardHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12002h();
    }

    private void m12002h() {
        m11988a(CaspianTimelineStandardHeader.class, (View) this);
        this.d = m12019x() ? StandardHeaderSizingType.NARROW : StandardHeaderSizingType.STANDARD;
        setCoverType(StandardCoverType.IMAGE);
        f();
        this.i.setAlpha(0.0f);
        m12020y();
        m12021z();
    }

    public final boolean m12022a(TimelineUserContext timelineUserContext, TimelineHeaderUserData timelineHeaderUserData) {
        TracerDetour.a("CaspianTimelineStandardHeader.bindModel", 1352014487);
        try {
            boolean b = m11996b(timelineUserContext, timelineHeaderUserData);
            return b;
        } finally {
            TracerDetour.a(576167230);
        }
    }

    private boolean m11996b(TimelineUserContext timelineUserContext, TimelineHeaderUserData timelineHeaderUserData) {
        if (timelineHeaderUserData == null) {
            return false;
        }
        int i = getContext().getResources().getConfiguration().orientation;
        if (this.f11959H == i && this.f11960I >= this.f11957F.c) {
            return false;
        }
        this.f11960I = timelineHeaderUserData.c;
        this.f11959H = i;
        this.f11956E = timelineUserContext;
        this.f11957F = timelineHeaderUserData;
        m12004i();
        return true;
    }

    public void setIsCoverEditMode(boolean z) {
        this.f11958G = z;
    }

    private void m12004i() {
        if (this.f11957F != null) {
            m12017v();
            m12018w();
            m12009n();
            if (!this.f11958G) {
                m12007l();
            }
            getProfileVideoController(this).a(getProfilePhotoOrVideoClickListener());
            if (getProfileVideoController(this).a()) {
                TimelinePerformanceLogger timelinePerformanceLogger = this.f11972q;
                if (!timelinePerformanceLogger.l) {
                    ImmutableMap b = new Builder().b("is_optimistic", null != null ? "1" : "0").b();
                    TimelineSequenceLogger timelineSequenceLogger = timelinePerformanceLogger.c;
                    String str = "TimelineProfileVideoLoad";
                    Sequence e = timelineSequenceLogger.a.e(TimelineSequences.a);
                    if (e != null) {
                        SequenceLoggerDetour.a(e, str, b, timelineSequenceLogger.c.now(), 1142377610);
                    }
                    timelinePerformanceLogger.l = true;
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b = getResources().getConfiguration().orientation;
        f();
        m12004i();
    }

    public final boolean gK_() {
        return true;
    }

    private boolean m12005j() {
        return this.f11957F.r();
    }

    private boolean m12006k() {
        String toLowerCase = this.f11975t.a().getLanguage().toLowerCase(Locale.US);
        return Objects.equal(toLowerCase, "kr") || Objects.equal(toLowerCase, "ar") || Objects.equal(toLowerCase, "hu") || Objects.equal(toLowerCase, "tr");
    }

    public final void m12023c() {
        if (!(this.f11957F == null || this.f11957F.V() == null)) {
            this.f11957F.V().cancel(true);
        }
        if (this.f11954C != null) {
            TimelineProfileImageFrameController timelineProfileImageFrameController = this.f11954C;
            TemporaryAffordanceViewController temporaryAffordanceViewController = timelineProfileImageFrameController.f11553c;
            if (temporaryAffordanceViewController.d.b()) {
                ((ProfileImageTemporaryAffordanceView) temporaryAffordanceViewController.d.a()).clearAnimation();
                if (temporaryAffordanceViewController.e != null) {
                    ((ProfileImageTemporaryAffordanceView) temporaryAffordanceViewController.d.a()).removeCallbacks(temporaryAffordanceViewController.e);
                }
                if (temporaryAffordanceViewController.f != null) {
                    ((ProfileImageTemporaryAffordanceView) temporaryAffordanceViewController.d.a()).removeCallbacks(temporaryAffordanceViewController.f);
                }
            }
            temporaryAffordanceViewController.h = true;
            temporaryAffordanceViewController.i = null;
            timelineProfileImageFrameController.f11558h = true;
        }
        getProfileVideoController(this).d();
        this.f11957F = null;
        this.f11954C = null;
        this.f11956E = null;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f11962K != null && this.f11962K.b()) {
            this.f11962K.a().measure(i, i2);
            ((LayoutParams) this.f11962K.a().getLayoutParams()).setMargins(0, -this.f11962K.a().getMeasuredHeight(), 0, 0);
        }
        super.onMeasure(i, i2);
    }

    private void m12007l() {
        PointF pointF;
        boolean z;
        if (this.f11957F.P() == null || this.f11957F.P().a() == null) {
            pointF = null;
        } else {
            pointF = new PointF((float) this.f11957F.P().a().a(), (float) this.f11957F.P().a().b());
        }
        if (!(this.f11957F.j() || TimelineHeaderViewHelper.b(this.f11957F.P()))) {
            this.f11981z.m11735c();
        }
        TimelineCoverPhotoControllerListener a = TimelineCoverPhotoControllerListenerProvider.m11725a(this.g, this.f11981z, this.f11957F);
        StandardCoverPhotoView standardCoverPhotoView = this.g;
        int screenWidth = getScreenWidth();
        int i = this.c;
        ImageRequest highResImageRequest = getHighResImageRequest();
        boolean b = this.f11956E.b();
        String[] Q = this.f11957F.Q();
        CallerContext callerContext = f11952B;
        OnClickListener onClickListener = this.f11965N;
        if (this.f11957F.j()) {
            z = false;
        } else {
            z = true;
        }
        standardCoverPhotoView.a(screenWidth, i, true, null, highResImageRequest, pointF, false, b, Q, callerContext, onClickListener, a, false, z);
        if (this.f11978w.a(TimelinePreferencesKeys.c, false)) {
            ((GenericDraweeHierarchy) this.g.getHierarchy()).a(this.f11977v.m12046a(this.f11957F));
        }
        m12008m();
    }

    @Nullable
    private ImageRequest getHighResImageRequest() {
        String R = this.f11957F.R();
        if (R == null) {
            return null;
        }
        Priority priority;
        if (this.f11957F.V() == null || !this.f11974s.a(ExperimentsForTimelineAbTestModule.U, false)) {
            priority = Priority.HIGH;
        } else {
            priority = Priority.LOW;
        }
        ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(R));
        a.i = priority;
        return a.m();
    }

    private void m12008m() {
        if (this.f11957F.V() != null) {
            Futures.a(this.f11957F.V(), new C17222(this), this.f11953A);
        }
    }

    private String getProfilePicUri() {
        return this.f11957F.L();
    }

    private void m12009n() {
        if (this.f11956E != null) {
            OnClickListener onClickListener;
            TimelineProfileImageFrameController timelineProfileImageFrameController = this.f11954C;
            TimelineHeaderUserData timelineHeaderUserData = this.f11957F;
            TimelineUserContext timelineUserContext = this.f11956E;
            boolean b = getProfileVideoController(this).b();
            boolean c = getProfileVideoController(this).c();
            boolean z = this.f11958G;
            if (this.f11958G) {
                onClickListener = null;
            } else {
                onClickListener = getProfilePhotoOrVideoClickListener();
            }
            timelineProfileImageFrameController.m11585a(timelineHeaderUserData, timelineUserContext, b, c, z, onClickListener, getProfileImageView(), this.f11961J, true);
            if (!this.f11958G) {
                this.f11967l.m11474a(this.f11956E, this.f11957F, getProfileImageView());
                if (this.f11956E == null || !this.f11956E.i()) {
                    this.f11962K.c();
                    return;
                }
                this.f11962K.a().setVisibility(0);
                this.k.add(this.f11962K.a());
            }
        }
    }

    private OnClickListener getProfilePhotoOrVideoClickListener() {
        if (this.f11963L == null) {
            this.f11963L = new C17233(this);
        }
        return this.f11963L;
    }

    public static void m12010o(CaspianTimelineStandardHeader caspianTimelineStandardHeader) {
        if (caspianTimelineStandardHeader.f11956E.b()) {
            caspianTimelineStandardHeader.f11968m.m11979a(caspianTimelineStandardHeader.getContext(), caspianTimelineStandardHeader.f11956E, caspianTimelineStandardHeader.m12013r(), getProfileVideoController(caspianTimelineStandardHeader).b(), caspianTimelineStandardHeader.f11957F.w(), new C17244(caspianTimelineStandardHeader)).a(caspianTimelineStandardHeader.j);
        } else {
            m12012q(caspianTimelineStandardHeader);
        }
    }

    public static void m12011p(CaspianTimelineStandardHeader caspianTimelineStandardHeader) {
        String c;
        ImageRequest a = caspianTimelineStandardHeader.f11957F.L() != null ? ImageRequest.a(Uri.parse(caspianTimelineStandardHeader.f11957F.L())) : null;
        TimelineHeaderProfilePictureData timelineHeaderProfilePictureData = caspianTimelineStandardHeader.f11957F.f;
        if (timelineHeaderProfilePictureData.b != null) {
            c = timelineHeaderProfilePictureData.b.c();
        } else {
            c = null;
        }
        String str = c;
        timelineHeaderProfilePictureData = caspianTimelineStandardHeader.f11957F.f;
        if (timelineHeaderProfilePictureData.b == null || timelineHeaderProfilePictureData.b.b() == null) {
            c = null;
        } else {
            c = timelineHeaderProfilePictureData.b.b().b();
        }
        String str2 = c;
        if (caspianTimelineStandardHeader.f11956E.b()) {
            caspianTimelineStandardHeader.m11994b(str, str2, a);
        } else {
            caspianTimelineStandardHeader.m11991a(str, str2, a, PhotoType.PROFILE_PHOTO);
        }
    }

    public static void m12012q(CaspianTimelineStandardHeader caspianTimelineStandardHeader) {
        caspianTimelineStandardHeader.f11976u.mo473l().mo551e();
        getProfileVideoController(caspianTimelineStandardHeader).e();
    }

    private boolean m12013r() {
        if (getProfileVideoController(this).c()) {
            return false;
        }
        if ((this.f11957F.f.c != null ? 1 : null) != null || getProfilePicUri() == null || this.f11957F.v()) {
            return false;
        }
        return true;
    }

    private boolean m12014s() {
        return (this.f11957F.g.e != null ? 1 : null) == null && this.f11957F.R() != null;
    }

    private void m11991a(String str, String str2, ImageRequest imageRequest, PhotoType photoType) {
        if (str != null) {
            m11995b(str, str2, imageRequest, photoType);
        } else if (photoType == PhotoType.PROFILE_PHOTO) {
            m11984a(imageRequest);
        }
    }

    private void m11984a(ImageRequest imageRequest) {
        if (this.f11957F.E() != null) {
            this.f11976u.mo473l().mo547a(getProfileImageView(), this.f11957F.E(), imageRequest, this.f11957F.K());
        }
    }

    private void m11995b(String str, String str2, ImageRequest imageRequest, PhotoType photoType) {
        FullscreenGallerySource fullscreenGallerySource;
        DraweeView profileImageView;
        DefaultImageFields defaultImageFields;
        FullscreenGallerySource fullscreenGallerySource2;
        DefaultImageFields defaultImageFields2 = null;
        if (photoType == PhotoType.PROFILE_PHOTO) {
            fullscreenGallerySource = FullscreenGallerySource.TIMELINE_PROFILE_PHOTO;
            profileImageView = getProfileImageView();
            defaultImageFields2 = this.f11957F.K();
        } else if (photoType == PhotoType.COVER_PHOTO) {
            fullscreenGallerySource = FullscreenGallerySource.TIMELINE_COVER_PHOTO;
            profileImageView = this.g;
            if (m12016u()) {
                defaultImageFields2 = this.f11957F.P().b().du_();
            }
        } else {
            defaultImageFields = null;
            profileImageView = null;
            fullscreenGallerySource2 = null;
            ((TimelineHeaderImagesController) this.f11966k.get()).m11682a(profileImageView, str, str2, imageRequest, defaultImageFields, fullscreenGallerySource2);
        }
        defaultImageFields = defaultImageFields2;
        fullscreenGallerySource2 = fullscreenGallerySource;
        ((TimelineHeaderImagesController) this.f11966k.get()).m11682a(profileImageView, str, str2, imageRequest, defaultImageFields, fullscreenGallerySource2);
    }

    public static void m12015t(CaspianTimelineStandardHeader caspianTimelineStandardHeader) {
        String d;
        String str = null;
        ImageRequest a = ImageRequest.a(caspianTimelineStandardHeader.f11957F.R());
        if (caspianTimelineStandardHeader.m12016u()) {
            TimelineHeaderCoverPhotoFieldsModel b = caspianTimelineStandardHeader.f11957F.P().b();
            d = b.d();
            if (b.c() != null) {
                str = b.c().b();
            }
        } else {
            d = null;
        }
        if (caspianTimelineStandardHeader.f11956E.b()) {
            caspianTimelineStandardHeader.m11990a(d, str, a);
        } else {
            caspianTimelineStandardHeader.m11991a(d, str, a, PhotoType.COVER_PHOTO);
        }
    }

    private boolean m12016u() {
        return (this.f11957F.P() == null || this.f11957F.P().b() == null) ? false : true;
    }

    private void m11990a(final String str, final String str2, final ImageRequest imageRequest) {
        TimelineCoverPhotoMenuBuilder timelineCoverPhotoMenuBuilder = (TimelineCoverPhotoMenuBuilder) this.f11969n.get();
        Context context = getContext();
        TimelineUserContext timelineUserContext = this.f11956E;
        boolean s = m12014s();
        OnMenuItemClickListener c17255 = new OnMenuItemClickListener(this) {
            final /* synthetic */ CaspianTimelineStandardHeader f11946d;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f11946d.m11991a(str, str2, imageRequest, PhotoType.COVER_PHOTO);
                return true;
            }
        };
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(context);
        PopoverMenu c = figPopoverMenuWindow.c();
        c.a(2131234984).setOnMenuItemClickListener(new C16911(timelineCoverPhotoMenuBuilder));
        if (timelineUserContext != null && timelineUserContext.e == TimelineType.USER) {
            c.a(2131234988).setOnMenuItemClickListener(new C16922(timelineCoverPhotoMenuBuilder));
        }
        if (s) {
            c.a(2131234975).setOnMenuItemClickListener(c17255);
        }
        figPopoverMenuWindow.a(this.g);
    }

    private void m11994b(final String str, final String str2, final ImageRequest imageRequest) {
        this.f11968m.m11979a(getContext(), this.f11956E, m12013r(), getProfileVideoController(this).b(), this.f11957F.w(), new OnMenuItemClickListener(this) {
            final /* synthetic */ CaspianTimelineStandardHeader f11950d;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f11950d.m11991a(str, str2, imageRequest, PhotoType.PROFILE_PHOTO);
                return true;
            }
        }).a(this.j);
    }

    private void m12017v() {
        this.f.setTitleTextAppearance(m12019x() ? 2131625435 : 2131625434);
        if (this.f11957F.N() != null) {
            CharSequence b = m11993b(m12019x() ? 2131625437 : 2131625436, getResources().getDimensionPixelSize(2131429896));
            if (b != null && b.length() > 30) {
                b = m11993b(m12019x() ? 2131625439 : 2131625438, getResources().getDimensionPixelSize(2131429897));
            }
            this.f.setTitleText(b);
        }
    }

    private void m12018w() {
        if (m12019x() && this.f11957F.s().isPresent()) {
            ImmutableList a = ((TimelineContextListItemsConnectionFieldsModel) this.f11957F.s().get()).a();
            if (a.isEmpty()) {
                this.f.setSubtitleText("");
                return;
            }
            Spannable spannableString;
            TimelineContextListItemFieldsModel timelineContextListItemFieldsModel = (TimelineContextListItemFieldsModel) a.get(0);
            Context context = getContext();
            boolean i = this.f11956E.i();
            ProfileControllerDelegate profileControllerDelegate = this.f11976u;
            if (timelineContextListItemFieldsModel.g() == null || timelineContextListItemFieldsModel.g().a() == null) {
                spannableString = new SpannableString("");
            } else {
                C16411 c16411 = new C16411(profileControllerDelegate, timelineContextListItemFieldsModel, i);
                int i2 = (i || timelineContextListItemFieldsModel.dr_() == GraphQLTimelineContextListItemType.BIRTHDAY) ? 1 : 0;
                TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(context, i2 != 0 ? 2131625441 : 2131625440);
                spannableString = new SpannableString(timelineContextListItemFieldsModel.g().a());
                spannableString.setSpan(textAppearanceSpan, 0, spannableString.length(), 33);
                spannableString.setSpan(c16411, 0, spannableString.length(), 33);
            }
            this.f.setSubtitleText(spannableString);
            return;
        }
        this.f.setSubtitleText("");
    }

    private boolean m12019x() {
        return this.f11974s.a(ExperimentsForTimelineAbTestModule.ah, false);
    }

    private CharSequence m11993b(int i, int i2) {
        String str;
        int i3;
        boolean z;
        boolean j = m12005j();
        boolean k = m12006k();
        String N = this.f11957F.N();
        TimelineHeaderUserData timelineHeaderUserData = this.f11957F;
        if (timelineHeaderUserData.a == null) {
            str = null;
        } else {
            str = timelineHeaderUserData.a.v();
        }
        String str2 = str;
        if (m12019x()) {
            i3 = 2131625446;
        } else {
            i3 = 2131625445;
        }
        SpannableStringBuilder a = TimelineViewHelper.a(N, str2, i, i3, getContext());
        if (j) {
            Object a2 = TimelineViewHelper.a(getResources().getText(2131235011), m12019x() ? 2131625448 : 2131625447, getContext());
            if (k) {
                a = a.append("\n").append(a2);
            } else {
                a = a2.append("\n").append(a);
            }
        }
        timelineHeaderUserData = this.f11957F;
        if (timelineHeaderUserData.a == null) {
            z = false;
        } else {
            z = timelineHeaderUserData.a.y();
        }
        boolean z2 = z;
        TimelineHeaderUserData timelineHeaderUserData2 = this.f11957F;
        if (timelineHeaderUserData2.a == null) {
            z = false;
        } else {
            z = timelineHeaderUserData2.a.z();
        }
        return TimelineViewHelper.a(z2, z, a, 2130843878, 2130844053, getContext(), getResources().getDimensionPixelSize(2131429838), i2, this.f11980y);
    }

    private void m12020y() {
        ViewStub profileEditIconViewStub = getProfileEditIconViewStub();
        ViewStub viewStub = (ViewStub) c(2131567615);
        boolean a = this.f11974s.a(ExperimentsForTimelineAbTestModule.ah, false);
        Resources resources = getResources();
        int intrinsicWidth = getResources().getDrawable(2130839751).getIntrinsicWidth();
        if (a) {
            int dimensionPixelSize = resources.getDimensionPixelSize(2131429904) - intrinsicWidth;
            if (TimelineProfileCoverEditIconViewHelper.m12055a(resources) <= Math.min(((getScreenWidth() / 2) - resources.getDimensionPixelSize(2131429902)) - intrinsicWidth, dimensionPixelSize)) {
                TimelineProfileCoverEditIconViewHelper.m12056a(profileEditIconViewStub, viewStub);
            } else {
                TimelineProfileCoverEditIconViewHelper.m12057b(profileEditIconViewStub, viewStub);
            }
        } else {
            if (TimelineProfileCoverEditIconViewHelper.m12055a(resources) <= resources.getDimensionPixelSize(2131429903) - intrinsicWidth) {
                TimelineProfileCoverEditIconViewHelper.m12056a(profileEditIconViewStub, viewStub);
            } else {
                TimelineProfileCoverEditIconViewHelper.m12057b(profileEditIconViewStub, viewStub);
            }
        }
        this.f11961J = new LazyView(profileEditIconViewStub);
        this.f11962K = new LazyView(viewStub);
    }

    private void m12021z() {
        ViewStub viewStub = (ViewStub) c(2131567622);
        viewStub.setLayoutResource(2130906438);
        LazyView lazyView = new LazyView(viewStub);
        TemporaryAffordanceViewControllerProvider temporaryAffordanceViewControllerProvider = this.f11970o;
        TemporaryAffordanceViewController temporaryAffordanceViewController = new TemporaryAffordanceViewController(TemporaryAffordanceViewBinder.a(temporaryAffordanceViewControllerProvider), ResourcesMethodAutoProvider.a(temporaryAffordanceViewControllerProvider), (Clock) SystemClockMethodAutoProvider.a(temporaryAffordanceViewControllerProvider), lazyView);
        InjectorLike injectorLike = this.f11971p;
        this.f11954C = new TimelineProfileImageFrameController(temporaryAffordanceViewController, StandardProfileImageViewBinder.b(injectorLike), ProfileControllerDelegate.m10751a(injectorLike), TimelinePerformanceLogger.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public static ProfileVideoController getProfileVideoController(CaspianTimelineStandardHeader caspianTimelineStandardHeader) {
        if (caspianTimelineStandardHeader.f11955D == null) {
            caspianTimelineStandardHeader.f11964M = new C17277(caspianTimelineStandardHeader);
            caspianTimelineStandardHeader.f11955D = caspianTimelineStandardHeader.f11973r.a(caspianTimelineStandardHeader.getContext(), caspianTimelineStandardHeader, caspianTimelineStandardHeader.f11956E.i(), caspianTimelineStandardHeader.f11957F, caspianTimelineStandardHeader.f11964M);
        }
        return caspianTimelineStandardHeader.f11955D;
    }

    public final boolean m12024g() {
        return getProfileVideoController(this).b();
    }
}
