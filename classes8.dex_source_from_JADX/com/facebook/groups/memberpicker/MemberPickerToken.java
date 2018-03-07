package com.facebook.groups.memberpicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;

/* compiled from: expiration_date_digits */
public class MemberPickerToken extends SimpleUserToken {
    public static final Creator<MemberPickerToken> CREATOR = new C15961();
    private String f14602e;
    public boolean f14603f;

    /* compiled from: expiration_date_digits */
    final class C15961 implements Creator<MemberPickerToken> {
        C15961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MemberPickerToken(parcel);
        }

        public final Object[] newArray(int i) {
            return new MemberPickerToken[i];
        }
    }

    public MemberPickerToken(Parcel parcel) {
        super((Name) parcel.readParcelable(Name.class.getClassLoader()), parcel.readString(), (UserKey) parcel.readParcelable(UserKey.class.getClassLoader()));
        this.f14602e = parcel.readString();
        this.f14603f = parcel.readInt() == 1;
    }

    public MemberPickerToken(SimpleUserToken simpleUserToken, String str) {
        super(simpleUserToken);
        this.f14602e = str;
        this.f14603f = false;
    }

    public final boolean m16487m() {
        return true;
    }

    public final String m16486l() {
        return this.f14602e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.e, i);
        parcel.writeString(i());
        parcel.writeParcelable(this.g, i);
        parcel.writeString(this.f14602e);
        parcel.writeInt(this.f14603f ? 1 : 0);
    }

    public MemberPickerToken(User user) {
        super(user.e, user.x(), user.T);
        this.f14602e = user.q;
        this.f14603f = false;
    }

    public MemberPickerToken(User user, boolean z) {
        super(user.e, user.x(), user.T);
        this.f14602e = user.q;
        this.f14603f = z;
    }
}
