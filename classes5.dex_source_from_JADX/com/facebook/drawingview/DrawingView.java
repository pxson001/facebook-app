package com.facebook.drawingview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: ZeroIndicatorBase */
public class DrawingView extends View {
    private static final String f11998c = DrawingView.class.getSimpleName();
    private final Runnable f11999A;
    private DrawingAudioState f12000B;
    LinkedList<DrawPoint> f12001a;
    LinkedList<LinkedList<DrawPoint>> f12002b;
    public DrawingListener f12003d;
    private Paint f12004e;
    private Bitmap f12005f;
    private Canvas f12006g;
    private Paint f12007h;
    private float f12008i;
    private float f12009j;
    private float f12010k;
    private int f12011l;
    private OnDrawConfirmedListener f12012m;
    public OnDrawingClearedListener f12013n;
    private AccessibilityManager f12014o;
    private VelocityTracker f12015p;
    private int f12016q;
    private int f12017r;
    private final Queue<MotionEvent> f12018s;
    private final float f12019t;
    private boolean f12020u;
    private float f12021v;
    private float f12022w;
    private boolean f12023x;
    private final Runnable f12024y;
    private final Runnable f12025z;

    /* compiled from: ZeroIndicatorBase */
    class C11151 implements Runnable {
        final /* synthetic */ DrawingView f11985a;

        C11151(DrawingView drawingView) {
            this.f11985a = drawingView;
        }

        public void run() {
            DrawingView.setDrawingAudioState(this.f11985a, DrawingAudioState.PEN_DOWN_IDLE);
        }
    }

    /* compiled from: ZeroIndicatorBase */
    class C11162 implements Runnable {
        final /* synthetic */ DrawingView f11986a;

        C11162(DrawingView drawingView) {
            this.f11986a = drawingView;
        }

        public void run() {
            DrawingView drawingView = this.f11986a;
        }
    }

    /* compiled from: ZeroIndicatorBase */
    class C11173 implements Runnable {
        final /* synthetic */ DrawingView f11987a;

        C11173(DrawingView drawingView) {
            this.f11987a = drawingView;
        }

        public void run() {
            DrawingView drawingView = this.f11987a;
        }
    }

