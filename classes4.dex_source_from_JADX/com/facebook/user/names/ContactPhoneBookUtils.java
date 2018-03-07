package com.facebook.user.names;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.user.names.NameSplitter.Name;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import java.lang.Character.UnicodeBlock;
import java.text.BreakIterator;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: receiver_webrtc_engine_layer */
public class ContactPhoneBookUtils {
    private static final Class<?> f13215a = ContactPhoneBookUtils.class;
    private static volatile ContactPhoneBookUtils f13216h;
    private final Locales f13217b;
    private final ContactLocaleUtils f13218c;
    private final NameSplitter f13219d;
    private final ContactAlphabeticIndexUtils f13220e;
    private TriState f13221f = TriState.UNSET;
    private BreakIterator f13222g;

    /* compiled from: receiver_webrtc_engine_layer */
    public class NameBucketParamsBuilder {
        public String f3700a;
        public String f3701b;
        public String f3702c;
        public String f3703d;
        @Nullable
        public String f3704e;
        @Nullable
        public String f3705f;

        public final PhoneBookContactBucketParams m4156a() {
            return new PhoneBookContactBucketParams(this);
        }
    }

    /* compiled from: receiver_webrtc_engine_layer */
    public class PhoneBookContactBucketParams {
        public String f3706a;
        public String f3707b;
        public String f3708c;
        public String f3709d;
        @Nullable
        public String f3710e;
        @Nullable
        public String f3711f;

        public PhoneBookContactBucketParams(NameBucketParamsBuilder nameBucketParamsBuilder) {
            this.f3706a = nameBucketParamsBuilder.f3700a;
            this.f3707b = nameBucketParamsBuilder.f3701b;
            this.f3708c = nameBucketParamsBuilder.f3702c;
            this.f3709d = nameBucketParamsBuilder.f3703d;
            this.f3710e = nameBucketParamsBuilder.f3704e;
            this.f3711f = nameBucketParamsBuilder.f3705f;
        }
    }

    public static com.facebook.user.names.ContactPhoneBookUtils m14075a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13216h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.user.names.ContactPhoneBookUtils.class;
        monitor-enter(r1);
        r0 = f13216h;	 Catch:{ all -> 0x003a }
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
        r0 = m14078b(r0);	 Catch:{ all -> 0x0035 }
        f13216h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13216h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.user.names.ContactPhoneBookUtils.a(com.facebook.inject.InjectorLike):com.facebook.user.names.ContactPhoneBookUtils");
    }

    private static ContactPhoneBookUtils m14078b(InjectorLike injectorLike) {
        return new ContactPhoneBookUtils(Locales.a(injectorLike), ContactLocaleUtils.m14085a(injectorLike), NameSplitterMethodAutoProvider.m14093a(injectorLike), ContactAlphabeticIndexUtils.m14107a(injectorLike));
    }

    @Inject
    public ContactPhoneBookUtils(Locales locales, ContactLocaleUtils contactLocaleUtils, NameSplitter nameSplitter, ContactAlphabeticIndexUtils contactAlphabeticIndexUtils) {
        this.f13217b = locales;
        this.f13218c = contactLocaleUtils;
        this.f13219d = nameSplitter;
        this.f13220e = contactAlphabeticIndexUtils;
        this.f13222g = BreakIterator.getCharacterInstance();
    }

    public final String m14082a(SQLiteDatabase sQLiteDatabase, PhoneBookContactBucketParams phoneBookContactBucketParams) {
        if (this.f13220e.m14111a()) {
            String a = m14076a(phoneBookContactBucketParams);
            if (a != null) {
                return a;
            }
        }
        return m14079b(sQLiteDatabase, phoneBookContactBucketParams);
    }

    private String m14076a(PhoneBookContactBucketParams phoneBookContactBucketParams) {
        String c = m14081c(phoneBookContactBucketParams);
        if (c == null) {
            return null;
        }
        return this.f13220e.m14110a(c);
    }

    private String m14079b(SQLiteDatabase sQLiteDatabase, PhoneBookContactBucketParams phoneBookContactBucketParams) {
        Cursor cursor = null;
        String b = m14080b(phoneBookContactBucketParams);
        if (b != null && m14077a(sQLiteDatabase)) {
            try {
                cursor = sQLiteDatabase.rawQuery(StringFormatUtil.a("SELECT GET_PHONEBOOK_INDEX(%s, %s)", new Object[]{DatabaseUtils.sqlEscapeString(b), DatabaseUtils.sqlEscapeString(this.f13217b.a().toString())}), null);
                if (cursor.moveToNext()) {
                    b = cursor.getString(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return b;
    }

    @SuppressLint({"CatchGeneralException"})
    private boolean m14077a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        if (this.f13221f.isSet()) {
            return this.f13221f.asBoolean();
        }
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT GET_PHONEBOOK_INDEX('A', 'en_US')", null);
            this.f13221f = TriState.YES;
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            this.f13221f = TriState.NO;
            BLog.a(f13215a, "", e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return this.f13221f.asBoolean();
    }

    @VisibleForTesting
    private String m14080b(PhoneBookContactBucketParams phoneBookContactBucketParams) {
        String c = m14081c(phoneBookContactBucketParams);
        this.f13222g.setText(c);
        int first = this.f13222g.first();
        int next = this.f13222g.next();
        if (next != -1) {
            return c.substring(first, next);
        }
        return c;
    }

    private String m14081c(PhoneBookContactBucketParams phoneBookContactBucketParams) {
        Name name = new Name();
        name.f3717b = phoneBookContactBucketParams.f3707b;
        name.f3719d = phoneBookContactBucketParams.f3708c;
        name.f3721f = 0;
        name.f3724i = phoneBookContactBucketParams.f3710e;
        name.f3722g = phoneBookContactBucketParams.f3711f;
        name.f3725j = 0;
        if (Strings.isNullOrEmpty(phoneBookContactBucketParams.f3709d)) {
            name.f3721f = this.f13219d.m14103a(this.f13219d.m14104a(phoneBookContactBucketParams.f3706a));
            String a = this.f13219d.m14106a(name, true, true);
            if (this.f13220e.m14111a()) {
                return a;
            }
            if (name.f3721f == 3 || name.f3721f == 2) {
                return this.f13218c.m14089a(a, name.f3721f);
            }
            return a;
        }
        CharSequence charSequence = phoneBookContactBucketParams.f3709d;
        int i = 0;
        if (charSequence != null) {
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                int codePointAt = Character.codePointAt(charSequence, i2);
                if (Character.isLetter(codePointAt)) {
                    UnicodeBlock of = UnicodeBlock.of(codePointAt);
                    if (NameSplitter.m14102d(of)) {
                        i = 4;
                        break;
                    } else if (NameSplitter.m14101c(of)) {
                        i = 5;
                        break;
                    } else if (NameSplitter.m14099a(of)) {
                        i = 3;
                        break;
                    }
                }
                i2 += Character.charCount(codePointAt);
            }
        }
        name.f3725j = i;
        return this.f13219d.m14105a(name);
    }
}
