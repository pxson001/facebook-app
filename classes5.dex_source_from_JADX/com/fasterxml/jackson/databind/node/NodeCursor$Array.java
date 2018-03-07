package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;

/* compiled from: capacity <= 0 */
public final class NodeCursor$Array extends NodeCursor {
    protected Iterator<JsonNode> f6150e;
    protected JsonNode f6151f;

    public final /* synthetic */ JsonStreamContext m11537a() {
        return this.c;
    }

    public NodeCursor$Array(JsonNode jsonNode, NodeCursor nodeCursor) {
        super(1, nodeCursor);
        this.f6150e = jsonNode.G();
    }

    public final JsonToken m11538j() {
        if (this.f6150e.hasNext()) {
            this.f6151f = (JsonNode) this.f6150e.next();
            return this.f6151f.a();
        }
        this.f6151f = null;
        return null;
    }

    public final JsonToken m11539k() {
        return JsonToken.END_ARRAY;
    }

    public final JsonNode m11540l() {
        return this.f6151f;
    }

    public final boolean m11541m() {
        return ((ContainerNode) m11540l()).e() > 0;
    }
}
