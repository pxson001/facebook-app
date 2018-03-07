package com.facebook.katana;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.credentials.PasswordCredentials.Type;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.StringUtil;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.katana.common.SoftKeyboardHelper;
import com.facebook.katana.common.TextEnteredListener;
import com.facebook.katana.dbl.DeviceBasedLoginListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.keyboard.KeyboardUtils;

/* compiled from: SECTION_HEADER */
public class LoginApprovalsFragment extends FbFragment implements OnClickListener, DeviceBasedLoginWaitListener, TextEnteredListener {
    private EditText f24197a;
    public DeviceBasedLoginListener f24198b;
    private Button f24199c;
    private ProgressBar f24200d;
    private DBLFacebookCredentials f24201e;

    public final void m25496c(Bundle bundle) {
        super.c(bundle);
        this.f24201e = (DBLFacebookCredentials) this.s.getParcelable("dbl_account_details");
    }

    public final View m25491a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -447926390);
        View inflate = layoutInflater.inflate(2130905141, viewGroup, false);
        this.f24197a = (EditText) inflate.findViewById(2131560331);
        new SoftKeyboardHelper().a(this, getContext(), this.f24197a, b(2131236274));
        this.f24200d = (ProgressBar) inflate.findViewById(2131559418);
        this.f24199c = (Button) inflate.findViewById(2131561795);
        this.f24199c.setOnClickListener(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -610342982, a);
        return inflate;
    }

    public final void m25492a() {
        this.f24199c.setVisibility(8);
        this.f24197a.setVisibility(8);
        this.f24200d.setVisibility(0);
    }

    public final void m25494b() {
        this.f24200d.setVisibility(8);
    }

    public final void m25495c() {
        this.f24199c.setVisibility(0);
        this.f24197a.setText("");
        this.f24197a.setVisibility(0);
        this.f24200d.setVisibility(8);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1325302519);
        if (view.getId() == 2131561795) {
            Object obj = this.f24197a.getText().toString();
            if (StringUtil.a(obj)) {
                Logger.a(2, EntryType.UI_INPUT_END, -191504606, a);
                return;
            }
            m25493a(obj);
        }
        LogUtils.a(-201419838, a);
    }

    public final void m25493a(String str) {
        KeyboardUtils.a(ao());
        this.f24198b.a(new PasswordCredentials(this.f24201e.mUserId, str, Type.PASSWORD), this.f24201e, this.s.getInt("dbl_flag", 0));
    }
}
