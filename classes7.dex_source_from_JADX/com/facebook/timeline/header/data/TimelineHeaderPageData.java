package com.facebook.timeline.header.data;

import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.ipc.profile.TimelineContext;
import com.google.common.collect.ImmutableList;

/* compiled from: fbobj */
public class TimelineHeaderPageData extends TimelineHeaderData {
    public boolean f14595a;
    public GraphQLPhoto f14596b;
    public GraphQLImage f14597c;
    public boolean f14598d;
    public String f14599e;
    public ImmutableList<String> f14600f;

    public TimelineHeaderPageData(TimelineContext timelineContext) {
        super(timelineContext);
    }
}
