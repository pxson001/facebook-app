package com.facebook.orca.threadview;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.threadview.rows.RowItemGrouping;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: message_requests_count_query_result */
public class RowItemUiUtil {
    private static volatile RowItemUiUtil f7370d;
    private final MessageUtil f7371a;
    private final Resources f7372b;
    private final Clock f7373c;

    /* compiled from: message_requests_count_query_result */
    public class BubbleCornerRadius {
        public int f7366a;
        public int f7367b;
        public int f7368c;
        public int f7369d;

        public final int m7011a() {
            return this.f7366a;
        }

        public final int m7012b() {
            return this.f7367b;
        }

        public final int m7013c() {
            return this.f7368c;
        }

        public final int m7014d() {
            return this.f7369d;
        }
    }

    public static com.facebook.orca.threadview.RowItemUiUtil m7015a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7370d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.threadview.RowItemUiUtil.class;
        monitor-enter(r1);
        r0 = f7370d;	 Catch:{ all -> 0x003a }
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
        r0 = m7017b(r0);	 Catch:{ all -> 0x0035 }
        f7370d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7370d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadview.RowItemUiUtil.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadview.RowItemUiUtil");
    }

    private static RowItemUiUtil m7017b(InjectorLike injectorLike) {
        return new RowItemUiUtil(MessageUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (Clock) DbClock.a(injectorLike));
    }

    @Inject
    public RowItemUiUtil(MessageUtil messageUtil, Resources resources, Clock clock) {
        this.f7371a = messageUtil;
        this.f7372b = resources;
        this.f7373c = clock;
    }

    public final RowItemGrouping m7018a(Message message, boolean z, @Nullable Message message2, @Nullable Message message3) {
        return RowItemGrouping.forGrouping(m7016a(message, message3), m7016a(message, message2), m7022a(message, z, message2));
    }

    final RowItemGrouping m7019a(Message message, boolean z, @Nullable Message message2, ParticipantInfo participantInfo) {
        return RowItemGrouping.forGrouping(m7021a(message, participantInfo), m7016a(message, message2), m7022a(message, z, message2));
    }

    final boolean m7021a(Message message, ParticipantInfo participantInfo) {
        return !MessageUtil.B(message) && Objects.equal(message.e.b, participantInfo.b) && Math.abs(this.f7373c.a() - MessageUtil.d(message)) < 60000;
    }

    private boolean m7016a(@Nullable Message message, @Nullable Message message2) {
        return (message == null || message2 == null || MessageUtil.B(message) || MessageUtil.B(message2) || MessageUtil.Q(message) || MessageUtil.Q(message2) || !Objects.equal(message.e.b, message2.e.b) || MessageUtil.b(message, message2) >= 60000) ? false : true;
    }

    public final boolean m7022a(Message message, boolean z, @Nullable Message message2) {
        if (z || message2 == null || MessageUtil.b(message, message2) >= 600000) {
            return true;
        }
        return false;
    }

    final long m7023b(Message message) {
        long a = this.f7373c.a();
        return (message != null && Math.abs(a - MessageUtil.d(message)) < 600000) ? -1 : a;
    }

    public final void m7020a(boolean z, RowItemGrouping rowItemGrouping, BubbleCornerRadius bubbleCornerRadius) {
        int i;
        int i2;
        int dimensionPixelOffset = this.f7372b.getDimensionPixelOffset(2131428580);
        int dimensionPixelOffset2 = this.f7372b.getDimensionPixelOffset(2131428581);
        switch (rowItemGrouping) {
            case ONLY_WITH_NEWER_ROW:
            case ONLY_WITH_NEWER_ROW_WITH_DIVIDER:
                if (z) {
                    i = dimensionPixelOffset;
                } else {
                    i = dimensionPixelOffset2;
                }
                if (!z) {
                    dimensionPixelOffset2 = dimensionPixelOffset;
                }
                i2 = dimensionPixelOffset;
                int i3 = dimensionPixelOffset;
                dimensionPixelOffset = i;
                i = i3;
                break;
            case ONLY_WITH_OLDER_ROW:
                if (z) {
                    i = dimensionPixelOffset;
                } else {
                    i = dimensionPixelOffset2;
                }
                if (!z) {
                    dimensionPixelOffset2 = dimensionPixelOffset;
                }
                i2 = i;
                i = dimensionPixelOffset2;
                dimensionPixelOffset2 = dimensionPixelOffset;
                break;
            case WITH_OLDER_AND_NEW_ROWS:
                if (z) {
                    i = dimensionPixelOffset;
                } else {
                    i = dimensionPixelOffset2;
                }
                if (!z) {
                    dimensionPixelOffset2 = dimensionPixelOffset;
                }
                dimensionPixelOffset = i;
                i2 = i;
                i = dimensionPixelOffset2;
                break;
            default:
                dimensionPixelOffset2 = dimensionPixelOffset;
                i = dimensionPixelOffset;
                i2 = dimensionPixelOffset;
                break;
        }
        bubbleCornerRadius.f7366a = i2;
        bubbleCornerRadius.f7367b = i;
        bubbleCornerRadius.f7368c = dimensionPixelOffset2;
        bubbleCornerRadius.f7369d = dimensionPixelOffset;
    }
}
