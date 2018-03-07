package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.ObjectCodec;

/* compiled from: promo_banner */
public class MappingJsonFactory extends JsonFactory {
    private static final long serialVersionUID = -6744103724013275513L;

    public MappingJsonFactory() {
        this(null);
    }

    public MappingJsonFactory(ObjectMapper objectMapper) {
        super((ObjectCodec) objectMapper);
        if (objectMapper == null) {
            this._objectCodec = new ObjectMapper(this);
        }
    }

    public final ObjectCodec mo1827a() {
        return (ObjectMapper) this._objectCodec;
    }
}
