package com.facebook.feed.platformads;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
/* compiled from: admin_click_insights_graph_weekly_like */
public class TrackedPackage implements Serializable {
    public String appLaunchUrl;
    public List<String> detectionStrings;
    public String fbid;
    public boolean notifyAppInstalledListener;
    public Date trackUntil;
    public ArrayNode trackingCodes;

    public final String m23083a(ObjectMapper objectMapper) {
        try {
            return objectMapper.a(this);
        } catch (IOException e) {
            return null;
        }
    }

    public static TrackedPackage m23082a(String str, ObjectMapper objectMapper) {
        try {
            return (TrackedPackage) objectMapper.a(str, TrackedPackage.class);
        } catch (IOException e) {
            return null;
        }
    }
}
