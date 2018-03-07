package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.Loader.ForceLoadContentObserver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* compiled from: voice_switcher_pages */
public class CursorLoader extends AsyncTaskLoader<Cursor> {
    final ForceLoadContentObserver f213f = new ForceLoadContentObserver(this);
    Uri f214g;
    String[] f215h;
    String f216i;
    String[] f217j;
    String f218k;
    Cursor f219l;

    public final void m223a(Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public final /* synthetic */ void m225b(Object obj) {
        m222a((Cursor) obj);
    }

    public /* synthetic */ Object m226d() {
        return m227f();
    }

    public CursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f214g = uri;
        this.f215h = strArr;
        this.f216i = str;
        this.f217j = strArr2;
        this.f218k = str2;
    }

    public Cursor m227f() {
        Cursor query = this.o.getContentResolver().query(this.f214g, this.f215h, this.f216i, this.f217j, this.f218k);
        if (query != null) {
            query.getCount();
            query.registerContentObserver(this.f213f);
        }
        return query;
    }

    protected final void m228g() {
        if (this.f219l != null) {
            m222a(this.f219l);
        }
        if (t() || this.f219l == null) {
            a();
        }
    }

    protected final void m229h() {
        b();
    }

    protected final void m230i() {
        super.i();
        m229h();
        if (!(this.f219l == null || this.f219l.isClosed())) {
            this.f219l.close();
        }
        this.f219l = null;
    }

    private void m222a(Cursor cursor) {
        if (!this.r) {
            Cursor cursor2 = this.f219l;
            this.f219l = cursor;
            if (this.p) {
                super.b(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public final void m224a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f214g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f215h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f216i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f217j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f218k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f219l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.s);
    }
}
