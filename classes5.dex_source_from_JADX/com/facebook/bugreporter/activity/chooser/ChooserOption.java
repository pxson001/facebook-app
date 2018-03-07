package com.facebook.bugreporter.activity.chooser;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.bugreporter.analytics.BugReporterAnalyticsLogger.CoreEvent;
import com.facebook.common.fblinks.FBLinks;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: android.media.metadata.ALBUM_ARTIST */
public class ChooserOption implements Parcelable {
    public static final Creator<ChooserOption> CREATOR = new C10341();
    public static final String f10721a = FBLinks.a("bugreport");
    public final int f10722b;
    public final int f10723c;
    public final String f10724d;
    public final CoreEvent f10725e;

    /* compiled from: android.media.metadata.ALBUM_ARTIST */
    final class C10341 implements Creator<ChooserOption> {
        C10341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ChooserOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new ChooserOption[i];
        }
    }

    /* compiled from: android.media.metadata.ALBUM_ARTIST */
    public class Builder {
        private final int f10717a;
        private final String f10718b;
        public int f10719c = 0;
        public CoreEvent f10720d = null;

        public Builder(int i, String str) {
            this.f10717a = i;
            this.f10718b = str;
        }

        public final ChooserOption m18740a() {
            return new ChooserOption(this.f10717a, this.f10719c, this.f10718b, this.f10720d);
        }
    }

    public ChooserOption(int i, int i2, String str, @Nullable CoreEvent coreEvent) {
        this.f10722b = i;
        this.f10723c = i2;
        this.f10724d = str;
        this.f10725e = coreEvent;
    }

    public ChooserOption(Parcel parcel) {
        this.f10722b = parcel.readInt();
        this.f10723c = parcel.readInt();
        this.f10724d = parcel.readString();
        this.f10725e = (CoreEvent) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10722b);
        parcel.writeInt(this.f10723c);
        parcel.writeString(this.f10724d);
        parcel.writeSerializable(this.f10725e);
    }
}
