package com.facebook.messaging.media.upload.udp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.model.attachment.ImageData.Source;
import com.facebook.messaging.model.attachment.VideoData;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import javax.annotation.concurrent.Immutable;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: last_delivered_receipt_time */
public class UDPMetadataUploadMethod implements ApiMethod<UDPUploadParams, UDPServerConfig> {

    @Immutable
    /* compiled from: last_delivered_receipt_time */
    public class UDPUploadParams implements Parcelable {
        public static final Creator<UDPUploadParams> CREATOR = new C13511();
        public final MediaResource f12194a;
        public final String f12195b;
        public final int f12196c;
        public final long f12197d;

        /* compiled from: last_delivered_receipt_time */
        final class C13511 implements Creator<UDPUploadParams> {
            C13511() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new UDPUploadParams((MediaResource) MediaResource.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt(), parcel.readLong());
            }

            public final Object[] newArray(int i) {
                return new UDPUploadParams[i];
            }
        }

        public UDPUploadParams(MediaResource mediaResource, String str, int i, long j) {
            this.f12194a = mediaResource;
            this.f12195b = str;
            this.f12196c = i;
            this.f12197d = j;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f12194a, i);
            parcel.writeString(this.f12195b);
            parcel.writeLong((long) this.f12196c);
            parcel.writeLong(this.f12197d);
        }
    }

    public final ApiRequest m12700a(Object obj) {
        UDPUploadParams uDPUploadParams = (UDPUploadParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "udp_upload";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "/me/udp_uploads";
        newBuilder = newBuilder;
        Builder builder = ImmutableList.builder();
        MediaResource mediaResource = uDPUploadParams.f12194a;
        builder.c(new BasicNameValuePair("entity_name", new File(mediaResource.c.getPath()).getName()));
        if (mediaResource.d == Type.PHOTO) {
            String str;
            String str2 = "image_type";
            if (mediaResource.e.isQuickCamSource()) {
                str = Source.QUICKCAM.apiStringValue;
            } else {
                str = Source.NONQUICKCAM.apiStringValue;
            }
            builder.c(new BasicNameValuePair(str2, str));
        } else if (mediaResource.d == Type.VIDEO) {
            builder.c(new BasicNameValuePair("video_type", mediaResource.e.isQuickCamSource() ? VideoData.Source.QUICKCAM.apiStringValue : VideoData.Source.NONQUICKCAM.apiStringValue));
        }
        builder.c(new BasicNameValuePair("mime_type", mediaResource.o));
        builder.c(new BasicNameValuePair("media_hash", uDPUploadParams.f12195b));
        builder.c(new BasicNameValuePair("payload_size", Long.toString(mediaResource.p)));
        builder.c(new BasicNameValuePair("upload_id", Integer.toString(uDPUploadParams.f12196c)));
        builder.c(new BasicNameValuePair("user_id", Long.toString(uDPUploadParams.f12197d)));
        newBuilder.g = builder.b();
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m12701a(Object obj, ApiResponse apiResponse) {
        return UDPServerConfig.m12706a(apiResponse.c());
    }
}
