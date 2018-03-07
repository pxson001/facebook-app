package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: capacity <= 0 */
public final class NodeCursor$RootValue extends NodeCursor {
    protected JsonNode f6152e;
    protected boolean f6153f = false;

    public final /* synthetic */ JsonStreamContext m11542a() {
        return this.c;
    }

    public NodeCursor$RootValue(JsonNode jsonNode, NodeCursor nodeCursor) {
        super(0, nodeCursor);
        this.f6152e = jsonNode;
    }

    public final JsonToken m11543j() {
        if (this.f6153f) {
            this.f6152e = null;
            return null;
        }
        this.f6153f = true;
        return this.f6152e.a();
    }

    public final JsonToken m11544k() {
        return null;
    }

    public final JsonNode m11545l() {
        return this.f6152e;
    }

    public final boolean m11546m() {
        return false;
    }
}
