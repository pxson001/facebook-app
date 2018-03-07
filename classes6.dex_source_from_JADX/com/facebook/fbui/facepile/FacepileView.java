package com.facebook.fbui.facepile;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: no partial record */
public class FacepileView extends View {
    private static final CallerContext f9978d = CallerContext.a(FacepileView.class, "unknown");
    @Inject
    FbDraweeControllerBuilder f9979a;
    @Inject
    NumberTruncationUtil f9980b;
    @Inject
    RTLUtil f9981c;
    private MultiDraweeHolder f9982e;
    private final GenericDraweeHierarchyBuilder f9983f;
    private final TextLayoutBuilder f9984g;
    private final List<Face> f9985h;
    private int f9986i;
    private int f9987j;
    private int f9988k;
    private int f9989l;
    private int f9990m;
    private int f9991n;
    private boolean f9992o;
    private int f9993p;
    private boolean f9994q;
    public int f9995r;
    private int f9996s;
    private int f9997t;
    private boolean f9998u;
    private Layout f9999v;
    private Paint f10000w;
    private Rect f10001x;
    private int f10002y;

    private static <T extends View> void m15690a(Class<T> cls, T t) {
        m15691a((Object) t, t.getContext());
    }

    private static void m15691a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FacepileView) obj).m15688a(FbDraweeControllerBuilder.b(fbInjector), NumberTruncationUtil.a(fbInjector), RTLUtil.a(fbInjector));
    }

    private void m15688a(FbDraweeControllerBuilder fbDraweeControllerBuilder, NumberTruncationUtil numberTruncationUtil, RTLUtil rTLUtil) {
        this.f9979a = fbDraweeControllerBuilder;
        this.f9980b = numberTruncationUtil;
        this.f9981c = rTLUtil;
    }

    public FacepileView(Context context) {
        this(context, null);
    }

    public FacepileView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772499);
    }

    public FacepileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9984g = new TextLayoutBuilder();
        this.f9987j = 0;
        this.f9989l = 0;
        this.f9990m = 0;
        this.f9991n = 0;
        this.f9993p = 0;
        this.f9994q = false;
        this.f9995r = 0;
        this.f9996s = 0;
        this.f9997t = 0;
        m15690a(FacepileView.class, (View) this);
        Resources resources = context.getResources();
        this.f9982e = new MultiDraweeHolder();
        this.f9983f = new GenericDraweeHierarchyBuilder(resources);
        this.f9979a.a(f9978d);
        this.f9985h = Lists.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FacepileView, i, 0);
        this.f9986i = obtainStyledAttributes.getInt(0, 8388659);
        this.f9989l = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.f9987j = obtainStyledAttributes.getInteger(10, 0);
        this.f9988k = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f9992o = obtainStyledAttributes.getBoolean(13, false);
        this.f9991n = obtainStyledAttributes.getDimensionPixelSize(14, 0);
        this.f9994q = obtainStyledAttributes.getBoolean(7, false);
        if (this.f9994q) {
            RoundingParams e = RoundingParams.e();
            this.f9996s = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f9997t = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            e.a(color, (float) this.f9996s);
            e.d((float) this.f9997t);
            this.f9983f.u = e;
        }
        this.f9995r = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.f9998u = obtainStyledAttributes.getBoolean(9, false);
        if (this.f9998u) {
            this.f9984g.c(obtainStyledAttributes.getColor(12, resources.getColor(2131361920))).b(resources.getDimensionPixelSize(2131427402)).a(Alignment.ALIGN_CENTER);
            this.f10000w = new Paint(1);
            this.f10000w.setColor(obtainStyledAttributes.getColor(11, resources.getColor(2131361957)));
            this.f10001x = new Rect();
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(15);
        if (drawable != null) {
            this.f9983f.f = drawable;
        }
        obtainStyledAttributes.recycle();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -980875547);
        super.onAttachedToWindow();
        this.f9982e.a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1028632844, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 691056573);
        super.onDetachedFromWindow();
        this.f9982e.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 316588896, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f9982e.b();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f9982e.a();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f9989l == 0 && MeasureSpec.getMode(i2) == 1073741824) {
            this.f9990m = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        } else {
            this.f9990m = this.f9989l;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            this.f9993p = Math.min(this.f9985h.size(), m15685a(size));
        } else {
            this.f9993p = this.f9985h.size();
        }
        if (mode == 1073741824) {
            mode = size;
        } else {
            mode = getWidthForFacesToDraw();
        }
        int i3 = 0;
        for (Face face : this.f9985h) {
            if (face != null) {
                if (face.f9956a != null && i3 < this.f9993p) {
                    FbPipelineDraweeController s = this.f9979a.b(face.f9956a).s();
                    DraweeHolder b = this.f9982e.b(i3);
                    b.a(s);
                    face.f9957b = b.h();
                    i3++;
                }
                if (face.f9957b != null) {
                    face.f9957b.setAlpha(face.f9961f);
                    face.f9957b.setCallback(this);
                }
                if (face.f9958c != null) {
                    face.f9958c.setCallback(this);
                }
            }
        }
        setMeasuredDimension(View.resolveSize(this.f9995r + mode, i), View.resolveSize(((this.f9990m + getPaddingTop()) + getPaddingBottom()) + this.f9995r, i2));
        m15695c();
    }

    private int m15685a(int i) {
        int horizontalPadding = getHorizontalPadding();
        return ((((i + horizontalPadding) - getPaddingStart()) - getPaddingEnd()) - this.f9995r) / (horizontalPadding + this.f9990m);
    }

    private int getWidthForFacesToDraw() {
        int totalItemsToDraw = getTotalItemsToDraw();
        int paddingEnd = getPaddingEnd() + ((m15693b(totalItemsToDraw) + (this.f9990m * totalItemsToDraw)) + getPaddingStart());
        totalItemsToDraw = (!this.f9998u || this.f9993p >= this.f9985h.size()) ? this.f9995r : 0;
        return totalItemsToDraw + paddingEnd;
    }

    private int m15693b(int i) {
        if (i == 0) {
            return 0;
        }
        return (i - 1) * getHorizontalPadding();
    }

    private boolean m15692a() {
        return this.f9998u && Math.max(this.f9985h.size(), this.f9987j) > this.f9993p;
    }

    private int getNumFacesToDraw() {
        this.f9993p = Math.min(this.f9993p, this.f9985h.size());
        Object obj = (m15685a(getMeasuredWidth()) > this.f9993p || !m15692a()) ? null : 1;
        return obj != null ? this.f9993p - 1 : this.f9993p;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9985h != null) {
            int numFacesToDraw = getNumFacesToDraw();
            int totalItemsToDraw = getTotalItemsToDraw() - 1;
            int size = this.f9985h.size();
            int i;
            Face face;
            if (m15694b()) {
                i = 0;
                while (i <= numFacesToDraw / 2 && i < size) {
                    face = (Face) this.f9985h.get(i);
                    face.f9957b.draw(canvas);
                    if (face.f9958c != null) {
                        face.f9958c.draw(canvas);
                    }
                    if (totalItemsToDraw - i == numFacesToDraw && m15692a()) {
                        m15687a(canvas);
                    } else if (i < totalItemsToDraw / 2) {
                        face = (Face) this.f9985h.get(totalItemsToDraw - i);
                        face.f9957b.draw(canvas);
                        if (face.f9958c != null) {
                            face.f9958c.draw(canvas);
                        }
                    }
                    i++;
                }
                return;
            }
            i = 0;
            while (i < numFacesToDraw && i < size) {
                face = (Face) this.f9985h.get(i);
                if (!(face == null || face.f9957b == null)) {
                    face.f9957b.draw(canvas);
                    if (face.f9958c != null) {
                        face.f9958c.draw(canvas);
                    }
                }
                i++;
            }
            if (m15692a()) {
                m15687a(canvas);
            }
        }
    }

    private void m15687a(Canvas canvas) {
        if (this.f9999v != null) {
            if (this.f9994q) {
                canvas.drawCircle(this.f10001x.exactCenterX(), this.f10001x.exactCenterY(), (float) (this.f10001x.width() / 2), this.f10000w);
            } else {
                canvas.drawRect(this.f10001x, this.f10000w);
            }
            canvas.translate((float) this.f10001x.left, (float) this.f10002y);
            this.f9999v.draw(canvas);
            canvas.translate((float) (-this.f10001x.left), (float) (-this.f10002y));
        }
    }

    private boolean m15694b() {
        return this.f9992o && getTotalItemsToDraw() % 2 != 0;
    }

    private int getTotalItemsToDraw() {
        return (m15692a() ? 1 : 0) + getNumFacesToDraw();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        for (Face face : this.f9985h) {
            if (face != null && (face.f9957b == drawable || face.f9958c == drawable)) {
                return true;
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void setHorizontalPadding(int i) {
        if (this.f9988k != i) {
            this.f9988k = i;
            requestLayout();
            invalidate();
        }
    }

    public void setGravity(int i) {
        if (this.f9986i != i) {
            this.f9986i = i;
            requestLayout();
            invalidate();
        }
    }

    public int getGravity() {
        return this.f9986i;
    }

    public int getDrawFaceCount() {
        return this.f9985h.size();
    }

    public void setFaceSize(int i) {
        if (this.f9989l != i) {
            this.f9989l = i;
            requestLayout();
            invalidate();
        }
    }

    public void setShowCentralizedSymmetricLayout(boolean z) {
        if (this.f9992o != z) {
            this.f9992o = z;
            requestLayout();
        }
    }

    public void setFaceSizeOffset(int i) {
        if (this.f9991n != i) {
            this.f9991n = i;
            requestLayout();
            invalidate();
        }
    }

    public int getFaceSize() {
        return this.f9990m;
    }

    public void setShowRoundFaces(boolean z) {
        if (this.f9994q != z) {
            RoundingParams e;
            this.f9994q = z;
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = this.f9983f;
            if (this.f9994q) {
                e = RoundingParams.e();
            } else {
                e = new RoundingParams();
            }
            genericDraweeHierarchyBuilder.u = e;
            requestLayout();
            invalidate();
        }
    }

    public void setBadgeOffset(int i) {
        if (this.f9995r != i) {
            this.f9995r = i;
            requestLayout();
            invalidate();
        }
    }

    public int getBadgeOffset() {
        return this.f9995r;
    }

    public int getHorizontalPadding() {
        int i;
        if (this.f9995r > 0) {
            i = this.f9995r;
        } else {
            i = 0;
        }
        return i + this.f9988k;
    }

    public void setFaceCountForOverflow(int i) {
        if (this.f9987j != i) {
            this.f9987j = i;
            requestLayout();
            invalidate();
        }
    }

    public int getFaceCountForOverflow() {
        return this.f9987j;
    }

    private void m15696c(int i) {
        while (this.f9982e.d() > i) {
            this.f9982e.a(this.f9982e.d() - 1);
        }
        while (this.f9982e.d() < i) {
            this.f9982e.a(new DraweeHolder(this.f9983f.u()));
        }
    }

    public void setFaceUrls(List<Uri> list) {
        if (list != null) {
            List a = Lists.a();
            for (Uri face : list) {
                a.add(new Face(face));
            }
            setFaces(a);
            return;
        }
        setFaces(null);
    }

    public void setFaceStrings(List<String> list) {
        if (list != null) {
            List a = Lists.a();
            for (String parse : list) {
                a.add(new Face(Uri.parse(parse)));
            }
            setFaces(a);
            return;
        }
        setFaces(null);
    }

    public void setFaceDrawables(List<Drawable> list) {
        if (list != null) {
            List a = Lists.a();
            for (Drawable face : list) {
                a.add(new Face(face));
            }
            setFaces(a);
            return;
        }
        setFaces(null);
    }

    public void setFaces(List<Face> list) {
        m15697a((List) list, null);
    }

    public final void m15697a(List<Face> list, MultiDraweeHolder multiDraweeHolder) {
        this.f9985h.clear();
        this.f9982e = multiDraweeHolder == null ? this.f9982e : multiDraweeHolder;
        if (list == null) {
            this.f9982e.c();
            requestLayout();
            invalidate();
            return;
        }
        if (multiDraweeHolder == null) {
            int i = 0;
            for (Face face : list) {
                int i2;
                if (face.f9956a != null) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            m15696c(i);
        }
        this.f9985h.addAll(list);
        requestLayout();
        invalidate();
    }

    public static List<Face> m15686a(List<Uri> list) {
        if (list == null) {
            return null;
        }
        List<Face> arrayList = new ArrayList();
        for (Uri face : list) {
            arrayList.add(new Face(face));
        }
        return arrayList;
    }

    private void m15695c() {
        if (!this.f9985h.isEmpty() || m15692a()) {
            boolean a = this.f9981c.a();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int numFacesToDraw = getNumFacesToDraw();
            int measuredHeight = getMeasuredHeight();
            int totalItemsToDraw = getTotalItemsToDraw();
            int i = this.f9986i & 112;
            int startX = getStartX();
            if (i == 80) {
                paddingBottom = (measuredHeight - this.f9990m) - paddingBottom;
            } else if (i == 16) {
                paddingBottom = paddingTop + ((((measuredHeight - this.f9990m) - paddingTop) - paddingBottom) / 2);
            } else {
                paddingBottom = paddingTop;
            }
            if (m15694b()) {
                if (m15692a() && a) {
                    startX += (this.f9990m + getHorizontalPadding()) - (this.f9991n * Math.abs((totalItemsToDraw / 2) - numFacesToDraw));
                }
                paddingTop = (this.f9991n * (totalItemsToDraw - 2)) + startX;
                startX = ((this.f9991n * totalItemsToDraw) / 4) + paddingBottom;
                measuredHeight = 0;
                paddingBottom = paddingTop;
                while (measuredHeight < numFacesToDraw) {
                    int horizontalPadding;
                    if (a) {
                        i = (numFacesToDraw - 1) - measuredHeight;
                        int abs = Math.abs((totalItemsToDraw / 2) - i) * this.f9991n;
                        ((Face) this.f9985h.get(i)).f9957b.setBounds(paddingBottom, startX, (this.f9990m + paddingBottom) - abs, (this.f9990m + startX) - abs);
                        horizontalPadding = paddingBottom + ((this.f9990m - abs) + getHorizontalPadding());
                        paddingBottom = ((i + 1 > totalItemsToDraw / 2 ? -1 : 1) * (this.f9991n / 2)) + startX;
                        paddingTop = horizontalPadding;
                    } else {
                        i = Math.abs((totalItemsToDraw / 2) - measuredHeight) * this.f9991n;
                        ((Face) this.f9985h.get(measuredHeight)).f9957b.setBounds(paddingBottom, startX, (this.f9990m + paddingBottom) - i, (this.f9990m + startX) - i);
                        horizontalPadding = paddingBottom + ((this.f9990m - i) + getHorizontalPadding());
                        paddingBottom = startX - ((measuredHeight + 1 > totalItemsToDraw / 2 ? -1 : 1) * (this.f9991n / 2));
                        paddingTop = horizontalPadding;
                    }
                    measuredHeight++;
                    startX = paddingBottom;
                    paddingBottom = paddingTop;
                }
                paddingTop = paddingBottom;
                paddingBottom = startX;
            } else {
                if (m15692a() && a) {
                    paddingTop = (this.f9990m + getHorizontalPadding()) + startX;
                } else {
                    paddingTop = startX;
                }
                int i2 = paddingTop;
                for (startX = 0; startX < numFacesToDraw; startX++) {
                    if (a) {
                        paddingTop = (numFacesToDraw - 1) - startX;
                    } else {
                        paddingTop = startX;
                    }
                    Face face = (Face) this.f9985h.get(paddingTop);
                    if (!(face == null || face.f9957b == null)) {
                        face.f9957b.setBounds(i2, paddingBottom, this.f9990m + i2, this.f9990m + paddingBottom);
                        if (face.f9958c != null) {
                            Drawable drawable = face.f9958c;
                            drawable.setBounds(((this.f9990m + i2) - drawable.getIntrinsicWidth()) + getBadgeOffset(), ((this.f9990m + paddingBottom) - drawable.getIntrinsicHeight()) + getBadgeOffset(), (this.f9990m + i2) + getBadgeOffset(), (this.f9990m + paddingBottom) + getBadgeOffset());
                        }
                    }
                    i2 += this.f9990m + getHorizontalPadding();
                }
                paddingTop = i2;
            }
            if (m15692a()) {
                startX = this.f9987j <= 0 ? this.f9985h.size() - numFacesToDraw : Math.max(this.f9987j, this.f9985h.size()) - numFacesToDraw;
                this.f9984g.a(this.f9994q ? this.f9990m - (this.f9996s * 2) : this.f9990m).a(getResources().getString(2131231953, new Object[]{this.f9980b.a(startX)}));
                startX = (int) this.f9984g.b();
                if (m15694b()) {
                    if (a) {
                        paddingTop = getStartX() + (this.f9991n * (totalItemsToDraw - 2));
                        paddingBottom += this.f9991n / 2;
                    }
                    m15689a(this.f9984g, this.f9990m - (this.f9991n * 2), 1, startX + 1);
                    this.f10001x.set(paddingTop, paddingBottom, (this.f9990m + paddingTop) - (this.f9991n * (totalItemsToDraw / 2)), (this.f9990m + paddingBottom) - (this.f9991n * (totalItemsToDraw / 2)));
                } else {
                    if (a) {
                        paddingTop = getStartX();
                    }
                    m15689a(this.f9984g, this.f9990m, 1, startX + 1);
                    this.f10001x.set(paddingTop, paddingBottom, this.f9990m + paddingTop, this.f9990m + paddingBottom);
                }
                this.f9999v = this.f9984g.d();
                this.f10002y = (((this.f9990m / 2) + paddingBottom) - this.f9991n) - (this.f9999v.getHeight() / 2);
            }
        }
    }

    private int getStartX() {
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        int measuredWidth = getMeasuredWidth();
        int widthForFacesToDraw = (getWidthForFacesToDraw() - paddingStart) - paddingEnd;
        int absoluteGravity = (this.f9981c.a() ? Gravity.getAbsoluteGravity(this.f9986i, 1) : this.f9986i) & 7;
        if (absoluteGravity == 5) {
            return (measuredWidth - widthForFacesToDraw) - paddingStart;
        }
        if (absoluteGravity == 1) {
            return paddingStart + ((((measuredWidth - widthForFacesToDraw) - paddingStart) - paddingEnd) / 2);
        }
        return paddingStart;
    }

    private static void m15689a(TextLayoutBuilder textLayoutBuilder, int i, int i2, int i3) {
        int i4 = i2;
        do {
            int i5 = (i4 + i3) / 2;
            if (textLayoutBuilder.b(i5).d().getHeight() <= i) {
                i2 = Math.max(i2, i5);
                i4 = i5 + 1;
                continue;
            } else {
                i3 = i5;
                continue;
            }
        } while (i4 < i3);
        textLayoutBuilder.b(i2);
    }
}
