package com.facebook.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.components.ComponentHostUtils.1;
import com.facebook.components.ComponentHostUtils.2;
import com.facebook.components.displaylist.DisplayListException;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: getMobileIfaces */
public class ComponentHost extends ViewGroup {
    public final SparseArrayCompat<MountItem> f22537a;
    public SparseArrayCompat<MountItem> f22538b;
    public final SparseArrayCompat<MountItem> f22539c;
    public SparseArrayCompat<MountItem> f22540d;
    public final DrawableHostHolder f22541e;
    private final InterleavedDispatchDraw f22542f;
    public final List<ComponentHost> f22543g;
    public int[] f22544h;
    public boolean f22545i;
    public long f22546j;
    private boolean f22547k;
    private ComponentAccessibilityDelegate f22548l;

    /* compiled from: getMobileIfaces */
    public class InterleavedDispatchDraw {
        final /* synthetic */ ComponentHost f22567a;
        public Canvas f22568b;
        public int f22569c;

        public InterleavedDispatchDraw(ComponentHost componentHost) {
            this.f22567a = componentHost;
        }

        public static boolean m30457a(InterleavedDispatchDraw interleavedDispatchDraw) {
            return interleavedDispatchDraw.f22568b != null && interleavedDispatchDraw.f22569c < interleavedDispatchDraw.f22567a.f22537a.m6348a();
        }

        public static void m30458b(InterleavedDispatchDraw interleavedDispatchDraw) {
            if (interleavedDispatchDraw.f22568b != null) {
                int i = interleavedDispatchDraw.f22569c;
                int a = interleavedDispatchDraw.f22567a.f22537a.m6348a();
                for (int i2 = i; i2 < a; i2++) {
                    Object obj;
                    MountItem mountItem = (MountItem) interleavedDispatchDraw.f22567a.f22537a.m6357f(i2);
                    if (mountItem.m30543k() != null) {
                        try {
                            mountItem.m30543k().m30577b(interleavedDispatchDraw.f22568b);
                            obj = null;
                        } catch (DisplayListException e) {
                        }
                        if (obj != null) {
                            obj = ((MountItem) interleavedDispatchDraw.f22567a.f22537a.m6357f(i2)).m30541c();
                            if (obj instanceof View) {
                                ((Drawable) obj).draw(interleavedDispatchDraw.f22568b);
                            } else {
                                interleavedDispatchDraw.f22569c = i2 + 1;
                                return;
                            }
                        }
                    }
                    i = 1;
                    if (obj != null) {
                        obj = ((MountItem) interleavedDispatchDraw.f22567a.f22537a.m6357f(i2)).m30541c();
                        if (obj instanceof View) {
                            ((Drawable) obj).draw(interleavedDispatchDraw.f22568b);
                        } else {
                            interleavedDispatchDraw.f22569c = i2 + 1;
                            return;
                        }
                    }
                }
                interleavedDispatchDraw.f22569c = interleavedDispatchDraw.f22567a.f22537a.m6348a();
            }
        }
    }

    public ComponentHost(Context context) {
        this(context, null);
    }

    public ComponentHost(Context context, AttributeSet attributeSet) {
        this(new ComponentContext(context), attributeSet);
    }

    public ComponentHost(ComponentContext componentContext) {
        this(componentContext, null);
    }

    public ComponentHost(ComponentContext componentContext, AttributeSet attributeSet) {
        super(componentContext, attributeSet);
        this.f22537a = new SparseArrayCompat();
        this.f22539c = new SparseArrayCompat();
        this.f22541e = new DrawableHostHolder(this);
        this.f22542f = new InterleavedDispatchDraw(this);
        this.f22543g = new ArrayList(3);
        this.f22544h = new int[0];
        setWillNotDraw(false);
        setChildrenDrawingOrderEnabled(true);
        this.f22548l = new ComponentAccessibilityDelegate(this);
        if (AccessibilityUtils.m30467a(getContext())) {
            ViewCompat.m10939a((View) this, this.f22548l);
        }
    }

