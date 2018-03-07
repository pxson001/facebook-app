package com.facebook.photos.upload.operation;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = UploadPartitionInfoDeserializer.class)
@JsonSerialize(using = UploadPartitionInfoSerializer.class)
/* compiled from: glEnableVertexAttribArray */
public class UploadPartitionInfo {
    @JsonProperty("chunkedUploadChunkLength")
    public long chunkedUploadChunkLength;
    @JsonProperty("chunkedUploadOffset")
    public long chunkedUploadOffset;
    @JsonProperty("partitionEndOffset")
    public long partitionEndOffset;
    @JsonProperty("partitionStartOffset")
    public long partitionStartOffset;

    private UploadPartitionInfo() {
    }

    public UploadPartitionInfo(long j, long j2, long j3, long j4) {
        this.partitionStartOffset = j;
        this.partitionEndOffset = j2;
        this.chunkedUploadOffset = j3;
        this.chunkedUploadChunkLength = j4;
    }
}
