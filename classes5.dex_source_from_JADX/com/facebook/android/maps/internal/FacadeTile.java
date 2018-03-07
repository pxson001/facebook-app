package com.facebook.android.maps.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import com.facebook.android.maps.model.Tile;

/* compiled from: average_star_rating */
public class FacadeTile {
    public Tile f8389a = null;
    public Tile f8390b = null;
    public Tile[] f8391c = new Tile[4];
    protected Paint f8392d = new Paint(3);
    int f8393e;
    int f8394f;
    int f8395g;
    public int f8396h = 0;
    private final Rect f8397i = new Rect();
    private final RectF f8398j = new RectF();

    public void mo1068a(Canvas canvas, float f, float f2) {
        Bitmap b = this.f8389a != null ? this.f8389a.m14616b() : null;
        if (b != Tile.f8650a) {
            Object obj;
            int i = 255;
            if (b != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (!(obj == null || this.f8389a.f8658d == -1)) {
                i = (int) (SystemClock.uptimeMillis() - this.f8389a.f8658d);
                if (i >= 255) {
                    i = 255;
                    this.f8389a.f8658d = -1;
                }
            }
            int i2 = i;
            if (i2 != 255 || obj == null) {
                int i3;
                int i4;
                this.f8392d.setAlpha(255);
                i = 0;
                if (this.f8391c != null) {
                    i3 = 0;
                    while (i3 < 4) {
                        if (!(this.f8391c[i3] == null || this.f8391c[i3].f8659e != this.f8395g + 1 || this.f8391c[i3].m14616b() == null)) {
                            i++;
                        }
                        i3++;
                    }
                }
                Bitmap b2 = this.f8390b != null ? this.f8390b.m14616b() : null;
                if (!(i == 4 || b2 == null || b2 == Tile.f8650a)) {
                    int i5 = this.f8395g - this.f8390b.f8659e;
                    int i6 = 1 << i5;
                    i5 = this.f8390b.f8656b >> i5;
                    i4 = (this.f8393e & (i6 - 1)) * i5;
                    i6 = ((i6 - 1) & this.f8394f) * i5;
                    this.f8397i.set(i4, i6, i4 + i5, i5 + i6);
                    this.f8398j.set(f, f2, ((float) this.f8390b.f8657c) + f, ((float) this.f8390b.f8656b) + f2);
                    canvas.drawBitmap(b2, this.f8397i, this.f8398j, this.f8392d);
                }
                if (i > 0) {
                    for (i3 = 0; i3 < 2; i3++) {
                        for (i = 0; i < 2; i++) {
                            Tile tile = this.f8391c[(i3 << 1) + i];
                            if (tile != null && tile.f8659e == this.f8395g + 1) {
                                Bitmap b3 = tile.m14616b();
                                if (!(b3 == null || b3 == Tile.f8650a)) {
                                    i4 = tile.f8656b >> 1;
                                    float f3 = ((float) (i4 * i3)) + f;
                                    float f4 = ((float) (i4 * i)) + f2;
                                    this.f8397i.set(0, 0, tile.f8657c, tile.f8656b);
                                    this.f8398j.set(f3, f4, ((float) i4) + f3, ((float) i4) + f4);
                                    canvas.drawBitmap(b3, this.f8397i, this.f8398j, this.f8392d);
                                }
                            }
                        }
                    }
                }
            }
            if (obj != null) {
                this.f8392d.setAlpha(i2);
                canvas.drawBitmap(b, f, f2, this.f8392d);
            }
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "{tile=" + (this.f8389a == null ? "{x}" : this.f8389a) + ", mParentTile=" + (this.f8390b == null ? "{x}" : this.f8390b) + ", status=" + this.f8396h + "}";
    }
}
