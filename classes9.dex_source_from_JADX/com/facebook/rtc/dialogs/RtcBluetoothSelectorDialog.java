package com.facebook.rtc.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.inject.Assisted;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.AudioOutput;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: auto_photo_download_upsell_shown */
public class RtcBluetoothSelectorDialog {
    private final Context f19323a;
    private final boolean f19324b;
    public final UpdateButtonsCallback f19325c;
    private final Map<AudioOutput, String> f19326d = new HashMap();
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f19327e = UltralightRuntime.b;

    /* compiled from: auto_photo_download_upsell_shown */
    public interface UpdateButtonsCallback {
        void mo774a();
    }

    @Inject
    public RtcBluetoothSelectorDialog(Context context, @Assisted Boolean bool, @Assisted UpdateButtonsCallback updateButtonsCallback) {
        this.f19323a = context;
        this.f19324b = bool.booleanValue();
        this.f19325c = updateButtonsCallback;
        this.f19326d.put(AudioOutput.EARPIECE, this.f19323a.getString(2131231978));
        this.f19326d.put(AudioOutput.SPEAKERPHONE, this.f19323a.getString(2131231976));
        this.f19326d.put(AudioOutput.BLUETOOTH, this.f19323a.getString(2131231975));
        this.f19326d.put(AudioOutput.HEADSET, this.f19323a.getString(2131231977));
    }

    public final void m19340a() {
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        if (((WebrtcUiHandler) this.f19327e.get()).bc) {
            arrayList.add(this.f19326d.get(AudioOutput.HEADSET));
            arrayList2.add(AudioOutput.HEADSET);
        } else if (((WebrtcUiHandler) this.f19327e.get()).bf && this.f19324b) {
            arrayList.add(this.f19326d.get(AudioOutput.EARPIECE));
            arrayList2.add(AudioOutput.EARPIECE);
        }
        arrayList.add(this.f19326d.get(AudioOutput.SPEAKERPHONE));
        arrayList2.add(AudioOutput.SPEAKERPHONE);
        if (((WebrtcUiHandler) this.f19327e.get()).ar()) {
            arrayList.add(this.f19326d.get(AudioOutput.BLUETOOTH));
            arrayList2.add(AudioOutput.BLUETOOTH);
        }
        new FbAlertDialogBuilder(this.f19323a).a((CharSequence[]) arrayList.toArray(new String[arrayList.size()]), new OnClickListener(this) {
            final /* synthetic */ RtcBluetoothSelectorDialog f19322b;

            public void onClick(DialogInterface dialogInterface, int i) {
                ((WebrtcUiHandler) this.f19322b.f19327e.get()).m19453a((AudioOutput) arrayList2.get(i));
                this.f19322b.f19325c.mo774a();
            }
        }).a().show();
    }
}
