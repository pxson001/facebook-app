package com.facebook.messaging.inbox2.recents;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.MathUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxUnitViewWithRecyclerView;
import com.facebook.messaging.inbox2.sharing.ShareFlowSelectorView;
import com.facebook.messaging.inbox2.sharing.UserSelectionListener;
import com.facebook.messaging.send.common.SendResult;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.user.model.User;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.widget.ChildSharingFrameLayout;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: selfupdate_post_notification */
public class InboxRecentItemsView extends CustomFrameLayout implements InboxUnitViewWithRecyclerView, ExpandedItemViewHost {
    private static final Class<?> f2924a = InboxRecentItemsView.class;
    @Inject
    private InboxRecentItemsAdapter f2925b;
    @Inject
    private SpringSystem f2926c;
    private BetterRecyclerView f2927d;
    private ViewStubHolder<View> f2928e;
    public ChildSharingFrameLayout f2929f;
    public InboxRecentItemFooter f2930g;
    public ShareFlowSelectorView f2931h;
    public InboxRecentItemsListener f2932i;
    private Spring f2933j;
    private int f2934k;
    private int f2935l;
    public int f2936m;
    public int f2937n;
    public Drawable f2938o;
    @Nullable
    public ExpandedItemState f2939p;

    /* compiled from: selfupdate_post_notification */
    class C04821 implements OnInflateListener<View> {
        final /* synthetic */ InboxRecentItemsView f2913a;

        /* compiled from: selfupdate_post_notification */
        class C04811 implements UserSelectionListener {
            final /* synthetic */ C04821 f2912a;

            C04811(C04821 c04821) {
                this.f2912a = c04821;
            }

            public final void m2883a(User user, FutureCallback<SendResult> futureCallback) {
                Preconditions.checkNotNull(this.f2912a.f2913a.f2939p);
                this.f2912a.f2913a.f2932i.mo90a(this.f2912a.f2913a.f2939p.f2921d, user, (FutureCallback) futureCallback);
            }

            public final void m2882a() {
                Preconditions.checkNotNull(this.f2912a.f2913a.f2939p);
                this.f2912a.f2913a.f2932i.mo89a(this.f2912a.f2913a.f2939p.f2921d);
            }
        }

        C04821(InboxRecentItemsView inboxRecentItemsView) {
            this.f2913a = inboxRecentItemsView;
        }

        public final void m2884a(View view) {
            this.f2913a.f2938o = view.getBackground();
            this.f2913a.f2929f = (ChildSharingFrameLayout) FindViewUtil.b(view, 2131563110);
            this.f2913a.f2930g = (InboxRecentItemFooter) FindViewUtil.b(view, 2131563105);
            this.f2913a.f2931h = (ShareFlowSelectorView) FindViewUtil.b(view, 2131563111);
            this.f2913a.f2931h.c = new C04811(this);
        }
    }

    /* compiled from: selfupdate_post_notification */
    class C04832 extends ItemDecoration {
        final /* synthetic */ InboxRecentItemsView f2914a;

        C04832(InboxRecentItemsView inboxRecentItemsView) {
            this.f2914a = inboxRecentItemsView;
        }

        public final void m2885a(Rect rect, View view, RecyclerView recyclerView, State state) {
            int d = RecyclerView.d(view);
            rect.set(d == 0 ? this.f2914a.f2936m : this.f2914a.f2937n, 0, d == state.e() + -1 ? this.f2914a.f2936m : this.f2914a.f2937n, 0);
        }
    }

    /* compiled from: selfupdate_post_notification */
    class C04843 implements InboxRecentItemsListener {
        final /* synthetic */ InboxRecentItemsView f2915a;

        C04843(InboxRecentItemsView inboxRecentItemsView) {
            this.f2915a = inboxRecentItemsView;
        }

        public final void mo89a(InboxRecentItem inboxRecentItem) {
            if (this.f2915a.f2932i != null) {
                this.f2915a.f2932i.mo89a(inboxRecentItem);
            }
        }

        public final void mo90a(InboxRecentItem inboxRecentItem, User user, FutureCallback<SendResult> futureCallback) {
            if (this.f2915a.f2932i != null) {
                this.f2915a.f2932i.mo90a(inboxRecentItem, user, (FutureCallback) futureCallback);
            }
        }

        public final boolean mo92b(InboxRecentItem inboxRecentItem) {
            if (this.f2915a.f2932i != null) {
                return this.f2915a.f2932i.mo92b(inboxRecentItem);
            }
            return false;
        }

        public final void mo91a(InboxRecentItem inboxRecentItem, String str, @Nullable Map<String, String> map) {
            if (this.f2915a.f2932i != null) {
                this.f2915a.f2932i.mo91a(inboxRecentItem, str, (Map) map);
            }
        }
    }

    /* compiled from: selfupdate_post_notification */
    class C04854 implements Runnable {
        final /* synthetic */ InboxRecentItemsView f2916a;

        C04854(InboxRecentItemsView inboxRecentItemsView) {
            this.f2916a = inboxRecentItemsView;
        }

