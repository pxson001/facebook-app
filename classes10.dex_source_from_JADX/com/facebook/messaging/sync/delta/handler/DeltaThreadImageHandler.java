package com.facebook.messaging.sync.delta.handler;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.AttachmentUriHelper;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.handlerbase.SingleThreadDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaThreadImage;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.MessageFromDeltaFactory;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;

@UserScoped
/* compiled from: press_photo_item_for_send */
public class DeltaThreadImageHandler extends SingleThreadDeltaHandler {
    private static final Object f4612h = new Object();
    private final AttachmentUriHelper f4613a;
    private final Clock f4614b;
    private final DbInsertThreadsHandler f4615c;
    private final MessageFromDeltaFactory f4616d;
    private final DeltaUiChangesCache f4617e;
    private final ThriftModelUtil f4618f;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4619g = UltralightRuntime.b;

    private static DeltaThreadImageHandler m4184b(InjectorLike injectorLike) {
        DeltaThreadImageHandler deltaThreadImageHandler = new DeltaThreadImageHandler(AttachmentUriHelper.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DbInsertThreadsHandler.a(injectorLike), MessageFromDeltaFactory.m4243a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), ThriftModelUtil.m4260a(injectorLike), IdBasedLazy.a(injectorLike, 11051));
        deltaThreadImageHandler.f4619g = IdBasedLazy.a(injectorLike, 7693);
        return deltaThreadImageHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaThreadImageHandler m4183a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4612h;	 Catch:{ all -> 0x006c }
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
        r1 = m4184b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4612h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadImageHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadImageHandler) r0;	 Catch:{  }
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
        r0 = f4612h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadImageHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaThreadImageHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaThreadImageHandler");
    }

    @Inject
    private DeltaThreadImageHandler(AttachmentUriHelper attachmentUriHelper, Clock clock, DbInsertThreadsHandler dbInsertThreadsHandler, MessageFromDeltaFactory messageFromDeltaFactory, DeltaUiChangesCache deltaUiChangesCache, ThriftModelUtil thriftModelUtil, com.facebook.inject.Lazy<MessageSyncAnalyticsLogger> lazy) {
        super(lazy);
        this.f4613a = attachmentUriHelper;
        this.f4614b = clock;
        this.f4615c = dbInsertThreadsHandler;
        this.f4616d = messageFromDeltaFactory;
        this.f4617e = deltaUiChangesCache;
        this.f4618f = thriftModelUtil;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4618f.m4262a(deltaWrapper.l().messageMetadata.threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return true;
    }

    public final Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        NewMessageResult a = m4182a(threadSummary, ((DeltaWrapper) deltaWithSequenceId.a).l(), deltaWithSequenceId.b);
        Bundle bundle = new Bundle();
        bundle.putParcelable("newMessageResult", a);
        return bundle;
    }

    public final void m4187a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        NewMessageResult newMessageResult = (NewMessageResult) bundle.getParcelable("newMessageResult");
        if (newMessageResult != null) {
            ((CacheInsertThreadsHandler) this.f4619g.get()).a(newMessageResult, deltaWithSequenceId.b);
            ((CacheInsertThreadsHandler) this.f4619g.get()).c(newMessageResult.c, newMessageResult.clientTimeMs);
            this.f4617e.m3964a(newMessageResult.a.b);
        }
    }

    private NewMessageResult m4182a(ThreadSummary threadSummary, DeltaThreadImage deltaThreadImage, long j) {
        ThreadSummary a;
        NewMessageResult a2 = this.f4615c.a(new NewMessageResult(DataFreshnessResult.FROM_SERVER, this.f4616d.m4256a(deltaThreadImage, threadSummary), null, null, this.f4614b.a()), j);
        if (deltaThreadImage.image == null) {
            a = this.f4615c.a(threadSummary.a, null, null);
        } else {
            a = this.f4615c.a(threadSummary.a, Long.toString((long) Objects.hashCode(new Object[]{deltaThreadImage.image.filename})), m4181a(a2.a.a).toString());
        }
        return new NewMessageResult(a2.freshness, a2.a, a2.b, a, a2.b());
    }

    private Uri m4181a(String str) {
        Builder a = this.f4613a.a();
        a.appendQueryParameter("mid", AttachmentUriHelper.a(str));
        a.appendQueryParameter("aid", "1");
        a.appendQueryParameter("format", "binary");
        return a.build();
    }
}
