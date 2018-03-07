package com.facebook.richdocument.logging;

import com.facebook.bugreporter.BugReportExtraDataMapProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.richdocument.RichDocumentConstants;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: place_reaction_units */
public class RichDocumentBugReportExtraDataProvider implements BugReportExtraDataMapProvider {
    private final FbSharedPreferences f5494a;

    @Inject
    public RichDocumentBugReportExtraDataProvider(FbSharedPreferences fbSharedPreferences) {
        this.f5494a = fbSharedPreferences;
    }

    public final Map<String, String> m5372c() {
        CharSequence a = this.f5494a.a(RichDocumentConstants.f5038b, null);
        if (StringUtil.c(a)) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        hashMap.put("last_article", a);
        return hashMap;
    }

    public final Map<String, String> m5373d() {
        return null;
    }
}
