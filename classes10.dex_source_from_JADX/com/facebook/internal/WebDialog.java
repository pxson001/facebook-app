package com.facebook.internal;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.Locale;

/* compiled from: SEND_SKIPPED_HAS_PLATFORM_METADATA */
public class WebDialog extends Dialog {
    public String f23989a;
    public String f23990b;
    public OnCompleteListener f23991c;
    public WebView f23992d;
    public ProgressDialog f23993e;
    public ImageView f23994f;
    public FrameLayout f23995g;
    public boolean f23996h;
    public boolean f23997i;
    public boolean f23998j;

    /* compiled from: SEND_SKIPPED_HAS_PLATFORM_METADATA */
    public interface OnCompleteListener {
        void mo1038a(Bundle bundle, FacebookException facebookException);
    }

    /* compiled from: SEND_SKIPPED_HAS_PLATFORM_METADATA */
    class C34551 implements OnCancelListener {
        final /* synthetic */ WebDialog f24058a;

        C34551(WebDialog webDialog) {
            this.f24058a = webDialog;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f24058a.cancel();
        }
    }

    /* compiled from: SEND_SKIPPED_HAS_PLATFORM_METADATA */
    public class C34562 implements OnClickListener {
        final /* synthetic */ WebDialog f24059a;

        public C34562(WebDialog webDialog) {
            this.f24059a = webDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2059732405);
            this.f24059a.cancel();
            Logger.a(2, EntryType.UI_INPUT_END, -307205447, a);
        }
    }

    /* compiled from: SEND_SKIPPED_HAS_PLATFORM_METADATA */
    public class C34584 implements OnTouchListener {
        final /* synthetic */ WebDialog f24061a;

        public C34584(WebDialog webDialog) {
            this.f24061a = webDialog;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!view.hasFocus()) {
                view.requestFocus();
            }
            return false;
        }
    }

    /* compiled from: SEND_SKIPPED_HAS_PLATFORM_METADATA */
    public class Builder {
        public Context f24062a;
        public String f24063b;
        private String f24064c;
        public int f24065d;
        public OnCompleteListener f24066e;
        public Bundle f24067f;
        private AccessToken f24068g;

        public Builder(Context context, String str, Bundle bundle) {
            this.f24068g = AccessToken.m14004a();
            if (this.f24068g == null) {
                String a = Utility.m25323a(context);
                if (a != null) {
                    this.f24063b = a;
                } else {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            m25372a(context, str, bundle);
        }

        public Builder(Context context, String str, String str2, Bundle bundle) {
            if (str == null) {
                str = Utility.m25323a(context);
            }
            Validate.m25367a(str, "applicationId");
            this.f24063b = str;
            m25372a(context, str2, bundle);
        }

        public WebDialog m25373a() {
            if (this.f24068g != null) {
                this.f24067f.putString("app_id", this.f24068g.f13714k);
                this.f24067f.putString("access_token", this.f24068g.f13711h);
            } else {
                this.f24067f.putString("app_id", this.f24063b);
            }
            return new WebDialog(this.f24062a, this.f24064c, this.f24067f, this.f24065d, this.f24066e);
        }

        private void m25372a(Context context, String str, Bundle bundle) {
            this.f24062a = context;
            this.f24064c = str;
            if (bundle != null) {
                this.f24067f = bundle;
            } else {
                this.f24067f = new Bundle();
            }
        }
    }

    /* compiled from: SEND_SKIPPED_HAS_PLATFORM_METADATA */
    public class DialogWebViewClient extends WebViewClient {
        final /* synthetic */ WebDialog f24069a;

        public DialogWebViewClient(WebDialog webDialog) {
            this.f24069a = webDialog;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Utility.m25339a("FacebookSDK.WebDialog", "Redirect URL: " + str);
            if (str.startsWith(this.f24069a.f23990b)) {
                int i;
                Bundle a = this.f24069a.mo1039a(str);
                String string = a.getString("error");
                if (string == null) {
                    string = a.getString("error_type");
                }
                String string2 = a.getString("error_msg");
                if (string2 == null) {
                    string2 = a.getString("error_message");
                }
                if (string2 == null) {
                    string2 = a.getString("error_description");
                }
                String string3 = a.getString("error_code");
                if (Utility.m25345a(string3)) {
                    i = -1;
                } else {
                    try {
                        i = Integer.parseInt(string3);
                    } catch (NumberFormatException e) {
                        i = -1;
                    }
                }
                if (Utility.m25345a(string) && Utility.m25345a(string2) && i == -1) {
                    this.f24069a.m25268a(a);
                } else if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                    this.f24069a.cancel();
                } else if (i == 4201) {
                    this.f24069a.cancel();
                } else {
                    this.f24069a.m25269a(new FacebookServiceException(new FacebookRequestError(i, string, string2), string2));
                }
                return true;
            } else if (str.startsWith("fbconnect://cancel")) {
                this.f24069a.cancel();
                return true;
            } else if (str.contains("touch")) {
                return false;
            } else {
                try {
                    this.f24069a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } catch (ActivityNotFoundException e2) {
                    return false;
                }
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.f24069a.m25269a(new FacebookDialogException(str, i, str2));
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            this.f24069a.m25269a(new FacebookDialogException(null, -11, null));
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Utility.m25339a("FacebookSDK.WebDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            if (!this.f24069a.f23997i) {
                this.f24069a.f23993e.show();
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!this.f24069a.f23997i) {
                this.f24069a.f23993e.dismiss();
            }
            this.f24069a.f23995g.setBackgroundColor(0);
            this.f24069a.f23992d.setVisibility(0);
            this.f24069a.f23994f.setVisibility(0);
            this.f24069a.f23998j = true;
        }
    }

    public WebDialog(Context context, String str) {
        this(context, str, FacebookSdk.m14054k());
    }

    private WebDialog(Context context, String str, int i) {
        if (i == 0) {
            i = FacebookSdk.m14054k();
        }
        super(context, i);
        this.f23990b = "fbconnect://success";
        this.f23996h = false;
        this.f23997i = false;
        this.f23998j = false;
        this.f23989a = str;
    }

    public WebDialog(Context context, String str, Bundle bundle, int i, OnCompleteListener onCompleteListener) {
        if (i == 0) {
            i = FacebookSdk.m14054k();
        }
        super(context, i);
        this.f23990b = "fbconnect://success";
        this.f23996h = false;
        this.f23997i = false;
        this.f23998j = false;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("redirect_uri", "fbconnect://success");
        bundle.putString("display", "touch");
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", new Object[]{"4.9.0"}));
        this.f23989a = Utility.m25318a(ServerProtocol.m25308a(), "v2.5" + "/dialog/" + str, bundle).toString();
        this.f23991c = onCompleteListener;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cancel();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void dismiss() {
        if (this.f23992d != null) {
            this.f23992d.stopLoading();
        }
        if (!(this.f23997i || this.f23993e == null || !this.f23993e.isShowing())) {
            this.f23993e.dismiss();
        }
        super.dismiss();
    }

    protected void onStart() {
        super.onStart();
        m25270d();
    }

    public void onDetachedFromWindow() {
        this.f23997i = true;
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        this.f23997i = false;
        super.onAttachedToWindow();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f23993e = new ProgressDialog(getContext());
        this.f23993e.requestWindowFeature(1);
        this.f23993e.setMessage(getContext().getString(2131242269));
        this.f23993e.setCanceledOnTouchOutside(false);
        this.f23993e.setOnCancelListener(new C34551(this));
        requestWindowFeature(1);
        this.f23995g = new FrameLayout(getContext());
        m25270d();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        this.f23994f = new ImageView(getContext());
        this.f23994f.setOnClickListener(new C34562(this));
        this.f23994f.setImageDrawable(getContext().getResources().getDrawable(2130838125));
        this.f23994f.setVisibility(4);
        int intrinsicWidth = (this.f23994f.getDrawable().getIntrinsicWidth() / 2) + 1;
        View linearLayout = new LinearLayout(getContext());
        this.f23992d = new WebView(this, getContext().getApplicationContext()) {
            final /* synthetic */ WebDialog f24060a;

            public void onWindowFocusChanged(boolean z) {
                int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2060696786);
                try {
                    super.onWindowFocusChanged(z);
                } catch (NullPointerException e) {
                }
                LogUtils.g(-310633602, a);
            }
        };
        this.f23992d.setVerticalScrollBarEnabled(false);
        this.f23992d.setHorizontalScrollBarEnabled(false);
        this.f23992d.setWebViewClient(new DialogWebViewClient(this));
        this.f23992d.getSettings().setJavaScriptEnabled(true);
        this.f23992d.loadUrl(this.f23989a);
        this.f23992d.setLayoutParams(new LayoutParams(-1, -1));
        this.f23992d.setVisibility(4);
        this.f23992d.getSettings().setSavePassword(false);
        this.f23992d.getSettings().setSaveFormData(false);
        this.f23992d.setFocusable(true);
        this.f23992d.setFocusableInTouchMode(true);
        this.f23992d.setOnTouchListener(new C34584(this));
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.f23992d);
        linearLayout.setBackgroundColor(-872415232);
        this.f23995g.addView(linearLayout);
        this.f23995g.addView(this.f23994f, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.f23995g);
    }

    protected Bundle mo1039a(String str) {
        Uri parse = Uri.parse(str);
        Bundle b = Utility.m25348b(parse.getQuery());
        b.putAll(Utility.m25348b(parse.getFragment()));
        return b;
    }

    public final void m25270d() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        getWindow().setLayout(Math.min(m25266a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(m25266a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
    }

    private static int m25266a(int i, float f, int i2, int i3) {
        double d = 0.5d;
        int i4 = (int) (((float) i) / f);
        if (i4 <= i2) {
            d = 1.0d;
        } else if (i4 < i3) {
            d = 0.5d + ((((double) (i3 - i4)) / ((double) (i3 - i2))) * 0.5d);
        }
        return (int) (d * ((double) i));
    }

    protected final void m25268a(Bundle bundle) {
        if (this.f23991c != null && !this.f23996h) {
            this.f23996h = true;
            this.f23991c.mo1038a(bundle, null);
            dismiss();
        }
    }

    protected final void m25269a(Throwable th) {
        if (this.f23991c != null && !this.f23996h) {
            this.f23996h = true;
            if (th instanceof FacebookException) {
                th = (FacebookException) th;
            } else {
                th = new FacebookException(th);
            }
            this.f23991c.mo1038a(null, th);
            dismiss();
        }
    }

    public void cancel() {
        if (this.f23991c != null && !this.f23996h) {
            m25269a(new FacebookOperationCanceledException());
        }
    }
}
