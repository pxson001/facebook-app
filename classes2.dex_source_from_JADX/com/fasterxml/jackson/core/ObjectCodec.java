package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Iterator;

/* compiled from: streaming_fetch_story_count_by_cc */
public abstract class ObjectCodec {
    @Deprecated
    public abstract JsonFactory mo905a();

    public abstract <T extends TreeNode> T mo906a(JsonParser jsonParser);

    public abstract <T> T mo907a(JsonParser jsonParser, TypeReference<?> typeReference);

    public abstract <T> T mo908a(JsonParser jsonParser, Class<T> cls);

    public abstract void mo909a(JsonGenerator jsonGenerator, Object obj);

    public abstract <T> Iterator<T> mo911b(JsonParser jsonParser, Class<T> cls);

    protected ObjectCodec() {
    }

    public JsonFactory mo910b() {
        return mo905a();
    }
}
