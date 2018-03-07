package com.facebook.fbui.widget.inlineactionbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v7.internal.view.menu.BaseMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar.InlineActionBarActionItemsSelectedHandler;
import java.util.ArrayList;

/* compiled from: source_group_id */
public final class InlineActionMenuPresenter extends BaseMenuPresenter {
    private Context f3619g;
    public InlineActionBarActionItemsSelectedHandler f3620h;
    public int f3621i;
    public int f3622j;
    public ColorStateList f3623k;
    private OverflowMenuButton f3624l;
    public int f3625m;
    public boolean f3626n;
    private int f3627o;
    public int f3628p;
    public int f3629q;
    public OverflowPopup f3630r;
    public OpenOverflowRunnable f3631s;

    /* compiled from: source_group_id */
    class OpenOverflowRunnable implements Runnable {
        final /* synthetic */ InlineActionMenuPresenter f3608a;
        private OverflowPopup f3609b;

        public OpenOverflowRunnable(InlineActionMenuPresenter inlineActionMenuPresenter, OverflowPopup overflowPopup) {
            this.f3608a = inlineActionMenuPresenter;
            this.f3609b = overflowPopup;
        }

        public void run() {
            this.f3608a.c.e();
            View view = (View) this.f3608a.f;
            if (!(view == null || view.getWindowToken() == null || !this.f3609b.m4333a())) {
                this.f3608a.f3630r = this.f3609b;
            }
            this.f3608a.f3631s = null;
        }
    }

    /* compiled from: source_group_id */
    class OverflowMenuButton extends GlyphButton {
        final /* synthetic */ InlineActionMenuPresenter f3610b;

