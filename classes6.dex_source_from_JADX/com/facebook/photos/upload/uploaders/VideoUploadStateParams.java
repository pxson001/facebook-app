package com.facebook.photos.upload.uploaders;

import com.facebook.photos.upload.operation.UploadPartitionInfo;

/* compiled from: friends_locations_feedstory_scroll_left */
class VideoUploadStateParams {
    float f14509a = 0.0f;
    float f14510b = 0.0f;
    long f14511c = 0;

    VideoUploadStateParams() {
    }

    public final void m22105a(long j, long j2, long j3, long j4) {
        this.f14511c = j;
        this.f14510b = this.f14509a;
        this.f14509a = ((float) j2) / ((float) ((j4 - j3) + 1));
    }

    public final void m22104a(long j) {
        this.f14511c = j;
        this.f14510b = this.f14509a;
        this.f14509a = 0.0f;
    }

    public final ChunkUploadProgressStatus m22103a(UploadSessionContext uploadSessionContext, String str) {
        return new ChunkUploadProgressStatus(this.f14511c, this.f14510b, this.f14509a, uploadSessionContext.f14486t, uploadSessionContext.f14487u, str);
    }

    public final ChunkUploadProgressStatus m22102a(UploadPartitionInfo uploadPartitionInfo, String str) {
        return new ChunkUploadProgressStatus(this.f14511c, this.f14510b, this.f14509a, uploadPartitionInfo.chunkedUploadOffset, uploadPartitionInfo.chunkedUploadChunkLength, str);
    }
}
