package com.facebook.feedback.reactions.ui.overlay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil.InputDockAssetType;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockView.FaceConfig;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockView.PointerPosition;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockView.ReactionsExploreByTouchHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.reactionsanimations.ReactionsFaceDrawable;
import com.facebook.reactionsanimations.ReactionsScalingDrawable;
import com.facebook.reactionsanimations.ReactionsScalingDrawable.ScaleDirection;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringChain;
import com.facebook.springs.SpringChain.SpringChainConfig;
import com.facebook.springs.SpringChainProvider;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;

/* compiled from: send_as_message_entry_point */
public class RopeStyleReactionsDockView extends ReactionsDockView {
    @Inject
    SpringChainProvider f4054C;
    @Inject
    SpringSystem f4055D;
    @Inject
    public Lazy<FBSoundUtil> f4056E;
    @Inject
    public ReactionsExperimentUtil f4057F;
    @Inject
    RTLUtil f4058G;
    private final int f4059H;
    private final int f4060I;
    private final Spring f4061J;
    private final Spring f4062K;
    public final AddReactionSpringListener f4063L;
    public ImmutableList<RopeFaceConfig> f4064M;
    public SpringChain f4065N;
    private PointerPosition f4066O;
    private FeedbackReaction f4067P;
    private Path f4068Q;
    private boolean f4069R;

    /* compiled from: send_as_message_entry_point */
    public class AddReactionSpringListener extends SimpleSpringListener {
        public final /* synthetic */ RopeStyleReactionsDockView f4036a;
        public final float[] f4037b = new float[2];
        public RopeFaceConfig f4038c;
        private PathMeasure f4039d;
        public boolean f4040e = false;

        public AddReactionSpringListener(RopeStyleReactionsDockView ropeStyleReactionsDockView) {
            this.f4036a = ropeStyleReactionsDockView;
        }

        public final void m4658a(RopeFaceConfig ropeFaceConfig, Path path) {
            this.f4038c = ropeFaceConfig;
            this.f4039d = new PathMeasure(path, false);
        }

        public final void m4659a(Spring spring) {
            if (this.f4039d != null) {
                if (!this.f4040e && spring.d() > 0.7d) {
                    this.f4040e = true;
                    ((FBSoundUtil) this.f4036a.f4056E.get()).b("reactions_like_down");
                }
                this.f4039d.getPosTan(this.f4039d.getLength() * ((float) spring.d()), this.f4037b, null);
                this.f4036a.invalidate();
            }
        }

        public final void m4660b(Spring spring) {
            this.f4040e = false;
        }
    }

    /* compiled from: send_as_message_entry_point */
    class DockBackgroundSpringListener extends SimpleSpringListener {
        final /* synthetic */ RopeStyleReactionsDockView f4041a;

        public DockBackgroundSpringListener(RopeStyleReactionsDockView ropeStyleReactionsDockView) {
            this.f4041a = ropeStyleReactionsDockView;
        }

        public final void m4661a(Spring spring) {
            int d = this.f4041a.f4011v + ((int) (((double) (this.f4041a.f4012w - this.f4041a.f4011v)) * spring.d()));
            int d2 = ((int) (((double) (this.f4041a.f4013x - this.f4041a.f4014y)) * (1.0d - spring.d()))) + this.f4041a.f4014y;
            int width = (this.f4041a.getWidth() - d) / 2;
            Drawable drawable = this.f4041a.f3984E;
            Rect bounds = drawable.getBounds();
            int i = bounds.top;
            d = bounds.bottom;
            if (this.f4041a.m4641a()) {
                i = d - d2;
            } else {
                d = i + d2;
            }
            drawable.setBounds(width, i, this.f4041a.getWidth() - width, d);
            this.f4041a.invalidate();
        }
    }

    /* compiled from: send_as_message_entry_point */
    class FaceAnimationSpringListener extends SimpleSpringListener {
        final /* synthetic */ RopeStyleReactionsDockView f4042a;
        private final RopeFaceConfig f4043b;

