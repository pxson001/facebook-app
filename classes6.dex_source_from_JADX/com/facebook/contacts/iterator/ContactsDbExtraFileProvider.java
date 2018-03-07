package com.facebook.contacts.iterator;

import android.net.Uri;
import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.contacts.graphql.Contact;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Lists;
import com.google.common.io.Closeables;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pending_media_item_upload */
public class ContactsDbExtraFileProvider implements BugReportExtraFileMapProvider, BugReportFileProvider {
    public static final PrefKey f8227a = ((PrefKey) SharedPrefKeys.c.a("contacts_db_in_bug_report"));
    private static final String f8228b = ContactsDbExtraFileProvider.class.getSimpleName();
    private static volatile ContactsDbExtraFileProvider f8229g;
    private final FbSharedPreferences f8230c;
    private final ContactIterators f8231d;
    private final AbstractFbErrorReporter f8232e;
    private final XConfigReader f8233f;

    public static com.facebook.contacts.iterator.ContactsDbExtraFileProvider m12065a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8229g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.iterator.ContactsDbExtraFileProvider.class;
        monitor-enter(r1);
        r0 = f8229g;	 Catch:{ all -> 0x003a }
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
        r0 = m12067b(r0);	 Catch:{ all -> 0x0035 }
        f8229g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8229g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.iterator.ContactsDbExtraFileProvider.a(com.facebook.inject.InjectorLike):com.facebook.contacts.iterator.ContactsDbExtraFileProvider");
    }

    private static ContactsDbExtraFileProvider m12067b(InjectorLike injectorLike) {
        return new ContactsDbExtraFileProvider((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ContactIterators.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), XConfigReader.a(injectorLike));
    }

    @Inject
    public ContactsDbExtraFileProvider(FbSharedPreferences fbSharedPreferences, ContactIterators contactIterators, AbstractFbErrorReporter abstractFbErrorReporter, XConfigReader xConfigReader) {
        this.f8230c = fbSharedPreferences;
        this.f8231d = contactIterators;
        this.f8232e = abstractFbErrorReporter;
        this.f8233f = xConfigReader;
    }

    public boolean shouldSendAsync() {
        return this.f8233f.a(BugReportingXConfig.r, false);
    }

    public Map<String, String> getExtraFileFromWorkerThread(File file) {
        Map<String, String> map = null;
        if (this.f8230c.a(f8227a, false)) {
            try {
                map = ImmutableBiMap.b("contacts_db.txt", m12064a(file).toString());
            } catch (Throwable e) {
                this.f8232e.a(f8228b, e);
            }
        }
        return map;
    }

    public void prepareDataForWriting() {
    }

    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        List<BugReportFile> a = Lists.a();
        if (this.f8230c.a(f8227a, false)) {
            a.add(new BugReportFile("contacts_db.txt", m12064a(file).toString(), "text/plain"));
        }
        return a;
    }

    private Uri m12064a(File file) {
        File file2 = new File(file, "contacts_db.txt");
        Closeable fileOutputStream = new FileOutputStream(file2);
        try {
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            m12066a(printWriter);
            printWriter.flush();
            Uri fromFile = Uri.fromFile(file2);
            return fromFile;
        } finally {
            Closeables.a(fileOutputStream, false);
        }
    }

    private void m12066a(PrintWriter printWriter) {
        ContactIterator a = this.f8231d.a(ContactCursorsQuery.a());
        while (a.hasNext()) {
            Contact contact = (Contact) a.next();
            printWriter.write(Objects.toStringHelper(contact).add("name", contact.e()).add("fbid", contact.c()).add("pushable", contact.r()).add("inContactList", contact.v()).add("type", contact.A()).toString());
            printWriter.write("\n");
        }
    }
}
