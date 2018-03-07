package com.facebook.messaging.sharing.sendasmessage;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.Spannable;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitleSpannableBuilder;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Strings;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: offsetCount */
public class SendAsMessageUtil {
    public static final String f7861a = Integer.valueOf(Integer.MAX_VALUE).toString();
    private static volatile SendAsMessageUtil f7862g;
    private final SecureContextHelper f7863b;
    public final MessengerAppUtils f7864c;
    private final AbstractFbErrorReporter f7865d;
    public final XConfigReader f7866e;
    private final Lazy<HeaderTitleSpannableBuilder> f7867f;

    public static com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil m9486a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7862g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil.class;
        monitor-enter(r1);
        r0 = f7862g;	 Catch:{ all -> 0x003a }
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
        r0 = m9492b(r0);	 Catch:{ all -> 0x0035 }
        f7862g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7862g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil");
    }

    private static SendAsMessageUtil m9492b(InjectorLike injectorLike) {
        return new SendAsMessageUtil((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), MessengerAppUtils.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), XConfigReader.a(injectorLike), (QuickExperimentController) QuickExperimentControllerImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 1880));
    }

    @Inject
    public SendAsMessageUtil(SecureContextHelper secureContextHelper, MessengerAppUtils messengerAppUtils, FbErrorReporter fbErrorReporter, XConfigReader xConfigReader, QuickExperimentController quickExperimentController, Lazy<HeaderTitleSpannableBuilder> lazy) {
        this.f7863b = secureContextHelper;
        this.f7864c = messengerAppUtils;
        this.f7865d = fbErrorReporter;
        this.f7866e = xConfigReader;
        this.f7867f = lazy;
    }

    private void m9489a(FeedProps<GraphQLStory> feedProps, Context context) {
        if (StorySharingHelper.b((GraphQLStory) feedProps.a)) {
            Intent a = m9484a(GraphQLStoryUtil.q(GraphQLStoryUtil.p(feedProps)));
            if (a != null) {
                this.f7863b.a(a, context);
            }
        }
    }

    public final void m9496a(Context context, String str, boolean z, boolean z2, @Nullable String str2) {
        Intent b = m9500b(context, str, z, z2, str2);
        if (b != null) {
            this.f7863b.a(b, context);
        }
    }

    @Nullable
    public final Intent m9500b(Context context, String str, boolean z, boolean z2, @Nullable String str2) {
        Object obj;
        Intent intent;
        if (this.f7864c.a(this.f7866e.a(SendAsMessageXConfig.d, f7861a))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            Intent a = m9485a(z, z2);
            a.putExtra("share_link_url", str);
            intent = a;
        } else {
            intent = m9484a(str);
        }
        if (intent == null) {
            return null;
        }
        if (ContextUtils.a(context, Service.class) != null) {
            intent.addFlags(268435456);
        }
        m9487a(intent, str2);
        intent.putExtra("trigger", "send_as_message");
        return intent;
    }

    public final void m9497a(FeedProps<GraphQLStory> feedProps, Context context, String str, long j, String str2, @Nullable String str3) {
        m9490a((FeedProps) feedProps, context, str, Long.valueOf(j), str2, true, str3);
    }

    public final void m9498a(FeedProps<GraphQLStory> feedProps, Context context, boolean z, @Nullable String str) {
        if (this.f7864c.a("21.0")) {
            m9490a((FeedProps) feedProps, context, null, null, null, z, str);
        } else {
            m9489a((FeedProps) feedProps, context);
        }
    }

    private void m9490a(FeedProps<GraphQLStory> feedProps, Context context, @Nullable String str, @Nullable Long l, @Nullable String str2, boolean z, @Nullable String str3) {
        String str4 = null;
        if (StorySharingHelper.b((GraphQLStory) feedProps.a())) {
            FeedProps p = GraphQLStoryUtil.p(feedProps);
            GraphQLStory graphQLStory = (GraphQLStory) p.a();
            Intent b = m9491b(graphQLStory.c(), z, true);
            b.putExtra("share_story_url", GraphQLStoryUtil.q(p));
            if (str != null) {
                b.putExtra("page_name", str);
            }
            if (l != null) {
                b.putExtra("page_target", l);
            }
            if (str2 != null) {
                b.putExtra("page_post_id", str2);
            }
            if (StoryAttachmentHelper.a(graphQLStory)) {
                GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
                Spannable c = ((HeaderTitleSpannableBuilder) this.f7867f.get()).a(p).a().b().c();
                String obj = c != null ? c.toString() : null;
                m9488a(b, "share_title", Strings.nullToEmpty(o.A()), obj);
                m9488a(b, "share_caption", GraphQLStoryAttachmentUtil.s(o), StoryTextHelper.a(graphQLStory));
                GraphQLActor b2 = StoryActorHelper.b(graphQLStory);
                String str5 = "share_media_url";
                String o2 = GraphQLStoryAttachmentUtil.o(o);
                if (b2 != null && GraphQLActorUtil.b(b2)) {
                    str4 = GraphQLActorUtil.c(b2);
                }
                m9488a(b, str5, o2, str4);
                b.putExtra("share_attachment_url", Strings.nullToEmpty(o.C()));
                if (!GraphQLStoryAttachmentUtil.b(o)) {
                    if (!(o.n() == null || o.n().equals(GraphQLStoryAttachmentUtil.r(o)))) {
                        b.putExtra("share_description", o.n().a());
                    }
                    if (obj != null) {
                        b.putExtra("share_robotext", obj);
                    }
                }
            } else {
                b.putExtra("share_description", StoryTextHelper.a(graphQLStory));
                if (StoryActorHelper.b(graphQLStory) != null) {
                    b.putExtra("share_title", StoryActorHelper.b(graphQLStory).aa());
                    b.putExtra("share_media_url", GraphQLActorUtil.c(StoryActorHelper.b(graphQLStory)));
                }
            }
            m9487a(b, str3);
            this.f7863b.a(b, context);
        }
    }

    public final void m9495a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(1 != null ? MessengerLinks.p : MessengerLinks.o));
        intent.putExtra("share_return_to_fb4a", true);
        Intent intent2 = intent;
        intent2.putExtra("share_fbid", str);
        intent2.putExtra("title", str3);
        intent2.putExtra("share_title", str2);
        intent2.putExtra("share_media_url", str4);
        intent2.putExtra("share_caption", str5);
        String[] strArr = new String[]{str6};
        intent2.putExtra("preselected_recipients", strArr);
        intent2.putExtra("suggested_recipients", strArr);
        intent2.putExtra("share_body_text_prefill", str7);
        m9487a(intent2, str8);
        this.f7863b.a(intent2, context);
    }

    public final void m9494a(Activity activity, String str, String str2, String str3, String str4, String str5, Set<String> set, String str6, int i) {
        Intent a = m9493a(str, str2, str3, str4, str5, (Set) set, str6);
        if (a != null) {
            this.f7863b.a(a, i, activity);
        }
    }

    @Deprecated
    public final Intent m9493a(String str, String str2, String str3, String str4, String str5, Set<String> set, String str6) {
        if (m9499a()) {
            Intent b = m9491b(str, true, true);
            b.putExtra("share_fbid", str);
            b.putExtra("share_return_to_fb4a", true);
            b.putExtra("share_title", str2);
            b.putExtra("share_media_url", str3);
            b.putExtra("share_caption", str4);
            b.putExtra("share_description", str5);
            String[] strArr = (String[]) set.toArray(new String[Math.min(set.size(), 50)]);
            b.putExtra("preselected_recipients", strArr);
            b.putExtra("suggested_recipients", strArr);
            b.putExtra("target_recipients", strArr);
            m9487a(b, str6);
            return b;
        }
        this.f7865d.b("Messenger", "Trying to pass extra share id in older versions of messenger");
        return null;
    }

    public final boolean m9499a() {
        return this.f7864c.a("17.0");
    }

    private static void m9488a(Intent intent, String str, @Nullable String str2, @Nullable String str3) {
        if (!Strings.isNullOrEmpty(str2)) {
            str3 = str2;
        }
        intent.putExtra(str, str3);
    }

    private Intent m9484a(String str) {
        PackageInfo e = this.f7864c.e();
        if (e == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        intent.setPackage(e.packageName);
        return intent;
    }

    private static Intent m9491b(String str, boolean z, boolean z2) {
        Intent a = m9485a(z, z2);
        a.putExtra("share_fbid", str);
        return a;
    }

    public static Intent m9485a(boolean z, boolean z2) {
        Intent intent = new Intent(MessagingIntentUris.a);
        intent.setData(Uri.parse(z2 ? MessengerLinks.p : MessengerLinks.o));
        intent.putExtra("share_return_to_fb4a", z);
        return intent;
    }

    private static void m9487a(Intent intent, String str) {
        String str2 = "send_as_message_entry_point";
        if (Strings.isNullOrEmpty(str)) {
            str = "unspecified";
        }
        intent.putExtra(str2, str);
    }
}
