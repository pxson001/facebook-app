package com.facebook.phoneid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: schemaObjectPropertiesDefinition */
public abstract class AbstractPhoneIdRequestReceiver extends BroadcastReceiver {
    protected abstract PhoneId mo582a();

    protected boolean mo583b() {
        return true;
    }

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -790395757);
        PhoneId a2 = mo582a();
        if ("com.facebook.GET_PHONE_ID".equals(intent.getAction()) && mo583b() && a2 != null) {
            if (AppAuthHelper.a(context, getResultExtras(true))) {
                Bundle bundle = new Bundle();
                bundle.putLong("timestamp", a2.b);
                setResult(-1, a2.a, bundle);
            }
            LogUtils.a(intent, 1968525047, a);
            return;
        }
        LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 593798351, a);
    }
}
