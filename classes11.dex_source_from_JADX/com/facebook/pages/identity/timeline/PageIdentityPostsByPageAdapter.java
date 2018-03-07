package com.facebook.pages.identity.timeline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.listview.FbBaseAdapter;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: page_identity_unlike_fail */
public class PageIdentityPostsByPageAdapter extends FbBaseAdapter {
    public boolean f4206a;

    public static PageIdentityPostsByPageAdapter m5189a(InjectorLike injectorLike) {
        return new PageIdentityPostsByPageAdapter();
    }

    public int getCount() {
        return this.f4206a ? 1 : 0;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        return view != null ? view : a(0, viewGroup);
    }

    public final View m5190a(int i, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906033, viewGroup, false);
        ((FbTextView) inflate.findViewById(2131565526)).setText(viewGroup.getContext().getResources().getString(2131235427).toUpperCase(Locale.getDefault()));
        return inflate;
    }

    public final void m5191a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
    }
}
