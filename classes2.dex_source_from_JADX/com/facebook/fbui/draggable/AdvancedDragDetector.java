package com.facebook.fbui.draggable;

import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import javax.inject.Inject;

/* compiled from: photo_type */
public class AdvancedDragDetector {
    private static final Class<?> f9972a = AdvancedDragDetector.class;
    public boolean f9973b;
    private Context f9974c;
    public int f9975d;
    public int f9976e;
    public int f9977f;
    public int f9978g;
    public Axis f9979h = Axis.VERTICAL;
    private float f9980i = -1.0f;
    private float f9981j = -1.0f;
    private float f9982k = 0.0f;
    private float f9983l = 0.0f;
    private Direction f9984m = null;
    private DragStatus f9985n = DragStatus.AT_REST;
    private VelocityTracker f9986o = null;
    public int f9987p = 0;
    public DragDecider f9988q = null;
    public DragListener f9989r = null;
    public TapListener f9990s = null;
    public boolean f9991t;

    /* compiled from: photo_type */
    enum DragStatus {
        AT_REST,
        DECIDING,
        DRAGGING,
        CANCELED
    }

    public static AdvancedDragDetector m15012b(InjectorLike injectorLike) {
        return new AdvancedDragDetector((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public AdvancedDragDetector(Context context) {
        this.f9974c = context;
    }

    public final void m15025a(Direction... directionArr) {
        this.f9987p = 0;
        for (int i = 0; i < directionArr.length; i++) {
            if (directionArr[i] != null) {
                this.f9987p |= directionArr[i].flag();
            }
        }
    }

    private boolean m15013d() {
        return Direction.UP.isSetInFlags(this.f9987p);
    }

    private boolean m15014e() {
        return Direction.DOWN.isSetInFlags(this.f9987p);
    }

    private boolean m15015g() {
        return Direction.RIGHT.isSetInFlags(this.f9987p);
    }

    private boolean m15016h() {
        return this.f9987p > 0;
    }

    public final boolean m15027b() {
        return this.f9985n == DragStatus.DRAGGING;
    }

    private boolean m15017i() {
        return this.f9985n == DragStatus.CANCELED;
    }

    public final boolean m15026a(MotionEvent motionEvent) {
        if (this.f9989r == null || !m15016h()) {
            return false;
        }
        int action = motionEvent.getAction();
        float rawX = this.f9991t ? motionEvent.getRawX() : motionEvent.getX();
        float rawY = this.f9991t ? motionEvent.getRawY() : motionEvent.getY();
        switch (action) {
            case 0:
                boolean a;
                this.f9985n = DragStatus.DECIDING;
                this.f9982k = 0.0f;
                this.f9983l = 0.0f;
                if (this.f9988q != null) {
                    a = this.f9988q.a(rawX, rawY);
                } else {
                    a = true;
                }
                if (a) {
                    this.f9980i = rawX;
                    this.f9981j = rawY;
                    if (this.f9988q != null) {
                        a = this.f9988q.b(rawX, rawY);
                    } else {
                        a = false;
                    }
                    if (a) {
                        m15010a(rawX, rawY, m15019k());
                        break;
                    }
                }
                m15029c();
                return false;
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case 3:
                if (!(this.f9990s == null || m15017i() || m15027b() || !m15018j())) {
                    boolean c = this.f9990s.c(rawX, rawY);
                    if (c) {
                        return c;
                    }
                    m15029c();
                    return c;
                }
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m15009a(rawX, rawY);
                break;
        }
        return m15027b();
    }

    public final boolean m15028b(MotionEvent motionEvent) {
        if (!m15027b()) {
            m15026a(motionEvent);
            switch (1.a[this.f9985n.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    return false;
                default:
                    return true;
            }
        } else if (this.f9989r == null || !m15016h()) {
            return false;
        } else {
            if (this.f9986o == null) {
                this.f9986o = VelocityTracker.obtain();
            }
            this.f9986o.addMovement(motionEvent);
            int action = motionEvent.getAction();
            float rawX = this.f9991t ? motionEvent.getRawX() : motionEvent.getX();
            float rawY = this.f9991t ? motionEvent.getRawY() : motionEvent.getY();
            switch (action) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                case 3:
                    int xVelocity;
                    VelocityTracker velocityTracker = this.f9986o;
                    this.f9986o = null;
                    velocityTracker.computeCurrentVelocity(1000, (float) m15023o());
                    if (this.f9984m.isXAxis()) {
                        xVelocity = (int) velocityTracker.getXVelocity();
                    } else {
                        xVelocity = (int) velocityTracker.getYVelocity();
                    }
                    if (Math.abs(xVelocity) > m15022n()) {
                        if (xVelocity < 0) {
                            Direction direction;
                            DragListener dragListener = this.f9989r;
                            if (this.f9984m.isXAxis()) {
                                direction = Direction.LEFT;
                            } else {
                                direction = Direction.UP;
                            }
                            dragListener.a(direction, xVelocity);
                        } else if (xVelocity > 0) {
                            this.f9989r.a(this.f9984m.isXAxis() ? Direction.RIGHT : Direction.DOWN, xVelocity);
                        }
                    } else if (this.f9990s == null || !m15018j()) {
                        this.f9989r.a();
                    } else {
                        this.f9990s.d(rawX, rawY);
                    }
                    this.f9985n = DragStatus.AT_REST;
                    velocityTracker.recycle();
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    float f = rawX - this.f9980i;
                    float f2 = rawY - this.f9981j;
                    this.f9980i = rawX;
                    this.f9981j = rawY;
                    this.f9982k += f;
                    this.f9983l += f2;
                    if (!this.f9984m.isYAxis()) {
                        this.f9989r.b(f, f2, f < 0.0f ? Direction.LEFT : Direction.RIGHT);
                        break;
                    }
                    this.f9989r.b(f, f2, f2 < 0.0f ? Direction.UP : Direction.DOWN);
                    break;
            }
            return true;
        }
    }

    private boolean m15018j() {
        int m = m15021m();
        return Math.abs(this.f9982k) < ((float) m) && Math.abs(this.f9983l) < ((float) m);
    }

    private void m15010a(float f, float f2, Direction direction) {
        this.f9980i = f;
        this.f9981j = f2;
        this.f9984m = direction;
        DragStatus dragStatus = this.f9985n;
        this.f9985n = DragStatus.DRAGGING;
        if (dragStatus != DragStatus.DRAGGING && !this.f9989r.a(f, f2, direction)) {
            this.f9985n = dragStatus;
            m15029c();
        }
    }

    public final void m15029c() {
        if (m15027b()) {
            this.f9989r.b();
        }
        this.f9980i = -1.0f;
        this.f9981j = -1.0f;
        this.f9985n = DragStatus.CANCELED;
        VelocityTracker velocityTracker = this.f9986o;
        this.f9986o = null;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
    }

    private Direction m15019k() {
        if (this.f9984m != null) {
            return this.f9984m;
        }
        if (m15015g()) {
            return Direction.RIGHT;
        }
        if (m15014e()) {
            return Direction.DOWN;
        }
        if (m15013d()) {
            return Direction.UP;
        }
        return Direction.LEFT;
    }

    private void m15009a(float f, float f2) {
        if (!m15017i() && !m15027b()) {
            int l = m15020l();
            int m = m15021m();
            int i = (int) (f - this.f9980i);
            int i2 = (int) (f2 - this.f9981j);
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            this.f9982k += (float) i;
            this.f9983l += (float) i2;
            if (abs2 <= m || (this.f9979h != Axis.VERTICAL && ((float) abs2) * 0.5f <= ((float) abs))) {
                if (abs <= l) {
                    return;
                }
                if (this.f9979h != Axis.HORIZONTAL && ((float) abs) * 0.5f <= ((float) abs2)) {
                    return;
                }
                if (i < 0 && Direction.LEFT.isSetInFlags(this.f9987p)) {
                    m15010a(f, f2, Direction.LEFT);
                } else if (i <= 0 || !m15015g()) {
                    m15029c();
                } else {
                    m15010a(f, f2, Direction.RIGHT);
                }
            } else if (i2 < 0 && m15013d()) {
                m15010a(f, f2, Direction.UP);
            } else if (i2 <= 0 || !m15014e()) {
                m15029c();
            } else {
                m15010a(f, f2, Direction.DOWN);
            }
        }
    }

    private int m15020l() {
        m15024p();
        return this.f9975d;
    }

    private int m15021m() {
        m15024p();
        return this.f9976e;
    }

    private int m15022n() {
        m15024p();
        return this.f9977f;
    }

    private int m15023o() {
        m15024p();
        return this.f9978g;
    }

    private void m15024p() {
        if (!this.f9973b) {
            m15011a(this.f9974c);
            this.f9973b = true;
            this.f9974c = null;
        }
    }

    private void m15011a(Context context) {
        if (context == null) {
            throw new IllegalStateException("Init Context must not be null");
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int a = ViewConfigurationCompat.m10827a(viewConfiguration);
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        int scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        int scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f9975d = a;
        this.f9976e = scaledTouchSlop;
        this.f9977f = scaledMinimumFlingVelocity;
        this.f9978g = scaledMaximumFlingVelocity;
        this.f9973b = true;
    }
}
