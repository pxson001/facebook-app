package android.support.v4.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.LayoutInflater.Filter;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: window_type */
public class ChildFragmentLayoutInflator extends LayoutInflater {
    private static final String[] f58a = new String[]{"android.widget.", "android.webkit."};
    private LayoutInflater f59b;
    private Fragment f60c;

    public ChildFragmentLayoutInflator(LayoutInflater layoutInflater, Fragment fragment) {
        super(layoutInflater.getContext());
        this.f59b = layoutInflater;
        this.f60c = fragment;
    }

    public LayoutInflater cloneInContext(Context context) {
        return new ChildFragmentLayoutInflator(this.f59b.cloneInContext(context), this.f60c);
    }

    public Context getContext() {
        return this.f59b.getContext();
    }

    public void setFactory(Factory factory) {
        super.setFactory(factory);
        this.f59b.setFactory(factory);
    }

    public void setFactory2(Factory2 factory2) {
        super.setFactory2(factory2);
        this.f59b.setFactory2(factory2);
    }

    public Filter getFilter() {
        return this.f59b.getFilter();
    }

    public void setFilter(Filter filter) {
        super.setFilter(filter);
        this.f59b.setFilter(filter);
    }

    protected View onCreateView(String str, AttributeSet attributeSet) {
        String[] strArr = f58a;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                View createView = this.f59b.createView(str, strArr[i], attributeSet);
                if (createView != null) {
                    return createView;
                }
                i++;
            } catch (ClassNotFoundException e) {
            }
        }
        return super.onCreateView(str, attributeSet);
    }

    public View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        FragmentHost fragmentHost = this.f60c.E;
        FragmentManager r = fragmentHost.r();
        fragmentHost.a(this.f60c.s());
        View inflate = this.f59b.inflate(xmlPullParser, viewGroup, z);
        fragmentHost.a(r);
        return inflate;
    }
}
