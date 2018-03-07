package com.facebook.facecastdisplay.streamingreactions;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.user.tiles.UserTileViewLogic;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: start_upload_contacts */
public class StreamingReactionsFireworksView extends View {
    private static final String f3356d = StreamingReactionsFireworksView.class.getName();
    private static final CallerContext f3357e = CallerContext.a(StreamingReactionsFireworksView.class, "unknown");
    public static final Rect f3358f = new Rect();
    @Inject
    FbDraweeControllerBuilder f3359a;
    @Inject
    UserTileViewLogic f3360b;
    @Inject
    Provider<StreamingReactionsFireworkExplosionDrawable> f3361c;
    private final int f3362g;
    public final int f3363h;
    private final int f3364i;
    private final int f3365j;
    private final Interpolator f3366k;
    private final Interpolator f3367l;
    private final Interpolator f3368m;
    private final MultiDraweeHolder f3369n;
    private final GenericDraweeHierarchyBuilder f3370o;
    private final List<FireworksDrawableHolder> f3371p;
    private final Queue<SoftReference<FireworksDrawableHolder>> f3372q;

    /* compiled from: start_upload_contacts */
    class FireworksDrawableHolder extends BaseControllerListener<ImageInfo> {
        public final DraweeHolder f3349a;
        public final StreamingReactionsFireworkExplosionDrawable f3350b;
        public final AnimatorSet f3351c;
        public final Rect f3352d;
        public boolean f3353e;
        @Nullable
        public LiveReactionsFireworksViewListener f3354f;
        final /* synthetic */ StreamingReactionsFireworksView f3355g;

        public FireworksDrawableHolder(StreamingReactionsFireworksView streamingReactionsFireworksView, DraweeHolder draweeHolder, StreamingReactionsFireworkExplosionDrawable streamingReactionsFireworkExplosionDrawable, AnimatorSet animatorSet) {
            this.f3355g = streamingReactionsFireworksView;
            this.f3349a = draweeHolder;
            this.f3350b = streamingReactionsFireworkExplosionDrawable;
            this.f3351c = animatorSet;
            this.f3352d = draweeHolder.h().copyBounds();
        }

        public final void m4091a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f3351c.start();
        }

        public final void m4093b(String str, Throwable th) {
            this.f3351c.start();
        }

        public final void m4092b() {
            this.f3349a.h().copyBounds(this.f3352d);
            this.f3353e = false;
        }

        public final void m4090a(@Nullable LiveReactionsFireworksViewListener liveReactionsFireworksViewListener) {
            this.f3354f = liveReactionsFireworksViewListener;
        }

        @DoNotStrip
        public void setAvatarTranslationY(int i) {
            this.f3349a.h().copyBounds(StreamingReactionsFireworksView.f3358f);
            this.f3349a.h().setBounds(StreamingReactionsFireworksView.f3358f.left, this.f3352d.top + i, StreamingReactionsFireworksView.f3358f.right, this.f3352d.bottom + i);
            this.f3355g.invalidateDrawable(this.f3349a.h());
        }

