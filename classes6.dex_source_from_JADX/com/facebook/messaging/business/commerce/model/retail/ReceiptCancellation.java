package com.facebook.messaging.business.commerce.model.retail;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: video_transcode_start_count */
public class ReceiptCancellation implements CommerceBubbleModel {
    public static final Creator<ReceiptCancellation> CREATOR = new C00651();
    @Nullable
    public final String f615a;
    @Nullable
    public final Receipt f616b;
    public final int f617c;
    public final ImmutableList<PlatformGenericAttachmentItem> f618d;

    /* compiled from: video_transcode_start_count */
    final class C00651 implements Creator<ReceiptCancellation> {
        C00651() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReceiptCancellation(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReceiptCancellation[i];
        }
    }

    public ReceiptCancellation(ReceiptCancellationBuilder receiptCancellationBuilder) {
        this.f615a = receiptCancellationBuilder.f619a;
        this.f616b = receiptCancellationBuilder.f620b;
        this.f617c = receiptCancellationBuilder.f621c;
        Collection collection = receiptCancellationBuilder.f622d;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        this.f618d = ImmutableList.copyOf(collection);
    }

    public ReceiptCancellation(Parcel parcel) {
        this.f615a = parcel.readString();
        this.f616b = (Receipt) parcel.readParcelable(Receipt.class.getClassLoader());
        this.f617c = parcel.readInt();
        Collection readArrayList = parcel.readArrayList(PlatformGenericAttachmentItem.class.getClassLoader());
        if (readArrayList == null) {
            readArrayList = Collections.EMPTY_LIST;
        }
        this.f618d = ImmutableList.copyOf(readArrayList);
    }

    public final CommerceBubbleModelType mo75b() {
        return CommerceBubbleModelType.CANCELLATION;
    }

    public final String mo74a() {
        return this.f615a;
    }

    public final ImmutableList<PlatformGenericAttachmentItem> mo76c() {
        return this.f618d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f615a);
        parcel.writeParcelable(this.f616b, i);
        parcel.writeInt(this.f617c);
        parcel.writeList(this.f618d);
    }
}
