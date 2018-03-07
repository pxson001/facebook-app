package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* compiled from: num_faceboxes_and_tags */
public class NestedScrollingChildHelper {
    private final View f11967a;
    private ViewParent f11968b;
    public boolean f11969c;
    private int[] f11970d;

    public NestedScrollingChildHelper(View view) {
        this.f11967a = view;
    }

    public final void m17658a(boolean z) {
        if (this.f11969c) {
            ViewCompat.f6441a.mo1581E(this.f11967a);
        }
        this.f11969c = z;
    }

    public final boolean m17659a() {
        return this.f11969c;
    }

    public final boolean m17660a(float f, float f2) {
        if (!this.f11969c || this.f11968b == null) {
            return false;
        }
        return ViewParentCompat.a.a(this.f11968b, this.f11967a, f, f2);
    }

    public final boolean m17661a(float f, float f2, boolean z) {
        if (!this.f11969c || this.f11968b == null) {
            return false;
        }
        return ViewParentCompat.a.a(this.f11968b, this.f11967a, f, f2, z);
    }

    public final boolean m17665b() {
        return this.f11968b != null;
    }

    public final boolean m17662a(int i) {
        if (m17665b()) {
            return true;
        }
        if (this.f11969c) {
            View view = this.f11967a;
            for (ViewParent parent = this.f11967a.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.a.a(parent, view, this.f11967a, i)) {
                    this.f11968b = parent;
                    ViewParentCompat.a.b(parent, view, this.f11967a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public final void m17666c() {
        if (this.f11968b != null) {
            ViewParentCompat.a.a(this.f11968b, this.f11967a);
            this.f11968b = null;
        }
    }

    public final boolean m17663a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m17659a() || this.f11968b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f11967a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            ViewParentCompat.a(this.f11968b, this.f11967a, i, i2, i3, i4);
            if (iArr != null) {
                this.f11967a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public final boolean m17664a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!this.f11969c || this.f11968b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f11967a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f11970d == null) {
                    this.f11970d = new int[2];
                }
                iArr = this.f11970d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ViewParentCompat.a(this.f11968b, this.f11967a, i, i2, iArr);
            if (iArr2 != null) {
                this.f11967a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }
}
