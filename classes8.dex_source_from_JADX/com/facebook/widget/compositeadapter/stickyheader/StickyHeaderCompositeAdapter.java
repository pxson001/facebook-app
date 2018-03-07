package com.facebook.widget.compositeadapter.stickyheader;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import com.facebook.widget.compositeadapter.CompositeAdapter;
import com.facebook.widget.compositeadapter.CompositeAdapter.Controller;
import com.facebook.widget.compositeadapter.CompositeAdapter.Model;
import com.facebook.widget.compositeadapter.CompositeAdapter.Renderer;
import com.facebook.widget.itemslist.StickyHeaderSectionIndexer;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;

/* compiled from: extra_sport_query_live_page_id */
public class StickyHeaderCompositeAdapter<ITEM_ACTION_TYPES extends Enum> extends CompositeAdapter<ITEM_ACTION_TYPES> implements SectionIndexer, StickyHeaderAdapter {
    private final StickyHeaderSectionIndexer f14290a;

    /* compiled from: extra_sport_query_live_page_id */
    public interface StickyHeaderRenderer extends Renderer {
        int mo863a();

        int mo866b();
    }

    public StickyHeaderCompositeAdapter(Context context, Model model, StickyHeaderSectionIndexer stickyHeaderSectionIndexer, StickyHeaderRenderer stickyHeaderRenderer, Controller<ITEM_ACTION_TYPES> controller) {
        super(context, model, stickyHeaderRenderer, controller);
        this.f14290a = stickyHeaderSectionIndexer;
    }

    public Object[] getSections() {
        return this.f14290a.getSections();
    }

    public int getPositionForSection(int i) {
        return this.f14290a.getPositionForSection(i);
    }

    public int getSectionForPosition(int i) {
        return this.f14290a.getSectionForPosition(i);
    }

    public final View m15894b(int i, View view, ViewGroup viewGroup) {
        if (!this.f14290a.z_(i)) {
            return null;
        }
        View a;
        int positionForSection = getPositionForSection(getSectionForPosition(i));
        int o_ = o_(positionForSection);
        if (view == null) {
            a = a(o_, viewGroup);
        } else {
            a = view;
        }
        a(i, getItem(positionForSection), a, o_, viewGroup);
        return a;
    }

    public final int o_(int i) {
        return getItemViewType(getPositionForSection(getSectionForPosition(i)));
    }

    public final int m15896e(int i) {
        return mo869b().mo863a();
    }

    public final int m15895d() {
        return mo869b().mo866b();
    }

    public final boolean m15897f(int i) {
        return this.f14290a.mo877c(i);
    }

    private StickyHeaderRenderer mo869b() {
        return (StickyHeaderRenderer) this.f14286d;
    }
}
