package com.facebook.events.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.events.model.EventType;
import com.facebook.events.model.PrivacyType;
import java.util.Date;
import java.util.TimeZone;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: audio_upload */
public class CreateEventParams extends ContextParams {
    public static final Creator<CreateEventParams> CREATOR = new C26971();
    public final Long f19033a;
    public final String f19034b;
    public final String f19035c;
    public final long f19036d;
    public final Date f19037e;
    public final boolean f19038f;
    public final Date f19039g;
    public final TimeZone f19040h;
    public final EventType f19041i;
    public final PrivacyType f19042j;
    public final boolean f19043k;
    public final String f19044l;
    public final boolean f19045m;

    /* compiled from: audio_upload */
    final class C26971 implements Creator<CreateEventParams> {
        C26971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            Builder builder = new Builder(parcel);
            builder.f19020b = Long.valueOf(parcel.readLong());
            builder = builder;
            builder.f19021c = parcel.readString();
            builder = builder;
            builder.f19022d = parcel.readString();
            builder = builder;
            builder.f19023e = parcel.readLong();
            builder = builder;
            builder.f19024f = new Date(parcel.readLong());
            Builder builder2 = builder;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            builder2.f19025g = z;
            builder2 = builder2;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                builder2.f19026h = new Date(parcel.readLong());
            }
            builder2.f19027i = TimeZone.getTimeZone(parcel.readString());
            Builder builder3 = builder2;
            builder3.f19032n = (EventType) parcel.readParcelable(EventType.class.getClassLoader());
            builder3 = builder3;
            builder3.f19028j = (PrivacyType) parcel.readParcelable(PrivacyType.class.getClassLoader());
            builder = builder3;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            builder.f19029k = z2;
            builder.f19030l = parcel.readString();
            return builder2.m19251a();
        }

        public final Object[] newArray(int i) {
            return new CreateEventParams[i];
        }
    }

    /* compiled from: audio_upload */
    public class Builder extends com.facebook.events.protocol.ContextParams.Builder<Builder> {
        public Long f19020b = Long.valueOf(-1);
        public String f19021c;
        public String f19022d;
        public long f19023e;
        public Date f19024f;
        public boolean f19025g;
        public Date f19026h;
        public TimeZone f19027i;
        public PrivacyType f19028j;
        public boolean f19029k;
        public String f19030l;
        public boolean f19031m;
        public EventType f19032n;

        public Builder(Parcel parcel) {
            super(parcel);
        }

        public final CreateEventParams m19251a() {
            return new CreateEventParams(this);
        }
    }

    public CreateEventParams(Builder builder) {
        super(builder);
        this.f19033a = builder.f19020b;
        this.f19034b = builder.f19021c;
        this.f19035c = builder.f19022d;
        this.f19036d = builder.f19023e;
        this.f19037e = builder.f19024f;
        this.f19038f = builder.f19025g;
        this.f19039g = builder.f19026h;
        this.f19040h = builder.f19027i;
        this.f19041i = builder.f19032n;
        this.f19042j = builder.f19028j;
        this.f19043k = builder.f19029k;
        this.f19044l = builder.f19030l;
        this.f19045m = builder.f19031m;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f19033a.longValue());
        parcel.writeString(this.f19034b);
        parcel.writeString(this.f19035c);
        parcel.writeLong(this.f19036d);
        parcel.writeLong(this.f19037e.getTime());
        parcel.writeByte((byte) (this.f19038f ? 1 : 0));
        if (this.f19039g != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f19039g != null) {
            parcel.writeLong(this.f19039g.getTime());
        }
        parcel.writeString(this.f19040h.getID());
        parcel.writeParcelable(this.f19041i, i);
        parcel.writeParcelable(this.f19042j, i);
        if (!this.f19043k) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.f19044l);
    }
}
