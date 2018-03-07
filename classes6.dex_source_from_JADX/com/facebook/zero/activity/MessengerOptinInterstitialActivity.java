package com.facebook.zero.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: com.facebook.photos.upload.service.retry */
public class MessengerOptinInterstitialActivity extends ZeroOptinInterstitialActivity {
    protected static final CallerContext f20330p = CallerContext.a(MessengerOptinInterstitialActivity.class, "messenger_optin_interstitial_new");
    private FbTextView al;
    private FbTextView am;
    @Inject
    public SecureContextHelper f20331q;
    private ImageView f20332r;

    /* compiled from: com.facebook.photos.upload.service.retry */
    class C15472 implements OnClickListener {
        final /* synthetic */ MessengerOptinInterstitialActivity f20328a;

        C15472(MessengerOptinInterstitialActivity messengerOptinInterstitialActivity) {
            this.f20328a = messengerOptinInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 226417483);
            this.f20328a.m28884d(null);
            Logger.a(2, EntryType.UI_INPUT_END, 725931933, a);
        }
    }

    /* compiled from: com.facebook.photos.upload.service.retry */
    class C15483 implements OnClickListener {
        final /* synthetic */ MessengerOptinInterstitialActivity f20329a;

        C15483(MessengerOptinInterstitialActivity messengerOptinInterstitialActivity) {
            this.f20329a = messengerOptinInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1933953157);
            this.f20329a.f20331q.b(this.f20329a.m28893q(), this.f20329a.getApplicationContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1368745353, a);
        }
    }

    private static <T extends Context> void m28915a(Class<T> cls, T t) {
        m28916a((Object) t, (Context) t);
    }

    public static void m28916a(Object obj, Context context) {
        ((MessengerOptinInterstitialActivity) obj).f20331q = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    protected final void mo1526b(Bundle bundle) {
        super.mo1526b(bundle);
        Class cls = MessengerOptinInterstitialActivity.class;
        m28916a((Object) this, (Context) this);
    }

    protected final void mo1527i() {
        setTheme(2131624474);
        setContentView(2130905255);
        this.G = (ProgressBar) a(2131560985);
        this.f20332r = (ImageView) a(2131563848);
        this.J = (ViewGroup) a(2131560986);
        this.N = (FbDraweeView) a(2131560994);
        this.K = (FbTextView) a(2131560987);
        this.al = (FbTextView) a(2131560988);
        this.I = (FbButton) a(2131560995);
        this.am = (FbTextView) a(2131560996);
        this.H = (LinearLayout) a(2131560991);
        this.L = (FbTextView) a(2131560989);
        this.Q = (FbTextView) a(2131563849);
    }

    protected final void mo1532n() {
        this.f20332r.setVisibility(0);
    }

    protected final void mo1533o() {
        this.f20332r.setVisibility(8);
    }

    protected final void mo1528j() {
        int i;
        int i2 = 1;
        this.f20291J.setVisibility(8);
        this.f20295N.setVisibility(8);
        if (this.f20302U == null || StringUtil.a(this.f20302U.toString())) {
            i = 0;
        } else {
            this.f20295N.a(this.f20302U, f20330p);
            this.f20295N.setVisibility(0);
            i = 1;
        }
        this.f20292K.setVisibility(8);
        if (!StringUtil.a(this.f20299R)) {
            this.f20292K.setText(this.f20299R);
            this.f20292K.setContentDescription(this.f20299R);
            this.f20292K.setVisibility(0);
            i = 1;
        }
        this.al.setVisibility(8);
        if (!StringUtil.a(this.f20300S)) {
            this.al.setText(this.f20300S);
            this.al.setContentDescription(this.f20300S);
            this.al.setVisibility(0);
            i = 1;
        }
        this.f20290I.setVisibility(8);
        if (!StringUtil.a(this.ab)) {
            this.f20290I.setText(this.ab);
            this.f20290I.setContentDescription(this.ab);
            final Bundle bundle = new Bundle();
            bundle.putString("ref", "dialtone_optin_screen");
            this.f20290I.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MessengerOptinInterstitialActivity f20327b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 205017502);
                    this.f20327b.m28883c(bundle);
                    Logger.a(2, EntryType.UI_INPUT_END, -549581870, a);
                }
            });
            this.f20290I.setVisibility(0);
            i = 1;
        }
        this.am.setVisibility(8);
        if (StringUtil.a(this.af)) {
            i2 = i;
        } else {
            this.am.setText(this.af);
            this.am.setContentDescription(this.af);
            this.am.setOnClickListener(new C15472(this));
            this.am.setVisibility(0);
        }
        if (i2 != 0) {
            this.f20291J.setVisibility(0);
        }
    }

    protected final void mo1529k() {
    }

    protected final void mo1530l() {
        int i;
        int i2 = 1;
        this.f20289H.setVisibility(8);
        this.f20293L.setVisibility(8);
        if (StringUtil.a(this.f20301T)) {
            i = 0;
        } else {
            this.f20293L.setText(this.f20301T);
            this.f20293L.setContentDescription(this.f20301T);
            this.f20293L.setVisibility(0);
            i = 1;
        }
        this.f20298Q.setVisibility(8);
        if (StringUtil.a(this.f20306Y)) {
            i2 = i;
        } else {
            this.f20298Q.setText(this.f20306Y);
            this.f20298Q.setContentDescription(this.f20306Y);
            this.f20298Q.setOnClickListener(new C15483(this));
            this.f20298Q.setVisibility(0);
        }
        if (i2 != 0) {
            this.f20289H.setVisibility(0);
        }
    }

    public void onBackPressed() {
        m28881a(mo1531m());
    }

    protected final CallerContext mo1531m() {
        return f20330p;
    }

    private void m28914a(SecureContextHelper secureContextHelper) {
        this.f20331q = secureContextHelper;
    }
}
