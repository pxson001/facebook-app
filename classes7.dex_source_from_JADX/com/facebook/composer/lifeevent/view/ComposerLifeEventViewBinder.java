package com.facebook.composer.lifeevent.view;

import android.content.res.Resources;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.graphql.enums.GraphQLLifeEventAPIIdentifier;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;

/* compiled from: context_item_target_type */
public class ComposerLifeEventViewBinder {
    public static void m20815a(Resources resources, ComposerLifeEventEditor composerLifeEventEditor, ComposerLifeEventModel composerLifeEventModel, TextWatcher textWatcher, OnClickListener onClickListener) {
        if (composerLifeEventModel.b == GraphQLLifeEventAPIIdentifier.STARTED_JOB || composerLifeEventModel.b == GraphQLLifeEventAPIIdentifier.GRADUATED) {
            composerLifeEventEditor.setIsTitleEditable(false);
        } else {
            composerLifeEventEditor.setIsTitleEditable(true);
        }
        composerLifeEventEditor.setTitle(composerLifeEventModel.a);
        composerLifeEventEditor.mo1293a(textWatcher);
        DefaultImageFieldsModel defaultImageFieldsModel = composerLifeEventModel.c;
        composerLifeEventEditor.setIconUri(defaultImageFieldsModel == null ? null : defaultImageFieldsModel.b());
        if (defaultImageFieldsModel != null) {
            composerLifeEventEditor.setIconSize(resources.getDimensionPixelSize(2131429327));
        }
        composerLifeEventEditor.setOnClickListener(onClickListener);
    }
}