        public FaceAnimationSpringListener(RopeStyleReactionsDockView ropeStyleReactionsDockView, RopeFaceConfig ropeFaceConfig) {
            this.f4042a = ropeStyleReactionsDockView;
            this.f4043b = ropeFaceConfig;
        }

        public final void m4662a(Spring spring) {
            float f = ((float) this.f4042a.f4007r) / 2.0f;
            int height = this.f4042a.getHeight();
            float f2 = ((float) height) - (((float) this.f4042a.f4000k) / 2.0f);
            f = ((f + ((float) this.f4042a.f4008s)) + ((float) this.f4042a.f4010u)) + ((float) this.f4042a.f4006q.top);
            if (!this.f4042a.m4641a()) {
                f2 = ((float) height) - f2;
                f = ((float) height) - f;
            }
            f = ((f - f2) * ((float) spring.d())) + f2;
            RopeFaceConfig ropeFaceConfig = this.f4043b;
            float d = (float) spring.d();
            ropeFaceConfig.f4049e = f;
            ropeFaceConfig.f4050f = d;
            this.f4043b.f3975d.setAlpha(Math.min((int) (255.0d * spring.d()), 255));
            this.f4042a.invalidate();
        }

        public final void m4663b(Spring spring) {
            int i = 0;
            int i2;
            if (this.f4042a.f4058G.a()) {
                i2 = 0;
            } else {
                i2 = this.f4042a.f4064M.size() - 1;
            }
            if (this.f4042a.f3986G != null && this.f4043b.f3973b == r0 && spring.g(0.0d)) {
                if (RopeStyleReactionsDockView.m4675g(this.f4042a)) {
                    int size = this.f4042a.f4064M.size();
                    while (i < size) {
                        RopeFaceConfig ropeFaceConfig = (RopeFaceConfig) this.f4042a.f4064M.get(i);
                        if (ropeFaceConfig.f3975d instanceof ReactionsFaceDrawable) {
                            ((ReactionsFaceDrawable) ropeFaceConfig.f3975d).m18272b();
                        }
                        i++;
                    }
                }
                this.f4042a.f3986G.c();
                this.f4042a.f4063L.m4658a(null, null);
            }
        }
    }

    /* compiled from: send_as_message_entry_point */
    class FaceSelectionSpringListener extends SimpleSpringListener {
        final /* synthetic */ RopeStyleReactionsDockView f4044a;
        private final RopeFaceConfig f4045b;

        public FaceSelectionSpringListener(RopeStyleReactionsDockView ropeStyleReactionsDockView, RopeFaceConfig ropeFaceConfig) {
            this.f4044a = ropeStyleReactionsDockView;
            this.f4045b = ropeFaceConfig;
        }

        public final void m4664a(Spring spring) {
            this.f4045b.f4051g = (float) spring.d();
            this.f4044a.invalidate();
        }
    }

    /* compiled from: send_as_message_entry_point */
    public class RopeFaceConfig extends FaceConfig {
        final /* synthetic */ RopeStyleReactionsDockView f4046b;
        public final Spring f4047c;
        private final FaceAnimationSpringListener f4048d;
        public float f4049e;
        public float f4050f;
        public float f4051g;
        public float f4052h;
        private boolean f4053i;

        public RopeFaceConfig(RopeStyleReactionsDockView ropeStyleReactionsDockView, int i, FeedbackReaction feedbackReaction) {
            this.f4046b = ropeStyleReactionsDockView;
            super(ropeStyleReactionsDockView, i, feedbackReaction);
            this.f4047c = ropeStyleReactionsDockView.f4055D.a().a(SpringConfig.b(15.0d, 5.0d)).a(new FaceSelectionSpringListener(ropeStyleReactionsDockView, this)).a((double) ropeStyleReactionsDockView.f3980A).l();
            this.f4048d = new FaceAnimationSpringListener(ropeStyleReactionsDockView, this);
            SpringChain springChain = ropeStyleReactionsDockView.f4065N;
            FaceAnimationSpringListener faceAnimationSpringListener = this.f4048d;
            springChain.c.add(springChain.a.a().a(springChain).a(springChain.f));
            springChain.b.add(faceAnimationSpringListener);
            this.f3975d.setBounds(0, 0, ropeStyleReactionsDockView.f4007r, ropeStyleReactionsDockView.f4007r);
        }

