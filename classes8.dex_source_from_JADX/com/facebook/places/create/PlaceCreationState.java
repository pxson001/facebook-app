package com.facebook.places.create;

import android.location.Location;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.ipc.model.PageTopic;
import com.facebook.places.create.network.PlacePinAppId;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: category_browser */
public class PlaceCreationState implements Parcelable {
    public static final Creator<PlaceCreationState> CREATOR = new C19831();
    public final String f18244a;
    public final PageTopic f18245b;
    public final Location f18246c;
    public final String f18247d;
    public final CheckinPlaceModel f18248e;
    public final String f18249f;
    public final boolean f18250g;
    public final Optional<Uri> f18251h;
    public final Optional<PlacePinAppId> f18252i;

    /* compiled from: category_browser */
    final class C19831 implements Creator<PlaceCreationState> {
        C19831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlaceCreationState(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlaceCreationState[i];
        }
    }

    /* compiled from: category_browser */
    public class Builder {
        public String f18235a;
        public PageTopic f18236b;
        public Location f18237c;
        public String f18238d = "";
        public CheckinPlaceModel f18239e;
        public String f18240f;
        public boolean f18241g;
        public Optional<Uri> f18242h;
        public Optional<PlacePinAppId> f18243i;

        public Builder(String str, PageTopic pageTopic, Location location, Optional<PlacePinAppId> optional, CheckinPlaceModel checkinPlaceModel) {
            this.f18235a = str;
            this.f18236b = pageTopic;
            this.f18237c = location;
            this.f18243i = optional;
            this.f18239e = checkinPlaceModel;
            this.f18240f = "";
            this.f18241g = false;
            this.f18242h = Absent.INSTANCE;
        }

        public final Builder m22183a(CheckinPlaceModel checkinPlaceModel) {
            this.f18239e = CheckinPlaceModel.a(checkinPlaceModel);
            return this;
        }

        public final PlaceCreationState m22184a() {
            return new PlaceCreationState(this);
        }
    }

    public PlaceCreationState(Builder builder) {
        this.f18244a = builder.f18235a;
        this.f18245b = builder.f18236b;
        this.f18246c = builder.f18237c;
        this.f18247d = builder.f18238d;
        this.f18248e = builder.f18239e;
        this.f18249f = builder.f18240f;
        this.f18250g = builder.f18241g;
        this.f18251h = builder.f18242h;
        this.f18252i = builder.f18243i;
    }

    public PlaceCreationState(Parcel parcel) {
        this.f18244a = parcel.readString();
        this.f18245b = (PageTopic) parcel.readParcelable(PageTopic.class.getClassLoader());
        this.f18246c = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f18247d = parcel.readString();
        this.f18248e = (CheckinPlaceModel) FlatBufferModelHelper.a(parcel);
        this.f18249f = parcel.readString();
        this.f18250g = parcel.readByte() != (byte) 0;
        this.f18251h = Optional.fromNullable(parcel.readParcelable(Uri.class.getClassLoader()));
        this.f18252i = Optional.fromNullable(parcel.readParcelable(PlacePinAppId.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18244a);
        parcel.writeParcelable(this.f18245b, i);
        parcel.writeParcelable(this.f18246c, i);
        parcel.writeString(this.f18247d);
        FlatBufferModelHelper.a(parcel, this.f18248e);
        parcel.writeString(this.f18249f);
        parcel.writeByte(this.f18250g ? (byte) 1 : (byte) 0);
        parcel.writeParcelable((Parcelable) this.f18251h.orNull(), i);
        parcel.writeParcelable((Parcelable) this.f18252i.orNull(), i);
    }
}
