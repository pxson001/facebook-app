package com.facebook.groups.composer.groupspollcomposer;

import android.content.Context;
import com.facebook.common.util.StringUtil;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: view_events_dashboard_tap */
public class GroupsPollOptionValidator {
    public static String m471a(String str, List<String> list, Context context) {
        if (StringUtil.c(str)) {
            return context.getString(2131238482);
        }
        if (list.contains(str.trim())) {
            return context.getString(2131238484);
        }
        for (CharSequence matcher : str.split("\\s+")) {
            if (Pattern.compile("^((https?|ftp)://|(www|ftp)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$").matcher(matcher).find()) {
                return context.getString(2131238483);
            }
        }
        return null;
    }
}
