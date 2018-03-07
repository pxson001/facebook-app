package com.facebook.feed.collage.offline;

import com.facebook.feed.collage.offline.OfflineCollageLayoutChooser.Dimension;
import com.google.common.collect.ImmutableList;
import java.util.EnumSet;

/* compiled from: social_search */
public class CollageLayoutModel {
    public final EnumSet<ActorType> f3656a;
    public final ImmutableList<GridItem> f3657b;

    /* compiled from: social_search */
    public enum ActorType {
        USER,
        PAGE
    }

    /* compiled from: social_search */
    public class Builder {
        private final EnumSet<ActorType> f3650a;
        private final com.google.common.collect.ImmutableList.Builder<GridItem> f3651b = new com.google.common.collect.ImmutableList.Builder();

        public Builder(EnumSet<ActorType> enumSet) {
            this.f3650a = enumSet;
        }

        public final Builder m4369a(int i, int i2, int i3, int i4) {
            this.f3651b.c(new GridItem(i, i2, i3, i4));
            return this;
        }

        public final CollageLayoutModel m4370a() {
            return new CollageLayoutModel(this.f3650a, this.f3651b.b());
        }
    }

    /* compiled from: social_search */
    public class GridItem implements Dimension {
        public final int f3652a;
        public final int f3653b;
        public final int f3654c;
        public final int f3655d;

        public final int mo174a() {
            return this.f3654c;
        }

        public final int mo175b() {
            return this.f3655d;
        }

        public GridItem(int i, int i2, int i3, int i4) {
            this.f3652a = i;
            this.f3653b = i2;
            this.f3654c = i3;
            this.f3655d = i4;
        }
    }

    public CollageLayoutModel(EnumSet<ActorType> enumSet, ImmutableList<GridItem> immutableList) {
        this.f3656a = enumSet;
        this.f3657b = immutableList;
    }
}
