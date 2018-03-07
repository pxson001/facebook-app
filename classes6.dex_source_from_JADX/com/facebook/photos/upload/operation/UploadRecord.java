package com.facebook.photos.upload.operation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = UploadRecordDeserializer.class)
@JsonSerialize(using = UploadRecordSerializer.class)
/* compiled from: glCreateShader type= */
public class UploadRecord implements Parcelable {
    public static final Creator<UploadRecord> CREATOR = new C08871();
    public static final Class<?> f13830a = UploadRecord.class;
    @JsonProperty("fbid")
    public long fbid;
    @JsonProperty("isRawUpload")
    public boolean isRawUpload;
    @JsonProperty("multimediaInfo")
    public MultimediaInfo multimediaInfo;
    @JsonProperty("partitionInfo")
    public List<UploadPartitionInfo> partitionInfo;
    @JsonProperty("sameHashExist")
    public boolean sameHashExist;
    @JsonProperty("transcodeInfo")
    public TranscodeInfo transcodeInfo;
    @JsonProperty("uploadTime")
    public long uploadTime;
    @JsonProperty("videoId")
    public String videoId;

    /* compiled from: glCreateShader type= */
    final class C08871 implements Creator<UploadRecord> {
        C08871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            Object obj = null;
            try {
                obj = UploadRecord.m21593a(parcel.readString());
            } catch (Throwable e) {
                BLog.b(UploadRecord.f13830a, "Unable to deserialize class from parcel", e);
            }
            return obj;
        }

        public final Object[] newArray(int i) {
            return new UploadRecord[i];
        }
    }

    private UploadRecord() {
    }

    public UploadRecord(long j, long j2, boolean z) {
        this(j, j2, z, false, "");
    }

    public UploadRecord(MultimediaInfo multimediaInfo) {
        this.fbid = 0;
        this.multimediaInfo = multimediaInfo;
    }

    public UploadRecord(long j, long j2, boolean z, boolean z2, String str) {
        this.fbid = j;
        this.uploadTime = j2;
        this.isRawUpload = z;
        this.sameHashExist = z2;
        this.videoId = str;
        this.partitionInfo = new ArrayList();
        this.transcodeInfo = new TranscodeInfo(0, 0, 0, 0, false, false, false, -2, -2);
    }

    public final String m21594a() {
        return FbObjectMapper.i().a(this);
    }

    public static UploadRecord m21593a(String str) {
        return (UploadRecord) FbObjectMapper.i().a(str, UploadRecord.class);
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeString(m21594a());
        } catch (JsonProcessingException e) {
            BLog.b(f13830a, "Unable to serialize class to write to parcel", e);
        }
    }

    public int describeContents() {
        return 0;
    }
}
