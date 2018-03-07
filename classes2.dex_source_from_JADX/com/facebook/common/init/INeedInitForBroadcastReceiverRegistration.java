package com.facebook.common.init;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: tr_TR */
public abstract class INeedInitForBroadcastReceiverRegistration<T> implements ActionReceiver {
    public final ImmutableList<String> mActions;
    private final Lazy<T> mBroadcastLogic;
    public final FbBroadcastManagerType mBroadcastType;
    @Nullable
    public final Handler mHandler;

    protected abstract void onReceive(Context context, Intent intent, T t);

    protected INeedInitForBroadcastReceiverRegistration(FbBroadcastManagerType fbBroadcastManagerType, Lazy<T> lazy, List<String> list) {
        this(fbBroadcastManagerType, (Lazy) lazy, null, (List) list);
    }

    protected INeedInitForBroadcastReceiverRegistration(FbBroadcastManagerType fbBroadcastManagerType, Lazy<T> lazy, @Nullable Handler handler, List<String> list) {
        this.mBroadcastType = fbBroadcastManagerType;
        this.mBroadcastLogic = lazy;
        this.mHandler = handler;
        this.mActions = ImmutableList.copyOf((Collection) list);
    }

    protected INeedInitForBroadcastReceiverRegistration(FbBroadcastManagerType fbBroadcastManagerType, Lazy<T> lazy, String... strArr) {
        this(fbBroadcastManagerType, (Lazy) lazy, null, strArr);
    }

    protected INeedInitForBroadcastReceiverRegistration(FbBroadcastManagerType fbBroadcastManagerType, Lazy<T> lazy, @Nullable Handler handler, String... strArr) {
        this(fbBroadcastManagerType, (Lazy) lazy, handler, ImmutableList.copyOf((Object[]) strArr));
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2104884032);
        onReceive(context, intent, this.mBroadcastLogic.get());
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -169953719, a);
    }
}
