package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: usage_context_sentence */
public class MenuBuilder implements SupportMenu {
    private static final int[] f846d = new int[]{1, 4, 5, 3, 2, 0};
    public CharSequence f847a;
    public Drawable f848b;
    public View f849c;
    public final Context f850e;
    public final Resources f851f;
    private boolean f852g;
    public boolean f853h;
    private Callback f854i;
    public ArrayList<MenuItemImpl> f855j;
    private ArrayList<MenuItemImpl> f856k;
    private boolean f857l;
    public ArrayList<MenuItemImpl> f858m;
    private ArrayList<MenuItemImpl> f859n;
    private boolean f860o;
    public int f861p = 1;
    private ContextMenuInfo f862q;
    private boolean f863r = false;
    private boolean f864s = false;
    public boolean f865t = false;
    private boolean f866u = false;
    private ArrayList<MenuItemImpl> f867v = new ArrayList();
    public CopyOnWriteArrayList<WeakReference<MenuPresenter>> f868w = new CopyOnWriteArrayList();
    public MenuItemImpl f869x;

    /* compiled from: usage_context_sentence */
    public interface Callback {
        boolean mo214a(MenuBuilder menuBuilder, MenuItem menuItem);

        void b_(MenuBuilder menuBuilder);
    }

    /* compiled from: usage_context_sentence */
    public interface ItemInvoker {
        boolean mo314a(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f850e = context;
        this.f851f = context.getResources();
        this.f855j = new ArrayList();
        this.f856k = new ArrayList();
        this.f857l = true;
        this.f858m = new ArrayList();
        this.f859n = new ArrayList();
        this.f860o = true;
        boolean z = true;
        if (1 == null || this.f851f.getConfiguration().keyboard == 1 || !this.f851f.getBoolean(2131296259)) {
            z = false;
        }
        this.f853h = z;
    }

    public final void m1401a(MenuPresenter menuPresenter) {
        m1402a(menuPresenter, this.f850e);
    }

    public final void m1402a(MenuPresenter menuPresenter, Context context) {
        this.f868w.add(new WeakReference(menuPresenter));
        menuPresenter.mo306a(context, this);
        this.f860o = true;
    }

