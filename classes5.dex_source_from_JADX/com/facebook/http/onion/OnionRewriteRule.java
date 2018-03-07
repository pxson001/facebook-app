package com.facebook.http.onion;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AutoGenJsonDeserializer
@JsonDeserialize(using = OnionRewriteRuleDeserializer.class)
/* compiled from: directmap */
public class OnionRewriteRule {
    private Pattern f5058a;
    @JsonProperty("format")
    public String format;
    @JsonProperty("matcher")
    public String matcher;

    private synchronized Pattern m9977a() {
        if (this.f5058a == null && this.matcher != null) {
            this.f5058a = Pattern.compile(this.matcher);
        }
        return this.f5058a;
    }

    public final String m9978a(String str) {
        Pattern a = m9977a();
        if (a == null) {
            return str;
        }
        Matcher matcher = a.matcher(str);
        if (!matcher.matches()) {
            return str;
        }
        String str2 = this.format;
        for (int i = 0; i <= matcher.groupCount(); i++) {
            CharSequence group = matcher.group(i);
            if (group == null) {
                group = "";
            }
            str2 = str2.replace(String.format(Locale.ENGLISH, "$%d", new Object[]{Integer.valueOf(i)}), group);
        }
        return str2;
    }
}
