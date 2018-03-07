package com.facebook.notifications.action;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.NotifOptionActionInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.notifications.event.NotificationsEventBus;
import com.facebook.notifications.logging.NotificationSettingsLogger;
import com.facebook.notifications.logging.NotificationSettingsLogger.Surface;
import com.facebook.notifications.logging.NotificationsActionLogger;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotifInlineActionOptionFragmentModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationOptionRowModel;
import com.facebook.notifications.protocol.NotifOptionRowsMutation;
import com.facebook.notifications.protocol.NotifOptionRowsMutation.NotifOptionActionMutationString;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment.NotifOptions.Nodes;
import com.facebook.notifications.protocol.NotificationsOptionRowCommonGraphQLInterfaces.SubmenuOptionSetFragment;
import com.facebook.notifications.settings.bottomsheet.NotificationBottomSheetAdapterProvider;
import com.facebook.notifications.util.NotificationsInlineActionsHelper.InlineAction;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.3;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.RowWithActionTaken;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: experiment_name */
public class NotificationsActionExecutor {
    private static volatile NotificationsActionExecutor f12603k;
    private final NotificationBottomSheetAdapterProvider f12604a;
    private final FbUriIntentHandler f12605b;
    public final Provider<ComponentName> f12606c;
    private final Lazy<GraphQLQueryExecutor> f12607d;
    private final NotificationsActionLogger f12608e;
    public final NotificationsEventBus f12609f;
    private final RuntimePermissionsUtil f12610g;
    public final SecureContextHelper f12611h;
    public final NotificationSettingsLogger f12612i;
    private final Executor f12613j;

