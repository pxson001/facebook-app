package com.facebook.storygallerysurvey.controllers;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.storygallerysurvey.fetchers.StoryGallerySurveyWithStoryFetcher;
import com.facebook.storygallerysurvey.fragment.StoryGallerySurveyWithStoryFragment.StoryGallerySurveyWithStoryControllerCallback;
import com.facebook.storygallerysurvey.protocol.FetchStoryGallerySurveyWithStoryGraphQLModels.FetchStoryGallerySurveyWithStoryQueryModel.StoryGallerySurveyModel.NodesModel;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;

/* compiled from: NoteQuery */
public class StoryGallerySurveyWithStoryController {
    public static final String f12927a = StoryGallerySurveyWithStoryController.class.getName();
    public final AbstractFbErrorReporter f12928b;
    public final StoryGallerySurveyWithStoryFetcher f12929c;
    public FutureCallback<ImmutableList<NodesModel>> f12930d = new C15251(this);
    public StoryGallerySurveyWithStoryControllerCallback f12931e;
    public ImmutableList<NodesModel> f12932f;
    public int f12933g;

    /* compiled from: NoteQuery */
    public class C15251 implements FutureCallback<ImmutableList<NodesModel>> {
        final /* synthetic */ StoryGallerySurveyWithStoryController f12926a;

        public C15251(StoryGallerySurveyWithStoryController storyGallerySurveyWithStoryController) {
            this.f12926a = storyGallerySurveyWithStoryController;
        }

        public void onSuccess(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            StoryGallerySurveyWithStoryController storyGallerySurveyWithStoryController = this.f12926a;
            storyGallerySurveyWithStoryController.f12932f = immutableList;
            storyGallerySurveyWithStoryController.f12931e.m13637a();
            storyGallerySurveyWithStoryController.f12931e.m13638b();
        }

        public void onFailure(Throwable th) {
            this.f12926a.f12928b.a("fail_to_fetch_story_gallery_survey_with_story", th.getMessage(), th);
        }
    }

    private static StoryGallerySurveyWithStoryController m13628b(InjectorLike injectorLike) {
        return new StoryGallerySurveyWithStoryController((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StoryGallerySurveyWithStoryFetcher.m13634b(injectorLike));
    }

    @Inject
    public StoryGallerySurveyWithStoryController(AbstractFbErrorReporter abstractFbErrorReporter, StoryGallerySurveyWithStoryFetcher storyGallerySurveyWithStoryFetcher) {
        this.f12928b = abstractFbErrorReporter;
        this.f12929c = storyGallerySurveyWithStoryFetcher;
    }

    public final ImmutableList<NodesModel> m13629c() {
        Collection arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            if (this.f12933g < this.f12932f.size()) {
                NodesModel nodesModel;
                if (this.f12933g < this.f12932f.size()) {
                    nodesModel = (NodesModel) this.f12932f.get(this.f12933g);
                } else {
                    this.f12928b.b(f12927a, "survey unit index out of bound");
                    nodesModel = null;
                }
                arrayList.add(nodesModel);
                this.f12933g++;
            }
        }
        return ImmutableList.copyOf(arrayList);
    }

    public final int m13630d() {
        return this.f12932f.size() / 2;
    }

    public final int m13631e() {
        return this.f12933g / 2;
    }
}
