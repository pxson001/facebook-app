package com.facebook.messaging.camerautil;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.View;

/* compiled from: messenger_transcode_canceled */
public class HighlightView {
    private static final Class<?> f9657g = HighlightView.class;
    public View f9658a;
    public boolean f9659b;
    public boolean f9660c;
    Rect f9661d;
    RectF f9662e;
    Matrix f9663f;
    private ModifyMode f9664h = ModifyMode.None;
    private RectF f9665i;
    private boolean f9666j = false;
    private float f9667k;
    private boolean f9668l = false;
    public Drawable f9669m;
    public Drawable f9670n;
    public Drawable f9671o;
    private final Paint f9672p = new Paint();
    private final Paint f9673q = new Paint();
    private final Paint f9674r = new Paint();

    /* compiled from: messenger_transcode_canceled */
    enum ModifyMode {
        None,
        Move,
        Grow
    }

    public HighlightView(View view) {
        this.f9658a = view;
        ViewCompat.a(this.f9658a, 1, null);
    }

    public final boolean m10260a() {
        return this.f9659b;
    }

    protected final void m10257a(Canvas canvas) {
        if (!this.f9660c) {
            canvas.save();
            Path path = new Path();
            if (m10260a()) {
                Rect rect = new Rect();
                this.f9658a.getDrawingRect(rect);
                if (this.f9668l) {
                    float width = (float) this.f9661d.width();
                    path.addCircle(((float) this.f9661d.left) + (width / 2.0f), (((float) this.f9661d.height()) / 2.0f) + ((float) this.f9661d.top), width / 2.0f, Direction.CW);
                    this.f9674r.setColor(-1112874);
                } else {
                    path.addRect(new RectF(this.f9661d), Direction.CW);
                    this.f9674r.setColor(this.f9658a.getResources().getColor(2131362241));
                }
                canvas.clipPath(path, Op.DIFFERENCE);
                canvas.drawRect(rect, m10260a() ? this.f9672p : this.f9673q);
                canvas.restore();
                canvas.drawPath(path, this.f9674r);
                if (this.f9664h != ModifyMode.Grow) {
                    return;
                }
                int round;
                int width2;
                int height;
                if (this.f9668l) {
                    round = (int) Math.round(Math.cos(0.7853981633974483d) * (((double) this.f9661d.width()) / 2.0d));
                    width2 = ((this.f9661d.left + (this.f9661d.width() / 2)) + round) - (this.f9671o.getIntrinsicWidth() / 2);
                    height = ((this.f9661d.top + (this.f9661d.height() / 2)) - round) - (this.f9671o.getIntrinsicHeight() / 2);
                    this.f9671o.setBounds(width2, height, this.f9671o.getIntrinsicWidth() + width2, this.f9671o.getIntrinsicHeight() + height);
                    this.f9671o.draw(canvas);
                    return;
                }
                width2 = this.f9661d.left + 1;
                height = this.f9661d.right + 1;
                round = this.f9661d.top + 4;
                int i = this.f9661d.bottom + 3;
                int intrinsicWidth = this.f9669m.getIntrinsicWidth() / 2;
                int intrinsicHeight = this.f9669m.getIntrinsicHeight() / 2;
                int intrinsicHeight2 = this.f9670n.getIntrinsicHeight() / 2;
                int intrinsicWidth2 = this.f9670n.getIntrinsicWidth() / 2;
                int i2 = this.f9661d.left + ((this.f9661d.right - this.f9661d.left) / 2);
                int i3 = this.f9661d.top + ((this.f9661d.bottom - this.f9661d.top) / 2);
                this.f9669m.setBounds(width2 - intrinsicWidth, i3 - intrinsicHeight, width2 + intrinsicWidth, i3 + intrinsicHeight);
                this.f9669m.draw(canvas);
                this.f9669m.setBounds(height - intrinsicWidth, i3 - intrinsicHeight, height + intrinsicWidth, i3 + intrinsicHeight);
                this.f9669m.draw(canvas);
                this.f9670n.setBounds(i2 - intrinsicWidth2, round - intrinsicHeight2, i2 + intrinsicWidth2, round + intrinsicHeight2);
                this.f9670n.draw(canvas);
                this.f9670n.setBounds(i2 - intrinsicWidth2, i - intrinsicHeight2, i2 + intrinsicWidth2, i + intrinsicHeight2);
                this.f9670n.draw(canvas);
                return;
            }
            this.f9674r.setColor(-16777216);
            canvas.drawRect(this.f9661d, this.f9674r);
        }
    }

