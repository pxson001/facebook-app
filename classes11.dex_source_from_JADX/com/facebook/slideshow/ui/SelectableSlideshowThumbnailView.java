package com.facebook.slideshow.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.inject.FbInjector;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: PHOTOS_TAKEN_HERE */
public class SelectableSlideshowThumbnailView extends FbDraweeView {
    private static final SpringConfig f12609c = SpringConfig.a(65.0d, 10.0d);
    @Inject
    public SpringSystem f12610d;
    public Spring f12611e;
    private RoundingParams f12612f;
    public boolean f12613g;

    /* compiled from: PHOTOS_TAKEN_HERE */
    class C14901 extends SimpleSpringListener {
        final /* synthetic */ SelectableSlideshowThumbnailView f12607a;

        C14901(SelectableSlideshowThumbnailView selectableSlideshowThumbnailView) {
            this.f12607a = selectableSlideshowThumbnailView;
        }

        public final void m13015a(Spring spring) {
            float d = (float) spring.d();
            this.f12607a.setScaleX(d);
            this.f12607a.setScaleY(d);
        }
    }

    /* compiled from: PHOTOS_TAKEN_HERE */
    class C14912 implements OnTouchListener {
        final /* synthetic */ SelectableSlideshowThumbnailView f12608a;

        C14912(SelectableSlideshowThumbnailView selectableSlideshowThumbnailView) {
            this.f12608a = selectableSlideshowThumbnailView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f12608a.f12611e.b(0.95d);
                    break;
                default:
                    if (!this.f12608a.f12613g) {
                        this.f12608a.f12611e.b(1.0d);
                        break;
                    }
                    break;
            }
            return true;
        }
    }

    private static <T extends View> void m13018a(Class<T> cls, T t) {
        m13019a((Object) t, t.getContext());
    }

    private static void m13019a(Object obj, Context context) {
        ((SelectableSlideshowThumbnailView) obj).f12610d = SpringSystem.b(FbInjector.get(context));
    }

    public SelectableSlideshowThumbnailView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        m13021c();
    }

    public SelectableSlideshowThumbnailView(Context context) {
        super(context);
        m13021c();
    }

    public SelectableSlideshowThumbnailView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m13021c();
    }

    public SelectableSlideshowThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13021c();
    }

    private void m13021c() {
        m13018a(SelectableSlideshowThumbnailView.class, (View) this);
        Spring a = this.f12610d.a().a(f12609c).a(1.0d);
        a.c = true;
        this.f12611e = a.l();
        this.f12611e.a(new C14901(this));
        setOnTouchListener(new C14912(this));
        this.f12612f = RoundingParams.b(0.0f).a(getResources().getColor(2131361917), (float) getResources().getDimensionPixelSize(2131434723));
        this.f12613g = false;
    }

    private void m13017a(SpringSystem springSystem) {
        this.f12610d = springSystem;
    }

    public void setIsSelected(boolean z) {
        this.f12613g = z;
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.a(this.f12613g ? this.f12612f : null);
        }
        if (!this.f12613g && this.f12611e.d() == 0.95d) {
            this.f12611e.b(1.0d);
        }
    }
}
