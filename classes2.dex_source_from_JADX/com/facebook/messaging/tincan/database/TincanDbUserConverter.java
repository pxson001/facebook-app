package com.facebook.messaging.tincan.database;

import android.database.Cursor;
import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserKey;
import com.facebook.user.module.UserSerialization;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mState= */
public class TincanDbUserConverter {
    private static volatile TincanDbUserConverter f15414c;
    private final UserSerialization f15415a;
    private final ObjectMapperWithUncheckedException f15416b;

    public static com.facebook.messaging.tincan.database.TincanDbUserConverter m21957a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15414c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.database.TincanDbUserConverter.class;
        monitor-enter(r1);
        r0 = f15414c;	 Catch:{ all -> 0x003a }
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
        r0 = m21958b(r0);	 Catch:{ all -> 0x0035 }
        f15414c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15414c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbUserConverter.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.database.TincanDbUserConverter");
    }

    private static TincanDbUserConverter m21958b(InjectorLike injectorLike) {
        return new TincanDbUserConverter(UserSerialization.m21850b(injectorLike), ObjectMapperWithUncheckedException.m21860a(injectorLike));
    }

    @Inject
    TincanDbUserConverter(UserSerialization userSerialization, ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f15415a = userSerialization;
        this.f15416b = objectMapperWithUncheckedException;
    }

    public static ThreadParticipant m21956a(Cursor cursor) {
        String b = TincanDbSchemaPart$ThreadsTable$Columns.f15364b.m2093b(cursor);
        String b2 = TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15381d.m2093b(cursor);
        long c = TincanDbSchemaPart$ThreadsTable$Columns.f15376n.m2094c(cursor);
        long c2 = TincanDbSchemaPart$ThreadsTable$Columns.f15375m.m2094c(cursor);
        ParticipantInfo participantInfo = new ParticipantInfo(UserKey.m5862b(b), b2);
        ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
        threadParticipantBuilder.a = participantInfo;
        threadParticipantBuilder = threadParticipantBuilder;
        threadParticipantBuilder.d = c;
        threadParticipantBuilder = threadParticipantBuilder;
        threadParticipantBuilder.b = c2;
        return threadParticipantBuilder.f();
    }

    public final User m21959b(Cursor cursor) {
        String b = TincanDbSchemaPart$ThreadsTable$Columns.f15364b.m2093b(cursor);
        String b2 = TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15379b.m2093b(cursor);
        String b3 = TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15380c.m2093b(cursor);
        String b4 = TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15381d.m2093b(cursor);
        String b5 = TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15382e.m2093b(cursor);
        Name name = new Name(b2, b3, b4);
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.f3518A = true;
        userBuilder.m5767a(Type.FACEBOOK, b);
        userBuilder.f3552i = b2;
        userBuilder.f3553j = b3;
        userBuilder.f3551h = b4;
        userBuilder.f3550g = name;
        if (b5 != null) {
            userBuilder.f3559p = UserSerialization.m21847a(this.f15416b.m21862a(b5));
        }
        return userBuilder.aa();
    }
}