    public final void m10259a(ModifyMode modifyMode) {
        if (modifyMode != this.f9664h) {
            this.f9664h = modifyMode;
            this.f9658a.invalidate();
        }
    }

    public final int m10255a(float f, float f2) {
        int i = 0;
        Rect e = m10254e();
        int sqrt;
        if (this.f9668l) {
            float centerX = f - ((float) e.centerX());
            float centerY = f2 - ((float) e.centerY());
            sqrt = (int) Math.sqrt((double) ((centerX * centerX) + (centerY * centerY)));
            int width = this.f9661d.width() / 2;
            if (((float) Math.abs(sqrt - width)) <= 20.0f) {
                if (Math.abs(centerY) > Math.abs(centerX)) {
                    if (centerY < 0.0f) {
                        return 8;
                    }
                    return 16;
                } else if (centerX < 0.0f) {
                    return 2;
                } else {
                    return 4;
                }
            } else if (sqrt < width) {
                return 32;
            } else {
                return 1;
            }
        }
        int i2 = (f2 < ((float) e.top) - 20.0f || f2 >= ((float) e.bottom) + 20.0f) ? 0 : 1;
        if (f >= ((float) e.left) - 20.0f && f < ((float) e.right) + 20.0f) {
            i = 1;
        }
        if (Math.abs(((float) e.left) - f) >= 20.0f || i2 == 0) {
            sqrt = 1;
        } else {
            sqrt = 3;
        }
        if (Math.abs(((float) e.right) - f) < 20.0f && i2 != 0) {
            sqrt |= 4;
        }
        if (Math.abs(((float) e.top) - f2) < 20.0f && r2 != 0) {
            sqrt |= 8;
        }
        if (Math.abs(((float) e.bottom) - f2) >= 20.0f || r2 == 0) {
            i2 = sqrt;
        } else {
            i2 = sqrt | 16;
        }
        if (i2 == 1 && e.contains((int) f, (int) f2)) {
            return 32;
        }
        return i2;
    }

    final void m10256a(int i, float f, float f2) {
        Rect e = m10254e();
        if (i != 1) {
            if (i == 32) {
                m10252b((this.f9662e.width() / ((float) e.width())) * f, (this.f9662e.height() / ((float) e.height())) * f2);
                return;
            }
            if ((i & 6) == 0) {
                f = 0.0f;
            }
            if ((i & 24) == 0) {
                f2 = 0.0f;
            }
            m10253c((f * (this.f9662e.width() / ((float) e.width()))) * ((float) ((i & 2) != 0 ? -1 : 1)), ((float) ((i & 8) != 0 ? -1 : 1)) * (f2 * (this.f9662e.height() / ((float) e.height()))));
        }
    }

    private void m10252b(float f, float f2) {
        Rect rect = new Rect(this.f9661d);
        this.f9662e.offset(f, f2);
        this.f9662e.offset(Math.max(0.0f, this.f9665i.left - this.f9662e.left), Math.max(0.0f, this.f9665i.top - this.f9662e.top));
        this.f9662e.offset(Math.min(0.0f, this.f9665i.right - this.f9662e.right), Math.min(0.0f, this.f9665i.bottom - this.f9662e.bottom));
        this.f9661d = m10254e();
        rect.union(this.f9661d);
        rect.inset(-10, -10);
        this.f9658a.invalidate(rect);
    }

