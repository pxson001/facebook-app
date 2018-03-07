package com.facebook.widget.tokenizedtypeahead.ui.listview;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.filter.CustomFilter;
import com.facebook.widget.filter.CustomFilterable;
import com.facebook.widget.listview.SectionedListAdapter;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseTokenMatcher;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: fb_location_continuous_listener_google_play */
public class TypeaheadAdapter extends SectionedListAdapter implements CustomFilterable {
    public List<SectionedListSection<? extends BaseToken>> f18479c = new ArrayList();
    public List<SectionedListSection<? extends BaseToken>> f18480d = new ArrayList();
    public final InputMethodManager f18481e;
    private TypeaheadMatcherFilter f18482f;
    private ViewFactory f18483g;
    private TypeaheadMatcherFilterProvider f18484h;
    public List<? extends BaseToken> f18485i = new ArrayList();

    /* compiled from: fb_location_continuous_listener_google_play */
    public interface ViewFactory {
        View mo1201a(ViewGroup viewGroup);

        TriState mo1202a();

        void mo1203a(View view, OnClickListener onClickListener);

        void mo1204a(View view, SectionedListSection sectionedListSection);

        void mo1205a(View view, BaseToken baseToken, boolean z);

        View mo1206b(ViewGroup viewGroup);

        void mo1207b(View view, BaseToken baseToken, boolean z);

        View mo1208c(ViewGroup viewGroup);

        View mo1209d(ViewGroup viewGroup);

        View mo1210e(ViewGroup viewGroup);
    }

    /* compiled from: fb_location_continuous_listener_google_play */
    public class C15121 {
        public final /* synthetic */ TypeaheadAdapter f20129a;

        C15121(TypeaheadAdapter typeaheadAdapter) {
            this.f20129a = typeaheadAdapter;
        }

        public final List<SectionedListSection<? extends BaseToken>> m28794a() {
            return this.f20129a.f18479c;
        }
    }

    /* compiled from: fb_location_continuous_listener_google_play */
    class C15143 extends Filter {
        final /* synthetic */ TypeaheadAdapter f20133a;

        C15143(TypeaheadAdapter typeaheadAdapter) {
            this.f20133a = typeaheadAdapter;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            throw new UnsupportedOperationException("We should be using the custom filter");
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        }
    }

