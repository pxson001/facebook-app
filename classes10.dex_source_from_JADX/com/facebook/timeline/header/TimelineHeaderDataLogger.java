package com.facebook.timeline.header;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.time.Clock;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.enums.GraphQLTimelineContextListItemType;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.RelationshipType;
import com.facebook.timeline.contextual.TimelineContextItemsData;
import com.facebook.timeline.contextual.TimelineContextualInfoData;
import com.facebook.timeline.data.TimelineHeaderRenderState;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.favphotos.IntroCardSuggestedPhotosExperimentController;
import com.facebook.timeline.header.favphotos.TimelineHeaderSuggestedPhotosView;
import com.facebook.timeline.header.ui.LoadMoreItemsView;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Sets;
import java.util.HashSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friends_center_opened */
public class TimelineHeaderDataLogger {
    private final HashSet<GraphQLTimelineContextListItemType> f11366a = Sets.a();
    public final String f11367b;
    public final long f11368c;
    private final TimelineHeaderUserData f11369d;
    public final TimelineAnalyticsLogger f11370e;
    private final TimelineHeaderRenderState f11371f;
    private final ScreenUtil f11372g;
    private final Clock f11373h;
    private final IntroCardSuggestedPhotosExperimentController f11374i;
    public RelationshipType f11375j = RelationshipType.UNKNOWN_RELATIONSHIP;
    public boolean f11376k;
    public boolean f11377l = false;
    public boolean f11378m;
    public boolean f11379n;
    private boolean f11380o = false;
    private boolean f11381p = false;
    public boolean f11382q;
    private boolean f11383r = false;
    private boolean f11384s = false;
    private boolean f11385t = false;
    public boolean f11386u = false;
    public boolean f11387v = false;
    public boolean f11388w = false;
    private boolean f11389x = false;
    private boolean f11390y = false;
    private long f11391z = 0;

    @Inject
    public TimelineHeaderDataLogger(@Assisted String str, @Assisted Long l, @Assisted TimelineHeaderUserData timelineHeaderUserData, TimelineAnalyticsLogger timelineAnalyticsLogger, TimelineHeaderRenderState timelineHeaderRenderState, ScreenUtil screenUtil, Clock clock, IntroCardSuggestedPhotosExperimentController introCardSuggestedPhotosExperimentController) {
        this.f11367b = str;
        this.f11368c = l.longValue();
        this.f11369d = timelineHeaderUserData;
        this.f11370e = timelineAnalyticsLogger;
        this.f11371f = timelineHeaderRenderState;
        this.f11372g = screenUtil;
        this.f11373h = clock;
        this.f11374i = introCardSuggestedPhotosExperimentController;
    }

    public final void m11442a(boolean z) {
        if (z && !this.f11390y) {
            m11439a();
        } else if (!z && this.f11390y) {
            m11438j();
        }
    }

    public final void m11439a() {
        this.f11390y = true;
        this.f11391z = this.f11373h.a();
    }

    private void m11438j() {
        this.f11390y = false;
        long a = this.f11373h.a() - this.f11391z;
        if (a >= 100) {
            m11431a(a);
        }
    }

    public final void m11441a(UserTimelineHeaderView userTimelineHeaderView) {
        if (!this.f11380o) {
            this.f11380o = m11435a(userTimelineHeaderView.f11572i, userTimelineHeaderView.f11581r, false);
        }
    }

    public final void m11440a(TimelineIntroCardView timelineIntroCardView) {
        if (!this.f11381p) {
            this.f11381p = m11435a(timelineIntroCardView.f11512g, timelineIntroCardView.getAboutItemsData(), true);
        }
        if (!this.f11384s) {
            m11437c(timelineIntroCardView.getFavPhotosEmptyView(), timelineIntroCardView.getHeaderData());
        }
        if (!this.f11383r) {
            m11436b(timelineIntroCardView.getFavPhotosView(), timelineIntroCardView.getHeaderData());
        }
        if (!this.f11385t) {
            m11432a(timelineIntroCardView.getSuggestedPhotosView(), timelineIntroCardView.getHeaderData());
        }
    }

