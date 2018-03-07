package com.facebook.feedback.reactions.ui;

import android.content.Context;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.data.FeedbackReactionAsset;
import com.facebook.feedback.reactions.data.FeedbackReactionDiskStaticAsset;
import com.facebook.feedback.reactions.prefs.FeedbackReactionsPrefKeys;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController.ImageFormat;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.base.Strings;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hasFetchFailed */
public class DynamicReactionFactory implements ReactionModelFactory {
    private static volatile DynamicReactionFactory f21395f;
    private final Context f21396a;
    private final StaticReactionFactory f21397b;
    private final FeedbackReactionHelper f21398c;
    private final ReactionsFaceDataCache f21399d;
    private final FbSharedPreferences f21400e;

    /* compiled from: hasFetchFailed */
    /* synthetic */ class C08451 {
        static final /* synthetic */ int[] f21485a = new int[ImageFormat.values().length];

        static {
            try {
                f21485a[ImageFormat.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21485a[ImageFormat.LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21485a[ImageFormat.TAB_ICONS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21485a[ImageFormat.VECTOR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static com.facebook.feedback.reactions.ui.DynamicReactionFactory m29104a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21395f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.reactions.ui.DynamicReactionFactory.class;
        monitor-enter(r1);
        r0 = f21395f;	 Catch:{ all -> 0x003a }
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
        r0 = m29109b(r0);	 Catch:{ all -> 0x0035 }
        f21395f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21395f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.ui.DynamicReactionFactory.a(com.facebook.inject.InjectorLike):com.facebook.feedback.reactions.ui.DynamicReactionFactory");
    }

    private static DynamicReactionFactory m29109b(InjectorLike injectorLike) {
        return new DynamicReactionFactory((Context) injectorLike.getInstance(Context.class), StaticReactionFactory.m29116a(injectorLike), FeedbackReactionHelper.m29122a(injectorLike), ReactionsFaceDataCache.m29129a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public DynamicReactionFactory(Context context, StaticReactionFactory staticReactionFactory, FeedbackReactionHelper feedbackReactionHelper, ReactionsFaceDataCache reactionsFaceDataCache, FbSharedPreferences fbSharedPreferences) {
        this.f21396a = context;
        this.f21397b = staticReactionFactory;
        this.f21398c = feedbackReactionHelper;
        this.f21399d = reactionsFaceDataCache;
        this.f21400e = fbSharedPreferences;
    }

    public final int[] mo3164a() {
        int i = 0;
        String a = this.f21400e.mo278a(FeedbackReactionsPrefKeys.f21471b, null);
        if (Strings.isNullOrEmpty(a)) {
            return this.f21397b.mo3164a();
        }
        String[] split = a.split(",");
        int[] iArr = new int[split.length];
        int length = split.length;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            try {
                iArr[i2] = Integer.parseInt(split[i]);
                i++;
                i2 = i3;
            } catch (NumberFormatException e) {
                this.f21400e.edit().mo1271a(FeedbackReactionsPrefKeys.f21471b).commit();
                return this.f21397b.mo3164a();
            }
        }
        return iArr;
    }

    public final FeedbackReaction mo3163a(int i, FeedbackReaction feedbackReaction) {
        String a = m29105a(i);
        int b = m29108b(i);
        boolean c = m29110c(i);
        String[] strArr = new String[]{m29106a(i, ImageFormat.SMALL), m29106a(i, this.f21398c.m29127a()), m29106a(i, ImageFormat.TAB_ICONS)};
        if (Strings.isNullOrEmpty(a) || b == 0 || !m29107a(strArr)) {
            return this.f21397b.mo3163a(i, feedbackReaction);
        }
        if (feedbackReaction.f21478e == i) {
            feedbackReaction.m29191a(a, b, c, m29103a(i, strArr[0], ImageFormat.SMALL), m29103a(i, strArr[1], this.f21398c.m29127a()), m29103a(i, strArr[2], ImageFormat.TAB_ICONS));
            return feedbackReaction;
        }
        return new FeedbackReaction(i, a, b, c, m29103a(i, strArr[0], ImageFormat.SMALL), m29103a(i, strArr[1], this.f21398c.m29127a()), m29103a(i, strArr[2], ImageFormat.TAB_ICONS));
    }

    private String m29105a(int i) {
        return this.f21400e.mo278a(FeedbackReactionsPrefKeys.m29185a(i), null);
    }

    private int m29108b(int i) {
        return this.f21400e.mo276a(FeedbackReactionsPrefKeys.m29188c(i), 0);
    }

    private boolean m29110c(int i) {
        return this.f21400e.mo286a(FeedbackReactionsPrefKeys.m29187b(i), false);
    }

    private String m29106a(int i, ImageFormat imageFormat) {
        return this.f21400e.mo278a(FeedbackReactionsPrefKeys.m29186a(i, imageFormat.name()), null);
    }

    private FeedbackReactionAsset m29103a(int i, String str, ImageFormat imageFormat) {
        switch (C08451.f21485a[imageFormat.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return new FeedbackReactionDiskStaticAsset(this.f21396a, new File(str));
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                this.f21399d.m29136a(i, new File(str));
                return new FeedbackReactionVectorAsset(this.f21399d, i, m29103a(i, m29106a(i, ImageFormat.LARGE), ImageFormat.LARGE));
            default:
                throw new IllegalArgumentException("Drawables for image type " + imageFormat.name() + " not supported.");
        }
    }

    private static boolean m29107a(String[] strArr) {
        for (String str : strArr) {
            if (Strings.isNullOrEmpty(str) || !new File(str).exists()) {
                return false;
            }
        }
        return true;
    }
}
