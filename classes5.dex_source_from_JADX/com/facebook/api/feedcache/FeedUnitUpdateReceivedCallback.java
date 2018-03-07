package com.facebook.api.feedcache;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.api.feedcache.db.FeedDbMutationService$FeedDbDeleteStoryRequest;
import com.facebook.api.feedcache.db.FeedDbMutationService$FeedDbLikeAndCommentCountUpdateRequest;
import com.facebook.api.feedcache.omnistore.analytics.OmnistoreUpdateAnalyticLogger;
import com.facebook.api.feedcache.omnistore.annotations.IsOmnistorePrivacyUpdateEnable;
import com.facebook.api.feedcache.omnistore.flatbuffer.FeedUnit;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.Delta;
import com.facebook.omnistore.Delta.Status;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.Omnistore.DeltaReceivedCallback;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: article_chaining */
public class FeedUnitUpdateReceivedCallback implements DeltaReceivedCallback {
    private static final Object f8783e = new Object();
    private final FeedDbMutationService f8784a;
    private final OmnistoreUpdateAnalyticLogger f8785b;
    public final Provider<Omnistore> f8786c;
    @IsOmnistorePrivacyUpdateEnable
    private final Provider<Boolean> f8787d;

    private static FeedUnitUpdateReceivedCallback m14694b(InjectorLike injectorLike) {
        return new FeedUnitUpdateReceivedCallback(FeedDbMutationService.a(injectorLike), OmnistoreUpdateAnalyticLogger.b(injectorLike), IdBasedProvider.a(injectorLike, 2863), IdBasedProvider.a(injectorLike, 3894));
    }

    @Inject
    public FeedUnitUpdateReceivedCallback(FeedDbMutationService feedDbMutationService, OmnistoreUpdateAnalyticLogger omnistoreUpdateAnalyticLogger, Provider<Omnistore> provider, Provider<Boolean> provider2) {
        this.f8784a = feedDbMutationService;
        this.f8785b = omnistoreUpdateAnalyticLogger;
        this.f8786c = provider;
        this.f8787d = provider2;
    }

    public void onDeltaReceived(Delta[] deltaArr) {
        Integer.valueOf(deltaArr.length);
        for (Delta delta : deltaArr) {
            HoneyClientEventFast a;
            OmnistoreUpdateAnalyticLogger omnistoreUpdateAnalyticLogger = this.f8785b;
            if (delta != null && omnistoreUpdateAnalyticLogger.b.nextInt(50) == 0) {
                a = omnistoreUpdateAnalyticLogger.a.a("feed_omnistore_delta_mod_50", false);
                if (a.a()) {
                    a.a("dedup_key", delta.mPrimaryKey);
                    a.a("sort_key", delta.mSortKey);
                    a.a("status", delta.mStatus);
                    a.a("reason", delta.mCollectionName);
                    a.a("type", delta.mType);
                    a.b();
                }
            }
            Status status = delta.mStatus;
            if (Status.PERSISTED_REMOTE == delta.mStatus) {
                if (((Boolean) this.f8787d.get()).booleanValue()) {
                    String str = delta.mPrimaryKey;
                    ByteBuffer byteBuffer = delta.mBlob;
                    FeedUnit feedUnit = new FeedUnit();
                    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                    feedUnit.a = byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position();
                    feedUnit.b = byteBuffer;
                    Table table = feedUnit;
                    if (table == null) {
                        this.f8785b.a("", "", "FeedUnit is null");
                        return;
                    }
                    int a2 = table.a(6);
                    if (a2 != 0) {
                        a2 = table.b.getInt(a2 + table.a);
                    } else {
                        a2 = 0;
                    }
                    if (a2 == 0) {
                        String c;
                        this.f8784a.a(new FeedDbMutationService$FeedDbDeleteStoryRequest(str));
                        OmnistoreUpdateAnalyticLogger omnistoreUpdateAnalyticLogger2 = this.f8785b;
                        a2 = table.a(4);
                        if (a2 != 0) {
                            c = table.c(a2 + table.a);
                        } else {
                            c = null;
                        }
                        String str2 = c;
                        a = omnistoreUpdateAnalyticLogger2.a.a("feed_omnistore_invalidation", false);
                        if (a.a()) {
                            a.a("status", "success");
                            a.a("dedup_key", str);
                            a.a("graphql_id", str2);
                            a.b();
                        }
                        return;
                    }
                    Integer.valueOf(table.m14728c());
                    Integer.valueOf(table.m14729d());
                    this.f8784a.a(new FeedDbMutationService$FeedDbLikeAndCommentCountUpdateRequest(str, table.m14728c(), table.m14729d()));
                } else {
                    this.f8785b.a("", "", "User is not in the gk");
                    return;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.api.feedcache.FeedUnitUpdateReceivedCallback m14693a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f8783e;	 Catch:{ all -> 0x006c }
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
        r1 = m14694b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f8783e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.api.feedcache.FeedUnitUpdateReceivedCallback) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.api.feedcache.FeedUnitUpdateReceivedCallback) r0;	 Catch:{  }
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
        r0 = f8783e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.api.feedcache.FeedUnitUpdateReceivedCallback) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.FeedUnitUpdateReceivedCallback.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.FeedUnitUpdateReceivedCallback");
    }
}
