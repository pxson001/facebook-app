package com.facebook.events.invite;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.widget.listview.SectionedListAdapter;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.ViewFactory;
import java.util.Collections;
import java.util.List;

/* compiled from: char */
public class InviteeReviewListViewAdapter extends SectionedListAdapter {
    private ViewFactory f17748c = new InviteePickerRowViewFactory();
    public List<EventInviteeToken> f17749d = Collections.emptyList();
    public List<SectionedListSection<EventInviteeToken>> f17750e = Collections.emptyList();

    /* compiled from: char */
    enum RowType {
        HEADER,
        SUBTITLED_ITEM
    }

    protected final int m18091c() {
        return this.f17750e.size();
    }

    protected final View m18087a(int i, View view, ViewGroup viewGroup) {
        return new View(viewGroup.getContext());
    }

    protected final int m18085a(int i) {
        return RowType.HEADER.ordinal();
    }

    protected final Object m18089b(int i) {
        return this.f17750e.get(i);
    }

    protected final int m18092c(int i) {
        return ((SectionedListSection) this.f17750e.get(i)).b().size();
    }

    protected final Object m18088a(int i, int i2) {
        if (i2 < ((SectionedListSection) this.f17750e.get(i)).b().size()) {
            return ((SectionedListSection) this.f17750e.get(i)).b().get(i2);
        }
        return null;
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public final View m18086a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f17748c.b(viewGroup);
        }
        BaseToken baseToken = (BaseToken) m18088a(i, i2);
        if (baseToken != null) {
            this.f17748c.b(view, baseToken, this.f17749d.contains(baseToken));
        }
        return view;
    }

    protected final boolean m18090b(int i, int i2) {
        return true;
    }

    protected final int m18093c(int i, int i2) {
        return RowType.SUBTITLED_ITEM.ordinal();
    }
}
