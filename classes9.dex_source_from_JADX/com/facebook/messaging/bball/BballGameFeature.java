package com.facebook.messaging.bball;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: only_notify_from_chathead */
public class BballGameFeature {
    public static final String f8168a = new String(Character.toChars(127936));
    public final GatekeeperStoreImpl f8169b;

    public static BballGameFeature m8410a(InjectorLike injectorLike) {
        return new BballGameFeature(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BballGameFeature(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f8169b = gatekeeperStoreImpl;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m8411a(com.facebook.messaging.model.messages.Message r5) {
        /*
        r4 = this;
        r1 = r4.f8169b;
        r2 = 167; // 0xa7 float:2.34E-43 double:8.25E-322;
        r3 = 0;
        r1 = r1.a(r2, r3);
        r0 = r1;
        if (r0 == 0) goto L_0x0053;
    L_0x000c:
        if (r5 == 0) goto L_0x0053;
    L_0x000e:
        r0 = r5.b;
        r1 = com.facebook.messaging.model.threadkey.ThreadKey.b(r0);
        if (r1 != 0) goto L_0x001c;
    L_0x0016:
        r1 = com.facebook.messaging.model.threadkey.ThreadKey.c(r0);
        if (r1 == 0) goto L_0x0055;
    L_0x001c:
        r1 = 1;
    L_0x001d:
        r0 = r1;
        if (r0 == 0) goto L_0x0053;
    L_0x0020:
        r1 = r5.l;
        r2 = com.facebook.messaging.model.messages.MessageType.REGULAR;
        if (r1 != r2) goto L_0x0057;
    L_0x0026:
        r1 = f8168a;
        r2 = r5.f;
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0057;
    L_0x0030:
        r1 = 1;
    L_0x0031:
        r0 = r1;
        if (r0 != 0) goto L_0x0051;
    L_0x0034:
        r1 = r5.I;
        if (r1 == 0) goto L_0x0059;
    L_0x0038:
        r1 = r5.I;
        r1 = r1.q();
        if (r1 == 0) goto L_0x0059;
    L_0x0040:
        r1 = "basketball";
        r2 = r5.I;
        r3 = r2.r;
        r2 = r3;
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0059;
    L_0x004d:
        r1 = 1;
    L_0x004e:
        r0 = r1;
        if (r0 == 0) goto L_0x0053;
    L_0x0051:
        r0 = 1;
    L_0x0052:
        return r0;
    L_0x0053:
        r0 = 0;
        goto L_0x0052;
    L_0x0055:
        r1 = 0;
        goto L_0x001d;
    L_0x0057:
        r1 = 0;
        goto L_0x0031;
    L_0x0059:
        r1 = 0;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.bball.BballGameFeature.a(com.facebook.messaging.model.messages.Message):boolean");
    }
}
