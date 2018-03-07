package com.facebook.photos.pandora.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: composer_rating_selected */
public class SimplePandoraInstanceId extends PandoraInstanceId {
    public static final Creator<SimplePandoraInstanceId> CREATOR = new C18461();
    public String f17366a;
    @Nullable
    private String f17367b;

    /* compiled from: composer_rating_selected */
    final class C18461 implements Creator<SimplePandoraInstanceId> {
        C18461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimplePandoraInstanceId(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimplePandoraInstanceId[i];
        }
    }

    public SimplePandoraInstanceId(String str) {
        this.f17366a = str;
    }

    public SimplePandoraInstanceId(String str, String str2) {
        this.f17366a = str;
        this.f17367b = str2;
    }

    public SimplePandoraInstanceId(Parcel parcel) {
        this.f17366a = parcel.readString();
        this.f17367b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17366a);
        parcel.writeString(this.f17367b);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SimplePandoraInstanceId)) {
            return false;
        }
        SimplePandoraInstanceId simplePandoraInstanceId = (SimplePandoraInstanceId) obj;
        if (Objects.equal(simplePandoraInstanceId.f17366a, this.f17366a) && Objects.equal(simplePandoraInstanceId.f17367b, this.f17367b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f17366a, this.f17367b});
    }

    public String toString() {
        return this.f17366a;
    }
}
