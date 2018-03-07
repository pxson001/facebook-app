package com.facebook.feed.inlinecomposer.multirow;

import com.facebook.feed.inlinecomposer.multirow.work.InlineComposerHscrollRecyclerViewPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.work.InlineComposerWorkHeaderPartDefinition;
import com.facebook.feed.photoreminder.MediaReminderPromptsPromptPartDefinition;
import com.facebook.feed.photoreminder.v3.MediaReminderPromptLargePartDefinition;
import com.facebook.feed.photoreminder.v3.MediaReminderPromptSmallPartDefinition;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.friendsharing.meme.prompt.MemePromptPartDefinition;
import com.facebook.friendsharing.souvenirs.prompt.SouvenirPromptsPromptPartDefinition;
import com.facebook.friendsharing.souvenirs.prompt.v3.SouvenirPromptSmallPartDefinition;
import com.facebook.friendsharing.suggestedcoverphotos.prompt.CoverPhotoPromptPartDefinition;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.creativeediting.swipeable.prompt.FramePromptsPromptPartDefinition;
import com.facebook.photos.creativeediting.swipeable.prompt.v3.FramePromptSmallPartDefinition;
import com.facebook.productionprompts.ClipboardPromptsPromptPartDefinition;
import com.facebook.productionprompts.ProductionPromptsPromptPartDefinition;
import com.facebook.productionprompts.v3.ClipboardPromptSmallPartDefinition;
import com.facebook.productionprompts.v3.ProductionPromptSmallPartDefintion;
import com.google.common.collect.ImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: android_global_page_redirection */
public class InlineComposerRowSupportDeclaration implements FeedRowSupportDeclaration {
    private static volatile InlineComposerRowSupportDeclaration f19249a;

    public static com.facebook.feed.inlinecomposer.multirow.InlineComposerRowSupportDeclaration m22757a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19249a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.inlinecomposer.multirow.InlineComposerRowSupportDeclaration.class;
        monitor-enter(r1);
        r0 = f19249a;	 Catch:{ all -> 0x0039 }
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
        r0 = m22756a();	 Catch:{ all -> 0x0034 }
        f19249a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f19249a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.inlinecomposer.multirow.InlineComposerRowSupportDeclaration.a(com.facebook.inject.InjectorLike):com.facebook.feed.inlinecomposer.multirow.InlineComposerRowSupportDeclaration");
    }

    private static InlineComposerRowSupportDeclaration m22756a() {
        return new InlineComposerRowSupportDeclaration();
    }

    public final void m22758a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(InlineComposerV2HeaderPartDefinition.a, InlineComposerFooterPartDefinition.a, InlineComposerWorkHeaderPartDefinition.a, InlineComposerHscrollRecyclerViewPartDefinition.a, ProductionPromptsPromptPartDefinition.b, ClipboardPromptsPromptPartDefinition.a, MediaReminderPromptsPromptPartDefinition.f19688a, FramePromptsPromptPartDefinition.a, SouvenirPromptsPromptPartDefinition.f24110a, MemePromptPartDefinition.f23958a, CoverPhotoPromptPartDefinition.f24316a, ProductionPromptSmallPartDefintion.a, new ViewType[]{ClipboardPromptSmallPartDefinition.a, MediaReminderPromptSmallPartDefinition.f19789a, FramePromptSmallPartDefinition.a, SouvenirPromptSmallPartDefinition.f24133a, MediaReminderPromptLargePartDefinition.f19773a});
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }
}
