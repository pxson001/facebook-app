package com.facebook.widget.listview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.facebook.R;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;

/* compiled from: relative */
public abstract class DragSortListView extends BetterListView {
    private ScrollHandler f6006A;
    private final AbstractFbErrorReporter f6007B;
    public final MonotonicClock f6008C;
    public int f6009a;
    protected int f6010b;
    protected int f6011c;
    private ImageView f6012d;
    public LinearLayout f6013e;
    public WindowManager f6014f;
    public LayoutParams f6015g;
    private int f6016h;
    public int f6017i;
    public int f6018j;
    public int f6019k;
    private DragListener f6020l;
    public DropListener f6021m;
    public int f6022n;
    public int f6023o;
    public int f6024p;
    private GestureDetector f6025q;
    public Rect f6026r;
    private Bitmap f6027s;
    private final int f6028t;
    private int f6029u;
    public int f6030v;
    public int f6031w;
    private Drawable f6032x;
    private Drawable f6033y;
    private long f6034z;

    /* compiled from: relative */
    public interface DragListener {
    }

    /* compiled from: relative */
    public interface DragSortListAdapter {
        int mo1289b();

        int mo1290c();
    }

    /* compiled from: relative */
    public interface DropListener {
        void mo1288a(int i, int i2);
    }

    /* compiled from: relative */
    public class ScrollHandler {
        public final /* synthetic */ DragSortListView f6001a;
        public long f6002b;
        public boolean f6003c;
        public float f6004d;
        private Runnable f6005e = new C03551(this);

        /* compiled from: relative */
        class C03551 implements Runnable {
            final /* synthetic */ ScrollHandler f6000a;

            C03551(ScrollHandler scrollHandler) {
                this.f6000a = scrollHandler;
            }

            public void run() {
                if (this.f6000a.f6004d != 0.0f) {
                    ViewCompat.a(this.f6000a.f6001a, this);
                    long now = this.f6000a.f6001a.f6008C.now();
                    int i = (int) (((float) ((now - this.f6000a.f6002b) / 10)) * this.f6000a.f6004d);
                    this.f6000a.f6002b = now;
                    int pointToPosition = this.f6000a.f6001a.pointToPosition(0, this.f6000a.f6001a.f6024p / 2);
                    if (pointToPosition == -1) {
                        pointToPosition = this.f6000a.f6001a.pointToPosition(0, ((this.f6000a.f6001a.f6024p / 2) + this.f6000a.f6001a.getDividerHeight()) + 64);
                    }
                    View childAt = this.f6000a.f6001a.getChildAt(pointToPosition - this.f6000a.f6001a.getFirstVisiblePosition());
                    if (childAt != null) {
                        this.f6000a.f6001a.setSelectionFromTop(pointToPosition, childAt.getTop() - i);
                        DragSortListView.m8591h(this.f6000a.f6001a);
                        return;
                    }
                    return;
                }
                this.f6000a.f6003c = false;
            }
        }

        public ScrollHandler(DragSortListView dragSortListView) {
            this.f6001a = dragSortListView;
        }

        public final void m8588a(int i) {
            int i2;
            if (i > this.f6001a.f6023o && this.f6001a.getLastVisiblePosition() < DragSortListView.getDragSortListAdapter(this.f6001a).mo1290c() + 2) {
                i2 = (this.f6001a.f6024p + this.f6001a.f6023o) / 2;
                if (i > i2) {
                    float f = (float) ((i - i2) / (this.f6001a.f6024p - i2));
                    i2 = (int) ((f * ((float) (this.f6001a.f6031w - this.f6001a.f6030v))) + ((float) this.f6001a.f6030v));
                } else {
                    i2 = this.f6001a.f6030v;
                }
            } else if (i >= this.f6001a.f6022n || this.f6001a.getFirstVisiblePosition() <= DragSortListView.getDragSortListAdapter(this.f6001a).mo1289b() - 2) {
                i2 = 0;
            } else if (i < this.f6001a.f6022n / 2) {
                i2 = this.f6001a.f6022n / 2;
                float f2 = (float) this.f6001a.f6030v;
                i2 = -((int) ((((float) ((i2 - i) / i2)) * ((float) (this.f6001a.f6031w - this.f6001a.f6030v))) + f2));
            } else {
                i2 = -this.f6001a.f6030v;
            }
            this.f6004d = (float) i2;
            if (!this.f6003c && this.f6004d != 0.0f) {
                this.f6003c = true;
                this.f6002b = this.f6001a.f6008C.now();
                ViewCompat.a(this.f6001a, this.f6005e);
            }
        }
    }