    public final void m30438a(int i, MountItem mountItem) {
        Object obj = mountItem.f22616b;
        if (obj instanceof Drawable) {
            DrawableHostHolder drawableHostHolder = this.f22541e;
            drawableHostHolder.f22556a.m6351a(i, mountItem);
            Drawable drawable = (Drawable) mountItem.f22616b;
            View view = drawableHostHolder.f22566k;
            int i2 = mountItem.f22624j;
            drawable.setVisible(view.getVisibility() == 0, false);
            drawable.setCallback(view);
            ComponentHostUtils.m30650a(view, drawable, i2);
            view.invalidate(drawable.getBounds());
            if (drawable instanceof Touchable) {
                drawableHostHolder.f22558c.m6351a(i, (Touchable) drawable);
            }
        } else if (obj instanceof View) {
            this.f22539c.m6351a(i, mountItem);
            m30436a((View) obj, mountItem.f22624j);
        }
        this.f22537a.m6351a(i, mountItem);
        ComponentHostUtils.m30651a(mountItem);
    }

    public final void m30442b(int i, MountItem mountItem) {
        Object obj = mountItem.f22616b;
        if (obj instanceof Drawable) {
            this.f22541e.m30454a(i, (Drawable) obj);
        } else if (obj instanceof View) {
            m30435a((View) obj);
            if (ComponentHostUtils.m30652a(i, this.f22540d)) {
                this.f22540d.m6353b(i);
            } else {
                this.f22539c.m6353b(i);
            }
        }
        if (ComponentHostUtils.m30652a(i, this.f22538b)) {
            this.f22538b.m6353b(i);
        } else {
            this.f22537a.m6353b(i);
        }
        mo3291h();
        ComponentHostUtils.m30651a(mountItem);
    }

    public long getParentHostMarker() {
        return this.f22546j;
    }

    public List<Drawable> getDrawables() {
        DrawableHostHolder drawableHostHolder = this.f22541e;
        List<Drawable> arrayList = new ArrayList(drawableHostHolder.f22556a.m6348a());
        int a = drawableHostHolder.f22556a.m6348a();
        for (int i = 0; i < a; i++) {
            arrayList.add((Drawable) ((MountItem) drawableHostHolder.f22556a.m6357f(i)).f22616b);
        }
        return arrayList;
    }

    public TextContent getTextContent() {
        TextContent textContent;
        List a = ComponentHostUtils.m30647a(this.f22537a);
        Object obj;
        if (a.size() == 1) {
            obj = a.get(0);
            textContent = obj instanceof TextContent ? (TextContent) obj : TextContent.f23058b;
        } else {
            List arrayList = new ArrayList();
            for (Object obj2 : a) {
                if (obj2 instanceof TextContent) {
                    arrayList.addAll(((TextContent) obj2).mo3385a());
                }
            }
            textContent = new 1(arrayList);
        }
        return textContent;
    }

    public ImageContent getImageContent() {
        ImageContent imageContent;
        List a = ComponentHostUtils.m30647a(this.f22537a);
        Object obj;
        if (a.size() == 1) {
            obj = a.get(0);
            imageContent = obj instanceof ImageContent ? (ImageContent) obj : ImageContent.f23027b;
        } else {
            List arrayList = new ArrayList();
            for (Object obj2 : a) {
                if (obj2 instanceof ImageContent) {
                    arrayList.addAll(((ImageContent) obj2).hj_());
                }
            }
            imageContent = new 2(arrayList);
        }
        return imageContent;
    }

    public CharSequence getContentDescription() {
        return this.f22541e.f22561f;
    }

    public void setContentDescription(CharSequence charSequence) {
        DrawableHostHolder drawableHostHolder = this.f22541e;
        drawableHostHolder.f22561f = charSequence;
        drawableHostHolder.f22566k.m30441b();
    }

