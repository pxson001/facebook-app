package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.fbui.popover.PopoverViewFlipper.NubShown;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.resources.ui.FbButton;
import com.facebook.richdocument.view.widget.RichTextView.InnerRichTextView;
import javax.inject.Inject;

/* compiled from: onItemRangeMoved is not supported */
public class InstantArticlesTextLongPressWindow extends PopoverWindow implements InjectableComponentWithoutContext {
    @Inject
    public GatekeeperStoreImpl f7218a;
    public FbButton f7219l;
    public FbButton f7220m;
    private int f7221n;
    private int f7222o;
    private boolean f7223p;
    private final int f7224q;
    private final int f7225r;
    private final int f7226s;

    public static void m7485a(Object obj, Context context) {
        ((InstantArticlesTextLongPressWindow) obj).f7218a = GatekeeperStoreImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public InstantArticlesTextLongPressWindow(Context context) {
        this(context, 0);
    }

    private InstantArticlesTextLongPressWindow(Context context, int i) {
        super(context, i);
        Class cls = InstantArticlesTextLongPressWindow.class;
        m7485a(this, context);
        View inflate = LayoutInflater.from(context).inflate(2130904819, null);
        d(inflate);
        c(true);
        b(0.0f);
        this.f7219l = (FbButton) inflate.findViewById(2131562993);
        this.f7220m = (FbButton) inflate.findViewById(2131562994);
        if (this.f7218a.a(109, false)) {
            this.f7220m.setVisibility(0);
        }
        Resources resources = getContext().getResources();
        this.f7224q = resources.getDimensionPixelSize(2131431840);
        this.f7225r = resources.getDimensionPixelSize(2131428372);
        this.f7226s = resources.getDimensionPixelSize(2131428373);
    }

    public final void m7488a(String str) {
        this.f7219l.setText(str);
    }

    public final void m7486a(int i, int i2, boolean z) {
        this.f7221n = i;
        this.f7222o = i2;
        this.f7223p = z;
    }

    protected final void m7487a(View view, boolean z, LayoutParams layoutParams) {
        int i;
        int i2;
        layoutParams.width = -1;
        layoutParams.height = -1;
        int[] iArr = new int[2];
        if (view instanceof InnerRichTextView) {
            ((ViewGroup) view.getParent()).getLocationInWindow(iArr);
        } else {
            view.getLocationInWindow(iArr);
        }
        Object obj = iArr[1] > this.f7224q ? 1 : null;
        int i3 = this.f7221n + iArr[0];
        if (this.f7223p) {
            i = iArr[1] + this.f7222o;
        } else if (obj != null) {
            i = iArr[1];
        } else {
            i = this.f7224q;
        }
        int paddingBottom = this.f.getPaddingBottom() - this.f7225r;
        int paddingTop = this.f.getPaddingTop() - this.f7226s;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        int height = view.getRootView().getHeight();
        int i6 = (i - this.f7224q) + paddingBottom;
        this.g.measure(MeasureSpec.makeMeasureSpec(i4, 0), MeasureSpec.makeMeasureSpec(Math.max(i6, (i5 - i) + paddingTop), Integer.MIN_VALUE));
        int measuredWidth = this.f.getMeasuredWidth();
        int measuredHeight = this.f.getMeasuredHeight();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        if (i3 - (measuredWidth / 2) > 0) {
            i2 = i3 - (measuredWidth / 2);
        } else {
            i2 = -this.f.getPaddingLeft();
        }
        if (i2 + measuredWidth > this.f.getPaddingRight() + i4) {
            i2 = (i4 - measuredWidth) + this.f.getPaddingRight();
        }
        i4 -= measuredWidth + i2;
        layoutParams2.leftMargin = i2;
        layoutParams2.rightMargin = i4;
        if (measuredHeight < i6) {
            layoutParams.windowAnimations = 2131624758;
            layoutParams2.gravity = 80;
            layoutParams.gravity = 80;
            layoutParams.y = (height - i) - paddingBottom;
            this.f.setNubShown(NubShown.ABOVE);
        } else {
            layoutParams.windowAnimations = 2131624757;
            layoutParams2.gravity = 48;
            layoutParams.gravity = 48;
            layoutParams.y = i - paddingTop;
            this.f.setNubShown(NubShown.BELOW);
        }
        this.f.setLayoutParams(layoutParams2);
        this.f.setNubOffset(i3 - i2);
        if (!this.f.b()) {
            layoutParams.windowAnimations = 0;
        }
    }
}
