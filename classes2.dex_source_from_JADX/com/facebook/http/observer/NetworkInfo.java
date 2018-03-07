package com.facebook.http.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: internal */
public class NetworkInfo {
    private final Integer f19681A;
    private final Integer f19682B;
    private final Boolean f19683C;
    private final Long f19684D;
    private final Long f19685E;
    private final Boolean f19686F;
    private final Long f19687G;
    private final Long f19688H;
    private final Long f19689I;
    private final Long f19690J;
    private final Long f19691K;
    private final Long f19692L;
    private final Double f19693M;
    private final Long f19694N;
    private final Long f19695O;
    private final Long f19696P;
    private final Double f19697Q;
    private final String f19698R;
    private final String f19699S;
    private final String f19700T;
    private List<String> f19701U = null;
    private Map<String, String> f19702V = null;
    private final Long f19703a;
    private final Long f19704b;
    private final Long f19705c;
    private final Long f19706d;
    private final Long f19707e;
    private final Long f19708f;
    private final Long f19709g;
    private final Long f19710h;
    private final Double f19711i;
    private final Boolean f19712j;
    private final Boolean f19713k;
    private final Long f19714l;
    private final Long f19715m;
    private final Long f19716n;
    private final Long f19717o;
    private final Long f19718p;
    private final Long f19719q;
    private final Long f19720r;
    private final Long f19721s;
    private final Long f19722t;
    private final Long f19723u;
    private final Long f19724v;
    private final String f19725w;
    private final Long f19726x;
    private final Integer f19727y;
    private final Integer f19728z;

    public NetworkInfo(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Double d, Boolean bool, Boolean bool2, Long l9, Long l10, Long l11, Long l12, Long l13, Long l14, Long l15, Long l16, Long l17, Long l18, Long l19, String str, Long l20, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool3, Long l21, Long l22, Boolean bool4, Long l23, Long l24, Long l25, Long l26, Long l27, Long l28, Double d2, Long l29, Long l30, Long l31, Double d3, String str2, String str3, String str4) {
        this.f19703a = l;
        this.f19704b = l2;
        this.f19705c = l3;
        this.f19706d = l4;
        this.f19707e = l5;
        this.f19708f = l6;
        this.f19709g = l7;
        this.f19710h = l8;
        this.f19711i = d;
        this.f19712j = bool;
        this.f19713k = bool2;
        this.f19714l = l9;
        this.f19715m = l10;
        this.f19716n = l11;
        this.f19717o = l12;
        this.f19718p = l13;
        this.f19719q = l14;
        this.f19720r = l15;
        this.f19721s = l16;
        this.f19722t = l17;
        this.f19723u = l18;
        this.f19724v = l19;
        this.f19725w = str;
        this.f19726x = l20;
        this.f19727y = num;
        this.f19728z = num2;
        this.f19681A = num3;
        this.f19682B = num4;
        this.f19683C = bool3;
        this.f19684D = l21;
        this.f19685E = l22;
        this.f19686F = bool4;
        this.f19687G = l23;
        this.f19688H = l24;
        this.f19689I = l25;
        this.f19690J = l26;
        this.f19691K = l27;
        this.f19692L = l28;
        this.f19693M = d2;
        this.f19694N = l29;
        this.f19695O = l30;
        this.f19696P = l31;
        this.f19697Q = d3;
        this.f19698R = str2;
        this.f19699S = str3;
        this.f19700T = str4;
    }

    public final Long m27416a() {
        return this.f19691K;
    }

    public final synchronized List<String> m27417b() {
        List<String> list;
        if (this.f19701U != null) {
            list = this.f19701U;
        } else {
            this.f19701U = new ArrayList();
            m27415b("network_info_ingress_avg", this.f19703a);
            m27415b("network_info_ingress_max", this.f19704b);
            m27415b("network_info_egress_avg", this.f19705c);
            m27415b("network_info_egress_max", this.f19706d);
            m27415b("network_info_read_count", this.f19707e);
            m27415b("network_info_write_count", this.f19708f);
            m27415b("network_info_rtt_avg", this.f19709g);
            m27415b("network_info_rtt_max", this.f19710h);
            m27415b("network_info_rtt_stddev", this.f19711i);
            m27415b("network_info_network_changed", this.f19712j);
            m27415b("network_info_celltower_changed", this.f19713k);
            m27415b("network_info_opened_conn", this.f19714l);
            m27415b("network_info_closed_conn", this.f19715m);
            m27415b("network_info_inflight_conn", this.f19716n);
            m27415b("network_info_enqueued_req", this.f19717o);
            m27415b("network_info_dequeued_req", this.f19718p);
            m27415b("network_info_finished_req", this.f19719q);
            m27415b("network_info_inflight_req", this.f19720r);
            m27415b("network_info_inqueue_req", this.f19721s);
            m27415b("network_info_interact_req", this.f19722t);
            m27415b("network_info_non_interact_req", this.f19723u);
            m27415b("network_info_can_wait_req", this.f19724v);
            m27415b("network_info_dns_reachability", this.f19725w);
            m27415b("network_info_dns_resolution_time", this.f19726x);
            m27415b("network_info_signal_level", this.f19727y);
            m27415b("network_info_signal_dbm", this.f19728z);
            m27415b("network_info_frequency_mhz", this.f19681A);
            m27415b("network_info_link_speed_mbps", this.f19682B);
            m27415b("network_info_app_backgrounded", this.f19683C);
            m27415b("network_info_ms_since_launch", this.f19684D);
            m27415b("network_info_ms_since_init", this.f19685E);
            m27415b("network_info_may_have_network", this.f19686F);
            m27415b("network_info_may_have_idled", this.f19687G);
            m27415b("network_info_active_read_seconds", this.f19688H);
            m27415b("network_info_active_write_seconds", this.f19689I);
            m27415b("network_info_req_bw_ingress_size", this.f19690J);
            m27415b("network_info_req_bw_ingress_avg", this.f19691K);
            m27415b("network_info_req_bw_ingress_max", this.f19692L);
            m27415b("network_info_req_bw_ingress_std_dev", this.f19693M);
            m27415b("network_info_req_bw_egress_size", this.f19694N);
            m27415b("network_info_req_bw_egress_avg", this.f19695O);
            m27415b("network_info_req_bw_egress_max", this.f19696P);
            m27415b("network_info_req_bw_egress_std_dev", this.f19697Q);
            m27415b("network_info_latency_quality", this.f19698R);
            m27415b("network_info_upload_bw_quality", this.f19699S);
            m27415b("network_info_download_bw_quality", this.f19700T);
            list = this.f19701U;
        }
        return list;
    }

