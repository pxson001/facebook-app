package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileTypes;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileTypesSetProvider;
import com.facebook.contacts.pictures.ContactPictureSizes;
import com.facebook.contacts.pictures.ContactPictureSizes.Size;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: rtc_data_channel */
public class ContactsGraphQlParams {
    private final ContactPictureSizes f3279a;
    private final ContactProfileTypes f3280b;

    public static ContactsGraphQlParams m3484b(InjectorLike injectorLike) {
        return new ContactsGraphQlParams(ContactPictureSizes.m14161a(injectorLike), ContactProfileTypes.m3497a(injectorLike));
    }

    @Inject
    public ContactsGraphQlParams(ContactPictureSizes contactPictureSizes, ContactProfileTypes contactProfileTypes) {
        this.f3279a = contactPictureSizes;
        this.f3280b = contactProfileTypes;
    }

    public final void m3485a(GraphQlQueryString graphQlQueryString) {
        graphQlQueryString.a("small_img_size", this.f3279a.m14165b(Size.SMALL));
        graphQlQueryString.a("big_img_size", this.f3279a.m14165b(Size.BIG));
        graphQlQueryString.a("huge_img_size", this.f3279a.m14165b(Size.HUGE));
    }

    public final void m3486b(GraphQlQueryString graphQlQueryString) {
        String str = "profile_types";
        ContactProfileTypes contactProfileTypes = this.f3280b;
        if (contactProfileTypes.f3288a == null) {
            Builder builder = ImmutableSet.builder();
            for (ContactProfileTypesSetProvider a : contactProfileTypes.f3289c) {
                Iterator it = a.mo271a().iterator();
                while (it.hasNext()) {
                    ContactProfileType contactProfileType = (ContactProfileType) it.next();
                    if (contactProfileType == ContactProfileType.UNMATCHED) {
                        BLog.b(ContactProfileTypes.f3286b, "Requesting UNMATCHED profile types not allowed");
                    } else {
                        builder.c(contactProfileType.getGraphQlParamValue());
                    }
                }
            }
            contactProfileTypes.f3288a = builder.b().asList();
        }
        graphQlQueryString.a(str, contactProfileTypes.f3288a);
    }
}