    public final void m30439a(MountItem mountItem, int i, int i2) {
        if (mountItem == null && this.f22538b != null) {
            mountItem = (MountItem) this.f22538b.m6350a(i);
        }
        if (mountItem != null) {
            Object obj = mountItem.f22616b;
            if (obj instanceof Drawable) {
                this.f22541e.m30455a(mountItem, i, i2);
            } else if (obj instanceof View) {
                if (this.f22539c.m6350a(i2) != null) {
                    if (this.f22540d == null) {
                        this.f22540d = ComponentsPools.m30529f();
                    }
                    ComponentHostUtils.m30649a(i2, this.f22539c, this.f22540d);
                }
                ComponentHostUtils.m30648a(i, i2, this.f22539c, this.f22540d);
            }
            if (this.f22537a.m6350a(i2) != null) {
                if (this.f22538b == null) {
                    this.f22538b = ComponentsPools.m30529f();
                }
                ComponentHostUtils.m30649a(i2, this.f22537a, this.f22538b);
            }
            ComponentHostUtils.m30648a(i, i2, this.f22537a, this.f22538b);
            mo3291h();
        }
    }

    public void setViewTags(SparseArray<Object> sparseArray) {
        this.f22541e.f22560e = sparseArray;
    }

    public final void m30440a(boolean z) {
        DrawableHostHolder drawableHostHolder = this.f22541e;
        if (drawableHostHolder.f22565j != z) {
            drawableHostHolder.f22565j = z;
            if (!drawableHostHolder.f22565j) {
                if (drawableHostHolder.f22563h) {
                    drawableHostHolder.f22566k.invalidate();
                    drawableHostHolder.f22563h = false;
                }
                if (drawableHostHolder.f22564i) {
                    drawableHostHolder.f22566k.m30441b();
                    drawableHostHolder.f22564i = false;
                }
            }
        }
    }

    public final void m30441b() {
        DrawableHostHolder drawableHostHolder = this.f22541e;
        boolean z = true;
        if (drawableHostHolder.f22565j) {
            drawableHostHolder.f22564i = true;
        } else {
            z = false;
        }
        if (!z) {
            this.f22548l.m26952a(-1);
        }
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f22548l.m26957a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public List<CharSequence> getContentDescriptions() {
        DrawableHostHolder drawableHostHolder = this.f22541e;
        List<CharSequence> arrayList = new ArrayList();
        int a = drawableHostHolder.f22556a.m6348a();
        for (int i = 0; i < a; i++) {
            CharSequence charSequence = ((MountItem) drawableHostHolder.f22556a.m6357f(i)).f22618d;
            if (charSequence != null) {
                arrayList.add(charSequence);
            }
        }
        List<CharSequence> list = arrayList;
        CharSequence contentDescription = getContentDescription();
        if (contentDescription != null) {
            list.add(contentDescription);
        }
        return list;
    }

    private void m30436a(View view, int i) {
        view.setDuplicateParentStateEnabled(MountItem.m30537b(i));
        this.f22545i = true;
        if ((view instanceof ComponentHost) && view.getParent() == this) {
            view.setVisibility(0);
            return;
        }
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(generateDefaultLayoutParams());
        }
        if (this.f22547k) {
            addViewInLayout(view, -1, view.getLayoutParams(), true);
        } else {
            addView(view, -1, view.getLayoutParams());
        }
    }

    private void m30435a(View view) {
        this.f22545i = true;
        if (view instanceof ComponentHost) {
            view.setVisibility(8);
            this.f22543g.add((ComponentHost) view);
        } else if (this.f22547k) {
            removeViewInLayout(view);
        } else {
            removeView(view);
        }
    }

