package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;

/* compiled from: uses_remarketing */
public abstract class CursorAdapter extends BaseAdapter implements CursorFilterClient, Filterable {
    public boolean f423a;
    public boolean f424b;
    public Cursor f425c;
    protected Context f426d;
    protected int f427e;
    protected ChangeObserver f428f;
    protected DataSetObserver f429g;
    protected CursorFilter f430h;
    protected FilterQueryProvider f431i;

    /* compiled from: uses_remarketing */
    class ChangeObserver extends ContentObserver {
        final /* synthetic */ CursorAdapter f421a;

        public ChangeObserver(CursorAdapter cursorAdapter) {
            this.f421a = cursorAdapter;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            CursorAdapter cursorAdapter = this.f421a;
            if (cursorAdapter.f424b && cursorAdapter.f425c != null && !cursorAdapter.f425c.isClosed()) {
                cursorAdapter.f423a = cursorAdapter.f425c.requery();
            }
        }
    }

    /* compiled from: uses_remarketing */
    class MyDataSetObserver extends DataSetObserver {
        final /* synthetic */ CursorAdapter f422a;

        public MyDataSetObserver(CursorAdapter cursorAdapter) {
            this.f422a = cursorAdapter;
        }

        public void onChanged() {
            this.f422a.f423a = true;
            AdapterDetour.a(this.f422a, 691766719);
        }

        public void onInvalidated() {
            this.f422a.f423a = false;
            AdapterDetour.b(this.f422a, -680324825);
        }
    }

    public abstract View mo193a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void mo450a(View view, Cursor cursor);

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        m858a(context, cursor, z ? 1 : 2);
    }

    public CursorAdapter(Context context, Cursor cursor, int i) {
        m858a(context, cursor, i);
    }

    private void m858a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f424b = true;
        } else {
            this.f424b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f425c = cursor;
        this.f423a = z;
        this.f426d = context;
        this.f427e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f428f = new ChangeObserver(this);
            this.f429g = new MyDataSetObserver(this);
        } else {
            this.f428f = null;
            this.f429g = null;
        }
        if (z) {
            if (this.f428f != null) {
                cursor.registerContentObserver(this.f428f);
            }
            if (this.f429g != null) {
                cursor.registerDataSetObserver(this.f429g);
            }
        }
    }

    public final Cursor mo168a() {
        return this.f425c;
    }

    public int getCount() {
        if (!this.f423a || this.f425c == null) {
            return 0;
        }
        return this.f425c.getCount();
    }

    public Object getItem(int i) {
        if (!this.f423a || this.f425c == null) {
            return null;
        }
        this.f425c.moveToPosition(i);
        return this.f425c;
    }

    public long getItemId(int i) {
        if (this.f423a && this.f425c != null && this.f425c.moveToPosition(i)) {
            return this.f425c.getLong(this.f427e);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f423a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f425c.moveToPosition(i)) {
            if (view == null) {
                view = mo193a(this.f426d, this.f425c, viewGroup);
            }
            mo450a(view, this.f425c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f423a) {
            return null;
        }
        this.f425c.moveToPosition(i);
        if (view == null) {
            view = mo194b(this.f426d, this.f425c, viewGroup);
        }
        mo450a(view, this.f425c);
        return view;
    }

    public View mo194b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo193a(context, cursor, viewGroup);
    }

    public void mo170a(Cursor cursor) {
        Cursor b = m864b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public Cursor m864b(Cursor cursor) {
        if (cursor == this.f425c) {
            return null;
        }
        Cursor cursor2 = this.f425c;
        if (cursor2 != null) {
            if (this.f428f != null) {
                cursor2.unregisterContentObserver(this.f428f);
            }
            if (this.f429g != null) {
                cursor2.unregisterDataSetObserver(this.f429g);
            }
        }
        this.f425c = cursor;
        if (cursor != null) {
            if (this.f428f != null) {
                cursor.registerContentObserver(this.f428f);
            }
            if (this.f429g != null) {
                cursor.registerDataSetObserver(this.f429g);
            }
            this.f427e = cursor.getColumnIndexOrThrow("_id");
            this.f423a = true;
            AdapterDetour.a(this, -2050286803);
            return cursor2;
        }
        this.f427e = -1;
        this.f423a = false;
        AdapterDetour.b(this, -1436252149);
        return cursor2;
    }

    public CharSequence mo171c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor mo169a(CharSequence charSequence) {
        if (this.f431i != null) {
            return this.f431i.runQuery(charSequence);
        }
        return this.f425c;
    }

    public Filter getFilter() {
        if (this.f430h == null) {
            this.f430h = new CursorFilter(this);
        }
        return this.f430h;
    }
}
