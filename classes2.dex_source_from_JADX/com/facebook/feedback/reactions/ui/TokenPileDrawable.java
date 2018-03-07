package com.facebook.feedback.reactions.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.util.SparseArrayCompat;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: gk_remove_extra_tranform */
public class TokenPileDrawable extends Drawable {
    private final boolean f22279a;
    public final int f22280b;
    public final int f22281c;
    public final SparseArrayCompat<Drawable> f22282d = new SparseArrayCompat();
    private final List<Drawable> f22283e = new ArrayList();
    private boolean f22284f;
    private int f22285g;
    private Paint f22286h = new Paint(1);
    public Path f22287i;

    @Inject
    public TokenPileDrawable(RTLUtil rTLUtil, Resources resources) {
        this.f22279a = rTLUtil.m6557a();
        this.f22280b = resources.getDimensionPixelSize(2131430648);
        this.f22281c = resources.getDimensionPixelSize(2131430649);
        this.f22286h.setColor(-1);
        this.f22286h.setStyle(Style.FILL);
    }

    public final void m30215a(List<FeedbackReaction> list) {
        this.f22283e.clear();
        for (FeedbackReaction feedbackReaction : list) {
            Drawable drawable = (Drawable) this.f22282d.m6350a(feedbackReaction.f21478e);
            if (drawable == null) {
                drawable = feedbackReaction.m29192e();
                this.f22282d.m6351a(feedbackReaction.f21478e, drawable);
            }
            Drawable drawable2 = drawable;
            drawable2.setBounds(0, 0, this.f22280b, this.f22280b);
            this.f22283e.add(drawable2);
        }
        this.f22285g = Math.min(this.f22283e.size(), 3) * this.f22280b;
    }

    public int getIntrinsicWidth() {
        return this.f22285g;
    }

    public int getIntrinsicHeight() {
        return this.f22280b;
    }

    public void draw(Canvas canvas) {
        canvas.save();
        if (this.f22284f) {
            m30211a(canvas);
        } else {
            m30213b(canvas);
        }
        canvas.restore();
    }

    private void m30211a(Canvas canvas) {
        int min = Math.min(this.f22283e.size(), 3);
        int i;
        if (this.f22279a) {
            canvas.translate((float) this.f22285g, 0.0f);
            for (i = 0; i < min; i++) {
                canvas.translate((float) (-this.f22280b), 0.0f);
                m30212a(canvas, (Drawable) this.f22283e.get(i));
            }
            return;
        }
        for (i = 0; i < min; i++) {
            m30212a(canvas, (Drawable) this.f22283e.get(i));
            canvas.translate((float) this.f22280b, 0.0f);
        }
    }

    private void m30212a(Canvas canvas, Drawable drawable) {
        drawable.draw(canvas);
        if (VERSION.SDK_INT >= 18) {
            canvas.clipPath(this.f22287i, Op.DIFFERENCE);
        }
    }

    private void m30213b(Canvas canvas) {
        int min = Math.min(this.f22283e.size(), 3);
        int i;
        if (this.f22279a) {
            for (i = min - 1; i >= 0; i--) {
                m30214b(canvas, (Drawable) this.f22283e.get(i));
                canvas.translate((float) this.f22280b, 0.0f);
            }
            return;
        }
        canvas.translate((float) this.f22285g, 0.0f);
        for (i = min - 1; i >= 0; i--) {
            canvas.translate((float) (-this.f22280b), 0.0f);
            m30214b(canvas, (Drawable) this.f22283e.get(i));
        }
    }

    private void m30214b(Canvas canvas, Drawable drawable) {
        float f = ((float) this.f22280b) / 2.0f;
        canvas.drawCircle(f, f, ((float) this.f22281c) + f, this.f22286h);
        drawable.draw(canvas);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -2;
    }

    public final void m30216a(boolean z) {
        this.f22284f = z;
        if (z && this.f22287i == null) {
            float f = ((float) this.f22280b) / 2.0f;
            this.f22287i = new Path();
            this.f22287i.addCircle(f, f, ((float) this.f22281c) + f, Direction.CW);
        }
    }
}
