package com.facebook.video.creativeediting.trimmer;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.video.creativeediting.VideoTrimmingController.C11825;
import com.facebook.video.creativeediting.trimmer.StripHandleController.HandlePosition;
import com.facebook.video.creativeediting.trimmer.StripSlidingController.SlidingDirection;
import com.facebook.video.creativeediting.ui.fresco.ZoomableDraweeStripView;
import com.facebook.video.creativeediting.utilities.StripViewVideoTimeConverter;
import com.facebook.video.creativeediting.utilities.TrimmedVideoLengthChecker;

/* compiled from: drawing */
public class StripHandleTouchListener implements OnTouchListener {
    private final StripHandleController f15545a;
    private final StripZoomingController f15546b;
    private final StripSlidingController f15547c;
    private final StripViewVideoTimeConverter f15548d;
    private final StripScrubberController f15549e;
    private final TrimmedVideoLengthChecker f15550f;
    private final int f15551g;
    public final int f15552h;
    public final int f15553i;
    public final ZoomableDraweeStripView f15554j;
    public final View f15555k;
    public final View f15556l;
    private final HandlePosition f15557m;
    private final C11825 f15558n;
    private boolean f15559o = false;
    private int f15560p;

    public StripHandleTouchListener(StripHandleController stripHandleController, StripZoomingController stripZoomingController, StripSlidingController stripSlidingController, StripViewVideoTimeConverter stripViewVideoTimeConverter, StripScrubberController stripScrubberController, TrimmedVideoLengthChecker trimmedVideoLengthChecker, int i, int i2, int i3, ZoomableDraweeStripView zoomableDraweeStripView, View view, View view2, HandlePosition handlePosition, C11825 c11825) {
        this.f15545a = stripHandleController;
        this.f15546b = stripZoomingController;
        this.f15547c = stripSlidingController;
        this.f15548d = stripViewVideoTimeConverter;
        this.f15549e = stripScrubberController;
        this.f15550f = trimmedVideoLengthChecker;
        this.f15551g = i;
        this.f15552h = i2;
        this.f15553i = i3;
        this.f15554j = zoomableDraweeStripView;
        this.f15555k = view;
        this.f15556l = view2;
        this.f15557m = handlePosition;
        this.f15558n = c11825;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f15546b.m19570a(this.f15557m);
                this.f15560p = rawX;
                break;
            case 1:
                if (this.f15547c.f15581h) {
                    this.f15547c.m19567b();
                    this.f15547c.f15581h = false;
                }
                if (this.f15546b.f15592h) {
                    this.f15546b.m19569a(this.f15545a.m19554a(this.f15557m), this.f15557m);
                }
                this.f15546b.m19571b();
                this.f15558n.m19515a(this.f15559o);
                this.f15549e.m19564d();
                this.f15559o = false;
                break;
            case 2:
                Object obj;
                if (rawX <= this.f15551g) {
                    obj = 1;
                } else {
                    obj = null;
                }
                Object obj2 = obj;
                if (rawX >= this.f15554j.getZoomedOutWidth() - this.f15551g) {
                    obj = 1;
                } else {
                    obj = null;
                }
                Object obj3 = obj;
                this.f15559o = true;
                if (this.f15547c.f15581h && obj2 == null && obj3 == null) {
                    this.f15547c.m19567b();
                    this.f15547c.f15581h = false;
                }
                if (!this.f15546b.f15592h) {
                    this.f15546b.m19570a(this.f15557m);
                } else if (!this.f15547c.f15581h) {
                    if (obj2 != null) {
                        this.f15547c.m19566a(SlidingDirection.LEFT, this.f15557m);
                    } else if (obj3 != null) {
                        this.f15547c.m19566a(SlidingDirection.RIGHT, this.f15557m);
                    }
                }
                int i = rawX - this.f15560p;
                if (this.f15557m == HandlePosition.LEFT) {
                    if (rawX >= (this.f15556l.getLeft() - this.f15553i) - this.f15552h) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null && m19560a(this.f15555k.getLeft(), this.f15555k.getRight(), i) && this.f15550f.m19607a(this.f15548d.m19605a(this.f15546b.f15592h, this.f15545a.m19553a() + i, this.f15545a.m19557b()))) {
                        this.f15558n.m19514a(i);
                        this.f15560p = rawX;
                        this.f15549e.m19563c();
                        break;
                    }
                }
                if (this.f15557m == HandlePosition.RIGHT) {
                    if (rawX <= (this.f15555k.getRight() + this.f15553i) + this.f15552h) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null && m19560a(this.f15556l.getLeft(), this.f15556l.getRight(), i) && this.f15550f.m19607a(this.f15548d.m19605a(this.f15546b.f15592h, this.f15545a.m19553a(), this.f15545a.m19557b() + i))) {
                        this.f15558n.m19514a(i);
                        this.f15560p = rawX;
                    }
                }
                this.f15549e.m19563c();
        }
        return true;
    }

    private boolean m19560a(int i, int i2, int i3) {
        return i + i3 >= 0 && i2 + i3 <= this.f15554j.getZoomedOutWidth();
    }
}
