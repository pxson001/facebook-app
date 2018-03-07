package com.facebook.video.livemap;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.crudolib.urimap.runtime.ComponentHelper;

/* compiled from: shown */
public class LiveMapUriMapHelper extends ComponentHelper {
    public final Intent mo1269a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putInt("title_bar_background_color_id", 2131361921);
        extras.putInt("fragment_background_color_id", 2131361921);
        intent.putExtras(extras);
        return super.mo1269a(intent);
    }
}
