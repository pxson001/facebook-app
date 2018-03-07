package com.facebook.pages.identity.contextitems;

import android.app.Activity;
import android.view.View;
import com.facebook.common.util.ContextUtils;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import javax.inject.Inject;

/* compiled from: phone_line_two_area_code */
public class PageContextItemsLaunchComposerHandler {
    private final ComposerIntentLauncher f3841a;
    public final ComposerLauncher f3842b;
    public final DefaultPageSurfaceIntentBuilder f3843c;

    @Inject
    public PageContextItemsLaunchComposerHandler(ComposerIntentLauncher composerIntentLauncher, ComposerLauncher composerLauncher, DefaultPageSurfaceIntentBuilder defaultPageSurfaceIntentBuilder) {
        this.f3841a = composerIntentLauncher;
        this.f3842b = composerLauncher;
        this.f3843c = defaultPageSurfaceIntentBuilder;
    }

    public final void m4781a(View view, ContextItemFieldsModel contextItemFieldsModel, PageContextItemHandlingData pageContextItemHandlingData) {
        GraphQLEntityCardContextItemType d = contextItemFieldsModel.d();
        Activity activity = (Activity) ContextUtils.a(view.getContext(), Activity.class);
        if (d == GraphQLEntityCardContextItemType.ADMIN_TIP_CREATE_POST) {
            this.f3842b.a(null, this.f3843c.a(pageContextItemHandlingData.a, pageContextItemHandlingData.e, pageContextItemHandlingData.f, pageContextItemHandlingData.i).a(), 1756, activity);
        } else if (d == GraphQLEntityCardContextItemType.ADMIN_TIP_CREATE_PHOTO_POST) {
            m4780b(pageContextItemHandlingData, activity);
        }
    }

    private void m4780b(PageContextItemHandlingData pageContextItemHandlingData, Activity activity) {
        this.f3841a.a(this.f3843c.b(pageContextItemHandlingData.a, pageContextItemHandlingData.e, pageContextItemHandlingData.f, pageContextItemHandlingData.i), 1756, activity);
    }
}
