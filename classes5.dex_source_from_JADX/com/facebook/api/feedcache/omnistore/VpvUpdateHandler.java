package com.facebook.api.feedcache.omnistore;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.api.feedcache.omnistore.analytics.OmnistoreUpdateAnalyticLogger;
import com.facebook.api.feedcache.omnistore.util.OmnistoreUpdateUtil;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.Collection;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.flatbuffers.FlatBufferBuilder;
import java.nio.ByteBuffer;
import javax.inject.Inject;

@UserScoped
/* compiled from: application_name */
public class VpvUpdateHandler {
    private static final Object f8835c = new Object();
    private final VpvUpdateSubscriber f8836a;
    private final OmnistoreUpdateAnalyticLogger f8837b;

    private static VpvUpdateHandler m14723b(InjectorLike injectorLike) {
        return new VpvUpdateHandler(VpvUpdateSubscriber.a(injectorLike), OmnistoreUpdateAnalyticLogger.b(injectorLike));
    }

    @Inject
    public VpvUpdateHandler(VpvUpdateSubscriber vpvUpdateSubscriber, OmnistoreUpdateAnalyticLogger omnistoreUpdateAnalyticLogger) {
        this.f8836a = vpvUpdateSubscriber;
        this.f8837b = omnistoreUpdateAnalyticLogger;
    }

    public final void m14724a(FeedUnit feedUnit) {
        if (feedUnit != null && PropertyHelper.c(feedUnit) != null && PropertyHelper.e(feedUnit) != null) {
            ArrayNode a = FeedTrackableUtil.a(feedUnit);
            if (a != null) {
                Collection b = this.f8836a.b();
                String c = PropertyHelper.c(feedUnit);
                String e = PropertyHelper.e(feedUnit);
                String arrayNode = a.toString();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(256);
                int a2 = flatBufferBuilder.a(arrayNode);
                flatBufferBuilder.b(2);
                flatBufferBuilder.b(1, 1, 0);
                flatBufferBuilder.c(0, a2, 0);
                flatBufferBuilder.c(flatBufferBuilder.c());
                ByteBuffer byteBuffer = flatBufferBuilder.a;
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                b.saveObject(c, e, bArr);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.api.feedcache.omnistore.VpvUpdateHandler m14722a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f8835c;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m14723b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f8835c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.api.feedcache.omnistore.VpvUpdateHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.api.feedcache.omnistore.VpvUpdateHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f8835c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.api.feedcache.omnistore.VpvUpdateHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.omnistore.VpvUpdateHandler.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.omnistore.VpvUpdateHandler");
    }

    public final void m14726a(String str) {
        this.f8836a.b().deleteObject(str);
    }

    public final void m14725a(ImmutableList<String> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            m14726a((String) immutableList.get(i));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m14721a() {
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.f8836a;
        r1 = r1.b();
        r2 = com.facebook.api.feed.util.FeedEdgeComparator.b;
        r3 = -1;
        r4 = com.facebook.omnistore.Collection.SortDirection.DESCENDING;
        r2 = r1.query(r2, r3, r4);
        r1 = 0;
    L_0x0011:
        r3 = r2.step();	 Catch:{ Throwable -> 0x0020 }
        if (r3 == 0) goto L_0x001a;
    L_0x0017:
        r0 = r0 + 1;
        goto L_0x0011;
    L_0x001a:
        if (r2 == 0) goto L_0x001f;
    L_0x001c:
        r2.close();
    L_0x001f:
        return r0;
    L_0x0020:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0022 }
    L_0x0022:
        r0 = move-exception;
        if (r2 == 0) goto L_0x002a;
    L_0x0025:
        if (r1 == 0) goto L_0x0030;
    L_0x0027:
        r2.close();	 Catch:{ Throwable -> 0x002b }
    L_0x002a:
        throw r0;
    L_0x002b:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);
        goto L_0x002a;
    L_0x0030:
        r2.close();
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.omnistore.VpvUpdateHandler.a():int");
    }

    public final void m14727b(ImmutableList<ClientFeedUnitEdge> immutableList) {
        int a = m14721a();
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        OmnistoreUpdateUtil.m14738a(immutableList, builder, builder2, this.f8836a);
        ImmutableList b = builder.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            m14724a(((ClientFeedUnitEdge) b.get(i)).c());
        }
        m14725a(builder2.b());
        OmnistoreUpdateAnalyticLogger omnistoreUpdateAnalyticLogger = this.f8837b;
        int size2 = immutableList.size();
        int size3 = builder.b().size();
        int size4 = builder2.b().size();
        HoneyClientEventFast a2 = omnistoreUpdateAnalyticLogger.a.a("feed_omnistore_vpv_db_sync", false);
        if (a2.a()) {
            a2.a("home_stories_entry", size2);
            a2.a("omnistore_entry", a);
            a2.a("added_entry", size3);
            a2.a("deleted_entry", size4);
            a2.b();
        }
    }
}
