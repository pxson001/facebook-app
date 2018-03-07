package com.facebook.feedback.reactions.ui.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import com.facebook.common.android.AccessibilityManagerMethodAutoProvider;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.device.ScreenUtil;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLogger;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: has_logged_app_install */
public class ReactionsDockOverlay {
    private static final ReactionsDockSupport f21358a = new C08441();
    private static ReactionsDockOverlay f21359t;
    private static final Object f21360u = new Object();
    public final Context f21361b;
    private final ScreenUtil f21362c;
    private final Lazy<FBSoundUtil> f21363d;
    private final boolean f21364e;
    private final RTLUtil f21365f;
    private final QuickPerformanceLogger f21366g;
    public final AccessibilityManager f21367h;
    public final ReactionsExperimentUtil f21368i;
    private final float f21369j;
    private final int f21370k;
    private final String f21371l;
    private final String f21372m;
    public ReactionsDockView f21373n;
    public PopupWindow f21374o;
    private Optional<float[]> f21375p = Absent.INSTANCE;
    public TouchMode f21376q = TouchMode.NONE;
    private WeakReference<ReactionsDockSupport> f21377r;
    public int f21378s = -1;

    /* compiled from: has_logged_app_install */
    final class C08441 implements ReactionsDockSupport {
        private final ImmutableList<FeedbackReaction> f21379a = RegularImmutableList.f535a;

        C08441() {
        }

        public final void mo3157a(boolean z) {
        }

        public final void mo3158b(boolean z) {
        }

        public final ReactionsFooterInteractionLogger getInteractionLogger() {
            return null;
        }

        public final ImmutableList<FeedbackReaction> getSupportedReactions() {
            return this.f21379a;
        }

        public final void mo3156a(FeedbackReaction feedbackReaction) {
        }

        public final DockTheme getDockTheme() {
            return DockTheme.LIGHT;
        }
    }

    /* compiled from: has_logged_app_install */
    public interface ReactionsDockSupport {
        void mo3156a(FeedbackReaction feedbackReaction);

        void mo3157a(boolean z);

        void mo3158b(boolean z);

        DockTheme getDockTheme();

        ReactionsFooterInteractionLogger getInteractionLogger();

        ImmutableList<FeedbackReaction> getSupportedReactions();
    }

    /* compiled from: has_logged_app_install */
    public enum TouchMode {
        DRAG,
        LINGER,
        NONE
    }

    /* compiled from: has_logged_app_install */
    public enum DockTheme {
        LIGHT(-1),
        DARK(-80530637);
        
        public final int backgroundColor;

        private DockTheme(int i) {
            this.backgroundColor = i;
        }
    }

