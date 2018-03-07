package com.facebook.reaction.feed.corecomponents.spec;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.TextUtils;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.reference.DrawableReference;
import com.facebook.graphql.enums.GraphQLReactionCoreComponentMargin;
import com.facebook.graphql.enums.GraphQLReactionCoreComponentPadding;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLInterfaces.ReactionCoreComponentBorderSpecFields;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLInterfaces.ReactionCoreComponentMarginSpecFields;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLInterfaces.ReactionCoreComponentPaddingSpecFields;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLModels.ReactionCoreComponentBorderSpecFieldsModel;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: baselineAligned */
public class ReactionCoreComponentSpec {
    private static volatile ReactionCoreComponentSpec f19041a;

    public static com.facebook.reaction.feed.corecomponents.spec.ReactionCoreComponentSpec m23086a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f19041a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.reaction.feed.corecomponents.spec.ReactionCoreComponentSpec.class;
        monitor-enter(r1);
        r0 = f19041a;	 Catch:{ all -> 0x0039 }
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
        r0 = m23085a();	 Catch:{ all -> 0x0034 }
        f19041a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f19041a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.corecomponents.spec.ReactionCoreComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.corecomponents.spec.ReactionCoreComponentSpec");
    }

    private static ReactionCoreComponentSpec m23085a() {
        return new ReactionCoreComponentSpec();
    }

    protected static ComponentLayout m23084a(ComponentContext componentContext, Component<?> component, String str, ReactionCoreComponentBorderSpecFields reactionCoreComponentBorderSpecFields, ReactionCoreComponentMarginSpecFields reactionCoreComponentMarginSpecFields, ReactionCoreComponentPaddingSpecFields reactionCoreComponentPaddingSpecFields) {
        ContainerBuilder a = Container.a(componentContext).a(component);
        if (reactionCoreComponentPaddingSpecFields != null) {
            a.n(1, m23082a(reactionCoreComponentPaddingSpecFields.d()));
            a.n(2, m23082a(reactionCoreComponentPaddingSpecFields.c()));
            a.n(3, m23082a(reactionCoreComponentPaddingSpecFields.a()));
            a.n(0, m23082a(reactionCoreComponentPaddingSpecFields.b()));
        }
        if (reactionCoreComponentMarginSpecFields != null) {
            a.j(1, m23081a(reactionCoreComponentMarginSpecFields.d()));
            a.j(2, m23081a(reactionCoreComponentMarginSpecFields.c()));
            a.j(3, m23081a(reactionCoreComponentMarginSpecFields.a()));
            a.j(0, m23081a(reactionCoreComponentMarginSpecFields.b()));
        }
        if (reactionCoreComponentBorderSpecFields != null) {
            a.a(DrawableReference.b().a(m23083a(componentContext.getResources(), reactionCoreComponentBorderSpecFields)));
        }
        ContainerBuilder a2 = Container.a(componentContext);
        if (TextUtils.isEmpty(str)) {
            a2.F(2130773596);
        } else {
            try {
                a2.H(Color.parseColor("#" + str));
            } catch (IllegalArgumentException e) {
                a2.F(2130773596);
            }
        }
        return a2.a(a).j();
    }

    private static Drawable m23083a(Resources resources, ReactionCoreComponentBorderSpecFieldsModel reactionCoreComponentBorderSpecFieldsModel) {
        int i = 0;
        int dimensionPixelSize = resources.getDimensionPixelSize(2131427379) * -1;
        Drawable drawable = resources.getDrawable(2130842898);
        int i2 = reactionCoreComponentBorderSpecFieldsModel.b() ? 0 : dimensionPixelSize;
        int i3 = reactionCoreComponentBorderSpecFieldsModel.d() ? 0 : dimensionPixelSize;
        int i4 = reactionCoreComponentBorderSpecFieldsModel.c() ? 0 : dimensionPixelSize;
        if (!reactionCoreComponentBorderSpecFieldsModel.a()) {
            i = dimensionPixelSize;
        }
        return new InsetDrawable(drawable, i2, i3, i4, i);
    }

    private static int m23081a(GraphQLReactionCoreComponentMargin graphQLReactionCoreComponentMargin) {
        if (graphQLReactionCoreComponentMargin == GraphQLReactionCoreComponentMargin.EXTRA_SMALL) {
            return 2131431490;
        }
        if (graphQLReactionCoreComponentMargin == GraphQLReactionCoreComponentMargin.SMALL) {
            return 2131431491;
        }
        if (graphQLReactionCoreComponentMargin == GraphQLReactionCoreComponentMargin.MEDIUM) {
            return 2131431492;
        }
        if (graphQLReactionCoreComponentMargin == GraphQLReactionCoreComponentMargin.LARGE) {
            return 2131431493;
        }
        if (graphQLReactionCoreComponentMargin == GraphQLReactionCoreComponentMargin.EXTRA_LARGE) {
            return 2131431494;
        }
        return 2131431489;
    }

    private static int m23082a(GraphQLReactionCoreComponentPadding graphQLReactionCoreComponentPadding) {
        if (graphQLReactionCoreComponentPadding == GraphQLReactionCoreComponentPadding.EXTRA_SMALL) {
            return 2131431490;
        }
        if (graphQLReactionCoreComponentPadding == GraphQLReactionCoreComponentPadding.SMALL) {
            return 2131431491;
        }
        if (graphQLReactionCoreComponentPadding == GraphQLReactionCoreComponentPadding.MEDIUM) {
            return 2131431492;
        }
        if (graphQLReactionCoreComponentPadding == GraphQLReactionCoreComponentPadding.LARGE) {
            return 2131431493;
        }
        if (graphQLReactionCoreComponentPadding == GraphQLReactionCoreComponentPadding.EXTRA_LARGE) {
            return 2131431494;
        }
        return 2131431489;
    }
}
