package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* compiled from: uses NavigableMap */
class CursorFilter extends Filter {
    CursorFilterClient f432a;

    /* compiled from: uses NavigableMap */
    interface CursorFilterClient {
        Cursor mo168a();

        Cursor mo169a(CharSequence charSequence);

        void mo170a(Cursor cursor);

        CharSequence mo171c(Cursor cursor);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.f432a = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f432a.mo171c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f432a.mo169a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f432a.mo168a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f432a.mo170a((Cursor) filterResults.values);
        }
    }
}
