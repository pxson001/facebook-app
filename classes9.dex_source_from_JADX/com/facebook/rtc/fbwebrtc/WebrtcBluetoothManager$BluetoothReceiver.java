package com.facebook.rtc.fbwebrtc;

import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: audio/imelody */
public final class WebrtcBluetoothManager$BluetoothReceiver extends DynamicSecureBroadcastReceiver {
    final /* synthetic */ WebrtcBluetoothManager f19383a;

    public WebrtcBluetoothManager$BluetoothReceiver(WebrtcBluetoothManager webrtcBluetoothManager) {
        this.f19383a = webrtcBluetoothManager;
        super(new Builder().b("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED", webrtcBluetoothManager.i).b("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED", webrtcBluetoothManager.i).b());
    }
}
