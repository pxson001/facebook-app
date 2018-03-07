package com.facebook.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.user.gender.Gender;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@DoNotStrip
@Immutable
/* compiled from: t_mf_as */
public class User implements Parcelable {
    public static final Creator<User> CREATOR = new C02081();
    public final boolean f3573A;
    public final int f3574B;
    public final int f3575C;
    public final int f3576D;
    public final boolean f3577E;
    public final boolean f3578F;
    public final TriState f3579G;
    public final boolean f3580H;
    public final boolean f3581I;
    public final boolean f3582J;
    public final boolean f3583K;
    public long f3584L;
    public final long f3585M;
    public final boolean f3586N;
    public final boolean f3587O;
    public final float f3588P;
    @Nullable
    public final ImmutableList<CallToAction> f3589Q;
    public final boolean f3590R;
    public final boolean f3591S;
    public final UserKey f3592T = new UserKey(this.f3599b, this.f3598a);
    public final UserIdentifier f3593U;
    private ImmutableList<UserPhoneNumber> f3594V;
    private String f3595W;
    private PicSquare f3596X;
    private String f3597Y;
    public final String f3598a;
    public final Type f3599b;
    public final ImmutableList<UserEmailAddress> f3600c;
    public final ImmutableList<UserCustomTag> f3601d;
    public final Name f3602e;
    private final Name f3603f;
    public final String f3604g;
    public final Gender f3605h;
    private final String f3606i;
    public final String f3607j;
    public final String f3608k;
    public final String f3609l;
    public final float f3610m;
    public final TriState f3611n;
    public final boolean f3612o;
    public final boolean f3613p;
    public final String f3614q;
    public final String f3615r;
    @Nullable
    public final String f3616s;
    public final boolean f3617t;
    public final boolean f3618u;
    @Nullable
    public final CommercePageType f3619v;
    @Nullable
    public final ImmutableList<CommercePageSetting> f3620w;
    public final long f3621x;
    public final long f3622y;
    public final boolean f3623z;

    /* compiled from: t_mf_as */
    public enum Type {
        FACEBOOK,
        ADDRESS_BOOK,
        PHONE_NUMBER,
        FACEBOOK_OBJECT,
        EMAIL,
        FACEBOOK_CONTACT;

        public final boolean isPhoneContact() {
            return this == ADDRESS_BOOK || this == PHONE_NUMBER;
        }
    }

    /* compiled from: t_mf_as */
    final class C02081 implements Creator<User> {
        C02081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        public final Object[] newArray(int i) {
            return new User[i];
        }
    }

    User(UserBuilder userBuilder) {
        Name name;
        this.f3598a = (String) Preconditions.checkNotNull(userBuilder.f3545b, "id must not be null");
        this.f3599b = (Type) Preconditions.checkNotNull(userBuilder.f3544a, "type must not be null");
        if (userBuilder.f3546c == null) {
            this.f3600c = RegularImmutableList.f535a;
        } else {
            this.f3600c = ImmutableList.copyOf((Collection) userBuilder.f3546c);
        }
        if (userBuilder.f3548e == null) {
            this.f3601d = RegularImmutableList.f535a;
        } else {
            this.f3601d = ImmutableList.copyOf((Collection) userBuilder.f3548e);
        }
        if (userBuilder.f3547d == null) {
            this.f3594V = RegularImmutableList.f535a;
        } else {
            this.f3594V = ImmutableList.copyOf((Collection) userBuilder.f3547d);
        }
        if (userBuilder.f3550g != null) {
            name = userBuilder.f3550g;
        } else {
            name = new Name(userBuilder.f3552i, userBuilder.f3553j, userBuilder.f3551h);
        }
        this.f3602e = name;
        this.f3603f = userBuilder.f3554k;
        this.f3604g = userBuilder.f3555l;
        this.f3605h = userBuilder.f3556m;
        this.f3606i = userBuilder.f3557n;
        this.f3607j = userBuilder.f3558o;
        this.f3596X = userBuilder.f3559p;
        this.f3608k = userBuilder.f3561r;
        this.f3609l = userBuilder.f3562s;
        this.f3610m = userBuilder.f3563t;
        this.f3611n = userBuilder.f3564u;
        this.f3612o = userBuilder.f3565v;
        this.f3613p = userBuilder.f3566w;
        this.f3614q = userBuilder.f3567x;
        this.f3615r = userBuilder.f3568y;
        this.f3616s = userBuilder.f3569z;
        this.f3617t = userBuilder.f3518A;
        this.f3618u = userBuilder.f3519B;
        this.f3619v = userBuilder.f3520C;
        this.f3620w = userBuilder.f3521D;
        this.f3621x = userBuilder.f3522E;
        this.f3622y = userBuilder.f3523F;
        this.f3623z = userBuilder.f3524G;
        this.f3573A = userBuilder.f3525H;
        this.f3593U = ap();
        this.f3574B = userBuilder.f3526I;
        this.f3575C = userBuilder.f3527J;
        this.f3576D = userBuilder.f3528K;
        this.f3577E = userBuilder.f3529L;
        this.f3578F = userBuilder.f3530M;
        this.f3579G = userBuilder.f3531N;
        this.f3580H = userBuilder.f3532O;
        this.f3581I = userBuilder.f3533P;
        this.f3582J = userBuilder.f3534Q;
        this.f3583K = userBuilder.f3540W;
        this.f3584L = userBuilder.f3541X;
        this.f3585M = userBuilder.f3542Y;
        this.f3586N = userBuilder.f3543Z;
        this.f3587O = userBuilder.f3535R;
        this.f3595W = userBuilder.f3549f;
        this.f3597Y = userBuilder.f3560q;
        this.f3588P = userBuilder.f3536S;
        this.f3589Q = userBuilder.f3537T;
        this.f3590R = userBuilder.f3538U;
        this.f3591S = userBuilder.f3539V;
    }

