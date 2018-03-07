package com.facebook.messaging.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.config.server.NetworkLogUrl;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.emoji.model.Emoji;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: manualGkRefresh */
public class DownloadableEmojiButtonBuilder {
    public static final CallerContext f10897a = CallerContext.a(DownloadableEmojiButtonBuilder.class, "emoji_popup");
    private static volatile DownloadableEmojiButtonBuilder f10898c;
    private final Provider<FbDraweeControllerBuilder> f10899b;

    /* compiled from: manualGkRefresh */
    public class DraweeEmojiViewHolder extends EmojiViewHolder {
        public static final SparseIntArray f10893o;
        public final DraweeView f10894l;
        private final CallerContext f10895m;
        private final Provider<FbDraweeControllerBuilder> f10896n;

        public DraweeEmojiViewHolder(DraweeView draweeView, CallerContext callerContext, Provider<FbDraweeControllerBuilder> provider) {
            super(draweeView);
            this.f10894l = draweeView;
            this.f10895m = callerContext;
            this.f10896n = provider;
        }

        protected final void mo423a(Emoji emoji) {
            Resources resources = this.f10894l.getResources();
            DraweeView draweeView = this.f10894l;
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
            genericDraweeHierarchyBuilder.f = resources.getDrawable(emoji.a);
            draweeView.setHierarchy(genericDraweeHierarchyBuilder.e(ScaleType.f).u());
            draweeView = this.f10894l;
            FbDraweeControllerBuilder fbDraweeControllerBuilder = (FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f10896n.get()).a(this.f10895m).b(this.f10894l.getController());
            Context context = this.f10894l.getContext();
            Emoji emoji2 = this.f10892m;
            StringBuilder stringBuilder = new StringBuilder(100);
            stringBuilder.append(NetworkLogUrl.a(context, "http://www.%s/images/emoji/unicode/"));
            stringBuilder.append("emoji_");
            int i = emoji2.b;
            stringBuilder.append(Integer.toHexString(f10893o.get(i, i)).toLowerCase(Locale.ENGLISH));
            if (emoji2.c != 0) {
                stringBuilder.append('_');
                stringBuilder.append(Integer.toHexString(emoji2.c).toLowerCase(Locale.ENGLISH));
            }
            stringBuilder.append("_64.png");
            draweeView.setController(fbDraweeControllerBuilder.b(Uri.parse(stringBuilder.toString())).s());
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f10893o = sparseIntArray;
            sparseIntArray.put(128541, 128069);
            f10893o.put(128524, 128518);
            f10893o.put(128553, 128532);
            f10893o.put(128555, 128547);
            f10893o.put(128548, 128513);
            f10893o.put(128565, 128547);
            f10893o.put(128570, 128515);
            f10893o.put(128568, 128513);
            f10893o.put(128571, 128525);
            f10893o.put(128573, 128536);
            f10893o.put(128572, 128513);
            f10893o.put(128576, 128532);
            f10893o.put(128575, 128546);
            f10893o.put(128569, 128514);
            f10893o.put(9995, 128587);
            f10893o.put(128589, 128532);
            f10893o.put(127932, 127926);
        }
    }

    public static com.facebook.messaging.emoji.DownloadableEmojiButtonBuilder m11311a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10898c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.emoji.DownloadableEmojiButtonBuilder.class;
        monitor-enter(r1);
        r0 = f10898c;	 Catch:{ all -> 0x003a }
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
        r0 = m11312b(r0);	 Catch:{ all -> 0x0035 }
        f10898c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10898c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.emoji.DownloadableEmojiButtonBuilder.a(com.facebook.inject.InjectorLike):com.facebook.messaging.emoji.DownloadableEmojiButtonBuilder");
    }

    private static DownloadableEmojiButtonBuilder m11312b(InjectorLike injectorLike) {
        return new DownloadableEmojiButtonBuilder(IdBasedProvider.a(injectorLike, 1117));
    }

    @Inject
    public DownloadableEmojiButtonBuilder(Provider<FbDraweeControllerBuilder> provider) {
        this.f10899b = provider;
    }

    public final EmojiViewHolder m11313a(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        DraweeView draweeView = new DraweeView(context);
        draweeView.setBackgroundResource(2130841833);
        draweeView.setContentDescription(context.getString(2131232443));
        return new DraweeEmojiViewHolder(draweeView, f10897a, this.f10899b);
    }
}
