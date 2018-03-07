package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: contact_logs_upload_succeeded */
public class SearchThreadNameAndParticipantsParams implements Parcelable {
    public static final Creator<SearchThreadNameAndParticipantsParams> CREATOR = new C20531();
    public final int f17288a;
    public final String f17289b;
    public final boolean f17290c;

    /* compiled from: contact_logs_upload_succeeded */
    final class C20531 implements Creator<SearchThreadNameAndParticipantsParams> {
        C20531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchThreadNameAndParticipantsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SearchThreadNameAndParticipantsParams[i];
        }
    }

    SearchThreadNameAndParticipantsParams(SearchThreadNameAndParticipantsParamsBuilder searchThreadNameAndParticipantsParamsBuilder) {
        this.f17288a = searchThreadNameAndParticipantsParamsBuilder.f17291a;
        this.f17289b = searchThreadNameAndParticipantsParamsBuilder.f17292b;
        this.f17290c = searchThreadNameAndParticipantsParamsBuilder.f17293c;
    }

    public static SearchThreadNameAndParticipantsParamsBuilder newBuilder() {
        return new SearchThreadNameAndParticipantsParamsBuilder();
    }

    public SearchThreadNameAndParticipantsParams(Parcel parcel) {
        this.f17288a = parcel.readInt();
        this.f17289b = parcel.readString();
        this.f17290c = ParcelUtil.a(parcel);
    }

    public final boolean m17167c() {
        return this.f17290c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f17288a);
        parcel.writeString(this.f17289b);
        ParcelUtil.a(parcel, this.f17290c);
    }
}
