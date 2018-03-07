package com.facebook.webrtc;

/* compiled from: serialized_publish_data */
public interface IWebrtcSignalingMessageInterface {
    boolean sendMultiwaySignalingMessage(String str, String str2, String str3, byte[] bArr);

    boolean sendOfferToPeer(String str, long j, long j2, long j3, byte[] bArr);

    boolean sendThriftToPeer(String str, long j, long j2, long j3, byte[] bArr);

    boolean sendThriftToSelf(String str, long j, long j2, byte[] bArr);

    boolean sendToPeer(String str, long j, long j2, long j3, String str2);

    boolean sendToSelf(String str, long j, long j2, String str2);

    void setWebrtcManager(WebrtcManager webrtcManager);
}
