package com.facebook.ads.internal.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class C2000e extends LinearLayout {
    private Bitmap f14376a;
    private Bitmap f14377b;
    private ImageView f14378c;
    private ImageView f14379d;
    private ImageView f14380e;
    private Bitmap f14381f;
    private int f14382g;
    private int f14383h;

    private void m14489a() {
        if (getHeight() > 0) {
            this.f14383h = m14490b();
            this.f14382g = (int) Math.ceil((double) (((float) (getHeight() - this.f14383h)) / 2.0f));
            Matrix matrix = new Matrix();
            matrix.preScale(1.0f, -1.0f);
            int floor = (int) Math.floor((double) (((float) (getHeight() - this.f14383h)) / 2.0f));
            float height = ((float) this.f14376a.getHeight()) / ((float) this.f14383h);
            int round = Math.round(((float) this.f14382g) * height);
            if (round > 0) {
                this.f14381f = Bitmap.createBitmap(this.f14377b, 0, 0, this.f14377b.getWidth(), round, matrix, true);
                this.f14378c.setImageBitmap(this.f14381f);
            }
            round = Math.round(((float) floor) * height);
            if (round > 0) {
                this.f14380e.setImageBitmap(Bitmap.createBitmap(this.f14377b, 0, this.f14377b.getHeight() - round, this.f14377b.getWidth(), round, matrix, true));
            }
        }
    }

    private int m14490b() {
        return (int) Math.round(((double) getWidth()) / 1.91d);
    }

    public final void m14491a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            this.f14379d.setImageDrawable(null);
            return;
        }
        this.f14379d.setImageBitmap(Bitmap.createBitmap(bitmap));
        this.f14376a = bitmap;
        this.f14377b = bitmap2;
        bitmap.getHeight();
        bitmap.getWidth();
        m14489a();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f14376a == null || this.f14377b == null) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int b = m14490b();
        if (this.f14381f == null || this.f14383h != b) {
            m14489a();
        }
        this.f14378c.layout(i, i2, i3, this.f14382g);
        this.f14379d.layout(i, this.f14382g + i2, i3, this.f14382g + this.f14383h);
        this.f14380e.layout(i, (this.f14382g + i2) + this.f14383h, i3, i4);
    }
}
