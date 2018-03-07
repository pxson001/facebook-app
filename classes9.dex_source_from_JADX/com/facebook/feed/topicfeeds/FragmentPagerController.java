package com.facebook.feed.topicfeeds;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.topicfeeds.NewsFeedSwitcherFragment.NewsFeedSwitcherFragmentPagerAdapter;
import com.facebook.feed.topicfeeds.TopicFeedsNavigationLogger.NavigationEventType;
import com.facebook.feed.topicfeeds.switcher.FeedSwitcherItem;
import java.util.List;

/* compiled from: TT;>;) */
public interface FragmentPagerController {
    Fragment mo1158a();

    View mo1159a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    void mo1160a(int i);

    void mo1161a(Fragment fragment, Context context, int i, List<FeedSwitcherItem> list, LinearLayoutManager linearLayoutManager, NavigationEventType navigationEventType);

    void mo1162a(NewsFeedSwitcherFragmentPagerAdapter newsFeedSwitcherFragmentPagerAdapter);

    void mo1163b();
}
