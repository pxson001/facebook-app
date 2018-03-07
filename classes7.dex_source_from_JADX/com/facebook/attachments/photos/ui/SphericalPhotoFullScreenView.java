package com.facebook.attachments.photos.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.common.touch.SphericalDragDetector;
import com.facebook.common.touch.SphericalDragDetector.DragListener;
import com.facebook.common.touch.TouchSlopDetector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.sphericalphoto.SphericalPhotoFragment;
import com.facebook.spherical.photo.SphericalPhotoIndicatorPlugin;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: useRecyclerView */
public class SphericalPhotoFullScreenView extends SphericalPhotoAttachmentView {
    private final int f964k;
    private GestureDetector f965l;
    private Photo360DragListener f966m;
    private SphericalDragDetector f967n;
    private TouchSlopDetector f968o;

    /* compiled from: useRecyclerView */
    class Photo360DragListener implements DragListener {
        final /* synthetic */ SphericalPhotoFullScreenView f962a;

        public Photo360DragListener(SphericalPhotoFullScreenView sphericalPhotoFullScreenView) {
            this.f962a = sphericalPhotoFullScreenView;
        }

        public final void m933a() {
        }

        public final void m935b() {
            this.f962a.f946j.k();
            this.f962a.f946j.i = false;
            this.f962a.f945i.d();
        }

        public final void m934a(float f, float f2) {
            this.f962a.f945i.b(f, f2);
        }

        public final void m936b(float f, float f2) {
            this.f962a.f945i.c(f, f2);
        }
    }

    /* compiled from: useRecyclerView */
    class SingleTapConfirm extends SimpleOnGestureListener {
        final /* synthetic */ SphericalPhotoFullScreenView f963a;

        public SingleTapConfirm(SphericalPhotoFullScreenView sphericalPhotoFullScreenView) {
            this.f963a = sphericalPhotoFullScreenView;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.f963a.f942f != null) {
                SphericalPhotoFragment sphericalPhotoFragment = this.f963a.f942f;
                if (sphericalPhotoFragment.ao != null) {
                    sphericalPhotoFragment.ao.b();
                }
                this.f963a.f946j.n();
            }
            return true;
        }
    }

    public SphericalPhotoFullScreenView(Context context) {
        this(context, null);
    }

    public SphericalPhotoFullScreenView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SphericalPhotoFullScreenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f964k = 130;
        m937a(context);
    }

    private void m937a(Context context) {
        this.f951p = false;
        this.f952q = true;
        m938n();
        this.f966m = new Photo360DragListener(this);
        this.f968o = new TouchSlopDetector(ViewConfiguration.get(context).getScaledTouchSlop());
        this.f967n = new SphericalDragDetector(this.f966m, this.f968o);
        SphericalPhotoIndicatorPlugin sphericalPhotoIndicatorPlugin = this.f946j;
        if (sphericalPhotoIndicatorPlugin.c != null) {
            sphericalPhotoIndicatorPlugin.c.j = 130;
        }
        this.f965l = new GestureDetector(getContext(), new SingleTapConfirm(this));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1112652696);
        if (this.f965l.onTouchEvent(motionEvent)) {
            Logger.a(2, EntryType.UI_INPUT_END, -1723256397, a);
            return true;
        }
        boolean a2 = this.f967n.a(motionEvent);
        LogUtils.a(368656162, a);
        return a2;
    }

    private void m938n() {
        this.f945i.b = false;
    }

    public final void m939a(boolean z) {
        this.f946j.g();
        if (z) {
            this.f946j.b.setVisibility(8);
        } else {
            this.f946j.b.setVisibility(0);
        }
        this.f946j.c();
    }
}
