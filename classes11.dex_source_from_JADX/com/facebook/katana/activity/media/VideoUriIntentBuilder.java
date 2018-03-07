package com.facebook.katana.activity.media;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.feed.PermalinkStoryFbIdParams;
import com.facebook.ipc.feed.StoryPermalinkParamsType;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: {set_token} */
public class VideoUriIntentBuilder extends UriIntentBuilder {
    private static volatile VideoUriIntentBuilder f8b;
    public final ViewPermalinkIntentFactory f9a;

    /* compiled from: {set_token} */
    class VidePermalinkIntentBuilder implements IUriTemplateIntentBuilder {
        final /* synthetic */ VideoUriIntentBuilder f7a;

        VidePermalinkIntentBuilder(VideoUriIntentBuilder videoUriIntentBuilder) {
            this.f7a = videoUriIntentBuilder;
        }

        public final Intent m22a(Context context, Bundle bundle) {
            Intent intent;
            PermalinkStoryFbIdParams permalinkStoryFbIdParams = new PermalinkStoryFbIdParams(bundle.getString("id").substring(1, bundle.getString("id").length() - 1));
            ViewPermalinkIntentFactory viewPermalinkIntentFactory = this.f7a.f9a;
            if (null == null) {
                intent = new Intent(viewPermalinkIntentFactory.a);
            } else {
                intent = new Intent().setComponent(null);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("extra_permalink_param_type", StoryPermalinkParamsType.STORY_FBID_KEY.name());
            bundle2.putString("story_fbid", permalinkStoryFbIdParams.a);
            bundle2.putInt("target_fragment", ContentFragmentType.NATIVE_PERMALINK_PAGE_FRAGMENT.ordinal());
            intent.putExtras(bundle2);
            viewPermalinkIntentFactory.c.a(intent);
            return intent;
        }
    }

    public static com.facebook.katana.activity.media.VideoUriIntentBuilder m23a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.activity.media.VideoUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f8b;	 Catch:{ all -> 0x003a }
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
        r0 = m25b(r0);	 Catch:{ all -> 0x0035 }
        f8b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.activity.media.VideoUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.katana.activity.media.VideoUriIntentBuilder");
    }

    private static VideoUriIntentBuilder m25b(InjectorLike injectorLike) {
        return new VideoUriIntentBuilder(ViewPermalinkIntentFactory.a(injectorLike));
    }

    @Inject
    public VideoUriIntentBuilder(ViewPermalinkIntentFactory viewPermalinkIntentFactory) {
        this.f9a = viewPermalinkIntentFactory;
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.dH, "id"), new VidePermalinkIntentBuilder(this));
        a(FBLinks.dI, ViewVideoActivity.class);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.dK, "video_fbid"), ViewVideoActivity.class);
    }

    public final Intent m26a(Context context, String str) {
        if (str.contains("video_redirect")) {
            str = m24a(str);
        } else {
            Uri parse = Uri.parse(str);
            Object obj = 1;
            if (parse.getScheme() == null || !parse.getScheme().equals("fb") || parse.getAuthority() == null || !parse.getAuthority().equals("video") || parse.getQueryParameter("source_url") == null || parse.getPathSegments() == null || parse.getPathSegments().size() != 1) {
                obj = null;
            }
            if (obj != null) {
                str = FBLinks.a(Uri.decode(new Builder().encodedPath("video/").appendQueryParameter("id", "{" + Uri.parse(str).getLastPathSegment() + "}").build().toString()));
            }
        }
        return super.a(context, str);
    }

    private static String m24a(String str) {
        String queryParameter = Uri.parse(Uri.decode(str)).getQueryParameter("href");
        if (queryParameter == null || queryParameter.indexOf("fb:") == -1) {
            return str;
        }
        return queryParameter.substring(queryParameter.indexOf("fb:"));
    }
}
