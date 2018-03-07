package com.facebook.common.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* compiled from: use_color_crops */
public class FbLocalBroadcastManager {
    private static final Object f1534a = new Object();
    private static FbLocalBroadcastManager f1535b;
    private final Map<BroadcastReceiver, List<IntentFilter>> f1536c = Maps.m838c();
    private final Map<String, List<ReceiverRecord>> f1537d = Maps.m838c();
    private final Multimap<Long, BroadcastRecord> f1538e = ArrayListMultimap.m2971t();
    private final Map<Long, LocalBroadcastHandler> f1539f = Maps.m838c();
    private final Context f1540g;
    private final LocalBroadcastManager f1541h;

    /* compiled from: use_color_crops */
    class LocalBroadcastHandler extends Handler {
        public final long f2301a;
        final /* synthetic */ FbLocalBroadcastManager f2302b;
        private final AtomicInteger f2303c = new AtomicInteger(0);

        public LocalBroadcastHandler(FbLocalBroadcastManager fbLocalBroadcastManager, Looper looper, long j) {
            this.f2302b = fbLocalBroadcastManager;
            super(looper);
            this.f2301a = j;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    FbLocalBroadcastManager.m2963a(this.f2302b, this.f2301a);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }

        public final void m4483a() {
            this.f2303c.getAndIncrement();
        }

        public final boolean m4484b() {
            return this.f2303c.decrementAndGet() <= 0;
        }
    }

