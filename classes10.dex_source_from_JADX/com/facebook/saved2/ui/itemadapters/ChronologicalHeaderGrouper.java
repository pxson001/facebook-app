package com.facebook.saved2.ui.itemadapters;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.StringRes;
import com.facebook.common.preconditions.Preconditions;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.saved2.ui.itemadapters.Saved2GroupedItemsAdapterFactory.HeaderGrouper;
import com.facebook.saved2.ui.itemadapters.Saved2HeadersAdapter.Header;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: initial_bio_text */
public class ChronologicalHeaderGrouper implements HeaderGrouper {
    private final Context f9584a;
    private final TimeGroup[] f9585b;

    /* compiled from: initial_bio_text */
    class TimeGroup {
        public final int f9582a;
        public final long f9583b;

        public TimeGroup(@StringRes int i, long j) {
            this.f9582a = i;
            this.f9583b = j;
        }
    }

    public ChronologicalHeaderGrouper(Context context, long j) {
        this.f9584a = context;
        this.f9585b = new TimeGroup[]{new TimeGroup(2131241568, j - TimeUnit.DAYS.toMillis(1)), new TimeGroup(2131241569, j - TimeUnit.DAYS.toMillis(7)), new TimeGroup(2131241570, (((j - TimeUnit.DAYS.toMillis(30)) - TimeUnit.HOURS.toMillis(9)) - TimeUnit.MINUTES.toMillis(50)) - TimeUnit.SECONDS.toMillis(24)), new TimeGroup(2131241571, Long.MAX_VALUE)};
    }

    @Nullable
    protected final ArrayList<Header> m9841a(BaseQueryDAO baseQueryDAO, Cursor cursor, int i, int i2) {
        Preconditions.b(i2 <= cursor.getCount() - i);
        ArrayList<Header> arrayList = new ArrayList();
        if (!baseQueryDAO.a().moveToFirst()) {
            return arrayList;
        }
        ListIterator listIterator = Arrays.asList(this.f9585b).listIterator();
        TimeGroup timeGroup = null;
        int i3 = -1;
        int i4 = 0;
        while (i3 < this.f9585b.length - 1 && i4 < i2 && cursor.moveToPosition(i + i4)) {
            long e = baseQueryDAO.e();
            if (timeGroup == null || e < timeGroup.f9583b) {
                while (true) {
                    if (timeGroup == null || (e < timeGroup.f9583b && r1 < this.f9585b.length - 1)) {
                        i3 = listIterator.nextIndex();
                        timeGroup = (TimeGroup) listIterator.next();
                    }
                }
                arrayList.add(new Header(this.f9584a.getString(timeGroup.f9582a), arrayList.size() + 1, arrayList.size() + i4));
            }
            i4++;
        }
        return arrayList;
    }

    @Nullable
    public ArrayList<Header> mo449a(BaseQueryDAO baseQueryDAO) {
        Cursor a = baseQueryDAO.a();
        return m9841a(baseQueryDAO, a, 0, a.getCount());
    }
}
