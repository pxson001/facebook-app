package com.facebook.chatheads.view.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.facebook.bugreporter.activity.ComponentWithDebugInfo;
import com.facebook.chatheads.view.ChatHeadContentType;
import com.facebook.chatheads.view.ChatHeadPositioningStrategy;
import com.facebook.chatheads.view.SpringSystem_ForChatHeadsMethodAutoProvider;
import com.facebook.chatheads.view.SpringyPositioner;
import com.facebook.chatheads.view.SpringyPositionerProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.appstate.AppStateManager.FloatingWindowListener;
import com.facebook.common.appstate.FloatingWindowListenerMethodAutoProvider;
import com.facebook.common.hardware.ScreenPowerState;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.chatheads.annotations.ForChatHeads;
import com.facebook.messaging.chatheads.annotations.IsChatHeadsHardwareAccelerationDisabled;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.animations.AnimationUtil;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewTransform;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: reach */
public class BubbleView extends CustomFrameLayout implements ComponentWithDebugInfo {
    private static final SpringConfig f5848g = SpringConfig.a(150.0d, 12.0d);
    private static final SpringConfig f5849h = SpringConfig.a(65.0d, 8.5d);
    private boolean f5850A;
    private C06141 f5851B;
    private IdleHandler f5852C;
    private OnVisibilityChangeListener f5853D;
    @Inject
    AnimationUtil f5854a;
    @Inject
    FloatingWindowListener f5855b;
    @ForChatHeads
    @Inject
    SpringSystem f5856c;
    @Inject
    @IsChatHeadsHardwareAccelerationDisabled
    Provider<Boolean> f5857d;
    @Inject
    ScreenPowerState f5858e;
    @Inject
    SpringyPositionerProvider f5859f;
    private final Map<ChatHeadContentType, BubbleContent> f5860i;
    private SpringyPositioner f5861j;
    private ViewGroup f5862k;
    private ViewTransform f5863l;
    private ViewTransform f5864m;
    private ImageView f5865n;
    public SettableFuture<Void> f5866o;
    private Spring f5867p;
    private int f5868q;
    private ChatHeadPositioningStrategy f5869r;
    private int f5870s;
    private int f5871t;
    private int f5872u;
    private int f5873v;
    private BubbleContentAdapter f5874w;
    private ChatHeadContentType f5875x;
    public boolean f5876y;
    private boolean f5877z;

    /* compiled from: reach */
    public class C06141 {
        final /* synthetic */ BubbleView f5844a;

        C06141(BubbleView bubbleView) {
            this.f5844a = bubbleView;
        }
    }

    /* compiled from: reach */
    class C06152 implements IdleHandler {
        final /* synthetic */ BubbleView f5845a;

        C06152(BubbleView bubbleView) {
            this.f5845a = bubbleView;
        }

        public boolean queueIdle() {
            BubbleView.m6090o(this.f5845a);
            this.f5845a.getCurrentContent();
            return false;
        }
    }

    /* compiled from: reach */
    public class C06164 {
        final /* synthetic */ BubbleView f5846a;

        C06164(BubbleView bubbleView) {
            this.f5846a = bubbleView;
        }

        public final void m6058a() {
            BubbleView.m6087l(this.f5846a);
        }

        public final void m6059b() {
            BubbleView.m6087l(this.f5846a);
        }
    }

    /* compiled from: reach */
    class MyShowToggleSpringListener extends SimpleSpringListener {
        final /* synthetic */ BubbleView f5847a;

        public MyShowToggleSpringListener(BubbleView bubbleView) {
            this.f5847a = bubbleView;
        }

        public final void m6062c(Spring spring) {
            BubbleView.m6087l(this.f5847a);
        }

        public final void m6060a(Spring spring) {
            BubbleView.m6086k(this.f5847a);
        }

        public final void m6061b(Spring spring) {
            BubbleView.m6087l(this.f5847a);
            if (this.f5847a.f5866o != null) {
                FutureDetour.a(this.f5847a.f5866o, null, 561463758);
                this.f5847a.f5866o = null;
            }
            if (this.f5847a.f5876y) {
                this.f5847a.m6072b();
            } else {
                BubbleView.m6078f(this.f5847a);
            }
        }
    }

    /* compiled from: reach */
    public interface OnVisibilityChangeListener {
    }

    private static <T extends View> void m6070a(Class<T> cls, T t) {
        m6071a((Object) t, t.getContext());
    }

