package com.facebook.notifications.settings;

import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.graphql.enums.GraphQLNotifOptionRowSetDisplayStyle;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsRemovableGroupPartDefinition;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsSelectorGroupPartDefinition;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsTogglePartDefinition;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: minutiae_verb_picker_time_to_verbs_shown_cached */
public class NotificationSettingsOptionSetsStyleMapper {
    private static volatile NotificationSettingsOptionSetsStyleMapper f8731c;
    public final Map<GraphQLNotifOptionRowSetDisplayStyle, MultiRowPartWithIsNeeded> f8732a = new HashMap();
    public final Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> f8733b;

    public static com.facebook.notifications.settings.NotificationSettingsOptionSetsStyleMapper m10700a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8731c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.settings.NotificationSettingsOptionSetsStyleMapper.class;
        monitor-enter(r1);
        r0 = f8731c;	 Catch:{ all -> 0x003a }
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
        r0 = m10701b(r0);	 Catch:{ all -> 0x0035 }
        f8731c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8731c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.settings.NotificationSettingsOptionSetsStyleMapper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.settings.NotificationSettingsOptionSetsStyleMapper");
    }

    private static NotificationSettingsOptionSetsStyleMapper m10701b(InjectorLike injectorLike) {
        return new NotificationSettingsOptionSetsStyleMapper(NotificationSettingsBasicSetPartDefinition.m10676a(injectorLike), NotificationSettingsRemovableGroupPartDefinition.m10727a(injectorLike), NotificationSettingsSelectorGroupPartDefinition.m10731a(injectorLike), NotificationSettingsTogglePartDefinition.m10752a(injectorLike), IdBasedLazy.a(injectorLike, 6023));
    }

    @Inject
    public NotificationSettingsOptionSetsStyleMapper(NotificationSettingsBasicSetPartDefinition notificationSettingsBasicSetPartDefinition, NotificationSettingsRemovableGroupPartDefinition notificationSettingsRemovableGroupPartDefinition, NotificationSettingsSelectorGroupPartDefinition notificationSettingsSelectorGroupPartDefinition, NotificationSettingsTogglePartDefinition notificationSettingsTogglePartDefinition, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy) {
        this.f8732a.put(GraphQLNotifOptionRowSetDisplayStyle.MENU_SECTION_WITH_INDEPENDENT_ROWS, notificationSettingsBasicSetPartDefinition);
        this.f8732a.put(GraphQLNotifOptionRowSetDisplayStyle.MENU_SECTION_WITH_REMOVABLE_ROWS, notificationSettingsRemovableGroupPartDefinition);
        this.f8732a.put(GraphQLNotifOptionRowSetDisplayStyle.MULTI_SELECTOR, notificationSettingsSelectorGroupPartDefinition);
        this.f8732a.put(GraphQLNotifOptionRowSetDisplayStyle.SETTING_PAGE_SECTION, notificationSettingsBasicSetPartDefinition);
        this.f8732a.put(GraphQLNotifOptionRowSetDisplayStyle.SINGLE_SELECTOR, notificationSettingsSelectorGroupPartDefinition);
        this.f8732a.put(GraphQLNotifOptionRowSetDisplayStyle.TOGGLE, notificationSettingsTogglePartDefinition);
        this.f8733b = lazy;
    }
}
