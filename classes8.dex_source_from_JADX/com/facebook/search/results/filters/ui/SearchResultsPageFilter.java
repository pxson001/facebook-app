package com.facebook.search.results.filters.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.model.NeedleFilter;
import com.facebook.search.results.filters.controller.FilterValueSearchControllerProvider;
import com.facebook.search.results.filters.ui.PopoverFilterWindow.OnFilterSelectedListener;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SINGLE */
public class SearchResultsPageFilter extends CustomLinearLayout {
    public final Map<View, NeedleFilter> f22939a = new HashMap();
    private final OnClickListener f22940b = new C24461(this);
    private final ImmutableMap<String, Integer> f22941c = ImmutableMap.of("city", Integer.valueOf(2130839795), "employer", Integer.valueOf(2130839724), "friends", Integer.valueOf(2130839898), "school", Integer.valueOf(2130840088));
    private int f22942d;
    private int f22943e;
    private ColorFilter f22944f;
    private ColorFilter f22945g;
    private int f22946h;
    private int f22947i;
    private int f22948j;
    private boolean f22949k;
    public PopoverFilterWindow f22950l;
    private OnFilterSelectedListener f22951m;

    /* compiled from: SINGLE */
    class C24461 implements OnClickListener {
        final /* synthetic */ SearchResultsPageFilter f22938a;

        C24461(SearchResultsPageFilter searchResultsPageFilter) {
            this.f22938a = searchResultsPageFilter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -526734005);
            NeedleFilter needleFilter = (NeedleFilter) this.f22938a.f22939a.get(view);
            PopoverFilterWindow popoverFilterWindow = this.f22938a.f22950l;
            popoverFilterWindow.f22877l.f22779h = needleFilter;
            popoverFilterWindow.f22876a.clear();
            AdapterDetour.a(popoverFilterWindow.f22889x, -304670957);
            popoverFilterWindow.f22885t.a();
            if (popoverFilterWindow.f22878m.containsKey(needleFilter.f22172b)) {
                popoverFilterWindow.f22885t.setHint(popoverFilterWindow.getContext().getString(((Integer) popoverFilterWindow.f22878m.get(needleFilter.f22172b)).intValue()));
            } else {
                popoverFilterWindow.f22885t.setHint(needleFilter.f22173c);
            }
            popoverFilterWindow.f22888w.smoothScrollToPosition(0);
            popoverFilterWindow.f22877l.m26420a(popoverFilterWindow.f22885t.getText().toString());
            this.f22938a.f22950l.f(view);
            Logger.a(2, EntryType.UI_INPUT_END, -1151530066, a);
        }
    }

    private static <T extends View> void m26566a(Class<T> cls, T t) {
        m26567a((Object) t, t.getContext());
    }

    private static void m26567a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SearchResultsPageFilter) obj).f22950l = new PopoverFilterWindow((Context) fbInjector.getInstance(Context.class), (FilterValueSearchControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FilterValueSearchControllerProvider.class));
    }

    @Inject
    private void m26565a(PopoverFilterWindow popoverFilterWindow) {
        this.f22950l = popoverFilterWindow;
    }

    public SearchResultsPageFilter(Context context) {
        super(context);
        m26562a();
    }

    public SearchResultsPageFilter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26563a(context, attributeSet, 0, 0);
        m26562a();
    }

    public SearchResultsPageFilter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26563a(context, attributeSet, i, 0);
        m26562a();
    }

    private void m26563a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SearchResultsPageFilter, i, i2);
        try {
            this.f22947i = obtainStyledAttributes.getInteger(0, 3);
            this.f22948j = obtainStyledAttributes.getDimensionPixelSize(1, 300);
            this.f22949k = obtainStyledAttributes.getBoolean(2, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m26562a() {
        m26566a(SearchResultsPageFilter.class, (View) this);
        Resources resources = getResources();
        this.f22942d = resources.getColor(2131363396);
        this.f22943e = resources.getColor(2131363395);
        this.f22944f = new PorterDuffColorFilter(this.f22942d, Mode.SRC_IN);
        this.f22945g = new PorterDuffColorFilter(this.f22943e, Mode.SRC_IN);
        this.f22946h = resources.getDimensionPixelSize(2131431608);
        this.f22950l.f22888w.f22860a = this.f22948j;
        this.f22950l.f22888w.f22861b = this.f22949k;
    }

    public void setOnFilterSelectedListener(OnFilterSelectedListener onFilterSelectedListener) {
        this.f22951m = onFilterSelectedListener;
        this.f22950l.f22890y = this.f22951m;
    }

    public void setNumButtons(int i) {
        this.f22947i = i;
    }

    public void setFilters(@Nullable ImmutableList<NeedleFilter> immutableList) {
        removeAllViews();
        this.f22939a.clear();
        if (immutableList == null || immutableList.isEmpty()) {
            setVisibility(8);
            return;
        }
        Resources resources = getResources();
        PopoverFilterWindow popoverFilterWindow = this.f22950l;
        popoverFilterWindow.f22876a.clear();
        AdapterDetour.a(popoverFilterWindow.f22889x, -2092172623);
        this.f22950l.m26530a(immutableList);
        LayoutInflater from = LayoutInflater.from(getContext());
        int i = 0;
        while (i < immutableList.size() && i < this.f22947i) {
            int i2;
            NeedleFilter needleFilter = (NeedleFilter) immutableList.get(i);
            if (needleFilter.m25681d() != null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            from.inflate(2130907013, this);
            View childAt = getChildAt(getChildCount() - 1);
            TextView textView = (TextView) childAt.findViewById(2131558966);
            this.f22939a.put(childAt, needleFilter);
            Drawable mutate = resources.getDrawable(((Integer) this.f22941c.get(needleFilter.m25679b())).intValue()).mutate();
            int paddingLeft = childAt.getPaddingLeft();
            m26564a(childAt, i2 != 0 ? 2130839736 : 2130843278);
            textView.setTextColor(i2 != 0 ? this.f22942d : this.f22943e);
            mutate.setColorFilter(i2 != 0 ? this.f22944f : this.f22945g);
            textView.setText(i2 != 0 ? needleFilter.m25681d().m10137a() : needleFilter.m25680c());
            childAt.setPadding(paddingLeft, this.f22946h, paddingLeft, this.f22946h);
            textView.setCompoundDrawablesWithIntrinsicBounds(mutate, null, null, null);
            childAt.setOnClickListener(this.f22940b);
            i++;
        }
        setVisibility(0);
    }

    private void m26564a(View view, int i) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(ContextCompat.a(getContext(), i));
        } else {
            view.setBackgroundResource(i);
        }
    }
}
