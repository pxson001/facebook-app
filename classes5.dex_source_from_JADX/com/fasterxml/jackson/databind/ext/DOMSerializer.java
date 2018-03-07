package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;

/* compiled from: charOffset */
public class DOMSerializer extends StdSerializer<Node> {
    protected final DOMImplementationLS f6110a;

    public final void m11370a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Node node = (Node) obj;
        if (this.f6110a == null) {
            throw new IllegalStateException("Could not find DOM LS");
        }
        jsonGenerator.b(this.f6110a.createLSSerializer().writeToString(node));
    }

    public DOMSerializer() {
        super(Node.class);
        try {
            this.f6110a = (DOMImplementationLS) DOMImplementationRegistry.newInstance().getDOMImplementation("LS");
        } catch (Throwable e) {
            throw new IllegalStateException("Could not instantiate DOMImplementationRegistry: " + e.getMessage(), e);
        }
    }
}
