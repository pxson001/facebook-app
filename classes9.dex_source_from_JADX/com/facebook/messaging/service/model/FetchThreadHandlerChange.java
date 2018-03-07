package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: count_string */
public class FetchThreadHandlerChange implements Parcelable {
    public static final Creator<FetchThreadHandlerChange> CREATOR = new C20241();
    @Nonnull
    public final Handler f17110a;
    @Nonnull
    public final Handler f17111b;
    @Nonnull
    public final ChangeReason f17112c;

    /* compiled from: count_string */
    final class C20241 implements Creator<FetchThreadHandlerChange> {
        C20241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchThreadHandlerChange(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchThreadHandlerChange[i];
        }
    }

    /* compiled from: count_string */
    public enum ChangeReason {
        NOT_MOSTLY_CACHED(0),
        NEED_MORE_RECENT_MESSAGES(1),
        NEED_OLDER_MESSAGES(2),
        NOT_IN_MEMORY_CACHE(3);
        
        public final int parcelValue;

        private ChangeReason(int i) {
            this.parcelValue = i;
        }

        public static ChangeReason fromParcelValue(int i) {
            switch (i) {
                case 0:
                    return NOT_MOSTLY_CACHED;
                case 1:
                    return NEED_MORE_RECENT_MESSAGES;
                case 2:
                    return NEED_OLDER_MESSAGES;
                case 3:
                    return NOT_IN_MEMORY_CACHE;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    /* compiled from: count_string */
    public enum Handler {
        CACHE(0),
        DATABASE(1),
        SERVER(2);
        
        public final int parcelValue;

        private Handler(int i) {
            this.parcelValue = i;
        }

        public static Handler fromParcelValue(int i) {
            switch (i) {
                case 0:
                    return CACHE;
                case 1:
                    return DATABASE;
                case 2:
                    return SERVER;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    private FetchThreadHandlerChange(@Nonnull Handler handler, @Nonnull Handler handler2, @Nonnull ChangeReason changeReason) {
        this.f17110a = (Handler) Preconditions.checkNotNull(handler);
        this.f17111b = (Handler) Preconditions.checkNotNull(handler2);
        this.f17112c = (ChangeReason) Preconditions.checkNotNull(changeReason);
    }

    public static FetchThreadHandlerChange m17098a() {
        return new FetchThreadHandlerChange(Handler.CACHE, Handler.DATABASE, ChangeReason.NOT_IN_MEMORY_CACHE);
    }

    public static FetchThreadHandlerChange m17099a(@Nonnull ChangeReason changeReason) {
        boolean z = changeReason == ChangeReason.NOT_MOSTLY_CACHED || changeReason == ChangeReason.NEED_MORE_RECENT_MESSAGES || changeReason == ChangeReason.NEED_OLDER_MESSAGES;
        Preconditions.checkState(z);
        return new FetchThreadHandlerChange(Handler.DATABASE, Handler.SERVER, changeReason);
    }

    public FetchThreadHandlerChange(Parcel parcel) {
        this.f17110a = Handler.fromParcelValue(parcel.readInt());
        this.f17111b = Handler.fromParcelValue(parcel.readInt());
        this.f17112c = ChangeReason.fromParcelValue(parcel.readInt());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f17110a.parcelValue);
        parcel.writeInt(this.f17111b.parcelValue);
        parcel.writeInt(this.f17112c.parcelValue);
    }

    public String toString() {
        return this.f17110a + "->" + this.f17111b + ":" + this.f17112c;
    }
}
