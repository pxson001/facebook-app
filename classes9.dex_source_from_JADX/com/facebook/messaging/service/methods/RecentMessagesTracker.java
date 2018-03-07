package com.facebook.messaging.service.methods;

import android.net.Uri;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.RecentMessageSource;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Queues;
import com.google.common.io.Closeables;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: current_bandwidth */
public class RecentMessagesTracker implements IHaveUserData, BugReportExtraFileMapProvider, BugReportFileProvider {
    private static final Class<?> f16959a;
    private static final String f16960b;
    private static volatile RecentMessagesTracker f16961i;
    private final Clock f16962c;
    private final AbstractFbErrorReporter f16963d;
    private final Provider<DataCache> f16964e;
    private final Provider<DbFetchThreadHandler> f16965f;
    private final XConfigReader f16966g;
    private final ConcurrentLinkedQueue<ThreadRecord> f16967h = Queues.b();

    /* compiled from: current_bandwidth */
    class MessageRecord {
        public final long f16955a;
        public final Message f16956b;

        public MessageRecord(long j, Message message) {
            this.f16955a = j;
            this.f16956b = message;
        }
    }

    /* compiled from: current_bandwidth */
    class ThreadRecord {
        public final ThreadKey f16957a;
        public final ConcurrentSkipListMap<RecentMessageSource, MessageRecord> f16958b = new ConcurrentSkipListMap();

        public ThreadRecord(ThreadKey threadKey) {
            this.f16957a = threadKey;
        }

        public final void m17008a(long j, RecentMessageSource recentMessageSource, Message message) {
            MessageRecord messageRecord = (MessageRecord) this.f16958b.get(recentMessageSource);
            if (messageRecord == null || (messageRecord.f16956b != message && messageRecord.f16956b.c < message.c)) {
                this.f16958b.put(recentMessageSource, new MessageRecord(j, message));
            }
        }
    }

    public static com.facebook.messaging.service.methods.RecentMessagesTracker m17010a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16961i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.service.methods.RecentMessagesTracker.class;
        monitor-enter(r1);
        r0 = f16961i;	 Catch:{ all -> 0x003a }
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
        r0 = m17014b(r0);	 Catch:{ all -> 0x0035 }
        f16961i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16961i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.service.methods.RecentMessagesTracker.a(com.facebook.inject.InjectorLike):com.facebook.messaging.service.methods.RecentMessagesTracker");
    }

    private static RecentMessagesTracker m17014b(InjectorLike injectorLike) {
        return new RecentMessagesTracker((Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 2567), IdBasedSingletonScopeProvider.a(injectorLike, 2597), XConfigReader.a(injectorLike));
    }

    static {
        Class cls = RecentMessagesTracker.class;
        f16959a = cls;
        f16960b = cls.getSimpleName();
    }

    @Inject
    public RecentMessagesTracker(Clock clock, FbErrorReporter fbErrorReporter, Provider<DataCache> provider, Provider<DbFetchThreadHandler> provider2, XConfigReader xConfigReader) {
        this.f16962c = clock;
        this.f16963d = fbErrorReporter;
        this.f16964e = provider;
        this.f16965f = provider2;
        this.f16966g = xConfigReader;
    }

    public final void m17015a(RecentMessageSource recentMessageSource, @Nullable Message message) {
        if (message != null) {
            ThreadKey threadKey = message.b;
            if (threadKey == null) {
                BLog.b(f16959a, "Tried to track message without threadkey");
                return;
            }
            ThreadRecord threadRecord;
            long a = this.f16962c.a();
            Iterator it = this.f16967h.iterator();
            while (it.hasNext()) {
                threadRecord = (ThreadRecord) it.next();
                if (Objects.equal(threadRecord.f16957a, threadKey)) {
                    threadRecord.m17008a(a, recentMessageSource, message);
                    it.remove();
                    this.f16967h.add(threadRecord);
                    return;
                }
            }
            threadRecord = new ThreadRecord(threadKey);
            threadRecord.m17008a(a, recentMessageSource, message);
            this.f16967h.add(threadRecord);
            if (this.f16967h.size() > 5) {
                this.f16967h.remove();
            }
        }
    }

    public void clearUserData() {
        this.f16967h.clear();
    }

    public boolean shouldSendAsync() {
        return this.f16966g.a(BugReportingXConfig.z, false);
    }

    public Map<String, String> getExtraFileFromWorkerThread(File file) {
        try {
            return ImmutableBiMap.b("recent_messages_json.txt", m17009a(file).toString());
        } catch (Throwable e) {
            this.f16963d.a(f16960b, e);
            return null;
        }
    }

    public void prepareDataForWriting() {
    }

    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        List<BugReportFile> arrayList = new ArrayList();
        try {
            arrayList.add(new BugReportFile("recent_messages_json.txt", m17009a(file).toString(), "text/plain"));
            return arrayList;
        } catch (Throwable e) {
            throw new IOException("Failed to write recent messages file", e);
        }
    }

    private Uri m17009a(File file) {
        long a = this.f16962c.a();
        File file2 = new File(file, "recent_messages_json.txt");
        Closeable printWriter = new PrintWriter(new FileOutputStream(file2));
        try {
            printWriter.write(m17011a(a).toString());
            Uri fromFile = Uri.fromFile(file2);
            return fromFile;
        } finally {
            Closeables.a(printWriter, false);
        }
    }

    private JSONObject m17011a(long j) {
        JSONObject jSONObject = new JSONObject();
        Iterator it = this.f16967h.iterator();
        while (it.hasNext()) {
            ThreadRecord threadRecord = (ThreadRecord) it.next();
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : threadRecord.f16958b.entrySet()) {
                MessageRecord messageRecord = (MessageRecord) entry.getValue();
                jSONObject2.put(((RecentMessageSource) entry.getKey()).name(), m17012a(messageRecord.f16955a, messageRecord.f16956b));
            }
            ThreadKey threadKey = threadRecord.f16957a;
            jSONObject2.put("REPORT_TIME_CACHE", m17013a(j, ((DataCache) this.f16964e.get()).b(threadKey)));
            jSONObject2.put("REPORT_TIME_DB", m17013a(j, ((DbFetchThreadHandler) this.f16965f.get()).a(threadKey, 1).f17181d));
            jSONObject.put(threadKey.g(), jSONObject2);
        }
        return jSONObject;
    }

    @Nullable
    private static JSONObject m17012a(long j, @Nullable Message message) {
        int i = -1;
        if (message == null) {
            return null;
        }
        JSONObject put = new JSONObject().put("recordTime", j).put("id", message.a).put("timestampMs", message.c).put("sentTimestampMs", message.d).put("senderInfo", message.e).put("actionId", message.g).put("numAttachments", message.i == null ? -1 : message.i.size());
        String str = "numShares";
        if (message.j != null) {
            i = message.j.size();
        }
        return put.put(str, i).put("offlineThreadingId", message.n).put("isNonAuthoritative", message.o).put("channelSource", message.q);
    }

    @Nullable
    private static JSONObject m17013a(long j, @Nullable MessagesCollection messagesCollection) {
        if (messagesCollection == null) {
            return null;
        }
        return m17012a(j, messagesCollection.c());
    }
}
