package com.facebook.katana.webview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.CheckBox;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.util.TriState;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.useragent.UserAgent;
import com.facebook.webview.FacebookWebView;
import com.facebook.webview.FacebookWebView.FacebookWebViewClient;
import com.facebook.webview.FacebookWebView.RPCChromeClient;
import com.facebook.webview.auth.AuthCallback;
import com.facebook.webview.auth.Authenticator;
import javax.inject.Inject;

/* compiled from: timeline_manage_button */
public class MobileCanvasWebView extends FacebookWebView {
    private static final Class<?> f1318l = MobileCanvasWebView.class;
    protected Authenticator f1319i;
    protected PageFinishedHandler f1320j;
    protected TriState f1321k;

    /* compiled from: timeline_manage_button */
    public class GeolocationWebChromeClient extends RPCChromeClient {
        final /* synthetic */ MobileCanvasWebView f1314b;
        private Context f1315d;

        public GeolocationWebChromeClient(MobileCanvasWebView mobileCanvasWebView, Context context) {
            this.f1314b = mobileCanvasWebView;
            super(mobileCanvasWebView);
            this.f1315d = context;
        }

        public void onGeolocationPermissionsShowPrompt(final String str, final Callback callback) {
            super.onGeolocationPermissionsShowPrompt(str, callback);
            final View checkBox = new CheckBox(this.f1315d);
            checkBox.setText(2131236568);
            checkBox.setTextColor(-1);
            new Builder(this.f1315d).b(this.f1315d.getString(2131236571, new Object[]{str})).a(false).b(checkBox).a(2131236569, new OnClickListener(this) {
                final /* synthetic */ GeolocationWebChromeClient f1313d;

                public void onClick(DialogInterface dialogInterface, int i) {
                    callback.invoke(str, true, checkBox.isChecked());
                }
            }).b(2131236570, new OnClickListener(this) {
                final /* synthetic */ GeolocationWebChromeClient f1309d;

                public void onClick(DialogInterface dialogInterface, int i) {
                    callback.invoke(str, false, checkBox.isChecked());
                }
            }).a().show();
        }
    }

    /* compiled from: timeline_manage_button */
    public class MobileCanvasWebViewClient extends FacebookWebViewClient {
        final /* synthetic */ MobileCanvasWebView f1317a;

        /* compiled from: timeline_manage_button */
        class C02201 implements AuthCallback {
            final /* synthetic */ MobileCanvasWebView f1316a;

            C02201(MobileCanvasWebView mobileCanvasWebView) {
                this.f1316a = mobileCanvasWebView;
            }

            public final void m1350a() {
            }

            public final void m1351b() {
            }

            public final void m1352c() {
            }
        }

        public MobileCanvasWebViewClient(MobileCanvasWebView mobileCanvasWebView, Context context) {
            this.f1317a = mobileCanvasWebView;
            super(context, mobileCanvasWebView.f1319i, new C02201(mobileCanvasWebView), mobileCanvasWebView.g, mobileCanvasWebView.a, mobileCanvasWebView.f1321k, mobileCanvasWebView.b);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (BuildConstants.i) {
                new StringBuilder().append("url ").append(str2).append(" failed (code: ").append(i).append("; description: ").append(str).append(")");
            }
        }
    }

    /* compiled from: timeline_manage_button */
    public interface PageFinishedHandler {
    }

    private static <T extends View> void m1355a(Class<T> cls, T t) {
        m1356a((Object) t, t.getContext());
    }

    private static void m1356a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MobileCanvasWebView) obj).m1354a((Authenticator) FacebookAuthentication.m1284a(injectorLike), TriState_IsMeUserAnEmployeeMethodAutoProvider.b(injectorLike));
    }

    public MobileCanvasWebView(Context context) {
        super(context);
    }

    public MobileCanvasWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MobileCanvasWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1355a(MobileCanvasWebView.class, (View) this);
    }

    @Inject
    private void m1354a(Authenticator authenticator, TriState triState) {
        this.f1319i = authenticator;
        this.f1321k = triState;
    }

    public void setPageFinishedHandler(PageFinishedHandler pageFinishedHandler) {
        this.f1320j = pageFinishedHandler;
    }

    protected final void m1359a(Context context) {
        super.a(context);
        this.f1320j = null;
        WebSettings settings = getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + " " + UserAgent.a(context, Boolean.valueOf(true)));
        setWebViewClient(new MobileCanvasWebViewClient(this, context));
        setWebChromeClient(new GeolocationWebChromeClient(this, context));
    }
}
