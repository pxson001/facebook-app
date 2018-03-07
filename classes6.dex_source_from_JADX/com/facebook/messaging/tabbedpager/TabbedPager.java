package com.facebook.messaging.tabbedpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: isTrimSpecified */
public class TabbedPager extends CustomLinearLayout {
    public TabbedPagerAdapter f12136a;
    public TabListAdapter f12137b;
    private TextView f12138c;
    private LinearLayoutManager f12139d;
    private RecyclerView f12140e;
    public TabbedPageIndicator f12141f;
    private View f12142g;
    private ImageButton f12143h;
    private TextView f12144i;
    private View f12145j;
    private ImageButton f12146k;
    private TextView f12147l;
    private ViewPager f12148m;
    public boolean f12149n;
    private boolean f12150o;
    public Listener f12151p;
    public ItemBasedTabbedPagerAdapter f12152q;
    private String f12153r;
    private int f12154s = -1;

    /* compiled from: isTrimSpecified */
    class C07871 extends OnScrollListener {
        final /* synthetic */ TabbedPager f12133a;

        C07871(TabbedPager tabbedPager) {
            this.f12133a = tabbedPager;
        }

        public final void m19066a(RecyclerView recyclerView, int i, int i2) {
            this.f12133a.f12141f.invalidate();
        }
    }

    /* compiled from: isTrimSpecified */
    class C07882 implements OnPageChangeListener {
        final /* synthetic */ TabbedPager f12134a;

        C07882(TabbedPager tabbedPager) {
            this.f12134a = tabbedPager;
        }

        public final void m19067a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            TabbedPager.m19082d(this.f12134a, i);
        }

