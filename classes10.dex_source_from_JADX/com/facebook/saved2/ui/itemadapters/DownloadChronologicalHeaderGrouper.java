package com.facebook.saved2.ui.itemadapters;

import android.content.Context;
import android.database.Cursor;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.saved2.ui.itemadapters.Saved2HeadersAdapter.Header;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: informational nux does not have selected privacy option */
public class DownloadChronologicalHeaderGrouper extends ChronologicalHeaderGrouper {
    private final Context f9586a;
    private final int f9587b = 1;
    private final Saved2DownloadItemsHelper f9588c;

    public DownloadChronologicalHeaderGrouper(Context context, long j, Saved2DownloadItemsHelper saved2DownloadItemsHelper) {
        super(context, j);
        this.f9588c = saved2DownloadItemsHelper;
        this.f9586a = context;
    }

    @Nullable
    public final ArrayList<Header> mo449a(BaseQueryDAO baseQueryDAO) {
        Cursor cursor = this.f9588c.f9625c;
        if (cursor == null) {
            cursor = baseQueryDAO.a();
        }
        int i = this.f9588c.f9624b;
        ArrayList<Header> a = super.m9841a(baseQueryDAO, cursor, i, cursor.getCount() - i);
        if (i == 0) {
            return a;
        }
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Header header = (Header) a.get(i2);
            header.f9636c = (header.f9636c + 1) + i;
        }
        a.add(0, new Header(this.f9586a.getString(2131241572), a.size() + 1, 0));
        return a;
    }
}