    public static com.facebook.notifications.action.NotificationsActionExecutor m13401a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12603k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.action.NotificationsActionExecutor.class;
        monitor-enter(r1);
        r0 = f12603k;	 Catch:{ all -> 0x003a }
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
        r0 = m13408b(r0);	 Catch:{ all -> 0x0035 }
        f12603k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12603k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.action.NotificationsActionExecutor.a(com.facebook.inject.InjectorLike):com.facebook.notifications.action.NotificationsActionExecutor");
    }

    private static NotificationsActionExecutor m13408b(InjectorLike injectorLike) {
        return new NotificationsActionExecutor((NotificationBottomSheetAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NotificationBottomSheetAdapterProvider.class), FbUriIntentHandler.a(injectorLike), IdBasedProvider.a(injectorLike, 12), IdBasedLazy.a(injectorLike, 2164), NotificationsActionLogger.m13421b(injectorLike), NotificationsEventBus.m13334a(injectorLike), RuntimePermissionsUtil.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), NotificationSettingsLogger.m13424b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    private void m13407a(NotificationsServerActionParams notificationsServerActionParams) {
        if (!Strings.isNullOrEmpty(notificationsServerActionParams.d)) {
            NotifOptionActionInputData a = new NotifOptionActionInputData().c(notificationsServerActionParams.d).a(SafeUUIDGenerator.a().toString());
            if (!Strings.isNullOrEmpty(notificationsServerActionParams.a)) {
                a.a("story_id", notificationsServerActionParams.a);
            }
            NotifOptionActionMutationString a2 = NotifOptionRowsMutation.a();
            a2.a("input", a);
            Futures.a(((GraphQLQueryExecutor) this.f12607d.get()).a(GraphQLRequest.a(a2)), new NotificationsActionExecutedCallback(this, notificationsServerActionParams), this.f12613j);
            NotificationSettingsLogger notificationSettingsLogger = this.f12612i;
            Surface surface = notificationsServerActionParams.g;
            notificationSettingsLogger.f12615a.a(NotificationSettingsLogger.m13423a("native_settings_changed", surface).b("server_action", notificationsServerActionParams.d));
        }
    }

    @Inject
    public NotificationsActionExecutor(NotificationBottomSheetAdapterProvider notificationBottomSheetAdapterProvider, FbUriIntentHandler fbUriIntentHandler, @FragmentChromeActivity Provider<ComponentName> provider, Lazy<GraphQLQueryExecutor> lazy, NotificationsActionLogger notificationsActionLogger, NotificationsEventBus notificationsEventBus, RuntimePermissionsUtil runtimePermissionsUtil, SecureContextHelper secureContextHelper, NotificationSettingsLogger notificationSettingsLogger, ExecutorService executorService) {
        this.f12604a = notificationBottomSheetAdapterProvider;
        this.f12605b = fbUriIntentHandler;
        this.f12606c = provider;
        this.f12607d = lazy;
        this.f12608e = notificationsActionLogger;
        this.f12609f = notificationsEventBus;
        this.f12610g = runtimePermissionsUtil;
        this.f12611h = secureContextHelper;
        this.f12612i = notificationSettingsLogger;
        this.f12613j = executorService;
    }

    public final void m13415a(Context context, Nodes nodes, Surface surface) {
        m13405a(context, nodes, surface, null, null, null, null);
    }

    public final void m13417a(Context context, Nodes nodes, Surface surface, String str) {
        m13405a(context, nodes, surface, null, null, null, str);
    }

    public final void m13416a(Context context, Nodes nodes, Surface surface, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, String str, @Nullable String str2) {
        m13405a(context, nodes, surface, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, str, str2, null);
    }

    private void m13405a(Context context, Nodes nodes, Surface surface, @Nullable FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (nodes != null && nodes.b() != null && nodes.b().b() != null) {
            NotificationsServerActionParams notificationsServerActionParams;
            switch (2.a[nodes.b().b().ordinal()]) {
                case 1:
                    m13409b(context, nodes);
                    return;
                case 2:
                    m13404a(context, nodes);
                    return;
                case 3:
                case 4:
                    if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields != null && nodes.d() != null && nodes.d().k() != null) {
                        notificationsServerActionParams = new NotificationsServerActionParams(nodes.gx_(), surface);
                        notificationsServerActionParams.e = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
                        NotificationsServerActionParams notificationsServerActionParams2 = notificationsServerActionParams;
                        notificationsServerActionParams2.f = nodes.c();
                        notificationsServerActionParams2 = notificationsServerActionParams2;
                        notificationsServerActionParams2.h = str2;
                        notificationsServerActionParams2 = notificationsServerActionParams2;
                        notificationsServerActionParams2.i = nodes.d().k().a();
                        notificationsServerActionParams2.c = str;
                        m13407a(notificationsServerActionParams);
                        return;
                    }
                    return;
                case 5:
                    notificationsServerActionParams = new NotificationsServerActionParams(nodes.gx_(), surface);
                    notificationsServerActionParams.b = str3;
                    m13407a(notificationsServerActionParams);
                    return;
                case 6:
                    if (!Strings.isNullOrEmpty(nodes.b().gy_())) {
                        Intent component = new Intent().setComponent((ComponentName) this.f12606c.get());
                        component.putExtra("event_id", nodes.b().gy_());
                        component.putExtra("target_fragment", ContentFragmentType.EVENTS_NOTIFICATION_SETTINGS_FRAGMENT.ordinal());
                        this.f12611h.a(component, context);
                        this.f12612i.m13427a(Surface.ENTITY_ROW, nodes.c(), nodes.b().gy_());
                    }
                    return;
                case 7:
                    m13412e(context, nodes);
                    return;
                case 8:
                    m13410c(context, nodes);
                    return;
                case 9:
                    m13411d(context, nodes);
                    return;
                case 10:
                    m13413f(context, nodes);
                    return;
                case 11:
                    m13402a();
                    return;
                default:
                    return;
            }
        }
    }

    public final void m13418a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, NotificationOptionRowModel notificationOptionRowModel, Context context, @Nullable 3 3, String str, int i) {
        if (InlineAction.SETTINGS_ACTION.name.equalsIgnoreCase(notificationOptionRowModel.a())) {
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.facebook.katana.NotificationSettingsActivity");
            this.f12611h.a(intent, context);
        } else {
            NotificationsServerActionParams notificationsServerActionParams = new NotificationsServerActionParams(notificationOptionRowModel.c(), Surface.INLINE_ACTION);
            notificationsServerActionParams.a = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k().c();
            m13407a(notificationsServerActionParams);
            if (3 != null) {
                RowWithActionTaken rowWithActionTaken = new RowWithActionTaken(3.a, 3.b, notificationOptionRowModel);
                if (3.c.f12629f.m13399d() && InlineAction.UNSUB_CLIENT_ACTION.name.equals(notificationOptionRowModel.a())) {
                    rowWithActionTaken.g = false;
                }
                3.c.m13442a(rowWithActionTaken);
            }
        }
        this.f12608e.m13422a("inline_action_selected", notificationOptionRowModel.c(), str, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k(), i);
    }

    public final void m13414a(Context context, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, NotifInlineActionOptionFragmentModel notifInlineActionOptionFragmentModel, @Nullable 3 3, String str, int i) {
        switch (2.a[notifInlineActionOptionFragmentModel.a().b().ordinal()]) {
            case 2:
            case 12:
                m13403a(context, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, notifInlineActionOptionFragmentModel);
                break;
            case 4:
            case 13:
                NotificationsServerActionParams notificationsServerActionParams = new NotificationsServerActionParams(notifInlineActionOptionFragmentModel.c(), Surface.INLINE_ACTION);
                notificationsServerActionParams.a = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k().c();
                m13407a(notificationsServerActionParams);
                if (3 != null) {
                    3.a(notifInlineActionOptionFragmentModel);
                    break;
                }
                break;
        }
        this.f12608e.m13422a("inline_action_selected", notifInlineActionOptionFragmentModel.c(), str, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k(), i);
    }

    public final void m13419a(String str, String str2, GraphQLStory graphQLStory, int i) {
        this.f12608e.m13422a("inline_action_undo", str, str2, graphQLStory, i);
        NotificationsServerActionParams notificationsServerActionParams = new NotificationsServerActionParams(str, Surface.INLINE_ACTION);
        notificationsServerActionParams.a = graphQLStory.c();
        m13407a(notificationsServerActionParams);
    }

    private void m13404a(Context context, Nodes nodes) {
        if (nodes.b() instanceof SubmenuOptionSetFragment) {
            SubmenuOptionSetFragment submenuOptionSetFragment = (SubmenuOptionSetFragment) nodes.b();
            if (submenuOptionSetFragment.c().size() == 1) {
                m13406a(context, submenuOptionSetFragment, null, nodes.c());
                this.f12612i.m13426a(Surface.ENTITY_ROW, nodes.c());
            }
        }
    }

    private void m13403a(Context context, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, NotifInlineActionOptionFragmentModel notifInlineActionOptionFragmentModel) {
        SubmenuOptionSetFragment a = notifInlineActionOptionFragmentModel.a();
        if (a != null && a.c().size() == 1) {
            NotifOptionSetFragment notifOptionSetFragment = (NotifOptionSetFragment) a.c().get(0);
            if (notifOptionSetFragment.d() != null && notifOptionSetFragment.d().c() != null) {
                switch (2.b[notifOptionSetFragment.d().c().ordinal()]) {
                    case 1:
                        m13406a(context, a, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void m13406a(Context context, SubmenuOptionSetFragment submenuOptionSetFragment, @Nullable FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, @Nullable String str) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.a(this.f12604a.m13420a((NotifOptionSetFragment) submenuOptionSetFragment.c().get(0), context, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, str, new 1(this, bottomSheetDialog)));
        bottomSheetDialog.e = 1;
        bottomSheetDialog.c = BottomSheetDialog.a[bottomSheetDialog.e];
        bottomSheetDialog.d = BottomSheetDialog.a[bottomSheetDialog.e];
        bottomSheetDialog.b.d = bottomSheetDialog.c;
        bottomSheetDialog.b.e = bottomSheetDialog.d;
        bottomSheetDialog.show();
    }

    private void m13409b(Context context, Nodes nodes) {
        if (nodes.b() instanceof SubmenuOptionSetFragment) {
            SubmenuOptionSetFragment submenuOptionSetFragment = (SubmenuOptionSetFragment) nodes.b();
            ArrayList arrayList = new ArrayList();
            ImmutableList c = submenuOptionSetFragment.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                NotifOptionSetFragment notifOptionSetFragment = (NotifOptionSetFragment) c.get(i);
                if (notifOptionSetFragment.b() != null) {
                    arrayList.add(notifOptionSetFragment.b());
                }
            }
            String a = nodes.b().d() == null ? null : nodes.b().d().a();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("extra_option_row_set_ids", arrayList);
            if (!Strings.isNullOrEmpty(a)) {
                bundle.putString("fragment_title", a);
            }
            bundle.putBoolean("force_create_new_activity", true);
            this.f12605b.a(context, FBLinks.ck, bundle);
            this.f12612i.m13426a(Surface.ENTITY_ROW, nodes.c());
        }
    }

    private void m13410c(Context context, Nodes nodes) {
        this.f12605b.a(context, FBLinks.cl);
        this.f12612i.m13426a(Surface.ENTITY_ROW, nodes.c());
    }

    private void m13411d(Context context, Nodes nodes) {
        this.f12605b.a(context, FBLinks.G);
        this.f12612i.m13426a(Surface.ENTITY_ROW, nodes.c());
    }

    private void m13412e(Context context, Nodes nodes) {
        if (!Strings.isNullOrEmpty(nodes.b().gy_())) {
            Bundle bundle = new Bundle();
            bundle.putString("group_feed_id", nodes.b().gy_());
            this.f12605b.a(context, FBLinks.A, bundle);
            this.f12612i.m13427a(Surface.ENTITY_ROW, nodes.c(), nodes.b().gy_());
        }
    }

    private void m13413f(Context context, Nodes nodes) {
        this.f12605b.a(context, FBLinks.by);
        this.f12612i.m13426a(Surface.ENTITY_ROW, nodes.c());
    }

    private void m13402a() {
        RuntimePermissionsUtil runtimePermissionsUtil = this.f12610g;
        if (VERSION.SDK_INT >= 21) {
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.Settings$AppNotificationSettingsActivity");
            intent.putExtra("app_package", runtimePermissionsUtil.a.getPackageName());
            intent.putExtra("app_uid", runtimePermissionsUtil.a.getApplicationInfo().uid);
            intent.addFlags(268435456);
            runtimePermissionsUtil.b.b(intent, runtimePermissionsUtil.a);
            return;
        }
        runtimePermissionsUtil.b();
    }
}
