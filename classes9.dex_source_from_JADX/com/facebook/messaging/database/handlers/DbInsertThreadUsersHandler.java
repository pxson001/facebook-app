package com.facebook.messaging.database.handlers;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.common.calltoaction.serialization.CallToActionSerialization;
import com.facebook.messaging.database.threads.ThreadsDatabaseSupplier;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.module.UserSerialization;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: media server is dead */
public class DbInsertThreadUsersHandler {
    private static final Class<?> f10345a = DbInsertThreadUsersHandler.class;
    private static volatile DbInsertThreadUsersHandler f10346e;
    private final Provider<ThreadsDatabaseSupplier> f10347b;
    private final UserSerialization f10348c;
    private final CallToActionSerialization f10349d;

    public static com.facebook.messaging.database.handlers.DbInsertThreadUsersHandler m10937a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10346e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.database.handlers.DbInsertThreadUsersHandler.class;
        monitor-enter(r1);
        r0 = f10346e;	 Catch:{ all -> 0x003a }
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
        r0 = m10938b(r0);	 Catch:{ all -> 0x0035 }
        f10346e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10346e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbInsertThreadUsersHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.handlers.DbInsertThreadUsersHandler");
    }

    private static DbInsertThreadUsersHandler m10938b(InjectorLike injectorLike) {
        return new DbInsertThreadUsersHandler(IdBasedProvider.a(injectorLike, 7815), UserSerialization.b(injectorLike), CallToActionSerialization.b(injectorLike));
    }

    @Inject
    DbInsertThreadUsersHandler(Provider<ThreadsDatabaseSupplier> provider, UserSerialization userSerialization, CallToActionSerialization callToActionSerialization) {
        this.f10347b = provider;
        this.f10348c = userSerialization;
        this.f10349d = callToActionSerialization;
    }

    public final void m10939a(List<User> list) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10347b.get()).a();
        SQLiteDetour.a(a, 353099427);
        try {
            for (User user : list) {
                int i;
                ContentValues contentValues = new ContentValues();
                contentValues.put("user_key", user.e().c());
                Name f = user.f();
                if (f != null) {
                    contentValues.put("first_name", f.a());
                    contentValues.put("last_name", f.c());
                    contentValues.put("name", f.g());
                }
                contentValues.put("username", user.l());
                if (user.z() != null) {
                    contentValues.put("profile_pic_square", this.f10348c.a(user.z()).toString());
                }
                contentValues.put("is_messenger_user", Integer.valueOf(user.O() ? 1 : 0));
                String str = "is_commerce";
                if (user.P()) {
                    i = 1;
                } else {
                    i = 0;
                }
                contentValues.put(str, Integer.valueOf(i));
                str = "is_partial";
                if (user.ad()) {
                    i = 1;
                } else {
                    i = 0;
                }
                contentValues.put(str, Integer.valueOf(i));
                contentValues.put("user_rank", Float.valueOf(user.D()));
                contentValues.put("profile_type", user.J());
                contentValues.put("is_blocked_by_viewer", Boolean.valueOf(user.K()));
                contentValues.put("is_message_blocked_by_viewer", Boolean.valueOf(user.L()));
                contentValues.put("commerce_page_type", user.Q() == null ? null : user.Q().name());
                contentValues.put("can_viewer_message", Boolean.valueOf(user.N()));
                contentValues.put("commerce_page_settings", user.R() == null ? null : UserSerialization.b(user.R()).toString());
                contentValues.put("is_friend", Boolean.valueOf(user.Y()));
                contentValues.put("last_fetch_time", Long.valueOf(user.S()));
                contentValues.put("montage_thread_fbid", String.valueOf(user.ag()));
                str = "can_see_viewer_montage_thread";
                if (user.ah()) {
                    i = 1;
                } else {
                    i = 0;
                }
                contentValues.put(str, Integer.valueOf(i));
                contentValues.put("is_messenger_bot", Boolean.valueOf(user.Z()));
                contentValues.put("is_messenger_promotion_blocked_by_viewer", Boolean.valueOf(user.M()));
                contentValues.put("is_receiving_subscription_messages", Boolean.valueOf(user.al()));
                contentValues.put("is_messenger_platform_bot", Boolean.valueOf(user.am()));
                if (user.q() != null) {
                    contentValues.put("user_custom_tags", UserSerialization.a(user.q()).toString());
                }
                if (user.ak() != null) {
                    contentValues.put("user_call_to_actions", CallToActionSerialization.a(user.ak()));
                }
                SQLiteDetour.a(1593183113);
                a.replaceOrThrow("thread_users", "", contentValues);
                SQLiteDetour.a(-1045975457);
            }
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, 1859649320);
        } catch (Throwable e) {
            BLog.a(f10345a, "SQLException", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, -1871092075);
        }
    }
}
