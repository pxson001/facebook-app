package com.facebook.feed.model;

import com.facebook.debug.log.BLog;
import com.facebook.feed.flatbuffers.FlatBufferFileLoader;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandler;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.VirtualFlattenableResolverImpl;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sessioned_index.bin */
public class FeedUnitInflater {
    private static volatile FeedUnitInflater f5386b;
    private final FlatBufferFileLoader f5387a;

    public static com.facebook.feed.model.FeedUnitInflater m9272a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5386b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.model.FeedUnitInflater.class;
        monitor-enter(r1);
        r0 = f5386b;	 Catch:{ all -> 0x003a }
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
        r0 = m9275b(r0);	 Catch:{ all -> 0x0035 }
        f5386b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5386b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.model.FeedUnitInflater.a(com.facebook.inject.InjectorLike):com.facebook.feed.model.FeedUnitInflater");
    }

    private static FeedUnitInflater m9275b(InjectorLike injectorLike) {
        return new FeedUnitInflater(FlatBufferFileLoaderMethodAutoProvider.m9277a(injectorLike));
    }

    @Inject
    public FeedUnitInflater(FlatBufferFileLoader flatBufferFileLoader) {
        this.f5387a = flatBufferFileLoader;
    }

    public final FeedUnit m9276a(ClientFeedUnitEdge clientFeedUnitEdge) {
        ByteBuffer byteBuffer;
        FeedUnit feedUnit = null;
        if (Strings.isNullOrEmpty(clientFeedUnitEdge.m21230o()) || clientFeedUnitEdge.m21232q() <= 0) {
            byteBuffer = null;
        } else {
            try {
                byteBuffer = this.f5387a.m9279a(clientFeedUnitEdge.m21230o(), clientFeedUnitEdge.m21231p(), clientFeedUnitEdge.m21232q());
            } catch (IOException e) {
                byteBuffer = null;
            }
            this.f5387a.m9280a();
        }
        if (byteBuffer != null) {
            FeedUnitCommon a = m9273a(byteBuffer, clientFeedUnitEdge.m21234s(), clientFeedUnitEdge.m21235t(), clientFeedUnitEdge.m21236u(), clientFeedUnitEdge.m21240y(), clientFeedUnitEdge.m21233r());
            if (a != null) {
                if ((a instanceof GraphQLStory) && ((GraphQLStory) a).ah()) {
                    PropertyHelper.m21301e((GraphQLStory) a, clientFeedUnitEdge.m21239x() != 0);
                }
                m9274a(a, clientFeedUnitEdge.m21237v(), DedupableUtil.m23084a(clientFeedUnitEdge), clientFeedUnitEdge.m19084d(), String.valueOf(clientFeedUnitEdge.m21238w()));
                FetchTimeMsHelper.m22314a(a, clientFeedUnitEdge.m21238w());
            }
        }
        return feedUnit;
    }

    private static void m9274a(FeedUnit feedUnit, String str, String str2, String str3, String str4) {
        MutableFlatBuffer w_ = feedUnit.w_();
        if (w_ != null) {
            w_.m21539a(0, (Object) str);
            w_.m21539a(1, (Object) str2);
            w_.m21539a(2, (Object) str3);
            w_.m21539a(3, (Object) str4);
        }
    }

    private static FeedUnit m9273a(@Nullable ByteBuffer byteBuffer, boolean z, @Nullable ByteBuffer byteBuffer2, @Nullable ByteBuffer byteBuffer3, DefaultFlatBufferCorruptionHandler defaultFlatBufferCorruptionHandler, int i) {
        if (byteBuffer == null) {
            return null;
        }
        FeedUnit feedUnit;
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(byteBuffer, byteBuffer2, byteBuffer3, z, defaultFlatBufferCorruptionHandler);
            if (i != 0) {
                feedUnit = (FeedUnit) mutableFlatBuffer.m21527a(i, VirtualFlattenableResolverImpl.f15617a);
            } else {
                feedUnit = (FeedUnit) mutableFlatBuffer.m21529a(VirtualFlattenableResolverImpl.f15617a);
            }
        } catch (Throwable e) {
            BLog.c("FlatBuffer", e, "Error deserializing feed unit from flatbuffer", new Object[0]);
            feedUnit = null;
        }
        if (feedUnit != null) {
            return feedUnit;
        }
        BLog.c("FlatBuffer", "unable to resolve root flattenable feed unit from flatbuffer");
        return feedUnit;
    }
}
