package com.facebook.nodes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.facebook.R;
import com.facebook.nodes.canvas.CanvasOperation;
import com.facebook.nodes.canvas.DeferredModeCanvasProxy;

/* compiled from: thumb */
public class ImageNode extends Node {
    private static final RectF f3107a = new RectF();
    private static final ScaleType[] f3108g = new ScaleType[]{ScaleType.MATRIX, ScaleType.FIT_XY, ScaleType.FIT_START, ScaleType.FIT_CENTER, ScaleType.FIT_END, ScaleType.CENTER, ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE};
    private final Matrix f3109b = new Matrix();
    private State f3110e = new State();
    private ScaleType f3111f;

    /* compiled from: thumb */
    public final class State implements AttachDetachListener, CanvasOperation {
        public Drawable f3100a;
        public boolean f3101b;
        public Matrix f3102c;
        public int f3103d;
        public int f3104e;
        public int f3105f;
        public int f3106g;

        public final void mo188a(Canvas canvas) {
            if (this.f3101b || this.f3102c != null) {
                canvas.save();
                if (this.f3101b) {
                    canvas.clipRect(this.f3103d, this.f3104e, this.f3105f, this.f3106g);
                }
                if (this.f3102c != null) {
                    canvas.translate((float) this.f3103d, (float) this.f3104e);
                    canvas.concat(this.f3102c);
                }
                this.f3100a.draw(canvas);
                canvas.restore();
                return;
            }
            this.f3100a.draw(canvas);
        }

        public final void mo189a(View view) {
            this.f3100a.setCallback(view);
        }

        public final void mo187a() {
            this.f3100a.setCallback(null);
        }
    }

