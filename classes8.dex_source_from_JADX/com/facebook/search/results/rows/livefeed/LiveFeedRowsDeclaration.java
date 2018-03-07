package com.facebook.search.results.rows.livefeed;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedGapPartDefinition;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedMain360VideoAttachmentPartDefinition;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedMainHeaderPartDefinition;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedMainPhotoAttachmentPartDefinition;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedMainVideoAttachmentPartDefinition;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedResharedAttachment360VideoPartDefinition;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedResharedAttachmentHeaderPartDefinition;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedResharedAttachmentPhotoPartDefinition;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedResharedAttachmentVideoPartDefinition;
import com.google.common.collect.ImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: RapidReportingMutation */
public class LiveFeedRowsDeclaration implements FeedRowSupportDeclaration {
    private static volatile LiveFeedRowsDeclaration f23595a;

    public static com.facebook.search.results.rows.livefeed.LiveFeedRowsDeclaration m27257a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f23595a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.rows.livefeed.LiveFeedRowsDeclaration.class;
        monitor-enter(r1);
        r0 = f23595a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m27256a();	 Catch:{ all -> 0x0034 }
        f23595a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f23595a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.rows.livefeed.LiveFeedRowsDeclaration.a(com.facebook.inject.InjectorLike):com.facebook.search.results.rows.livefeed.LiveFeedRowsDeclaration");
    }

    private static LiveFeedRowsDeclaration m27256a() {
        return new LiveFeedRowsDeclaration();
    }

    public final void m27258a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(LiveFeedMainHeaderPartDefinition.f24483a, LiveFeedResharedAttachmentHeaderPartDefinition.f24538a, LiveFeedMainPhotoAttachmentPartDefinition.f24492a, LiveFeedResharedAttachmentPhotoPartDefinition.f24543a, LiveFeedMainVideoAttachmentPartDefinition.f24498a, LiveFeedMain360VideoAttachmentPartDefinition.f24476a, LiveFeedResharedAttachmentVideoPartDefinition.f24548a, LiveFeedResharedAttachment360VideoPartDefinition.f24519a, LiveFeedGapPartDefinition.f24439a);
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }
}
