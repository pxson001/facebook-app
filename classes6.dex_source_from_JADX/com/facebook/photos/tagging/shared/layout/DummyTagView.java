package com.facebook.photos.tagging.shared.layout;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.facebook.inject.Assisted;
import com.facebook.photos.tagging.shared.BubbleLayout.ArrowDirection;
import javax.inject.Inject;

/* compiled from: has_available_photo_menus */
public class DummyTagView<TAGVIEW extends View & LayoutableTagView> {
    public static final ArrowDirection f13381a = ArrowDirection.UP;
    public ArrowDirection f13382b;
    public PointF f13383c = new PointF();
    public final TAGVIEW f13384d;
    private final TagWithFacebox f13385e;
    public InsetContainerBounds f13386f = new InsetContainerBounds();

    @Inject
    public DummyTagView(@Assisted LayoutableTagView layoutableTagView, @Assisted Integer num, @Assisted TagWithFacebox tagWithFacebox) {
        this.f13384d = (View) layoutableTagView;
        this.f13385e = tagWithFacebox;
        this.f13383c.set(this.f13385e.f13389a);
        m21052a(f13381a);
    }

    public final ArrowDirection m21051a() {
        return this.f13382b;
    }

    public final void m21052a(ArrowDirection arrowDirection) {
        this.f13382b = arrowDirection;
        if (this.f13385e.f13390b != null) {
            RectF rectF = this.f13385e.f13390b;
            PointF pointF = this.f13383c;
            switch (arrowDirection) {
                case DOWN:
                    pointF.set(rectF.centerX(), rectF.top);
                    return;
                case RIGHT:
                    pointF.set(rectF.left, rectF.centerY());
                    return;
                case LEFT:
                    pointF.set(rectF.right, rectF.centerY());
                    return;
                case UP:
                    pointF.set(rectF.centerX(), rectF.bottom);
                    return;
                case DOWNRIGHT:
                    pointF.set(rectF.left, rectF.top);
                    return;
                case DOWNLEFT:
                    pointF.set(rectF.right, rectF.top);
                    return;
                case UPRIGHT:
                    pointF.set(rectF.left, rectF.bottom);
                    return;
                case UPLEFT:
                    pointF.set(rectF.right, rectF.bottom);
                    return;
                default:
                    return;
            }
        }
    }

    public final PointF m21053b() {
        return this.f13383c;
    }

    public final Rect m21054c() {
        return this.f13386f.f13387a;
    }
}