    @VisibleForTesting
    private boolean m11435a(@Nullable ViewGroup viewGroup, @Nullable TimelineContextualInfoData timelineContextualInfoData, boolean z) {
        if (viewGroup == null || timelineContextualInfoData == null || !timelineContextualInfoData.a().isPresent()) {
            return true;
        }
        int size = ((TimelineContextItemsData) timelineContextualInfoData.a().get()).f10311a.size();
        int i = 0;
        boolean z2 = false;
        while (i < viewGroup.getChildCount() && i < size) {
            boolean z3;
            if ((viewGroup.getChildAt(i) instanceof LoadMoreItemsView) || !m11434a(viewGroup.getChildAt(i))) {
                z3 = z2;
            } else {
                m11433a((TimelineContextListItemFieldsModel) ((TimelineContextItemsData) timelineContextualInfoData.a().get()).f10311a.get(i), z);
                z3 = i == size + -1;
            }
            i++;
            z2 = z3;
        }
        if (size == 0) {
            return true;
        }
        if (i == size && z2) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    private void m11436b(@Nullable View view, @Nullable TimelineHeaderUserData timelineHeaderUserData) {
        if (timelineHeaderUserData != null && !timelineHeaderUserData.Z().isEmpty() && view != null && m11434a(view)) {
            this.f11383r = true;
            this.f11370e.e(this.f11368c, this.f11367b, this.f11375j);
        }
    }

    private void m11432a(@Nullable TimelineHeaderSuggestedPhotosView timelineHeaderSuggestedPhotosView, @Nullable TimelineHeaderUserData timelineHeaderUserData) {
        if (timelineHeaderUserData != null && timelineHeaderUserData.aa() && timelineHeaderSuggestedPhotosView != null && m11434a((View) timelineHeaderSuggestedPhotosView)) {
            this.f11385t = true;
            this.f11370e.a(this.f11368c, timelineHeaderUserData.ab().size(), this.f11367b, this.f11375j);
            this.f11374i.m11366f();
        }
    }

    private void m11437c(View view, TimelineHeaderUserData timelineHeaderUserData) {
        if (timelineHeaderUserData != null && !timelineHeaderUserData.aa() && timelineHeaderUserData.Z().isEmpty() && view != null && m11434a(view)) {
            this.f11384s = true;
            this.f11370e.i(this.f11368c, this.f11367b);
        }
    }

    private boolean m11434a(View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (iArr[1] <= 0 || iArr[1] >= this.f11372g.d()) {
            return false;
        }
        return true;
    }

    private void m11433a(TimelineContextListItemFieldsModel timelineContextListItemFieldsModel, boolean z) {
        GraphQLTimelineContextListItemType dr_ = timelineContextListItemFieldsModel.dr_();
        if (dr_ != null && dr_ != GraphQLTimelineContextListItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE && !this.f11366a.contains(dr_)) {
            this.f11366a.add(dr_);
            this.f11370e.a(this.f11368c, this.f11367b, this.f11375j, timelineContextListItemFieldsModel);
            if (z) {
                this.f11370e.b(this.f11368c, this.f11367b, this.f11375j, timelineContextListItemFieldsModel);
            }
        }
    }

    private void m11431a(long j) {
        this.f11370e.b(this.f11368c, this.f11367b, this.f11375j, this.f11369d.j, this.f11371f.e, j);
        this.f11370e.a(this.f11368c, this.f11367b, this.f11375j, this.f11369d.i, this.f11371f.d, j);
    }

    public final void m11443i() {
        if (!this.f11389x) {
            this.f11389x = true;
            this.f11370e.f(this.f11368c, this.f11367b, this.f11375j);
        }
    }
}
