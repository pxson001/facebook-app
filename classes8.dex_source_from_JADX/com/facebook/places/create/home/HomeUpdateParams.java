package com.facebook.places.create.home;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.photos.base.media.PhotoItem;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: card_form_params */
public class HomeUpdateParams implements Parcelable {
    public static final Creator<HomeUpdateParams> CREATOR = new C20061();
    public final long f18346a;
    public final String f18347b;
    public final GraphQLPrivacyOption f18348c;
    public final String f18349d;
    public final String f18350e;
    public final String f18351f;
    public final long f18352g;
    public final PhotoItem f18353h;
    public final boolean f18354i;

    /* compiled from: card_form_params */
    final class C20061 implements Creator<HomeUpdateParams> {
        C20061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new HomeUpdateParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new HomeUpdateParams[i];
        }
    }

    public HomeUpdateParams(HomeActivityModel homeActivityModel) {
        this.f18346a = homeActivityModel.f18319l;
        this.f18347b = homeActivityModel.f18308a;
        this.f18348c = homeActivityModel.f18314g;
        this.f18349d = homeActivityModel.f18311d;
        this.f18350e = homeActivityModel.f18310c;
        this.f18351f = homeActivityModel.f18309b;
        this.f18352g = homeActivityModel.f18312e;
        this.f18353h = homeActivityModel.f18315h;
        this.f18354i = homeActivityModel.f18317j;
    }

    protected HomeUpdateParams(Parcel parcel) {
        this.f18346a = parcel.readLong();
        this.f18347b = parcel.readString();
        this.f18348c = (GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel);
        this.f18349d = parcel.readString();
        this.f18350e = parcel.readString();
        this.f18351f = parcel.readString();
        this.f18352g = parcel.readLong();
        this.f18353h = (PhotoItem) parcel.readValue(PhotoItem.class.getClassLoader());
        this.f18354i = parcel.readByte() != (byte) 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f18346a);
        parcel.writeString(this.f18347b);
        FlatBufferModelHelper.a(parcel, this.f18348c);
        parcel.writeString(this.f18349d);
        parcel.writeString(this.f18350e);
        parcel.writeString(this.f18351f);
        parcel.writeLong(this.f18352g);
        parcel.writeParcelable(this.f18353h, i);
        parcel.writeByte((byte) (this.f18354i ? 1 : 0));
    }
}
