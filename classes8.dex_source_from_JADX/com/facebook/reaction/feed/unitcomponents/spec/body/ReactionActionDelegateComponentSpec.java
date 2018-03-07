package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.content.Context;
import android.view.View;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionCommonFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionFragment;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: a675785bc622c0d83714f4012a1a6af2 */
public class ReactionActionDelegateComponentSpec<E extends CanLaunchReactionIntent & HasReactionAnalyticsParams & HasReactionSession> {
    private static volatile ReactionActionDelegateComponentSpec f20211b;
    private final ReactionActionHandler f20212a;

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponentSpec m24069a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20211b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponentSpec.class;
        monitor-enter(r1);
        r0 = f20211b;	 Catch:{ all -> 0x003a }
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
        r0 = m24070b(r0);	 Catch:{ all -> 0x0035 }
        f20211b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20211b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponentSpec");
    }

    private static ReactionActionDelegateComponentSpec m24070b(InjectorLike injectorLike) {
        return new ReactionActionDelegateComponentSpec(ReactionActionHandler.m22673a(injectorLike));
    }

    @Inject
    public ReactionActionDelegateComponentSpec(ReactionActionHandler reactionActionHandler) {
        this.f20212a = reactionActionHandler;
    }

    protected final void m24071a(View view, ReactionStoryAttachmentActionFragment reactionStoryAttachmentActionFragment, String str, E e, String str2, String str3) {
        if (reactionStoryAttachmentActionFragment != null) {
            String str4;
            ReactionActionHandler reactionActionHandler = this.f20212a;
            Context context = view.getContext();
            if (reactionStoryAttachmentActionFragment.fU_() == null) {
                str4 = null;
            } else {
                str4 = reactionStoryAttachmentActionFragment.fU_().a();
            }
            e.mo696a(str2, str3, str, reactionActionHandler.m22677a((ReactionStoryAttachmentActionCommonFragment) reactionStoryAttachmentActionFragment, context, str4, ((HasReactionSession) e).mo704p().m22562f(), ((HasReactionSession) e).mo704p().m22575w(), str2, str3, ((HasReactionAnalyticsParams) e).mo706r()));
        }
    }
}
