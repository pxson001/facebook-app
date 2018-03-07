package com.facebook.groups.logging;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;

/* compiled from: f49aa4b74af7911e60bbfdfc157d192a */
public enum GroupsFeedSequences {
    FRESH_STORIES("GroupsFeedTTIFreshStories"),
    CACHED_STORIES("GroupsFeedTTICachedStories"),
    FRESH_HEADER("GroupsFeedTTIFreshHeader"),
    CACHED_HEADER("GroupsFeedTTICachedHeader"),
    INITIAL_STORIES("GroupsFeedTTIInitialStoriesRendered");
    
    public static final GroupsFeedTTISequence GROUPS_FEED_TTI_SEQUENCE = null;
    private String mName;

    /* compiled from: f49aa4b74af7911e60bbfdfc157d192a */
    public final class GroupsFeedTTISequence extends AbstractSequenceDefinition {
        public GroupsFeedTTISequence() {
            super(1114113, "GroupsFeedTTISequence", false, ImmutableSet.of("com.facebook.groups.feed.ui.GroupsFeedFragment"));
        }
    }

    static {
        GROUPS_FEED_TTI_SEQUENCE = new GroupsFeedTTISequence();
    }

    private GroupsFeedSequences(String str) {
        this.mName = str;
    }

    public final String getName() {
        return this.mName;
    }
}
