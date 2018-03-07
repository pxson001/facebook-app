package com.facebook.today.notifications;

import android.database.DataSetObservable;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.event.NotificationsEventBus;
import com.facebook.notifications.event.NotificationsEvents.NotificationsClickedEvent;
import com.facebook.notifications.event.NotificationsEvents.NotificationsClickedEventSubscriber;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.util.NotificationsMutator;
import com.facebook.today.abtest.ExperimentsForTodayAbTestModule;
import com.facebook.today.abtest.TodayExperimentController;
import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: typeid */
public class TodayNotificationsHolder {
    private static volatile TodayNotificationsHolder f1201m;
    public final DataSetObservable f1202a = new DataSetObservable();
    public final Map<String, Integer> f1203b = new HashMap();
    public final TodayExperimentController f1204c;
    private final TodayNotificationsUtil f1205d;
    public final NotificationsEventBus f1206e;
    public final NotificationsClickedEventSubscriber f1207f = new C01141(this);
    public boolean f1208g = false;
    public int f1209h;
    public int f1210i = 0;
    public int f1211j;
    public List<NotificationsEdgeFields> f1212k = new ArrayList();
    public boolean f1213l = false;

    /* compiled from: typeid */
    class C01141 extends NotificationsClickedEventSubscriber {
        final /* synthetic */ TodayNotificationsHolder f1200a;

        C01141(TodayNotificationsHolder todayNotificationsHolder) {
            this.f1200a = todayNotificationsHolder;
        }

        public final void m1360b(FbEvent fbEvent) {
            NotificationsClickedEvent notificationsClickedEvent = (NotificationsClickedEvent) fbEvent;
            TodayNotificationsHolder todayNotificationsHolder = this.f1200a;
            Integer num = (Integer) todayNotificationsHolder.f1203b.get(notificationsClickedEvent.a);
            if (num != null && num.intValue() < todayNotificationsHolder.f1212k.size()) {
                todayNotificationsHolder.f1212k.set(num.intValue(), NotificationsMutator.a((NotificationsEdgeFields) todayNotificationsHolder.f1212k.get(num.intValue())));
                todayNotificationsHolder.m1371g();
            }
        }
    }

    public static com.facebook.today.notifications.TodayNotificationsHolder m1361a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1201m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.today.notifications.TodayNotificationsHolder.class;
        monitor-enter(r1);
        r0 = f1201m;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m1362b(r0);	 Catch:{ all -> 0x0035 }
        f1201m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1201m;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.today.notifications.TodayNotificationsHolder.a(com.facebook.inject.InjectorLike):com.facebook.today.notifications.TodayNotificationsHolder");
    }

    private static TodayNotificationsHolder m1362b(InjectorLike injectorLike) {
        return new TodayNotificationsHolder(NotificationsEventBus.a(injectorLike), TodayNotificationsUtil.m1372a(injectorLike), TodayExperimentController.a(injectorLike));
    }

    @Inject
    public TodayNotificationsHolder(NotificationsEventBus notificationsEventBus, TodayNotificationsUtil todayNotificationsUtil, TodayExperimentController todayExperimentController) {
        this.f1206e = notificationsEventBus;
        this.f1206e.a(this.f1207f);
        this.f1205d = todayNotificationsUtil;
        this.f1204c = todayExperimentController;
    }

    public final boolean m1368a() {
        return this.f1208g || this.f1212k.size() <= m1365i();
    }

    public final void m1367a(boolean z) {
        this.f1208g = z;
        m1371g();
    }

    public final List<NotificationsEdgeFields> m1369b() {
        int i = m1365i();
        if (this.f1208g) {
            i += 10;
        }
        return this.f1212k.size() > i ? this.f1212k.subList(0, i) : this.f1212k;
    }

    private int m1365i() {
        int a = this.f1204c.b.a(ExperimentsForTodayAbTestModule.j, 6);
        if (this.f1209h != 0 && this.f1204c.b.a(ExperimentsForTodayAbTestModule.f, false)) {
            int ceil;
            double d = ((double) this.f1211j) / ((double) this.f1209h);
            if (this.f1204c.b.a(ExperimentsForTodayAbTestModule.R, true)) {
                ceil = (int) Math.ceil(d);
            } else {
                ceil = (int) Math.floor(d);
            }
            a = Math.max(a, ceil - 1);
        }
        return Math.max(a, (this.f1210i + 1) + this.f1205d.m1383b());
    }

    public final boolean m1370e() {
        return !this.f1212k.isEmpty();
    }

    public final void m1366a(List<NotificationsEdgeFields> list) {
        if (this.f1213l || !this.f1204c.C()) {
            this.f1212k = new ArrayList(list);
            m1363c(list);
        } else {
            this.f1213l = true;
            this.f1212k = m1364d(m1365i());
        }
        m1371g();
    }

    public final void m1371g() {
        this.f1202a.notifyInvalidated();
    }

    @VisibleForTesting
    private List<NotificationsEdgeFields> m1364d(int i) {
        if (this.f1212k.isEmpty()) {
            return new ArrayList();
        }
        int i2;
        List arrayList = new ArrayList();
        for (i2 = i; i2 < this.f1212k.size(); i2++) {
            if (GraphQLNotifImportanceType.IMPORTANT.equals(((NotificationsEdgeFields) this.f1212k.get(i2)).g())) {
                arrayList.add(this.f1212k.get(i2));
            }
        }
        List<NotificationsEdgeFields> arrayList2 = new ArrayList(this.f1212k);
        if (!arrayList.isEmpty()) {
            Collection subList;
            int size = arrayList.size();
            int min = Math.min(this.f1204c.i(), i - this.f1204c.b.a(ExperimentsForTodayAbTestModule.r, 3));
            int i3 = i - 1;
            i2 = 0;
            while (i2 < size && i3 >= i - min) {
                int i4;
                if (GraphQLNotifImportanceType.IMPORTANT.equals(((NotificationsEdgeFields) this.f1212k.get(i3)).g())) {
                    arrayList.add(this.f1212k.get(i3));
                    i4 = i2;
                } else {
                    i4 = i2 + 1;
                }
                i3--;
                i2 = i4;
            }
            Collections.sort(arrayList, new NotificationHighlightsComparator());
            if (arrayList.size() > min) {
                subList = arrayList.subList(0, min);
            } else {
                Object obj = arrayList;
            }
            arrayList2.removeAll(subList);
            arrayList2.addAll(i - subList.size(), subList);
        }
        m1363c(arrayList2);
        return arrayList2;
    }

    private void m1363c(List<NotificationsEdgeFields> list) {
        this.f1203b.clear();
        for (int i = 0; i < list.size(); i++) {
            this.f1203b.put(((NotificationsEdgeFields) list.get(i)).k().g(), Integer.valueOf(i));
        }
    }
}
