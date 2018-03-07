package com.facebook.instantshopping.logging;

/* compiled from: ShareAttachment */
public class LoggingParams {
    public String f23578a;
    public String f23579b;

    public LoggingParams(String str, String str2) {
        this.f23579b = str;
        this.f23578a = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LoggingParams loggingParams = (LoggingParams) obj;
        if (this.f23578a == null ? loggingParams.f23578a != null : !this.f23578a.equals(loggingParams.f23578a)) {
            return false;
        }
        if (this.f23579b != null) {
            if (this.f23579b.equals(loggingParams.f23579b)) {
                return true;
            }
        } else if (loggingParams.f23579b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f23578a != null) {
            hashCode = this.f23578a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f23579b != null) {
            i = this.f23579b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return this.f23578a + "_" + this.f23579b;
    }
}