    public abstract void mo1291a(View view);

    protected abstract void mo1292a(View view, int i, int i2, int i3);

    protected abstract boolean mo1293b(View view);

    public DragSortListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DragSortListView(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        super(context, attributeSet, i);
        this.f6026r = new Rect();
        this.f6009a = -1;
        this.f6010b = -1;
        this.f6011c = -1;
        this.f6029u = -1;
        this.f6032x = null;
        this.f6033y = null;
        this.f6028t = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f6006A = new ScrollHandler(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DragSortListView, 0, 0);
            this.f6009a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.f6010b = (this.f6009a * 2) - 1;
            this.f6011c = obtainStyledAttributes.getResourceId(1, -1);
            this.f6029u = obtainStyledAttributes.getResourceId(2, -1);
            this.f6032x = obtainStyledAttributes.getDrawable(4);
            this.f6033y = obtainStyledAttributes.getDrawable(3);
            this.f6031w = (int) getResources().getDimension(2131428328);
            this.f6030v = (int) getResources().getDimension(2131428329);
            obtainStyledAttributes.recycle();
        }
        Preconditions.checkArgument(this.f6009a > 0, "Item height must be > 0");
        if (this.f6011c <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Grabber id must be valid");
        FbInjector fbInjector = FbInjector.get(context);
        this.f6008C = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector);
        this.f6007B = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
    }

    public void setDragListener(DragListener dragListener) {
        this.f6020l = dragListener;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter == null || (listAdapter instanceof DragSortListAdapter)) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new RuntimeException("DragSortListView expects a DragSortListAdapter based adapter");
    }

    public final void addHeaderView(View view, Object obj, boolean z) {
        throw new RuntimeException("Headers are not supported with DragSortListView");
    }

    public final void addHeaderView(View view) {
        throw new RuntimeException("Headers are not supported with DragSortListView");
    }

    public final void addFooterView(View view, Object obj, boolean z) {
        throw new RuntimeException("Footers are not supported with DragSortListView in conjunction with remove_mode");
    }

    public final void addFooterView(View view) {
        throw new RuntimeException("Footers are not supported with DragSortListView in conjunction with remove_mode");
    }

    public static DragSortListAdapter getDragSortListAdapter(DragSortListView dragSortListView) {
        return (DragSortListAdapter) dragSortListView.getAdapter();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!(this.f6020l == null && this.f6021m == null)) {
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int pointToPosition = pointToPosition(x, y);
                    if (pointToPosition != -1) {
                        View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                        if (mo1293b(childAt)) {
                            this.f6018j = y - childAt.getTop();
                            this.f6019k = ((int) motionEvent.getRawY()) - y;
                            View findViewById = childAt.findViewById(this.f6011c);
                            Rect rect = this.f6026r;
                            rect.left = findViewById.getLeft();
                            rect.right = findViewById.getRight();
                            rect.top = findViewById.getTop();
                            rect.bottom = findViewById.getBottom();
                            if (rect.left > x || x > rect.right) {
                                this.f6013e = null;
                                break;
                            }
                            findViewById = childAt.findViewById(this.f6029u);
                            x = findViewById != null ? findViewById.getVisibility() : 4;
                            if (x == 0) {
                                findViewById.setVisibility(4);
                            }
                            boolean isDrawingCacheEnabled = childAt.isDrawingCacheEnabled();
                            boolean willNotCacheDrawing = childAt.willNotCacheDrawing();
                            childAt.setDrawingCacheEnabled(true);
                            childAt.setWillNotCacheDrawing(false);
                            try {
                                if (childAt.getDrawingCache() == null) {
                                    this.f6007B.a("bookmark", "The drawing cache is null while dragging the item in the list! " + childAt);
                                    break;
                                }
                                Bitmap createBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                                childAt.setDrawingCacheEnabled(isDrawingCacheEnabled);
                                childAt.setWillNotCacheDrawing(willNotCacheDrawing);
                                if (x == 0) {
                                    findViewById.setVisibility(0);
                                }
                                Rect rect2 = new Rect();
                                getGlobalVisibleRect(rect2, null);
                                m8589a(createBitmap, rect2.left, y);
                                this.f6016h = pointToPosition;
                                this.f6017i = this.f6016h;
                                this.f6024p = getHeight();
                                x = this.f6028t;
                                this.f6022n = Math.min(y - x, this.f6024p / 3);
                                this.f6023o = Math.max(x + y, (this.f6024p * 2) / 3);
                                return false;
                            } finally {
                                childAt.setDrawingCacheEnabled(isDrawingCacheEnabled);
                                childAt.setWillNotCacheDrawing(willNotCacheDrawing);
                            }
                        }
                    }
                    break;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public static void m8591h(DragSortListView dragSortListView) {
        if (dragSortListView.f6008C.now() - dragSortListView.f6034z >= 25) {
            int i;
            int b = getDragSortListAdapter(dragSortListView).mo1289b();
            int c = getDragSortListAdapter(dragSortListView).mo1290c();
            int boundedDragPosition = dragSortListView.getBoundedDragPosition() - dragSortListView.getFirstVisiblePosition();
            if (dragSortListView.f6016h >= dragSortListView.f6017i && dragSortListView.f6016h < c) {
                boundedDragPosition++;
            }
            int lastVisiblePosition = (dragSortListView.getLastVisiblePosition() - dragSortListView.getFirstVisiblePosition()) + 1;
            int firstVisiblePosition = dragSortListView.f6017i - dragSortListView.getFirstVisiblePosition();
            if (dragSortListView.f6017i == c && dragSortListView.f6016h >= c) {
                i = boundedDragPosition - 1;
            } else if (dragSortListView.f6017i != b || dragSortListView.f6016h >= b) {
                i = boundedDragPosition;
            } else {
                i = boundedDragPosition + 1;
            }
            if (b == c) {
                dragSortListView.mo1292a(dragSortListView.getChildAt(firstVisiblePosition), dragSortListView.f6009a, 80, 4);
                return;
            }
            for (int i2 = 0; i2 < lastVisiblePosition; i2++) {
                View childAt = dragSortListView.getChildAt(i2);
                if (childAt == null) {
                    break;
                }
                int i3;
                boundedDragPosition = dragSortListView.f6009a;
                if (i2 == firstVisiblePosition) {
                    b = 4;
                    i3 = 1;
                    boundedDragPosition = 80;
                } else if (i2 == i) {
                    b = dragSortListView.f6010b;
                    if (dragSortListView.f6016h >= c) {
                        boundedDragPosition = 48;
                        i3 = b;
                        b = 0;
                    } else {
                        boundedDragPosition = 80;
                        i3 = b;
                        b = 0;
                    }
                } else {
                    b = 0;
                    i3 = boundedDragPosition;
                    boundedDragPosition = 80;
                }
                dragSortListView.mo1292a(childAt, i3, boundedDragPosition, b);
            }
            dragSortListView.layoutChildren();
        }
    }

    protected static void m8590a(View view, int i, int i2) {
        if (i != -1) {
            View findViewById = view.findViewById(i);
            if (findViewById != null) {
                findViewById.setVisibility(i2);
            }
        }
    }

    private int getBoundedDragPosition() {
        int b = getDragSortListAdapter(this).mo1289b();
        int c = getDragSortListAdapter(this).mo1290c();
        int i = this.f6016h;
        if (i > c) {
            return c;
        }
        if (i < b) {
            return b;
        }
        return i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 443973242);
        if (this.f6025q != null) {
            this.f6025q.onTouchEvent(motionEvent);
        }
        if ((this.f6020l == null && this.f6021m == null) || this.f6013e == null) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(-265918133, a);
            return onTouchEvent;
        }
        int i;
        int i2;
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                int childCount;
                int i3;
                motionEvent.getX();
                int y = (int) motionEvent.getY();
                this.f6015g.y = (y - this.f6018j) + this.f6019k;
                this.f6014f.updateViewLayout(this.f6013e, this.f6015g);
                i = (y - this.f6018j) - (this.f6009a / 2);
                Rect rect = this.f6026r;
                for (childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    getChildAt(childCount).getHitRect(rect);
                    if (rect.contains(0, i)) {
                        childCount += getFirstVisiblePosition();
                        i2 = childCount;
                        if (i2 < 0) {
                            if (i2 <= this.f6017i) {
                                i2++;
                            }
                        } else if (i < 0) {
                            i2 = 0;
                        }
                        i3 = i2;
                        if (i3 >= 0) {
                            this.f6016h = i3;
                            m8591h(this);
                            if (y >= this.f6024p / 3) {
                                this.f6022n = this.f6024p / 3;
                            }
                            if (y <= (this.f6024p * 2) / 3) {
                                this.f6023o = (this.f6024p * 2) / 3;
                            }
                            this.f6006A.m8588a(y);
                            break;
                        }
                    }
                }
                childCount = -1;
                i2 = childCount;
                if (i2 < 0) {
                    if (i < 0) {
                        i2 = 0;
                    }
                } else if (i2 <= this.f6017i) {
                    i2++;
                }
                i3 = i2;
                if (i3 >= 0) {
                    this.f6016h = i3;
                    m8591h(this);
                    if (y >= this.f6024p / 3) {
                        this.f6022n = this.f6024p / 3;
                    }
                    if (y <= (this.f6024p * 2) / 3) {
                        this.f6023o = (this.f6024p * 2) / 3;
                    }
                    this.f6006A.m8588a(y);
                }
                break;
            case 1:
            case 3:
                this.f6013e.getDrawingRect(this.f6026r);
                this.f6006A.f6004d = 0.0f;
                i2 = 0;
                while (true) {
                    if (getChildAt(i2) == null) {
                        layoutChildren();
                        if (getChildAt(i2) == null) {
                            for (i = 0; i < getChildCount(); i++) {
                                mo1291a(getChildAt(i));
                            }
                            m8592j();
                            if (!(this.f6021m == null || this.f6016h == this.f6017i)) {
                                this.f6021m.mo1288a(this.f6017i, getBoundedDragPosition());
                                break;
                            }
                        }
                    }
                    i2++;
                }
        }
        LogUtils.a(142638250, a);
        return true;
    }

    private void m8589a(Bitmap bitmap, int i, int i2) {
        m8592j();
        this.f6034z = this.f6008C.now();
        this.f6015g = new LayoutParams();
        this.f6015g.gravity = 51;
        this.f6015g.x = i;
        this.f6015g.y = (i2 - this.f6018j) + this.f6019k;
        if (ContextUtils.a(getContext(), Activity.class) == null) {
            this.f6015g.type = VERSION.SDK_INT < 11 ? 2002 : 2007;
        }
        this.f6015g.height = -2;
        this.f6015g.width = -2;
        this.f6015g.flags = 408;
        this.f6015g.format = -3;
        this.f6015g.windowAnimations = 0;
        this.f6012d = new ImageView(getContext());
        if (this.f6032x != null) {
            this.f6012d.setBackgroundDrawable(this.f6032x);
        }
        this.f6012d.setImageBitmap(bitmap);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.addView(this.f6012d);
        if (this.f6033y != null) {
            linearLayout.setBackgroundDrawable(this.f6033y);
        }
        this.f6027s = bitmap;
        this.f6014f = WindowManagerMethodAutoProvider.b(FbInjector.get(getContext()));
        this.f6014f.addView(linearLayout, this.f6015g);
        this.f6013e = linearLayout;
    }

    private void m8592j() {
        if (this.f6013e != null) {
            WindowManagerMethodAutoProvider.b(FbInjector.get(getContext())).removeView(this.f6013e);
            this.f6012d.setImageDrawable(null);
            this.f6012d = null;
            this.f6013e = null;
        }
        if (this.f6027s != null) {
            this.f6027s.recycle();
            this.f6027s = null;
        }
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1750961268);
        super.onDetachedFromWindow();
        m8592j();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1023700754, a);
    }
}
