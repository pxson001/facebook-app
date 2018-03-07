package com.facebook.identitygrowth.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: mCreativeEditingData */
public class SaveProfileQuestionParams implements Parcelable {
    public static final Creator<SaveProfileQuestionParams> CREATOR = new C06931();
    public final String f11192a;
    public final String f11193b;
    public final String f11194c;
    public final String f11195d;
    public final String f11196e;
    public final String f11197f;
    public final String f11198g;

    /* compiled from: mCreativeEditingData */
    final class C06931 implements Creator<SaveProfileQuestionParams> {
        C06931() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SaveProfileQuestionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SaveProfileQuestionParams[i];
        }
    }

    public SaveProfileQuestionParams(@Nullable String str, @Nonnull String str2, @Nonnull String str3, @Nullable String str4, @Nullable String str5, @Nonnull String str6) {
        this.f11192a = str;
        this.f11194c = str3;
        this.f11193b = str2;
        if (this.f11193b.equals("SAVE")) {
            String str7;
            this.f11195d = "page".equals(str5) ? str4 : null;
            if ("predefined_option".equals(str5)) {
                str7 = str4;
            } else {
                str7 = null;
            }
            this.f11197f = str7;
            if (!"secondary_option".equals(str5)) {
                str4 = null;
            }
            this.f11198g = str4;
            this.f11196e = str6;
            return;
        }
        this.f11196e = null;
        this.f11195d = null;
        this.f11197f = null;
        this.f11198g = null;
    }

    public SaveProfileQuestionParams(Parcel parcel) {
        this.f11192a = parcel.readString();
        this.f11193b = parcel.readString();
        this.f11194c = parcel.readString();
        this.f11195d = parcel.readString();
        this.f11197f = parcel.readString();
        this.f11198g = parcel.readString();
        this.f11196e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11192a);
        parcel.writeString(this.f11193b);
        parcel.writeString(this.f11194c);
        parcel.writeString(this.f11195d);
        parcel.writeString(this.f11197f);
        parcel.writeString(this.f11198g);
        parcel.writeString(this.f11196e);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("method", "SaveProfileQuestionMethod").add("graphApiID", this.f11192a).add("action", this.f11193b).add("sessionID", this.f11194c).add("hubID", this.f11195d).add("predefined_option", this.f11197f).add("secondary_option", this.f11198g).add("privacy", this.f11196e).toString();
    }
}
