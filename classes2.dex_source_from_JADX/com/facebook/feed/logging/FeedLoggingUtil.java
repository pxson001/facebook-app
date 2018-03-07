package com.facebook.feed.logging;

import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.sponsored.SponsoredUtils;
import com.facebook.feed.ui.MultiRowAdapterRecyclerViewProxy;
import com.facebook.feed.ui.NewsFeedRecyclerViewAdapterWrapper;
import com.facebook.graphql.model.BaseImpression;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: predicted_prefetch_schedule */
public class FeedLoggingUtil {
    private static final Class<?> f9306a = FeedLoggingUtil.class;
    private static volatile FeedLoggingUtil f9307c;
    private final AbstractFbErrorReporter f9308b;

    public static com.facebook.feed.logging.FeedLoggingUtil m14266a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9307c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.FeedLoggingUtil.class;
        monitor-enter(r1);
        r0 = f9307c;	 Catch:{ all -> 0x003a }
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
        r0 = m14270b(r0);	 Catch:{ all -> 0x0035 }
        f9307c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9307c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.FeedLoggingUtil.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.FeedLoggingUtil");
    }

    private static FeedLoggingUtil m14270b(InjectorLike injectorLike) {
        return new FeedLoggingUtil(FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public FeedLoggingUtil(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9308b = abstractFbErrorReporter;
    }

    public static int m14264a(View view, int i) {
        return Math.max(0, Math.min(i, view.getBottom()) - Math.max(0, view.getTop()));
    }

    public static boolean m14272b(View view, int i) {
        return view.getTop() >= 0 && view.getBottom() <= i;
    }

    @Nullable
    public static FeedUnitHeightTracker m14267a(ScrollingViewProxy scrollingViewProxy) {
        HasMultiRow b = m14271b(scrollingViewProxy);
        if (b instanceof NewsFeedRecyclerViewAdapterWrapper) {
            return ((NewsFeedRecyclerViewAdapterWrapper) b).f13611e;
        }
        return null;
    }

    @Nullable
    public static HasMultiRow m14271b(ScrollingViewProxy scrollingViewProxy) {
        return scrollingViewProxy instanceof MultiRowAdapterRecyclerViewProxy ? ((MultiRowAdapterRecyclerViewProxy) scrollingViewProxy).f12216b : null;
    }

    public static boolean m14269a(Object obj) {
        Sponsorable a = SponsoredUtils.m21144a(obj);
        if (a == null) {
            return false;
        }
        BaseImpression a2 = SponsoredUtils.m21143a(a);
        if (a2 == null || !a2.mo3121k()) {
            return false;
        }
        return true;
    }

    public static ArrayNode m14268a(@Nullable ArrayNode arrayNode, ImmutableSet<String> immutableSet, FbObjectMapper fbObjectMapper) {
        try {
            ArrayNode arrayNode2 = new ArrayNode(JsonNodeFactory.f3121a);
            if (arrayNode == null) {
                return arrayNode2;
            }
            Iterator it = arrayNode.iterator();
            while (it.hasNext()) {
                JsonNode a = fbObjectMapper.m6636a(((JsonNode) it.next()).mo719B());
                ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
                Iterator j = a.mo714j();
                while (j.hasNext()) {
                    String str = (String) j.next();
                    if (!immutableSet.contains(str)) {
                        objectNode.m5143c(str, a.mo709b(str));
                    }
                }
                arrayNode2.m13394h(objectNode.toString());
            }
            return arrayNode2;
        } catch (Throwable e) {
            BLog.b(f9306a, e, "Failed to strip tracking code - %s", new Object[]{arrayNode});
            return arrayNode;
        }
    }

    public final boolean m14273a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, View view) {
        TracerDetour.a("FeedLoggingUtil.isEnoughVisible", -1723927491);
        try {
            int q = scrollingViewProxy.mo2402q();
            int r = scrollingViewProxy.mo2403r();
            int e = scrollingViewProxy.mo2381e();
            int c = scrollingViewProxy.mo2371c(view);
            if (!scrollingViewProxy.mo2343C()) {
                return false;
            }
            int i = e / 2;
            c = hasMultiRow.s_(c);
            if (c == Integer.MIN_VALUE) {
                TracerDetour.a(543489244);
                return false;
            }
            int t_ = hasMultiRow.t_(c);
            int g = hasMultiRow.mo2514g(c);
            c = Math.max(t_, q) - q;
            int min = Math.min(g, r) - q;
            if (t_ >= q && g <= r) {
                View a = m14265a(c, scrollingViewProxy, c, min);
                View a2 = m14265a(min, scrollingViewProxy, c, min);
                if (a == null || a2 == null) {
                    TracerDetour.a(-1922284090);
                    return false;
                } else if (a.getTop() >= 0 && a2.getBottom() <= e) {
                    TracerDetour.a(373089242);
                    return true;
                }
            }
            r = 0;
            for (q = c; q <= min; q++) {
                View a3 = m14265a(q, scrollingViewProxy, c, min);
                if (a3 == null) {
                    TracerDetour.a(967352506);
                    return false;
                }
                r += m14264a(a3, e);
                if (r >= i) {
                    TracerDetour.a(-2775927);
                    return true;
                }
            }
            TracerDetour.a(-1430292182);
            return false;
        } finally {
            TracerDetour.a(991354136);
        }
    }

    @Nullable
    private View m14265a(int i, ScrollingViewProxy scrollingViewProxy, int i2, int i3) {
        View f = scrollingViewProxy.mo2386f(i);
        if (f != null) {
            return f;
        }
        this.f9308b.m2340a(f9306a.toString(), StringFormatUtil.a("Invalid position %d (internal positions %d to %d, proxy positions %d to %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(scrollingViewProxy.mo2402q()), Integer.valueOf(scrollingViewProxy.mo2403r())}));
        return null;
    }
}
