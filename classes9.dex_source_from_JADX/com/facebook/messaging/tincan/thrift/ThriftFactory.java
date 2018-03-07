package com.facebook.messaging.tincan.thrift;

import javax.annotation.Nullable;

/* compiled from: choppy_video */
public class ThriftFactory {
    private static final int f18226a = Constants.f18117a.intValue();

    public static SignalingCollectionAddress m18183a(long j) {
        return new SignalingCollectionAddress(Long.valueOf(j));
    }

    public static MessagingCollectionAddress m18178a(long j, String str) {
        return new MessagingCollectionAddress(Long.valueOf(j), str);
    }

    public static RequestPreKeyBundle m18181a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        return new RequestPreKeyBundle(bArr, bArr2, bArr3, bArr4);
    }

    public static RequestPayload m18180a(RequestPreKeyBundle requestPreKeyBundle) {
        return new RequestPayload(requestPreKeyBundle, null);
    }

    public static Salamander m18182a(int i, SalamanderBody salamanderBody, @Nullable Integer num) {
        Long l;
        if (num == null || num.intValue() == 0) {
            l = null;
        } else {
            l = Long.valueOf(Long.valueOf((long) num.intValue()).longValue() * 1000);
        }
        return new Salamander(Integer.valueOf(i), salamanderBody, null, l);
    }

    public static AcceptPayload m18176a(byte[] bArr) {
        return new AcceptPayload(bArr, null);
    }

    public static Packet m18179a(@Nullable SignalingCollectionAddress signalingCollectionAddress, @Nullable MessagingCollectionAddress messagingCollectionAddress, @Nullable MessagingCollectionAddress messagingCollectionAddress2, long j, int i, PacketBody packetBody, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        return new Packet(Integer.valueOf(f18226a), signalingCollectionAddress, messagingCollectionAddress, messagingCollectionAddress2, Long.valueOf(j), Integer.valueOf(i), packetBody, bArr2, null, bArr, Boolean.valueOf(false));
    }

    public static AttachmentInfo m18177a(byte[] bArr, Long l, Long l2, byte[] bArr2, String str, String str2, byte[] bArr3, ImageMetadata imageMetadata, VideoMetadata videoMetadata) {
        return new AttachmentInfo(bArr, l, l2, bArr2, str, str2, bArr3, imageMetadata, videoMetadata);
    }
}
