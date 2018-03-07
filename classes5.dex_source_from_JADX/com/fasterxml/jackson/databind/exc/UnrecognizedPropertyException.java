package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Collection;

/* compiled from: check fail  */
public class UnrecognizedPropertyException extends JsonMappingException {
    private static final long serialVersionUID = 1;
    protected final Collection<Object> _propertyIds;
    protected final Class<?> _referringClass;
    protected final String _unrecognizedPropertyName;
    protected transient String f6103a;

    private UnrecognizedPropertyException(String str, JsonLocation jsonLocation, Class<?> cls, String str2, Collection<Object> collection) {
        super(str, jsonLocation);
        this._referringClass = cls;
        this._unrecognizedPropertyName = str2;
        this._propertyIds = collection;
    }

    public static UnrecognizedPropertyException m11357a(JsonParser jsonParser, Object obj, String str, Collection<Object> collection) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        Class cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
        } else {
            cls = obj.getClass();
        }
        UnrecognizedPropertyException unrecognizedPropertyException = new UnrecognizedPropertyException("Unrecognized field \"" + str + "\" (class " + cls.getName() + "), not marked as ignorable", jsonParser.l(), cls, str, collection);
        unrecognizedPropertyException.a(obj, str);
        return unrecognizedPropertyException;
    }

    public final String m11358a() {
        String str = this.f6103a;
        if (str != null || this._propertyIds == null) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(100);
        int size = this._propertyIds.size();
        if (size != 1) {
            stringBuilder.append(" (").append(size).append(" known properties: ");
            for (Object valueOf : this._propertyIds) {
                stringBuilder.append(", \"");
                stringBuilder.append(String.valueOf(valueOf));
                stringBuilder.append('\"');
                if (stringBuilder.length() > 200) {
                    stringBuilder.append(" [truncated]");
                    break;
                }
            }
        }
        stringBuilder.append(" (one known property: \"");
        stringBuilder.append(String.valueOf(this._propertyIds.iterator().next()));
        stringBuilder.append('\"');
        stringBuilder.append("])");
        str = stringBuilder.toString();
        this.f6103a = str;
        return str;
    }
}
