package com.facebook.rtc.fbwebrtc;

import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.C23056;

/* compiled from: audio/imelody */
public class WebrtcBluetoothManager$1 implements ServiceListener {
    final /* synthetic */ WebrtcBluetoothManager f19382a;

    public WebrtcBluetoothManager$1(WebrtcBluetoothManager webrtcBluetoothManager) {
        this.f19382a = webrtcBluetoothManager;
    }

    public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
        this.f19382a.f = (BluetoothHeadset) bluetoothProfile;
        if (this.f19382a.g != null) {
            C23056 c23056 = this.f19382a.g;
            if (c23056.f19533a.f19579n.b()) {
                WebrtcUiHandler.bb(c23056.f19533a);
            }
            WebrtcUiHandler.bn(c23056.f19533a);
        }
    }

    public void onServiceDisconnected(int i) {
        this.f19382a.f = null;
        this.f19382a.e = null;
        if (this.f19382a.g != null) {
            C23056 c23056 = this.f19382a.g;
            if (c23056.f19533a.be) {
                WebrtcUiHandler.bc(c23056.f19533a);
            }
            WebrtcUiHandler.bn(c23056.f19533a);
        }
    }
}
