package com.facebook.bugreporter.activity.categorylist;

import com.facebook.common.util.TriState;
import java.text.Collator;
import java.util.Comparator;
import javax.inject.Inject;

/* compiled from: android.media.metadata.AUTHOR */
public class CategoryInfoComparator implements Comparator<CategoryInfo> {
    private final Collator f10697a;
    private final TriState f10698b;

    public int compare(Object obj, Object obj2) {
        return this.f10697a.compare(((CategoryInfo) obj).m18726a(this.f10698b), ((CategoryInfo) obj2).m18726a(this.f10698b));
    }

    @Inject
    public CategoryInfoComparator(Collator collator, TriState triState) {
        this.f10697a = collator;
        this.f10698b = triState;
    }
}
