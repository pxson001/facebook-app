package com.facebook.crowdsourcing.picker;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldMutator;
import com.facebook.ipc.model.PageTopic;
import com.facebook.places.pagetopics.logging.PlaceCategoryPickerLoggerFactory.Type;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.livephotos.exoplayer.extractor.ts.TsExtractor */
public class CategoryPicker implements SuggestEditsPicker<SuggestEditsField> {
    private final Provider<ComponentName> f17441a;

    public final Object mo1364a(Intent intent, Object obj) {
        return SuggestEditsFieldMutator.m21496a((SuggestEditsField) obj, (PageTopic) intent.getParcelableExtra("extra_picked_category"));
    }

    @Inject
    public CategoryPicker(@FragmentChromeActivity Provider<ComponentName> provider) {
        this.f17441a = provider;
    }

    public final Intent mo1362a(Object obj, Fragment fragment) {
        Intent component = new Intent().setComponent((ComponentName) this.f17441a.get());
        component.putExtra("target_fragment", ContentFragmentType.CATEGORY_PICKER_FRAGMENT.ordinal());
        component.putExtra("extra_logger_type", Type.NO_LOGGER);
        return component;
    }

    public final SuggestEditsInputType mo1363a() {
        return SuggestEditsInputType.CATEGORY_PICKER;
    }
}
