package com.facebook.timeline.refresher;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.graphql.enums.GraphQLProfileWizardStepType;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: updateInboxTabs() not supported yet */
public class ProfileRefresherAnalyticsLogger {
    private static volatile ProfileRefresherAnalyticsLogger f949b;
    private final AnalyticsLogger f950a;

    public static com.facebook.timeline.refresher.ProfileRefresherAnalyticsLogger m947a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f949b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.refresher.ProfileRefresherAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f949b;	 Catch:{ all -> 0x003a }
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
        r0 = m949b(r0);	 Catch:{ all -> 0x0035 }
        f949b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f949b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.ProfileRefresherAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.timeline.refresher.ProfileRefresherAnalyticsLogger");
    }

    private static ProfileRefresherAnalyticsLogger m949b(InjectorLike injectorLike) {
        return new ProfileRefresherAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProfileRefresherAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f950a = analyticsLogger;
    }

    public final void m951a(String str, ImmutableList<GraphQLProfileWizardStepType> immutableList, GraphQLProfileWizardStepType graphQLProfileWizardStepType) {
        m948a(str, immutableList, graphQLProfileWizardStepType, "profile_wizard_step_view");
    }

    public final void m953b(String str, ImmutableList<GraphQLProfileWizardStepType> immutableList, GraphQLProfileWizardStepType graphQLProfileWizardStepType) {
        m948a(str, immutableList, graphQLProfileWizardStepType, "profile_wizard_cancel_button_tap");
    }

    public final void m955c(String str, ImmutableList<GraphQLProfileWizardStepType> immutableList, GraphQLProfileWizardStepType graphQLProfileWizardStepType) {
        m948a(str, immutableList, graphQLProfileWizardStepType, "profile_wizard_skip_button_tap");
    }

    public final void m957d(String str, ImmutableList<GraphQLProfileWizardStepType> immutableList, GraphQLProfileWizardStepType graphQLProfileWizardStepType) {
        m948a(str, immutableList, graphQLProfileWizardStepType, "profile_wizard_upload_photo_from_camera_roll_tap");
    }

    public final void m958e(String str, ImmutableList<GraphQLProfileWizardStepType> immutableList, GraphQLProfileWizardStepType graphQLProfileWizardStepType) {
        m948a(str, immutableList, graphQLProfileWizardStepType, "profile_wizard_upload_photo_from_albums_tap");
    }

    public final void m959f(String str, ImmutableList<GraphQLProfileWizardStepType> immutableList, GraphQLProfileWizardStepType graphQLProfileWizardStepType) {
        m948a(str, immutableList, graphQLProfileWizardStepType, "profile_wizard_step_save");
    }

    public final void m950a(String str) {
        m948a(str, null, null, "profile_refresher_entry_point_tapped");
    }

    public final void m952b(String str) {
        m948a(str, null, null, "profile_nux_entry_point_view");
    }

    public final void m954c(String str) {
        m948a(str, null, null, "profile_nux_entry_point_close_button_tapped");
    }

    public final void m956d(String str) {
        m948a(str, null, null, "profile_nux_start_button_tapped");
    }

    private void m948a(String str, @Nullable ImmutableList<GraphQLProfileWizardStepType> immutableList, @Nullable GraphQLProfileWizardStepType graphQLProfileWizardStepType, String str2) {
        String str3 = null;
        HoneyClientEventFast a = this.f950a.a(str, false);
        if (a.a()) {
            JsonNode jsonNode;
            String str4 = "profile_wizard_flow_type";
            if (immutableList == null) {
                jsonNode = null;
            } else {
                ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    arrayNode.h(((GraphQLProfileWizardStepType) immutableList.get(i)).name());
                }
                jsonNode = arrayNode;
            }
            a.a(str4, jsonNode);
            String str5 = "profile_wizard_step_type";
            if (graphQLProfileWizardStepType != null) {
                str3 = graphQLProfileWizardStepType.name();
            }
            a.a(str5, str3);
            a.a("event_type", str2);
            a.b();
        }
    }
}
