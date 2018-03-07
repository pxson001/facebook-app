package com.facebook.pages.common.surface.ui.header;

import android.graphics.drawable.Animatable;
import android.os.ParcelUuid;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent.HeaderPerfLoggingEventType;
import com.facebook.pages.common.sequencelogger.PageHeaderSequenceLoggerHelper;
import com.facebook.pages.common.sequencelogger.PagesManagerStartupSequencesHelper;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.ProfilePicContentState;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.ProfilePicState;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: region_zoom */
public class CaspianPagesHeaderViewPerfLoggingImpl implements CaspianPagesHeaderViewPerfLogging {
    public static final Optional<DataFreshnessResult> f2641a = Optional.of(DataFreshnessResult.NO_DATA);
    public final PageHeaderSequenceLoggerHelper f2642b;
    private final QuickPerformanceLogger f2643c;
    private final PagesManagerStartupSequencesHelper f2644d;
    private final PageScopedEventBus f2645e;
    private final Lazy<FbErrorReporter> f2646f;
    private ParcelUuid f2647g;
    public String f2648h;
    public boolean f2649i;
    private final ProfilePhotoControllerListener f2650j = new ProfilePhotoControllerListener(this);
    public boolean f2651k;
    private final CoverPhotoControllerListener f2652l = new CoverPhotoControllerListener(this);

    /* compiled from: region_zoom */
    class CoverPhotoControllerListener extends BaseControllerListener {
        final /* synthetic */ CaspianPagesHeaderViewPerfLoggingImpl f2639a;

        public CoverPhotoControllerListener(CaspianPagesHeaderViewPerfLoggingImpl caspianPagesHeaderViewPerfLoggingImpl) {
            this.f2639a = caspianPagesHeaderViewPerfLoggingImpl;
        }

        public final void m3587a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f2639a.f2642b.d("CoverPhotoLoad", this.f2639a.f2648h, null);
            this.f2639a.f2642b.d("TimeToCoverPhotoComplete", this.f2639a.f2648h, null);
            this.f2639a.m3603b((Optional) Absent.INSTANCE);
        }

        public final void m3586a(String str, Object obj) {
            this.f2639a.f2642b.d("TimeToCoverPhotoOnSubmit", this.f2639a.f2648h, null);
            if (!this.f2639a.f2651k) {
                this.f2639a.f2642b.b("CoverPhotoLoad", this.f2639a.f2648h, null);
            }
        }