    private void m10253c(float f, float f2) {
        float f3;
        float f4;
        if (this.f9666j) {
            if (f != 0.0f) {
                f2 = f / this.f9667k;
            } else if (f2 != 0.0f) {
                f = f2 * this.f9667k;
            }
        }
        RectF rectF = new RectF(this.f9662e);
        if (f > 0.0f && rectF.width() + (2.0f * f) > this.f9665i.width()) {
            f = (this.f9665i.width() - rectF.width()) / 2.0f;
            if (this.f9666j) {
                f3 = f / this.f9667k;
                f4 = f;
                if (f3 > 0.0f && rectF.height() + (2.0f * f3) > this.f9665i.height()) {
                    f3 = (this.f9665i.height() - rectF.height()) / 2.0f;
                    if (this.f9666j) {
                        f4 = this.f9667k * f3;
                    }
                }
                rectF.inset(-f4, -f3);
                if (rectF.width() < 25.0f) {
                    rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
                }
                f3 = this.f9666j ? 25.0f / this.f9667k : 25.0f;
                if (rectF.height() < f3) {
                    rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
                }
                if (rectF.left < this.f9665i.left) {
                    rectF.offset(this.f9665i.left - rectF.left, 0.0f);
                } else if (rectF.right > this.f9665i.right) {
                    rectF.offset(-(rectF.right - this.f9665i.right), 0.0f);
                }
                if (rectF.top < this.f9665i.top) {
                    rectF.offset(0.0f, this.f9665i.top - rectF.top);
                } else if (rectF.bottom > this.f9665i.bottom) {
                    rectF.offset(0.0f, -(rectF.bottom - this.f9665i.bottom));
                }
                this.f9662e.set(rectF);
                this.f9661d = m10254e();
                this.f9658a.invalidate();
            }
        }
        f3 = f2;
        f4 = f;
        f3 = (this.f9665i.height() - rectF.height()) / 2.0f;
        if (this.f9666j) {
            f4 = this.f9667k * f3;
        }
        rectF.inset(-f4, -f3);
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        if (this.f9666j) {
        }
        if (rectF.height() < f3) {
            rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
        }
        if (rectF.left < this.f9665i.left) {
            rectF.offset(this.f9665i.left - rectF.left, 0.0f);
        } else if (rectF.right > this.f9665i.right) {
            rectF.offset(-(rectF.right - this.f9665i.right), 0.0f);
        }
        if (rectF.top < this.f9665i.top) {
            rectF.offset(0.0f, this.f9665i.top - rectF.top);
        } else if (rectF.bottom > this.f9665i.bottom) {
            rectF.offset(0.0f, -(rectF.bottom - this.f9665i.bottom));
        }
        this.f9662e.set(rectF);
        this.f9661d = m10254e();
        this.f9658a.invalidate();
    }

    public final Rect m10261b() {
        return new Rect((int) this.f9662e.left, (int) this.f9662e.top, (int) this.f9662e.right, (int) this.f9662e.bottom);
    }

    private Rect m10254e() {
        RectF rectF = new RectF(this.f9662e.left, this.f9662e.top, this.f9662e.right, this.f9662e.bottom);
        this.f9663f.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public final void m10262c() {
        this.f9661d = m10254e();
    }

    public final void m10258a(Matrix matrix, Rect rect, RectF rectF, boolean z, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.f9663f = new Matrix(matrix);
        this.f9662e = rectF;
        this.f9665i = new RectF(rect);
        this.f9666j = z2;
        this.f9668l = z;
        this.f9667k = this.f9662e.width() / this.f9662e.height();
        this.f9661d = m10254e();
        this.f9672p.setARGB(125, 50, 50, 50);
        this.f9673q.setARGB(125, 50, 50, 50);
        this.f9674r.setStrokeWidth(3.0f);
        this.f9674r.setStyle(Style.STROKE);
        this.f9674r.setAntiAlias(true);
        this.f9664h = ModifyMode.None;
        Resources resources = this.f9658a.getResources();
        this.f9669m = resources.getDrawable(2130841897);
        this.f9670n = resources.getDrawable(2130841896);
        this.f9671o = resources.getDrawable(2130842060);
    }
}
