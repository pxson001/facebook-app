package com.facebook.tagging.adapter;

import android.content.Context;
import android.widget.Filter;
import android.widget.Filter.FilterListener;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tagging.adapter.filters.TagTypeaheadFilter;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: has_limited_objects */
public class TagTypeaheadAdapter extends BaseTagTypeaheadAdapter {
    public final TagTypeaheadFilter f17321b;

    private static TagTypeaheadAdapter m25157a(InjectorLike injectorLike) {
        return new TagTypeaheadAdapter((Context) injectorLike.getInstance(Context.class), new TagTypeaheadFilter(DefaultAndroidThreadUtil.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 11099)));
    }

    @Inject
    public TagTypeaheadAdapter(Context context, TagTypeaheadFilter tagTypeaheadFilter) {
        super(context);
        this.f17321b = tagTypeaheadFilter;
    }

    public void mo1306a(CharSequence charSequence, String str, @Nullable FilterListener filterListener) {
        TagTypeaheadFilter tagTypeaheadFilter = this.f17321b;
        tagTypeaheadFilter.f17346k = charSequence;
        tagTypeaheadFilter.f17347l = str;
        this.f17321b.filter(charSequence, filterListener);
    }

    public final TagTypeaheadAdapter m25160c(boolean z) {
        this.f17321b.f17338c = z;
        return this;
    }

    public final TagTypeaheadAdapter m25161d(boolean z) {
        this.f17321b.f17340e = z;
        return this;
    }

    public void mo1307b(TagTypeaheadDataSource tagTypeaheadDataSource) {
        this.f17321b.f17343h = tagTypeaheadDataSource;
    }

    public Filter getFilter() {
        return this.f17321b;
    }
}