    private static ReactionsDockOverlay m29057b(InjectorLike injectorLike) {
        return new ReactionsDockOverlay((Context) injectorLike.getInstance(Context.class), ScreenUtil.m8695a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 10994), Boolean_IsTabletMethodAutoProvider.m7864a(injectorLike), RTLUtil.m6553a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), AccessibilityManagerMethodAutoProvider.m8780b(injectorLike), ReactionsExperimentUtil.m10410a(injectorLike));
    }

    public final void m29066c() {
        this.f21375p = Absent.INSTANCE;
        if (this.f21373n.I) {
            this.f21374o.dismiss();
            m29061d(this).mo3157a(false);
            m29064a(null);
        }
    }

    public static ReactionsDockOverlay m29052a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionsDockOverlay b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21360u) {
                ReactionsDockOverlay reactionsDockOverlay;
                if (a2 != null) {
                    reactionsDockOverlay = (ReactionsDockOverlay) a2.mo818a(f21360u);
                } else {
                    reactionsDockOverlay = f21359t;
                }
                if (reactionsDockOverlay == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29057b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21360u, b3);
                        } else {
                            f21359t = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionsDockOverlay;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ReactionsDockOverlay(Context context, ScreenUtil screenUtil, Lazy<FBSoundUtil> lazy, Boolean bool, RTLUtil rTLUtil, QuickPerformanceLogger quickPerformanceLogger, AccessibilityManager accessibilityManager, ReactionsExperimentUtil reactionsExperimentUtil) {
        this.f21361b = context;
        this.f21362c = screenUtil;
        this.f21363d = lazy;
        this.f21364e = bool.booleanValue();
        this.f21365f = rTLUtil;
        this.f21366g = quickPerformanceLogger;
        this.f21367h = accessibilityManager;
        this.f21368i = reactionsExperimentUtil;
        Resources resources = this.f21361b.getResources();
        this.f21370k = resources.getDimensionPixelSize(2131430632);
        this.f21369j = (float) resources.getDimensionPixelSize(2131430633);
        this.f21371l = resources.getString(2131235958);
        this.f21372m = resources.getString(2131235956);
    }

    private void m29053a(View view) {
        if (view != null && !m29061d(this).getSupportedReactions().isEmpty()) {
            if (this.f21374o == null) {
                Activity activity = (Activity) ContextUtils.m2500a(this.f21361b, Activity.class);
                if (activity != null && activity.isFinishing()) {
                    return;
                }
            }
            if (this.f21374o == null) {
                if (this.f21368i.m10418m()) {
                    this.f21373n = new SimpleReactionsDockView(this.f21361b);
                } else {
                    this.f21373n = new RopeStyleReactionsDockView(this.f21361b);
                }
                this.f21373n.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                this.f21373n.G = this;
                this.f21374o = new PopupWindow(this.f21373n, this.f21373n.getMeasuredWidth(), this.f21373n.getMeasuredHeight());
                this.f21374o.setTouchable(true);
                this.f21374o.setFocusable(true);
                this.f21374o.setClippingEnabled(false);
                this.f21374o.setBackgroundDrawable(new ColorDrawable(0));
                this.f21374o.setTouchInterceptor(new DockPopupTouchInterceptor(this));
                this.f21374o.setInputMethodMode(2);
                this.f21374o.setOnDismissListener(new 2(this));
                this.f21366g.mo476d(8519683);
            } else {
                this.f21366g.mo476d(8519684);
            }
            if (!this.f21374o.isShowing() || this.f21373n.f()) {
                this.f21374o.setTouchable(true);
                m29061d(this).mo3157a(true);
                this.f21376q = TouchMode.NONE;
                m29058b(view);
                if (m29061d(this) != f21358a) {
                    m29061d(this).getInteractionLogger().m30290a();
                }
            }
        }
    }

    public final void m29062a() {
        if (this.f21373n != null) {
            this.f21373n.c();
        }
        m29065b();
    }

    public final void m29065b() {
        this.f21375p = Absent.INSTANCE;
        if (this.f21373n != null && !this.f21373n.f()) {
            this.f21374o.setTouchable(false);
            this.f21374o.update();
            this.f21376q = TouchMode.NONE;
            if (this.f21373n.I) {
                if (m29061d(this) != f21358a) {
                    m29061d(this).getInteractionLogger().m30292a(this.f21373n.getCurrentReaction(), this.f21373n.getPointerPosition());
                }
                ((FBSoundUtil) this.f21363d.get()).b("reactions_dock_away");
                this.f21373n.e();
                m29061d(this).mo3157a(false);
            }
        }
    }

    public final void m29063a(View view, MotionEvent motionEvent) {
        m29055a(this, view, motionEvent, false);
    }

    public static void m29055a(ReactionsDockOverlay reactionsDockOverlay, View view, MotionEvent motionEvent, boolean z) {
        if (reactionsDockOverlay.f21378s == -1 || reactionsDockOverlay.f21378s == motionEvent.getPointerId(motionEvent.getActionIndex())) {
            if (reactionsDockOverlay.f21378s == -1 && (motionEvent.getAction() == 0 || motionEvent.getAction() == 2)) {
                reactionsDockOverlay.f21378s = motionEvent.getPointerId(motionEvent.getActionIndex());
            }
            if (!reactionsDockOverlay.f21375p.isPresent()) {
                reactionsDockOverlay.f21375p = Optional.of(new float[]{motionEvent.getRawX(), motionEvent.getRawY()});
            }
            reactionsDockOverlay.m29053a(view);
            if (reactionsDockOverlay.f21374o == null || reactionsDockOverlay.f21373n == null) {
                reactionsDockOverlay.f21378s = -1;
                reactionsDockOverlay.f21375p = Absent.INSTANCE;
                return;
            }
            if (reactionsDockOverlay.f21376q == TouchMode.NONE && motionEvent.getActionMasked() == 1) {
                reactionsDockOverlay.f21376q = TouchMode.LINGER;
                reactionsDockOverlay.m29059b(TouchMode.LINGER);
            }
            if (reactionsDockOverlay.f21376q != TouchMode.DRAG && (z || (!reactionsDockOverlay.f21367h.isTouchExplorationEnabled() && reactionsDockOverlay.m29060c(motionEvent)))) {
                reactionsDockOverlay.f21376q = TouchMode.DRAG;
                reactionsDockOverlay.m29059b(TouchMode.DRAG);
            }
            if (reactionsDockOverlay.f21376q == TouchMode.DRAG) {
                boolean z2;
                ReactionsDockView reactionsDockView = reactionsDockOverlay.f21373n;
                if (motionEvent.getAction() == 3) {
                    reactionsDockView.c();
                } else {
                    reactionsDockView.a(motionEvent.getRawX(), motionEvent.getRawY());
                }
                switch (motionEvent.getAction()) {
                    case 0:
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        if (m29061d(reactionsDockOverlay) != f21358a) {
                            m29061d(reactionsDockOverlay).getInteractionLogger().m30293c(reactionsDockOverlay.f21373n.getCurrentReaction());
                            break;
                        }
                        break;
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        reactionsDockOverlay.m29054a(reactionsDockOverlay.f21373n.getCurrentReaction());
                        reactionsDockOverlay.m29065b();
                        m29061d(reactionsDockOverlay).mo3156a(reactionsDockOverlay.f21373n.getCurrentReaction());
                        if (reactionsDockOverlay.f21373n.getCurrentReaction() != FeedbackReaction.f21476c) {
                            reactionsDockOverlay.m29056a(reactionsDockOverlay.f21361b.getResources().getString(2131235957, new Object[]{reactionsDockOverlay.f21373n.getCurrentReaction().f21479f}));
                            break;
                        }
                        ((FBSoundUtil) reactionsDockOverlay.f21363d.get()).b("reactions_cancel");
                        reactionsDockOverlay.m29056a(reactionsDockOverlay.f21371l);
                        break;
                    case 3:
                        reactionsDockOverlay.m29065b();
                        break;
                }
                ReactionsDockSupport d = m29061d(reactionsDockOverlay);
                if (reactionsDockOverlay.f21373n.getCurrentReaction() == FeedbackReaction.f21476c) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                d.mo3158b(z2);
            } else if (reactionsDockOverlay.f21376q == TouchMode.LINGER) {
                m29061d(reactionsDockOverlay).mo3158b(false);
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                reactionsDockOverlay.f21378s = -1;
            }
        }
    }

    public final void m29064a(ReactionsDockSupport reactionsDockSupport) {
        this.f21377r = new WeakReference(reactionsDockSupport);
    }

    public static ReactionsDockSupport m29061d(ReactionsDockOverlay reactionsDockOverlay) {
        if (reactionsDockOverlay.f21377r.get() != null) {
            return (ReactionsDockSupport) reactionsDockOverlay.f21377r.get();
        }
        return f21358a;
    }

    private boolean m29060c(MotionEvent motionEvent) {
        return ((double) this.f21369j) < Math.hypot((double) Math.abs(motionEvent.getRawX() - ((float[]) this.f21375p.get())[0]), (double) Math.abs(motionEvent.getRawY() - ((float[]) this.f21375p.get())[1]));
    }

    private void m29058b(View view) {
        int height;
        int i = 0;
        this.f21373n.setupReactions(m29061d(this).getSupportedReactions());
        this.f21373n.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        ReactionsDockView$DockPosition reactionsDockView$DockPosition = iArr[1] < this.f21373n.getMeasuredHeight() ? ReactionsDockView$DockPosition.BELOW_FOOTER : ReactionsDockView$DockPosition.ABOVE_FOOTER;
        m29061d(this).getInteractionLogger().f22370i = reactionsDockView$DockPosition;
        ReactionsDockView reactionsDockView = this.f21373n;
        int i2 = m29061d(this).getDockTheme().backgroundColor;
        if (i2 == -1) {
            reactionsDockView.E = reactionsDockView.C;
        } else {
            if (reactionsDockView.D != i2) {
                reactionsDockView.D = i2;
                if (reactionsDockView.F == null) {
                    reactionsDockView.F = reactionsDockView.C.getConstantState().newDrawable();
                    reactionsDockView.F.mutate();
                }
                reactionsDockView.E = reactionsDockView.b.m11491a(reactionsDockView.F, i2);
            }
            reactionsDockView.E = reactionsDockView.F;
        }
        int i3 = iArr[1];
        if (reactionsDockView$DockPosition == ReactionsDockView$DockPosition.ABOVE_FOOTER) {
            height = view.getHeight() - this.f21373n.getMeasuredHeight();
        } else {
            height = 0;
        }
        i2 = i3 + height;
        if (this.f21361b.getResources().getConfiguration().orientation == 2) {
            height = 1;
        } else {
            height = 0;
        }
        if (height != 0 || this.f21364e) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            height = ((int) ((float[]) this.f21375p.get())[0]) - this.f21370k;
        } else {
            height = 0;
        }
        if (i3 != 0 && this.f21365f.m6557a()) {
            height -= this.f21373n.getMeasuredWidth();
        }
        if (height >= 0) {
            i = height;
        }
        if (this.f21374o.isShowing()) {
            this.f21374o.update(i, i2, this.f21373n.getMeasuredWidth(), this.f21373n.getMeasuredHeight());
        } else {
            if (i3 != 0) {
                height = 3;
            } else {
                height = 1;
            }
            this.f21374o.setWidth(this.f21373n.getMeasuredWidth());
            this.f21374o.setHeight(this.f21373n.getMeasuredHeight());
            this.f21374o.showAtLocation(view, height | 48, i, i2);
        }
        reactionsDockView = this.f21373n;
        reactionsDockView.H = reactionsDockView$DockPosition;
        reactionsDockView.d();
        m29056a(this.f21372m);
        this.f21366g.mo468b(8519683, (short) 2);
        this.f21366g.mo468b(8519684, (short) 2);
    }

    private void m29059b(TouchMode touchMode) {
        if (m29061d(this) != f21358a) {
            ReactionsFooterInteractionLogger interactionLogger = m29061d(this).getInteractionLogger();
            Preconditions.checkArgument(touchMode != TouchMode.NONE);
            interactionLogger.f22363b.m8043b(ReactionsFooterInteractionLogger.f22362a, touchMode.name());
            if (interactionLogger.f22372k == TouchMode.NONE) {
                interactionLogger.f22372k = touchMode;
            }
        }
    }

    private void m29054a(FeedbackReaction feedbackReaction) {
        if (m29061d(this) != f21358a && feedbackReaction != FeedbackReaction.f21476c) {
            m29061d(this).getInteractionLogger().f22363b.m8038a(ReactionsFooterInteractionLogger.f22362a, "reaction_selected", Integer.toString(feedbackReaction.f21478e));
        }
    }

    private void m29056a(CharSequence charSequence) {
        if (VERSION.SDK_INT >= 16) {
            this.f21373n.announceForAccessibility(charSequence);
        }
    }
}
