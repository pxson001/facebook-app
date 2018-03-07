package com.facebook.events.invite;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.graphql.Contact;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;

/* compiled from: collection_count */
public class EventInviteeToken extends SimpleUserToken implements Parcelable {
    public static final Creator<EventInviteeToken> CREATOR = new C24731();
    private String f17495e;
    private final String f17496f;

    /* compiled from: collection_count */
    final class C24731 implements Creator<EventInviteeToken> {
        C24731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventInviteeToken(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventInviteeToken[i];
        }
    }

    public EventInviteeToken(Parcel parcel) {
        super((Name) parcel.readParcelable(Name.class.getClassLoader()), parcel.readString(), (UserKey) parcel.readParcelable(UserKey.class.getClassLoader()));
        this.f17495e = parcel.readString();
        this.f17496f = parcel.readString();
    }

    public EventInviteeToken(Contact contact, String str) {
        super(contact.e(), contact.g(), UserKey.b(contact.c()));
        this.f17495e = contact.H();
        this.f17496f = str;
    }

    public final String m17867l() {
        return this.f17495e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.e, i);
        parcel.writeString(i());
        parcel.writeParcelable(this.g, i);
        parcel.writeString(this.f17495e);
        parcel.writeString(this.f17496f);
    }

    public EventInviteeToken(User user) {
        super(user.e, user.x(), user.T);
        this.f17495e = user.q;
        this.f17496f = null;
    }
}
