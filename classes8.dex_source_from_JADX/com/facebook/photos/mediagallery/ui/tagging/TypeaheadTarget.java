package com.facebook.photos.mediagallery.ui.tagging;

import android.graphics.PointF;
import com.facebook.tagging.model.SetTagSuggestionsCallback;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: skip_badge */
public class TypeaheadTarget implements SetTagSuggestionsCallback {
    public final boolean f2574a;
    public final Optional<String> f2575b;
    public final PointF f2576c;
    private final PointF f2577d;
    public ImmutableList<TaggingProfile> f2578e;

    public TypeaheadTarget(@Nullable String str, List<TaggingProfile> list, PointF pointF, PointF pointF2, boolean z) {
        Preconditions.checkNotNull(pointF);
        Preconditions.checkNotNull(pointF2);
        this.f2575b = Optional.fromNullable(str);
        this.f2576c = pointF;
        this.f2577d = pointF2;
        this.f2574a = z;
        this.f2578e = ImmutableList.copyOf(list);
    }

    public final PointF m2676c() {
        return new PointF(this.f2577d.x, this.f2577d.y);
    }

    public void setTagSuggestions(List<TaggingProfile> list) {
        this.f2578e = ImmutableList.copyOf(list);
    }
}
