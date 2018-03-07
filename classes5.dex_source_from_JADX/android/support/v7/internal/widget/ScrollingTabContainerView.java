package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.widget.AdapterViewCompat.OnItemClickListener;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: undo */
public class ScrollingTabContainerView extends HorizontalScrollView implements OnItemClickListener {
    private static final Interpolator f1134l = new DecelerateInterpolator();
    Runnable f1135a;
    int f1136b;
    int f1137c;
    protected ViewPropertyAnimatorCompat f1138d;
    protected final VisibilityAnimListener f1139e = new VisibilityAnimListener(this);
    public TabClickListener f1140f;
    public LinearLayoutCompat f1141g;
    private SpinnerCompat f1142h;
    public boolean f1143i;
    public int f1144j;
    private int f1145k;

    /* compiled from: undo */
    class TabAdapter extends BaseAdapter {
        final /* synthetic */ ScrollingTabContainerView f1123a;

        public TabAdapter(ScrollingTabContainerView scrollingTabContainerView) {
            this.f1123a = scrollingTabContainerView;
        }

        public int getCount() {
            return this.f1123a.f1141g.getChildCount();
        }

        public Object getItem(int i) {
            return ((TabView) this.f1123a.f1141g.getChildAt(i)).f1127c;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                ScrollingTabContainerView scrollingTabContainerView = this.f1123a;
                View tabView = new TabView(scrollingTabContainerView, scrollingTabContainerView.getContext(), (Tab) getItem(i), true);
                if (1 != null) {
                    tabView.setBackgroundDrawable(null);
                    tabView.setLayoutParams(new LayoutParams(-1, scrollingTabContainerView.f1144j));
                } else {
                    tabView.setFocusable(true);
                    if (scrollingTabContainerView.f1140f == null) {
                        scrollingTabContainerView.f1140f = new TabClickListener(scrollingTabContainerView);
                    }
                    tabView.setOnClickListener(scrollingTabContainerView.f1140f);
                }
                return tabView;
            }
            ((TabView) view).m1634a((Tab) getItem(i));
            return view;
        }
    }

    /* compiled from: undo */
    public class TabClickListener implements OnClickListener {
        final /* synthetic */ ScrollingTabContainerView f1124a;

        public TabClickListener(ScrollingTabContainerView scrollingTabContainerView) {
            this.f1124a = scrollingTabContainerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -107638904);
            ((TabView) view).f1127c.mo260e();
            int childCount = this.f1124a.f1141g.getChildCount();
            for (int i = 0; i < childCount; i++) {
                boolean z;
                View childAt = this.f1124a.f1141g.getChildAt(i);
                if (childAt == view) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
            LogUtils.a(-1111106952, a);
        }
    }

    /* compiled from: undo */
    public class TabView extends LinearLayoutCompat implements OnLongClickListener {
        final /* synthetic */ ScrollingTabContainerView f1125a;
        private final int[] f1126b = new int[]{16842964};
        public Tab f1127c;
        private TextView f1128d;
        private ImageView f1129e;
        private View f1130f;

        public TabView(ScrollingTabContainerView scrollingTabContainerView, Context context, Tab tab, boolean z) {
            this.f1125a = scrollingTabContainerView;
            super(context, null, 2130771978);
            this.f1127c = tab;
            TintTypedArray a = TintTypedArray.m1693a(context, null, this.f1126b, 2130771978, 0);
            if (a.m1702d(0)) {
                setBackgroundDrawable(a.m1695a(0));
            }
            a.m1698b();
            if (z) {
                setGravity(8388627);
            }
            m1633b();
        }

        public final void m1634a(Tab tab) {
            this.f1127c = tab;
            m1633b();
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(Tab.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(Tab.class.getName());
            }
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f1125a.f1136b > 0 && getMeasuredWidth() > this.f1125a.f1136b) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f1125a.f1136b, 1073741824), i2);
            }
        }

        private void m1633b() {
            Tab tab = this.f1127c;
            View d = tab.mo259d();
            if (d != null) {
                TabView parent = d.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(d);
                    }
                    addView(d);
                }
                this.f1130f = d;
                if (this.f1128d != null) {
                    this.f1128d.setVisibility(8);
                }
                if (this.f1129e != null) {
                    this.f1129e.setVisibility(8);
                    this.f1129e.setImageDrawable(null);
                    return;
                }
                return;
            }
            boolean z;
            if (this.f1130f != null) {
                removeView(this.f1130f);
                this.f1130f = null;
            }
            Drawable b = tab.mo257b();
            CharSequence c = tab.mo258c();
            if (b != null) {
                if (this.f1129e == null) {
                    View imageView = new ImageView(getContext());
                    ViewGroup.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.f1294h = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView, 0);
                    this.f1129e = imageView;
                }
                this.f1129e.setImageDrawable(b);
                this.f1129e.setVisibility(0);
            } else if (this.f1129e != null) {
                this.f1129e.setVisibility(8);
                this.f1129e.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(c)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.f1128d == null) {
                    imageView = new CompatTextView(getContext(), null, 2130771980);
                    imageView.setEllipsize(TruncateAt.END);
                    layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.f1294h = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView);
                    this.f1128d = imageView;
                }
                this.f1128d.setText(c);
                this.f1128d.setVisibility(0);
            } else if (this.f1128d != null) {
                this.f1128d.setVisibility(8);
                this.f1128d.setText(null);
            }
            if (this.f1129e != null) {
                this.f1129e.setContentDescription(tab.mo261f());
            }
            if (z || TextUtils.isEmpty(tab.mo261f())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f1127c.mo261f(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }
    }

    /* compiled from: undo */
    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        final /* synthetic */ ScrollingTabContainerView f1131a;
        private boolean f1132b = false;
        private int f1133c;

        protected VisibilityAnimListener(ScrollingTabContainerView scrollingTabContainerView) {
            this.f1131a = scrollingTabContainerView;
        }

        public final void mo87a(View view) {
            this.f1131a.setVisibility(0);
            this.f1132b = false;
        }

        public final void mo88b(View view) {
            if (!this.f1132b) {
                this.f1131a.f1138d = null;
                this.f1131a.setVisibility(this.f1133c);
            }
        }

        public final void mo89c(View view) {
            this.f1132b = true;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy a = ActionBarPolicy.m1276a(context);
        setContentHeight(a.m1278e());
        this.f1137c = a.m1279g();
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, 2130771979);
        linearLayoutCompat.mUseLargestChild = true;
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        this.f1141g = linearLayoutCompat;
        addView(this.f1141g, new ViewGroup.LayoutParams(-2, -1));
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f1141g.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1136b = -1;
        } else {
            if (childCount > 2) {
                this.f1136b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f1136b = MeasureSpec.getSize(i) / 2;
            }
            this.f1136b = Math.min(this.f1136b, this.f1137c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f1144j, 1073741824);
        if (z || !this.f1143i) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f1141g.measure(0, mode);
            if (this.f1141g.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m1639b();
            } else {
                m1640c();
            }
        } else {
            m1640c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f1145k);
        }
    }

    private boolean m1638a() {
        return this.f1142h != null && this.f1142h.getParent() == this;
    }

    private void m1639b() {
        if (!m1638a()) {
            if (this.f1142h == null) {
                SpinnerCompat spinnerCompat = new SpinnerCompat(getContext(), null, 2130772010);
                spinnerCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                spinnerCompat.m1671a((OnItemClickListener) this);
                this.f1142h = spinnerCompat;
            }
            removeView(this.f1141g);
            addView(this.f1142h, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1142h.f976a == null) {
                this.f1142h.mo374a(new TabAdapter(this));
            }
            if (this.f1135a != null) {
                removeCallbacks(this.f1135a);
                this.f1135a = null;
            }
            this.f1142h.setSelection(this.f1145k);
        }
    }

    private boolean m1640c() {
        if (m1638a()) {
            removeView(this.f1142h);
            addView(this.f1141g, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f1142h.f970v);
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.f1145k = i;
        int childCount = this.f1141g.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.f1141g.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                m1641a(i);
            }
        }
        if (this.f1142h != null && i >= 0) {
            this.f1142h.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f1144j = i;
        requestLayout();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        ActionBarPolicy a = ActionBarPolicy.m1276a(getContext());
        setContentHeight(a.m1278e());
        this.f1137c = a.m1279g();
    }

    public final void m1641a(int i) {
        final View childAt = this.f1141g.getChildAt(i);
        if (this.f1135a != null) {
            removeCallbacks(this.f1135a);
        }
        this.f1135a = new Runnable(this) {
            final /* synthetic */ ScrollingTabContainerView f1122b;

            public void run() {
                this.f1122b.smoothScrollTo(childAt.getLeft() - ((this.f1122b.getWidth() - childAt.getWidth()) / 2), 0);
                this.f1122b.f1135a = null;
            }
        };
        post(this.f1135a);
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1157115774);
        super.onAttachedToWindow();
        if (this.f1135a != null) {
            post(this.f1135a);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1450297046, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -680668683);
        super.onDetachedFromWindow();
        if (this.f1135a != null) {
            removeCallbacks(this.f1135a);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2141632378, a);
    }

    public final void mo367a(View view) {
        ((TabView) view).f1127c.mo260e();
    }
}
