package com.facebook.feedback.reactions.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.feedback.reactions.ui.VectorGraphicConfig.AnimationWave;
import com.facebook.feedback.reactions.ui.VectorGraphicConfig.PaintConfig;
import com.facebook.feedback.reactions.ui.VectorGraphicConfig.State;
import com.facebook.feedback.reactions.ui.VectorGraphicConfig.VectorLine;
import com.facebook.feedback.reactions.ui.anim.ReactionsAnimationManager;
import com.facebook.inject.Assisted;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.waveanimator.MultiWaveAnimator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;

/* compiled from: setting_id */
public class ReactionsVectorDrawable extends Drawable {
    private final VectorGraphicConfig f3894a;
    private final List<Path> f3895b;
    private final Drawable f3896c;
    public final Spring f3897d;
    private final TransitionSpringListener f3898e;
    private final Paint f3899f;
    private ReactionsClientInfo f3900g;
    public int f3901h;
    public int f3902i;
    private float f3903j;
    private float f3904k;
    private MultiWaveAnimator f3905l;
    private C03371 f3906m;
    public float f3907n;
    public float f3908o;
    public float f3909p;
    private ReactionsAnimationManager f3910q;

    /* compiled from: setting_id */
    public class C03371 {
        public final /* synthetic */ ReactionsVectorDrawable f3890a;

        C03371(ReactionsVectorDrawable reactionsVectorDrawable) {
            this.f3890a = reactionsVectorDrawable;
        }
    }

    /* compiled from: setting_id */
    class TransitionSpringListener extends SimpleSpringListener {
        public ReactionsClientInfo f3891a;
        public ReactionsClientInfo f3892b;
        final /* synthetic */ ReactionsVectorDrawable f3893c;

        public TransitionSpringListener(ReactionsVectorDrawable reactionsVectorDrawable) {
            this.f3893c = reactionsVectorDrawable;
        }

        public final void m4527a(Spring spring) {
            ReactionsVectorDrawable.m4535a(this.f3893c, this.f3891a, this.f3892b, (float) spring.d());
            this.f3893c.invalidateSelf();
        }

        public final void m4528b(Spring spring) {
            ReactionsVectorDrawable.m4540f(this.f3893c);
            this.f3893c.invalidateSelf();
        }
    }

