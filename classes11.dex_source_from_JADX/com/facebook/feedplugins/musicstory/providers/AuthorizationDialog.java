package com.facebook.feedplugins.musicstory.providers;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.content.SafeOAuthUrl;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.feedplugins.musicstory.providers.MusicProviderUtils.C10331;
import com.facebook.feedplugins.musicstory.providers.MusicProviderUtils.C10353;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger.ActionType;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.nttdocomo.android.selection */
public class AuthorizationDialog extends FbDialogFragment {
    public static final String am = AuthorizationDialog.class.getSimpleName();
    @Inject
    public SecureWebViewHelper an;
    @Nullable
    public C10331 ao;
    private WebView ap;
    public LoadingIndicatorView aq;

    /* compiled from: com.nttdocomo.android.selection */
    public class C10301 extends WebViewClient {
        String f8345a;
        final /* synthetic */ AuthorizationDialog f8346b;

        public C10301(AuthorizationDialog authorizationDialog) {
            this.f8346b = authorizationDialog;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            this.f8346b.aq.setVisibility(0);
            this.f8346b.aq.a();
        }

        public void onPageFinished(WebView webView, String str) {
            this.f8346b.aq.b();
            this.f8346b.aq.setVisibility(8);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!str.startsWith("https://m.facebook.com/spotify_callback")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            Uri parse = Uri.parse(str);
            C10331 c10331;
            if (parse.getQueryParameterNames().contains("code")) {
                this.f8345a = parse.getQueryParameter("code");
                if (this.f8346b.ao != null) {
                    c10331 = this.f8346b.ao;
                    String str2 = this.f8345a;
                    if (c10331.f8364a != null) {
                        c10331.f8364a.m9315a(ActionType.auth_success);
                        c10331.f8365b.m9292a(str2, c10331.f8366c, c10331.f8367d, new C10353(c10331.f8368e));
                    }
                }
                this.f8346b.b();
            } else if (parse.getQueryParameterNames().contains("error")) {
                if (this.f8346b.ao != null) {
                    c10331 = this.f8346b.ao;
                    if (c10331.f8364a != null) {
                        c10331.f8364a.m9315a(ActionType.auth_fail);
                    }
                }
                this.f8346b.b();
            }
            return true;
        }
    }

    public static void m9257a(Object obj, Context context) {
        ((AuthorizationDialog) obj).an = SecureWebViewHelper.a(FbInjector.get(context));
    }

    public final void m9259a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 380026272);
        super.a(bundle);
        Class cls = AuthorizationDialog.class;
        m9257a(this, getContext());
        a(0, 2131626695);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 827887236, a);
    }

    public final View m9258a(LayoutInflater layoutInflater, @android.support.annotation.Nullable ViewGroup viewGroup, @android.support.annotation.Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1835865864);
        View inflate = layoutInflater.inflate(2130903321, viewGroup, false);
        this.aq = (LoadingIndicatorView) inflate.findViewById(2131559751);
        this.ap = (WebView) inflate.findViewById(2131559752);
        this.ap.getSettings().setJavaScriptEnabled(true);
        Builder buildUpon = Uri.parse("https://accounts.spotify.com/authorize").buildUpon();
        buildUpon.appendQueryParameter("client_id", "9cc4aaeb43f24b098cff096385f00233");
        buildUpon.appendQueryParameter("response_type", "code");
        buildUpon.appendQueryParameter("show_dialog", Boolean.toString(true));
        buildUpon.appendQueryParameter("redirect_uri", "https://m.facebook.com/spotify_callback");
        this.ap.setWebViewClient(new C10301(this));
        this.ap.loadUrl(new SafeOAuthUrl(buildUpon.toString()).toString());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -752482939, a);
        return inflate;
    }
}
