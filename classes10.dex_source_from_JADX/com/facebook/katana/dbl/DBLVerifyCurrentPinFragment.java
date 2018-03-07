package com.facebook.katana.dbl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.devicebasedlogin.ui.PasscodeViewListener;
import com.facebook.devicebasedlogin.ui.PinCodeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.keyboard.KeyboardUtils;

/* compiled from: update_favorites_failed */
public class DBLVerifyCurrentPinFragment extends FbFragment implements DeviceBasedLoginWaitListener, PasscodeViewListener {
    TextView f906a;
    public DBLPinSettingsListener f907b;
    private PinCodeView f908c;
    private ProgressBar f909d;
    private int f910e;
    private int f911f;

    public final View m931a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -122545764);
        View inflate = layoutInflater.inflate(2130903848, viewGroup, false);
        this.f906a = (TextView) inflate.findViewById(2131560318);
        if (this.f910e != 0) {
            ((TextView) inflate.findViewById(2131559592)).setText(this.f910e);
        }
        if (this.f911f != 0) {
            this.f906a.setText(this.f911f);
        }
        this.f908c = (PinCodeView) inflate.findViewById(2131558995);
        this.f908c.f = this;
        this.f908c.a();
        this.f908c.b();
        this.f909d = (ProgressBar) inflate.findViewById(2131559418);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -350474045, a);
        return inflate;
    }

    public final void m936g(int i) {
        this.f910e = i;
        if (this.T != null) {
            ((TextView) this.T.findViewById(2131559592)).setText(this.f910e);
        }
    }

    public final void m937h(int i) {
        this.f911f = i;
        if (this.f906a != null) {
            this.f906a.setText(this.f911f);
        }
    }

    public final void m930G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 230197766);
        super.G();
        this.f908c.e.requestFocus();
        KeyboardUtils.b(ao(), this.f908c.e);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1378052180, a);
    }

    public final void m932a() {
        this.f909d.setVisibility(0);
    }

    public final void m934b() {
        this.f909d.setVisibility(8);
    }

    public final void m935c() {
        this.f909d.setVisibility(8);
        this.f908c.b();
    }

    public final void m933a(String str) {
        this.f907b.mo1042b(str);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1047446523);
        super.mj_();
        KeyboardUtils.a(ao());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 861187299, a);
    }
}
