package com.facebook.feed.logging.viewport;

import android.support.v4.util.SimpleArrayMap;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableMap;

/* compiled from: prefetch_low_priority_feedback */
public interface FeedLoggingHandler {
    void mo1913a(SimpleArrayMap<Object, Object> simpleArrayMap);

    void mo1914a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, int i);

    void mo1915a(ScrollingViewProxy scrollingViewProxy, int i, int i2);

    void mo1916a(ScrollingViewProxy scrollingViewProxy, Object obj, int i);

    void mo1917a(ImmutableMap<String, String> immutableMap);

    void mo1918a(String str);

    boolean mo1919a(Object obj);

    void mo1920b(ScrollableItemListFeedUnit scrollableItemListFeedUnit, int i);

    void mo1921b(Object obj);

    void mo1922c(Object obj);

    boolean mo1923d(Object obj);
}
