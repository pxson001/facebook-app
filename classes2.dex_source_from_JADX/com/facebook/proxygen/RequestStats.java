package com.facebook.proxygen;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: mEffect */
public class RequestStats {
    private static final Map<String, List<String>> mFlowTimeMap = Collections.unmodifiableMap(new C06731());
    private TraceEvent[] mEvents;

    /* compiled from: mEffect */
    final class C06731 extends HashMap<String, List<String>> {
        C06731() {
            put("HTTPRequestExchange", Arrays.asList(new String[]{"uri", "is_secure", "status_code", "content_type", "using_spdy", "local_addr", "local_port", "request_header_size", "request_header_compressed_size", "request_body_size", "response_header_size", "response_header_compressed_size", "redirect_location", "num_redirects", "num_retries", "using_http2", "body_generated", "first_body_byte_flushed", "first_body_byte_flushed_ratio", "last_body_byte_flushed", "last_body_byte_flushed_ratio", "header_generated", "security_protocol", "flow_control_pauses", "replay_safe"}));
            put("HTTPResponseBodyRead", Arrays.asList(new String[]{"response_interval_average", "response_interval_stddev", "response_number_on_body", "response_server_quality", "flow_control_recv_to_ack"}));
            put("TotalConnect", Arrays.asList(new String[0]));
            put("PreConnect", Arrays.asList(new String[]{"new_connection", "waiting_for_new_connection", "new_session", "new_conn_timeout", "sess_mgr_type", "in_flight_conns", "cached_sessions", "cached_active_sessions", "connection_routing_stale", "conns_started", "requests_waited", "total_conns_started", "total_backup_conns_started", "total_requests_waited", "session_cache_hit_type", "per_domain_limit", "dynamic_domain_limit_ratio", "load_balancing", "max_connection_retry_count", "max_idle_http_sessions", "max_idle_spdy_sessions"}));
            put("DNSResolution", Arrays.asList(new String[]{"host_name", "ip_address", "port", "canonical_name", "cname_redirects", "redirect_time", "number_resolvers", "resolvers_serialized", "request_family", "number_answers"}));
            put("DNSCache", Arrays.asList(new String[]{"host_name", "ip_address", "port", "canonical_name", "cname_redirects", "redirect_time", "number_resolvers", "request_family", "number_answers", "dns_cache_hit", "dns_cache_stale", "dns_cache_inflight"}));
            put("TCPConnect", Arrays.asList(new String[]{"cached_family"}));
            put("TLSSetup", Arrays.asList(new String[]{"tls_reused", "tls_cache_hit", "cipher_name", "ssl_version", "openssl_version", "tls_cache_persistence"}));
            put("ZeroSetup", Arrays.asList(new String[]{"zero_scfg_cache_hit", "zero_initial_app_bytes_written", "zero_time_to_initial", "zero_scfg_expired", "error_description", "zero_aead", "zero_kex", "zero_version", "zero_rtt_enabled"}));
            put("proxy_connect", Arrays.asList(new String[]{"proxy_host", "proxy_port"}));
            put("scheduling", Arrays.asList(new String[]{"scheduler_type", "initial_priority", "size_of_queue"}));
            put("PostConnect", Arrays.asList(new String[]{"new_session", "num_waiting"}));
            put("SessionTransactions", Arrays.asList(new String[]{"current_txns", "historical_max_txns", "permitted_max_txns", "number_txns_served", "total_pings_sent", "total_ping_replies_received", "last_ping_timeout"}));
            put("TCPInfo", Arrays.asList(new String[]{"cwnd", "cwnd_bytes", "total_retx", "inflight_packet_loss", "rtt", "rtt_variance", "rto", "sending_mss", "mtu", "recv_window", "upstream_capacity"}));
            put("ConnInfo", Arrays.asList(new String[]{"reqs_succeed", "reqs_failed", "ttfb", "ttlb", "request_header_size", "request_body_size", "response_header_size", "response_body_size", "connection_life_span", "connection_idle_duration", "egress_buffered", "transport_rtt_completed", "unparsed_data_size", "unparsed_data"}));
            put("decompression_filter", Arrays.asList(new String[]{"response_body_size", "response_body_compressed_size"}));
            put("ReplaySafety", Arrays.asList(new String[0]));
            put("push", Arrays.asList(new String[]{"is_push_request", "push_connected_in_flight", "push_orphaned"}));
        }
    }