        public final void m19068b(int i) {
        }
    }

    /* compiled from: isTrimSpecified */
    public class C07893 {
        final /* synthetic */ TabbedPager f12135a;

        C07893(TabbedPager tabbedPager) {
            this.f12135a = tabbedPager;
        }

        public final void m19069a(int i) {
            if (this.f12135a.f12152q.mo1284e(this.f12135a.f12136a.f12162d.get(i))) {
                TabbedPager.m19082d(this.f12135a, i);
                TabbedPager.m19084e(this.f12135a, i);
            }
        }
    }

    /* compiled from: isTrimSpecified */
    public interface Listener {
        void mo1270a(Object obj);
    }

    private static <T extends View> void m19075a(Class<T> cls, T t) {
        m19076a((Object) t, t.getContext());
    }

    private static void m19076a(Object obj, Context context) {
        ((TabbedPager) obj).f12136a = TabbedPagerAdapter.m19094b(FbInjector.get(context));
    }

    public TabbedPager(Context context) {
        super(context);
        m19072a(context, null);
    }

    public TabbedPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19072a(context, attributeSet);
    }

    private void m19072a(Context context, AttributeSet attributeSet) {
        m19075a(TabbedPager.class, (View) this);
        setContentView(2130905871);
        this.f12138c = (TextView) a(2131564429);
        this.f12140e = (RecyclerView) a(2131565174);
        this.f12141f = (TabbedPageIndicator) a(2131563265);
        this.f12142g = a(2131565173);
        this.f12143h = (ImageButton) a(2131565171);
        this.f12144i = (TextView) a(2131565172);
        this.f12145j = a(2131565175);
        this.f12146k = (ImageButton) a(2131565176);
        this.f12147l = (TextView) a(2131565177);
        this.f12148m = (ViewPager) a(2131562217);
        this.f12139d = new LinearLayoutManager(context);
        this.f12139d.b(0);
        this.f12140e.setLayoutManager(this.f12139d);
        this.f12140e.setItemAnimator(new DefaultItemAnimator());
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TabbedPager);
        if (obtainStyledAttributes.peekValue(0) != null) {
            this.f12153r = ResourceUtils.a(context, obtainStyledAttributes, 0);
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f12146k.getDrawable().setColorFilter(obtainStyledAttributes.getColor(1, 0), Mode.SRC_IN);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.f12150o = obtainStyledAttributes.getBoolean(2, false);
        }
        obtainStyledAttributes.recycle();
        setOrientation(1);
        this.f12148m.setAdapter(this.f12136a);
    }

    @Inject
    private void m19074a(TabbedPagerAdapter tabbedPagerAdapter) {
        this.f12136a = tabbedPagerAdapter;
    }

    public final void m19085a() {
        this.f12149n = true;
        this.f12141f.setViewPager(this.f12148m);
        this.f12141f.f12125b = this.f12140e;
        this.f12140e.setOnScrollListener(new C07871(this));
        this.f12141f.f12127d = new C07882(this);
        if (Strings.isNullOrEmpty(this.f12153r)) {
            this.f12138c.setVisibility(8);
            return;
        }
        this.f12138c.setVisibility(0);
        this.f12138c.setText(this.f12153r);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m19083e();
    }

    public TabbedPageIndicator getTabbedPageIndicator() {
        return this.f12141f;
    }

    public final boolean m19089b() {
        return this.f12149n;
    }

    public void setListener(Listener listener) {
        this.f12151p = listener;
    }

    public void setAdapter(ItemBasedTabbedPagerAdapter itemBasedTabbedPagerAdapter) {
        this.f12152q = itemBasedTabbedPagerAdapter;
        this.f12136a.m19101a(itemBasedTabbedPagerAdapter);
        this.f12137b = new TabListAdapter();
        this.f12137b.m19059a(itemBasedTabbedPagerAdapter);
        this.f12137b.f12120b = new C07893(this);
        this.f12140e.setAdapter(this.f12137b);
        m19080c();
    }

    public TabListAdapter getTabListAdapter() {
        return this.f12137b;
    }

    public void setItems(List<?> list) {
        this.f12136a.m19102a((List) list);
        this.f12137b.m19060a((List) list);
        m19080c();
    }

    public final void m19086a(int i, Object obj) {
        List arrayList = new ArrayList();
        arrayList.addAll(this.f12136a.f12162d);
        arrayList.add(i, obj);
        this.f12136a.m19102a(arrayList);
        this.f12137b.m19057a(i, obj);
    }

    public final void m19090c(int i) {
        List arrayList = new ArrayList();
        Object obj = this.f12154s == i ? 1 : null;
        arrayList.addAll(this.f12136a.f12162d);
        arrayList.remove(i);
        this.f12136a.m19102a(arrayList);
        this.f12137b.m19061e(i);
        if (obj != null) {
            m19084e(this, this.f12154s);
            this.f12151p.mo1270a(arrayList.get(this.f12154s));
        }
    }

    public int getTabCount() {
        return this.f12136a.b();
    }

    public void setShowStartTabButton(boolean z) {
        int i;
        int i2 = 0;
        ImageButton imageButton = this.f12143h;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        imageButton.setVisibility(i);
        View view = this.f12142g;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
        m19083e();
    }

    public void setStartTabButtonOnClickListener(OnClickListener onClickListener) {
        this.f12143h.setOnClickListener(onClickListener);
    }

    public void setStartTabButtonContentDescription(String str) {
        this.f12143h.setContentDescription(str);
    }

    public void setStartTabButtonBadgeVisibility(boolean z) {
        this.f12144i.setVisibility(z ? 0 : 8);
    }

    public void setStartTabButtonBadgeText(String str) {
        this.f12144i.setText(str);
    }

    public void setShowEndTabButton(boolean z) {
        int i;
        int i2 = 0;
        ImageButton imageButton = this.f12146k;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        imageButton.setVisibility(i);
        View view = this.f12145j;
        if (!z || this.f12150o) {
            i2 = 8;
        }
        view.setVisibility(i2);
        m19083e();
    }

    public void setEndTabButtonOnClickListener(OnClickListener onClickListener) {
        this.f12146k.setOnClickListener(onClickListener);
    }

    public void setEndTabButtonOnTouchListener(OnTouchListener onTouchListener) {
        this.f12146k.setOnTouchListener(onTouchListener);
    }

    public void setEndTabButtonContentDescription(String str) {
        this.f12146k.setContentDescription(str);
    }

    public void setEndTabButtonBadgeVisibility(boolean z) {
        this.f12147l.setVisibility(z ? 0 : 8);
    }

    public void setEndTabButtonBadgeText(String str) {
        this.f12147l.setText(str);
    }

    public final void m19087a(String str) {
        int a = this.f12136a.m19098a(str);
        this.f12137b.f12123e = str;
        if (a >= 0) {
            m19082d(this, a);
        }
    }

    public final void m19088a(String str, int i) {
        int a = this.f12136a.m19098a(str);
        if (a != -1) {
            if (i < this.f12140e.getMeasuredWidth()) {
                this.f12139d.d(a, i);
            } else {
                this.f12140e.a(Math.max(0, a - 1));
            }
        }
    }

    public int getTabContainerScrollOffsetToRestore() {
        int i = 0;
        if (this.f12140e.getChildCount() == 0) {
            return 0;
        }
        int width = this.f12140e.getWidth();
        int width2 = this.f12140e.getChildAt(0).getWidth();
        int m = this.f12139d.m();
        int o = this.f12139d.o();
        if (m > this.f12154s - 1) {
            if (this.f12154s > 0) {
                return width2;
            }
            return 0;
        } else if (o < this.f12154s + 1) {
            if (this.f12154s < this.f12136a.f12162d.size() - 1) {
                i = 1;
            }
            return width - ((i + 1) * width2);
        } else {
            return this.f12140e.getChildAt(this.f12154s - this.f12139d.l()).getLeft();
        }
    }

    private void m19080c() {
        if (this.f12136a != null) {
            this.f12138c.setVisibility(this.f12136a.f12162d.size() > 0 ? 8 : 0);
        }
    }

    public static void m19082d(TabbedPager tabbedPager, int i) {
        ImmutableList immutableList = tabbedPager.f12136a.f12162d;
        if (i < 0 || i >= immutableList.size()) {
            i = 0;
        }
        if (i != tabbedPager.f12154s) {
            if (tabbedPager.f12154s >= 0 && tabbedPager.f12154s < immutableList.size()) {
                immutableList.get(tabbedPager.f12154s);
            }
            tabbedPager.f12154s = i;
            tabbedPager.f12152q.mo1283d(immutableList.get(i));
            if (tabbedPager.f12151p != null) {
                tabbedPager.f12151p.mo1270a(immutableList.get(i));
            }
            tabbedPager.f12148m.setCurrentItem(i);
            tabbedPager.m19081d();
            m19084e(tabbedPager, i);
        }
    }

    private void m19081d() {
        int l = this.f12139d.l();
        for (int i = 0; i < this.f12140e.getChildCount(); i++) {
            boolean z;
            if (l + i == this.f12154s) {
                z = true;
            } else {
                z = false;
            }
            this.f12140e.getChildAt(i).setSelected(z);
        }
    }

    public static void m19084e(TabbedPager tabbedPager, int i) {
        if (tabbedPager.f12140e.getChildCount() != 0) {
            if (tabbedPager.f12139d.l() >= i - 1) {
                View childAt = tabbedPager.f12140e.getChildAt(0);
                float l = (float) ((tabbedPager.f12139d.l() * childAt.getWidth()) - childAt.getLeft());
                tabbedPager.f12140e.a((int) (((float) (childAt.getWidth() * Math.max(i - 1, 0))) - l), 0);
            } else if (tabbedPager.f12139d.n() <= i + 1 && tabbedPager.f12139d.n() < tabbedPager.f12136a.b()) {
                int min = Math.min(i + 1, tabbedPager.f12136a.f12162d.size() - 1);
                View childAt2 = tabbedPager.f12140e.getChildAt(tabbedPager.f12140e.getChildCount() - 1);
                float width = (float) ((min + 1) * childAt2.getWidth());
                tabbedPager.f12140e.a((int) (width - ((float) (((tabbedPager.f12139d.n() * childAt2.getWidth()) + tabbedPager.f12140e.getWidth()) - childAt2.getLeft()))), 0);
            }
        }
    }

    private void m19083e() {
        this.f12141f.setLeftTrackPadding(this.f12140e.getLeft());
        this.f12141f.setRightTrackPadding(getWidth() - this.f12140e.getRight());
    }
}
