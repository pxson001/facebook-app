package com.facebook.notifications.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.NotificationSource;
import com.facebook.backstage.entry.BackstageFragmentInitializer;
import com.facebook.backstage.entry.BackstageFragmentInitializer.2;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.ActionSource;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImageOverlay;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groups.constants.GroupIntentBuilder;
import com.facebook.heisman.intent.ProfilePictureOverlayCameraIntentData;
import com.facebook.heisman.protocol.conversion.ImageOverlayConversionHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.pages.fb4a.constants.PagesFb4aConstants.PagesFb4aTabs;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.intent.ModelBundle;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: explain_dialog_action */
public class DefaultNotificationStoryLauncher {
    private static volatile DefaultNotificationStoryLauncher f12559j;
    private final ViewPermalinkIntentFactory f12560a;
    private final IFeedIntentBuilder f12561b;
    private final NotificationStoryHelper f12562c;
    private final SecureContextHelper f12563d;
    private final AbstractFbErrorReporter f12564e;
    private final PerformanceLogger f12565f;
    private final FbUriIntentHandler f12566g;
    private final QeAccessor f12567h;
    private final List<WeakReference<NotificationHandler>> f12568i = new LinkedList();

    public static com.facebook.notifications.util.DefaultNotificationStoryLauncher m13335a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12559j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.DefaultNotificationStoryLauncher.class;
        monitor-enter(r1);
        r0 = f12559j;	 Catch:{ all -> 0x003a }
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
        r0 = m13339b(r0);	 Catch:{ all -> 0x0035 }
        f12559j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12559j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.DefaultNotificationStoryLauncher.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.DefaultNotificationStoryLauncher");
    }

    private static DefaultNotificationStoryLauncher m13339b(InjectorLike injectorLike) {
        return new DefaultNotificationStoryLauncher(ViewPermalinkIntentFactory.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), NotificationStoryHelper.m13347a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), FbUriIntentHandler.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DefaultNotificationStoryLauncher(ViewPermalinkIntentFactory viewPermalinkIntentFactory, IFeedIntentBuilder iFeedIntentBuilder, NotificationStoryHelper notificationStoryHelper, SecureContextHelper secureContextHelper, AbstractFbErrorReporter abstractFbErrorReporter, PerformanceLogger performanceLogger, FbUriIntentHandler fbUriIntentHandler, QeAccessor qeAccessor) {
        this.f12560a = viewPermalinkIntentFactory;
        this.f12561b = iFeedIntentBuilder;
        this.f12562c = notificationStoryHelper;
        this.f12563d = secureContextHelper;
        this.f12564e = abstractFbErrorReporter;
        this.f12565f = performanceLogger;
        this.f12566g = fbUriIntentHandler;
        this.f12567h = qeAccessor;
    }

    public final boolean m13345a(Context context, FeedProps<GraphQLStory> feedProps) {
        Bundle bundle;
        Throwable e;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a();
        if (m13337a(graphQLStory)) {
            this.f12565f.b(655408, "NNF_PermalinkNotificationLoad");
            return true;
        }
        String b = this.f12562c.m13359b(graphQLStory);
        if (b != null) {
            this.f12565f.b(655408, "NNF_PermalinkNotificationLoad");
            GraphQLObjectType c = this.f12562c.m13360c(graphQLStory);
            if (c != null) {
                Bundle bundle2;
                String d;
                switch (c.g()) {
                    case 2479791:
                        bundle2 = new Bundle();
                        d = m13342d(graphQLStory, bundle2);
                        if (d == null) {
                            d = b;
                        }
                        b = d;
                        bundle = bundle2;
                        break;
                    case 2645995:
                        bundle2 = new Bundle();
                        m13340b(graphQLStory, bundle2);
                        bundle = bundle2;
                        break;
                    case 67338874:
                        bundle2 = new Bundle();
                        m13341c(graphQLStory, bundle2);
                        bundle = bundle2;
                        break;
                    case 69076575:
                        bundle2 = new Bundle();
                        m13336a(graphQLStory, bundle2);
                        bundle = bundle2;
                        break;
                    case 77090322:
                        bundle2 = new Bundle();
                        d = m13343e(graphQLStory, bundle2);
                        if (d != null) {
                            b = d;
                        }
                        bundle = bundle2;
                        break;
                    default:
                        if (!StringUtil.a(graphQLStory.k())) {
                            try {
                                JSONObject jSONObject = new JSONObject(graphQLStory.k());
                                if (jSONObject.getString("notif_type") != null) {
                                    bundle = new Bundle();
                                    try {
                                        bundle.putString("tracking_notification_type", jSONObject.getString("notif_type"));
                                    } catch (JSONException e2) {
                                        e = e2;
                                        this.f12564e.a(getClass().getName(), "Unable to parse notifStory.tracking as JSON", e);
                                        return this.f12561b.a(context, b, bundle, null);
                                    }
                                }
                                bundle = null;
                            } catch (Throwable e3) {
                                e = e3;
                                bundle = null;
                                this.f12564e.a(getClass().getName(), "Unable to parse notifStory.tracking as JSON", e);
                                return this.f12561b.a(context, b, bundle, null);
                            }
                        }
                        break;
                }
            }
            bundle = null;
            return this.f12561b.a(context, b, bundle, null);
        }
        Builder a = new Builder().a(graphQLStory.c()).b(graphQLStory.g()).a(graphQLStory).d(graphQLStory).b(graphQLStory).c(graphQLStory).a(NotificationSource.JEWEL).a(GraphQLHelper.i(graphQLStory));
        GraphQLComment a2 = GraphQLHelper.a(graphQLStory);
        String h = GraphQLHelper.h(graphQLStory);
        if (h != null) {
            a.a(CommentOrderType.getOrder(h));
            if (a2 != null) {
                a.d(a2.y());
            }
        }
        a.a(GraphQLHelper.e(graphQLStory));
        if (GraphQLStoryUtil.q(graphQLStory.L())) {
            a.e(graphQLStory.L().aJ().b());
        }
        Intent a3 = this.f12560a.a(a.a());
        if (a3 == null) {
            return false;
        }
        a3.putExtra("notification_launch_source", "source_jewel");
        this.f12563d.a(a3, context);
        return true;
    }

    private static void m13336a(GraphQLStory graphQLStory, Bundle bundle) {
        ImmutableList M = graphQLStory.M();
        if (m13338a(M)) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(0);
            GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment.j(), 44201556);
            if (a != null) {
                GraphQLNode z = graphQLStoryAttachment.z();
                M = a.aK();
                if (M != null && !M.isEmpty()) {
                    if (M.size() > 4) {
                        M = M.subList(0, 4);
                    }
                    bundle.putString("notification_launch_source", "source_jewel");
                    GroupIntentBuilder.a(bundle, z.dp(), z.eP(), M);
                }
            }
        }
    }

    private boolean m13337a(GraphQLStory graphQLStory) {
        for (WeakReference weakReference : this.f12568i) {
            2 2 = (2) weakReference.get();
            if (2 != null) {
                Object obj;
                BackstageFragmentInitializer backstageFragmentInitializer = 2.b;
                BackstageFragmentInitializer.a(2.a.n);
                GraphQLObjectType c = 2.b.c.m13360c(graphQLStory);
                if (c == null || c.g() != -864712441) {
                    obj = null;
                } else {
                    2.a.kZ_();
                    obj = 1;
                }
                if (obj != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void m13344a(2 2) {
        m13346b(2);
        this.f12568i.add(new WeakReference(2));
    }

    public final void m13346b(2 2) {
        for (WeakReference weakReference : this.f12568i) {
            if (Objects.equal(2, weakReference.get())) {
                this.f12568i.remove(weakReference);
                return;
            }
        }
    }

    private static void m13340b(GraphQLStory graphQLStory, Bundle bundle) {
        GraphQLProfile a = FeedUnitItemProfileHelper.a(graphQLStory);
        if (a != null) {
            ModelBundle.a(bundle, a.b(), a.ai() == null ? null : a.ai().b(), a.U());
        }
    }

    private static void m13341c(GraphQLStory graphQLStory, Bundle bundle) {
        ActionSource.putActionRef(bundle, ActionSource.NOTIFICATION);
        bundle.putString("story_cache_id", graphQLStory.g());
    }

    private String m13342d(GraphQLStory graphQLStory, Bundle bundle) {
        ImmutableList M = graphQLStory.M();
        if (!m13338a(M)) {
            return null;
        }
        String formatStrLocaleSafe;
        Set hashSet = new HashSet();
        hashSet.add("Recent Check-ins");
        hashSet.add("Recent Reviews");
        hashSet.add("Recent Shares");
        hashSet.add("Recent Mentions");
        Set set = hashSet;
        GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) ((GraphQLStoryAttachment) M.get(0)).j().get(0);
        String dp = ((GraphQLStoryAttachment) M.get(0)).z().dp();
        String eP = ((GraphQLStoryAttachment) M.get(0)).z().eP();
        if (set.contains(graphQLStoryActionLink.aB())) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.af, dp);
            bundle.putBoolean("extra_is_admin", true);
            bundle.putSerializable("extra_page_tab", PagesFb4aTabs.ACTIVITY);
        } else {
            formatStrLocaleSafe = null;
        }
        if (graphQLStoryActionLink.a() != null) {
            if (graphQLStoryActionLink.a().g() == 693396622) {
                ArrayList arrayList = new ArrayList();
                if (((GraphQLStoryAttachment) M.get(0)).x() != null) {
                    M = ((GraphQLStoryAttachment) M.get(0)).x();
                    int size = M.size();
                    for (int i = 0; i < size; i++) {
                        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(i);
                        if (!(graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().dp() == null)) {
                            arrayList.add(graphQLStoryAttachment.z().dp());
                        }
                    }
                }
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.at, dp);
                bundle.putString("extra_page_name", eP);
                bundle.putStringArrayList("event_id", arrayList);
                bundle.putString("extra_ref_module", "notifications".toString());
            } else if (graphQLStoryActionLink.a().g() == 848958408 && this.f12567h.a(ExperimentsForNotificationsAbtestModule.f7757F, false)) {
                bundle.putBoolean("force_external_activity", true);
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aA, dp);
            }
        }
        return formatStrLocaleSafe;
    }

    @Nullable
    private static String m13343e(GraphQLStory graphQLStory, Bundle bundle) {
        ImmutableList M = graphQLStory.M();
        if (!m13338a(M)) {
            return null;
        }
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(0);
        GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) graphQLStoryAttachment.j().get(0);
        if (graphQLStoryActionLink.a() != null && graphQLStoryActionLink.a().g() == -1029190389) {
            GraphQLImageOverlay ax = graphQLStoryActionLink.ax();
            if (!(ax == null || ax.l() == null)) {
                bundle.putParcelable("heisman_camera_intent_data", ((ProfilePictureOverlayCameraIntentData.Builder) ((ProfilePictureOverlayCameraIntentData.Builder) ((ProfilePictureOverlayCameraIntentData.Builder) new ProfilePictureOverlayCameraIntentData.Builder(ImageOverlayConversionHelper.a(ax), SafeUUIDGenerator.a().toString(), "notification").a(graphQLStoryActionLink.s())).b(graphQLStoryAttachment.B())).a(0)).a());
                return StringFormatUtil.formatStrLocaleSafe(FBLinks.cn, ax.l(), "notification");
            }
        }
        return null;
    }

    private static boolean m13338a(@Nullable ImmutableList<GraphQLStoryAttachment> immutableList) {
        return (immutableList == null || immutableList.isEmpty() || immutableList.get(0) == null || ((GraphQLStoryAttachment) immutableList.get(0)).z() == null || ((GraphQLStoryAttachment) immutableList.get(0)).z().dp() == null || ((GraphQLStoryAttachment) immutableList.get(0)).j() == null || ((GraphQLStoryAttachment) immutableList.get(0)).j().isEmpty() || ((GraphQLStoryAttachment) immutableList.get(0)).j().get(0) == null) ? false : true;
    }
}
