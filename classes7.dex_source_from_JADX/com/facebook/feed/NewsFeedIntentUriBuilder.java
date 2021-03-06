package com.facebook.feed;

import android.os.Bundle;
import com.facebook.api.feedtype.FeedType;
import com.facebook.apptab.state.TabTag;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.ipc.feed.StoryPermalinkParamsType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: argument must be less than 1000 */
public class NewsFeedIntentUriBuilder extends UriIntentBuilder {
    private static volatile NewsFeedIntentUriBuilder f19123a;

    public static com.facebook.feed.NewsFeedIntentUriBuilder m22673a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f19123a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.NewsFeedIntentUriBuilder.class;
        monitor-enter(r1);
        r0 = f19123a;	 Catch:{ all -> 0x0039 }
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
        r0 = m22674b();	 Catch:{ all -> 0x0034 }
        f19123a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f19123a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.NewsFeedIntentUriBuilder.a(com.facebook.inject.InjectorLike):com.facebook.feed.NewsFeedIntentUriBuilder");
    }

    private static NewsFeedIntentUriBuilder m22674b() {
        return new NewsFeedIntentUriBuilder();
    }

    @Inject
    public NewsFeedIntentUriBuilder() {
        Bundle bundle = new Bundle();
        bundle.putString("target_tab_name", TabTag.Feed.name());
        bundle.putString("feed_type_name", FeedType.b.a());
        bundle.putString("POP_TO_ROOT", "1");
        a(FBLinks.a("feed"), FragmentChromeActivity.class, ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT.ordinal(), bundle);
        bundle = new Bundle();
        bundle.putString("feed_type", FeedType.a.a());
        a(FBLinks.a("recent_feed"), FragmentChromeActivity.class, ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT.ordinal(), bundle);
        bundle = new Bundle();
        bundle.putString("extra_permalink_param_type", StoryPermalinkParamsType.PLATFORM_KEY.name());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("native_post/{%s}?fallback_url={%s}"), "extra_platform_id", "extra_fallback_url"), FragmentChromeActivity.class, ContentFragmentType.NATIVE_PERMALINK_PAGE_FRAGMENT.ordinal(), bundle);
        bundle = new Bundle();
        bundle.putString("extra_permalink_param_type", StoryPermalinkParamsType.FEED_STORY_ID_KEY.name());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("native_post/{%s}?story_cache_id={%s}"), "story_id", "story_cache_id"), FragmentChromeActivity.class, ContentFragmentType.NATIVE_PERMALINK_PAGE_FRAGMENT.ordinal(), bundle);
    }
}
