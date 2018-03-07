package com.facebook.device_id;

import android.content.Context;
import android.content.Intent;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.phoneid.AbstractPhoneIdRequestReceiver;
import com.facebook.phoneid.PhoneId;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: schemaItemDefinition */
public class DefaultPhoneIdRequestReceiver extends AbstractPhoneIdRequestReceiver {
    private static final String f2918b = DefaultPhoneIdRequestReceiver.class.getSimpleName();
    @Inject
    public Lazy<DefaultPhoneIdStore> f2919a;

    @Deprecated
    private static <T> void m4055a(Class<T> cls, T t, Context context) {
        m4056a(t, context);
    }

    public static void m4056a(Object obj, Context context) {
        ((DefaultPhoneIdRequestReceiver) obj).f2919a = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 1069);
    }

    protected final boolean mo583b() {
        return ((DefaultPhoneIdStore) this.f2919a.get()).a();
    }

    @Nullable
    protected final PhoneId mo582a() {
        if (((DefaultPhoneIdStore) this.f2919a.get()).c.c.a()) {
            return ((DefaultPhoneIdStore) this.f2919a.get()).b();
        }
        return null;
    }

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1380974670);
        Class cls = DefaultPhoneIdRequestReceiver.class;
        m4056a(this, context);
        super.onReceive(context, intent);
        LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1302803208, a);
    }

    private void m4054a(Lazy<DefaultPhoneIdStore> lazy) {
        this.f2919a = lazy;
    }
}
