package com.facebook.timeline.header.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorRes;
import android.view.View;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: fetchMoreThreads (WSH) */
public class ViewBorderDrawingHelper {
    private Paint f12026a = new Paint(1);
    private int f12027b;

    /* compiled from: fetchMoreThreads (WSH) */
    public class BordersSpec {
        boolean f12022a;
        boolean f12023b;
        boolean f12024c;
        boolean f12025d;

        public BordersSpec(boolean z, boolean z2, boolean z3, boolean z4) {
            this.f12022a = z;
            this.f12023b = z2;
            this.f12024c = z3;
            this.f12025d = z4;
        }
    }

    @Inject
    public ViewBorderDrawingHelper(@ColorRes @Assisted int i, @Assisted int i2, Resources resources) {
        this.f12027b = i2;
        this.f12026a.setColor(resources.getColor(i));
        this.f12026a.setStrokeWidth((float) this.f12027b);
    }

    public final void m12059a(View view, BordersSpec bordersSpec) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = bordersSpec.f12022a ? this.f12027b : 0;
        if (bordersSpec.f12023b) {
            i = this.f12027b;
        } else {
            i = 0;
        }
        if (bordersSpec.f12024c) {
            i2 = this.f12027b;
        } else {
            i2 = 0;
        }
        if (bordersSpec.f12025d) {
            i3 = this.f12027b;
        }
        view.setPadding(i4 + view.getPaddingLeft(), i2 + view.getPaddingTop(), i + view.getPaddingRight(), i3 + view.getPaddingBottom());
    }

    public final void m12058a(View view, Canvas canvas, BordersSpec bordersSpec) {
        int width = view.getWidth() - 1;
        int height = view.getHeight() - 1;
        if (bordersSpec.f12022a) {
            canvas.drawLine(0.0f, 0.0f, 0.0f, (float) height, this.f12026a);
        }
        if (bordersSpec.f12023b) {
            canvas.drawLine((float) width, 0.0f, (float) width, (float) height, this.f12026a);
        }
        if (bordersSpec.f12024c) {
            canvas.drawLine(0.0f, 0.0f, (float) width, 0.0f, this.f12026a);
        }
        if (bordersSpec.f12025d) {
            canvas.drawLine(0.0f, (float) height, (float) width, (float) height, this.f12026a);
        }
    }
}
