package com.facebook.zero.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: com.facebook.photos.upload.video. */
public class DialtoneOptinInterstitialActivity extends ZeroOptinInterstitialActivity {
    protected static final CallerContext f20316p = CallerContext.a(DialtoneOptinInterstitialActivity.class, "dialtone_optin_interstitial");
    private FbTextView al;
    private FbTextView am;
    @Inject
    SecureContextHelper f20317q;
    @Inject
    Resources f20318r;

    /* compiled from: com.facebook.photos.upload.video. */
    class C15412 implements OnClickListener {
        final /* synthetic */ DialtoneOptinInterstitialActivity f20279a;

        C15412(DialtoneOptinInterstitialActivity dialtoneOptinInterstitialActivity) {
            this.f20279a = dialtoneOptinInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 980836183);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(this.f20279a.aa);
            intent.setFlags(335544320);
            this.f20279a.f20317q.b(intent, this.f20279a.getApplicationContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1072358513, a);
        }
    }

    /* compiled from: com.facebook.photos.upload.video. */
    class C15423 implements OnClickListener {
        final /* synthetic */ DialtoneOptinInterstitialActivity f20280a;

        C15423(DialtoneOptinInterstitialActivity dialtoneOptinInterstitialActivity) {
            this.f20280a = dialtoneOptinInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -94686506);
            this.f20280a.m28884d(null);
            Logger.a(2, EntryType.UI_INPUT_END, 1313531499, a);
        }
    }

    private static <T extends Context> void m28895a(Class<T> cls, T t) {
        m28896a((Object) t, (Context) t);
    }

    public static void m28896a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DialtoneOptinInterstitialActivity) obj).m28894a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector));
    }

    protected final void mo1526b(Bundle bundle) {
        super.mo1526b(bundle);
        Class cls = DialtoneOptinInterstitialActivity.class;
        m28896a((Object) this, (Context) this);
    }

    protected final void mo1527i() {
        setTheme(2131624474);
        setContentView(2130903897);
        this.G = (ProgressBar) a(2131560985);
        this.J = (ViewGroup) a(2131560986);
        this.K = (FbTextView) a(2131560987);
        this.al = (FbTextView) a(2131560988);
        this.L = (FbTextView) a(2131560989);
        this.M = (ScrollView) a(2131560990);
        this.O = (FbTextView) a(2131560993);
        this.P = (FacepileView) a(2131560992);
        this.N = (FbDraweeView) a(2131560994);
        this.H = (LinearLayout) a(2131560991);
        this.I = (FbButton) a(2131560995);
        final Bundle bundle = new Bundle();
        bundle.putString("ref", "dialtone_optin_screen");
        this.f20290I.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DialtoneOptinInterstitialActivity f20278b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -176501658);
                this.f20278b.m28883c(bundle);
                Logger.a(2, EntryType.UI_INPUT_END, -318662368, a);
            }
        });
        this.am = (FbTextView) a(2131560996);
    }

    protected final void mo1528j() {
        int i = 1;
        super.mo1528j();
        int i2 = this.f20291J.getVisibility() == 0 ? 1 : 0;
        this.al.setVisibility(8);
        if (StringUtil.a(this.f20300S)) {
            i = i2;
        } else {
            this.al.setText(this.f20300S);
            this.al.setContentDescription(this.f20300S);
            this.al.setVisibility(0);
        }
        if (i != 0) {
            this.f20291J.setVisibility(0);
        } else {
            this.f20291J.setVisibility(8);
        }
    }

    protected final void mo1529k() {
        int i;
        int i2 = 1;
        this.f20294M.setVisibility(8);
        this.f20296O.setVisibility(8);
        if (StringUtil.a(this.f20305X) || StringUtil.a(this.f20307Z)) {
            i = 0;
        } else {
            this.f20296O.setText(new StyledStringBuilder(this.f20318r).a(this.f20305X).a(" ").a(new StyleSpan(1), 33).a(this.f20307Z).a().b());
            this.f20296O.setContentDescription(this.f20305X);
            this.f20296O.setOnClickListener(new C15412(this));
            this.f20296O.setVisibility(0);
            i = 1;
        }
        this.f20295N.setVisibility(8);
        if (!(this.f20302U == null || StringUtil.a(this.f20302U.toString()))) {
            this.f20295N.a(this.f20302U, f20316p);
            this.f20295N.setVisibility(0);
            i = 1;
        }
        this.f20297P.setVisibility(8);
        if (this.f20304W.isEmpty()) {
            i2 = i;
        } else {
            this.f20297P.setFaceStrings(this.f20304W);
            this.f20297P.setVisibility(0);
        }
        if (i2 != 0) {
            this.f20294M.setVisibility(0);
        }
    }

    protected final void mo1530l() {
        int i;
        int i2 = 1;
        this.f20289H.setVisibility(8);
        this.f20290I.setVisibility(8);
        if (StringUtil.a(this.ab)) {
            i = 0;
        } else {
            this.f20290I.setText(this.ab);
            this.f20290I.setContentDescription(this.ab);
            this.f20290I.setVisibility(0);
            i = 1;
        }
        this.am.setVisibility(8);
        if (StringUtil.a(this.af)) {
            i2 = i;
        } else {
            this.am.setText(this.af);
            this.am.setContentDescription(this.af);
            this.am.setOnClickListener(new C15423(this));
            this.am.setVisibility(0);
        }
        if (i2 != 0) {
            this.f20289H.setVisibility(0);
        }
    }

    protected final CallerContext mo1531m() {
        return f20316p;
    }

    private void m28894a(SecureContextHelper secureContextHelper, Resources resources) {
        this.f20317q = secureContextHelper;
        this.f20318r = resources;
    }
}
