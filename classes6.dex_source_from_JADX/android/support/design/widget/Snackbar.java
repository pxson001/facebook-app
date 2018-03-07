package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.SwipeDismissBehavior.OnDismissListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: publish_bio_sticky */
public final class Snackbar {
    public static final Handler f7074a = new Handler(Looper.getMainLooper(), new C04011());
    public final ViewGroup f7075b;
    private final Context f7076c;
    public final SnackbarLayout f7077d;
    public int f7078e;
    public Callback f7079f;
    public final Callback f7080g = new C04033(this);

    /* compiled from: publish_bio_sticky */
    public class AnonymousClass10 implements AnimationListener {
        final /* synthetic */ int f7044a;
        final /* synthetic */ Snackbar f7045b;

        public AnonymousClass10(Snackbar snackbar, int i) {
            this.f7045b = snackbar;
            this.f7044a = i;
        }

        public void onAnimationEnd(Animation animation) {
            Snackbar.m10175f(this.f7045b, this.f7044a);
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: publish_bio_sticky */
    final class C04011 implements android.os.Handler.Callback {
        C04011() {
        }

        public final boolean handleMessage(Message message) {
            Snackbar snackbar;
            android.support.design.widget.CoordinatorLayout.Behavior behavior;
            switch (message.what) {
                case 0:
                    snackbar = (Snackbar) message.obj;
                    if (snackbar.f7077d.getParent() == null) {
                        LayoutParams layoutParams = snackbar.f7077d.getLayoutParams();
                        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                            behavior = new Behavior(snackbar);
                            behavior.f7064h = SwipeDismissBehavior.m10165c(0.0f, 0.1f, 1.0f);
                            behavior.f7065i = SwipeDismissBehavior.m10165c(0.0f, 0.6f, 1.0f);
                            behavior.f7062f = 0;
                            behavior.f7058b = new C04044(snackbar);
                            ((CoordinatorLayout.LayoutParams) layoutParams).m10077a(behavior);
                        }
                        snackbar.f7075b.addView(snackbar.f7077d);
                    }
                    snackbar.f7077d.f7073f = new C04065(snackbar);
                    if (ViewCompat.E(snackbar.f7077d)) {
                        Snackbar.m10176g(snackbar);
                    } else {
                        snackbar.f7077d.f7072e = new C04076(snackbar);
                    }
                    return true;
                case 1:
                    snackbar = (Snackbar) message.obj;
                    int i = message.arg1;
                    if (snackbar.f7077d.getVisibility() == 0) {
                        Object obj;
                        Animation loadAnimation;
                        LayoutParams layoutParams2 = snackbar.f7077d.getLayoutParams();
                        if (layoutParams2 instanceof CoordinatorLayout.LayoutParams) {
                            behavior = ((CoordinatorLayout.LayoutParams) layoutParams2).f6979a;
                            if (behavior instanceof SwipeDismissBehavior) {
                                int i2;
                                SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) behavior;
                                if (swipeDismissBehavior.f7057a != null) {
                                    i2 = swipeDismissBehavior.f7057a.a;
                                } else {
                                    i2 = 0;
                                }
                                obj = i2 != 0 ? 1 : null;
                                if (obj == null) {
                                    if (VERSION.SDK_INT < 14) {
                                        ViewCompat.t(snackbar.f7077d).c((float) snackbar.f7077d.getHeight()).a(AnimationUtils.f6855b).a(250).a(new C04109(snackbar, i)).b();
                                    } else {
                                        loadAnimation = AnimationUtils.loadAnimation(snackbar.f7077d.getContext(), 2130968612);
                                        loadAnimation.setInterpolator(AnimationUtils.f6855b);
                                        loadAnimation.setDuration(250);
                                        loadAnimation.setAnimationListener(new AnonymousClass10(snackbar, i));
                                        snackbar.f7077d.startAnimation(loadAnimation);
                                    }
                                    return true;
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            if (VERSION.SDK_INT < 14) {
                                loadAnimation = AnimationUtils.loadAnimation(snackbar.f7077d.getContext(), 2130968612);
                                loadAnimation.setInterpolator(AnimationUtils.f6855b);
                                loadAnimation.setDuration(250);
                                loadAnimation.setAnimationListener(new AnonymousClass10(snackbar, i));
                                snackbar.f7077d.startAnimation(loadAnimation);
                            } else {
                                ViewCompat.t(snackbar.f7077d).c((float) snackbar.f7077d.getHeight()).a(AnimationUtils.f6855b).a(250).a(new C04109(snackbar, i)).b();
                            }
                            return true;
                        }
                    }
                    Snackbar.m10175f(snackbar, i);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: publish_bio_sticky */
    class C04033 implements Callback {
        final /* synthetic */ Snackbar f7048a;

        C04033(Snackbar snackbar) {
            this.f7048a = snackbar;
        }

        public final void mo874a() {
            Snackbar.f7074a.sendMessage(Snackbar.f7074a.obtainMessage(0, this.f7048a));
        }

        public final void mo875a(int i) {
            Snackbar.f7074a.sendMessage(Snackbar.f7074a.obtainMessage(1, i, 0, this.f7048a));
        }
    }

    /* compiled from: publish_bio_sticky */
    public class C04044 implements OnDismissListener {
        final /* synthetic */ Snackbar f7049a;

        public C04044(Snackbar snackbar) {
            this.f7049a = snackbar;
        }

        public final void mo876a() {
            Snackbar.m10174d(this.f7049a, 0);
        }

        public final void mo877a(int i) {
            switch (i) {
                case 0:
                    SnackbarManager.m10183a().m10195d(this.f7049a.f7080g);
                    return;
                case 1:
                case 2:
                    SnackbarManager.m10183a().m10194c(this.f7049a.f7080g);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: publish_bio_sticky */
    public class C04065 implements OnAttachStateChangeListener {
        final /* synthetic */ Snackbar f7051a;

        /* compiled from: publish_bio_sticky */
        class C04051 implements Runnable {
            final /* synthetic */ C04065 f7050a;

            C04051(C04065 c04065) {
                this.f7050a = c04065;
            }

            public void run() {
                Snackbar.m10175f(this.f7050a.f7051a, 3);
            }
        }

        public C04065(Snackbar snackbar) {
            this.f7051a = snackbar;
        }

        public final void mo878a() {
            if (SnackbarManager.m10183a().m10196e(this.f7051a.f7080g)) {
                HandlerDetour.a(Snackbar.f7074a, new C04051(this), -2134443249);
            }
        }
    }

    /* compiled from: publish_bio_sticky */
    public class C04076 implements OnLayoutChangeListener {
        final /* synthetic */ Snackbar f7052a;

        public C04076(Snackbar snackbar) {
            this.f7052a = snackbar;
        }

        public final void mo879a() {
            Snackbar.m10176g(this.f7052a);
            this.f7052a.f7077d.f7072e = null;
        }
    }

    /* compiled from: publish_bio_sticky */
    class C04087 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ Snackbar f7053a;

        C04087(Snackbar snackbar) {
            this.f7053a = snackbar;
        }

        public final void m10161a(View view) {
            this.f7053a.f7077d.m10171a(70, 180);
        }

        public final void m10162b(View view) {
            if (this.f7053a.f7079f != null) {
                Callback callback = this.f7053a.f7079f;
            }
            SnackbarManager.m10183a().m10193b(this.f7053a.f7080g);
        }
    }

    /* compiled from: publish_bio_sticky */
    class C04098 implements AnimationListener {
        final /* synthetic */ Snackbar f7054a;

        C04098(Snackbar snackbar) {
            this.f7054a = snackbar;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f7054a.f7079f != null) {
                Callback callback = this.f7054a.f7079f;
            }
            SnackbarManager.m10183a().m10193b(this.f7054a.f7080g);
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: publish_bio_sticky */
    public class C04109 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ int f7055a;
        final /* synthetic */ Snackbar f7056b;

        public C04109(Snackbar snackbar, int i) {
            this.f7056b = snackbar;
            this.f7055a = i;
        }

        public final void m10163a(View view) {
            this.f7056b.f7077d.m10172b(0, 180);
        }

        public final void m10164b(View view) {
            Snackbar.m10175f(this.f7056b, this.f7055a);
        }
    }

    /* compiled from: publish_bio_sticky */
    public final class Behavior extends SwipeDismissBehavior<SnackbarLayout> {
        final /* synthetic */ Snackbar f7067a;

        public Behavior(Snackbar snackbar) {
            this.f7067a = snackbar;
        }

        public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            view = (SnackbarLayout) view;
            if (coordinatorLayout.m10125a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        SnackbarManager.m10183a().m10194c(this.f7067a.f7080g);
                        break;
                    case 1:
                    case 3:
                        SnackbarManager.m10183a().m10195d(this.f7067a.f7080g);
                        break;
                }
            }
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        public final boolean mo880a(View view) {
            return view instanceof SnackbarLayout;
        }
    }

    /* compiled from: publish_bio_sticky */
    public abstract class Callback {

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: publish_bio_sticky */
        public @interface DismissEvent {
        }

        public void mo1143a(Snackbar snackbar, int i) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: publish_bio_sticky */
    public @interface Duration {
    }

    /* compiled from: publish_bio_sticky */
    public class SnackbarLayout extends LinearLayout {
        public TextView f7068a;
        public Button f7069b;
        private int f7070c;
        private int f7071d;
        public OnLayoutChangeListener f7072e;
        public OnAttachStateChangeListener f7073f;

        /* compiled from: publish_bio_sticky */
        interface OnAttachStateChangeListener {
            void mo878a();
        }

        /* compiled from: publish_bio_sticky */
        interface OnLayoutChangeListener {
            void mo879a();
        }

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            this.f7070c = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            this.f7071d = obtainStyledAttributes.getDimensionPixelSize(2, -1);
            if (obtainStyledAttributes.hasValue(1)) {
                ViewCompat.g(this, (float) obtainStyledAttributes.getDimensionPixelSize(1, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(2130903882, this);
            ViewCompat.f(this, 1);
        }

        protected void onFinishInflate() {
            int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -770433474);
            super.onFinishInflate();
            this.f7068a = (TextView) findViewById(2131560959);
            this.f7069b = (Button) findViewById(2131560689);
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1321651881, a);
        }

        TextView getMessageView() {
            return this.f7068a;
        }

        Button getActionView() {
            return this.f7069b;
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f7070c > 0 && getMeasuredWidth() > this.f7070c) {
                i = MeasureSpec.makeMeasureSpec(this.f7070c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(2131427703);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131427702);
            int i3 = this.f7068a.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.f7071d <= 0 || this.f7069b.getMeasuredWidth() <= this.f7071d) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (m10170a(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (m10170a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        final void m10171a(int i, int i2) {
            ViewCompat.c(this.f7068a, 0.0f);
            ViewCompat.t(this.f7068a).a(1.0f).a((long) i2).b((long) i).b();
            if (this.f7069b.getVisibility() == 0) {
                ViewCompat.c(this.f7069b, 0.0f);
                ViewCompat.t(this.f7069b).a(1.0f).a((long) i2).b((long) i).b();
            }
        }

        final void m10172b(int i, int i2) {
            ViewCompat.c(this.f7068a, 1.0f);
            ViewCompat.t(this.f7068a).a(0.0f).a((long) i2).b((long) i).b();
            if (this.f7069b.getVisibility() == 0) {
                ViewCompat.c(this.f7069b, 1.0f);
                ViewCompat.t(this.f7069b).a(0.0f).a((long) i2).b((long) i).b();
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z && this.f7072e != null) {
                this.f7072e.mo879a();
            }
        }

        protected void onAttachedToWindow() {
            int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1661407453);
            super.onAttachedToWindow();
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1622914977, a);
        }

        protected void onDetachedFromWindow() {
            int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 278449149);
            super.onDetachedFromWindow();
            if (this.f7073f != null) {
                this.f7073f.mo878a();
            }
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2140675080, a);
        }

        void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.f7072e = onLayoutChangeListener;
        }

        void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            this.f7073f = onAttachStateChangeListener;
        }

        private boolean m10170a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.f7068a.getPaddingTop() == i2 && this.f7068a.getPaddingBottom() == i3) {
                return z;
            }
            m10169a(this.f7068a, i2, i3);
            return true;
        }

        private static void m10169a(View view, int i, int i2) {
            if (ViewCompat.a.D(view)) {
                ViewCompat.b(view, ViewCompat.n(view), i, ViewCompat.o(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }
    }

    private Snackbar(ViewGroup viewGroup) {
        this.f7075b = viewGroup;
        this.f7076c = viewGroup.getContext();
        ThemeUtils.m10221a(this.f7076c);
        this.f7077d = (SnackbarLayout) LayoutInflater.from(this.f7076c).inflate(2130903881, this.f7075b, false);
    }

    @NonNull
    public static Snackbar m10173a(@NonNull View view, @NonNull CharSequence charSequence, int i) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        View view2 = view;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    viewGroup = (ViewGroup) view2;
                    break;
                }
                viewGroup2 = (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    continue;
                } else {
                    view2 = null;
                    continue;
                }
            }
            if (view2 == null) {
                viewGroup = viewGroup2;
                break;
            }
        }
        viewGroup = (ViewGroup) view2;
        Snackbar snackbar = new Snackbar(viewGroup);
        snackbar.f7077d.f7068a.setText(charSequence);
        snackbar.f7078e = i;
        return snackbar;
    }

