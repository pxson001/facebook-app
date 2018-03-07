package com.facebook.contacts.picker;

import com.facebook.user.model.User;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: pn_ref */
public class UserComparatorByRankingAndName implements Comparator<User> {
    private final Map<String, UserRank> f6500a = new HashMap();

    /* compiled from: pn_ref */
    public class UserRank {
        Float f6497a = null;
        public boolean f6498b = false;
        public boolean f6499c = false;
    }

    public int compare(Object obj, Object obj2) {
        User user = (User) obj;
        User user2 = (User) obj2;
        String k = user.k();
        String k2 = user2.k();
        UserRank userRank = (UserRank) this.f6500a.get(k);
        UserRank userRank2 = (UserRank) this.f6500a.get(k2);
        int compare = Float.compare(userRank2.f6497a.floatValue(), userRank.f6497a.floatValue());
        if (compare != 0) {
            return compare;
        }
        compare = k.compareTo(k2);
        int a;
        if (compare != 0) {
            a = m6845a(userRank.f6498b, userRank.f6499c, userRank2.f6498b, userRank2.f6499c);
            if (a == 0) {
                return compare;
            }
            return a;
        }
        a = m6846b(user, user2);
        if (a == 0) {
            return Float.compare(user2.m, user.m);
        }
        return a;
    }

    public UserComparatorByRankingAndName(Collection<User> collection) {
        for (User user : collection) {
            String k = user.k();
            UserRank userRank = (UserRank) this.f6500a.get(k);
            if (userRank == null) {
                userRank = new UserRank();
                this.f6500a.put(k, userRank);
            }
            if (userRank.f6497a == null || userRank.f6497a.floatValue() < user.m) {
                userRank.f6497a = Float.valueOf(user.m);
            }
            if (user.t) {
                userRank.f6498b = true;
            }
            if (user.b()) {
                userRank.f6499c = true;
            }
        }
    }

    public static int m6845a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z || z3) {
            if (!z) {
                return 1;
            }
            if (z3) {
                return 0;
            }
            return -1;
        } else if (!z2 && !z4) {
            return 0;
        } else {
            if (!z2) {
                return 1;
            }
            if (z4) {
                return 0;
            }
            return -1;
        }
    }

    private static int m6846b(User user, User user2) {
        return m6845a(user.t, user.b(), user2.t, user2.b());
    }
}
