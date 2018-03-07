package com.facebook.timeline.units.model;

import android.content.Context;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.feedcache.memory.pendingstory.PendingStoryCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.feed.viewstate.UnseenStoryManager;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Feedbackable;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.model.GraphQLUnseenStoriesConnection;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.facebook.timeline.model.TimelineStorySnapshot;
import com.facebook.timeline.units.TimelineUnitSubscriber;
import com.facebook.timeline.units.model.TimelineSectionData.LoadingIndicator;
import com.facebook.timeline.units.model.TimelineSectionData.Placeholder;
import com.facebook.timeline.units.model.TimelineSectionData.ScrollLoadTrigger;
import com.facebook.timeline.units.model.TimelineSectionData.SectionType;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: extra_instant_shopping_catalog_id */
public class TimelineAllSectionsData implements ListItemCollection<Object> {
    private static TimelineAllSectionsData f12760i;
    private static final Object f12761j = new Object();
    private final AbstractFbErrorReporter f12762a;
    private final UnseenStoryManager f12763b;
    public final MonotonicClock f12764c;
    public final List<TimelineSectionData> f12765d = new ArrayList();
    private final LoadingIndicator f12766e = new LoadingIndicator();
    public PendingStoryCache f12767f;
    public boolean f12768g = true;
    public TimelineUnitSubscriber f12769h = null;

