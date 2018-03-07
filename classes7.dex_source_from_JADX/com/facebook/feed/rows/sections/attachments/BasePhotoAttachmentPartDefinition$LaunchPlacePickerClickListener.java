package com.facebook.feed.rows.sections.attachments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import com.facebook.attachments.photos.ui.HasPhotoAttachment;
import com.facebook.attachments.photos.ui.HasPhotoAttachment.OnPhotoClickListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration.Builder;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.launcher.PlacePickerLauncher;

/* compiled from: [F>; */
class BasePhotoAttachmentPartDefinition$LaunchPlacePickerClickListener implements OnPhotoClickListener {
    final /* synthetic */ BasePhotoAttachmentPartDefinition f20546a;
    private final FeedProps<GraphQLStoryAttachment> f20547b;

    public BasePhotoAttachmentPartDefinition$LaunchPlacePickerClickListener(BasePhotoAttachmentPartDefinition basePhotoAttachmentPartDefinition, FeedProps<GraphQLStoryAttachment> feedProps) {
        this.f20546a = basePhotoAttachmentPartDefinition;
        this.f20547b = feedProps;
    }

    @SuppressLint({"DeprecatedClass"})
    public final <T extends View & HasPhotoAttachment> void m23604a(T t, boolean z, int i) {
        this.f20546a.i.b(AttachmentProps.c(this.f20547b));
        ((HasPhotoAttachment) t).a(0, 0);
        Activity activity = (Activity) ContextUtils.a(t.getContext(), Activity.class);
        PlacePickerLauncher placePickerLauncher = (PlacePickerLauncher) this.f20546a.g.get();
        String b = ((GraphQLStoryAttachment) this.f20547b.a).r().b();
        Builder a = PlacePickerLauncher.m13010a(SearchType.PHOTO, "edit_photo_location", null);
        a.l = b;
        ((SecureContextHelper) placePickerLauncher.f11026a.get()).a(CheckinIntentCreator.a(activity, a.a()), 5002, activity);
    }
}
