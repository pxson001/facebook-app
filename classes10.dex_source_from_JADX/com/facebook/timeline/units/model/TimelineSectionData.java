package com.facebook.timeline.units.model;

import com.facebook.api.feedcache.memory.pendingstory.PendingStoryCache;
import com.facebook.common.time.MonotonicClock;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Feedbackable;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.model.GraphQLTimelineSectionUnitsEdge;
import com.facebook.graphql.model.GraphQLUnseenStoriesConnection;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.graphql.parser.GraphQlIdParserUtil;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: extra_instant_articles_canonical_url */
public class TimelineSectionData implements Iterable {
    public SectionType f12788a;
    @Nullable
    private TimelinePostsLabel f12789b;
    @Nullable
    private final PendingStoryCache f12790c;
    public final List<Object> f12791d = new ArrayList();
    public int f12792e = 0;
    public final String f12793f;
    public boolean f12794g = false;
    public boolean f12795h = false;
    public boolean f12796i = false;
    public boolean f12797j = true;
    public boolean f12798k = false;
    public final MonotonicClock f12799l;

    /* compiled from: extra_instant_articles_canonical_url */
    public interface Placeholder {
    }

    /* compiled from: extra_instant_articles_canonical_url */
    public class LoadingIndicator implements Placeholder {
        public final TimelineSectionFetchParams f12776a;
        public TimelineSectionLoadState f12777b;

        public LoadingIndicator() {
            this(null);
        }

        public LoadingIndicator(@Nullable TimelineSectionFetchParams timelineSectionFetchParams) {
            this.f12777b = TimelineSectionLoadState.LOADING;
            this.f12776a = timelineSectionFetchParams;
        }

        public final boolean m12735a() {
            return this.f12777b == TimelineSectionLoadState.COMPLETED;
        }
    }

    /* compiled from: extra_instant_articles_canonical_url */
    public class NoStoriesMarker {
    }

    /* compiled from: extra_instant_articles_canonical_url */
    public class ScrollLoadTrigger implements Placeholder {
        public final String f12778a;
        public final String f12779b;
        public final int f12780c;

        public ScrollLoadTrigger(String str, String str2, int i) {
            this.f12778a = str;
            this.f12779b = str2;
            this.f12780c = i;
        }
    }

    /* compiled from: extra_instant_articles_canonical_url */
    public class Scrubber {
        public String f12781a;
        public String f12782b;
        public TimelineSectionLoadState f12783c = TimelineSectionLoadState.COMPLETED;

        public final boolean m12736a() {
            return this.f12783c == TimelineSectionLoadState.LOADING;
        }
    }

    /* compiled from: extra_instant_articles_canonical_url */
    public enum SectionType {
        UNSEEN_SECTION,
        RECENT_SECTION,
        YEAR_SECTION
    }

