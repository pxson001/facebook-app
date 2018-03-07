package com.facebook.search.results.filters.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.model.NeedleFilter;
import com.facebook.search.results.filters.controller.FilterValueSearchController;
import com.facebook.search.results.filters.controller.FilterValueSearchControllerProvider;
import com.facebook.search.results.filters.loader.OnFilterValuesFetchedListener;
import com.facebook.search.results.protocol.filters.FilterValue;
import com.facebook.search.results.protocol.filters.FilterValue.Builder;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.search.SearchEditText;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.widget.listview.BetterListView.OnTouchDownListener;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: SLIDESHOW_PREVIEW_PLAY */
public class PopoverFilterWindow extends PopoverWindow {
    public final List<FilterValue> f22876a = new ArrayList();
    public final FilterValueSearchController f22877l;
    public final ImmutableMap<String, Integer> f22878m = ImmutableMap.of("city", Integer.valueOf(2131237386), "employer", Integer.valueOf(2131237387), "friends", Integer.valueOf(2131237388), "school", Integer.valueOf(2131237389));
    public Drawable f22879n;
    public Drawable f22880o;
    public int f22881p;
    public int f22882q;
    public int f22883r;
    public GlyphView f22884s;
    public SearchEditText f22885t;
    public LayoutInflater f22886u;
    public SegmentedLinearLayout f22887v;
    public FilterPopoverListView f22888w;
    public PopoverFilterWindowsAdapter f22889x;
    public OnFilterSelectedListener f22890y;

    /* compiled from: SLIDESHOW_PREVIEW_PLAY */
    public class C24311 implements OnClickListener {
        final /* synthetic */ PopoverFilterWindow f22870a;

