package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.facebook.inject.Assisted;
import com.facebook.widget.text.BetterTextView;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Upload method  */
public class AdInterfacesSpinnerAdapter extends ArrayAdapter<SpinnerAdapterItem> {
    private List<SpinnerAdapterItem> f22952a;
    private LayoutInflater f22953b;

    /* compiled from: Upload method  */
    public class SpinnerAdapterItem {
        public String f22949a;
        public String f22950b;
        public String f22951c;

        public SpinnerAdapterItem(String str, String str2, String str3) {
            this.f22949a = str;
            this.f22950b = str2;
            this.f22951c = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SpinnerAdapterItem spinnerAdapterItem = (SpinnerAdapterItem) obj;
            if (this.f22951c == null ? spinnerAdapterItem.f22951c != null : !this.f22951c.equals(spinnerAdapterItem.f22951c)) {
                return false;
            }
            if (this.f22950b == null ? spinnerAdapterItem.f22950b != null : !this.f22950b.equals(spinnerAdapterItem.f22950b)) {
                return false;
            }
            if (this.f22949a != null) {
                if (this.f22949a.equals(spinnerAdapterItem.f22949a)) {
                    return true;
                }
            } else if (spinnerAdapterItem.f22949a == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i = 0;
            if (this.f22949a != null) {
                hashCode = this.f22949a.hashCode();
            } else {
                hashCode = 0;
            }
            int i2 = hashCode * 31;
            if (this.f22950b != null) {
                hashCode = this.f22950b.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode = (hashCode + i2) * 31;
            if (this.f22951c != null) {
                i = this.f22951c.hashCode();
            }
            return hashCode + i;
        }
    }

    @Inject
    public AdInterfacesSpinnerAdapter(Context context, @Assisted List<SpinnerAdapterItem> list) {
        super(context, 0, list);
        this.f22952a = list;
        this.f22953b = LayoutInflater.from(context);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new AdInterfacesSpinnerItemView(getContext());
        } else {
            AdInterfacesSpinnerItemView adInterfacesSpinnerItemView = (AdInterfacesSpinnerItemView) view;
        }
        SpinnerAdapterItem spinnerAdapterItem = (SpinnerAdapterItem) getItem(i);
        String str = spinnerAdapterItem.f22949a;
        String str2 = spinnerAdapterItem.f22950b;
        view.f22954a.setText(str);
        if (str2 == null) {
            view.f22955b.setVisibility(8);
        } else {
            view.f22955b.setText(str2);
        }
        return view;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f22953b.inflate(2130903098, viewGroup, false);
        }
        ((BetterTextView) view.findViewById(2131559247)).setText(((SpinnerAdapterItem) this.f22952a.get(i)).f22951c);
        return view;
    }
}
