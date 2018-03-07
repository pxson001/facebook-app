package com.facebook.orca.threadview;

import android.content.Context;
import android.database.DataSetObserver;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.animatablelistview.AnimatingListAdapter;
import com.facebook.widget.listview.BetterListView;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: msgr_bball_start */
public class AnimatingListAdapterForMessageList extends AnimatingListAdapter<RowItem> {
    private MessageListAdapterForListView f6856a;

    public AnimatingListAdapterForMessageList(Context context, BetterListView betterListView, MessageListAdapterForListView messageListAdapterForListView, AbstractFbErrorReporter abstractFbErrorReporter, @Nullable AnalyticsTagger analyticsTagger) {
        super(context, betterListView, messageListAdapterForListView, abstractFbErrorReporter, analyticsTagger);
        this.f6856a = messageListAdapterForListView;
    }

    protected final void m6501a(List<RowItem> list) {
        this.f6856a.f7210b.m6888a((List) list);
    }

    public final ImmutableList<RowItem> m6502d() {
        return this.f6856a.m6897a();
    }

    public Object getItem(int i) {
        return this.f6856a.m6896a(i);
    }

    protected final synchronized void m6503h() {
        AdapterDetour.a(this.f6856a, 1769744961);
    }

    protected final synchronized void m6504i() {
        AdapterDetour.b(this.f6856a, -504026486);
    }

    public synchronized void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f6856a.registerDataSetObserver(dataSetObserver);
    }

    public synchronized void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f6856a.unregisterDataSetObserver(dataSetObserver);
    }
}
