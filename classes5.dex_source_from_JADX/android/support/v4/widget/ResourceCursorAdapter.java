package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: user_fundraiser_page */
public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int f507j;
    private int f508k;
    private LayoutInflater f509l;

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f508k = i;
        this.f507j = i;
        this.f509l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View mo193a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f509l.inflate(this.f507j, viewGroup, false);
    }

    public final View mo194b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f509l.inflate(this.f508k, viewGroup, false);
    }
}
