package com.facebook.feed.topicfeeds;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.FindViewUtil;
import com.facebook.feed.topicfeeds.NewsFeedSwitcherFragment.C29531;
import com.facebook.feed.topicfeeds.NewsFeedSwitcherFragment.NewsFeedSwitcherFragmentPagerAdapter;
import com.facebook.feed.topicfeeds.TopicFeedsNavigationLogger.NavigationEventType;
import com.facebook.feed.topicfeeds.switcher.FeedSwitcherItem;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.viewpager.CustomFragmentStatePagerAdapter;
import java.util.List;

/* compiled from: TROUBLE_LOGGING_IN */
public class SwipingFragmentPagerController implements FragmentPagerController {
    public Context f24563a;
    public CustomFragmentStatePagerAdapter f24564b;
    private CustomViewPager f24565c;
    private FragmentManager f24566d;
    public LinearLayoutManager f24567e;
    public List<FeedSwitcherItem> f24568f;
    private RecyclerView f24569g;
    public C29531 f24570h;
    private TopicFeedsNavigationLogger f24571i;
    public int f24572j;
    public NavigationEventType f24573k;
    public boolean f24574l;
    public int f24575m;

    /* compiled from: TROUBLE_LOGGING_IN */
    class C29621 implements OnPageChangeListener {
        final /* synthetic */ SwipingFragmentPagerController f24560a;

        C29621(SwipingFragmentPagerController swipingFragmentPagerController) {
            this.f24560a = swipingFragmentPagerController;
        }

        public final void m26483a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            C29531 c29531 = this.f24560a.f24570h;
            NewsFeedSwitcherFragment.m26472h(c29531.f24538a, i);
            c29531.f24538a.m26468b(i, null);
            this.f24560a.f24572j = i;
            NavigationEventType navigationEventType = (this.f24560a.f24573k == NavigationEventType.BACK_BUTTON || this.f24560a.f24573k == NavigationEventType.NEWS_FEED_TAB) ? this.f24560a.f24573k : this.f24560a.f24574l ? NavigationEventType.TOPIC_SWIPE : NavigationEventType.TOPIC_TAB;
            this.f24560a.m26490b(this.f24560a.f24564b.mo1156a(i), this.f24560a.f24563a, i, this.f24560a.f24568f, this.f24560a.f24567e, navigationEventType);
            this.f24560a.f24574l = false;
            this.f24560a.f24573k = NavigationEventType.INTERNAL_RESET;
        }

        public final void m26484b(int i) {
            boolean z = true;
            SwipingFragmentPagerController swipingFragmentPagerController = this.f24560a;
            if (!(this.f24560a.f24575m == 1 && i == 2)) {
                z = false;
            }
            swipingFragmentPagerController.f24574l = z;
            this.f24560a.f24575m = i;
        }
    }

    /* compiled from: TROUBLE_LOGGING_IN */
    class DelegatingAdapter extends CustomFragmentStatePagerAdapter {
        final /* synthetic */ SwipingFragmentPagerController f24561a;
        private NewsFeedSwitcherFragmentPagerAdapter f24562b;

        public DelegatingAdapter(SwipingFragmentPagerController swipingFragmentPagerController, FragmentManager fragmentManager, NewsFeedSwitcherFragmentPagerAdapter newsFeedSwitcherFragmentPagerAdapter) {
            this.f24561a = swipingFragmentPagerController;
            super(fragmentManager);
            this.f24562b = newsFeedSwitcherFragmentPagerAdapter;
        }

        public final Fragment mo1156a(int i) {
            return this.f24562b.m26454a(i);
        }

        public final int m26487b() {
            return this.f24562b.f24547a.ar.size();
        }

        public final String mo1157b(int i) {
            return ((FeedSwitcherItem) this.f24562b.f24547a.ar.get(i)).f24534b;
        }

        public final CharSequence J_(int i) {
            return mo1157b(i);
        }

        public final int m26485a(Object obj) {
            NewsFeedSwitcherFragmentPagerAdapter newsFeedSwitcherFragmentPagerAdapter = this.f24562b;
            int a = NewsFeedSwitcherFragment.m26459a(newsFeedSwitcherFragmentPagerAdapter.f24547a, (String) newsFeedSwitcherFragmentPagerAdapter.f24548b.a_().get(obj));
            if (a == -1) {
                a = -2;
            }
            return a;
        }
    }

    public SwipingFragmentPagerController(Context context, FragmentManager fragmentManager, LinearLayoutManager linearLayoutManager, List<FeedSwitcherItem> list, TopicChangeListener topicChangeListener, TopicFeedsNavigationLogger topicFeedsNavigationLogger) {
        this.f24563a = context;
        this.f24566d = fragmentManager;
        this.f24567e = linearLayoutManager;
        this.f24568f = list;
        this.f24570h = topicChangeListener;
        this.f24571i = topicFeedsNavigationLogger;
    }

    public final View mo1159a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.f24565c = (CustomViewPager) layoutInflater.inflate(2130905453, viewGroup, false);
        this.f24565c.setPageMargin(layoutInflater.getContext().getResources().getDimensionPixelOffset(2131432668));
        this.f24569g = (RecyclerView) FindViewUtil.b(this.f24565c, 2131564237);
        ((LayoutParams) this.f24569g.getLayoutParams()).a = true;
        if (this.f24564b != null) {
            this.f24565c.setAdapter(this.f24564b);
        }
        this.f24565c.setOnPageChangeListener(new C29621(this));
        this.f24565c.setCurrentItem(this.f24572j);
        return this.f24565c;
    }

    public final void mo1162a(NewsFeedSwitcherFragmentPagerAdapter newsFeedSwitcherFragmentPagerAdapter) {
        this.f24564b = new DelegatingAdapter(this, this.f24566d, newsFeedSwitcherFragmentPagerAdapter);
        if (this.f24565c != null) {
            this.f24565c.setAdapter(this.f24564b);
        }
    }

    public final void mo1160a(int i) {
        if (i != this.f24572j) {
            this.f24572j = i;
            if (this.f24565c != null) {
                this.f24565c.a(i, true);
            }
        }
    }

    public final Fragment mo1158a() {
        if (this.f24564b != null) {
            return this.f24564b.m3371e(this.f24572j);
        }
        return null;
    }

    public final void mo1163b() {
        this.f24564b.kR_();
    }

    public final void mo1161a(Fragment fragment, Context context, int i, List<FeedSwitcherItem> list, LinearLayoutManager linearLayoutManager, NavigationEventType navigationEventType) {
        this.f24573k = navigationEventType;
    }

    private void m26490b(Fragment fragment, Context context, int i, List<FeedSwitcherItem> list, LinearLayoutManager linearLayoutManager, NavigationEventType navigationEventType) {
        this.f24571i.m26503a(fragment, context, i, list, linearLayoutManager, navigationEventType);
    }
}
