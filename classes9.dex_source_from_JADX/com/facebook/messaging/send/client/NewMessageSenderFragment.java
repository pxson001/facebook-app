package com.facebook.messaging.send.client;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.analytics.base.MessagingAnalyticsConstants.MessageSendTrigger;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.analytics.threads.CreateThreadReliabilityLogger;
import com.facebook.messaging.analytics.threads.CreateThreadReliabilityLogger.CreateThreadSource;
import com.facebook.messaging.media.upload.MediaItemUploadStatus;
import com.facebook.messaging.media.upload.MediaItemUploadStatus.State;
import com.facebook.messaging.media.upload.MediaUploadManager;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.SendMessageByRecipientsParams;
import com.facebook.orca.creation.CreateThreadActivity.1;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: delete_messages */
public class NewMessageSenderFragment extends FbDialogFragment {
    private static final Class<?> am = NewMessageSenderFragment.class;
    private boolean aA;
    private ListenableFuture<FetchThreadResult> aB;
    private DisposableFutureCallback<FetchThreadResult> aC;
    public long aD;
    private long aE;
    public 1 aF;
    public SelfRegistrableReceiverImpl aG;
    private CreateThreadManager an;
    public SendMessageManager ao;
    public MediaUploadManagerImpl ap;
    private OfflineThreadingIdGenerator aq;
    public DefaultThreadKeyFactory ar;
    private ExecutorService as;
    private BaseFbBroadcastManager at;
    public MessagingPerformanceLogger au;
    public Lazy<CreateThreadReliabilityLogger> av;
    public ImmutableList<User> aw;
    public Message ax;
    public String ay;
    public NavigationTrigger az;

    /* compiled from: delete_messages */
    class C19631 implements ActionReceiver {
        final /* synthetic */ NewMessageSenderFragment f16661a;

