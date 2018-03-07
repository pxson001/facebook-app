package com.facebook.messaging.sms.defaultapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android_src.mmsv2.MmsManager;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.Looper_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.threadkey.SmsThreadKeyUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.sms.SmsThreadManager;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.common.Constants.MmsSmsErrorType;
import com.facebook.messaging.sms.common.MmsSmsIdUtils;
import com.facebook.messaging.sms.defaultapp.action.ProcessDownloadMmsAction;
import com.facebook.messaging.sms.defaultapp.action.ProcessMmsDownloadedAction;
import com.facebook.messaging.sms.defaultapp.action.ProcessMmsReceivedAction;
import com.facebook.messaging.sms.defaultapp.action.ProcessMmsSentAction;
import com.facebook.messaging.sms.defaultapp.action.ProcessSendMmsAction;
import com.facebook.messaging.sms.defaultapp.action.ProcessSendSmsAction;
import com.facebook.messaging.sms.defaultapp.action.ProcessSmsReceivedAction;
import com.facebook.messaging.sms.defaultapp.action.ProcessSmsSentAction;
import com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue;
import com.facebook.messaging.sms.defaultapp.send.PendingSendMessage;
import com.facebook.messaging.sms.defaultapp.send.SendRetryController;
import com.google.common.base.Strings;
import java.util.Collections;
import java.util.HashSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: com.facebook.platform.PlatformCanonicalProfileIdActivity */
public class SmsHandler extends Handler {
    private static final Uri f17594a = Uri.parse(MessengerLinks.b + "smsreply");
    private static final Object f17595r = new Object();
    private final Context f17596b;
    private final SmsThreadManager f17597c;
    private final MmsSmsPendingMessagesMarker f17598d;
    private final SecureContextHelper f17599e;
    private final SmsTakeoverAnalyticsLogger f17600f;
    private final ProcessSendSmsAction f17601g;
    private final ProcessSendMmsAction f17602h;
    private final ProcessSmsSentAction f17603i;
    private final ProcessMmsSentAction f17604j;
    private final ProcessSmsReceivedAction f17605k;
    private final ProcessMmsReceivedAction f17606l;
    private final ProcessDownloadMmsAction f17607m;
    private final ProcessMmsDownloadedAction f17608n;
    private final MmsSmsPendingSendQueue f17609o;
    private final SendRetryController f17610p;
    public Service f17611q;

    private static SmsHandler m17580b(InjectorLike injectorLike) {
        return new SmsHandler(Looper_ForNonUiThreadMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), SmsThreadManager.m17473a(injectorLike), MmsSmsPendingMessagesMarker.m17541a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SmsTakeoverAnalyticsLogger.a(injectorLike), ProcessSendSmsAction.m17624a(injectorLike), ProcessSendMmsAction.m17620a(injectorLike), ProcessSmsSentAction.m17634a(injectorLike), ProcessMmsSentAction.m17618a(injectorLike), ProcessSmsReceivedAction.m17629a(injectorLike), ProcessMmsReceivedAction.m17615a(injectorLike), ProcessDownloadMmsAction.m17602a(injectorLike), ProcessMmsDownloadedAction.m17607a(injectorLike), MmsSmsPendingSendQueue.m17644a(injectorLike), SendRetryController.m17669a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sms.defaultapp.SmsHandler m17576a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f17595r;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m17580b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17595r;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.defaultapp.SmsHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sms.defaultapp.SmsHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f17595r;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.defaultapp.SmsHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.defaultapp.SmsHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.defaultapp.SmsHandler");
    }

