package com.facebook.orca.notify;

import com.facebook.common.init.INeedInit;
import com.facebook.common.process.ProcessName;
import com.facebook.common.process.ProcessNameMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: video_broadcast_calculate_stats_type */
public class MessagesNotificationServiceModule$Initializer implements INeedInit {
    private final ProcessName f1246a;

    public static MessagesNotificationServiceModule$Initializer m2435b(InjectorLike injectorLike) {
        return new MessagesNotificationServiceModule$Initializer(ProcessNameMethodAutoProvider.m2431b(injectorLike));
    }

    public static MessagesNotificationServiceModule$Initializer m2434a(InjectorLike injectorLike) {
        return m2435b(injectorLike);
    }

    @Inject
    public MessagesNotificationServiceModule$Initializer(ProcessName processName) {
        this.f1246a = processName;
    }

    public void init() {
        boolean z;
        if (this.f1246a.e() || this.f1246a.a()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Module installed in the wrong process: " + this.f1246a.b);
    }
}
