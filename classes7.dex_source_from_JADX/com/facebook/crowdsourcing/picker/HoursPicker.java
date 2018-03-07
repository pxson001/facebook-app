package com.facebook.crowdsourcing.picker;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.helper.HoursData;
import com.facebook.crowdsourcing.helper.HoursDataHelper;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedHours;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsHoursFieldMutator;
import com.facebook.crowdsourcing.suggestedits.helper.ExtractValuesHelper;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.livephotos.exoplayer.extractor.ts.AdtsExtractor */
public class HoursPicker implements SuggestEditsPicker<SuggestEditsField> {
    public static final Map<GraphQLSuggestEditsFieldOptionType, Integer> f17443a = new Builder().b(GraphQLSuggestEditsFieldOptionType.HAS_VALUE, Integer.valueOf(0)).b(GraphQLSuggestEditsFieldOptionType.ALWAYS_OPEN, Integer.valueOf(1)).b(GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE, Integer.valueOf(2)).b(GraphQLSuggestEditsFieldOptionType.PERMANENTLY_CLOSED, Integer.valueOf(3)).b();
    private Provider<ComponentName> f17444b;
    private final HoursDataHelper f17445c;

    public final Intent mo1362a(Object obj, Fragment fragment) {
        Bundle bundle;
        SuggestEditsField suggestEditsField = (SuggestEditsField) obj;
        Intent component = new Intent().setComponent((ComponentName) this.f17444b.get());
        component.putExtra("target_fragment", ContentFragmentType.SUGGEST_EDITS_HOURS_PICKER_FRAGMENT.ordinal());
        Bundle bundle2 = new Bundle();
        if (f17443a.containsKey(suggestEditsField.ew_())) {
            bundle2.putInt("extra_hours_selected_option", ((Integer) f17443a.get(suggestEditsField.ew_())).intValue());
        }
        if (suggestEditsField.ew_() == GraphQLSuggestEditsFieldOptionType.HAS_VALUE) {
            CrowdsourcedHours f = ExtractValuesHelper.m21538f(suggestEditsField);
            if (f == null) {
                bundle = bundle2;
                component.putExtras(bundle);
                return component;
            }
            Parcelable hoursData = new HoursData();
            for (int i = 1; i <= 7; i++) {
                hoursData.m21323a(i, HoursDataHelper.m21324a(i, f));
            }
            bundle2.putParcelable("extra_hours_data", hoursData);
        }
        bundle = bundle2;
        component.putExtras(bundle);
        return component;
    }

    public final Object mo1364a(Intent intent, Object obj) {
        SuggestEditsField suggestEditsField = (SuggestEditsField) obj;
        int intExtra = intent.getIntExtra("extra_hours_selected_option", -1);
        return intExtra == -1 ? suggestEditsField : SuggestEditsHoursFieldMutator.m21516a(suggestEditsField, intExtra, (HoursData) intent.getParcelableExtra("extra_hours_data"));
    }

    @Inject
    public HoursPicker(@FragmentChromeActivity Provider<ComponentName> provider, HoursDataHelper hoursDataHelper) {
        this.f17444b = provider;
        this.f17445c = hoursDataHelper;
    }

    public final SuggestEditsInputType mo1363a() {
        return SuggestEditsInputType.HOURS_PICKER;
    }
}
