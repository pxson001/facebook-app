package com.facebook.rtc.dialogs;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.rtc.dialogs.RtcBluetoothSelectorDialog.UpdateButtonsCallback;

/* compiled from: audio/x-mp3 */
public class RtcBluetoothSelectorDialogProvider extends AbstractAssistedProvider<RtcBluetoothSelectorDialog> {
    public final RtcBluetoothSelectorDialog m19341a(Boolean bool, UpdateButtonsCallback updateButtonsCallback) {
        RtcBluetoothSelectorDialog rtcBluetoothSelectorDialog = new RtcBluetoothSelectorDialog((Context) getInstance(Context.class), bool, updateButtonsCallback);
        rtcBluetoothSelectorDialog.f19327e = IdBasedLazy.a(this, 10375);
        return rtcBluetoothSelectorDialog;
    }
}
