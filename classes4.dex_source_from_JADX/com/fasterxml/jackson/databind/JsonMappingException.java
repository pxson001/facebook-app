package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: topOnMessengerFriends */
public class JsonMappingException extends JsonProcessingException {
    private static final long serialVersionUID = 1;
    protected LinkedList<Reference> _path;

    public JsonMappingException(String str) {
        super(str);
    }

    public JsonMappingException(String str, Throwable th) {
        super(str, th);
    }

    public JsonMappingException(String str, JsonLocation jsonLocation) {
        super(str, jsonLocation);
    }

    public JsonMappingException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str, jsonLocation, th);
    }

    public static JsonMappingException m1241a(JsonParser jsonParser, String str) {
        return new JsonMappingException(str, jsonParser == null ? null : jsonParser.k());
    }

    public static JsonMappingException m1242a(JsonParser jsonParser, String str, Throwable th) {
        return new JsonMappingException(str, jsonParser == null ? null : jsonParser.k(), th);
    }

    public static JsonMappingException m1243a(IOException iOException) {
        return new JsonMappingException("Unexpected IOException (of type " + iOException.getClass().getName() + "): " + iOException.getMessage(), null, iOException);
    }

    public static JsonMappingException m1246a(Throwable th, Object obj, String str) {
        return m1244a(th, new Reference(obj, str));
    }

    public static JsonMappingException m1245a(Throwable th, Object obj, int i) {
        return m1244a(th, new Reference(obj, i));
    }

    private static JsonMappingException m1244a(Throwable th, Reference reference) {
        if (th instanceof JsonMappingException) {
            th = (JsonMappingException) th;
        } else {
            String message = th.getMessage();
            if (message == null || message.length() == 0) {
                message = "(was " + th.getClass().getName() + ")";
            }
            th = new JsonMappingException(message, null, th);
        }
        th.m1250a(reference);
        return th;
    }

    private StringBuilder m1247a(StringBuilder stringBuilder) {
        m1249b(stringBuilder);
        return stringBuilder;
    }

    public final void m1251a(Object obj, String str) {
        m1250a(new Reference(obj, str));
    }

    public final void m1250a(Reference reference) {
        if (this._path == null) {
            this._path = new LinkedList();
        }
        if (this._path.size() < 1000) {
            this._path.addFirst(reference);
        }
    }

    public String getLocalizedMessage() {
        return m1248b();
    }

    public String getMessage() {
        return m1248b();
    }

    private String m1248b() {
        String message = super.getMessage();
        if (this._path == null) {
            return message;
        }
        StringBuilder stringBuilder = message == null ? new StringBuilder() : new StringBuilder(message);
        stringBuilder.append(" (through reference chain: ");
        stringBuilder = m1247a(stringBuilder);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    private void m1249b(StringBuilder stringBuilder) {
        if (this._path != null) {
            Iterator it = this._path.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((Reference) it.next()).toString());
                if (it.hasNext()) {
                    stringBuilder.append("->");
                }
            }
        }
    }
}
