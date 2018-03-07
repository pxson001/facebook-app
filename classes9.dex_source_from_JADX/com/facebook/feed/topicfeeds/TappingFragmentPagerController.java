package com.facebook.feed.topicfeeds;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.topicfeeds.NewsFeedSwitcherFragment.NewsFeedSwitcherFragmentPagerAdapter;
import com.facebook.feed.topicfeeds.TopicFeedsNavigationLogger.NavigationEventType;
import com.facebook.feed.topicfeeds.switcher.FeedSwitcherItem;
import java.util.List;

/* compiled from: TRIPLEPOP */
public class TappingFragmentPagerController implements FragmentPagerController {
    private final FragmentPager f24576a;
    private final TopicFeedsNavigationLogger f24577b;

    public TappingFragmentPagerController(FragmentManager fragmentManager, int i, TopicFeedsNavigationLogger topicFeedsNavigationLogger) {
        this.f24576a = new FragmentPager(fragmentManager, i);
        this.f24577b = topicFeedsNavigationLogger;
    }

    public final View mo1159a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return layoutInflater.inflate(2130905452, viewGroup, false);
    }

    public final void mo1162a(NewsFeedSwitcherFragmentPagerAdapter newsFeedSwitcherFragmentPagerAdapter) {
        this.f24576a.f24532c = newsFeedSwitcherFragmentPagerAdapter;
    }

    public final void mo1160a(int i) {
        FragmentPager fragmentPager = this.f24576a;
        fragmentPager.f24530a.a().b(fragmentPager.f24531b, fragmentPager.f24532c.m26454a(i)).c();
        fragmentPager.f24530a.b();
    }

    public final Fragment mo1158a() {
        FragmentPager fragmentPager = this.f24576a;
        return fragmentPager.f24530a.a(fragmentPager.f24531b);
    }

    public final void mo1163b() {
    }

    public final void mo1161a(Fragment fragment, Context context, int i, List<FeedSwitcherItem> list, LinearLayoutManager linearLayoutManager, NavigationEventType navigationEventType) {
        this.f24577b.m26503a(fragment, context, i, list, linearLayoutManager, navigationEventType);
    }
}
