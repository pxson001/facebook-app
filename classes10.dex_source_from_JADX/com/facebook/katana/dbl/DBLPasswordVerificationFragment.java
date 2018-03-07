package com.facebook.katana.dbl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.StringUtil;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.katana.common.SoftKeyboardHelper;
import com.facebook.katana.common.TextEnteredListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.keyboard.KeyboardUtils;

/* compiled from: upload_picture */
public class DBLPasswordVerificationFragment extends FbFragment implements DeviceBasedLoginWaitListener, TextEnteredListener {
    public EditText f882a;
    public DBLPinSettingsListener f883b;
    private Button f884c;
    private ProgressBar f885d;
    private int f886e;
    private int f887f;

    /* compiled from: upload_picture */
    public class C01461 implements OnClickListener {
        final /* synthetic */ DBLPasswordVerificationFragment f881a;

        public C01461(DBLPasswordVerificationFragment dBLPasswordVerificationFragment) {
            this.f881a = dBLPasswordVerificationFragment;
        }

        public void onClick(View view) {
            Boolean valueOf;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 197341546);
            Object obj = this.f881a.f882a.getText().toString();
            DBLPasswordVerificationFragment dBLPasswordVerificationFragment = this.f881a;
            if (StringUtil.a(obj)) {
                Toast.makeText(dBLPasswordVerificationFragment.ao(), dBLPasswordVerificationFragment.b(2131236275), 1).show();
                dBLPasswordVerificationFragment.f882a.setText("");
                valueOf = Boolean.valueOf(false);
            } else {
                valueOf = Boolean.valueOf(true);
            }
            if (valueOf.booleanValue()) {
                this.f881a.f883b.mo1043c(obj);
                LogUtils.a(826966256, a);
                return;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1632762736, a);
        }
    }

    public final View m863a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1378017041);
        View inflate = layoutInflater.inflate(2130903849, viewGroup, false);
        if (this.f886e != 0) {
            ((TextView) inflate.findViewById(2131559592)).setText(this.f886e);
        }
        if (this.f887f != 0) {
            ((TextView) inflate.findViewById(2131560318)).setText(this.f887f);
        }
        this.f882a = (EditText) inflate.findViewById(2131560912);
        new SoftKeyboardHelper().a(this, getContext(), this.f882a, b(2131236275));
        this.f885d = (ProgressBar) inflate.findViewById(2131559418);
        this.f884c = (Button) inflate.findViewById(2131560913);
        this.f884c.setOnClickListener(new C01461(this));
        KeyboardUtils.a(ao());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1493775311, a);
        return inflate;
    }

    public final void m868g(int i) {
        this.f886e = i;
        if (this.T != null) {
            ((TextView) this.T.findViewById(2131559592)).setText(this.f886e);
        }
    }

    public final void m869h(int i) {
        this.f887f = i;
        if (this.T != null) {
            ((TextView) this.T.findViewById(2131560318)).setText(this.f887f);
        }
    }

    public final void m862G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 18791628);
        super.G();
        this.f882a.requestFocus();
        KeyboardUtils.b(ao(), this.f882a);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1877252068, a);
    }

    public final void m865a(String str) {
        this.f883b.mo1043c(str);
    }

    public final void m864a() {
        this.f884c.setVisibility(8);
        this.f885d.setVisibility(0);
    }

    public final void m866b() {
        this.f885d.setVisibility(8);
    }

    public final void m867c() {
        this.f882a.setText("");
        this.f884c.setVisibility(0);
        this.f885d.setVisibility(8);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2036524086);
        super.mj_();
        KeyboardUtils.a(ao());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1830949470, a);
    }
}
