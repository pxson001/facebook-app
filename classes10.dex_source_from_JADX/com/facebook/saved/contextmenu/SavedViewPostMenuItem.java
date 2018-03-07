package com.facebook.saved.contextmenu;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.facebook.analytics.CurationMechanism;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.saved.contextmenu.interfaces.SavableItemWrapper;
import com.facebook.saved.contextmenu.interfaces.SavedContextMenuItem;
import com.google.common.base.Strings;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: is_preview */
public class SavedViewPostMenuItem implements SavedContextMenuItem<SavableItemWrapper> {
    private final Resources f8995a;
    private final ViewPermalinkIntentFactory f8996b;
    private final SecureContextHelper f8997c;

    public final String mo410a(Object obj) {
        if (Strings.isNullOrEmpty(((SavableItemWrapper) obj).mo431h())) {
            return null;
        }
        return this.f8995a.getString(2131238188, new Object[]{r0});
    }

    public final boolean mo411a(Object obj, Fragment fragment) {
        String g = ((SavableItemWrapper) obj).mo430g();
        Builder builder = new Builder();
        builder.a = g;
        this.f8997c.a(this.f8996b.a(builder.a()), fragment.getContext());
        return true;
    }

    public final boolean mo413b(Object obj) {
        return !StringUtil.a(((SavableItemWrapper) obj).mo430g());
    }

    @Inject
    public SavedViewPostMenuItem(Resources resources, ViewPermalinkIntentFactory viewPermalinkIntentFactory, SecureContextHelper secureContextHelper) {
        this.f8995a = resources;
        this.f8996b = viewPermalinkIntentFactory;
        this.f8997c = secureContextHelper;
    }

    public final Class<SavableItemWrapper> mo409a() {
        return SavableItemWrapper.class;
    }

    @Nonnull
    public final CurationMechanism mo414c() {
        return CurationMechanism.VIEW_POST_BUTTON;
    }

    public final String mo412b() {
        return this.f8995a.getString(2131238181);
    }

    public final int mo415d() {
        return 2130843248;
    }
}
