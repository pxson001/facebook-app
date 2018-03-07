package com.facebook.search.results.protocol.filters;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: method/places.create */
public class FilterValue implements Parcelable {
    public static final Creator<FilterValue> CREATOR = new C09231();
    public final String f8689a;
    public final String f8690b;
    public final String f8691c;
    public final boolean f8692d;
    public final String f8693e;
    public final boolean f8694f;

    /* compiled from: method/places.create */
    final class C09231 implements Creator<FilterValue> {
        C09231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FilterValue(parcel);
        }

        public final Object[] newArray(int i) {
            return new FilterValue[i];
        }
    }

    /* compiled from: method/places.create */
    public class Builder {
        public String f8683a;
        public String f8684b;
        public String f8685c;
        public boolean f8686d;
        public String f8687e;
        public boolean f8688f = false;

        public final FilterValue m10135f() {
            return new FilterValue(this);
        }
    }

    protected FilterValue(Builder builder) {
        this.f8689a = (String) Preconditions.checkNotNull(builder.f8683a);
        this.f8690b = (String) Preconditions.checkNotNull(builder.f8684b);
        this.f8691c = builder.f8685c;
        this.f8692d = builder.f8686d;
        this.f8693e = builder.f8687e;
        this.f8694f = builder.f8688f;
    }

    public FilterValue(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f8689a = (String) Preconditions.checkNotNull(parcel.readString());
        this.f8690b = (String) Preconditions.checkNotNull(parcel.readString());
        this.f8691c = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f8692d = z;
        this.f8693e = parcel.readString();
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f8694f = z2;
    }

    @Nonnull
    public final String m10137a() {
        return this.f8689a;
    }

    @Nonnull
    public final String m10138b() {
        return this.f8690b;
    }

    @Nullable
    public final String m10139c() {
        return this.f8691c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FilterValue)) {
            return false;
        }
        return this.f8690b.equals(((FilterValue) obj).f8690b);
    }

    public int hashCode() {
        return this.f8690b.hashCode();
    }

    public String toString() {
        JsonFactory jsonFactory = new JsonFactory();
        Writer stringWriter = new StringWriter();
        try {
            JsonGenerator a = jsonFactory.a(stringWriter);
            a.f();
            a.a("value", this.f8690b);
            a.a("text", this.f8689a);
            a.a("name", this.f8691c);
            a.a("is_selected", Boolean.toString(this.f8692d));
            a.a("profile_picture_uri", this.f8693e);
            a.a("is_fuzzy", Boolean.toString(this.f8694f));
            a.g();
            a.close();
            return stringWriter.getBuffer().toString();
        } catch (IOException e) {
            return super.toString();
        }
    }

    public static Builder m10136g() {
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f8689a);
        parcel.writeString(this.f8690b);
        parcel.writeString(this.f8691c);
        if (this.f8692d) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f8693e);
        if (!this.f8694f) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
