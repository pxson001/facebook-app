package com.facebook.groups.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: published_on */
public class GroupsFeedTypeValueParams implements Parcelable {
    public static final Creator<GroupsFeedTypeValueParams> CREATOR = new C05271();
    public final String f5695a;
    public final GroupsFeedTypes f5696b;
    private final String f5697c;
    public final List<String> f5698d;

    /* compiled from: published_on */
    final class C05271 implements Creator<GroupsFeedTypeValueParams> {
        C05271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GroupsFeedTypeValueParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new GroupsFeedTypeValueParams[i];
        }
    }

    /* compiled from: published_on */
    public /* synthetic */ class C05282 {
        public static final /* synthetic */ int[] f5694a = new int[GroupsFeedTypes.values().length];

        static {
            try {
                f5694a[GroupsFeedTypes.PinnedPosts.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5694a[GroupsFeedTypes.PendingPosts.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5694a[GroupsFeedTypes.ReportedPosts.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5694a[GroupsFeedTypes.YourAvailableForSalePosts.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5694a[GroupsFeedTypes.YourSoldForSalePosts.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5694a[GroupsFeedTypes.YourExpiredForSalePosts.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5694a[GroupsFeedTypes.GroupsStories.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f5694a[GroupsFeedTypes.AvailableForSalePosts.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f5694a[GroupsFeedTypes.CrossGroupForSalePosts.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* compiled from: published_on */
    public enum GroupsFeedTypes {
        PinnedPosts,
        PendingPosts,
        ReportedPosts,
        GroupsFeed,
        GroupsStories,
        YourAvailableForSalePosts,
        YourSoldForSalePosts,
        YourExpiredForSalePosts,
        AvailableForSalePosts,
        CrossGroupForSalePosts
    }

    public GroupsFeedTypeValueParams(String str, GroupsFeedTypes groupsFeedTypes, List<String> list) {
        this.f5695a = str;
        this.f5696b = groupsFeedTypes;
        this.f5698d = list;
        this.f5697c = m6948e() + str;
    }

    public GroupsFeedTypeValueParams(String str, GroupsFeedTypes groupsFeedTypes) {
        this.f5695a = str;
        this.f5696b = groupsFeedTypes;
        this.f5698d = null;
        this.f5697c = m6948e() + str;
    }

    public GroupsFeedTypeValueParams(Parcel parcel) {
        this.f5695a = parcel.readString();
        this.f5696b = GroupsFeedTypes.valueOf(parcel.readString());
        this.f5698d = null;
        this.f5697c = m6948e() + this.f5695a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5695a);
        parcel.writeString(this.f5696b.toString());
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final ImmutableList<String> m6949b() {
        if (this.f5698d != null) {
            return ImmutableList.copyOf(this.f5698d);
        }
        return null;
    }

    public String toString() {
        return this.f5697c;
    }

    private String m6948e() {
        return this.f5696b == GroupsFeedTypes.GroupsStories ? "" : this.f5696b.toString() + ":";
    }
}
