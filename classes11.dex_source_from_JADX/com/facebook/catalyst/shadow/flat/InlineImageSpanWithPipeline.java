package com.facebook.catalyst.shadow.flat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.facebook.catalyst.shadow.flat.FlatViewGroup.InvalidateCallback;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

/* compiled from: location_upsell */
public final class InlineImageSpanWithPipeline extends ReplacementSpan implements AttachDetachListener, BitmapUpdateListener {
    private static final RectF f5758b = new RectF();
    @Nullable
    public PipelineRequestHelper f5759c;
    @Nullable
    private InvalidateCallback f5760d;
    public float f5761e;
    public float f5762f;
    public boolean f5763g;

    InlineImageSpanWithPipeline() {
        this(null, Float.NaN, Float.NaN);
    }

    public InlineImageSpanWithPipeline(@Nullable PipelineRequestHelper pipelineRequestHelper, float f, float f2) {
        this.f5759c = pipelineRequestHelper;
        this.f5761e = f;
        this.f5762f = f2;
    }

    public final void mo159b() {
        this.f5760d.m7067a();
    }

    public final void mo160c() {
        this.f5760d.m7067a();
    }

    public final void mo157a(InvalidateCallback invalidateCallback) {
        this.f5760d = invalidateCallback;
        if (this.f5759c != null) {
            PipelineRequestHelper pipelineRequestHelper = this.f5759c;
            boolean z = true;
            pipelineRequestHelper.f5780b = this;
            pipelineRequestHelper.f5783e++;
            if (pipelineRequestHelper.f5783e == 1) {
                Assertions.a(pipelineRequestHelper.f5781c == null);
                if (pipelineRequestHelper.f5782d != null) {
                    z = false;
                }
                Assertions.a(z);
                pipelineRequestHelper.f5781c = ImagePipelineFactory.a().h().c(pipelineRequestHelper.f5779a, RCTImageView.f5784h);
                pipelineRequestHelper.f5781c.a(pipelineRequestHelper, UiThreadImmediateExecutorService.b());
            } else if (pipelineRequestHelper.m7110b() != null) {
                mo159b();
            }
        }
    }

    public final void nX_() {
        if (this.f5759c != null) {
            Object obj;
            PipelineRequestHelper pipelineRequestHelper = this.f5759c;
            pipelineRequestHelper.f5783e--;
            if (pipelineRequestHelper.f5783e == 0) {
                if (pipelineRequestHelper.f5781c != null) {
                    pipelineRequestHelper.f5781c.g();
                    pipelineRequestHelper.f5781c = null;
                }
                if (pipelineRequestHelper.f5782d != null) {
                    pipelineRequestHelper.f5782d.close();
                    pipelineRequestHelper.f5782d = null;
                }
                pipelineRequestHelper.f5780b = null;
            }
            if (this.f5759c.f5783e == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f5760d = null;
            }
        }
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -Math.round(this.f5762f);
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return Math.round(this.f5761e);
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (this.f5759c != null) {
            Bitmap b = this.f5759c.m7110b();
            if (b != null) {
                float f2 = (float) i5;
                f5758b.set(f, f2 - this.f5762f, this.f5761e + f, f2);
                canvas.drawBitmap(b, null, f5758b, paint);
            }
        }
    }
}
