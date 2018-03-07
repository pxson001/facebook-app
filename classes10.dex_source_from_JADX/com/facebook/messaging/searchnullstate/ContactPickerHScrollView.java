package com.facebook.messaging.searchnullstate;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: refreshZeroToken */
public class ContactPickerHScrollView extends CustomFrameLayout {
    @Inject
    public ContactPickerHScrollViewAdapter f3825a;
    public RecyclerView f3826b = ((RecyclerView) c(2131560745));
    public boolean f3827c;

    public static void m3606a(Object obj, Context context) {
        ((ContactPickerHScrollView) obj).f3825a = new ContactPickerHScrollViewAdapter(LayoutInflaterMethodAutoProvider.b(FbInjector.get(context)));
    }

    public ContactPickerHScrollView(Context context) {
        super(context);
        Class cls = ContactPickerHScrollView.class;
        m3606a(this, getContext());
        setContentView(2130905653);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.b(0);
        this.f3826b.setLayoutManager(linearLayoutManager);
        this.f3826b.setAdapter(this.f3825a);
    }
}
