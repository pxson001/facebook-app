package com.facebook.timeline.header;

import com.facebook.common.time.Clock;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.feed.logging.FeedLoggingUtil;
import com.facebook.feed.photos.FeedUnitImagesStateMapper;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.viewstate.UnseenStoryManager;
import com.facebook.feed.viewstate.UnseenStoryManager.1;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.RelationshipType;
import com.facebook.timeline.listview.TimelineAdapter;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.util.ProtilesLoggingUtil;
import com.facebook.timeline.protiles.util.TimelineCollapsedProtilesExperimentHelper;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.timeline.units.model.TimelineSectionData;
import com.facebook.timeline.units.model.TimelineSectionData.TimelineSectionLabel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.inject.Inject;

/* compiled from: fragment passed is null */
public class TimelineLoggingViewportListener extends BaseViewportEventListener {
    private boolean f11528a = false;
    public FeedProps<GraphQLStory> f11529b;
    private final long f11530c;
    private final TimelineAdapter f11531d;
    private final TimelineAnalyticsLogger f11532e;
    public final UnseenStoryManager f11533f;
    private final TimelineAllSectionsData f11534g;
    private final Clock f11535h;
    private final FeedLoggingUtil f11536i;
    private final FeedUnitImagesStateMapper f11537j;
    public final TimelineCollapsedProtilesExperimentHelper f11538k;
    public RelationshipType f11539l = RelationshipType.UNKNOWN_RELATIONSHIP;

    @Inject
    public TimelineLoggingViewportListener(@Assisted Long l, @Assisted TimelineAdapter timelineAdapter, @Assisted TimelineAllSectionsData timelineAllSectionsData, TimelineAnalyticsLogger timelineAnalyticsLogger, UnseenStoryManager unseenStoryManager, Clock clock, FeedLoggingUtil feedLoggingUtil, FeedUnitImagesStateMapper feedUnitImagesStateMapper, TimelineCollapsedProtilesExperimentHelper timelineCollapsedProtilesExperimentHelper) {
        this.f11530c = l.longValue();
        this.f11531d = timelineAdapter;
        this.f11532e = timelineAnalyticsLogger;
        this.f11534g = timelineAllSectionsData;
        this.f11533f = unseenStoryManager;
        this.f11535h = clock;
        this.f11536i = feedLoggingUtil;
        this.f11537j = feedUnitImagesStateMapper;
        this.f11538k = timelineCollapsedProtilesExperimentHelper;
    }

    public final void m11572a(ScrollingViewProxy scrollingViewProxy, Object obj, int i) {
        if (m11571c(obj)) {
            m11570a(scrollingViewProxy, (ProtileModel) ((BoundedAdapter) obj).a.b, i);
        }
    }

    private static boolean m11571c(Object obj) {
        return (obj instanceof BoundedAdapter) && (((BoundedAdapter) obj).a.b instanceof ProtileModel);
    }

    private void m11570a(ScrollingViewProxy scrollingViewProxy, ProtileModel protileModel, int i) {
        if (scrollingViewProxy.C()) {
            m11568a(protileModel, this.f11536i.a(this.f11531d, scrollingViewProxy, scrollingViewProxy.f(i)));
        }
    }

    public final void m11573a(Object obj) {
        Object obj2;
        if (obj instanceof BoundedAdapter) {
            obj = (BoundedAdapter) obj;
            obj2 = obj.a.b;
        } else {
            obj2 = obj;
            obj = null;
        }
        if (obj2 instanceof GraphQLStory) {
            if (obj != null && obj.b == 0) {
                FeedProps c = FeedProps.c((GraphQLStory) obj2);
                if (this.f11529b != null) {
                    UnseenStoryManager unseenStoryManager = this.f11533f;
                    FeedProps feedProps = this.f11529b;
                    if (((GraphQLStory) feedProps.a).au() == GraphQLStorySeenState.UNSEEN_AND_UNREAD) {
                        HandlerDetour.b(unseenStoryManager.c, new 1(unseenStoryManager, feedProps), 5000, -1474942295);
                    }
                }
                this.f11529b = c;
            }
        } else if (obj2 instanceof TimelineSectionLabel) {
            m11569a((TimelineSectionLabel) obj2);
        }
    }

    public final void m11574b(Object obj) {
        Object obj2;
        if (obj instanceof BoundedAdapter) {
            obj = (BoundedAdapter) obj;
            obj2 = obj.a.b;
        } else {
            obj2 = obj;
            obj = null;
        }
        if ((obj2 instanceof GraphQLStory) && r5 != null && r5.b == 0) {
            this.f11529b = null;
        }
        if (obj2 instanceof ProtileModel) {
            m11568a((ProtileModel) obj2, false);
        }
    }

    private void m11569a(TimelineSectionLabel timelineSectionLabel) {
        if (!this.f11528a) {
            boolean z;
            TimelineAllSectionsData timelineAllSectionsData = this.f11534g;
            String str = timelineSectionLabel.f12781a;
            if (timelineAllSectionsData.f12765d.isEmpty()) {
                z = false;
            } else {
                z = ((TimelineSectionData) timelineAllSectionsData.f12765d.get(timelineAllSectionsData.f12765d.size() - 1)).f12793f.equals(str);
            }
            if (z) {
                this.f11528a = true;
                this.f11532e.b(this.f11530c, this.f11539l);
            }
        }
    }

    private void m11568a(ProtileModel protileModel, boolean z) {
        if (z && !protileModel.f12110f) {
            protileModel.f12109e = this.f11535h.a();
        } else if (!z && protileModel.f12110f) {
            m11567a(protileModel);
        }
        protileModel.f12110f = z;
    }

    private void m11567a(ProtileModel protileModel) {
        long a = this.f11535h.a() - protileModel.f12109e;
        if (a >= 100 && !this.f11538k.m12445c(protileModel)) {
            this.f11532e.a(this.f11530c, this.f11539l, protileModel.m12109b(), ProtilesLoggingUtil.m12433a(protileModel), ProtilesLoggingUtil.m12434b(protileModel), a, this.f11537j.a(protileModel.f12105a));
        }
    }
}
