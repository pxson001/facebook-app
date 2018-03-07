package com.facebook.saved2.ui;

import com.facebook.saved2.model.Saved2UnreadCountsTable_Queries.BaseQueryDAOImpl;

/* compiled from: instant_shopping_catalog_id */
public class FindSectionUtil {
    private FindSectionUtil() {
    }

    public static int m9717a(BaseQueryDAOImpl baseQueryDAOImpl, String str) {
        baseQueryDAOImpl.a().moveToPosition(-1);
        while (baseQueryDAOImpl.a().moveToNext()) {
            if (str.equals(baseQueryDAOImpl.e())) {
                return baseQueryDAOImpl.b();
            }
        }
        return -1;
    }
}
