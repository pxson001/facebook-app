package com.facebook.fbui.widget.inlineactionbar;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.R;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: source_initial_units */
public class InlineActionBar extends SegmentedLinearLayout implements SupportMenu, Callback, ItemInvoker, MenuView {
    private InlineActionMenuPresenter f3592a;
    public InlineActionBarMenuHandler f3593b;
    private MenuBuilder f3594c;
    private final int f3595d = getResources().getDimensionPixelSize(2131429813);
    private Paint f3596e = new Paint(1);
    private int f3597f;
    private boolean f3598g;
    private boolean f3599h;
    private boolean f3600i;

    /* compiled from: source_initial_units */
    public interface InlineActionBarActionItemsSelectedHandler {
        void m4312a(MenuBuilder menuBuilder);
    }

    /* compiled from: source_initial_units */
    public interface InlineActionBarMenuHandler {
        boolean mo1170a(MenuItem menuItem);
    }

    public /* synthetic */ MenuItem add(int i) {
        return m4326d(i);
    }

    public /* synthetic */ MenuItem add(int i, int i2, int i3, int i4) {
        return m4320a(i, i2, i3, i4);
    }

    public /* synthetic */ MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m4314a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return m4314a(0, 0, 0, charSequence);
    }

    public InlineActionBar(Context context) {
        super(context);
        m4316a(context, null, 0);
    }

    public InlineActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4316a(context, attributeSet, 0);
    }

    public InlineActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        m4316a(context, attributeSet, i);
    }

    private void m4316a(Context context, AttributeSet attributeSet, int i) {
        super.setOrientation(0);
        Context contextThemeWrapper = new ContextThemeWrapper(context, 2131625424);
        this.f3596e = new Paint(1);
        this.f3596e.setColor(getResources().getColor(2131361939));
        this.f3592a = new InlineActionMenuPresenter(contextThemeWrapper);
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(attributeSet, R.styleable.InlineActionBar, i, 0);
        this.f3592a.f3622j = obtainStyledAttributes.getResourceId(3, 2130839946);
        setMaxNumOfVisibleButtons(obtainStyledAttributes.getInt(2, Integer.MAX_VALUE));
        this.f3592a.f3621i = obtainStyledAttributes.getResourceId(4, 2131625422);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f3592a.f3623k = obtainStyledAttributes.getColorStateList(0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            setMenuResource(resourceId);
        }
        obtainStyledAttributes.recycle();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3592a.b(false);
        if (this.f3592a.m4357f()) {
            this.f3592a.m4355d();
            this.f3592a.m4354c();
        }
    }

    private void m4317a(SupportMenu supportMenu, MenuPresenter.Callback callback) {
        if (supportMenu != this.f3594c) {
            m4318b(supportMenu, callback);
        }
    }

    public void setInlineActionBarMenuHandler(InlineActionBarMenuHandler inlineActionBarMenuHandler) {
        this.f3593b = inlineActionBarMenuHandler;
    }

    public void setInlineActionBarActionItemsSelected(InlineActionBarActionItemsSelectedHandler inlineActionBarActionItemsSelectedHandler) {
        this.f3592a.f3620h = inlineActionBarActionItemsSelectedHandler;
    }

    public void setMaxNumOfVisibleButtons(int i) {
        this.f3592a.f3628p = i;
    }

    public final void m4322a(boolean z, boolean z2, int i) {
        this.f3598g = z;
        this.f3599h = z2;
        this.f3597f = i;
    }

    private void setMenuResource(int i) {
        SupportMenu a = m4315a();
        m4317a(a, null);
        a.f();
        new SupportMenuInflater(getContext()).inflate(i, this);
        a.g();
    }

    public final SupportMenuItem m4326d(int i) {
        return m4320a(0, 0, 0, i);
    }

    private SupportMenuItem m4314a(int i, int i2, int i3, CharSequence charSequence) {
        if (this.f3594c == null) {
            m4317a(m4315a(), null);
        }
        MenuItemImpl menuItemImpl = (MenuItemImpl) this.f3594c.add(i, i2, i3, charSequence);
        menuItemImpl.setShowAsAction(1);
        return menuItemImpl;
    }

    public final SupportMenuItem m4320a(int i, int i2, int i3, int i4) {
        if (this.f3594c == null) {
            m4317a(m4315a(), null);
        }
        MenuItemImpl menuItemImpl = (MenuItemImpl) this.f3594c.add(i, i2, i3, i4);
        menuItemImpl.setShowAsAction(1);
        return menuItemImpl;
    }

    @Deprecated
    public SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    @Deprecated
    public SubMenu addSubMenu(int i) {
        return null;
    }

    @Deprecated
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return null;
    }

    @Deprecated
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return null;
    }

    @Deprecated
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return 0;
    }

    public void removeItem(int i) {
        if (this.f3594c != null) {
            this.f3594c.removeItem(i);
        }
    }

    public void removeGroup(int i) {
        if (this.f3594c != null) {
            this.f3594c.removeGroup(i);
        }
    }

    public void clear() {
        if (this.f3594c != null) {
            this.f3594c.clear();
        }
    }

    @Deprecated
    public void setGroupCheckable(int i, boolean z, boolean z2) {
    }

    @Deprecated
    public void setGroupVisible(int i, boolean z) {
    }

    @Deprecated
    public void setGroupEnabled(int i, boolean z) {
    }

    public boolean hasVisibleItems() {
        return this.f3594c != null ? this.f3594c.hasVisibleItems() : false;
    }

    public MenuItem findItem(int i) {
        return this.f3594c != null ? this.f3594c.findItem(i) : null;
    }

    public int size() {
        return this.f3594c != null ? this.f3594c.size() : 0;
    }

    public MenuItem getItem(int i) {
        return this.f3594c != null ? this.f3594c.getItem(i) : null;
    }

    public final void m4325b() {
        if (this.f3594c != null) {
            this.f3594c.f();
        } else {
            this.f3600i = true;
        }
    }

    public final void m4327d() {
        if (this.f3594c != null) {
            this.f3594c.g();
        } else {
            this.f3600i = false;
        }
    }

    @Deprecated
    public void close() {
    }

    @Deprecated
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return false;
    }

    @Deprecated
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return false;
    }

    @Deprecated
    public boolean performIdentifierAction(int i, int i2) {
        return false;
    }

    @Deprecated
    public void setQwertyMode(boolean z) {
    }

    public void setOrientation(int i) {
        if (i != 0) {
            throw new IllegalArgumentException("InlineActionBar only supports horizontal orientation");
        }
    }

    public final boolean m4323a(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f3593b != null) {
            return this.f3593b.mo1170a(menuItem);
        }
        return false;
    }

    public void b_(MenuBuilder menuBuilder) {
    }

    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(this.f3595d, -1);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
        if (layoutParams2.gravity > 0) {
            return layoutParams2;
        }
        layoutParams2.gravity = 16;
        return layoutParams2;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public final boolean m4324a(MenuItemImpl menuItemImpl) {
        return this.f3594c.a(menuItemImpl, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final void m4321a(MenuBuilder menuBuilder) {
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = (getDefaultSize(getSuggestedMinimumWidth(), i) - getPaddingLeft()) - getPaddingRight();
        InlineActionMenuPresenter inlineActionMenuPresenter = this.f3592a;
        int i3 = this.f3595d;
        inlineActionMenuPresenter.f3625m = defaultSize;
        inlineActionMenuPresenter.f3629q = i3;
        inlineActionMenuPresenter.f3626n = true;
        if (this.f3594c != null) {
            m4319b(this.f3594c);
        }
        super.onMeasure(i, i2);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3598g) {
            canvas.drawLine((float) this.f3597f, 0.0f, (float) (getWidth() - this.f3597f), 0.0f, this.f3596e);
        }
        if (this.f3599h) {
            int height = getHeight() - 1;
            canvas.drawLine((float) this.f3597f, (float) height, (float) (getWidth() - this.f3597f), (float) height, this.f3596e);
        }
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), this.f3595d * getChildCount());
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2067342371);
        super.onDetachedFromWindow();
        this.f3592a.m4356e();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1004823062, a);
    }

    private void m4318b(SupportMenu supportMenu, MenuPresenter.Callback callback) {
        if (this.f3594c != null) {
            this.f3594c.b(this.f3592a);
        }
        this.f3594c = (MenuBuilder) supportMenu;
        this.f3592a.g = callback;
        m4321a(this.f3594c);
        this.f3592a.a(this);
    }

    private void m4319b(MenuBuilder menuBuilder) {
        menuBuilder.b(this.f3592a);
        menuBuilder.a(this.f3592a);
        this.f3592a.b(true);
    }

    private MenuBuilder m4315a() {
        MenuBuilder menuBuilder = new MenuBuilder(getContext());
        menuBuilder.a(this);
        if (this.f3600i) {
            menuBuilder.f();
            this.f3600i = false;
        }
        return menuBuilder;
    }
}
