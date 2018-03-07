package com.facebook.messaging.photoreminders.inboxheader;

import com.facebook.common.util.CollectionUtil;
import com.facebook.messaging.photoreminders.interfaces.PhotoSuggestion;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: registration_step_error */
public class PhotoRemindersInboxDataUtil {
    @Nullable
    public final PhotoRemindersInboxData m3405a(ImmutableList<PhotoSuggestion> immutableList) {
        if (CollectionUtil.a(immutableList)) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < Math.min(3, immutableList.size()); i++) {
            builder.c(((PhotoSuggestion) immutableList.get(i)).a);
        }
        int size = immutableList.size();
        ImmutableList b = builder.b();
        long j = ((PhotoSuggestion) immutableList.get(0)).b;
        Map hashMap = new HashMap();
        for (PhotoSuggestion photoSuggestion : immutableList) {
            ImmutableList immutableList2 = photoSuggestion.c;
            ImmutableList immutableList3 = photoSuggestion.d;
            for (int i2 = 0; i2 < immutableList2.size(); i2++) {
                String str = (String) immutableList2.get(i2);
                if (!hashMap.containsKey(str)) {
                    hashMap.put(str, immutableList3.get(i2));
                }
            }
        }
        return new PhotoRemindersInboxData(size, b, j, ImmutableList.copyOf(hashMap.values()));
    }
}
