package com.facebook.facecast.plugin.creativetools;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.facecast.FacecastPreviewView;
import com.facebook.facecast.PreviewRenderer;
import com.facebook.facecast.plugin.FacecastAnalyticsLogger;
import com.facebook.facecast.plugin.creativetools.CreativeToolsBasicAdjustmentFilterView.CreativeToolsBasicAdjustmentFilterViewListener;
import com.facebook.inject.Assisted;
import com.facebook.videocodec.effects.renderers.ColorFilter;
import com.facebook.widget.CustomHorizontalScrollView;
import com.facebook.widget.CustomHorizontalScrollView.OnScrollListener;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bio_add_prompt_suggested_click */
public class CreativeToolsBasicAdjustmentFilterTrayController implements CreativeToolsBasicAdjustmentFilterViewListener, CreativeToolsTrayController, OnScrollListener {
    public final FacecastAnalyticsLogger f18649a;
    private final PreviewRenderer f18650b;
    private final CustomHorizontalScrollView f18651c;
    private final LinearLayout f18652d = ((LinearLayout) this.f18651c.findViewById(2131561620));
    private final List<CreativeToolsBasicAdjustmentFilterView> f18653e = new ArrayList();
    private final OnTouchListener f18654f;
    @Nullable
    public CreativeToolsBasicAdjustmentPack f18655g;
    public int f18656h;
    public boolean f18657i;

    /* compiled from: bio_add_prompt_suggested_click */
    class C16112 implements OnLayoutChangeListener {
        final /* synthetic */ CreativeToolsBasicAdjustmentFilterTrayController f18647a;

