package com.facebook.katana.dbl;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.devicebasedlogin.ui.PasscodeViewListener;
import com.facebook.devicebasedlogin.ui.PinCodeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.IFbResourcesNotRequired;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.keyboard.KeyboardUtils;

/* compiled from: upsell_decline_count */
public class DBLChangePasscodeAfterIncorrectPasscodeFragment extends FbFragment implements IAuthNotRequired, DeviceBasedLoginWaitListener, PasscodeViewListener, IFbResourcesNotRequired {
    public DBLPinSettingsListener f872a;
    public PinCodeView f873b;
    private ProgressBar f874c;
    public int f875d;
    public int f876e;
    public TextView f877f;
    public View f878g;
    public final Handler f879h = new Handler();
    public TextView f880i;

    /* compiled from: upsell_decline_count */
    public class C01431 implements OnClickListener {
        final /* synthetic */ DBLChangePasscodeAfterIncorrectPasscodeFragment f869a;

        public C01431(DBLChangePasscodeAfterIncorrectPasscodeFragment dBLChangePasscodeAfterIncorrectPasscodeFragment) {
            this.f869a = dBLChangePasscodeAfterIncorrectPasscodeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1416810691);
            this.f869a.f872a.d_("");
            Logger.a(2, EntryType.UI_INPUT_END, -1295406854, a);
        }
    }

    /* compiled from: upsell_decline_count */
    public class C01452 implements Runnable {
        final /* synthetic */ DBLChangePasscodeAfterIncorrectPasscodeFragment f871a;

        /* compiled from: upsell_decline_count */
        class C01441 implements AnimationListener {
            final /* synthetic */ C01452 f870a;

            C01441(C01452 c01452) {
                this.f870a = c01452;
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.f870a.f871a.f878g.setVisibility(0);
                this.f870a.f871a.f877f.setVisibility(0);
                this.f870a.f871a.f873b.d();
                this.f870a.f871a.f880i.setVisibility(0);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        }

        public C01452(DBLChangePasscodeAfterIncorrectPasscodeFragment dBLChangePasscodeAfterIncorrectPasscodeFragment) {
            this.f871a = dBLChangePasscodeAfterIncorrectPasscodeFragment;
        }

        public void run() {
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500);
            this.f871a.f877f.startAnimation(alphaAnimation);
            this.f871a.f878g.startAnimation(alphaAnimation);
            this.f871a.f873b.startAnimation(alphaAnimation);
            this.f871a.f880i.startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new C01441(this));
        }
    }

    public final View m857a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -777776554);
        View inflate = layoutInflater.inflate(2130903851, viewGroup, false);
        this.f880i = (TextView) inflate.findViewById(2131558926);
        if (this.f875d != 0) {
            ((TextView) inflate.findViewById(2131559592)).setText(this.f875d);
        }
        if (this.f876e != 0) {
            this.f880i.setText(this.f876e);
        }
        this.f873b = (PinCodeView) inflate.findViewById(2131560914);
        this.f873b.f = this;
        this.f873b.c();
        this.f873b.b();
        this.f874c = (ProgressBar) inflate.findViewById(2131559418);
        this.f878g = inflate.findViewById(2131560055);
        this.f877f = (TextView) inflate.findViewById(2131560915);
        this.f877f.setOnClickListener(new C01431(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2110011523, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1531748869);
        super.mi_();
        this.f873b.e.requestFocus();
        KeyboardUtils.b(ao(), this.f873b);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1566503722, a);
    }

    public final void m856G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1647508017);
        super.G();
        HandlerDetour.b(this.f879h, new C01452(this), 500, -1724853352);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 594234206, a);
    }

    public final void m858a() {
        this.f874c.setVisibility(0);
        this.f878g.setVisibility(8);
        this.f877f.setVisibility(8);
    }

    public final void m860b() {
    }

    public final void m861c() {
        this.f874c.setVisibility(8);
        this.f878g.setVisibility(0);
        this.f877f.setVisibility(0);
        this.f873b.b();
    }

    public final void m859a(String str) {
        this.f872a.d_(str);
    }
}
