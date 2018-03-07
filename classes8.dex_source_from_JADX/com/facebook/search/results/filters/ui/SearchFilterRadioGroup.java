package com.facebook.search.results.filters.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.SecureContextHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.intent.SearchFilterTypeaheadIntentBuilder;
import com.facebook.search.results.filters.definition.SearchResultPageRadioGroupFilterDefinition.C24263;
import com.facebook.search.results.filters.definition.SearchResultPageRadioGroupFilterDefinition.C24274;
import com.facebook.search.results.filters.ui.SearchResultPageFilterFragment.C24411;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageMainFilterFragmentModel.MainFilterModel;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;

/* compiled from: SLIDESHOW_DESELECTED */
public class SearchFilterRadioGroup extends CustomLinearLayout {
    public ImmutableList<SearchFilterRadioButton> f22899a;
    private BetterTextView f22900b;
    public C24274 f22901c;
    public C24263 f22902d;

    /* compiled from: SLIDESHOW_DESELECTED */
    class C24341 implements OnClickListener {
        final /* synthetic */ SearchFilterRadioGroup f22897a;

        C24341(SearchFilterRadioGroup searchFilterRadioGroup) {
            this.f22897a = searchFilterRadioGroup;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2094716102);
            C24263 c24263 = this.f22897a.f22902d;
            C24411 c24411 = c24263.f22830a;
            MainFilterModel mainFilterModel = c24263.f22831b;
            SearchFilterTypeaheadIntentBuilder searchFilterTypeaheadIntentBuilder = (SearchFilterTypeaheadIntentBuilder) c24411.f22930a.an.get();
            String g = mainFilterModel.m10188g();
            String jo_ = mainFilterModel.jo_();
            ((SecureContextHelper) c24411.f22930a.ao.get()).a(new Intent().setComponent((ComponentName) searchFilterTypeaheadIntentBuilder.a.get()).putExtra("target_fragment", ContentFragmentType.SEARCH_FILTER_TYPEAHEAD_FRAGMENT.ordinal()).putExtra("search_filter_id", g).putExtra("search_filter_name", jo_).putExtra("search_filter_text", mainFilterModel.m10189j()), 0, c24411.f22930a);
            Logger.a(2, EntryType.UI_INPUT_END, -1399007296, a);
        }
    }

    /* compiled from: SLIDESHOW_DESELECTED */
    class C24352 implements OnClickListener {
        final /* synthetic */ SearchFilterRadioGroup f22898a;

        C24352(SearchFilterRadioGroup searchFilterRadioGroup) {
            this.f22898a = searchFilterRadioGroup;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2108523463);
            SearchFilterRadioGroup searchFilterRadioGroup = this.f22898a;
            int size = searchFilterRadioGroup.f22899a.size();
            for (int i = 0; i < size; i++) {
                boolean z;
                SearchFilterRadioButton searchFilterRadioButton = (SearchFilterRadioButton) searchFilterRadioGroup.f22899a.get(i);
                if (searchFilterRadioButton.getTag() == view.getTag()) {
                    z = true;
                } else {
                    z = false;
                }
                searchFilterRadioButton.setChecked(z);
            }
            this.f22898a.f22901c.m26485a(((Integer) view.getTag()).intValue());
            Logger.a(2, EntryType.UI_INPUT_END, -264162602, a);
        }
    }

    public SearchFilterRadioGroup(Context context) {
        this(context, null);
    }

    private SearchFilterRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
    }

    public final void m26535a(C24263 c24263, String str, boolean z) {
        this.f22900b = (BetterTextView) LayoutInflater.from(getContext()).inflate(2130906995, null);
        this.f22900b.setText(str);
        this.f22900b.setMaxLines(1);
        addView(this.f22900b);
        this.f22902d = c24263;
        this.f22900b.setOnClickListener(new C24341(this));
        if (z) {
            this.f22900b.setTextColor(getContext().getResources().getColor(2131361917));
        }
    }

    public void setOnRadioButtonSelectedListener(C24274 c24274) {
        this.f22901c = c24274;
    }

    public void setRadioButtons(ImmutableList<SearchFilterRadioButton> immutableList) {
        this.f22899a = immutableList;
        int size = this.f22899a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            SearchFilterRadioButton searchFilterRadioButton = (SearchFilterRadioButton) this.f22899a.get(i2);
            searchFilterRadioButton.setTag(Integer.valueOf(i));
            addView(searchFilterRadioButton);
            searchFilterRadioButton.setOnClickListener(new C24352(this));
            i++;
        }
    }
}
