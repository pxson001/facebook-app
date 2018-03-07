package com.facebook.notifications.lockscreenservice;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

@TargetApi(18)
/* compiled from: new */
public class LockScreenDismissKeyguardActivity extends Activity {
    public AbstractFbErrorReporter f8238a;

    /* compiled from: new */
    class C06591 implements OnWindowFocusChangeListener {
        final /* synthetic */ LockScreenDismissKeyguardActivity f8237a;

        C06591(LockScreenDismissKeyguardActivity lockScreenDismissKeyguardActivity) {
            this.f8237a = lockScreenDismissKeyguardActivity;
        }

        public void onWindowFocusChanged(boolean z) {
            if (z) {
                this.f8237a.finish();
            }
        }
    }

    private static <T extends Context> void m9826a(Class<T> cls, T t) {
        m9827a((Object) t, (Context) t);
    }

    private static void m9827a(Object obj, Context context) {
        ((LockScreenDismissKeyguardActivity) obj).f8238a = (AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(context));
    }

    protected void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1236129625);
        super.onCreate(bundle);
        m9826a(LockScreenDismissKeyguardActivity.class, (Context) this);
        getWindow().addFlags(4718592);
        try {
            findViewById(16908290).getViewTreeObserver().addOnWindowFocusChangeListener(new C06591(this));
        } catch (Throwable e) {
            this.f8238a.b(LockScreenDismissKeyguardActivity.class.getSimpleName(), "Error dismissing keyguard", e);
            finish();
        }
        LogUtils.c(-1175206062, a);
    }
}
