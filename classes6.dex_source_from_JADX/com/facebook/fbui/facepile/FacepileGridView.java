package com.facebook.fbui.facepile;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: no upload record for this upload */
public class FacepileGridView extends View {
    private static final CallerContext f9962b = CallerContext.a(FacepileGridView.class, "unknown");
    @Inject
    public FbDraweeControllerBuilder f9963a;
    private final MultiDraweeHolder f9964c;
    private final GenericDraweeHierarchyBuilder f9965d;
    private final ArrayList<Face> f9966e;
    public int f9967f;
    private int f9968g;
    public int f9969h;
    private int f9970i;
    private int f9971j;
    private int f9972k;
    public int f9973l;
    private int f9974m;
    private ColumnLengthsTracker f9975n;
    private boolean f9976o;
    private boolean f9977p;

    private static <T extends View> void m15677a(Class<T> cls, T t) {
        m15678a((Object) t, t.getContext());
    }

    private static void m15678a(Object obj, Context context) {
        ((FacepileGridView) obj).f9963a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    private void m15676a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f9963a = fbDraweeControllerBuilder;
    }

    public FacepileGridView(Context context) {
        this(context, null);
    }

    public FacepileGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772500);
    }

    public FacepileGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9964c = new MultiDraweeHolder();
        this.f9966e = Lists.a();
        this.f9976o = false;
        this.f9977p = false;
        m15677a(FacepileGridView.class, (View) this);
        this.f9963a.a(f9962b);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FacepileGridView, i, 0);
        this.f9969h = obtainStyledAttributes.getInt(3, 1);
        this.f9970i = obtainStyledAttributes.getInt(2, 1);
        this.f9971j = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f9972k = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.f9967f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f9968g = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        this.f9973l = this.f9971j;
        this.f9974m = this.f9972k == 0 ? this.f9973l : this.f9972k;
        this.f9965d = new GenericDraweeHierarchyBuilder(context.getResources());
        this.f9975n = new ColumnLengthsTracker(this.f9970i);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1294768070);
        super.onAttachedToWindow();
        this.f9964c.a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1258915197, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1615672358);
        super.onDetachedFromWindow();
        this.f9964c.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1467175532, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f9964c.b();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f9964c.a();
    }

    public void setFaces(List<Face> list) {
        this.f9966e.clear();
        if (list != null) {
            this.f9966e.addAll(list);
        }
        m15680b();
        invalidate();
    }

    public void setVerticalPadding(int i) {
        if (this.f9968g != i) {
            this.f9968g = i;
            m15675a();
        }
    }

    public int getVerticalPadding() {
        return this.f9968g;
    }

    public void setHorizontalPadding(int i) {
        if (this.f9967f != i) {
            this.f9967f = i;
            m15675a();
        }
    }

    public int getHorizontalPadding() {
        return this.f9967f;
    }

    public void setCellWidth(int i) {
        if (this.f9971j != i) {
            this.f9971j = i;
            m15675a();
        }
    }

    public void setCellHeight(int i) {
        if (this.f9972k != i) {
            this.f9972k = i;
            m15675a();
        }
    }

    public void setNumRows(int i) {
        if (this.f9969h != i && i > 0) {
            this.f9969h = i;
            m15675a();
        }
    }

    public int getCellWidth() {
        return this.f9973l;
    }

    public int getCellHeight() {
        return this.f9974m;
    }

    public int getNumRows() {
        return this.f9969h;
    }

    public void setNumCols(int i) {
        if (this.f9970i != i && i > 0) {
            this.f9970i = i;
            m15675a();
            this.f9975n = new ColumnLengthsTracker(i);
        }
    }

    public int getNumCols() {
        return this.f9970i;
    }

    private void m15675a() {
        requestLayout();
        this.f9977p = true;
    }

    protected void onMeasure(int i, int i2) {
        int resolveSize = View.resolveSize(getPreferredWidth(), i);
        setMeasuredDimension(resolveSize, View.resolveSize(m15674a(resolveSize), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int b = m15679b(i3 - i);
        int c = m15681c(i4 - i2);
        if (!(this.f9973l == b && this.f9974m == c)) {
            this.f9973l = b;
            this.f9974m = c;
            this.f9977p = true;
        }
        if (this.f9976o) {
            m15682c();
        }
        if (this.f9977p) {
            m15684d();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f9966e.size();
        for (int i = 0; i != size; i++) {
            Face face = (Face) this.f9966e.get(i);
            face.f9957b.draw(canvas);
            if (face.f9958c != null) {
                face.f9958c.draw(canvas);
            }
        }
    }

    private int getPreferredWidth() {
        return (getPaddingLeft() + getPaddingRight()) + (((this.f9971j + this.f9967f) * this.f9970i) - this.f9967f);
    }

    private int m15674a(int i) {
        int i2 = this.f9972k;
        if (i2 == 0) {
            i2 = m15679b(i);
        }
        return (((i2 + this.f9968g) * this.f9969h) - this.f9968g) + (getPaddingTop() + getPaddingBottom());
    }

    private int m15679b(int i) {
        if (this.f9971j > 0) {
            return this.f9971j;
        }
        return Math.max(0, ((((i - getPaddingLeft()) - getPaddingRight()) + this.f9967f) / this.f9970i) - this.f9967f);
    }

    private int m15681c(int i) {
        if (this.f9972k > 0) {
            return this.f9972k;
        }
        return Math.max(0, ((((i - getPaddingTop()) - getPaddingBottom()) + this.f9968g) / this.f9969h) - this.f9968g);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        int size = this.f9966e.size();
        for (int i = 0; i != size; i++) {
            Face face = (Face) this.f9966e.get(i);
            if (face.f9957b == drawable || face.f9958c == drawable) {
                return true;
            }
        }
        return super.verifyDrawable(drawable);
    }

    private DraweeHolder m15683d(int i) {
        if (i == this.f9964c.d()) {
            this.f9964c.a(DraweeHolder.a(this.f9965d.u(), getContext()));
        }
        return this.f9964c.b(i);
    }

    private void m15680b() {
        boolean z;
        this.f9976o = false;
        this.f9977p = false;
        if (this.f9973l <= 0 || this.f9974m <= 0) {
            z = false;
        } else {
            z = true;
        }
        int size = this.f9966e.size();
        int i = 0;
        for (int i2 = 0; i2 != size; i2++) {
            Face face = (Face) this.f9966e.get(i2);
            if (face.f9956a != null) {
                DraweeController s;
                int i3 = i + 1;
                DraweeHolder d = m15683d(i);
                face.f9957b = d.h();
                DraweeController draweeController = d.f;
                if (z) {
                    i = (face.f9960e * (this.f9973l + this.f9967f)) - this.f9967f;
                    int i4 = (face.f9959d * (this.f9974m + this.f9968g)) - this.f9968g;
                    FbDraweeControllerBuilder fbDraweeControllerBuilder = this.f9963a;
                    ImageRequestBuilder a = ImageRequestBuilder.a(face.f9956a);
                    a.d = new ResizeOptions(i, i4);
                    s = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) fbDraweeControllerBuilder.c(a.m())).b(draweeController)).s();
                } else {
                    s = ((FbDraweeControllerBuilder) this.f9963a.b(face.f9956a).b(draweeController)).s();
                }
                d.a(s);
                i = i3;
            }
            face.f9957b.setAlpha(face.f9961f);
            face.f9957b.setCallback(this);
            if (face.f9958c != null) {
                face.f9958c.setCallback(this);
            }
        }
        while (this.f9964c.d() > i) {
            this.f9964c.a(this.f9964c.d() - 1);
        }
        if (z) {
            m15684d();
        } else {
            this.f9977p = true;
        }
    }

    private void m15682c() {
        this.f9976o = false;
        int size = this.f9966e.size();
        int i = 0;
        int i2 = 0;
        while (i != size) {
            int i3;
            Face face = (Face) this.f9966e.get(i);
            if (face.f9956a != null) {
                int i4 = i2 + 1;
                DraweeHolder b = this.f9964c.b(i2);
                int i5 = (face.f9960e * (this.f9973l + this.f9967f)) - this.f9967f;
                int i6 = (face.f9959d * (this.f9974m + this.f9968g)) - this.f9968g;
                FbDraweeControllerBuilder fbDraweeControllerBuilder = this.f9963a;
                ImageRequestBuilder a = ImageRequestBuilder.a(face.f9956a);
                a.d = new ResizeOptions(i5, i6);
                b.a(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) fbDraweeControllerBuilder.c(a.m())).b(b.f)).s());
                i3 = i4;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
    }

    private void m15684d() {
        this.f9977p = false;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i = this.f9973l + this.f9967f;
        int i2 = this.f9974m + this.f9968g;
        this.f9975n.m15673b();
        int size = this.f9966e.size();
        for (int i3 = 0; i3 != size; i3++) {
            int a = this.f9975n.m15670a();
            int a2 = this.f9975n.m15671a(a);
            Face face = (Face) this.f9966e.get(i3);
            int i4 = face.f9960e;
            int i5 = face.f9959d;
            if (face.f9957b != null) {
                int i6 = (i * a) + paddingLeft;
                int i7 = (i2 * a2) + paddingTop;
                int i8 = ((i4 * i) + i6) - this.f9967f;
                int i9 = ((i5 * i2) + i7) - this.f9968g;
                face.f9957b.setBounds(i6, i7, i8, i9);
                Drawable drawable = face.f9958c;
                if (drawable != null) {
                    drawable.setBounds(i8 - drawable.getIntrinsicWidth(), i9 - drawable.getIntrinsicHeight(), i8, i9);
                }
            }
            a2 += i5;
            for (int i10 = a; i10 < a + i4; i10++) {
                this.f9975n.m15672a(i10, a2);
            }
        }
        invalidate();
    }
}