    public User(Parcel parcel) {
        boolean z;
        ImmutableList immutableList = null;
        boolean z2 = true;
        this.f3598a = parcel.readString();
        this.f3599b = Type.valueOf(parcel.readString());
        this.f3600c = ImmutableList.copyOf(parcel.readArrayList(UserEmailAddress.class.getClassLoader()));
        this.f3601d = ImmutableList.copyOf(parcel.readArrayList(UserCustomTag.class.getClassLoader()));
        this.f3594V = ImmutableList.copyOf(parcel.readArrayList(UserPhoneNumber.class.getClassLoader()));
        this.f3602e = (Name) parcel.readParcelable(Name.class.getClassLoader());
        this.f3603f = (Name) parcel.readParcelable(Name.class.getClassLoader());
        this.f3604g = parcel.readString();
        this.f3605h = Gender.valueOf(parcel.readString());
        this.f3606i = parcel.readString();
        this.f3607j = parcel.readString();
        this.f3596X = (PicSquare) parcel.readParcelable(PicSquare.class.getClassLoader());
        this.f3608k = parcel.readString();
        this.f3609l = parcel.readString();
        this.f3610m = parcel.readFloat();
        this.f3611n = TriState.valueOf(parcel.readString());
        this.f3612o = parcel.readInt() != 0;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3613p = z;
        this.f3614q = parcel.readString();
        this.f3615r = parcel.readString();
        this.f3616s = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3617t = z;
        this.f3621x = parcel.readLong();
        this.f3622y = parcel.readLong();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3623z = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3573A = z;
        this.f3574B = parcel.readInt();
        this.f3575C = parcel.readInt();
        this.f3576D = parcel.readInt();
        this.f3593U = ap();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3577E = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3578F = z;
        this.f3579G = TriState.fromDbValue(parcel.readInt());
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3618u = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3580H = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3581I = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3582J = z;
        this.f3619v = m5818a(parcel.readString());
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3583K = z;
        Collection readArrayList = parcel.readArrayList(CommercePageSetting.class.getClassLoader());
        this.f3620w = readArrayList == null ? null : ImmutableList.copyOf(readArrayList);
        this.f3584L = parcel.readLong();
        this.f3585M = parcel.readLong();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3586N = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3587O = z;
        this.f3595W = parcel.readString();
        this.f3597Y = parcel.readString();
        this.f3588P = parcel.readFloat();
        readArrayList = parcel.readArrayList(CallToAction.class.getClassLoader());
        if (readArrayList != null) {
            immutableList = ImmutableList.copyOf(readArrayList);
        }
        this.f3589Q = immutableList;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3590R = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f3591S = z2;
    }

    private UserIdentifier ap() {
        if (this.f3599b == Type.FACEBOOK) {
            return new UserFbidIdentifier(this.f3598a);
        }
        if (!this.f3599b.isPhoneContact()) {
            return null;
        }
        UserPhoneNumber w = m5855w();
        if (w != null) {
            return new UserSmsIdentifier(w.c, w.b);
        }
        return null;
    }

    public final boolean m5839b() {
        return this.f3592T.m5870e();
    }

    public final String m5840d() {
        return this.f3598a;
    }

    public final UserKey m5841e() {
        return this.f3592T;
    }

    public final Name m5842f() {
        return this.f3602e;
    }

