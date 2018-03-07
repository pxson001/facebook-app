package com.facebook.messaging.montage.composer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.ViewHelper;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: is_prepay_eligible */
public class MontageComposerNavigationView extends LinearLayout {
    private static final SpringConfig f12517b = new SpringConfig(200.0d, 15.0d);
    @Inject
    public SpringSystem f12518a;
    public float f12519c;
    private final int f12520d;
    private final Spring f12521e;
    private MontageComposerNavigationItemView f12522f;
    public OnItemClickListener f12523g;
    private final OnClickListener f12524h;
    private final OnClickListener f12525i;

    /* compiled from: is_prepay_eligible */
    public interface OnItemClickListener {
        void mo487a();

        void mo488a(CanvasType canvasType);

        void mo489a(EditType editType);
    }

    /* compiled from: is_prepay_eligible */
    class C13901 implements OnClickListener {
        final /* synthetic */ MontageComposerNavigationView f12510a;

        C13901(MontageComposerNavigationView montageComposerNavigationView) {
            this.f12510a = montageComposerNavigationView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 682274233);
            if (this.f12510a.f12523g == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 410680437, a);
                return;
            }
            Object tag = view.getTag();
            if (tag == null) {
                LogUtils.a(-911479278, a);
                return;
            }
            if (tag instanceof CanvasType) {
                CanvasType canvasType = (CanvasType) tag;
                this.f12510a.m12989b(canvasType);
                this.f12510a.f12523g.mo488a(canvasType);
            } else if (tag instanceof EditType) {
                this.f12510a.f12523g.mo489a((EditType) tag);
            }
            LogUtils.a(-351508657, a);
        }
    }

    /* compiled from: is_prepay_eligible */
    class C13912 implements OnClickListener {
        final /* synthetic */ MontageComposerNavigationView f12511a;

        C13912(MontageComposerNavigationView montageComposerNavigationView) {
            this.f12511a = montageComposerNavigationView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -990986408);
            if (this.f12511a.f12523g != null) {
                this.f12511a.f12523g.mo487a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -324033324, a);
        }
    }

    /* compiled from: is_prepay_eligible */
    class BackgroundFadeListener extends SimpleSpringListener {
        final /* synthetic */ MontageComposerNavigationView f12512a;

        public BackgroundFadeListener(MontageComposerNavigationView montageComposerNavigationView) {
            this.f12512a = montageComposerNavigationView;
        }

        public final void m12973a(Spring spring) {
            this.f12512a.f12519c = (float) spring.d();
            this.f12512a.invalidate();
        }
    }

    /* compiled from: is_prepay_eligible */
    public class TabItem {
        final CanvasType f12513a;
        final EditType f12514b;
        @DrawableRes
        public int f12515c;
        @StringRes
        public int f12516d;

        TabItem() {
            this.f12513a = null;
            this.f12514b = null;
        }

        public TabItem(CanvasType canvasType) {
            this.f12513a = (CanvasType) Preconditions.checkNotNull(canvasType, "Must specify canvas type");
            this.f12514b = null;
        }

        public TabItem(EditType editType) {
            this.f12514b = (EditType) Preconditions.checkNotNull(editType, "Must specify freeform type");
            this.f12513a = null;
        }

        public final TabItem m12974a(@StringRes int i) {
            this.f12516d = i;
            return this;
        }

        public final TabItem m12975b(@DrawableRes int i) {
            this.f12515c = i;
            return this;
        }
    }

    private static <T extends View> void m12980a(Class<T> cls, T t) {
        m12981a((Object) t, t.getContext());
    }

    private static void m12981a(Object obj, Context context) {
        ((MontageComposerNavigationView) obj).f12518a = SpringSystem.b(FbInjector.get(context));
    }

    public MontageComposerNavigationView(Context context) {
        this(context, null);
    }

    public MontageComposerNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void m12979a(SpringSystem springSystem) {
        this.f12518a = springSystem;
    }

    public MontageComposerNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12524h = new C13901(this);
        this.f12525i = new C13912(this);
        m12980a(MontageComposerNavigationView.class, (View) this);
        this.f12520d = ContextCompat.b(context, 2131363802);
        this.f12519c = getBackgroundColorAlpha();
        Spring l = this.f12518a.a().a(f12517b).a((double) getBackgroundColorAlpha()).l();
        l.c = true;
        this.f12521e = l.a(new BackgroundFadeListener(this));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f12523g = onItemClickListener;
    }

    public final void m12988a(TabItem tabItem) {
        MontageComposerNavigationItemView b = m12983b(tabItem);
        b.setOnClickListener(this.f12524h);
        addView(b);
    }

    final void m12987a(CanvasType canvasType) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getTag() == canvasType) {
                childAt.performClick();
                return;
            }
        }
    }

    final void m12989b(CanvasType canvasType) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            boolean z;
            View childAt = getChildAt(i);
            if (childAt == this.f12522f || childAt.getTag() == canvasType) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
        }
    }

    public final void m12986a(int i) {
        Resources resources = getResources();
        View view = new View(getContext());
        ViewHelper.a(view, ContextCompat.b(getContext(), 2131363804));
        super.addView(view, i, new LayoutParams(resources.getDimensionPixelSize(2131427382), resources.getDimensionPixelSize(2131433685)));
    }

    public final void m12985a(@FloatRange float f) {
        this.f12521e.b((double) (getBackgroundColorAlpha() * f));
    }

    public void setPrimaryMode(@Nullable CanvasType canvasType) {
        if (canvasType == null) {
            m12984b();
        } else {
            m12978a();
        }
    }

    private void m12978a() {
        if (this.f12522f == null) {
            TabItem tabItem = new TabItem();
            tabItem.f12516d = 2131240936;
            tabItem = tabItem;
            tabItem.f12515c = 2130841433;
            this.f12522f = m12983b(tabItem);
            this.f12522f.setSelected(true);
            this.f12522f.setOnClickListener(this.f12525i);
            addView(this.f12522f);
        }
        this.f12522f.setVisibility(0);
    }

    private void m12984b() {
        if (this.f12522f != null) {
            this.f12522f.setVisibility(8);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MontageComposerNavigationItemView) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("Only MontageComposerNavigationItemView children can be added to this view");
    }

    protected void dispatchDraw(Canvas canvas) {
        canvas.drawColor(ColorUtils.b(this.f12520d, (int) (255.0f * this.f12519c)));
        super.dispatchDraw(canvas);
    }

    @TargetApi(21)
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        if (!getFitsSystemWindows()) {
            return super.onApplyWindowInsets(windowInsets);
        }
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + windowInsets.getSystemWindowInsetBottom());
        return windowInsets.consumeSystemWindowInsets();
    }

    private MontageComposerNavigationItemView m12983b(TabItem tabItem) {
        MontageComposerNavigationItemView montageComposerNavigationItemView = new MontageComposerNavigationItemView(getContext());
        montageComposerNavigationItemView.f12508c.setImageResource(tabItem.f12515c);
        montageComposerNavigationItemView.setContentDescription(getResources().getString(tabItem.f12516d));
        montageComposerNavigationItemView.setLayoutParams(m12982b(1.0f));
        if (tabItem.f12513a != null) {
            montageComposerNavigationItemView.setTag(tabItem.f12513a);
        } else if (tabItem.f12514b != null) {
            montageComposerNavigationItemView.setTag(tabItem.f12514b);
        }
        return montageComposerNavigationItemView;
    }

    private static LayoutParams m12982b(float f) {
        return new LayoutParams(0, -1, f);
    }

    private float getBackgroundColorAlpha() {
        return ((float) Color.alpha(this.f12520d)) / 255.0f;
    }
}
