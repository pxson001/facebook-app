package com.facebook.messaging.modifiers.flowerborder;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.facebook.common.time.Clock;
import com.facebook.common.util.MathUtil;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import com.facebook.ultralight.Inject;
import java.util.ArrayList;
import java.util.List;

/* compiled from: js called native_return with callId  */
public class FlowerCornersDrawable extends Drawable {
    private final ChoreographerWrapper f12273a;
    private final Clock f12274b;
    private final FlowerElementsGenerator f12275c;
    private final List<Element> f12276d = new ArrayList();
    private final List<Element> f12277e = new ArrayList();
    private final Interpolator f12278f = new OvershootInterpolator(2.5f);
    private long f12279g;
    private long f12280h;
    private final FrameCallbackWrapper f12281i = new C13541(this);

    /* compiled from: js called native_return with callId  */
    class C13541 extends FrameCallbackWrapper {
        final /* synthetic */ FlowerCornersDrawable f12272a;

        C13541(FlowerCornersDrawable flowerCornersDrawable) {
            this.f12272a = flowerCornersDrawable;
        }

        public final void m12740a(long j) {
            this.f12272a.invalidateSelf();
        }
    }

    @Inject
    public FlowerCornersDrawable(ChoreographerWrapper choreographerWrapper, Clock clock, FlowerElementsGenerator flowerElementsGenerator) {
        this.f12273a = choreographerWrapper;
        this.f12274b = clock;
        this.f12275c = flowerElementsGenerator;
        m12743a();
    }

    public final void m12743a() {
        this.f12276d.clear();
        this.f12276d.addAll(this.f12275c.m12751a());
        this.f12277e.clear();
        this.f12277e.addAll(this.f12275c.m12751a());
        this.f12279g = this.f12274b.a();
        this.f12280h = 0;
        for (Element element : this.f12276d) {
            this.f12280h = Math.max(element.f12257i, this.f12280h);
        }
        for (Element element2 : this.f12277e) {
            this.f12280h = Math.max(element2.f12257i + 200, this.f12280h);
        }
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        long a = this.f12274b.a() - this.f12279g;
        Rect bounds = getBounds();
        for (Element a2 : this.f12276d) {
            m12742a(canvas, a2, bounds.left, bounds.top, a);
        }
        long j = a - 200;
        for (Element a3 : this.f12277e) {
            m12742a(canvas, a3, bounds.right, bounds.bottom, j);
        }
        if (a < this.f12280h) {
            this.f12273a.b(this.f12281i);
            this.f12273a.a(this.f12281i);
        }
    }

    private void m12742a(Canvas canvas, Element element, int i, int i2, long j) {
        int i3;
        int i4 = 0;
        int i5 = -1;
        float interpolation = this.f12278f.getInterpolation(MathUtil.c((float) j, (float) element.f12256h, (float) element.f12257i));
        int i6 = i > getBounds().centerX() ? 1 : 0;
        float f = (float) i;
        float f2 = element.f12249a;
        if (i6 != 0) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        float f3 = (((float) i3) * f2) + f;
        f = (float) i2;
        f2 = element.f12250b;
        if (i6 == 0) {
            i5 = 1;
        }
        float f4 = (((float) i5) * f2) + f;
        float f5 = element.f12252d;
        if (i6 != 0) {
            i4 = 180;
        }
        float f6 = (((float) i4) + f5) + ((1.0f - interpolation) * element.f12253e);
        float f7 = (element.f12251c * interpolation) * element.f12254f.f12263b;
        canvas.save();
        canvas.translate(f3, f4);
        canvas.rotate(f6);
        canvas.scale(f7, f7);
        m12741a(canvas, element);
        canvas.restore();
    }

    private static void m12741a(Canvas canvas, Element element) {
        ElementStyle elementStyle = element.f12254f;
        canvas.drawBitmap(elementStyle.f12262a.getBitmap(), ((float) (-elementStyle.f12262a.getIntrinsicWidth())) * elementStyle.f12264c, elementStyle.f12265d * ((float) (-elementStyle.f12262a.getIntrinsicHeight())), element.f12255g);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
