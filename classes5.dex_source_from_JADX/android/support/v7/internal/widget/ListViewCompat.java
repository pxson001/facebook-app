package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* compiled from: undo_text */
public class ListViewCompat extends ListView {
    private static final int[] f1103f = new int[]{0};
    public final Rect f1104a = new Rect();
    int f1105b = 0;
    int f1106c = 0;
    int f1107d = 0;
    int f1108e = 0;
    private Field f1109g;
    private GateKeeperDrawable f1110h;

    /* compiled from: undo_text */
    public class GateKeeperDrawable extends DrawableWrapper {
        public boolean f1102a = true;

        public GateKeeperDrawable(Drawable drawable) {
            super(drawable);
        }

        public boolean setState(int[] iArr) {
            if (this.f1102a) {
                return super.setState(iArr);
            }
            return false;
        }

        public void draw(Canvas canvas) {
            if (this.f1102a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f1102a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f1102a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f1102a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public ListViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            this.f1109g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1109g.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void setSelector(Drawable drawable) {
        this.f1110h = drawable != null ? new GateKeeperDrawable(drawable) : null;
        super.setSelector(this.f1110h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1105b = rect.left;
        this.f1106c = rect.top;
        this.f1107d = rect.right;
        this.f1108e = rect.bottom;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        Drawable selector = getSelector();
        if (selector != null) {
            Object obj;
            if (mo449a() && isPressed()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                selector.setState(getDrawableState());
            }
        }
    }

    public boolean mo449a() {
        return false;
    }

    protected void dispatchDraw(Canvas canvas) {
        if (!this.f1104a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f1104a);
                selector.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    protected final void m1630a(int i, View view, float f, float f2) {
        m1627a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            DrawableCompat.a(selector, f, f2);
        }
    }

    private void m1627a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m1628b(i, view);
        if (z2) {
            Rect rect = this.f1104a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            DrawableCompat.a(selector, exactCenterX, exactCenterY);
        }
    }

    private void m1628b(int i, View view) {
        Rect rect = this.f1104a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1105b;
        rect.top -= this.f1106c;
        rect.right += this.f1107d;
        rect.bottom += this.f1108e;
        try {
            boolean z = this.f1109g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1109g.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public final int m1629a(int i, int i2, int i3) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i4 = 0;
        int i5 = 0;
        View view = null;
        int i6 = 0;
        while (i4 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i4);
            if (listPaddingTop != i5) {
                i5 = listPaddingTop;
                view2 = null;
            } else {
                view2 = view;
            }
            view = adapter.getView(i4, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                listPaddingTop = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            view.measure(i, listPaddingTop);
            if (i4 > 0) {
                listPaddingTop = listPaddingBottom + dividerHeight;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            listPaddingBottom = view.getMeasuredHeight() + listPaddingTop;
            if (listPaddingBottom < i2) {
                if (i3 < 0 || i4 < i3) {
                    listPaddingTop = i6;
                } else {
                    listPaddingTop = listPaddingBottom;
                }
                i4++;
                i6 = listPaddingTop;
            } else if (i3 < 0 || i4 <= i3 || i6 <= 0 || listPaddingBottom == i2) {
                return i2;
            } else {
                return i6;
            }
        }
        return listPaddingBottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f1110h != null) {
            this.f1110h.f1102a = z;
        }
    }
}
