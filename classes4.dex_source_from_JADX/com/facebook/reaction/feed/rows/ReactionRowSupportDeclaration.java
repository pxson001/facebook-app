package com.facebook.reaction.feed.rows;

import android.support.annotation.Nullable;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.inject.InjectorLike;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.feed.common.ReactionDividerUnitComponentPartDefinition;
import com.facebook.reaction.feed.pages.PagesPinnedPostHeaderPartDefinition;
import com.facebook.reaction.feed.rows.attachments.ReactionAttachmentsFallbackPartDefinition;
import com.facebook.reaction.feed.rows.attachments.ReactionEventBlocksAttachmentPartDefinition;
import com.facebook.reaction.feed.rows.attachments.ReactionImageTextBlockAttachmentPartDefinition;
import com.facebook.reaction.feed.rows.attachments.ReactionProfileStoryAttachmentPartDefinition;
import com.facebook.reaction.feed.rows.attachments.ReactionProfileStoryWithIconAttachmentPartDefinition;
import com.facebook.reaction.feed.rows.attachments.ReactionSimpleLeftRightTextAttachmentPartDefinition;
import com.facebook.reaction.feed.rows.attachments.ReactionSinglePhotoAttachmentPartDefinition;
import com.facebook.reaction.feed.rows.attachments.ReactionTopicBlocksAttachmentPartDefinition;
import com.facebook.reaction.feed.rows.ui.ReactionImageStoryBlockUnitComponentView;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionActionListUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionArticleUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionBannerHighlightableUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionCollapsableIconMessageUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionCollapsableIconMessageWithCaretUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionCollapsedIconMessageUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionCountsHorizontalUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionCrisisActionUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionEventRowUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionExpandableUnitComponentPromptPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionFacepileHScrollUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionFigActionFooterPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionFigFooterPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionFormattedParagraphUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionFundraiserAmountRaisedUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionGroupDescriptionPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionHScrollGenericComponentsListPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionHScrollUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionHeaderWithVerifiedBadgeComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionIconMessageAutoActionUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionIconMessageUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionIconMessageUnitComponentWithMenuPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionIconOverMessageUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionImageWithOverlayGridUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionInfoRowDividerPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionInfoRowUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionInfoRowWithRightIconUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionPageMapWithNavigationUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionPaginatedHScrollUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionPaginatedVScrollGenericComponentsGapPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionPhotoFullWidthCounterUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionPhotoFullWidthPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionPhotoUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionPhotosUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionPlaceholderPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionPostPivotUnitComponentDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionProgressBarUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionReviewComposerUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionReviewUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionScrollingLabelPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionSimpleTextUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionSingleButtonUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionSingleImageUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionStaticMapUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionStoryBlockUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionTextWithInlineFacepileUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionTwoMessageUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionVerticalComponentsGapPartDefinition;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: notif_option_set_context */
public class ReactionRowSupportDeclaration implements FeedRowSupportDeclaration, RecyclableViewsDeclaration {
    private static volatile ReactionRowSupportDeclaration f6908c;
    @Nullable
    private List<ViewType> f6909a;
    private final QeAccessor f6910b;

