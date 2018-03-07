package com.facebook.widget.sectionedadapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.sectionedadapter.SectionedAdapterController.Observer;
import com.facebook.widget.sectionedadapter.SectionedAdapterController.Section;
import com.facebook.widget.sectionedadapter.SectionedAdapterController.ViewTypeLookUpResult;
import com.google.common.collect.ImmutableList;

/* compiled from: trans_source_text */
public class SectionedAdapterForListView extends FbBaseAdapter {
    private final SectionedAdapterController<SectionAdapter> f16162a;

    /* compiled from: trans_source_text */
    public abstract class SectionAdapter extends FbBaseAdapter implements Section {
        public final void mo57a(final Observer observer) {
            super.registerDataSetObserver(new DataSetObserver(this) {
                final /* synthetic */ SectionAdapter f16161b;

                public void onChanged() {
                    observer.mo1239a();
                }
            });
        }
    }

    /* compiled from: trans_source_text */
    class C12741 extends Observer {
        final /* synthetic */ SectionedAdapterForListView f16159a;

        C12741(SectionedAdapterForListView sectionedAdapterForListView) {
            this.f16159a = sectionedAdapterForListView;
        }

        public final void mo1239a() {
            super.mo1239a();
            AdapterDetour.a(this.f16159a, -1076726209);
        }
    }

    public SectionedAdapterForListView(ImmutableList<SectionAdapter> immutableList) {
        this(immutableList, null);
    }

    private SectionedAdapterForListView(ImmutableList<SectionAdapter> immutableList, SectionAdapter sectionAdapter) {
        this(immutableList, sectionAdapter, false);
    }

    private SectionedAdapterForListView(ImmutableList<SectionAdapter> immutableList, SectionAdapter sectionAdapter, boolean z) {
        this.f16162a = z ? SectionedAdapterController.m20187a(immutableList, sectionAdapter) : new SectionedAdapterController(immutableList, sectionAdapter);
        this.f16162a.f16150c = new C12741(this);
    }

    public final View m20197a(int i, ViewGroup viewGroup) {
        ViewTypeLookUpResult a = this.f16162a.m20191a(i);
        return ((SectionAdapter) a.f16146b).a(a.f16145a, viewGroup);
    }

    public final void m20198a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ViewTypeLookUpResult a = this.f16162a.m20191a(i2);
        ((SectionAdapter) a.f16146b).a(i, obj, view, a.f16145a, viewGroup);
    }

    public int getCount() {
        return this.f16162a.m20190a();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public Object getItem(int i) {
        return this.f16162a.m20195d(i);
    }

    public int getItemViewType(int i) {
        return this.f16162a.m20194c(i);
    }

    public int getViewTypeCount() {
        return this.f16162a.m20192b();
    }
}
