package com.facebook.messaging.sms.contacts;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.abtest.SmsTakeoverMultiverseExperimentHelper;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.telephony.FbPhoneNumberUtils;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserPhoneNumber;
import com.facebook.user.names.ContactPhoneBookUtils;
import com.facebook.user.names.ContactPhoneBookUtils.NameBucketParamsBuilder;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: edit_story_privacy_saved */
public class PhoneContactsLoader {
    private static final String[] f13281a = new String[]{"android.permission.READ_CONTACTS", "android.permission.READ_SMS"};
    private static final String[] f13282b = new String[]{"contact_id", "display_name", "data4", "data1", "data2"};
    private static final Expression f13283c = SqlExpression.a(new Expression[]{SqlExpression.a("mimetype", "vnd.android.cursor.item/phone_v2"), SqlExpression.a("has_phone_number", "1"), SqlExpression.a("data1"), SqlExpression.a(SqlExpression.a("data1", "")), SqlExpression.a("display_name"), SqlExpression.a(SqlExpression.a("display_name", ""))});
    private static final Pattern f13284d = Pattern.compile("\\s+");
    private final Context f13285e;
    private final SmsIntegrationState f13286f;
    private final Provider<Boolean> f13287g;
    public final ContactPhoneBookUtils f13288h;
    private final FbPhoneNumberUtils f13289i;
    private final RuntimePermissionsUtil f13290j;
    private final SmsContactsRankingHelper f13291k;
    private final SmsTakeoverMultiverseExperimentHelper f13292l;
    private final SmsTakeoverAnalyticsLogger f13293m;
    private final FbSharedPreferences f13294n;

    /* compiled from: edit_story_privacy_saved */
    public enum CallerContext {
        SEARCH,
        NULL_STATE,
        PEOPLE_TAB
    }

