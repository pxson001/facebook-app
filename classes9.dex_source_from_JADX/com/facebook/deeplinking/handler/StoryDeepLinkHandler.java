package com.facebook.deeplinking.handler;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.util.StringUtil;
import com.facebook.deeplinking.activity.StoryDeepLinkLoadingActivity;
import java.util.List;

/* compiled from: phone_number_added */
public class StoryDeepLinkHandler implements DeepLinkHandler {
    public final Intent mo269a(Context context, Uri uri) {
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            String str = (String) pathSegments.get(0);
            if (StringUtil.a("permalink.php", str)) {
                return m6941c(context, uri);
            }
            if (StringUtil.a("story.php", str)) {
                Builder buildUpon = uri.buildUpon();
                buildUpon.path("permalink.php");
                return m6941c(context, buildUpon.build());
            }
        } else if (pathSegments.size() == 3 && StringUtil.a("posts", (String) pathSegments.get(1))) {
            return m6941c(context, uri);
        }
        return null;
    }

    public static Intent m6941c(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setComponent(new ComponentName(context, StoryDeepLinkLoadingActivity.class));
        intent.setData(uri);
        return intent;
    }
}
