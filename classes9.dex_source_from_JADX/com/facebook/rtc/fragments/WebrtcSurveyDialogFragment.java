package com.facebook.rtc.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.common.random.InsecureRandom;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: application/vnd.wap.wtls-user-certificate */
public class WebrtcSurveyDialogFragment extends WebrtcDialogFragment {
    @Inject
    @InsecureRandom
    public Random am;
    private int aq;
    public String ar;
    public int as;
    private boolean at;
    private boolean au;
    private AlertDialog av;
    public Map<String, String> aw;

    /* compiled from: application/vnd.wap.wtls-user-certificate */
    class C23271 implements OnClickListener {
        final /* synthetic */ WebrtcSurveyDialogFragment f19723a;

        C23271(WebrtcSurveyDialogFragment webrtcSurveyDialogFragment) {
            this.f19723a = webrtcSurveyDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f19723a.as = i;
            this.f19723a.an.mo808a(90000);
            this.f19723a.at();
        }
    }

    /* compiled from: application/vnd.wap.wtls-user-certificate */
    class C23282 implements OnClickListener {
        final /* synthetic */ WebrtcSurveyDialogFragment f19724a;

        C23282(WebrtcSurveyDialogFragment webrtcSurveyDialogFragment) {
            this.f19724a = webrtcSurveyDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f19724a.a();
        }
    }

    public static void m19527a(Object obj, Context context) {
        ((WebrtcSurveyDialogFragment) obj).am = Random_InsecureRandomMethodAutoProvider.a(FbInjector.get(context));
    }

    public final void mo817a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 960909462);
        super.mo817a(bundle);
        Class cls = WebrtcSurveyDialogFragment.class;
        m19527a(this, getContext());
        this.aq = this.s.getInt("rating", 0);
        this.at = this.s.getBoolean("use_video", false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1216278265, a);
    }

    public final Dialog m19529c(Bundle bundle) {
        this.an.mo808a(120000);
        if (this.at) {
            this.aw = new HashMap();
            this.aw.put(b(2131232126), "no_video");
            this.aw.put(b(2131232127), "blurry_video");
            this.aw.put(b(2131232128), "frozen_video");
            this.aw.put(b(2131232129), "choppy_video");
            this.aw.put(b(2131232130), "lip_sync");
            this.aw.put(b(2131232131), "shaky_video");
            this.aw.put(b(2131232144), "battery_life");
            this.aw.put(b(2131232145), "device_got_hot");
            this.aw.put(b(2131232146), "audio_quality");
        } else {
            this.aw = new HashMap();
            this.aw.put(b(2131232115), "silent_call");
            this.aw.put(b(2131232116), "audio_dropout");
            this.aw.put(b(2131232117), "call_gaps");
            this.aw.put(b(2131232118), "voice_distortion");
            this.aw.put(b(2131232119), "background_noise");
            this.aw.put(b(2131232120), "echo");
            this.aw.put(b(2131232121), "low_volume");
            this.aw.put(b(2131232122), "latency");
        }
        List linkedList = new LinkedList(this.aw.keySet());
        Collections.shuffle(linkedList, this.am);
        linkedList.add(b(2131232124));
        this.aw.put(b(2131232124), "other");
        final String[] strArr = (String[]) linkedList.toArray(new String[0]);
        this.av = new FbAlertDialogBuilder(this.aq).a(getContext().getString(2131232125)).a(b(2131232062), new OnClickListener(this) {
            final /* synthetic */ WebrtcSurveyDialogFragment f19726b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f19726b.ar = (String) this.f19726b.aw.get(strArr[this.f19726b.as]);
                this.f19726b.a();
            }
        }).b(b(2131232063), new C23282(this)).a(strArr, -1, new C23271(this)).a();
        return this.av;
    }

    final AlertDialog aq() {
        return this.av;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.au) {
            this.au = false;
            return;
        }
        if ("audio_quality".equals(this.ar)) {
            this.an.mo810d(this.aq);
            return;
        }
        if ("other".equals(this.ar)) {
            this.an.mo806a(this.aq, this.ar);
        } else {
            m19519a(this.aq, this.ar, null);
        }
    }

    public final void ar() {
        this.au = true;
        m19519a(this.aq, this.ar, null);
    }
}