    public final String m5843h() {
        return this.f3602e.m5808a();
    }

    public final String m5844i() {
        return this.f3602e.m5810c();
    }

    public final String m5845j() {
        return this.f3602e.m5814g();
    }

    public final String m5846k() {
        return this.f3602e.m5816i();
    }

    public final String m5847l() {
        return this.f3604g;
    }

    public final UserFbidIdentifier m5848n() {
        if (this.f3593U instanceof UserFbidIdentifier) {
            return (UserFbidIdentifier) this.f3593U;
        }
        return null;
    }

    public final ImmutableList<UserEmailAddress> m5849p() {
        return this.f3600c;
    }

    public final ImmutableList<UserCustomTag> m5850q() {
        return this.f3601d;
    }

    public final ImmutableList<UserPhoneNumber> m5851r() {
        if (this.f3594V == null || this.f3594V.isEmpty()) {
            ImmutableList ar = ar();
            if (ar != null) {
                this.f3594V = ar;
            }
        }
        if (this.f3594V == null) {
            this.f3594V = RegularImmutableList.f535a;
        }
        return this.f3594V;
    }

    public final String m5852s() {
        if (this.f3595W == null) {
            this.f3595W = aq();
        }
        return this.f3595W;
    }

    public final String m5853u() {
        return this.f3600c.isEmpty() ? null : ((UserEmailAddress) this.f3600c.get(0)).f3571a;
    }

    public final boolean m5854v() {
        return !this.f3594V.isEmpty();
    }

    public final UserPhoneNumber m5855w() {
        return this.f3594V.isEmpty() ? null : (UserPhoneNumber) this.f3594V.get(0);
    }

    public final String m5856x() {
        if (this.f3606i != null) {
            return this.f3606i;
        }
        if (this.f3596X != null) {
            return ((PicSquareUrlWithSize) this.f3596X.a().get(0)).url;
        }
        return null;
    }

    public final String m5857y() {
        return this.f3607j;
    }

    public final PicSquare m5858z() {
        if (this.f3596X == null) {
            this.f3596X = at();
        }
        return this.f3596X;
    }

    public final String m5819A() {
        if (this.f3597Y == null) {
            this.f3597Y = as();
        }
        return this.f3597Y;
    }

    public final String m5820C() {
        return this.f3609l;
    }

    public final float m5821D() {
        return this.f3610m;
    }

    public final TriState m5822E() {
        return this.f3611n;
    }

    public final boolean m5823F() {
        return this.f3612o;
    }

    public final boolean m5824G() {
        return this.f3613p;
    }

    @Nullable
    public final String m5825J() {
        return this.f3616s;
    }

    public final boolean m5826K() {
        return this.f3580H;
    }

    public final boolean m5827L() {
        return this.f3581I;
    }

    public final boolean m5828M() {
        return this.f3582J;
    }

    public final boolean m5829N() {
        return this.f3583K;
    }

    public final boolean m5830O() {
        return this.f3617t;
    }

    public final boolean m5831P() {
        return this.f3618u;
    }

    @Nullable
    public final CommercePageType m5832Q() {
        return this.f3619v;
    }

    @Nullable
    public final ImmutableList<CommercePageSetting> m5833R() {
        return this.f3620w;
    }

    public final long m5834S() {
        return this.f3584L;
    }

    public final boolean m5835T() {
        return "page".equals(this.f3616s);
    }

    public final boolean m5836U() {
        return "user".equals(this.f3616s);
    }

    public final boolean m5837Y() {
        return this.f3623z;
    }

    public final boolean m5838Z() {
        return this.f3573A;
    }

    public final int aa() {
        return this.f3574B;
    }

    public final int ab() {
        return this.f3575C;
    }

    public final int ac() {
        return this.f3576D;
    }

    public final boolean ad() {
        return this.f3577E;
    }

    public final boolean ae() {
        return this.f3578F;
    }

    public final TriState af() {
        return this.f3579G;
    }

    public final long ag() {
        return this.f3585M;
    }

    public final boolean ah() {
        return this.f3586N;
    }

    public final boolean ai() {
        return this.f3587O;
    }

    @Nullable
    public final ImmutableList<CallToAction> ak() {
        return this.f3589Q;
    }

    public final boolean al() {
        return this.f3590R;
    }

