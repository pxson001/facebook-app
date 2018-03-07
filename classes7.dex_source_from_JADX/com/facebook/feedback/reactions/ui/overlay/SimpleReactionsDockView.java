package com.facebook.feedback.reactions.ui.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockView.FaceConfig;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockView.PointerPosition;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockView.ReactionsExploreByTouchHelper;
import com.facebook.inject.FbInjector;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;

/* compiled from: send_as_message */
public class SimpleReactionsDockView extends ReactionsDockView {
    @Inject
    public SpringSystem f4071C;
    private final int f4072D;
    private final Spring f4073E;
    private final int f4074F;
    private final Rect f4075G;
    private final int[] f4076H;
    private ImmutableList<FaceConfig> f4077I;
    public float f4078J;
    private boolean f4079K;
    private FeedbackReaction f4080L;
    private PointerPosition f4081M;

    /* compiled from: send_as_message */
    class AnimationSpring extends SimpleSpringListener {
        final /* synthetic */ SimpleReactionsDockView f4070a;

        public AnimationSpring(SimpleReactionsDockView simpleReactionsDockView) {
            this.f4070a = simpleReactionsDockView;
        }

        public final void m4683a(Spring spring) {
            this.f4070a.f4078J = (float) spring.d();
            this.f4070a.invalidate();
        }

        public final void m4684b(Spring spring) {
            if (spring.g(0.0d)) {
                this.f4070a.f3986G.c();
            }
        }
    }

    public static void m4686a(Object obj, Context context) {
        ((SimpleReactionsDockView) obj).f4071C = SpringSystem.b(FbInjector.get(context));
    }

    public SimpleReactionsDockView(Context context) {
        this(context, null);
    }

