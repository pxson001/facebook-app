package com.facebook.events.ui.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;

/* compiled from: applicationContext */
public class EventLocationModel implements Parcelable {
    public static final Creator<EventLocationModel> CREATOR = new C27691();
    public CheckinPlaceModel f19461a;
    public long f19462b;
    public String f19463c;

    /* compiled from: applicationContext */
    final class C27691 implements Creator<EventLocationModel> {
        C27691() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventLocationModel((CheckinPlaceModel) FlatBufferModelHelper.a(parcel), parcel.readLong(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new EventLocationModel[i];
        }
    }

    public EventLocationModel() {
        this.f19461a = null;
        this.f19462b = -1;
        this.f19463c = null;
    }

    public EventLocationModel(CheckinPlaceModel checkinPlaceModel, long j, String str) {
        this.f19461a = checkinPlaceModel;
        this.f19462b = j;
        this.f19463c = str;
    }

    public EventLocationModel(Intent intent) {
        m19634a(intent);
    }

    public final void m19634a(Intent intent) {
        if (!intent.getBooleanExtra("extra_xed_location", false)) {
            if (intent.hasExtra("extra_place")) {
                this.f19461a = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
                this.f19462b = this.f19461a == null ? -1 : Long.parseLong(this.f19461a.cf_());
                this.f19463c = null;
                return;
            } else if (intent.hasExtra("extra_location_text")) {
                this.f19461a = null;
                this.f19462b = -1;
                this.f19463c = intent.getStringExtra("extra_location_text");
                return;
            }
        }
        this.f19461a = null;
        this.f19462b = -1;
        this.f19463c = null;
    }

    public final CheckinPlaceModel m19633a() {
        return this.f19461a;
    }

    public final String m19635c() {
        return this.f19463c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, CheckinPlaceModel.a(this.f19461a));
        parcel.writeLong(this.f19462b);
        parcel.writeString(this.f19463c);
    }
}
