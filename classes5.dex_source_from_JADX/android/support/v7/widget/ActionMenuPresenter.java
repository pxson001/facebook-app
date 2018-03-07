package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.ActionMenuItemView.PopupCallback;
import android.support.v7.internal.view.menu.BaseMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.TintImageView;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

/* compiled from: uiTiltGestures */
public class ActionMenuPresenter extends BaseMenuPresenter implements SubUiVisibilityListener {
    final PopupPresenterCallback f1273g = new PopupPresenterCallback(this);
    int f1274h;
    public View f1275i;
    private boolean f1276j;
    private boolean f1277k;
    private int f1278l;
    private int f1279m;
    public int f1280n;
    public boolean f1281o;
    private boolean f1282p;
    private boolean f1283q;
    public boolean f1284r;
    private int f1285s;
    private final SparseBooleanArray f1286t = new SparseBooleanArray();
    private View f1287u;
    public OverflowPopup f1288v;
    public ActionButtonSubmenu f1289w;
    public OpenOverflowRunnable f1290x;
    private ActionMenuPopupCallback f1291y;

    /* compiled from: uiTiltGestures */
    class ActionButtonSubmenu extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter f1261c;
        private SubMenuBuilder f1262d;

        public ActionButtonSubmenu(ActionMenuPresenter actionMenuPresenter, Context context, SubMenuBuilder subMenuBuilder) {
            boolean z = false;
            this.f1261c = actionMenuPresenter;
            super(context, subMenuBuilder, null, false, 2130771982);
            this.f1262d = subMenuBuilder;
            if (!((MenuItemImpl) subMenuBuilder.getItem()).m1441j()) {
                View view;
                if (actionMenuPresenter.f1275i == null) {
                    view = (View) actionMenuPresenter.f809f;
                } else {
                    view = actionMenuPresenter.f1275i;
                }
                this.f922k = view;
            }
            this.f925n = actionMenuPresenter.f1273g;
            int size = subMenuBuilder.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            this.f913b = z;
        }

