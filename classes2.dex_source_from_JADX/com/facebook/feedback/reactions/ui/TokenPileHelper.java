package com.facebook.feedback.reactions.ui;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedbackHelper;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTopReactionsConnection;
import com.facebook.graphql.model.GraphQLTopReactionsEdge;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: glGenTextures */
public class TokenPileHelper {
    private static final Ordering<GraphQLTopReactionsEdge> f22260a = NaturalOrdering.f22266a.mo3241a().m30182a(new C09011());
    private static volatile TokenPileHelper f22261f;
    private final RTLUtil f22262b;
    private final Provider<TokenPileDrawable> f22263c;
    public final FeedbackReactionsController f22264d;
    private final Ordering<GraphQLTopReactionsEdge> f22265e = NaturalOrdering.f22266a.m30182a(new C09022(this));

    /* compiled from: glGenTextures */
    final class C09011 implements Function<GraphQLTopReactionsEdge, Integer> {
        C09011() {
        }

        public final Object apply(Object obj) {
            return Integer.valueOf(((GraphQLTopReactionsEdge) obj).m27553j());
        }
    }

    /* compiled from: glGenTextures */
    class C09022 implements Function<GraphQLTopReactionsEdge, Integer> {
        final /* synthetic */ TokenPileHelper f22268a;

        C09022(TokenPileHelper tokenPileHelper) {
            this.f22268a = tokenPileHelper;
        }

        public Object apply(Object obj) {
            GraphQLTopReactionsEdge graphQLTopReactionsEdge = (GraphQLTopReactionsEdge) obj;
            int i = Integer.MAX_VALUE;
            if (this.f22268a.f22264d == null || this.f22268a.f22264d.f21389d == null) {
                return Integer.valueOf(Integer.MAX_VALUE);
            }
            int indexOf = this.f22268a.f22264d.f21389d.indexOf(this.f22268a.f22264d.m29087a(graphQLTopReactionsEdge.m27550a().m27561m()));
            if (indexOf >= 0) {
                i = indexOf;
            }
            return Integer.valueOf(i);
        }
    }

    public static com.facebook.feedback.reactions.ui.TokenPileHelper m30171a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22261f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.reactions.ui.TokenPileHelper.class;
        monitor-enter(r1);
        r0 = f22261f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m30173b(r0);	 Catch:{ all -> 0x0035 }
        f22261f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22261f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.ui.TokenPileHelper.a(com.facebook.inject.InjectorLike):com.facebook.feedback.reactions.ui.TokenPileHelper");
    }

    private static TokenPileHelper m30173b(InjectorLike injectorLike) {
        return new TokenPileHelper(RTLUtil.m6553a(injectorLike), IdBasedProvider.m1811a(injectorLike, 1788), FeedbackReactionsController.m29084a(injectorLike));
    }

    @Inject
    public TokenPileHelper(RTLUtil rTLUtil, Provider<TokenPileDrawable> provider, FeedbackReactionsController feedbackReactionsController) {
        this.f22262b = rTLUtil;
        this.f22263c = provider;
        this.f22264d = feedbackReactionsController;
    }

    public final void m30175a(GraphQLFeedback graphQLFeedback, TextView textView) {
        List a = m30174a(graphQLFeedback);
        if (a.isEmpty()) {
            m30172a(textView);
            return;
        }
        textView.setTypeface(textView.getTypeface(), 1);
        TokenPileDrawable tokenPileDrawable = (TokenPileDrawable) this.f22263c.get();
        tokenPileDrawable.m30215a(a);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (this.f22262b.m6557a()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], tokenPileDrawable, compoundDrawables[3]);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(tokenPileDrawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    public static void m30172a(TextView textView) {
        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        textView.setTypeface(Typeface.DEFAULT);
    }

    public final ImmutableList<FeedbackReaction> m30174a(GraphQLFeedback graphQLFeedback) {
        GraphQLTopReactionsConnection a = GraphQLFeedbackHelper.m30217a(graphQLFeedback);
        if (a != null && a.m24899a() != null) {
            ImmutableList d = f22260a.m30188b(this.f22265e).m30194d(a.m24899a());
            Builder builder = ImmutableList.builder();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                GraphQLTopReactionsEdge graphQLTopReactionsEdge = (GraphQLTopReactionsEdge) d.get(i);
                FeedbackReaction a2 = this.f22264d.m29087a(graphQLTopReactionsEdge.m27550a().m27561m());
                if (graphQLTopReactionsEdge.m27553j() > 0 && a2 != FeedbackReaction.f21476c) {
                    builder.m1069c(a2);
                }
            }
            return builder.m1068b();
        } else if (GraphQLHelper.m22522p(graphQLFeedback) > 0) {
            return ImmutableList.of(this.f22264d.m29087a(1));
        } else {
            return RegularImmutableList.f535a;
        }
    }
}
