package com.facebook.adinterfaces.external;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import java.net.URLEncoder;

/* compiled from: bd_accepted_request */
public class AdInterfacesIntentUtil {
    private static final String[] f8015a = new String[]{"placement_extra", "source", "referral"};

    public static Intent m14176a(Context context, ObjectiveType objectiveType, Integer num, String str) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.facebook.adinterfaces.AdInterfacesObjectiveActivity");
        intent.putExtra("objective", objectiveType);
        intent.putExtra("title", num);
        intent.putExtra("placement_extra", str);
        return intent;
    }

    public static Intent m14174a(Context context, int i, String str, String str2, String str3, String str4, boolean z) {
        if (z) {
            return m14175a(context, ObjectiveType.BOOSTED_COMPONENT_BOOST_POST, i, str, str2, str3, str4);
        }
        return m14175a(context, ObjectiveType.BOOST_POST, i, str, str2, str3, str4);
    }

    public static String m14178a(String str, String str2, String str3, String str4) {
        return StringFormatUtil.formatStrLocaleSafe(FBLinks.e, URLEncoder.encode(str, "utf-8"), URLEncoder.encode(str2, "utf-8"), URLEncoder.encode(str3, "utf-8"), URLEncoder.encode(str4, "utf-8"));
    }

    public static Intent m14173a(Context context, int i, String str, String str2, String str3, String str4, String str5) {
        Intent a = m14175a(context, ObjectiveType.BOOST_EVENT, i, str2, str3, str4, str5);
        a.putExtra("promotion_target_id", str);
        return a;
    }

    private static Intent m14175a(Context context, ObjectiveType objectiveType, int i, String str, String str2, String str3, String str4) {
        Intent a = m14176a(context, objectiveType, Integer.valueOf(i), str4);
        a.putExtra("storyId", str);
        a.putExtra("legacyStoryId", str2);
        a.putExtra("page_id", str3);
        a.putExtra("placement_extra", str4);
        return a;
    }

    public static Intent m14172a(Context context, int i, String str, String str2, Intent intent) {
        Intent a = m14176a(context, ObjectiveType.BOOST_POST_INSIGHTS, Integer.valueOf(i), str);
        a.putExtra("storyId", str2);
        a.putExtra("intent", intent);
        return a;
    }

    public static String m14177a(Intent intent) {
        for (String stringExtra : f8015a) {
            String stringExtra2 = intent.getStringExtra(stringExtra2);
            if (stringExtra2 != null && !"UNKNOWN".equals(stringExtra2)) {
                return stringExtra2;
            }
        }
        return "UNKNOWN";
    }
}
