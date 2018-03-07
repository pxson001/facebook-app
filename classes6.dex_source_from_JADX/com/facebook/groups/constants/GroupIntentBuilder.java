package com.facebook.groups.constants;

import android.os.Bundle;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: mPhones */
public class GroupIntentBuilder {
    public static void m17640a(Bundle bundle, String str, String str2, @Nullable ImmutableList<String> immutableList) {
        bundle.putString("group_feed_id", str);
        bundle.putString("group_feed_title", str2);
        if (immutableList != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(immutableList);
            bundle.putStringArrayList("group_feed_hoisted_story_ids", arrayList);
        }
    }
}
