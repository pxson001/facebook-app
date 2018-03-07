package com.facebook.composer.util;

import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;

/* compiled from: tapped_friend_timeline */
public class ComposerTagComparatorProvider extends AbstractAssistedProvider<ComposerTagComparator> {
    public static <DataProvider extends ProvidesConfiguration & ProvidesLocationInfo & ProvidesTaggedUsers & ProvidesMinutiae> ComposerTagComparator<DataProvider> m2086a(DataProvider dataProvider) {
        return new ComposerTagComparator((ProvidesConfiguration) dataProvider);
    }
}
