package com.facebook.feedback.reactions.ui;

import android.content.Context;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel;
import com.facebook.feedback.reactions.api.C0892xd41607c3;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController.ImageFormat;
import com.facebook.feedback.reactions.ui.ReactionsClientInfo.ReactionsClientInfoAsset;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import java.io.File;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: harrison_fragment_count */
public class FeedbackReactionHelper {
    private static volatile FeedbackReactionHelper f21405d;
    private final Context f21406a;
    private final ReactionsExperimentUtil f21407b;
    private File f21408c;

    public static com.facebook.feedback.reactions.ui.FeedbackReactionHelper m29122a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21405d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.reactions.ui.FeedbackReactionHelper.class;
        monitor-enter(r1);
        r0 = f21405d;	 Catch:{ all -> 0x003a }
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
        r0 = m29124b(r0);	 Catch:{ all -> 0x0035 }
        f21405d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21405d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.ui.FeedbackReactionHelper.a(com.facebook.inject.InjectorLike):com.facebook.feedback.reactions.ui.FeedbackReactionHelper");
    }

    private static FeedbackReactionHelper m29124b(InjectorLike injectorLike) {
        return new FeedbackReactionHelper((Context) injectorLike.getInstance(Context.class), ReactionsExperimentUtil.m10410a(injectorLike));
    }

    @Inject
    public FeedbackReactionHelper(Context context, ReactionsExperimentUtil reactionsExperimentUtil) {
        this.f21406a = context;
        this.f21407b = reactionsExperimentUtil;
    }

    private File m29125b() {
        if (this.f21408c != null) {
            return this.f21408c;
        }
        String canonicalPath;
        String str = null;
        try {
            canonicalPath = this.f21406a.getFilesDir().getCanonicalPath();
        } catch (IOException e) {
            canonicalPath = str;
        }
        this.f21408c = canonicalPath != null ? new File(canonicalPath) : this.f21406a.getFilesDir();
        return this.f21408c;
    }

    public final ImageFormat m29127a() {
        return this.f21407b.m10416j().isVectorBased ? ImageFormat.VECTOR : ImageFormat.LARGE;
    }

    public static ReactionsClientInfoAsset m29123a(ReactionsClientInfo reactionsClientInfo, ImageFormat imageFormat) {
        switch (1.a[imageFormat.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return reactionsClientInfo.m;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return reactionsClientInfo.n;
            case 3:
                return reactionsClientInfo.o;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return reactionsClientInfo.p;
            default:
                throw new IllegalArgumentException("Resource for image type " + imageFormat.name() + " not supported.");
        }
    }

    public static C0892xd41607c3 m29121a(ReactionInfosModel reactionInfosModel, ImageFormat imageFormat) {
        switch (1.a[imageFormat.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return reactionInfosModel.m29986o();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return reactionInfosModel.m29984m();
            case 3:
                return reactionInfosModel.m29987p();
            default:
                throw new IllegalArgumentException("Reaction Asset for image type " + imageFormat.name() + " not supported.");
        }
    }

    public static String m29126b(ReactionInfosModel reactionInfosModel, ImageFormat imageFormat) {
        switch (1.a[imageFormat.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return m29121a(reactionInfosModel, imageFormat).m29994a();
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return reactionInfosModel.m29978a().m29991a();
            default:
                throw new IllegalArgumentException("Reaction Asset for image type " + imageFormat.name() + " not supported.");
        }
    }

    public final String m29128c(ReactionInfosModel reactionInfosModel, ImageFormat imageFormat) {
        return m29125b().getAbsolutePath() + File.separator + imageFormat.getImageDirectory() + File.separator + m29126b(reactionInfosModel, imageFormat).replaceAll("[^\\w\\d]", "");
    }
}
