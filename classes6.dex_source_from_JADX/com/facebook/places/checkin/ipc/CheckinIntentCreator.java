package com.facebook.places.checkin.ipc;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.model.ComposerEntryPicker;
import com.facebook.ipc.composer.model.ComposerLaunchLoggingParams;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration.Builder;
import com.google.common.base.Preconditions;

/* compiled from: friendListPrivacyOptions */
public class CheckinIntentCreator {
    public static Intent m22221a(Context context, PlacePickerConfiguration placePickerConfiguration) {
        Preconditions.checkNotNull(placePickerConfiguration);
        if (placePickerConfiguration.f14648i) {
            ComposerConfiguration composerConfiguration = (ComposerConfiguration) Preconditions.checkNotNull(placePickerConfiguration.f14642c);
            Builder builder = new Builder(placePickerConfiguration);
            builder.f14617c = ComposerConfiguration.m18225a(composerConfiguration).setLaunchLoggingParams(ComposerLaunchLoggingParams.a(composerConfiguration.getLaunchLoggingParams()).setEntryPicker(ComposerEntryPicker.PLACE_PICKER).a()).m18223a();
            Builder builder2 = builder;
            if (placePickerConfiguration.f14644e == null) {
                builder2.f14619e = SafeUUIDGenerator.a().toString();
            }
            placePickerConfiguration = builder2.m22222a();
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.facebook.places.checkin.activity.SelectAtTagActivity");
        intent.putExtra("place_picker_configuration", placePickerConfiguration);
        return intent;
    }
}
