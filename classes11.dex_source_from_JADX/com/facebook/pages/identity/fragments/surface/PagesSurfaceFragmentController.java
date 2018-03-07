package com.facebook.pages.identity.fragments.surface;

import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragmentModel.Builder;
import javax.inject.Inject;

/* compiled from: page_video_list_max_videos */
public class PagesSurfaceFragmentController {
    public PagesExperimentUtils f4112a;

    public static PagesSurfaceFragmentController m5053a(InjectorLike injectorLike) {
        return new PagesSurfaceFragmentController(PagesExperimentUtils.a(injectorLike));
    }

    @Inject
    public PagesSurfaceFragmentController(PagesExperimentUtils pagesExperimentUtils) {
        this.f4112a = pagesExperimentUtils;
    }

    public static PagesSurfaceFragmentModel m5054a(PagesSurfaceFragmentModel pagesSurfaceFragmentModel, FetchPageHeaderQueryModel fetchPageHeaderQueryModel) {
        Builder a = Builder.m5055a(pagesSurfaceFragmentModel);
        if (new ProfilePermissions(fetchPageHeaderQueryModel.af()).a(Permission.BASIC_ADMIN)) {
            a.f4114b = TriState.YES;
        } else {
            a.f4114b = TriState.NO;
        }
        return a.m5056a();
    }
}
