package com.facebook.notifications.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.facebook.common.util.CollectionUtil;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLNotifOptionRenderType;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.action.NotificationsActionExecutor;
import com.facebook.notifications.action.NotificationsInlineActionsHelperV2;
import com.facebook.notifications.logging.NotificationsActionLogger;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationOptionRowModel;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.3;
import com.facebook.notifications.widget.CaspianNotificationsView;
import com.facebook.notifications.widget.DefaultNotificationsRenderer;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: experiment_params */
public class NotificationsInlineActionsHelper {
    private static volatile NotificationsInlineActionsHelper f12593j;
    public final NotificationsActionExecutor f12594a;
    private final NotificationsActionLogger f12595b;
    private final NotificationsInlineActionsHelperV2 f12596c;
    private final QeAccessor f12597d;
    public final FbSharedPreferences f12598e;
    private final TodayExperimentController f12599f;
    public BottomSheetDialog f12600g;
    public PopoverMenuWindow f12601h;
    private final Map<String, Integer> f12602i = new C05961(this);

    /* compiled from: experiment_params */
    class C05961 extends ArrayMap<String, Integer> {
        final /* synthetic */ NotificationsInlineActionsHelper f12622i;

        C05961(NotificationsInlineActionsHelper notificationsInlineActionsHelper) {
            this.f12622i = notificationsInlineActionsHelper;
            put(InlineAction.HIDE_CLIENT_ACTION.name, Integer.valueOf(2130839920));
            put(InlineAction.UNSUB_CLIENT_ACTION.name, Integer.valueOf(2130840145));
            put(InlineAction.SETTINGS_ACTION.name, Integer.valueOf(2130840093));
        }
    }

    /* compiled from: experiment_params */
    public enum InlineAction {
        HIDE_CLIENT_ACTION("HIDE"),
        UNSUB_CLIENT_ACTION("UNSUB"),
        SETTINGS_ACTION("SETTINGS");
        
        static Set<String> sActions;
        public String name;

        static {
            sActions = new HashSet();
            InlineAction[] values = values();
            int length = values.length;
            int i;
            while (i < length) {
                sActions.add(values[i].name);
                i++;
            }
        }

        private InlineAction(String str) {
            this.name = str;
        }

        public static boolean contains(String str) {
            return sActions.contains(str);
        }
    }

