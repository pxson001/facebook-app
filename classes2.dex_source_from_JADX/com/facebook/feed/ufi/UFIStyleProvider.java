package com.facebook.feed.ufi;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.feed.ufi.UFIFooterButtonStyleDefinition.FooterLayoutType;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommonex.LocaleChangeController;

/* compiled from: get_media_resp */
public class UFIStyleProvider extends AbstractAssistedProvider<UFIStyle> {
    public final UFIStyle m30342a(FooterLayoutType footerLayoutType) {
        return new UFIStyle(footerLayoutType, ResourcesMethodAutoProvider.m6510a(this), LocaleChangeController.m29097a((InjectorLike) this));
    }
}
