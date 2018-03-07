package com.facebook.reaction.feed.corecomponents.spec;

import android.text.TextUtils;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.InternalNode;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentMessage.Builder;
import com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentMessage.State;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLModels.ReactionCoreComponentTextSpecFieldsModel;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentsGraphQLInterfaces.ReactionCoreComponentTextFields;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: bar */
public class ReactionCoreTextComponentSpec {
    private static volatile ReactionCoreTextComponentSpec f19103b;
    private ReactionCoreTextComponentMessage f19104a;

    public static com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentSpec m23124a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19103b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentSpec.class;
        monitor-enter(r1);
        r0 = f19103b;	 Catch:{ all -> 0x003a }
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
        r0 = m23126b(r0);	 Catch:{ all -> 0x0035 }
        f19103b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19103b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentSpec");
    }

    private static ReactionCoreTextComponentSpec m23126b(InjectorLike injectorLike) {
        return new ReactionCoreTextComponentSpec(ReactionCoreTextComponentMessage.m23117a(injectorLike));
    }

    @Inject
    public ReactionCoreTextComponentSpec(ReactionCoreTextComponentMessage reactionCoreTextComponentMessage) {
        this.f19104a = reactionCoreTextComponentMessage;
    }

    protected final InternalNode m23127a(ComponentContext componentContext, ReactionCoreComponentTextFields reactionCoreComponentTextFields) {
        ContainerBuilder C = Container.a(componentContext).C(0);
        m23125a(componentContext, C, reactionCoreComponentTextFields.b(), reactionCoreComponentTextFields.c());
        m23125a(componentContext, C, reactionCoreComponentTextFields.d(), reactionCoreComponentTextFields.fZ_());
        m23125a(componentContext, C, reactionCoreComponentTextFields.g(), reactionCoreComponentTextFields.fY_());
        return C.j();
    }

    private void m23125a(ComponentContext componentContext, ContainerBuilder containerBuilder, DefaultTextWithEntitiesFields defaultTextWithEntitiesFields, ReactionCoreComponentTextSpecFieldsModel reactionCoreComponentTextSpecFieldsModel) {
        if (defaultTextWithEntitiesFields != null && !TextUtils.isEmpty(defaultTextWithEntitiesFields.a()) && reactionCoreComponentTextSpecFieldsModel != null) {
            State state = new State(this.f19104a);
            Builder builder = (Builder) ReactionCoreTextComponentMessage.f19098b.a();
            if (builder == null) {
                builder = new Builder();
            }
            Builder.m23114a(builder, componentContext, 0, state);
            Builder builder2 = builder;
            builder2.f19091a.f19095a = defaultTextWithEntitiesFields.a();
            builder2.f19094d.set(0);
            builder2 = builder2;
            builder2.f19091a.f19096b = reactionCoreComponentTextSpecFieldsModel;
            builder2.f19094d.set(1);
            containerBuilder.a(builder2);
        }
    }
}
