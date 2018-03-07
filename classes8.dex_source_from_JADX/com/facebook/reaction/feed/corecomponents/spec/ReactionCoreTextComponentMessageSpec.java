package com.facebook.reaction.feed.corecomponents.spec;

import android.content.Context;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import com.facebook.components.ComponentContext;
import com.facebook.components.InternalNode;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Text;
import com.facebook.components.widget.Text.Builder;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.graphql.enums.GraphQLReactionCoreTextAlignment;
import com.facebook.graphql.enums.GraphQLReactionCoreTextSize;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.corecomponents.util.ReactionCoreComponentsUtil;
import com.facebook.reaction.feed.unitcomponents.util.ReactionSpannableStringUtil;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLModels.ReactionCoreComponentTextSpecFieldsModel;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: bar_color */
public class ReactionCoreTextComponentMessageSpec {
    private static volatile ReactionCoreTextComponentMessageSpec f19101b;
    private final AllCapsTransformationMethod f19102a;

    public static com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentMessageSpec m23121a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19101b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentMessageSpec.class;
        monitor-enter(r1);
        r0 = f19101b;	 Catch:{ all -> 0x003a }
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
        r0 = m23122b(r0);	 Catch:{ all -> 0x0035 }
        f19101b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19101b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentMessageSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentMessageSpec");
    }

    private static ReactionCoreTextComponentMessageSpec m23122b(InjectorLike injectorLike) {
        return new ReactionCoreTextComponentMessageSpec(AllCapsTransformationMethod.b(injectorLike));
    }

    @Inject
    public ReactionCoreTextComponentMessageSpec(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f19102a = allCapsTransformationMethod;
    }

    protected final InternalNode m23123a(ComponentContext componentContext, CharSequence charSequence, ReactionCoreComponentTextSpecFieldsModel reactionCoreComponentTextSpecFieldsModel) {
        int i;
        Alignment alignment;
        TruncateAt truncateAt;
        boolean z = !reactionCoreComponentTextSpecFieldsModel.g();
        int a = ReactionCoreComponentsUtil.m4768a(reactionCoreComponentTextSpecFieldsModel.d(), componentContext.getResources());
        GraphQLReactionCoreTextSize eZ_ = reactionCoreComponentTextSpecFieldsModel.eZ_();
        if (eZ_ == GraphQLReactionCoreTextSize.EXTRA_LARGE) {
            i = 2131427406;
        } else if (eZ_ == GraphQLReactionCoreTextSize.LARGE) {
            i = 2131427404;
        } else if (eZ_ == GraphQLReactionCoreTextSize.MEDIUM) {
            i = 2131427402;
        } else if (eZ_ == GraphQLReactionCoreTextSize.SMALL) {
            i = 2131427400;
        } else {
            i = 2131427402;
        }
        int i2 = i;
        if (reactionCoreComponentTextSpecFieldsModel.k()) {
            charSequence = this.f19102a.getTransformation(charSequence, null);
        }
        Builder k = Text.a(componentContext).d(ReactionCoreComponentsUtil.m4766a(reactionCoreComponentTextSpecFieldsModel.eY_())).o(i2).k(a);
        GraphQLReactionCoreTextAlignment a2 = reactionCoreComponentTextSpecFieldsModel.a();
        if (a2 == GraphQLReactionCoreTextAlignment.LEFT) {
            alignment = Alignment.ALIGN_NORMAL;
        } else if (a2 == GraphQLReactionCoreTextAlignment.CENTER) {
            alignment = Alignment.ALIGN_CENTER;
        } else if (a2 == GraphQLReactionCoreTextAlignment.RIGHT) {
            alignment = Alignment.ALIGN_OPPOSITE;
        } else {
            alignment = Alignment.ALIGN_NORMAL;
        }
        Builder a3 = k.a(alignment);
        if (reactionCoreComponentTextSpecFieldsModel.fa_() > 0) {
            charSequence = ReactionSpannableStringUtil.m24370a(componentContext.getResources(), new SpannableStringBuilder(charSequence), false, reactionCoreComponentTextSpecFieldsModel.j(), a, componentContext.getResources().getDimensionPixelSize(i2), reactionCoreComponentTextSpecFieldsModel.fa_());
        }
        Builder b = a3.a(charSequence).a(ReactionCoreComponentsUtil.m4769a((Context) componentContext, reactionCoreComponentTextSpecFieldsModel.b())).b(z);
        if (z) {
            truncateAt = TruncateAt.END;
        } else {
            truncateAt = null;
        }
        return b.a(truncateAt).b();
    }
}
