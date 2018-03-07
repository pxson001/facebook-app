package com.facebook.optic;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: targetHeight */
public class PhotoCaptureInfo {
    public final Rect f3335a;
    public final Rect f3336b;
    public final Rect f3337c;
    public final int f3338d;

    PhotoCaptureInfo(Rect rect, Rect rect2, Rect rect3, int i) {
        this.f3335a = m4405a(rect, i);
        this.f3336b = m4405a(rect2, i);
        this.f3337c = rect3;
        this.f3338d = i;
    }

    public final Rect m4406a(int i) {
        if (i != 0) {
            m4405a(this.f3336b, i);
            m4405a(this.f3335a, i);
        }
        return m4404a(m4404a(this.f3335a, ((float) this.f3336b.width()) / ((float) this.f3336b.height())), ((float) this.f3337c.width()) / ((float) this.f3337c.height()));
    }

    private static Rect m4404a(Rect rect, float f) {
        int round;
        int i;
        int height;
        int width;
        float width2 = ((float) rect.width()) / ((float) rect.height());
        if (width2 < f) {
            round = Math.round((width2 / f) * ((float) rect.height()));
            i = rect.left;
            height = (rect.height() - round) / 2;
            width = rect.width() + i;
            round += height;
        } else {
            round = Math.round((f / width2) * ((float) rect.width()));
            i = (rect.width() - round) / 2;
            height = rect.top;
            width = i + round;
            round = rect.height() + height;
        }
        return new Rect(i, height, width, round);
    }

    private static Rect m4405a(Rect rect, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        RectF rectF = new RectF();
        rectF.set(rect);
        matrix.mapRect(rectF);
        rectF.round(rect);
        rect.offsetTo(0, 0);
        return rect;
    }
}
