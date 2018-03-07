package com.facebook.video.channelfeed.uri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.InjectorLike;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.facebook.video.channelfeed.activity.ChannelFeedActivity;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: storyGraphQLID */
public class ChannelFeedUriIntentBuilder extends UriIntentBuilder {
    private static volatile ChannelFeedUriIntentBuilder f2739b;
    private final ChannelFeedConfig f2740a;

    /* compiled from: storyGraphQLID */
    class ChannelFeedActivityIntentBuilder implements IUriTemplateIntentBuilder {
        final /* synthetic */ ChannelFeedUriIntentBuilder f2738a;

        public ChannelFeedActivityIntentBuilder(ChannelFeedUriIntentBuilder channelFeedUriIntentBuilder) {
            this.f2738a = channelFeedUriIntentBuilder;
        }

        @Nullable
        public final Intent m2628a(Context context, Bundle bundle) {
            return ChannelFeedActivity.m2592a(context, bundle.getString("video_channel_id"));
        }
    }

    public static com.facebook.video.channelfeed.uri.ChannelFeedUriIntentBuilder m2629a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2739b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.channelfeed.uri.ChannelFeedUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f2739b;	 Catch:{ all -> 0x003a }
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
        r0 = m2630b(r0);	 Catch:{ all -> 0x0035 }
        f2739b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2739b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.channelfeed.uri.ChannelFeedUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.video.channelfeed.uri.ChannelFeedUriIntentBuilder");
    }

    private static ChannelFeedUriIntentBuilder m2630b(InjectorLike injectorLike) {
        return new ChannelFeedUriIntentBuilder(ChannelFeedConfig.a(injectorLike));
    }

    @Inject
    public ChannelFeedUriIntentBuilder(ChannelFeedConfig channelFeedConfig) {
        this.f2740a = channelFeedConfig;
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.gb, "{video_channel_id}"), new ChannelFeedActivityIntentBuilder(this));
    }

    protected final boolean m2631a() {
        return this.f2740a.a;
    }
}
