package com.facebook.messaging.attribution;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.webview.FacebookWebView;
import com.facebook.widget.listview.EmptyListViewItem;
import javax.inject.Inject;

/* compiled from: p2p_add_card_success */
public class AttributionReportFragment extends FbDialogFragment {
    @Inject
    public AbstractFbErrorReporter am;
    @Inject
    public SecureWebViewHelper an;
    public EmptyListViewItem ao;
    public FacebookWebView ap;
    private String aq;

    /* compiled from: p2p_add_card_success */
    class C08591 extends WebViewClient {
        final /* synthetic */ AttributionReportFragment f7790a;

        C08591(AttributionReportFragment attributionReportFragment) {
            this.f7790a = attributionReportFragment;
        }

        public void onPageFinished(WebView webView, String str) {
            this.f7790a.ap.setVisibility(0);
            this.f7790a.ao.setVisibility(8);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f7790a.am.a("attribution_report_webview_received_error", StringFormatUtil.a("errorCode=%d description=%s failingUrl=%s", new Object[]{Integer.valueOf(i), str, str2}));
            webView.setVisibility(8);
            this.f7790a.b();
        }
    }

    public static void m8034a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AttributionReportFragment attributionReportFragment = (AttributionReportFragment) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        SecureWebViewHelper a = SecureWebViewHelper.a(fbInjector);
        attributionReportFragment.am = abstractFbErrorReporter;
        attributionReportFragment.an = a;
    }

    public final void m8036a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1271028574);
        super.a(bundle);
        Class cls = AttributionReportFragment.class;
        m8034a((Object) this, getContext());
        this.aq = this.s.getString("attachment_fbid");
        a(0, 2131625149);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 19278748, a);
    }

    public final View m8035a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -856768432);
        View inflate = layoutInflater.inflate(2130903307, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 665708227, a);
        return inflate;
    }

    public final void m8037a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ap = (FacebookWebView) e(2131559724);
        this.ao = (EmptyListViewItem) e(2131559725);
        this.ao.a(true);
        this.ao.setMessage(2131230739);
        Uri parse = Uri.parse(StringFormatUtil.formatStrLocaleSafe("https://m.facebook.com/trust/afro/?reportable_ent_token=%s&initial_action=%s&story_location=%s", this.aq, GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM, "messenger"));
        this.ap.setWebViewClient(new C08591(this));
        this.an.a(this.ap, parse.toString());
    }
}
