package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.widget.ImageView.ScaleType;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Image;
import com.facebook.components.widget.Text;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent.Builder;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitMessageAndBreadcrumbsComponentFragment.Breadcrumbs;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: a2a79d0cd9d8994cfebc170ffa05b929 */
public class ReactionBreadcrumbsComponentSpec<E extends CanLaunchReactionIntent & HasReactionSession> {
    private static volatile ReactionBreadcrumbsComponentSpec f20229b;
    private final ReactionActionDelegateComponent f20230a;

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionBreadcrumbsComponentSpec m24083a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f20229b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionBreadcrumbsComponentSpec.class;
        monitor-enter(r1);
        r0 = f20229b;	 Catch:{ all -> 0x003a }
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
        r0 = m24084b(r0);	 Catch:{ all -> 0x0035 }
        f20229b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20229b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionBreadcrumbsComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionBreadcrumbsComponentSpec");
    }

    private static ReactionBreadcrumbsComponentSpec m24084b(InjectorLike injectorLike) {
        return new ReactionBreadcrumbsComponentSpec(ReactionActionDelegateComponent.m24063a(injectorLike));
    }

    @Inject
    public ReactionBreadcrumbsComponentSpec(ReactionActionDelegateComponent reactionActionDelegateComponent) {
        this.f20230a = reactionActionDelegateComponent;
    }

    protected final ComponentLayout m24085a(ComponentContext componentContext, ImmutableList<? extends Breadcrumbs> immutableList, E e, String str, String str2) {
        ContainerBuilder a = Container.a(componentContext);
        UnmodifiableListIterator listIterator = immutableList.listIterator();
        while (listIterator.hasNext()) {
            Breadcrumbs breadcrumbs = (Breadcrumbs) listIterator.next();
            if (!(breadcrumbs.b() == null || Strings.isNullOrEmpty(breadcrumbs.b().a()))) {
                int i;
                Builder a2 = this.f20230a.m24066a(componentContext).m24058a(breadcrumbs.a());
                Text.Builder a3 = Text.a(componentContext);
                if (breadcrumbs.a() == null) {
                    i = 2131361974;
                } else {
                    i = 2131361916;
                }
                a.a(a2.m24055a(a3.l(i).a(breadcrumbs.b().a()).o(2131427400)).m24057a((CanLaunchReactionIntent) e).m24060b(str).m24061c(str2).c().g(5, 2131431416));
                if (listIterator.hasNext()) {
                    a.a(Image.a(componentContext).h(2130842916).a(ScaleType.CENTER));
                }
            }
        }
        return a.C(2).b(1.0f).E(2).D(1).j();
    }
}
