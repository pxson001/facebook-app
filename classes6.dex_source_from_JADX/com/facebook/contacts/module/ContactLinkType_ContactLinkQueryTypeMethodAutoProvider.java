package com.facebook.contacts.module;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: participants_removed */
public class ContactLinkType_ContactLinkQueryTypeMethodAutoProvider extends AbstractProvider<ContactLinkType> {
    public static ContactLinkType m12113b(InjectorLike injectorLike) {
        return ContactsModule.m12114a(Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    public Object get() {
        return ContactsModule.m12114a(Boolean_IsWorkBuildMethodAutoProvider.a(this));
    }

    public static ContactLinkType m12112a(InjectorLike injectorLike) {
        return m12113b(injectorLike);
    }
}
