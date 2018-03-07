package com.facebook.timeline.header.controllers;

import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.header.TimelineIntroCardAdapter.CollapseState;
import com.facebook.timeline.header.bio.IntroCardSuggestedBioExperimentController;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.favphotos.IntroCardSuggestedPhotosExperimentController;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderProfileIntroCardFieldsModel;
import com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import javax.inject.Inject;

/* compiled from: first_party_bootstrap_js */
public class TimelineHeaderViewController {
    public final QeAccessor f11641a;
    public final FavPhotosVsFeaturedContainersController f11642b;
    private final IntroCardSuggestedPhotosExperimentController f11643c;
    private final IntroCardSuggestedBioExperimentController f11644d;

    /* compiled from: first_party_bootstrap_js */
    public enum IntroViewType {
        EMPTY,
        CONTENT,
        SUGGESTED_CONTENT,
        NONE
    }

    public static TimelineHeaderViewController m11687b(InjectorLike injectorLike) {
        return new TimelineHeaderViewController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FavPhotosVsFeaturedContainersController.m12774a(injectorLike), IntroCardSuggestedPhotosExperimentController.m11801a(injectorLike), IntroCardSuggestedBioExperimentController.m11605a(injectorLike), FeaturedContainersHeaderData.m12779a(injectorLike));
    }

    public static TimelineHeaderViewController m11686a(InjectorLike injectorLike) {
        return m11687b(injectorLike);
    }

    @Inject
    public TimelineHeaderViewController(QeAccessor qeAccessor, FavPhotosVsFeaturedContainersController favPhotosVsFeaturedContainersController, IntroCardSuggestedPhotosExperimentController introCardSuggestedPhotosExperimentController, IntroCardSuggestedBioExperimentController introCardSuggestedBioExperimentController, FeaturedContainersHeaderData featuredContainersHeaderData) {
        this.f11641a = qeAccessor;
        this.f11642b = favPhotosVsFeaturedContainersController;
        this.f11643c = introCardSuggestedPhotosExperimentController;
        this.f11644d = introCardSuggestedBioExperimentController;
    }

    public final IntroViewType m11691a(TimelineHeaderUserData timelineHeaderUserData, TimelineContext timelineContext, boolean z) {
        if (timelineHeaderUserData.j() || !this.f11641a.a(ExperimentsForTimelineAbTestModule.X, false)) {
            return IntroViewType.NONE;
        }
        if (timelineHeaderUserData.W()) {
            return IntroViewType.CONTENT;
        }
        if (!z || !timelineContext.i()) {
            return IntroViewType.NONE;
        }
        if (this.f11644d.mo533e()) {
            Object obj;
            if (timelineHeaderUserData.b == null || timelineHeaderUserData.b.l() == null || StringUtil.a(timelineHeaderUserData.b.l().a())) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                return IntroViewType.SUGGESTED_CONTENT;
            }
        }
        return IntroViewType.EMPTY;
    }

    public final IntroViewType m11690a(TimelineHeaderUserData timelineHeaderUserData, TimelineContext timelineContext, CollapseState collapseState) {
        boolean b = this.f11642b.m12777b();
        Object obj = null;
        if (timelineHeaderUserData.j() || !this.f11642b.m12776a()) {
            obj = 1;
        } else if (collapseState != CollapseState.EXPANDED && (timelineHeaderUserData.W() || timelineHeaderUserData.Y())) {
            int i = 1;
        }
        if (obj != null) {
            return IntroViewType.NONE;
        }
        if (!timelineHeaderUserData.Z().isEmpty()) {
            return IntroViewType.CONTENT;
        }
        if (!b || !timelineContext.i()) {
            return IntroViewType.NONE;
        }
        if (this.f11643c.mo533e() && timelineHeaderUserData.aa()) {
            return IntroViewType.SUGGESTED_CONTENT;
        }
        return IntroViewType.EMPTY;
    }

    public final IntroViewType m11693b(TimelineHeaderUserData timelineHeaderUserData, TimelineContext timelineContext, CollapseState collapseState) {
        boolean a = this.f11641a.a(ExperimentsForTimelineAbTestModule.F, false);
        boolean z = false;
        if (timelineHeaderUserData.j() || !this.f11641a.a(ExperimentsForTimelineAbTestModule.J, false)) {
            z = true;
        } else if (collapseState != CollapseState.EXPANDED && (timelineHeaderUserData.W() || timelineHeaderUserData.Y())) {
            z = true;
        }
        if (z) {
            return IntroViewType.NONE;
        }
        if (!timelineHeaderUserData.ac().isEmpty()) {
            return IntroViewType.CONTENT;
        }
        if (a && timelineContext.i()) {
            return IntroViewType.EMPTY;
        }
        return IntroViewType.NONE;
    }

    public static int m11684a(CollapseState collapseState, TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, FeaturedContainersHeaderData featuredContainersHeaderData, int i) {
        if (collapseState == CollapseState.COLLAPSED && timelineHeaderUserData.W() && !timelineHeaderUserData.Y() && m11688b(timelineContext, timelineHeaderUserData, featuredContainersHeaderData)) {
            return 3;
        }
        if (collapseState != CollapseState.COLLAPSED || timelineHeaderUserData.W() || i > 2 || !m11688b(timelineContext, timelineHeaderUserData, featuredContainersHeaderData)) {
            return collapseState == CollapseState.COLLAPSED ? 1 : 2;
        } else {
            return 3;
        }
    }

    public final boolean m11692a(TimelineContext timelineContext) {
        return timelineContext.i() && this.f11641a.a(ExperimentsForTimelineAbTestModule.Z, false);
    }

    public static int m11685a(TimelineHeaderProfileIntroCardFieldsModel timelineHeaderProfileIntroCardFieldsModel) {
        if (timelineHeaderProfileIntroCardFieldsModel == null || timelineHeaderProfileIntroCardFieldsModel.g() == null) {
            return 0;
        }
        return timelineHeaderProfileIntroCardFieldsModel.g().a().size();
    }

    public static boolean m11688b(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, FeaturedContainersHeaderData featuredContainersHeaderData) {
        return (!timelineContext.i() && timelineHeaderUserData.Z().isEmpty() && timelineHeaderUserData.ac().isEmpty() && featuredContainersHeaderData.f12836b.isEmpty()) ? false : true;
    }

    public static boolean m11689b(TimelineHeaderUserData timelineHeaderUserData) {
        return timelineHeaderUserData.b != null && timelineHeaderUserData.b.c();
    }
}
