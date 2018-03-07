package com.facebook.messaging.send.service;

import com.facebook.mqtt.model.thrift.Coordinates;
import com.facebook.mqtt.model.thrift.LocationAttachment;
import com.facebook.mqtt.model.thrift.SendMessageRequest;
import java.util.List;
import java.util.Map;

/* compiled from: recommended_product_items */
public class SendMessageRequestBuilder {
    private String f3901a;
    private String f3902b;
    private Long f3903c;
    private Coordinates f3904d;
    private Map<String, String> f3905e;
    private String f3906f;
    private String f3907g;
    private String f3908h;
    private List<String> f3909i;
    private String f3910j;
    private Long f3911k;
    private LocationAttachment f3912l;
    private Integer f3913m;
    private Integer f3914n;

    public final SendMessageRequest m3655a() {
        return new SendMessageRequest(this.f3901a, this.f3902b, this.f3903c, this.f3904d, this.f3905e, this.f3906f, this.f3907g, this.f3908h, this.f3909i, this.f3910j, null, this.f3911k, null, null, null, null, this.f3912l, this.f3913m, this.f3914n);
    }

    public final void m3659a(String str) {
        this.f3901a = str;
    }

    public final void m3664b(String str) {
        this.f3902b = str;
    }

    public final void m3658a(Long l) {
        this.f3903c = l;
    }

    public final void m3661a(Map<String, String> map) {
        this.f3905e = map;
    }

    public final void m3665c(String str) {
        this.f3906f = str;
    }

    public final void m3666d(String str) {
        this.f3907g = str;
    }

    public final void m3667e(String str) {
        this.f3908h = str;
    }

    public final void m3660a(List<String> list) {
        this.f3909i = list;
    }

    public final void m3668f(String str) {
        this.f3910j = str;
    }

    public final void m3663b(Long l) {
        this.f3911k = l;
    }

    public final void m3656a(LocationAttachment locationAttachment) {
        this.f3912l = locationAttachment;
    }

    public final void m3657a(Integer num) {
        this.f3913m = num;
    }

    public final void m3662b(Integer num) {
        this.f3914n = num;
    }
}
