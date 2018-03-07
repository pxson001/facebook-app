package com.facebook.privacy.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.edit.EditPrivacyFragment.C10092;
import com.facebook.privacy.model.ContentPrivacyOptionsResult;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListAdapter;
import com.facebook.widget.listview.SectionedListSection;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: mIsDiskRecordingEnabled */
public class PrivacyOptionsAdapter extends SectionedListAdapter {
    protected final LayoutInflater f11077c;
    protected List<SectionedListSection<GraphQLPrivacyOption>> f11078d = RegularImmutableList.a;
    private final Context f11079e;
    public C10092 f11080f;
    public OnClickListener f11081g;
    public GraphQLPrivacyOption f11082h;

    /* compiled from: mIsDiskRecordingEnabled */
    public class C10711 implements OnClickListener {
        final /* synthetic */ PrivacyOptionsAdapter f15336a;

        public C10711(PrivacyOptionsAdapter privacyOptionsAdapter) {
            this.f15336a = privacyOptionsAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1124796305);
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) view.getTag();
            if (graphQLPrivacyOption != null) {
                this.f15336a.f11080f.m22589a(graphQLPrivacyOption, graphQLPrivacyOption.equals(this.f15336a.f11082h));
                this.f15336a.f11082h = graphQLPrivacyOption;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1676831475, a);
        }
    }

    public PrivacyOptionsAdapter(Context context, LayoutInflater layoutInflater) {
        this.f11079e = (Context) Preconditions.checkNotNull(context);
        this.f11077c = (LayoutInflater) Preconditions.checkNotNull(layoutInflater);
    }

    public void mo1066a(ContentPrivacyOptionsResult contentPrivacyOptionsResult) {
        m17819a(contentPrivacyOptionsResult, null);
    }

    private void m17819a(ContentPrivacyOptionsResult contentPrivacyOptionsResult, GraphQLPrivacyOption graphQLPrivacyOption) {
        Builder builder = ImmutableList.builder();
        builder.c(new ImmutableSectionedListSection(this.f11079e.getString(2131234235), ImmutableList.copyOf(contentPrivacyOptionsResult.f15071a)));
        SectionedListSection immutableSectionedListSection = new ImmutableSectionedListSection(this.f11079e.getString(2131234236), ImmutableList.copyOf(contentPrivacyOptionsResult.f15072b));
        if (!immutableSectionedListSection.mo434b().isEmpty()) {
            builder.c(immutableSectionedListSection);
        }
        this.f11078d = builder.b();
        if (this.f11082h == null) {
            if (graphQLPrivacyOption == null) {
                graphQLPrivacyOption = contentPrivacyOptionsResult.f15073c;
            }
            this.f11082h = graphQLPrivacyOption;
        }
        AdapterDetour.a(this, -1133990849);
    }

    public final int mo1063c() {
        return this.f11078d.size();
    }

    public final int mo1064c(int i) {
        return ((SectionedListSection) this.f11078d.get(i)).mo434b().size();
    }

    public final Object mo1060b(int i) {
        return this.f11078d.get(i);
    }

    public final Object mo1059a(int i, int i2) {
        return ((SectionedListSection) this.f11078d.get(i)).mo434b().get(i2);
    }

    public View mo1058a(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.f11077c.inflate(2130903955, null);
        } else {
            inflate = view;
        }
        ((TextView) inflate).setText(((ImmutableSectionedListSection) mo1060b(i)).mo432a());
        return inflate;
    }

    public View mo1057a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View privacyOptionRowView;
        if (view == null) {
            privacyOptionRowView = new PrivacyOptionRowView(this.f11079e);
        } else {
            privacyOptionRowView = view;
        }
        GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) mo1059a(i, i2);
        ((PrivacyOptionRowView) privacyOptionRowView).m22960a(graphQLPrivacyOption, graphQLPrivacyOption.equals(this.f11082h));
        privacyOptionRowView.setTag(graphQLPrivacyOption);
        privacyOptionRowView.setOnClickListener(this.f11081g);
        return privacyOptionRowView;
    }

    public final boolean mo1062b(int i, int i2) {
        return true;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public final int mo1056a(int i) {
        return 0;
    }

    public final int mo1065c(int i, int i2) {
        return 1;
    }

    public final boolean mo1061b() {
        return this.f11078d.isEmpty();
    }
}
