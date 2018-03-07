package com.facebook.messaging.business.common.calltoaction.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringLocaleUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: defaultSignInAccount */
public class CallToAction implements Parcelable {
    public static final Creator<CallToAction> CREATOR = new C04911();
    @Nullable
    public final Uri f5177a;
    @Nullable
    public final Type f5178b;
    public final ImmutableList<String> f5179c;
    public boolean f5180d;
    private final String f5181e;
    public final String f5182f;

    /* compiled from: defaultSignInAccount */
    final class C04911 implements Creator<CallToAction> {
        C04911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CallToAction(parcel);
        }

        public final Object[] newArray(int i) {
            return new CallToAction[i];
        }
    }

    /* compiled from: defaultSignInAccount */
    public enum Type {
        OPEN_NATIVE("OPEN_NATIVE"),
        OPEN_URL("OPEN_URL"),
        OPEN_CANCEL_RIDE_MUTATION("OPEN_CANCEL_RIDE_MUTATION"),
        POSTBACK("POSTBACK"),
        ACCOUNT_LINK("ACCOUNT_LINK"),
        PIN_PROTECTION("PIN_PROTECTION");
        
        public final String dbValue;

        private Type(String str) {
            this.dbValue = str;
        }

        @Nullable
        public static Type fromDbValue(String str) {
            for (Type type : values()) {
                if (Objects.equal(type.dbValue, str)) {
                    return type;
                }
            }
            return null;
        }
    }

    public CallToAction(CallToActionBuilder callToActionBuilder) {
        ImmutableList immutableList;
        this.f5181e = (String) Preconditions.checkNotNull(callToActionBuilder.f5183a);
        this.f5182f = (String) Preconditions.checkNotNull(callToActionBuilder.f5184b);
        this.f5177a = callToActionBuilder.f5185c;
        this.f5178b = callToActionBuilder.f5186d;
        if (callToActionBuilder.f5187e != null) {
            immutableList = callToActionBuilder.f5187e;
        } else {
            immutableList = ImmutableList.copyOf(Collections.EMPTY_LIST);
        }
        this.f5179c = immutableList;
        this.f5180d = callToActionBuilder.f5188f;
    }

    public CallToAction(Parcel parcel) {
        this.f5181e = parcel.readString();
        this.f5182f = parcel.readString();
        this.f5177a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        String readString = parcel.readString();
        this.f5178b = !Strings.isNullOrEmpty(readString) ? m10052a(readString) : null;
        Collection readArrayList = parcel.readArrayList(String.class.getClassLoader());
        if (readArrayList == null) {
            readArrayList = Collections.EMPTY_LIST;
        }
        this.f5179c = ImmutableList.copyOf(readArrayList);
        this.f5180d = parcel.readInt() == 1;
    }

    public final String m10053a() {
        if (Type.POSTBACK.equals(this.f5178b)) {
            return this.f5181e;
        }
        if (this.f5179c == null || this.f5179c.isEmpty()) {
            return this.f5181e;
        }
        return (String) this.f5179c.get(0);
    }

    public final String m10054b() {
        return this.f5182f == null ? "" : StringLocaleUtil.b(this.f5182f);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5181e);
        parcel.writeString(this.f5182f);
        parcel.writeParcelable(this.f5177a, i);
        parcel.writeString(this.f5178b != null ? this.f5178b.name() : null);
        parcel.writeList(this.f5179c);
        parcel.writeInt(this.f5180d ? 1 : 0);
    }

    public static Type m10052a(String str) {
        Type type = null;
        if (str != null) {
            try {
                type = Type.valueOf(str);
            } catch (IllegalArgumentException e) {
            }
        }
        return type;
    }
}
