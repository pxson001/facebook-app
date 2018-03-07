package com.facebook.abtest.qe.settings;

import com.facebook.inject.InjectorLike;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: top_level_offending_relative_layout */
public class QuickExperimentNameHelper {
    public static QuickExperimentNameHelper m2486a(InjectorLike injectorLike) {
        return new QuickExperimentNameHelper();
    }

    public static String m2487a(String str) {
        Preconditions.checkNotNull(str);
        Iterable<String> split = Splitter.on("_").omitEmptyStrings().split(str);
        Iterable a = Lists.a();
        for (String str2 : split) {
            StringBuilder stringBuilder = new StringBuilder(str2.length());
            stringBuilder.append(Character.toUpperCase(str2.charAt(0)));
            if (str2.contains(":")) {
                List splitToList = Splitter.on(":").omitEmptyStrings().splitToList(str2);
                stringBuilder.append(((String) splitToList.get(0)).substring(1));
                stringBuilder.append(" - ");
                stringBuilder.append(Character.toUpperCase(((String) splitToList.get(1)).charAt(0)));
                stringBuilder.append(((String) splitToList.get(1)).substring(1));
            } else if (str2.length() > 1) {
                stringBuilder.append(str2.substring(1));
            }
            a.add(stringBuilder.toString());
        }
        return Joiner.on(" ").join(a);
    }
}
