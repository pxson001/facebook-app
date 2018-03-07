package com.facebook.feedplugins.pyml.controllers;

import android.content.Context;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.TriState;
import com.facebook.feed.annotations.IsHscrollReliableSwipingEnabled;
import com.facebook.feed.hscroll.FeedRecyclablePagerAdapter;
import com.facebook.feed.hscroll.HScrollFeedItem.Position;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.ui.itemlistfeedunits.FeedListItemUserActionListener;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.ListViewFriendlyViewPager;
import com.facebook.widget.RecyclableView;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.inject.Provider;

/* compiled from: android_messenger_number_of_availability_checks */
public class HScrollFeedUnitView extends CustomLinearLayout implements FeedListItemUserActionListener, RecyclableView {
    @Inject
    public RecyclableViewPoolManager f19653a;
    @Inject
    FeedLoggingViewportEventListener f19654b;
    @Inject
    HScrollFeedUnitControllerManager f19655c;
    @Inject
    AbstractFbErrorReporter f19656d;
    @Inject
    WindowManager f19657e;
    @Inject
    @IsHscrollReliableSwipingEnabled
    public Provider<TriState> f19658f;
    public CustomViewPager f19659g;
    public TextView f19660h;
    public TextView f19661i;
    public View f19662j;
    public View f19663k;
    public View f19664l;
    public View f19665m;
    public ItemListRecyclablePagerAdapter f19666n;
    private Optional<View> f19667o = Absent.INSTANCE;
    private PagerViewType f19668p;
    public ScrollableItemListFeedUnit f19669q;
    public HScrollFeedUnitController f19670r;
    private int f19671s = -1;
    public boolean f19672t;

    /* compiled from: android_messenger_number_of_availability_checks */
    public class C27921 extends SimpleOnPageChangeListener {
        final /* synthetic */ HScrollFeedUnitView f19650a;

        public C27921(HScrollFeedUnitView hScrollFeedUnitView) {
            this.f19650a = hScrollFeedUnitView;
        }

        public final void e_(int i) {
            if (this.f19650a.f19669q != null && this.f19650a.f19670r != null) {
                this.f19650a.f19654b.a(this.f19650a.f19669q, i);
            }
        }
    }

    /* compiled from: android_messenger_number_of_availability_checks */
    public class ItemListRecyclablePagerAdapter extends FeedRecyclablePagerAdapter {
        final /* synthetic */ HScrollFeedUnitView f19651a;
        private FeedListItemUserActionListener f19652b;

        public ItemListRecyclablePagerAdapter(HScrollFeedUnitView hScrollFeedUnitView, RecyclableViewPoolManager recyclableViewPoolManager, FeedListItemUserActionListener feedListItemUserActionListener) {
            this.f19651a = hScrollFeedUnitView;
            super(recyclableViewPoolManager);
            this.f19652b = feedListItemUserActionListener;
        }

        public final float m19935d(int i) {
            return this.f19651a.f19670r.a(a(i, this.a.size()));
        }

        protected final PagerViewType m19936d() {
            return this.f19651a.f19670r.a();
        }

        protected final void m19934a(View view, Object obj, int i) {
            this.f19651a.f19670r.mo888a(this.f19651a.f19669q, view, obj, a(i, this.a.size()), this.f19652b);
        }
    }

