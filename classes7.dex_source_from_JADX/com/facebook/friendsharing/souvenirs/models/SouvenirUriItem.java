package com.facebook.friendsharing.souvenirs.models;

import android.os.Parcel;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.ipc.media.data.HasMediaData;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@Immutable
/* compiled from: RIGHT_HANDLE_MOVES */
public abstract class SouvenirUriItem implements SouvenirItem, HasMediaData {
    public final String m26186c() {
        return b().mId;
    }

    public String toString() {
        return hw_().toString();
    }

    protected SouvenirUriItem() {
    }

    public int describeContents() {
        return 0;
    }

    protected SouvenirUriItem(byte b) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
