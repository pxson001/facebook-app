package com.facebook.chatheads.view;

import android.content.Context;
import android.os.Handler;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.ui.text.MultilineEllipsizeTextView;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.MaskedFrameLayout;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;

/* compiled from: read=0 or seen=0 */
public class ChatHeadTextBubbleView extends CustomFrameLayout {
    private static final SpringConfig f5808d = SpringConfig.a(40.0d, 7.0d);
    @Inject
    @ForUiThread
    public Handler f5809a;
    @Inject
    public SpringSystem f5810b;
    @Inject
    public AbstractFbErrorReporter f5811c;
    private final Spring f5812e;
    private final Spring f5813f;
    public boolean f5814g;
    private final MaskedFrameLayout f5815h;
    private final MultilineEllipsizeTextView f5816i;
    private final MaskedFrameLayout f5817j;
    private final MultilineEllipsizeTextView f5818k;
    private int f5819l;
    private final Runnable f5820m;
    public Origin f5821n;
    private DisplayMode f5822o;
    private GestureDetector f5823p;
    public SettableFuture<Void> f5824q;
    public SettableFuture<Void> f5825r;
    public OnTextBubbleAutoHideListener f5826s;
    private OnClickListener f5827t;

    /* compiled from: read=0 or seen=0 */
    class C06091 implements Runnable {
        final /* synthetic */ ChatHeadTextBubbleView f5801a;

        C06091(ChatHeadTextBubbleView chatHeadTextBubbleView) {
            this.f5801a = chatHeadTextBubbleView;
        }

        public void run() {
            this.f5801a.f5824q;
        }
    }

    /* compiled from: read=0 or seen=0 */
    class C06102 implements OnClickListener {
        final /* synthetic */ ChatHeadTextBubbleView f5802a;

