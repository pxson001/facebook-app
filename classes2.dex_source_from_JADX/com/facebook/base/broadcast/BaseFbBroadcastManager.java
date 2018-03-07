package com.facebook.base.broadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.content.ActionReceiver;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Lazy;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: use_okhttp */
public abstract class BaseFbBroadcastManager {
    public final Lazy<MultiplexBackgroundWorkObserver> f1532a;

    /* compiled from: use_okhttp */
    public class BaseReceiverBuilder implements FbBroadcastManager$ReceiverBuilder {
        final /* synthetic */ BaseFbBroadcastManager f1636a;
        private final Map<String, ActionReceiver> f1637b = Maps.m838c();
        private IntentFilter f1638c;
        private Handler f1639d;

        protected BaseReceiverBuilder(BaseFbBroadcastManager baseFbBroadcastManager) {
            this.f1636a = baseFbBroadcastManager;
        }

        public final FbBroadcastManager$ReceiverBuilder mo506a(String str, ActionReceiver actionReceiver) {
            this.f1637b.put(str, actionReceiver);
            return this;
        }

        public final FbBroadcastManager$ReceiverBuilder mo504a(IntentFilter intentFilter) {
            this.f1638c = intentFilter;
            return this;
        }

        public final FbBroadcastManager$ReceiverBuilder mo505a(Handler handler) {
            this.f1639d = handler;
            return this;
        }

        public final SelfRegistrableReceiverImpl mo503a() {
            return new SelfRegistrableReceiverImpl(this.f1636a, this.f1637b, this.f1638c, this.f1639d);
        }
    }

    /* compiled from: use_okhttp */
    public class SelfRegistrableReceiverImpl {
        final /* synthetic */ BaseFbBroadcastManager f1641a;
        private final DynamicSecureBroadcastReceiver f1642b;
        private final IntentFilter f1643c;
        private final Handler f1644d;
        private boolean f1645e = false;

        public SelfRegistrableReceiverImpl(final BaseFbBroadcastManager baseFbBroadcastManager, Map<String, ActionReceiver> map, @Nullable IntentFilter intentFilter, @Nullable Handler handler) {
            this.f1641a = baseFbBroadcastManager;
            this.f1642b = new DynamicSecureBroadcastReceiver(this, map, baseFbBroadcastManager.f1532a) {
                final /* synthetic */ SelfRegistrableReceiverImpl f1647b;

                protected final boolean mo508b() {
                    return this.f1647b.m3295a();
                }
            };
            this.f1643c = intentFilter;
            this.f1644d = handler;
        }

        public final synchronized boolean m3295a() {
            return this.f1645e;
        }

        public final synchronized void m3296b() {
            if (this.f1645e) {
                BLog.b(this.f1641a.getClass().getSimpleName(), "Called registerBroadcastReceiver twice.");
            } else {
                IntentFilter intentFilter = this.f1643c;
                if (intentFilter == null) {
                    IntentFilter intentFilter2 = new IntentFilter();
                    for (String addAction : this.f1642b.m3300a()) {
                        intentFilter2.addAction(addAction);
                    }
                    intentFilter = intentFilter2;
                }
                this.f1641a.mo405a(this.f1642b, intentFilter, this.f1644d);
                this.f1645e = true;
            }
        }

        public final synchronized void m3297c() {
            if (this.f1645e) {
                this.f1641a.mo404a(this.f1642b);
                this.f1645e = false;
            }
        }
    }

    protected abstract void mo404a(BroadcastReceiver broadcastReceiver);

    protected abstract void mo405a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, @Nullable Handler handler);

    public abstract void mo406a(Intent intent);

    protected BaseFbBroadcastManager(Lazy<MultiplexBackgroundWorkObserver> lazy) {
        this.f1532a = lazy;
    }

    public final void m2955a(String str) {
        Preconditions.checkNotNull(str);
        mo406a(new Intent(str));
    }

    public final FbBroadcastManager$ReceiverBuilder m2951a() {
        return new BaseReceiverBuilder(this);
    }
}
