package com.facebook.timeline.widget.actionbar;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import com.facebook.friending.suggestion.abtest.ExperimentsForFriendingSuggestionAbTestModule;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLInterfaces.TimelineHeaderActionFields;
import com.google.common.base.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: f0fb962f65458dba4167c9dfb610dd5a */
public class TimelineActionBarItemFactory {
    private static volatile TimelineActionBarItemFactory f14980b;
    public final QeAccessor f14981a;

    /* compiled from: f0fb962f65458dba4167c9dfb610dd5a */
    /* synthetic */ class C11111 {
        static final /* synthetic */ int[] f14979a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f14979a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14979a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14979a[GraphQLFriendshipStatus.CANNOT_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14979a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14979a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static com.facebook.timeline.widget.actionbar.TimelineActionBarItemFactory m18811a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14980b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.widget.actionbar.TimelineActionBarItemFactory.class;
        monitor-enter(r1);
        r0 = f14980b;	 Catch:{ all -> 0x003a }
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
        r0 = m18817b(r0);	 Catch:{ all -> 0x0035 }
        f14980b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14980b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.widget.actionbar.TimelineActionBarItemFactory.a(com.facebook.inject.InjectorLike):com.facebook.timeline.widget.actionbar.TimelineActionBarItemFactory");
    }

    private static TimelineActionBarItemFactory m18817b(InjectorLike injectorLike) {
        return new TimelineActionBarItemFactory((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TimelineActionBarItemFactory(QeAccessor qeAccessor) {
        this.f14981a = qeAccessor;
    }

    public final void m18827a(boolean z, TimelineHeaderActionFields timelineHeaderActionFields, boolean z2, boolean z3, PersonActionBarItemConsumer personActionBarItemConsumer) {
        if (z) {
            m18814a(z2, personActionBarItemConsumer);
        } else {
            m18826a(timelineHeaderActionFields, z2, z3, personActionBarItemConsumer);
        }
    }

    public static void m18814a(boolean z, PersonActionBarItemConsumer personActionBarItemConsumer) {
        personActionBarItemConsumer.m18804a(10, 2131234885, 2130840058, 0, true, true);
        personActionBarItemConsumer.m18804a(11, 2131234886, 2130840019, 0, true, true);
        personActionBarItemConsumer.m18804a(12, 2131234883, 2130840056, 0, true, true);
        personActionBarItemConsumer.m18804a(13, 2131234884, 2130839957, 2, true, true);
        personActionBarItemConsumer.m18804a(9, 2131234882, 2130839880, 2, true, !z);
    }

    public final void m18826a(TimelineHeaderActionFields timelineHeaderActionFields, boolean z, boolean z2, PersonActionBarItemConsumer personActionBarItemConsumer) {
        m18813a(timelineHeaderActionFields, z, personActionBarItemConsumer);
        m18812a(timelineHeaderActionFields, personActionBarItemConsumer);
        personActionBarItemConsumer.m18804a(2, 2131234867, AppGlyphResolver.a(), 2, timelineHeaderActionFields.d(), true);
        m18825h(timelineHeaderActionFields, personActionBarItemConsumer);
        m18824g(timelineHeaderActionFields, personActionBarItemConsumer);
        m18820c(timelineHeaderActionFields, personActionBarItemConsumer);
        m18823f(timelineHeaderActionFields, personActionBarItemConsumer);
        m18818b(timelineHeaderActionFields, z2, personActionBarItemConsumer);
        m18821d(timelineHeaderActionFields, personActionBarItemConsumer);
        m18822e(timelineHeaderActionFields, personActionBarItemConsumer);
    }

    private void m18813a(TimelineHeaderActionFields timelineHeaderActionFields, boolean z, PersonActionBarItemConsumer personActionBarItemConsumer) {
        if (timelineHeaderActionFields.j() != null && timelineHeaderActionFields.j() != GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            boolean z2;
            boolean z3;
            int a = m18810a(timelineHeaderActionFields.j());
            int b = m18816b(timelineHeaderActionFields.j());
            if (timelineHeaderActionFields.j() != GraphQLFriendshipStatus.CANNOT_REQUEST) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z4 = z2;
            boolean z5 = !z && (z4 || m18815a());
            if (timelineHeaderActionFields.j() == GraphQLFriendshipStatus.ARE_FRIENDS || timelineHeaderActionFields.j() == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
                z3 = true;
            } else {
                z3 = false;
            }
            personActionBarItemConsumer.m18805a(0, a, b, 2, z4, z5, true, z3);
        }
    }

    @StringRes
    private static int m18810a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        switch (C11111.f14979a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                return 2131234860;
            case 2:
                return 2131233212;
            case 3:
                return 2131233212;
            case 4:
                return 2131233215;
            case 5:
                return 2131234863;
            default:
                throw new IllegalArgumentException("Unexpected friendship status: " + graphQLFriendshipStatus);
        }
    }

    @DrawableRes
    private static int m18816b(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        switch (C11111.f14979a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                return 2130839879;
            case 2:
                return 2130839877;
            case 3:
                return 2130839888;
            case 4:
                return 2130839879;
            case 5:
                return 2130839892;
            default:
                throw new IllegalArgumentException("Unexpected friendship status: " + graphQLFriendshipStatus);
        }
    }

    private void m18812a(TimelineHeaderActionFields timelineHeaderActionFields, PersonActionBarItemConsumer personActionBarItemConsumer) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        int i2 = 2131234865;
        if (GraphQLSubscribeStatus.IS_SUBSCRIBED.equals(timelineHeaderActionFields.n())) {
            int i3;
            if (GraphQLSecondarySubscribeStatus.SEE_FIRST.equals(timelineHeaderActionFields.m())) {
                i2 = 2131234906;
                i3 = 2130843308;
            } else {
                i3 = 2130840402;
            }
            z = true;
            i = i3;
            z2 = true;
            z3 = true;
        } else {
            boolean z4;
            z3 = GraphQLSubscribeStatus.CAN_SUBSCRIBE.equals(timelineHeaderActionFields.n());
            if (z3 || m18815a()) {
                z4 = true;
            } else {
                z4 = false;
            }
            z = false;
            z2 = z4;
            i = 2130839874;
            i2 = 2131234864;
        }
        personActionBarItemConsumer.m18805a(1, i2, i, 2, z3, z2, true, z);
    }

    private boolean m18815a() {
        return this.f14981a.a(ExperimentsForTimelineAbTestModule.Q, false);
    }

    private static void m18820c(TimelineHeaderActionFields timelineHeaderActionFields, PersonActionBarItemConsumer personActionBarItemConsumer) {
        personActionBarItemConsumer.m18804a(3, 2131234869, 2130839901, 2, timelineHeaderActionFields.b(), timelineHeaderActionFields.b());
    }

    private static void m18821d(TimelineHeaderActionFields timelineHeaderActionFields, PersonActionBarItemConsumer personActionBarItemConsumer) {
        personActionBarItemConsumer.m18804a(4, 2131234873, 2130840037, 0, timelineHeaderActionFields.do_(), timelineHeaderActionFields.do_());
    }

    private static void m18822e(TimelineHeaderActionFields timelineHeaderActionFields, PersonActionBarItemConsumer personActionBarItemConsumer) {
        personActionBarItemConsumer.m18804a(5, 2131234875, 2130839882, 0, true, Objects.equal(timelineHeaderActionFields.j(), GraphQLFriendshipStatus.ARE_FRIENDS));
    }

    private void m18823f(TimelineHeaderActionFields timelineHeaderActionFields, PersonActionBarItemConsumer personActionBarItemConsumer) {
        if (timelineHeaderActionFields.j() == GraphQLFriendshipStatus.ARE_FRIENDS) {
            if (m18819b(timelineHeaderActionFields)) {
                personActionBarItemConsumer.m18804a(6, 2131233245, 2130839877, 2, true, true);
                return;
            } else if (this.f14981a.a(ExperimentsForFriendingSuggestionAbTestModule.f5366e, false)) {
                personActionBarItemConsumer.m18804a(6, 2131233244, 2130839877, 0, true, true);
                return;
            }
        }
        personActionBarItemConsumer.m18804a(6, 2131233244, 2130839877, 0, false, false);
    }

    private static void m18824g(TimelineHeaderActionFields timelineHeaderActionFields, PersonActionBarItemConsumer personActionBarItemConsumer) {
        personActionBarItemConsumer.m18804a(7, 2131234877, 2130839878, 0, true, timelineHeaderActionFields.c());
    }

    private static void m18818b(TimelineHeaderActionFields timelineHeaderActionFields, boolean z, PersonActionBarItemConsumer personActionBarItemConsumer) {
        boolean z2 = Objects.equal(timelineHeaderActionFields.j(), GraphQLFriendshipStatus.ARE_FRIENDS) && z;
        personActionBarItemConsumer.m18804a(14, 2131237833, 2130839682, 0, true, z2);
    }

    private static void m18825h(TimelineHeaderActionFields timelineHeaderActionFields, PersonActionBarItemConsumer personActionBarItemConsumer) {
        personActionBarItemConsumer.m18804a(8, 2131234878, 2130840081, 0, true, timelineHeaderActionFields.dp_());
    }

    private boolean m18819b(TimelineHeaderActionFields timelineHeaderActionFields) {
        if (timelineHeaderActionFields.dq_() == null) {
            return false;
        }
        int a = timelineHeaderActionFields.dq_().a();
        if (!this.f14981a.a(ExperimentsForFriendingSuggestionAbTestModule.f5362a, false) || a > this.f14981a.a(ExperimentsForFriendingSuggestionAbTestModule.f5363b, 30) || a <= 0) {
            return false;
        }
        return true;
    }
}
