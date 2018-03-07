package com.facebook.contacts.handlers;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.contacts.database.ContactSerialization;
import com.facebook.contacts.database.ContactsDatabaseSupplier;
import com.facebook.contacts.database.ContactsDbSchemaPart.ContactsIndexedDataTable.Columns;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.index.ContactIndexer;
import com.facebook.contacts.index.ContactIndexer.IndexWriter;
import com.facebook.contacts.iterator.ContactCursors;
import com.facebook.contacts.properties.ContactsDbStateChecker;
import com.facebook.contacts.properties.DbContactsPropertyUtil;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.Name;
import com.facebook.user.names.ContactPhoneBookUtils;
import com.facebook.user.names.ContactPhoneBookUtils.NameBucketParamsBuilder;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: rtc_android_video_vp8_hw_decode */
public class DbInsertContactHandler {
    private static final Class<?> f3295a = DbInsertContactHandler.class;
    private static volatile DbInsertContactHandler f3296l;
    private final ContactsDatabaseSupplier f3297b;
    private final DbContactsPropertyUtil f3298c;
    public final PhoneNumberUtil f3299d;
    private final DefaultUserInteractionController f3300e;
    private final Provider<String> f3301f;
    private final ContactPhoneBookUtils f3302g;
    private final ContactSerialization f3303h;
    private final ContactIndexer f3304i;
    private final ContactCursors f3305j;
    private final ContactsDbStateChecker f3306k;

    /* compiled from: rtc_android_video_vp8_hw_decode */
    public enum InsertionType {
        REPLACE_ALL,
        REPLACE,
        INSERT
    }

    /* compiled from: rtc_android_video_vp8_hw_decode */
    class ContentValuesIndexBuilder implements IndexWriter {
        private final long f3748a;
        private final Builder<ContentValues> f3749b = ImmutableList.builder();

        public ContentValuesIndexBuilder(long j) {
            this.f3748a = j;
        }

        public final void mo294a(String str, String str2) {
            ContentValues contentValues = new ContentValues(3);
            contentValues.put(Columns.f8288a.d, str);
            contentValues.put("indexed_data", str2);
            contentValues.put("contact_internal_id", Long.valueOf(this.f3748a));
            this.f3749b.c(contentValues);
        }

        public final void mo293a(String str, float f) {
            ContentValues contentValues = new ContentValues(3);
            contentValues.put(Columns.f8288a.d, str);
            contentValues.put("indexed_data", Float.valueOf(f));
            contentValues.put("contact_internal_id", Long.valueOf(this.f3748a));
            this.f3749b.c(contentValues);
        }

        public final ImmutableList<ContentValues> m4186a() {
            return this.f3749b.b();
        }
    }

