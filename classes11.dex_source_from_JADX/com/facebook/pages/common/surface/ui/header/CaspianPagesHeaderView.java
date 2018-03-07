package com.facebook.pages.common.surface.ui.header;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelUuid;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArrayMap;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView.StandardHeaderSizingType;
import com.facebook.caspian.ui.standardheader.StandardCoverType;
import com.facebook.caspian.ui.standardheader.StandardHeaderTitlesContainer;
import com.facebook.caspian.ui.standardheader.StandardProfileImageViewBinder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.view.DraweeView;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLPhoto.Builder;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent.HeaderPerfLoggingEventType;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.CoverPhotoViewModel.CoverPhotoSubtitleState;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.ProfileEditIconState;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.ProfilePicContentState;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.ProfilePicState;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageHeaderDataProfilePhotoModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageProfileCoverPhotosDataModel.CoverPhotoModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageProfileCoverPhotosDataModel.CoverPhotoModel.PhotoModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity;
import com.facebook.timeline.profilevideo.playback.ProfileVideoController;
import com.facebook.timeline.profilevideo.playback.ProfileVideoControllerProvider;
import com.facebook.timeline.profilevideo.playback.ProfileVideoPlaybackExperimentAccessor;
import com.facebook.timeline.util.TimelineViewHelper;
import com.facebook.widget.OnDispatchDrawListener;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.inject.util.Providers;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reportPlace */
public class CaspianPagesHeaderView extends StandardCoverHeaderView implements CaspianPagesHeaderViewCallbacks {
    private static final CallerContext f2573u = CallerContext.a(CaspianPagesHeaderView.class, "pages_identity", "profile_photo");
    private static final CallerContext f2574v = CallerContext.a(CaspianPagesHeaderView.class, "pages_identity", "cover_photo");
    public boolean f2575A;
    public ProfileVideoController f2576B;
    private OnClickListener f2577C;
    private ProfileVideoPlaybackExperimentAccessor f2578D;
    public boolean f2579E;
    private final OnClickListener f2580F = new C03391(this);
    private final OnClickListener f2581G = new C03402(this);
    @Inject
    PageScopedEventBus f2582k;
    @Inject
    SecureContextHelper f2583l;
    @Inject
    MediaGalleryLauncherParamsFactory f2584m;
    @Inject
    MediaGalleryLauncher f2585n;
    @Inject
    PagesAnalytics f2586o;
    @Inject
    PagesExperimentUtils f2587p;
    @Inject
    StandardProfileImageViewBinder f2588q;
    @Inject
    CaspianPagesHeaderViewControllerProvider f2589r;
    @Inject
    ProfileVideoControllerProvider f2590s;
    public CaspianPagesHeaderViewHandler f2591t;
    private View f2592w;
    public BindModel f2593x;
    public ParcelUuid f2594y;
    private PageHeaderData f2595z;

    /* compiled from: reportPlace */
    class C03391 implements OnClickListener {
        final /* synthetic */ CaspianPagesHeaderView f2556a;

