package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import com.facebook.components.ComponentContext;
import com.facebook.components.InternalNode;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionCenteredParagraphUnitComponent.Builder;
import com.facebook.reaction.feed.unitcomponents.util.ReactionSpannableStringUtil;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: __user */
public class ReactionTruncatedParagraphUnitComponentSpec {
    private static volatile ReactionTruncatedParagraphUnitComponentSpec f20423b;
    private final ReactionCenteredParagraphUnitComponent f20424a;

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionTruncatedParagraphUnitComponentSpec m24216a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20423b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionTruncatedParagraphUnitComponentSpec.class;
        monitor-enter(r1);
        r0 = f20423b;	 Catch:{ all -> 0x003a }
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
        r0 = m24217b(r0);	 Catch:{ all -> 0x0035 }
        f20423b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20423b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionTruncatedParagraphUnitComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionTruncatedParagraphUnitComponentSpec");
    }

    private static ReactionTruncatedParagraphUnitComponentSpec m24217b(InjectorLike injectorLike) {
        return new ReactionTruncatedParagraphUnitComponentSpec(ReactionCenteredParagraphUnitComponent.m24091a(injectorLike));
    }

    @Inject
    public ReactionTruncatedParagraphUnitComponentSpec(ReactionCenteredParagraphUnitComponent reactionCenteredParagraphUnitComponent) {
        this.f20424a = reactionCenteredParagraphUnitComponent;
    }

    protected final InternalNode m24218a(ComponentContext componentContext, SpannableStringBuilder spannableStringBuilder, boolean z, DefaultTextWithEntitiesFields defaultTextWithEntitiesFields, GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
        int i;
        Builder a = this.f20424a.m24093a(componentContext);
        Resources resources = componentContext.getResources();
        Resources resources2 = componentContext.getResources();
        if (graphQLReactionUnitComponentStyle == null || graphQLReactionUnitComponentStyle != GraphQLReactionUnitComponentStyle.LEFT_DARK_PARAGRAPH_LONG_TRUNCATION) {
            i = 2131361974;
        } else {
            i = 2131361972;
        }
        int color = resources2.getColor(i);
        resources2 = componentContext.getResources();
        if (graphQLReactionUnitComponentStyle == null || graphQLReactionUnitComponentStyle != GraphQLReactionUnitComponentStyle.LEFT_DARK_PARAGRAPH_LONG_TRUNCATION) {
            i = 2131427400;
        } else {
            i = 2131427402;
        }
        int dimensionPixelSize = resources2.getDimensionPixelSize(i);
        if (graphQLReactionUnitComponentStyle == null || graphQLReactionUnitComponentStyle != GraphQLReactionUnitComponentStyle.LEFT_DARK_PARAGRAPH_LONG_TRUNCATION) {
            i = 2;
        } else {
            i = 5;
        }
        return a.m24087a(ReactionSpannableStringUtil.m24369a(resources, spannableStringBuilder, z, defaultTextWithEntitiesFields, color, dimensionPixelSize, i)).m24088a(graphQLReactionUnitComponentStyle).b();
    }
}
