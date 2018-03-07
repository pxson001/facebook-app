package com.facebook.platform.opengraph.server;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.FbObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

/* compiled from: field_edited */
public class PublishOpenGraphActionOperation$Params implements Parcelable {
    public static final Creator<PublishOpenGraphActionOperation$Params> CREATOR = new C09821();
    public final String f14921a;
    public final ObjectNode f14922b;
    public final String f14923c;

    /* compiled from: field_edited */
    final class C09821 implements Creator<PublishOpenGraphActionOperation$Params> {
        C09821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return new PublishOpenGraphActionOperation$Params(parcel);
            } catch (IOException e) {
                return null;
            }
        }

        public final Object[] newArray(int i) {
            return new PublishOpenGraphActionOperation$Params[i];
        }
    }

    @SuppressLint({"BadMethodUse-<init>"})
    public PublishOpenGraphActionOperation$Params(String str, ObjectNode objectNode) {
        this(str, objectNode, null);
    }

    private PublishOpenGraphActionOperation$Params(String str, ObjectNode objectNode, String str2) {
        this.f14921a = str;
        this.f14922b = objectNode;
        this.f14923c = str2;
    }

    public PublishOpenGraphActionOperation$Params(Parcel parcel) {
        this.f14921a = parcel.readString();
        this.f14922b = (ObjectNode) FbObjectMapper.i().a(parcel.readString());
        this.f14923c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14921a);
        parcel.writeString(this.f14922b.toString());
        parcel.writeString(this.f14923c);
    }
}