    public final void m1409b(MenuPresenter menuPresenter) {
        Iterator it = this.f868w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.f868w.remove(weakReference);
            }
        }
    }

    public final void m1399a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = MenuItemCompat.m379a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (MenuItemCompat.m383c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).m1399a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo329a(), sparseArray);
        }
    }

    public final void m1408b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo329a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = MenuItemCompat.m379a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).m1408b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    MenuItemCompat.m382b(item);
                }
            }
        }
    }

    protected String mo329a() {
        return "android:menu:actionviewstates";
    }

    public void mo330a(Callback callback) {
        this.f854i = callback;
    }

    private MenuItem m1389a(int i, int i2, int i3, CharSequence charSequence) {
        int i4;
        int d = m1394d(i3);
        MenuItem a = m1387a(i, i2, i3, d, charSequence, this.f861p);
        if (this.f862q != null) {
            a.f900v = this.f862q;
        }
        ArrayList arrayList = this.f855j;
        ArrayList arrayList2 = this.f855j;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            if (((MenuItemImpl) arrayList2.get(size)).f882d <= d) {
                i4 = size + 1;
                break;
            }
        }
        i4 = 0;
        arrayList.add(i4, a);
        m1410b(true);
        return a;
    }

    private MenuItemImpl m1387a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return m1389a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return m1389a(0, 0, 0, this.f851f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m1389a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m1389a(i, i2, i3, this.f851f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f851f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) m1389a(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f850e, this, menuItemImpl);
        menuItemImpl.m1431a(subMenuBuilder);
        return subMenuBuilder;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f851f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f850e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeGroup(int i) {
        int c = m1393c(i);
        if (c >= 0) {
            int size = this.f855j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((MenuItemImpl) this.f855j.get(c)).getGroupId() != i) {
                    m1410b(true);
                } else {
                    m1391a(c, false);
                    i2 = i3;
                }
            }
            m1410b(true);
        }
    }

    private void m1391a(int i, boolean z) {
        if (i >= 0 && i < this.f855j.size()) {
            this.f855j.remove(i);
            if (z) {
                m1410b(true);
            }
        }
    }

    public void clear() {
        if (this.f869x != null) {
            mo334b(this.f869x);
        }
        this.f855j.clear();
        m1410b(true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f855j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f855j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.m1432a(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f855j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f855j.get(i2);
            if (menuItemImpl.getGroupId() == i && menuItemImpl.m1435c(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            m1410b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f855j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f855j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((MenuItemImpl) this.f855j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f855j.get(i2);
            if (menuItemImpl.getItemId() == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu()) {
                MenuItem findItem = menuItemImpl.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public void removeItem(int i) {
        int i2;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((MenuItemImpl) this.f855j.get(i3)).getItemId() == i) {
                i2 = i3;
                break;
            }
        }
        i2 = -1;
        m1391a(i2, true);
    }

    private int m1393c(int i) {
        return m1386a(i, 0);
    }

    private int m1386a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((MenuItemImpl) this.f855j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.f855j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f855j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m1388a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.f852g = z;
        m1410b(false);
    }

    private static int m1394d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f846d.length) {
            return (f846d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean mo333b() {
        return this.f852g;
    }

    public boolean mo335c() {
        return this.f853h;
    }

    public final Context m1414d() {
        return this.f850e;
    }

    boolean mo331a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f854i != null && this.f854i.mo214a(menuBuilder, menuItem);
    }

    public final void m1415e() {
        if (this.f854i != null) {
            this.f854i.b_(this);
        }
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m1388a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m1406a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m1403a(true);
        }
        return z;
    }

    private void m1392a(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        boolean b = mo333b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f855j.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) this.f855j.get(i2);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).m1392a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && menuItemImpl.isEnabled())) {
                    list.add(menuItemImpl);
                }
            }
        }
    }

    private MenuItemImpl m1388a(int i, KeyEvent keyEvent) {
        List list = this.f867v;
        list.clear();
        m1392a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (MenuItemImpl) list.get(0);
        }
        boolean b = mo333b();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) list.get(i2);
            char alphabeticShortcut = b ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return menuItemImpl;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return menuItemImpl;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m1406a(findItem(i), i2);
    }

    public final boolean m1406a(MenuItem menuItem, int i) {
        return m1407a(menuItem, null, i);
    }

    public final boolean m1407a(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean z;
        boolean b = menuItemImpl.m1434b();
        ActionProvider a = menuItemImpl.mo289a();
        if (a == null || !a.mo319e()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (menuItemImpl.m1444n()) {
            expandActionView = menuItemImpl.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m1403a(true);
            return expandActionView;
        } else if (menuItemImpl.hasSubMenu() || z) {
            m1403a(false);
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.m1431a(new SubMenuBuilder(this.f850e, this, menuItemImpl));
            }
            SubMenu subMenu = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                a.mo317a(subMenu);
            }
            boolean z2 = false;
            if (!this.f868w.isEmpty()) {
                if (menuPresenter != null) {
                    z2 = menuPresenter.mo308a(subMenu);
                }
                Iterator it = this.f868w.iterator();
                boolean z3 = z2;
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
                    if (menuPresenter2 == null) {
                        this.f868w.remove(weakReference);
                    } else {
                        if (z3) {
                            z2 = z3;
                        } else {
                            z2 = menuPresenter2.mo308a(subMenu);
                        }
                        z3 = z2;
                    }
                }
                z2 = z3;
            }
            expandActionView = z2 | b;
            if (expandActionView) {
                return expandActionView;
            }
            m1403a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m1403a(true);
            }
            return b;
        }
    }

    public final void m1403a(boolean z) {
        if (!this.f866u) {
            this.f866u = true;
            Iterator it = this.f868w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f868w.remove(weakReference);
                } else {
                    menuPresenter.mo307a(this, z);
                }
            }
            this.f866u = false;
        }
    }

    public void close() {
        m1403a(true);
    }

    public final void m1410b(boolean z) {
        if (this.f863r) {
            this.f864s = true;
            return;
        }
        if (z) {
            this.f857l = true;
            this.f860o = true;
        }
        if (!this.f868w.isEmpty()) {
            m1416f();
            Iterator it = this.f868w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f868w.remove(weakReference);
                } else {
                    menuPresenter.mo309b(z);
                }
            }
            m1417g();
        }
    }

    public final void m1416f() {
        if (!this.f863r) {
            this.f863r = true;
            this.f864s = false;
        }
    }

    public final void m1417g() {
        this.f863r = false;
        if (this.f864s) {
            this.f864s = false;
            m1410b(true);
        }
    }

    final void m1418h() {
        this.f857l = true;
        m1410b(true);
    }

    public final void m1419i() {
        this.f860o = true;
        m1410b(true);
    }

    public final ArrayList<MenuItemImpl> m1420j() {
        if (!this.f857l) {
            return this.f856k;
        }
        this.f856k.clear();
        int size = this.f855j.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f855j.get(i);
            if (menuItemImpl.isVisible()) {
                this.f856k.add(menuItemImpl);
            }
        }
        this.f857l = false;
        this.f860o = true;
        return this.f856k;
    }

    public final void m1421k() {
        ArrayList j = m1420j();
        if (this.f860o) {
            Iterator it = this.f868w.iterator();
            int i = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f868w.remove(weakReference);
                } else {
                    i = menuPresenter.mo310b() | i;
                }
            }
            if (i != 0) {
                this.f858m.clear();
                this.f859n.clear();
                i = j.size();
                for (int i2 = 0; i2 < i; i2++) {
                    MenuItemImpl menuItemImpl = (MenuItemImpl) j.get(i2);
                    if (menuItemImpl.m1441j()) {
                        this.f858m.add(menuItemImpl);
                    } else {
                        this.f859n.add(menuItemImpl);
                    }
                }
            } else {
                this.f858m.clear();
                this.f859n.clear();
                this.f859n.addAll(m1420j());
            }
            this.f860o = false;
        }
    }

    public final ArrayList<MenuItemImpl> m1422m() {
        m1421k();
        return this.f859n;
    }

    public void clearHeader() {
        this.f848b = null;
        this.f847a = null;
        this.f849c = null;
        m1410b(false);
    }

    private void m1390a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = this.f851f;
        if (view != null) {
            this.f849c = view;
            this.f847a = null;
            this.f848b = null;
        } else {
            if (i > 0) {
                this.f847a = resources.getText(i);
            } else if (charSequence != null) {
                this.f847a = charSequence;
            }
            if (i2 > 0) {
                this.f848b = ContextCompat.a(this.f850e, i2);
            } else if (drawable != null) {
                this.f848b = drawable;
            }
            this.f849c = null;
        }
        m1410b(false);
    }

    protected final MenuBuilder m1397a(CharSequence charSequence) {
        m1390a(0, charSequence, 0, null, null);
        return this;
    }

    protected final MenuBuilder m1395a(Drawable drawable) {
        m1390a(0, null, 0, drawable, null);
        return this;
    }

    protected final MenuBuilder m1396a(View view) {
        m1390a(0, null, 0, null, view);
        return this;
    }

    public MenuBuilder mo336q() {
        return this;
    }

    public boolean mo332a(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f868w.isEmpty()) {
            m1416f();
            Iterator it = this.f868w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter != null) {
                    z = menuPresenter.mo311b(menuItemImpl);
                    if (z) {
                        break;
                    }
                    z2 = z;
                } else {
                    this.f868w.remove(weakReference);
                }
            }
            z = z2;
            m1417g();
            if (z) {
                this.f869x = menuItemImpl;
            }
        }
        return z;
    }

    public boolean mo334b(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f868w.isEmpty() && this.f869x == menuItemImpl) {
            m1416f();
            Iterator it = this.f868w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter != null) {
                    z = menuPresenter.mo312c(menuItemImpl);
                    if (z) {
                        break;
                    }
                    z2 = z;
                } else {
                    this.f868w.remove(weakReference);
                }
            }
            z = z2;
            m1417g();
            if (z) {
                this.f869x = null;
            }
        }
        return z;
    }
}
