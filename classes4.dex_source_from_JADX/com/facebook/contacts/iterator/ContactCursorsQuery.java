package com.facebook.contacts.iterator;

import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: getCallLogs */
public class ContactCursorsQuery {
    public Collection<ContactProfileType> f11216a;
    public Collection<ContactLinkType> f11217b;
    public Collection<UserKey> f11218c;
    public String f11219d;
    public boolean f11220e;
    public boolean f11221f;
    public boolean f11222g;
    public boolean f11223h;
    public boolean f11224i;
    public boolean f11225j;
    public SortKey f11226k = SortKey.NO_SORT_ORDER;
    public boolean f11227l;
    public int f11228m = -1;

    /* compiled from: getCallLogs */
    public enum SortKey {
        NO_SORT_ORDER(null),
        NAME("sort_name_key"),
        COMMUNICATION_RANK("communication_rank"),
        WITH_TAGGING_RANK("with_tagging_rank"),
        PHAT_RANK("communication_rank", "phat_rank"),
        ID("_id");
        
        @Nullable
        public final String mLegacyIndexColumnName;
        @Nullable
        public final String mOmnistoreIndexColumnName;

        private SortKey(String str, String str2) {
            this.mLegacyIndexColumnName = str;
            this.mOmnistoreIndexColumnName = str2;
        }

        private SortKey(String str) {
            this.mLegacyIndexColumnName = str;
            this.mOmnistoreIndexColumnName = str;
        }
    }

    public static ContactCursorsQuery m11630a() {
        return new ContactCursorsQuery();
    }

    public static ContactCursorsQuery m11632a(Collection<UserKey> collection) {
        ContactCursorsQuery contactCursorsQuery = new ContactCursorsQuery();
        contactCursorsQuery.f11218c = collection;
        return contactCursorsQuery;
    }

    public static ContactCursorsQuery m11631a(String str) {
        ContactCursorsQuery contactCursorsQuery = new ContactCursorsQuery();
        contactCursorsQuery.f11218c = ImmutableList.of(UserKey.b(str));
        return contactCursorsQuery;
    }

    public static ContactCursorsQuery m11634b(Collection<String> collection) {
        ContactCursorsQuery contactCursorsQuery = new ContactCursorsQuery();
        contactCursorsQuery.f11218c = UserKey.a(collection);
        return contactCursorsQuery;
    }

    public static ContactCursorsQuery m11633a(Collection<ContactProfileType> collection, int i) {
        ContactCursorsQuery a = m11630a();
        a.f11216a = collection;
        a = a;
        a.f11226k = SortKey.COMMUNICATION_RANK;
        a = a;
        a.f11227l = true;
        a = a;
        a.f11228m = i;
        return a;
    }

    public static ContactCursorsQuery m11635b(Collection<ContactProfileType> collection, int i) {
        ContactCursorsQuery a = m11630a();
        a.f11216a = collection;
        a = a;
        a.f11226k = SortKey.PHAT_RANK;
        a = a;
        a.f11227l = true;
        a = a;
        a.f11228m = i;
        return a;
    }

    public static ContactCursorsQuery m11636c(Collection<ContactProfileType> collection, int i) {
        ContactCursorsQuery a = m11630a();
        a.f11216a = collection;
        a = a;
        a.f11226k = SortKey.COMMUNICATION_RANK;
        a = a;
        a.f11227l = true;
        a = a;
        a.f11221f = true;
        a = a;
        a.f11228m = i;
        return a;
    }

    private ContactCursorsQuery() {
    }

    public final ContactCursorsQuery m11642c(Collection<ContactProfileType> collection) {
        this.f11216a = collection;
        return this;
    }

    public final ContactCursorsQuery m11644d(Collection<ContactLinkType> collection) {
        this.f11217b = collection;
        return this;
    }

    public final ContactCursorsQuery m11646e(Collection<UserKey> collection) {
        this.f11218c = collection;
        return this;
    }

    public final ContactCursorsQuery m11640b(String str) {
        this.f11219d = str;
        return this;
    }

    public final ContactCursorsQuery m11639a(boolean z) {
        this.f11220e = z;
        return this;
    }

    public final ContactCursorsQuery m11641b(boolean z) {
        this.f11221f = z;
        return this;
    }

    public final ContactCursorsQuery m11643c(boolean z) {
        this.f11222g = z;
        return this;
    }

    public final ContactCursorsQuery m11645d(boolean z) {
        this.f11223h = z;
        return this;
    }

    public final ContactCursorsQuery m11647e(boolean z) {
        this.f11224i = z;
        return this;
    }

    public final ContactCursorsQuery m11638a(SortKey sortKey) {
        this.f11226k = sortKey;
        return this;
    }

    public final ContactCursorsQuery m11648f(boolean z) {
        this.f11227l = z;
        return this;
    }

    public final ContactCursorsQuery m11637a(int i) {
        this.f11228m = i;
        return this;
    }

    public final ContactCursorsQuery m11649g(boolean z) {
        this.f11225j = z;
        return this;
    }
}
