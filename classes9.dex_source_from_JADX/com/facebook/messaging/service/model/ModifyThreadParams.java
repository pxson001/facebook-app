package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: content_search */
public class ModifyThreadParams implements Parcelable {
    public static final Creator<ModifyThreadParams> CREATOR = new C20401();
    public final ThreadKey f17221a;
    public final String f17222b;
    public final boolean f17223c;
    public final String f17224d;
    public final MediaResource f17225e;
    public final boolean f17226f;
    public final boolean f17227g;
    public final NotificationSetting f17228h;
    public final boolean f17229i;
    public final boolean f17230j;
    public final NicknamePair f17231k;
    public final ThreadCustomization f17232l;
    @Nullable
    public final String f17233m;
    public final boolean f17234n;
    public final int f17235o;
    public final int f17236p;

    /* compiled from: content_search */
    final class C20401 implements Creator<ModifyThreadParams> {
        C20401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ModifyThreadParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ModifyThreadParams[i];
        }
    }

    /* compiled from: content_search */
    public class NicknamePair implements Parcelable {
        public static final Creator<NicknamePair> NICKNAME_PAIR_CREATOR = new C20411();
        public String f17219a;
        public String f17220b;

        /* compiled from: content_search */
        final class C20411 implements Creator<NicknamePair> {
            C20411() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new NicknamePair(parcel);
            }

            public final Object[] newArray(int i) {
                return new NicknamePair[i];
            }
        }

        public NicknamePair(String str, String str2) {
            this.f17219a = str;
            this.f17220b = str2;
        }

        public NicknamePair(Parcel parcel) {
            this.f17219a = parcel.readString();
            this.f17220b = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f17219a);
            parcel.writeString(this.f17220b);
        }

        public int describeContents() {
            return 0;
        }
    }

    ModifyThreadParams(ModifyThreadParamsBuilder modifyThreadParamsBuilder) {
        boolean z;
        if (modifyThreadParamsBuilder.f17237a == null && modifyThreadParamsBuilder.f17238b == null) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z, "thread id/key/idRefQuery must be specified");
        this.f17221a = modifyThreadParamsBuilder.f17237a;
        this.f17222b = modifyThreadParamsBuilder.f17238b;
        this.f17223c = modifyThreadParamsBuilder.f17239c;
        this.f17224d = modifyThreadParamsBuilder.f17240d;
        this.f17226f = modifyThreadParamsBuilder.f17241e;
        this.f17225e = modifyThreadParamsBuilder.f17242f;
        this.f17227g = modifyThreadParamsBuilder.f17243g;
        this.f17228h = modifyThreadParamsBuilder.f17244h;
        this.f17229i = modifyThreadParamsBuilder.f17245i;
        this.f17230j = modifyThreadParamsBuilder.f17246j;
        this.f17231k = modifyThreadParamsBuilder.f17247k;
        this.f17232l = modifyThreadParamsBuilder.f17248l;
        this.f17233m = modifyThreadParamsBuilder.f17249m;
        this.f17234n = modifyThreadParamsBuilder.f17250n;
        this.f17235o = modifyThreadParamsBuilder.f17251o;
        this.f17236p = modifyThreadParamsBuilder.f17252p;
    }

    public ModifyThreadParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f17221a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17222b = parcel.readString();
        this.f17223c = parcel.readInt() != 0;
        this.f17224d = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f17226f = z;
        this.f17225e = (MediaResource) parcel.readParcelable(MediaResource.class.getClassLoader());
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f17227g = z;
        this.f17228h = (NotificationSetting) parcel.readParcelable(NotificationSetting.class.getClassLoader());
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f17229i = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f17230j = z2;
        this.f17232l = (ThreadCustomization) parcel.readParcelable(ThreadCustomization.class.getClassLoader());
        this.f17234n = ParcelUtil.a(parcel);
        this.f17235o = parcel.readInt();
        this.f17236p = parcel.readInt();
        this.f17233m = parcel.readString();
        this.f17231k = (NicknamePair) parcel.readParcelable(NicknamePair.class.getClassLoader());
    }

    public final ThreadKey m17155a() {
        return this.f17221a;
    }

    public final String m17156q() {
        if (this.f17221a == null) {
            return this.f17222b;
        }
        return String.valueOf(this.f17221a.i());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeParcelable(this.f17221a, i);
        parcel.writeInt(this.f17223c ? 1 : 0);
        parcel.writeString(this.f17224d);
        if (this.f17226f) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.f17225e, i);
        if (this.f17227g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.f17228h, i);
        if (this.f17229i) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f17230j) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeParcelable(this.f17232l, i);
        ParcelUtil.a(parcel, this.f17234n);
        parcel.writeInt(this.f17235o);
        parcel.writeInt(this.f17236p);
        parcel.writeString(this.f17233m);
        parcel.writeParcelable(this.f17231k, i);
    }
}
