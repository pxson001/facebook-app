package com.facebook.composer.minutiae;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLInterfaces.MinutiaeTaggableSuggestions;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.MinutiaeTaggableSuggestionsModel;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration;
import com.facebook.composer.minutiae.view.MinutiaeBaseRowView;
import com.facebook.composer.minutiae.view.MinutiaeObjectRowView;
import com.facebook.composer.minutiae.view.MinutiaeTaggableObjectViewController;
import com.facebook.composer.minutiae.view.MinutiaeTaggableObjectViewController.SuggestionCallback;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.sectionedadapter.SectionedAdapterForListView.SectionAdapter;
import com.google.common.collect.ImmutableList;

/* compiled from: trans_language */
public class MinutiaeSuggestionAdapter extends SectionAdapter {
    private final Context f1342a;
    private final SuggestionCallback f1343b;
    private final MinutiaeTaggableObjectViewController f1344c = new MinutiaeTaggableObjectViewController();
    private final ActivityPickerAnalyticsLogger f1345d;
    private final MinutiaeConfiguration f1346e;
    private ImmutableList<? extends MinutiaeTaggableSuggestions> f1347f;
    public ImmutableList<? extends MinutiaeTaggableSuggestions> f1348g = null;
    public boolean f1349h = false;

    public MinutiaeSuggestionAdapter(Context context, MinutiaeConfiguration minutiaeConfiguration, ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger, SuggestionCallback suggestionCallback) {
        this.f1342a = context;
        this.f1346e = minutiaeConfiguration;
        this.f1343b = suggestionCallback;
        this.f1345d = activityPickerAnalyticsLogger;
    }

    public final void m1429a(ImmutableList<? extends MinutiaeTaggableSuggestions> immutableList) {
        this.f1347f = immutableList;
        AdapterDetour.a(this, 442006750);
    }

    private boolean m1423b() {
        return (m1424c() == null || m1424c().isEmpty()) ? false : true;
    }

    private ImmutableList<? extends MinutiaeTaggableSuggestions> m1424c() {
        if (this.f1349h) {
            return null;
        }
        return this.f1347f;
    }

    public final void m1427a() {
        if (this.f1348g != null) {
            m1429a(this.f1348g);
            this.f1348g = null;
        }
    }

    public final View m1426a(int i, ViewGroup viewGroup) {
        return new MinutiaeObjectRowView(this.f1342a);
    }

    public final void m1428a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        this.f1344c.m1845a((MinutiaeBaseRowView) view, (MinutiaeTaggableSuggestionsModel) obj, this.f1343b);
    }

    public int getCount() {
        return m1423b() ? m1424c().size() : 0;
    }

    public Object getItem(int i) {
        return (!m1423b() || i >= getCount()) ? null : (MinutiaeTaggableSuggestionsModel) m1424c().get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final int m1425a(MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel) {
        return this.f1347f.indexOf(minutiaeTaggableSuggestionsModel);
    }
}