        @DoNotStrip
        public void setAvatarSize(int i) {
            this.f3349a.h().copyBounds(StreamingReactionsFireworksView.f3358f);
            StreamingReactionsFireworksView.m4103b(this.f3349a.h(), StreamingReactionsFireworksView.f3358f.centerX(), StreamingReactionsFireworksView.f3358f.centerY(), i);
            this.f3355g.invalidateDrawable(this.f3349a.h());
            if (this.f3353e && this.f3354f != null && this.f3354f.mo158a((float) i)) {
                this.f3351c.cancel();
                this.f3355g.m4098a(this);
            }
        }
    }

    /* compiled from: start_upload_contacts */
    public interface LiveReactionsFireworksViewListener {
        void mo157a();

        boolean mo158a(float f);
    }

    private static <T extends View> void m4100a(Class<T> cls, T t) {
        m4101a((Object) t, t.getContext());
    }

    private static void m4101a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((StreamingReactionsFireworksView) obj).m4097a(FbDraweeControllerBuilder.b(fbInjector), UserTileViewLogic.a(fbInjector), IdBasedProvider.a(fbInjector, 5752));
    }

    public StreamingReactionsFireworksView(Context context) {
        this(context, null);
    }

    public StreamingReactionsFireworksView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StreamingReactionsFireworksView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4100a(StreamingReactionsFireworksView.class, (View) this);
        this.f3362g = getResources().getDimensionPixelSize(2131428044);
        this.f3363h = getResources().getDimensionPixelSize(2131428045);
        this.f3364i = getResources().getDimensionPixelSize(2131428046);
        this.f3365j = this.f3364i - (this.f3363h / 2);
        setPadding(this.f3365j, this.f3365j, 0, 0);
        this.f3366k = PathInterpolatorCompat.a(0.075f, 0.82f, 0.165f, 1.0f);
        this.f3367l = PathInterpolatorCompat.a(0.17f, 0.89f, 0.53f, 1.52f);
        this.f3368m = PathInterpolatorCompat.a(0.19f, 1.0f, 0.22f, 1.0f);
        this.f3369n = new MultiDraweeHolder();
        GenericDraweeHierarchyBuilder a = GenericDraweeHierarchyBuilder.a(getResources());
        a.u = RoundingParams.e();
        a = a;
        a.f = new ColorDrawable(ContextCompat.b(context, 2131361957));
        this.f3370o = a;
        this.f3359a.a(f3357e);
        this.f3371p = new ArrayList();
        this.f3372q = new LinkedList();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1144051713);
        super.onAttachedToWindow();
        this.f3369n.a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 102583098, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1224880851);
        super.onDetachedFromWindow();
        this.f3369n.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1283367608, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f3369n.b();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f3369n.a();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable)) {
            return true;
        }
        for (FireworksDrawableHolder fireworksDrawableHolder : this.f3371p) {
            if (fireworksDrawableHolder.f3350b == drawable) {
                return true;
            }
            if (fireworksDrawableHolder.f3349a.h() == drawable) {
                return true;
            }
        }
        return false;
    }

    private void m4097a(FbDraweeControllerBuilder fbDraweeControllerBuilder, UserTileViewLogic userTileViewLogic, Provider<StreamingReactionsFireworkExplosionDrawable> provider) {
        this.f3359a = fbDraweeControllerBuilder;
        this.f3360b = userTileViewLogic;
        this.f3361c = provider;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (FireworksDrawableHolder fireworksDrawableHolder : this.f3371p) {
            fireworksDrawableHolder.f3350b.draw(canvas);
            fireworksDrawableHolder.f3349a.h().draw(canvas);
        }
    }

    public final void m4106a(String str, int i, int i2, int i3, boolean z, long j, @Nullable LiveReactionsFireworksViewListener liveReactionsFireworksViewListener) {
        ControllerListener controllerListener;
        int height = getHeight() + (this.f3362g / 2);
        FireworksDrawableHolder fireworksDrawableHolder = (FireworksDrawableHolder) StreamingReactionsUtil.m4123a(this.f3372q);
        if (fireworksDrawableHolder == null) {
            DraweeHolder draweeHolder = new DraweeHolder(this.f3370o.u());
            this.f3369n.a(draweeHolder);
            Drawable h = draweeHolder.h();
            if (h == null) {
                BLog.b(f3356d, "Top level drawable was null when adding reaction");
                return;
            }
            h.setCallback(this);
            StreamingReactionsFireworkExplosionDrawable streamingReactionsFireworkExplosionDrawable = (StreamingReactionsFireworkExplosionDrawable) this.f3361c.get();
            streamingReactionsFireworkExplosionDrawable.setCallback(this);
            AnimatorSet animatorSet = new AnimatorSet();
            final FireworksDrawableHolder fireworksDrawableHolder2 = new FireworksDrawableHolder(this, draweeHolder, streamingReactionsFireworkExplosionDrawable, animatorSet);
            ObjectAnimator objectAnimator = new ObjectAnimator();
            objectAnimator.setTarget(fireworksDrawableHolder2);
            objectAnimator.setPropertyName("avatarTranslationY");
            objectAnimator.setIntValues(new int[]{height, 0});
            objectAnimator.setDuration(500);
            objectAnimator.setInterpolator(this.f3366k);
            ObjectAnimator objectAnimator2 = new ObjectAnimator();
            objectAnimator2.setTarget(fireworksDrawableHolder2);
            objectAnimator2.setPropertyName("avatarSize");
            objectAnimator2.setIntValues(new int[]{this.f3362g, this.f3363h});
            objectAnimator2.setDuration(110);
            objectAnimator2.setStartDelay(0);
            objectAnimator2.setInterpolator(this.f3367l);
            objectAnimator2.addListener(new StreamingReactionsAnimationListener(this) {
                final /* synthetic */ StreamingReactionsFireworksView f3346b;

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    fireworksDrawableHolder2.f3350b.f3342f.start();
                }
            });
            ObjectAnimator objectAnimator3 = new ObjectAnimator();
            objectAnimator3.setTarget(fireworksDrawableHolder2);
            objectAnimator3.setPropertyName("avatarSize");
            objectAnimator3.setIntValues(new int[]{this.f3363h, 0});
            objectAnimator3.setDuration(300);
            objectAnimator3.setStartDelay(800);
            objectAnimator3.setInterpolator(this.f3368m);
            objectAnimator3.addListener(new StreamingReactionsAnimationListener(this) {
                final /* synthetic */ StreamingReactionsFireworksView f3348b;

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (fireworksDrawableHolder2.f3354f != null) {
                        fireworksDrawableHolder2.f3354f.mo157a();
                    }
                    fireworksDrawableHolder2.f3353e = true;
                }

                public final void mo156a(Animator animator) {
                    super.mo156a(animator);
                    this.f3348b.m4098a(fireworksDrawableHolder2);
                }
            });
            animatorSet.playSequentially(new Animator[]{objectAnimator, objectAnimator2, objectAnimator3});
            fireworksDrawableHolder = fireworksDrawableHolder2;
        }
        FbDraweeControllerBuilder b = this.f3359a.b(this.f3360b.a(str, this.f3363h, this.f3363h));
        if (z) {
            controllerListener = null;
        } else {
            controllerListener = fireworksDrawableHolder;
        }
        b.a(controllerListener);
        FbPipelineDraweeController s = this.f3359a.s();
        fireworksDrawableHolder.f3350b.m4088a(i3);
        m4103b(fireworksDrawableHolder.f3350b, i, i2, this.f3364i * 2);
        m4103b(fireworksDrawableHolder.f3349a.h(), i, i2, this.f3362g);
        fireworksDrawableHolder.m4090a(liveReactionsFireworksViewListener);
        fireworksDrawableHolder.m4092b();
        fireworksDrawableHolder.setAvatarTranslationY(height);
        fireworksDrawableHolder.f3349a.a(s);
        if (z) {
            fireworksDrawableHolder.f3351c.setStartDelay(0);
            fireworksDrawableHolder.f3351c.start();
        } else {
            fireworksDrawableHolder.f3351c.setStartDelay(j);
        }
        this.f3371p.add(fireworksDrawableHolder);
    }

    public int getAvatarSize() {
        return this.f3363h;
    }

    public final void m4105a(Rect rect) {
        rect.top = getPaddingTop() + (this.f3363h / 2);
        rect.bottom = (getHeight() - getPaddingBottom()) - (this.f3363h / 2);
        rect.left = getPaddingLeft() + (this.f3363h / 2);
        rect.right = (getWidth() - getPaddingRight()) - (this.f3363h / 2);
    }

    public final void m4104a() {
        for (FireworksDrawableHolder fireworksDrawableHolder : this.f3371p) {
            fireworksDrawableHolder.f3351c.cancel();
        }
        this.f3371p.clear();
        this.f3372q.clear();
        this.f3369n.c();
        invalidate();
    }

    public int getCurrentNumberOfFireworks() {
        return this.f3371p.size();
    }

    public static void m4103b(Drawable drawable, int i, int i2, int i3) {
        drawable.setBounds(i - (i3 / 2), i2 - (i3 / 2), (i3 / 2) + i, (i3 / 2) + i2);
    }

    private void m4098a(FireworksDrawableHolder fireworksDrawableHolder) {
        this.f3371p.remove(fireworksDrawableHolder);
        this.f3372q.add(new SoftReference(fireworksDrawableHolder));
    }
}
