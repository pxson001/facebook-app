package com.facebook.placetips.pulsarcore.parsing;

import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import com.facebook.placetips.bootstrap.data.PulsarRecord;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TabsEnabled */
public class PulsarPacketParser {
    @Nullable
    private final UUID f10729a;

    @Inject
    public PulsarPacketParser(@Assisted String str) {
        if (StringUtil.c(str)) {
            this.f10729a = null;
        } else {
            this.f10729a = UUID.fromString(str);
        }
    }

    @Nullable
    public final PulsarRecord m11265a(List<BluetoothAdRecord> list) {
        for (BluetoothAdRecord a : list) {
            PulsarRecord a2 = m11264a(a);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    @Nullable
    private PulsarRecord m11264a(BluetoothAdRecord bluetoothAdRecord) {
        if (bluetoothAdRecord.f10725a != 26 || bluetoothAdRecord.f10726b != (byte) -1) {
            return null;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bluetoothAdRecord.f10727c, 0, 2);
        byte[] copyOfRange2 = Arrays.copyOfRange(bluetoothAdRecord.f10727c, 2, 4);
        byte[] copyOfRange3 = Arrays.copyOfRange(bluetoothAdRecord.f10727c, 4, 20);
        byte[] copyOfRange4 = Arrays.copyOfRange(bluetoothAdRecord.f10727c, 20, 22);
        byte[] copyOfRange5 = Arrays.copyOfRange(bluetoothAdRecord.f10727c, 22, 24);
        int intValue = new BigInteger(1, copyOfRange).intValue();
        int intValue2 = new BigInteger(1, copyOfRange2).intValue();
        ByteBuffer order = ByteBuffer.wrap(copyOfRange3).order(ByteOrder.BIG_ENDIAN);
        UUID uuid = new UUID(order.getLong(), order.getLong());
        int intValue3 = new BigInteger(1, copyOfRange4).intValue();
        int intValue4 = new BigInteger(1, copyOfRange5).intValue();
        if (this.f10729a == null || this.f10729a.equals(uuid)) {
            return new PulsarRecord(intValue, intValue2, uuid, intValue3, intValue4);
        }
        return null;
    }
}
