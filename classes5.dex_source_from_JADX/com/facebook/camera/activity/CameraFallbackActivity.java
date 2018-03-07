package com.facebook.camera.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: analytics_module */
public class CameraFallbackActivity extends FbFragmentActivity implements OnClickListener {
    protected final void m18833b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903483);
        findViewById(2131560146).setOnClickListener(this);
        findViewById(2131560147).setOnClickListener(this);
        findViewById(2131560148).setOnClickListener(this);
        findViewById(2131560149).setOnClickListener(this);
    }

    public void onClick(View view) {
        int i = 2;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1473456730);
        int id = view.getId();
        if (id == 2131560146) {
            i = 4;
        } else if (id != 2131560148) {
            i = id == 2131560149 ? 1 : id == 2131560147 ? 3 : -1;
        }
        setResult(i);
        finish();
        LogUtils.a(-1152967798, a);
    }
}
