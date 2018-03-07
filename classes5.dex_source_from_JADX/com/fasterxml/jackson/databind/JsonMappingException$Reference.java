package com.fasterxml.jackson.databind;

import java.io.Serializable;

/* compiled from: clipboard */
public class JsonMappingException$Reference implements Serializable {
    private static final long serialVersionUID = 1;
    protected String _fieldName;
    protected Object _from;
    protected int _index = -1;

    protected JsonMappingException$Reference() {
    }

    public JsonMappingException$Reference(Object obj, String str) {
        this._from = obj;
        if (str == null) {
            throw new NullPointerException("Can not pass null fieldName");
        }
        this._fieldName = str;
    }

    public JsonMappingException$Reference(Object obj, int i) {
        this._from = obj;
        this._index = i;
    }

    public String toString() {
        Class cls;
        StringBuilder stringBuilder = new StringBuilder();
        if (this._from instanceof Class) {
            cls = (Class) this._from;
        } else {
            cls = this._from.getClass();
        }
        Package packageR = cls.getPackage();
        if (packageR != null) {
            stringBuilder.append(packageR.getName());
            stringBuilder.append('.');
        }
        stringBuilder.append(cls.getSimpleName());
        stringBuilder.append('[');
        if (this._fieldName != null) {
            stringBuilder.append('\"');
            stringBuilder.append(this._fieldName);
            stringBuilder.append('\"');
        } else if (this._index >= 0) {
            stringBuilder.append(this._index);
        } else {
            stringBuilder.append('?');
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
