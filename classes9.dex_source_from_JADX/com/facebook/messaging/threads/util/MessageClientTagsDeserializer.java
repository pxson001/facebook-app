package com.facebook.messaging.threads.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.facebook.composer.lifeevent.type.ComposerLifeEventTypeActivity */
public class MessageClientTagsDeserializer {
    public static Map<String, String> m17833a(@Nullable List<String> list) {
        Map<String, String> hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (String str : list) {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0) {
                hashMap.put(str.substring(0, indexOf), str.substring(indexOf + 1));
            } else {
                hashMap.put(str, "");
            }
        }
        return hashMap;
    }
}