    /* compiled from: extra_instant_articles_canonical_url */
    public class SeeMore extends Scrubber implements Placeholder {
        public SeeMore(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    /* compiled from: extra_instant_articles_canonical_url */
    public class TimelinePostsLabel {
        public final SectionType f12784a;

        public TimelinePostsLabel(SectionType sectionType) {
            this.f12784a = sectionType;
        }

        public static TimelinePostsLabel m12737a() {
            return new TimelinePostsLabel(SectionType.RECENT_SECTION);
        }
    }

    /* compiled from: extra_instant_articles_canonical_url */
    public class TimelineSectionLabel extends Scrubber {
        public final String f12785c;
        public final LoadingIndicator f12786d;
        public boolean f12787e;

        public TimelineSectionLabel(String str, String str2, boolean z) {
            this.a = str;
            this.f12785c = str2;
            this.f12787e = z;
            this.f12786d = !z ? new LoadingIndicator() : null;
        }
    }

    public Iterator iterator() {
        return this.f12791d.iterator();
    }

    public TimelineSectionData(String str, String str2, SectionType sectionType, boolean z, MonotonicClock monotonicClock, @Nullable PendingStoryCache pendingStoryCache) {
        boolean z2 = false;
        this.f12793f = str;
        if (sectionType == SectionType.YEAR_SECTION) {
            this.f12791d.add(new TimelineSectionLabel(str, str2, !z));
        }
        this.f12788a = sectionType;
        if (!(sectionType == SectionType.YEAR_SECTION && z)) {
            z2 = true;
        }
        this.f12797j = z2;
        this.f12799l = monotonicClock;
        this.f12790c = pendingStoryCache;
    }

    public final Object m12743a(int i) {
        if (this.f12797j) {
            int k = m12740k();
            if (i < k) {
                return this.f12789b;
            }
            k = i - k;
            int j = m12739j();
            if (k < j) {
                return ((GraphQLFeedUnitEdge) this.f12790c.a().get(k)).c();
            }
            return this.f12791d.get(k - j);
        }
        throw new IllegalStateException("Requesting data while inactive. Index:" + i);
    }

    private int m12739j() {
        if (this.f12788a != SectionType.RECENT_SECTION || this.f12790c == null) {
            return 0;
        }
        return this.f12790c.c();
    }

    private int m12740k() {
        return this.f12789b != null ? 1 : 0;
    }

    public final int m12742a(String str, String str2) {
        int i = 0;
        while (i < this.f12791d.size()) {
            Object obj = this.f12791d.get(i);
            if ((obj instanceof GraphQLStory) && StoryProps.a(FeedProps.c((GraphQLStory) obj), str) != null) {
                return i;
            }
            if (obj instanceof Feedbackable) {
                Feedbackable feedbackable = (Feedbackable) obj;
                if (str != null && (obj instanceof FeedUnit) && str.equals(((FeedUnit) obj).g())) {
                    return i;
                }
                if (str2 != null) {
                    String a = GraphQlIdParserUtil.a(str2);
                    GraphQLFeedback l = feedbackable.l();
                    if (l != null && (a.equals(l.j()) || str2.equals(l.j()))) {
                        return i;
                    }
                }
                continue;
            }
            i++;
        }
        return -1;
    }

    @Nullable
    public final Feedbackable m12749b(String str, String str2) {
        int a = m12742a(str, str2);
        if (a == -1 || !(this.f12791d.get(a) instanceof GraphQLStory)) {
            return null;
        }
        if (str == null) {
            return (GraphQLStory) this.f12791d.get(a);
        }
        FeedProps a2 = StoryProps.a(FeedProps.c((GraphQLStory) this.f12791d.get(a)), str);
        if (a2 != null) {
            return (GraphQLStory) a2.a;
        }
        return null;
    }

    public final void m12747a(String str, String str2, StoryVisibility storyVisibility, int i) {
        int a = m12742a(str, str2);
        if (a != -1) {
            Feedbackable b = m12749b(str, str2);
            Object obj = this.f12791d.get(a) == b ? 1 : null;
            if (b instanceof HideableUnit) {
                HideableUnit hideableUnit = (HideableUnit) b;
                FeedUnitMutator a2 = FeedUnitMutator.a(hideableUnit);
                long now = this.f12799l.now();
                if (i == -1) {
                    i = hideableUnit.p();
                }
                FeedUnit a3 = a2.a(now, storyVisibility, i).a();
                if (obj != null) {
                    this.f12791d.set(a, a3);
                }
            }
        }
    }

    public final int m12748b() {
        if (!this.f12797j || this.f12798k) {
            return 0;
        }
        return (m12740k() + m12739j()) + this.f12791d.size();
    }

    public final void m12745a(GraphQLUnseenStoriesConnection graphQLUnseenStoriesConnection) {
        if (this.f12788a == SectionType.UNSEEN_SECTION && graphQLUnseenStoriesConnection != null && graphQLUnseenStoriesConnection.a() != null && !graphQLUnseenStoriesConnection.a().isEmpty()) {
            this.f12789b = new TimelinePostsLabel(SectionType.UNSEEN_SECTION);
            ImmutableList a = graphQLUnseenStoriesConnection.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLStory graphQLStory = (GraphQLStory) a.get(i);
                FetchTimeMsHelper.a(graphQLStory, this.f12799l.now());
                this.f12791d.add(graphQLStory);
            }
            this.f12792e += graphQLUnseenStoriesConnection.a().size();
            this.f12795h = true;
        }
    }

