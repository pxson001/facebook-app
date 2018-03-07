package com.facebook.messaging.media.upload.udp;

import com.facebook.common.util.StreamUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: last_fetch_pinned_thread_suggestions_time_ms */
public class UDPMessageUtil {

    /* compiled from: last_fetch_pinned_thread_suggestions_time_ms */
    public enum UDPMessageType {
        HOLE,
        CHUNK,
        STUNPING,
        FINISHED,
        OTHER
    }

    public static UDPMessageType m12694a(UDPMessage uDPMessage) {
        int i = ByteBuffer.wrap(uDPMessage.f12150a).order(ByteOrder.LITTLE_ENDIAN).getInt(4);
        if (i == -1) {
            return UDPMessageType.FINISHED;
        }
        if (i >= 0) {
            return UDPMessageType.HOLE;
        }
        return UDPMessageType.OTHER;
    }

    public static String m12697b(UDPMessage uDPMessage) {
        return Long.toString(ByteBuffer.wrap(uDPMessage.f12150a).order(ByteOrder.LITTLE_ENDIAN).getLong(16));
    }

    public static int m12698c(UDPMessage uDPMessage) {
        return ByteBuffer.wrap(uDPMessage.f12150a).order(ByteOrder.LITTLE_ENDIAN).getInt(4);
    }

    public static Set<Integer> m12699d(UDPMessage uDPMessage) {
        ByteBuffer order = ByteBuffer.wrap(uDPMessage.f12150a).order(ByteOrder.LITTLE_ENDIAN);
        Set<Integer> hashSet = new HashSet();
        int i = (uDPMessage.f12151b - 16) / 4;
        order.position(16);
        for (int i2 = 0; i2 < i; i2++) {
            hashSet.add(Integer.valueOf(order.getInt()));
        }
        return hashSet;
    }

    public static Map<UDPUploadSession, List<UDPMessage>> m12696a(List<UDPMessage> list) {
        Map<UDPUploadSession, List<UDPMessage>> hashMap = new HashMap();
        for (UDPMessage uDPMessage : list) {
            ByteBuffer wrap = ByteBuffer.wrap(uDPMessage.f12150a);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            UDPUploadSession uDPUploadSession = new UDPUploadSession(wrap.getInt(0), wrap.getLong(8));
            if (!hashMap.containsKey(uDPUploadSession)) {
                hashMap.put(uDPUploadSession, new ArrayList());
            }
            ((List) hashMap.get(uDPUploadSession)).add(uDPMessage);
        }
        return hashMap;
    }

    public static List<UDPChunk> m12695a(File file, List<Integer> list, int i, UDPUploadSession uDPUploadSession) {
        Collections.sort(list);
        List<UDPChunk> arrayList = new ArrayList();
        InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        UDPMessageBuilder b = new UDPMessageBuilder().m12646c(16).m12644b(i);
        int i2 = -1;
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            long j = (long) (((intValue2 - i2) - 1) * i);
            if (StreamUtil.a(bufferedInputStream, j) < j) {
                throw new IOException("Unable to read chunks from, chunkIDs go pact the end of the file.");
            }
            try {
                byte[] a = UDPByteBufferBuilder.m12661a();
                ByteBuffer wrap = ByteBuffer.wrap(a);
                wrap.clear();
                wrap.order(ByteOrder.LITTLE_ENDIAN).putInt(uDPUploadSession.f12225b).putInt(intValue2).putLong(uDPUploadSession.f12224a);
                i2 = 0;
                while (i2 < i) {
                    int read = bufferedInputStream.read(a, i2 + 16, i - i2);
                    if (read < 0) {
                        break;
                    }
                    i2 += read;
                }
                arrayList.add(b.m12642a(a).m12647d(intValue2).m12645c());
                i2 = intValue2;
            } catch (IOException e) {
                IOException iOException = e;
                for (UDPChunk a2 : arrayList) {
                    UDPByteBufferBuilder.m12660a(a2.m12662a());
                }
                bufferedInputStream.close();
                throw iOException;
            }
        }
        bufferedInputStream.close();
        return arrayList;
    }
}
