package com.facebook.crowdsourcing.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: open_suggesting_content */
public class PlaceCreationAnalyticsLogger {
    private static volatile PlaceCreationAnalyticsLogger f8650c;
    private final AnalyticsLogger f8651a;
    private final CrowdsourcingSession f8652b;

    /* compiled from: open_suggesting_content */
    public enum FieldType {
        PAGE_NAME("PAGE_NAME"),
        PAGE_PHOTO("PAGE_PHOTO"),
        PLACE_CATEGORY("PLACE_CATEGORY"),
        PLACE_CITY("PLACE_CITY"),
        PLACE_COORDINATES("PLACE_COORDINvATES"),
        PLACE_STREET_ADDRESS("PLACE_STREET_ADDRESS"),
        PLACE_ZIP_CODE("PLACE_ZIP_CODE");
        
        public final String name;

        private FieldType(String str) {
            this.name = str;
        }
    }

    /* compiled from: open_suggesting_content */
    public enum View {
        CATEGORY_PICKER("category_picker"),
        CITY_PICKER("city_picker"),
        PHOTO_PICKER("photo_picker"),
        HOME_CREATION("home_creation"),
        DEDUPER("deduper"),
        FORM("form");
        
        public final String logValue;

        private View(String str) {
            this.logValue = str;
        }
    }

    public static com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger m12449a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8650c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f8650c;	 Catch:{ all -> 0x003a }
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
        r0 = m12450b(r0);	 Catch:{ all -> 0x0035 }
        f8650c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8650c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger");
    }

    private static PlaceCreationAnalyticsLogger m12450b(InjectorLike injectorLike) {
        return new PlaceCreationAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), CrowdsourcingSession.a(injectorLike));
    }

    @Inject
    public PlaceCreationAnalyticsLogger(AnalyticsLogger analyticsLogger, CrowdsourcingSession crowdsourcingSession) {
        this.f8651a = analyticsLogger;
        this.f8652b = crowdsourcingSession;
    }

    public final void m12451a(CrowdEntryPoint crowdEntryPoint) {
        this.f8651a.a(m12447a(crowdEntryPoint, "entry_point_impression"));
    }

    public final void m12457a(CrowdsourcingContext crowdsourcingContext, View view) {
        this.f8651a.a(m12448a(crowdsourcingContext, "endpoint_impression").b("starting_view_name", view.logValue));
    }

    public final void m12455a(CrowdsourcingContext crowdsourcingContext, FieldType fieldType, long j, String str) {
        this.f8651a.a(m12448a(crowdsourcingContext, "search_result_tapped").b("field_type_name", fieldType.name).a("event_obj_id", j).b("query", str));
    }

    public final void m12453a(CrowdsourcingContext crowdsourcingContext, long j) {
        this.f8651a.a(m12448a(crowdsourcingContext, "hierarchy_result_tapped").a("event_obj_id", j));
    }

    public final void m12456a(CrowdsourcingContext crowdsourcingContext, FieldType fieldType, String str) {
        this.f8651a.a(m12448a(crowdsourcingContext, "no_results_found").b("field_type_name", fieldType.name).b("query", str));
    }

    public final void m12460b(CrowdsourcingContext crowdsourcingContext, long j) {
        this.f8651a.a(m12448a(crowdsourcingContext, "typeahead_parent_category_viewed").a("event_obj_id", j));
    }

    public final void m12461b(CrowdsourcingContext crowdsourcingContext, View view) {
        this.f8651a.a(m12448a(crowdsourcingContext, "view_changed").b("view_name", view.logValue));
    }

    public final void m12463c(CrowdsourcingContext crowdsourcingContext, long j) {
        this.f8651a.a(m12448a(crowdsourcingContext, "created_place").a("event_obj_id", j));
    }

    public final void m12458a(CrowdsourcingContext crowdsourcingContext, View view, long j) {
        this.f8651a.a(m12448a(crowdsourcingContext, "existing_place_selected").a("event_obj_id", j).b("view_name", view.logValue));
    }

    public final void m12452a(CrowdsourcingContext crowdsourcingContext) {
        this.f8651a.a(m12448a(crowdsourcingContext, "current_location_toggled"));
    }

    public final void m12459b(CrowdsourcingContext crowdsourcingContext) {
        this.f8651a.a(m12448a(crowdsourcingContext, "done_button_tapped"));
    }

    public final void m12454a(CrowdsourcingContext crowdsourcingContext, FieldType fieldType) {
        this.f8651a.a(m12448a(crowdsourcingContext, "field_edited").b("field_type_name", fieldType.name));
    }

    public final void m12462c(CrowdsourcingContext crowdsourcingContext) {
        this.f8651a.a(m12448a(crowdsourcingContext, "camera_button_tapped"));
    }

    public final void m12464d(CrowdsourcingContext crowdsourcingContext) {
        this.f8651a.a(m12448a(crowdsourcingContext, "photo_warning_dialog_cancel_tapped"));
    }

    private HoneyClientEvent m12448a(CrowdsourcingContext crowdsourcingContext, String str) {
        return m12447a(crowdsourcingContext.f8648a, str).b("endpoint", crowdsourcingContext.f8649b.getFullName());
    }

    private HoneyClientEvent m12447a(CrowdEntryPoint crowdEntryPoint, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("place_creation_session");
        honeyClientEvent.c = "crowdsourcing_create";
        return honeyClientEvent.b("event", str).b("entry_point", crowdEntryPoint.getFullName()).a("session_id", this.f8652b.a());
    }
}
