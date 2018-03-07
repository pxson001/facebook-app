package com.facebook.saved2.ui.contextmenu;

import android.content.Context;
import com.facebook.analytics.CurationMechanism;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import javax.inject.Inject;

/* compiled from: initial_tab */
public class Saved2ViewPostMenuItem implements Saved2ContextMenuItem {
    private final Context f9579a;
    private final Lazy<ViewPermalinkIntentFactory> f9580b;
    private final Lazy<SecureContextHelper> f9581c;

    @Inject
    public Saved2ViewPostMenuItem(@Assisted Context context, Lazy<ViewPermalinkIntentFactory> lazy, Lazy<SecureContextHelper> lazy2) {
        this.f9579a = context;
        this.f9580b = lazy;
        this.f9581c = lazy2;
    }

    public final int mo445a() {
        return 2131238181;
    }

    public final int mo446b() {
        return 2130840052;
    }

    public final boolean mo447b(BaseQueryDAO baseQueryDAO) {
        Builder builder = new Builder();
        builder.a = baseQueryDAO.s();
        ((SecureContextHelper) this.f9581c.get()).a(((ViewPermalinkIntentFactory) this.f9580b.get()).a(builder.a()), this.f9579a);
        return true;
    }

    public final CurationMechanism mo448c() {
        return CurationMechanism.VIEW_POST_BUTTON;
    }
}
