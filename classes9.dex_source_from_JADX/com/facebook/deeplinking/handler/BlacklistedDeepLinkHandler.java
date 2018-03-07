package com.facebook.deeplinking.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.util.StringUtil;
import com.facebook.deeplinking.DeepLinkingUtils;
import com.facebook.deeplinking.config.DeepLinkingConfig;
import com.facebook.xconfig.core.XConfigReader;
import java.util.List;
import javax.inject.Inject;

/* compiled from: photoResult */
public class BlacklistedDeepLinkHandler implements DeepLinkHandler {
    private final XConfigReader f6613a;
    private final DeepLinkingUtils f6614b;

    @Inject
    public BlacklistedDeepLinkHandler(XConfigReader xConfigReader, DeepLinkingUtils deepLinkingUtils) {
        this.f6613a = xConfigReader;
        this.f6614b = deepLinkingUtils;
    }

    public final Intent mo269a(Context context, Uri uri) {
        String path = uri.getPath();
        for (String a : StringUtil.a(this.f6613a.a(DeepLinkingConfig.c, ""), ',')) {
            List a2 = StringUtil.a(a, ':');
            String a3 = (String) a2.get(0);
            Object obj = (a2.size() <= 1 || StringUtil.a((CharSequence) a2.get(1))) ? null : (String) a2.get(1);
            if (StringUtil.a(a3, path)) {
                Builder buildUpon = uri.buildUpon();
                buildUpon.authority("m.facebook.com");
                Uri build = buildUpon.build();
                if (!StringUtil.a(obj)) {
                    build = build.buildUpon().path(obj).build();
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(build);
                context.startActivity(intent);
                return DeepLinkingUtils.m6908b(build);
            }
        }
        return null;
    }
}
