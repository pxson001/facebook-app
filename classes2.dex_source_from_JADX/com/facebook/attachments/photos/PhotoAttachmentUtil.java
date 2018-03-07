package com.facebook.attachments.photos;

import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.proxygen.HTTPTransportCallback;
import javax.inject.Singleton;

@Singleton
/* compiled from: hide_link */
public class PhotoAttachmentUtil {
    private static volatile PhotoAttachmentUtil f21569a;

    public static com.facebook.attachments.photos.PhotoAttachmentUtil m29272a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f21569a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.attachments.photos.PhotoAttachmentUtil.class;
        monitor-enter(r1);
        r0 = f21569a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m29271a();	 Catch:{ all -> 0x0034 }
        f21569a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f21569a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.attachments.photos.PhotoAttachmentUtil.a(com.facebook.inject.InjectorLike):com.facebook.attachments.photos.PhotoAttachmentUtil");
    }

    private static PhotoAttachmentUtil m29271a() {
        return new PhotoAttachmentUtil();
    }

    public static FullscreenGallerySource m29273a(StoryRenderContext storyRenderContext) {
        if (storyRenderContext == null) {
            return FullscreenGallerySource.UNKNOWN;
        }
        switch (1.a[storyRenderContext.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return FullscreenGallerySource.NEWSFEED;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return FullscreenGallerySource.TIMELINE_WALL;
            default:
                return FullscreenGallerySource.OTHER;
        }
    }

    public static FullscreenGallerySource m29274a(FeedListType feedListType) {
        if (feedListType == null) {
            return FullscreenGallerySource.UNKNOWN;
        }
        switch (1.b[feedListType.mo2419a().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return FullscreenGallerySource.NEWSFEED;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return FullscreenGallerySource.TIMELINE_WALL;
            default:
                return FullscreenGallerySource.OTHER;
        }
    }
}
