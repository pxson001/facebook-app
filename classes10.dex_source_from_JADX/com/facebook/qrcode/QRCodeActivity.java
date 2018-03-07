package com.facebook.qrcode;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;

/* compiled from: load failed */
public class QRCodeActivity extends FbFragmentActivity {
    public final void m8496b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906534);
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
        fbTitleBar.setTitle(2131241358);
        fbTitleBar.setHasBackButton(false);
        fbTitleBar.setCustomTitleView(null);
        final FragmentManager kO_ = kO_();
        Fragment a = kO_.a(2131558429);
        fbTitleBar.a(new OnClickListener(this) {
            final /* synthetic */ QRCodeActivity f8585b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 335537344);
                if (kO_.e()) {
                    Logger.a(2, EntryType.UI_INPUT_END, 1552164950, a);
                    return;
                }
                this.f8585b.finish();
                LogUtils.a(-1613468737, a);
            }
        });
        if (a == null) {
            QRCodeFragment qRCodeFragment = new QRCodeFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("source", getIntent().getStringExtra("source"));
            qRCodeFragment.g(bundle2);
            kO_.a().a(2131558429, qRCodeFragment).b();
        }
    }
}
