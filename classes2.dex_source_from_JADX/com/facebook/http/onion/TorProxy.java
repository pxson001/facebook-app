package com.facebook.http.onion;

import android.webkit.WebView;
import com.facebook.common.init.INeedInit;
import javax.annotation.Nullable;
import org.apache.http.HttpHost;

/* compiled from: unit_id */
public interface TorProxy extends INeedInit {

    /* compiled from: unit_id */
    public interface TorListener {
        void mo1681a();

        void mo1682a(State state, @Nullable ConnectionState connectionState);
    }

    void mo560a(WebView webView);

    void mo561a(TorListener torListener);

    boolean mo562a();

    void mo563b(TorListener torListener);

    boolean mo564b();

    HttpHost mo565c();

    void mo566d();
}