        public OverflowMenuButton(InlineActionMenuPresenter inlineActionMenuPresenter, Context context) {
            this.f3610b = inlineActionMenuPresenter;
            super(context, null, 2130773375);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setContentDescription(context.getString(2131234849));
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.f3610b.m4354c();
            }
            return true;
        }
    }

    /* compiled from: source_group_id */
    class OverflowPopup extends PopoverMenuWindowHelper {
        final /* synthetic */ InlineActionMenuPresenter f3618a;

        public OverflowPopup(InlineActionMenuPresenter inlineActionMenuPresenter, Context context, MenuBuilder menuBuilder, View view, boolean z) {
            this.f3618a = inlineActionMenuPresenter;
            super(context, menuBuilder, view, z);
        }

        public final boolean mo173a(PopoverWindow popoverWindow) {
            super.mo173a(popoverWindow);
            this.f3618a.c.close();
            this.f3618a.f3630r = null;
            return true;
        }
    }

    public InlineActionMenuPresenter(Context context) {
        super(context, 0, 0);
        this.f3619g = context;
    }

    public final void m4346a(Context context, MenuBuilder menuBuilder) {
        super.a(context, menuBuilder);
        if (!this.f3626n) {
            Resources resources = context.getResources();
            this.f3625m = resources.getDisplayMetrics().widthPixels;
            this.f3629q = resources.getDimensionPixelSize(2131429814);
        }
        int i = this.f3625m;
        if (this.f3624l == null) {
            this.f3624l = new OverflowMenuButton(this, this.a);
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            this.f3624l.measure(makeMeasureSpec, makeMeasureSpec);
        }
        this.f3627o = i - this.f3624l.getMeasuredWidth();
    }

    public final MenuView m4344a(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = (MenuView) viewGroup;
        }
        return this.f;
    }

    public final ItemView m4351b(ViewGroup viewGroup) {
        return new InlineActionButton(this.f3619g);
    }

    public final View m4345a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null) {
            if (!(view instanceof InlineActionButton)) {
                view = null;
            }
            actionView = super.a(menuItemImpl, view, viewGroup);
        }
        InlineActionBar inlineActionBar = (InlineActionBar) viewGroup;
        if (!inlineActionBar.checkLayoutParams(actionView.getLayoutParams())) {
            actionView.setLayoutParams(inlineActionBar.generateDefaultLayoutParams());
        }
        return actionView;
    }

    public final void m4348a(MenuItemImpl menuItemImpl, ItemView itemView) {
        InlineActionButton inlineActionButton = (InlineActionButton) itemView;
        inlineActionButton.m4329a(menuItemImpl);
        inlineActionButton.setTextAppearance(this.f3619g, this.f3621i);
        inlineActionButton.setGlyphColor(this.f3623k);
        inlineActionButton.f3603c = (InlineActionBar) this.f;
        if (menuItemImpl.getItemId() > 0) {
            inlineActionButton.setId(menuItemImpl.getItemId());
        }
    }

    public final boolean m4349a(MenuItemImpl menuItemImpl) {
        return menuItemImpl.j();
    }

    public final void m4352b(boolean z) {
        int i = 1;
        int i2 = 0;
        super.b(z);
        if (this.f != null) {
            int size;
            InlineActionBar inlineActionBar;
            ArrayList m = this.c != null ? this.c.m() : null;
            if (m != null) {
                size = m.size();
                if (size != 1 && size <= 0) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                if (this.f3624l == null) {
                    this.f3624l = new OverflowMenuButton(this, this.a);
                }
                ViewGroup viewGroup = (ViewGroup) this.f3624l.getParent();
                if (viewGroup != this.f) {
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f3624l);
                    }
                    inlineActionBar = (InlineActionBar) this.f;
                    inlineActionBar.addView(this.f3624l, inlineActionBar.generateDefaultLayoutParams());
                }
            } else if (this.f3624l != null && this.f3624l.getParent() == this.f) {
                ((ViewGroup) this.f).removeView(this.f3624l);
            }
            inlineActionBar = (InlineActionBar) this.f;
            size = inlineActionBar.getChildCount();
            if (size > 0 && this.f3622j > 0) {
                while (i2 < size) {
                    View childAt = inlineActionBar.getChildAt(i2);
                    childAt.setBackgroundResource(this.f3622j);
                    childAt.getLayoutParams();
                    i2++;
                }
            }
        }
    }

    public final boolean m4350a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f3624l) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    public final boolean m4354c() {
        if (m4357f() || this.c == null || this.f == null || this.f3631s != null) {
            return false;
        }
        this.f3631s = new OpenOverflowRunnable(this, new OverflowPopup(this, this.f3619g, this.c, this.f3624l, true));
        ((View) this.f).post(this.f3631s);
        return true;
    }

    public final boolean m4355d() {
        if (this.f3631s == null || this.f == null) {
            PopoverMenuWindowHelper popoverMenuWindowHelper = this.f3630r;
            if (popoverMenuWindowHelper == null) {
                return false;
            }
            popoverMenuWindowHelper.m4340c();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f3631s);
        this.f3631s = null;
        return true;
    }

    public final boolean m4356e() {
        return m4355d();
    }

    public final boolean m4357f() {
        return this.f3630r != null && this.f3630r.m4342d();
    }

    public final boolean m4353b() {
        int i;
        ArrayList j = this.c.j();
        int size = j.size();
        int i2 = this.f3628p;
        int i3 = this.f3627o;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            int i7;
            boolean z2;
            MenuItemImpl menuItemImpl = (MenuItemImpl) j.get(i4);
            if (menuItemImpl.l()) {
                boolean z3 = z;
                i7 = i5;
                i5 = i6 + 1;
                z2 = z3;
            } else if (menuItemImpl.k()) {
                i = i5 + 1;
                i5 = i6;
                int i8 = i;
                z2 = z;
                i7 = i8;
            } else {
                z2 = true;
                i7 = i5;
                i5 = i6;
            }
            i4++;
            i6 = i5;
            i5 = i7;
            z = z2;
        }
        if (z || i6 + i5 > i2) {
            i = i2 - 1;
        } else {
            i = i2;
        }
        i6 = i - i6;
        i5 = (i3 / this.f3629q) + 1;
        int i9 = 0;
        i2 = i3;
        while (i9 < size) {
            menuItemImpl = (MenuItemImpl) j.get(i9);
            if (menuItemImpl.l()) {
                i5--;
                i2 -= this.f3629q;
                menuItemImpl.d(true);
                i = i5;
                i5 = i2;
            } else if (menuItemImpl.k()) {
                boolean z4;
                boolean z5 = i6 > 0 && i2 > 0 && i5 > 0;
                if (z5) {
                    i3 = i5 - 1;
                    i2 -= this.f3629q;
                    boolean z6 = i2 >= 0 ? true : i9 == size + -1 && !z && (this.f3625m - this.f3627o) + i2 >= 0;
                    z4 = z6;
                    i8 = i3;
                    i3 = i2;
                    i2 = i8;
                } else {
                    z4 = z5;
                    i3 = i2;
                    i2 = i5;
                }
                if (z4) {
                    i5 = i6 - 1;
                } else {
                    i5 = i6;
                }
                menuItemImpl.d(z4);
                i = i2;
                i6 = i5;
                i5 = i3;
            } else {
                i = i5;
                i5 = i2;
            }
            i9++;
            i2 = i5;
            i5 = i;
        }
        if (this.f3620h != null) {
            this.f3620h.m4312a(this.c);
        }
        return true;
    }

    public final void m4347a(MenuBuilder menuBuilder, boolean z) {
        m4356e();
        super.a(menuBuilder, z);
    }
}
