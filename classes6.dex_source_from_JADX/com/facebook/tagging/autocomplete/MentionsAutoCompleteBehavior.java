package com.facebook.tagging.autocomplete;

import android.content.Context;
import com.facebook.config.application.Product;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tagging.abtest.ExperimentsForTaggingABTestModule;
import com.facebook.tagging.adapter.BaseTagTypeaheadAdapter.TaggingProfileExclusionFilter;
import com.facebook.tagging.adapter.MentionsTagTypeaheadAdapter;
import com.facebook.tagging.adapter.filters.TagTypeaheadFilter;
import com.facebook.tagging.graphql.utils.MentionsSpannableStringBuilder;
import com.facebook.tagging.logging.MentionsTypeaheadAnalyticHelper;
import com.facebook.tagging.model.MentionSpan;
import com.facebook.tagging.model.MentionSurface;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView.C12821;
import com.facebook.tagging.ui.utils.MentionsTokenUtils;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: device_autoplay_setting_update */
public class MentionsAutoCompleteBehavior {
    public final Context f17362a;
    public final C12821 f17363b;
    public final MentionsTokenUtils f17364c;
    private final QeAccessor f17365d;
    public final MentionsTagTypeaheadAdapter f17366e;
    public final MentionsTypeaheadAnalyticHelper f17367f;
    public final int f17368g;
    public final int f17369h;
    public boolean f17370i = true;
    public String f17371j;
    public TaggingProfile f17372k;
    public Long f17373l;
    public MentionSurface f17374m;

    /* compiled from: device_autoplay_setting_update */
    class C12611 implements TaggingProfileExclusionFilter {
        final /* synthetic */ MentionsAutoCompleteBehavior f17361a;

        C12611(MentionsAutoCompleteBehavior mentionsAutoCompleteBehavior) {
            this.f17361a = mentionsAutoCompleteBehavior;
        }

        public final boolean mo1310a(long j) {
            MentionsSpannableStringBuilder a = this.f17361a.f17363b.m25566a();
            int i = 0;
            List a2 = Lists.a();
            MentionSpan[] mentionSpanArr = (MentionSpan[]) a.getSpans(0, a.length(), MentionSpan.class);
            int length = mentionSpanArr.length;
            while (i < length) {
                a2.add(Long.valueOf(mentionSpanArr[i].m25523b()));
                i++;
            }
            List list = a2;
            return list != null && list.contains(Long.valueOf(j));
        }
    }

    @Inject
    public MentionsAutoCompleteBehavior(Context context, @Assisted C12821 c12821, MentionsTokenUtils mentionsTokenUtils, QeAccessor qeAccessor, MentionsTagTypeaheadAdapter mentionsTagTypeaheadAdapter, MentionsTypeaheadAnalyticHelper mentionsTypeaheadAnalyticHelper, Product product) {
        this.f17362a = context;
        this.f17363b = c12821;
        this.f17364c = mentionsTokenUtils;
        this.f17365d = qeAccessor;
        this.f17366e = mentionsTagTypeaheadAdapter;
        this.f17367f = mentionsTypeaheadAnalyticHelper;
        this.f17366e.f17314a = new C12611(this);
        this.f17368g = product == Product.PAA ? 3 : 5;
        this.f17369h = ((Integer) ImmutableSortedSet.a(Integer.valueOf(this.f17365d.a(ExperimentsForTaggingABTestModule.f17308g, 1) + 1), Integer.valueOf(this.f17365d.a(ExperimentsForTaggingABTestModule.f17309h, 4)), Integer.valueOf(this.f17368g)).first()).intValue();
    }

    public final CharSequence m25188a(Object obj) {
        TaggingProfile taggingProfile = (TaggingProfile) obj;
        if (taggingProfile.f17538a == null) {
            return null;
        }
        this.f17372k = taggingProfile;
        return taggingProfile.m25532i();
    }

    public final void m25189b() {
        TagTypeaheadFilter tagTypeaheadFilter = this.f17366e.f17321b;
        tagTypeaheadFilter.f17346k = null;
        tagTypeaheadFilter.f17347l = null;
    }
}