        C06102(ChatHeadTextBubbleView chatHeadTextBubbleView) {
            this.f5802a = chatHeadTextBubbleView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1441743616);
            this.f5802a.m6023a(view);
            Logger.a(2, EntryType.UI_INPUT_END, -1187354621, a);
        }
    }

    /* compiled from: read=0 or seen=0 */
    class C06113 implements FutureCallback<Void> {
        final /* synthetic */ ChatHeadTextBubbleView f5803a;

        C06113(ChatHeadTextBubbleView chatHeadTextBubbleView) {
            this.f5803a = chatHeadTextBubbleView;
        }

        public void onSuccess(Object obj) {
            if (this.f5803a.f5826s != null) {
                OnTextBubbleAutoHideListener onTextBubbleAutoHideListener = this.f5803a.f5826s;
            }
        }

        public void onFailure(Throwable th) {
            if (!(th instanceof CancellationException)) {
                this.f5803a.f5811c.a("ChatHeadTextBubbleView", "handleTimeout onFailure", th);
            }
        }
    }

    /* compiled from: read=0 or seen=0 */
    class ClickStateSpringListener extends SimpleSpringListener {
        final /* synthetic */ ChatHeadTextBubbleView f5804a;

        public ClickStateSpringListener(ChatHeadTextBubbleView chatHeadTextBubbleView) {
            this.f5804a = chatHeadTextBubbleView;
        }

        public final void m6015a(Spring spring) {
            ChatHeadTextBubbleView.m6041h(this.f5804a);
        }

        public final void m6016b(Spring spring) {
            if (this.f5804a.f5825r != null) {
                FutureDetour.a(this.f5804a.f5825r, null, -1854834356);
                this.f5804a.f5825r = null;
            }
        }
    }

    /* compiled from: read=0 or seen=0 */
    public enum DisplayMode {
        MESSENGER,
        SMS
    }

    /* compiled from: read=0 or seen=0 */
    class MyOnGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ ChatHeadTextBubbleView f5805a;
        private boolean f5806b;

        public MyOnGestureListener(ChatHeadTextBubbleView chatHeadTextBubbleView) {
            this.f5805a = chatHeadTextBubbleView;
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.f5805a.m6045e();
            this.f5805a.f5814g = false;
            this.f5806b = false;
            this.f5805a.m6031b(1.0d);
            return false;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f5805a.f5814g = true;
            if (!this.f5806b) {
                this.f5806b = true;
                this.f5805a.m6031b(0.0d);
            }
            float rawX = ((ChatHeadTextBubbleView.m6042i(this.f5805a) ? -1.0f : 1.0f) * (motionEvent2.getRawX() - motionEvent.getRawX())) / ((float) ChatHeadTextBubbleView.getCurrentTextBubbleView(this.f5805a).getWidth());
            if (rawX < 0.0f) {
                return false;
            }
            this.f5805a.m6020a((double) (1.0f - rawX));
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if ((!ChatHeadTextBubbleView.m6042i(this.f5805a) || f >= 0.0f) && (ChatHeadTextBubbleView.m6042i(this.f5805a) || f <= 0.0f)) {
                this.f5805a.m6043a();
            } else {
                this.f5805a.m6044b();
            }
            return true;
        }
    }

    /* compiled from: read=0 or seen=0 */
    public interface OnTextBubbleAutoHideListener {
    }

    /* compiled from: read=0 or seen=0 */
    public enum Origin {
        RIGHT,
        LEFT
    }

    /* compiled from: read=0 or seen=0 */
    class ShowToggleSpringListener extends SimpleSpringListener {
        final /* synthetic */ ChatHeadTextBubbleView f5807a;

        public ShowToggleSpringListener(ChatHeadTextBubbleView chatHeadTextBubbleView) {
            this.f5807a = chatHeadTextBubbleView;
        }

        public final void m6019c(Spring spring) {
            this.f5807a.setVisibility(0);
        }

        public final void m6017a(Spring spring) {
            ChatHeadTextBubbleView.m6041h(this.f5807a);
        }

        public final void m6018b(Spring spring) {
            if (spring.d() == 0.0d) {
                this.f5807a.setVisibility(8);
            }
            if (this.f5807a.f5824q != null) {
                FutureDetour.a(this.f5807a.f5824q, null, 1902917349);
                this.f5807a.f5824q = null;
            }
        }
    }

    private static <T extends View> void m6027a(Class<T> cls, T t) {
        m6028a((Object) t, t.getContext());
    }

    private static void m6028a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ChatHeadTextBubbleView chatHeadTextBubbleView = (ChatHeadTextBubbleView) obj;
        Handler b = Handler_ForUiThreadMethodAutoProvider.b(fbInjector);
        SpringSystem b2 = SpringSystem.b(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        chatHeadTextBubbleView.f5809a = b;
        chatHeadTextBubbleView.f5810b = b2;
        chatHeadTextBubbleView.f5811c = abstractFbErrorReporter;
    }

    public ChatHeadTextBubbleView(Context context) {
        this(context, null);
    }

    public ChatHeadTextBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatHeadTextBubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5819l = 5000;
        this.f5820m = new C06091(this);
        this.f5822o = DisplayMode.MESSENGER;
        m6027a(ChatHeadTextBubbleView.class, (View) this);
        setContentView(2130905576);
        this.f5815h = (MaskedFrameLayout) c(2131564471);
        this.f5816i = (MultilineEllipsizeTextView) c(2131564472);
        this.f5817j = (MaskedFrameLayout) c(2131564473);
        this.f5818k = (MultilineEllipsizeTextView) c(2131564474);
        setOrigin(Origin.LEFT);
        super.setOnClickListener(new C06102(this));
        this.f5823p = new GestureDetector(context, new MyOnGestureListener(this));
        Spring a = this.f5810b.a().a(f5808d);
        a.l = 0.0010000000474974513d;
        a = a;
        a.k = 0.0010000000474974513d;
        this.f5812e = a.a(new ShowToggleSpringListener(this));
        a = this.f5810b.a().a(f5808d);
        a.l = 0.0010000000474974513d;
        a = a;
        a.k = 0.0010000000474974513d;
        this.f5813f = a.a(new ClickStateSpringListener(this));
    }

    public void setDisplayMode(DisplayMode displayMode) {
        if (this.f5822o != displayMode) {
            this.f5822o = displayMode;
            int i = this.f5822o == DisplayMode.SMS ? 2130842299 : 2130841916;
            this.f5816i.setBackgroundResource(i);
            this.f5818k.setBackgroundResource(i);
        }
    }

    public Origin getOrigin() {
        return this.f5821n;
    }

    public void setOrigin(Origin origin) {
        if (this.f5821n != origin) {
            this.f5821n = origin;
            if (this.f5821n == Origin.LEFT) {
                this.f5815h.setVisibility(0);
                this.f5817j.setVisibility(8);
                return;
            }
            this.f5815h.setVisibility(8);
            this.f5817j.setVisibility(0);
        }
    }

    public void setOnTextBubbleAutoHideListener(OnTextBubbleAutoHideListener onTextBubbleAutoHideListener) {
        this.f5826s = onTextBubbleAutoHideListener;
    }

    public void setMaxLines(int i) {
        this.f5816i.setMaxLines(i);
        this.f5818k.setMaxLines(i);
    }

    public void setTextBubbleDisplayTimeout(int i) {
        this.f5819l = i;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f5827t = onClickListener;
    }

    public void setMessage(Spanned spanned) {
        this.f5816i.setText(spanned);
        this.f5818k.setText(spanned);
    }

    public final ListenableFuture<Void> m6043a() {
        m6038f();
        return m6020a(1.0d);
    }

    public final ListenableFuture<Void> m6044b() {
        m6045e();
        return m6020a(0.0d);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 805601189);
        super.onSizeChanged(i, i2, i3, i4);
        this.f5815h.setPivotX(0.0f);
        this.f5815h.setPivotY((float) (i2 / 2));
        this.f5817j.setPivotX((float) i);
        this.f5817j.setPivotY((float) (i2 / 2));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 29816752, a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1822506675);
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            boolean z2 = this.f5814g;
            this.f5814g = false;
            if (!z2 || this.f5812e.i > 0.6d) {
                m6043a();
                m6038f();
            } else {
                m6044b();
                Logger.a(2, EntryType.UI_INPUT_END, -1969267294, a);
                return true;
            }
        }
        if (this.f5823p.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent)) {
            z = true;
        }
        LogUtils.a(-3377703, a);
        return z;
    }

    private void m6023a(View view) {
        m6031b(0.0d);
        if (this.f5827t != null) {
            this.f5827t.onClick(view);
        }
    }

    private void m6038f() {
        m6045e();
        HandlerDetour.b(this.f5809a, this.f5820m, (long) this.f5819l, 1684039782);
    }

    public final void m6045e() {
        HandlerDetour.a(this.f5809a, this.f5820m);
    }

    public static void m6040g(ChatHeadTextBubbleView chatHeadTextBubbleView) {
        Futures.a(chatHeadTextBubbleView.m6044b(), new C06113(chatHeadTextBubbleView));
    }

    private ListenableFuture<Void> m6020a(double d) {
        boolean z = false;
        if (this.f5812e.i != d) {
            if (this.f5824q != null) {
                this.f5824q.cancel(false);
            }
            this.f5824q = SettableFuture.f();
            Spring spring = this.f5812e;
            if (d != 0.0d) {
                z = true;
            }
            spring.c = z;
            this.f5812e.b(d);
            return this.f5824q;
        } else if (this.f5824q != null) {
            return this.f5824q;
        } else {
            return Futures.a(null);
        }
    }

    private ListenableFuture<Void> m6031b(double d) {
        if (d != this.f5813f.i) {
            boolean z;
            this.f5825r = SettableFuture.f();
            Spring spring = this.f5813f;
            if (d != 0.0d) {
                z = true;
            } else {
                z = false;
            }
            spring.c = z;
            this.f5813f.b(d);
            return this.f5825r;
        } else if (this.f5825r != null) {
            return this.f5825r;
        } else {
            return Futures.a(null);
        }
    }

    public static void m6041h(ChatHeadTextBubbleView chatHeadTextBubbleView) {
        float d = (float) chatHeadTextBubbleView.f5812e.d();
        float d2 = (float) chatHeadTextBubbleView.f5813f.d();
        m6024a(chatHeadTextBubbleView.f5815h, d, d2);
        m6024a(chatHeadTextBubbleView.f5817j, d, d2);
    }

    private static void m6024a(View view, float f, float f2) {
        float f3 = (-0.09f * f2) + f;
        view.setScaleX(f3);
        view.setScaleY(f3);
        view.setAlpha(Math.max(0.0f, Math.min(f, 1.0f)));
    }

    public static MultilineEllipsizeTextView getCurrentTextBubbleView(ChatHeadTextBubbleView chatHeadTextBubbleView) {
        return m6042i(chatHeadTextBubbleView) ? chatHeadTextBubbleView.f5816i : chatHeadTextBubbleView.f5818k;
    }

    public static boolean m6042i(ChatHeadTextBubbleView chatHeadTextBubbleView) {
        return chatHeadTextBubbleView.f5821n == Origin.LEFT;
    }
}
