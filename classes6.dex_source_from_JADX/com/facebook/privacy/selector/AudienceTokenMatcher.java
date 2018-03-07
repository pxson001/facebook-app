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
import com.facebook.widget.tokenizedtypeahead.model.SimpleFriendlistToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: fb_video */
public class AudienceTokenMatcher extends UserTokenMatcher {
    private String f15157d;

    public static AudienceTokenMatcher m22752c(InjectorLike injectorLike) {
        return new AudienceTokenMatcher(ContactIterators.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), ContactLinkType_ContactLinkQueryTypeMethodAutoProvider.m12113b(injectorLike));
    }

    @Inject
    public AudienceTokenMatcher(ContactIterators contactIterators, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ContactLinkType contactLinkType) {
        super(contactIterators, defaultAndroidThreadUtil, contactLinkType);
    }

    public final void mo1197a(String str) {
        this.f15157d = str;
        m22751b(str);
    }

    public final boolean mo1198a(BaseToken baseToken) {
        if (baseToken instanceof SimpleUserToken) {
            return this.f15153a.contains(((SimpleUserToken) baseToken).f20125g.b());
        }
        if (!(baseToken instanceof SimpleFriendlistToken) && !(baseToken instanceof PrivacyToken)) {
            return false;
        }
        String a = StringLocaleUtil.a(baseToken.mo1185b());
        if (Strings.isNullOrEmpty(a) || !a.startsWith(StringLocaleUtil.a(this.f15157d))) {
            return false;
        }
        return true;
    }
}
