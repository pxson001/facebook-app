package com.facebook.feedback.reactions.ui;

import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.model.GraphQLFeedbackReaction;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommonex.LocaleChangeController;
import com.facebook.languages.switchercommonex.LocaleChangeListener;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: has_app_link */
public class FeedbackReactionsController implements LocaleChangeListener {
    private static volatile FeedbackReactionsController f21385f;
    private final ReactionModelFactory f21386a;
    private final FeedbackReactionsDownloader f21387b;
    private final Provider<StaticReactionFactory> f21388c;
    public ImmutableList<FeedbackReaction> f21389d = m29085a(this.f21386a);
    @Nullable
    private ImmutableList<FeedbackReaction> f21390e;

    /* compiled from: has_app_link */
    public enum ImageFormat {
        SMALL("feedback/reactions/small_images/"),
        LARGE("feedback/reactions/large_images/"),
        TAB_ICONS("feedback/reactions/tab_icons/"),
        VECTOR("feedback/reactions/vector/");
        
        private final String mImageDirectory;

        private ImageFormat(String str) {
            this.mImageDirectory = str;
        }

        public final String getImageDirectory() {
            return this.mImageDirectory;
        }
    }

    public static com.facebook.feedback.reactions.ui.FeedbackReactionsController m29084a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21385f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.reactions.ui.FeedbackReactionsController.class;
        monitor-enter(r1);
        r0 = f21385f;	 Catch:{ all -> 0x003a }
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
        r0 = m29086b(r0);	 Catch:{ all -> 0x0035 }
        f21385f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21385f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.ui.FeedbackReactionsController.a(com.facebook.inject.InjectorLike):com.facebook.feedback.reactions.ui.FeedbackReactionsController");
    }

    private static FeedbackReactionsController m29086b(InjectorLike injectorLike) {
        return new FeedbackReactionsController(IdBasedSingletonScopeProvider.m1809a(injectorLike, 1787), IdBasedSingletonScopeProvider.m1809a(injectorLike, 1781), (FeedbackReactionsDownloaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackReactionsDownloaderProvider.class), LocaleChangeController.m29097a(injectorLike));
    }

    @Inject
    public FeedbackReactionsController(Provider<StaticReactionFactory> provider, Provider<DynamicReactionFactory> provider2, FeedbackReactionsDownloaderProvider feedbackReactionsDownloaderProvider, LocaleChangeController localeChangeController) {
        this.f21388c = provider;
        this.f21386a = (ReactionModelFactory) provider2.get();
        this.f21387b = feedbackReactionsDownloaderProvider.m29096a(this, this.f21386a);
        this.f21387b.m29174a(false);
        localeChangeController.m29101a((LocaleChangeListener) this);
    }

    @Nullable
    public final ListenableFuture mo3162a(Locale locale) {
        this.f21387b.m29174a(true);
        return null;
    }

    public final FeedbackReaction m29087a(int i) {
        return m29083a(i, this.f21389d);
    }

    public final ImmutableList<FeedbackReaction> m29091b() {
        return ImmutableList.builder().m1069c(FeedbackReaction.f21476c).m1065b((Iterable) this.f21389d).m1068b();
    }

    public final ImmutableList<FeedbackReaction> m29092c() {
        Builder builder = new Builder();
        ImmutableList immutableList = this.f21389d;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            FeedbackReaction feedbackReaction = (FeedbackReaction) immutableList.get(i);
            if (!feedbackReaction.f21481h && feedbackReaction.f21483j.mo3167b()) {
                builder.m1069c(feedbackReaction);
            }
        }
        return builder.m1068b();
    }

    public final FeedbackReaction m29090b(int i) {
        if (this.f21390e == null) {
            this.f21390e = m29085a((ReactionModelFactory) this.f21388c.get());
        }
        return m29083a(i, this.f21390e);
    }

    public final ImmutableList<FeedbackReaction> m29088a(List<GraphQLFeedbackReaction> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        for (GraphQLFeedbackReaction a : list) {
            FeedbackReaction a2 = m29087a(a.m24885a());
            if (a2 != FeedbackReaction.f21476c) {
                builder.m1069c(a2);
            }
        }
        return builder.m1068b();
    }

    public final FeedbackReaction m29093d() {
        return m29087a(1);
    }

    public final void m29094e() {
        this.f21389d = m29085a(this.f21386a);
    }

    private ImmutableList<FeedbackReaction> m29085a(ReactionModelFactory reactionModelFactory) {
        Builder builder = ImmutableList.builder();
        for (int i : reactionModelFactory.mo3164a()) {
            FeedbackReaction a = reactionModelFactory.mo3163a(i, m29087a(i));
            if (a != null) {
                builder.m1069c(a);
            }
        }
        return builder.m1068b();
    }

    private static FeedbackReaction m29083a(int i, List<FeedbackReaction> list) {
        if (list == null) {
            return FeedbackReaction.f21476c;
        }
        for (FeedbackReaction feedbackReaction : list) {
            if (feedbackReaction.f21478e == i) {
                return feedbackReaction;
            }
        }
        return FeedbackReaction.f21476c;
    }
}
