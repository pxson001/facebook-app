package com.facebook.search.results.filters.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.inject.Assisted;
import com.facebook.search.results.protocol.filters.FilterValue;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableList;

/* compiled from: SLIDESHOW_PREVIEW_SAVED */
public class FilterTypeaheadAdapter extends FbBaseAdapter {
    private static final ImmutableMap<String, Integer> f22862a = ImmutableMap.of("city", Integer.valueOf(2130840023), "employer", Integer.valueOf(2130839723), "school", Integer.valueOf(2130839844));
    public final Context f22863b;
    public final boolean f22864c;
    private final Drawable f22865d;
    public final String f22866e;
    public FilterValue f22867f;
    public SpannableString f22868g;
    public ImmutableList<FilterValue> f22869h = RegularImmutableList.a;

    public /* synthetic */ Object getItem(int i) {
        return m26519a(i);
    }

    @Inject
    public FilterTypeaheadAdapter(@Assisted String str, @Assisted String str2, Context context, GlyphColorizer glyphColorizer) {
        this.f22866e = StringLocaleUtil.a(str2);
        this.f22863b = context;
        this.f22864c = f22862a.containsKey(str);
        this.f22865d = this.f22864c ? glyphColorizer.a(((Integer) f22862a.get(str)).intValue(), -10972929) : null;
    }

    public final View m26518a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f22863b).inflate(2130907006, viewGroup, false);
    }

    public final void m26520a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        FilterValue filterValue = (FilterValue) obj;
        ContentView contentView = (ContentView) view;
        if (filterValue == this.f22867f) {
            contentView.setTitleText(this.f22868g);
            contentView.setThumbnailDrawable(this.f22865d);
            contentView.setTitleTextAppearance(2131625942);
        } else if (filterValue.f8693e != null) {
            contentView.setTitleText(filterValue.f8691c);
            contentView.setThumbnailUri(filterValue.f8693e);
            contentView.setTitleTextAppearance(2131625939);
        } else {
            contentView.setTitleText(filterValue.f8691c);
            contentView.setThumbnailPlaceholderResource(((Integer) f22862a.get(this.f22866e)).intValue());
            contentView.setTitleTextAppearance(2131625939);
        }
    }

    public int getCount() {
        return this.f22869h.size();
    }

    public final FilterValue m26519a(int i) {
        return (FilterValue) this.f22869h.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }
}
