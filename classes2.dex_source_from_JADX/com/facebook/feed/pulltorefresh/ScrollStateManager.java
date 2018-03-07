package com.facebook.feed.pulltorefresh;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: offers/detail/?offer_id=%s&share_id=%s&redirect=%s */
public class ScrollStateManager {
    private static volatile ScrollStateManager f11588d;
    private final Clock f11589a;
    private ArrayList<ScrollAction> f11590b = Lists.m1296a();
    public ArrayList<Integer> f11591c = Lists.m1296a();

    public static com.facebook.feed.pulltorefresh.ScrollStateManager m16891a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11588d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.pulltorefresh.ScrollStateManager.class;
        monitor-enter(r1);
        r0 = f11588d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m16894b(r0);	 Catch:{ all -> 0x0035 }
        f11588d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11588d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.pulltorefresh.ScrollStateManager.a(com.facebook.inject.InjectorLike):com.facebook.feed.pulltorefresh.ScrollStateManager");
    }

    private static ScrollStateManager m16894b(InjectorLike injectorLike) {
        return new ScrollStateManager(SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public ScrollStateManager(Clock clock) {
        this.f11589a = clock;
    }

    public final ScrollMode m16896a() {
        ScrollAction g = m16895g();
        return g == null ? ScrollMode.UNKNOWN : g.a;
    }

    public final void m16897a(int i, int i2) {
        this.f11591c.add(Integer.valueOf(i));
        m16892a(i2);
    }

    private void m16892a(int i) {
        ScrollMode b = m16893b();
        if (b != ScrollMode.UNKNOWN) {
            ScrollAction scrollAction = null;
            if (!this.f11590b.isEmpty()) {
                ScrollAction g = m16895g();
                if (i != g.c) {
                    scrollAction = new ScrollAction(this, b, i - g.c < 0 ? ScrollDirection.UP : ScrollDirection.DOWN, i, this.f11589a.mo211a());
                }
            } else if (i > 0) {
                scrollAction = new ScrollAction(this, b, ScrollDirection.DOWN, i, this.f11589a.mo211a());
            }
            if (scrollAction != null) {
                this.f11590b.add(scrollAction);
                new StringBuilder("Scroll Action: ").append(scrollAction.a.toString()).append(", ").append(scrollAction.b.toString()).append(", ").append(scrollAction.c).append(", ").append(scrollAction.d);
                if (this.f11590b.size() > 5) {
                    this.f11590b.remove(0);
                }
            }
        }
    }

    private ScrollMode m16893b() {
        ScrollMode scrollMode = ScrollMode.UNKNOWN;
        if (this.f11591c.isEmpty()) {
            return scrollMode;
        }
        while (this.f11591c.size() > 0 && ((Integer) this.f11591c.get(0)).intValue() == 0) {
            this.f11591c.remove(0);
        }
        if (this.f11591c.isEmpty()) {
            return scrollMode;
        }
        ScrollMode scrollMode2;
        int i;
        int intValue = ((Integer) this.f11591c.get(0)).intValue();
        if (intValue == 1) {
            int i2;
            Object obj;
            if (this.f11591c.size() >= 2 && ((Integer) this.f11591c.get(0)).intValue() == 1 && ((Integer) this.f11591c.get(1)).intValue() == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                if (this.f11591c.size() >= 3 && ((Integer) this.f11591c.get(0)).intValue() == 1 && ((Integer) this.f11591c.get(1)).intValue() == 2 && ((Integer) this.f11591c.get(2)).intValue() == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    obj = null;
                    if (obj != null) {
                        scrollMode2 = ScrollMode.MANUAL;
                        if (intValue == 2) {
                            if (this.f11591c.size() < 2 && ((Integer) this.f11591c.get(0)).intValue() == 2 && ((Integer) this.f11591c.get(1)).intValue() == 0) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            if (i != 0) {
                                scrollMode2 = ScrollMode.AUTOMATIC;
                            }
                        }
                        if (scrollMode2 != ScrollMode.UNKNOWN) {
                            return scrollMode2;
                        }
                        this.f11591c.clear();
                        return scrollMode2;
                    }
                }
            }
            obj = 1;
            if (obj != null) {
                scrollMode2 = ScrollMode.MANUAL;
                if (intValue == 2) {
                    if (this.f11591c.size() < 2) {
                    }
                    i = 0;
                    if (i != 0) {
                        scrollMode2 = ScrollMode.AUTOMATIC;
                    }
                }
                if (scrollMode2 != ScrollMode.UNKNOWN) {
                    return scrollMode2;
                }
                this.f11591c.clear();
                return scrollMode2;
            }
        }
        scrollMode2 = scrollMode;
        if (intValue == 2) {
            if (this.f11591c.size() < 2) {
            }
            i = 0;
            if (i != 0) {
                scrollMode2 = ScrollMode.AUTOMATIC;
            }
        }
        if (scrollMode2 != ScrollMode.UNKNOWN) {
            return scrollMode2;
        }
        this.f11591c.clear();
        return scrollMode2;
    }

    private ScrollAction m16895g() {
        if (this.f11590b.isEmpty()) {
            return null;
        }
        return (ScrollAction) this.f11590b.get(this.f11590b.size() - 1);
    }
}
