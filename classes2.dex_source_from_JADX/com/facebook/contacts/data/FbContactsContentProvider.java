package com.facebook.contacts.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.i18n.BreakIteratorHelper;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.data.FbContactsContract.ContactsTable;
import com.facebook.contacts.data.FbContactsContract.QueryType;
import com.facebook.contacts.database.ContactsDatabaseSupplier;
import com.facebook.content.SecureContentProvider;
import com.facebook.database.provider.TableMatcher;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.names.NameNormalizer;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;

/* compiled from: zero_rating2/clearable/zero_interstitial_ttl */
public class FbContactsContentProvider extends SecureContentProvider {
    private static final Class<?> f350a = FbContactsContentProvider.class;
    public static final ImmutableMap<String, String> f351b = ImmutableMap.builder().m609b("_id", "_id").m609b("fbid", "fbid").m609b("type", "type").m609b("link_type", "link_type").m609b("communication_rank", "communication_rank").m609b("with_tagging_rank", "with_tagging_rank").m609b("is_messenger_user", "is_messenger_user").m609b("is_on_viewer_contact_list", "is_on_viewer_contact_list").m609b("sort_name_key", "sort_name_key").m609b("phonebook_section_key", "phonebook_section_key").m609b("data", "data").m609b("first_name", "first_name").m609b("last_name", "last_name").m609b("display_name", "display_name").m609b("small_picture_url", "small_picture_url").m609b("big_picture_url", "big_picture_url").m609b("huge_picture_url", "huge_picture_url").m609b("small_picture_size", "small_picture_size").m609b("big_picture_size", "big_picture_size").m609b("huge_picture_size", "huge_picture_size").m609b("is_mobile_pushable", "is_mobile_pushable").m609b("messenger_install_time_ms", "messenger_install_time_ms").m609b("added_time_ms", "added_time_ms").m609b("last_fetch_time_ms", "last_fetch_time_ms").m609b("is_indexed", "is_indexed").m609b("bday_month", "bday_month").m609b("bday_day", "bday_day").m609b("is_partial", "is_partial").m609b("messenger_invite_priority", "messenger_invite_priority").m610b();
    public static final ImmutableMap<String, String> f352c = ImmutableMap.builder().m609b("fbid", "fbid").m609b("display_order", "display_order").m610b();
    public static final ImmutableMap<String, String> f353d = ImmutableMap.builder().m609b("raw_phone_number", "raw_phone_number").m609b("display_order", "display_order").m610b();
    public static final ImmutableMap<FbContactsContract$SearchType, String> f354e = ImmutableMap.builder().m609b(FbContactsContract$SearchType.PHONE_LOCAL, "phone_local").m609b(FbContactsContract$SearchType.PHONE_NATIONAL, "phone_national").m609b(FbContactsContract$SearchType.PHONE_E164, "phone_e164").m609b(FbContactsContract$SearchType.PHONE_VERIFIED, "phone_verified").m610b();
    public ContactsDatabaseSupplier f355f;
    public NameNormalizer f356g;
    public FbContactsContract f357h;
    public BreakIteratorHelper f358i;
    private TableMatcher f359j;
    private ContactsTable f360k;
    private FavoritesTable f361l;
    private SmsFavoritesTable f362m;
    private SearchTable f363n;

    protected final synchronized void mo10a() {
        TracerDetour.a("ContactsContentProvider.onInitialize", 1684832346);
        try {
            InjectorLike injectorLike = FbInjector.get(getContext());
            this.f355f = ContactsDatabaseSupplier.a(injectorLike);
            this.f356g = NameNormalizer.b(injectorLike);
            this.f357h = FbContactsContract.a(injectorLike);
            this.f358i = BreakIteratorHelper.a(injectorLike);
            this.f360k = new ContactsTable(this);
            this.f361l = new FavoritesTable(this);
            this.f362m = new SmsFavoritesTable(this);
            this.f363n = new SearchTable(this);
            this.f359j = new TableMatcher();
            this.f359j.m805a(this.f357h.a, "contacts_with_fbids", this.f360k);
            this.f359j.m805a(this.f357h.a, "favorites", this.f361l);
            this.f359j.m805a(this.f357h.a, "sms_favorites", this.f362m);
            this.f359j.m805a(this.f357h.a, QueryType.CONTACT.searchTableContentPath, this.f363n);
            this.f359j.m805a(this.f357h.a, QueryType.CONTACT.searchTableContentPath + "/", this.f363n);
            this.f359j.m805a(this.f357h.a, QueryType.CONTACT.searchTableContentPath + "/*", this.f363n);
            int i = this.f359j;
            i.m805a(this.f357h.a, QueryType.CONTACT.searchTableContentPath + "/*/*", this.f363n);
            TracerDetour.a(i);
        } finally {
            TracerDetour.a(-223388754);
        }
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, @Nullable String str, String[] strArr2, @Nullable String str2) {
        TracerDetour.a("FbContactsContentProvider.doQuery", -1254528280);
        try {
            Cursor a = this.f359j.m804a(uri).m784a(uri, strArr, str, strArr2, str2);
            return a;
        } finally {
            Long.valueOf(TracerDetour.b(-571451995));
        }
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        if (this.f357h.g.a.equals(uri)) {
            this.f355f.mo2481e();
            return 0;
        }
        throw new UnsupportedOperationException();
    }

    private static String m702a(String str, @Nullable String str2) {
        if (str2 != null && !"_id".equals(str2)) {
            return str;
        }
        if (StringUtil.m3589a((CharSequence) str)) {
            return "is_indexed = 1";
        }
        return str + " AND is_indexed = 1";
    }

    @VisibleForTesting
    final String m718a(String str, String[] strArr, String str2, @Nullable String str3) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Collections.addAll(linkedHashSet, strArr);
        String nullToEmpty = Strings.nullToEmpty(str2);
        Iterator it = f351b.keySet().iterator();
        while (it.hasNext()) {
            String str4 = (String) it.next();
            if (nullToEmpty.contains(str4)) {
                linkedHashSet.add(str4);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("c.internal_id AS _id");
        String a = m703a(str3, stringBuilder, str);
        if (str3 != null) {
            linkedHashSet.remove(str3);
        }
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            m704a((String) it2.next(), stringBuilder);
        }
        return "(SELECT " + stringBuilder + " FROM " + a + ")";
    }

    private static String m701a(@Nullable String str) {
        String nullToEmpty = Strings.nullToEmpty(str);
        Iterator it = f351b.keySet().iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (nullToEmpty.contains(str2)) {
                return str2;
            }
        }
        return null;
    }

    private static void m704a(String str, StringBuilder stringBuilder) {
        if (!"_id".equals(str)) {
            if ("data".equals(str) || "is_indexed".equals(str) || ContactsTable.a.contains(str)) {
                stringBuilder.append(", c.").append(str).append(" AS ").append(str);
                return;
            }
            throw new IllegalArgumentException("Unknown field: " + str);
        }
    }

    private static String m703a(@Nullable String str, StringBuilder stringBuilder, String str2) {
        boolean z = str == null || ContactsTable.b.contains(str);
        Preconditions.checkState(z);
        if (str == null || "_id".equals(str)) {
            return str2 + " AS c ";
        }
        String str3 = (String) f351b.get(str);
        stringBuilder.append(", idx.indexed_data AS ").append(str3);
        return str2 + " AS c INNER JOIN contacts_indexed_data AS idx ON (c.internal_id = idx.contact_internal_id AND " + "idx.type = '" + str3 + "') ";
    }

    protected final String mo8a(Uri uri) {
        throw new UnsupportedOperationException();
    }

    protected final Uri mo7a(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
