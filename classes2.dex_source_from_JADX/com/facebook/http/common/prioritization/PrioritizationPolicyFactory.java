package com.facebook.http.common.prioritization;

/* compiled from: received_sms */
public class PrioritizationPolicyFactory {
    public static PrioritizationPolicy m12501a(String str, String str2) {
        PrioritizationPolicy a = m12500a(str);
        return a == null ? m12500a(str2) : a;
    }

    private static PrioritizationPolicy m12500a(String str) {
        try {
            String[] split = str.split(":");
            return new PrioritizationPolicy(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
        } catch (Exception e) {
            return null;
        }
    }
}
