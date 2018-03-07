package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: updatePreviewState  */
public final class ExpandedMenuView extends ListView implements ItemInvoker, MenuView, OnItemClickListener {
    private static final int[] f818a = new int[]{16842964, 16843049};
    private MenuBuilder f819b;
    private int f820c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray a = TintTypedArray.m1693a(context, attributeSet, f818a, i, 0);
        if (a.m1702d(0)) {
            setBackgroundDrawable(a.m1695a(0));
        }
        if (a.m1702d(1)) {
            setDivider(a.m1695a(1));
        }
        a.m1698b();
    }

    public final void mo313a(MenuBuilder menuBuilder) {
        this.f819b = menuBuilder;
    }

    protected final void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1079751553);
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -147823233, a);
    }

    public final boolean mo314a(MenuItemImpl menuItemImpl) {
        return this.f819b.m1406a((MenuItem) menuItemImpl, 0);
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo314a((MenuItemImpl) getAdapter().getItem(i));
    }

    public final int getWindowAnimations() {
        return this.f820c;
    }
}
