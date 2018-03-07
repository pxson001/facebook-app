package com.facebook.photos.base.analytics.bugreporter;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.Event;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: insightsPlatformRef */
public class PhotosBugReportExtraDataCollector {
    private static volatile PhotosBugReportExtraDataCollector f12664c;
    Clock f12665a;
    @GuardedBy("this")
    LinkedList<UploadAttempt> f12666b;

    /* compiled from: insightsPlatformRef */
    class EventData {
        long f12657a;
        Event f12658b;
        Map<String, String> f12659c;
        final /* synthetic */ PhotosBugReportExtraDataCollector f12660d;

        EventData(PhotosBugReportExtraDataCollector photosBugReportExtraDataCollector, Event event, Map<String, String> map) {
            this.f12660d = photosBugReportExtraDataCollector;
            this.f12657a = photosBugReportExtraDataCollector.f12665a.a();
            this.f12658b = event;
            this.f12659c = map;
        }
    }

    /* compiled from: insightsPlatformRef */
    class UploadAttempt {
        String f12661a;
        LinkedList<EventData> f12662b = Lists.b();
        final /* synthetic */ PhotosBugReportExtraDataCollector f12663c;

        UploadAttempt(PhotosBugReportExtraDataCollector photosBugReportExtraDataCollector, String str) {
            this.f12663c = photosBugReportExtraDataCollector;
            this.f12661a = str;
        }
    }

    public static com.facebook.photos.base.analytics.bugreporter.PhotosBugReportExtraDataCollector m20068a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12664c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.base.analytics.bugreporter.PhotosBugReportExtraDataCollector.class;
        monitor-enter(r1);
        r0 = f12664c;	 Catch:{ all -> 0x003a }
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
        r0 = m20069b(r0);	 Catch:{ all -> 0x0035 }
        f12664c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12664c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.base.analytics.bugreporter.PhotosBugReportExtraDataCollector.a(com.facebook.inject.InjectorLike):com.facebook.photos.base.analytics.bugreporter.PhotosBugReportExtraDataCollector");
    }

    private static PhotosBugReportExtraDataCollector m20069b(InjectorLike injectorLike) {
        return new PhotosBugReportExtraDataCollector((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PhotosBugReportExtraDataCollector(Clock clock) {
        this.f12665a = clock;
    }

    public final synchronized ImmutableMap<String, String> m20070a() {
        Builder builder;
        builder = ImmutableMap.builder();
        if (this.f12666b != null) {
            Iterator it = this.f12666b.iterator();
            int i = 0;
            while (it.hasNext()) {
                UploadAttempt uploadAttempt = (UploadAttempt) it.next();
                int i2 = i + 1;
                Iterator it2 = uploadAttempt.f12662b.iterator();
                int i3 = 0;
                while (it2.hasNext()) {
                    EventData eventData = (EventData) it2.next();
                    int i4 = i3 + 1;
                    ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                    objectNode.a("time", Long.toString(eventData.f12657a));
                    objectNode.a("qn", uploadAttempt.f12661a);
                    objectNode.a("event", eventData.f12658b.toString());
                    for (Entry entry : eventData.f12659c.entrySet()) {
                        objectNode.a((String) entry.getKey(), (String) entry.getValue());
                    }
                    builder.b("Upload_" + i2 + "_Event_" + i4, objectNode.toString());
                    i3 = i4;
                }
                i = i2;
            }
        }
        return builder.b();
    }

    public final synchronized void m20071a(Event event, String str, Map<String, String> map) {
        UploadAttempt uploadAttempt;
        if (this.f12666b == null) {
            this.f12666b = Lists.b();
        }
        if (this.f12666b.size() <= 0 || !((UploadAttempt) this.f12666b.getLast()).f12661a.equals(str)) {
            uploadAttempt = new UploadAttempt(this, str);
            this.f12666b.addLast(uploadAttempt);
            if (this.f12666b.size() > 5) {
                this.f12666b.removeFirst();
            }
        } else {
            uploadAttempt = (UploadAttempt) this.f12666b.getLast();
        }
        uploadAttempt.f12662b.addLast(new EventData(this, event, map));
        if (uploadAttempt.f12662b.size() > 5) {
            uploadAttempt.f12662b.removeFirst();
        }
    }
}
