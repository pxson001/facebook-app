package com.facebook.tablet.sideshow.widget;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* compiled from: windows-1256 */
public class SideshowExpandableListView extends CustomLinearLayout {
    private Drawable f10137a;
    private Drawable f10138b;
    private AdapterDataSetObserver f10139c;
    private List<View> f10140d;
    private Stack<View> f10141e;
    private SideShowExpandableListAdapter f10142f;
    public OnItemClickedListener f10143g;
    public ListExpansionListener f10144h;
    private View f10145i;
    private ExpandButtonView f10146j;
    public boolean f10147k;
    private boolean f10148l;
    private int f10149m;

    /* compiled from: windows-1256 */
    public interface OnItemClickedListener {
        void mo13a(View view, Object obj);
    }

    /* compiled from: windows-1256 */
    public interface ListExpansionListener {
        void mo14a();

        void mo15b();
    }

    /* compiled from: windows-1256 */
    class AdapterDataSetObserver extends DataSetObserver {
        final /* synthetic */ SideshowExpandableListView f10136a;

        public AdapterDataSetObserver(SideshowExpandableListView sideshowExpandableListView) {
            this.f10136a = sideshowExpandableListView;
        }

        public void onChanged() {
            SideshowExpandableListView.m10204h(this.f10136a);
        }
    }

    /* compiled from: windows-1256 */
    class ExpandButtonView extends CustomFrameLayout {
        public ExpandButtonView(Context context, int i) {
            super(context);
            setContentView(i);
        }

        public Animation getAnimation() {
            return null;
        }
    }

    public SideshowExpandableListView(Context context) {
        super(context);
        m10194a(null, 0);
    }

