package com.facebook.messaging.business.commerce.model.retail;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: video_trim_end_time_ms */
public class Receipt implements CommerceBubbleModel {
    public static final Creator<Receipt> CREATOR = new C00641();
    public final String f575a;
    @Nullable
    public final String f576b;
    @Nullable
    public final String f577c;
    @Nullable
    public final String f578d;
    @Nullable
    public final Uri f579e;
    @Nullable
    public final Uri f580f;
    @Nullable
    public final RetailAddress f581g;
    @Nullable
    public final String f582h;
    @Nullable
    public final String f583i;
    @Nullable
    public final String f584j;
    public final ImmutableList<RetailAdjustment> f585k;
    @Nullable
    public final String f586l;
    @Nullable
    public final String f587m;
    @Nullable
    public final LogoImage f588n;
    @Nullable
    public final String f589o;
    @Nullable
    public final String f590p;
    @Nullable
    public final String f591q;
    public final boolean f592r;
    public final int f593s;
    public final ImmutableList<PlatformGenericAttachmentItem> f594t;

    /* compiled from: video_trim_end_time_ms */
    final class C00641 implements Creator<Receipt> {
        C00641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Receipt(parcel);
        }

        public final Object[] newArray(int i) {
            return new Receipt[i];
        }
    }

    public Receipt(ReceiptBuilder receiptBuilder) {
        this.f575a = (String) Preconditions.checkNotNull(receiptBuilder.f595a);
        this.f576b = receiptBuilder.f596b;
        this.f577c = receiptBuilder.f597c;
        this.f578d = receiptBuilder.f598d;
        this.f579e = receiptBuilder.f599e;
        this.f580f = receiptBuilder.f600f;
        this.f581g = receiptBuilder.f601g;
        this.f582h = receiptBuilder.f602h;
        this.f583i = receiptBuilder.f603i;
        this.f584j = receiptBuilder.f604j;
        Collection collection = receiptBuilder.f606l;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        this.f585k = ImmutableList.copyOf(collection);
        this.f586l = receiptBuilder.f605k;
        this.f587m = receiptBuilder.f607m;
        this.f588n = receiptBuilder.f610p;
        this.f589o = receiptBuilder.f608n;
        this.f593s = receiptBuilder.f609o;
        collection = receiptBuilder.f611q;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        this.f594t = ImmutableList.copyOf(collection);
        this.f590p = receiptBuilder.f612r;
        this.f591q = receiptBuilder.f613s;
        this.f592r = receiptBuilder.f614t;
    }

    public Receipt(Parcel parcel) {
        this.f575a = parcel.readString();
        this.f576b = parcel.readString();
        this.f577c = parcel.readString();
        this.f578d = parcel.readString();
        this.f579e = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f580f = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f581g = (RetailAddress) parcel.readParcelable(RetailAddress.class.getClassLoader());
        this.f582h = parcel.readString();
        this.f583i = parcel.readString();
        this.f584j = parcel.readString();
        Collection readArrayList = parcel.readArrayList(RetailAdjustment.class.getClassLoader());
        if (readArrayList == null) {
            readArrayList = Collections.EMPTY_LIST;
        }
        this.f585k = ImmutableList.copyOf(readArrayList);
        this.f586l = parcel.readString();
        this.f587m = parcel.readString();
        this.f588n = (LogoImage) parcel.readParcelable(LogoImage.class.getClassLoader());
        this.f589o = parcel.readString();
        this.f593s = parcel.readInt();
        readArrayList = parcel.readArrayList(PlatformGenericAttachmentItem.class.getClassLoader());
        if (readArrayList == null) {
            readArrayList = Collections.EMPTY_LIST;
        }
        this.f594t = ImmutableList.copyOf(readArrayList);
        this.f590p = parcel.readString();
        this.f591q = parcel.readString();
        this.f592r = parcel.readByte() != (byte) 0;
    }

    public final CommerceBubbleModelType mo75b() {
        return CommerceBubbleModelType.RECEIPT;
    }

    public final String mo74a() {
        return this.f575a;
    }

    public final ImmutableList<PlatformGenericAttachmentItem> mo76c() {
        return this.f594t;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f575a);
        parcel.writeString(this.f576b);
        parcel.writeString(this.f577c);
        parcel.writeString(this.f578d);
        parcel.writeParcelable(this.f579e, i);
        parcel.writeParcelable(this.f580f, i);
        parcel.writeParcelable(this.f581g, i);
        parcel.writeString(this.f582h);
        parcel.writeString(this.f583i);
        parcel.writeString(this.f584j);
        parcel.writeList(this.f585k);
        parcel.writeString(this.f586l);
        parcel.writeString(this.f587m);
        parcel.writeParcelable(this.f588n, i);
        parcel.writeString(this.f589o);
        parcel.writeInt(this.f593s);
        parcel.writeList(this.f594t);
        parcel.writeString(this.f590p);
        parcel.writeString(this.f591q);
        parcel.writeByte((byte) (this.f592r ? 1 : 0));
    }
}
