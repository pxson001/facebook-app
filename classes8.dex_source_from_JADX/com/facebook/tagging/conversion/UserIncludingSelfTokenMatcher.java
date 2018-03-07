package com.facebook.tagging.conversion;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseTokenMatcher;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: maxSlideshowMedia */
public class UserIncludingSelfTokenMatcher implements BaseTokenMatcher {
    protected Set<String> f9116a = Sets.a();
    protected final ContactIterators f9117b;
    protected final DefaultAndroidThreadUtil f9118c;
    private final ContactLinkType f9119d;

    @Inject
    public UserIncludingSelfTokenMatcher(ContactIterators contactIterators, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ContactLinkType contactLinkType) {
        this.f9117b = contactIterators;
        this.f9118c = defaultAndroidThreadUtil;
        this.f9119d = contactLinkType;
    }

    public final void m10895a(String str) {
        m10894b(str);
    }

    private void m10894b(String str) {
        this.f9118c.b();
        this.f9116a.clear();
        ContactIterator a = this.f9117b.a(ContactCursorsQuery.a().b(str).d(ImmutableList.of(ContactLinkType.ME, this.f9119d)).a(SortKey.NAME));
        while (a.hasNext()) {
            try {
                this.f9116a.add(((Contact) a.next()).c());
            } finally {
                a.close();
            }
        }
    }

    public final boolean m10896a(BaseToken baseToken) {
        return baseToken instanceof SimpleUserToken ? this.f9116a.contains(((SimpleUserToken) baseToken).g.b()) : false;
    }
}
