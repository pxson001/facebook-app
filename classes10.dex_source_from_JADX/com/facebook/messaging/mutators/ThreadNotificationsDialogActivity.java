package com.facebook.messaging.mutators;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInput;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.widget.Toast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.notify.bridge.NotificationBridge;
import com.facebook.messaging.notify.bridge.NotificationBridgeMethodAutoProvider;
import com.facebook.wear.RemoteInputHelper;
import com.google.common.base.Preconditions;
import java.util.Date;

/* compiled from: rp */
public class ThreadNotificationsDialogActivity extends FbFragmentActivity {
    public RemoteInputHelper f3331p;
    public MessagesNotificationClient f3332q;
    public NotificationBridge f3333r;
    private ThreadKey f3334s;
    private AlertDialog f3335t;
    private boolean f3336u = true;

    /* compiled from: rp */
    class C05391 implements OnDismissListener {
        final /* synthetic */ ThreadNotificationsDialogActivity f3330a;

        C05391(ThreadNotificationsDialogActivity threadNotificationsDialogActivity) {
            this.f3330a = threadNotificationsDialogActivity;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            ThreadNotificationsDialogActivity.m3245i(this.f3330a);
        }
    }

    public static void m3243a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ThreadNotificationsDialogActivity threadNotificationsDialogActivity = (ThreadNotificationsDialogActivity) obj;
        MessagesNotificationClient a = MessagesNotificationClient.a(fbInjector);
        NotificationBridge a2 = NotificationBridgeMethodAutoProvider.a(fbInjector);
        threadNotificationsDialogActivity.f3331p = new RemoteInputHelper();
        threadNotificationsDialogActivity.f3332q = a;
        threadNotificationsDialogActivity.f3333r = a2;
    }

    protected final void m3247b(Bundle bundle) {
        super.b(bundle);
        Class cls = ThreadNotificationsDialogActivity.class;
        m3243a(this, this);
        m3244b(getIntent());
    }

    protected final void m3246a(Intent intent) {
        super.a(intent);
        if (this.f3335t != null) {
            this.f3336u = false;
            this.f3335t.cancel();
        }
        m3244b(intent);
    }

    private void m3244b(Intent intent) {
        CharSequence charSequence;
        this.f3334s = (ThreadKey) intent.getParcelableExtra("thread_key");
        Preconditions.checkNotNull(this.f3334s);
        String str = "voice_reply";
        Bundle a = RemoteInput.g.a(intent);
        if (a != null) {
            charSequence = a.getCharSequence(str);
        } else {
            charSequence = null;
        }
        CharSequence charSequence2 = charSequence;
        if (!TextUtils.isEmpty(charSequence2)) {
            NotificationBridge notificationBridge = this.f3333r;
            charSequence2.toString();
            if (notificationBridge.a()) {
                m3245i(this);
                return;
            }
        }
        this.f3335t = this.f3333r.b();
        this.f3335t.setOnDismissListener(new C05391(this));
        this.f3335t.show();
    }

    public static void m3245i(ThreadNotificationsDialogActivity threadNotificationsDialogActivity) {
        if (threadNotificationsDialogActivity.f3336u) {
            NotificationSetting d = threadNotificationsDialogActivity.f3333r.d();
            if (d != NotificationSetting.a) {
                CharSequence string;
                if (d == NotificationSetting.b) {
                    string = threadNotificationsDialogActivity.getString(2131231531);
                } else {
                    Date date = new Date(d.d * 1000);
                    string = threadNotificationsDialogActivity.getString(2131231532, new Object[]{DateFormat.getTimeFormat(threadNotificationsDialogActivity).format(date)});
                }
                Toast.makeText(threadNotificationsDialogActivity, string, 0).show();
                threadNotificationsDialogActivity.f3332q.a(threadNotificationsDialogActivity.f3334s);
            }
            threadNotificationsDialogActivity.finish();
            return;
        }
        threadNotificationsDialogActivity.f3336u = true;
    }
}
