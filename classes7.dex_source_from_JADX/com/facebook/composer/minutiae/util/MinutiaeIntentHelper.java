package com.facebook.composer.minutiae.util;

import android.content.Context;
import android.content.Intent;
import com.facebook.composer.minutiae.MinutiaeConstants.TargetFragment;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLInterfaces.MinutiaeTaggableSuggestions;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration.Action;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: text_filled */
public class MinutiaeIntentHelper {
    public static Intent m1819a(Context context, ComposerConfiguration composerConfiguration, @Nullable String str, MinutiaeTaggableActivity minutiaeTaggableActivity, String str2, @Nullable String str3) {
        Builder b = MinutiaeConfiguration.m1813b();
        b.f1823b = TargetFragment.VERB_PICKER;
        b = b;
        b.f1826e = minutiaeTaggableActivity;
        b = b;
        b.f1829h = Action.LAUNCH_COMPOSER;
        b = b;
        b.f1830i = composerConfiguration;
        b = b;
        b.f1822a = str;
        b = b;
        b.f1833l = str2;
        b = b;
        b.f1834m = str3;
        Builder c = b.m1811a().m1815c();
        c.f1826e = minutiaeTaggableActivity;
        c = c;
        c.f1823b = TargetFragment.OBJECT_PICKER;
        Builder builder = c;
        builder.f1828g = true;
        return builder.m1809a(context);
    }

    public static Intent m1818a(Context context, MinutiaeObject minutiaeObject, String str, ComposerConfiguration composerConfiguration, CheckinPlace checkinPlace, List<? extends MinutiaeTaggableSuggestions> list, boolean z) {
        Builder b = MinutiaeConfiguration.m1813b();
        b.f1825d = minutiaeObject;
        b = b;
        b.f1822a = str;
        b = b;
        b.f1823b = TargetFragment.VERB_PICKER;
        Builder builder = b;
        builder.f1830i = composerConfiguration;
        builder = builder;
        builder.f1824c = list;
        builder = builder;
        builder.f1828g = true;
        builder = builder.m1810a((CheckinPlaceModel) checkinPlace);
        builder.f1831j = z;
        return builder.m1809a(context);
    }
}
