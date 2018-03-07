package android.support.v4.content;

import android.content.Context;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: super_local_sharing_holdout_2016_h1 */
public class Loader<D> {
    public int f3825m;
    OnLoadCompleteListener<D> f3826n;
    public Context f3827o;
    public boolean f3828p = false;
    public boolean f3829q = false;
    public boolean f3830r = true;
    public boolean f3831s = false;
    public boolean f3832t = false;

    /* compiled from: super_local_sharing_holdout_2016_h1 */
    public interface OnLoadCompleteListener<D> {
        void mo881a(Loader<D> loader, D d);
    }

    public Loader(Context context) {
        this.f3827o = context.getApplicationContext();
    }

    public void m6371b(D d) {
        if (this.f3826n != null) {
            this.f3826n.mo881a(this, d);
        }
    }

    public final void m6368a(int i, OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f3826n != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f3826n = onLoadCompleteListener;
        this.f3825m = i;
    }

    public final void m6369a(OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f3826n == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f3826n != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f3826n = null;
        }
    }

    public void m6372g() {
    }

    public void m6367a() {
    }

    public void m6373h() {
    }

    public final void m6375r() {
        this.f3829q = true;
    }

    public final void m6376s() {
        m6374i();
        this.f3830r = true;
        this.f3828p = false;
        this.f3829q = false;
        this.f3831s = false;
        this.f3832t = false;
    }

    protected void m6374i() {
    }

    public final boolean m6377t() {
        boolean z = this.f3831s;
        this.f3831s = false;
        this.f3832t |= z;
        return z;
    }

    public final void m6378u() {
        this.f3832t = false;
    }

    public final void m6379w() {
        if (this.f3828p) {
            m6367a();
        } else {
            this.f3831s = true;
        }
    }

    public static String m6366c(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.m13772a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.m13772a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f3825m);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m6370a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f3825m);
        printWriter.print(" mListener=");
        printWriter.println(this.f3826n);
        if (this.f3828p || this.f3831s || this.f3832t) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f3828p);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f3831s);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f3832t);
        }
        if (this.f3829q || this.f3830r) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f3829q);
            printWriter.print(" mReset=");
            printWriter.println(this.f3830r);
        }
    }
}
