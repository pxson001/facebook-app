package com.facebook.feed.ui.chaining;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.widget.TextView;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.hscroll.FeedRecyclablePagerAdapter;
import com.facebook.feed.hscroll.HScrollFeedItem.Position;
import com.facebook.feed.hscroll.HScrollFeedItemController;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.itemlistfeedunits.FeedListItemUserActionListener;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.widget.CustomViewPager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: TrendingGifsTask */
public abstract class HScrollChainingViewController extends HScrollFeedItemController {
    public final Context f21854a;
    protected final ScreenUtil f21855b;
    public final FeedRenderUtils f21856c;
    @Nullable
    public AnyEnvironment f21857d;
    public int f21858e;
    public int f21859f;

    /* compiled from: TrendingGifsTask */
    public class ItemListRecyclablePagerAdapter extends FeedRecyclablePagerAdapter {
        private final FeedListItemUserActionListener f21850a;
        private final HScrollChainingViewController f21851b;
        public final GraphQLStory f21852c;
        private final ScrollableItemListFeedUnit f21853d;

        public final Position mo1516a(int i, int i2) {
            if (null == null || i2 != 1) {
                return super.mo1516a(i, i2);
            }
            return Position.INNER;
        }

        public ItemListRecyclablePagerAdapter(RecyclableViewPoolManager recyclableViewPoolManager, HScrollChainingViewController hScrollChainingViewController, FeedListItemUserActionListener feedListItemUserActionListener, GraphQLStory graphQLStory, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
            super(recyclableViewPoolManager);
            this.f21851b = hScrollChainingViewController;
            this.f21850a = feedListItemUserActionListener;
            this.f21852c = graphQLStory;
            this.f21853d = scrollableItemListFeedUnit;
        }

        public final float m24435d(int i) {
            return this.f21851b.mo1518a(mo1516a(i, this.f19220a.size()));
        }

        protected final PagerViewType mo1517d() {
            return this.f21851b.mo1562a();
        }

        protected final void m24433a(View view, Object obj, int i) {
            this.f21851b.mo1564a(view, obj, mo1516a(i, this.f19220a.size()), this.f21850a, this.f21853d);
        }

        public final void m24434b(View view, Object obj) {
            this.f21851b.m24440a(view);
        }
    }

    public abstract void mo1564a(View view, Object obj, Position position, FeedListItemUserActionListener feedListItemUserActionListener, ScrollableItemListFeedUnit scrollableItemListFeedUnit);

    public abstract Class<? extends ScrollableItemListFeedUnit> mo1566c();

    public HScrollChainingViewController(Context context, ScreenUtil screenUtil, FeedRenderUtils feedRenderUtils) {
        this.f21854a = context;
        this.f21855b = screenUtil;
        this.f21856c = feedRenderUtils;
    }

    public static void m24437a(ItemListRecyclablePagerAdapter itemListRecyclablePagerAdapter, ViewPager viewPager) {
        if (itemListRecyclablePagerAdapter.f19221b) {
            int i = viewPager.k + 1;
            if (i < itemListRecyclablePagerAdapter.b()) {
                viewPager.setCurrentItem(i);
            }
        }
    }

    public void mo1565a(FeedProps<ScrollableItemListFeedUnit> feedProps, TextView textView) {
    }

    protected void m24440a(View view) {
    }

    public void m24444a(ItemListRecyclablePagerAdapter itemListRecyclablePagerAdapter, ViewPager viewPager, View view, Object obj, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        m24437a(itemListRecyclablePagerAdapter, viewPager);
    }

    protected final void m24441a(View view, Position position) {
        view.setLayoutParams(new LayoutParams());
        if (position == Position.FIRST) {
            view.setPadding(mo1567d(), 0, this.f21859f, 0);
        } else {
            view.setPadding(this.f21859f, 0, this.f21859f, 0);
        }
    }

    public ArrayNode mo1563a(FeedProps<ScrollableItemListFeedUnit> feedProps) {
        return null;
    }

    public int mo1521b() {
        return (this.f21858e / mo1569f()) + 1;
    }

    public float mo1518a(Position position) {
        if (position == Position.FIRST) {
            return ((float) ((mo1567d() + mo1569f()) + this.f21859f)) / ((float) this.f21858e);
        }
        return 1.0f;
    }

    public void mo1520a(List list, CustomViewPager customViewPager) {
        customViewPager.b(mo1568e(), true);
    }

    public void mo1519a(CustomViewPager customViewPager, Resources resources) {
        this.f21858e = this.f21856c.a();
        this.f21859f = (this.f21858e - mo1569f()) / 2;
        customViewPager.setPageMargin(((this.f21859f * 2) - mo1570g()) * -1);
    }

    protected int mo1567d() {
        return 0;
    }

    protected int mo1568e() {
        return 0;
    }

    public int mo1569f() {
        return 0;
    }

    public int mo1570g() {
        return 0;
    }
}
