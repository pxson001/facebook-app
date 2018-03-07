package com.facebook.facecastdisplay.streamingreactions;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.auth.annotations.ViewerContextUserId;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.SparseArrayUtil;
import com.facebook.facecastdisplay.streamingreactions.StreamingReactionsController.OnStreamingReactionsToggledListener;
import com.facebook.facecastdisplay.streamingreactions.StreamingReactionsFireworksView.LiveReactionsFireworksViewListener;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomFrameLayout;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: start should be called before calling getVersion() */
public class StreamingReactionsView extends CustomFrameLayout implements OnStreamingReactionsToggledListener, StreamingReactionsModelListener {
    private static final String[] f3408h = new String[]{"1055790620", "655436164", "630379738", "100001500408498", "567878735", "1940736"};
    private final AccelerateInterpolator f3409A;
    private final AccelerateDecelerateInterpolator f3410B;
    private final LinearInterpolator f3411C;
    private final Rect f3412D;
    @Nullable
    private StreamingReactionsModel f3413E;
    @Nullable
    public StreamingReactionsDebugView f3414F;
    @Nullable
    private String f3415G;
    @Nullable
    private String f3416H;
    private boolean f3417I;
    private int f3418J;
    private boolean f3419K;
    @Inject
    FeedbackReactionsController f3420a;
    @Inject
    Lazy<LiveStreamingReactionsModel> f3421b;
    @Inject
    Lazy<VodStreamingReactionsModel> f3422c;
    @Inject
    @ViewerContextUserId
    String f3423d;
    @Inject
    QeAccessor f3424e;
    @Inject
    GatekeeperStoreImpl f3425f;
    @Inject
    StreamingReactionsController f3426g;
    private final int f3427i;
    private final int f3428j;
    private final int f3429k;
    private final int f3430l;
    private final int f3431m;
    private final float f3432n;
    private final float f3433o;
    private final int f3434p;
    private final StreamingReactionsFireworksView f3435q;
    @Nullable
    private final Paint f3436r;
    private final int f3437s;
    private final int f3438t;
    private final int f3439u;
    private final Random f3440v;
    private final List<FeedbackReaction> f3441w;
    public final List<ReactionViewHolder> f3442x;
    private final Queue<SoftReference<ReactionViewHolder>> f3443y;
    private final Interpolator f3444z;

    /* compiled from: start should be called before calling getVersion() */
    class C02951 implements OnClickListener {
        final /* synthetic */ StreamingReactionsView f3393a;

