package com.facebook.feedplugins.graphqlstory.translation;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition.4;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: dont_append_here */
public class SeeTranslationPartDefinition$2 implements OnClickListener {
    final /* synthetic */ TranslatedTextPersistentState f13713a;
    final /* synthetic */ HasPositionInformation f13714b;
    final /* synthetic */ FeedProps f13715c;
    final /* synthetic */ SeeTranslationPartDefinition f13716d;

    public SeeTranslationPartDefinition$2(SeeTranslationPartDefinition seeTranslationPartDefinition, TranslatedTextPersistentState translatedTextPersistentState, HasPositionInformation hasPositionInformation, FeedProps feedProps) {
        this.f13716d = seeTranslationPartDefinition;
        this.f13713a = translatedTextPersistentState;
        this.f13714b = hasPositionInformation;
        this.f13715c = feedProps;
    }

    public void onClick(View view) {
        Object obj;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1930324927);
        TranslationView translationView = (TranslationView) view;
        if (translationView.f13698b.getVisibility() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null || this.f13713a.f13712b) {
            Logger.a(2, EntryType.UI_INPUT_END, -2051609863, a);
            return;
        }
        this.f13713a.f13712b = true;
        translationView.f13699c.setVisibility(0);
        SeeTranslationPartDefinition seeTranslationPartDefinition = this.f13716d;
        HasPositionInformation hasPositionInformation = this.f13714b;
        FeedProps feedProps = this.f13715c;
        seeTranslationPartDefinition.f.d = new 4(seeTranslationPartDefinition, hasPositionInformation, feedProps);
        this.f13716d.f.a((GraphQLStory) this.f13715c.a, this.f13713a);
        LogUtils.a(-1199639983, a);
    }
}
