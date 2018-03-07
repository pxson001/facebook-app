package com.facebook.zero.activity;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;

/* compiled from: com.facebook.photos.upload.service.retry. */
class LinkshimIntentTransformer {
    LinkshimIntentTransformer() {
    }

    public static Intent m28913a(Intent intent) {
        if (intent != null) {
            Uri data = intent.getData();
            if (FacebookUriUtil.a(data) && StringUtil.a(data.getQueryParameter("no_warn_external"))) {
                Builder buildUpon = data.buildUpon();
                buildUpon.appendQueryParameter("no_warn_external", "1");
                intent.setData(buildUpon.build());
            }
        }
        return intent;
    }
}
