package com.facebook.saved2.ui.contextmenu;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import com.facebook.analytics.CurationMechanism;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;

/* compiled from: instant_articles_base_view_creation */
public interface Saved2ContextMenuItem {
    @StringRes
    int mo445a();

    @DrawableRes
    int mo446b();

    boolean mo447b(BaseQueryDAO baseQueryDAO);

    CurationMechanism mo448c();
}
