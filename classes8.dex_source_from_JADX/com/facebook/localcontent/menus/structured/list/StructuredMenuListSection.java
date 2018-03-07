package com.facebook.localcontent.menus.structured.list;

import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListModels.MenuItemModel;
import com.facebook.widget.listview.SectionedListSection;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: draft_load_attempts */
public class StructuredMenuListSection implements SectionedListSection<MenuItemModel> {
    private final String f15172a;
    public final ArrayList<MenuItemModel> f15173b = new ArrayList();

    public final /* synthetic */ List m17610b() {
        return m17612d();
    }

    public StructuredMenuListSection(String str, ImmutableList<MenuItemModel> immutableList) {
        this.f15172a = str;
        this.f15173b.addAll(immutableList);
    }

    public final ImmutableList<MenuItemModel> m17612d() {
        return ImmutableList.copyOf(this.f15173b);
    }

    public final String m17608a() {
        return this.f15172a;
    }

    public final boolean m17611c() {
        return false;
    }

    public final void m17609a(boolean z) {
    }

    public final boolean m17613f() {
        return false;
    }
}
