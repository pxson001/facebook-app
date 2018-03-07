package com.facebook.tagging.autocomplete;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tagging.abtest.ExperimentsForTaggingABTestModule;
import com.facebook.tagging.adapter.MentionsTagTypeaheadAdapter;
import com.facebook.tagging.logging.MentionsTypeaheadAnalyticHelper;
import com.facebook.tagging.model.MentionSurface;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView.C12821;
import com.facebook.tagging.ui.utils.MentionsTokenUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: device_location_ */
public class AutoCompleteBehaviorFactory {
    private final C12821 f17359a;
    public final MentionsAutoCompleteBehavior f17360b;

    @Inject
    public AutoCompleteBehaviorFactory(@Assisted C12821 c12821, MentionsAutoCompleteBehaviorProvider mentionsAutoCompleteBehaviorProvider) {
        this.f17359a = c12821;
        this.f17360b = new MentionsAutoCompleteBehavior((Context) mentionsAutoCompleteBehaviorProvider.getInstance(Context.class), this.f17359a, MentionsTokenUtils.m25580b(mentionsAutoCompleteBehaviorProvider), (QeAccessor) QeInternalImplMethodAutoProvider.a(mentionsAutoCompleteBehaviorProvider), MentionsTagTypeaheadAdapter.m25172d((InjectorLike) mentionsAutoCompleteBehaviorProvider), new MentionsTypeaheadAnalyticHelper(AnalyticsLoggerMethodAutoProvider.a(mentionsAutoCompleteBehaviorProvider)), ProductMethodAutoProvider.b(mentionsAutoCompleteBehaviorProvider));
    }

    public final void m25186a(@Nullable Long l, MentionSurface mentionSurface) {
        MentionsAutoCompleteBehavior mentionsAutoCompleteBehavior = this.f17360b;
        MentionsTagTypeaheadAdapter mentionsTagTypeaheadAdapter = mentionsAutoCompleteBehavior.f17366e;
        boolean z = true;
        if (!(l == null || l.longValue() == 0)) {
            boolean z2 = false;
            boolean z3 = MentionSurface.COMPOSER.equals(mentionSurface) && mentionsTagTypeaheadAdapter.f17330e.a(ExperimentsForTaggingABTestModule.f17304c, false);
            boolean z4;
            if (MentionSurface.COMMENT.equals(mentionSurface) && mentionsTagTypeaheadAdapter.f17330e.a(ExperimentsForTaggingABTestModule.f17303b, false)) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z3 || r11) {
                z2 = true;
            }
            if (z2) {
                mentionsTagTypeaheadAdapter.f17329d = true;
                mentionsTagTypeaheadAdapter.f17331f = mentionsTagTypeaheadAdapter.f17327b.m25262a(l);
                mentionsTagTypeaheadAdapter.m25175a(mentionsTagTypeaheadAdapter.f17331f);
                if (z) {
                    mentionsAutoCompleteBehavior.f17373l = l;
                }
                mentionsAutoCompleteBehavior.f17374m = mentionSurface;
            }
        }
        z = false;
        if (z) {
            mentionsAutoCompleteBehavior.f17373l = l;
        }
        mentionsAutoCompleteBehavior.f17374m = mentionSurface;
    }
}