    private SimpleReactionsDockView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private SimpleReactionsDockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4075G = new Rect();
        this.f4076H = new int[2];
        this.f4080L = FeedbackReaction.c;
        this.f4081M = PointerPosition.UNKNOWN;
        Class cls = SimpleReactionsDockView.class;
        m4686a((Object) this, getContext());
        this.f4072D = getResources().getDimensionPixelSize(2131430637);
        this.f4073E = this.f4071C.a().a(SpringConfig.b(45.0d, 5.0d)).a(0.0d).l().a(new AnimationSpring(this));
        this.f4074F = (this.f4001l + this.f4003n) + (this.f4002m * 2);
        ViewCompat.a(this, new ReactionsExploreByTouchHelper(this, this));
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f4011v, ((this.f4074F + this.f4013x) + this.f3995f) + this.f4000k);
        this.f3984E.setBounds(0, 0, getMeasuredWidth(), this.f4013x);
    }

    protected void setupReactionsImpl(List<FeedbackReaction> list) {
        int i;
        int i2;
        int i3 = 0;
        if (this.f4077I != null && list.size() == this.f4077I.size()) {
            int size = this.f4077I.size();
            for (i = 0; i < size; i++) {
                if (((FaceConfig) this.f4077I.get(i)).f3974c != list.get(i)) {
                    i2 = 1;
                    break;
                }
            }
            i2 = 0;
            if (i2 == 0) {
                return;
            }
        }
        Builder builder = ImmutableList.builder();
        int i4 = this.f4006q.top + this.f4008s;
        i2 = this.f4006q.left + this.f4008s;
        int size2 = list.size();
        i = i2;
        while (i3 < size2) {
            FaceConfig faceConfig = new FaceConfig(this, i3, (FeedbackReaction) list.get(i3));
            faceConfig.f3975d.setBounds(i, i4, this.f4007r + i, this.f4007r + i4);
            builder.c(faceConfig);
            i += this.f4007r + this.f4009t;
            i3++;
        }
        this.f4077I = builder.b();
    }

    public void onDraw(Canvas canvas) {
        float f;
        float f2 = ((float) this.f4072D) + (this.f4078J * ((float) (-this.f4072D)));
        int a = (int) (SpringUtil.a((double) this.f4078J, 0.0d, 1.0d) * 255.0d);
        if (m4641a()) {
            canvas.translate(0.0f, (float) this.f4074F);
            f = f2;
        } else {
            float f3 = -1.0f * f2;
            canvas.translate(0.0f, (float) ((getMeasuredHeight() - this.f4013x) - this.f4074F));
            f = f3;
        }
        canvas.translate(0.0f, f);
        this.f3984E.setAlpha(a);
        this.f3984E.draw(canvas);
        int size = this.f4077I.size();
        for (int i = 0; i < size; i++) {
            FaceConfig faceConfig = (FaceConfig) this.f4077I.get(i);
            faceConfig.f3975d.setAlpha(a);
            faceConfig.f3975d.draw(canvas);
            if (faceConfig.f3978g) {
                m4685a(canvas, faceConfig);
            }
        }
        canvas.translate(0.0f, -f);
        if (!m4641a()) {
            canvas.translate(0.0f, (float) ((-getMeasuredHeight()) + this.f4013x));
        }
    }

    private void m4685a(Canvas canvas, FaceConfig faceConfig) {
        Rect bounds = faceConfig.f3975d.getBounds();
        float f = ((float) bounds.left) + (((float) this.f4007r) / 2.0f);
        float f2 = m4641a() ? (float) (((bounds.top - this.f4003n) - this.f4002m) - (this.f4001l / 2)) : (float) (((bounds.bottom + this.f4003n) + this.f4002m) + (this.f4001l / 2));
        this.f3993d.setBounds((int) ((f - (faceConfig.f3977f / 2.0f)) - ((float) this.f4002m)), (int) ((f2 - (((float) this.f4001l) / 2.0f)) - ((float) this.f4002m)), (int) (((faceConfig.f3977f / 2.0f) + f) + ((float) this.f4002m)), (int) (((((float) this.f4001l) / 2.0f) + f2) + ((float) this.f4002m)));
        this.f3993d.draw(canvas);
        canvas.drawText(faceConfig.f3976e, f - (faceConfig.f3977f / 2.0f), (f2 + ((this.f3994e.descent() - this.f3994e.ascent()) / 2.0f)) - this.f3994e.descent(), this.f3994e);
    }

    protected final void mo186a(float f, float f2) {
        Rect rect = this.f4075G;
        int[] iArr = this.f4076H;
        getHitRect(rect);
        getLocationOnScreen(iArr);
        rect.offset(iArr[0], iArr[1]);
        this.f4081M = PointerPosition.UNKNOWN;
        if (f2 < ((float) rect.top)) {
            this.f4081M = PointerPosition.ABOVE;
        } else if (f2 > ((float) rect.bottom)) {
            this.f4081M = PointerPosition.BELOW;
        } else if (f < ((float) rect.left)) {
            this.f4081M = PointerPosition.LEFT;
        } else if (f > ((float) rect.right)) {
            this.f4081M = PointerPosition.RIGHT;
        }
        if (this.f4081M != PointerPosition.UNKNOWN) {
            this.f4080L = FeedbackReaction.c;
            int size = this.f4077I.size();
            for (int i = 0; i < size; i++) {
                ((FaceConfig) this.f4077I.get(i)).m4628a(false);
            }
            return;
        }
        float f3 = (float) (this.f4007r + this.f4009t);
        int i2 = ((rect.left + this.f4006q.left) + this.f4008s) - (this.f4009t / 2);
        int size2 = this.f4077I.size();
        int i3 = 0;
        boolean z = false;
        while (i3 < size2) {
            boolean z2;
            FaceConfig faceConfig = (FaceConfig) this.f4077I.get(i3);
            if (z || f <= ((float) i2) + (((float) i3) * f3) || f > ((float) i2) + (((float) (i3 + 1)) * f3)) {
                faceConfig.m4628a(false);
                z2 = z;
            } else {
                this.f4080L = faceConfig.f3974c;
                faceConfig.m4628a(true);
                this.f4081M = PointerPosition.OVER;
                z2 = true;
            }
            i3++;
            z = z2;
        }
        if (!z) {
            this.f4080L = FeedbackReaction.c;
            this.f4081M = PointerPosition.UNKNOWN;
        }
    }

    public final void mo188c() {
        this.f4080L = FeedbackReaction.c;
        this.f4081M = PointerPosition.UNKNOWN;
        int size = this.f4077I.size();
        for (int i = 0; i < size; i++) {
            ((FaceConfig) this.f4077I.get(i)).m4628a(false);
        }
    }

    public PointerPosition getPointerPosition() {
        return this.f4081M;
    }

    public FeedbackReaction getCurrentReaction() {
        return this.f4080L;
    }

    public final boolean mo187b(MotionEvent motionEvent) {
        getHitRect(this.f4075G);
        return this.f4075G.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    protected final void mo189d() {
        this.f4073E.b(1.0d);
        this.f4079K = false;
        mo188c();
    }

    public final void mo190e() {
        if (!this.f4079K) {
            this.f4073E.b(0.0d);
            this.f4079K = true;
        }
    }

    public final boolean mo191f() {
        return this.f4079K;
    }

    protected ImmutableList<? extends FaceConfig> getFaceConfigs() {
        return this.f4077I;
    }

    protected final Rect mo185a(int i) {
        int measuredHeight = m4641a() ? 0 : getMeasuredHeight() - this.f4013x;
        int i2 = (this.f4006q.left + this.f4008s) + ((this.f4007r + this.f4009t) * i);
        return new Rect(i2, measuredHeight, this.f4007r + i2, this.f4013x + measuredHeight);
    }
}
