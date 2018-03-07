package com.facebook.notifications.action;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLNotifOptionClientActionType;
import com.facebook.graphql.enums.GraphQLNotifOptionRowSetDisplayStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.abtest.NotificationsJewelExperimentController;
import com.facebook.notifications.logging.NotificationsActionLogger;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.NotifOptionSetsModel.EdgesModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.NotifOptionSetsModel.EdgesModel.NodeModel.NotifOptionsModel.NotifOptionsEdgesModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotifInlineActionOptionFragmentModel;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.3;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: experiment */
public class NotificationsInlineActionsHelperV2 {
    private static final Map<Enum, Integer> f12616a;
    private static volatile NotificationsInlineActionsHelperV2 f12617f;
    private final NotificationsJewelExperimentController f12618b;
    public final NotificationsActionExecutor f12619c;
    private final NotificationsActionLogger f12620d;
    public final NotificationsActionsSupportedStyles f12621e;

    public static com.facebook.notifications.action.NotificationsInlineActionsHelperV2 m13428a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12617f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.action.NotificationsInlineActionsHelperV2.class;
        monitor-enter(r1);
        r0 = f12617f;	 Catch:{ all -> 0x003a }
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
        r0 = m13434b(r0);	 Catch:{ all -> 0x0035 }
        f12617f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12617f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.action.NotificationsInlineActionsHelperV2.a(com.facebook.inject.InjectorLike):com.facebook.notifications.action.NotificationsInlineActionsHelperV2");
    }

    private static NotificationsInlineActionsHelperV2 m13434b(InjectorLike injectorLike) {
        return new NotificationsInlineActionsHelperV2(NotificationsJewelExperimentController.m8058b(injectorLike), NotificationsActionExecutor.m13401a(injectorLike), NotificationsActionLogger.m13421b(injectorLike), NotificationsActionsSupportedStyles.m8056b(injectorLike));
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        f12616a = arrayMap;
        arrayMap.put(GraphQLNotifOptionClientActionType.HIDE, Integer.valueOf(2130839920));
        f12616a.put(GraphQLNotifOptionClientActionType.UNSUB, Integer.valueOf(2130840145));
        f12616a.put(GraphQLNotifOptionClientActionType.SHOW_MORE, Integer.valueOf(2130839963));
        f12616a.put(GraphQLNotifOptionClientActionType.OPEN_ACTION_SHEET, Integer.valueOf(2130839963));
    }

    @Inject
    public NotificationsInlineActionsHelperV2(NotificationsJewelExperimentController notificationsJewelExperimentController, NotificationsActionExecutor notificationsActionExecutor, NotificationsActionLogger notificationsActionLogger, NotificationsActionsSupportedStyles notificationsActionsSupportedStyles) {
        this.f12618b = notificationsJewelExperimentController;
        this.f12619c = notificationsActionExecutor;
        this.f12620d = notificationsActionLogger;
        this.f12621e = notificationsActionsSupportedStyles;
    }

    public final boolean m13437a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, View view, 3 3, String str, int i) {
        if (!m13436a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields)) {
            return false;
        }
        if (GraphQLNotifOptionRowSetDisplayStyle.ACTION_SHEET_MENU.name().equals(this.f12618b.m8060f())) {
            m13431a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, view.getContext(), 3, str, i);
        } else {
            m13435b(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, view, 3, str, i);
        }
        this.f12620d.m13422a("inline_actions_launched", null, str, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k(), i);
        return true;
    }

    public final boolean m13436a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) {
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo824m() == null || fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo824m().a().isEmpty() || fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k() == null) {
            return false;
        }
        ImmutableList a = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo824m().a();
        int size = a.size();
        int i = 0;
        while (i < size) {
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            if (!(edgesModel.a() == null || edgesModel.a().a() == null || edgesModel.a().a().a().isEmpty())) {
                boolean z;
                if (edgesModel.a() == null || edgesModel.a().b() == null || edgesModel.a().b().c() == null) {
                    z = false;
                } else {
                    z = this.f12621e.f7711c.containsKey(edgesModel.a().b().c().name());
                }
                if (z) {
                    i++;
                }
            }
            return false;
        }
        return true;
    }

    private void m13435b(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, View view, 3 3, String str, int i) {
        PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(view.getContext());
        ImmutableList a = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo824m().a();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            EdgesModel edgesModel = (EdgesModel) a.get(i2);
            ImmutableList a2 = edgesModel.a().a().a();
            int size2 = a2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2 = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
                m13432a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2, edgesModel.a().b().c(), (NotifOptionsEdgesModel) a2.get(i3), popoverMenuWindow.c(), 3, str, i);
            }
        }
        popoverMenuWindow.mo538a(view);
    }

    private void m13431a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, Context context, 3 3, String str, int i) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(context);
        ImmutableList a = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo824m().a();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            EdgesModel edgesModel = (EdgesModel) a.get(i2);
            ImmutableList a2 = edgesModel.a().a().a();
            int size2 = a2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                NotifOptionsEdgesModel notifOptionsEdgesModel = (NotifOptionsEdgesModel) a2.get(i3);
                m13429a(context, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, edgesModel.a().b().c(), notifOptionsEdgesModel, bottomSheetAdapter, 3, str, i);
            }
        }
        bottomSheetDialog.a(bottomSheetAdapter);
        bottomSheetDialog.show();
    }

    private void m13432a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, GraphQLNotifOptionRowSetDisplayStyle graphQLNotifOptionRowSetDisplayStyle, NotifOptionsEdgesModel notifOptionsEdgesModel, PopoverMenu popoverMenu, 3 3, String str, int i) {
        if (m13433a(graphQLNotifOptionRowSetDisplayStyle, notifOptionsEdgesModel)) {
            FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2 = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
            m13430a(null, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2, notifOptionsEdgesModel.a(), popoverMenu.a(notifOptionsEdgesModel.a().b().gp_().a()), 3, str, i);
        }
    }

    private void m13429a(Context context, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, GraphQLNotifOptionRowSetDisplayStyle graphQLNotifOptionRowSetDisplayStyle, NotifOptionsEdgesModel notifOptionsEdgesModel, BottomSheetAdapter bottomSheetAdapter, 3 3, String str, int i) {
        if (m13433a(graphQLNotifOptionRowSetDisplayStyle, notifOptionsEdgesModel)) {
            Context context2 = context;
            FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2 = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
            m13430a(context2, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2, notifOptionsEdgesModel.a(), bottomSheetAdapter.a(notifOptionsEdgesModel.a().b().gp_().a()), 3, str, i);
        }
    }

    private void m13430a(@Nullable Context context, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, NotifInlineActionOptionFragmentModel notifInlineActionOptionFragmentModel, MenuItemImpl menuItemImpl, 3 3, String str, int i) {
        if (notifInlineActionOptionFragmentModel.a() != null && f12616a.containsKey(notifInlineActionOptionFragmentModel.a().b())) {
            menuItemImpl.setIcon(((Integer) f12616a.get(notifInlineActionOptionFragmentModel.a().b())).intValue());
        }
        menuItemImpl.setOnMenuItemClickListener(new 1(this, context, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, notifInlineActionOptionFragmentModel, 3, str, i));
    }

    private boolean m13433a(GraphQLNotifOptionRowSetDisplayStyle graphQLNotifOptionRowSetDisplayStyle, NotifOptionsEdgesModel notifOptionsEdgesModel) {
        if (!(notifOptionsEdgesModel.a() == null || notifOptionsEdgesModel.a().b() == null || notifOptionsEdgesModel.a().b().gp_() == null || Strings.isNullOrEmpty(notifOptionsEdgesModel.a().b().gp_().a()))) {
            if (((ImmutableList) this.f12621e.f7711c.get(graphQLNotifOptionRowSetDisplayStyle.name())).contains(notifOptionsEdgesModel.a().b().c().name())) {
                return true;
            }
        }
        return false;
    }
}