    public static com.facebook.reaction.feed.rows.ReactionRowSupportDeclaration m7223a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6908c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.rows.ReactionRowSupportDeclaration.class;
        monitor-enter(r1);
        r0 = f6908c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m7224b(r0);	 Catch:{ all -> 0x0035 }
        f6908c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6908c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.rows.ReactionRowSupportDeclaration.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.rows.ReactionRowSupportDeclaration");
    }

    private static ReactionRowSupportDeclaration m7224b(InjectorLike injectorLike) {
        return new ReactionRowSupportDeclaration((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ReactionRowSupportDeclaration(QeAccessor qeAccessor) {
        this.f6910b = qeAccessor;
    }

    public final void m7225a(ListItemRowController listItemRowController) {
        if (!this.f6910b.a(ExperimentsForFeedbackTestModule.y, false) || this.f6909a == null) {
            this.f6909a = ImmutableList.of(ReactionArticleUnitComponentPartDefinition.a, ReactionActionListUnitComponentPartDefinition.a, ReactionAttachmentsFallbackPartDefinition.a, ReactionBannerHighlightableUnitComponentPartDefinition.b, ReactionCenterAlignedHeaderPartDefinition.a, ReactionCollapsableIconMessageUnitComponentPartDefinition.a, ReactionCollapsableIconMessageWithCaretUnitComponentPartDefinition.a, ReactionCollapsableStoryIconHeaderPartDefinition.a, ReactionCollapsedIconMessageUnitComponentPartDefinition.a, ReactionCountsHorizontalUnitComponentPartDefinition.a, ReactionCrisisActionUnitComponentPartDefinition.a, ReactionDescriptiveHeaderPartDefinition.a, new ViewType[]{ReactionDividerUnitComponentPartDefinition.a, ReactionEventBlocksAttachmentPartDefinition.a, ReactionEventRowUnitComponentPartDefinition.a, ReactionEventSubscribeHeaderPartDefinition.a, ReactionExpandableUnitComponentPromptPartDefinition.a, ReactionFacepileHScrollUnitComponentPartDefinition.a, ReactionFigActionFooterPartDefinition.a, ReactionFigFooterPartDefinition.a, ComponentPartDefinition.a, ReactionFormattedParagraphUnitComponentPartDefinition.a, ReactionFundraiserAmountRaisedUnitComponentPartDefinition.b, ReactionGroupDescriptionPartDefinition.a, ReactionHeaderWithVerifiedBadgeComponentPartDefinition.a, ReactionHScrollGenericComponentsListPartDefinition.a, ReactionIconHeaderPartDefinition.a, ReactionIconHeaderWithActionPartDefinition.a, ReactionIconInlineActionHeaderPartDefinition.a, ReactionIconMenuHeaderPartDefinition.a, ReactionIconMessageAutoActionUnitComponentPartDefinition.a, ReactionIconMessageUnitComponentPartDefinition.a, ReactionIconMessageUnitComponentWithMenuPartDefinition.a, ReactionIconOverMessageUnitComponentPartDefinition.a, ReactionIconPivotHeaderPartDefinition.a, ReactionImageStoryBlockUnitComponentView.a, ReactionImageTextBlockAttachmentPartDefinition.a, ReactionImageWithOverlayGridUnitComponentPartDefinition.a, ReactionInfoRowDividerPartDefinition.a, ReactionInfoRowUnitComponentPartDefinition.a, ReactionInfoRowWithRightIconUnitComponentPartDefinition.a, ReactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition.a, ComponentPartDefinition.a, ReactionMultiActionFooterPartDefinition.a, ReactionMultiFacepileHeaderPartDefinition.a, ReactionPageMapWithNavigationUnitComponentPartDefinition.a, ReactionPaginatedHScrollUnitComponentPartDefinition.f6920a, ReactionPaginatedVScrollGenericComponentsGapPartDefinition.a, ReactionPhotoFullWidthCounterUnitComponentPartDefinition.b, ReactionPhotosUnitComponentPartDefinition.a, ReactionPhotoUnitComponentPartDefinition.a, ReactionPlaceholderPartDefinition.a, ReactionPostPivotUnitComponentDefinition.a, ReactionProfileStoryAttachmentPartDefinition.a, ReactionProfileStoryWithIconAttachmentPartDefinition.a, ReactionProgressBarUnitComponentPartDefinition.b, ReactionReviewComposerUnitComponentPartDefinition.a, ReactionReviewUnitComponentPartDefinition.c, ReactionScrollingLabelPartDefinition.a, ReactionSimpleLeftRightTextAttachmentPartDefinition.a, ReactionSimpleTextUnitComponentPartDefinition.a, ReactionSingleActionFooterPartDefinition.a, ReactionSingleButtonUnitComponentPartDefinition.a, ReactionSingleFacepileHeaderPartDefinition.a, ReactionSingleImageUnitComponentPartDefinition.a, ReactionSinglePhotoAttachmentPartDefinition.a, ReactionStaticMapUnitComponentPartDefinition.a, ReactionStoryBlockUnitComponentPartDefinition.a, ReactionStoryBottomWithMarginPartDefinition.a, ReactionStoryTopWithMarginPartDefinition.a, ReactionTextWithInlineFacepileUnitComponentPartDefinition.a, ReactionTopicBlocksAttachmentPartDefinition.a, ReactionTwoMessageUnitComponentPartDefinition.a, ReactionUnitStackPartDefinition.a, ReactionVerticalComponentsGapPartDefinition.a, PagesPinnedPostHeaderPartDefinition.a, ComponentPartDefinition.a});
        }
        for (ViewType a : this.f6909a) {
            listItemRowController.a(a);
        }
    }

    public final void m7226a(RecyclableViewPoolManager recyclableViewPoolManager) {
        RecyclableViewTypeUtil.m6979a(recyclableViewPoolManager, ReactionHScrollUnitComponentPartDefinition.f6911a);
        RecyclableViewTypeUtil.m6979a(recyclableViewPoolManager, ReactionHScrollUnitComponentPartDefinition.f6912b);
        RecyclableViewTypeUtil.m6979a(recyclableViewPoolManager, ReactionPaginatedHScrollUnitComponentPartDefinition.f6920a);
        RecyclableViewTypeUtil.m6979a(recyclableViewPoolManager, ReactionPhotoFullWidthPartDefinition.f6933a);
    }
}
