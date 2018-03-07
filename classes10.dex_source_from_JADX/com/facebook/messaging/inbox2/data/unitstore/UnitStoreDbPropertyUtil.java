package com.facebook.messaging.inbox2.data.unitstore;

import com.facebook.database.properties.DbPropertyUtil;
import javax.inject.Inject;

/* compiled from: sending reply failed */
public class UnitStoreDbPropertyUtil extends DbPropertyUtil<UnitStorePropertyKey> {
    @Inject
    public UnitStoreDbPropertyUtil(UnitStoreDatabaseSupplier unitStoreDatabaseSupplier) {
        super(unitStoreDatabaseSupplier, "properties");
    }
}
