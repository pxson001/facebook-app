package com.facebook.neko.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.facebook.resources.ui.FbTextView;

/* compiled from: tintColor */
public class HackWebViewClient extends WebViewClient {
    private String f892a;
    private ProgressBar f893b;
    private Context f894c;
    private FbTextView f895d;
    private boolean f896e;

    public HackWebViewClient(String str, ProgressBar progressBar, Context context, FbTextView fbTextView) {
        this.f892a = str;
        this.f893b = progressBar;
        this.f894c = context;
        this.f895d = fbTextView;
    }

    public void onPageFinished(WebView webView, String str) {
        if (!this.f896e) {
            this.f893b.setVisibility(8);
            webView.setVisibility(0);
            super.onPageFinished(webView, str);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.equals(this.f892a)) {
            return false;
        }
        this.f894c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (i == -2) {
            m1163a();
        }
    }

    private void m1163a() {
        this.f896e = true;
        AnimationUtils.m1114a(this.f893b, this.f895d, 4);
    }
}
