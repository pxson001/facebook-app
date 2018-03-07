package com.facebook.search.bootstrap.db.data;

import com.facebook.database.properties.DbPropertyUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: extensible_message_admin_text */
public class BootstrapDbPropertyUtil extends DbPropertyUtil<BootstrapDbPropertyKey> {
    public static BootstrapDbPropertyUtil m23411b(InjectorLike injectorLike) {
        return new BootstrapDbPropertyUtil(BootstrapDatabaseSupplier.m23374a(injectorLike));
    }

    @Inject
    public BootstrapDbPropertyUtil(BootstrapDatabaseSupplier bootstrapDatabaseSupplier) {
        super(bootstrapDatabaseSupplier, "bootstrap_db_properties");
    }
}
