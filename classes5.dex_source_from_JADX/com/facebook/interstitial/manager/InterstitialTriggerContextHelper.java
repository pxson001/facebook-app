package com.facebook.interstitial.manager;

import com.google.common.collect.ImmutableMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: TOPIC_COUNTRY */
public class InterstitialTriggerContextHelper {
    private static final Pattern f13877a = Pattern.compile("\\{([^{}]*)\\}");

    public static Set<String> m23256a(@Nullable String str) {
        if (str == null) {
            return new HashSet();
        }
        Set<String> hashSet = new HashSet();
        Matcher matcher = f13877a.matcher(str);
        while (matcher.find()) {
            hashSet.add(matcher.group(1));
        }
        return hashSet;
    }

    public static String m23255a(@Nullable String str, @Nullable InterstitialTriggerContext interstitialTriggerContext) {
        if (str == null) {
            return null;
        }
        if (interstitialTriggerContext == null) {
            return str;
        }
        ImmutableMap immutableMap = interstitialTriggerContext.f13876a;
        Matcher matcher = f13877a.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (immutableMap.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, "");
                stringBuffer.append((String) immutableMap.get(group));
            } else {
                throw new IllegalArgumentException("Unknown token " + group);
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
