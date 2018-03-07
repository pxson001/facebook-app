package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.RtlSpacingHelper;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ToolbarWidgetWrapper;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.view.CollapsibleActionView;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.ArrayList;
import java.util.List;

/* compiled from: treehouse_ios_groups_tab */
public class Toolbar extends ViewGroup {
    private boolean f1554A;
    private final ArrayList<View> f1555B;
    private final int[] f1556C;
    public OnMenuItemClickListener f1557D;
    private final android.support.v7.widget.ActionMenuView.OnMenuItemClickListener f1558E;
    private ToolbarWidgetWrapper f1559F;
    private ActionMenuPresenter f1560G;
    private ExpandedActionViewMenuPresenter f1561H;
    private Callback f1562I;
    private MenuBuilder.Callback f1563J;
    private boolean f1564K;
    private final Runnable f1565L;
    private final TintManager f1566M;
    View f1567a;
    private ActionMenuView f1568b;
    private TextView f1569c;
    private TextView f1570d;
    private ImageButton f1571e;
    private ImageView f1572f;
    private Drawable f1573g;
    private CharSequence f1574h;
    public ImageButton f1575i;
    private Context f1576j;
    private int f1577k;
    private int f1578l;
    private int f1579m;
    public int f1580n;
    private int f1581o;
    private int f1582p;
    private int f1583q;
    private int f1584r;
    private int f1585s;
    private final RtlSpacingHelper f1586t;
    private int f1587u;
    public CharSequence f1588v;
    public CharSequence f1589w;
    private int f1590x;
    private int f1591y;
    private boolean f1592z;

    /* compiled from: treehouse_ios_groups_tab */
    class C00841 implements android.support.v7.widget.ActionMenuView.OnMenuItemClickListener {
        final /* synthetic */ Toolbar f1545a;

        C00841(Toolbar toolbar) {
            this.f1545a = toolbar;
        }

        public final boolean mo453a(MenuItem menuItem) {
            if (this.f1545a.f1557D != null) {
                return this.f1545a.f1557D.m2118a(menuItem);
            }
            return false;
        }
    }

    /* compiled from: treehouse_ios_groups_tab */
    class C00852 implements Runnable {
        final /* synthetic */ Toolbar f1546a;

        C00852(Toolbar toolbar) {
            this.f1546a = toolbar;
        }

        public void run() {
            this.f1546a.m2155d();
        }
    }

    /* compiled from: treehouse_ios_groups_tab */
    class C00863 implements OnClickListener {
        final /* synthetic */ Toolbar f1547a;

