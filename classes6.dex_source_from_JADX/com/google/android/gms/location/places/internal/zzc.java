package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity.SubstringEntity;
import java.util.List;

public class zzc {
    public static CharSequence m9017a(String str, List<SubstringEntity> list, CharacterStyle characterStyle) {
        if (characterStyle == null) {
            return str;
        }
        CharSequence spannableString = new SpannableString(str);
        for (SubstringEntity substringEntity : list) {
            spannableString.setSpan(CharacterStyle.wrap(characterStyle), substringEntity.f6485b, substringEntity.f6486c + substringEntity.f6485b, 0);
        }
        return spannableString;
    }
}
