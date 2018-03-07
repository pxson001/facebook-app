package com.facebook.orca.notify;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.messaging.notify.MissedCallNotification;

/* compiled from: not recognized */
class DefaultMessagingNotificationHandler$5 implements MessagingNotificationUtil$BitmapCallback {
    final /* synthetic */ MissedCallNotification f6208a;
    final /* synthetic */ long f6209b;
    final /* synthetic */ int f6210c;
    final /* synthetic */ DefaultMessagingNotificationHandler f6211d;

    DefaultMessagingNotificationHandler$5(DefaultMessagingNotificationHandler defaultMessagingNotificationHandler, MissedCallNotification missedCallNotification, long j, int i) {
        this.f6211d = defaultMessagingNotificationHandler;
        this.f6208a = missedCallNotification;
        this.f6209b = j;
        this.f6210c = i;
    }

    public final void mo234a(CloseableReference<CloseableImage> closeableReference) {
        Bitmap bitmap = null;
        try {
            if (closeableReference.a() instanceof CloseableBitmap) {
                bitmap = ((CloseableBitmap) closeableReference.a()).a();
            }
            m5930a(bitmap);
        } finally {
            closeableReference.close();
        }
    }

    public final void mo233a() {
        m5930a(null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5930a(@javax.annotation.Nullable android.graphics.Bitmap r15) {
        /*
        r14 = this;
        r7 = 0;
        r0 = r14.f6211d;
        r1 = r14.f6208a;
        r1 = r1.i;
        r2 = r14.f6209b;
        r4 = r14.f6208a;
        r4 = r4.d;
        r6 = r14.f6208a;
        r6 = r6.b;
        r1 = r0.a(r1, r2, r4, r6);
        r0 = r14.f6211d;
        r2 = r14.f6209b;
        r4 = r14.f6208a;
        r4 = r4.f;
        r2 = r0.a(r2, r4);
        r0 = r14.f6208a;
        r3 = r0.a;
        r0 = r14.f6208a;
        r4 = r0.b;
        r0 = r14.f6208a;
        r0 = r0.h;
        r5 = com.facebook.messaging.notify.MissedCallNotification.MissCallType.CONFERENCE_ON_GOING;
        if (r0 != r5) goto L_0x0143;
    L_0x0031:
        r0 = r14.f6211d;
        r5 = r14.f6208a;
        r5 = r5.i;
        r6 = r14.f6208a;
        r6 = r6.f;
        r8 = r0.H;
        r9 = "RTC_JOIN_CONFERENCE_CALL_ACTION";
        r8 = r8.a(r9);
        r9 = new android.content.Intent;
        r9.<init>(r8);
        r8 = r0.r;
        r8 = r8.a(r5);
        if (r8 != 0) goto L_0x0146;
    L_0x0050:
        r8 = "DefaultMessagingNotificationHandler";
        r9 = "createPendingIntentForJoinConferenceCall cannot fetch threadSummary";
        com.facebook.debug.log.BLog.a(r8, r9);
        r8 = 0;
    L_0x0058:
        r0 = r8;
        if (r0 == 0) goto L_0x0143;
    L_0x005b:
        r5 = new android.support.v4.app.NotificationCompat$Builder;
        r6 = r14.f6211d;
        r6 = r6.b;
        r5.<init>(r6);
        r3 = r5.a(r3);
        r3 = r3.b(r4);
        r4 = r14.f6210c;
        r3 = r3.a(r4);
        r3.d = r0;
        r3 = r3;
        r2 = r3.b(r2);
        r3 = 2;
        r2.j = r3;
        r2 = r2;
        r3 = r14.f6208a;
        r4 = r3.d;
        r2 = r2.a(r4);
        r3 = r14.f6211d;
        r3 = r3.b;
        r3 = r3.getResources();
        r4 = 2131362510; // 0x7f0a02ce float:1.8344803E38 double:1.053032995E-314;
        r3 = r3.getColor(r4);
        r2.y = r3;
        r2 = r2;
        r3 = 1;
        r2 = r2.c(r3);
        if (r15 == 0) goto L_0x00a0;
    L_0x009e:
        r2.g = r15;
    L_0x00a0:
        r3 = r14.f6208a;
        r3 = r3.e;
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x00e1;
    L_0x00aa:
        r3 = r14.f6211d;
        r3 = r3.B;
        r3 = r3.h();
        r4 = com.facebook.config.application.Product.MESSENGER;
        if (r3 != r4) goto L_0x00e1;
    L_0x00b6:
        r3 = com.facebook.messaging.appspecific.AppGlyphResolver.a();
        r4 = r14.f6211d;
        r4 = r4.b;
        r5 = 2131232101; // 0x7f080565 float:1.8080302E38 double:1.0529685644E-314;
        r4 = r4.getString(r5);
        r2.a(r3, r4, r1);
        r1 = r14.f6208a;
        r1 = r1.h;
        r3 = com.facebook.messaging.notify.MissedCallNotification.MissCallType.CONFERENCE_ON_GOING;
        if (r1 != r3) goto L_0x0110;
    L_0x00d0:
        r1 = 2130843998; // 0x7f02195e float:1.7293135E38 double:1.052776816E-314;
        r3 = r14.f6211d;
        r3 = r3.b;
        r4 = 2131231995; // 0x7f0804fb float:1.8080087E38 double:1.052968512E-314;
        r3 = r3.getString(r4);
        r2.a(r1, r3, r0);
    L_0x00e1:
        r0 = r14.f6211d;
        r0 = r0.f;
        r1 = r14.f6208a;
        r1 = r1.g;
        r3 = 0;
        r4 = r14.f6208a;
        r4 = r4.i;
        r0.a(r2, r1, r3, r4);
        r0 = r14.f6211d;
        r1 = r0.d;
        r0 = r14.f6208a;
        r0 = r0.h;
        r3 = com.facebook.messaging.notify.MissedCallNotification.MissCallType.P2P;
        if (r0 != r3) goto L_0x0136;
    L_0x00fd:
        r0 = r14.f6208a;
        r0 = r0.c;
    L_0x0101:
        r3 = 10010; // 0x271a float:1.4027E-41 double:4.9456E-320;
        r2 = r2.c();
        r1.a(r0, r3, r2);
        r0 = r14.f6208a;
        r0.i();
        return;
    L_0x0110:
        r0 = r14.f6208a;
        r0 = r0.a();
        if (r0 != 0) goto L_0x00e1;
    L_0x0118:
        r0 = r14.f6211d;
        r4 = r14.f6209b;
        r1 = r14.f6208a;
        r1 = r1.f;
        r0 = r0.a(r4, r7, r1);
        r1 = 2130843998; // 0x7f02195e float:1.7293135E38 double:1.052776816E-314;
        r3 = r14.f6211d;
        r3 = r3.b;
        r4 = 2131232032; // 0x7f080520 float:1.8080162E38 double:1.0529685303E-314;
        r3 = r3.getString(r4);
        r2.a(r1, r3, r0);
        goto L_0x00e1;
    L_0x0136:
        r0 = r14.f6208a;
        r0 = r0.i;
        r4 = r0.i();
        r0 = java.lang.Long.toString(r4);
        goto L_0x0101;
    L_0x0143:
        r0 = r1;
        goto L_0x005b;
    L_0x0146:
        r10 = "THREAD_SUMMARY";
        r8 = r9.putExtra(r10, r8);
        r10 = "IS_CONFERENCE_CALL";
        r11 = 1;
        r8 = r8.putExtra(r10, r11);
        r10 = "IS_VIDEO_CALL";
        r8 = r8.putExtra(r10, r7);
        r10 = "CALLBACK_NOTIF_TIME";
        r11 = r0.w;
        r12 = r11.a();
        r8 = r8.putExtra(r10, r12);
        r10 = "trigger";
        r8.putExtra(r10, r6);
        r8 = r0.l;
        r8 = r8.nextInt();
        r10 = r0.b;
        r11 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r8 = com.facebook.content.SecurePendingIntent.b(r10, r8, r9, r11);
        goto L_0x0058;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.DefaultMessagingNotificationHandler$5.a(android.graphics.Bitmap):void");
    }
}
