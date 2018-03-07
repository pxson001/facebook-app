package com.facebook.fbui.viewdescriptionbuilder.viewspecs;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilderSpec;

/* compiled from: XOUT */
public class ListViewDescriptionSpec implements ViewDescriptionBuilderSpec<ListView> {
    public final void mo1226a(Object obj, Bundle bundle) {
        ListAdapter adapter = ((ListView) obj).getAdapter();
        bundle.putString("list_adapter_class", adapter == null ? "null" : adapter.getClass().getName());
    }

    public final Class<ListView> mo1225a() {
        return ListView.class;
    }
}