        public C24311(PopoverFilterWindow popoverFilterWindow) {
            this.f22870a = popoverFilterWindow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 786354331);
            this.f22870a.f22885t.a();
            Logger.a(2, EntryType.UI_INPUT_END, 248851308, a);
        }
    }

    /* compiled from: SLIDESHOW_PREVIEW_PLAY */
    public class C24322 implements OnItemClickListener {
        final /* synthetic */ PopoverFilterWindow f22871a;

        public C24322(PopoverFilterWindow popoverFilterWindow) {
            this.f22871a = popoverFilterWindow;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            boolean z;
            FilterValue filterValue;
            NeedleFilter needleFilter = this.f22871a.f22877l.f22779h;
            Builder g = FilterValue.m10136g();
            g.f8683a = ((FilterValue) this.f22871a.f22876a.get(i)).f8689a;
            g = g;
            g.f8684b = ((FilterValue) this.f22871a.f22876a.get(i)).f8690b;
            g = g;
            if (((FilterValue) this.f22871a.f22876a.get(i)).f8692d) {
                z = false;
            } else {
                z = true;
            }
            g.f8686d = z;
            g = g;
            g.f8688f = ((FilterValue) this.f22871a.f22876a.get(i)).f8694f;
            g = g;
            g.f8687e = ((FilterValue) this.f22871a.f22876a.get(i)).f8693e;
            FilterValue f = g.m10135f();
            NeedleFilter.Builder builder = new NeedleFilter.Builder();
            builder.f22167a = needleFilter.f22171a;
            builder = builder;
            builder.f22168b = needleFilter.f22172b;
            builder = builder;
            builder.f22169c = needleFilter.f22173c;
            NeedleFilter.Builder builder2 = builder;
            if (((FilterValue) this.f22871a.f22876a.get(i)).f8692d) {
                filterValue = null;
            } else {
                filterValue = f;
            }
            builder2.f22170d = filterValue;
            this.f22871a.f22890y.mo1302a(builder2.m25678a());
            this.f22871a.l();
        }
    }

    /* compiled from: SLIDESHOW_PREVIEW_PLAY */
    public class C24333 implements OnTouchDownListener {
        final /* synthetic */ PopoverFilterWindow f22872a;

        public C24333(PopoverFilterWindow popoverFilterWindow) {
            this.f22872a = popoverFilterWindow;
        }

        public final void m26521a() {
            this.f22872a.f22885t.c();
        }
    }

    /* compiled from: SLIDESHOW_PREVIEW_PLAY */
    class FilterValueListener implements OnFilterValuesFetchedListener {
        final /* synthetic */ PopoverFilterWindow f22873a;

        public FilterValueListener(PopoverFilterWindow popoverFilterWindow) {
            this.f22873a = popoverFilterWindow;
        }

        public final void mo1270a(String str, String str2, String str3, SearchResponse<FilterValue> searchResponse) {
            this.f22873a.f22876a.clear();
            this.f22873a.f22876a.addAll(searchResponse.b);
            AdapterDetour.a(this.f22873a.f22889x, -187718321);
        }

        public final void mo1269a(String str) {
        }

        public final void mo1271b(String str) {
        }
    }

    /* compiled from: SLIDESHOW_PREVIEW_PLAY */
    public class FocusListener implements OnFocusChangeListener {
        final /* synthetic */ PopoverFilterWindow f22874a;

        public FocusListener(PopoverFilterWindow popoverFilterWindow) {
            this.f22874a = popoverFilterWindow;
        }

        public void onFocusChange(View view, boolean z) {
            PopoverFilterWindow popoverFilterWindow;
            if (z) {
                if (Strings.isNullOrEmpty(this.f22874a.f22885t.getText().toString())) {
                    PopoverFilterWindow.m26527s(this.f22874a);
                }
                popoverFilterWindow = this.f22874a;
                InputMethodManager inputMethodManager = (InputMethodManager) popoverFilterWindow.getContext().getSystemService("input_method");
                if (!inputMethodManager.showSoftInput(popoverFilterWindow.f22885t, 0)) {
                    PopoverFilterWindow.m26526r(popoverFilterWindow);
                    inputMethodManager.toggleSoftInput(0, 0);
                    inputMethodManager.showSoftInput(popoverFilterWindow.f22885t, 0);
                }
                popoverFilterWindow = this.f22874a;
                popoverFilterWindow.f22887v.setSegmentedDividerThickness(4);
                popoverFilterWindow.f22887v.setSegmentedDivider(popoverFilterWindow.f22879n);
                return;
            }
            PopoverFilterWindow.m26526r(this.f22874a);
            PopoverFilterWindow.m26528u(this.f22874a);
            popoverFilterWindow = this.f22874a;
            popoverFilterWindow.f22887v.setSegmentedDividerThickness(2);
            popoverFilterWindow.f22887v.setSegmentedDivider(popoverFilterWindow.f22880o);
        }
    }

    /* compiled from: SLIDESHOW_PREVIEW_PLAY */
    public interface OnFilterSelectedListener {
        void mo1302a(NeedleFilter needleFilter);
    }

    /* compiled from: SLIDESHOW_PREVIEW_PLAY */
    public class TextListener implements TextWatcher {
        final /* synthetic */ PopoverFilterWindow f22875a;

        public TextListener(PopoverFilterWindow popoverFilterWindow) {
            this.f22875a = popoverFilterWindow;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i == 0 && i3 > 0) {
                PopoverFilterWindow.m26528u(this.f22875a);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() <= 0) {
                PopoverFilterWindow.m26527s(this.f22875a);
                this.f22875a.f22884s.setVisibility(8);
            } else {
                this.f22875a.f22884s.setVisibility(0);
            }
            this.f22875a.f22877l.m26420a(editable.toString());
        }
    }

    @Inject
    public PopoverFilterWindow(Context context, FilterValueSearchControllerProvider filterValueSearchControllerProvider) {
        super(context, 0);
        this.f22877l = filterValueSearchControllerProvider.m26421a(new FilterValueListener(this));
        this.f22882q = getContext().getResources().getColor(2131363396);
        this.f22883r = getContext().getResources().getColor(2131363395);
        this.f22881p = getContext().getResources().getColor(2131363397);
        this.f22886u = LayoutInflater.from(getContext());
        this.f22879n = new ColorDrawable(this.f22882q);
        this.f22880o = new ColorDrawable(this.f22883r);
        this.f22887v = (SegmentedLinearLayout) this.f22886u.inflate(2130907005, null);
        c(true);
        this.f22889x = new PopoverFilterWindowsAdapter(getContext(), this.f22876a);
        this.f22888w = (FilterPopoverListView) this.f22887v.findViewById(2131567294);
        this.f22885t = (SearchEditText) this.f22887v.findViewById(2131562543);
        this.f22884s = (GlyphView) this.f22887v.findViewById(2131562544);
        this.f22884s.setOnClickListener(new C24311(this));
        this.f22885t.addTextChangedListener(new TextListener(this));
        this.f22885t.setOnFocusChangeListener(new FocusListener(this));
        this.f22888w.setAdapter(this.f22889x);
        this.f22888w.setOnItemClickListener(new C24322(this));
        this.f22888w.y = new C24333(this);
    }

    public final void m26531d() {
        d(this.f22887v);
        super.d();
    }

    public final void m26532l() {
        FilterValueSearchController filterValueSearchController = this.f22877l;
        filterValueSearchController.f22773b.f22855d.c();
        filterValueSearchController.f22776e.clear();
        if (this.r) {
            m26526r(this);
        }
        super.l();
    }

    public final void m26529a(View view, boolean z, LayoutParams layoutParams) {
        super.a(view, z, layoutParams);
        if (z) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            this.f.setLayoutParams(layoutParams2);
            if (!this.f22888w.f22861b) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                this.f.setNubOffset(iArr[0] + (view.getWidth() / 2));
            }
        }
    }

    public final void m26530a(ImmutableList<NeedleFilter> immutableList) {
        FilterValueSearchController filterValueSearchController = this.f22877l;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            NeedleFilter needleFilter = (NeedleFilter) immutableList.get(i);
            if (filterValueSearchController.f22775d.get(needleFilter.f22172b) != null && ((String) filterValueSearchController.f22775d.get(needleFilter.f22172b)).equals(needleFilter.f22171a)) {
                hashMap.put(needleFilter.f22172b, filterValueSearchController.f22774c.get(needleFilter.f22172b));
                hashMap2.put(needleFilter.f22172b, filterValueSearchController.f22775d.get(needleFilter.f22172b));
            }
        }
        filterValueSearchController.f22774c.clear();
        filterValueSearchController.f22775d.clear();
        filterValueSearchController.f22774c.putAll(hashMap);
        filterValueSearchController.f22775d.putAll(hashMap2);
    }

    public static void m26526r(PopoverFilterWindow popoverFilterWindow) {
        ((InputMethodManager) popoverFilterWindow.getContext().getSystemService("input_method")).hideSoftInputFromWindow(popoverFilterWindow.f22885t.getWindowToken(), 0);
    }

    public static void m26527s(PopoverFilterWindow popoverFilterWindow) {
        popoverFilterWindow.f22885t.setTextColor(popoverFilterWindow.f22882q);
    }

    public static void m26528u(PopoverFilterWindow popoverFilterWindow) {
        popoverFilterWindow.f22885t.setTextColor(popoverFilterWindow.f22881p);
    }
}
