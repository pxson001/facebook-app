package com.facebook.phoneid;

/* compiled from: total_first_available_expired_uri_num */
public class Response {
    public final String f890a;
    public PhoneId f891b;
    public final PhoneId f892c;
    public Status f893d = Status.NO_RESPONSE;
    private final long f894e = System.currentTimeMillis();
    public long f895f;

    /* compiled from: total_first_available_expired_uri_num */
    enum Status {
        FAILED("failed"),
        NO_RESPONSE("no_response"),
        NULL("null"),
        SAME("same"),
        OLDER("older"),
        NEWER("newer");
        
        private String mStatus;

        private Status(String str) {
            this.mStatus = str;
        }

        final String getStatus() {
            return this.mStatus;
        }
    }

    Response(String str, PhoneId phoneId) {
        this.f890a = str;
        this.f892c = phoneId;
    }

    public final String m1224d() {
        return this.f893d.getStatus();
    }

    public final int m1225e() {
        return (int) (this.f895f - this.f894e);
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder("{src_pkg=").append(this.f890a).append(", phone_id=");
        if (this.f891b == null) {
            str = null;
        } else {
            str = this.f891b.toString();
        }
        return append.append(str).append(", status=").append(m1224d()).append(", duration=").append(m1225e()).append(", prev_phone_id=").append(this.f892c).append("}").toString();
    }
}
