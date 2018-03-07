package com.facebook.zero.activity;

import android.content.Context;
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
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.zero.annotations.NewLightswitchOptinGateKeeper;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.photos.upload.service.success */
public class LightswitchOptinInterstitialActivity extends ZeroOptinInterstitialActivity {
    protected static final CallerContext f20323p = CallerContext.a(LightswitchOptinInterstitialActivity.class, "lightswitch_optin_interstitial");
    private FbTextView al;
    private ImageView am;
    private ImageView an;
    private View ao;
    @Inject
    SecureContextHelper f20324q;
    @Inject
    @NewLightswitchOptinGateKeeper
    Provider<Boolean> f20325r;

    /* compiled from: com.facebook.photos.upload.service.success */
    class C15442 implements OnClickListener {
        final /* synthetic */ LightswitchOptinInterstitialActivity f20321a;

        C15442(LightswitchOptinInterstitialActivity lightswitchOptinInterstitialActivity) {
            this.f20321a = lightswitchOptinInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1286132898);
            this.f20321a.f20324q.b(this.f20321a.m28893q(), this.f20321a.getApplicationContext());
            Logger.a(2, EntryType.UI_INPUT_END, 1357872878, a);
        }
    }

    /* compiled from: com.facebook.photos.upload.service.success */
    class C15453 implements OnClickListener {
        final /* synthetic */ LightswitchOptinInterstitialActivity f20322a;

        C15453(LightswitchOptinInterstitialActivity lightswitchOptinInterstitialActivity) {
            this.f20322a = lightswitchOptinInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1067706836);
            this.f20322a.m28884d(null);
            Logger.a(2, EntryType.UI_INPUT_END, 1205365323, a);
        }
    }

    private static <T extends Context> void m28904a(Class<T> cls, T t) {
        m28905a((Object) t, (Context) t);
    }

    public static void m28905a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((LightswitchOptinInterstitialActivity) obj).m28903a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), IdBasedProvider.a(fbInjector, 4389));
    }

    protected final void mo1526b(Bundle bundle) {
        Class cls = LightswitchOptinInterstitialActivity.class;
        m28905a((Object) this, (Context) this);
        super.mo1526b(bundle);
    }

    protected final void mo1527i() {
        setTheme(2131624474);
        if (((Boolean) this.f20325r.get()).booleanValue()) {
            setContentView(2130905036);
            this.ao = a(2131563419);
            this.an = (ImageView) a(2131563418);
        } else {
            setContentView(2130905037);
            this.N = (FbDraweeView) a(2131560994);
        }
        this.G = (ProgressBar) a(2131560985);
        this.am = (ImageView) a(2131563417);
        this.J = (ViewGroup) a(2131560986);
        this.K = (FbTextView) a(2131560987);
        this.L = (FbTextView) a(2131560989);
        this.H = (LinearLayout) a(2131560991);
        this.f20289H.setVisibility(8);
        this.I = (FbButton) a(2131560995);
        final Bundle bundle = new Bundle();
        bundle.putString("ref", "dialtone_optin_screen");
        this.f20290I.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LightswitchOptinInterstitialActivity f20320b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 500570305);
                this.f20320b.m28883c(bundle);
                Logger.a(2, EntryType.UI_INPUT_END, -1165400265, a);
            }
        });
        this.al = (FbTextView) a(2131560996);
    }

    protected final void mo1532n() {
        this.am.setVisibility(8);
        if (((Boolean) this.f20325r.get()).booleanValue()) {
            this.an.setVisibility(8);
        }
        if (!StringUtil.a(this.f20307Z)) {
            this.am.setVisibility(0);
            if (((Boolean) this.f20325r.get()).booleanValue()) {
                this.an.setVisibility(0);
            }
        }
    }

    protected final void mo1528j() {
        int i;
        super.mo1528j();
        int i2 = this.f20291J.getVisibility() == 0 ? 1 : 0;
        this.f20293L.setVisibility(8);
        if (StringUtil.a(this.f20301T)) {
            i = i2;
        } else {
            this.f20293L.setText(this.f20301T);
            this.f20293L.setContentDescription(this.f20301T);
            this.f20293L.setTextColor(getResources().getColor(2131362691));
            if (StringUtil.a(this.f20307Z) || this.aa == null) {
                this.f20293L.setOnClickListener(null);
            } else {
                if (((Boolean) this.f20325r.get()).booleanValue()) {
                    this.f20293L.setText(Html.fromHtml("<font color=black>" + this.f20301T + " </font>" + this.f20307Z));
                } else {
                    this.f20293L.setText(Html.fromHtml(this.f20301T + " <font color=black>" + this.f20307Z + "</font>"));
                }
                this.f20293L.setTextColor(getResources().getColor(2131362693));
                this.f20293L.setOnClickListener(new C15442(this));
            }
            this.f20293L.setVisibility(0);
            i = 1;
        }
        if (((Boolean) this.f20325r.get()).booleanValue()) {
            this.ao.setVisibility(8);
        } else {
            this.f20295N.setVisibility(8);
        }
        if (!(this.f20302U == null || StringUtil.a(this.f20302U.toString()))) {
            if (((Boolean) this.f20325r.get()).booleanValue()) {
                this.ao.setVisibility(0);
            } else {
                this.f20295N.a(this.f20302U, f20323p);
                this.f20295N.setVisibility(0);
            }
            i = 1;
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
        this.al.setVisibility(8);
        if (StringUtil.a(this.af)) {
            i2 = i;
        } else {
            this.al.setText(this.af);
            this.al.setContentDescription(this.af);
            this.al.setOnClickListener(new C15453(this));
            this.al.setVisibility(0);
        }
        if (i2 != 0) {
            this.f20289H.setVisibility(0);
        }
    }

    protected final CallerContext mo1531m() {
        return f20323p;
    }

    private void m28903a(SecureContextHelper secureContextHelper, Provider<Boolean> provider) {
        this.f20324q = secureContextHelper;
        this.f20325r = provider;
    }
}
