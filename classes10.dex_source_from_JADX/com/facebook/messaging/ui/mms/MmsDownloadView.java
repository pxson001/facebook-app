package com.facebook.messaging.ui.mms;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.sms.analytics.SmsCallerContext;
import com.facebook.messaging.sms.common.MmsSmsIdUtils;
import com.facebook.messaging.sms.defaultapp.MmsDownloadManager;
import com.facebook.messaging.sms.defaultapp.MmsDownloadManager.ErrorCode;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.messaging.sms.defaultapp.SmsReceiver;
import com.facebook.messaging.sms.util.TelephonyUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_list_id */
public class MmsDownloadView extends CustomViewGroup {
    @Inject
    MmsDownloadManager f4860a;
    @Inject
    @ForUiThread
    ListeningExecutorService f4861b;
    @Inject
    Lazy<Toaster> f4862c;
    @Inject
    SmsDefaultAppManager f4863d;
    private Message f4864e;
    private ImageView f4865f;
    private TextView f4866g;
    private TextView f4867h;

    /* compiled from: place_list_id */
    class C06631 implements OnClickListener {
        final /* synthetic */ MmsDownloadView f4857a;

        C06631(MmsDownloadView mmsDownloadView) {
            this.f4857a = mmsDownloadView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1249521137);
            this.f4857a.m4395b();
            Logger.a(2, EntryType.UI_INPUT_END, -1330535580, a);
        }
    }

    /* compiled from: place_list_id */
    class C06642 implements Runnable {
        final /* synthetic */ MmsDownloadView f4858a;

        C06642(MmsDownloadView mmsDownloadView) {
            this.f4858a = mmsDownloadView;
        }

        public void run() {
            this.f4858a.m4395b();
        }
    }

    /* compiled from: place_list_id */
    class C06653 implements FutureCallback {
        final /* synthetic */ MmsDownloadView f4859a;

        C06653(MmsDownloadView mmsDownloadView) {
            this.f4859a = mmsDownloadView;
        }

        public void onSuccess(@Nullable Object obj) {
            if (obj != null) {
                ErrorCode errorCode = (ErrorCode) obj;
                if (errorCode == ErrorCode.MESSAGE_NOT_FOUND) {
                    ((Toaster) this.f4859a.f4862c.get()).b(new ToastBuilder(2131232340));
                } else if (errorCode == ErrorCode.MESSAGE_EXPIRED) {
                    ((Toaster) this.f4859a.f4862c.get()).b(new ToastBuilder(2131232341));
                } else if (errorCode == ErrorCode.OTHER) {
                    ((Toaster) this.f4859a.f4862c.get()).b(new ToastBuilder(2131232339));
                    MmsDownloadView.m4397c(this.f4859a);
                }
            }
        }

        public void onFailure(Throwable th) {
            BLog.c("MmsDownloadView", "startDownload()", th);
        }
    }

    private static <T extends View> void m4393a(Class<T> cls, T t) {
        m4394a((Object) t, t.getContext());
    }

    private static void m4394a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MmsDownloadView) obj).m4391a(MmsDownloadManager.a(fbInjector), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 3588), SmsDefaultAppManager.a(fbInjector));
    }

    public MmsDownloadView(Context context) {
        this(context, null);
    }

    public MmsDownloadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MmsDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4390a();
    }

    private void m4390a() {
        m4393a(MmsDownloadView.class, (View) this);
        setContentView(2130905290);
        this.f4866g = (TextView) getView(2131563898);
        this.f4865f = (ImageView) getView(2131563897);
        this.f4867h = (TextView) getView(2131563899);
    }

    public void setMessage(Message message) {
        Preconditions.checkArgument(message.L.a());
        this.f4864e = message;
        this.f4865f.setOnClickListener(new C06631(this));
        String formatDateTime = DateUtils.formatDateTime(getContext(), this.f4864e.L.b, 65560);
        String formatDateTime2 = DateUtils.formatDateTime(getContext(), this.f4864e.L.b, 18945);
        this.f4867h.setText(getResources().getString(2131232337, new Object[]{formatDateTime, formatDateTime2}));
        MmsDownloadManager mmsDownloadManager = this.f4860a;
        if (mmsDownloadManager.a.containsKey(message.a)) {
            this.f4866g.setText(2131232338);
            this.f4865f.setClickable(false);
            return;
        }
        m4397c(this);
    }

    private void m4395b() {
        if (this.f4863d.a(this.f4864e.b)) {
            this.f4863d.a(SmsCallerContext.DOWNLOAD_MESSAGE, new C06642(this));
        } else if (TelephonyUtils.d(getContext())) {
            ((Toaster) this.f4862c.get()).b(new ToastBuilder(2131232342));
        } else if (TelephonyUtils.c(getContext())) {
            MmsDownloadManager mmsDownloadManager = this.f4860a;
            String str = this.f4864e.a;
            SettableFuture settableFuture = (SettableFuture) mmsDownloadManager.a.get(str);
            if (settableFuture == null) {
                settableFuture = SettableFuture.f();
                mmsDownloadManager.a.put(str, settableFuture);
                Intent intent = new Intent(mmsDownloadManager.b, SmsReceiver.class);
                intent.setAction("com.facebook.messaging.sms.DOWNLOAD_MMS");
                intent.putExtra("extra_uri", MmsSmsIdUtils.b(str));
                mmsDownloadManager.b.sendBroadcast(intent);
            }
            Futures.a(settableFuture, new C06653(this), this.f4861b);
            this.f4865f.setClickable(false);
            this.f4866g.setText(2131232338);
        } else {
            ((Toaster) this.f4862c.get()).b(new ToastBuilder(2131232343));
        }
    }

    private void m4391a(MmsDownloadManager mmsDownloadManager, ListeningExecutorService listeningExecutorService, Lazy<Toaster> lazy, SmsDefaultAppManager smsDefaultAppManager) {
        this.f4860a = mmsDownloadManager;
        this.f4861b = listeningExecutorService;
        this.f4862c = lazy;
        this.f4863d = smsDefaultAppManager;
    }

    public static void m4397c(MmsDownloadView mmsDownloadView) {
        mmsDownloadView.f4866g.setText(mmsDownloadView.getResources().getString(2131232334, new Object[]{mmsDownloadView.m4389a(mmsDownloadView.f4864e.L.c)}));
        mmsDownloadView.f4865f.setClickable(true);
    }

    private String m4389a(long j) {
        return getResources().getString(2131232336, new Object[]{Long.valueOf(((j + 1024) - 1) / 1024)});
    }
}
