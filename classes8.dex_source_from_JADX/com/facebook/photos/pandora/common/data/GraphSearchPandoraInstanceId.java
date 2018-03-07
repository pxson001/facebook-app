package com.facebook.photos.pandora.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: composer_title */
public class GraphSearchPandoraInstanceId extends PandoraInstanceId {
    public static final Creator<GraphSearchPandoraInstanceId> CREATOR = new C18441();
    public String f17358a;
    @Nullable
    public String f17359b;

    /* compiled from: composer_title */
    final class C18441 implements Creator<GraphSearchPandoraInstanceId> {
        C18441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphSearchPandoraInstanceId(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphSearchPandoraInstanceId[i];
        }
    }

    public GraphSearchPandoraInstanceId(String str, @Nullable String str2) {
        this.f17358a = str;
        this.f17359b = str2;
    }

    public GraphSearchPandoraInstanceId(Parcel parcel) {
        this.f17358a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17358a);
        parcel.writeString(this.f17359b);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GraphSearchPandoraInstanceId)) {
            return false;
        }
        GraphSearchPandoraInstanceId graphSearchPandoraInstanceId = (GraphSearchPandoraInstanceId) obj;
        if (Optional.fromNullable(graphSearchPandoraInstanceId.f17358a).equals(Optional.fromNullable(this.f17358a)) && Optional.fromNullable(graphSearchPandoraInstanceId.f17359b).equals(Optional.fromNullable(this.f17359b))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f17358a, this.f17359b});
    }

    public String toString() {
        return this.f17358a;
    }
}
