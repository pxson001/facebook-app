package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: single_buffer */
public abstract class NodeCursor extends JsonStreamContext {
    public final NodeCursor f2150c;
    protected String f2151d;

    /* compiled from: single_buffer */
    public final class Object extends NodeCursor {
        protected Iterator<Entry<String, JsonNode>> f2147e;
        protected Entry<String, JsonNode> f2148f;
        protected boolean f2149g = true;

        public final /* synthetic */ JsonStreamContext mo150a() {
            return this.f2150c;
        }

        public Object(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(2, nodeCursor);
            this.f2147e = ((ObjectNode) jsonNode).H();
        }

        public final JsonToken mo151j() {
            if (!this.f2149g) {
                this.f2149g = true;
                return ((JsonNode) this.f2148f.getValue()).a();
            } else if (this.f2147e.hasNext()) {
                this.f2149g = false;
                this.f2148f = (Entry) this.f2147e.next();
                this.d = this.f2148f == null ? null : (String) this.f2148f.getKey();
                return JsonToken.FIELD_NAME;
            } else {
                this.d = null;
                this.f2148f = null;
                return null;
            }
        }

        public final JsonToken mo152k() {
            return JsonToken.END_OBJECT;
        }

        public final JsonNode mo153l() {
            return this.f2148f == null ? null : (JsonNode) this.f2148f.getValue();
        }

        public final boolean mo154m() {
            return ((ContainerNode) mo153l()).e() > 0;
        }
    }

    public abstract JsonToken mo151j();

    public abstract JsonToken mo152k();

    public abstract JsonNode mo153l();

    public abstract boolean mo154m();

    public NodeCursor(int i, NodeCursor nodeCursor) {
        this.a = i;
        this.b = -1;
        this.f2150c = nodeCursor;
    }

    public /* synthetic */ JsonStreamContext mo150a() {
        return this.f2150c;
    }

    public final NodeCursor m2295i() {
        return this.f2150c;
    }

    public final String m2294h() {
        return this.f2151d;
    }

    public final NodeCursor m2300n() {
        JsonNode l = mo153l();
        if (l == null) {
            throw new IllegalStateException("No current node");
        } else if (l.h()) {
            return new Array(l, this);
        } else {
            if (l.i()) {
                return new Object(l, this);
            }
            throw new IllegalStateException("Current node of type " + l.getClass().getName());
        }
    }
}
