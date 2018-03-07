package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.ViewBindingsMap;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: device_based_login_logging_sampling_rate */
public class PageItems {
    private final ArrayList<PageItem> f13917a = new ArrayList();
    private final PagerBinderDelegate f13918b;
    public final Lazy<FbErrorReporter> f13919c;
    private RowKey f13920d;
    public AnyEnvironment f13921e;

    @Inject
    public PageItems(@Assisted PagerBinderDelegate pagerBinderDelegate, Lazy<FbErrorReporter> lazy) {
        this.f13918b = pagerBinderDelegate;
        this.f13919c = lazy;
        for (int i = 0; i < this.f13918b.m14715e(); i++) {
            this.f13917a.add(null);
        }
    }

    public final void m14718a(RowKey rowKey) {
        this.f13920d = rowKey;
    }

    public final void m14719a(AnyEnvironment anyEnvironment) {
        this.f13921e = anyEnvironment;
    }

    @Nullable
    public final PageItem m14716a(int i) {
        Preconditions.checkNotNull(this.f13921e, "Environment must be set in advance.");
        if (i >= this.f13917a.size() || i >= this.f13918b.m14715e()) {
            return null;
        }
        PageItem pageItem = (PageItem) this.f13917a.get(i);
        if (pageItem != null) {
            return pageItem;
        }
        pageItem = this.f13918b.m14710a(i);
        this.f13917a.set(i, pageItem);
        return pageItem;
    }

    public final void m14721c(int i) {
        TracerDetour.a("PageItems.preparePageItem", -758978759);
        try {
            PageItem a = m14716a(i);
            if (a != null) {
                a.m14748a(this.f13920d, this.f13921e);
            }
            TracerDetour.a(-1795818876);
        } catch (Throwable th) {
            TracerDetour.a(-1567735294);
        }
    }

    public final void m14717a(int i, View view) {
        TracerDetour.a("PageItems.bindPageItem", 871426472);
        try {
            PageItem a = m14716a(i);
            if (a != null) {
                a.m14749a(this.f13920d, this.f13921e, view);
                ViewBindingsMap.a(view, a.m14750b(), (AbstractFbErrorReporter) this.f13919c.get());
            }
            TracerDetour.a(1472234066);
        } catch (Throwable th) {
            TracerDetour.a(483288145);
        }
    }

    public final int m14720b() {
        return this.f13917a.size();
    }
}
