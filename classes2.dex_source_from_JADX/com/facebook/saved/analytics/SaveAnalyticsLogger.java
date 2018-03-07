package com.facebook.saved.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.graphql.enums.GraphQLStorySaveNuxType;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pyml_fan */
public class SaveAnalyticsLogger {
    private static volatile SaveAnalyticsLogger f8566c;
    public final AnalyticsLogger f8567a;
    public final NavigationLogger f8568b;

    public static com.facebook.saved.analytics.SaveAnalyticsLogger m13117a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8566c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.saved.analytics.SaveAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f8566c;	 Catch:{ all -> 0x003a }
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
        r0 = m13118b(r0);	 Catch:{ all -> 0x0035 }
        f8566c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8566c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved.analytics.SaveAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.saved.analytics.SaveAnalyticsLogger");
    }

    private static SaveAnalyticsLogger m13118b(InjectorLike injectorLike) {
        return new SaveAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NavigationLogger.m5475a(injectorLike));
    }

    @Inject
    public SaveAnalyticsLogger(AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger) {
        this.f8567a = analyticsLogger;
        this.f8568b = navigationLogger;
    }

    public final void m13122a(@Nullable String str, UndoAction undoAction) {
        UndoAction undoAction2 = undoAction;
        this.f8568b.m5517b("saved_dashboard", null, null, ImmutableMap.of("action_name", "saved_dashboard_undo_button_clicked", "object_id", Strings.nullToEmpty(str), "undo_action", undoAction2, "event_id", SafeUUIDGenerator.m2795a().toString()));
    }

    public final void m13120a(@Nullable String str, GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType) {
        GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType2 = graphQLSavedDashboardSectionType;
        this.f8568b.m5517b("saved_dashboard", null, null, ImmutableMap.of("action_name", "saved_dashboard_item_clicked", "object_id", Strings.nullToEmpty(str), "section_type", graphQLSavedDashboardSectionType2, "event_id", SafeUUIDGenerator.m2795a().toString()));
    }

    public final void m13123a(String str, @Nullable String str2, CurationMechanism curationMechanism) {
        CurationMechanism curationMechanism2 = curationMechanism;
        this.f8568b.m5517b(str, null, null, ImmutableMap.of("action_name", "saved_more_menu_item_clicked", "object_id", Strings.nullToEmpty(str2), "mechanism", curationMechanism2, "event_id", SafeUUIDGenerator.m2795a().toString()));
    }

    public final void m13128a(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nonnull CurationSurface curationSurface, @Nonnull CurationMechanism curationMechanism) {
        this.f8568b.m5517b(str, null, null, new Builder().m609b("action_name", "saved_collection_saved_button_clicked").m609b("object_id", Strings.nullToEmpty(str2)).m609b("story_id", Strings.nullToEmpty(str3)).m609b("url", Strings.nullToEmpty(str4)).m609b("collection_id", Strings.nullToEmpty(str5)).m609b("surface", curationSurface.toString()).m609b("mechanism", curationMechanism).m609b("event_id", SafeUUIDGenerator.m2795a().toString()).m610b());
    }

    public final void m13119a(GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType, GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType2) {
        GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType3 = graphQLSavedDashboardSectionType;
        GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType4 = graphQLSavedDashboardSectionType2;
        this.f8568b.m5517b("saved_dashboard", null, null, ImmutableMap.of("action_name", "saved_dashboard_section_list_item_clicked", "current_section_type", graphQLSavedDashboardSectionType3, "next_section_type", graphQLSavedDashboardSectionType4, "event_id", SafeUUIDGenerator.m2795a().toString()));
    }

    public final void m13130b(GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType, GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType2) {
        GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType3 = graphQLSavedDashboardSectionType;
        GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType4 = graphQLSavedDashboardSectionType2;
        this.f8568b.m5517b("saved_dashboard", null, null, ImmutableMap.of("action_name", "saved_dashboard_filter_section_clicked", "current_section_type", graphQLSavedDashboardSectionType3, "next_section_type", graphQLSavedDashboardSectionType4, "event_id", SafeUUIDGenerator.m2795a().toString()));
    }

    public final void m13124a(String str, String str2, CurationSurface curationSurface) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("saved_collection_story_caret_imp");
        honeyClientEvent.f3099c = str;
        this.f8567a.mo526a(honeyClientEvent.m5090b("story_id", str2).m5090b("surface", curationSurface.toString()).m5090b("event_id", SafeUUIDGenerator.m2795a().toString()));
    }

    public final void m13127a(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nonnull CurationSurface curationSurface, @Nonnull CurationMechanism curationMechanism, boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("saved_collection_save_button_imp");
        honeyClientEvent.f3099c = str;
        this.f8567a.mo526a(honeyClientEvent.m5090b("object_id", Strings.nullToEmpty(str2)).m5090b("story_id", Strings.nullToEmpty(str3)).m5090b("collection_id", Strings.nullToEmpty(str4)).m5090b("surface", curationSurface.toString()).m5090b("mechanism", curationMechanism.toString()).m5090b("is_save_button", String.valueOf(z)).m5090b("event_id", SafeUUIDGenerator.m2795a().toString()));
    }

    public final void m13121a(String str, GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("saved_dashboard_saved_item_vpv");
        honeyClientEvent.f3099c = "saved_dashboard";
        this.f8567a.mo526a(honeyClientEvent.m5090b("object_id", str).m5086a("dashboard_section_type", (Object) graphQLSavedDashboardSectionType).m5086a("timespan_ms", Long.valueOf(j)).m5090b("event_id", SafeUUIDGenerator.m2795a().toString()));
    }

    public final void m13129a(String str, String str2, List<CurationMechanism> list, CurationMechanism curationMechanism) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("saved_more_menu_imp");
        honeyClientEvent.f3099c = str;
        this.f8567a.mo526a(honeyClientEvent.m5090b("object_id", str2).m5090b("options", Joiner.on("|").join((Iterable) list)).m5086a("mechanism", (Object) curationMechanism).m5090b("event_id", SafeUUIDGenerator.m2795a().toString()));
    }

    public final void m13125a(String str, @Nullable String str2, @Nonnull CurationSurface curationSurface, @Nonnull CurationMechanism curationMechanism, @Nonnull GraphQLStorySaveNuxType graphQLStorySaveNuxType) {
        this.f8568b.m5517b(str, null, null, ImmutableMap.builder().m609b("action_name", "saved_caret_nux_clicked").m609b("story_id", Strings.nullToEmpty(str2)).m609b("surface", curationSurface.toString()).m609b("mechanism", curationMechanism.toString()).m609b("nux_type", graphQLStorySaveNuxType.toString()).m609b("event_id", SafeUUIDGenerator.m2795a().toString()).m610b());
    }

    public final void m13131b(String str, @Nullable String str2, @Nonnull CurationSurface curationSurface, @Nonnull CurationMechanism curationMechanism, @Nonnull GraphQLStorySaveNuxType graphQLStorySaveNuxType) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("saved_caret_nux_imp");
        honeyClientEvent.f3099c = str;
        this.f8567a.mo526a(honeyClientEvent.m5090b("story_id", Strings.nullToEmpty(str2)).m5090b("surface", curationSurface.toString()).m5090b("mechanism", curationMechanism.toString()).m5090b("event_id", SafeUUIDGenerator.m2795a().toString()).m5090b("nux_type", graphQLStorySaveNuxType.toString()));
    }

    public final void m13126a(String str, @Nullable String str2, @Nullable String str3, @Nonnull CurationSurface curationSurface, @Nonnull CurationMechanism curationMechanism) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("saved_button_nux_imp");
        honeyClientEvent.f3099c = str;
        this.f8567a.mo526a(honeyClientEvent.m5090b("event_id", SafeUUIDGenerator.m2795a().toString()).m5090b("object_id", Strings.nullToEmpty(str2)).m5090b("collection_id", Strings.nullToEmpty(str3)).m5086a("surface", (Object) curationSurface).m5086a("mechanism", (Object) curationMechanism));
    }
}
