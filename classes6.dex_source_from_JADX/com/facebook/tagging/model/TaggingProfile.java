package com.facebook.tagging.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.user.model.Name;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: deltaRTCEventLog */
public class TaggingProfile implements Parcelable, Comparable<TaggingProfile> {
    public static final Creator<TaggingProfile> CREATOR = new C12801();
    public final Name f17538a;
    public final long f17539b;
    public final String f17540c;
    @Nullable
    public final String f17541d;
    public final Type f17542e;
    public final String f17543f;
    private final String f17544g;
    public final String f17545h;
    public final String f17546i;

    /* compiled from: deltaRTCEventLog */
    final class C12801 implements Creator<TaggingProfile> {
        C12801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TaggingProfile(parcel);
        }

        public final Object[] newArray(int i) {
            return new TaggingProfile[i];
        }
    }

    /* compiled from: deltaRTCEventLog */
    public class Builder {
        public Name f17529a;
        public long f17530b;
        public String f17531c;
        @Nullable
        public String f17532d;
        public Type f17533e;
        public String f17534f;
        public String f17535g;
        public String f17536h;
        public String f17537i;

        public final TaggingProfile m25525j() {
            return new TaggingProfile(this);
        }
    }

    /* compiled from: deltaRTCEventLog */
    public enum Type {
        UNKNOWN,
        TEXT,
        SELF,
        USER,
        PAGE,
        FAMILY_NONUSER_MEMBER
    }

    public int compareTo(Object obj) {
        return Long.valueOf(this.f17539b).compareTo(Long.valueOf(((TaggingProfile) obj).f17539b));
    }

    public TaggingProfile(Builder builder) {
        this.f17538a = builder.f17529a;
        this.f17539b = builder.f17530b;
        this.f17540c = builder.f17531c;
        this.f17541d = builder.f17532d;
        this.f17542e = builder.f17533e;
        this.f17543f = builder.f17534f;
        this.f17544g = builder.f17535g;
        this.f17546i = builder.f17536h;
        this.f17545h = builder.f17537i;
    }

    public final Name m25529a() {
        return this.f17538a;
    }

    public final String m25532i() {
        return this.f17538a.i();
    }

    public final long m25530b() {
        return this.f17539b;
    }

    public final Type m25531d() {
        return this.f17542e;
    }

    public static Type m25527a(GraphQLObjectType graphQLObjectType) {
        if (graphQLObjectType == null) {
            return Type.UNKNOWN;
        }
        return m25526a(graphQLObjectType.g());
    }

    public static Type m25526a(int i) {
        switch (i) {
            case 2479791:
                return Type.PAGE;
            case 2645995:
                return Type.USER;
            default:
                return Type.UNKNOWN;
        }
    }

    public String toString() {
        return this.f17538a.g();
    }

    public TaggingProfile(Parcel parcel) {
        this.f17538a = (Name) parcel.readParcelable(Name.class.getClassLoader());
        this.f17539b = parcel.readLong();
        this.f17540c = parcel.readString();
        this.f17541d = parcel.readString();
        this.f17542e = Type.values()[parcel.readInt()];
        this.f17543f = parcel.readString();
        this.f17544g = parcel.readString();
        this.f17546i = parcel.readString();
        this.f17545h = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17538a, 0);
        parcel.writeLong(this.f17539b);
        parcel.writeString(this.f17540c);
        parcel.writeString(this.f17541d);
        parcel.writeInt(this.f17542e.ordinal());
        parcel.writeString(this.f17543f);
        parcel.writeString(this.f17544g);
        parcel.writeString(this.f17546i);
        parcel.writeString(this.f17545h);
    }

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f17539b)});
    }

    public boolean equals(Object obj) {
        return (obj instanceof TaggingProfile) && ((TaggingProfile) obj).f17539b == this.f17539b;
    }

    public static List<TaggingProfile> m25528a(List<TaggingProfile> list) {
        return Lists.a(Sets.c(list));
    }
}
