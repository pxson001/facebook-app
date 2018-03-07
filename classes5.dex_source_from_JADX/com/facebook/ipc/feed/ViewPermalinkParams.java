package com.facebook.ipc.feed;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.ipc.intent.FacebookOnlyIntentParams;
import com.google.common.base.Preconditions;

/* compiled from: TICKER */
public class ViewPermalinkParams implements FacebookOnlyIntentParams {
    public static final Creator<ViewPermalinkParams> CREATOR = new C13451();
    private static final Class<?> f14066a = ViewPermalinkParams.class;
    private final FeedUnit f14067b;
    public boolean f14068c = false;
    private boolean f14069d = false;

    /* compiled from: TICKER */
    final class C13451 implements Creator<ViewPermalinkParams> {
        C13451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ViewPermalinkParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ViewPermalinkParams[i];
        }
    }

    public ViewPermalinkParams(FeedUnit feedUnit) {
        this.f14067b = (FeedUnit) Preconditions.checkNotNull(feedUnit);
    }

    public ViewPermalinkParams(Parcel parcel) {
        this.f14067b = (FeedUnit) FlatBufferModelHelper.m4278a(parcel);
    }

    public final FeedUnit m23436a() {
        return this.f14067b;
    }

    public final boolean m23437b() {
        return this.f14068c;
    }

    public final boolean m23438d() {
        return this.f14069d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.m4288a(parcel, this.f14067b);
    }
}
