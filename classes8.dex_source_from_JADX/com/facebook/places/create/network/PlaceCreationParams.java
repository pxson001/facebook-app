package com.facebook.places.create.network;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.privacy.model.GraphQLPrivacyOptionBuilder;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: caption_title_small_style */
public class PlaceCreationParams implements Parcelable {
    public static final Creator<PlaceCreationParams> CREATOR = new C20101();
    public final String f18371a;
    public final Optional<PlacePinAppId> f18372b;
    public final ImmutableList<Long> f18373c;
    public final String f18374d;
    public final long f18375e;
    public final String f18376f;
    public final String f18377g;
    public final String f18378h;
    public final String f18379i;
    public final String f18380j;
    public final boolean f18381k;
    public final GraphQLPrivacyOption f18382l;
    public final ImmutableList<Long> f18383m;
    public final PhotoItem f18384n;
    private final Location f18385o;

    /* compiled from: caption_title_small_style */
    final class C20101 implements Creator<PlaceCreationParams> {
        C20101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlaceCreationParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlaceCreationParams[i];
        }
    }

    private PlaceCreationParams(String str, Location location, Optional<PlacePinAppId> optional, PhotoItem photoItem, List<Long> list, String str2, long j, String str3, String str4, String str5, String str6, String str7, boolean z, GraphQLPrivacyOption graphQLPrivacyOption, List<Long> list2) {
        this.f18371a = str;
        this.f18385o = new Location(location);
        this.f18372b = optional;
        this.f18384n = photoItem;
        if (list != null) {
            this.f18373c = ImmutableList.copyOf(list);
        } else {
            this.f18373c = null;
        }
        this.f18374d = str2;
        this.f18375e = j;
        this.f18376f = str3;
        this.f18377g = str4;
        this.f18378h = str5;
        this.f18379i = str6;
        this.f18380j = str7;
        this.f18381k = z;
        this.f18382l = graphQLPrivacyOption;
        if (list2 != null) {
            this.f18383m = ImmutableList.copyOf(list2);
        } else {
            this.f18383m = null;
        }
    }

    public final Location m22329a() {
        return new Location(this.f18385o);
    }

    public static PlaceCreationParams m22326a(String str, Location location, Optional<PlacePinAppId> optional, PhotoItem photoItem, List<Long> list, String str2, long j, String str3, String str4, String str5, String str6, String str7, boolean z, GraphQLPrivacyOption graphQLPrivacyOption, List<Long> list2) {
        return new PlaceCreationParams(str, location, optional, photoItem, list, str2, j, str3, str4, str5, str6, str7, z, graphQLPrivacyOption, list2);
    }

    public static GraphQLPrivacyOption m22328b() {
        GraphQLPrivacyOptionBuilder graphQLPrivacyOptionBuilder = new GraphQLPrivacyOptionBuilder();
        graphQLPrivacyOptionBuilder.c("{\"value\":\"EVERYONE\"}");
        return graphQLPrivacyOptionBuilder.b();
    }

    private static ImmutableList<Long> m22327a(Parcel parcel) {
        return ImmutableList.copyOf(parcel.readArrayList(Long.class.getClassLoader()));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18371a);
        parcel.writeParcelable(this.f18385o, i);
        parcel.writeParcelable(this.f18384n, i);
        parcel.writeList(this.f18373c);
        parcel.writeString(this.f18374d);
        parcel.writeLong(this.f18375e);
        parcel.writeString(this.f18376f);
        parcel.writeString(this.f18377g);
        parcel.writeString(this.f18378h);
        parcel.writeString(this.f18379i);
        parcel.writeString(this.f18380j);
        parcel.writeByte((byte) (this.f18381k ? 1 : 0));
        FlatBufferModelHelper.a(parcel, this.f18382l);
        parcel.writeList(this.f18383m);
        parcel.writeParcelable((Parcelable) this.f18372b.orNull(), i);
    }

    public int describeContents() {
        return 0;
    }

    public PlaceCreationParams(Parcel parcel) {
        this.f18371a = parcel.readString();
        this.f18385o = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f18384n = (PhotoItem) parcel.readParcelable(PhotoItem.class.getClassLoader());
        this.f18373c = m22327a(parcel);
        this.f18374d = parcel.readString();
        this.f18375e = parcel.readLong();
        this.f18376f = parcel.readString();
        this.f18377g = parcel.readString();
        this.f18378h = parcel.readString();
        this.f18379i = parcel.readString();
        this.f18380j = parcel.readString();
        this.f18381k = parcel.readByte() != (byte) 0;
        this.f18382l = (GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel);
        this.f18383m = m22327a(parcel);
        this.f18372b = Optional.fromNullable(parcel.readParcelable(PlacePinAppId.class.getClassLoader()));
    }
}
