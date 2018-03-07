package com.facebook.ufiservices.flyout;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.ipc.feed.ProfileListParamType;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: d5b45d145ec253d150d059afdd637c45 */
public class ProfileListParams implements Parcelable {
    public static final Creator<ProfileListParams> CREATOR = new C13121();
    public String f18089a;
    private List<GraphQLActor> f18090b;
    private List<String> f18091c;
    public ProfileListParamType f18092d = ProfileListParamType.UNKNOWN;
    public boolean f18093e;
    public boolean f18094f;
    public boolean f18095g;
    public String f18096h;
    public String f18097i;
    public HashMap<Integer, Integer> f18098j;

    /* compiled from: d5b45d145ec253d150d059afdd637c45 */
    final class C13121 implements Creator<ProfileListParams> {
        C13121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProfileListParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProfileListParams[i];
        }
    }

    /* compiled from: d5b45d145ec253d150d059afdd637c45 */
    public class Builder {
        public String f18079a;
        public List<GraphQLActor> f18080b;
        public List<String> f18081c;
        public ProfileListParamType f18082d = ProfileListParamType.UNKNOWN;
        public boolean f18083e;
        public boolean f18084f;
        public boolean f18085g;
        public String f18086h;
        public String f18087i;
        public HashMap<Integer, Integer> f18088j;

        public final ProfileListParams m26564a() {
            boolean z;
            if (this.f18079a == null && this.f18080b == null && this.f18081c == null) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z, "Either a feedback id, profile ids or actors list must be set");
            return new ProfileListParams(this);
        }
    }

    public ProfileListParams(Parcel parcel) {
        this.f18089a = parcel.readString();
        this.f18090b = parcel.readArrayList(GraphQLActor.class.getClassLoader());
        this.f18091c = parcel.readArrayList(String.class.getClassLoader());
        this.f18092d = ProfileListParamType.values()[parcel.readInt()];
        this.f18093e = ParcelUtil.a(parcel);
        this.f18094f = ParcelUtil.a(parcel);
        this.f18095g = ParcelUtil.a(parcel);
        this.f18096h = parcel.readString();
        this.f18097i = parcel.readString();
        this.f18098j = (HashMap) parcel.readSerializable();
    }

    public ProfileListParams(Builder builder) {
        this.f18089a = builder.f18079a;
        this.f18090b = builder.f18080b;
        this.f18091c = builder.f18081c;
        this.f18092d = builder.f18082d;
        this.f18093e = builder.f18083e;
        this.f18094f = builder.f18084f;
        this.f18095g = builder.f18085g;
        this.f18096h = builder.f18086h;
        this.f18097i = builder.f18087i;
        this.f18098j = builder.f18088j;
    }

    @Nullable
    public final ImmutableList<GraphQLActor> m26565a() {
        return this.f18090b != null ? ImmutableList.copyOf(this.f18090b) : null;
    }

    @Nullable
    public final ImmutableList<String> m26566b() {
        return this.f18091c != null ? ImmutableList.copyOf(this.f18091c) : null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18089a);
        parcel.writeList(m26565a());
        parcel.writeList(m26566b());
        parcel.writeInt(this.f18092d.ordinal());
        ParcelUtil.a(parcel, this.f18093e);
        ParcelUtil.a(parcel, this.f18094f);
        ParcelUtil.a(parcel, this.f18095g);
        parcel.writeString(this.f18096h);
        parcel.writeString(this.f18097i);
        parcel.writeSerializable(this.f18098j);
    }

    public int describeContents() {
        return 0;
    }

    public final Bundle m26567k() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("profileListParams", this);
        return bundle;
    }
}