    private static TimelineAllSectionsData m12708b(InjectorLike injectorLike) {
        return new TimelineAllSectionsData((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PendingStoryCache.b(injectorLike), UnseenStoryManager.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    public static TimelineAllSectionsData m12706a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineAllSectionsData b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12761j) {
                TimelineAllSectionsData timelineAllSectionsData;
                if (a2 != null) {
                    timelineAllSectionsData = (TimelineAllSectionsData) a2.a(f12761j);
                } else {
                    timelineAllSectionsData = f12760i;
                }
                if (timelineAllSectionsData == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12708b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12761j, b3);
                        } else {
                            f12760i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineAllSectionsData;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public TimelineAllSectionsData(AbstractFbErrorReporter abstractFbErrorReporter, PendingStoryCache pendingStoryCache, UnseenStoryManager unseenStoryManager, MonotonicClock monotonicClock) {
        this.f12762a = abstractFbErrorReporter;
        this.f12767f = pendingStoryCache;
        this.f12763b = unseenStoryManager;
        this.f12764c = monotonicClock;
    }

    public final void m12725a(boolean z) {
        if (this.f12765d.isEmpty() || ((TimelineSectionData) this.f12765d.get(0)).f12788a != SectionType.UNSEEN_SECTION) {
            this.f12765d.clear();
        } else {
            this.f12765d.subList(1, this.f12765d.size()).clear();
        }
        if (z) {
            this.f12767f.d();
            return;
        }
        this.f12767f.a(GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        this.f12767f.a(GraphQLFeedOptimisticPublishState.SUCCESS);
    }

    public final Object m12715a(int i) {
        int i2;
        if (!this.f12768g) {
            i2 = i;
        } else if (i == 0) {
            return this.f12766e;
        } else {
            i2 = i - 1;
        }
        int i3 = i2;
        for (TimelineSectionData timelineSectionData : this.f12765d) {
            if (i3 < timelineSectionData.m12748b()) {
                return timelineSectionData.m12743a(i3);
            }
            i3 -= timelineSectionData.m12748b();
        }
        throw new IllegalArgumentException("Invalid index:" + i);
    }

    public final Feedbackable m12712a(@Nullable String str, String str2) {
        GraphQLStory e = this.f12767f.e(str2);
        if (e != null) {
            return e;
        }
        for (TimelineSectionData b : this.f12765d) {
            Feedbackable b2 = b.m12749b(str, str2);
            if (b2 != null) {
                return b2;
            }
        }
        return null;
    }

    public final void m12717a(Feedbackable feedbackable, GraphQLFeedback graphQLFeedback) {
        if (feedbackable instanceof GraphQLStory) {
            Builder a = Builder.a((GraphQLStory) feedbackable);
            a.D = graphQLFeedback;
            a = a;
            a.F = System.currentTimeMillis();
            m12716a(a.a());
            return;
        }
        this.f12762a.b("timeline_story_update_fail", "Unable to update unit of type " + feedbackable.getClass().toString());
    }

    public final void m12716a(FeedUnit feedUnit) {
        if (feedUnit.g() == null && (feedUnit instanceof GraphQLStory) && ((GraphQLStory) feedUnit).ai() != null) {
            this.f12767f.a((GraphQLStory) feedUnit);
        }
        for (TimelineSectionData timelineSectionData : this.f12765d) {
            FetchTimeMsHelper.a(feedUnit, timelineSectionData.f12799l.now());
            int a = timelineSectionData.m12742a(feedUnit.g(), null);
            if (a != -1) {
                PropertyHelper.a(feedUnit, PropertyHelper.f((FeedUnit) timelineSectionData.f12791d.set(a, feedUnit)));
            }
        }
        if (this.f12769h != null && (feedUnit instanceof GraphQLStory) && ((GraphQLStory) feedUnit).c() != null) {
            this.f12769h.m12702a((GraphQLStory) feedUnit);
        }
    }

    public final int m12710a() {
        int i = 0;
        if (this.f12768g) {
            i = 1;
        }
        int i2 = i;
        for (TimelineSectionData b : this.f12765d) {
            i2 = b.m12748b() + i2;
        }
        return i2;
    }

    public final void m12720a(Placeholder placeholder) {
        for (TimelineSectionData timelineSectionData : this.f12765d) {
            timelineSectionData.f12791d.remove(placeholder);
        }
        m12709f();
    }

    private void m12709f() {
        int i = 0;
        for (TimelineSectionData it : this.f12765d) {
            Iterator it2 = it.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (next instanceof GraphQLStory) {
                    PropertyHelper.a((GraphQLStory) next, i);
                    i++;
                }
            }
        }
    }

    public final void m12724a(String str, String str2, String str3, StoryVisibility storyVisibility) {
        GraphQLStory graphQLStory = null;
        if (str3 != null) {
            graphQLStory = this.f12767f.f(str3);
            if (graphQLStory != null) {
                this.f12767f.a(str3, m12704a(graphQLStory, storyVisibility, graphQLStory.p()));
            }
        } else if (str2 != null) {
            graphQLStory = m12705a(str2, storyVisibility);
        }
        if (graphQLStory == null) {
            for (TimelineSectionData a : this.f12765d) {
                a.m12747a(str, str2, storyVisibility, -1);
            }
        }
    }

    @Nullable
    private GraphQLStory m12705a(String str, StoryVisibility storyVisibility) {
        GraphQLStory e = this.f12767f.e(str);
        if (e != null) {
            this.f12767f.a(m12704a(e, storyVisibility, e.p()));
        }
        return e;
    }

    public final void m12723a(String str, String str2, StoryVisibility storyVisibility, int i) {
        if (str == null && str2 != null) {
            m12705a(str2, storyVisibility);
        }
        for (TimelineSectionData a : this.f12765d) {
            a.m12747a(str, str2, storyVisibility, i);
        }
    }

    private GraphQLStory m12704a(GraphQLStory graphQLStory, StoryVisibility storyVisibility, int i) {
        return (GraphQLStory) FeedUnitMutator.a(graphQLStory).a(this.f12764c.now(), storyVisibility, i).a();
    }

    public final void m12718a(GraphQLUnseenStoriesConnection graphQLUnseenStoriesConnection, TimelineSectionLoadState timelineSectionLoadState) {
        if (graphQLUnseenStoriesConnection != null && graphQLUnseenStoriesConnection.a() != null && !graphQLUnseenStoriesConnection.a().isEmpty()) {
            Iterable timelineSectionData = new TimelineSectionData(SectionType.UNSEEN_SECTION.name(), null, SectionType.UNSEEN_SECTION, true, this.f12764c, null);
            this.f12765d.add(0, timelineSectionData);
            timelineSectionData.m12745a(graphQLUnseenStoriesConnection);
            timelineSectionData.m12746a(timelineSectionLoadState, null);
            m12709f();
            if (this.f12769h != null) {
                this.f12769h.m12703a(timelineSectionData);
            }
        }
    }

    @Nullable
    public final TimelineSectionData m12714a(String str) {
        if (str != null) {
            for (TimelineSectionData timelineSectionData : this.f12765d) {
                if (str.equals(timelineSectionData.f12793f)) {
                    return timelineSectionData;
                }
            }
        }
        return null;
    }

    public final int m12711a(GraphQLTimelineSection graphQLTimelineSection) {
        Iterable a = m12714a(graphQLTimelineSection.j());
        if (a == null) {
            return 0;
        }
        a.m12744a(graphQLTimelineSection);
        if (this.f12769h != null) {
            this.f12769h.m12703a(a);
        }
        m12709f();
        return graphQLTimelineSection.l().a().size();
    }

    public final void m12722a(String str, Optional<? extends ScrollLoadTrigger> optional) {
        if (optional.isPresent()) {
            TimelineSectionData a = m12714a(str);
            if (a != null) {
                a.m12751b((Placeholder) optional.get());
            }
        }
    }

    public final void m12721a(TimelineSectionLoadState timelineSectionLoadState) {
        this.f12766e.f12777b = timelineSectionLoadState;
    }

    public final void m12719a(TimelineSectionFetchParams timelineSectionFetchParams, TimelineSectionLoadState timelineSectionLoadState) {
        TimelineSectionData a;
        if (timelineSectionFetchParams.f10703g) {
            a = m12707a(SectionType.RECENT_SECTION);
            if (a != null) {
                m12721a(TimelineSectionLoadState.COMPLETED);
                a.m12746a(timelineSectionLoadState, timelineSectionFetchParams);
            } else {
                m12721a(timelineSectionLoadState);
            }
            a = m12707a(SectionType.UNSEEN_SECTION);
            if (a != null && timelineSectionLoadState == TimelineSectionLoadState.COMPLETED) {
                a.m12746a(timelineSectionLoadState, null);
                return;
            }
            return;
        }
        a = m12714a(timelineSectionFetchParams.f10699c);
        if (a != null) {
            a.m12746a(timelineSectionLoadState, timelineSectionFetchParams);
        }
    }

    public final String m12726d(String str) {
        Object obj = null;
        for (TimelineSectionData timelineSectionData : this.f12765d) {
            if (obj != null) {
                return timelineSectionData.f12793f;
            }
            Object obj2;
            if (timelineSectionData.f12793f.equals(str)) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
        return null;
    }

    public final void m12728e(String str) {
        TimelineSectionData a = m12714a(str);
        if (a != null) {
            a.f12798k = true;
        }
    }

    public final TimelineStorySnapshot m12713a(int i, int i2) {
        int i3 = 0;
        for (TimelineSectionData timelineSectionData : this.f12765d) {
            int b = timelineSectionData.m12748b() + i3;
            if (b >= i) {
                b = (i - i3) - 1;
                return new TimelineStorySnapshot(timelineSectionData.f12793f, b, timelineSectionData.m12750b(b), i2);
            }
            i3 = b;
        }
        return null;
    }

    @Nullable
    private TimelineSectionData m12707a(SectionType sectionType) {
        for (TimelineSectionData timelineSectionData : this.f12765d) {
            if (timelineSectionData.f12788a == sectionType) {
                return timelineSectionData;
            }
        }
        return null;
    }

    public final ImmutableList<String> m12727e() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (TimelineSectionData timelineSectionData : this.f12765d) {
            builder.c(timelineSectionData.f12793f);
        }
        return builder.b();
    }
}
