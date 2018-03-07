package com.facebook.privacy.selector;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.contacts.module.ContactLinkType_ContactLinkQueryTypeMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.model.PrivacyToken;
import com.facebook.userfilter.UserTokenMatcher;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: fb4a_feed */
public class PrivacyTokenMatcher extends UserTokenMatcher {
    private String f15250d;

    public static PrivacyTokenMatcher m22908c(InjectorLike injectorLike) {
        return new PrivacyTokenMatcher(ContactIterators.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), ContactLinkType_ContactLinkQueryTypeMethodAutoProvider.m12113b(injectorLike));
    }

    @Inject
    public PrivacyTokenMatcher(ContactIterators contactIterators, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ContactLinkType contactLinkType) {
        super(contactIterators, defaultAndroidThreadUtil, contactLinkType);
    }

    public final void mo1197a(String str) {
        this.f15250d = str;
        m22751b(str);
    }

    public final boolean mo1198a(BaseToken baseToken) {
        if (!(baseToken instanceof PrivacyToken)) {
            return false;
        }
        String a = StringLocaleUtil.a(baseToken.mo1185b());
        CharSequence a2 = StringLocaleUtil.a(this.f15250d);
        if (Strings.isNullOrEmpty(a) || !a.contains(a2)) {
            return false;
        }
        return true;
    }
}
