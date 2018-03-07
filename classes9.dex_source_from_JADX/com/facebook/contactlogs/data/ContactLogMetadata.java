package com.facebook.contactlogs.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: profile_wizard_flow_type */
public class ContactLogMetadata implements Parcelable {
    public static final Creator<ContactLogMetadata> CREATOR = new C06381();
    private static final Class<?> f6133c = ContactLogMetadata.class;
    public final ContactLogType f6134a;
    public ObjectNode f6135b;

    /* compiled from: profile_wizard_flow_type */
    final class C06381 implements Creator<ContactLogMetadata> {
        C06381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContactLogMetadata(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContactLogMetadata[i];
        }
    }

    /* compiled from: profile_wizard_flow_type */
    public enum ContactLogType {
        CALL_LOG,
        MMS_LOG,
        SMS_LOG
    }

    public ContactLogMetadata(ObjectNode objectNode, ContactLogType contactLogType) {
        this.f6135b = (ObjectNode) Preconditions.checkNotNull(objectNode);
        this.f6134a = (ContactLogType) Preconditions.checkNotNull(contactLogType);
    }

    public ContactLogMetadata(Parcel parcel) {
        try {
            this.f6135b = (ObjectNode) ParcelUtil.i(parcel);
        } catch (Throwable e) {
            BLog.a(f6133c, "Could not read JSON from parcel", e);
            this.f6135b = new ObjectNode(JsonNodeFactory.a);
        }
        this.f6134a = (ContactLogType) ParcelUtil.c(parcel, ContactLogType.class);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6135b.toString());
        ParcelUtil.a(parcel, this.f6134a);
    }
}
