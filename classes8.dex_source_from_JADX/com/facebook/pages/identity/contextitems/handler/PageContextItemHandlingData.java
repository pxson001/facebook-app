package com.facebook.pages.identity.contextitems.handler;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultAddressFieldsModel;
import javax.annotation.Nullable;

/* compiled from: confirmationEditRegistrationContactpointParams */
public class PageContextItemHandlingData implements Parcelable {
    public static final Creator<PageContextItemHandlingData> CREATOR = new C18371();
    public final long f17312a;
    public final boolean f17313b;
    public final boolean f17314c;
    public int f17315d = 0;
    @Nullable
    public final String f17316e;
    @Nullable
    public final String f17317f;
    @Nullable
    public final DefaultLocationFields f17318g;
    @Nullable
    public final DefaultAddressFieldsModel f17319h;
    @Nullable
    public final ViewerContext f17320i;
    @Nullable
    public ParcelUuid f17321j;

    /* compiled from: confirmationEditRegistrationContactpointParams */
    final class C18371 implements Creator<PageContextItemHandlingData> {
        C18371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PageContextItemHandlingData(parcel);
        }

        public final Object[] newArray(int i) {
            return new PageContextItemHandlingData[i];
        }
    }

    public PageContextItemHandlingData(long j, String str, String str2, DefaultLocationFields defaultLocationFields, DefaultAddressFieldsModel defaultAddressFieldsModel, ViewerContext viewerContext, boolean z, boolean z2) {
        this.f17312a = j;
        this.f17316e = str;
        this.f17317f = str2;
        this.f17318g = defaultLocationFields;
        this.f17319h = defaultAddressFieldsModel;
        this.f17320i = viewerContext;
        this.f17313b = z;
        this.f17314c = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f17312a);
        parcel.writeString(this.f17316e);
        parcel.writeString(this.f17317f);
        parcel.writeInt(this.f17315d);
        parcel.writeValue(Boolean.valueOf(this.f17313b));
        parcel.writeValue(Boolean.valueOf(this.f17314c));
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f17318g);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f17319h);
        parcel.writeParcelable(this.f17320i, i);
        parcel.writeParcelable(this.f17321j, i);
    }

    public PageContextItemHandlingData(Parcel parcel) {
        this.f17312a = parcel.readLong();
        this.f17316e = parcel.readString();
        this.f17317f = parcel.readString();
        this.f17315d = parcel.readInt();
        this.f17313b = ((Boolean) parcel.readValue(null)).booleanValue();
        this.f17314c = ((Boolean) parcel.readValue(null)).booleanValue();
        this.f17318g = (DefaultLocationFields) FlatBufferModelHelper.a(parcel);
        this.f17319h = (DefaultAddressFieldsModel) FlatBufferModelHelper.a(parcel);
        this.f17320i = (ViewerContext) parcel.readParcelable(ViewerContext.class.getClassLoader());
        this.f17321j = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
    }
}