        public final float m4666g() {
            return this.f4049e;
        }

        public final float m4667h() {
            return this.f4050f;
        }

        public final void m4665b(boolean z) {
            if (this.f4053i != z) {
                if (z) {
                    this.f4046b.performHapticFeedback(3);
                    RopeStyleReactionsDockView ropeStyleReactionsDockView = this.f4046b;
                    int i = this.f3973b;
                    if (i >= 0) {
                        ((FBSoundUtil) ropeStyleReactionsDockView.f4056E.get()).b("reactions_dock_select_" + Math.min(i + 1, 6));
                    }
                }
                if ((this.f4046b.f4057F.j() == InputDockAssetType.VECTOR_ANIMATED_SELECTED ? 1 : null) != null && (this.f3975d instanceof ReactionsFaceDrawable)) {
                    if (z) {
                        ((ReactionsFaceDrawable) this.f3975d).m18269a();
                    } else {
                        ((ReactionsFaceDrawable) this.f3975d).m18272b();
                    }
                }
                this.f4053i = z;
            }
        }

        public final float m4668i() {
            return this.f4046b.f4015z + ((2.25f - this.f4046b.f4015z) * this.f4051g);
        }

        public final float m4669j() {
            return this.f4046b.f4015z + ((this.f4046b.f3981B - this.f4046b.f4015z) * this.f4051g);
        }

        public final float m4670k() {
            return this.f4052h;
        }
    }

