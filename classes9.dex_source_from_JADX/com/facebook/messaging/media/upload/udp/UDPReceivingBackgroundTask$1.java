package com.facebook.messaging.media.upload.udp;

import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.debug.log.BLog;
import java.net.DatagramPacket;
import java.util.concurrent.Callable;

/* compiled from: last_delivered_receipt_id */
class UDPReceivingBackgroundTask$1 implements Callable<BackgroundResult> {
    final /* synthetic */ UDPReceivingBackgroundTask f12205a;

    UDPReceivingBackgroundTask$1(UDPReceivingBackgroundTask uDPReceivingBackgroundTask) {
        this.f12205a = uDPReceivingBackgroundTask;
    }

    public Object call() {
        long a = this.f12205a.b.a();
        long j = a + 1000;
        UDPMessageBuilder uDPMessageBuilder = new UDPMessageBuilder();
        long j2 = a;
        while (j2 < j) {
            try {
                byte[] a2 = UDPByteBufferBuilder.m12661a();
                DatagramPacket datagramPacket = new DatagramPacket(a2, a2.length);
                this.f12205a.f.receive(datagramPacket);
                BlockingByteBufferQueue blockingByteBufferQueue = this.f12205a.a;
                a = uDPMessageBuilder.m12642a(a2).m12641a(datagramPacket.getLength()).m12643b();
                blockingByteBufferQueue.a(a);
            } catch (long a3) {
                BLog.b(UDPPacketManager.class, "Error receiving on socket", a3);
                j2 = (a3 - j2) + j2;
            } finally {
                this.f12205a.b.a();
                j2 = (a3 - j2) + j2;
            }
            j2 = (a3 - j2) + j2;
        }
        if (!this.f12205a.a.a()) {
            for (UDPChunkManager a4 : this.f12205a.d) {
                a4.m12675a();
            }
        }
        return new BackgroundResult(true);
    }
}
