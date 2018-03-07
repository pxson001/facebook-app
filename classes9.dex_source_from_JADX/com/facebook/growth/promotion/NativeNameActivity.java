package com.facebook.growth.promotion;

import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.growth.nux.fragments.NUXNativeNameFragment;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;

/* compiled from: p2p_remove_card_success */
public class NativeNameActivity extends FbFragmentActivity {
    public final void m7806b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906554);
        FbTitleBarUtil.b(this);
        ((FbTitleBar) a(2131558563)).setTitle(2131236370);
        kO_().a().a(2131566509, new NUXNativeNameFragment()).b();
    }
}