        C03391(CaspianPagesHeaderView caspianPagesHeaderView) {
            this.f2556a = caspianPagesHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1595587070);
            this.f2556a.f2586o.b(this.f2556a.f2593x.f2636f, CaspianPagesHeaderView.getProfilePhotoId(this.f2556a));
            this.f2556a.m3533b(view);
            Logger.a(2, EntryType.UI_INPUT_END, 1862208419, a);
        }
    }

    /* compiled from: reportPlace */
    class C03402 implements OnClickListener {
        final /* synthetic */ CaspianPagesHeaderView f2557a;

        C03402(CaspianPagesHeaderView caspianPagesHeaderView) {
            this.f2557a = caspianPagesHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1425178896);
            this.f2557a.f2586o.c(this.f2557a.f2593x.f2636f, CaspianPagesHeaderView.getCoverPhotoId(this.f2557a));
            CaspianPagesHeaderView.m3536c(this.f2557a, view);
            Logger.a(2, EntryType.UI_INPUT_END, -1961458659, a);
        }
    }

    /* compiled from: reportPlace */
    class C03413 implements OnDispatchDrawListener {
        final /* synthetic */ CaspianPagesHeaderView f2558a;

        C03413(CaspianPagesHeaderView caspianPagesHeaderView) {
            this.f2558a = caspianPagesHeaderView;
        }

        public final boolean m3506a() {
            ArrayMap arrayMap = new ArrayMap(1);
            String str = "ProfileVideoView";
            Object obj = (this.f2558a.f2575A && this.f2558a.f2576B.a()) ? "true" : "false";
            arrayMap.put(str, obj);
            this.f2558a.f2582k.a(new PageFragmentScopedHeaderPerfLoggingEvent(this.f2558a.f2594y, HeaderPerfLoggingEventType.HEADER_DISPATCH_DRAW_HAS_DATA, Optional.of(DataFreshnessResult.FROM_SERVER), arrayMap));
            this.f2558a.f2579E = true;
            return true;
        }
    }

    /* compiled from: reportPlace */
    class C03457 implements ProfileVideoPlaybackExperimentAccessor {
        final /* synthetic */ CaspianPagesHeaderView f2568a;

        C03457(CaspianPagesHeaderView caspianPagesHeaderView) {
            this.f2568a = caspianPagesHeaderView;
        }

        public final boolean m3508a() {
            return this.f2568a.f2575A;
        }

        public final boolean m3509b() {
            return false;
        }
    }

    /* compiled from: reportPlace */
    class C03468 implements OnClickListener {
        final /* synthetic */ CaspianPagesHeaderView f2569a;

        C03468(CaspianPagesHeaderView caspianPagesHeaderView) {
            this.f2569a = caspianPagesHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1761477871);
            if (CaspianPagesHeaderView.getProfileVideoController(this.f2569a).b()) {
                CaspianPagesHeaderView.getProfileVideoController(this.f2569a).e();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1628114725, a);
        }
    }

    /* compiled from: reportPlace */
    /* synthetic */ class C03479 {
        static final /* synthetic */ int[] f2571b = new int[GraphQLPageVerificationBadge.values().length];

        static {
            f2572c = new int[PhotoType.values().length];
            try {
                f2572c[PhotoType.COVER_PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2572c[PhotoType.PROFILE_PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2571b[GraphQLPageVerificationBadge.GRAY_VERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2571b[GraphQLPageVerificationBadge.BLUE_VERIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            f2570a = new int[CoverPhotoSubtitleState.values().length];
            try {
                f2570a[CoverPhotoSubtitleState.CREATE_USERNAME.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2570a[CoverPhotoSubtitleState.USERNAME.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2570a[CoverPhotoSubtitleState.CATEGORY.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: reportPlace */
    public interface CaspianPagesHeaderViewHandler {
        BaseControllerListener mo61a();

        BindModel mo62a(PageHeaderData pageHeaderData, CaspianPagesHeaderViewCallbacks caspianPagesHeaderViewCallbacks);

        void mo63a(ParcelUuid parcelUuid);

        void mo64a(FragmentManager fragmentManager);

        BaseControllerListener mo65b();
    }

    /* compiled from: reportPlace */
    enum PhotoType {
        COVER_PHOTO,
        PROFILE_PHOTO
    }

    private static <T extends View> void m3529a(Class<T> cls, T t) {
        m3530a((Object) t, t.getContext());
    }

    private static void m3530a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CaspianPagesHeaderView) obj).m3524a(PageScopedEventBus.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), MediaGalleryLauncherParamsFactory.a(fbInjector), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.a(fbInjector), PagesAnalytics.a(fbInjector), PagesExperimentUtils.a(fbInjector), StandardProfileImageViewBinder.b(fbInjector), (CaspianPagesHeaderViewControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CaspianPagesHeaderViewControllerProvider.class), (ProfileVideoControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ProfileVideoControllerProvider.class));
    }

    public CaspianPagesHeaderView(Context context) {
        super(context);
        m3542i();
    }

    public CaspianPagesHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m3542i();
    }

    public CaspianPagesHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3542i();
    }

    private void m3542i() {
        m3529a(CaspianPagesHeaderView.class, (View) this);
        this.f2591t = this.f2589r.m3579a(getContext());
        this.f2575A = this.f2587p.b();
        this.d = StandardHeaderSizingType.NARROW;
        setCoverType(StandardCoverType.IMAGE);
        this.i.setAlpha(0.0f);
        f();
        m3546m();
    }

    public CaspianPagesHeaderViewHandler getCaspianPagesHeaderViewHandler() {
        return this.f2591t;
    }

    public void setPageHeaderData(PageHeaderData pageHeaderData) {
        this.f2595z = pageHeaderData;
        Preconditions.checkNotNull(this.f2595z);
        this.f2593x = this.f2591t.mo62a(pageHeaderData, this);
        if (!this.f2579E) {
            a(new C03413(this));
        }
        f();
        m3544k();
        if (this.f2576B != null) {
            this.f2576B.e = pageHeaderData;
        }
        m3543j();
    }

    public final void mo59a(@Nullable Drawable drawable) {
        this.g.setPlaceholderDrawable(drawable);
    }

    public final void mo60a(boolean z, View view) {
        if (z) {
            this.f2592w = view;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388693;
            this.e.addView(view, this.e.indexOfChild(this.g) + 1, layoutParams);
            return;
        }
        if (view != null) {
            this.e.removeView(view);
        }
        this.f2592w = null;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f2592w != null) {
            this.f2592w.measure(i, i2);
            ((LinearLayout.LayoutParams) this.f2592w.getLayoutParams()).setMargins(0, -this.f2592w.getMeasuredHeight(), 0, 0);
        }
        super.onMeasure(i, i2);
    }

    private void m3543j() {
        if (this.f2593x.f2637g.f2626a == ProfilePicState.NOT_VISIBLE) {
            e();
        } else {
            m3545l();
            if (this.f2575A) {
                getProfileVideoController(this).a(getProfileVideoClickListener());
            }
        }
        m3547n();
    }

    private void m3544k() {
        int i;
        if (this.f2587p.c()) {
            this.f.setSubtitleTextAppearance(2131625419);
            i = 2131625418;
        } else {
            this.f.setSubtitleTextAppearance(2131625413);
            i = 2131625412;
        }
        this.f.setTitleTextAppearance(i);
        if (this.f2593x.f2633c.f2624g) {
            ((LinearLayout.LayoutParams) this.f.getLayoutParams()).topMargin = 0;
        }
        SpannableStringBuilder a = TimelineViewHelper.a(this.f2593x.f2635e, null, i, 0, getContext());
        if (this.f2593x.f2635e != null) {
            int a2;
            GraphQLPageVerificationBadge ad = (this.f2595z.e == null || this.f2595z.e.ad() == null) ? GraphQLPageVerificationBadge.UNSET_OR_UNRECOGNIZED_ENUM_VALUE : this.f2595z.e.ad();
            boolean z = (GraphQLPageVerificationBadge.NOT_VERIFIED.equals(ad) || GraphQLPageVerificationBadge.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.equals(ad)) ? false : true;
            StandardHeaderTitlesContainer standardHeaderTitlesContainer = this.f;
            if (z) {
                a2 = m3517a(ad);
            } else {
                a2 = 0;
            }
            standardHeaderTitlesContainer.setTitleText(TimelineViewHelper.a(z, false, a, a2, 2130844053, getContext(), getResources().getDimensionPixelSize(2131429838), getResources().getDimensionPixelSize(2131429792), Providers.a(TriState.UNSET)));
        }
        switch (this.f2593x.f2633c.f2621d) {
            case CREATE_USERNAME:
                this.f.setSubtitleText(getResources().getString(2131234845));
                this.f.setSubtitleOnClickListener(this.f2593x.f2633c.f2625h);
                return;
            case USERNAME:
                if (StringUtil.a(this.f2593x.f2633c.f2622e)) {
                    this.f.setSubtitleOnClickListener(null);
                    return;
                }
                this.f.setSubtitleText(this.f2593x.f2633c.f2622e);
                this.f.setSubtitleOnClickListener(this.f2593x.f2633c.f2625h);
                return;
            case CATEGORY:
                if (!StringUtil.a(this.f2593x.f2633c.f2622e)) {
                    this.f.setSubtitleText(this.f2593x.f2633c.f2622e);
                }
                this.f.setSubtitleOnClickListener(null);
                return;
            default:
                return;
        }
    }

    private static int m3517a(GraphQLPageVerificationBadge graphQLPageVerificationBadge) {
        switch (C03479.f2571b[graphQLPageVerificationBadge.ordinal()]) {
            case 1:
                return 2130842498;
            case 2:
                return 2130842497;
            default:
                throw new IllegalArgumentException("No asset for verification status " + graphQLPageVerificationBadge.name());
        }
    }

    public static String getProfilePhotoId(CaspianPagesHeaderView caspianPagesHeaderView) {
        PageHeaderDataProfilePhotoModel M = caspianPagesHeaderView.f2595z.e.M();
        if (M == null || M.d() == null) {
            return null;
        }
        return M.d();
    }

    public static String getCoverPhotoId(CaspianPagesHeaderView caspianPagesHeaderView) {
        CoverPhotoModel u = caspianPagesHeaderView.f2595z.e.u();
        if (u == null || u.j() == null || u.j().l() == null) {
            return null;
        }
        return u.j().l();
    }

    private void m3545l() {
        if (this.f2593x.f2637g.f2628c == ProfilePicContentState.HAS_DATA) {
            this.f2588q.a(ImageRequest.a(this.f2593x.f2637g.f2629d), ImageRequest.a(this.f2593x.f2637g.f2630e), this.f2593x.f2638h, true, this.f2593x.f2631a, true, f2573u, this.f2580F, this.f2591t.mo61a(), getProfileImageView());
            if (this.f2593x.f2637g.f2627b == ProfileEditIconState.VISIBLE) {
                getProfileEditIconViewStub().setVisibility(0);
            }
        }
    }

    private void m3546m() {
        String[] strArr = new String[0];
        setCoverType(StandardCoverType.IMAGE);
        this.g.a(getScreenWidth(), this.c, false, null, null, null, false, false, strArr, f2574v, null, null, true, false);
    }

    private void m3547n() {
        this.g.a(getScreenWidth(), this.c, true, null, ImageRequest.a(this.f2593x.f2633c.f2618a), this.f2593x.f2633c.f2619b, this.f2593x.f2631a, this.f2593x.f2631a, this.f2593x.f2633c.f2620c, f2574v, this.f2581G, this.f2591t.mo65b(), this.f2593x.f2633c.f2623f, this.f2593x.f2634d);
    }

    private void m3533b(View view) {
        PageHeaderDataProfilePhotoModel M;
        if (this.f2595z.e.M() != null) {
            M = this.f2595z.e.M();
        } else {
            M = null;
        }
        if (this.f2593x.f2631a) {
            m3521a(view, m3518a(M), PhotoType.PROFILE_PHOTO);
        } else {
            m3522a(m3518a(M), PhotoType.PROFILE_PHOTO);
        }
    }

    public static void m3536c(CaspianPagesHeaderView caspianPagesHeaderView, View view) {
        CoverPhotoModel u;
        if (caspianPagesHeaderView.f2595z.e.u() != null) {
            u = caspianPagesHeaderView.f2595z.e.u();
        } else {
            u = null;
        }
        if (caspianPagesHeaderView.f2593x.f2631a) {
            caspianPagesHeaderView.m3521a(view, m3519a(u), PhotoType.COVER_PHOTO);
        } else {
            caspianPagesHeaderView.m3522a(m3519a(u), PhotoType.COVER_PHOTO);
        }
    }

    private static GraphQLPhoto m3518a(PageHeaderDataProfilePhotoModel pageHeaderDataProfilePhotoModel) {
        if (pageHeaderDataProfilePhotoModel == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.F = pageHeaderDataProfilePhotoModel.d();
        Builder builder2 = builder;
        builder2.G = DefaultGraphQLConversionHelper.a(pageHeaderDataProfilePhotoModel.k());
        builder2 = builder2;
        builder2.P = DefaultGraphQLConversionHelper.a(pageHeaderDataProfilePhotoModel.m());
        builder2 = builder2;
        builder2.S = DefaultGraphQLConversionHelper.a(pageHeaderDataProfilePhotoModel.n());
        builder2.I = DefaultGraphQLConversionHelper.a(pageHeaderDataProfilePhotoModel.l());
        if (pageHeaderDataProfilePhotoModel.j() != null) {
            GraphQLAlbum.Builder builder3 = new GraphQLAlbum.Builder();
            builder3.o = pageHeaderDataProfilePhotoModel.j().j();
            builder.e = builder3.a();
        }
        return builder.a();
    }

    private static GraphQLPhoto m3519a(CoverPhotoModel coverPhotoModel) {
        if (coverPhotoModel == null || coverPhotoModel.j() == null) {
            return null;
        }
        PhotoModel j = coverPhotoModel.j();
        Builder builder = new Builder();
        builder.F = j.l();
        builder = builder;
        builder.G = DefaultGraphQLConversionHelper.a(j.m());
        builder = builder;
        builder.K = DefaultGraphQLConversionHelper.a(j.m());
        builder = builder;
        GraphQLAlbum.Builder builder2 = new GraphQLAlbum.Builder();
        builder2.o = j.k().j();
        builder.e = builder2.a();
        return builder.a();
    }

    public final void m3551b() {
        if (this.f2575A) {
            getProfileVideoController(this).d();
        }
    }

    public final void m3552g() {
        String[] strArr = new String[]{this.f2595z.g().D()};
        this.g.setPlaceholderDrawable(null);
        this.g.a(getScreenWidth(), this.c, false, null, null, null, this.f2593x.f2631a, this.f2593x.f2631a, strArr, f2574v, this.f2581G, null, true, true);
    }

    public void setFragmentUuidForLogging(ParcelUuid parcelUuid) {
        this.f2594y = parcelUuid;
        this.f2591t.mo63a(parcelUuid);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b = getResources().getConfiguration().orientation;
        f();
        if (this.f2595z != null) {
            m3543j();
        }
    }

    private void m3521a(View view, final GraphQLPhoto graphQLPhoto, final PhotoType photoType) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(getContext());
        PopoverMenu c = figPopoverMenuWindow.c();
        OnMenuItemClickListener c03424 = new OnMenuItemClickListener(this) {
            final /* synthetic */ CaspianPagesHeaderView f2561c;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f2561c.m3522a(graphQLPhoto, photoType);
                return true;
            }
        };
        c.a(2131234984).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ CaspianPagesHeaderView f2563b;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f2563b.m3525a(photoType);
                return true;
            }
        });
        if (graphQLPhoto != null) {
            c.a(2131234973).setOnMenuItemClickListener(c03424);
        }
        figPopoverMenuWindow.a(view);
    }

    private void m3525a(PhotoType photoType) {
        SimplePickerSource simplePickerSource;
        int i;
        Action action = Action.NONE;
        switch (photoType) {
            case COVER_PHOTO:
                simplePickerSource = SimplePickerSource.PAGE_COVER_PHOTO;
                i = 124;
                break;
            case PROFILE_PHOTO:
                SimplePickerSource simplePickerSource2 = SimplePickerSource.PAGE_PROFILE_PIC;
                action = Action.LAUNCH_PROFILE_PIC_CROPPER;
                simplePickerSource = simplePickerSource2;
                i = 125;
                break;
            default:
                return;
        }
        SimplePickerLauncherConfiguration.Builder a = new SimplePickerLauncherConfiguration.Builder(simplePickerSource).h().i().k().a(action);
        Intent intent = new Intent(getContext(), SimplePickerLauncherActivity.class);
        intent.putExtra("extra_simple_picker_launcher_settings", a.r());
        this.f2583l.a(intent, i, (Activity) ContextUtils.a(getContext(), Activity.class));
    }

    private void m3522a(GraphQLPhoto graphQLPhoto, PhotoType photoType) {
        if (graphQLPhoto != null) {
            FullscreenGallerySource fullscreenGallerySource;
            switch (photoType) {
                case COVER_PHOTO:
                    fullscreenGallerySource = FullscreenGallerySource.PAGE_COVER_PHOTO;
                    break;
                case PROFILE_PHOTO:
                    fullscreenGallerySource = FullscreenGallerySource.PAGE_PROFILE_PHOTO;
                    break;
                default:
                    return;
            }
            m3523a(graphQLPhoto, fullscreenGallerySource);
        }
    }

    private void m3523a(final GraphQLPhoto graphQLPhoto, final FullscreenGallerySource fullscreenGallerySource) {
        MediaGalleryLauncherParams.Builder b;
        Uri a;
        if (graphQLPhoto.k() == null) {
            b = MediaGalleryLauncherParamsFactory.b(ImmutableList.of(graphQLPhoto));
        } else {
            b = MediaGalleryLauncherParamsFactory.a(graphQLPhoto.k());
        }
        b.a(fullscreenGallerySource).a(graphQLPhoto.K()).m = true;
        if (graphQLPhoto.P() != null) {
            a = ImageUtil.a(graphQLPhoto.P());
        } else if (graphQLPhoto.N() != null) {
            a = ImageUtil.a(graphQLPhoto.N());
        } else {
            a = ImageUtil.a(graphQLPhoto.L());
        }
        final ImageRequest a2 = ImageRequest.a(a);
        b.a(a2);
        this.f2585n.a(getContext(), b.b(), new AnimationParamProvider(this) {
            final /* synthetic */ CaspianPagesHeaderView f2567d;

            public final AnimationParams m3507a(String str) {
                if (!Objects.equal(str, graphQLPhoto.K())) {
                    return null;
                }
                DraweeView draweeView;
                if (fullscreenGallerySource == FullscreenGallerySource.PAGE_COVER_PHOTO) {
                    draweeView = this.f2567d.g;
                } else {
                    draweeView = this.f2567d.j.b;
                }
                return new AnimationParams(DrawingRule.a(draweeView), a2);
            }
        });
    }

    public final boolean m3550a() {
        return this.f2593x.f2632b;
    }

    public static ProfileVideoController getProfileVideoController(CaspianPagesHeaderView caspianPagesHeaderView) {
        if (caspianPagesHeaderView.f2576B == null) {
            caspianPagesHeaderView.f2578D = new C03457(caspianPagesHeaderView);
            caspianPagesHeaderView.f2576B = caspianPagesHeaderView.f2590s.a(caspianPagesHeaderView.getContext(), caspianPagesHeaderView, true, caspianPagesHeaderView.f2595z, caspianPagesHeaderView.f2578D);
        }
        return caspianPagesHeaderView.f2576B;
    }

    private OnClickListener getProfileVideoClickListener() {
        if (this.f2577C == null) {
            this.f2577C = new C03468(this);
        }
        return this.f2577C;
    }

    private void m3524a(PageScopedEventBus pageScopedEventBus, SecureContextHelper secureContextHelper, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory, MediaGalleryLauncher mediaGalleryLauncher, PagesAnalytics pagesAnalytics, PagesExperimentUtils pagesExperimentUtils, StandardProfileImageViewBinder standardProfileImageViewBinder, CaspianPagesHeaderViewControllerProvider caspianPagesHeaderViewControllerProvider, ProfileVideoControllerProvider profileVideoControllerProvider) {
        this.f2582k = pageScopedEventBus;
        this.f2583l = secureContextHelper;
        this.f2584m = mediaGalleryLauncherParamsFactory;
        this.f2585n = mediaGalleryLauncher;
        this.f2586o = pagesAnalytics;
        this.f2587p = pagesExperimentUtils;
        this.f2588q = standardProfileImageViewBinder;
        this.f2589r = caspianPagesHeaderViewControllerProvider;
        this.f2590s = profileVideoControllerProvider;
    }

    public final boolean m3553h() {
        return getProfileVideoController(this).b();
    }
}
