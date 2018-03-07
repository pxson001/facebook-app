package com.facebook.photos.tagging.ui;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.taggablegallery.TaggablePhotoGalleryFragment.10;
import com.facebook.photos.tagging.ui.TaggablePhotoView.C09502;
import com.facebook.photos.tagging.ui.TagsView.C09591;
import com.facebook.widget.images.zoomableimageview.ZoomableImageView;
import com.google.common.base.Preconditions;

/* compiled from: instagram_url */
public class ZoomableFriendlyOnTouchListener implements OnTouchListener {
    private GestureDetector f11021a;
    public ZoomableImageView f11022b;
    public C09591 f11023c;
    public boolean f11024d = true;
    public boolean f11025e = true;

    /* compiled from: instagram_url */
    class ZoomableFriendlyOnGestureListener implements OnGestureListener {
        final /* synthetic */ ZoomableFriendlyOnTouchListener f11020a;

        public ZoomableFriendlyOnGestureListener(ZoomableFriendlyOnTouchListener zoomableFriendlyOnTouchListener) {
            this.f11020a = zoomableFriendlyOnTouchListener;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (!this.f11020a.f11024d) {
                return false;
            }
            this.f11020a.f11022b.a(motionEvent);
            C09591 c09591 = this.f11020a.f11023c;
            c09591.f11006a.bringToFront();
            if (c09591.f11008c.isEnabled()) {
                if (c09591.f11006a.m12955a()) {
                    if (!c09591.f11006a.f10943n) {
                        c09591.f11008c.m13006a();
                        c09591.f11006a.m12954a(true);
                        c09591.f11008c.f11017f = c09591.f11006a;
                    } else if (motionEvent.getX() > ((float) c09591.f11006a.getWidth()) - c09591.f11008c.f11013b) {
                        c09591.f11008c.m13007a(c09591.f11007b);
                        c09591.f11008c.f11018g.m12958b(c09591.f11007b);
                    } else {
                        c09591.f11006a.m12956e();
                        c09591.f11008c.f11017f = null;
                    }
                } else if (c09591.f11008c.f11018g != null) {
                    c09591.f11008c.m13006a();
                    C09502 c09502 = c09591.f11008c.f11018g;
                    Tag tag = c09591.f11007b;
                    if (c09502.f10955a.f10964g != null) {
                        Preconditions.checkState(((Tag) c09502.f10955a.f10976s.a(tag)) != null);
                        10 10 = c09502.f10955a.f10964g;
                    }
                }
            }
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (this.f11020a.f11025e) {
                this.f11020a.f11022b.a(motionEvent);
            }
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }
    }

    public ZoomableFriendlyOnTouchListener(Context context, ZoomableImageView zoomableImageView, C09591 c09591) {
        this.f11021a = new GestureDetector(context, new ZoomableFriendlyOnGestureListener(this), null, true);
        this.f11022b = zoomableImageView;
        this.f11023c = c09591;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = view.getX();
        float y = view.getY();
        this.f11021a.onTouchEvent(motionEvent);
        motionEvent.offsetLocation(x, y);
        this.f11022b.onTouchEvent(motionEvent);
        return true;
    }
}
