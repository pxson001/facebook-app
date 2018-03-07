package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils.TruncateAt;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.Builder;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.InternalNode;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.components.reference.ColorDrawableReference;
import com.facebook.components.widget.Text;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: _u */
public class ReactionImageBlockComponentSpec {
    private static final CallerContext f20280a = CallerContext.a(ReactionImageBlockComponent.class);
    private static volatile ReactionImageBlockComponentSpec f20281c;
    private final FbDraweeControllerBuilder f20282b;

    /* compiled from: _u */
    /* synthetic */ class C21591 {
        static final /* synthetic */ int[] f20279a = new int[GraphQLReactionUnitComponentStyle.values().length];

        static {
            try {
                f20279a[GraphQLReactionUnitComponentStyle.PROMPT_IMAGE_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20279a[GraphQLReactionUnitComponentStyle.NOTIFICATION_IMAGE_BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20279a[GraphQLReactionUnitComponentStyle.ICON_MESSAGE_SMALL_TITLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionImageBlockComponentSpec m24130a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20281c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionImageBlockComponentSpec.class;
        monitor-enter(r1);
        r0 = f20281c;	 Catch:{ all -> 0x003a }
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
        r0 = m24132b(r0);	 Catch:{ all -> 0x0035 }
        f20281c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20281c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionImageBlockComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionImageBlockComponentSpec");
    }

    private static ReactionImageBlockComponentSpec m24132b(InjectorLike injectorLike) {
        return new ReactionImageBlockComponentSpec(FbDraweeControllerBuilder.b(injectorLike));
    }

    @Inject
    public ReactionImageBlockComponentSpec(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f20282b = fbDraweeControllerBuilder;
    }

    protected final InternalNode m24134a(ComponentContext componentContext, Uri uri, String str, String str2, Uri uri2, GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
        Builder builder = null;
        ContainerBuilder F = Container.a(componentContext).F(2130773596);
        ContainerBuilder a = Container.a(componentContext).C(2).E(2).i(5, 2130773575).a(FbFrescoComponent.a(componentContext).a(ColorDrawableReference.a(componentContext).i(2131361970).b()).a(this.f20282b.b(uri).a(f20280a).s()).c().p(m24128a(graphQLReactionUnitComponentStyle)).l(m24128a(graphQLReactionUnitComponentStyle)).c(8, 2131431413).c(2, 2131431416)).a(Container.a(componentContext).C(0).b(1.0f).D(1).n(2, 2131431413).a(Text.a(componentContext).b(true).d(1.14f).a(str).a(TruncateAt.END).l(m24131b(graphQLReactionUnitComponentStyle)).a(m24129a(graphQLReactionUnitComponentStyle, componentContext)).o(m24133c(graphQLReactionUnitComponentStyle))).a(Strings.isNullOrEmpty(str2) ? null : Text.a(componentContext).d(1.33f).j(3).o(2131427400).a(TruncateAt.END).l(2131361974).a(str2)));
        if (uri2 != null) {
            builder = FbFrescoComponent.a(componentContext).a(this.f20282b.b(uri2).a(f20280a).s()).c().p(2131431407).l(2131431407).c(8, 2131431413);
        }
        return F.a(a.a(builder)).j();
    }

    private static int m24128a(GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
        switch (C21591.f20279a[graphQLReactionUnitComponentStyle.ordinal()]) {
            case 1:
            case 2:
                return 2131431410;
            default:
                return 2131431409;
        }
    }

    private static int m24131b(GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
        switch (C21591.f20279a[graphQLReactionUnitComponentStyle.ordinal()]) {
            case 1:
                return 2131361917;
            case 3:
                return 2131361973;
            default:
                return 2131361972;
        }
    }

    private static Typeface m24129a(GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle, Context context) {
        switch (C21591.f20279a[graphQLReactionUnitComponentStyle.ordinal()]) {
            case 3:
                return Typeface.DEFAULT;
            default:
                return CustomFontHelper.a(context, FontFamily.ROBOTO, FontWeight.MEDIUM, null);
        }
    }

    private static int m24133c(GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
        switch (C21591.f20279a[graphQLReactionUnitComponentStyle.ordinal()]) {
            case 3:
                return 2131427400;
            default:
                return 2131427402;
        }
    }
}