    @Inject
    public ReactionsVectorDrawable(Resources resources, SpringSystem springSystem, FbObjectMapper fbObjectMapper, ReactionsAnimationManager reactionsAnimationManager, @Assisted View view, @Assisted String str) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Join.ROUND);
        this.f3899f = paint;
        this.f3910q = reactionsAnimationManager;
        this.f3894a = VectorGraphicConfig.m4607a(fbObjectMapper, resources, str);
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < this.f3894a.mVectorCount; i++) {
            builder.c(new Path());
        }
        this.f3895b = builder.b();
        this.f3896c = resources.getDrawable(2130842937);
        this.f3897d = springSystem.a().a(0.0d).l().a(SpringConfig.b(20.0d, 0.0d));
        this.f3898e = new TransitionSpringListener(this);
        this.f3897d.a(this.f3898e);
        setCallback(view);
        this.f3906m = new C03371(this);
        this.f3905l = MultiWaveAnimator.m19328a(this.f3906m);
    }

    private static float m4530a(AnimationWave animationWave, AnimationWave animationWave2, float f, float f2) {
        return m4529a(animationWave.mRange0 + ((animationWave.mRange1 - animationWave.mRange0) * f), animationWave2.mRange0 + ((animationWave2.mRange1 - animationWave2.mRange0) * f), f2);
    }

    public final void m4542a() {
        MultiWaveAnimator multiWaveAnimator = this.f3905l;
        multiWaveAnimator.mo1187b();
        multiWaveAnimator.mo1186a();
    }

    public final void m4543b() {
        MultiWaveAnimator multiWaveAnimator = this.f3905l;
        multiWaveAnimator.mo1187b();
        multiWaveAnimator.f15321e = 0;
    }

    public static State m4537c(ReactionsVectorDrawable reactionsVectorDrawable) {
        return reactionsVectorDrawable.f3894a.m4610a(reactionsVectorDrawable.f3900g.q);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f3901h = i3 - i;
        this.f3902i = i4 - i2;
        this.f3903j = ((float) this.f3901h) / this.f3894a.mCanvasSize[0];
        this.f3904k = ((float) this.f3902i) / this.f3894a.mCanvasSize[1];
        m4540f(this);
        this.f3896c.setBounds(0, 0, this.f3901h, this.f3902i);
    }

    public void draw(Canvas canvas) {
        this.f3896c.draw(canvas);
        int i = this.f3900g.q;
        canvas.save();
        canvas.rotate(this.f3909p, (((float) (this.f3901h / 2)) + (this.f3907n * this.f3903j)) + ((float) getBounds().left), (((float) (this.f3902i / 2)) + (this.f3908o * this.f3904k)) + ((float) getBounds().top));
        for (int i2 = 0; i2 < this.f3894a.mVectorCount; i2++) {
            Path path = (Path) this.f3895b.get(i2);
            for (Style a : Style.values()) {
                if (m4536a(this.f3899f, a, i2)) {
                    canvas.drawPath(path, this.f3899f);
                }
            }
        }
        canvas.restore();
    }

    private boolean m4536a(Paint paint, Style style, int i) {
        float f = (this.f3903j + this.f3904k) / 2.0f;
        PaintConfig paintConfig;
        if (this.f3897d.k()) {
            paintConfig = (PaintConfig) m4537c(this).mVectorLines[i].f3957a.get(style);
            if (paintConfig == null) {
                return false;
            }
            paint.setStyle(Style.valueOf(paintConfig.mStyle.name()));
            paint.setStrokeCap(Cap.valueOf(paintConfig.mCap));
            paint.setStrokeWidth(((float) paintConfig.mWidth) * f);
            paint.setColor(paintConfig.m4589c());
            return true;
        }
        paintConfig = (PaintConfig) this.f3894a.m4610a(this.f3898e.f3891a.q).mVectorLines[i].f3957a.get(style);
        PaintConfig paintConfig2 = (PaintConfig) this.f3894a.m4610a(this.f3898e.f3892b.q).mVectorLines[i].f3957a.get(style);
        if (paintConfig == null && paintConfig2 == null) {
            return false;
        }
        if (paintConfig != null && paintConfig2 != null) {
            paint.setStyle(Style.valueOf(paintConfig2.mStyle.name()));
            paint.setStrokeCap(Cap.valueOf(paintConfig2.mCap));
            paint.setStrokeWidth(((float) paintConfig2.mWidth) * f);
            if (paintConfig.m4589c() == paintConfig2.m4589c()) {
                paint.setColor(paintConfig2.m4589c());
            } else {
                paint.setColor(m4532a(paintConfig.m4589c(), paintConfig2.m4589c(), this.f3897d.d()));
            }
        } else if (paintConfig == null) {
            paint.setStyle(Style.valueOf(paintConfig2.mStyle.name()));
            paint.setStrokeCap(Cap.valueOf(paintConfig2.mCap));
            paint.setStrokeWidth(((float) paintConfig2.mWidth) * f);
            paint.setColor(m4531a(paintConfig2.m4589c(), this.f3897d.d()));
        } else if (paintConfig2 == null) {
            paint.setStyle(Style.valueOf(paintConfig.mStyle.name()));
            paint.setStrokeCap(Cap.valueOf(paintConfig.mCap));
            paint.setStrokeWidth(((float) paintConfig.mWidth) * f);
            paint.setColor(m4531a(paintConfig.m4589c(), 1.0d - this.f3897d.d()));
        }
        return true;
    }

    private static int m4532a(int i, int i2, double d) {
        int alpha = Color.alpha(i);
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        return ((((alpha + ((int) (((double) (Color.alpha(i2) - alpha)) * d))) << 24) | ((red + ((int) (((double) (Color.red(i2) - red)) * d))) << 16)) | ((((int) (((double) (Color.green(i2) - green)) * d)) + green) << 8)) | (((int) (((double) (Color.blue(i2) - blue)) * d)) + blue);
    }

    private static int m4531a(int i, double d) {
        return ((i << 8) >> 8) | (((int) (255.0d * d)) << 24);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return (int) this.f3894a.mCanvasSize[0];
    }

    public int getIntrinsicHeight() {
        return (int) this.f3894a.mCanvasSize[1];
    }

    private int m4538d() {
        return this.f3901h;
    }

    private int m4539e() {
        return this.f3902i;
    }

    public static void m4540f(ReactionsVectorDrawable reactionsVectorDrawable) {
        reactionsVectorDrawable.m4541g();
        float f = (float) (reactionsVectorDrawable.f3901h / 2);
        float f2 = (float) (reactionsVectorDrawable.f3902i / 2);
        State c = m4537c(reactionsVectorDrawable);
        reactionsVectorDrawable.f3910q.m4622a();
        for (int i = 0; i < reactionsVectorDrawable.f3894a.mVectorCount; i++) {
            VectorLine vectorLine = c.mVectorLines[i];
            reactionsVectorDrawable.m4533a((Path) reactionsVectorDrawable.f3895b.get(i), vectorLine, ((float) reactionsVectorDrawable.getBounds().left) + (((((float) vectorLine.mOffsetX) + reactionsVectorDrawable.f3907n) * reactionsVectorDrawable.f3903j) + f), ((float) reactionsVectorDrawable.getBounds().top) + (((((float) vectorLine.mOffsetY) + reactionsVectorDrawable.f3908o) * reactionsVectorDrawable.f3904k) + f2));
        }
    }

    private void m4533a(Path path, VectorLine vectorLine, float f, float f2) {
        float f3 = (this.f3903j * ((float) vectorLine.fromX)) + f;
        float d = (this.f3904k * ((float) vectorLine.m4598d())) + f2;
        float e = (this.f3903j * ((float) vectorLine.m4599e())) + f;
        float f4 = (this.f3904k * ((float) vectorLine.m4600f())) + f2;
        path.moveTo(f3, d);
        path.cubicTo((this.f3903j * ((float) vectorLine.m4601g())) + f, (this.f3904k * ((float) vectorLine.m4602h())) + f2, (this.f3903j * ((float) vectorLine.m4603i())) + f, (this.f3904k * ((float) vectorLine.m4604j())) + f2, e, f4);
        if (vectorLine.m4606l().containsKey(Style.FILL)) {
            path.lineTo(f3, d);
        }
        if (vectorLine.m4605k() != null) {
            this.f3910q.m4621a(vectorLine.m4605k()).mo183a(path, (f3 + e) / 2.0f, (d + f4) / 2.0f);
        }
    }

    public static void m4535a(ReactionsVectorDrawable reactionsVectorDrawable, ReactionsClientInfo reactionsClientInfo, ReactionsClientInfo reactionsClientInfo2, float f) {
        reactionsVectorDrawable.m4541g();
        float d = (float) (reactionsVectorDrawable.m4538d() / 2);
        float e = (float) (reactionsVectorDrawable.m4539e() / 2);
        State a = reactionsVectorDrawable.f3894a.m4610a(reactionsClientInfo.b());
        State a2 = reactionsVectorDrawable.f3894a.m4610a(reactionsClientInfo2.b());
        reactionsVectorDrawable.f3907n = m4530a(a.m4591b(), a2.m4591b(), reactionsVectorDrawable.f3905l.m19334c(), f);
        reactionsVectorDrawable.f3908o = m4530a(a.m4592c(), a2.m4592c(), reactionsVectorDrawable.f3905l.m19335d(), f);
        reactionsVectorDrawable.f3909p = m4530a(a.m4593d(), a2.m4593d(), reactionsVectorDrawable.f3905l.m19336e(), f);
        reactionsVectorDrawable.f3910q.m4622a();
        for (int i = 0; i < reactionsVectorDrawable.f3894a.m4609a(); i++) {
            ReactionsVectorDrawable reactionsVectorDrawable2 = reactionsVectorDrawable;
            reactionsVectorDrawable2.m4534a((Path) reactionsVectorDrawable.f3895b.get(i), a.m4590a()[i], a2.m4590a()[i], (((float) reactionsVectorDrawable.getBounds().left) + d) + (reactionsVectorDrawable.f3907n * reactionsVectorDrawable.f3903j), (((float) reactionsVectorDrawable.getBounds().top) + e) + (reactionsVectorDrawable.f3908o * reactionsVectorDrawable.f3904k), f);
        }
    }

    private void m4534a(Path path, VectorLine vectorLine, VectorLine vectorLine2, float f, float f2, float f3) {
        float a = m4529a((float) vectorLine.m4597c(), (float) vectorLine2.m4597c(), f3);
        float a2 = m4529a((float) vectorLine.m4598d(), (float) vectorLine2.m4598d(), f3);
        float a3 = m4529a((float) vectorLine.m4601g(), (float) vectorLine2.m4601g(), f3);
        float a4 = m4529a((float) vectorLine.m4602h(), (float) vectorLine2.m4602h(), f3);
        float a5 = m4529a((float) vectorLine.m4603i(), (float) vectorLine2.m4603i(), f3);
        float a6 = m4529a((float) vectorLine.m4604j(), (float) vectorLine2.m4604j(), f3);
        float a7 = m4529a((float) vectorLine.m4599e(), (float) vectorLine2.m4599e(), f3);
        float a8 = (m4529a((float) vectorLine.m4595a(), (float) vectorLine2.m4595a(), f3) * this.f3903j) + f;
        float a9 = (m4529a((float) vectorLine.m4596b(), (float) vectorLine2.m4596b(), f3) * this.f3904k) + f2;
        float f4 = (a * this.f3903j) + a8;
        float f5 = (this.f3904k * a2) + a9;
        a7 = (this.f3903j * a7) + a8;
        float a10 = (this.f3904k * m4529a((float) vectorLine.m4600f(), (float) vectorLine2.m4600f(), f3)) + a9;
        path.moveTo(f4, f5);
        path.cubicTo((this.f3903j * a3) + a8, (this.f3904k * a4) + a9, (this.f3903j * a5) + a8, (this.f3904k * a6) + a9, a7, a10);
        if (vectorLine2.m4606l().containsKey(Style.FILL)) {
            path.lineTo(f4, f5);
        }
        if (vectorLine2.m4605k() != null) {
            this.f3910q.m4621a(vectorLine2.m4605k()).mo183a(path, (f4 + a7) / 2.0f, (f5 + a10) / 2.0f);
        }
    }

    private static float m4529a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    private void m4541g() {
        for (Path reset : this.f3895b) {
            reset.reset();
        }
    }
}
