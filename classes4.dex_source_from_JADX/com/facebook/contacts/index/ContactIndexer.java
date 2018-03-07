package com.facebook.contacts.index;

import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactPhone;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.phonenumbers.NumberParseException;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;
import com.facebook.user.module.UserNameUtil;
import com.facebook.user.names.ContactNameLookupBuilder;
import com.facebook.user.names.NameNormalizer;
import com.facebook.user.names.Normalizer;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: rich_notifications_enabled */
public class ContactIndexer {
    private final UserNameUtil f3332a;
    public final NameNormalizer f3333b;
    private final Provider<ContactNameLookupBuilder> f3334c;
    private final PhoneNumberUtil f3335d;

    /* compiled from: rich_notifications_enabled */
    public interface IndexWriter {
        void mo293a(String str, float f);

        void mo294a(String str, String str2);
    }

    public static ContactIndexer m3566b(InjectorLike injectorLike) {
        return new ContactIndexer(UserNameUtil.m10377a(injectorLike), NameNormalizer.m11653b(injectorLike), IdBasedProvider.a(injectorLike, 3603), PhoneNumberUtilMethodAutoProvider.m14153a(injectorLike));
    }

    @Inject
    public ContactIndexer(UserNameUtil userNameUtil, Normalizer normalizer, Provider<ContactNameLookupBuilder> provider, PhoneNumberUtil phoneNumberUtil) {
        this.f3332a = userNameUtil;
        this.f3333b = normalizer;
        this.f3334c = provider;
        this.f3335d = phoneNumberUtil;
    }

    public final void m3570a(Contact contact, IndexWriter indexWriter) {
        m3567c(contact, indexWriter);
        m3568d(contact, indexWriter);
        m3569e(contact, indexWriter);
        float m = contact.m4078m();
        if (m > 0.0f) {
            indexWriter.mo293a("communication_rank", m);
        }
        m = contact.m4079n();
        if (m > 0.0f) {
            indexWriter.mo293a("with_tagging_rank", m);
        }
        m = contact.m4063K();
        if (m > 0.0f) {
            indexWriter.mo293a("phat_rank", m);
        }
        String L = contact.m4064L();
        if (L != null) {
            indexWriter.mo294a("username", this.f3333b.m11655a(L));
        }
    }

    public final void m3571b(Contact contact, IndexWriter indexWriter) {
        m3567c(contact, indexWriter);
        m3568d(contact, indexWriter);
    }

    private void m3567c(Contact contact, IndexWriter indexWriter) {
        String a = UserNameUtil.m10378a(contact.m4070e(), contact.m4071f());
        if (a != null) {
            indexWriter.mo294a("sort_name_key", this.f3333b.m11655a(a));
        }
    }

    private void m3568d(Contact contact, IndexWriter indexWriter) {
        ContactNameLookupBuilder contactNameLookupBuilder = (ContactNameLookupBuilder) this.f3334c.get();
        contactNameLookupBuilder.m4203a(contact.m4070e());
        contactNameLookupBuilder.m4203a(contact.m4071f());
        contactNameLookupBuilder.m4204a(contact.m4091z());
        for (String a : contactNameLookupBuilder.f3757f) {
            indexWriter.mo294a("name", a);
        }
    }

    private void m3569e(Contact contact, IndexWriter indexWriter) {
        ImmutableList o = contact.m4080o();
        int size = o.size();
        for (int i = 0; i < size; i++) {
            ContactPhone contactPhone = (ContactPhone) o.get(i);
            try {
                PhoneNumber parse = this.f3335d.parse(contactPhone.d(), null);
                indexWriter.mo294a("phone_e164", this.f3335d.format(parse, PhoneNumberFormat.E164));
                String nationalSignificantNumber = this.f3335d.getNationalSignificantNumber(parse);
                indexWriter.mo294a("phone_national", nationalSignificantNumber);
                int lengthOfGeographicalAreaCode = this.f3335d.getLengthOfGeographicalAreaCode(parse);
                if (lengthOfGeographicalAreaCode > 0) {
                    indexWriter.mo294a("phone_local", nationalSignificantNumber.substring(lengthOfGeographicalAreaCode));
                }
                if (contactPhone.e()) {
                    indexWriter.mo294a("phone_verified", contactPhone.d());
                }
            } catch (NumberParseException e) {
            }
        }
    }
}
