package com.facebook.messaging.momentsinvite.webview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.webview.FacebookWebView;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: iso-8859-6 */
public class MomentsInviteWebViewActivity extends FbFragmentActivity {
    public static final String f12381t = MomentsInviteWebViewActivity.class.getSimpleName();
    @Inject
    public FbActionBarUtil f12382p;
    @Inject
    public Provider<AppCompatActivityOverrider> f12383q;
    @Inject
    public SecureWebViewHelper f12384r;
    @Inject
    public AbstractFbErrorReporter f12385s;
    public EmptyListViewItem f12386u;
    public FacebookWebView f12387v;
    private boolean f12388w;

    /* compiled from: iso-8859-6 */
    class C13671 extends WebViewClient {
        final /* synthetic */ MomentsInviteWebViewActivity f12380a;

        C13671(MomentsInviteWebViewActivity momentsInviteWebViewActivity) {
            this.f12380a = momentsInviteWebViewActivity;
        }

        public void onPageFinished(WebView webView, String str) {
            this.f12380a.f12387v.setVisibility(0);
            this.f12380a.f12386u.setVisibility(8);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f12380a.f12385s.a(MomentsInviteWebViewActivity.f12381t, StringFormatUtil.a("errorCode=%d description=%s failingUrl=%s", new Object[]{Integer.valueOf(i), str, str2}));
            webView.setVisibility(8);
            this.f12380a.finish();
        }
    }

    private static <T extends Context> void m12846a(Class<T> cls, T t) {
        m12847a((Object) t, (Context) t);
    }

    public static void m12847a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MomentsInviteWebViewActivity momentsInviteWebViewActivity = (MomentsInviteWebViewActivity) obj;
        FbActionBarUtil a = FbActionBarUtil.a(fbInjector);
        Provider a2 = IdBasedProvider.a(fbInjector, 4577);
        SecureWebViewHelper a3 = SecureWebViewHelper.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        momentsInviteWebViewActivity.f12382p = a;
        momentsInviteWebViewActivity.f12383q = a2;
        momentsInviteWebViewActivity.f12384r = a3;
        momentsInviteWebViewActivity.f12385s = abstractFbErrorReporter;
    }

    protected final void m12851a(Bundle bundle) {
        Class cls = MomentsInviteWebViewActivity.class;
        m12847a((Object) this, (Context) this);
        this.f12388w = this.f12382p.a();
        if (this.f12388w) {
            a((AppCompatActivityOverrider) this.f12383q.get());
        }
    }

    protected final void m12852b(Bundle bundle) {
        super.b(bundle);
        setTitle(getString(2131241122));
        if (!this.f12388w) {
            FbTitleBarUtil.b(this);
        }
        setContentView(2130907776);
        this.f12386u = (EmptyListViewItem) a(2131568536);
        this.f12386u.a(true);
        this.f12386u.setMessage(2131230739);
        this.f12387v = (FacebookWebView) a(2131568535);
        this.f12387v.setFocusableInTouchMode(true);
        this.f12387v.setWebViewClient(new C13671(this));
        Uri data = getIntent().getData();
        Object uri = data.toString();
        Preconditions.checkArgument(!StringUtil.a(uri));
        Preconditions.checkArgument(m12848a(data), uri);
        this.f12384r.a(this.f12387v, uri);
    }

    public static boolean m12848a(Uri uri) {
        if (!FacebookUriUtil.c(uri)) {
            return false;
        }
        String path = uri.getPath();
        if (path == null || !path.contains("moments_app")) {
            return false;
        }
        return true;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f12387v != null) {
            this.f12387v.saveState(bundle);
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (this.f12387v != null) {
            this.f12387v.restoreState(bundle);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
