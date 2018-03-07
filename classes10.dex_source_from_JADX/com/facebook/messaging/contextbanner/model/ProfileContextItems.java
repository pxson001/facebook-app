package com.facebook.messaging.contextbanner.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: status_id */
public class ProfileContextItems implements ContextItems {
    private static final ImmutableList<ProfileContextItemType> f2224a = ImmutableList.of(ProfileContextItemType.WORK, ProfileContextItemType.EDUCATION, ProfileContextItemType.CURRENT_CITY);
    public static final ImmutableList<ProfileContextItemType> f2225b = ImmutableList.of(ProfileContextItemType.CURRENT_CITY, ProfileContextItemType.EDUCATION);
    public static final ImmutableList<ProfileContextItemType> f2226c = ImmutableList.of(ProfileContextItemType.CURRENT_CITY);
    private final ImmutableList<ProfileContextItem> f2227d;

    public ProfileContextItems(ImmutableList<ProfileContextItem> immutableList) {
        this.f2227d = (ImmutableList) Preconditions.checkNotNull(immutableList);
    }

    @Nullable
    public final String mo60a() {
        ProfileContextItem a = m2096a(ProfileContextItemType.OTHER);
        if (a == null) {
            return null;
        }
        return a.f2223b;
    }

    @Nullable
    public final String mo61b() {
        ProfileContextItem d = m2098d();
        if (d != null) {
            return d.f2223b;
        }
        return null;
    }

    @Nullable
    public final String mo62c() {
        ProfileContextItem d = m2098d();
        if (d == null) {
            return null;
        }
        d = m2095a(d);
        if (d != null) {
            return d.f2223b;
        }
        return null;
    }

    @Nullable
    private ProfileContextItem m2096a(ProfileContextItemType profileContextItemType) {
        int size = this.f2227d.size();
        for (int i = 0; i < size; i++) {
            ProfileContextItem profileContextItem = (ProfileContextItem) this.f2227d.get(i);
            if (profileContextItemType == profileContextItem.f2222a) {
                return profileContextItem;
            }
        }
        return null;
    }

    @Nullable
    private ProfileContextItem m2098d() {
        return m2097a(f2224a);
    }

    @Nullable
    private ProfileContextItem m2097a(ImmutableList<ProfileContextItemType> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ProfileContextItem a = m2096a((ProfileContextItemType) immutableList.get(i));
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    @Nullable
    private ProfileContextItem m2095a(ProfileContextItem profileContextItem) {
        ImmutableList immutableList;
        ProfileContextItemType profileContextItemType = profileContextItem.f2222a;
        if (profileContextItemType == ProfileContextItemType.WORK) {
            immutableList = f2225b;
        } else if (profileContextItemType == ProfileContextItemType.EDUCATION) {
            immutableList = f2226c;
        } else {
            immutableList = RegularImmutableList.a;
        }
        return m2097a(immutableList);
    }
}