    /* compiled from: ZeroIndicatorBase */
    /* synthetic */ class C11184 {
        static final /* synthetic */ int[] f11988a = new int[DrawingAudioState.values().length];

        static {
            try {
                f11988a[DrawingAudioState.PEN_DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11988a[DrawingAudioState.PEN_STROKE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11988a[DrawingAudioState.PEN_SCRIBBLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11988a[DrawingAudioState.PEN_DOWN_IDLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11988a[DrawingAudioState.PEN_UP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: ZeroIndicatorBase */
    public class DrawPoint {
        protected static Path f11989c = new Path();
        protected float f11990d;
        protected float f11991e;
        protected float f11992f;
        protected int f11993g;

        public DrawPoint(float f, float f2, float f3, int i) {
            this.f11990d = f;
            this.f11991e = f2;
            this.f11992f = f3;
            this.f11993g = i;
        }

        public void mo1206a(Paint paint, Canvas canvas, View view) {
            f11989c.reset();
            f11989c.moveTo(this.f11990d, this.f11991e);
            f11989c.lineTo(this.f11990d + 0.5f, this.f11991e);
            paint.setColor(this.f11993g);
            paint.setStrokeWidth(this.f11992f);
            canvas.drawPath(f11989c, paint);
            view.invalidate((int) (this.f11990d - this.f11992f), (int) (this.f11991e - this.f11992f), (int) ((this.f11990d + 0.5f) + this.f11992f), (int) (this.f11991e + this.f11992f));
        }
    }

    /* compiled from: ZeroIndicatorBase */
    public class DrawLine extends DrawPoint {
        protected float f11994a;
        protected float f11995b;

        private DrawLine(float f, float f2, float f3, float f4, float f5, int i) {
            super(f, f2, f5, i);
            this.f11994a = f3;
            this.f11995b = f4;
        }

        public void mo1206a(Paint paint, Canvas canvas, View view) {
            DrawPoint.f11989c.reset();
            DrawPoint.f11989c.moveTo(this.f11994a, this.f11995b);
            DrawPoint.f11989c.lineTo(this.f11990d, this.f11991e);
            paint.setColor(this.f11993g);
            paint.setStrokeWidth(this.f11992f);
            canvas.drawPath(DrawPoint.f11989c, paint);
            m19994a(view);
        }

        protected final void m19994a(View view) {
            if (view != null) {
                view.invalidate((int) (Math.min(this.f11994a, this.f11990d) - this.f11992f), (int) (Math.min(this.f11995b, this.f11991e) - this.f11992f), (int) (Math.max(this.f11994a, this.f11990d) + this.f11992f), (int) (Math.max(this.f11995b, this.f11991e) + this.f11992f));
            }
        }
    }

    /* compiled from: ZeroIndicatorBase */
    class DrawQuad extends DrawLine {
        protected float f11996h;
        protected float f11997i;

        private DrawQuad(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
            super(f3, f4, f5, f6, f7, i);
            this.f11996h = f;
            this.f11997i = f2;
        }

        public final void mo1206a(Paint paint, Canvas canvas, View view) {
            DrawPoint.f11989c.reset();
            DrawPoint.f11989c.moveTo(this.f11994a, this.f11995b);
            DrawPoint.f11989c.quadTo(this.f11996h, this.f11997i, this.f11990d, this.f11991e);
            paint.setColor(this.f11993g);
            paint.setStrokeWidth(this.f11992f);
            canvas.drawPath(DrawPoint.f11989c, paint);
            m19994a(view);
        }
    }

    /* compiled from: ZeroIndicatorBase */
    enum DrawingAudioState {
        PEN_DOWN,
        PEN_STROKE,
        PEN_SCRIBBLE,
        PEN_DOWN_IDLE,
        PEN_UP
    }

    /* compiled from: ZeroIndicatorBase */
    public interface DrawingListener {
        void m19996a();

        void m19997b();
    }

    /* compiled from: ZeroIndicatorBase */
    public interface OnDrawConfirmedListener {
    }

    /* compiled from: ZeroIndicatorBase */
    public interface OnDrawingClearedListener {
        void m19998a();
    }

    static /* synthetic */ void m20003a(DrawingView drawingView) {
    }

    static /* synthetic */ void m20006b(DrawingView drawingView) {
    }

    public DrawingView(Context context) {
        this(context, null);
    }

    public DrawingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12004e = new Paint();
        this.f12002b = new LinkedList();
        this.f12018s = Lists.b();
        this.f12019t = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        this.f12024y = new C11151(this);
        this.f12025z = new C11162(this);
        this.f11999A = new C11173(this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DrawingView);
        this.f12010k = obtainStyledAttributes.getDimension(0, 12.0f);
        this.f12011l = obtainStyledAttributes.getColor(1, getResources().getColor(2131362241));
        obtainStyledAttributes.recycle();
        this.f12004e.setAntiAlias(true);
        this.f12004e.setColor(this.f12011l);
        this.f12004e.setStyle(Style.STROKE);
        this.f12004e.setStrokeJoin(Join.ROUND);
        this.f12004e.setStrokeWidth(this.f12010k);
        this.f12004e.setStrokeCap(Cap.ROUND);
        this.f12007h = new Paint(4);
        this.f12007h.setAntiAlias(true);
        this.f12007h.setFilterBitmap(true);
        this.f12014o = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -860786481);
        if (i > 0 && i2 > 0) {
            m20001a(i, i2);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 177898903, a);
    }

    public void setDrawingListener(DrawingListener drawingListener) {
        this.f12003d = drawingListener;
    }

    private void m20001a(int i, int i2) {
        if (this.f12005f != null) {
            this.f12005f.recycle();
        }
        this.f12005f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        this.f12006g = new Canvas(this.f12005f);
        this.f12006g.drawColor(0, Mode.CLEAR);
    }

    private void m19999a(float f, float f2) {
        DrawPoint drawPoint = new DrawPoint(f, f2, this.f12010k, this.f12011l);
        this.f12001a.add(drawPoint);
        drawPoint.mo1206a(this.f12004e, this.f12006g, this);
        this.f12008i = f;
        this.f12009j = f2;
    }

    private void m20005b(float f, float f2) {
        DrawPoint drawLine = new DrawLine(f, f2, this.f12008i, this.f12009j, this.f12010k, this.f12011l);
        this.f12001a.add(drawLine);
        drawLine.mo1206a(this.f12004e, this.f12006g, this);
        this.f12008i = f;
        this.f12009j = f2;
    }

    private void m20000a(float f, float f2, float f3, float f4) {
        DrawQuad drawQuad = new DrawQuad(f, f2, f3, f4, this.f12008i, this.f12009j, this.f12010k, this.f12011l);
        this.f12001a.add(drawQuad);
        drawQuad.mo1206a(this.f12004e, this.f12006g, this);
        this.f12008i = f3;
        this.f12009j = f4;
    }

    public final void m20010a() {
        this.f12002b.clear();
        if (!(this.f12006g == null || this.f12005f == null || this.f12005f.isRecycled())) {
            this.f12006g.drawColor(0, Mode.CLEAR);
            invalidate();
        }
        m20007d();
        m20008e();
    }

    public final void m20011b() {
        if (!(this.f12002b == null || this.f12002b.isEmpty())) {
            this.f12002b.removeLast();
            this.f12006g.drawColor(0, Mode.CLEAR);
            Iterator it = this.f12002b.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((LinkedList) it.next()).iterator();
                while (it2.hasNext()) {
                    ((DrawPoint) it2.next()).mo1206a(this.f12004e, this.f12006g, this);
                }
            }
        }
        if (this.f12002b == null || this.f12002b.isEmpty()) {
            invalidate();
            m20007d();
        }
    }

    private void m20007d() {
        if (this.f12013n != null) {
            this.f12013n.m19998a();
        }
    }

    public void setColour(int i) {
        this.f12004e.setColor(i);
        this.f12011l = i;
    }

    public void setStrokeWidth(float f) {
        this.f12010k = f;
        this.f12004e.setStrokeWidth(this.f12010k);
    }

    protected void onDraw(Canvas canvas) {
        if (!this.f12002b.isEmpty() && this.f12005f != null && !this.f12005f.isRecycled()) {
            canvas.drawBitmap(this.f12005f, 0.0f, 0.0f, this.f12007h);
        }
    }

    @TargetApi(14)
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!this.f12014o.isTouchExplorationEnabled()) {
            return super.onHoverEvent(motionEvent);
        }
        switch (motionEvent.getActionMasked()) {
            case 7:
                motionEvent.setAction(2);
                break;
            case 9:
                motionEvent.setAction(0);
                break;
            case 10:
                motionEvent.setAction(1);
                break;
        }
        return onTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -63071212);
        if (isEnabled()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.f12015p == null) {
                this.f12015p = VelocityTracker.obtain();
            }
            this.f12015p.addMovement(motionEvent);
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.f12020u = false;
                    this.f12021v = x;
                    this.f12022w = y;
                    this.f12001a = Lists.b();
                    this.f12002b.add(this.f12001a);
                    this.f12008i = x;
                    this.f12009j = y;
                    m19999a(x, y);
                    setDrawingAudioState(this, DrawingAudioState.PEN_DOWN);
                    if (this.f12003d != null) {
                        this.f12003d.m19996a();
                        break;
                    }
                    break;
                case 1:
                    setDrawingAudioState(this, DrawingAudioState.PEN_UP);
                    m20005b(x, y);
                    this.f12015p.recycle();
                    this.f12015p = null;
                    if (this.f12003d != null) {
                        this.f12003d.m19997b();
                        break;
                    }
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    m20002a(motionEvent);
                    int historySize = motionEvent.getHistorySize();
                    while (i < historySize) {
                        m20000a(this.f12008i, this.f12009j, (motionEvent.getHistoricalX(i) + this.f12008i) / 2.0f, (motionEvent.getHistoricalY(i) + this.f12009j) / 2.0f);
                        i++;
                    }
                    m20000a(this.f12008i, this.f12009j, (x + this.f12008i) / 2.0f, (y + this.f12009j) / 2.0f);
                    break;
                case 3:
                    this.f12015p.recycle();
                    this.f12015p = null;
                    break;
                default:
                    new StringBuilder("Ignored touch event: ").append(motionEvent.toString());
                    LogUtils.a(-919069401, a);
                    return false;
            }
            LogUtils.a(457279799, a);
            return true;
        }
        Logger.a(2, EntryType.UI_INPUT_END, -2067785347, a);
        return false;
    }

