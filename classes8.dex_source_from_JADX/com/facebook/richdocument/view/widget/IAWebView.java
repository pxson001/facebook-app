package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Picture;
import android.net.Uri;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;
import android.webkit.WebViewClient;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.view.util.WebViewUtils;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import javax.inject.Inject;

/* compiled from: open_friend_inviter */
public class IAWebView extends PerfLoggingWebView implements PictureListener, InjectableComponentWithoutContext {
    private static final SpringConfig f7172g = SpringConfig.a(280.0d, 38.0d);
    @Inject
    SecureContextHelper f7173a;
    @Inject
    MonotonicClock f7174b;
    @Inject
    RichDocumentAnalyticsLogger f7175c;
    @Inject
    SpringSystem f7176d;
    @Inject
    GatekeeperStoreImpl f7177e;
    public final Transitioner f7178h = new Transitioner(this);
    public long f7179i;
    public float f7180j;
    private float f7181k;
    public int f7182l;
    public int f7183m;
    public int f7184n;
    public Spring f7185o;
    public int f7186p;
    private boolean f7187q;

    /* compiled from: open_friend_inviter */
    class IAWebViewClient extends WebViewClient {
        final /* synthetic */ IAWebView f7165a;

        public IAWebViewClient(IAWebView iAWebView) {
            this.f7165a = iAWebView;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (this.f7165a.f7174b.now() - this.f7165a.f7179i > 100) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.putExtra("com.android.browser.headers", WebViewUtils.m7371a());
            this.f7165a.f7173a.b(intent, this.f7165a.getContext());
            this.f7165a.f7175c.m5369b(str, null);
            this.f7165a.f7175c.m5368b(str, "WEBVIEW");
            return true;
        }
    }

    /* compiled from: open_friend_inviter */
    public class Transitioner implements SpringListener {
        public final /* synthetic */ IAWebView f7166a;
        public int f7167b;

        public Transitioner(IAWebView iAWebView) {
            this.f7166a = iAWebView;
        }

        public final void m7443a() {
            this.f7166a.f7185o.l();
        }

        public final void m7446c(Spring spring) {
        }

        public final void m7444a(Spring spring) {
            IAWebView iAWebView = this.f7166a;
            int d = (int) spring.d();
            if (d < iAWebView.f7182l) {
                iAWebView.f7186p = iAWebView.f7182l;
            } else if (d > iAWebView.f7183m) {
                iAWebView.f7186p = iAWebView.f7183m;
            } else {
                iAWebView.f7186p = d;
            }
            iAWebView.requestLayout();
        }

        public final void m7445b(Spring spring) {
        }

        public final void m7447d(Spring spring) {
        }
    }

    public static void m7455a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((IAWebView) obj).m7454a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector), RichDocumentAnalyticsLogger.m5360a(fbInjector), SpringSystem.b(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector));
    }

    public IAWebView(Context context) {
        super(context);
        m7456b();
    }

    public IAWebView(Context context, Context context2) {
        super(context, context2);
        m7453a(context2);
    }

    private void m7456b() {
        m7453a(null);
    }

    private void m7453a(Context context) {
        if (context == null) {
            context = getContext();
        }
        Class cls = IAWebView.class;
        m7455a(this, context);
        Spring c = this.f7176d.a().a(f7172g).c(300.0d);
        c.c = true;
        this.f7185o = c.l();
        this.f7185o.a(this.f7178h);
        setWebViewClient(new IAWebViewClient(this));
        super.setPictureListener(this);
        if (this.f7177e.a(113, false)) {
            setLayerType(2, null);
        }
    }

    public float getFallbackAspectRatio() {
        return this.f7180j;
    }

    public void setFallbackAspectRatio(float f) {
        this.f7180j = f;
        this.f7178h.m7443a();
        invalidate();
    }

    public void setHeightRangeAspectRatio(float f) {
        this.f7181k = f;
        this.f7182l = 0;
        this.f7183m = 0;
        requestLayout();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f7181k > 0.0f && this.f7182l == 0 && this.f7183m == 0) {
            this.f7184n = (int) (((float) getMeasuredWidth()) / this.f7181k);
            this.f7182l = (int) (((float) this.f7184n) * 0.9f);
            this.f7183m = (int) (((float) this.f7184n) * 1.1f);
        }
        int i3 = getLayoutParams().height;
        if (i3 != -2 && i3 > 0) {
            return;
        }
        if (this.f7186p > 0) {
            setMeasuredDimension(getMeasuredWidth(), this.f7186p);
        } else if (this.f7184n > 0) {
            setMeasuredDimension(getMeasuredWidth(), this.f7184n);
        } else if (this.f7180j > 0.0f) {
            setMeasuredDimension(getMeasuredWidth(), (int) (((float) getMeasuredWidth()) / this.f7180j));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1862836146);
        if (motionEvent.getAction() == 1) {
            this.f7179i = this.f7174b.now();
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -1433300592, a);
        return onTouchEvent;
    }

    public void onNewPicture(WebView webView, Picture picture) {
        int contentHeight = (int) (((float) webView.getContentHeight()) * webView.getScale());
        Transitioner transitioner = this.f7178h;
        if (contentHeight != transitioner.f7167b) {
            transitioner.f7167b = contentHeight;
            transitioner.f7166a.getLocationOnScreen(new int[2]);
            transitioner.f7166a.f7185o.a((double) transitioner.f7166a.getMeasuredHeight());
            transitioner.f7166a.f7185o.b((double) transitioner.f7167b);
        }
    }

    public void setPictureListener(PictureListener pictureListener) {
        throw new UnsupportedOperationException("setPictureListener not supported by IAWebView");
    }

    public void stopLoading() {
        this.f7187q = true;
        super.stopLoading();
    }

    private void m7454a(SecureContextHelper secureContextHelper, MonotonicClock monotonicClock, RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, SpringSystem springSystem, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f7173a = secureContextHelper;
        this.f7174b = monotonicClock;
        this.f7175c = richDocumentAnalyticsLogger;
        this.f7176d = springSystem;
        this.f7177e = gatekeeperStoreImpl;
    }
}
