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

/* compiled from: update_favorites_success */
public class DBLSetNewPinFragment extends FbFragment implements DeviceBasedLoginWaitListener, PasscodeViewListener {
    public DBLPinSettingsListener f901a;
    private PinCodeView f902b;
    private ProgressBar f903c;
    private int f904d;
    private int f905e;

    public final View m923a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 712980551);
        View inflate = layoutInflater.inflate(2130903848, viewGroup, false);
        if (this.f904d != 0) {
            ((TextView) inflate.findViewById(2131559592)).setText(this.f904d);
        }
        if (this.f905e != 0) {
            ((TextView) inflate.findViewById(2131560318)).setText(this.f905e);
        }
        this.f902b = (PinCodeView) inflate.findViewById(2131558995);
        this.f902b.f = this;
        this.f903c = (ProgressBar) inflate.findViewById(2131559418);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1731959525, a);
        return inflate;
    }

    public final void m928g(int i) {
        this.f904d = i;
        if (this.T != null) {
            ((TextView) this.T.findViewById(2131559592)).setText(this.f904d);
        }
    }

    public final void m929h(int i) {
        this.f905e = i;
        if (this.T != null) {
            ((TextView) this.T.findViewById(2131560318)).setText(this.f905e);
        }
    }

    public final void m922G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2042643704);
        super.G();
        this.f902b.e.requestFocus();
        KeyboardUtils.b(ao(), this.f902b.e);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -722236765, a);
    }

    public final void m924a() {
        this.f903c.setVisibility(0);
    }

    public final void m926b() {
        this.f903c.setVisibility(8);
    }

    public final void m927c() {
        this.f903c.setVisibility(8);
        this.f902b.b();
    }

    public final void m925a(String str) {
        if (this.f901a != null) {
            this.f901a.d_(str);
        }
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 121422695);
        super.mj_();
        KeyboardUtils.a(ao());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 696009546, a);
    }
}
