package com.facebook.base.broadcast;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: sim_operator_mcc_mnc */
public abstract class BroadcastReceiverManager<T> {
    private final ForwardingBroadcastReceiver<T> f4741a;
    private final IntentFilter f4742b;
    @Nullable
    private final String f4743c;
    @GuardedBy("this")
    private final List<BroadcastReceiverHolder> f4744d;

    protected abstract void mo1250a(BroadcastReceiver broadcastReceiver);

    protected abstract void mo1251a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, @Nullable String str, @Nullable Handler handler);

    protected BroadcastReceiverManager(ForwardingBroadcastReceiver<T> forwardingBroadcastReceiver, IntentFilter intentFilter) {
        this(forwardingBroadcastReceiver, intentFilter, null);
    }

    private BroadcastReceiverManager(ForwardingBroadcastReceiver<T> forwardingBroadcastReceiver, IntentFilter intentFilter, String str) {
        this.f4741a = (ForwardingBroadcastReceiver) Preconditions.checkNotNull(forwardingBroadcastReceiver);
        this.f4742b = (IntentFilter) Preconditions.checkNotNull(intentFilter);
        this.f4743c = str;
        this.f4744d = Lists.m1305b(3);
    }

    public final synchronized void m8556a(T t, @Nullable Handler handler) {
        Preconditions.checkNotNull(t);
        Looper a = m8549a(handler);
        BroadcastReceiverHolder b = m8550b(a);
        if (b != null) {
            b.c.add(t);
        } else {
            ForwardingBroadcastReceiverAdapter forwardingBroadcastReceiverAdapter = new ForwardingBroadcastReceiverAdapter(this.f4741a, this, a);
            this.f4744d.add(new BroadcastReceiverHolder(forwardingBroadcastReceiverAdapter, a, t));
            mo1251a(forwardingBroadcastReceiverAdapter, this.f4742b, this.f4743c, handler);
        }
    }

    public final synchronized void m8555a(@Nullable T t) {
        Iterator it = this.f4744d.iterator();
        while (it.hasNext()) {
            BroadcastReceiverHolder broadcastReceiverHolder = (BroadcastReceiverHolder) it.next();
            if (broadcastReceiverHolder.c.remove(t) && broadcastReceiverHolder.c.isEmpty()) {
                mo1250a(broadcastReceiverHolder.a);
                it.remove();
            }
        }
    }

    public final synchronized boolean m8557a() {
        return !this.f4744d.isEmpty();
    }

    public final synchronized Collection<T> m8552a(@Nullable Looper looper) {
        Collection<T> collection;
        BroadcastReceiverHolder b = m8550b(m8551c(looper));
        if (b == null) {
            collection = Collections.EMPTY_LIST;
        } else {
            collection = new ArrayList(b.c);
        }
        return collection;
    }

    @Nullable
    private synchronized BroadcastReceiverHolder m8550b(Looper looper) {
        BroadcastReceiverHolder broadcastReceiverHolder;
        for (BroadcastReceiverHolder broadcastReceiverHolder2 : this.f4744d) {
            if (broadcastReceiverHolder2.b == looper) {
                break;
            }
        }
        broadcastReceiverHolder2 = null;
        return broadcastReceiverHolder2;
    }

    private static Looper m8549a(@Nullable Handler handler) {
        if (handler == null) {
            return Looper.getMainLooper();
        }
        return handler.getLooper();
    }

    private static Looper m8551c(@Nullable Looper looper) {
        if (looper == null) {
            return Looper.getMainLooper();
        }
        return looper;
    }
}
