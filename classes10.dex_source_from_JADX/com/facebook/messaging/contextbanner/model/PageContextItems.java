package com.facebook.messaging.contextbanner.model;

import android.content.res.Resources;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import com.facebook.messaging.contextbanner.graphql.PageContextQueryModels.PageContextQueryModel;
import com.facebook.messaging.contextbanner.graphql.PageContextQueryModels.PageContextQueryModel.MessengerContextBannerModel.SubtitlesModel;
import com.facebook.messaging.model.threads.ThreadSummary;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: store_url_web_fallback */
public class PageContextItems implements ContextItems {
    private final ThreadSummary f2219a;
    public final PageContextQueryModel f2220b;
    public final Resources f2221c;

    @Inject
    public PageContextItems(@Assisted PageContextQueryModel pageContextQueryModel, @Assisted ThreadSummary threadSummary, Resources resources) {
        this.f2220b = pageContextQueryModel;
        this.f2219a = threadSummary;
        this.f2221c = resources;
    }

    @Nullable
    public final String mo60a() {
        String str;
        if (m2094d()) {
            if (this.f2220b.m2045d() == null) {
                str = null;
            } else {
                str = this.f2221c.getString(2131241192, new Object[]{this.f2220b.m2045d()});
            }
            return str;
        }
        if (this.f2220b.m2044c() == null || this.f2220b.m2044c().m2033b() == null || StringUtil.a(this.f2220b.m2044c().m2033b().m2028a())) {
            str = null;
        } else {
            str = this.f2220b.m2044c().m2033b().m2028a();
        }
        return str;
    }

    @Nullable
    public final String mo61b() {
        if (this.f2220b.m2044c() == null || this.f2220b.m2044c().m2032a() == null || this.f2220b.m2044c().m2032a().isEmpty()) {
            return null;
        }
        SubtitlesModel subtitlesModel = (SubtitlesModel) this.f2220b.m2044c().m2032a().get(0);
        if (subtitlesModel.m2023a() == null) {
            return null;
        }
        return subtitlesModel.m2023a();
    }

    @Nullable
    public final String mo62c() {
        return null;
    }

    public final boolean m2094d() {
        return this.f2220b.m2043b() && this.f2219a != null && this.f2219a.A.isMessageRequestFolders();
    }
}
