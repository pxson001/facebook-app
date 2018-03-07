package com.facebook.widget.tokenizedtypeahead.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: com.facebook.platform.protocol.RESULT_ARGS */
public class SimpleUserToken extends BaseToken<UserKey> implements Parcelable {
    public static final Creator CREATOR = new C15111();
    public final Name f20123e;
    private final String f20124f;
    public final UserKey f20125g;
    private boolean f20126h;
    public boolean f20127i;

    /* compiled from: com.facebook.platform.protocol.RESULT_ARGS */
    final class C15111 implements Creator {
        C15111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimpleUserToken(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimpleUserToken[i];
        }
    }

    public SimpleUserToken(User user) {
        super(Type.USER);
        this.f20127i = true;
        this.f20123e = user.e;
        this.f20124f = user.x();
        this.f20125g = user.T;
        this.f20126h = true;
    }

    public SimpleUserToken(Name name, String str, UserKey userKey) {
        super(Type.USER);
        this.f20127i = true;
        this.f20123e = name;
        this.f20124f = str;
        this.f20125g = userKey;
        this.f20126h = true;
    }

    public SimpleUserToken(Name name, String str, UserKey userKey, boolean z, boolean z2) {
        super(Type.USER);
        this.f20127i = true;
        this.f20123e = name;
        this.f20124f = str;
        this.f20125g = userKey;
        this.f20127i = z;
        this.f20126h = z2;
    }

    public SimpleUserToken(SimpleUserToken simpleUserToken) {
        this(simpleUserToken.f20123e, simpleUserToken.f20124f, simpleUserToken.f20125g);
    }

    protected SimpleUserToken(Parcel parcel) {
        this((Name) parcel.readValue(Name.class.getClassLoader()), parcel.readString(), (UserKey) parcel.readValue(UserKey.class.getClassLoader()), parcel.readString().equals("true"), parcel.readString().equals("true"));
    }

    public String mo1185b() {
        return this.f20123e.i();
    }

    public final int mo1187e() {
        return -1;
    }

    public final int mo1190h() {
        return -1;
    }

    public final int mo1188f() {
        return -1;
    }

    public final int mo1189g() {
        return -1;
    }

    public final String mo1191i() {
        return this.f20124f;
    }

    public final /* synthetic */ Object mo1186d() {
        return this.f20125g;
    }

    public final UserKey m28784o() {
        return this.f20125g;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f20125g});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SimpleUserToken) {
            return this.f20125g.equals(((SimpleUserToken) obj).f20125g);
        }
        return false;
    }

    public final boolean mo1524k() {
        return this.f20126h;
    }

    public boolean mo1195a() {
        return this.f20127i;
    }

    public final String m28785p() {
        return this.f20125g.b();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f20123e);
        parcel.writeString(this.f20124f);
        parcel.writeValue(this.f20125g);
        parcel.writeString(String.valueOf(this.f20127i));
        parcel.writeString(String.valueOf(this.f20126h));
    }
}