    static Map<String, List<String>> getFlowTimeFieldsMap() {
        return mFlowTimeMap;
    }

    public RequestStats(TraceEvent[] traceEventArr) {
        this.mEvents = traceEventArr;
    }

    public HTTPFlowStats getFlowStats() {
        String str = "";
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        String str2 = "";
        String str3 = "";
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        for (TraceEvent traceEvent : this.mEvents) {
            Map metaData = traceEvent.getMetaData();
            if ("HTTPRequestExchange".equals(traceEvent.getName())) {
                str2 = TraceEventUtil.readStrMeta(metaData, "protocol", "");
                z = isValidCodecProtocolStr(str2);
                str3 = TraceEventUtil.readStrMeta(metaData, "local_addr", "");
                i = TraceEventUtil.readIntMeta(metaData, "local_port", 0);
                i2 = TraceEventUtil.readIntMeta(metaData, "request_header_size", 0);
                i3 = TraceEventUtil.readIntMeta(metaData, "request_header_compressed_size", 0);
                z3 = i2 != 0;
                i4 = TraceEventUtil.readIntMeta(metaData, "request_body_size", 0);
                i5 = TraceEventUtil.readIntMeta(metaData, "response_header_size", 0);
                i6 = TraceEventUtil.readIntMeta(metaData, "response_header_compressed_size", 0);
                if (i5 != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
            } else if ("PostConnect".equals(traceEvent.getName())) {
                z2 = TraceEventUtil.readBooleanMeta(metaData, "new_session", false);
                str = TraceEventUtil.readStrMeta(metaData, "server_address", str);
            } else if ("HTTPResponseBodyRead".equals(traceEvent.getName())) {
                j4 = traceEvent.getEnd() - traceEvent.getStart();
            } else if ("TCPConnect".equals(traceEvent.getName())) {
                str = TraceEventUtil.readStrMeta(metaData, "server_address", str);
                j2 = traceEvent.getEnd() - traceEvent.getStart();
            } else if ("PreConnect".equals(traceEvent.getName()) || "multi_connector".equals(traceEvent.getName())) {
                str = TraceEventUtil.readStrMeta(metaData, "server_address", str);
            } else if ("DNSResolution".equals(traceEvent.getName())) {
                j = traceEvent.getEnd() - traceEvent.getStart();
                str = TraceEventUtil.readStrMeta(metaData, "server_address", str);
            } else if ("TLSSetup".equals(traceEvent.getName())) {
                j3 = traceEvent.getEnd() - traceEvent.getStart();
                str = TraceEventUtil.readStrMeta(metaData, "server_address", str);
            } else if ("decompression_filter".equals(traceEvent.getName())) {
                i7 = TraceEventUtil.readIntMeta(metaData, "response_body_size", 0);
                i8 = TraceEventUtil.readIntMeta(metaData, "response_body_compressed_size", 0);
            }
        }
        return new HTTPFlowStats(str, str3, i, z, z2, z3, z4, str2, i2, i3, i4, i5, i6, i7, i8, j, j2, j3, j4);
    }

    public Map<String, String> getFlowTimeData() {
        Map<String, String> hashMap = new HashMap();
        for (TraceEvent traceEvent : this.mEvents) {
            if (mFlowTimeMap.containsKey(traceEvent.mName)) {
                Map metaData = traceEvent.getMetaData();
                if (!(traceEvent.getStart() == 0 || traceEvent.getEnd() == 0 || traceEvent.getStart() >= traceEvent.getEnd())) {
                    hashMap.put(traceEvent.getName(), String.valueOf(traceEvent.getEnd() - traceEvent.getStart()));
                }
                for (String str : (List) mFlowTimeMap.get(traceEvent.getName())) {
                    if (metaData.containsKey(str)) {
                        hashMap.put(str, metaData.get(str));
                    }
                }
                if (metaData.containsKey("server_address")) {
                    hashMap.put("server_address", metaData.get("server_address"));
                    hashMap.put("server_port", metaData.get("server_port"));
                    hashMap.put("server_address_stage", traceEvent.getName());
                }
                if (metaData.containsKey("error_description")) {
                    if (hashMap.containsKey("error_stage")) {
                        hashMap.put("error_stage", ((String) hashMap.get("error_stage")) + ";" + traceEvent.getName());
                    } else {
                        hashMap.put("error_stage", traceEvent.getName());
                    }
                    joinMetaFields(metaData, hashMap, "error_description");
                    joinMetaFields(metaData, hashMap, "error_direction");
                    joinMetaFields(metaData, hashMap, "proxygen_error");
                    joinMetaFields(metaData, hashMap, "codec_error");
                }
                if (metaData.containsKey("last_ping_sent_time_offset")) {
                    hashMap.put("last_ping_sent_time_offset", metaData.get("last_ping_sent_time_offset"));
                }
                if (metaData.containsKey("last_ping_recv_time_offset")) {
                    hashMap.put("last_ping_recv_time_offset", metaData.get("last_ping_recv_time_offset"));
                }
                if (metaData.containsKey("recent_ping_sent_count")) {
                    hashMap.put("recent_ping_sent_count", metaData.get("recent_ping_sent_count"));
                }
                if (metaData.containsKey("recent_ping_recv_count")) {
                    hashMap.put("recent_ping_recv_count", metaData.get("recent_ping_recv_count"));
                }
                if (metaData.containsKey("priority_changes")) {
                    joinMetaFields(metaData, hashMap, "priority_changes");
                }
                if (metaData.containsKey("priority_changes_egress_states")) {
                    joinMetaFields(metaData, hashMap, "priority_changes_egress_states");
                }
                if (metaData.containsKey("priority_changes_ingress_states")) {
                    joinMetaFields(metaData, hashMap, "priority_changes_ingress_states");
                }
            }
        }
        return hashMap;
    }

    public Map<String, String> getCertificateVerificationData() {
        HashMap hashMap = new HashMap();
        int i = 0;
        for (TraceEvent traceEvent : this.mEvents) {
            if (traceEvent.mName.equals("cert_verification") || traceEvent.mName.equals("ZeroVerification")) {
                for (Entry entry : traceEvent.getMetaData().entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
                i = 1;
            } else if (traceEvent.mName.equals("PreConnect") || traceEvent.mName.equals("TCPConnect") || traceEvent.mName.equals("PostConnect") || traceEvent.mName.equals("multi_connector")) {
                r1 = traceEvent.getMetaData();
                r7 = TraceEventUtil.readStrMeta(r1, "server_address", "");
                r1 = TraceEventUtil.readIntMeta(r1, "server_port", 0);
                if (!r7.equals("") && r1 > 0) {
                    hashMap.put("verified_server_address", r7 + ":" + String.valueOf(r1));
                }
            } else if (traceEvent.mName.equals("TLSSetup")) {
                r1 = traceEvent.getMetaData();
                r7 = TraceEventUtil.readStrMeta(r1, "cipher_name", "");
                int readIntMeta = TraceEventUtil.readIntMeta(r1, "ssl_version", 0);
                long readIntMeta2 = (long) TraceEventUtil.readIntMeta(r1, "openssl_version", 0);
                if (!r7.equals("")) {
                    hashMap.put("cipher_name", r7);
                }
                if (readIntMeta != 0) {
                    hashMap.put("ssl_version", String.valueOf(readIntMeta));
                }
                if (readIntMeta2 != 0) {
                    hashMap.put("openssl_version", String.valueOf(readIntMeta2));
                }
            } else if (traceEvent.mName.equals("proxy_connect")) {
                r1 = traceEvent.getMetaData();
                r7 = TraceEventUtil.readStrMeta(r1, "proxy_host", "");
                r1 = TraceEventUtil.readIntMeta(r1, "proxy_port", 0);
                if (!r7.equals("") && r1 > 0) {
                    hashMap.put("verified_proxy_address", r7 + ":" + String.valueOf(r1));
                }
            }
        }
        if (i == 0) {
            return new HashMap(0);
        }
        return hashMap;
    }

    public TraceEvent[] getTraceEvents() {
        return this.mEvents;
    }

    private static boolean isValidCodecProtocolStr(String str) {
        return str.equals("http/1.1") || str.equals("spdy/3") || str.equals("spdy/3.1") || str.equals("spdy/3.1-hpack") || str.equals("http/2");
    }

    private static void joinMetaFields(Map<String, String> map, Map<String, String> map2, String str) {
        if (!map.containsKey(str)) {
            return;
        }
        if (map2.containsKey(str)) {
            map2.put(str, ((String) map2.get(str)) + ";" + ((String) map.get(str)));
        } else {
            map2.put(str, map.get(str));
        }
    }
}
