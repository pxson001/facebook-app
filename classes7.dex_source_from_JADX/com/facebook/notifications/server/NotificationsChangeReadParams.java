package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Iterator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: moof */
public class NotificationsChangeReadParams implements Parcelable {
    public static final Creator<NotificationsChangeReadParams> CREATOR = new C07001();
    private final ImmutableSet<String> f8691a;
    private final boolean f8692b;

    /* compiled from: moof */
    final class C07001 implements Creator<NotificationsChangeReadParams> {
        C07001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NotificationsChangeReadParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new NotificationsChangeReadParams[i];
        }
    }

    public NotificationsChangeReadParams(Parcel parcel) {
        boolean z;
        int i = 0;
        Builder builder = ImmutableSet.builder();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f8692b = z;
        int readInt = parcel.readInt();
        while (i < readInt) {
            builder.c(parcel.readString());
            i++;
        }
        this.f8691a = builder.b();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8692b ? 1 : 0);
        parcel.writeInt(this.f8691a.size());
        Iterator it = this.f8691a.iterator();
        while (it.hasNext()) {
            parcel.writeString((String) it.next());
        }
    }
}
