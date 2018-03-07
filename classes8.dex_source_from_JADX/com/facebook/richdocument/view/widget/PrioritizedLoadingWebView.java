package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: open_composer_tap */
public class PrioritizedLoadingWebView extends WebView {
    public final List<OnPageFinishedListener> f7168a = new CopyOnWriteArrayList();

    /* compiled from: open_composer_tap */
    public interface OnPageFinishedListener {
        void mo461a();

        void mo462b();

        void mo463c();
    }

    /* compiled from: open_composer_tap */
    public class DelegatingWebViewClient extends WebViewClient {
        final /* synthetic */ PrioritizedLoadingWebView f7248a;
        private final WebViewClient f7249b;

        public DelegatingWebViewClient(PrioritizedLoadingWebView prioritizedLoadingWebView, WebViewClient webViewClient) {
            this.f7248a = prioritizedLoadingWebView;
            this.f7249b = webViewClient;
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (this.f7249b != null) {
                this.f7249b.doUpdateVisitedHistory(webView, str, z);
            }
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            if (this.f7249b != null) {
                this.f7249b.onFormResubmission(webView, message, message2);
            }
        }

        public void onLoadResource(WebView webView, String str) {
            if (this.f7249b != null) {
                this.f7249b.onLoadResource(webView, str);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            for (OnPageFinishedListener a : this.f7248a.f7168a) {
                a.mo461a();
            }
            if (this.f7249b != null) {
                this.f7249b.onPageFinished(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (this.f7249b != null) {
                this.f7249b.onPageStarted(webView, str, bitmap);
            }
        }

        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            if (this.f7249b != null) {
                this.f7249b.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            for (OnPageFinishedListener b : this.f7248a.f7168a) {
                b.mo462b();
            }
            if (this.f7249b != null) {
                this.f7249b.onReceivedError(webView, i, str, str2);
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            if (this.f7249b != null) {
                this.f7249b.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if (this.f7249b != null) {
                this.f7249b.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            for (OnPageFinishedListener c : this.f7248a.f7168a) {
                c.mo463c();
            }
            if (this.f7249b != null) {
                this.f7249b.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        public void onScaleChanged(WebView webView, float f, float f2) {
            if (this.f7249b != null) {
                this.f7249b.onScaleChanged(webView, f, f2);
            }
        }

        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            if (this.f7249b != null) {
                this.f7249b.onTooManyRedirects(webView, message, message2);
            }
        }

        public void onUnhandledInputEvent(WebView webView, InputEvent inputEvent) {
            if (this.f7249b != null) {
                this.f7249b.onUnhandledInputEvent(webView, inputEvent);
            }
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (this.f7249b != null) {
                this.f7249b.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (this.f7249b == null) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            return this.f7249b.shouldInterceptRequest(webView, webResourceRequest);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (this.f7249b == null) {
                return super.shouldInterceptRequest(webView, str);
            }
            return this.f7249b.shouldInterceptRequest(webView, str);
        }

        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (this.f7249b == null) {
                return super.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return this.f7249b.shouldOverrideKeyEvent(webView, keyEvent);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (this.f7249b == null) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return this.f7249b.shouldOverrideUrlLoading(webView, str);
        }
    }

    public PrioritizedLoadingWebView(Context context) {
        super(context);
        setWebViewClient(new DelegatingWebViewClient(this, null));
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(new DelegatingWebViewClient(this, webViewClient));
    }

    public void destroy() {
        this.f7168a.clear();
        super.destroy();
    }

    public final void m7448a(OnPageFinishedListener onPageFinishedListener) {
        if (!this.f7168a.contains(onPageFinishedListener)) {
            this.f7168a.add(onPageFinishedListener);
        }
    }

    public final void m7449b(OnPageFinishedListener onPageFinishedListener) {
        this.f7168a.remove(onPageFinishedListener);
    }
}