    public static void m4674a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RopeStyleReactionsDockView) obj).m4673a((SpringChainProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SpringChainProvider.class), SpringSystem.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 10994), ReactionsExperimentUtil.a(fbInjector), RTLUtil.a(fbInjector));
    }

    public RopeStyleReactionsDockView(Context context) {
        this(context, null);
    }

    private RopeStyleReactionsDockView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private RopeStyleReactionsDockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4066O = PointerPosition.UNKNOWN;
        Class cls = RopeStyleReactionsDockView.class;
        m4674a((Object) this, getContext());
        Resources resources = context.getResources();
        this.f4059H = resources.getDimensionPixelSize(2131430642);
        this.f4060I = resources.getDimensionPixelSize(2131430643);
        Spring a = this.f4055D.a().a(SpringConfig.b(15.0d, 5.0d));
        a.c = true;
        this.f4061J = a.a(0.0d).l().a(new DockBackgroundSpringListener(this));
        this.f4063L = new AddReactionSpringListener(this);
        a = this.f4055D.a().a(SpringConfig.a(20.0d, 15.0d));
        a.c = true;
        this.f4062K = a.a(0.0d).l().a(this.f4063L);
        setFocusable(true);
        ViewCompat.a(this, new ReactionsExploreByTouchHelper(this, this));
        if (this.f4057F.j() == InputDockAssetType.VECTOR_STATIC || this.f4057F.k()) {
            setLayerType(1, null);
        }
    }

    protected void setupReactionsImpl(List<FeedbackReaction> list) {
        int i;
        if (this.f4064M != null && list.size() == this.f4064M.size()) {
            Object obj;
            int size = this.f4064M.size();
            for (i = 0; i < size; i++) {
                if (((RopeFaceConfig) this.f4064M.get(i)).f3974c != list.get(i)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                return;
            }
        }
        this.f4065N = new SpringChain(SpringSystem.b(this.f4054C), new SpringChainConfig(SpringConfig.b(20.0d, 5.0d), SpringConfig.b(30.0d, 5.0d)));
        Builder builder = ImmutableList.builder();
        int size2 = list.size();
        for (i = 0; i < size2; i++) {
            builder.c(new RopeFaceConfig(this, i, (FeedbackReaction) list.get(i)));
        }
        this.f4064M = builder.b();
        this.f4065N.a(this.f4058G.a() ? this.f4064M.size() - 1 : 0);
    }

    protected final void mo186a(float f, float f2) {
        float height;
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        float f3 = (float) (((iArr[0] + this.f4008s) + this.f3984E.getBounds().left) + this.f4006q.left);
        float f4 = m4641a() ? (float) iArr[1] : (float) (iArr[1] - this.f4004o);
        if (m4641a()) {
            height = (float) ((iArr[1] + getHeight()) + this.f4004o);
        } else {
            height = (float) (iArr[1] + getHeight());
        }
        int size = this.f4064M.size();
        int i = 0;
        float f5 = f3;
        boolean z = false;
        while (i < size) {
            boolean z2;
            RopeFaceConfig ropeFaceConfig = (RopeFaceConfig) this.f4064M.get(i);
            float i2 = (ropeFaceConfig.m4668i() * ((float) this.f4007r)) + ((float) this.f4009t);
            if (z || f < f5 - ((float) this.f4009t) || f >= f5 + i2 || f2 < f4 || f2 > height) {
                ropeFaceConfig.m4665b(false);
                if (f < f5 - ((float) this.f4009t)) {
                    this.f4066O = PointerPosition.LEFT;
                }
                if (f > f5 + i2) {
                    this.f4066O = PointerPosition.RIGHT;
                }
                if (f2 < f4) {
                    this.f4066O = PointerPosition.ABOVE;
                }
                if (f2 > height) {
                    this.f4066O = PointerPosition.BELOW;
                }
                z2 = z;
            } else {
                ropeFaceConfig.m4665b(true);
                this.f4061J.b(1.0d);
                this.f4067P = ropeFaceConfig.m4629b();
                z2 = true;
            }
            f5 += i2;
            i++;
            z = z2;
        }
        if (z) {
            this.f4066O = PointerPosition.OVER;
        } else {
            this.f4061J.b(0.0d);
            this.f4067P = FeedbackReaction.c;
        }
        setScaleForAllFaces(z);
    }

    public final void mo188c() {
        this.f4067P = FeedbackReaction.c;
        this.f4066O = PointerPosition.UNKNOWN;
        int size = this.f4064M.size();
        for (int i = 0; i < size; i++) {
            ((RopeFaceConfig) this.f4064M.get(i)).m4665b(false);
        }
        setScaleForAllFaces(false);
    }

    public PointerPosition getPointerPosition() {
        return this.f4066O;
    }

    public FeedbackReaction getCurrentReaction() {
        return this.f4067P;
    }

    public final boolean mo187b(MotionEvent motionEvent) {
        PointerPosition pointerPosition;
        int rawX = (int) (motionEvent.getRawX() + 0.5f);
        int rawY = (int) (motionEvent.getRawY() + 0.5f);
        int[] iArr = new int[2];
        Rect rect = new Rect(this.f3984E.getBounds());
        getLocationOnScreen(iArr);
        int i = this.f3995f + this.f4000k;
        rect.left += iArr[0];
        rect.right += iArr[0];
        rect.top += iArr[1];
        rect.bottom = iArr[1] + rect.bottom;
        if (m4641a()) {
            rect.bottom += i;
        } else {
            rect.top -= i;
        }
        if (rawX < rect.left) {
            pointerPosition = PointerPosition.LEFT;
        } else if (rawX > rect.right) {
            pointerPosition = PointerPosition.RIGHT;
        } else if (rawY < rect.top) {
            pointerPosition = PointerPosition.ABOVE;
        } else if (rawY > rect.bottom) {
            pointerPosition = PointerPosition.BELOW;
        } else {
            pointerPosition = PointerPosition.OVER;
        }
        this.f4066O = pointerPosition;
        return rect.contains(rawX, rawY);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = ((this.f4013x + this.f3995f) + this.f4000k) + this.f4010u;
        setMeasuredDimension(this.f4012w, i3);
        int i4 = (this.f4012w - this.f4011v) / 2;
        if (m4641a()) {
            this.f3984E.setBounds(i4, this.f4010u, getMeasuredWidth() - i4, this.f4010u + this.f4013x);
        } else {
            this.f3984E.setBounds(i4, (i3 - this.f4013x) - this.f4010u, getMeasuredWidth() - i4, i3 - this.f4010u);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m4671a(canvas);
        float f = ((float) this.f4007r) / 2.0f;
        float f2 = (float) ((getBackgroundDrawable().getBounds().left + this.f4006q.left) + this.f4008s);
        int size = this.f4064M.size();
        for (int i = 0; i < size; i++) {
            float f3;
            float f4;
            RopeFaceConfig ropeFaceConfig = (RopeFaceConfig) this.f4064M.get(i);
            float i2 = ropeFaceConfig.m4668i();
            float f5 = (i2 - 1.0f) * ((float) this.f4007r);
            float f6 = 0.0f;
            if (this.f4063L.f4038c == ropeFaceConfig) {
                f6 = (f + f2) - this.f4063L.f4037b[0];
                f3 = f2 - f6;
                f2 = this.f4063L.f4037b[1] - f;
            } else {
                f3 = (f5 / 2.0f) + f2;
                f2 = ropeFaceConfig.m4666g() - f;
            }
            canvas.save();
            canvas.translate(f3, f2);
            if (i2 > 1.0f && f6 == 0.0f) {
                m4672a(canvas, ropeFaceConfig);
            }
            ReactionsScalingDrawable reactionsScalingDrawable;
            float d;
            if (f6 != 0.0f) {
                if (ropeFaceConfig.m4630c() instanceof ReactionsScalingDrawable) {
                    ScaleDirection scaleDirection;
                    reactionsScalingDrawable = (ReactionsScalingDrawable) ropeFaceConfig.m4630c();
                    d = (1.0f - ((float) this.f4062K.d())) * i2;
                    if (m4641a()) {
                        scaleDirection = ScaleDirection.UP;
                    } else {
                        scaleDirection = ScaleDirection.DOWN;
                    }
                    reactionsScalingDrawable.mo1143a(1.0f, d, scaleDirection);
                } else {
                    canvas.scale((1.0f - ((float) this.f4062K.d())) * i2, i2 * (1.0f - ((float) this.f4062K.d())), f, f);
                }
                ropeFaceConfig.m4630c().setAlpha((int) (255.0f * (1.0f - ((float) this.f4062K.d()))));
            } else {
                i2 = ropeFaceConfig.m4632f() ? ropeFaceConfig.m4669j() : ropeFaceConfig.m4668i();
                if (ropeFaceConfig.m4630c() instanceof ReactionsScalingDrawable) {
                    ScaleDirection scaleDirection2;
                    reactionsScalingDrawable = (ReactionsScalingDrawable) ropeFaceConfig.m4630c();
                    d = ropeFaceConfig.m4667h();
                    if (m4641a()) {
                        scaleDirection2 = ScaleDirection.UP;
                    } else {
                        scaleDirection2 = ScaleDirection.DOWN;
                    }
                    reactionsScalingDrawable.mo1143a(d, i2, scaleDirection2);
                } else {
                    canvas.scale(ropeFaceConfig.m4667h(), ropeFaceConfig.m4667h(), f, f);
                    canvas.scale(i2, i2, f, m4641a() ? ((float) this.f4007r) * ropeFaceConfig.m4667h() : 0.0f);
                }
                ropeFaceConfig.f4052h = (((float) this.f4007r) / 2.0f) + f3;
            }
            ropeFaceConfig.m4630c().draw(canvas);
            canvas.restore();
            f2 = ((((float) this.f4007r) + (f5 / 2.0f)) + ((float) this.f4009t)) + f6;
            if (f6 == 0.0f) {
                f4 = 0.0f;
            } else {
                f4 = f5 / 2.0f;
            }
            f2 = f3 + (f4 + f2);
        }
    }

    private void m4672a(Canvas canvas, RopeFaceConfig ropeFaceConfig) {
        canvas.save();
        float j = ropeFaceConfig.m4669j();
        float f = (j - 1.0f) * ((float) this.f4007r);
        float f2 = ropeFaceConfig.f3977f + ((float) (this.f4002m * 4));
        int i = this.f4001l + (this.f4002m * 2);
        float f3 = (j - 1.0f) / 1.25f;
        if (m4641a()) {
            j = ((float) ((-this.f4003n) - i)) - f;
        } else {
            j = (((float) this.f4007r) + f) + ((float) this.f4003n);
        }
        canvas.translate((((float) this.f4007r) - f2) / 2.0f, j);
        int a = (int) (SpringUtil.a((double) f3, 0.0d, 1.0d) * 255.0d);
        this.f3993d.setAlpha(a);
        this.f3993d.setBounds(0, 0, (int) (0.5f + f2), i);
        canvas.scale(f3, f3, f2 / 2.0f, m4641a() ? ((float) this.f4007r) * ropeFaceConfig.m4667h() : 0.0f);
        this.f3993d.draw(canvas);
        j = ((((float) i) / 2.0f) + ((this.f3994e.descent() - this.f3994e.ascent()) / 2.0f)) - this.f3994e.descent();
        canvas.translate((float) (this.f4002m * 2), 0.0f);
        this.f3994e.setAlpha(a);
        canvas.drawText(ropeFaceConfig.m4631d(), 0.0f, j, this.f3994e);
        canvas.restore();
    }

    private void m4671a(Canvas canvas) {
        float f;
        Drawable drawable = this.f3984E;
        if (m4641a()) {
            f = (((RopeFaceConfig) this.f4064M.get(this.f4065N.d)).f4049e - ((float) drawable.getBounds().bottom)) + (((float) this.f4013x) / 2.0f);
        } else {
            f = ((((float) this.f4013x) / 2.0f) + ((float) drawable.getBounds().top)) - ((RopeFaceConfig) this.f4064M.get(this.f4065N.d)).f4049e;
        }
        drawable.setAlpha((int) (SpringUtil.a(this.f4065N.b().d(), 0.0d, 1.0d) * 255.0d));
        canvas.translate(0.0f, f);
        drawable.draw(canvas);
        canvas.translate(0.0f, -f);
    }

    public final void mo189d() {
        int i = 0;
        this.f4067P = FeedbackReaction.c;
        this.f4066O = PointerPosition.UNKNOWN;
        this.f4069R = false;
        for (Spring spring : this.f4065N.c) {
            spring.c = false;
        }
        this.f4065N.b().b(1.0d);
        ((FBSoundUtil) this.f4056E.get()).b("reactions_dock_appear");
        if (m4675g(this)) {
            int size = this.f4064M.size();
            while (i < size) {
                RopeFaceConfig ropeFaceConfig = (RopeFaceConfig) this.f4064M.get(i);
                if (ropeFaceConfig.f3975d instanceof ReactionsFaceDrawable) {
                    ((ReactionsFaceDrawable) ropeFaceConfig.f3975d).m18269a();
                }
                i++;
            }
        }
    }

    public final void mo190e() {
        if (!this.f4069R) {
            this.f4069R = true;
            for (Spring spring : this.f4065N.c) {
                spring.c = true;
            }
            this.f4065N.b().b(0.0d);
            this.f4061J.b(0.0d);
            int size = this.f4064M.size();
            for (int i = 0; i < size; i++) {
                RopeFaceConfig ropeFaceConfig = (RopeFaceConfig) this.f4064M.get(i);
                if (this.f4067P != FeedbackReaction.c && ropeFaceConfig.m4629b() == this.f4067P) {
                    int i2;
                    float f;
                    this.f4062K.a(0.0d).l();
                    this.f4068Q = new Path();
                    float i3 = ((ropeFaceConfig.m4668i() - 1.0f) * ((float) this.f4007r)) / 2.0f;
                    Path path = this.f4068Q;
                    float k = ropeFaceConfig.m4670k();
                    float g = ropeFaceConfig.m4666g();
                    if (m4641a()) {
                        i2 = -1;
                    } else {
                        i2 = 1;
                    }
                    path.moveTo(k, (((float) i2) * i3) + g);
                    float f2 = ((float) this.f4059H) + i3;
                    if (this.f4058G.a()) {
                        f2 = ((float) getWidth()) - f2;
                    }
                    i3 = m4641a() ? (float) (getHeight() - this.f4060I) : (float) this.f4060I;
                    Path path2 = this.f4068Q;
                    g = (ropeFaceConfig.m4670k() + f2) / 2.0f;
                    if (m4641a()) {
                        f = (float) (-this.f4060I);
                    } else {
                        f = (float) (getHeight() + this.f4060I);
                    }
                    path2.quadTo(g, f, f2, i3);
                    this.f4063L.m4658a(ropeFaceConfig, this.f4068Q);
                    this.f4062K.b(1.0d);
                }
                ropeFaceConfig.m4665b(false);
            }
            setScaleForAllFaces(false);
        }
    }

    public final boolean mo191f() {
        return this.f4069R;
    }

    protected ImmutableList<? extends FaceConfig> getFaceConfigs() {
        return this.f4064M;
    }

    protected final Rect mo185a(int i) {
        float f = (float) ((this.f4008s + this.f3984E.getBounds().left) + this.f4006q.left);
        float i2 = ((float) this.f4009t) + (((RopeFaceConfig) this.f4064M.get(i)).m4668i() * ((float) this.f4007r));
        float f2 = ((RopeFaceConfig) this.f4064M.get(i)).f4049e;
        f += ((float) i) * i2;
        return new Rect((int) (f - ((float) this.f4009t)), (int) (f2 - (i2 / 2.0f)), (int) (f + i2), (int) (f2 + (i2 / 2.0f)));
    }

    private void setScaleForAllFaces(boolean z) {
        int size = this.f4064M.size();
        for (int i = 0; i < size; i++) {
            RopeFaceConfig ropeFaceConfig = (RopeFaceConfig) this.f4064M.get(i);
            float f = this.f3980A;
            if (z) {
                if (ropeFaceConfig.f3974c == this.f4067P) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
            }
            ropeFaceConfig.f4047c.b((double) f);
        }
    }

    private void m4673a(SpringChainProvider springChainProvider, SpringSystem springSystem, Lazy<FBSoundUtil> lazy, ReactionsExperimentUtil reactionsExperimentUtil, RTLUtil rTLUtil) {
        this.f4054C = springChainProvider;
        this.f4055D = springSystem;
        this.f4056E = lazy;
        this.f4057F = reactionsExperimentUtil;
        this.f4058G = rTLUtil;
    }

    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable)) {
            Object obj;
            int size = this.f4064M.size();
            for (int i = 0; i < size; i++) {
                if (((RopeFaceConfig) this.f4064M.get(i)).f3975d == drawable) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            invalidate();
        }
    }

    public static boolean m4675g(RopeStyleReactionsDockView ropeStyleReactionsDockView) {
        return ropeStyleReactionsDockView.f4057F.j() == InputDockAssetType.VECTOR_ANIMATED_ALWAYS;
    }
}
