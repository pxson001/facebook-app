package com.facebook.browser.prefetch;

import com.facebook.common.util.StringUtil;
import com.google.common.base.Strings;
import java.io.File;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: processPhoto Exception */
public class BrowserPrefetchCacheManager$CacheEntry {
    public int f7412a;
    public String f7413b;
    public String f7414c;
    public String f7415d = "";
    public String f7416e = "";
    public boolean f7417f = false;

    public BrowserPrefetchCacheManager$CacheEntry(File file, String str, @Nullable String str2) {
        this.f7412a = (int) file.length();
        this.f7413b = str;
        this.f7414c = file.getAbsolutePath();
        if (!Strings.isNullOrEmpty(str2)) {
            String str3;
            List a = StringUtil.a(str2, ';');
            if (!a.isEmpty()) {
                if (a.get(0) == null) {
                    str3 = "";
                } else {
                    str3 = ((String) a.get(0)).trim();
                }
                this.f7415d = str3;
            }
            for (int i = 1; i < a.size(); i++) {
                str3 = (String) a.get(i);
                if (!Strings.isNullOrEmpty(str3)) {
                    str3 = str3.toUpperCase(Locale.US).trim();
                    if (str3.contains("CHARSET")) {
                        List a2 = StringUtil.a(str3, '=');
                        if (a2.size() == 2 && "CHARSET".equals(((String) a2.get(0)).trim())) {
                            if (a2.get(1) == null) {
                                str3 = "";
                            } else {
                                str3 = ((String) a2.get(1)).trim();
                            }
                            this.f7416e = str3;
                            return;
                        }
                    }
                    continue;
                }
            }
        }
    }
}
