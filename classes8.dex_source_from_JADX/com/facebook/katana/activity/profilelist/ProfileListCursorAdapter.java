package com.facebook.katana.activity.profilelist;

import android.database.Cursor;
import com.facebook.katana.activity.profilelist.ProfileListActivity.ProfileListAdapter;
import java.util.Comparator;
import java.util.List;

/* compiled from: unfollowed */
public abstract class ProfileListCursorAdapter extends ProfileListAdapter {
    public Cursor f1207d;
    protected List<Section> f1208e;

    /* compiled from: unfollowed */
    public class Section {
        static Comparator<Section> f1264d = new C01221();
        public final String f1265a;
        protected int f1266b;
        public int f1267c;

        /* compiled from: unfollowed */
        final class C01221 implements Comparator<Section> {
            C01221() {
            }

            public final int compare(Object obj, Object obj2) {
                return ((Section) obj).f1265a.compareTo(((Section) obj2).f1265a);
            }
        }

        public Section(String str, int i, int i2) {
            this.f1265a = str;
            this.f1266b = i;
            this.f1267c = i2;
        }

        public String toString() {
            return this.f1265a;
        }
    }

    public final int m1450c() {
        return this.f1208e.size();
    }

    public final int m1451c(int i) {
        return ((Section) this.f1208e.get(i)).f1267c;
    }

    public final Object m1448b(int i) {
        return this.f1208e.get(i);
    }

    public final boolean m1449b(int i, int i2) {
        return true;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public final int m1447a(int i) {
        return 0;
    }

    public final int m1452c(int i, int i2) {
        return 1;
    }
}
