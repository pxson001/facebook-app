package com.facebook.storygallerysurvey.activity;

import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLStoryGallerySurveyFeedUnit;

@UriMatchPatterns
/* compiled from: NotesLoad */
public class StoryGallerySurveyWithStoryActivity extends FbFragmentActivity {
    public GraphQLStoryGallerySurveyFeedUnit f12925p = null;

    protected final void m13626b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130907254);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f12925p = (GraphQLStoryGallerySurveyFeedUnit) FlatBufferModelHelper.a(extras, "story_gallery_survey_feed_unit");
        }
    }

    public final GraphQLStoryGallerySurveyFeedUnit m13627i() {
        return this.f12925p;
    }
}
