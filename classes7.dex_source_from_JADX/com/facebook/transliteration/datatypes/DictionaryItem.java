package com.facebook.transliteration.datatypes;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@AutoGenJsonDeserializer
/* compiled from: example_frame_image */
public class DictionaryItem implements LanguageModel {
    @JsonProperty("dictionary")
    public Map<String, String> mDictionary;
}
