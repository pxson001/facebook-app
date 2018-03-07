package com.facebook.contacts.properties;

import com.facebook.contacts.database.ContactsDatabaseSupplier;
import com.facebook.database.properties.DbPropertyUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: maxImpressions */
public class DbContactsPropertyUtil extends DbPropertyUtil<DbContactsPropertyKey> {
    public static DbContactsPropertyUtil m8548b(InjectorLike injectorLike) {
        return new DbContactsPropertyUtil(ContactsDatabaseSupplier.m8560a(injectorLike));
    }

    @Inject
    public DbContactsPropertyUtil(ContactsDatabaseSupplier contactsDatabaseSupplier) {
        super(contactsDatabaseSupplier, "contacts_db_properties");
    }

    public static DbContactsPropertyUtil m8547a(InjectorLike injectorLike) {
        return m8548b(injectorLike);
    }
}
