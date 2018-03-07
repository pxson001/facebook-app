package com.facebook.messaging.business.commerce.model.retail;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: video_resized_file_size */
public class Subscription implements CommerceBubbleModel {
    public static final Creator<Subscription> CREATOR = new C00711();
    public final String f701a;
    @Nullable
    public final LogoImage f702b;
    @Nullable
    public final Uri f703c;
    public final PlatformGenericAttachmentItem f704d;

    /* compiled from: video_resized_file_size */
    final class C00711 implements Creator<Subscription> {
        C00711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Subscription(parcel);
        }

        public final Object[] newArray(int i) {
            return new Subscription[i];
        }
    }

    public Subscription(SubscriptionBuilder subscriptionBuilder) {
        this.f701a = (String) Preconditions.checkNotNull(subscriptionBuilder.f705a);
        this.f702b = subscriptionBuilder.f706b;
        this.f703c = subscriptionBuilder.f707c;
        this.f704d = subscriptionBuilder.f708d;
    }

    public Subscription(Parcel parcel) {
        this.f701a = parcel.readString();
        this.f702b = (LogoImage) parcel.readParcelable(LogoImage.class.getClassLoader());
        this.f703c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f704d = (PlatformGenericAttachmentItem) parcel.readParcelable(PlatformGenericAttachmentItem.class.getClassLoader());
    }

    public final String mo74a() {
        return this.f701a;
    }

    public final CommerceBubbleModelType mo75b() {
        return CommerceBubbleModelType.PRODUCT_SUBSCRIPTION;
    }

    public final ImmutableList<PlatformGenericAttachmentItem> mo76c() {
        return ImmutableList.of(this.f704d);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f701a);
        parcel.writeParcelable(this.f702b, i);
        parcel.writeParcelable(this.f703c, i);
        parcel.writeParcelable(this.f704d, i);
    }
}