        C16112(CreativeToolsBasicAdjustmentFilterTrayController creativeToolsBasicAdjustmentFilterTrayController) {
            this.f18647a = creativeToolsBasicAdjustmentFilterTrayController;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f18647a.f18657i) {
                CreativeToolsBasicAdjustmentFilterTrayController.m22239f(this.f18647a);
            }
        }
    }

    /* compiled from: bio_add_prompt_suggested_click */
    class FlingListener extends SimpleOnGestureListener {
        final /* synthetic */ CreativeToolsBasicAdjustmentFilterTrayController f18648a;

        public FlingListener(CreativeToolsBasicAdjustmentFilterTrayController creativeToolsBasicAdjustmentFilterTrayController) {
            this.f18648a = creativeToolsBasicAdjustmentFilterTrayController;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            boolean z = false;
            if (Math.abs(f2) > Math.abs(f)) {
                return false;
            }
            int i;
            String str;
            if (f > 0.0f) {
                int i2 = this.f18648a.f18656h - 1;
                if (i2 < 0) {
                    i2 = this.f18648a.f18655g.m22260e() - 1;
                }
                i = i2;
                str = "swipe_right";
            } else {
                boolean z2 = this.f18648a.f18656h + 1;
                if (z2 < this.f18648a.f18655g.m22260e()) {
                    z = z2;
                }
                z2 = z;
                str = "swipe_left";
            }
            CreativeToolsBasicAdjustmentFilterTrayController.m22236a(this.f18648a, i);
            CreativeToolsUtil.m22288b(this.f18648a.f18649a, this.f18648a.f18655g.m22256a(this.f18648a.f18656h).f18642b, str);
            return true;
        }
    }

    @Inject
    public CreativeToolsBasicAdjustmentFilterTrayController(@Assisted Context context, @Assisted PreviewRenderer previewRenderer, FacecastAnalyticsLogger facecastAnalyticsLogger) {
        this.f18650b = previewRenderer;
        this.f18649a = facecastAnalyticsLogger;
        this.f18651c = (CustomHorizontalScrollView) LayoutInflater.from(context).inflate(2130904194, null);
        final GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(context, new FlingListener(this));
        this.f18654f = new OnTouchListener(this) {
            final /* synthetic */ CreativeToolsBasicAdjustmentFilterTrayController f18646b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetectorCompat.a(motionEvent);
                return false;
            }
        };
        this.f18651c.a = this;
        this.f18652d.addOnLayoutChangeListener(new C16112(this));
    }

    public final void m22243a(CreativeToolsBasicAdjustmentPack creativeToolsBasicAdjustmentPack) {
        if (creativeToolsBasicAdjustmentPack != this.f18655g) {
            this.f18655g = creativeToolsBasicAdjustmentPack;
            this.f18652d.removeAllViews();
            for (CreativeToolsBasicAdjustmentFilterView a : this.f18653e) {
                a.m22249a();
            }
            this.f18656h = 0;
            this.f18657i = true;
            LayoutInflater from = LayoutInflater.from(this.f18652d.getContext());
            Iterator it = this.f18655g.iterator();
            while (it.hasNext()) {
                CreativeToolsBasicAdjustmentFilter creativeToolsBasicAdjustmentFilter = (CreativeToolsBasicAdjustmentFilter) it.next();
                CreativeToolsBasicAdjustmentFilterView creativeToolsBasicAdjustmentFilterView = (CreativeToolsBasicAdjustmentFilterView) from.inflate(2130904192, this.f18652d, false);
                creativeToolsBasicAdjustmentFilterView.f18665f = this;
                creativeToolsBasicAdjustmentFilterView.f18664e = this.f18650b;
                creativeToolsBasicAdjustmentFilterView.m22250a(creativeToolsBasicAdjustmentFilter);
                this.f18652d.addView(creativeToolsBasicAdjustmentFilterView);
                this.f18653e.add(creativeToolsBasicAdjustmentFilterView);
                if (this.f18653e.size() == 1) {
                    creativeToolsBasicAdjustmentFilterView.setSelected(true);
                }
            }
        }
    }

    public final void mo1431a(CreativeToolsBasicAdjustmentFilterView creativeToolsBasicAdjustmentFilterView) {
        Preconditions.checkNotNull(this.f18655g);
        m22236a(this, this.f18653e.indexOf(creativeToolsBasicAdjustmentFilterView));
        CreativeToolsUtil.m22288b(this.f18649a, this.f18655g.m22256a(this.f18656h).f18642b, "tap");
    }

    public final void mo1430a(FacecastPreviewView facecastPreviewView) {
        facecastPreviewView.m21876a(this.f18654f);
        if (this.f18651c.getChildCount() == 0) {
            this.f18651c.addView(this.f18652d);
        }
    }

    public final void mo1433b(FacecastPreviewView facecastPreviewView) {
        facecastPreviewView.m21877b(this.f18654f);
        this.f18651c.removeView(this.f18652d);
    }

    public final View mo1432b() {
        return this.f18651c;
    }

    @Nullable
    public final View mo1434c() {
        return null;
    }

    public final void m22240a() {
        m22239f(this);
    }

    public static void m22236a(CreativeToolsBasicAdjustmentFilterTrayController creativeToolsBasicAdjustmentFilterTrayController, int i) {
        Preconditions.checkNotNull(creativeToolsBasicAdjustmentFilterTrayController.f18655g);
        int i2 = creativeToolsBasicAdjustmentFilterTrayController.f18656h;
        creativeToolsBasicAdjustmentFilterTrayController.f18656h = i;
        if (i2 != creativeToolsBasicAdjustmentFilterTrayController.f18656h) {
            CreativeToolsBasicAdjustmentFilterView creativeToolsBasicAdjustmentFilterView = (CreativeToolsBasicAdjustmentFilterView) creativeToolsBasicAdjustmentFilterTrayController.f18653e.get(i2);
            CreativeToolsBasicAdjustmentFilterView creativeToolsBasicAdjustmentFilterView2 = (CreativeToolsBasicAdjustmentFilterView) creativeToolsBasicAdjustmentFilterTrayController.f18653e.get(creativeToolsBasicAdjustmentFilterTrayController.f18656h);
            PreviewRenderer previewRenderer = creativeToolsBasicAdjustmentFilterTrayController.f18650b;
            ColorFilter colorFilter = creativeToolsBasicAdjustmentFilterTrayController.f18655g.m22256a(creativeToolsBasicAdjustmentFilterTrayController.f18656h).f18643c;
            if (previewRenderer.f18101v != null) {
                previewRenderer.f18101v.f18019h.m19768a(colorFilter);
            }
            creativeToolsBasicAdjustmentFilterView.setSelected(false);
            creativeToolsBasicAdjustmentFilterView2.setSelected(true);
            LayoutParams layoutParams = (LayoutParams) creativeToolsBasicAdjustmentFilterView2.getLayoutParams();
            int left = creativeToolsBasicAdjustmentFilterView2.getLeft() - layoutParams.leftMargin;
            i2 = layoutParams.rightMargin + creativeToolsBasicAdjustmentFilterView2.getRight();
            int d = creativeToolsBasicAdjustmentFilterTrayController.m22237d();
            int e = creativeToolsBasicAdjustmentFilterTrayController.m22238e();
            if (left < d) {
                creativeToolsBasicAdjustmentFilterTrayController.f18651c.smoothScrollBy(left - d, 0);
            } else if (i2 > e) {
                creativeToolsBasicAdjustmentFilterTrayController.f18651c.smoothScrollBy(i2 - e, 0);
            }
        }
    }

    private int m22237d() {
        return this.f18651c.getScrollX() - ((FrameLayout.LayoutParams) this.f18652d.getLayoutParams()).leftMargin;
    }

    private int m22238e() {
        return m22237d() + this.f18651c.getWidth();
    }

    public static void m22239f(CreativeToolsBasicAdjustmentFilterTrayController creativeToolsBasicAdjustmentFilterTrayController) {
        int d = creativeToolsBasicAdjustmentFilterTrayController.m22237d();
        int e = creativeToolsBasicAdjustmentFilterTrayController.m22238e();
        creativeToolsBasicAdjustmentFilterTrayController.f18657i = false;
        for (int i = 0; i < creativeToolsBasicAdjustmentFilterTrayController.f18653e.size(); i++) {
            boolean z;
            CreativeToolsBasicAdjustmentFilterView creativeToolsBasicAdjustmentFilterView = (CreativeToolsBasicAdjustmentFilterView) creativeToolsBasicAdjustmentFilterTrayController.f18653e.get(i);
            if (creativeToolsBasicAdjustmentFilterView.getRight() <= d || creativeToolsBasicAdjustmentFilterView.getLeft() >= e) {
                z = false;
            } else {
                z = true;
            }
            creativeToolsBasicAdjustmentFilterView.setVisibility(z);
        }
    }
}