        public void run() {
            this.f2916a.f2937n;
        }
    }

    /* compiled from: selfupdate_post_notification */
    class ExpandItemSpringListener extends SimpleSpringListener {
        final /* synthetic */ InboxRecentItemsView f2917a;

        public ExpandItemSpringListener(InboxRecentItemsView inboxRecentItemsView) {
            this.f2917a = inboxRecentItemsView;
        }

        public final void m2892c(Spring spring) {
        }

        public final void m2891b(Spring spring) {
            this.f2917a.m2916g();
        }

        public final void m2890a(Spring spring) {
            Double.valueOf(spring.d());
            if (this.f2917a.f2939p != null) {
                this.f2917a.m2902a(spring.d());
            }
        }

        public final void m2893d(Spring spring) {
        }
    }

    /* compiled from: selfupdate_post_notification */
    class ExpandedItemState {
        final View f2918a;
        final ChildSharingFrameLayout f2919b;
        final LayoutParams f2920c;
        final InboxRecentItem f2921d;
        final Rect f2922e;
        final Rect f2923f;

        private ExpandedItemState(View view, ChildSharingFrameLayout childSharingFrameLayout, LayoutParams layoutParams, InboxRecentItem inboxRecentItem, Rect rect, Rect rect2) {
            this.f2918a = (View) Preconditions.checkNotNull(view);
            this.f2919b = (ChildSharingFrameLayout) Preconditions.checkNotNull(childSharingFrameLayout);
            this.f2920c = (LayoutParams) Preconditions.checkNotNull(layoutParams);
            this.f2921d = (InboxRecentItem) Preconditions.checkNotNull(inboxRecentItem);
            this.f2922e = rect;
            this.f2923f = rect2;
        }
    }

    private static <T extends View> void m2906a(Class<T> cls, T t) {
        m2907a((Object) t, t.getContext());
    }

