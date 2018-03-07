package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: reaction_hover */
public abstract class PagerAdapter {
    private DataSetObservable f8056a = new DataSetObservable();

    public abstract boolean mo1716a(View view, Object obj);

    public abstract int mo1711b();

    public void mo1715a(ViewGroup viewGroup) {
    }

    public Object mo1714a(ViewGroup viewGroup, int i) {
        return m12648a((View) viewGroup, i);
    }

    public void mo1710a(ViewGroup viewGroup, int i, Object obj) {
        m12646d();
    }

    public void mo1717b(ViewGroup viewGroup, int i, Object obj) {
        m12652a((View) viewGroup, i, obj);
    }

    public void mo1712b(ViewGroup viewGroup) {
    }

    public Object m12648a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    private static void m12646d() {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void m12652a(View view, int i, Object obj) {
    }

    public Parcelable gG_() {
        return null;
    }

    public void mo1709a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int mo1707a(Object obj) {
        return -1;
    }

    public void kR_() {
        this.f8056a.notifyChanged();
    }

    public final void m12650a(DataSetObserver dataSetObserver) {
        this.f8056a.registerObserver(dataSetObserver);
    }

    public final void m12657b(DataSetObserver dataSetObserver) {
        this.f8056a.unregisterObserver(dataSetObserver);
    }

    public CharSequence J_(int i) {
        return null;
    }

    public float m12660d(int i) {
        return 1.0f;
    }
}
