package com.facebook.account.recovery.ui;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.account.recovery.model.AccountCandidateModel;
import com.facebook.account.recovery.model.AccountSearchListItem;
import com.facebook.account.recovery.model.AccountSearchListItemType;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: linksPreviewParams */
public class AccountCandidateListAdapter extends BaseAdapter implements StickyHeaderAdapter {
    private final Resources f10330a;
    public List<AccountSearchListItem> f10331b = Lists.a();
    private int f10332c = 0;

    @Inject
    public AccountCandidateListAdapter(Resources resources) {
        this.f10330a = resources;
    }

    public int getCount() {
        return this.f10331b.size();
    }

    public Object getItem(int i) {
        return this.f10331b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return ((AccountSearchListItem) this.f10331b.get(i)).mo678j().ordinal();
    }

    public int getViewTypeCount() {
        return AccountSearchListItemType.values().length;
    }

    public boolean isEnabled(int i) {
        return ((AccountSearchListItem) this.f10331b.get(i)).mo679k();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        AccountSearchListItem accountSearchListItem = (AccountSearchListItem) getItem(i);
        switch (accountSearchListItem.mo678j()) {
            case HEADER:
                View a = m12121a(view, viewGroup);
                a.setText(2131239697);
                return a;
            case CANDIDATE:
                ContentView b = m12122b(view, viewGroup);
                AccountCandidateModel accountCandidateModel = (AccountCandidateModel) accountSearchListItem;
                b.setThumbnailSize(ThumbnailSize.MEDIUM);
                b.setThumbnailUri(accountCandidateModel.m12090b());
                b.setTitleText(accountCandidateModel.m12091c());
                b.setSubtitleText(accountCandidateModel.m12092d());
                b.setMetaText(null);
                return b;
            case NOT_IN_LIST:
                return m12123c(view, viewGroup);
            default:
                throw new IllegalStateException("Unexpected type");
        }
    }

    public final View m12125b(int i, View view, ViewGroup viewGroup) {
        View a = m12121a(view, viewGroup);
        a.setText(2131239697);
        if (this.f10332c == 0) {
            a.setLayoutParams(new LayoutParams(-1, -2));
            a.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            this.f10332c = a.getMeasuredHeight();
        }
        return a;
    }

    public final int o_(int i) {
        return 0;
    }

    public final int m12127e(int i) {
        return this.f10332c;
    }

    public final int m12126d() {
        return this.f10330a.getColor(2131361920);
    }

    public final boolean m12128f(int i) {
        return false;
    }

    private static TextView m12121a(View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130903066, viewGroup, false);
        } else {
            inflate = view;
        }
        return (TextView) inflate;
    }

    private static ContentView m12122b(View view, ViewGroup viewGroup) {
        return view == null ? new ContentView(viewGroup.getContext()) : (ContentView) view;
    }

    private static View m12123c(View view, ViewGroup viewGroup) {
        if (view == null) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(2130903071, viewGroup, false);
        }
        return view;
    }

    public final void m12124a() {
        this.f10331b.clear();
        AdapterDetour.a(this, -1384374002);
    }
}