        C19631(NewMessageSenderFragment newMessageSenderFragment) {
            this.f16661a = newMessageSenderFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1678486516);
            NewMessageSenderFragment.av(this.f16661a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -800334240, a);
        }
    }

    /* compiled from: delete_messages */
    class C19642 extends AbstractDisposableFutureCallback<FetchThreadResult> {
        final /* synthetic */ NewMessageSenderFragment f16662a;

        C19642(NewMessageSenderFragment newMessageSenderFragment) {
            this.f16662a = newMessageSenderFragment;
        }

        public final void m16660a(Object obj) {
            FetchThreadResult fetchThreadResult = (FetchThreadResult) obj;
            NewMessageSenderFragment newMessageSenderFragment = this.f16662a;
            ThreadKey threadKey = fetchThreadResult.f17180c.a;
            ((CreateThreadReliabilityLogger) newMessageSenderFragment.av.get()).m7974a(newMessageSenderFragment.ax.b, newMessageSenderFragment.aD, CreateThreadSource.MULTIPICKER);
            if (newMessageSenderFragment.aF != null) {
                newMessageSenderFragment.aF.a(fetchThreadResult);
            }
            newMessageSenderFragment.b();
        }

        public final void m16661a(Throwable th) {
            NewMessageSenderFragment.m16664a(this.f16662a, false, th);
        }
    }

    public static void m16665a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((NewMessageSenderFragment) obj).m16663a(CreateThreadManager.m16650a(injectorLike), SendMessageManager.m16780a(injectorLike), MediaUploadManagerImpl.a(injectorLike), OfflineThreadingIdGenerator.m16673a(injectorLike), DefaultThreadKeyFactory.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), MessagingPerformanceLogger.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 7518));
    }

    @Inject
    private void m16663a(CreateThreadManager createThreadManager, SendMessageManager sendMessageManager, MediaUploadManager mediaUploadManager, OfflineThreadingIdGenerator offlineThreadingIdGenerator, ThreadKeyFactory threadKeyFactory, ExecutorService executorService, FbBroadcastManager fbBroadcastManager, MessagingPerformanceLogger messagingPerformanceLogger, Lazy<CreateThreadReliabilityLogger> lazy) {
        this.an = createThreadManager;
        this.ao = sendMessageManager;
        this.ap = mediaUploadManager;
        this.aq = offlineThreadingIdGenerator;
        this.ar = threadKeyFactory;
        this.as = executorService;
        this.at = fbBroadcastManager;
        this.au = messagingPerformanceLogger;
        this.av = lazy;
    }

    public final void m16668a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1377126078);
        super.a(bundle);
        Bundle bundle2 = this.s;
        Collection parcelableArrayList = bundle2.getParcelableArrayList("r");
        Preconditions.checkNotNull(parcelableArrayList);
        this.aw = ImmutableList.copyOf(parcelableArrayList);
        this.ax = (Message) bundle2.getParcelable("m");
        this.ay = bundle2.getString("om");
        this.az = (NavigationTrigger) bundle2.getParcelable("t");
        this.aA = bundle2.getBoolean("rtv");
        Class cls = NewMessageSenderFragment.class;
        m16665a(this, getContext());
        d_(true);
        C19631 c19631 = new C19631(this);
        this.aG = this.at.a().a("com.facebook.orca.media.upload.PROCESS_MEDIA_TOTAL_PROGRESS", c19631).a("com.facebook.orca.media.upload.PROCESS_MEDIA_COMPLETE", c19631).a("com.facebook.orca.media.upload.MEDIA_UPLOAD_STATUS_CHANGED", c19631).a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1888971617, a);
    }

    public final Dialog m16669c(Bundle bundle) {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.d = 1;
        progressDialog.a(true);
        progressDialog.setCancelable(true);
        progressDialog.c(100);
        progressDialog.a(a(2131231238));
        progressDialog.a(null);
        return progressDialog;
    }

    public final void m16670d(Bundle bundle) {
        Object obj = 1;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1474212646);
        super.d(bundle);
        if (bundle != null && bundle.containsKey("waitingToCreateThreadId")) {
            this.aE = bundle.getLong("waitingToCreateThreadId");
        }
        Object obj2 = (bundle == null || bundle.containsKey("createThreadId") || this.aw.size() <= 1) ? null : 1;
        if (bundle == null || !bundle.containsKey("createThreadId")) {
            obj = null;
        }
        if (bundle == null || obj2 != null) {
            aq();
        } else if (obj != null) {
            this.aD = bundle.getLong("createThreadId");
            this.aB = this.an.m16653a(this.aD);
            if (this.aB != null) {
                this.aC = ay();
                Futures.a(this.aB, this.aC, this.as);
            } else {
                b();
            }
        } else {
            b();
        }
        LogUtils.f(1034338127, a);
    }

    public final void m16671e(Bundle bundle) {
        super.e(bundle);
        if (this.aE > 0) {
            bundle.putLong("waitingToCreateThreadId", this.aE);
        }
        if (this.aD > 0) {
            bundle.putLong("createThreadId", this.aD);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.aB != null) {
            this.aB.cancel(false);
            this.aB = null;
        }
        this.aG.c();
    }

    public final void m16667I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 199929010);
        super.I();
        this.aG.c();
        if (this.aC != null) {
            this.aC.jc_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -732015157, a);
    }

    private void aq() {
        int i = 1;
        int i2 = !this.aA ? 1 : 0;
        int i3;
        if (this.aw.size() == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (((User) this.aw.get(0)).n() == null) {
            i = 0;
        }
        if (i2 == 0 || r4 == 0 || r2 == 0) {
            ar();
            return;
        }
        ThreadKey a = this.ar.a(((User) this.aw.get(0)).T);
        MessageBuilder a2 = Message.newBuilder().a(this.ax);
        a2.b = a;
        Message R = a2.R();
        this.au.a(R.n);
        this.ao.m16803a(R, this.ay, this.az, MessageSendTrigger.NEW_MESSAGE);
        if (this.aF != null) {
            this.aF.a(a);
        }
        b();
    }

    private void ar() {
        Object obj;
        ImmutableList immutableList = this.ax.t;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (this.ap.c((MediaResource) immutableList.get(i)).f11847b == State.IN_PROGRESS) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            if (this.aE <= 0) {
                this.aE = this.aq.m16675a();
            }
            m16662a(this.ax.b, this.aE, true);
            this.aG.b();
            ((ProgressDialog) this.f).a(false);
            av(this);
            return;
        }
        aw();
    }

    public static void av(NewMessageSenderFragment newMessageSenderFragment) {
        ImmutableList immutableList = newMessageSenderFragment.ax.t;
        int size = immutableList.size();
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            double d2;
            MediaResource mediaResource = (MediaResource) immutableList.get(i2);
            int i4 = i + 1;
            MediaItemUploadStatus c = newMessageSenderFragment.ap.c(mediaResource);
            State state = c.f11847b;
            switch (c.f11847b) {
                case SUCCEEDED:
                    d2 = 1.0d + d;
                    i3++;
                    break;
                case IN_PROGRESS:
                    d2 = newMessageSenderFragment.ap.d(mediaResource) + d;
                    break;
                default:
                    m16664a(newMessageSenderFragment, true, new Exception("Media upload failed"));
                    return;
            }
            i2++;
            d = d2;
            i = i4;
        }
        Integer.valueOf(i3);
        Integer.valueOf(i);
        if (i3 == i) {
            newMessageSenderFragment.aw();
            return;
        }
        ((ProgressDialog) newMessageSenderFragment.f).b((int) ((d / ((double) i)) * 99.0d));
    }

    private void aw() {
        Object obj;
        ImmutableList immutableList = this.ax.t;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (this.ap.c((MediaResource) immutableList.get(i)).f11847b != State.SUCCEEDED) {
                obj = null;
                break;
            }
        }
        obj = 1;
        if (obj == null) {
            m16664a(this, true, new Exception("Media upload failed"));
            return;
        }
        d_(false);
        this.aG.c();
        ProgressDialog progressDialog = (ProgressDialog) this.f;
        progressDialog.b(99);
        if (VERSION.SDK_INT >= 14) {
            progressDialog.a(null);
        }
        progressDialog.a(true);
        Message c = this.ap.c(this.ax);
        List arrayList = new ArrayList();
        int size2 = this.aw.size();
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList.add(((User) this.aw.get(i2)).U);
        }
        SendMessageByRecipientsParams sendMessageByRecipientsParams = new SendMessageByRecipientsParams(null, c, arrayList);
        boolean z = this.aE > 0;
        if (z) {
            this.aD = this.aE;
        } else {
            this.aD = this.aq.m16675a();
        }
        if (!z) {
            m16662a(this.ax.b, this.aD, false);
        }
        this.aB = this.an.m16654a(this.aD, sendMessageByRecipientsParams);
        this.aC = ay();
        Futures.a(this.aB, this.aC, this.as);
    }

    private DisposableFutureCallback<FetchThreadResult> ay() {
        return new C19642(this);
    }

    public static void m16664a(NewMessageSenderFragment newMessageSenderFragment, boolean z, Throwable th) {
        if (z) {
            newMessageSenderFragment.m16666b(newMessageSenderFragment.ax.b, newMessageSenderFragment.aE, true);
        } else {
            newMessageSenderFragment.m16666b(newMessageSenderFragment.ax.b, newMessageSenderFragment.aD, false);
        }
        if (newMessageSenderFragment.aF != null) {
            newMessageSenderFragment.aF.a(th);
        }
        newMessageSenderFragment.b();
    }

    private void m16662a(ThreadKey threadKey, long j, boolean z) {
        ((CreateThreadReliabilityLogger) this.av.get()).m7976a(threadKey, j, CreateThreadSource.MULTIPICKER, z, this.aw.size() + 1);
    }

    private void m16666b(@Nullable ThreadKey threadKey, long j, boolean z) {
        ((CreateThreadReliabilityLogger) this.av.get()).m7975a(threadKey, j, CreateThreadSource.MULTIPICKER, z);
    }
}