    @Inject
    SmsHandler(Looper looper, Context context, SmsThreadManager smsThreadManager, MmsSmsPendingMessagesMarker mmsSmsPendingMessagesMarker, SecureContextHelper secureContextHelper, SmsTakeoverAnalyticsLogger smsTakeoverAnalyticsLogger, ProcessSendSmsAction processSendSmsAction, ProcessSendMmsAction processSendMmsAction, ProcessSmsSentAction processSmsSentAction, ProcessMmsSentAction processMmsSentAction, ProcessSmsReceivedAction processSmsReceivedAction, ProcessMmsReceivedAction processMmsReceivedAction, ProcessDownloadMmsAction processDownloadMmsAction, ProcessMmsDownloadedAction processMmsDownloadedAction, MmsSmsPendingSendQueue mmsSmsPendingSendQueue, SendRetryController sendRetryController) {
        super(looper);
        this.f17596b = context;
        this.f17597c = smsThreadManager;
        this.f17598d = mmsSmsPendingMessagesMarker;
        this.f17599e = secureContextHelper;
        this.f17600f = smsTakeoverAnalyticsLogger;
        this.f17601g = processSendSmsAction;
        this.f17602h = processSendMmsAction;
        this.f17603i = processSmsSentAction;
        this.f17604j = processMmsSentAction;
        this.f17605k = processSmsReceivedAction;
        this.f17606l = processMmsReceivedAction;
        this.f17607m = processDownloadMmsAction;
        this.f17608n = processMmsDownloadedAction;
        this.f17609o = mmsSmsPendingSendQueue;
        this.f17610p = sendRetryController;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r8) {
        /*
        r7 = this;
        if (r8 == 0) goto L_0x0006;
    L_0x0002:
        r0 = r8.obj;
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r8.obj;
        r0 = (android.content.Intent) r0;
        r1 = r8.arg1;
        java.lang.Integer.valueOf(r1);
        r2 = r0.getAction();
        r3 = r7.f17598d;	 Catch:{ Exception -> 0x0036 }
        r3.m17545b();	 Catch:{ Exception -> 0x0036 }
        r3 = "com.facebook.messaging.sms.REQUEST_SEND_MESSAGE";
        r3 = r3.equals(r2);	 Catch:{ Exception -> 0x0036 }
        if (r3 == 0) goto L_0x002a;
    L_0x0021:
        r7.m17577a();	 Catch:{ Exception -> 0x0036 }
    L_0x0024:
        r0 = r7.f17611q;
        com.facebook.messaging.sms.defaultapp.SmsActionReceiver.m17566a(r0, r1);
        goto L_0x0006;
    L_0x002a:
        r3 = "com.facebook.messaging.sms.MESSAGE_SENT";
        r3 = r3.equals(r2);	 Catch:{  }
        if (r3 == 0) goto L_0x0047;
    L_0x0032:
        r7.m17582c(r0);	 Catch:{  }
        goto L_0x0024;
    L_0x0036:
        r0 = move-exception;
        r2 = "SmsHandler";
        r3 = "Exception in sms handling.";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0053 }
        com.facebook.debug.log.BLog.c(r2, r0, r3, r4);	 Catch:{ all -> 0x0053 }
        r0 = r7.f17611q;
        com.facebook.messaging.sms.defaultapp.SmsActionReceiver.m17566a(r0, r1);
        goto L_0x0006;
    L_0x0047:
        r3 = "android.provider.Telephony.SMS_DELIVER";
        r3 = r3.equals(r2);	 Catch:{  }
        if (r3 == 0) goto L_0x005a;
    L_0x004f:
        r7.m17583d(r0);	 Catch:{  }
        goto L_0x0024;
    L_0x0053:
        r0 = move-exception;
        r2 = r7.f17611q;
        com.facebook.messaging.sms.defaultapp.SmsActionReceiver.m17566a(r2, r1);
        throw r0;
    L_0x005a:
        r3 = "android.provider.Telephony.WAP_PUSH_DELIVER";
        r3 = r3.equals(r2);	 Catch:{  }
        if (r3 == 0) goto L_0x0066;
    L_0x0062:
        r7.m17584e(r0);	 Catch:{  }
        goto L_0x0024;
    L_0x0066:
        r3 = "com.facebook.messaging.sms.DOWNLOAD_MMS";
        r3 = r3.equals(r2);	 Catch:{  }
        if (r3 == 0) goto L_0x0072;
    L_0x006e:
        r7.m17585f(r0);	 Catch:{  }
        goto L_0x0024;
    L_0x0072:
        r3 = "com.facebook.messaging.sms.MMS_DOWNLOADED";
        r3 = r3.equals(r2);	 Catch:{  }
        if (r3 == 0) goto L_0x007e;
    L_0x007a:
        r7.m17586g(r0);	 Catch:{  }
        goto L_0x0024;
    L_0x007e:
        r3 = "com.facebook.messaging.sms.COMPOSE_SMS";
        r3 = r3.equals(r2);	 Catch:{  }
        if (r3 == 0) goto L_0x008a;
    L_0x0086:
        r7.m17578a(r0);	 Catch:{  }
        goto L_0x0024;
    L_0x008a:
        r3 = "com.facebook.messaging.sms.HEADLESS_SEND";
        r3 = r3.equals(r2);	 Catch:{  }
        if (r3 == 0) goto L_0x0096;
    L_0x0092:
        r7.m17581b(r0);	 Catch:{  }
        goto L_0x0024;
    L_0x0096:
        r3 = "com.facebook.messaging.sms.E2E_TEST_RECEIVING_SMS";
        r3 = r3.equals(r2);	 Catch:{  }
        if (r3 == 0) goto L_0x00a2;
    L_0x009e:
        r7.m17587h(r0);	 Catch:{  }
        goto L_0x0024;
    L_0x00a2:
        r3 = "com.facebook.messaging.sms.MARK_PENDING_MMS";
        r2 = r3.equals(r2);	 Catch:{  }
        if (r2 != 0) goto L_0x0024;
    L_0x00aa:
        r2 = "SmsHandler";
        r3 = "Unknown action to handle: serviceId %d, intent %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{  }
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r1);	 Catch:{  }
        r4[r5] = r6;	 Catch:{  }
        r5 = 1;
        r4[r5] = r0;	 Catch:{  }
        com.facebook.debug.log.BLog.b(r2, r3, r4);	 Catch:{  }
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.defaultapp.SmsHandler.handleMessage(android.os.Message):void");
    }

    private void m17578a(Intent intent) {
        String stringExtra = intent.getStringExtra("addresses");
        String stringExtra2 = intent.getStringExtra("message");
        Uri parse = Uri.parse(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.A, Long.toString(m17575a(stringExtra).b)));
        Intent intent2 = new Intent(MessagingIntentUris.a);
        intent2.setData(parse);
        intent2.setFlags(268435456);
        intent2.putExtra("focus_compose", true);
        intent2.putExtra("show_composer", true);
        intent2.putExtra("composer_initial_text", stringExtra2);
        intent2.putExtra("modify_backstack_override", false);
        this.f17599e.a(intent2, this.f17596b);
    }

    private void m17581b(Intent intent) {
        String stringExtra = intent.getStringExtra("addresses");
        String stringExtra2 = intent.getStringExtra("message");
        ThreadKey a = m17575a(stringExtra);
        Intent intent2 = new Intent("com.facebook.messaging.sms.HEADLESS_SEND");
        intent2.setData(f17594a);
        intent2.setFlags(268435456);
        intent2.putExtra("thread_key", a);
        intent2.putExtra("text", stringExtra2);
        this.f17599e.a(intent2, this.f17596b);
    }

    private ThreadKey m17575a(String str) {
        Object hashSet = new HashSet();
        Collections.addAll(hashSet, str.split(","));
        return ThreadKey.b(SmsThreadKeyUtil.a(this.f17596b, hashSet));
    }

    private void m17577a() {
        if (!this.f17610p.m17675a()) {
            PendingSendMessage b = this.f17609o.m17653b();
            if (b != null) {
                try {
                    String a = b.m17663a();
                    if (MmsSmsIdUtils.m17502c(a)) {
                        this.f17601g.m17627a(b);
                    } else if (MmsSmsIdUtils.m17503d(a)) {
                        this.f17602h.m17623a(b);
                    } else {
                        throw new IllegalArgumentException("Unknown message id type to send " + a);
                    }
                } catch (Exception e) {
                    this.f17609o.m17654b(b.m17663a(), b.m17664b());
                    throw e;
                }
            }
        }
    }

    private void m17582c(Intent intent) {
        Uri data = intent.getData();
        PendingSendMessage a = PendingSendMessage.m17661a(intent.getExtras());
        int intExtra = intent.getIntExtra("result_code", -1);
        MmsSmsErrorType mmsSmsErrorType = (MmsSmsErrorType) intent.getSerializableExtra("mmssms_quickfail_type");
        try {
            boolean c = MmsSmsIdUtils.m17502c(a.m17663a());
            MmsSmsErrorType a2 = mmsSmsErrorType != null ? mmsSmsErrorType : c ? MmsSmsErrorHelper.m17534a(intExtra) : MmsSmsErrorHelper.m17536b(intExtra);
            intent.putExtra("mmssms_error_type", a2);
            if (SendRetryController.m17670a(a2, a)) {
                this.f17610p.m17674a(a);
                return;
            }
            Message a3 = c ? this.f17603i.m17635a(data, intent.getExtras()) : this.f17604j.m17619a(data, intent.getExtras());
            if (a3 != null) {
                boolean z;
                String stringExtra = intent.getStringExtra("mmssms_quickfail_msg");
                if (mmsSmsErrorType == null) {
                    stringExtra = c ? MmsSmsErrorHelper.m17535a(intExtra, intent.getIntExtra("errorCode", 0)) : MmsSmsErrorHelper.m17538b(intExtra, intent.getIntExtra("android.telephony.extra.MMS_HTTP_STATUS", 0));
                }
                if (c || MmsManager.m3541a()) {
                    z = false;
                } else {
                    z = true;
                }
                m17579a(a3, a2, stringExtra, z);
            }
        } catch (Exception e) {
            if (a != null) {
                this.f17609o.m17654b(a.m17663a(), a.m17664b());
            } else {
                this.f17609o.m17654b(MmsSmsIdUtils.m17499a(data), 0);
            }
            throw e;
        }
    }

    private void m17583d(Intent intent) {
        this.f17605k.m17633a(intent);
    }

    private void m17584e(Intent intent) {
        this.f17606l.m17617a(intent.getExtras());
    }

    private void m17585f(Intent intent) {
        this.f17607m.m17605a(intent.getExtras());
    }

    private void m17586g(Intent intent) {
        this.f17608n.m17614a(intent.getExtras());
    }

    private void m17587h(Intent intent) {
        if (Strings.isNullOrEmpty(intent.getStringExtra("sms_in_base64"))) {
            BLog.b("SmsHandler", "Cannot get the sms message for full mode e2e test.");
            return;
        }
        try {
            Intent intent2 = new Intent();
            intent2.putExtra("pdus", new byte[][]{Base64.decode(r0, 0)});
            this.f17605k.m17633a(intent2);
        } catch (Throwable e) {
            BLog.c("SmsHandler", e, "Exception in handling full mode sms deliver for e2e test.", new Object[0]);
        }
    }

    private void m17579a(Message message, MmsSmsErrorType mmsSmsErrorType, @Nullable String str, boolean z) {
        String str2;
        int size = this.f17597c.m17487a(message.b.i()).size();
        if (message.k != null) {
            str2 = "sticker";
        } else {
            str2 = message.L.c();
        }
        boolean d = MmsSmsIdUtils.m17503d(message.a);
        boolean z2 = message.w == null || message.w == SendError.a;
        this.f17600f.a(d, z2, z2 ? null : mmsSmsErrorType.name(), str, str2, message.L.d.size(), size, z);
    }
}
