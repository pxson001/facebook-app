package com.facebook.placetips.bootstrap.data;

import android.bluetooth.BluetoothDevice;
import com.google.common.base.Objects;
import java.math.BigInteger;

/* compiled from: search_pivots */
public class BleBroadcast {
    public final BluetoothDevice f3826a;
    public final byte[] f3827b;
    public final String f3828c;

    public BleBroadcast(BluetoothDevice bluetoothDevice, byte[] bArr) {
        this.f3826a = bluetoothDevice;
        this.f3827b = bArr;
        this.f3828c = new BigInteger(1, bArr).toString(16);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof BleBroadcast) && obj.hashCode() == hashCode();
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f3826a, this.f3828c});
    }
}