    public void dispatchDraw(Canvas canvas) {
        InterleavedDispatchDraw interleavedDispatchDraw = this.f22542f;
        interleavedDispatchDraw.f22568b = canvas;
        interleavedDispatchDraw.f22569c = 0;
        super.dispatchDraw(canvas);
        if (InterleavedDispatchDraw.m30457a(this.f22542f)) {
            InterleavedDispatchDraw.m30458b(this.f22542f);
        }
        this.f22542f.f22568b = null;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f22545i) {
            int i3;
            int childCount = getChildCount();
            if (this.f22544h.length < childCount) {
                this.f22544h = new int[(childCount + 5)];
            }
            int a = this.f22539c.m6348a();
            for (i3 = 0; i3 < a; i3++) {
                this.f22544h[i3] = indexOfChild((View) ((MountItem) this.f22539c.m6357f(i3)).f22616b);
            }
            int size = this.f22543g.size();
            for (i3 = 0; i3 < size; i3++) {
                this.f22544h[i3 + a] = indexOfChild((View) this.f22543g.get(i3));
            }
            this.f22545i = false;
        }
        if (InterleavedDispatchDraw.m30457a(this.f22542f)) {
            InterleavedDispatchDraw.m30458b(this.f22542f);
        }
        return this.f22544h[i2];
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Object obj;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1683699566);
        DrawableHostHolder drawableHostHolder = this.f22541e;
        for (int a2 = drawableHostHolder.f22558c.m6348a() - 1; a2 >= 0; a2--) {
            Touchable touchable = (Touchable) drawableHostHolder.f22558c.m6357f(a2);
            if (touchable.mo3375a(motionEvent) && touchable.mo3376a(motionEvent, drawableHostHolder.f22566k)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        boolean z = obj != null || super.onTouchEvent(motionEvent);
        LogUtils.a(285832651, a);
        return z;
    }

    void mo3289c() {
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f22547k = true;
        mo3289c();
        this.f22547k = false;
    }

    public void requestLayout() {
        ViewParent viewParent = this;
        while (viewParent instanceof ComponentHost) {
            if (((ComponentHost) viewParent).mo3290d()) {
                viewParent = viewParent.getParent();
            } else {
                return;
            }
        }
        super.requestLayout();
    }

    protected boolean mo3290d() {
        return !this.f22547k;
    }

    @SuppressLint({"MissingSuperCall"})
    protected boolean verifyDrawable(Drawable drawable) {
        return true;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        DrawableHostHolder drawableHostHolder = this.f22541e;
        int a = drawableHostHolder.f22556a.m6348a();
        for (int i = 0; i < a; i++) {
            MountItem mountItem = (MountItem) drawableHostHolder.f22556a.m6357f(i);
            ComponentHostUtils.m30650a(drawableHostHolder.f22566k, (Drawable) mountItem.f22616b, mountItem.f22624j);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        DrawableHostHolder drawableHostHolder = this.f22541e;
        int a = drawableHostHolder.f22556a.m6348a();
        for (int i = 0; i < a; i++) {
            DrawableCompat.a((Drawable) ((MountItem) drawableHostHolder.f22556a.m6357f(i)).f22616b);
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        DrawableHostHolder drawableHostHolder = this.f22541e;
        int a = drawableHostHolder.f22556a.m6348a();
        for (int i2 = 0; i2 < a; i2++) {
            boolean z;
            Drawable drawable = (Drawable) ((MountItem) drawableHostHolder.f22556a.m6357f(i2)).f22616b;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            drawable.setVisible(z, false);
        }
    }

    public Object getTag(int i) {
        Object obj;
        DrawableHostHolder drawableHostHolder = this.f22541e;
        if (drawableHostHolder.f22560e != null) {
            obj = drawableHostHolder.f22560e.get(i);
        } else {
            obj = null;
        }
        Object obj2 = obj;
        return obj2 != null ? obj2 : super.getTag(i);
    }

    public void invalidate(Rect rect) {
        if (!this.f22541e.m30456g()) {
            super.invalidate(rect);
        }
    }

    public void invalidate(int i, int i2, int i3, int i4) {
        if (!this.f22541e.m30456g()) {
            super.invalidate(i, i2, i3, i4);
        }
    }

    public void invalidate() {
        if (this.f22541e == null || !this.f22541e.m30456g()) {
            super.invalidate();
        }
    }

    private void mo3291h() {
        if (this.f22538b != null && this.f22538b.m6348a() == 0) {
            ComponentsPools.m30522a(this.f22538b);
            this.f22538b = null;
        }
        if (this.f22540d != null && this.f22540d.m6348a() == 0) {
            ComponentsPools.m30522a(this.f22540d);
            this.f22540d = null;
        }
    }
}
