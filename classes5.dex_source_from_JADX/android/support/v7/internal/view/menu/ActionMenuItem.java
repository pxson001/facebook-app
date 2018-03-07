package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* compiled from: upsellTimeLabel */
public class ActionMenuItem implements SupportMenuItem {
    private final int f768a;
    private final int f769b;
    private final int f770c;
    private final int f771d;
    private CharSequence f772e;
    private CharSequence f773f;
    private Intent f774g;
    private char f775h;
    private char f776i;
    private Drawable f777j;
    private int f778k = 0;
    private Context f779l;
    private OnMenuItemClickListener f780m;
    private int f781n = 16;

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f779l = context;
        this.f768a = i2;
        this.f769b = i;
        this.f770c = i3;
        this.f771d = i4;
        this.f772e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f776i;
    }

    public int getGroupId() {
        return this.f769b;
    }

    public Drawable getIcon() {
        return this.f777j;
    }

    public Intent getIntent() {
        return this.f774g;
    }

    public int getItemId() {
        return this.f768a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f775h;
    }

    public int getOrder() {
        return this.f771d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f772e;
    }

    public CharSequence getTitleCondensed() {
        return this.f773f != null ? this.f773f : this.f772e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f781n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f781n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f781n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f781n & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f776i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f781n = (z ? 1 : 0) | (this.f781n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f781n = (z ? 2 : 0) | (this.f781n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f781n = (z ? 16 : 0) | (this.f781n & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f777j = drawable;
        this.f778k = 0;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f778k = i;
        this.f777j = ContextCompat.a(this.f779l, i);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f774g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f775h = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f780m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f775h = c;
        this.f776i = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f772e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f772e = this.f779l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f773f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f781n = (z ? 0 : 8) | (this.f781n & 8);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public final android.support.v4.view.ActionProvider mo289a() {
        return null;
    }

    public final SupportMenuItem mo287a(android.support.v4.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public final SupportMenuItem mo288a(MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        return this;
    }
}