    private static void m6071a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BubbleView) obj).m6069a(AnimationUtil.a(fbInjector), FloatingWindowListenerMethodAutoProvider.a(fbInjector), SpringSystem_ForChatHeadsMethodAutoProvider.m6049a(fbInjector), IdBasedProvider.a(fbInjector, 4129), ScreenPowerState.a(fbInjector), (SpringyPositionerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SpringyPositionerProvider.class));
    }

    public BubbleView(Context context) {
        this(context, null);
    }

    public BubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5860i = new HashMap();
        this.f5875x = ChatHeadContentType.UNSET;
        m6070a(BubbleView.class, (View) this);
        this.f5850A = !((Boolean) this.f5857d.get()).booleanValue();
        m6088m();
        this.f5876y = false;
        this.f5851B = new C06141(this);
        this.f5852C = new C06152(this);
    }

    public void setAdapter(BubbleContentAdapter bubbleContentAdapter) {
        this.f5874w = bubbleContentAdapter;
    }

    public void setOnVisibilityChangeListener(OnVisibilityChangeListener onVisibilityChangeListener) {
        this.f5853D = onVisibilityChangeListener;
    }

    public void setContentYOffset(int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f5862k.getLayoutParams();
        marginLayoutParams.topMargin = i;
        this.f5862k.setLayoutParams(marginLayoutParams);
    }

    public ChatHeadContentType getShownContentType() {
        return this.f5875x;
    }

    private BubbleContent m6064a(ChatHeadContentType chatHeadContentType) {
        return (BubbleContent) this.f5860i.get(chatHeadContentType);
    }

    public BubbleContent getCurrentContent() {
        return m6064a(this.f5875x);
    }

    public void setChatHeadsPositioningStrategy(ChatHeadPositioningStrategy chatHeadPositioningStrategy) {
        this.f5869r = chatHeadPositioningStrategy;
    }

    public void setNubVisibility(int i) {
        this.f5864m.setVisibility(i);
    }

    public void setNubTarget(int i) {
        PointF a = m6063a(i);
        m6067a(a.x, a.y);
        this.f5868q = i;
    }

    private void m6067a(float f, float f2) {
        float signum = Math.signum((float) this.f5871t) * f2;
        this.f5864m.setTranslationX((Math.signum((float) this.f5870s) * f) - ((float) (this.f5870s / 2)));
        this.f5864m.setTranslationY(signum - ((float) (this.f5871t / 2)));
        this.f5863l.setPivotX(((float) this.f5872u) + f);
        this.f5863l.setPivotY(((float) this.f5873v) + f2);
    }

    private PointF m6063a(int i) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131427726) / 2;
        PointF a = this.f5869r.m6009a();
        a.x += (float) dimensionPixelOffset;
        a.y = ((float) dimensionPixelOffset) + a.y;
        return a;
    }

    private float getNubTargetX() {
        return this.f5863l.a.getPivotX() - ((float) this.f5872u);
    }

    private float getNubTargetY() {
        return this.f5863l.a.getPivotY() - ((float) this.f5873v);
    }

    private void m6066a() {
        m6085j();
        Resources resources = getResources();
        this.f5872u = resources.getDimensionPixelOffset(2131427758);
        this.f5873v = resources.getDimensionPixelOffset(2131427759);
        this.f5870s = resources.getDimensionPixelOffset(2131427753);
        this.f5871t = resources.getDimensionPixelOffset(2131427754);
    }

    private void m6072b() {
        getCurrentContent();
        FloatingWindowListener floatingWindowListener = this.f5855b;
        AppStateManager.K(floatingWindowListener.a);
        floatingWindowListener.a.T = true;
        floatingWindowListener.a.O = ((MonotonicClock) floatingWindowListener.a.s.get()).now();
        AppStateManager.w(floatingWindowListener.a);
        m6089n();
    }

    public static void m6077e(BubbleView bubbleView) {
        bubbleView.getCurrentContent();
    }

    public static void m6078f(BubbleView bubbleView) {
        bubbleView.getCurrentContent();
        FloatingWindowListener floatingWindowListener = bubbleView.f5855b;
        AppStateManager.L(floatingWindowListener.a);
        floatingWindowListener.a.T = false;
        floatingWindowListener.a.P = ((MonotonicClock) floatingWindowListener.a.s.get()).now();
        AppStateManager.w(floatingWindowListener.a);
    }

    private void m6080g() {
        if (this.f5867p != null) {
            this.f5867p.a();
            this.f5867p = null;
        }
        if (this.f5866o != null) {
            this.f5866o.cancel(false);
            this.f5866o = null;
        }
    }

    private void m6082h() {
        if (this.f5867p == null) {
            Spring a = this.f5856c.a().a(f5848g);
            a.k = 0.004999999888241291d;
            a = a;
            a.l = 0.004999999888241291d;
            this.f5867p = a.a(new MyShowToggleSpringListener(this));
        }
    }

    private void m6084i() {
        this.f5863l = new ViewTransform(this);
        Resources resources = getResources();
        this.f5872u = resources.getDimensionPixelOffset(2131427758);
        this.f5873v = resources.getDimensionPixelOffset(2131427759);
        this.f5861j = new SpringyPositioner(this.f5863l, SpringSystem_ForChatHeadsMethodAutoProvider.m6049a(this.f5859f));
        if (this.f5850A) {
            setScaleX(0.0f);
            setScaleY(0.0f);
            setAlpha(0.0f);
            this.f5861j.f5842g = new C06164(this);
        }
    }

    private void m6085j() {
        Resources resources = getResources();
        this.f5870s = resources.getDimensionPixelOffset(2131427753);
        this.f5871t = resources.getDimensionPixelOffset(2131427754);
        this.f5865n = (ImageView) c(2131564478);
        this.f5864m = new ViewTransform(this.f5865n);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m6086k(this);
        }
    }

    public static void m6086k(BubbleView bubbleView) {
        float f = 0.0f;
        float d = bubbleView.f5867p != null ? (float) bubbleView.f5867p.d() : 0.0f;
        if (bubbleView.f5850A) {
            bubbleView.setScaleX(d);
            bubbleView.setScaleY(d);
            bubbleView.setAlpha(Math.max(0.0f, Math.min(d, 1.0f)));
            return;
        }
        if (d <= 0.0f) {
            f = 10000.0f;
        }
        bubbleView.setTranslationX(f);
    }

    public Map<String, String> getDebugInfo() {
        BubbleContent currentContent = getCurrentContent();
        if (currentContent instanceof ComponentWithDebugInfo) {
            return ((ComponentWithDebugInfo) currentContent).getDebugInfo();
        }
        return null;
    }

    public String getCurrentAnalyticsTag() {
        BubbleContent currentContent = getCurrentContent();
        if (currentContent != null) {
            return currentContent.m6057a();
        }
        return null;
    }

    public static void m6087l(BubbleView bubbleView) {
        if (bubbleView.f5858e.a()) {
            Object obj;
            SpringyPositioner springyPositioner = bubbleView.f5861j;
            if (springyPositioner.f5839d.k() && springyPositioner.f5840e.k()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (!(obj == null && (bubbleView.f5867p == null || bubbleView.f5867p.k()))) {
                bubbleView.f5854a.a(bubbleView);
                return;
            }
        }
        bubbleView.f5854a.b(bubbleView);
    }

    private void m6069a(AnimationUtil animationUtil, FloatingWindowListener floatingWindowListener, SpringSystem springSystem, Provider<Boolean> provider, ScreenPowerState screenPowerState, SpringyPositionerProvider springyPositionerProvider) {
        this.f5854a = animationUtil;
        this.f5855b = floatingWindowListener;
        this.f5856c = springSystem;
        this.f5857d = provider;
        this.f5858e = screenPowerState;
        this.f5859f = springyPositionerProvider;
    }

    private void m6088m() {
        removeAllViewsInLayout();
        if (this.f5862k != null) {
            this.f5862k.removeAllViews();
        }
        setContentView(2130905578);
        this.f5862k = (ViewGroup) c(2131560065);
        m6082h();
        m6084i();
        m6085j();
        m6066a();
    }

    private List<BubbleContent> getBubbleContentElements() {
        return ImmutableList.copyOf(this.f5860i.values());
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1418793535);
        super.onAttachedToWindow();
        this.f5877z = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -899786653, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1941520769);
        super.onDetachedFromWindow();
        this.f5877z = false;
        m6090o(this);
        m6080g();
        Iterator it = this.f5860i.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.f5860i.clear();
        LogUtils.g(-17929140, a);
    }

    private void m6089n() {
        Looper.myQueue().addIdleHandler(this.f5852C);
    }

    public static void m6090o(BubbleView bubbleView) {
        Looper.myQueue().removeIdleHandler(bubbleView.f5852C);
    }
}
