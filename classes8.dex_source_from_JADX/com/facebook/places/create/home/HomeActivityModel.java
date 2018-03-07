package com.facebook.places.create.home;

import android.location.Location;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.photos.base.media.PhotoItem;
import com.google.common.base.Preconditions;

/* compiled from: card_issuer */
public class HomeActivityModel implements Parcelable {
    public static final Creator<HomeActivityModel> CREATOR = new C19951();
    public String f18308a;
    public String f18309b;
    public String f18310c;
    public String f18311d;
    public long f18312e;
    public Location f18313f;
    public GraphQLPrivacyOption f18314g;
    public PhotoItem f18315h;
    public Uri f18316i;
    public boolean f18317j;
    public HomeActivityMode f18318k;
    public long f18319l;

    /* compiled from: card_issuer */
    final class C19951 implements Creator<HomeActivityModel> {
        C19951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new HomeActivityModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new HomeActivityModel[i];
        }
    }

    public HomeActivityModel(HomeActivityMode homeActivityMode) {
        Preconditions.checkArgument(homeActivityMode != HomeActivityMode.INVALID);
        this.f18308a = null;
        this.f18313f = null;
        this.f18314g = null;
        this.f18309b = null;
        this.f18312e = 0;
        this.f18310c = null;
        this.f18311d = null;
        this.f18315h = null;
        this.f18316i = null;
        this.f18317j = false;
        this.f18318k = homeActivityMode;
        this.f18319l = 0;
    }

    protected HomeActivityModel(Parcel parcel) {
        this.f18308a = parcel.readString();
        this.f18313f = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f18314g = (GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel);
        this.f18309b = parcel.readString();
        this.f18312e = parcel.readLong();
        this.f18310c = parcel.readString();
        this.f18311d = parcel.readString();
        this.f18315h = (PhotoItem) parcel.readValue(PhotoItem.class.getClassLoader());
        this.f18316i = (Uri) parcel.readValue(Uri.class.getClassLoader());
        this.f18317j = parcel.readByte() != (byte) 0;
        this.f18318k = HomeActivityMode.values()[parcel.readInt()];
        this.f18319l = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18308a);
        parcel.writeParcelable(this.f18313f, i);
        FlatBufferModelHelper.a(parcel, this.f18314g);
        parcel.writeString(this.f18309b);
        parcel.writeLong(this.f18312e);
        parcel.writeString(this.f18310c);
        parcel.writeString(this.f18311d);
        parcel.writeValue(this.f18315h);
        parcel.writeValue(this.f18316i);
        parcel.writeByte((byte) (this.f18317j ? 1 : 0));
        parcel.writeInt(this.f18318k.ordinal());
        parcel.writeLong(this.f18319l);
    }
}
