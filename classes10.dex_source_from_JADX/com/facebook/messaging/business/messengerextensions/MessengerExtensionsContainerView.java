package com.facebook.messaging.business.messengerextensions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.browser.MessengerWebViewHelper;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.send.client.OutgoingMessageFactory;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.statusbar.StatusBarUtil;
import com.facebook.widget.CustomFrameLayout;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: thread_event_reminder_time */
public final class MessengerExtensionsContainerView extends CustomFrameLayout {
    @Inject
    StatusBarUtil f1611a;
    @Inject
    SpringSystem f1612b;
    @Inject
    MessengerWebViewHelper f1613c;
    @Inject
    MessengerExtensionsJSBridgeHelper f1614d;
    public DismissAnimationEventListener f1615e;
    private boolean f1616f;
    private float f1617g = 0.8f;
    private Spring f1618h;
    public FrameLayout f1619i;

    /* compiled from: thread_event_reminder_time */
    class C02601 implements OnClickListener {
        final /* synthetic */ MessengerExtensionsContainerView f1609a;

        C02601(MessengerExtensionsContainerView messengerExtensionsContainerView) {
            this.f1609a = messengerExtensionsContainerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -54363586);
            this.f1609a.m1590a();
            Logger.a(2, EntryType.UI_INPUT_END, -1355024929, a);
        }
    }

    /* compiled from: thread_event_reminder_time */
    class C02612 extends SimpleSpringListener {
        final /* synthetic */ MessengerExtensionsContainerView f1610a;

        C02612(MessengerExtensionsContainerView messengerExtensionsContainerView) {
            this.f1610a = messengerExtensionsContainerView;
        }

        public final void m1578a(Spring spring) {
            this.f1610a.f1619i.setTranslationY((float) spring.d());
            if (this.f1610a.getBottom() > 0) {
                this.f1610a.getBackground().mutate().setAlpha(Math.max(0, Math.min((int) ((1.0f - (((float) spring.d()) / ((float) this.f1610a.getBottom()))) * 153.0f), 255)));
            }
        }

        public final void m1579b(Spring spring) {
            if (spring.d() == ((double) MessengerExtensionsContainerView.getViewportSize(this.f1610a).y) && this.f1610a.f1615e != null) {
                this.f1610a.f1615e.mo53a();
            }
        }
    }

    /* compiled from: thread_event_reminder_time */
    public interface DismissAnimationEventListener extends MessengerExtensionsEventListener {
        void mo53a();
    }

    private static <T extends View> void m1585a(Class<T> cls, T t) {
        m1586a((Object) t, t.getContext());
    }

    private static void m1586a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MessengerExtensionsContainerView) obj).m1584a(StatusBarUtil.a(fbInjector), SpringSystem.b(fbInjector), MessengerWebViewHelper.b(fbInjector), new MessengerExtensionsJSBridgeHelper(IdBasedProvider.a(fbInjector, 3595), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), OutgoingMessageFactory.a(fbInjector), SendMessageManager.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), SecureWebViewHelper.a(fbInjector)));
    }

    private void m1584a(StatusBarUtil statusBarUtil, SpringSystem springSystem, MessengerWebViewHelper messengerWebViewHelper, MessengerExtensionsJSBridgeHelper messengerExtensionsJSBridgeHelper) {
        this.f1611a = statusBarUtil;
        this.f1612b = springSystem;
        this.f1613c = messengerWebViewHelper;
        this.f1614d = messengerExtensionsJSBridgeHelper;
    }

    public MessengerExtensionsContainerView(Context context) {
        super(context);
        m1588b();
    }

    public MessengerExtensionsContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m1588b();
    }

    public MessengerExtensionsContainerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1588b();
    }

    @SuppressLint({"ConstructorMayLeakThis", "SetJavaScriptEnabled"})
    private void m1588b() {
        m1585a(MessengerExtensionsContainerView.class, (View) this);
        setBackgroundDrawable(new ColorDrawable(-16777216));
        getBackground().mutate().setAlpha(0);
        setContentView(2130905248);
        this.f1619i = (FrameLayout) c(2131563839);
        this.f1619i.setLayoutParams(new LayoutParams(getViewportSize(this).x, getWebViewHolderHeight()));
        this.f1618h = this.f1612b.a().a(new SpringConfig(700.0d, 48.0d)).a(getSpringEventListener());
        this.f1613c.d = (ProgressBar) c(2131563840);
        View a = this.f1613c.a();
        this.f1619i.addView(a);
        this.f1614d.f1641k = a;
        a.getSettings().setJavaScriptEnabled(true);
        a.addJavascriptInterface(new MessengerExtensionsJSBridge(this.f1614d), "MESSENGER");
        a.setLayoutParams(new LayoutParams(getViewportSize(this).x, getWebViewHolderHeight() - this.f1611a.a(null)));
        setOnClickListener(new C02601(this));
    }

    public final void m1591a(@Nullable String str, @Nullable ThreadKey threadKey, @Nullable DismissAnimationEventListener dismissAnimationEventListener) {
        this.f1615e = dismissAnimationEventListener;
        MessengerExtensionsJSBridgeHelper messengerExtensionsJSBridgeHelper = this.f1614d;
        messengerExtensionsJSBridgeHelper.f1637g = str;
        messengerExtensionsJSBridgeHelper.f1638h = threadKey;
        messengerExtensionsJSBridgeHelper.f1639i = dismissAnimationEventListener;
        if (messengerExtensionsJSBridgeHelper.f1637g != null) {
            messengerExtensionsJSBridgeHelper.f1641k.loadUrl(messengerExtensionsJSBridgeHelper.f1637g.toString());
        }
    }

    public final void setShowRatio(float f) {
        this.f1617g = f;
    }

    public final void m1590a() {
        this.f1616f = true;
        this.f1618h.c = true;
        this.f1618h.l();
        this.f1618h.a((double) (getViewportSize(this).y - getWebViewHolderHeight()));
        this.f1618h.b((double) getViewportSize(this).y);
    }

    protected final void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -968298365);
        super.onDetachedFromWindow();
        this.f1613c.b();
        this.f1618h.l();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 57218182, a);
    }

    protected final void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 968112314);
        super.onAttachedToWindow();
        this.f1616f = false;
        this.f1618h.c = false;
        this.f1618h.a((double) getViewportSize(this).y);
        this.f1618h.b((double) (getViewportSize(this).y - getWebViewHolderHeight()));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1210907460, a);
    }

    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.f1616f) {
            this.f1618h.c = false;
            this.f1618h.a((double) (getViewportSize(this).y - getWebViewHolderHeight()));
            this.f1618h.b((double) getViewportSize(this).y);
        }
    }

    private int getWebViewHolderHeight() {
        return (int) (((float) (getViewportSize(this).y - this.f1611a.a(null))) * this.f1617g);
    }

    public static Point getViewportSize(MessengerExtensionsContainerView messengerExtensionsContainerView) {
        WindowManager windowManager = (WindowManager) messengerExtensionsContainerView.getContext().getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point;
    }

    private SimpleSpringListener getSpringEventListener() {
        return new C02612(this);
    }
}
