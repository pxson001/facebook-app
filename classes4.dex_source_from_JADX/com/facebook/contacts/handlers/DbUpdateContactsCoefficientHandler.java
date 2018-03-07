package com.facebook.contacts.handlers;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactBuilder;
import com.facebook.contacts.graphql.ContactGraphQLInterfaces.ContactCoefficient;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactCoefficientModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactCoefficientModel.RepresentedProfileModel;
import com.facebook.contacts.handlers.DbInsertContactHandler.InsertionType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: retry_millis */
public class DbUpdateContactsCoefficientHandler {
    private static final Class<?> f3367a = DbUpdateContactsCoefficientHandler.class;
    private final ContactIterators f3368b;
    private final DbInsertContactHandler f3369c;

    public static DbUpdateContactsCoefficientHandler m3601b(InjectorLike injectorLike) {
        return new DbUpdateContactsCoefficientHandler(ContactIterators.m3605a(injectorLike), DbInsertContactHandler.m3505a(injectorLike));
    }

    @Inject
    public DbUpdateContactsCoefficientHandler(ContactIterators contactIterators, DbInsertContactHandler dbInsertContactHandler) {
        this.f3368b = contactIterators;
        this.f3369c = dbInsertContactHandler;
    }

    public final void m3604a(ImmutableList<? extends ContactCoefficient> immutableList) {
        Preconditions.checkNotNull(immutableList);
        TracerDetour.a("updateContactsCoefficientInDatabase (%d contacts)", Integer.valueOf(immutableList.size()), -1834520086);
        int i = 0;
        while (i < immutableList.size()) {
            try {
                int min = Math.min(i + 20, immutableList.size());
                m3602b(immutableList.subList(i, min));
                i = min;
            } finally {
                TracerDetour.a(872584972);
            }
        }
    }

    private void m3602b(ImmutableList<? extends ContactCoefficient> immutableList) {
        Map c = m3603c(immutableList);
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ContactCoefficientModel contactCoefficientModel = (ContactCoefficientModel) immutableList.get(i);
            RepresentedProfileModel c2 = contactCoefficientModel.c();
            String b = contactCoefficientModel.b();
            if (c.containsKey(b)) {
                float b2 = (c2 == null || b == null) ? 0.0f : (float) c2.b();
                ContactBuilder contactBuilder = new ContactBuilder((Contact) c.get(b));
                contactBuilder.f3653o = b2;
                builder.c(contactBuilder.m4092P());
            }
        }
        this.f3369c.m3515a(builder.b(), InsertionType.REPLACE, null);
    }

    private Map<String, Contact> m3603c(ImmutableList<? extends ContactCoefficient> immutableList) {
        Throwable th;
        Preconditions.checkNotNull(immutableList);
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            RepresentedProfileModel c = ((ContactCoefficientModel) immutableList.get(i)).c();
            if (c != null) {
                String c2 = c.c();
                if (c2 != null) {
                    builder.c(c2);
                }
            }
        }
        Collection b = builder.b();
        Map<String, Contact> hashMap = new HashMap(b.size());
        ContactIterator a = this.f3368b.m3607a(ContactCursorsQuery.m11634b(b));
        Throwable th2 = null;
        while (a.hasNext()) {
            try {
                Contact contact = (Contact) a.next();
                hashMap.put(contact.m4067b(), contact);
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
        }
        if (a != null) {
            a.close();
        }
        b.size();
        return hashMap;
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }
}
