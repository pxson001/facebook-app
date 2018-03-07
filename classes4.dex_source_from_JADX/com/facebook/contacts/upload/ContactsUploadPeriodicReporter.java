package com.facebook.contacts.upload;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: group_chat_rank */
public class ContactsUploadPeriodicReporter implements IAnalyticsPeriodicEventReporter {
    private static volatile ContactsUploadPeriodicReporter f10954b;
    private final ContactUploadStatusHelper f10955a;

    public static com.facebook.contacts.upload.ContactsUploadPeriodicReporter m11410a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10954b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.upload.ContactsUploadPeriodicReporter.class;
        monitor-enter(r1);
        r0 = f10954b;	 Catch:{ all -> 0x003a }
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
        r0 = m11411b(r0);	 Catch:{ all -> 0x0035 }
        f10954b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10954b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.upload.ContactsUploadPeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.contacts.upload.ContactsUploadPeriodicReporter");
    }

    private static ContactsUploadPeriodicReporter m11411b(InjectorLike injectorLike) {
        return new ContactsUploadPeriodicReporter(ContactUploadStatusHelper.m11414b(injectorLike));
    }

    @Inject
    public ContactsUploadPeriodicReporter(ContactUploadStatusHelper contactUploadStatusHelper) {
        this.f10955a = contactUploadStatusHelper;
    }

    @Nullable
    public final HoneyAnalyticsEvent mo804a(long j, String str) {
        if (str == null) {
            return null;
        }
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("contacts_upload_state");
        honeyClientEvent.c = "contacts_upload";
        honeyClientEvent.a("continuous_upload_state", this.f10955a.m11419b().getDbValue());
        return honeyClientEvent;
    }
}
