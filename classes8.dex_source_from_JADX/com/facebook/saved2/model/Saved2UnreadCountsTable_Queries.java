package com.facebook.saved2.model;

import android.database.Cursor;
import com.facebook.crudolib.dao.AbstractDAOItem;
import com.facebook.crudolib.dao.DAOItem;
import com.facebook.crudolib.dbquery.QueryProvider;
import com.facebook.crudolib.sqliteproc.BaseModel_Queries.BaseQueryDAO;

/* compiled from: normalizedBounds */
public final class Saved2UnreadCountsTable_Queries {

    /* compiled from: normalizedBounds */
    public class BaseQueryDAOImpl extends AbstractDAOItem implements BaseQueryDAO {
        public BaseQueryDAOImpl(Cursor cursor) {
            super(cursor);
        }

        public final long m8238d() {
            return this.a.getLong(0);
        }

        public final String m8239e() {
            return this.a.getString(1);
        }
    }

    /* compiled from: normalizedBounds */
    public final class BaseQueryProvider implements QueryProvider<BaseQueryDAO> {
        public final Object[] m8241a() {
            return new Object[]{Saved2UnreadCountsTable.class};
        }

        public final Object[] m8242b() {
            r0 = new Object[5];
            r0[1] = new String[]{"_id", "section_name", "unread_count"};
            r0[2] = null;
            r0[3] = null;
            r0[4] = null;
            return r0;
        }

        public final DAOItem m8240a(Cursor cursor) {
            return new BaseQueryDAOImpl(cursor);
        }
    }
}
