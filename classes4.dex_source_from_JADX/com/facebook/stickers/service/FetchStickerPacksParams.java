package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.calls.InterfaceInputInterface;
import com.facebook.stickers.model.StickerPackType;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: query_hash */
public class FetchStickerPacksParams implements Parcelable {
    public static final Creator<FetchStickerPacksParams> CREATOR = new C01791();
    public final StickerPackType f3923a;
    public final DataFreshnessParam f3924b;
    private final int f3925c;
    public final boolean f3926d;
    public final boolean f3927e;
    public final boolean f3928f;
    public final boolean f3929g;
    public final TrayPacksUpdateOperation f3930h;

    /* compiled from: query_hash */
    public class Builder {
        private StickerPackType f3915a;
        private DataFreshnessParam f3916b;
        public InterfaceInputInterface f3917c;
        private boolean f3918d;
        private boolean f3919e;
        private boolean f3920f;
        public boolean f3921g;
        public TrayPacksUpdateOperation f3922h = TrayPacksUpdateOperation.DO_NOT_UPDATE;

        public Builder(StickerPackType stickerPackType, DataFreshnessParam dataFreshnessParam) {
            this.f3915a = stickerPackType;
            this.f3916b = dataFreshnessParam;
        }

        public final Builder m4384a(@Nullable InterfaceInputInterface interfaceInputInterface) {
            this.f3917c = interfaceInputInterface;
            return this;
        }

        public final FetchStickerPacksParams m4385a() {
            return new FetchStickerPacksParams(this.f3915a, this.f3916b, this.f3917c, this.f3918d, this.f3919e, this.f3920f, this.f3921g, this.f3922h);
        }
    }

    /* compiled from: query_hash */
    public enum TrayPacksUpdateOperation {
        APPEND_TO_DB,
        REPLACE_FROM_NETWORK,
        DO_NOT_UPDATE
    }

    /* compiled from: query_hash */
    final class C01791 implements Creator<FetchStickerPacksParams> {
        C01791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickerPacksParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickerPacksParams[i];
        }
    }

    private FetchStickerPacksParams(StickerPackType stickerPackType, DataFreshnessParam dataFreshnessParam, InterfaceInputInterface interfaceInputInterface, boolean z, boolean z2, boolean z3, boolean z4, TrayPacksUpdateOperation trayPacksUpdateOperation) {
        this.f3923a = stickerPackType;
        this.f3924b = dataFreshnessParam;
        this.f3925c = interfaceInputInterface != null ? interfaceInputInterface.ordinal() : -1;
        this.f3926d = z;
        this.f3927e = z2;
        this.f3928f = z3;
        this.f3929g = z4;
        boolean z5 = this.f3929g || trayPacksUpdateOperation != TrayPacksUpdateOperation.APPEND_TO_DB;
        Preconditions.checkArgument(z5, "appending to db operation should only be used when performing a delta fetch");
        this.f3930h = trayPacksUpdateOperation;
    }

    public FetchStickerPacksParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f3923a = StickerPackType.valueOf(parcel.readString());
        this.f3924b = DataFreshnessParam.valueOf(parcel.readString());
        this.f3925c = parcel.readInt();
        this.f3926d = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3927e = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3928f = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f3929g = z2;
        this.f3930h = TrayPacksUpdateOperation.valueOf(parcel.readString());
    }

    public final StickerPackType m4386a() {
        return this.f3923a;
    }

    public final DataFreshnessParam m4387b() {
        return this.f3924b;
    }

    @Nullable
    public final InterfaceInputInterface m4388d() {
        if (this.f3925c == -1) {
            return null;
        }
        return InterfaceInputInterface.values()[this.f3925c];
    }

    public final boolean m4389g() {
        return this.f3929g;
    }

    public final TrayPacksUpdateOperation m4390h() {
        return this.f3930h;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f3923a.toString());
        parcel.writeString(this.f3924b.toString());
        parcel.writeInt(this.f3925c);
        parcel.writeInt(this.f3926d ? 1 : 0);
        if (this.f3927e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f3928f) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f3929g) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.f3930h.toString());
    }

    public int hashCode() {
        int hashCode;
        int i = 1;
        int i2 = 0;
        int hashCode2 = (this.f3923a != null ? this.f3923a.hashCode() : 0) * 31;
        if (this.f3924b != null) {
            hashCode = this.f3924b.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (((hashCode + hashCode2) * 31) + this.f3925c) * 31;
        if (this.f3926d) {
            hashCode = 1;
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f3927e) {
            hashCode = 1;
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f3928f) {
            hashCode = 1;
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (!this.f3929g) {
            i = 0;
        }
        hashCode = (hashCode + i) * 31;
        if (this.f3930h != null) {
            i2 = this.f3930h.hashCode();
        }
        return hashCode + i2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchStickerPacksParams)) {
            return false;
        }
        FetchStickerPacksParams fetchStickerPacksParams = (FetchStickerPacksParams) obj;
        if (this.f3923a == fetchStickerPacksParams.f3923a && this.f3924b == fetchStickerPacksParams.f3924b && this.f3925c == fetchStickerPacksParams.f3925c && this.f3926d == fetchStickerPacksParams.f3926d && this.f3927e == fetchStickerPacksParams.f3927e && this.f3928f == fetchStickerPacksParams.f3928f && this.f3929g == fetchStickerPacksParams.f3929g && this.f3930h == fetchStickerPacksParams.f3930h) {
            return true;
        }
        return false;
    }
}
