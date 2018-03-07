package com.facebook.transliteration.api;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;

@AutoGenJsonDeserializer
/* compiled from: expected characters 'vorbis' */
public class TransliterationModelResponse {
    @JsonProperty("dictionary")
    public final String mDictionary = null;
    @JsonProperty("language_model")
    public final String mLanguageModel = null;
    @JsonProperty("version")
    public final Integer mVersion = Integer.valueOf(0);

    public final String m19146a() {
        return this.mLanguageModel;
    }

    public final String m19147b() {
        return this.mDictionary;
    }

    public final String m19148c() {
        return "{ \"dictionary\" : " + this.mDictionary + " }";
    }
}
