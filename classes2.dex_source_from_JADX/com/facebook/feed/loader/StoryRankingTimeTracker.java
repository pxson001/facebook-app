package com.facebook.feed.loader;

import com.facebook.api.feed.xconfig.FreshFeedConfigReader;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.debug.log.BLog;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: settings/ */
public class StoryRankingTimeTracker extends BaseViewportEventListener implements ViewportEventListener {
    private static final String f10418a = StoryRankingTimeTracker.class.getSimpleName();
    public final Clock f10419b;
    public final FbSharedPreferences f10420c;
    public final QeAccessor f10421d;
    public final FreshFeedConfigReader f10422e;
    public HitPreviouslyRankedStoriesListener f10423f;
    public FeedType f10424g;
    private long f10425h;
    private Long f10426i;
    public Long f10427j;
    public Long f10428k;

    /* compiled from: settings/ */
    public interface HitPreviouslyRankedStoriesListener {
        void iv_();
    }

    public static StoryRankingTimeTracker m15516a(InjectorLike injectorLike) {
        return new StoryRankingTimeTracker(QeInternalImplMethodAutoProvider.m3744a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), FreshFeedConfigReader.m9080a(injectorLike));
    }

    @Inject
    public StoryRankingTimeTracker(QeAccessor qeAccessor, Clock clock, FbSharedPreferences fbSharedPreferences, FreshFeedConfigReader freshFeedConfigReader) {
        this.f10421d = qeAccessor;
        this.f10419b = clock;
        this.f10420c = fbSharedPreferences;
        this.f10422e = freshFeedConfigReader;
    }

    public final void m15520a(@Nullable HitPreviouslyRankedStoriesListener hitPreviouslyRankedStoriesListener) {
        this.f10423f = hitPreviouslyRankedStoriesListener;
    }

    public final void m15519a(long j) {
        this.f10426i = Long.valueOf(Math.max(j, this.f10426i == null ? 0 : this.f10426i.longValue()));
    }

    private long m15517e() {
        if (this.f10427j == null) {
            this.f10427j = Long.valueOf(this.f10420c.mo277a(FeedPrefKeys.f5739c, 0));
        }
        return this.f10427j.longValue();
    }

    public final long m15522b() {
        if (this.f10428k == null) {
            this.f10428k = Long.valueOf(this.f10420c.mo277a(FeedPrefKeys.f5740d, 0));
        }
        return this.f10428k.longValue();
    }

    private void m15518g() {
        this.f10428k = Long.valueOf(this.f10419b.mo211a());
        this.f10420c.edit().mo1275a(FeedPrefKeys.f5740d, this.f10428k.longValue()).commit();
        long j = this.f10425h;
        this.f10427j = Long.valueOf(j);
        this.f10420c.edit().mo1275a(FeedPrefKeys.f5739c, j).commit();
        this.f10423f.iv_();
        if (BLog.b(3)) {
            new SimpleDateFormat("MM/dd HH:mm", Locale.US).format(new Date(this.f10427j.longValue() * 1000));
        }
    }

    public final void mo1970a(Object obj) {
        FeedUnit a = FeedUnitHelper.m21141a(obj);
        if (a instanceof GraphQLStory) {
            long aZ = ((GraphQLStory) a).aZ();
            if (aZ != 0) {
                this.f10426i = Long.valueOf(this.f10426i == null ? aZ : Math.max(this.f10426i.longValue(), aZ));
                if (!m15523c() && aZ < this.f10425h && m15517e() < this.f10425h) {
                    m15518g();
                }
                this.f10425h = aZ;
            }
        }
    }

    public final boolean m15523c() {
        return this.f10426i != null && m15517e() >= this.f10426i.longValue();
    }

    public final boolean m15524d() {
        return m15517e() == 0;
    }
}