        C00863(Toolbar toolbar) {
            this.f1547a = toolbar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -772609991);
            this.f1547a.m2159h();
            Logger.a(2, EntryType.UI_INPUT_END, -1125648723, a);
        }
    }

    /* compiled from: treehouse_ios_groups_tab */
    class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuBuilder f1548a;
        MenuItemImpl f1549b;
        final /* synthetic */ Toolbar f1550c;

        public ExpandedActionViewMenuPresenter(Toolbar toolbar) {
            this.f1550c = toolbar;
        }

        public final void mo306a(Context context, MenuBuilder menuBuilder) {
            if (!(this.f1548a == null || this.f1549b == null)) {
                this.f1548a.mo334b(this.f1549b);
            }
            this.f1548a = menuBuilder;
        }

        public final void mo309b(boolean z) {
            Object obj = null;
            if (this.f1549b != null) {
                if (this.f1548a != null) {
                    int size = this.f1548a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f1548a.getItem(i) == this.f1549b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    mo312c(this.f1549b);
                }
            }
        }

        public final boolean mo308a(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public final void mo307a(MenuBuilder menuBuilder, boolean z) {
        }

        public final boolean mo310b() {
            return false;
        }

        public final boolean mo311b(MenuItemImpl menuItemImpl) {
            Toolbar.m2144n(this.f1550c);
            if (this.f1550c.f1575i.getParent() != this.f1550c) {
                this.f1550c.addView(this.f1550c.f1575i);
            }
            this.f1550c.f1567a = menuItemImpl.getActionView();
            this.f1549b = menuItemImpl;
            if (this.f1550c.f1567a.getParent() != this.f1550c) {
                android.view.ViewGroup.LayoutParams i = Toolbar.m2139i();
                i.a = 8388611 | (this.f1550c.f1580n & 112);
                i.f1551b = 2;
                this.f1550c.f1567a.setLayoutParams(i);
                this.f1550c.addView(this.f1550c.f1567a);
            }
            Toolbar.setChildVisibilityForExpandedActionView(this.f1550c, true);
            this.f1550c.requestLayout();
            menuItemImpl.m1438e(true);
            if (this.f1550c.f1567a instanceof CollapsibleActionView) {
                ((CollapsibleActionView) this.f1550c.f1567a).onActionViewExpanded();
            }
            return true;
        }

        public final boolean mo312c(MenuItemImpl menuItemImpl) {
            if (this.f1550c.f1567a instanceof CollapsibleActionView) {
                ((CollapsibleActionView) this.f1550c.f1567a).onActionViewCollapsed();
            }
            this.f1550c.removeView(this.f1550c.f1567a);
            this.f1550c.removeView(this.f1550c.f1575i);
            this.f1550c.f1567a = null;
            Toolbar.setChildVisibilityForExpandedActionView(this.f1550c, false);
            this.f1549b = null;
            this.f1550c.requestLayout();
            menuItemImpl.m1438e(false);
            return true;
        }
    }

    /* compiled from: treehouse_ios_groups_tab */
    public class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        int f1551b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1551b = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f1551b = 0;
            this.a = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.f1551b = 0;
            this.a = i3;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.f1551b = 0;
            this.f1551b = layoutParams.f1551b;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1551b = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.f1551b = 0;
            m2117a(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1551b = 0;
        }

        private void m2117a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* compiled from: treehouse_ios_groups_tab */
    public interface OnMenuItemClickListener {
        boolean m2118a(MenuItem menuItem);
    }

    /* compiled from: treehouse_ios_groups_tab */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C00871();
        public int f1552a;
        public boolean f1553b;

        /* compiled from: treehouse_ios_groups_tab */
        final class C00871 implements Creator<SavedState> {
            C00871() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1552a = parcel.readInt();
            this.f1553b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1552a);
            parcel.writeInt(this.f1553b ? 1 : 0);
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m2139i();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m2123a(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772024);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(ViewUtils.m1754a(context, attributeSet, false, true), attributeSet, i);
        this.f1586t = new RtlSpacingHelper();
        this.f1587u = 8388627;
        this.f1555B = new ArrayList();
        this.f1556C = new int[2];
        this.f1558E = new C00841(this);
        this.f1565L = new C00852(this);
        TintTypedArray a = TintTypedArray.m1693a(getContext(), attributeSet, R.styleable.Toolbar, i, 0);
        this.f1578l = a.m1704f(7, 0);
        this.f1579m = a.m1704f(8, 0);
        this.f1587u = a.f1229b.getInteger(0, this.f1587u);
        this.f1580n = 48;
        int c = a.m1699c(9, 0);
        this.f1585s = c;
        this.f1584r = c;
        this.f1583q = c;
        this.f1582p = c;
        c = a.m1699c(10, -1);
        if (c >= 0) {
            this.f1582p = c;
        }
        c = a.m1699c(11, -1);
        if (c >= 0) {
            this.f1583q = c;
        }
        c = a.m1699c(12, -1);
        if (c >= 0) {
            this.f1584r = c;
        }
        c = a.m1699c(13, -1);
        if (c >= 0) {
            this.f1585s = c;
        }
        this.f1581o = a.m1701d(14, -1);
        c = a.m1699c(2, Integer.MIN_VALUE);
        int c2 = a.m1699c(3, Integer.MIN_VALUE);
        int d = a.m1701d(4, 0);
        int d2 = a.m1701d(5, 0);
        RtlSpacingHelper rtlSpacingHelper = this.f1586t;
        rtlSpacingHelper.f1120h = false;
        if (d != Integer.MIN_VALUE) {
            rtlSpacingHelper.f1117e = d;
            rtlSpacingHelper.f1113a = d;
        }
        if (d2 != Integer.MIN_VALUE) {
            rtlSpacingHelper.f1118f = d2;
            rtlSpacingHelper.f1114b = d2;
        }
        if (!(c == Integer.MIN_VALUE && c2 == Integer.MIN_VALUE)) {
            this.f1586t.m1632a(c, c2);
        }
        this.f1573g = a.m1695a(16);
        this.f1574h = a.m1697b(17);
        CharSequence b = a.m1697b(20);
        if (!TextUtils.isEmpty(b)) {
            setTitle(b);
        }
        b = a.m1697b(21);
        if (!TextUtils.isEmpty(b)) {
            setSubtitle(b);
        }
        this.f1576j = getContext();
        setPopupTheme(a.m1704f(6, 0));
        Drawable a2 = a.m1695a(18);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        b = a.m1697b(19);
        if (!TextUtils.isEmpty(b)) {
            setNavigationContentDescription(b);
        }
        a.m1698b();
        this.f1566M = a.m1700c();
    }

    public void setPopupTheme(int i) {
        if (this.f1577k != i) {
            this.f1577k = i;
            if (i == 0) {
                this.f1576j = getContext();
            } else {
                this.f1576j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1577k;
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        RtlSpacingHelper rtlSpacingHelper = this.f1586t;
        if (i != 1) {
            z = false;
        }
        if (z != rtlSpacingHelper.f1119g) {
            rtlSpacingHelper.f1119g = z;
            if (!rtlSpacingHelper.f1120h) {
                rtlSpacingHelper.f1113a = rtlSpacingHelper.f1117e;
                rtlSpacingHelper.f1114b = rtlSpacingHelper.f1118f;
            } else if (z) {
                rtlSpacingHelper.f1113a = rtlSpacingHelper.f1116d != Integer.MIN_VALUE ? rtlSpacingHelper.f1116d : rtlSpacingHelper.f1117e;
                rtlSpacingHelper.f1114b = rtlSpacingHelper.f1115c != Integer.MIN_VALUE ? rtlSpacingHelper.f1115c : rtlSpacingHelper.f1118f;
            } else {
                rtlSpacingHelper.f1113a = rtlSpacingHelper.f1115c != Integer.MIN_VALUE ? rtlSpacingHelper.f1115c : rtlSpacingHelper.f1117e;
                rtlSpacingHelper.f1114b = rtlSpacingHelper.f1116d != Integer.MIN_VALUE ? rtlSpacingHelper.f1116d : rtlSpacingHelper.f1118f;
            }
        }
    }

    public void setLogo(int i) {
        setLogo(this.f1566M.m1690a(i));
    }

    public final boolean m2151a() {
        return getVisibility() == 0 && this.f1568b != null && this.f1568b.f1306e;
    }

    public final boolean m2153b() {
        return this.f1568b != null && this.f1568b.m1804f();
    }

    public final boolean m2154c() {
        return this.f1568b != null && this.f1568b.m1805g();
    }

    public final boolean m2155d() {
        return this.f1568b != null && this.f1568b.m1802d();
    }

    public final boolean m2156e() {
        return this.f1568b != null && this.f1568b.m1803e();
    }

    public final void m2150a(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.f1568b != null) {
            m2142l();
            MenuBuilder menuBuilder2 = this.f1568b.f1302a;
            if (menuBuilder2 != menuBuilder) {
                if (menuBuilder2 != null) {
                    menuBuilder2.m1409b(this.f1560G);
                    menuBuilder2.m1409b(this.f1561H);
                }
                if (this.f1561H == null) {
                    this.f1561H = new ExpandedActionViewMenuPresenter(this);
                }
                actionMenuPresenter.f1284r = true;
                if (menuBuilder != null) {
                    menuBuilder.m1402a((MenuPresenter) actionMenuPresenter, this.f1576j);
                    menuBuilder.m1402a(this.f1561H, this.f1576j);
                } else {
                    actionMenuPresenter.mo306a(this.f1576j, null);
                    this.f1561H.mo306a(this.f1576j, null);
                    actionMenuPresenter.mo309b(true);
                    this.f1561H.mo309b(true);
                }
                this.f1568b.setPopupTheme(this.f1577k);
                this.f1568b.setPresenter(actionMenuPresenter);
                this.f1560G = actionMenuPresenter;
            }
        }
    }

    public final void m2157f() {
        if (this.f1568b != null) {
            this.f1568b.m1806h();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m2140j();
            if (this.f1572f.getParent() == null) {
                m2126a(this.f1572f);
                m2138e(this.f1572f);
            }
        } else if (!(this.f1572f == null || this.f1572f.getParent() == null)) {
            removeView(this.f1572f);
        }
        if (this.f1572f != null) {
            this.f1572f.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.f1572f != null ? this.f1572f.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2140j();
        }
        if (this.f1572f != null) {
            this.f1572f.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.f1572f != null ? this.f1572f.getContentDescription() : null;
    }

    private void m2140j() {
        if (this.f1572f == null) {
            this.f1572f = new ImageView(getContext());
        }
    }

    public final boolean m2158g() {
        return (this.f1561H == null || this.f1561H.f1549b == null) ? false : true;
    }

    public final void m2159h() {
        MenuItemImpl menuItemImpl = this.f1561H == null ? null : this.f1561H.f1549b;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f1588v;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1569c == null) {
                Context context = getContext();
                this.f1569c = new TextView(context);
                this.f1569c.setSingleLine();
                this.f1569c.setEllipsize(TruncateAt.END);
                if (this.f1578l != 0) {
                    this.f1569c.setTextAppearance(context, this.f1578l);
                }
                if (this.f1590x != 0) {
                    this.f1569c.setTextColor(this.f1590x);
                }
            }
            if (this.f1569c.getParent() == null) {
                m2126a(this.f1569c);
                m2138e(this.f1569c);
            }
        } else if (!(this.f1569c == null || this.f1569c.getParent() == null)) {
            removeView(this.f1569c);
        }
        if (this.f1569c != null) {
            this.f1569c.setText(charSequence);
        }
        this.f1588v = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.f1589w;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1570d == null) {
                Context context = getContext();
                this.f1570d = new TextView(context);
                this.f1570d.setSingleLine();
                this.f1570d.setEllipsize(TruncateAt.END);
                if (this.f1579m != 0) {
                    this.f1570d.setTextAppearance(context, this.f1579m);
                }
                if (this.f1591y != 0) {
                    this.f1570d.setTextColor(this.f1591y);
                }
            }
            if (this.f1570d.getParent() == null) {
                m2126a(this.f1570d);
                m2138e(this.f1570d);
            }
        } else if (!(this.f1570d == null || this.f1570d.getParent() == null)) {
            removeView(this.f1570d);
        }
        if (this.f1570d != null) {
            this.f1570d.setText(charSequence);
        }
        this.f1589w = charSequence;
    }

    public final void m2149a(Context context, int i) {
        this.f1578l = i;
        if (this.f1569c != null) {
            this.f1569c.setTextAppearance(context, i);
        }
    }

    public final void m2152b(Context context, int i) {
        this.f1579m = i;
        if (this.f1570d != null) {
            this.f1570d.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.f1590x = i;
        if (this.f1569c != null) {
            this.f1569c.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.f1591y = i;
        if (this.f1570d != null) {
            this.f1570d.setTextColor(i);
        }
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        return this.f1571e != null ? this.f1571e.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2143m();
        }
        if (this.f1571e != null) {
            this.f1571e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f1566M.m1690a(i));
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            m2143m();
            if (this.f1571e.getParent() == null) {
                m2126a(this.f1571e);
                m2138e(this.f1571e);
            }
        } else if (!(this.f1571e == null || this.f1571e.getParent() == null)) {
            removeView(this.f1571e);
        }
        if (this.f1571e != null) {
            this.f1571e.setImageDrawable(drawable);
        }
    }

    @Nullable
    public Drawable getNavigationIcon() {
        return this.f1571e != null ? this.f1571e.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m2143m();
        this.f1571e.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        m2141k();
        return this.f1568b.getMenu();
    }

    private void m2141k() {
        m2142l();
        if (this.f1568b.f1302a == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f1568b.getMenu();
            if (this.f1561H == null) {
                this.f1561H = new ExpandedActionViewMenuPresenter(this);
            }
            this.f1568b.setExpandedActionViewsExclusive(true);
            menuBuilder.m1402a(this.f1561H, this.f1576j);
        }
    }

    private void m2142l() {
        if (this.f1568b == null) {
            this.f1568b = new ActionMenuView(getContext());
            this.f1568b.setPopupTheme(this.f1577k);
            this.f1568b.f1314m = this.f1558E;
            this.f1568b.m1797a(this.f1562I, this.f1563J);
            android.view.ViewGroup.LayoutParams i = m2139i();
            i.a = 8388613 | (this.f1580n & 112);
            this.f1568b.setLayoutParams(i);
            m2126a(this.f1568b);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public final void m2147a(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1557D = onMenuItemClickListener;
    }

    public final void m2148a(int i, int i2) {
        this.f1586t.m1632a(i, i2);
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.f1586t;
        return rtlSpacingHelper.f1119g ? rtlSpacingHelper.f1114b : rtlSpacingHelper.f1113a;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.f1586t;
        return rtlSpacingHelper.f1119g ? rtlSpacingHelper.f1113a : rtlSpacingHelper.f1114b;
    }

    public int getContentInsetLeft() {
        return this.f1586t.f1113a;
    }

    public int getContentInsetRight() {
        return this.f1586t.f1114b;
    }

    private void m2143m() {
        if (this.f1571e == null) {
            this.f1571e = new ImageButton(getContext(), null, 2130772025);
            android.view.ViewGroup.LayoutParams i = m2139i();
            i.a = 8388611 | (this.f1580n & 112);
            this.f1571e.setLayoutParams(i);
        }
    }

    public static void m2144n(Toolbar toolbar) {
        if (toolbar.f1575i == null) {
            toolbar.f1575i = new ImageButton(toolbar.getContext(), null, 2130772025);
            toolbar.f1575i.setImageDrawable(toolbar.f1573g);
            toolbar.f1575i.setContentDescription(toolbar.f1574h);
            android.view.ViewGroup.LayoutParams i = m2139i();
            i.a = 8388611 | (toolbar.f1580n & 112);
            i.f1551b = 2;
            toolbar.f1575i.setLayoutParams(i);
            toolbar.f1575i.setOnClickListener(new C00863(toolbar));
        }
    }

    private void m2126a(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m2139i();
        } else if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        } else {
            layoutParams = m2123a(layoutParams);
        }
        layoutParams.f1551b = 1;
        addView(view, layoutParams);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f1561H == null || this.f1561H.f1549b == null)) {
            savedState.f1552a = this.f1561H.f1549b.getItemId();
        }
        savedState.f1553b = m2153b();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        Menu menu;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f1568b != null) {
            menu = this.f1568b.f1302a;
        } else {
            menu = null;
        }
        if (!(savedState.f1552a == 0 || this.f1561H == null || menu == null)) {
            MenuItem findItem = menu.findItem(savedState.f1552a);
            if (findItem != null) {
                MenuItemCompat.m382b(findItem);
            }
        }
        if (savedState.f1553b) {
            m2145o();
        }
    }

    private void m2145o() {
        removeCallbacks(this.f1565L);
        post(this.f1565L);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -108048641);
        super.onDetachedFromWindow();
        removeCallbacks(this.f1565L);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 291538322, a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -282862309);
        int a2 = MotionEventCompat.a(motionEvent);
        if (a2 == 0) {
            this.f1592z = false;
        }
        if (!this.f1592z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a2 == 0 && !onTouchEvent) {
                this.f1592z = true;
            }
        }
        if (a2 == 1 || a2 == 3) {
            this.f1592z = false;
        }
        Logger.a(2, EntryType.UI_INPUT_END, 1047216458, a);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = MotionEventCompat.a(motionEvent);
        if (a == 9) {
            this.f1554A = false;
        }
        if (!this.f1554A) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1554A = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1554A = false;
        }
        return true;
    }

    private void m2127a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int m2120a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean m2146p() {
        if (!this.f1564K) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m2132b(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int a;
        int i5;
        int[] iArr = this.f1556C;
        if (ViewUtils.m1756a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i6 = 0;
        if (m2132b(this.f1571e)) {
            m2127a(this.f1571e, i, 0, i2, 0, this.f1581o);
            i6 = this.f1571e.getMeasuredWidth() + m2134c(this.f1571e);
            max = Math.max(0, this.f1571e.getMeasuredHeight() + m2137d(this.f1571e));
            a = ViewUtils.m1753a(0, ViewCompat.m(this.f1571e));
            i5 = max;
        } else {
            a = 0;
            i5 = 0;
        }
        if (m2132b(this.f1575i)) {
            m2127a(this.f1575i, i, 0, i2, 0, this.f1581o);
            i6 = this.f1575i.getMeasuredWidth() + m2134c(this.f1575i);
            i5 = Math.max(i5, this.f1575i.getMeasuredHeight() + m2137d(this.f1575i));
            a = ViewUtils.m1753a(a, ViewCompat.m(this.f1575i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = Math.max(contentInsetStart, i6) + 0;
        iArr[i4] = Math.max(0, contentInsetStart - i6);
        i6 = 0;
        if (m2132b(this.f1568b)) {
            m2127a(this.f1568b, i, max2, i2, 0, this.f1581o);
            i6 = this.f1568b.getMeasuredWidth() + m2134c(this.f1568b);
            i5 = Math.max(i5, this.f1568b.getMeasuredHeight() + m2137d(this.f1568b));
            a = ViewUtils.m1753a(a, ViewCompat.m(this.f1568b));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i6);
        iArr[i3] = Math.max(0, contentInsetStart - i6);
        if (m2132b(this.f1567a)) {
            max2 += m2120a(this.f1567a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1567a.getMeasuredHeight() + m2137d(this.f1567a));
            a = ViewUtils.m1753a(a, ViewCompat.m(this.f1567a));
        }
        if (m2132b(this.f1572f)) {
            max2 += m2120a(this.f1572f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1572f.getMeasuredHeight() + m2137d(this.f1572f));
            a = ViewUtils.m1753a(a, ViewCompat.m(this.f1572f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i7 = i5;
        i5 = a;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).f1551b == 0 && m2132b(childAt)) {
                max2 += m2120a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i7, childAt.getMeasuredHeight() + m2137d(childAt));
                i6 = ViewUtils.m1753a(i5, ViewCompat.m(childAt));
                contentInsetStart = max;
            } else {
                i6 = i5;
                contentInsetStart = i7;
            }
            i3++;
            i5 = i6;
            i7 = contentInsetStart;
        }
        contentInsetStart = 0;
        i6 = 0;
        a = this.f1584r + this.f1585s;
        max = this.f1582p + this.f1583q;
        if (m2132b(this.f1569c)) {
            m2120a(this.f1569c, i, max2 + max, i2, a, iArr);
            contentInsetStart = m2134c(this.f1569c) + this.f1569c.getMeasuredWidth();
            i6 = this.f1569c.getMeasuredHeight() + m2137d(this.f1569c);
            i5 = ViewUtils.m1753a(i5, ViewCompat.m(this.f1569c));
        }
        if (m2132b(this.f1570d)) {
            contentInsetStart = Math.max(contentInsetStart, m2120a(this.f1570d, i, max2 + max, i2, a + i6, iArr));
            i6 += this.f1570d.getMeasuredHeight() + m2137d(this.f1570d);
            i5 = ViewUtils.m1753a(i5, ViewCompat.m(this.f1570d));
        }
        contentInsetStart += max2;
        i6 = Math.max(i7, i6) + (getPaddingTop() + getPaddingBottom());
        contentInsetStart = ViewCompat.a(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i6 = ViewCompat.a(Math.max(i6, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m2146p()) {
            i6 = 0;
        }
        setMeasuredDimension(contentInsetStart, i6);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int measuredWidth;
        if (ViewCompat.h(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.f1556C;
        iArr[1] = 0;
        iArr[0] = 0;
        int s = ViewCompat.s(this);
        if (!m2132b(this.f1571e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = m2130b(this.f1571e, i8, iArr, s);
            i5 = paddingLeft;
        } else {
            i5 = m2121a(this.f1571e, paddingLeft, iArr, s);
        }
        if (m2132b(this.f1575i)) {
            if (obj != null) {
                i8 = m2130b(this.f1575i, i8, iArr, s);
            } else {
                i5 = m2121a(this.f1575i, i5, iArr, s);
            }
        }
        if (m2132b(this.f1568b)) {
            if (obj != null) {
                i5 = m2121a(this.f1568b, i5, iArr, s);
            } else {
                i8 = m2130b(this.f1568b, i8, iArr, s);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (m2132b(this.f1567a)) {
            if (obj != null) {
                i8 = m2130b(this.f1567a, i8, iArr, s);
            } else {
                i5 = m2121a(this.f1567a, i5, iArr, s);
            }
        }
        if (!m2132b(this.f1572f)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = m2130b(this.f1572f, i8, iArr, s);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = m2121a(this.f1572f, i5, iArr, s);
        }
        boolean b = m2132b(this.f1569c);
        boolean b2 = m2132b(this.f1570d);
        i5 = 0;
        if (b) {
            LayoutParams layoutParams = (LayoutParams) this.f1569c.getLayoutParams();
            i5 = (layoutParams.bottomMargin + (layoutParams.topMargin + this.f1569c.getMeasuredHeight())) + 0;
        }
        if (b2) {
            layoutParams = (LayoutParams) this.f1570d.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.f1570d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (b || b2) {
            int paddingTop2;
            layoutParams = (LayoutParams) (b ? this.f1569c : this.f1570d).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (b2 ? this.f1570d : this.f1569c).getLayoutParams();
            Object obj2 = ((!b || this.f1569c.getMeasuredWidth() <= 0) && (!b2 || this.f1570d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f1587u & 112) {
                case 48:
                    paddingTop2 = (layoutParams.topMargin + getPaddingTop()) + this.f1584r;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.f1585s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < layoutParams.topMargin + this.f1584r) {
                        i8 = layoutParams.topMargin + this.f1584r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        if (measuredHeight < layoutParams.bottomMargin + this.f1585s) {
                            i8 = Math.max(0, paddingTop2 - ((layoutParams2.bottomMargin + this.f1585s) - measuredHeight));
                        } else {
                            i8 = paddingTop2;
                        }
                    }
                    paddingTop2 = paddingTop + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.f1582p : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (b) {
                    layoutParams = (LayoutParams) this.f1569c.getLayoutParams();
                    measuredWidth = i5 - this.f1569c.getMeasuredWidth();
                    i6 = this.f1569c.getMeasuredHeight() + paddingTop2;
                    this.f1569c.layout(measuredWidth, paddingTop2, i5, i6);
                    paddingTop2 = i6 + layoutParams.bottomMargin;
                    i6 = measuredWidth - this.f1583q;
                } else {
                    i6 = i5;
                }
                if (b2) {
                    layoutParams = (LayoutParams) this.f1570d.getLayoutParams();
                    measuredWidth = layoutParams.topMargin + paddingTop2;
                    this.f1570d.layout(i5 - this.f1570d.getMeasuredWidth(), measuredWidth, i5, this.f1570d.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i5 - this.f1583q;
                    i8 = layoutParams.bottomMargin;
                    i8 = measuredWidth;
                } else {
                    i8 = i5;
                }
                if (obj2 != null) {
                    i8 = Math.min(i6, i8);
                } else {
                    i8 = i5;
                }
                i6 = i8;
            } else {
                i8 = (obj2 != null ? this.f1582p : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (b) {
                    layoutParams = (LayoutParams) this.f1569c.getLayoutParams();
                    i5 = this.f1569c.getMeasuredWidth() + i7;
                    measuredWidth = this.f1569c.getMeasuredHeight() + paddingTop2;
                    this.f1569c.layout(i7, paddingTop2, i5, measuredWidth);
                    i8 = layoutParams.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f1583q;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop2;
                }
                if (b2) {
                    layoutParams = (LayoutParams) this.f1570d.getLayoutParams();
                    i5 += layoutParams.topMargin;
                    paddingTop2 = this.f1570d.getMeasuredWidth() + i7;
                    this.f1570d.layout(i7, i5, paddingTop2, this.f1570d.getMeasuredHeight() + i5);
                    i5 = this.f1583q + paddingTop2;
                    i8 = layoutParams.bottomMargin;
                    i8 = i5;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        m2128a(this.f1555B, 3);
        int size = this.f1555B.size();
        i5 = i7;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m2121a((View) this.f1555B.get(measuredWidth), i5, iArr, s);
        }
        m2128a(this.f1555B, 5);
        i7 = this.f1555B.size();
        for (measuredWidth = 0; measuredWidth < i7; measuredWidth++) {
            i6 = m2130b((View) this.f1555B.get(measuredWidth), i6, iArr, s);
        }
        m2128a(this.f1555B, 1);
        measuredWidth = m2122a(this.f1555B, iArr);
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i8;
        if (i8 < i5) {
            i8 = i5;
        } else if (measuredWidth > i6) {
            i8 -= measuredWidth - i6;
        }
        paddingLeft = this.f1555B.size();
        measuredWidth = i8;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m2121a((View) this.f1555B.get(i5), measuredWidth, iArr, s);
        }
        this.f1555B.clear();
    }

    private static int m2122a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            i6 = layoutParams.leftMargin - i6;
            i = layoutParams.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private int m2121a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m2119a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int m2130b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m2119a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int m2119a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m2129b(layoutParams.f572a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i3 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m2129b(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f1587u & 112;
        }
    }

    private void m2128a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ViewCompat.h(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = GravityCompat.a(i, ViewCompat.h(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1551b == 0 && m2132b(childAt) && m2133c(layoutParams.f572a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.f1551b == 0 && m2132b(childAt2) && m2133c(layoutParams.f572a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int m2133c(int i) {
        int h = ViewCompat.h(this);
        int a = GravityCompat.a(i, h) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return h == 1 ? 5 : 3;
        }
    }

    private boolean m2132b(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private static int m2134c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.b(marginLayoutParams) + MarginLayoutParamsCompat.a(marginLayoutParams);
    }

    private static int m2137d(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private static LayoutParams m2123a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected static LayoutParams m2139i() {
        return new LayoutParams(-2, -2);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public DecorToolbar getWrapper() {
        if (this.f1559F == null) {
            this.f1559F = new ToolbarWidgetWrapper(this, true);
        }
        return this.f1559F;
    }

    public static void setChildVisibilityForExpandedActionView(Toolbar toolbar, boolean z) {
        int childCount = toolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = toolbar.getChildAt(i);
            if (!(((LayoutParams) childAt.getLayoutParams()).f1551b == 2 || childAt == toolbar.f1568b)) {
                int i2;
                if (z) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                childAt.setVisibility(i2);
            }
        }
    }

    private void m2138e(View view) {
        if (((LayoutParams) view.getLayoutParams()).f1551b != 2 && view != this.f1568b) {
            view.setVisibility(this.f1567a != null ? 8 : 0);
        }
    }

    public void setCollapsible(boolean z) {
        this.f1564K = z;
        requestLayout();
    }
}
