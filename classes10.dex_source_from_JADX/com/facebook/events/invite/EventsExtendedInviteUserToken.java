package com.facebook.events.invite;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.user.model.Name;
import com.facebook.user.model.UserKey;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;

/* compiled from: checkout_item */
public class EventsExtendedInviteUserToken extends SimpleUserToken implements Parcelable {
    public static final Creator<EventsExtendedInviteUserToken> CREATOR = new C25111();
    private String f17689e;

    /* compiled from: checkout_item */
    final class C25111 implements Creator<EventsExtendedInviteUserToken> {
        C25111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventsExtendedInviteUserToken(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventsExtendedInviteUserToken[i];
        }
    }

    public EventsExtendedInviteUserToken(UserKey userKey, Name name, String str, String str2, boolean z) {
        super(name, str2, userKey, !z, true);
        this.f17689e = str;
    }

    protected EventsExtendedInviteUserToken(Parcel parcel) {
        super(parcel);
        this.f17689e = parcel.readString();
    }

    public final String m18015l() {
        return this.f17689e;
    }

    public final boolean m18016m() {
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f17689e);
    }
}
