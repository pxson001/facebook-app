package com.facebook.feed.ui.attachments.angora;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.facebook.common.util.StringUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.util.StoryAttachmentUtil;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.InjectorLike;
import com.facebook.text.CustomFontUtil;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hideAppIcon */
public class LegacyAngoraAttachmentUtil {
    public static int f21093f;
    public static int f21094g;
    private static volatile LegacyAngoraAttachmentUtil f21095h;
    public Context f21096a;
    public FeedRenderUtils f21097b;
    private StoryAttachmentUtil f21098c;
    private CustomFontUtil f21099d;
    public ScreenUtil f21100e;

    public static com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil m28831a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21095h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil.class;
        monitor-enter(r1);
        r0 = f21095h;	 Catch:{ all -> 0x003a }
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
        r0 = m28834b(r0);	 Catch:{ all -> 0x0035 }
        f21095h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21095h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil.a(com.facebook.inject.InjectorLike):com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil");
    }

    private static LegacyAngoraAttachmentUtil m28834b(InjectorLike injectorLike) {
        return new LegacyAngoraAttachmentUtil((Context) injectorLike.getInstance(Context.class), FeedRenderUtils.m14652a(injectorLike), StoryAttachmentUtil.m22700a(injectorLike), CustomFontUtil.m26563a(injectorLike), ScreenUtil.m8695a(injectorLike));
    }

    @Inject
    public LegacyAngoraAttachmentUtil(Context context, FeedRenderUtils feedRenderUtils, StoryAttachmentUtil storyAttachmentUtil, CustomFontUtil customFontUtil, ScreenUtil screenUtil) {
        this.f21096a = context;
        this.f21097b = feedRenderUtils;
        this.f21098c = storyAttachmentUtil;
        this.f21099d = customFontUtil;
        this.f21100e = screenUtil;
    }

    public final boolean m28836a(@Nullable GraphQLImage graphQLImage, float f) {
        if (graphQLImage == null) {
            return false;
        }
        if (f21093f == 0 || f21094g == 0) {
            int a = this.f21097b.m14654a();
            int d = this.f21100e.m8703d();
            int a2 = this.f21097b.m14657a(this.f21096a, 1) * 2;
            f21093f = Math.min(a, d) - a2;
            f21094g = Math.max(a, d) - a2;
        }
        float f2 = (((float) f21093f) / f) * 0.55f;
        if (((float) graphQLImage.mo2925c()) < ((float) f21093f) * 0.55f || ((float) graphQLImage.mo2923a()) < f2) {
            return false;
        }
        return true;
    }

    public final Spannable m28835a(GraphQLStoryAttachment graphQLStoryAttachment) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Object a = StoryAttachmentUtil.m22701a(graphQLStoryAttachment);
        if (!Strings.isNullOrEmpty(a)) {
            spannableStringBuilder.append(a);
            spannableStringBuilder.setSpan(CustomFontUtil.m26562a(), 0, a.length(), 17);
        }
        GraphQLStoryActionLink a2 = ActionLinkHelper.m22935a(graphQLStoryAttachment);
        String a3 = (a2 == null || Strings.isNullOrEmpty(a2.m22890Q())) ? graphQLStoryAttachment.m23975n() != null ? graphQLStoryAttachment.m23975n().mo2911a() : null : a2.m22890Q();
        CharSequence charSequence = a3;
        if (!StringUtil.m3599c(charSequence)) {
            m28832a(spannableStringBuilder);
            spannableStringBuilder.append(charSequence);
        }
        return spannableStringBuilder;
    }

    public static void m28832a(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder.length() > 0) {
            spannableStringBuilder.append("\n");
        }
    }

    public static Spannable m28833b(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryActionLink a = ActionLinkHelper.m22935a(graphQLStoryAttachment);
        String a2 = (a == null || Strings.isNullOrEmpty(a.m22891R())) ? graphQLStoryAttachment.m23982u() != null ? graphQLStoryAttachment.m23982u().mo2911a() : null : a.m22891R();
        CharSequence charSequence = a2;
        if (StringUtil.m3599c(charSequence)) {
            return null;
        }
        return SpannableStringBuilder.valueOf(charSequence);
    }
}