    public final void m12744a(GraphQLTimelineSection graphQLTimelineSection) {
        int i = 0;
        m12741l();
        if (!this.f12795h) {
            boolean z = this.f12788a == SectionType.RECENT_SECTION;
            if (graphQLTimelineSection.l().a().isEmpty() && !z) {
                this.f12791d.add(new NoStoriesMarker());
            } else if (z && !graphQLTimelineSection.l().a().isEmpty()) {
                this.f12789b = TimelinePostsLabel.m12737a();
            }
        }
        ImmutableList a = graphQLTimelineSection.l().a();
        int size = a.size();
        while (i < size) {
            GraphQLTimelineSectionUnitsEdge graphQLTimelineSectionUnitsEdge = (GraphQLTimelineSectionUnitsEdge) a.get(i);
            FetchTimeMsHelper.a(graphQLTimelineSectionUnitsEdge.j(), this.f12799l.now());
            this.f12791d.add(graphQLTimelineSectionUnitsEdge.j());
            i++;
        }
        this.f12792e += graphQLTimelineSection.l().a().size();
        this.f12795h = true;
    }

    public final void m12751b(Placeholder placeholder) {
        m12741l();
        this.f12791d.add(placeholder);
    }

    private void m12741l() {
        while (!this.f12791d.isEmpty() && (this.f12791d.get(this.f12791d.size() - 1) instanceof Placeholder)) {
            this.f12791d.remove(this.f12791d.size() - 1);
        }
    }

    public final void m12746a(TimelineSectionLoadState timelineSectionLoadState, TimelineSectionFetchParams timelineSectionFetchParams) {
        boolean z = false;
        Object obj;
        if (timelineSectionLoadState != TimelineSectionLoadState.COMPLETED) {
            if (!this.f12791d.isEmpty()) {
                if (timelineSectionLoadState == TimelineSectionLoadState.LOADING) {
                    z = true;
                }
                this.f12794g = z;
                obj = this.f12791d.get(this.f12791d.size() - 1);
                if (obj instanceof Scrubber) {
                    ((Scrubber) obj).f12783c = timelineSectionLoadState;
                    return;
                } else if (this.f12791d.get(this.f12791d.size() - 1) instanceof LoadingIndicator) {
                    ((LoadingIndicator) this.f12791d.get(this.f12791d.size() - 1)).f12777b = timelineSectionLoadState;
                    return;
                }
            }
            m12738a(timelineSectionFetchParams);
        } else if (!this.f12791d.isEmpty()) {
            this.f12794g = false;
            obj = this.f12791d.get(this.f12791d.size() - 1);
            if (obj instanceof Scrubber) {
                ((Scrubber) obj).f12783c = timelineSectionLoadState;
                return;
            }
            while (!this.f12791d.isEmpty() && (this.f12791d.get(this.f12791d.size() - 1) instanceof LoadingIndicator)) {
                this.f12791d.remove(this.f12791d.size() - 1);
            }
        }
    }

    private void m12738a(TimelineSectionFetchParams timelineSectionFetchParams) {
        m12741l();
        this.f12791d.add(new LoadingIndicator(timelineSectionFetchParams));
    }

    public final String m12750b(int i) {
        String str = null;
        if (i >= m12748b()) {
            return null;
        }
        Object a = m12743a(i);
        if (a instanceof GraphQLStory) {
            str = ((GraphQLStory) a).c();
        }
        if (a instanceof Scrubber) {
            str = ((Scrubber) a).f12781a;
        }
        if (a instanceof Placeholder) {
            return "PLACEHOLDER_ID";
        }
        return str;
    }

    public String toString() {
        return this.f12793f;
    }
}
