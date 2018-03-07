package com.facebook.katana.activity.media;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.util.StringUtil;
import com.facebook.katana.activity.BaseFacebookActivity;

/* compiled from: {parent_page_id NOT_SET} */
public class ViewVideoActivity extends BaseFacebookActivity {
    public final void m27b(Bundle bundle) {
        super.b(bundle);
        String stringExtra = getIntent().getStringExtra("href");
        if (stringExtra != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            Uri parse = Uri.parse(stringExtra);
            if (StringUtil.a(parse.getScheme(), "https")) {
                parse = parse.buildUpon().scheme("http").build();
            }
            intent.setDataAndType(parse, "video/*");
            if (getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                startActivity(intent);
            }
        }
        finish();
    }
}