    public ImageNode(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageNode, i, i2);
        this.f3110e.f3100a = obtainStyledAttributes.getDrawable(0);
        this.f3111f = f3108g[obtainStyledAttributes.getInt(1, ScaleType.FIT_CENTER.ordinal())];
        obtainStyledAttributes.recycle();
    }

    public final Drawable m4150a() {
        return this.f3110e.f3100a;
    }

    public final void m4153a(Context context, int i) {
        if (i == 0) {
            m4154a(null);
        } else {
            m4154a(context.getResources().getDrawable(i));
        }
    }

    public void m4154a(Drawable drawable) {
        Drawable drawable2 = this.f3110e.f3100a;
        if (drawable2 != drawable) {
            BaseThreadingModel baseThreadingModel = this.f3086q;
            if (baseThreadingModel != null) {
                if (drawable2 != null) {
                    baseThreadingModel.m4065b(this.f3110e);
                }
                if (drawable != null) {
                    baseThreadingModel.m4060a(this.f3110e);
                    if (drawable.isStateful()) {
                        drawable.setState(baseThreadingModel.m4068d());
                    }
                }
            }
            this.f3110e.f3100a = drawable;
            m4107s();
        }
    }

    public final void mo176a(BaseThreadingModel baseThreadingModel) {
        if (this.f3110e.f3100a != null) {
            BaseThreadingModel baseThreadingModel2 = this.f3086q;
            if (baseThreadingModel2 != null) {
                baseThreadingModel2.m4065b(this.f3110e);
            }
            if (baseThreadingModel != null) {
                baseThreadingModel.m4060a(this.f3110e);
            }
        }
        super.mo176a(baseThreadingModel);
    }

    protected void mo178a(int[] iArr) {
        super.mo178a(iArr);
        Drawable drawable = this.f3110e.f3100a;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(iArr);
        }
    }

    protected final void mo184a(int i, int i2) {
        Drawable drawable = this.f3110e.f3100a;
        if (drawable == null) {
            m4091c(this.f3081l + this.f3082m, this.f3083n + this.f3084o);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth == -1) {
            m4091c(this.f3081l + this.f3082m, this.f3083n + this.f3084o);
        } else {
            m4091c((intrinsicWidth + this.f3081l) + this.f3082m, (drawable.getIntrinsicHeight() + this.f3083n) + this.f3084o);
        }
    }

    protected final void mo185a(int i, int i2, int i3, int i4) {
        Drawable drawable = this.f3110e.f3100a;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int n = i + m4102n();
            int o = i3 - m4103o();
            int p = i2 + m4104p();
            int q = i4 - m4105q();
            this.f3110e.f3101b = false;
            this.f3110e.f3102c = null;
            this.f3110e.f3103d = n;
            this.f3110e.f3104e = p;
            this.f3110e.f3105f = o;
            this.f3110e.f3106g = q;
            ScaleType scaleType = this.f3111f;
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0 || scaleType == ScaleType.FIT_XY) {
                drawable.setBounds(n, p, o, q);
                return;
            }
            int i5 = o - n;
            int i6 = q - p;
            if (i5 == intrinsicWidth && i6 == intrinsicHeight) {
                drawable.setBounds(n, p, o, q);
            } else if (scaleType == ScaleType.MATRIX) {
                drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.f3110e.f3102c = this.f3109b;
                f3107a.set(0.0f, 0.0f, (float) intrinsicWidth, (float) intrinsicHeight);
                this.f3109b.mapRect(f3107a);
                State state = this.f3110e;
                if (f3107a.left < 0.0f || f3107a.top < 0.0f || f3107a.right > ((float) m4100l()) || f3107a.bottom > ((float) m4101m())) {
                    r0 = true;
                } else {
                    r0 = false;
                }
                state.f3101b = r0;
            } else if (scaleType == ScaleType.CENTER) {
                r0 = i5 - intrinsicWidth;
                o = i6 - intrinsicHeight;
                State state2 = this.f3110e;
                if (r0 < 0 || o < 0) {
                    r0 = true;
                } else {
                    r0 = false;
                }
                state2.f3101b = r0;
                r0 = (i / 2) + n;
                o = (i2 / 2) + p;
                drawable.setBounds(r0, o, r0 + intrinsicWidth, o + intrinsicHeight);
            } else if (this.f3111f == ScaleType.CENTER_CROP) {
                float f;
                this.f3110e.f3101b = true;
                o = 0;
                r0 = 0;
                if (intrinsicWidth * i6 > i5 * intrinsicHeight) {
                    f = ((float) i6) / ((float) intrinsicHeight);
                    o = (int) (((((float) i5) - (((float) intrinsicWidth) * f)) * 0.5f) + 0.5f);
                } else {
                    f = ((float) i5) / ((float) intrinsicWidth);
                    r0 = (int) (((((float) i6) - (((float) intrinsicHeight) * f)) * 0.5f) + 0.5f);
                }
                drawable.setBounds(o + n, r0 + p, n + ((int) (((float) intrinsicWidth) * f)), ((int) (f * ((float) intrinsicHeight))) + p);
            } else {
                if (scaleType == ScaleType.CENTER_INSIDE) {
                    if (intrinsicWidth > i5 || intrinsicHeight > i6) {
                        scaleType = ScaleType.FIT_CENTER;
                    } else {
                        drawable.setBounds(((i5 - intrinsicWidth) / 2) + n, ((i6 - intrinsicHeight) / 2) + p, n + intrinsicWidth, p + intrinsicHeight);
                        return;
                    }
                }
                float min = Math.min(((float) i5) / ((float) intrinsicWidth), ((float) i6) / ((float) intrinsicHeight));
                q = (int) (((float) intrinsicWidth) * min);
                intrinsicWidth = (int) (min * ((float) intrinsicHeight));
                if (scaleType == ScaleType.FIT_START) {
                    r0 = p;
                    o = n;
                } else if (scaleType == ScaleType.FIT_CENTER) {
                    o = n + ((int) ((((float) (i5 - q)) * 0.5f) + 0.5f));
                    r0 = ((int) ((((float) (i6 - intrinsicWidth)) * 0.5f) + 0.5f)) + p;
                } else if (scaleType == ScaleType.FIT_END) {
                    o = n + (i5 - q);
                    r0 = (i6 - intrinsicWidth) + p;
                } else {
                    throw new RuntimeException("Unknown ScaleType: " + scaleType);
                }
                drawable.setBounds(o, r0, q + o, r0 + intrinsicWidth);
            }
        }
    }

    protected final void mo177a(DeferredModeCanvasProxy deferredModeCanvasProxy) {
        if (this.f3110e.f3100a != null) {
            deferredModeCanvasProxy.m4235a(this.f3110e);
        }
    }
}
