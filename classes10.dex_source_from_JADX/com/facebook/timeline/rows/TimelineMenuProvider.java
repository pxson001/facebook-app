package com.facebook.timeline.rows;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.timeline.units.storymenu.NonSelfTimelineFeedStoryMenuHelperProvider;
import com.facebook.timeline.units.storymenu.SelfTimelineFeedStoryMenuHelperProvider;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: extra_start_time */
public class TimelineMenuProvider {
    private final SelfTimelineFeedStoryMenuHelperProvider f12618a;
    private final NonSelfTimelineFeedStoryMenuHelperProvider f12619b;

    /* compiled from: extra_start_time */
    /* synthetic */ class C17741 {
        static final /* synthetic */ int[] f12617a = new int[FeedListName.values().length];

        static {
            try {
                f12617a[FeedListName.MY_TIMELINE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12617a[FeedListName.REDSPACE_SELF.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12617a[FeedListName.OTHER_PERSON_TIMELINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12617a[FeedListName.REDSPACE_OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public TimelineMenuProvider(SelfTimelineFeedStoryMenuHelperProvider selfTimelineFeedStoryMenuHelperProvider, NonSelfTimelineFeedStoryMenuHelperProvider nonSelfTimelineFeedStoryMenuHelperProvider) {
        this.f12618a = selfTimelineFeedStoryMenuHelperProvider;
        this.f12619b = nonSelfTimelineFeedStoryMenuHelperProvider;
    }

    public final BaseFeedStoryMenuHelper m12582a(FeedEnvironment feedEnvironment) {
        FeedListType c = feedEnvironment.c();
        Preconditions.checkArgument(c instanceof AbstractTimelineFeedType);
        AbstractTimelineFeedType abstractTimelineFeedType = (AbstractTimelineFeedType) c;
        switch (C17741.f12617a[c.a().ordinal()]) {
            case 1:
            case 2:
                return this.f12618a.m12771a(abstractTimelineFeedType.f12583a, feedEnvironment);
            case 3:
            case 4:
                return this.f12619b.m12767a(abstractTimelineFeedType.f12583a, feedEnvironment);
            default:
                throw new IllegalStateException("Unsupported feedListType: " + c.a().toString());
        }
    }
}