    public static PhoneContactsLoader m14173b(InjectorLike injectorLike) {
        return new PhoneContactsLoader((Context) injectorLike.getInstance(Context.class), SmsIntegrationState.m10491a(injectorLike), IdBasedProvider.a(injectorLike, 4200), ContactPhoneBookUtils.m14075a(injectorLike), FbPhoneNumberUtils.m14146b(injectorLike), RuntimePermissionsUtil.b(injectorLike), SmsContactsRankingHelper.m14188a(injectorLike), SmsTakeoverMultiverseExperimentHelper.m14202b(injectorLike), SmsTakeoverAnalyticsLogger.m14218b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    public static PhoneContactsLoader m14166a(InjectorLike injectorLike) {
        return m14173b(injectorLike);
    }

    @Inject
    public PhoneContactsLoader(Context context, SmsIntegrationState smsIntegrationState, Provider<Boolean> provider, ContactPhoneBookUtils contactPhoneBookUtils, FbPhoneNumberUtils fbPhoneNumberUtils, RuntimePermissionsUtil runtimePermissionsUtil, SmsContactsRankingHelper smsContactsRankingHelper, SmsTakeoverMultiverseExperimentHelper smsTakeoverMultiverseExperimentHelper, SmsTakeoverAnalyticsLogger smsTakeoverAnalyticsLogger, FbSharedPreferences fbSharedPreferences) {
        this.f13285e = context;
        this.f13286f = smsIntegrationState;
        this.f13287g = provider;
        this.f13288h = contactPhoneBookUtils;
        this.f13289i = fbPhoneNumberUtils;
        this.f13290j = runtimePermissionsUtil;
        this.f13291k = smsContactsRankingHelper;
        this.f13292l = smsTakeoverMultiverseExperimentHelper;
        this.f13293m = smsTakeoverAnalyticsLogger;
        this.f13294n = fbSharedPreferences;
    }

    public final ImmutableList<User> m14177a(String str, int i, boolean z, CallerContext callerContext) {
        if (!m14174c(callerContext)) {
            return RegularImmutableList.a;
        }
        List arrayList;
        if (FbPhoneNumberUtils.m14147c(str)) {
            HashMap hashMap = new HashMap();
            String e = FbPhoneNumberUtils.m14148e(str);
            if (e.length() >= 3) {
                for (User user : m14169a(Uri.withAppendedPath(Phone.CONTENT_FILTER_URI, Uri.encode(str)), f13283c, i, "_id", true, callerContext)) {
                    hashMap.put(user.d(), user);
                }
                for (User user2 : m14169a(Phone.CONTENT_URI, SqlExpression.a(new Expression[]{f13283c, SqlExpression.d("data4", "%" + e + "%")}), i, "_id", true, callerContext)) {
                    hashMap.put(user2.d(), user2);
                }
                Set hashSet = new HashSet();
                for (User user22 : hashMap.values()) {
                    hashSet.add(user22.w().c());
                    hashSet.add(user22.w().b());
                    hashSet.add(user22.w().a());
                }
                for (User user222 : m14170a(e, hashSet)) {
                    hashMap.put(user222.d(), user222);
                }
            }
            arrayList = new ArrayList(hashMap.values());
        } else {
            String[] split = f13284d.split(str, 4);
            ConjunctionExpression a = SqlExpression.a();
            for (String str2 : split) {
                a.a(SqlExpression.b(new Expression[]{SqlExpression.d("display_name", str2 + "%"), SqlExpression.d("display_name", "% " + str2 + "%")}));
            }
            arrayList = m14169a(Phone.CONTENT_URI, SqlExpression.a(new Expression[]{f13283c, a}), i, "_id", true, callerContext);
        }
        if (z) {
            m14172a(str, arrayList);
        }
        m14171a(callerContext, arrayList.size());
        return ImmutableList.copyOf(arrayList);
    }

    public final ImmutableList<User> m14176a(CallerContext callerContext) {
        if (!m14174c(callerContext)) {
            return RegularImmutableList.a;
        }
        ImmutableList<User> copyOf = ImmutableList.copyOf(m14169a(Phone.CONTENT_URI, f13283c, 2000, "_id", false, callerContext));
        m14171a(callerContext, copyOf.size());
        return copyOf;
    }

    public final ImmutableList<User> m14179b(CallerContext callerContext) {
        return m14175a(10, callerContext);
    }

    public final ImmutableList<User> m14175a(int i, CallerContext callerContext) {
        if (!m14174c(callerContext)) {
            return RegularImmutableList.a;
        }
        Collection<String> a = this.f13291k.m14193a(i);
        Collection arrayList = new ArrayList(a.size());
        for (String d : a) {
            arrayList.add(this.f13289i.m14152d(d));
        }
        Uri uri = Phone.CONTENT_URI;
        Expression[] expressionArr = new Expression[2];
        expressionArr[0] = f13283c;
        expressionArr[1] = SqlExpression.b(new Expression[]{SqlExpression.a("data1", a), SqlExpression.a("data4", arrayList)});
        Collection a2 = m14169a(uri, SqlExpression.a(expressionArr), 2000, "_id", true, callerContext);
        if (a2.size() > i) {
            Collections.sort(a2, new 1(this));
            a2 = a2.subList(0, i);
        }
        m14171a(callerContext, a2.size());
        return ImmutableList.copyOf(a2);
    }

    public final ImmutableList<User> m14178a(Collection<String> collection, CallerContext callerContext) {
        if (!m14174c(callerContext)) {
            return RegularImmutableList.a;
        }
        Collection a = m14169a(Phone.CONTENT_URI, SqlExpression.a(new Expression[]{f13283c, SqlExpression.a("data1", collection)}), 2000, "_id", false, callerContext);
        m14171a(callerContext, a.size());
        return ImmutableList.copyOf(a);
    }

    private boolean m14174c(CallerContext callerContext) {
        if (this.f13290j.a(f13281a)) {
            return this.f13286f.m10496a() || ((Boolean) this.f13287g.get()).booleanValue() || ((callerContext == CallerContext.SEARCH && this.f13292l.m14213t()) || ((callerContext == CallerContext.NULL_STATE && this.f13292l.m14214u()) || (callerContext == CallerContext.PEOPLE_TAB && this.f13292l.m14215v())));
        } else {
            return false;
        }
    }

    private List<User> m14170a(String str, Set<String> set) {
        List arrayList = new ArrayList();
        Map a = this.f13291k.m14194a(str);
        for (String str2 : a.keySet()) {
            String d = this.f13289i.m14152d(str2);
            String b = this.f13289i.m14151b(str2);
            if (!(set.contains(str2) || set.contains(d) || set.contains(b))) {
                ImmutableList of = ImmutableList.of(new UserPhoneNumber(b, str2, d, 7));
                UserBuilder a2 = new UserBuilder().a(null, d);
                a2.h = b;
                a2 = a2;
                a2.d = of;
                a2 = a2;
                a2.t = ((Double) a.get(str2)).floatValue();
                arrayList.add(a2.aa());
            }
        }
        return arrayList;
    }

    private List<User> m14169a(Uri uri, Expression expression, int i, String str, boolean z, CallerContext callerContext) {
        Cursor query;
        Throwable th;
        SQLiteDatabase sQLiteDatabase = null;
        Preconditions.checkState(m14174c(callerContext));
        try {
            List<User> a;
            query = this.f13285e.getContentResolver().query(uri.buildUpon().appendQueryParameter("limit", String.valueOf(i)).build(), f13282b, expression.a(), expression.b(), str);
            if (query != null) {
                try {
                    sQLiteDatabase = SQLiteDatabase.create(null);
                    a = m14168a(query, sQLiteDatabase, i, z);
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            }
            a = null;
            if (query != null) {
                query.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            return a == null ? new ArrayList() : a;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    @VisibleForTesting
    private List<User> m14168a(Cursor cursor, SQLiteDatabase sQLiteDatabase, int i, boolean z) {
        List<User> arrayList = new ArrayList();
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("contact_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("data4");
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("data1");
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("display_name");
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("data2");
        Map hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        while (cursor.moveToNext() && arrayList.size() <= i) {
            long j = cursor.getLong(columnIndexOrThrow);
            String string = cursor.getString(columnIndexOrThrow4);
            String string2 = cursor.getString(columnIndexOrThrow2);
            String string3 = cursor.getString(columnIndexOrThrow3);
            if (Strings.isNullOrEmpty(string2)) {
                string2 = this.f13289i.m14152d(string3);
            }
            String e = FbPhoneNumberUtils.m14148e(string3);
            Set set = (Set) hashMap.get(string);
            if (!(Strings.isNullOrEmpty(string2) || Strings.isNullOrEmpty(e))) {
                if (set == null || !(set.contains(string2) || set.contains(e))) {
                    UserBuilder a;
                    if (set == null) {
                        set = new HashSet();
                        hashMap.put(string, set);
                    }
                    set.add(string2);
                    set.add(e);
                    User user = (User) hashMap2.get(Long.valueOf(j));
                    if (!((Boolean) this.f13287g.get()).booleanValue() || user == null) {
                        a = m14167a(Long.toString(j), cursor.getString(columnIndexOrThrow4), string3, string2, cursor.getInt(columnIndexOrThrow5), sQLiteDatabase);
                    } else {
                        ImmutableList b = ImmutableList.builder().b(user.r()).c(new UserPhoneNumber(string2, string3, string2, cursor.getInt(columnIndexOrThrow5))).b();
                        arrayList.remove(user);
                        a = new UserBuilder().a(user).b(b);
                    }
                    if (z) {
                        float a2 = (float) this.f13291k.m14192a(string3, string2);
                        if (a2 > a.t()) {
                            a.a(a2);
                        }
                    }
                    user = a.aa();
                    hashMap2.put(Long.valueOf(j), user);
                    arrayList.add(user);
                }
            }
        }
        return arrayList;
    }

    private UserBuilder m14167a(String str, String str2, String str3, String str4, int i, SQLiteDatabase sQLiteDatabase) {
        String str5;
        UserBuilder a = new UserBuilder().a(str, str4);
        a.h = str2;
        a = a;
        if (FbPhoneNumberUtils.m14147c(str2)) {
            str5 = "";
        } else {
            NameBucketParamsBuilder nameBucketParamsBuilder = new NameBucketParamsBuilder();
            nameBucketParamsBuilder.f3701b = str2;
            nameBucketParamsBuilder = nameBucketParamsBuilder;
            nameBucketParamsBuilder.f3700a = str2;
            str5 = this.f13288h.m14082a(sQLiteDatabase, nameBucketParamsBuilder.m4156a());
        }
        String str6 = str5;
        if (str6 != null) {
            a.s = str6;
        }
        List arrayList = new ArrayList(1);
        arrayList.add(new UserPhoneNumber(str4, str3, str4, i));
        a.d = arrayList;
        return a;
    }

    private void m14172a(String str, List<User> list) {
        if (FbPhoneNumberUtils.m14147c(str)) {
            String d = this.f13289i.m14152d(str);
            if (!Strings.isNullOrEmpty(d)) {
                String b = this.f13289i.m14151b(d);
                for (User w : list) {
                    if (b.equals(this.f13289i.m14151b(w.w().b))) {
                        return;
                    }
                }
                List arrayList = new ArrayList();
                arrayList.add(new UserPhoneNumber(b, str, d, 7));
                UserBuilder a = new UserBuilder().a(null, d);
                a.h = b;
                a = a;
                a.d = arrayList;
                UserBuilder userBuilder = a;
                userBuilder.t = 99.0f;
                list.add(userBuilder.aa());
            }
        }
    }

    private void m14171a(CallerContext callerContext, int i) {
        if (!this.f13286f.m10496a() && !((Boolean) this.f13287g.get()).booleanValue()) {
            Object obj;
            SmsTakeoverMultiverseExperimentHelper smsTakeoverMultiverseExperimentHelper = this.f13292l;
            if (smsTakeoverMultiverseExperimentHelper.m14213t() || smsTakeoverMultiverseExperimentHelper.m14214u() || smsTakeoverMultiverseExperimentHelper.m14215v()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                String str;
                PrefKey prefKey;
                if (callerContext == CallerContext.SEARCH) {
                    str = "search";
                    prefKey = SmsPrefKeys.f13592o;
                } else if (callerContext == CallerContext.NULL_STATE) {
                    str = "null_state";
                    prefKey = SmsPrefKeys.f13593p;
                } else {
                    str = "people_tab";
                    prefKey = SmsPrefKeys.f13594q;
                }
                if (!(this.f13294n.a(prefKey, false) && this.f13294n.a(SmsPrefKeys.f13595r, false))) {
                    this.f13294n.edit().putBoolean(prefKey, true).putBoolean(SmsPrefKeys.f13595r, true).commit();
                }
                this.f13293m.m14228a(str, i);
            }
        }
    }
}
