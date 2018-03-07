package com.google.android.gms.location.places.internal;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity.SubstringEntity;
import java.util.Collections;
import java.util.List;

public class zzb extends zzu implements AutocompletePrediction {
    public zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private String m9009g() {
        return m9004a("ap_primary_text", "");
    }

    private String m9010h() {
        return m9004a("ap_secondary_text", "");
    }

    private List<SubstringEntity> m9011j() {
        return m9005a("ap_primary_text_matched", SubstringEntity.CREATOR, Collections.emptyList());
    }

    private List<SubstringEntity> m9012k() {
        return m9005a("ap_secondary_text_matched", SubstringEntity.CREATOR, Collections.emptyList());
    }

    public final CharSequence mo488a(CharacterStyle characterStyle) {
        return zzc.m9017a(m9009g(), m9011j(), characterStyle);
    }

    public final Object m9014a() {
        return AutocompletePredictionEntity.m8974a(mo490b(), m9006a("ap_place_types", Collections.emptyList()), m9002a("ap_personalization_type", 6), m9004a("ap_description", ""), m9005a("ap_matched_subscriptions", SubstringEntity.CREATOR, Collections.emptyList()), m9009g(), m9011j(), m9010h(), m9012k());
    }

    public final CharSequence mo489b(CharacterStyle characterStyle) {
        return zzc.m9017a(m9010h(), m9012k(), characterStyle);
    }

    public final String mo490b() {
        return m9004a("ap_place_id", null);
    }
}
