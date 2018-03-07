package com.facebook.http.onion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.facebook.http.onion.impl.FbOnionRewriter;
import com.facebook.inject.FbInjector;
import java.util.Map;

@SuppressLint({"DeprecatedSuperclass", "BadMethodUse-android.webkit.WebView.loadUrl", "BadSuperClassWebView.OnionWebView"})
/* compiled from: direct_node_load */
public class OnionWebView extends WebView {
    public TorProxy f5060a;
    public FbOnionRewriter f5061b;

    public static void m9981a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        OnionWebView onionWebView = (OnionWebView) obj;
        TorProxy b = TorProxyMethodAutoProvider.b(fbInjector);
        FbOnionRewriter a = FbOnionRewriter.a(fbInjector);
        onionWebView.f5060a = b;
        onionWebView.f5061b = a;
    }

    public OnionWebView(Context context) {
        this(context, null);
    }

    public OnionWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OnionWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = OnionWebView.class;
        m9981a(this, getContext());
        this.f5060a.a(this);
    }

    public void loadUrl(String str) {
        loadUrl(str, null);
    }

    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(this.f5061b.a(str), map);
    }
}
