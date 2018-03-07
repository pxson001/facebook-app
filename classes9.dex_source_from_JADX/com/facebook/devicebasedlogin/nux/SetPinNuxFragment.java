package com.facebook.devicebasedlogin.nux;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.devicebasedlogin.ui.PasscodeViewListener;
import com.facebook.devicebasedlogin.ui.PinCodeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.keyboard.KeyboardUtils;

/* compiled from: This field is not an extension. */
public class SetPinNuxFragment extends FbFragment implements DeviceBasedLoginWaitListener, PasscodeViewListener {
    public ActivateDBLListener f24168a;
    public PinCodeView f24169b;
    private final Handler f24170c = new Handler();

    /* compiled from: This field is not an extension. */
    class C29181 implements Runnable {
        final /* synthetic */ SetPinNuxFragment f24167a;

        C29181(SetPinNuxFragment setPinNuxFragment) {
            this.f24167a = setPinNuxFragment;
        }

        public void run() {
            this.f24167a.f24169b.f6674e.requestFocus();
            ((InputMethodManager) this.f24167a.ao().getSystemService("input_method")).showSoftInput(this.f24167a.f24169b.f6674e, 1);
        }
    }

    public final View m26130a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1008384655);
        View inflate = layoutInflater.inflate(2130903893, viewGroup, false);
        this.f24169b = (PinCodeView) inflate.findViewById(2131558995);
        this.f24169b.f6675f = this;
        ((TextView) inflate.findViewById(2131558927)).setText(2131236237);
        ((TextView) inflate.findViewById(2131560967)).setVisibility(0);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -640587889, a);
        return inflate;
    }

    public final void m26129G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1982733855);
        super.G();
        HandlerDetour.b(this.f24170c, new C29181(this), 500, -1302004431);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1088948846, a);
    }

    public final void mo1131a() {
    }

    public final void mo1132b() {
    }

    public final void mo1133c() {
        this.f24169b.m6985b();
    }

    public final void mo1134a(String str) {
        if (this.f24168a != null) {
            KeyboardUtils.a(ao());
            this.f24168a.b_(str);
        }
    }
}