    /* compiled from: use_color_crops */
    class ReceiverRecord {
        final IntentFilter f2304a;
        final BroadcastReceiver f2305b;
        final long f2306c;
        final LocalBroadcastHandler f2307d;
        boolean f2308e;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver, long j, LocalBroadcastHandler localBroadcastHandler) {
            this.f2304a = intentFilter;
            this.f2305b = broadcastReceiver;
            this.f2306c = j;
            this.f2307d = (LocalBroadcastHandler) Preconditions.checkNotNull(localBroadcastHandler);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.f2305b);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.f2304a);
            stringBuilder.append(" looperId=");
            stringBuilder.append(this.f2306c);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    /* compiled from: use_color_crops */
    class BroadcastRecord {
        final Intent f15148a;
        final Collection<ReceiverRecord> f15149b;

        BroadcastRecord(Intent intent, Collection<ReceiverRecord> collection) {
            this.f15148a = intent;
            this.f15149b = collection;
        }
    }

    public static FbLocalBroadcastManager m2961a(Context context) {
        FbLocalBroadcastManager fbLocalBroadcastManager;
        synchronized (f1534a) {
            if (f1535b == null) {
                f1535b = new FbLocalBroadcastManager(context.getApplicationContext());
            }
            fbLocalBroadcastManager = f1535b;
        }
        return fbLocalBroadcastManager;
    }

    @VisibleForTesting
    private FbLocalBroadcastManager(Context context) {
        this.f1540g = context;
        this.f1541h = LocalBroadcastManager.m3051a(context);
    }

    public final void m2967a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        m2968a(broadcastReceiver, intentFilter, null);
    }

    public final void m2968a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, @Nullable Looper looper) {
        if (looper == null) {
            this.f1541h.m3054a(broadcastReceiver, intentFilter);
            return;
        }
        synchronized (this.f1536c) {
            LocalBroadcastHandler localBroadcastHandler;
            long a = m2960a(looper);
            LocalBroadcastHandler localBroadcastHandler2 = (LocalBroadcastHandler) this.f1539f.get(Long.valueOf(a));
            if (localBroadcastHandler2 == null) {
                localBroadcastHandler = new LocalBroadcastHandler(this, looper, a);
                this.f1539f.put(Long.valueOf(a), localBroadcastHandler);
            } else {
                localBroadcastHandler = localBroadcastHandler2;
            }
            localBroadcastHandler.m4483a();
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver, a, localBroadcastHandler);
            List list = (List) this.f1536c.get(broadcastReceiver);
            if (list == null) {
                list = Lists.m1305b(1);
                this.f1536c.put(broadcastReceiver, list);
            }
            list.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                list = (List) this.f1537d.get(action);
                if (list == null) {
                    list = Lists.m1305b(1);
                    this.f1537d.put(action, list);
                }
                list.add(receiverRecord);
            }
        }
    }

    public final void m2966a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f1536c) {
            this.f1541h.m3053a(broadcastReceiver);
            List list = (List) this.f1536c.remove(broadcastReceiver);
            if (list == null) {
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                IntentFilter intentFilter = (IntentFilter) list.get(i);
                for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                    String action = intentFilter.getAction(i2);
                    List list2 = (List) this.f1537d.get(action);
                    if (list2 != null) {
                        int i3 = 0;
                        while (i3 < list2.size()) {
                            int i4;
                            if (((ReceiverRecord) list2.get(i3)).f2305b == broadcastReceiver) {
                                ReceiverRecord receiverRecord = (ReceiverRecord) list2.remove(i3);
                                if (receiverRecord.f2307d.m4484b()) {
                                    this.f1539f.remove(Long.valueOf(receiverRecord.f2307d.f2301a));
                                }
                                i4 = i3 - 1;
                            } else {
                                i4 = i3;
                            }
                            i3 = i4 + 1;
                        }
                        if (list2.isEmpty()) {
                            this.f1537d.remove(action);
                        }
                    }
                }
            }
        }
    }

    public final boolean m2969a(Intent intent) {
        boolean a;
        synchronized (this.f1536c) {
            a = this.f1541h.m3055a(intent) | m2965b(intent);
        }
        return a;
    }

    private boolean m2965b(Intent intent) {
        synchronized (this.f1536c) {
            Set<Long> a = m2962a(intent, this.f1538e);
            if (a != null) {
                for (Long l : a) {
                    Handler handler = (Handler) this.f1539f.get(l);
                    if (!(handler == null || handler.hasMessages(1))) {
                        handler.sendEmptyMessage(1);
                    }
                }
                return true;
            }
            return false;
        }
    }

    private Set<Long> m2962a(Intent intent, Multimap<Long, BroadcastRecord> multimap) {
        Set<Long> b;
        synchronized (this.f1536c) {
            Object obj;
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f1540g.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set categories = intent.getCategories();
            if ((intent.getFlags() & 8) != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            Multimap multimap2 = null;
            List list = (List) this.f1537d.get(intent.getAction());
            if (list != null) {
                int i = 0;
                while (i < list.size()) {
                    Multimap multimap3;
                    Object obj2 = (ReceiverRecord) list.get(i);
                    if (obj2.f2308e) {
                        if (obj != null) {
                            multimap3 = multimap2;
                        }
                        multimap3 = multimap2;
                    } else {
                        int match = obj2.f2304a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (obj != null) {
                                Integer.valueOf(match);
                            }
                            if (multimap2 == null) {
                                multimap3 = ArrayListMultimap.m2971t();
                            } else {
                                multimap3 = multimap2;
                            }
                            multimap3.mo431a(Long.valueOf(obj2.f2306c), obj2);
                            obj2.f2308e = true;
                        }
                        multimap3 = multimap2;
                    }
                    i++;
                    multimap2 = multimap3;
                }
            }
            if (multimap2 != null) {
                for (ReceiverRecord receiverRecord : multimap2.mo418i()) {
                    receiverRecord.f2308e = false;
                }
                for (Object obj3 : multimap2.mo421p()) {
                    multimap.mo431a(obj3, new BroadcastRecord(intent, multimap2.mo427c(obj3)));
                }
                b = Sets.m1324b(multimap2.mo421p());
            } else {
                b = null;
            }
        }
        return b;
    }

    private static long m2960a(Looper looper) {
        return looper.getThread().getId();
    }

    public static void m2963a(FbLocalBroadcastManager fbLocalBroadcastManager, long j) {
        while (true) {
            BroadcastRecord[] broadcastRecordArr;
            synchronized (fbLocalBroadcastManager.f1536c) {
                if (fbLocalBroadcastManager.f1538e.mo413f() <= 0) {
                    return;
                }
                Collection c = fbLocalBroadcastManager.f1538e.mo427c(Long.valueOf(j));
                if (c == null) {
                    return;
                }
                int size = c.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new BroadcastRecord[size];
                c.toArray(broadcastRecordArr);
                fbLocalBroadcastManager.f1538e.mo429d(Long.valueOf(j));
            }
            fbLocalBroadcastManager.m2964a(broadcastRecordArr);
        }
    }

    private void m2964a(BroadcastRecord[] broadcastRecordArr) {
        for (BroadcastRecord broadcastRecord : broadcastRecordArr) {
            for (ReceiverRecord receiverRecord : broadcastRecord.f15149b) {
                receiverRecord.f2305b.onReceive(this.f1540g, broadcastRecord.f15148a);
            }
        }
    }
}