    public final synchronized Map<String, String> m27418c() {
        Map<String, String> map;
        if (this.f19702V != null) {
            map = this.f19702V;
        } else {
            this.f19702V = new HashMap();
            m27414a("network_info_ingress_avg", this.f19703a);
            m27414a("network_info_ingress_max", this.f19704b);
            m27414a("network_info_egress_avg", this.f19705c);
            m27414a("network_info_egress_max", this.f19706d);
            m27414a("network_info_read_count", this.f19707e);
            m27414a("network_info_write_count", this.f19708f);
            m27414a("network_info_rtt_avg", this.f19709g);
            m27414a("network_info_rtt_max", this.f19710h);
            m27414a("network_info_rtt_stddev", this.f19711i);
            m27414a("network_info_network_changed", this.f19712j);
            m27414a("network_info_celltower_changed", this.f19713k);
            m27414a("network_info_opened_conn", this.f19714l);
            m27414a("network_info_closed_conn", this.f19715m);
            m27414a("network_info_inflight_conn", this.f19716n);
            m27414a("network_info_enqueued_req", this.f19717o);
            m27414a("network_info_dequeued_req", this.f19718p);
            m27414a("network_info_finished_req", this.f19719q);
            m27414a("network_info_inflight_req", this.f19720r);
            m27414a("network_info_inqueue_req", this.f19721s);
            m27414a("network_info_interact_req", this.f19722t);
            m27414a("network_info_non_interact_req", this.f19723u);
            m27414a("network_info_can_wait_req", this.f19724v);
            m27414a("network_info_dns_reachability", this.f19725w);
            m27414a("network_info_dns_resolution_time", this.f19726x);
            m27414a("network_info_signal_level", this.f19727y);
            m27414a("network_info_signal_dbm", this.f19728z);
            m27414a("network_info_frequency_mhz", this.f19681A);
            m27414a("network_info_link_speed_mbps", this.f19682B);
            m27414a("network_info_app_backgrounded", this.f19683C);
            m27414a("network_info_ms_since_launch", this.f19684D);
            m27414a("network_info_ms_since_init", this.f19685E);
            m27414a("network_info_may_have_network", this.f19686F);
            m27414a("network_info_may_have_idled", this.f19687G);
            m27414a("network_info_active_read_seconds", this.f19688H);
            m27414a("network_info_active_write_seconds", this.f19689I);
            m27414a("network_info_req_bw_ingress_size", this.f19690J);
            m27414a("network_info_req_bw_ingress_avg", this.f19691K);
            m27414a("network_info_req_bw_ingress_max", this.f19692L);
            m27414a("network_info_req_bw_ingress_std_dev", this.f19693M);
            m27414a("network_info_req_bw_egress_size", this.f19694N);
            m27414a("network_info_req_bw_egress_avg", this.f19695O);
            m27414a("network_info_req_bw_egress_max", this.f19696P);
            m27414a("network_info_req_bw_egress_std_dev", this.f19697Q);
            m27414a("network_info_latency_quality", this.f19698R);
            m27414a("network_info_upload_bw_quality", this.f19699S);
            m27414a("network_info_download_bw_quality", this.f19700T);
            map = this.f19702V;
        }
        return map;
    }

    private void m27414a(String str, Object obj) {
        if (obj != null) {
            this.f19702V.put(str, String.valueOf(obj));
        }
    }

    private void m27415b(String str, Object obj) {
        if (obj != null) {
            this.f19701U.add(str);
            this.f19701U.add(String.valueOf(obj));
        }
    }
}