    public static com.facebook.notifications.util.NotificationsInlineActionsHelper m13381a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12593j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.NotificationsInlineActionsHelper.class;
        monitor-enter(r1);
        r0 = f12593j;	 Catch:{ all -> 0x003a }
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
        r0 = m13390b(r0);	 Catch:{ all -> 0x0035 }
        f12593j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12593j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.NotificationsInlineActionsHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.NotificationsInlineActionsHelper");
    }

    private static NotificationsInlineActionsHelper m13390b(InjectorLike injectorLike) {
        return new NotificationsInlineActionsHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), NotificationsActionExecutor.m13401a(injectorLike), NotificationsActionLogger.m13421b(injectorLike), NotificationsInlineActionsHelperV2.m13428a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), TodayExperimentController.a(injectorLike));
    }

    @Inject
    public NotificationsInlineActionsHelper(FbSharedPreferences fbSharedPreferences, NotificationsActionExecutor notificationsActionExecutor, NotificationsActionLogger notificationsActionLogger, NotificationsInlineActionsHelperV2 notificationsInlineActionsHelperV2, QeAccessor qeAccessor, TodayExperimentController todayExperimentController) {
        this.f12598e = fbSharedPreferences;
        this.f12594a = notificationsActionExecutor;
        this.f12595b = notificationsActionLogger;
        this.f12596c = notificationsInlineActionsHelperV2;
        this.f12597d = qeAccessor;
        this.f12599f = todayExperimentController;
    }

    private boolean m13391b(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) {
        return m13388a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) && this.f12601h == null;
    }

    private PopoverMenu m13380a(Context context) {
        this.f12601h = new PopoverMenuWindow(context);
        this.f12601h.f5789H = new 2(this);
        return this.f12601h.c();
    }

    public final void m13394a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, Context context, View view, 3 3, int i) {
        if (m13391b(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) || this.f12596c.m13436a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields)) {
            if (!this.f12596c.m13437a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, view, 3, "long_press", i)) {
                m13382a(m13380a(context), fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3, i, "long_press");
                this.f12601h.mo538a(view);
                this.f12595b.m13422a("inline_actions_launched", null, "long_press", fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k(), i);
            }
        }
    }

    public final void m13396a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, Context context, CaspianNotificationsView caspianNotificationsView, 3 3, int i, boolean z, DefaultNotificationsRenderer.3 32, String str) {
        if (m13391b(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields)) {
            PopoverMenu a = m13380a(context);
            m13383a(a, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3, i, z);
            if (32 != null) {
                MenuItemImpl a2 = a.a(str);
                a2.setIcon(2130840076);
                a2.setOnMenuItemClickListener(new 3(this, 32));
            }
            this.f12601h.mo538a(caspianNotificationsView.r);
            this.f12595b.m13422a("inline_actions_launched", null, "chevron_v2", fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k(), i);
        }
    }

    public final void m13393a() {
        if (this.f12601h != null && this.f12601h.f5809r) {
            this.f12601h.mo542l();
        }
    }

    public final void m13395a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, Context context, 3 3, CaspianNotificationsView caspianNotificationsView, int i) {
        if (m13398c()) {
            m13385a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, context, 3, i);
        } else if (m13399d()) {
            m13396a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, context, caspianNotificationsView, 3, i, true, null, null);
        }
    }

    private void m13385a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, Context context, 3 3, int i) {
        if (!m13388a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields)) {
            return;
        }
        if (this.f12600g == null || !this.f12600g.isShowing()) {
            this.f12600g = new BottomSheetDialog(context);
            BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(context);
            m13386a(bottomSheetAdapter, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3, i);
            this.f12600g.setOnDismissListener(new 4(this));
            this.f12600g.a(bottomSheetAdapter);
            this.f12600g.show();
        }
    }

    public final boolean m13397b() {
        return this.f12597d.a(ExperimentsForNotificationsAbtestModule.f7770i, true) && !this.f12599f.v();
    }

    public final boolean m13398c() {
        return this.f12597d.a(ExperimentsForNotificationsAbtestModule.f7768g, false);
    }

    private boolean m13392g() {
        return this.f12597d.a(ExperimentsForNotificationsAbtestModule.f7771j, false);
    }

    public final boolean m13399d() {
        return this.f12597d.a(ExperimentsForNotificationsAbtestModule.f7769h, false);
    }

    public final boolean m13400e() {
        return (m13397b() || m13398c()) && !this.f12598e.a(NotificationsPreferenceConstants.f7719H, false);
    }

    public static boolean m13388a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) {
        if (CollectionUtil.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo823l())) {
            return false;
        }
        ImmutableList l = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo823l();
        int size = l.size();
        for (int i = 0; i < size; i++) {
            if (((NotificationOptionRowModel) l.get(i)).b() == GraphQLNotifOptionRenderType.CHEVRON) {
                return true;
            }
        }
        return false;
    }

    private void m13382a(PopoverMenu popoverMenu, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3 3, int i, String str) {
        ImmutableList l = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo823l();
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            NotificationOptionRowModel notificationOptionRowModel = (NotificationOptionRowModel) l.get(i2);
            if (m13389a(notificationOptionRowModel) && (!InlineAction.SETTINGS_ACTION.name.equals(notificationOptionRowModel.a()) || m13392g())) {
                m13384a(popoverMenu, notificationOptionRowModel, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3, i, str);
            }
        }
    }

    private void m13386a(BottomSheetAdapter bottomSheetAdapter, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3 3, int i) {
        ImmutableList l = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo823l();
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            NotificationOptionRowModel notificationOptionRowModel = (NotificationOptionRowModel) l.get(i2);
            if (m13389a(notificationOptionRowModel) && (!InlineAction.SETTINGS_ACTION.name.equals(notificationOptionRowModel.a()) || m13392g())) {
                m13387a(bottomSheetAdapter, notificationOptionRowModel, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3, i);
            }
        }
    }

    @SuppressLint({"DeprecatedClass"})
    private void m13383a(PopoverMenu popoverMenu, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3 3, int i, boolean z) {
        ImmutableList l = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo823l();
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            NotificationOptionRowModel notificationOptionRowModel = (NotificationOptionRowModel) l.get(i2);
            if (m13389a(notificationOptionRowModel) && !InlineAction.SETTINGS_ACTION.name.equals(notificationOptionRowModel.a()) && ((InlineAction.HIDE_CLIENT_ACTION.name.equals(notificationOptionRowModel.a()) && z) || !(InlineAction.HIDE_CLIENT_ACTION.name.equals(notificationOptionRowModel.a()) || z))) {
                m13384a(popoverMenu, notificationOptionRowModel, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3, i, "chevron_v2");
            }
        }
    }

    private static boolean m13389a(NotificationOptionRowModel notificationOptionRowModel) {
        return notificationOptionRowModel.b() == GraphQLNotifOptionRenderType.CHEVRON && InlineAction.contains(notificationOptionRowModel.a());
    }

    private void m13384a(PopoverMenu popoverMenu, NotificationOptionRowModel notificationOptionRowModel, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3 3, int i, String str) {
        MenuItemImpl a = popoverMenu.a(notificationOptionRowModel.d().a());
        Integer num = (Integer) this.f12602i.get(notificationOptionRowModel.a());
        if (num != null) {
            a.setIcon(num.intValue());
        }
        a.setOnMenuItemClickListener(new 5(this, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, notificationOptionRowModel, popoverMenu, 3, str, i));
    }

    private void m13387a(BottomSheetAdapter bottomSheetAdapter, NotificationOptionRowModel notificationOptionRowModel, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3 3, int i) {
        MenuItemImpl a = bottomSheetAdapter.a(notificationOptionRowModel.d().a());
        Integer num = (Integer) this.f12602i.get(notificationOptionRowModel.a());
        if (num != null) {
            a.setIcon(num.intValue());
        }
        a.setOnMenuItemClickListener(new 6(this, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, notificationOptionRowModel, bottomSheetAdapter, 3, i));
    }
}