        public final void m3589b(String str, Throwable th) {
            this.f2639a.f2642b.b("CoverPhotoLoad", this.f2639a.f2648h);
            this.f2639a.m3603b((Optional) Absent.INSTANCE);
        }
    }

    /* compiled from: region_zoom */
    class ProfilePhotoControllerListener extends BaseControllerListener {
        final /* synthetic */ CaspianPagesHeaderViewPerfLoggingImpl f2640a;

        public ProfilePhotoControllerListener(CaspianPagesHeaderViewPerfLoggingImpl caspianPagesHeaderViewPerfLoggingImpl) {
            this.f2640a = caspianPagesHeaderViewPerfLoggingImpl;
        }

        public final void m3591a(String str, Object obj) {
            this.f2640a.f2642b.d("TimeToProfilePicOnSubmit", this.f2640a.f2648h, null);
            if (!this.f2640a.f2649i) {
                this.f2640a.f2642b.b("ProfilePhotoLoad", this.f2640a.f2648h, null);
            }
        }

        public final void m3592a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            m3590d();
        }

        public final void m3593b(String str, @Nullable Object obj) {
            m3590d();
        }

        public final void m3594b(String str, Throwable th) {
            this.f2640a.f2642b.b("ProfilePhotoLoad", this.f2640a.f2648h);
            this.f2640a.m3598a(CaspianPagesHeaderViewPerfLoggingImpl.f2641a);
        }

        private void m3590d() {
            this.f2640a.f2642b.d("ProfilePhotoLoad", this.f2640a.f2648h, null);
            this.f2640a.f2642b.d("TimeToProfilePhotoComplete", this.f2640a.f2648h, null);
            this.f2640a.m3598a((Optional) Absent.INSTANCE);
        }
    }

    public static CaspianPagesHeaderViewPerfLoggingImpl m3600b(InjectorLike injectorLike) {
        return new CaspianPagesHeaderViewPerfLoggingImpl(PageHeaderSequenceLoggerHelper.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), PagesManagerStartupSequencesHelper.a(injectorLike), PageScopedEventBus.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    public static CaspianPagesHeaderViewPerfLoggingImpl m3595a(InjectorLike injectorLike) {
        return m3600b(injectorLike);
    }

    @Inject
    public CaspianPagesHeaderViewPerfLoggingImpl(PageHeaderSequenceLoggerHelper pageHeaderSequenceLoggerHelper, QuickPerformanceLogger quickPerformanceLogger, PagesManagerStartupSequencesHelper pagesManagerStartupSequencesHelper, PageScopedEventBus pageScopedEventBus, Lazy<FbErrorReporter> lazy) {
        this.f2642b = pageHeaderSequenceLoggerHelper;
        this.f2643c = quickPerformanceLogger;
        this.f2644d = pagesManagerStartupSequencesHelper;
        this.f2645e = pageScopedEventBus;
        this.f2646f = lazy;
    }

    public final void mo67a(ParcelUuid parcelUuid) {
        this.f2647g = parcelUuid;
        if (this.f2647g == null) {
            ((AbstractFbErrorReporter) this.f2646f.get()).b(getClass().getName(), "UUID in context header view is null");
        } else {
            this.f2648h = this.f2647g.toString();
        }
    }

    public final void mo68a(PageHeaderData pageHeaderData, BindModel bindModel) {
        m3602b(pageHeaderData, bindModel);
        m3604c(pageHeaderData, bindModel);
    }

    public final BaseControllerListener mo66a() {
        return this.f2650j;
    }

    public final void mo69a(boolean z) {
        if (z) {
            m3603b(f2641a);
        }
    }

    public final BaseControllerListener mo70b() {
        return this.f2652l;
    }

    public final void mo71c() {
        this.f2643c.a(1245307, (short) 91);
        this.f2643c.a(1245312, (short) 91);
        this.f2642b.d("TimeToCoverPhotoMinipreview", this.f2648h, null);
        m3603b(f2641a);
    }

    private void m3602b(PageHeaderData pageHeaderData, BindModel bindModel) {
        if (bindModel.f2637g.f2626a == ProfilePicState.NOT_VISIBLE) {
            m3598a(f2641a);
            return;
        }
        if (!(!StringUtil.a(bindModel.f2637g.f2629d) || pageHeaderData.e.M() == null || pageHeaderData.e.M().m() == null)) {
            this.f2642b.e(this.f2648h, "TinyResProfilePic", null);
            this.f2643c.a(1245285, "tiny_profile_pic");
        }
        if (bindModel.f2637g.f2628c == ProfilePicContentState.NO_DATA && bindModel.f2634d) {
            m3598a(f2641a);
        } else if (bindModel.f2637g.f2628c == ProfilePicContentState.HAS_DATA && m3608e()) {
            this.f2644d.a("ProfilePhotoDownloaded");
            this.f2642b.a("ProfilePhotoDownloaded", this.f2648h, null);
            this.f2643c.f(1245285, 1245306);
        }
    }

    private void m3604c(PageHeaderData pageHeaderData, BindModel bindModel) {
        if (!pageHeaderData.e.y() && bindModel.f2634d) {
            m3603b(f2641a);
        } else if (!StringUtil.a(bindModel.f2633c.f2618a)) {
            if (pageHeaderData.e.u().j().n() == null) {
                this.f2642b.e(this.f2648h, "NoPreview", null);
            }
            if (m3609f()) {
                this.f2644d.a("CoverPhotoDownloaded");
                this.f2642b.a("CoverPhotoDownloaded", this.f2648h, null);
                this.f2643c.f(1245307, 1245306);
            }
        } else if (bindModel.f2634d) {
            m3603b(f2641a);
        }
    }

    private boolean m3608e() {
        return (this.f2649i || this.f2642b.c("ProfilePhotoDownloaded", this.f2648h)) ? false : true;
    }

    private boolean m3609f() {
        return (this.f2651k || this.f2642b.c("CoverPhotoDownloaded", this.f2648h)) ? false : true;
    }

    private void m3598a(Optional<DataFreshnessResult> optional) {
        if (!this.f2649i) {
            this.f2642b.d("ProfilePhotoDownloaded", this.f2648h, null);
            this.f2644d.c("ProfilePhotoDownloaded");
            this.f2642b.b("TimeToProfilePicOnSubmit", this.f2648h);
            this.f2649i = true;
            this.f2645e.a(new PageFragmentScopedHeaderPerfLoggingEvent(this.f2647g, HeaderPerfLoggingEventType.PROFILE_PHOTO_COMPLETE, optional));
            this.f2643c.b(1245285, (short) 2);
            this.f2643c.a(1245312, (short) 90);
        }
    }

    private void m3603b(Optional<DataFreshnessResult> optional) {
        if (!this.f2651k) {
            this.f2642b.d("CoverPhotoDownloaded", this.f2648h, null);
            this.f2644d.c("CoverPhotoDownloaded");
            this.f2651k = true;
            this.f2642b.b("TimeToCoverPhotoOnSubmit", this.f2648h);
            this.f2645e.a(new PageFragmentScopedHeaderPerfLoggingEvent(this.f2647g, HeaderPerfLoggingEventType.COVER_PHOTO_COMPLETE, optional));
            this.f2643c.b(1245307, (short) 2);
        }
    }
}
