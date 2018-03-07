package com.facebook.messaging.media.upload.udp;

import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.debug.log.BLog;
import java.net.DatagramPacket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* compiled from: last_confirmed_number */
class UDPSendingBackgroundTask$1 implements Callable<BackgroundResult> {
    final /* synthetic */ UDPSendingBackgroundTask f12206a;

    UDPSendingBackgroundTask$1(UDPSendingBackgroundTask uDPSendingBackgroundTask) {
        this.f12206a = uDPSendingBackgroundTask;
    }

    public Object call() {
        Object<UDPMessage> arrayList = new ArrayList();
        this.f12206a.a.a(arrayList);
        SocketAddress socketAddress = (SocketAddress) this.f12206a.d.get();
        for (UDPMessage uDPMessage : arrayList) {
            DatagramPacket datagramPacket = new DatagramPacket(uDPMessage.m12662a(), uDPMessage.m12663b());
            datagramPacket.setSocketAddress(socketAddress);
            try {
                this.f12206a.c.send(datagramPacket);
            } catch (Throwable e) {
                BLog.b(UDPSendingBackgroundTask.class, "Error sending to socket " + socketAddress.toString(), e);
            } finally {
                UDPByteBufferBuilder.m12660a(uDPMessage.m12662a());
            }
        }
        return new BackgroundResult(true);
    }
}
