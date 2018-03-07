package com.facebook.feedback.ui.rows;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feedback.ui.rows.views.CommentHeaderView;
import com.facebook.feedback.ui.rows.views.CommentTruncatableHeaderView;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: ridge_mic_permission_denied */
public class CommentRowSupportDeclaration implements FeedRowSupportDeclaration {
    private static volatile CommentRowSupportDeclaration f5012a;

    public static com.facebook.feedback.ui.rows.CommentRowSupportDeclaration m5492a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5012a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feedback.ui.rows.CommentRowSupportDeclaration.class;
        monitor-enter(r1);
        r0 = f5012a;	 Catch:{ all -> 0x0039 }
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
        r0 = m5491a();	 Catch:{ all -> 0x0034 }
        f5012a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f5012a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.ui.rows.CommentRowSupportDeclaration.a(com.facebook.inject.InjectorLike):com.facebook.feedback.ui.rows.CommentRowSupportDeclaration");
    }

    private static CommentRowSupportDeclaration m5491a() {
        return new CommentRowSupportDeclaration();
    }

    public final void m5493a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(CommentTruncatableHeaderView.f5203m, CommentHeaderView.f5181m, CommentOfflineStatusPartDefinition.f4937a, CommentActionsPartDefinition.f4836a, CommentActionsWithReactionsPartDefinition.f4855a, ViewMoreRepliesPartDefinition.f5137a, LoadMoreCommentsPartDefinition.f5073a, OriginalPostButtonPartDefinition.f5085a, TypingIndicatorPartDefinition.f5128a, CommentPhotoAttachmentPartDefinition.f4942a, CommentVideoAttachmentPartDefinition.f5039a, CommentShareAttachmentPartDefinition.f5013a, new ViewType[]{CommentStickerAttachmentPartDefinition.f5017a, CommentPlaceInfoAttachmentPartDefinition.f4973a, CommentAddPlaceInfoAttachmentPartDefinition.f4875a, CommentReplyPartDefinition.f5008a, InlineReplyComposerPartDefinition.f5051b, RepliesCountPartDefinition.f5094a});
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }
}
