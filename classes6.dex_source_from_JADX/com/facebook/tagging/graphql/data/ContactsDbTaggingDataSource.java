package com.facebook.tagging.graphql.data;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.contacts.module.ContactLinkType_ContactLinkQueryTypeMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.tagging.shared.FamilyTagTypeaheadUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tagging.abtest.ExperimentsForTaggingABTestModule;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.TagTypeaheadDataSource.TagTypeaheadDataType;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@UserScoped
/* compiled from: destination is null; perhaps no accessible storage is available. */
public class ContactsDbTaggingDataSource extends TagTypeaheadDataSource {
    private static final Object f17404g = new Object();
    private final ContactIterators f17405a;
    private final ImmutableList<ContactLinkType> f17406b;
    private final TaggingProfiles f17407c;
    private final QeAccessor f17408d;
    public final FamilyTagTypeaheadUtil f17409e;
    private Lazy<FbErrorReporter> f17410f;

    /* compiled from: destination is null; perhaps no accessible storage is available. */
    public /* synthetic */ class C12671 {
        public static final /* synthetic */ int[] f17403a = new int[ContactProfileType.values().length];

        static {
            try {
                f17403a[ContactProfileType.USER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17403a[ContactProfileType.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static ContactsDbTaggingDataSource m25229b(InjectorLike injectorLike) {
        return new ContactsDbTaggingDataSource(ContactIterators.a(injectorLike), TaggingProfiles.m25203b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FamilyTagTypeaheadUtil.m20957a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), ContactLinkType_ContactLinkQueryTypeMethodAutoProvider.m12113b(injectorLike));
    }

    @Inject
    public ContactsDbTaggingDataSource(ContactIterators contactIterators, TaggingProfiles taggingProfiles, QeAccessor qeAccessor, FamilyTagTypeaheadUtil familyTagTypeaheadUtil, Lazy<FbErrorReporter> lazy, ContactLinkType contactLinkType) {
        this.f17405a = contactIterators;
        this.f17407c = taggingProfiles;
        this.f17408d = qeAccessor;
        this.f17409e = familyTagTypeaheadUtil;
        this.f17410f = lazy;
        this.f17406b = ImmutableList.of(contactLinkType, ContactLinkType.PAGE, ContactLinkType.ME, ContactLinkType.UNMATCHED);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.tagging.graphql.data.ContactsDbTaggingDataSource m25225a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f17404g;	 Catch:{ all -> 0x006c }
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
        r1 = m25229b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17404g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.tagging.graphql.data.ContactsDbTaggingDataSource) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.tagging.graphql.data.ContactsDbTaggingDataSource) r0;	 Catch:{  }
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
        r0 = f17404g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.tagging.graphql.data.ContactsDbTaggingDataSource) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tagging.graphql.data.ContactsDbTaggingDataSource.a(com.facebook.inject.InjectorLike):com.facebook.tagging.graphql.data.ContactsDbTaggingDataSource");
    }

    private ContactCursorsQuery m25224a(CharSequence charSequence, int i, String str, boolean z) {
        ContactCursorsQuery a = ContactCursorsQuery.a();
        a.d = charSequence.toString();
        a = a;
        a.b = this.f17406b;
        a = a;
        a.k = SortKey.NAME;
        a = a;
        a.m = i;
        a = a;
        if (str.equals("communication_rank")) {
            if (z) {
                a.j = true;
            } else {
                a.k = SortKey.COMMUNICATION_RANK;
                a.l = true;
            }
        }
        return a;
    }

    private List<TaggingProfile> m25230b(CharSequence charSequence, int i, String str, boolean z) {
        Lists.a();
        ContactIterator contactIterator = null;
        try {
            contactIterator = this.f17405a.a(m25224a(charSequence, i, str, z));
            List<TaggingProfile> a = m25227a(contactIterator, "contacts_db", TagTypeaheadDataType.FRIENDS.toString());
            return a;
        } finally {
            if (contactIterator != null) {
                contactIterator.close();
            }
        }
    }

    public final List<TaggingProfile> mo1318a(CharSequence charSequence, boolean z, boolean z2, boolean z3, boolean z4) {
        List a = Lists.a();
        if (charSequence == null) {
            return a;
        }
        int a2 = this.f17408d.a(ExperimentsForTaggingABTestModule.f17307f, 1000);
        String a3 = this.f17408d.a(ExperimentsForTaggingABTestModule.f17311j, "");
        List b = m25230b(charSequence, a2, a3, false);
        if (!a3.equals("") && b.size() < a2) {
            b.addAll(m25230b(charSequence, a2 - b.size(), a3, true));
        }
        CharSequence toLowerCase = charSequence.toString().toLowerCase();
        List a4 = this.f17409e.m20961a();
        if (!(a4 == null || a4.isEmpty())) {
            for (int i = 0; i < a4.size(); i++) {
                if (((TaggingProfile) a4.get(i)).f17543f.contains(toLowerCase)) {
                    b.add(a4.get(i));
                }
            }
        }
        if (z4) {
            b.add(m25226a(charSequence));
        }
        return m25228a(b, z, z2, z3, z4);
    }

    public final String mo1316b() {
        return "contacts_db";
    }

    public final ImmutableList<String> mo1319d() {
        Builder builder = new Builder();
        builder.c(TagTypeaheadDataType.FRIENDS.toString());
        return builder.b();
    }

    private static List<TaggingProfile> m25228a(List<TaggingProfile> list, boolean z, boolean z2, boolean z3, boolean z4) {
        List<TaggingProfile> a = Lists.a();
        for (TaggingProfile taggingProfile : list) {
            if ((z || taggingProfile.f17542e != Type.SELF) && ((z2 || taggingProfile.f17542e != Type.USER) && ((z3 || taggingProfile.f17542e != Type.PAGE) && (z4 || taggingProfile.f17542e != Type.TEXT)))) {
                a.add(taggingProfile);
            }
        }
        return a;
    }

    private ArrayList<TaggingProfile> m25227a(ContactIterator contactIterator, String str, String str2) {
        ArrayList<TaggingProfile> arrayList = new ArrayList();
        if (contactIterator == null) {
            return arrayList;
        }
        while (contactIterator.hasNext()) {
            Type type;
            Contact contact = (Contact) contactIterator.next();
            TaggingProfiles taggingProfiles = this.f17407c;
            Name e = contact.e();
            long parseLong = Long.parseLong(contact.c());
            String g = contact.g();
            switch (C12671.f17403a[contact.A().ordinal()]) {
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
            arrayList.add(taggingProfiles.m25206a(e, parseLong, g, type, str, str2));
        }
        return arrayList;
    }

    private TaggingProfile m25226a(CharSequence charSequence) {
        return this.f17407c.m25206a(new Name(null, null, charSequence.toString()), -1, null, Type.TEXT, "", "");
    }
}