    @NonNull
    public final Snackbar m10178a(@StringRes int i, OnClickListener onClickListener) {
        return m10179a(this.f7076c.getText(i), onClickListener);
    }

    @NonNull
    public final Snackbar m10179a(CharSequence charSequence, final OnClickListener onClickListener) {
        TextView textView = this.f7077d.f7069b;
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            textView.setVisibility(8);
            textView.setOnClickListener(null);
        } else {
            textView.setVisibility(0);
            textView.setText(charSequence);
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ Snackbar f7047b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -33091531);
                    onClickListener.onClick(view);
                    Snackbar.m10174d(this.f7047b, 1);
                    Logger.a(2, EntryType.UI_INPUT_END, -1931194283, a);
                }
            });
        }
        return this;
    }

    @NonNull
    public final Snackbar m10177a(@ColorInt int i) {
        this.f7077d.f7069b.setTextColor(i);
        return this;
    }

    public final void m10180b() {
        SnackbarManager.m10183a().m10190a(this.f7078e, this.f7080g);
    }

    public static void m10174d(Snackbar snackbar, int i) {
        SnackbarManager.m10183a().m10192a(snackbar.f7080g, i);
    }

    public static void m10176g(Snackbar snackbar) {
        if (VERSION.SDK_INT >= 14) {
            ViewCompat.b(snackbar.f7077d, (float) snackbar.f7077d.getHeight());
            ViewCompat.t(snackbar.f7077d).c(0.0f).a(AnimationUtils.f6855b).a(250).a(new C04087(snackbar)).b();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(snackbar.f7077d.getContext(), 2130968611);
        loadAnimation.setInterpolator(AnimationUtils.f6855b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C04098(snackbar));
        snackbar.f7077d.startAnimation(loadAnimation);
    }

    public static void m10175f(Snackbar snackbar, int i) {
        SnackbarManager.m10183a().m10191a(snackbar.f7080g);
        if (snackbar.f7079f != null) {
            snackbar.f7079f.mo1143a(snackbar, i);
        }
        ViewParent parent = snackbar.f7077d.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(snackbar.f7077d);
        }
    }
}
