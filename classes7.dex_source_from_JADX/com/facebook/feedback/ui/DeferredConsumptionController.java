package com.facebook.feedback.ui;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecurePendingIntent;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.flyout.FeedbackParams;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: screenPhysicalPixels */
public class DeferredConsumptionController implements OnFeedbackLoadListener {
    private static final Set<ErrorCode> f4405a = EnumSet.of(ErrorCode.CONNECTION_FAILURE);
    public static final CallerContext f4406b = CallerContext.a(DeferredConsumptionController.class);
    private static volatile DeferredConsumptionController f4407m;
    public final Map<String, FeedbackParams> f4408c = new HashMap();
    public final Map<String, Integer> f4409d = new HashMap();
    public final DefaultFeedIntentBuilder f4410e;
    public final Context f4411f;
    private final NotificationManager f4412g;
    public final BaseFbBroadcastManager f4413h;
    public final FbNetworkManager f4414i;
    public final SingletonFeedbackController f4415j;
    public int f4416k = 0;
    public SelfRegistrableReceiverImpl f4417l;

    /* compiled from: screenPhysicalPixels */
    public class C04061 implements ActionReceiver {
        final /* synthetic */ DeferredConsumptionController f4404a;

        public C04061(DeferredConsumptionController deferredConsumptionController) {
            this.f4404a = deferredConsumptionController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1798356096);
            if (this.f4404a.f4414i.d()) {
                DeferredConsumptionController deferredConsumptionController = this.f4404a;
                for (String str : deferredConsumptionController.f4409d.keySet()) {
                    deferredConsumptionController.f4415j.m5303a((FeedbackParams) deferredConsumptionController.f4408c.get(str), DeferredConsumptionController.f4406b, deferredConsumptionController);
                }
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -138301532, a);
        }
    }

    public static com.facebook.feedback.ui.DeferredConsumptionController m5014a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4407m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.ui.DeferredConsumptionController.class;
        monitor-enter(r1);
        r0 = f4407m;	 Catch:{ all -> 0x003a }
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
        r0 = m5016b(r0);	 Catch:{ all -> 0x0035 }
        f4407m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4407m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.ui.DeferredConsumptionController.a(com.facebook.inject.InjectorLike):com.facebook.feedback.ui.DeferredConsumptionController");
    }

    private static DeferredConsumptionController m5016b(InjectorLike injectorLike) {
        return new DeferredConsumptionController(DefaultFeedIntentBuilder.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), FbNetworkManager.a(injectorLike), SingletonFeedbackController.m5296a(injectorLike));
    }

    @Inject
    public DeferredConsumptionController(DefaultFeedIntentBuilder defaultFeedIntentBuilder, Context context, BaseFbBroadcastManager baseFbBroadcastManager, FbNetworkManager fbNetworkManager, SingletonFeedbackController singletonFeedbackController) {
        this.f4410e = defaultFeedIntentBuilder;
        this.f4411f = context;
        this.f4412g = (NotificationManager) this.f4411f.getSystemService("notification");
        this.f4413h = baseFbBroadcastManager;
        this.f4414i = fbNetworkManager;
        this.f4415j = singletonFeedbackController;
    }

    public final void mo197a(ServiceException serviceException, FeedbackParams feedbackParams) {
        String b = m5017b(feedbackParams);
        if (this.f4408c.containsKey(b) && f4405a.contains(serviceException.errorCode)) {
            int intValue = (this.f4409d.containsKey(b) ? ((Integer) this.f4409d.get(b)).intValue() : 0) + 1;
            if (intValue < 3) {
                this.f4409d.put(b, Integer.valueOf(intValue));
            } else {
                this.f4409d.remove(b);
            }
        }
    }

    private void m5015a(GraphQLStory graphQLStory) {
        if (StoryActorHelper.b(graphQLStory) != null) {
            Builder b = new Builder(this.f4411f).a(2130843529).a(this.f4411f.getString(2131233355)).b(this.f4411f.getString(2131233356, new Object[]{r0.aa()}));
            Context context = this.f4411f;
            int i = this.f4416k;
            this.f4416k = i + 1;
            b.d = SecurePendingIntent.a(context, i, this.f4410e.a(graphQLStory), 134217728);
            b = b.c(true);
            NotificationManager notificationManager = this.f4412g;
            int i2 = this.f4416k;
            this.f4416k = i2 + 1;
            notificationManager.notify(i2, b.c());
        }
    }

    public static String m5017b(FeedbackParams feedbackParams) {
        if (feedbackParams.g() != null) {
            return feedbackParams.g();
        }
        return feedbackParams.d();
    }

    public final void mo199b(GraphQLFeedback graphQLFeedback) {
        String z_;
        if (graphQLFeedback.z_() != null) {
            z_ = graphQLFeedback.z_();
        } else {
            z_ = graphQLFeedback.j();
        }
        String str = z_;
        FeedbackParams feedbackParams = (FeedbackParams) this.f4408c.get(str);
        if (feedbackParams != null && feedbackParams.c != null) {
            this.f4409d.remove(str);
            this.f4408c.remove(str);
            m5015a((GraphQLStory) feedbackParams.c.a);
        }
    }

    public final void mo200c(GraphQLFeedback graphQLFeedback) {
    }
}
