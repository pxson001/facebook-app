package com.facebook.registration.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.SimpleRegFormData;
import com.facebook.registration.util.RegistrationUtil;
import com.facebook.ui.keyboard.KeyboardUtils;
import javax.inject.Inject;

/* compiled from: last_full_successful_fetch_ms */
public class RegistrationInlineTermsFragment extends RegistrationFragment {
    public View al;
    public View am;
    @Inject
    public SimpleRegFormData f8846b;
    @Inject
    public RegistrationUtil f8847c;
    @Inject
    public SimpleRegLogger f8848d;
    @Inject
    public FbAndroidAuthActivityUtil f8849e;
    private TextView f8850f;
    public Button f8851g;
    public ViewGroup f8852h;
    public View f8853i;

    /* compiled from: last_full_successful_fetch_ms */
    public class C13311 implements OnClickListener {
        final /* synthetic */ RegistrationInlineTermsFragment f8831a;

        public C13311(RegistrationInlineTermsFragment registrationInlineTermsFragment) {
            this.f8831a = registrationInlineTermsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -763460799);
            this.f8831a.f8846b.a = true;
            this.f8831a.mo385a(RegFragmentState.TERMS_ACCEPTED);
            Logger.a(2, EntryType.UI_INPUT_END, -2026051298, a);
        }
    }

    /* compiled from: last_full_successful_fetch_ms */
    public class C13364 implements OnTouchListener {
        final /* synthetic */ RegistrationInlineTermsFragment f8841a;

        public C13364(RegistrationInlineTermsFragment registrationInlineTermsFragment) {
            this.f8841a = registrationInlineTermsFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    /* compiled from: last_full_successful_fetch_ms */
    enum TermsCardInfo {
        TERMS_OF_SERVICE(2131239856, "https://m.facebook.com/reg/app_terms/tos/"),
        DATA_POLICY(2131239857, "https://m.facebook.com/reg/app_terms/data_policy/"),
        LOCATION_SUPPLEMENT(2131239858, "https://m.facebook.com/reg/app_terms/location/");
        
        public final int titleResId;
        public final String url;

        private TermsCardInfo(int i, String str) {
            this.titleResId = i;
            this.url = str;
        }
    }

    public static void m8831a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RegistrationInlineTermsFragment registrationInlineTermsFragment = (RegistrationInlineTermsFragment) obj;
        SimpleRegFormData a = SimpleRegFormData.a(fbInjector);
        RegistrationUtil b = RegistrationUtil.b(fbInjector);
        SimpleRegLogger b2 = SimpleRegLogger.b(fbInjector);
        FbAndroidAuthActivityUtil b3 = FbAndroidAuthActivityUtil.b(fbInjector);
        registrationInlineTermsFragment.f8846b = a;
        registrationInlineTermsFragment.f8847c = b;
        registrationInlineTermsFragment.f8848d = b2;
        registrationInlineTermsFragment.f8849e = b3;
    }

    public final void m8833c(Bundle bundle) {
        super.c(bundle);
        Class cls = RegistrationInlineTermsFragment.class;
        m8831a((Object) this, getContext());
    }

    public final void mo383b(View view, Bundle bundle) {
        KeyboardUtils.a(getContext(), view);
        this.f8850f = (TextView) FindViewUtil.b(view, 2131566924);
        this.f8851g = (Button) FindViewUtil.b(view, 2131566905);
        this.f8852h = (ViewGroup) FindViewUtil.b(view, 2131566923);
        this.f8853i = FindViewUtil.b(view, 2131566925);
        this.al = FindViewUtil.b(view, 2131566926);
        this.am = FindViewUtil.b(view, 2131566927);
        this.f8847c.a(this.f8850f);
        this.f8851g.setOnClickListener(new C13311(this));
        m8830a(this.f8853i, TermsCardInfo.TERMS_OF_SERVICE);
        m8830a(this.al, TermsCardInfo.DATA_POLICY);
        m8830a(this.am, TermsCardInfo.LOCATION_SUPPLEMENT);
        final WebView webView = (WebView) FindViewUtil.b(this.f8853i, 2131566919);
        final WebView webView2 = (WebView) FindViewUtil.b(this.al, 2131566919);
        final WebView webView3 = (WebView) FindViewUtil.b(this.am, 2131566919);
        OnTouchListener c13364 = new C13364(this);
        webView.setOnTouchListener(c13364);
        webView2.setOnTouchListener(c13364);
        webView3.setOnTouchListener(c13364);
        this.f8852h.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ RegistrationInlineTermsFragment f8845d;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                webView.getParent().requestDisallowInterceptTouchEvent(false);
                webView2.getParent().requestDisallowInterceptTouchEvent(false);
                webView3.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
    }

    protected final int mo384e() {
        return 2131239793;
    }

    protected final int aq() {
        return 2130906805;
    }

    private void m8830a(View view, final TermsCardInfo termsCardInfo) {
        final WebView webView = (WebView) FindViewUtil.b(view, 2131566919);
        final ProgressBar progressBar = (ProgressBar) FindViewUtil.b(view, 2131566920);
        final CheckedTextView checkedTextView = (CheckedTextView) FindViewUtil.b(view, 2131566921);
        final CheckedTextView checkedTextView2 = (CheckedTextView) FindViewUtil.b(view, 2131566922);
        ((TextView) FindViewUtil.b(view, 2131566918)).setText(termsCardInfo.titleResId);
        webView.getSettings().setUserAgentString(webView.getSettings().getUserAgentString() + ";FB_FW/1");
        webView.setVerticalScrollBarEnabled(true);
        webView.setLayerType(2, null);
        webView.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ RegistrationInlineTermsFragment f8834c;

            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    progressBar.setVisibility(8);
                    webView.setVisibility(0);
                }
            }
        });
        webView.setLayerType(1, null);
        webView.loadUrl(termsCardInfo.url);
        checkedTextView2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegistrationInlineTermsFragment f8840d;

            /* compiled from: last_full_successful_fetch_ms */
            class C13331 implements DialogInterface.OnClickListener {
                final /* synthetic */ C13353 f8835a;

                C13331(C13353 c13353) {
                    this.f8835a = c13353;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f8835a.f8840d.f8848d.b("inline_terms_disagree_dialog");
                    this.f8835a.f8840d.f8849e.a(this.f8835a.f8840d.o());
                }
            }

            /* compiled from: last_full_successful_fetch_ms */
            class C13342 implements DialogInterface.OnClickListener {
                final /* synthetic */ C13353 f8836a;

                C13342(C13353 c13353) {
                    this.f8836a = c13353;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    checkedTextView.setChecked(true);
                    checkedTextView2.setChecked(false);
                    dialogInterface.dismiss();
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1976749325);
                checkedTextView.setChecked(false);
                checkedTextView2.setChecked(true);
                new Builder(this.f8840d.o()).a(termsCardInfo.titleResId).b(StringFormatUtil.formatStrLocaleSafe(this.f8840d.b(2131239859), this.f8840d.b(termsCardInfo.titleResId))).a(2131239854, new C13342(this)).b(2131239855, new C13331(this)).a(false).a().show();
                Logger.a(2, EntryType.UI_INPUT_END, 1698017932, a);
            }
        });
    }
}
