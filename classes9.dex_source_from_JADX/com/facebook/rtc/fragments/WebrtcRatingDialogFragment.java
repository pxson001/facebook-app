package com.facebook.rtc.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.facebook.common.random.InsecureRandom;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: application/vnd.wap.xhtml+xml */
public class WebrtcRatingDialogFragment extends WebrtcDialogFragment {
    @Inject
    public QeAccessor am;
    @Inject
    @InsecureRandom
    public Random aq;
    public FbTextView ar;
    public int as = 0;
    public int at;
    private AlertDialog au;
    private boolean av;
    public boolean aw;

    /* compiled from: application/vnd.wap.xhtml+xml */
    class C23241 implements OnClickListener {
        final /* synthetic */ WebrtcRatingDialogFragment f19718a;

        C23241(WebrtcRatingDialogFragment webrtcRatingDialogFragment) {
            this.f19718a = webrtcRatingDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f19718a.a();
        }
    }

    /* compiled from: application/vnd.wap.xhtml+xml */
    class C23252 implements OnClickListener {
        final /* synthetic */ WebrtcRatingDialogFragment f19719a;

        C23252(WebrtcRatingDialogFragment webrtcRatingDialogFragment) {
            this.f19719a = webrtcRatingDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f19719a.as = this.f19719a.at;
            this.f19719a.a();
        }
    }

    public static void m19524a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        WebrtcRatingDialogFragment webrtcRatingDialogFragment = (WebrtcRatingDialogFragment) obj;
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        Random a = Random_InsecureRandomMethodAutoProvider.a(fbInjector);
        webrtcRatingDialogFragment.am = qeAccessor;
        webrtcRatingDialogFragment.aq = a;
    }

    public final void mo817a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -566753447);
        super.mo817a(bundle);
        this.aw = this.s.getBoolean("is_conference", false);
        Class cls = WebrtcRatingDialogFragment.class;
        m19524a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -987498491, a);
    }

    public final Dialog m19526c(Bundle bundle) {
        View inflate = this.aq.getLayoutInflater().inflate(2130907751, null);
        final ViewGroup viewGroup = (ViewGroup) inflate.findViewById(2131568457);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            ((ImageButton) viewGroup.getChildAt(i)).setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WebrtcRatingDialogFragment f19722c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 2073118759);
                    if (this.f19722c.mx_()) {
                        this.f19722c.an.mo808a(90000);
                        this.f19722c.at();
                        int i = i + 1;
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            boolean z;
                            ImageButton imageButton = (ImageButton) viewGroup.getChildAt(i2);
                            if (i2 <= i) {
                                z = true;
                            } else {
                                z = false;
                            }
                            imageButton.setSelected(z);
                            WebrtcRatingDialogFragment webrtcRatingDialogFragment = this.f19722c;
                            if (webrtcRatingDialogFragment.ar != null) {
                                switch (i) {
                                    case 1:
                                        webrtcRatingDialogFragment.ar.setText(webrtcRatingDialogFragment.b(2131232065));
                                        break;
                                    case 2:
                                        webrtcRatingDialogFragment.ar.setText(webrtcRatingDialogFragment.b(2131232066));
                                        break;
                                    case 3:
                                        webrtcRatingDialogFragment.ar.setText(webrtcRatingDialogFragment.b(2131232067));
                                        break;
                                    case 4:
                                        webrtcRatingDialogFragment.ar.setText(webrtcRatingDialogFragment.b(2131232068));
                                        break;
                                    case 5:
                                        webrtcRatingDialogFragment.ar.setText(webrtcRatingDialogFragment.b(2131232069));
                                        break;
                                    default:
                                        webrtcRatingDialogFragment.ar.setText("____");
                                        break;
                                }
                            }
                            this.f19722c.at = i;
                        }
                        LogUtils.a(1623625051, a);
                        return;
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -1319702547, a);
                }
            });
        }
        this.ar = (FbTextView) inflate.findViewById(2131568458);
        this.au = new FbAlertDialogBuilder(this.aq).b(inflate).a(getContext().getString(2131232029)).a(b(2131232062), new C23252(this)).b(b(2131230737), new C23241(this)).a();
        return this.au;
    }

    final AlertDialog aq() {
        return this.au;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.av) {
            this.av = false;
            return;
        }
        int a = this.am.a(Liveness.Cached, ExposureLogging.Off, this.aw ? ExperimentsForRtcModule.dl : ExperimentsForRtcModule.dk, 0);
        int a2 = this.am.a(Liveness.Cached, ExposureLogging.Off, this.aw ? ExperimentsForRtcModule.dj : ExperimentsForRtcModule.di, 0);
        if (this.as <= 0 || this.as > a || this.aq.nextInt(100) >= a2) {
            a2 = 0;
        } else {
            a2 = 1;
        }
        if (a2 != 0) {
            this.an.mo809b(this.as);
        } else {
            m19519a(this.as, null, null);
        }
    }

    public final void ar() {
        this.av = true;
        m19519a(this.as, null, null);
    }
}
