package com.facebook.messaging.attribution;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.chatheads.ipc.ChatHeadsIntent;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.neue.activitybridge.NeueActivityBridge;
import com.facebook.messaging.neue.activitybridge.NeueActivityBridgeMethodAutoProvider;
import com.facebook.messaging.sharing.mediapreview.MediaCheckHelper;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: p2p_%d */
public class ChatHeadsReplyFlowHandlerActivity extends Activity {
    private static final Class<?> f7798h = ChatHeadsReplyFlowHandlerActivity.class;
    @Inject
    Context f7799a;
    @Inject
    SecureContextHelper f7800b;
    @Inject
    NeueActivityBridge f7801c;
    @Inject
    @LoggedInUserId
    @NeedsApplicationInjector
    Provider<String> f7802d;
    @Inject
    MediaCheckHelper f7803e;
    @Inject
    @ForUiThread
    Executor f7804f;
    @Inject
    AbstractFbErrorReporter f7805g;
    private Intent f7806i;
    private ThreadKey f7807j;
    public ProgressDialog f7808k;

    public static void m8043a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ChatHeadsReplyFlowHandlerActivity) obj).m8041a((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), NeueActivityBridgeMethodAutoProvider.m13094a(injectorLike), IdBasedProvider.a(injectorLike.getApplicationInjector(), 4442), MediaCheckHelper.m17375b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    protected void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1390326424);
        super.onCreate(bundle);
        Class cls = ChatHeadsReplyFlowHandlerActivity.class;
        m8043a((Object) this, (Context) this);
        Intent intent = getIntent();
        this.f7806i = (Intent) intent.getParcelableExtra("external_intent");
        this.f7807j = (ThreadKey) intent.getParcelableExtra("thread_key");
        this.f7800b.b(this.f7806i, 1003, this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 912241032, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1003) {
            Integer.valueOf(i);
            m8040a();
        } else if (i2 == -1) {
            this.f7808k = new ProgressDialog(this);
            this.f7808k.d = 1;
            this.f7808k.a(true);
            this.f7808k.setCancelable(true);
            this.f7808k.a(getString(2131230739));
            this.f7808k.a(null);
            this.f7808k.a(null);
            this.f7808k.show();
            m8044b(intent);
        } else {
            m8042a(this, m8038a(this.f7807j));
        }
    }

    private void m8041a(Context context, SecureContextHelper secureContextHelper, NeueActivityBridge neueActivityBridge, Provider<String> provider, MediaCheckHelper mediaCheckHelper, Executor executor, FbErrorReporter fbErrorReporter) {
        this.f7799a = context;
        this.f7800b = secureContextHelper;
        this.f7801c = neueActivityBridge;
        this.f7802d = provider;
        this.f7803e = mediaCheckHelper;
        this.f7804f = executor;
        this.f7805g = fbErrorReporter;
    }

    public static void m8042a(ChatHeadsReplyFlowHandlerActivity chatHeadsReplyFlowHandlerActivity, Intent intent) {
        chatHeadsReplyFlowHandlerActivity.f7799a.startService(intent);
        chatHeadsReplyFlowHandlerActivity.m8040a();
    }

    private void m8040a() {
        moveTaskToBack(true);
        finish();
    }

    private void m8044b(@Nullable Intent intent) {
        ListenableFuture a;
        int i = 2131240039;
        int i2 = 2131240037;
        int i3 = 2131240040;
        if (intent != null) {
            MediaResource C = this.f7803e.m17377a(intent.getData(), (Uri) intent.getParcelableExtra("com.facebook.orca.extra.EXTERNAL_URI"), intent.getType()).C();
            if (C != null) {
                a = this.f7803e.m17378a(ImmutableList.of(C));
            } else {
                a = Futures.a(new IllegalArgumentException("Got a media resource with an unidentifiable mime type"));
                i = 2131240034;
                i2 = 2131240035;
                i3 = 2131240036;
            }
        } else {
            a = Futures.a(new IllegalArgumentException(this.f7806i.getPackage() + " returned with RESULT_OK but with no data."));
        }
        Futures.a(a, m8039a(intent, i, i2, i3), this.f7804f);
    }

    private FutureCallback<List<MediaResource>> m8039a(@Nullable Intent intent, int i, int i2, int i3) {
        final Intent a = m8038a(this.f7807j);
        final Intent intent2 = intent;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        return new FutureCallback<List<MediaResource>>(this) {
            final /* synthetic */ ChatHeadsReplyFlowHandlerActivity f7797f;

            /* compiled from: p2p_%d */
            class C08601 implements OnClickListener {
                final /* synthetic */ C08611 f7791a;

                C08601(C08611 c08611) {
                    this.f7791a = c08611;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    ChatHeadsReplyFlowHandlerActivity.m8042a(this.f7791a.f7797f, a);
                }
            }

            public void onSuccess(Object obj) {
                List list = (List) obj;
                Preconditions.checkArgument(list.size() == 1);
                intent2.setDataAndType(((MediaResource) list.get(0)).c, intent2.getType());
                intent2.putExtra("IS_URI_COPIED", true);
                a.putExtra(ChatHeadsIntent.s, intent2);
                ChatHeadsReplyFlowHandlerActivity.m8045c(this.f7797f);
                ChatHeadsReplyFlowHandlerActivity.m8042a(this.f7797f, a);
            }

            public void onFailure(Throwable th) {
                ChatHeadsReplyFlowHandlerActivity.m8045c(this.f7797f);
                this.f7797f.f7805g.a("ChatHeadsReplyFlowHandlerActivity", th);
                new FbAlertDialogBuilder(this.f7797f).a(i4).b(i5).a(i6, new C08601(this)).a(false).b();
            }
        };
    }

    public static void m8045c(ChatHeadsReplyFlowHandlerActivity chatHeadsReplyFlowHandlerActivity) {
        if (chatHeadsReplyFlowHandlerActivity.f7808k != null && chatHeadsReplyFlowHandlerActivity.f7808k.isShowing()) {
            chatHeadsReplyFlowHandlerActivity.f7808k.dismiss();
        }
    }

    private Intent m8038a(ThreadKey threadKey) {
        Intent a = this.f7801c.m13093a();
        a.setAction(ChatHeadsIntent.e);
        a.putExtra(ChatHeadsIntent.r, threadKey.toString());
        a.putExtra(ChatHeadsIntent.o, "reply_flow");
        a.putExtra(ChatHeadsIntent.m, (String) this.f7802d.get());
        return a;
    }
}
