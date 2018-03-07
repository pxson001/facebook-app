package com.facebook.user.util;

import com.facebook.user.model.User;
import java.util.Comparator;

/* compiled from: context_status_secondary */
public class UserRankComparator implements Comparator<User> {
    public static final UserRankComparator f18478a = new UserRankComparator();

    public int compare(Object obj, Object obj2) {
        return Float.compare(((User) obj2).m, ((User) obj).m);
    }
}
