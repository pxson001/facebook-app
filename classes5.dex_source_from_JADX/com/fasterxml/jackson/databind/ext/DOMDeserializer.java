package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/* compiled from: charity */
public abstract class DOMDeserializer<T> extends FromStringDeserializer<T> {
    private static final DocumentBuilderFactory f6109a;
    private static final long serialVersionUID = 1;

    /* compiled from: charity */
    public class DocumentDeserializer extends DOMDeserializer<Document> {
        private static final long serialVersionUID = 1;

        public DocumentDeserializer() {
            super(Document.class);
        }

        public final Object mo692a(String str, DeserializationContext deserializationContext) {
            return DOMDeserializer.m11366a(str);
        }
    }

    /* compiled from: charity */
    public class NodeDeserializer extends DOMDeserializer<Node> {
        private static final long serialVersionUID = 1;

        public NodeDeserializer() {
            super(Node.class);
        }

        public final Object mo692a(String str, DeserializationContext deserializationContext) {
            return DOMDeserializer.m11366a(str);
        }
    }

    public abstract T mo692a(String str, DeserializationContext deserializationContext);

    static {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        f6109a = newInstance;
        newInstance.setNamespaceAware(true);
    }

    protected DOMDeserializer(Class<T> cls) {
        super(cls);
    }

    protected static Document m11366a(String str) {
        try {
            return f6109a.newDocumentBuilder().parse(new InputSource(new StringReader(str)));
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to parse JSON String as XML: " + e.getMessage(), e);
        }
    }
}
