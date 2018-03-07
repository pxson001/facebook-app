package com.facebook.orca.compose;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogParams;
import com.facebook.messaging.payment.value.input.OrionMessengerPayParams;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.share.model.ShareItem;
import com.facebook.ui.media.attachments.MediaResource;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: org.torproject.android.intent.extra.PACKAGE_NAME */
public class ComposerInitParams implements Parcelable {
    public static final Creator<ComposerInitParams> CREATOR = new C07651();
    public final String f5425a;
    public final List<MediaResource> f5426b;
    public final PickMediaDialogParams f5427c;
    public final OrionMessengerPayParams f5428d;
    public final ShareItem f5429e;
    public final boolean f5430f;
    public final boolean f5431g;
    public final ComposerAppAttribution f5432h;

    /* compiled from: org.torproject.android.intent.extra.PACKAGE_NAME */
    final class C07651 implements Creator<ComposerInitParams> {
        C07651() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerInitParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerInitParams[i];
        }
    }

    public ComposerInitParams(ComposerInitParamsBuilder composerInitParamsBuilder) {
        this.f5425a = composerInitParamsBuilder.f5433a;
        this.f5426b = composerInitParamsBuilder.f5434b;
        this.f5427c = composerInitParamsBuilder.f5435c;
        this.f5428d = composerInitParamsBuilder.f5436d;
        this.f5429e = composerInitParamsBuilder.f5437e;
        this.f5430f = composerInitParamsBuilder.f5438f;
        this.f5431g = composerInitParamsBuilder.f5439g;
        this.f5432h = composerInitParamsBuilder.f5440h;
    }

    public ComposerInitParams(Parcel parcel) {
        this.f5425a = parcel.readString();
        this.f5426b = parcel.readArrayList(MediaResource.class.getClassLoader());
        this.f5427c = (PickMediaDialogParams) parcel.readParcelable(PickMediaDialogParams.class.getClassLoader());
        this.f5428d = (OrionMessengerPayParams) parcel.readParcelable(OrionMessengerPayParams.class.getClassLoader());
        this.f5429e = (ShareItem) parcel.readParcelable(ShareItem.class.getClassLoader());
        this.f5430f = ParcelUtil.a(parcel);
        this.f5431g = ParcelUtil.a(parcel);
        this.f5432h = (ComposerAppAttribution) parcel.readParcelable(ComposerAppAttribution.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5425a);
        parcel.writeList(this.f5426b);
        parcel.writeParcelable(this.f5427c, i);
        parcel.writeParcelable(this.f5428d, i);
        parcel.writeParcelable(this.f5429e, i);
        ParcelUtil.a(parcel, this.f5430f);
        ParcelUtil.a(parcel, this.f5431g);
        parcel.writeParcelable(this.f5432h, i);
    }
}
