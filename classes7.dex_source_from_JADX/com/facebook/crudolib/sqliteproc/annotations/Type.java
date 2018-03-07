package com.facebook.crudolib.sqliteproc.annotations;

/* compiled from: canComment */
public enum Type {
    INT(SqlType.INTEGER, "int", "getInt"),
    LONG(SqlType.INTEGER, "long", "getLong"),
    STRING(SqlType.TEXT, "String", "getString"),
    BYTES(SqlType.BLOB, "byte[]", "getBlob"),
    FLOAT(SqlType.REAL, "float", "getFloat"),
    DOUBLE(SqlType.REAL, "double", "getDouble"),
    BOOLEAN(SqlType.INTEGER, "boolean", "getInt", "!= 0");
    
    private final String mCursorGetter;
    private final SqlType mSqlType;
    private final String mSuffixHack;
    private final String mTypeString;

    private Type(SqlType sqlType, String str, String str2) {
        this(r8, r9, sqlType, str, str2, null);
    }

    private Type(SqlType sqlType, String str, String str2, String str3) {
        this.mSqlType = sqlType;
        this.mTypeString = str;
        this.mCursorGetter = str2;
        this.mSuffixHack = str3;
    }

    public final SqlType getSqlType() {
        return this.mSqlType;
    }

    public final String getTypeString() {
        return this.mTypeString;
    }

    public final String getCursorGetter() {
        return this.mCursorGetter;
    }

    public final String getSuffixHack() {
        return this.mSuffixHack;
    }
}
