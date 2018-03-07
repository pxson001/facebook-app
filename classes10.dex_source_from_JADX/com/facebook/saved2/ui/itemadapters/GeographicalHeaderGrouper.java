package com.facebook.saved2.ui.itemadapters;

import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.saved2.ui.itemadapters.Saved2GroupedItemsAdapterFactory.HeaderGrouper;
import com.facebook.saved2.ui.itemadapters.Saved2HeadersAdapter.Header;
import java.util.ArrayList;

/* compiled from: info_request_type */
public class GeographicalHeaderGrouper implements HeaderGrouper {
    public final ArrayList<Header> mo449a(BaseQueryDAO baseQueryDAO) {
        ArrayList<Header> arrayList = new ArrayList();
        if (baseQueryDAO == null || !baseQueryDAO.a().moveToFirst()) {
            return null;
        }
        Object obj = "";
        baseQueryDAO.a().moveToPosition(-1);
        int i = 0;
        while (baseQueryDAO.a().moveToNext()) {
            CharSequence g = baseQueryDAO.g();
            if (!g.equals(obj)) {
                arrayList.add(new Header(g, arrayList.size() + 1, arrayList.size() + i));
            }
            i++;
            CharSequence charSequence = g;
        }
        return arrayList;
    }
}
