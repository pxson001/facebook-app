package com.facebook.http.blendedvip;

import android.annotation.SuppressLint;
import com.facebook.http.common.FbHttpRequest;
import java.net.URI;
import java.util.regex.Matcher;
import org.apache.http.impl.client.RequestWrapper;

/* compiled from: num_before_surround */
public final class VipRewriter {
    private VipRewriter() {
    }

    @SuppressLint({"DeprecatedClass"})
    public static void m17683a(RequestWrapper requestWrapper, FbHttpRequest fbHttpRequest, VipRewriteConfig vipRewriteConfig) {
        String str = fbHttpRequest.f7686c;
        if (vipRewriteConfig.f11987a && !BlendedOverwriteConstants.a.contains(str) && !vipRewriteConfig.f11991e.contains(str)) {
            str = requestWrapper.getURI().toString();
            Matcher matcher = vipRewriteConfig.f11989c.matcher(requestWrapper.getURI().getHost());
            if (matcher.find() && matcher.start() == 0) {
                String replaceFirst = str.replaceFirst("\\/\\/", "//" + vipRewriteConfig.f11990d);
                if (!str.equals(replaceFirst)) {
                    requestWrapper.setURI(URI.create(replaceFirst));
                }
            }
        }
    }
}
