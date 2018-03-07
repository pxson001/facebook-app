package com.facebook.quickpromotion.customrender;

import com.facebook.quickpromotion.logger.QuickPromotionLogger$LayoutInfo;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelper;

/* compiled from: relatedArticleImageWidth */
public class CustomRenderBaseController {
    public QuickPromotionViewHelper f4610a;
    private final Runnable f4611b;

    public CustomRenderBaseController(Runnable runnable, QuickPromotionViewHelper quickPromotionViewHelper) {
        this.f4611b = runnable;
        this.f4610a = quickPromotionViewHelper;
    }

    public final void m4473a() {
        this.f4610a.m4726a();
        this.f4610a.m4727a(new QuickPromotionLogger$LayoutInfo());
    }

    public void m4474c() {
        if (this.f4611b != null) {
            this.f4611b.run();
        }
    }
}
