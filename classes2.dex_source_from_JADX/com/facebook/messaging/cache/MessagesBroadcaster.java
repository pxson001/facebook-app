package com.facebook.messaging.cache;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.base.userscope.UserScopedCrossProcessBroadcastManager;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mThemeCookies */
public class MessagesBroadcaster {
    private static volatile MessagesBroadcaster f15350d;
    private final Context f15351a;
    private final Provider<UserScopedCrossProcessBroadcastManager> f15352b;
    private final Provider<ThreadUnreadCountUtil> f15353c;

    public static com.facebook.messaging.cache.MessagesBroadcaster m21869a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15350d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.cache.MessagesBroadcaster.class;
        monitor-enter(r1);
        r0 = f15350d;	 Catch:{ all -> 0x003a }
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
        r0 = m21876b(r0);	 Catch:{ all -> 0x0035 }
        f15350d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15350d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.MessagesBroadcaster.a(com.facebook.inject.InjectorLike):com.facebook.messaging.cache.MessagesBroadcaster");
    }

    private static MessagesBroadcaster m21876b(InjectorLike injectorLike) {
        return new MessagesBroadcaster((Context) injectorLike.getInstance(Context.class), IdBasedProvider.m1811a(injectorLike, 4971), IdBasedProvider.m1811a(injectorLike, 7709));
    }

    @Inject
    public MessagesBroadcaster(Context context, Provider<UserScopedCrossProcessBroadcastManager> provider, Provider<ThreadUnreadCountUtil> provider2) {
        this.f15351a = context;
        this.f15352b = provider;
        this.f15353c = provider2;
    }

    public final void m21880a() {
        Intent intent = new Intent();
        intent.setAction(MessagesBroadcastIntents.f2346a);
        m21870a(intent);
    }

    public final void m21885a(ThreadKey threadKey) {
        m21891a(ImmutableList.of(threadKey));
    }

    public final void m21891a(ImmutableList<ThreadKey> immutableList) {
        m21873a(MessagesBroadcastIntents.f2347b, new ArrayList(immutableList));
    }

    public final void m21887a(ThreadKey threadKey, Bundle bundle) {
        m21872a(ImmutableList.of(threadKey), bundle);
    }

    private void m21872a(ImmutableList<ThreadKey> immutableList, Bundle bundle) {
        m21875a(MessagesBroadcastIntents.f2347b, new ArrayList(immutableList), -1, bundle);
    }

    public final void m21886a(ThreadKey threadKey, long j) {
        m21871a(ImmutableList.of(threadKey), j);
    }

    private void m21871a(ImmutableList<ThreadKey> immutableList, long j) {
        m21874a(MessagesBroadcastIntents.f2347b, new ArrayList(immutableList), j);
    }

    public final void m21888a(ThreadKey threadKey, ThreadKey threadKey2) {
        Intent intent = new Intent();
        intent.setAction(MessagesBroadcastIntents.f2350e);
        intent.putExtra("pending_thread_key", threadKey);
        intent.putExtra("server_thread_key", threadKey2);
        m21870a(intent);
    }

    public final void m21896b(ThreadKey threadKey, ThreadKey threadKey2) {
        Intent intent = new Intent();
        intent.setAction(MessagesBroadcastIntents.f2352g);
        intent.putExtra("outdated_thread_key", threadKey);
        intent.putExtra("updated_thread_key", threadKey2);
        m21870a(intent);
    }

    public final void m21895b(ThreadKey threadKey) {
        Intent intent = new Intent();
        intent.setAction(MessagesBroadcastIntents.f2351f);
        intent.putExtra("pending_thread_key", threadKey);
        m21870a(intent);
    }

    public final void m21890a(ThreadKey threadKey, Collection<String> collection, Collection<String> collection2) {
        Intent intent = new Intent();
        intent.setAction(MessagesBroadcastIntents.f2353h);
        intent.putExtra("thread_key", threadKey);
        intent.putStringArrayListExtra("message_ids", Lists.m1298a((Iterable) collection));
        intent.putStringArrayListExtra("offline_threading_ids", Lists.m1298a((Iterable) collection2));
        m21870a(intent);
    }

    public final void m21889a(ThreadKey threadKey, String str) {
        Intent intent = new Intent();
        intent.setAction(MessagesBroadcastIntents.f2356k);
        intent.putExtra("thread_key", threadKey);
        intent.putExtra("offline_threading_id", str);
        m21870a(intent);
    }

    public final void m21892a(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction(MessagesBroadcastIntents.f2355j);
        intent.putExtra("message_id", str);
        intent.putExtra("offline_threading_id", str2);
        m21870a(intent);
    }

    public final void m21884a(Message message) {
        Intent intent = new Intent();
        intent.setAction(MessagesBroadcastIntents.f2357l);
        intent.putExtra("thread_key", message.b);
        intent.putExtra("offline_threading_id", message.n);
        intent.putExtra("is_sent_payment_message", m21877c(message));
        m21870a(intent);
    }

    public final void m21894b(Message message) {
        Intent intent = new Intent();
        intent.setAction(MessagesBroadcastIntents.f2358m);
        intent.putExtra("thread_key", message.b);
        if (message.w.c != null) {
            intent.putExtra("error_message", message.w.c);
        }
        intent.putExtra("error_number", message.w.d);
        if (message != null) {
            intent.putExtra("message_id", message.a);
            intent.putExtra("offline_threading_id", message.n);
            intent.putExtra("is_sent_payment_message", m21877c(message));
        }
        m21870a(intent);
    }

    public final void m21899c(ThreadKey threadKey) {
        m21897b(ImmutableList.of(threadKey));
    }

    public final void m21897b(ImmutableList<ThreadKey> immutableList) {
        m21873a(MessagesBroadcastIntents.f2348c, new ArrayList(immutableList));
    }

    public final void m21900c(ImmutableList<ThreadKey> immutableList) {
        m21873a(MessagesBroadcastIntents.f2349d, new ArrayList(immutableList));
    }

    private void m21873a(String str, ArrayList<ThreadKey> arrayList) {
        m21874a(str, (ArrayList) arrayList, -1);
    }

    private void m21874a(String str, ArrayList<ThreadKey> arrayList, long j) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putParcelableArrayListExtra("multiple_thread_keys", arrayList);
        if (j != -1) {
            intent.putExtra("action_id", j);
        }
        Long.valueOf(j);
        m21870a(intent);
    }

    private void m21875a(String str, ArrayList<ThreadKey> arrayList, long j, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putParcelableArrayListExtra("multiple_thread_keys", arrayList);
        if (j != -1) {
            intent.putExtra("action_id", j);
        }
        if (bundle != null) {
            intent.putExtra("broadcast_extras", bundle);
        }
        Long.valueOf(j);
        m21870a(intent);
    }

    public final void m21881a(int i) {
        Intent intent = new Intent(MessagesBroadcastIntents.f2359n);
        intent.putExtra("EXTRA_BADGE_COUNT", i);
        m21870a(intent);
    }

    public final void m21893b() {
        m21870a(new Intent(MessagesBroadcastIntents.f2360o));
    }

    public final void m21898c() {
        m21882a(0);
    }

    public final void m21882a(long j) {
        Intent intent = new Intent(MessagesBroadcastIntents.f2361p);
        intent.putExtra("UPDATE_TIME_MS", j);
        m21870a(intent);
    }

    public final void m21901d() {
        m21870a(new Intent(MessagesBroadcastIntents.f2362q));
    }

    public final void m21883a(Parcelable parcelable) {
        Intent intent = new Intent(MessagesBroadcastIntents.f2341B);
        intent.putExtra("message_push_data", parcelable);
        m21870a(intent);
    }

    public final void m21902e(ThreadKey threadKey) {
        Intent intent = new Intent(MessagesBroadcastIntents.f2344E);
        intent.putExtra("thread_key", threadKey);
        m21870a(intent);
    }

    private void m21870a(Intent intent) {
        FbLocalBroadcastManager.m2961a(this.f15351a).m2969a(intent);
        ((UserScopedCrossProcessBroadcastManager) this.f15352b.get()).a(intent, this.f15351a);
    }

    public static Bundle m21868a(ThreadUpdateCause threadUpdateCause, @Nullable String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("broadcast_cause", threadUpdateCause);
        if (str != null) {
            bundle.putString("sound_trigger_identifier", threadUpdateCause.toString() + str);
        }
        return bundle;
    }

    public static Bundle m21867a(ThreadUpdateCause threadUpdateCause, ThreadKey threadKey, long j, FbTraceNode fbTraceNode, long j2) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("broadcast_cause", threadUpdateCause);
        if (j >= 0) {
            bundle.putString("sound_trigger_identifier", threadUpdateCause.toString() + threadKey.toString() + ":" + j);
        }
        bundle.putParcelable("fbtrace_node", fbTraceNode);
        bundle.putLong("sequence_id", j2);
        return bundle;
    }

    public final Bundle m21878a(ThreadSummary threadSummary, long j) {
        Bundle bundle = new Bundle();
        if (!((ThreadUnreadCountUtil) this.f15353c.get()).b(threadSummary)) {
            return bundle;
        }
        return m21867a(ThreadUpdateCause.READ_RECEIPT, threadSummary.a, j, FbTraceNode.f7566a, threadSummary.d);
    }

    public final Bundle m21879a(ThreadSummary threadSummary, long j, FbTraceNode fbTraceNode) {
        return m21867a(ThreadUpdateCause.DELIVERY_RECEIPT, threadSummary.a, j, fbTraceNode, threadSummary.d);
    }

    private static boolean m21877c(Message message) {
        return (message.u == null || message.u.c == null) ? false : true;
    }
}