        C02951(StreamingReactionsView streamingReactionsView) {
            this.f3393a = streamingReactionsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 748195938);
            this.f3393a.removeView(this.f3393a.f3414F);
            this.f3393a.f3414F = null;
            Logger.a(2, EntryType.UI_INPUT_END, 269171866, a);
        }
    }

    /* compiled from: start should be called before calling getVersion() */
    class ReactionViewHolder implements LiveReactionsFireworksViewListener {
        public final FacecastReactionView f3398a;
        public final AnimatorSet f3399b;
        public final ObjectAnimator f3400c;
        public final ObjectAnimator f3401d;
        public final ObjectAnimator f3402e;
        public final AnimatorSet f3403f;
        public final ObjectAnimator f3404g;
        public final AnimatorSet f3405h;
        public final ObjectAnimator f3406i;
        public int f3407j;

        public ReactionViewHolder(FacecastReactionView facecastReactionView, ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2, ObjectAnimator objectAnimator3, AnimatorSet animatorSet, ObjectAnimator objectAnimator4, AnimatorSet animatorSet2, AnimatorSet animatorSet3, ObjectAnimator objectAnimator5) {
            this.f3398a = facecastReactionView;
            this.f3399b = animatorSet2;
            this.f3400c = objectAnimator;
            this.f3401d = objectAnimator2;
            this.f3402e = objectAnimator3;
            this.f3403f = animatorSet;
            this.f3404g = objectAnimator4;
            this.f3405h = animatorSet3;
            this.f3406i = objectAnimator5;
        }

        public final void mo157a() {
            this.f3405h.start();
            this.f3398a.setVisibility(0);
        }

        public final boolean mo158a(float f) {
            return ((float) this.f3398a.getHeight()) * this.f3398a.getScaleY() > f;
        }
    }

    private static <T extends View> void m4138a(Class<T> cls, T t) {
        m4139a((Object) t, t.getContext());
    }

    private static void m4139a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((StreamingReactionsView) obj).m4137a(FeedbackReactionsController.a(injectorLike), IdBasedLazy.a(injectorLike, 5750), IdBasedLazy.a(injectorLike, 5754), String_ViewerContextUserIdMethodAutoProvider.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), StreamingReactionsController.m4075a(injectorLike));
    }

    public StreamingReactionsView(Context context) {
        this(context, null);
    }

    public StreamingReactionsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StreamingReactionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4138a(StreamingReactionsView.class, (View) this);
        this.f3427i = this.f3424e.a(ExperimentsForStreamingReactionsModule.f3289g, 10);
        this.f3428j = this.f3424e.a(ExperimentsForStreamingReactionsModule.f3288f, 3);
        this.f3429k = this.f3424e.a(ExperimentsForStreamingReactionsModule.f3284b, 15);
        this.f3430l = this.f3424e.a(ExperimentsForStreamingReactionsModule.f3283a, 40);
        this.f3431m = this.f3424e.a(ExperimentsForStreamingReactionsModule.f3291i, 100);
        this.f3432n = this.f3424e.a(ExperimentsForStreamingReactionsModule.f3292j, 0.7f);
        this.f3433o = this.f3424e.a(ExperimentsForStreamingReactionsModule.f3293k, 0.5f);
        this.f3434p = this.f3424e.a(ExperimentsForStreamingReactionsModule.f3286d, 10);
        setContentView(2130907285);
        this.f3437s = getResources().getDimensionPixelSize(2131428043);
        setMinimumHeight(this.f3437s);
        this.f3436r = null;
        this.f3435q = (StreamingReactionsFireworksView) c(2131567727);
        if (this.f3425f.a(593, false)) {
            this.f3414F = (StreamingReactionsDebugView) ((ViewStub) c(2131567728)).inflate();
            this.f3414F.setOnClickListener(new C02951(this));
        }
        this.f3440v = new Random();
        this.f3441w = this.f3420a.c();
        this.f3438t = getResources().getDimensionPixelSize(2131428049);
        this.f3439u = getResources().getDimensionPixelSize(2131428048);
        this.f3442x = new ArrayList();
        this.f3443y = new LinkedList();
        this.f3444z = PathInterpolatorCompat.a(0.19f, 1.0f, 0.22f, 1.0f);
        this.f3409A = new AccelerateInterpolator();
        this.f3410B = new AccelerateDecelerateInterpolator();
        this.f3411C = new LinearInterpolator();
        this.f3412D = new Rect();
    }

    private void m4137a(FeedbackReactionsController feedbackReactionsController, Lazy<LiveStreamingReactionsModel> lazy, Lazy<VodStreamingReactionsModel> lazy2, String str, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, StreamingReactionsController streamingReactionsController) {
        this.f3420a = feedbackReactionsController;
        this.f3421b = lazy;
        this.f3422c = lazy2;
        this.f3423d = str;
        this.f3424e = qeAccessor;
        this.f3425f = gatekeeperStore;
        this.f3426g = streamingReactionsController;
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof MarginLayoutParams) {
            int i = -((MarginLayoutParams) layoutParams).bottomMargin;
            if (i > 0) {
                int paddingBottom = i - this.f3435q.getPaddingBottom();
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f3435q.getLayoutParams();
                marginLayoutParams.bottomMargin = paddingBottom;
                this.f3435q.setLayoutParams(marginLayoutParams);
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.f3436r != null) {
            canvas.drawRect(0.0f, (float) (canvas.getHeight() - this.f3437s), (float) canvas.getWidth(), (float) canvas.getHeight(), this.f3436r);
        }
        super.onDraw(canvas);
    }

    public final void mo161a(SparseArray<Integer> sparseArray) {
        Preconditions.a(this.f3413E);
        int[] a = SparseArrayUtil.a(sparseArray);
        int i = 0;
        int i2 = 0;
        while (i2 < a.length) {
            int intValue = i + ((Integer) sparseArray.get(a[i2])).intValue();
            i2++;
            i = intValue;
        }
        int max = Math.max(this.f3428j, Math.min((int) ((((double) (this.f3429k * this.f3413E.mo154d())) * 1.0d) / 1000.0d), this.f3430l - this.f3442x.size()));
        int i3;
        if (i <= max) {
            for (int i4 : a) {
                i = ((Integer) sparseArray.get(i4)).intValue();
                for (i3 = 0; i3 < i; i3++) {
                    m4133a(i4, 1);
                }
            }
            return;
        }
        for (int i5 : a) {
            intValue = ((Integer) sparseArray.get(i5)).intValue();
            int floor = (int) Math.floor((((double) intValue) / ((double) i)) * ((double) max));
            if (floor != 0) {
                int i6 = ((floor + 1) * floor) / 2;
                i2 = intValue;
                for (i3 = 1; i3 < floor; i3++) {
                    int i7 = (int) ((1.0d / ((double) i6)) * ((double) intValue));
                    i2 -= i7;
                    m4133a(i5, i7);
                }
                m4133a(i5, i2);
            }
        }
    }

    public final void mo160a(int i, String str) {
        if (this.f3435q.getCurrentNumberOfFireworks() < this.f3434p) {
            m4134a(i, str, false);
        }
    }

    public final void mo163b(SparseArray<Integer> sparseArray) {
        if (this.f3414F != null) {
            this.f3414F.setCurrentReactions(sparseArray);
        }
    }

    public final void mo159a() {
        for (final ReactionViewHolder reactionViewHolder : this.f3442x) {
            reactionViewHolder.f3398a.m4050a();
            reactionViewHolder.f3398a.animate().alpha(0.0f).setDuration(200).setListener(new StreamingReactionsAnimationListener(this) {
                final /* synthetic */ StreamingReactionsView f3395b;

                public final void mo156a(Animator animator) {
                    this.f3395b.removeView(reactionViewHolder.f3398a);
                    reactionViewHolder.f3398a.setAlpha(1.0f);
                    this.f3395b.f3442x.remove(reactionViewHolder);
                }
            }).start();
            reactionViewHolder.f3399b.cancel();
            reactionViewHolder.f3405h.cancel();
        }
        this.f3443y.clear();
        this.f3435q.m4104a();
    }

    private void m4133a(int i, int i2) {
        if (getWidth() != 0 && getHeight() != 0) {
            this.f3418J = Math.max(i2, this.f3418J);
            int i3 = (int) (((((double) (i2 - 1)) / (((double) this.f3418J) - 1.0d)) * ((double) (this.f3439u - this.f3438t))) + ((double) this.f3438t));
            this.f3412D.top = (getHeight() - this.f3437s) + (i3 / 2);
            this.f3412D.bottom = getHeight() - (i3 / 2);
            this.f3412D.right = getWidth() + (i3 / 2);
            this.f3412D.left = getWidth() + (i3 / 2);
            ReactionViewHolder a = m4132a(i, i3, i3, this.f3412D);
            a.f3399b.start();
            a.f3398a.setVisibility(0);
            this.f3442x.add(a);
        }
    }

    private void m4134a(int i, String str, boolean z) {
        Preconditions.a(this.f3413E);
        if (getWidth() != 0 && getHeight() != 0) {
            int i2 = this.f3435q.f3363h;
            this.f3435q.m4105a(this.f3412D);
            Rect rect = this.f3412D;
            rect.left += this.f3435q.getLeft() - (i2 / 2);
            rect = this.f3412D;
            rect.right += this.f3435q.getLeft() - (i2 / 2);
            rect = this.f3412D;
            rect.top += this.f3435q.getTop();
            rect = this.f3412D;
            rect.bottom += this.f3435q.getTop();
            LiveReactionsFireworksViewListener a = m4132a(i, i2, this.f3438t, this.f3412D);
            this.f3442x.add(a);
            this.f3435q.m4106a(str, ((int) (a.f3398a.getX() + (((float) i2) / 2.0f))) - this.f3435q.getLeft(), ((int) ((((float) i2) / 2.0f) + a.f3398a.getY())) - this.f3435q.getTop(), this.f3420a.a(i).g, z, this.f3417I ? 0 : (long) m4140b(0, this.f3413E.mo154d()), a);
        }
    }

    public final void m4144a(int i, boolean z) {
        if (this.f3419K) {
            m4134a(i, this.f3423d, true);
            if (z && this.f3413E != null) {
                this.f3413E.mo149a(i);
            }
        }
    }

    public final void mo162a(String str, boolean z) {
        if (str.equals(this.f3415G)) {
            this.f3419K = z;
            if (this.f3419K) {
                m4151f();
            } else {
                m4152g();
            }
        }
    }

    public final void m4146a(String str, @Nullable String str2, boolean z) {
        this.f3415G = str;
        this.f3416H = str2;
        this.f3417I = z;
        if (z) {
            this.f3413E = (StreamingReactionsModel) this.f3421b.get();
        } else {
            this.f3413E = (StreamingReactionsModel) this.f3422c.get();
        }
        this.f3419K = !this.f3426g.m4079a(str);
        this.f3426g.m4078a((OnStreamingReactionsToggledListener) this);
    }

    public final void m4148b() {
        if (this.f3419K && this.f3413E != null) {
            this.f3413E.mo150a(this, this.f3415G, this.f3416H);
        }
        this.f3418J = this.f3427i;
    }

    public final void m4150e() {
        if (this.f3413E != null && this.f3413E.mo152b()) {
            this.f3413E.mo148a();
        }
    }

    public final void m4151f() {
        if (this.f3415G != null && this.f3413E != null && !this.f3413E.mo152b()) {
            m4148b();
        }
    }

    public final void m4152g() {
        if (this.f3413E != null) {
            this.f3413E.mo148a();
        }
        for (ReactionViewHolder reactionViewHolder : this.f3442x) {
            reactionViewHolder.f3398a.m4050a();
            reactionViewHolder.f3399b.cancel();
            reactionViewHolder.f3405h.cancel();
            removeView(reactionViewHolder.f3398a);
        }
        this.f3442x.clear();
        this.f3443y.clear();
        this.f3435q.m4104a();
        if (this.f3414F != null) {
            this.f3414F.m4087a();
        }
    }

    public final boolean m4153h() {
        return this.f3413E == null ? false : this.f3413E.mo152b();
    }

    public void setVideoTime(int i) {
        if (this.f3413E != null) {
            this.f3413E.mo151b(i);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int paddingTop = (((int) (((double) measuredWidth) * 0.3d)) + this.f3435q.getPaddingTop()) + this.f3435q.getPaddingBottom();
        this.f3435q.measure(MeasureSpec.makeMeasureSpec((((int) (((double) measuredWidth) * 0.35d)) + this.f3435q.getPaddingLeft()) + this.f3435q.getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec(paddingTop, 1073741824));
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f3435q.getLayoutParams();
        int measuredHeight = marginLayoutParams.bottomMargin + this.f3435q.getMeasuredHeight();
        int mode = MeasureSpec.getMode(i2);
        paddingTop = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                measuredHeight = Math.min(paddingTop, measuredHeight);
                break;
            case 1073741824:
                measuredHeight = paddingTop;
                break;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    private ReactionViewHolder m4132a(int i, int i2, int i3, Rect rect) {
        Preconditions.a(this.f3413E);
        ReactionViewHolder reactionViewHolder = (ReactionViewHolder) StreamingReactionsUtil.m4123a(this.f3443y);
        if (reactionViewHolder == null) {
            FacecastReactionView facecastReactionView = new FacecastReactionView(getContext());
            ObjectAnimator objectAnimator = new ObjectAnimator();
            objectAnimator.setTarget(facecastReactionView);
            objectAnimator.setPropertyName("translationX");
            objectAnimator.setInterpolator(this.f3409A);
            ObjectAnimator objectAnimator2 = new ObjectAnimator();
            objectAnimator2.setTarget(facecastReactionView);
            objectAnimator2.setPropertyName("translationY");
            objectAnimator2.setInterpolator(this.f3410B);
            ObjectAnimator objectAnimator3 = new ObjectAnimator();
            objectAnimator3.setTarget(facecastReactionView);
            objectAnimator3.setPropertyName("translationY");
            objectAnimator3.setInterpolator(this.f3410B);
            objectAnimator3.setRepeatMode(2);
            objectAnimator3.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(new Animator[]{objectAnimator2, objectAnimator3});
            ObjectAnimator objectAnimator4 = new ObjectAnimator();
            objectAnimator4.setTarget(facecastReactionView);
            objectAnimator4.setInterpolator(this.f3411C);
            Animator animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(new Animator[]{objectAnimator, animatorSet, objectAnimator4});
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.play(animatorSet2);
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f, 1.0f});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 1.0f});
            ObjectAnimator objectAnimator5 = new ObjectAnimator();
            objectAnimator5.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
            objectAnimator5.setTarget(facecastReactionView);
            objectAnimator5.setDuration(300);
            objectAnimator5.setInterpolator(this.f3444z);
            ObjectAnimator objectAnimator6 = new ObjectAnimator();
            objectAnimator6.setTarget(facecastReactionView);
            objectAnimator6.setInterpolator(this.f3411C);
            AnimatorSet animatorSet4 = new AnimatorSet();
            animatorSet4.playTogether(new Animator[]{objectAnimator6, animatorSet2});
            animatorSet4.setStartDelay(500);
            AnimatorSet animatorSet5 = new AnimatorSet();
            animatorSet5.playSequentially(new Animator[]{objectAnimator5, animatorSet4});
            reactionViewHolder = new ReactionViewHolder(facecastReactionView, objectAnimator, objectAnimator2, objectAnimator3, animatorSet, objectAnimator4, animatorSet3, animatorSet5, objectAnimator6);
            objectAnimator.addListener(new StreamingReactionsAnimationListener(this) {
                final /* synthetic */ StreamingReactionsView f3397b;

                public final void mo156a(Animator animator) {
                    super.mo156a(animator);
                    this.f3397b.m4135a(reactionViewHolder);
                }
            });
        }
        reactionViewHolder.f3407j = i;
        reactionViewHolder.f3398a.setReaction(this.f3420a.b(i));
        reactionViewHolder.f3398a.setVisibility(8);
        reactionViewHolder.f3398a.setScaleX(1.0f);
        reactionViewHolder.f3398a.setScaleY(1.0f);
        reactionViewHolder.f3398a.setTranslationX(0.0f);
        reactionViewHolder.f3398a.setTranslationY(0.0f);
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.height = i2;
        generateDefaultLayoutParams.width = i2;
        generateDefaultLayoutParams.gravity = 51;
        addView(reactionViewHolder.f3398a, getChildCount() - 1, generateDefaultLayoutParams);
        double min = Math.min(this.f3413E.mo153c(), (double) this.f3431m) / ((double) this.f3431m);
        double d = (double) (-i2);
        long a = (long) (((double) m4129a(2900, 4000)) * (1.0d - (((double) (1.0f - this.f3432n)) * min)));
        reactionViewHolder.f3400c.setFloatValues(new float[]{(float) ((double) m4140b(rect.left, rect.right)), (float) d});
        reactionViewHolder.f3400c.setDuration(a);
        reactionViewHolder.f3398a.setTranslationX((float) r8);
        double a2 = (((double) this.f3437s) * m4128a(0.05d, 0.2d)) * (1.0d - (min * ((double) (1.0f - this.f3433o))));
        long a3 = m4129a(1500, 3000);
        min = m4128a(((double) rect.top) + a2, ((double) rect.bottom) - a2) - ((double) (i2 / 2));
        double d2 = min + a2;
        d = min - a2;
        double a4 = m4128a(-a2, a2) + min;
        Object obj = m4140b(0, 1) == 0 ? 1 : null;
        if (obj != null) {
            min = d2;
        } else {
            min = d;
        }
        long max = (long) (Math.max(Math.abs(min - a4) / (a2 * 2.0d), 0.75d) * ((double) a3));
        if (obj == null) {
            d = d2;
        }
        reactionViewHolder.f3401d.setFloatValues(new float[]{(float) a4, (float) min});
        reactionViewHolder.f3401d.setDuration(max);
        reactionViewHolder.f3401d.setStartDelay((long) (((double) max) * 0.2d));
        reactionViewHolder.f3398a.setTranslationY((float) a4);
        reactionViewHolder.f3402e.setFloatValues(new float[]{(float) min, (float) d});
        reactionViewHolder.f3402e.setDuration(a3);
        long j = (long) (((double) a) * 0.15d);
        long j2 = a - j;
        float f = (float) (((double) (((float) i3) / ((float) i2))) * 0.3d);
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scaleX", new float[]{((float) i3) / ((float) i2), f});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("scaleY", new float[]{r5, f});
        reactionViewHolder.f3404g.setValues(new PropertyValuesHolder[]{ofFloat3, ofFloat4});
        reactionViewHolder.f3404g.setDuration(j);
        reactionViewHolder.f3404g.setStartDelay(j2);
        reactionViewHolder.f3399b.setStartDelay((long) m4140b(0, this.f3413E.mo154d()));
        j = (long) (((double) a) * 0.33d);
        PropertyValuesHolder ofFloat5 = PropertyValuesHolder.ofFloat("scaleX", new float[]{r5});
        PropertyValuesHolder ofFloat6 = PropertyValuesHolder.ofFloat("scaleY", new float[]{r5});
        reactionViewHolder.f3406i.setValues(new PropertyValuesHolder[]{ofFloat5, ofFloat6});
        reactionViewHolder.f3406i.setDuration(j);
        return reactionViewHolder;
    }

    private int getRandomReactionIndex() {
        return ((FeedbackReaction) this.f3441w.get(this.f3440v.nextInt(this.f3441w.size()))).e;
    }

    private void m4135a(ReactionViewHolder reactionViewHolder) {
        this.f3442x.remove(reactionViewHolder);
        reactionViewHolder.f3398a.m4050a();
        reactionViewHolder.f3403f.end();
        removeView(reactionViewHolder.f3398a);
        this.f3443y.add(new SoftReference(reactionViewHolder));
    }

    private double m4128a(double d, double d2) {
        return (this.f3440v.nextDouble() * (d2 - d)) + d;
    }

    private int m4140b(int i, int i2) {
        return (int) ((this.f3440v.nextDouble() * ((double) ((i2 - i) + 1))) + ((double) i));
    }

    private long m4129a(long j, long j2) {
        return (long) ((this.f3440v.nextDouble() * ((double) ((j2 - j) + 1))) + ((double) j));
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1794962058);
        super.onDetachedFromWindow();
        this.f3426g.m4080b((OnStreamingReactionsToggledListener) this);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2044141918, a);
    }
}