    public SideshowExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10194a(attributeSet, 0);
    }

    public SideshowExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10194a(attributeSet, i);
    }

    private void m10194a(AttributeSet attributeSet, int i) {
        setOrientation(1);
        Drawable drawable = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SideshowExpandableListView, i, 0);
            this.f10138b = obtainStyledAttributes.getDrawable(2);
            drawable = obtainStyledAttributes.getDrawable(0);
            this.f10137a = obtainStyledAttributes.getDrawable(1);
            this.f10149m = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            obtainStyledAttributes.recycle();
        }
        this.f10140d = new ArrayList();
        this.f10141e = new Stack();
        if (drawable != null) {
            addView(m10192a(drawable));
        }
        if (this.f10137a != null) {
            addView(m10192a(this.f10137a));
        }
        m10197d();
    }

    @TargetApi(11)
    private void m10197d() {
        LayoutTransition layoutTransition = new LayoutTransition();
        if (VERSION.SDK_INT >= 16) {
            layoutTransition.disableTransitionType(3);
        } else {
            layoutTransition.setStartDelay(3, 0);
            layoutTransition.setDuration(3, 0);
        }
        layoutTransition.setStartDelay(1, 0);
        setLayoutTransition(layoutTransition);
    }

    public void setAdapter(SideShowExpandableListAdapter sideShowExpandableListAdapter) {
        if (!(this.f10142f == null || this.f10139c == null)) {
            this.f10142f.unregisterDataSetObserver(this.f10139c);
        }
        this.f10142f = sideShowExpandableListAdapter;
        this.f10139c = new AdapterDataSetObserver(this);
        this.f10142f.registerDataSetObserver(this.f10139c);
        m10204h(this);
    }

    public final View m10206a(View view) {
        if (this.f10145i != null) {
            removeView(this.f10145i);
        }
        this.f10145i = view;
        if (this.f10145i != null) {
            addView(view, 0);
        }
        return this.f10145i;
    }

    public View getHeaderView() {
        return this.f10145i;
    }

    public final View m10209c(int i) {
        if (this.f10146j != null) {
            m10201f();
        }
        this.f10146j = new ExpandButtonView(getContext(), i);
        if (!(this.f10146j == null || this.f10142f == null || this.f10142f.getCount() <= this.f10142f.mo16a())) {
            m10199e();
        }
        return this.f10146j;
    }

    private void m10199e() {
        addView(this.f10146j, getChildCount());
        this.f10148l = true;
    }

    private void m10201f() {
        removeView(this.f10146j);
        this.f10148l = false;
    }

    public View getExpandButtonView() {
        return this.f10146j;
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.f10143g = onItemClickedListener;
    }

    public void setOnExpansionListner(ListExpansionListener listExpansionListener) {
        this.f10144h = listExpansionListener;
    }

    private void m10203g() {
        View a = m10192a(this.f10138b);
        m10195b(a);
        this.f10141e.add(a);
    }

    private View m10192a(Drawable drawable) {
        Preconditions.checkNotNull(drawable);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight == -1) {
            intrinsicHeight = 1;
        }
        View view = new View(getContext());
        CustomViewUtils.b(view, drawable);
        view.setLayoutParams(new LayoutParams(-1, intrinsicHeight));
        return view;
    }

    private void m10195b(View view) {
        int childCount = (this.f10146j == null || !this.f10148l) ? getChildCount() : getChildCount() - 1;
        if (this.f10137a != null) {
            addView(view, childCount - 1);
        } else {
            addView(view, childCount);
        }
    }

    public static void m10204h(SideshowExpandableListView sideshowExpandableListView) {
        int i;
        Preconditions.checkNotNull(sideshowExpandableListView.f10142f);
        if (sideshowExpandableListView.f10140d.size() > sideshowExpandableListView.f10142f.getCount()) {
            sideshowExpandableListView.m10205i();
        }
        int count = sideshowExpandableListView.f10142f.getCount();
        int a = sideshowExpandableListView.f10142f.mo16a();
        if (sideshowExpandableListView.f10147k) {
            i = count;
        } else {
            i = Math.min(count, a);
            sideshowExpandableListView.m10198d(i);
        }
        sideshowExpandableListView.m10200e(i);
        sideshowExpandableListView.m10202f(i);
        if (sideshowExpandableListView.f10146j == null) {
            return;
        }
        if (count > a && !sideshowExpandableListView.f10148l) {
            sideshowExpandableListView.m10199e();
        } else if (count <= a && sideshowExpandableListView.f10148l) {
            sideshowExpandableListView.m10201f();
        }
    }

    private void m10205i() {
        int count = this.f10142f.getCount();
        while (this.f10140d.size() != count) {
            View view = (View) this.f10140d.get(count);
            removeView(view);
            this.f10140d.remove(view);
            if (!this.f10141e.isEmpty()) {
                removeView((View) this.f10141e.pop());
            }
        }
    }

    private void m10198d(int i) {
        for (int size = this.f10140d.size() - 1; size >= i; size--) {
            View view = (View) this.f10140d.get(size);
            removeView(view);
            this.f10140d.remove(view);
            if (!this.f10141e.isEmpty()) {
                removeView((View) this.f10141e.pop());
            }
        }
    }

    private void m10200e(int i) {
        for (int i2 = 0; i2 < this.f10140d.size(); i2++) {
            boolean z;
            View view = (View) this.f10140d.get(i2);
            View view2 = this.f10142f.getView(i2, view, this);
            if (view == view2) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Old view wasn't reused");
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (i2 == i - 1) {
                layoutParams.bottomMargin = this.f10149m;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    private void m10202f(int i) {
        LayoutParams layoutParams = null;
        for (int size = this.f10140d.size(); size < i; size++) {
            View view = this.f10142f.getView(size, null, this);
            final Object item = this.f10142f.getItem(size);
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SideshowExpandableListView f10135b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1467878665);
                    if (this.f10135b.f10143g != null) {
                        this.f10135b.f10143g.mo13a(view, item);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -1572577132, a);
                }
            });
            this.f10140d.add(view);
            layoutParams = new LayoutParams(-1, -2);
            layoutParams.topMargin = this.f10149m;
            if (!(size == 0 || this.f10138b == null)) {
                m10203g();
            }
            view.setLayoutParams(layoutParams);
            m10195b(view);
        }
        if (layoutParams != null) {
            layoutParams.bottomMargin = this.f10149m;
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1748674456);
        super.onAttachedToWindow();
        if (this.f10142f != null && this.f10139c == null) {
            this.f10139c = new AdapterDataSetObserver(this);
            this.f10142f.registerDataSetObserver(this.f10139c);
            m10204h(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 507856219, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1183355352);
        super.onDetachedFromWindow();
        if (this.f10142f != null) {
            this.f10142f.unregisterDataSetObserver(this.f10139c);
            this.f10139c = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1991115552, a);
    }

    public final void m10207a() {
        this.f10147k = false;
        m10204h(this);
        if (this.f10144h != null) {
            this.f10144h.mo14a();
        }
    }

    public final void m10208b() {
        this.f10147k = true;
        m10204h(this);
        if (this.f10144h != null) {
            this.f10144h.mo15b();
        }
    }

    public final boolean m10210c() {
        return this.f10147k;
    }
}
