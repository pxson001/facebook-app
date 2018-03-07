package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.richdocument.logging.WebViewPerfInfoLogger;
import com.facebook.richdocument.logging.WebViewPerfInfoLogger.WebViewPerfEventInfo;
import com.facebook.richdocument.view.widget.PrioritizedLoadingWebView.OnPageFinishedListener;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: open_all_notifications_tap */
public class PerfLoggingWebView extends PrioritizedLoadingWebView implements InjectableComponentWithoutContext {
    public String f7169a;
    public boolean f7170b;
    @Inject
    public WebViewPerfInfoLogger f7171f;

    /* compiled from: open_all_notifications_tap */
    class C08261 implements OnPageFinishedListener {
        final /* synthetic */ PerfLoggingWebView f7234a;

        C08261(PerfLoggingWebView perfLoggingWebView) {
            this.f7234a = perfLoggingWebView;
        }

        public final void mo461a() {
            this.f7234a.f7171f.m5428c(this.f7234a.f7169a);
            this.f7234a.m7449b(this);
            this.f7234a.f7170b = true;
        }

        public final void mo462b() {
            this.f7234a.f7171f.m5428c(this.f7234a.f7169a);
            this.f7234a.m7449b(this);
        }

        public final void mo463c() {
            this.f7234a.f7171f.m5428c(this.f7234a.f7169a);
            this.f7234a.m7449b(this);
        }
    }

    public static void m7452a(Object obj, Context context) {
        ((PerfLoggingWebView) obj).f7171f = WebViewPerfInfoLogger.m5422a(FbInjector.get(context));
    }

    public PerfLoggingWebView(Context context) {
        super(context);
        m7450a();
    }

    public PerfLoggingWebView(Context context, Context context2) {
        super(context);
        m7451a(context2);
    }

    private void m7450a() {
        m7451a(null);
    }

    private void m7451a(Context context) {
        if (context == null) {
            context = getContext();
        }
        Class cls = PerfLoggingWebView.class;
        m7452a(this, context);
        m7448a(new C08261(this));
    }

    public void loadData(String str, String str2, String str3) {
        super.loadData(str, str2, str3);
        this.f7171f.m5427b(this.f7169a);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        this.f7171f.m5427b(this.f7169a);
    }

    public void loadUrl(String str) {
        super.loadUrl(str);
        this.f7171f.m5427b(this.f7169a);
    }

    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(str, map);
        this.f7171f.m5427b(this.f7169a);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f7170b) {
            WebViewPerfInfoLogger webViewPerfInfoLogger = this.f7171f;
            CharSequence charSequence = this.f7169a;
            if (!StringUtil.c(charSequence) && webViewPerfInfoLogger.f5599a.containsKey(charSequence)) {
                WebViewPerfEventInfo webViewPerfEventInfo = (WebViewPerfEventInfo) webViewPerfInfoLogger.f5599a.get(charSequence);
                if (webViewPerfEventInfo != null) {
                    webViewPerfEventInfo.f5590j = webViewPerfInfoLogger.f5601c.now();
                }
            }
            this.f7170b = false;
        }
    }

    public String getBlockId() {
        return this.f7169a;
    }
}
