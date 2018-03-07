package com.facebook.zero.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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

/* compiled from: com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity */
public class MessengerOptinInterstitialActivityOld extends ZeroOptinInterstitialActivity {
    protected static final CallerContext f20337p = CallerContext.a(MessengerOptinInterstitialActivityOld.class, "messenger_optin_interstitial_old");
    private FbTextView al;
    @Inject
    public SecureContextHelper f20338q;
    private FbTextView f20339r;

    /* compiled from: com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity */
    class C15502 implements OnClickListener {
        final /* synthetic */ MessengerOptinInterstitialActivityOld f20335a;

        C15502(MessengerOptinInterstitialActivityOld messengerOptinInterstitialActivityOld) {
            this.f20335a = messengerOptinInterstitialActivityOld;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -310628559);
            this.f20335a.f20338q.b(this.f20335a.m28893q(), this.f20335a.getApplicationContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1175575025, a);
        }
    }

    /* compiled from: com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity */
    class C15513 implements OnClickListener {
        final /* synthetic */ MessengerOptinInterstitialActivityOld f20336a;

        C15513(MessengerOptinInterstitialActivityOld messengerOptinInterstitialActivityOld) {
            this.f20336a = messengerOptinInterstitialActivityOld;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -565900702);
            this.f20336a.m28884d(null);
            Logger.a(2, EntryType.UI_INPUT_END, 237300119, a);
        }
    }

    private static <T extends Context> void m28926a(Class<T> cls, T t) {
        m28927a((Object) t, (Context) t);
    }

    public static void m28927a(Object obj, Context context) {
        ((MessengerOptinInterstitialActivityOld) obj).f20338q = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    protected final void mo1526b(Bundle bundle) {
        super.mo1526b(bundle);
        Class cls = MessengerOptinInterstitialActivityOld.class;
        m28927a((Object) this, (Context) this);
    }

    protected final void mo1527i() {
        setTheme(2131624474);
        setContentView(2130905256);
        this.G = (ProgressBar) a(2131560985);
        this.N = (FbDraweeView) a(2131560994);
        this.J = (ViewGroup) a(2131560986);
        this.K = (FbTextView) a(2131560987);
        this.f20339r = (FbTextView) a(2131560988);
        this.L = (FbTextView) a(2131560989);
        this.Q = (FbTextView) a(2131563850);
        this.H = (LinearLayout) a(2131560991);
        this.f20289H.setVisibility(8);
        this.I = (FbButton) a(2131560995);
        final Bundle bundle = new Bundle();
        bundle.putString("ref", "dialtone_optin_screen");
        this.f20290I.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessengerOptinInterstitialActivityOld f20334b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1940281289);
                this.f20334b.m28883c(bundle);
                Logger.a(2, EntryType.UI_INPUT_END, 1739172345, a);
            }
        });
        this.al = (FbTextView) a(2131560996);
    }

    protected final void mo1528j() {
        int i = 1;
        super.mo1528j();
        int i2 = this.f20291J.getVisibility() == 0 ? 1 : 0;
        this.f20295N.setVisibility(8);
        if (!(this.f20302U == null || StringUtil.a(this.f20302U.toString()))) {
            this.f20295N.a(this.f20302U, f20337p);
            this.f20295N.setVisibility(0);
            i2 = 1;
        }
        this.f20339r.setVisibility(8);
        if (!StringUtil.a(this.f20300S)) {
            this.f20339r.setText(this.f20300S);
            this.f20339r.setContentDescription(this.f20300S);
            this.f20339r.setVisibility(0);
            i2 = 1;
        }
        this.f20298Q.setVisibility(8);
        if (!StringUtil.a(this.f20307Z)) {
            this.f20298Q.setText(this.f20307Z);
            this.f20298Q.setContentDescription(this.f20307Z);
            this.f20298Q.setOnClickListener(new C15502(this));
            this.f20298Q.setVisibility(0);
            i2 = 1;
        }
        this.f20290I.setVisibility(8);
        if (StringUtil.a(this.ab)) {
            i = i2;
        } else {
            this.f20290I.setText(this.ab);
            this.f20290I.setContentDescription(this.ab);
            this.f20290I.setVisibility(0);
        }
        if (i != 0) {
            this.f20291J.setVisibility(0);
        } else {
            this.f20291J.setVisibility(8);
        }
    }

    protected final void mo1529k() {
    }

    protected final void mo1530l() {
        int i;
        this.f20289H.setVisibility(8);
        this.al.setVisibility(8);
        if (StringUtil.a(this.af)) {
            i = 0;
        } else {
            this.al.setText(this.af);
            this.al.setContentDescription(this.af);
            this.al.setOnClickListener(new C15513(this));
            this.al.setVisibility(0);
            i = 1;
        }
        if (i != 0) {
            this.f20289H.setVisibility(0);
        }
    }

    public void onBackPressed() {
        m28881a(f20337p);
    }

    protected final CallerContext mo1531m() {
        return f20337p;
    }

    private void m28925a(SecureContextHelper secureContextHelper) {
        this.f20338q = secureContextHelper;
    }
}
