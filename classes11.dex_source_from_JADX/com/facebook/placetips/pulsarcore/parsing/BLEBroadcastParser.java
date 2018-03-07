package com.facebook.placetips.pulsarcore.parsing;

import com.facebook.inject.Assisted;
import com.facebook.placetips.bootstrap.data.BleBroadcast;
import com.facebook.placetips.bootstrap.data.PulsarRecord;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: The Friend Request list is empty */
public class BLEBroadcastParser {
    private final BluetoothAdRecordParser f10722a;
    private final PulsarPacketParser f10723b;
    private final FBLEParser f10724c;

    /* compiled from: The Friend Request list is empty */
    public enum BroadcastType {
        PULSAR,
        FBLE
    }

    /* compiled from: The Friend Request list is empty */
    public class ParsedBroadcast {
        public final BroadcastType f10719a;
        public final Optional<PulsarRecord> f10720b;
        public final Optional<FBLEBroadcast> f10721c;

        ParsedBroadcast(PulsarRecord pulsarRecord) {
            this.f10719a = BroadcastType.PULSAR;
            this.f10720b = Optional.of(pulsarRecord);
            this.f10721c = Absent.INSTANCE;
        }

        ParsedBroadcast(FBLEBroadcast fBLEBroadcast) {
            this.f10719a = BroadcastType.FBLE;
            this.f10720b = Absent.INSTANCE;
            this.f10721c = Optional.of(fBLEBroadcast);
        }
    }

    @Nullable
    public final ParsedBroadcast m11261a(BleBroadcast bleBroadcast) {
        byte[] bArr = bleBroadcast.b;
        List b = Lists.b();
        int i = 0;
        while (i < bArr.length) {
            byte b2 = bArr[i];
            i++;
            if (b2 <= (byte) 0 || i >= bArr.length) {
                break;
            }
            byte b3 = bArr[i];
            int i2 = i + 1;
            if (b3 == (byte) 0 || i2 >= bArr.length) {
                break;
            }
            i = (i2 + b2) - 1;
            if (i > bArr.length) {
                break;
            }
            b.add(new BluetoothAdRecord(b2, b3, Arrays.copyOfRange(bArr, i2, i)));
        }
        List list = b;
        FBLEBroadcast a = this.f10724c.m11263a(list);
        if (a != null) {
            return new ParsedBroadcast(a);
        }
        PulsarRecord a2 = this.f10723b.m11265a(list);
        if (a2 != null) {
            return new ParsedBroadcast(a2);
        }
        return null;
    }

    @Inject
    public BLEBroadcastParser(BluetoothAdRecordParser bluetoothAdRecordParser, PulsarPacketParserProvider pulsarPacketParserProvider, FBLEParser fBLEParser, @Assisted String str) {
        this.f10722a = bluetoothAdRecordParser;
        this.f10723b = new PulsarPacketParser(str);
        this.f10724c = fBLEParser;
    }
}
