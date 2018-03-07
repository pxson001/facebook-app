package com.facebook.zero.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;

/* compiled from: ्ओ */
public class TimeBasedOptinInterstitialActivity extends ZeroOptinInterstitialActivity {
    protected static final CallerContext f8p = CallerContext.a(TimeBasedOptinInterstitialActivity.class, "time_based_optin_interstitial");
    private FbTextView al;
    private LinearLayout am;
    private ImageView f9q;
    private FbTextView f10r;

    /* compiled from: ्ओ */
    class C00011 implements OnClickListener {
        final /* synthetic */ TimeBasedOptinInterstitialActivity f3a;

        C00011(TimeBasedOptinInterstitialActivity timeBasedOptinInterstitialActivity) {
            this.f3a = timeBasedOptinInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 63029800);
            this.f3a.w.b(this.f3a.q(), this.f3a.getApplicationContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1993734523, a);
        }
    }

    /* compiled from: ्ओ */
    class C00022 implements OnClickListener {
        final /* synthetic */ TimeBasedOptinInterstitialActivity f4a;

        C00022(TimeBasedOptinInterstitialActivity timeBasedOptinInterstitialActivity) {
            this.f4a = timeBasedOptinInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1411599628);
            this.f4a.w.b(this.f4a.q(), this.f4a.getApplicationContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1791894985, a);
        }
    }

    /* compiled from: ्ओ */
    class C00044 implements OnClickListener {
        final /* synthetic */ TimeBasedOptinInterstitialActivity f7a;

        C00044(TimeBasedOptinInterstitialActivity timeBasedOptinInterstitialActivity) {
            this.f7a = timeBasedOptinInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1877824353);
            this.f7a.d(null);
            Logger.a(2, EntryType.UI_INPUT_END, -1602420107, a);
        }
    }

    protected final void m6i() {
        setTheme(2131624474);
        setContentView(2130907427);
        this.G = (ProgressBar) a(2131560985);
        this.f9q = (ImageView) a(2131563848);
        this.J = (ViewGroup) a(2131560986);
        this.K = (FbTextView) a(2131560987);
        this.f10r = (FbTextView) a(2131560988);
        this.am = (LinearLayout) a(2131567902);
        this.L = (FbTextView) a(2131560989);
        this.Q = (FbTextView) a(2131567903);
        this.H = (LinearLayout) a(2131560991);
        this.I = (FbButton) a(2131560995);
        this.al = (FbTextView) a(2131560996);
    }

    protected final void m11n() {
        this.f9q.setVisibility(0);
    }

    protected final void m12o() {
        this.f9q.setVisibility(8);
    }

    protected final void m13p() {
        this.am.setVisibility(8);
        super.p();
    }

    protected final void m7j() {
        int i;
        int i2 = 1;
        CharSequence fromHtml = Html.fromHtml(this.R);
        CharSequence fromHtml2 = Html.fromHtml(this.S);
        this.J.setVisibility(8);
        this.K.setVisibility(8);
        if (StringUtil.a(fromHtml)) {
            i = 0;
        } else {
            this.K.setText(fromHtml);
            this.K.setContentDescription(fromHtml);
            this.K.setVisibility(0);
            i = 1;
        }
        this.f10r.setVisibility(8);
        if (StringUtil.a(fromHtml2)) {
            i2 = i;
        } else {
            this.f10r.setText(fromHtml2);
            this.f10r.setContentDescription(fromHtml2);
            this.f10r.setVisibility(0);
        }
        if (i2 != 0) {
            this.J.setVisibility(0);
        }
    }

    protected final void m8k() {
        int i;
        int i2 = 1;
        CharSequence fromHtml = Html.fromHtml(this.T);
        CharSequence fromHtml2 = Html.fromHtml(this.Z);
        this.L.setVisibility(8);
        if (StringUtil.a(fromHtml)) {
            i = 0;
        } else {
            this.L.setText(fromHtml);
            this.L.setContentDescription(fromHtml);
            this.L.setVisibility(0);
            this.L.setOnClickListener(new C00011(this));
            i = 1;
        }
        this.Q.setVisibility(8);
        if (StringUtil.a(fromHtml2)) {
            i2 = i;
        } else {
            this.Q.setText(fromHtml2);
            this.Q.setContentDescription(fromHtml2);
            this.Q.setVisibility(0);
            this.Q.setOnClickListener(new C00022(this));
        }
        if (i2 != 0) {
            this.am.setVisibility(0);
        } else {
            this.am.setVisibility(8);
        }
    }

    protected final void m9l() {
        int i;
        int i2 = 1;
        CharSequence fromHtml = Html.fromHtml(this.ab);
        CharSequence fromHtml2 = Html.fromHtml(this.af);
        this.H.setVisibility(8);
        this.I.setVisibility(8);
        if (StringUtil.a(fromHtml)) {
            i = 0;
        } else {
            this.I.setText(fromHtml);
            this.I.setContentDescription(fromHtml);
            final Bundle bundle = new Bundle();
            bundle.putString("ref", "dialtone_optin_screen");
            this.I.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ TimeBasedOptinInterstitialActivity f6b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1965119621);
                    this.f6b.c(bundle);
                    Logger.a(2, EntryType.UI_INPUT_END, -817580916, a);
                }
            });
            this.I.setVisibility(0);
            i = 1;
        }
        this.al.setVisibility(8);
        if (StringUtil.a(fromHtml2)) {
            i2 = i;
        } else {
            this.al.setText(fromHtml2);
            this.al.setContentDescription(fromHtml2);
            this.al.setOnClickListener(new C00044(this));
            this.al.setVisibility(0);
        }
        if (i2 != 0) {
            this.H.setVisibility(0);
        }
    }

    public void onBackPressed() {
        a(m10m());
        finish();
    }

    protected final CallerContext m10m() {
        return f8p;
    }
}
