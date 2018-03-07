package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.text.SpannableStringBuilder;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.components.ComponentContext;
import com.facebook.components.InternalNode;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.unitcomponents.util.ReactionSpannableStringUtil;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.PlaceInfoBlurbFieldsModel;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: _openURL */
public class ReactionPlaceInfoBlurbUnitComponentSpec {
    private static volatile ReactionPlaceInfoBlurbUnitComponentSpec f20332d;
    private final ReactionCenteredParagraphUnitComponent f20333a;
    private final Clock f20334b;
    private final ReactionTruncatedParagraphUnitComponent f20335c;

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbUnitComponentSpec m24163a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20332d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbUnitComponentSpec.class;
        monitor-enter(r1);
        r0 = f20332d;	 Catch:{ all -> 0x003a }
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
        r0 = m24164b(r0);	 Catch:{ all -> 0x0035 }
        f20332d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20332d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbUnitComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbUnitComponentSpec");
    }

    private static ReactionPlaceInfoBlurbUnitComponentSpec m24164b(InjectorLike injectorLike) {
        return new ReactionPlaceInfoBlurbUnitComponentSpec(ReactionCenteredParagraphUnitComponent.m24091a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ReactionTruncatedParagraphUnitComponent.m24211a(injectorLike));
    }

    @Inject
    public ReactionPlaceInfoBlurbUnitComponentSpec(ReactionCenteredParagraphUnitComponent reactionCenteredParagraphUnitComponent, Clock clock, ReactionTruncatedParagraphUnitComponent reactionTruncatedParagraphUnitComponent) {
        this.f20333a = reactionCenteredParagraphUnitComponent;
        this.f20334b = clock;
        this.f20335c = reactionTruncatedParagraphUnitComponent;
    }

    protected final InternalNode m24165a(ComponentContext componentContext, String str, PlaceInfoBlurbFieldsModel placeInfoBlurbFieldsModel, DefaultTextWithEntitiesFields defaultTextWithEntitiesFields, DefaultTextWithEntitiesFields defaultTextWithEntitiesFields2, boolean z) {
        SpannableStringBuilder a = ReactionSpannableStringUtil.m24371a(this.f20334b, componentContext, defaultTextWithEntitiesFields == null ? null : defaultTextWithEntitiesFields.a(), str, placeInfoBlurbFieldsModel);
        if (z) {
            return this.f20335c.m24213a(componentContext).m24207a(a).m24208a(defaultTextWithEntitiesFields2).b();
        }
        return this.f20333a.m24093a(componentContext).m24087a(a).b();
    }
}
