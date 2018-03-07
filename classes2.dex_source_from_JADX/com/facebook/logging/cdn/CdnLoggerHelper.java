package com.facebook.logging.cdn;

import android.net.Uri;
import android.net.Uri.Builder;
import com.google.common.base.Splitter;
import javax.annotation.Nullable;

/* compiled from: num_ads_in_first_fetch_pyml */
public class CdnLoggerHelper {
    public static String m17686a(String str) {
        Uri parse = Uri.parse(str);
        Builder buildUpon = parse.buildUpon();
        buildUpon.encodedQuery("");
        for (String split : Splitter.on('&').omitEmptyStrings().split(parse.getQuery())) {
            String split2 = (String) Splitter.on('=').split(split2).iterator().next();
            if (!(split2 == null || split2.equals("logcdn"))) {
                buildUpon.appendQueryParameter(split2, parse.getQueryParameter(split2));
            }
        }
        return buildUpon.build().toString();
    }

    @Nullable
    public static String m17687b(String str) {
        Uri parse = Uri.parse(str);
        return parse.isHierarchical() ? parse.getQueryParameter("logcdn") : null;
    }
}
