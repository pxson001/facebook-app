package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.support.v7.internal.widget.CompatTextView;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: upsellPeopleLabel */
public class ActionMenuItemView extends CompatTextView implements ItemView, ActionMenuChildView, OnClickListener, OnLongClickListener {
    public MenuItemImpl f793a;
    private CharSequence f794b;
    private Drawable f795c;
    public ItemInvoker f796d;
    private ForwardingListener f797e;
    public PopupCallback f798f;
    private boolean f799g;
    private boolean f800h;
    private int f801i;
    private int f802j;
    private int f803k;

    /* compiled from: upsellPeopleLabel */
    class ActionMenuItemForwardingListener extends ForwardingListener {
        final /* synthetic */ ActionMenuItemView f792a;

        public ActionMenuItemForwardingListener(ActionMenuItemView actionMenuItemView) {
            this.f792a = actionMenuItemView;
            super(actionMenuItemView);
        }

        public final ListPopupWindow mo298a() {
            if (this.f792a.f798f != null) {
                return this.f792a.f798f.mo418a();
            }
            return null;
        }

        protected final boolean mo299b() {
            if (this.f792a.f796d == null || !this.f792a.f796d.mo314a(this.f792a.f793a)) {
                return false;
            }
            ListPopupWindow a = mo298a();
            if (a == null || !a.m1661b()) {
                return false;
            }
            return true;
        }

        protected final boolean mo300c() {
            ListPopupWindow a = mo298a();
            if (a == null) {
                return false;
            }
            a.m1657a();
            return true;
        }
    }

    /* compiled from: upsellPeopleLabel */
    public abstract class PopupCallback {
        public abstract ListPopupWindow mo418a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f799g = resources.getBoolean(2131296260);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i, 0);
        this.f801i = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.f803k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f802j = -1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f799g = getContext().getResources().getBoolean(2131296260);
        m1341e();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f802j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public MenuItemImpl getItemData() {
        return this.f793a;
    }

    public final void mo301a(MenuItemImpl menuItemImpl, int i) {
        this.f793a = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.m1430a((ItemView) this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f797e == null) {
            this.f797e = new ActionMenuItemForwardingListener(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1045319786);
        if (this.f793a.hasSubMenu() && this.f797e != null && this.f797e.onTouch(this, motionEvent)) {
            Logger.a(2, EntryType.UI_INPUT_END, 324020443, a);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-3609733, a);
        return onTouchEvent;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1955303562);
        if (this.f796d != null) {
            this.f796d.mo314a(this.f793a);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -1793959592, a);
    }

    public void setItemInvoker(ItemInvoker itemInvoker) {
        this.f796d = itemInvoker;
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f798f = popupCallback;
    }

    public final boolean gO_() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f800h != z) {
            this.f800h = z;
            if (this.f793a != null) {
                this.f793a.f890l.m1419i();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1341e() {
        /*
        r6 = this;
        r1 = 1;
        r2 = 0;
        r0 = r6.f794b;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x002e;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r3 = r6.f795c;
        if (r3 == 0) goto L_0x0024;
    L_0x000f:
        r3 = r6.f793a;
        r4 = r3.f895q;
        r4 = r4 & 4;
        r5 = 4;
        if (r4 != r5) goto L_0x0032;
    L_0x0018:
        r4 = 1;
    L_0x0019:
        r3 = r4;
        if (r3 == 0) goto L_0x0025;
    L_0x001c:
        r3 = r6.f799g;
        if (r3 != 0) goto L_0x0024;
    L_0x0020:
        r3 = r6.f800h;
        if (r3 == 0) goto L_0x0025;
    L_0x0024:
        r2 = r1;
    L_0x0025:
        r0 = r0 & r2;
        if (r0 == 0) goto L_0x0030;
    L_0x0028:
        r0 = r6.f794b;
    L_0x002a:
        r6.setText(r0);
        return;
    L_0x002e:
        r0 = r2;
        goto L_0x000b;
    L_0x0030:
        r0 = 0;
        goto L_0x002a;
    L_0x0032:
        r4 = 0;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.view.menu.ActionMenuItemView.e():void");
    }

    public void setIcon(Drawable drawable) {
        this.f795c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f803k) {
                f = ((float) this.f803k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f803k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f803k) {
                f = ((float) this.f803k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f803k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m1341e();
    }

    public final boolean m1343b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f794b = charSequence;
        setContentDescription(this.f794b);
        m1341e();
    }

    public final boolean mo302c() {
        return m1343b() && this.f793a.getIcon() == null;
    }

    public final boolean mo303d() {
        return m1343b();
    }

    public boolean onLongClick(View view) {
        if (m1343b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        int i2 = iArr[0] + (width / 2);
        if (ViewCompat.h(view) == 0) {
            i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
        }
        Toast makeText = Toast.makeText(context, this.f793a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, i2, height);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 698670199);
        boolean b = m1343b();
        if (b && this.f802j >= 0) {
            super.setPadding(this.f802j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.f801i) : this.f801i;
        if (mode != 1073741824 && this.f801i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!(b || this.f795c == null)) {
            super.setPadding((getMeasuredWidth() - this.f795c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        LogUtils.g(225108531, a);
    }
}
