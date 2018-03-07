package com.facebook.feedplugins.musicstory.model;

import android.net.Uri;
import com.facebook.feedplugins.musicstory.SingleSongData;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: composer_activity_tagging_inline_sprout */
public class AlbumData {
    private final String f8322a;
    private final String f8323b;
    private final String f8324c;
    private final Uri f8325d;
    private final Uri f8326e;
    private final Uri f8327f;
    private final Uri f8328g;
    private final String f8329h;
    public final ImmutableList<SingleSongData> f8330i;
    private final int f8331j;

    /* compiled from: composer_activity_tagging_inline_sprout */
    public class Builder {
        @Nullable
        public String f8313a;
        @Nullable
        public String f8314b;
        @Nullable
        public String f8315c;
        @Nullable
        public Uri f8316d;
        @Nullable
        public Uri f8317e;
        @Nullable
        public Uri f8318f;
        @Nullable
        public String f8319g;
        @Nullable
        public Uri f8320h;
        public List<SingleSongData> f8321i = new ArrayList();

        public Builder(List<SingleSongData> list) {
            Preconditions.checkNotNull(list);
            Preconditions.checkArgument(list.size() > 0);
            this.f8321i.addAll(list);
        }
    }

    public AlbumData(Builder builder) {
        this.f8322a = builder.f8313a == null ? "" : builder.f8313a;
        this.f8323b = builder.f8314b == null ? "" : builder.f8314b;
        this.f8324c = builder.f8315c == null ? "" : builder.f8315c;
        this.f8325d = builder.f8316d;
        this.f8326e = builder.f8320h;
        this.f8327f = builder.f8317e;
        this.f8328g = builder.f8318f;
        this.f8329h = builder.f8319g;
        this.f8330i = new com.google.common.collect.ImmutableList.Builder().b(builder.f8321i).b();
        this.f8331j = builder.f8321i.size();
    }
}
