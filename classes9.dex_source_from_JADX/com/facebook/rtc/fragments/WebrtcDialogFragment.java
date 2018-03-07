package com.facebook.rtc.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.ui.dialogs.FbDialogFragment;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: auto focusing error */
public abstract class WebrtcDialogFragment extends FbDialogFragment {
    private static final Class<?> am = WebrtcDialogFragment.class;
    WebrtcSurveyListener an;
    Button ao;
    @Inject
    public Lazy<WebrtcLoggingHandler> ap;
    public Activity aq;

    /* compiled from: auto focusing error */
    public interface WebrtcSurveyListener {
        void mo806a(int i, String str);

        void mo807a(int i, @Nullable String str, @Nullable String str2);

        void mo808a(long j);

        void mo809b(int i);

        void mo810d(int i);
    }

    public static void m19518a(Object obj, Context context) {
        ((WebrtcDialogFragment) obj).ap = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 3344);
    }

    abstract AlertDialog aq();

    public abstract void ar();

    public void mo817a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1453981215);
        super.a(bundle);
        Class cls = WebrtcDialogFragment.class;
        m19518a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -639100184, a);
    }

    public final void a_(Context context) {
        super.a_(context);
        if (context instanceof Activity) {
            this.aq = (Activity) context;
        }
        if (context instanceof WebrtcSurveyListener) {
            this.an = (WebrtcSurveyListener) context;
        }
    }

    final void at() {
        if (this.ao != null) {
            this.ao.setEnabled(true);
        }
    }

    public final void au() {
        this.ao = aq().a(-1);
        this.ao.setEnabled(false);
    }

    final void m19519a(int i, String str, String str2) {
        if (this.an != null) {
            this.an.mo807a(i, str, str2);
            return;
        }
        int i2;
        int i3 = i > 0 ? 1 : 0;
        if (str != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        i3 += i2;
        if (str2 != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ((WebrtcLoggingHandler) this.ap.get()).logCallAction(0, 0, "survey_no_listener", String.valueOf(i2 + i3));
        BLog.a(am, "Attempting to flush survey results but there is no listener set up. code: %d", new Object[]{Integer.valueOf(i2)});
    }
}
