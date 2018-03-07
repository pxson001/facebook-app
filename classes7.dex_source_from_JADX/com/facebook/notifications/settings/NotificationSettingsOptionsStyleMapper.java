package com.facebook.notifications.settings;

import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLNotifOptionRowDisplayStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsTextWithButtonPartDefinition;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsWashTextPartDefinition;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: minutiae_verb_picker_time_to_verbs_shown */
public class NotificationSettingsOptionsStyleMapper {
    private static volatile NotificationSettingsOptionsStyleMapper f8734b;
    private final Map<GraphQLNotifOptionRowDisplayStyle, MultiRowSinglePartDefinition> f8735a = new HashMap();

    public static com.facebook.notifications.settings.NotificationSettingsOptionsStyleMapper m10702a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8734b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.settings.NotificationSettingsOptionsStyleMapper.class;
        monitor-enter(r1);
        r0 = f8734b;	 Catch:{ all -> 0x003a }
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
        r0 = m10703b(r0);	 Catch:{ all -> 0x0035 }
        f8734b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8734b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.settings.NotificationSettingsOptionsStyleMapper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.settings.NotificationSettingsOptionsStyleMapper");
    }

    private static NotificationSettingsOptionsStyleMapper m10703b(InjectorLike injectorLike) {
        return new NotificationSettingsOptionsStyleMapper(NotificationSettingsPartDefinition.m10707a(injectorLike), NotificationSettingsTextWithButtonPartDefinition.m10744a(injectorLike), NotificationSettingsWashTextPartDefinition.m10760a(injectorLike));
    }

    @Inject
    public NotificationSettingsOptionsStyleMapper(NotificationSettingsPartDefinition notificationSettingsPartDefinition, NotificationSettingsTextWithButtonPartDefinition notificationSettingsTextWithButtonPartDefinition, NotificationSettingsWashTextPartDefinition notificationSettingsWashTextPartDefinition) {
        this.f8735a.put(GraphQLNotifOptionRowDisplayStyle.BASIC_MENU, notificationSettingsPartDefinition);
        this.f8735a.put(GraphQLNotifOptionRowDisplayStyle.TEXT_WITH_BUTTON, notificationSettingsTextWithButtonPartDefinition);
        this.f8735a.put(GraphQLNotifOptionRowDisplayStyle.PROFILE_IMAGE_OPTION, notificationSettingsPartDefinition);
        this.f8735a.put(GraphQLNotifOptionRowDisplayStyle.WASH_TEXTS, notificationSettingsWashTextPartDefinition);
    }

    @Nullable
    public final MultiRowSinglePartDefinition m10704a(GraphQLNotifOptionRowDisplayStyle graphQLNotifOptionRowDisplayStyle) {
        return (MultiRowSinglePartDefinition) this.f8735a.get(graphQLNotifOptionRowDisplayStyle);
    }

    public final boolean m10705b(GraphQLNotifOptionRowDisplayStyle graphQLNotifOptionRowDisplayStyle) {
        return this.f8735a.containsKey(graphQLNotifOptionRowDisplayStyle);
    }
}
