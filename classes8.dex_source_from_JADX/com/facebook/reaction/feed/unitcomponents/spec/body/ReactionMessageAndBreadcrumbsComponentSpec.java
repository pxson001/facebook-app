package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.text.Layout.Alignment;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Text;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionBreadcrumbsComponent.Builder;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionBreadcrumbsComponent.State;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitMessageAndBreadcrumbsComponentFragment.Breadcrumbs;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: _startActivityForUrl */
public class ReactionMessageAndBreadcrumbsComponentSpec<E extends CanLaunchReactionIntent & HasReactionSession> {
    private static volatile ReactionMessageAndBreadcrumbsComponentSpec f20300b;
    private final ReactionBreadcrumbsComponent f20301a;

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionMessageAndBreadcrumbsComponentSpec m24142a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20300b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionMessageAndBreadcrumbsComponentSpec.class;
        monitor-enter(r1);
        r0 = f20300b;	 Catch:{ all -> 0x003a }
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
        r0 = m24143b(r0);	 Catch:{ all -> 0x0035 }
        f20300b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20300b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionMessageAndBreadcrumbsComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionMessageAndBreadcrumbsComponentSpec");
    }

    private static ReactionMessageAndBreadcrumbsComponentSpec m24143b(InjectorLike injectorLike) {
        return new ReactionMessageAndBreadcrumbsComponentSpec(ReactionBreadcrumbsComponent.m24079a(injectorLike));
    }

    @Inject
    public ReactionMessageAndBreadcrumbsComponentSpec(ReactionBreadcrumbsComponent reactionBreadcrumbsComponent) {
        this.f20301a = reactionBreadcrumbsComponent;
    }

    protected final ComponentLayout m24144a(ComponentContext componentContext, String str, ImmutableList<? extends Breadcrumbs> immutableList, E e, String str2, String str3) {
        ContainerBuilder F = Container.a(componentContext).F(2130773596);
        ContainerBuilder a = Container.a(componentContext).C(0).E(2).i(5, 2130773575).n(8, 2131431413).a(Text.a(componentContext).o(2131427408).a(Alignment.ALIGN_CENTER).a(str));
        ReactionBreadcrumbsComponent reactionBreadcrumbsComponent = this.f20301a;
        State state = new State(reactionBreadcrumbsComponent);
        Builder builder = (Builder) reactionBreadcrumbsComponent.f20228c.a();
        if (builder == null) {
            builder = new Builder(reactionBreadcrumbsComponent);
        }
        Builder.m24072a(builder, componentContext, 0, state);
        return F.a(a.a(builder.m24074a((ImmutableList) immutableList).m24073a((CanLaunchReactionIntent) e).m24075a(str2).m24077b(str3).c().c(1, 2131431417))).j();
    }
}
