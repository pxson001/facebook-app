package com.facebook.placetips.pulsarcore.parsing;

import java.math.BigInteger;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: TabsPreloadNumber */
public class FBLEParser {
    @Nullable
    public final FBLEBroadcast m11263a(List<BluetoothAdRecord> list) {
        int i = 0;
        for (BluetoothAdRecord bluetoothAdRecord : list) {
            if (i == 0) {
                int i2 = 1;
                if (bluetoothAdRecord.f10725a != 3 || bluetoothAdRecord.f10726b != (byte) 3 || bluetoothAdRecord.f10727c.length != 2) {
                    i2 = 0;
                } else if (bluetoothAdRecord.f10727c[0] != (byte) -72 || bluetoothAdRecord.f10727c[1] != (byte) -2) {
                    i2 = 0;
                }
                i = i2;
            } else {
                FBLEBroadcast fBLEBroadcast;
                if (bluetoothAdRecord.f10725a == 23 && bluetoothAdRecord.f10726b == (byte) -1 && bluetoothAdRecord.f10727c[0] == (byte) -85 && bluetoothAdRecord.f10727c[1] == (byte) 1) {
                    String bigInteger = new BigInteger(1, bluetoothAdRecord.f10727c).toString(16);
                    while (bigInteger.length() < bluetoothAdRecord.f10727c.length * 2) {
                        bigInteger = "0" + bigInteger;
                    }
                    fBLEBroadcast = new FBLEBroadcast(bigInteger);
                } else {
                    fBLEBroadcast = null;
                }
                return fBLEBroadcast;
            }
        }
        return null;
    }
}
