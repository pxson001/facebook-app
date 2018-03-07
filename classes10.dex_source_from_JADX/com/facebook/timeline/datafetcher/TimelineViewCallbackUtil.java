package com.facebook.timeline.datafetcher;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitor;
import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitorProvider;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher.ViewCallback;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParamsHelper;
import com.facebook.timeline.protocol.ResultSource;
import com.facebook.timeline.stories.TimelineInfiniteScrollController;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.timeline.units.model.TimelineSectionData;
import com.facebook.timeline.units.model.TimelineSectionData.LoadingIndicator;
import com.facebook.timeline.units.model.TimelineSectionData.Placeholder;
import com.facebook.timeline.units.model.TimelineSectionData.ScrollLoadTrigger;
import com.facebook.timeline.units.model.TimelineSectionData.SeeMore;
import com.facebook.timeline.units.model.TimelineSectionLoadState;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: graphql_query_hashes */
public class TimelineViewCallbackUtil {
    public final TimelineContext f10680a;
    public final ViewCallback f10681b;
    public final TimelineAllSectionsData f10682c;
    private final AbstractFbErrorReporter f10683d;
    public final VideoPrefetchVisitorProvider f10684e;
    @Nullable
    public VideoPrefetchVisitor f10685f;

    public TimelineViewCallbackUtil(TimelineContext timelineContext, ViewCallback viewCallback, TimelineAllSectionsData timelineAllSectionsData, AbstractFbErrorReporter abstractFbErrorReporter, VideoPrefetchVisitorProvider videoPrefetchVisitorProvider) {
        this.f10680a = timelineContext;
        this.f10681b = viewCallback;
        this.f10682c = timelineAllSectionsData;
        this.f10683d = abstractFbErrorReporter;
        this.f10684e = videoPrefetchVisitorProvider;
    }

    public final void m10741a(TimelineSectionFetchParams timelineSectionFetchParams) {
        this.f10682c.m12719a(timelineSectionFetchParams, TimelineSectionLoadState.LOADING);
        this.f10681b.mo508a(timelineSectionFetchParams);
        this.f10681b.aC();
    }

    public final void m10740a(GraphQLTimelineSection graphQLTimelineSection, TimelineSectionFetchParams timelineSectionFetchParams, DataFreshnessResult dataFreshnessResult, ResultSource resultSource, long j) {
        if (!this.f10682c.f12765d.isEmpty()) {
            TimelineSectionData a = this.f10682c.m12714a(graphQLTimelineSection.j());
            if (a == null) {
                this.f10683d.a("timeline_unknown_section_id", StringFormatUtil.formatStrLocaleSafe("onSectionUnitsLoaded: Expected ID %s to be in section list %s", graphQLTimelineSection.j(), this.f10682c.m12727e()));
                return;
            }
            this.f10682c.m12719a(timelineSectionFetchParams, TimelineSectionLoadState.COMPLETED);
            boolean a2 = m10738a(graphQLTimelineSection);
            Optional a3 = m10737a(timelineSectionFetchParams, a2, graphQLTimelineSection, a, dataFreshnessResult);
            if (a3.isPresent()) {
                a.m12751b((Placeholder) a3.get());
            }
            this.f10682c.m12722a(this.f10682c.m12726d(graphQLTimelineSection.j()), m10736a(graphQLTimelineSection, a2));
            if (m10739a(a)) {
                this.f10682c.m12728e(graphQLTimelineSection.j());
            }
            this.f10681b.mo509a(timelineSectionFetchParams, dataFreshnessResult, resultSource, j);
            if (graphQLTimelineSection.l() == null || graphQLTimelineSection.l().a() == null || graphQLTimelineSection.l().a().isEmpty()) {
                this.f10681b.mX_();
            }
        }
    }

    private boolean m10739a(TimelineSectionData timelineSectionData) {
        return TimelineInfiniteScrollController.m12681a(this.f10680a) && timelineSectionData.f12792e == 0;
    }

    private static boolean m10738a(GraphQLTimelineSection graphQLTimelineSection) {
        if (graphQLTimelineSection == null || graphQLTimelineSection.l() == null || graphQLTimelineSection.l().j() == null || !graphQLTimelineSection.l().j().b() || graphQLTimelineSection.l().j().a() == null) {
            return false;
        }
        return true;
    }

    private Optional<? extends Placeholder> m10737a(TimelineSectionFetchParams timelineSectionFetchParams, boolean z, GraphQLTimelineSection graphQLTimelineSection, TimelineSectionData timelineSectionData, DataFreshnessResult dataFreshnessResult) {
        Preconditions.checkNotNull(graphQLTimelineSection, "SectionResult should not be absent unless server side error.");
        if (!z) {
            return Absent.INSTANCE;
        }
        boolean z2;
        int i = timelineSectionFetchParams.f10706j;
        Object obj = null;
        if (timelineSectionData != null) {
            z2 = timelineSectionData.f12796i;
        } else {
            z2 = false;
        }
        boolean a = TimelineInfiniteScrollController.m12681a(this.f10680a);
        if (z2 || (i <= 0 && this.f10680a.c() && !a)) {
            obj = 1;
        }
        if (obj != null) {
            timelineSectionData.f12796i = false;
            return Optional.of(new SeeMore(graphQLTimelineSection.j(), graphQLTimelineSection.l().j().a()));
        } else if (dataFreshnessResult == DataFreshnessResult.FROM_SERVER) {
            return Optional.of(new ScrollLoadTrigger(graphQLTimelineSection.j(), graphQLTimelineSection.l().j().a(), timelineSectionFetchParams.f10706j));
        } else {
            return Optional.of(new LoadingIndicator(timelineSectionFetchParams));
        }
    }

    private Optional<? extends ScrollLoadTrigger> m10736a(GraphQLTimelineSection graphQLTimelineSection, boolean z) {
        if (z) {
            return Absent.INSTANCE;
        }
        String d = this.f10682c.m12726d(graphQLTimelineSection.j());
        if (d != null) {
            TimelineSectionData a = this.f10682c.m12714a(d);
            if (a == null) {
                this.f10683d.b("timeline_next_section_not_found", StringFormatUtil.formatStrLocaleSafe("getScrollLoadTrigger: Expected ID %s to be in section list %s", d, this.f10682c.m12727e()));
                return Absent.INSTANCE;
            } else if (!(!TimelineInfiniteScrollController.m12681a(this.f10680a) || a.f12795h || a.f12794g)) {
                a.f12797j = true;
                ScrollLoadTrigger scrollLoadTrigger = new ScrollLoadTrigger(d, null, 0);
                a.m12746a(TimelineSectionLoadState.LOADING, TimelineSectionFetchParamsHelper.m10748a(scrollLoadTrigger));
                return Optional.of(scrollLoadTrigger);
            }
        }
        return Absent.INSTANCE;
    }
}
