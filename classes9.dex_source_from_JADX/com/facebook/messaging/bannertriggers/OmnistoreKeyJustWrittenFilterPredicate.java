package com.facebook.messaging.bannertriggers;

import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: openGroupEditPage() not supported yet */
public class OmnistoreKeyJustWrittenFilterPredicate extends AbstractContextualFilterPredicate {
    private final Clock f8132a;
    private final BannerTriggersCache f8133b;

    @Inject
    public OmnistoreKeyJustWrittenFilterPredicate(Clock clock, BannerTriggersCache bannerTriggersCache) {
        this.f8132a = clock;
        this.f8133b = bannerTriggersCache;
    }

    public final boolean m8383a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        String str = (String) contextualFilter.b().get("duration");
        if (StringUtil.a(str)) {
            return false;
        }
        CharSequence charSequence = contextualFilter.value;
        if (StringUtil.a(charSequence)) {
            return false;
        }
        Object obj;
        String format;
        if (interstitialTrigger == null || interstitialTrigger.a == null) {
            obj = null;
        } else {
            obj = interstitialTrigger.a.a("thread_id");
        }
        if (obj != null && contextualFilter.b().containsKey("thread_level_gating") && ((String) contextualFilter.b().get("thread_level_gating")).equals("1")) {
            format = String.format("%s:%s", new Object[]{obj, charSequence});
        } else {
            CharSequence charSequence2 = charSequence;
        }
        long parseInt = ((long) Integer.parseInt(str)) * 1000;
        Long a = this.f8133b.a(format);
        if (a == null) {
            return false;
        }
        return this.f8132a.a() - (a.longValue() * 1000) <= parseInt;
    }
}
