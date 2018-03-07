package com.google.protobuf;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.MessageLite.Builder;

/* compiled from: android.hardware.audio.low_latency */
public interface Message$Builder extends Builder, MessageOrBuilder {
    Message$Builder mo861a(FieldDescriptor fieldDescriptor, Object obj);

    Message$Builder mo847b(ByteString byteString, ExtensionRegistryLite extensionRegistryLite);

    Message$Builder mo864b(FieldDescriptor fieldDescriptor, Object obj);

    Message$Builder mo865b(UnknownFieldSet unknownFieldSet);

    Message$Builder mo849c(AbstractMessage abstractMessage);

    Message$Builder mo867c(FieldDescriptor fieldDescriptor);

    Descriptor mo841e();

    AbstractMessage mo874h();

    AbstractMessage mo875i();
}