    public final boolean am() {
        return this.f3591S;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f3598a);
        parcel.writeString(this.f3599b.name());
        parcel.writeList(this.f3600c);
        parcel.writeList(this.f3601d);
        parcel.writeList(this.f3594V);
        parcel.writeParcelable(this.f3602e, i);
        parcel.writeParcelable(this.f3603f, i);
        parcel.writeString(this.f3604g);
        parcel.writeString(this.f3605h.name());
        parcel.writeString(this.f3606i);
        parcel.writeString(this.f3607j);
        parcel.writeParcelable(this.f3596X, i);
        parcel.writeString(this.f3608k);
        parcel.writeString(this.f3609l);
        parcel.writeFloat(this.f3610m);
        parcel.writeString(this.f3611n.name());
        parcel.writeInt(this.f3612o ? 1 : 0);
        if (this.f3613p) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f3614q);
        parcel.writeString(this.f3615r);
        parcel.writeString(this.f3616s);
        if (this.f3617t) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeLong(this.f3621x);
        parcel.writeLong(this.f3622y);
        if (this.f3623z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f3573A) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.f3574B);
        parcel.writeInt(this.f3575C);
        parcel.writeInt(this.f3576D);
        if (this.f3577E) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f3578F) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.f3579G.getDbValue());
        if (this.f3618u) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f3580H) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f3581I) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f3582J) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f3619v == null ? null : this.f3619v.name());
        if (this.f3583K) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeList(this.f3620w);
        parcel.writeLong(this.f3584L);
        parcel.writeLong(this.f3585M);
        if (this.f3586N) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f3587O) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f3595W);
        parcel.writeString(this.f3597Y);
        parcel.writeFloat(this.f3588P);
        parcel.writeList(this.f3589Q);
        if (this.f3590R) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f3591S) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f3602e).append(" ");
        stringBuilder.append(this.f3598a).append(" [").append(this.f3599b).append("] ");
        if (!this.f3600c.isEmpty()) {
            stringBuilder.append(this.f3600c.get(0)).append(" ");
        }
        if (!this.f3594V.isEmpty()) {
            stringBuilder.append(this.f3594V.get(0)).append(" ");
        }
        return stringBuilder.toString();
    }

    @Nullable
    private static CommercePageType m5818a(String str) {
        CommercePageType commercePageType = null;
        if (str != null) {
            try {
                commercePageType = CommercePageType.valueOf(str);
            } catch (IllegalArgumentException e) {
            }
        }
        return commercePageType;
    }

    @Nullable
    public final String an() {
        return this.f3592T.m5871f();
    }

    public final boolean ao() {
        return this.f3599b.isPhoneContact();
    }

    private String aq() {
        if (this.f3594V == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int size = this.f3594V.size();
        int i = 0;
        while (i < size) {
            UserPhoneNumber userPhoneNumber = (UserPhoneNumber) this.f3594V.get(i);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("phone_full_number", userPhoneNumber.b());
                jSONObject.put("phone_display_number", userPhoneNumber.a());
                if (userPhoneNumber.e() != TriState.UNSET) {
                    jSONObject.put("phone_is_verified", userPhoneNumber.e().asBoolean(false));
                }
                jSONObject.put("phone_android_type", userPhoneNumber.d());
                jSONArray.put(jSONObject);
                i++;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return jSONArray.toString();
    }

    @Nullable
    private ImmutableList<UserPhoneNumber> ar() {
        if (TextUtils.isEmpty(this.f3595W)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.f3595W);
            Builder builder = ImmutableList.builder();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("phone_full_number");
                builder.m1069c(new UserPhoneNumber(optJSONObject.optString("phone_display_number"), optString, optString, optJSONObject.optInt("phone_android_type"), optJSONObject.has("phone_is_verified") ? TriState.valueOf(optJSONObject.optBoolean("phone_is_verified")) : TriState.UNSET));
            }
            return builder.m1068b();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private String as() {
        if (this.f3596X == null) {
            return null;
        }
        ImmutableList a = this.f3596X.a();
        if (a == null || a.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            PicSquareUrlWithSize picSquareUrlWithSize = (PicSquareUrlWithSize) a.get(i);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("profile_pic_size", picSquareUrlWithSize.size);
                jSONObject.put("profile_pic_url", picSquareUrlWithSize.url);
                jSONArray.put(jSONObject);
            } catch (Throwable e) {
                BLog.b("User", "Profile square pic serialization", e);
            }
        }
        return jSONArray.toString();
    }

    private PicSquare at() {
        if (TextUtils.isEmpty(this.f3597Y)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.f3597Y);
            Builder builder = ImmutableList.builder();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                builder.m1069c(new PicSquareUrlWithSize(optJSONObject.optInt("profile_pic_size"), optJSONObject.optString("profile_pic_url")));
            }
            return new PicSquare(builder.m1068b());
        } catch (JSONException e) {
            return null;
        }
    }
}
