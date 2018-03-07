package com.facebook.feedback.reactions.ui;

import android.content.Context;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.data.FeedbackReactionAPKStaticAsset;
import com.facebook.feedback.reactions.data.FeedbackReactionAsset;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController.ImageFormat;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: harrison_fragment_stacks */
public class StaticReactionFactory implements ReactionModelFactory {
    private static volatile StaticReactionFactory f21401d;
    private final Context f21402a;
    private final FeedbackReactionHelper f21403b;
    private final ReactionsFaceDataCache f21404c;

    public static com.facebook.feedback.reactions.ui.StaticReactionFactory m29116a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21401d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.reactions.ui.StaticReactionFactory.class;
        monitor-enter(r1);
        r0 = f21401d;	 Catch:{ all -> 0x003a }
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
        r0 = m29118b(r0);	 Catch:{ all -> 0x0035 }
        f21401d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21401d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.ui.StaticReactionFactory.a(com.facebook.inject.InjectorLike):com.facebook.feedback.reactions.ui.StaticReactionFactory");
    }

    private static StaticReactionFactory m29118b(InjectorLike injectorLike) {
        return new StaticReactionFactory((Context) injectorLike.getInstance(Context.class), FeedbackReactionHelper.m29122a(injectorLike), ReactionsFaceDataCache.m29129a(injectorLike));
    }

    @Inject
    public StaticReactionFactory(Context context, FeedbackReactionHelper feedbackReactionHelper, ReactionsFaceDataCache reactionsFaceDataCache) {
        this.f21402a = context;
        this.f21403b = feedbackReactionHelper;
        this.f21404c = reactionsFaceDataCache;
    }

    public final int[] mo3164a() {
        int[] iArr = new int[ReactionsClientInfo.k.size()];
        ImmutableList immutableList = ReactionsClientInfo.k;
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = i2 + 1;
            iArr[i2] = ((ReactionsClientInfo) immutableList.get(i)).l;
            i++;
            i2 = i3;
        }
        return iArr;
    }

    public final FeedbackReaction mo3163a(int i, FeedbackReaction feedbackReaction) {
        ReactionsClientInfo a = ReactionsClientInfo.a(i);
        if (a == null) {
            return null;
        }
        if (feedbackReaction.f21478e == i) {
            feedbackReaction.m29191a(m29117a(a.c()), a.h(), false, m29115a(a, ImageFormat.SMALL), m29115a(a, this.f21403b.m29127a()), m29115a(a, ImageFormat.TAB_ICONS));
            return feedbackReaction;
        }
        return new FeedbackReaction(i, m29117a(a.c()), a.h(), false, m29115a(a, ImageFormat.SMALL), m29115a(a, this.f21403b.m29127a()), m29115a(a, ImageFormat.TAB_ICONS));
    }

    private String m29117a(int i) {
        return i != 0 ? this.f21402a.getResources().getString(i) : "";
    }

    private FeedbackReactionAsset m29115a(ReactionsClientInfo reactionsClientInfo, ImageFormat imageFormat) {
        switch (1.a[imageFormat.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return new FeedbackReactionAPKStaticAsset(this.f21402a, FeedbackReactionHelper.m29123a(reactionsClientInfo, imageFormat).c);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                this.f21404c.m29137a(reactionsClientInfo);
                return new FeedbackReactionVectorAsset(this.f21404c, reactionsClientInfo.l, m29115a(reactionsClientInfo, ImageFormat.LARGE));
            default:
                throw new IllegalArgumentException("Asset for image type " + imageFormat.name() + " not supported.");
        }
    }
}