    private void m20002a(MotionEvent motionEvent) {
        DrawingView drawingView;
        boolean z;
        DrawingView drawingView2;
        float xVelocity;
        float yVelocity;
        int i;
        int i2 = 1;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.f12023x) {
            this.f12021v = x;
            this.f12021v = y;
            this.f12023x = false;
            drawingView = this;
        } else {
            if (!this.f12020u) {
                if (Math.sqrt(Math.pow((double) (this.f12021v - x), 2.0d) + Math.pow((double) (y - this.f12022w), 2.0d)) > ((double) this.f12019t)) {
                    z = true;
                    drawingView2 = this;
                    drawingView2.f12020u = z;
                } else {
                    drawingView = this;
                }
            }
            this.f12015p.computeCurrentVelocity(1000);
            xVelocity = this.f12015p.getXVelocity();
            yVelocity = this.f12015p.getYVelocity();
            i = xVelocity <= 0.0f ? 1 : xVelocity >= 0.0f ? -1 : 0;
            if (yVelocity <= 0.0f) {
                i2 = yVelocity >= 0.0f ? -1 : 0;
            }
            if ((this.f12020u && this.f12016q != i && Math.abs(xVelocity) > 100.0f) || (this.f12017r != i2 && Math.abs(yVelocity) > 100.0f)) {
                while (this.f12018s.size() >= 3) {
                    ((MotionEvent) this.f12018s.poll()).recycle();
                }
                this.f12018s.offer(MotionEvent.obtain(motionEvent));
            }
            x = Float.MAX_VALUE;
            if (!this.f12018s.isEmpty()) {
                x = (float) (SystemClock.uptimeMillis() - ((MotionEvent) this.f12018s.peek()).getEventTime());
            }
            if (x >= 375.0f && this.f12018s.size() == 3) {
                setDrawingAudioState(this, DrawingAudioState.PEN_SCRIBBLE);
            } else if (200.0f <= Math.abs(xVelocity) && 200.0f > Math.abs(yVelocity)) {
                removeCallbacks(this.f12024y);
                postDelayed(this.f12024y, 50);
            } else if (this.f12020u) {
                removeCallbacks(this.f12024y);
                setDrawingAudioState(this, DrawingAudioState.PEN_STROKE);
            }
            this.f12016q = i;
            this.f12017r = i2;
        }
        drawingView2 = drawingView;
        z = false;
        drawingView2.f12020u = z;
        this.f12015p.computeCurrentVelocity(1000);
        xVelocity = this.f12015p.getXVelocity();
        yVelocity = this.f12015p.getYVelocity();
        if (xVelocity <= 0.0f) {
            if (xVelocity >= 0.0f) {
            }
        }
        if (yVelocity <= 0.0f) {
            if (yVelocity >= 0.0f) {
            }
        }
        while (this.f12018s.size() >= 3) {
            ((MotionEvent) this.f12018s.poll()).recycle();
        }
        this.f12018s.offer(MotionEvent.obtain(motionEvent));
        x = Float.MAX_VALUE;
        if (this.f12018s.isEmpty()) {
            x = (float) (SystemClock.uptimeMillis() - ((MotionEvent) this.f12018s.peek()).getEventTime());
        }
        if (x >= 375.0f) {
        }
        if (200.0f <= Math.abs(xVelocity)) {
        }
        if (this.f12020u) {
            removeCallbacks(this.f12024y);
            setDrawingAudioState(this, DrawingAudioState.PEN_STROKE);
        }
        this.f12016q = i;
        this.f12017r = i2;
    }

    public int getHistorySize() {
        return this.f12002b.size();
    }

    public final boolean m20012c() {
        return !this.f12002b.isEmpty();
    }

    public final Bitmap m20009a(int i) {
        if (this.f12005f == null || this.f12005f.isRecycled()) {
            return null;
        }
        if (i <= 0) {
            i = 1;
        }
        return Bitmap.createScaledBitmap(this.f12005f, this.f12005f.getWidth() / i, this.f12005f.getHeight() / i, true);
    }

    public void setOnDrawConfirmedListener(OnDrawConfirmedListener onDrawConfirmedListener) {
        this.f12012m = onDrawConfirmedListener;
    }

    public void setOnDrawingClearedListener(OnDrawingClearedListener onDrawingClearedListener) {
        this.f12013n = onDrawingClearedListener;
    }

    public static void setDrawingAudioState(DrawingView drawingView, DrawingAudioState drawingAudioState) {
        if (drawingAudioState != drawingView.f12000B) {
            new StringBuilder("DrawingAudioState: ").append(drawingView.f12000B).append(" -> ").append(drawingAudioState);
            switch (C11184.f11988a[drawingAudioState.ordinal()]) {
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    drawingView.removeCallbacks(drawingView.f12024y);
                    drawingView.removeCallbacks(drawingView.f12025z);
                    drawingView.postDelayed(drawingView.f11999A, 50);
                    break;
                case 3:
                    drawingView.removeCallbacks(drawingView.f12024y);
                    drawingView.removeCallbacks(drawingView.f11999A);
                    drawingView.postDelayed(drawingView.f12025z, 50);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    drawingView.f12020u = false;
                    drawingView.f12023x = true;
                    break;
                case 5:
                    if (drawingView.f12000B != DrawingAudioState.PEN_DOWN) {
                        DrawingAudioState drawingAudioState2 = DrawingAudioState.PEN_DOWN_IDLE;
                    }
                    drawingView.removeCallbacks(drawingView.f12024y);
                    break;
            }
            drawingView.f12000B = drawingAudioState;
        }
    }

    private void m20008e() {
        removeCallbacks(this.f12024y);
        removeCallbacks(this.f11999A);
        removeCallbacks(this.f12025z);
    }
}