    public static com.facebook.contacts.handlers.DbInsertContactHandler m3505a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3296l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.handlers.DbInsertContactHandler.class;
        monitor-enter(r1);
        r0 = f3296l;	 Catch:{ all -> 0x003a }
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
        r0 = m3510b(r0);	 Catch:{ all -> 0x0035 }
        f3296l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3296l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.handlers.DbInsertContactHandler.a(com.facebook.inject.InjectorLike):com.facebook.contacts.handlers.DbInsertContactHandler");
    }

    private static DbInsertContactHandler m3510b(InjectorLike injectorLike) {
        return new DbInsertContactHandler(ContactsDatabaseSupplier.m8560a(injectorLike), ContactSerialization.m3517a(injectorLike), DbContactsPropertyUtil.m8548b(injectorLike), PhoneNumberUtilMethodAutoProvider.m14153a(injectorLike), DefaultUserInteractionController.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), ContactPhoneBookUtils.m14075a(injectorLike), ContactIndexer.m3566b(injectorLike), ContactCursors.m11620a(injectorLike), ContactsDbStateChecker.m8582a(injectorLike));
    }

    @Inject
    public DbInsertContactHandler(ContactsDatabaseSupplier contactsDatabaseSupplier, ContactSerialization contactSerialization, DbContactsPropertyUtil dbContactsPropertyUtil, PhoneNumberUtil phoneNumberUtil, UserInteractionController userInteractionController, Provider<String> provider, ContactPhoneBookUtils contactPhoneBookUtils, ContactIndexer contactIndexer, ContactCursors contactCursors, ContactsDbStateChecker contactsDbStateChecker) {
        this.f3297b = contactsDatabaseSupplier;
        this.f3298c = dbContactsPropertyUtil;
        this.f3299d = phoneNumberUtil;
        this.f3300e = userInteractionController;
        this.f3301f = provider;
        this.f3302g = contactPhoneBookUtils;
        this.f3303h = contactSerialization;
        this.f3304i = contactIndexer;
        this.f3305j = contactCursors;
        this.f3306k = contactsDbStateChecker;
    }

    public final void m3515a(ImmutableCollection<Contact> immutableCollection, InsertionType insertionType, @Nullable DataFreshnessResult dataFreshnessResult) {
        if (!immutableCollection.isEmpty()) {
            TracerDetour.a("insertContactsIntoDatabase (%d contacts)", Integer.valueOf(immutableCollection.size()), 658737703);
            LoomLogger.a(LoomLoggerDetour.a(289758661), "InsertContactsIntoDatabase", String.valueOf(immutableCollection.size()));
            try {
                this.f3300e.c();
                SQLiteDatabase a = this.f3297b.a();
                SQLiteDetour.a(a, 636785227);
                try {
                    if (insertionType == InsertionType.REPLACE_ALL) {
                        String str = "contacts";
                    }
                    Iterator it = immutableCollection.iterator();
                    while (it.hasNext()) {
                        m3512a((Contact) it.next(), dataFreshnessResult);
                    }
                    a.setTransactionSuccessful();
                    SQLiteDetour.b(a, -943350440);
                } finally {
                    SQLiteDetour.b(a, -1258126433);
                }
            } finally {
                TracerDetour.a(-2129750768);
            }
        }
    }

    public final void m3513a() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r13 = this;
        r1 = 0;
        r0 = "reindexContactsNames";
        r2 = 697757595; // 0x2996ef9b float:6.702903E-14 double:3.44738057E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r2);
        r0 = com.facebook.contacts.iterator.ContactCursorsQuery.m11630a();	 Catch:{ all -> 0x00b8 }
        r2 = com.facebook.contacts.iterator.ContactCursorsQuery.SortKey.ID;	 Catch:{ all -> 0x00b8 }
        r0 = r0.m11638a(r2);	 Catch:{ all -> 0x00b8 }
        r2 = r13.f3305j;	 Catch:{ all -> 0x00b8 }
        r3 = com.facebook.contacts.data.FbContactsContract.QueryType.CONTACT;	 Catch:{ all -> 0x00b8 }
        r5 = r2.m11622a(r0, r3);	 Catch:{ all -> 0x00b8 }
        r4 = 0;
        r0 = "data";	 Catch:{ Throwable -> 0x00aa, all -> 0x00c9 }
        r6 = r5.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00aa, all -> 0x00c9 }
        r0 = "_id";	 Catch:{ Throwable -> 0x00aa, all -> 0x00c9 }
        r7 = r5.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00aa, all -> 0x00c9 }
        r3 = com.google.common.collect.ImmutableList.builder();	 Catch:{ Throwable -> 0x00aa, all -> 0x00c9 }
        r2 = com.google.common.collect.ImmutableList.builder();	 Catch:{ Throwable -> 0x00aa, all -> 0x00c9 }
        r0 = r13.f3297b;	 Catch:{ Throwable -> 0x00aa, all -> 0x00c9 }
        r8 = r0.a();	 Catch:{ Throwable -> 0x00aa, all -> 0x00c9 }
        r0 = -1194515175; // 0xffffffffb8cd2519 float:-9.782072E-5 double:NaN;	 Catch:{ Throwable -> 0x00aa, all -> 0x00c9 }
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r8, r0);	 Catch:{ Throwable -> 0x00aa, all -> 0x00c9 }
        r13.m3511b();	 Catch:{ all -> 0x00a2 }
        r0 = r1;	 Catch:{ all -> 0x00a2 }
    L_0x0040:
        r9 = r5.moveToNext();	 Catch:{ all -> 0x00a2 }
        if (r9 == 0) goto L_0x007b;	 Catch:{ all -> 0x00a2 }
    L_0x0046:
        r9 = r5.getString(r6);	 Catch:{ all -> 0x00a2 }
        r10 = r13.f3303h;	 Catch:{ all -> 0x00a2 }
        r9 = r10.m3519a(r9);	 Catch:{ all -> 0x00a2 }
        r3.c(r9);	 Catch:{ all -> 0x00a2 }
        r10 = r5.getLong(r7);	 Catch:{ all -> 0x00a2 }
        r9 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x00a2 }
        r2.c(r9);	 Catch:{ all -> 0x00a2 }
        r0 = r0 + 1;	 Catch:{ all -> 0x00a2 }
        r9 = 20;	 Catch:{ all -> 0x00a2 }
        if (r0 != r9) goto L_0x0040;	 Catch:{ all -> 0x00a2 }
    L_0x0064:
        r0 = r3.b();	 Catch:{ all -> 0x00a2 }
        r2 = r2.b();	 Catch:{ all -> 0x00a2 }
        r13.m3508a(r0, r2);	 Catch:{ all -> 0x00a2 }
        r2 = com.google.common.collect.ImmutableList.builder();	 Catch:{ all -> 0x00a2 }
        r0 = com.google.common.collect.ImmutableList.builder();	 Catch:{ all -> 0x00a2 }
        r3 = r2;	 Catch:{ all -> 0x00a2 }
        r2 = r0;	 Catch:{ all -> 0x00a2 }
        r0 = r1;	 Catch:{ all -> 0x00a2 }
        goto L_0x0040;	 Catch:{ all -> 0x00a2 }
    L_0x007b:
        if (r0 == 0) goto L_0x0088;	 Catch:{ all -> 0x00a2 }
    L_0x007d:
        r0 = r3.b();	 Catch:{ all -> 0x00a2 }
        r1 = r2.b();	 Catch:{ all -> 0x00a2 }
        r13.m3508a(r0, r1);	 Catch:{ all -> 0x00a2 }
    L_0x0088:
        r0 = r13.f3306k;	 Catch:{ all -> 0x00a2 }
        r0.m8585c();	 Catch:{ all -> 0x00a2 }
        r8.setTransactionSuccessful();	 Catch:{ all -> 0x00a2 }
        r0 = -1671229269; // 0xffffffff9c6310ab float:-7.512954E-22 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r8, r0);	 Catch:{  }
        if (r5 == 0) goto L_0x009b;
    L_0x0098:
        r5.close();	 Catch:{  }
    L_0x009b:
        r0 = 1356513451; // 0x50dac0ab float:2.93604782E10 double:6.702066943E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        return;
    L_0x00a2:
        r0 = move-exception;
        r1 = 496016655; // 0x1d909d0f float:3.8278877E-21 double:2.45064789E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r8, r1);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x00aa:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00ac }
    L_0x00ac:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x00b0:
        if (r5 == 0) goto L_0x00b7;
    L_0x00b2:
        if (r1 == 0) goto L_0x00c5;
    L_0x00b4:
        r5.close();	 Catch:{ Throwable -> 0x00c0 }
    L_0x00b7:
        throw r0;	 Catch:{  }
    L_0x00b8:
        r0 = move-exception;
        r1 = -280810247; // 0xffffffffef432cf9 float:-6.0403946E28 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
    L_0x00c0:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);	 Catch:{  }
        goto L_0x00b7;	 Catch:{  }
    L_0x00c5:
        r5.close();	 Catch:{  }
        goto L_0x00b7;
    L_0x00c9:
        r0 = move-exception;
        r1 = r4;
        goto L_0x00b0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.handlers.DbInsertContactHandler.a():void");
    }

    @VisibleForTesting
    private void m3511b() {
        Expression a = SqlExpression.a(Columns.f8288a.d, ImmutableList.of("sort_name_key", "name"));
        this.f3300e.c();
        this.f3297b.a().delete("contacts_indexed_data", a.a(), a.b());
    }

    @VisibleForTesting
    private void m3508a(ImmutableList<Contact> immutableList, ImmutableList<Long> immutableList2) {
        if (!immutableList.isEmpty()) {
            TracerDetour.a("reindexContactsNames (%d contacts)", Integer.valueOf(immutableList.size()), -1640772651);
            LoomLogger.a(LoomLoggerDetour.a(-1885710190), "reindexContactNames", String.valueOf(immutableList.size()));
            try {
                SQLiteDatabase a = this.f3297b.a();
                SQLiteDetour.a(a, 1904309636);
                try {
                    Builder builder = ImmutableList.builder();
                    UnmodifiableIterator it = immutableList2.iterator();
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        Contact contact = (Contact) immutableList.get(i);
                        Object contentValuesIndexBuilder = new ContentValuesIndexBuilder(((Long) it.next()).longValue());
                        this.f3304i.m3571b(contact, contentValuesIndexBuilder);
                        builder.b(contentValuesIndexBuilder.m4186a());
                    }
                    this.f3300e.c();
                    ImmutableList b = builder.b();
                    int size2 = b.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ContentValues contentValues = (ContentValues) b.get(i2);
                        String str = "contacts_indexed_data";
                        SQLiteDetour.a(1967849863);
                        a.insertOrThrow(str, null, contentValues);
                        SQLiteDetour.a(1273389563);
                    }
                    a.setTransactionSuccessful();
                    SQLiteDetour.b(a, -619720457);
                } catch (Throwable th) {
                    SQLiteDetour.b(a, 843504545);
                }
            } finally {
                TracerDetour.a(542738311);
            }
        }
    }

    public final void m3514a(ImmutableCollection<String> immutableCollection) {
        if (!immutableCollection.isEmpty()) {
            this.f3300e.c();
            SQLiteDatabase a = this.f3297b.a();
            Expression a2 = SqlExpression.a("contact_id", immutableCollection);
            String str = "contact_internal_id in (select internal_id from contacts where " + a2.a() + ")";
            SQLiteDetour.a(a, 1355684683);
            try {
                a.delete("contacts_indexed_data", str, a2.b());
                a.delete("contacts", a2.a(), a2.b());
                a.setTransactionSuccessful();
            } finally {
                SQLiteDetour.b(a, -1242949680);
            }
        }
    }

    public final long m3512a(Contact contact, @Nullable DataFreshnessResult dataFreshnessResult) {
        TracerDetour.a("insertContactIntoDatabase (%s)", contact.m4067b(), 927354425);
        long valueOf = String.valueOf(contact.m4067b());
        LoomLogger.a(LoomLoggerDetour.a(-459793063), "insertContactIntoDatabase", valueOf);
        try {
            Preconditions.checkNotNull(contact);
            int i = ((!contact.m4082q() || contact.m4086u()) && contact.m4053A() != ContactProfileType.PAGE) ? 0 : 1;
            SQLiteDatabase a = this.f3297b.a();
            SQLiteDetour.a(a, -862597631);
            try {
                valueOf = m3503a(a, contact, i, dataFreshnessResult);
                if (i != 0) {
                    m3507a(a, contact, valueOf);
                }
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, i);
                return valueOf;
            } finally {
                valueOf = 1775123998;
                SQLiteDetour.b(a, 1775123998);
            }
        } finally {
            TracerDetour.a(1154871803);
        }
    }

    private long m3503a(SQLiteDatabase sQLiteDatabase, Contact contact, boolean z, @Nullable DataFreshnessResult dataFreshnessResult) {
        String str;
        if (dataFreshnessResult == DataFreshnessResult.FROM_SERVER) {
            str = "?";
        } else {
            str = "(select last_fetch_time_ms from contacts where contact_id = ?)";
        }
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("INSERT OR REPLACE INTO contacts (internal_id, contact_id, fbid, first_name, last_name, display_name, small_picture_url, big_picture_url, huge_picture_url, small_picture_size, big_picture_size, huge_picture_size, communication_rank, is_mobile_pushable, is_messenger_user, messenger_install_time_ms, added_time_ms, phonebook_section_key, is_on_viewer_contact_list, type, link_type, is_indexed, data, bday_month, bday_day, is_partial, messenger_invite_priority, last_fetch_time_ms) VALUES ((select internal_id from contacts where contact_id = ?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " + str + ")");
        try {
            long j;
            compileStatement.bindString(1, contact.m4067b());
            compileStatement.bindString(2, contact.m4067b());
            m3504a(compileStatement, 3, contact.m4068c());
            m3504a(compileStatement, 4, contact.m4070e().a());
            m3504a(compileStatement, 5, contact.m4070e().c());
            m3504a(compileStatement, 6, contact.m4070e().g());
            m3504a(compileStatement, 7, contact.m4072g());
            m3504a(compileStatement, 8, contact.m4073h());
            m3504a(compileStatement, 9, contact.m4074i());
            compileStatement.bindLong(10, (long) contact.m4075j());
            compileStatement.bindLong(11, (long) contact.m4076k());
            compileStatement.bindLong(12, (long) contact.m4077l());
            compileStatement.bindDouble(13, (double) contact.m4078m());
            compileStatement.bindLong(14, (long) contact.m4083r().getDbValue());
            compileStatement.bindString(15, String.valueOf(contact.m4084s()));
            compileStatement.bindLong(16, contact.m4085t());
            compileStatement.bindLong(17, contact.m4088w());
            m3504a(compileStatement, 18, m3506a(sQLiteDatabase, contact.m4070e(), contact.m4071f()));
            compileStatement.bindString(19, String.valueOf(contact.m4087v()));
            compileStatement.bindLong(20, (long) contact.m4053A().getDbValue());
            compileStatement.bindLong(21, (long) ContactLinkType.getFromContact(contact, (String) this.f3301f.get()).getDbValue());
            compileStatement.bindLong(22, z ? 1 : 0);
            m3504a(compileStatement, 23, this.f3303h.m3520a(contact));
            compileStatement.bindLong(24, (long) contact.m4057E());
            compileStatement.bindLong(25, (long) contact.m4056D());
            if (contact.m4058F()) {
                j = 1;
            } else {
                j = 0;
            }
            compileStatement.bindLong(26, j);
            compileStatement.bindDouble(27, (double) contact.m4065M());
            if (dataFreshnessResult == DataFreshnessResult.FROM_SERVER) {
                compileStatement.bindLong(28, contact.m4059G());
            } else {
                compileStatement.bindString(28, contact.m4067b());
            }
            SQLiteDetour.a(-1052711884);
            j = compileStatement.executeInsert();
            SQLiteDetour.a(680090223);
            return j;
        } finally {
            compileStatement.close();
        }
    }

    private static SQLiteStatement m3504a(SQLiteStatement sQLiteStatement, int i, @Nullable String str) {
        if (str == null) {
            sQLiteStatement.bindNull(i);
        } else {
            sQLiteStatement.bindString(i, str);
        }
        return sQLiteStatement;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m3516a(com.google.common.collect.ImmutableMultimap<java.lang.String, com.facebook.phonenumbers.Phonenumber.PhoneNumber> r9) {
        /*
        r8 = this;
        r0 = com.google.common.collect.ImmutableList.builder();
        r8.m3509a(r9, r0);
        r1 = r8.f3300e;
        r1.c();
        r1 = r8.f3297b;
        r2 = r1.a();
        r1 = -78278487; // 0xfffffffffb5590a9 float:-1.1088933E36 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r2, r1);
        r3 = com.facebook.contacts.database.ContactsDatabaseSQLightHelper.a(r2);	 Catch:{ all -> 0x0071 }
        r4 = r0.b();	 Catch:{ all -> 0x006c }
        r5 = r4.size();	 Catch:{ all -> 0x006c }
        r0 = 0;
        r1 = r0;
    L_0x0026:
        if (r1 >= r5) goto L_0x005f;
    L_0x0028:
        r0 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r0 = (android.content.ContentValues) r0;	 Catch:{ all -> 0x006c }
        r6 = 1;
        r7 = "contact_id";
        r7 = r0.getAsString(r7);	 Catch:{ all -> 0x006c }
        r3.bindString(r6, r7);	 Catch:{ all -> 0x006c }
        r6 = 2;
        r7 = "type";
        r7 = r0.getAsString(r7);	 Catch:{ all -> 0x006c }
        r3.bindString(r6, r7);	 Catch:{ all -> 0x006c }
        r6 = 3;
        r7 = "indexed_data";
        r0 = r0.getAsString(r7);	 Catch:{ all -> 0x006c }
        r3.bindString(r6, r0);	 Catch:{ all -> 0x006c }
        r0 = 215167564; // 0xcd3324c float:3.2539969E-31 double:1.063069015E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r0);	 Catch:{ all -> 0x006c }
        r3.execute();	 Catch:{ all -> 0x006c }
        r0 = -285756112; // 0xffffffffeef7b530 float:-3.833092E28 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r0);	 Catch:{ all -> 0x006c }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0026;
    L_0x005f:
        r3.close();	 Catch:{  }
        r2.setTransactionSuccessful();	 Catch:{  }
        r0 = 2050764912; // 0x7a3c3070 float:2.4428356E35 double:1.0132124907E-314;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r2, r0);
        return;
    L_0x006c:
        r0 = move-exception;
        r3.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0071:
        r0 = move-exception;
        r1 = -108171150; // 0xfffffffff98d7072 float:-9.179931E34 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r2, r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.handlers.DbInsertContactHandler.a(com.google.common.collect.ImmutableMultimap):void");
    }

    private void m3509a(ImmutableMultimap<String, PhoneNumber> immutableMultimap, Builder<ContentValues> builder) {
        Iterator it = immutableMultimap.u().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            ContentValues contentValues = new ContentValues();
            contentValues.put("contact_id", (String) entry.getKey());
            PhoneNumber phoneNumber = (PhoneNumber) entry.getValue();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("type", "phone_e164");
            contentValues2.putAll(contentValues);
            contentValues2.put("indexed_data", this.f3299d.format(phoneNumber, PhoneNumberFormat.E164));
            builder.c(contentValues2);
            String nationalSignificantNumber = this.f3299d.getNationalSignificantNumber(phoneNumber);
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("type", "phone_national");
            contentValues3.putAll(contentValues);
            contentValues3.put("indexed_data", nationalSignificantNumber);
            builder.c(contentValues3);
            int lengthOfGeographicalAreaCode = this.f3299d.getLengthOfGeographicalAreaCode(phoneNumber);
            if (lengthOfGeographicalAreaCode > 0) {
                nationalSignificantNumber = nationalSignificantNumber.substring(lengthOfGeographicalAreaCode);
                contentValues3 = new ContentValues();
                contentValues3.put("type", "phone_local");
                contentValues3.putAll(contentValues);
                contentValues3.put("indexed_data", nationalSignificantNumber);
                builder.c(contentValues3);
            }
        }
    }

    @Nullable
    private String m3506a(SQLiteDatabase sQLiteDatabase, Name name, @Nullable Name name2) {
        NameBucketParamsBuilder nameBucketParamsBuilder = new NameBucketParamsBuilder();
        nameBucketParamsBuilder.f3700a = name.i();
        NameBucketParamsBuilder nameBucketParamsBuilder2 = nameBucketParamsBuilder;
        nameBucketParamsBuilder2.f3701b = name.a();
        nameBucketParamsBuilder2.f3702c = name.c();
        if (name2 != null) {
            nameBucketParamsBuilder.f3703d = name2.i();
            nameBucketParamsBuilder2 = nameBucketParamsBuilder;
            nameBucketParamsBuilder2.f3704e = name2.a();
            nameBucketParamsBuilder2.f3705f = name2.c();
        }
        return this.f3302g.m14082a(sQLiteDatabase, nameBucketParamsBuilder.m4156a());
    }

    private void m3507a(SQLiteDatabase sQLiteDatabase, Contact contact, long j) {
        Object contentValuesIndexBuilder = new ContentValuesIndexBuilder(j);
        this.f3304i.m3570a(contact, contentValuesIndexBuilder);
        SQLiteDetour.a(sQLiteDatabase, -703999620);
        try {
            sQLiteDatabase.delete("contacts_indexed_data", "contact_internal_id = ?", new String[]{String.valueOf(j)});
            ImmutableList a = contentValuesIndexBuilder.m4186a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ContentValues contentValues = (ContentValues) a.get(i);
                SQLiteDetour.a(1474309530);
                sQLiteDatabase.insertOrThrow("contacts_indexed_data", null, contentValues);
                SQLiteDetour.a(1806633613);
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(sQLiteDatabase, -347376630);
        }
    }
}
