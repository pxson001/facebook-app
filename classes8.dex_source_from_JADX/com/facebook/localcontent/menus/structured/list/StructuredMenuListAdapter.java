package com.facebook.localcontent.menus.structured.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListModels.MenuItemModel;
import com.facebook.widget.listview.SectionedListAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: drag_to_scale_photo */
public class StructuredMenuListAdapter extends SectionedListAdapter {
    public final List<StructuredMenuListSection> f15170c = new ArrayList();
    private final StructuredMenuItemController f15171d;

    /* compiled from: drag_to_scale_photo */
    enum ViewTypes {
        HEADER,
        MENU_ITEM
    }

    protected final /* synthetic */ Object m17602a(int i, int i2) {
        return m17598d(i, i2);
    }

    @Inject
    public StructuredMenuListAdapter(StructuredMenuItemController structuredMenuItemController) {
        this.f15171d = structuredMenuItemController;
    }

    private MenuItemModel m17598d(int i, int i2) {
        return (MenuItemModel) ((StructuredMenuListSection) this.f15170c.get(i)).m17612d().get(i2);
    }

    protected final int m17605c() {
        return this.f15170c.size();
    }

    protected final View m17601a(int i, View view, ViewGroup viewGroup) {
        view = (TextView) view;
        if (view == null) {
            view = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907289, viewGroup, false);
        }
        view.setText(((StructuredMenuListSection) this.f15170c.get(i)).m17608a());
        return view;
    }

    protected final int m17599a(int i) {
        return ViewTypes.HEADER.ordinal();
    }

    protected final Object m17603b(int i) {
        return (StructuredMenuListSection) this.f15170c.get(i);
    }

    protected final int m17606c(int i) {
        return ((StructuredMenuListSection) this.f15170c.get(i)).m17612d().size();
    }

    protected final View m17600a(final int i, final int i2, boolean z, View view, ViewGroup viewGroup) {
        boolean z2;
        if (view == null) {
            view = (ContentViewWithButton) LayoutInflater.from(viewGroup.getContext()).inflate(2130907287, viewGroup, false);
        } else {
            ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        }
        MenuItemModel d = m17598d(i, i2);
        StructuredMenuItemController structuredMenuItemController = this.f15171d;
        C16551 c16551 = new Object(this) {
            final /* synthetic */ StructuredMenuListAdapter f15169c;

            public final void m17597a(MenuItemModel menuItemModel) {
                StructuredMenuListSection structuredMenuListSection = (StructuredMenuListSection) this.f15169c.f15170c.get(i);
                structuredMenuListSection.f15173b.set(i2, menuItemModel);
            }
        };
        if (i2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        structuredMenuItemController.m17596a(view, d, c16551, z2);
        return view;
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    protected final boolean m17604b(int i, int i2) {
        return false;
    }

    protected final int m17607c(int i, int i2) {
        return ViewTypes.MENU_ITEM.ordinal();
    }
}
