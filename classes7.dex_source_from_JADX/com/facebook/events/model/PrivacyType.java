package com.facebook.events.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.calls.EventEditInputData.EventVisibility;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: super_state */
public enum PrivacyType implements Parcelable {
    FRIENDS_OF_FRIENDS,
    FRIENDS_OF_GUESTS,
    GROUP,
    INVITE_ONLY,
    PAGE,
    USER_PUBLIC,
    COMMUNITY;
    
    public static final Creator<PrivacyType> CREATOR = null;
    public static List<PrivacyType> SELECTABLE_PRIVACY_TYPES;

    /* compiled from: super_state */
    final class C02381 implements Creator<PrivacyType> {
        C02381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return PrivacyType.valueOf(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new PrivacyType[i];
        }
    }

    static {
        SELECTABLE_PRIVACY_TYPES = Lists.a(new PrivacyType[]{INVITE_ONLY, FRIENDS_OF_GUESTS, USER_PUBLIC});
        CREATOR = new C02381();
    }

    public final String getContentValue() {
        return name();
    }

    public final int describeContents() {
        return 0;
    }

    public static EventVisibility getPrivacyTypeForEventEditInputData(PrivacyType privacyType) {
        switch (privacyType) {
            case FRIENDS_OF_FRIENDS:
                return EventVisibility.FRIENDS_OF_FRIENDS;
            case FRIENDS_OF_GUESTS:
                return EventVisibility.FRIENDS_OF_GUESTS;
            case INVITE_ONLY:
                return EventVisibility.INVITE_ONLY;
            case PAGE:
                return EventVisibility.PAGE;
            case USER_PUBLIC:
                return EventVisibility.USER_PUBLIC;
            case GROUP:
                return EventVisibility.GROUP;
            case COMMUNITY:
                return EventVisibility.COMMUNITY;
            default:
                throw new IllegalArgumentException("Type does not support setting: " + privacyType);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}
