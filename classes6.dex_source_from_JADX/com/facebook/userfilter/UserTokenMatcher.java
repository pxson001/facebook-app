package com.facebook.userfilter;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.contacts.module.ContactLinkType_ContactLinkQueryTypeMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseTokenMatcher;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: fbandroid_progressive_jpeg_backtest */
public class UserTokenMatcher implements BaseTokenMatcher {
    protected Set<String> f15153a = new HashSet();
    protected final ContactIterators f15154b;
    protected final DefaultAndroidThreadUtil f15155c;
    private final ContactLinkType f15156d;

    public static UserTokenMatcher m22748b(InjectorLike injectorLike) {
        return new UserTokenMatcher(ContactIterators.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), ContactLinkType_ContactLinkQueryTypeMethodAutoProvider.m12113b(injectorLike));
    }

    @Inject
    public UserTokenMatcher(ContactIterators contactIterators, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ContactLinkType contactLinkType) {
        this.f15154b = contactIterators;
        this.f15155c = defaultAndroidThreadUtil;
        this.f15156d = contactLinkType;
    }

    public void mo1197a(String str) {
        m22751b(str);
    }

    protected final void m22751b(String str) {
        this.f15155c.b();
        this.f15153a.clear();
        ContactIterator a = this.f15154b.a(ContactCursorsQuery.a().b(str).d(ImmutableList.of(this.f15156d)).a(SortKey.NAME));
        while (a.hasNext()) {
            try {
                this.f15153a.add(((Contact) a.next()).c());
            } finally {
                a.close();
            }
        }
    }

    public static UserTokenMatcher m22747a(InjectorLike injectorLike) {
        return m22748b(injectorLike);
    }

    public boolean mo1198a(BaseToken baseToken) {
        return baseToken instanceof SimpleUserToken ? this.f15153a.contains(((SimpleUserToken) baseToken).f20125g.b()) : false;
    }
}