        public void onDismiss() {
            super.onDismiss();
            this.f1261c.f1289w = null;
            this.f1261c.f1274h = 0;
        }
    }

    /* compiled from: uiTiltGestures */
    class ActionMenuPopupCallback extends PopupCallback {
        final /* synthetic */ ActionMenuPresenter f1263a;

        public ActionMenuPopupCallback(ActionMenuPresenter actionMenuPresenter) {
            this.f1263a = actionMenuPresenter;
        }

        public final ListPopupWindow mo418a() {
            return this.f1263a.f1289w != null ? this.f1263a.f1289w.f923l : null;
        }
    }

    /* compiled from: uiTiltGestures */
    class OpenOverflowRunnable implements Runnable {
        final /* synthetic */ ActionMenuPresenter f1264a;
        private OverflowPopup f1265b;

        public OpenOverflowRunnable(ActionMenuPresenter actionMenuPresenter, OverflowPopup overflowPopup) {
            this.f1264a = actionMenuPresenter;
            this.f1265b = overflowPopup;
        }

        public void run() {
            this.f1264a.f806c.m1415e();
            View view = (View) this.f1264a.f809f;
            if (!(view == null || view.getWindowToken() == null || !this.f1265b.m1469d())) {
                this.f1264a.f1288v = this.f1265b;
            }
            this.f1264a.f1290x = null;
        }
    }

    /* compiled from: uiTiltGestures */
    class OverflowMenuButton extends TintImageView implements ActionMenuChildView {
        final /* synthetic */ ActionMenuPresenter f1268a;
        private final float[] f1269b = new float[2];

        public OverflowMenuButton(final ActionMenuPresenter actionMenuPresenter, Context context) {
            this.f1268a = actionMenuPresenter;
            super(context, null, 2130771981);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ForwardingListener(this, this) {
                final /* synthetic */ OverflowMenuButton f1267b;

                public final ListPopupWindow mo298a() {
                    if (this.f1267b.f1268a.f1288v == null) {
                        return null;
                    }
                    return this.f1267b.f1268a.f1288v.f923l;
                }

                public final boolean mo299b() {
                    this.f1267b.f1268a.m1780d();
                    return true;
                }

                public final boolean mo300c() {
                    if (this.f1267b.f1268a.f1290x != null) {
                        return false;
                    }
                    this.f1267b.f1268a.m1781e();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.f1268a.m1780d();
            }
            return true;
        }

        public final boolean mo302c() {
            return false;
        }

        public final boolean mo303d() {
            return false;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    /* compiled from: uiTiltGestures */
    class OverflowPopup extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter f1270c;

        public OverflowPopup(ActionMenuPresenter actionMenuPresenter, Context context, MenuBuilder menuBuilder, View view, boolean z) {
            this.f1270c = actionMenuPresenter;
            super(context, menuBuilder, view, z, 2130771982);
            this.f925n = actionMenuPresenter.f1273g;
        }

        public void onDismiss() {
            super.onDismiss();
            this.f1270c.f806c.close();
            this.f1270c.f1288v = null;
        }
    }

    /* compiled from: uiTiltGestures */
    class PopupPresenterCallback implements Callback {
        final /* synthetic */ ActionMenuPresenter f1271a;

        public PopupPresenterCallback(ActionMenuPresenter actionMenuPresenter) {
            this.f1271a = actionMenuPresenter;
        }

        public final boolean a_(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            this.f1271a.f1274h = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            Callback callback = this.f1271a.f810g;
            return callback != null ? callback.a_(menuBuilder) : false;
        }

        public final void mo228a(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                ((SubMenuBuilder) menuBuilder).mo336q().m1403a(false);
            }
            Callback callback = this.f1271a.f810g;
            if (callback != null) {
                callback.mo228a(menuBuilder, z);
            }
        }
    }

    /* compiled from: uiTiltGestures */
    class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C00641();
        public int f1272a;

        /* compiled from: uiTiltGestures */
        final class C00641 implements Creator<SavedState> {
            C00641() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f1272a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1272a);
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, 2130903044, 2130903043);
    }

    public final void mo306a(Context context, MenuBuilder menuBuilder) {
        super.mo306a(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy a = ActionBarPolicy.m1276a(context);
        if (!this.f1277k) {
            boolean z = true;
            if (VERSION.SDK_INT < 19 && ViewConfigurationCompat.b(ViewConfiguration.get(a.f707a))) {
                z = false;
            }
            this.f1276j = z;
        }
        if (!this.f1283q) {
            this.f1278l = a.f707a.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.f1281o) {
            this.f1280n = a.f707a.getResources().getInteger(2131492866);
        }
        int i = this.f1278l;
        if (this.f1276j) {
            if (this.f1275i == null) {
                this.f1275i = new OverflowMenuButton(this, this.f804a);
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f1275i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1275i.getMeasuredWidth();
        } else {
            this.f1275i = null;
        }
        this.f1279m = i;
        this.f1285s = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f1287u = null;
    }

    public final void m1767a(int i, boolean z) {
        this.f1278l = i;
        this.f1282p = z;
        this.f1283q = true;
    }

    public final void m1779c(boolean z) {
        this.f1276j = z;
        this.f1277k = true;
    }

    public final void m1776b(int i) {
        this.f1280n = i;
        this.f1281o = true;
    }

    public final MenuView mo419a(ViewGroup viewGroup) {
        MenuView a = super.mo419a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public final View mo420a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.m1444n()) {
            actionView = super.mo420a(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m1795a(layoutParams));
        }
        return actionView;
    }

    public final void mo421a(MenuItemImpl menuItemImpl, ItemView itemView) {
        itemView.mo301a(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.f796d = (ActionMenuView) this.f809f;
        if (this.f1291y == null) {
            this.f1291y = new ActionMenuPopupCallback(this);
        }
        actionMenuItemView.f798f = this.f1291y;
    }

    public final boolean mo423a(MenuItemImpl menuItemImpl) {
        return menuItemImpl.m1441j();
    }

    public final void mo309b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ((View) this.f809f).getParent();
        super.mo309b(z);
        ((View) this.f809f).requestLayout();
        if (this.f806c != null) {
            MenuBuilder menuBuilder = this.f806c;
            menuBuilder.m1421k();
            ArrayList arrayList = menuBuilder.f858m;
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                ActionProvider a = ((MenuItemImpl) arrayList.get(i)).mo289a();
                if (a != null) {
                    a.f278b = this;
                }
            }
        }
        ArrayList m = this.f806c != null ? this.f806c.m1422m() : null;
        if (this.f1276j && m != null) {
            i = m.size();
            if (i == 1) {
                int i4;
                if (((MenuItemImpl) m.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.f1275i == null) {
                this.f1275i = new OverflowMenuButton(this, this.f804a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1275i.getParent();
            if (viewGroup != this.f809f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1275i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f809f;
                actionMenuView.addView(this.f1275i, actionMenuView.m1800b());
            }
        } else if (this.f1275i != null && this.f1275i.getParent() == this.f809f) {
            ((ViewGroup) this.f809f).removeView(this.f1275i);
        }
        ((ActionMenuView) this.f809f).f1306e = this.f1276j;
    }

    public final boolean mo424a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1275i) {
            return false;
        }
        return super.mo424a(viewGroup, i);
    }

    public final boolean mo308a(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        View view;
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.f930d != this.f806c) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.f930d;
        }
        MenuItemImpl item = subMenuBuilder2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.f809f;
        if (viewGroup == null) {
            view = null;
        } else {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                view = viewGroup.getChildAt(i);
                if ((view instanceof ItemView) && ((ItemView) view).getItemData() == item) {
                    break;
                }
            }
            view = null;
        }
        View view2 = view;
        if (view2 == null) {
            if (this.f1275i == null) {
                return false;
            }
            view2 = this.f1275i;
        }
        this.f1274h = subMenuBuilder.getItem().getItemId();
        this.f1289w = new ActionButtonSubmenu(this, this.f805b, subMenuBuilder);
        this.f1289w.f922k = view2;
        this.f1289w.m1461a();
        super.mo308a(subMenuBuilder);
        return true;
    }

    public final boolean m1780d() {
        if (!this.f1276j || m1784h() || this.f806c == null || this.f809f == null || this.f1290x != null || this.f806c.m1422m().isEmpty()) {
            return false;
        }
        this.f1290x = new OpenOverflowRunnable(this, new OverflowPopup(this, this.f805b, this.f806c, this.f1275i, true));
        ((View) this.f809f).post(this.f1290x);
        super.mo308a(null);
        return true;
    }

    public final boolean m1781e() {
        if (this.f1290x == null || this.f809f == null) {
            MenuPopupHelper menuPopupHelper = this.f1288v;
            if (menuPopupHelper == null) {
                return false;
            }
            menuPopupHelper.m1470e();
            return true;
        }
        ((View) this.f809f).removeCallbacks(this.f1290x);
        this.f1290x = null;
        return true;
    }

    public final boolean m1782f() {
        return m1781e() | m1783g();
    }

    public final boolean m1783g() {
        if (this.f1289w == null) {
            return false;
        }
        this.f1289w.m1470e();
        return true;
    }

    public final boolean m1784h() {
        return this.f1288v != null && this.f1288v.m1471f();
    }

    public final boolean mo310b() {
        int i;
        ArrayList j = this.f806c.m1420j();
        int size = j.size();
        int i2 = this.f1280n;
        int i3 = this.f1279m;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f809f;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int i6 = 0;
        while (i6 < size) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) j.get(i6);
            if (menuItemImpl.m1443l()) {
                i4++;
            } else if (menuItemImpl.m1442k()) {
                i5++;
            } else {
                obj = 1;
            }
            if (this.f1284r && menuItemImpl.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i2;
            }
            i6++;
            i2 = i;
        }
        if (this.f1276j && (r4 != null || i4 + i5 > i2)) {
            i2--;
        }
        i6 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = this.f1286t;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f1282p) {
            i = i3 / this.f1285s;
            i5 = ((i3 % this.f1285s) / i) + this.f1285s;
        } else {
            i5 = 0;
        }
        int i7 = 0;
        i2 = 0;
        int i8 = i;
        while (i7 < size) {
            menuItemImpl = (MenuItemImpl) j.get(i7);
            int i9;
            if (menuItemImpl.m1443l()) {
                View a = mo420a(menuItemImpl, this.f1287u, viewGroup);
                if (this.f1287u == null) {
                    this.f1287u = a;
                }
                if (this.f1282p) {
                    i8 -= ActionMenuView.m1788a(a, i5, i8, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = menuItemImpl.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                menuItemImpl.m1437d(true);
                i = i9;
                i2 = i6;
            } else if (menuItemImpl.m1442k()) {
                boolean z;
                int groupId = menuItemImpl.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.f1282p || i8 > 0);
                if (z3) {
                    View a2 = mo420a(menuItemImpl, this.f1287u, viewGroup);
                    if (this.f1287u == null) {
                        this.f1287u = a2;
                    }
                    boolean z4;
                    if (this.f1282p) {
                        int a3 = ActionMenuView.m1788a(a2, i5, i8, makeMeasureSpec, 0);
                        i9 = i8 - a3;
                        if (a3 == 0) {
                            i8 = 0;
                        } else {
                            z4 = z3;
                        }
                        i4 = i9;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i4 = i8;
                        z4 = z5;
                    }
                    i9 = a2.getMeasuredWidth();
                    i3 -= i9;
                    if (i2 == 0) {
                        i2 = i9;
                    }
                    if (this.f1282p) {
                        z = i8 & (i3 >= 0 ? 1 : 0);
                        i9 = i2;
                        i2 = i4;
                    } else {
                        z = i8 & (i3 + i2 > 0 ? 1 : 0);
                        i9 = i2;
                        i2 = i4;
                    }
                } else {
                    z = z3;
                    i9 = i2;
                    i2 = i8;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i8 = i6;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i4 = i6;
                    for (i6 = 0; i6 < i7; i6++) {
                        MenuItemImpl menuItemImpl2 = (MenuItemImpl) j.get(i6);
                        if (menuItemImpl2.getGroupId() == groupId) {
                            if (menuItemImpl2.m1441j()) {
                                i4++;
                            }
                            menuItemImpl2.m1437d(false);
                        }
                    }
                    i8 = i4;
                } else {
                    i8 = i6;
                }
                if (z) {
                    i8--;
                }
                menuItemImpl.m1437d(z);
                i4 = i9;
                i = i3;
                int i10 = i2;
                i2 = i8;
                i8 = i10;
            } else {
                menuItemImpl.m1437d(false);
                i4 = i2;
                i = i3;
                i2 = i6;
            }
            i7++;
            i3 = i;
            i6 = i2;
            i2 = i4;
        }
        return true;
    }

    public final void mo307a(MenuBuilder menuBuilder, boolean z) {
        m1782f();
        super.mo307a(menuBuilder, z);
    }

    public final void mo422a(boolean z) {
        if (z) {
            super.mo308a(null);
        } else {
            this.f806c.m1403a(false);
        }
    }

    public final void m1771a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.mo313a(this.f806c);
    }
}