    /* compiled from: fb_location_continuous_listener_google_play */
    /* synthetic */ class C15154 {
        static final /* synthetic */ int[] f20134a = new int[TriState.values().length];

        static {
            f20135b = new int[RowType.values().length];
            try {
                f20135b[RowType.ITEM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20135b[RowType.VIEW_MORE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20135b[RowType.SUBTITLED_ITEM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20135b[RowType.LOADING_SECTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f20134a[TriState.UNSET.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f20134a[TriState.YES.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: fb_location_continuous_listener_google_play */
    public enum RowType {
        HEADER,
        ITEM,
        VIEW_MORE,
        SUBTITLED_ITEM,
        LOADING_SECTION
    }

    public static TypeaheadAdapter m27098b(InjectorLike injectorLike) {
        return new TypeaheadAdapter(InputMethodManagerMethodAutoProvider.b(injectorLike), (TypeaheadMatcherFilterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TypeaheadMatcherFilterProvider.class));
    }

    @Inject
    public TypeaheadAdapter(InputMethodManager inputMethodManager, TypeaheadMatcherFilterProvider typeaheadMatcherFilterProvider) {
        this.f18481e = inputMethodManager;
        this.f18484h = typeaheadMatcherFilterProvider;
    }

    public final void m27105a(BaseTokenMatcher baseTokenMatcher) {
        m27106a(baseTokenMatcher, new DefaultViewFactory(true));
    }

    public void m27106a(BaseTokenMatcher baseTokenMatcher, ViewFactory viewFactory) {
        this.f18483g = viewFactory;
        TypeaheadMatcherFilterProvider typeaheadMatcherFilterProvider = this.f18484h;
        this.f18482f = new TypeaheadMatcherFilter(FbHandlerThreadFactory.a(typeaheadMatcherFilterProvider), baseTokenMatcher, m27114e());
    }

    public final C15121 m27114e() {
        return new C15121(this);
    }

    public boolean areAllItemsEnabled() {
        switch (C15154.f20134a[this.f18483g.mo1202a().ordinal()]) {
            case 1:
                return super.areAllItemsEnabled();
            case 2:
                return true;
            default:
                return false;
        }
    }

    public final int mo1063c() {
        return this.f18480d.size();
    }

    public final int mo1064c(int i) {
        SectionedListSection sectionedListSection = (SectionedListSection) this.f18480d.get(i);
        if (sectionedListSection.mo435c() || sectionedListSection.mo436f()) {
            return sectionedListSection.mo434b().size() + 1;
        }
        return sectionedListSection.mo434b().size();
    }

    public final Object mo1060b(int i) {
        return this.f18480d.get(i);
    }

    public final Object mo1059a(int i, int i2) {
        if (i2 < ((SectionedListSection) this.f18480d.get(i)).mo434b().size()) {
            return ((SectionedListSection) this.f18480d.get(i)).mo434b().get(i2);
        }
        return null;
    }

    public View mo1058a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f18483g.mo1209d(viewGroup);
        }
        this.f18483g.mo1204a(view, (SectionedListSection) mo1060b(i));
        return view;
    }

    private View m27096a(RowType rowType, ViewGroup viewGroup) {
        switch (rowType) {
            case ITEM:
                return this.f18483g.mo1201a(viewGroup);
            case VIEW_MORE:
                return this.f18483g.mo1208c(viewGroup);
            case SUBTITLED_ITEM:
                return this.f18483g.mo1206b(viewGroup);
            case LOADING_SECTION:
                return this.f18483g.mo1210e(viewGroup);
            default:
                throw new RuntimeException("Could not find child view.");
        }
    }

    public View mo1057a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View a;
        RowType rowType = RowType.values()[mo1065c(i, i2)];
        if (view == null) {
            a = m27096a(rowType, viewGroup);
        } else {
            a = view;
        }
        try {
            m27097a(a, rowType, i, i2);
            return a;
        } catch (ClassCastException e) {
            a = m27096a(rowType, viewGroup);
            m27097a(a, rowType, i, i2);
            return a;
        }
    }

    private void m27097a(final View view, RowType rowType, final int i, int i2) {
        BaseToken baseToken;
        if (rowType == RowType.ITEM) {
            baseToken = (BaseToken) mo1059a(i, i2);
            if (baseToken != null) {
                this.f18483g.mo1205a(view, baseToken, this.f18485i.contains(baseToken));
            }
        } else if (rowType == RowType.VIEW_MORE) {
            this.f18483g.mo1203a(view, new OnClickListener(this) {
                final /* synthetic */ TypeaheadAdapter f20132c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1121593729);
                    ((SectionedListSection) this.f20132c.mo1060b(i)).mo433a(true);
                    this.f20132c.f18481e.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    AdapterDetour.a(this.f20132c, 368869722);
                    Logger.a(2, EntryType.UI_INPUT_END, 1822048606, a);
                }
            });
        } else if (rowType == RowType.SUBTITLED_ITEM) {
            baseToken = (BaseToken) mo1059a(i, i2);
            if (baseToken != null) {
                this.f18483g.mo1207b(view, baseToken, this.f18485i.contains(baseToken));
            }
        }
    }

    public final boolean mo1062b(int i, int i2) {
        if (i2 < ((SectionedListSection) mo1060b(i)).mo434b().size()) {
            Object a = mo1059a(i, i2);
            if (a instanceof BaseToken) {
                return ((BaseToken) a).mo1195a();
            }
        }
        return true;
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public final int mo1056a(int i) {
        return RowType.HEADER.ordinal();
    }

    public final int mo1065c(int i, int i2) {
        SectionedListSection sectionedListSection = (SectionedListSection) mo1060b(i);
        Object a = mo1059a(i, i2);
        if (sectionedListSection.mo436f() && sectionedListSection.mo434b().isEmpty()) {
            return RowType.LOADING_SECTION.ordinal();
        }
        if (sectionedListSection.mo435c() && i2 == sectionedListSection.mo434b().size()) {
            return RowType.VIEW_MORE.ordinal();
        }
        if (!(a instanceof BaseToken) || (Strings.isNullOrEmpty(((BaseToken) a).mo1192l()) && !((BaseToken) a).m22651m())) {
            return RowType.ITEM.ordinal();
        }
        return RowType.SUBTITLED_ITEM.ordinal();
    }

    public final boolean mo1061b() {
        return this.f18480d.isEmpty();
    }

    public Filter getFilter() {
        return new C15143(this);
    }

    public CustomFilter mo438a() {
        return this.f18482f;
    }

    public final SectionedListSection m27115g(int i) {
        return (SectionedListSection) this.f18479c.get(i);
    }

    public final void m27107a(List<? extends SectionedListSection<? extends BaseToken>> list) {
        List a = Lists.a(list);
        this.f18480d = a;
        this.f18479c = a;
        AdapterDetour.a(this, -1292285261);
    }

    public final void m27104a(int i, SectionedListSection<? extends BaseToken> sectionedListSection) {
        this.f18479c.set(i, sectionedListSection);
        this.f18480d = this.f18479c;
        AdapterDetour.a(this, 230551754);
    }
}
