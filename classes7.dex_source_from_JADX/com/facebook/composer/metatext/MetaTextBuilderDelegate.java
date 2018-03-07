package com.facebook.composer.metatext;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.metatext.MetaTextBuilder.Params;
import com.facebook.composer.metatext.MetaTextBuilder.StyleParams;
import com.facebook.composer.metatext.MetaTextBuilder.StyleParamsBuilder;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: transliteration_composer */
public class MetaTextBuilderDelegate implements MetaTextBuilder {
    private final DefaultMetaTextBuilder f1306a;
    private final MinutiaeTemplateMetaTextBuilder f1307b;
    private final Resources f1308c;

    public static MetaTextBuilderDelegate m1381b(InjectorLike injectorLike) {
        return new MetaTextBuilderDelegate(new DefaultMetaTextBuilder(ResourcesMethodAutoProvider.a(injectorLike)), MinutiaeTemplateMetaTextBuilder.m1391b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MetaTextBuilderDelegate(DefaultMetaTextBuilder defaultMetaTextBuilder, MinutiaeTemplateMetaTextBuilder minutiaeTemplateMetaTextBuilder, Resources resources) {
        this.f1306a = defaultMetaTextBuilder;
        this.f1307b = minutiaeTemplateMetaTextBuilder;
        this.f1308c = resources;
    }

    public final SpannableStringBuilder mo56a(Params params) {
        return m1383a(params, new StyleParamsBuilder(this.f1308c).m1374a());
    }

    public final SpannableStringBuilder m1383a(Params params, StyleParams styleParams) {
        if (params.f1283a == null) {
            return this.f1306a.m1368a(params, styleParams);
        }
        return this.f1307b.m1394a(params, styleParams);
    }

    public static MetaTextBuilderDelegate m1380a(InjectorLike injectorLike) {
        return m1381b(injectorLike);
    }
}
