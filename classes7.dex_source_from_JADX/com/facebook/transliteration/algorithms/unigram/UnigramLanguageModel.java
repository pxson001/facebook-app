package com.facebook.transliteration.algorithms.unigram;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.transliteration.datatypes.LanguageModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@AutoGenJsonDeserializer
/* compiled from: extra_album */
public class UnigramLanguageModel implements LanguageModel {
    @JsonProperty("locale")
    public String mLocale;
    @JsonProperty("model")
    public Map<String, UnigramModelDataItem> mModel;
    @JsonProperty("version")
    public int mVersion;
}
