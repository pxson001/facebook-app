package com.facebook.contacts.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.contacts.database.ContactSerialization;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.ContactDatabaseCursorIterator;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.contacts.provider.ContactsConnectionsContract.Selectors;
import com.facebook.content.SecureContentProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.user.names.NameNormalizer;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

@Deprecated
/* compiled from: zero_upsell_buy */
public class ContactsConnectionsProvider extends SecureContentProvider {
    private static final UriMatcher f294a = new UriMatcher(-1);
    private ContactIterators f295b;
    private ContactSerialization f296c;
    private NameNormalizer f297d;

    static {
        for (Selectors selectors : Selectors.values()) {
            f294a.addURI(ContactsConnectionsContract.f298a, selectors.getMatcherPartialUri(), selectors.uriMatcherIndex());
        }
    }

    protected final void mo10a() {
        super.mo10a();
        InjectorLike injectorLike = FbInjector.get(getContext());
        this.f295b = ContactIterators.a(injectorLike);
        this.f296c = ContactSerialization.a(injectorLike);
        this.f297d = NameNormalizer.b(injectorLike);
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    protected final String mo8a(Uri uri) {
        if (f294a.match(uri) > 0) {
            return "vnd.android.cursor.item/vnd.com.facebook.katana.provider.contacts";
        }
        throw new IllegalArgumentException("Unknown URL " + uri);
    }

    protected final Uri mo7a(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    private ContactIterator m596a(ContactLinkType contactLinkType) {
        ContactIterators contactIterators = this.f295b;
        ContactCursorsQuery a = ContactCursorsQuery.a();
        a.b = ImmutableList.of(contactLinkType);
        a = a;
        a.k = SortKey.NAME;
        return contactIterators.a(a);
    }

    private ContactIterator m597a(ImmutableList<ContactLinkType> immutableList, String str) {
        ContactIterators contactIterators = this.f295b;
        ContactCursorsQuery a = ContactCursorsQuery.a(str);
        a.b = immutableList;
        return contactIterators.a(a);
    }

    private ContactIterator m598b(ImmutableList<ContactLinkType> immutableList, String str) {
        ContactIterators contactIterators = this.f295b;
        ContactCursorsQuery a = ContactCursorsQuery.a();
        a.d = str;
        a = a;
        a.b = immutableList;
        a = a;
        a.k = SortKey.NAME;
        return contactIterators.a(a);
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ContactIterator a;
        m57c();
        int match = f294a.match(uri);
        if (match == Selectors.CONTACTS_CONTENT.uriMatcherIndex()) {
            ContactIterators contactIterators = this.f295b;
            ContactCursorsQuery a2 = ContactCursorsQuery.a();
            a2.b = ContactLinkType.CONNECTIONS;
            a = contactIterators.a(a2);
        } else if (match == Selectors.CONTACT_ID.uriMatcherIndex()) {
            a = m597a(ContactLinkType.CONNECTIONS, (String) uri.getPathSegments().get(2));
        } else if (match == Selectors.FRIENDS_CONTENT.uriMatcherIndex()) {
            a = m596a(ContactLinkType.FRIEND);
        } else if (match == Selectors.FRIEND_UID.uriMatcherIndex()) {
            a = m597a(ContactLinkType.FRIENDS, (String) uri.getPathSegments().get(2));
        } else if (match == Selectors.FRIENDS_PREFIX_SEARCH.uriMatcherIndex()) {
            a = m598b(ContactLinkType.FRIENDS, (String) uri.getPathSegments().get(2));
        } else if (match == Selectors.PAGES_CONTENT.uriMatcherIndex()) {
            a = m596a(ContactLinkType.PAGE);
        } else if (match == Selectors.PAGE_ID.uriMatcherIndex()) {
            a = m597a(ContactLinkType.PAGES, (String) uri.getPathSegments().get(2));
        } else if (match == Selectors.PAGES_SEARCH.uriMatcherIndex()) {
            a = m598b(ContactLinkType.PAGES, (String) uri.getPathSegments().get(2));
        } else {
            throw new IllegalArgumentException("Unknown URL " + uri);
        }
        Preconditions.checkState(a instanceof ContactDatabaseCursorIterator, "ContactsConnectionProvider only supports ContactDatabaseCursorIterator.");
        return new ContactsConnectionsCursor(((ContactDatabaseCursorIterator) a).c, this.f296c, this.f297d);
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
