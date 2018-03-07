package com.facebook.events.permalink.guestlist.common;

import android.os.Bundle;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: header_see_more_tap */
public enum EventGuestListType {
    PRIVATE_GOING,
    PRIVATE_MAYBE,
    PRIVATE_INVITED,
    PRIVATE_NOT_GOING,
    PUBLIC_GOING,
    PUBLIC_WATCHED,
    PUBLIC_INVITED;

    public static EventGuestListType fromString(String str) {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase("PRIVATE_GOING")) {
            return PRIVATE_GOING;
        }
        if (str.equalsIgnoreCase("PRIVATE_MAYBE")) {
            return PRIVATE_MAYBE;
        }
        if (str.equalsIgnoreCase("PRIVATE_INVITED")) {
            return PRIVATE_INVITED;
        }
        if (str.equalsIgnoreCase("PRIVATE_NOT_GOING")) {
            return PRIVATE_NOT_GOING;
        }
        if (str.equalsIgnoreCase("PUBLIC_GOING")) {
            return PUBLIC_GOING;
        }
        if (str.equalsIgnoreCase("PUBLIC_WATCHED")) {
            return PUBLIC_WATCHED;
        }
        if (str.equalsIgnoreCase("PUBLIC_INVITED")) {
            return PUBLIC_INVITED;
        }
        return null;
    }

    public final String toString() {
        return name();
    }

    public static void writeGuestListTypesList(Bundle bundle, String str, List<EventGuestListType> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (EventGuestListType eventGuestListType : list) {
                arrayList.add(eventGuestListType.toString());
            }
            bundle.putStringArrayList(str, arrayList);
        }
    }

    public static ImmutableList<EventGuestListType> readGuestListTypesList(Bundle bundle, String str) {
        List<String> stringArrayList = bundle.getStringArrayList(str);
        Builder builder = new Builder();
        for (String str2 : stringArrayList) {
            if (str2 != null) {
                builder.c(valueOf(str2));
            }
        }
        return builder.b();
    }
}
