package com.facebook.commerce.core.ui;

import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: prev_tab_name */
public class PageInfoViewProvider extends AbstractAssistedProvider<PageInfoView> {
    public final PageInfoView m10652a(ContentView contentView) {
        return new PageInfoView(CommerceNavigationUtil.m10681a((InjectorLike) this), contentView);
    }
}
