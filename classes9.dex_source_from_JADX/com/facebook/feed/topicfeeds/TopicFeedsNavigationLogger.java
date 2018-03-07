package com.facebook.feed.topicfeeds;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import com.facebook.analytics.NavigationLogger;
import com.facebook.feed.topicfeeds.switcher.FeedSwitcherItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: TRENDING_ITEMS */
public class TopicFeedsNavigationLogger {
    private final NavigationLogger f24578a;

    /* compiled from: TRENDING_ITEMS */
    public enum NavigationEventType {
        BACK_BUTTON,
        TOPIC_TAB,
        NEWS_FEED_TAB,
        TOPIC_SWIPE,
        INTERNAL_RESET
    }

    @Inject
    public TopicFeedsNavigationLogger(NavigationLogger navigationLogger) {
        this.f24578a = navigationLogger;
    }

    public final void m26503a(Fragment fragment, Context context, int i, List<FeedSwitcherItem> list, LinearLayoutManager linearLayoutManager, NavigationEventType navigationEventType) {
        NavigationLogger navigationLogger = this.f24578a;
        Map hashMap = new HashMap();
        hashMap.put("index", Integer.valueOf(i));
        hashMap.put("destination", ((FeedSwitcherItem) list.get(i)).f24534b);
        hashMap.put("method", navigationEventType.name());
        List arrayList = new ArrayList();
        for (FeedSwitcherItem feedSwitcherItem : list) {
            arrayList.add(feedSwitcherItem.f24534b);
        }
        hashMap.put("topic_feeds", arrayList);
        int l = linearLayoutManager.l();
        int n = linearLayoutManager.n();
        List arrayList2 = new ArrayList();
        int i2 = l;
        while (i2 <= n && i2 != -1 && i2 < list.size()) {
            arrayList2.add(((FeedSwitcherItem) list.get(i2)).f24534b);
            i2++;
        }
        hashMap.put("visible_topic_feeds", arrayList2);
        navigationLogger.a(fragment, context, hashMap);
    }
}
