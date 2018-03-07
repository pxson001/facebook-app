package com.facebook.negativefeedback.ui.messagecomposer;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.contacts.data.FbContactsContract.SearchType;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.inject.InjectorLike;
import com.facebook.tagging.data.TagTypeaheadDataSource.TagTypeaheadDataType;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import javax.inject.Inject;

@UserScoped
/* compiled from: node_ids */
public class ContactsDbMessageRecipientDataSource {
    private static final Object f8107c = new Object();
    private final ContactIterators f8108a;
    private final TaggingProfiles f8109b;

    /* compiled from: node_ids */
    public /* synthetic */ class C06511 {
        public static final /* synthetic */ int[] f8106a = new int[ContactProfileType.values().length];

        static {
            try {
                f8106a[ContactProfileType.USER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8106a[ContactProfileType.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static ContactsDbMessageRecipientDataSource m9764b(InjectorLike injectorLike) {
        return new ContactsDbMessageRecipientDataSource(ContactIterators.a(injectorLike), TaggingProfiles.b(injectorLike));
    }

    @Inject
    public ContactsDbMessageRecipientDataSource(ContactIterators contactIterators, TaggingProfiles taggingProfiles) {
        this.f8108a = contactIterators;
        this.f8109b = taggingProfiles;
    }

    private static ContactCursorsQuery m9763b(CharSequence charSequence) {
        ContactCursorsQuery a = ContactCursorsQuery.a();
        a.d = charSequence.toString();
        a = a;
        a.b = ContactLinkType.FRIENDS;
        a = a;
        a.k = SortKey.COMMUNICATION_RANK;
        a = a;
        a.l = true;
        return a;
    }

    private List<TaggingProfile> m9765c(CharSequence charSequence) {
        Lists.a();
        ContactIterator contactIterator = null;
        try {
            contactIterator = this.f8108a.a(m9763b(charSequence), EnumSet.of(SearchType.NAME));
            List<TaggingProfile> a = m9762a(contactIterator, "contacts_db");
            return a;
        } finally {
            if (contactIterator != null) {
                contactIterator.close();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.negativefeedback.ui.messagecomposer.ContactsDbMessageRecipientDataSource m9761a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f8107c;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m9764b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f8107c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.negativefeedback.ui.messagecomposer.ContactsDbMessageRecipientDataSource) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.negativefeedback.ui.messagecomposer.ContactsDbMessageRecipientDataSource) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f8107c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.negativefeedback.ui.messagecomposer.ContactsDbMessageRecipientDataSource) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.negativefeedback.ui.messagecomposer.ContactsDbMessageRecipientDataSource.a(com.facebook.inject.InjectorLike):com.facebook.negativefeedback.ui.messagecomposer.ContactsDbMessageRecipientDataSource");
    }

    public final List<TaggingProfile> m9766a(CharSequence charSequence) {
        List a = Lists.a();
        if (charSequence == null) {
            return a;
        }
        return m9765c(charSequence);
    }

    private ArrayList<TaggingProfile> m9762a(ContactIterator contactIterator, String str) {
        ArrayList<TaggingProfile> arrayList = new ArrayList();
        if (contactIterator == null) {
            return arrayList;
        }
        while (contactIterator.hasNext()) {
            Type type;
            Contact contact = (Contact) contactIterator.next();
            TaggingProfiles taggingProfiles = this.f8109b;
            Name e = contact.e();
            long parseLong = Long.parseLong(contact.c());
            String g = contact.g();
            switch (C06511.f8106a[contact.A().ordinal()]) {
                case 1:
                    type = Type.USER;
                    break;
                case 2:
                    type = Type.PAGE;
                    break;
                default:
                    type = Type.UNKNOWN;
                    break;
            }
            arrayList.add(taggingProfiles.a(e, parseLong, g, type, str, TagTypeaheadDataType.FRIENDS.toString()));
        }
        return arrayList;
    }
}