    public static void m19940a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((HScrollFeedUnitView) obj).m19939a(RecyclableViewPoolManager.a(fbInjector), FeedLoggingViewportEventListener.a(fbInjector), HScrollFeedUnitControllerManager.m19932a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), WindowManagerMethodAutoProvider.b(fbInjector), IdBasedProvider.a(fbInjector, 670));
    }

    private void m19939a(RecyclableViewPoolManager recyclableViewPoolManager, FeedLoggingViewportEventListener feedLoggingViewportEventListener, HScrollFeedUnitControllerManager hScrollFeedUnitControllerManager, FbErrorReporter fbErrorReporter, WindowManager windowManager, Provider<TriState> provider) {
        this.f19653a = recyclableViewPoolManager;
        this.f19654b = feedLoggingViewportEventListener;
        this.f19655c = hScrollFeedUnitControllerManager;
        this.f19656d = fbErrorReporter;
        this.f19657e = windowManager;
        this.f19658f = provider;
    }

    public HScrollFeedUnitView(Context context) {
        super(context);
        Class cls = HScrollFeedUnitView.class;
        m19940a((Object) this, getContext());
        boolean asBoolean = ((TriState) this.f19658f.get()).asBoolean(false);
        setContentView(2130904793);
        setOrientation(1);
        setBackgroundResource(2130840323);
        this.f19659g = (CustomViewPager) a(2131562915);
        this.f19660h = (TextView) a(2131562912);
        this.f19661i = (TextView) a(2131562921);
        this.f19662j = a(2131562918);
        this.f19663k = a(2131562919);
        this.f19664l = a(2131562920);
        this.f19665m = a(2131562922);
        this.f19660h.setMovementMethod(LinkMovementMethod.getInstance());
        this.f19666n = new ItemListRecyclablePagerAdapter(this, this.f19653a, this);
        this.f19659g.setAdapter(this.f19666n);
        this.f19659g.setOnPageChangeListener(new C27921(this));
        if (asBoolean && (this.f19659g instanceof ListViewFriendlyViewPager)) {
            ((ListViewFriendlyViewPager) this.f19659g).g();
        }
    }

    public final boolean m19943a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, boolean z) {
        List v = scrollableItemListFeedUnit.v();
        if (v == null || v.isEmpty()) {
            setVisibility(8);
            return false;
        }
        if (z) {
            this.f19662j.setVisibility(0);
        } else {
            this.f19662j.setVisibility(8);
        }
        int rotation = this.f19657e.getDefaultDisplay().getRotation();
        if (this.f19669q != null && Objects.equal(scrollableItemListFeedUnit.g(), this.f19669q.g())) {
            if (scrollableItemListFeedUnit.T_() == this.f19669q.T_() && this.f19671s == rotation) {
                return false;
            }
            VisibleItemHelper.a(scrollableItemListFeedUnit, v, this.f19669q.ac_());
        }
        this.f19669q = scrollableItemListFeedUnit;
        this.f19671s = rotation;
        HScrollFeedUnitControllerManager hScrollFeedUnitControllerManager = this.f19655c;
        Class cls = scrollableItemListFeedUnit.getClass();
        Preconditions.checkArgument(ScrollableItemListFeedUnit.class.isAssignableFrom(cls), "HScrollFeedUnitView can only be bound to FeedUnits which implement the ScrollableItemListFeedUnit interface.");
        this.f19670r = (HScrollFeedUnitController) hScrollFeedUnitControllerManager.f19649a.get(cls);
        if (this.f19670r == null) {
            setVisibility(8);
            this.f19656d.b("HScrollFeedUnitView no controller for HScrollFeedUnitView for class " + scrollableItemListFeedUnit.getClass(), "Zombie:" + scrollableItemListFeedUnit.S_());
            return false;
        }
        this.f19670r.mo889a(scrollableItemListFeedUnit, this.f19660h, this.f19663k);
        TextView textView = this.f19661i;
        View view = this.f19664l;
        View view2 = this.f19665m;
        view.setVisibility(8);
        textView.setVisibility(8);
        view2.setVisibility(0);
        if (v.size() == 1 && this.f19670r.mo891d()) {
            m19937a(scrollableItemListFeedUnit, v.get(0));
        } else {
            m19938a(scrollableItemListFeedUnit, v);
        }
        return true;
    }

    private void m19938a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, List list) {
        this.f19659g.setVisibility(0);
        if (list.size() == 1) {
            this.f19659g.a = false;
        } else {
            this.f19659g.a = true;
        }
        if (this.f19667o.isPresent()) {
            ((View) this.f19667o.get()).setVisibility(8);
        }
        this.f19670r.a(scrollableItemListFeedUnit.v(), this.f19659g);
        this.f19670r.a(this.f19659g, getResources());
        this.f19666n.a(list);
        if (this.f19659g.getAdapter() != this.f19666n) {
            this.f19659g.setAdapter(this.f19666n);
        }
        this.f19659g.setOffscreenPageLimit(this.f19670r.b());
        this.f19659g.a(scrollableItemListFeedUnit.ac_(), false);
    }

    private void m19937a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, Object obj) {
        this.f19659g.setVisibility(8);
        if (this.f19659g.getAdapter() == this.f19666n) {
            this.f19659g.setAdapter(null);
        }
        if (this.f19670r.a() != this.f19668p && this.f19667o.isPresent()) {
            this.f19653a.a(this.f19668p.a(), (View) this.f19667o.get(), this);
            this.f19667o = Absent.INSTANCE;
            this.f19668p = null;
        }
        if (!this.f19667o.isPresent()) {
            this.f19667o = Optional.of(this.f19666n.b(this, 0));
            this.f19668p = this.f19670r.a();
            addView((View) this.f19667o.get(), indexOfChild(this.f19659g), generateDefaultLayoutParams());
        }
        View view = (View) this.f19667o.get();
        view.setVisibility(0);
        this.f19670r.mo888a(scrollableItemListFeedUnit, view, obj, Position.FIRST, this);
    }

    public final void mR_() {
        this.f19670r.mo887a(this.f19666n, this.f19659g);
    }

    public final void m19941a(View view, Object obj, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(obj);
        this.f19670r.mo887a(this.f19666n, this.f19659g);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1733055237);
        super.onAttachedToWindow();
        this.f19672t = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1333657014, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 503796245);
        super.onDetachedFromWindow();
        this.f19672t = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 104014464, a);
    }

    public final boolean m19942a() {
        return this.f19672t;
    }
}
