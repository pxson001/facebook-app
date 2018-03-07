package com.facebook.messaging.contextbanner;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageSetting;
import javax.annotation.Nullable;

/* compiled from: suggestion_surface */
public class ContextRowHelper {
    public static ContextRowHelper m2010a(InjectorLike injectorLike) {
        return new ContextRowHelper();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m2013a(boolean r4, com.facebook.messaging.model.threadkey.ThreadKey r5, @javax.annotation.Nullable com.facebook.user.model.User r6) {
        /*
        r3 = this;
        if (r4 == 0) goto L_0x002b;
    L_0x0002:
        if (r5 == 0) goto L_0x002b;
    L_0x0004:
        r0 = r5.b();
        if (r0 != 0) goto L_0x0029;
    L_0x000a:
        r1 = 0;
        r2 = com.facebook.messaging.model.threadkey.ThreadKey.b(r5);
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = com.facebook.messaging.model.threadkey.ThreadKey.g(r5);
        if (r2 == 0) goto L_0x0026;
    L_0x0017:
        if (r6 == 0) goto L_0x0026;
    L_0x0019:
        r2 = r6.T();
        if (r2 == 0) goto L_0x0025;
    L_0x001f:
        r2 = m2011a(r6);
        if (r2 == 0) goto L_0x0026;
    L_0x0025:
        r1 = 1;
    L_0x0026:
        r0 = r1;
        if (r0 == 0) goto L_0x002b;
    L_0x0029:
        r0 = 1;
    L_0x002a:
        return r0;
    L_0x002b:
        r0 = 0;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.contextbanner.ContextRowHelper.a(boolean, com.facebook.messaging.model.threadkey.ThreadKey, com.facebook.user.model.User):boolean");
    }

    public final boolean m2012a(ThreadKey threadKey, @Nullable User user) {
        return ThreadKey.b(threadKey) && user != null && (!user.T() || m2011a(user));
    }

    public static boolean m2011a(User user) {
        return user.T() && (user.w == null || !user.w.contains(CommercePageSetting.COMMERCE_NUX_ENABLED));
    }
}