    private static void m2907a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((InboxRecentItemsView) obj).m2903a(new InboxRecentItemsAdapter((Context) fbInjector.getInstance(Context.class)), SpringSystem.b(fbInjector));
    }

    public InboxRecentItemsView(Context context) {
        super(context);
        m2901a();
    }

    public InboxRecentItemsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2901a();
    }

    public InboxRecentItemsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2901a();
    }

    private void m2901a() {
        m2906a(InboxRecentItemsView.class, (View) this);
        setContentView(2130904881);
        this.f2927d = (BetterRecyclerView) c(2131559427);
        this.f2928e = ViewStubHolder.a((ViewStubCompat) c(2131563109));
        getContext();
        this.f2927d.setLayoutManager(new LinearLayoutManager(0, false));
        this.f2927d.setAdapter(this.f2925b);
        this.f2935l = getResources().getDimensionPixelSize(2131433623);
        this.f2934k = getResources().getDimensionPixelSize(2131433622);
        this.f2936m = getResources().getDimensionPixelSize(2131433625);
        this.f2937n = getResources().getDimensionPixelSize(2131433626);
        this.f2928e.c = new C04821(this);
        this.f2927d.a(new C04832(this));
        this.f2925b.f2910c = new C04843(this);
        this.f2933j = this.f2926c.a().a(SpringConfig.a(230.2d, 25.0d)).a(new ExpandItemSpringListener(this));
    }

    public void setUnitData(InboxRecentItemsData inboxRecentItemsData) {
        this.f2925b.f2909b = inboxRecentItemsData.mf_();
        this.f2925b.notifyDataSetChanged();
    }

    public void setListener(InboxRecentItemsListener inboxRecentItemsListener) {
        this.f2932i = inboxRecentItemsListener;
    }

    public BetterRecyclerView getRecyclerView() {
        return this.f2927d;
    }

    public InboxAdapter getInboxAdapter() {
        return this.f2925b;
    }

    public final void mo93a(View view, InboxRecentItem inboxRecentItem) {
        boolean z = false;
        Preconditions.checkNotNull(view);
        Preconditions.checkArgument(view.getParent() instanceof ChildSharingFrameLayout);
        if (this.f2939p == null || view != this.f2939p.f2918a) {
            if (this.f2939p != null) {
                m2909b();
            }
            Rect a = m2894a(view);
            ChildSharingFrameLayout childSharingFrameLayout = (ChildSharingFrameLayout) view.getParent();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.f2928e.a(true);
            this.f2929f.a(view, new LayoutParams(-1, -1));
            this.f2930g.setItem(inboxRecentItem);
            this.f2930g.setVisibility(0);
            this.f2931h.setVisibility(0);
            this.f2931h.a();
            this.f2939p = new ExpandedItemState(view, childSharingFrameLayout, layoutParams, inboxRecentItem, a, m2918h());
            this.f2933j.b(1.0d);
            if (inboxRecentItem instanceof RecentVideoInboxItem) {
                m2905a((RichVideoPlayer) view, "expand_video");
                return;
            }
            return;
        }
        if (this.f2939p.f2918a.getParent() == this.f2929f) {
            z = true;
        }
        Preconditions.checkState(z);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(1);
        int x = (int) childAt.getX();
        int y = (int) childAt.getY();
        int width = childAt.getWidth();
        int height = childAt.getHeight();
        Integer.valueOf(x);
        Integer.valueOf(y);
        Integer.valueOf(width);
        Integer.valueOf(height);
    }

    public final void mo95b(View view, InboxRecentItem inboxRecentItem) {
        Preconditions.checkNotNull(view);
        if (this.f2939p != null && this.f2939p.f2918a == view) {
            this.f2930g.setVisibility(4);
            this.f2931h.setVisibility(4);
            this.f2933j.b(0.0d);
            if (inboxRecentItem instanceof RecentVideoInboxItem) {
                m2905a((RichVideoPlayer) view, "collapse_video");
            }
        }
    }

    private void m2905a(RichVideoPlayer richVideoPlayer, String str) {
        if (this.f2932i != null && this.f2939p != null) {
            Map hashMap = new HashMap();
            hashMap.put("ms", Integer.toString(richVideoPlayer.getCurrentPositionMs()));
            hashMap.put("pc", Integer.toString(Math.round(richVideoPlayer.getPlaybackPercentage() * 100.0f)));
            this.f2932i.mo91a(this.f2939p.f2921d, str, hashMap);
        }
    }

    public final void mo94a(String str, @Nullable Map<String, String> map) {
        Preconditions.checkNotNull(this.f2939p);
        if (this.f2932i != null) {
            this.f2932i.mo91a(this.f2939p.f2921d, str, (Map) map);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -842047698);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f2939p != null) {
            post(new C04854(this));
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1661023567, a);
    }

    private void m2903a(InboxRecentItemsAdapter inboxRecentItemsAdapter, SpringSystem springSystem) {
        this.f2925b = inboxRecentItemsAdapter;
        this.f2926c = springSystem;
    }

    private Rect m2894a(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        getLocationInWindow(iArr);
        rect.offset(-iArr[0], -iArr[1]);
        return rect;
    }

    private void m2909b() {
        Preconditions.checkState(this.f2939p != null);
        this.f2939p.f2919b.a(this.f2939p.f2918a, this.f2939p.f2920c);
        this.f2939p = null;
    }

    public static void m2913e(InboxRecentItemsView inboxRecentItemsView) {
        RecyclerView f = inboxRecentItemsView.m2914f();
        if (f != null) {
            View a = inboxRecentItemsView.m2896a(f);
            if (a != null && (a.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
                int f2 = ((RecyclerView.LayoutParams) a.getLayoutParams()).f();
                if (f2 != -1) {
                    Integer.valueOf(f2);
                    f.a(f2);
                }
            }
        }
    }

    @Nullable
    private RecyclerView m2914f() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof RecyclerView) {
                return (RecyclerView) parent;
            }
        }
        return null;
    }

    @Nullable
    private View m2896a(RecyclerView recyclerView) {
        View view = this;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == recyclerView) {
                return view;
            }
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void m2916g() {
        m2919i();
        if (this.f2933j.d() == 0.0d) {
            m2909b();
        }
    }

    private void m2902a(double d) {
        Rect rect = this.f2939p.f2922e;
        Rect rect2 = this.f2939p.f2923f;
        int width = getWidth() - rect2.width();
        int height = getHeight() - rect2.height();
        int i = rect2.left;
        float a = (float) MathUtil.a((double) (rect.left - i), 0.0d, d);
        float a2 = (float) MathUtil.a((double) (rect.top - rect2.top), 0.0d, d);
        int a3 = ((int) MathUtil.a((double) rect.width(), (double) rect2.width(), d)) + width;
        i = ((int) MathUtil.a((double) rect.height(), (double) rect2.height(), d)) + height;
        Float.valueOf(a);
        Float.valueOf(a2);
        Integer.valueOf(a3);
        Integer.valueOf(i);
        View a4 = this.f2928e.a();
        a4.setX(a);
        a4.setY(a2);
        LayoutParamsUtil.a(a4, a3, i);
        this.f2938o.mutate().setAlpha((int) (MathUtil.b(d, 0.0d, 1.0d) * 255.0d));
        LayoutParamsUtil.a(this, -1, (int) ((float) MathUtil.a((double) this.f2934k, (double) (this.f2935l + this.f2931h.getShareViewHeight()), d)));
    }

    private Rect m2918h() {
        View a = this.f2928e.a();
        a.measure(MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        a.layout(0, 0, getWidth(), getHeight());
        int left = this.f2929f.getLeft();
        int top = this.f2929f.getTop();
        return new Rect(left, top, this.f2929f.getMeasuredWidth() + left, this.f2929f.getMeasuredHeight() + top);
    }

    private void m2919i() {
        View a = this.f2928e.a();
        a.setX(0.0f);
        a.setY(0.0f);
        LayoutParamsUtil.a(a, -1, -1);
    }
}
