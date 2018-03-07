package com.facebook.timeline.service;

import android.content.Intent;
import android.os.Bundle;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: extra_page_id */
public class ProfileLoadRequest {
    public final Parameters f12695a;
    public int f12696b;

    /* compiled from: extra_page_id */
    public class Parameters {
        public final long f12691a;
        public final String f12692b;
        @Nullable
        public final String f12693c;
        @Nullable
        public final Bundle f12694d;

        /* compiled from: extra_page_id */
        public class Builder {
            public long f12687a;
            public String f12688b;
            public String f12689c;
            public Bundle f12690d;

            public Builder(Intent intent) {
                this.f12687a = intent.getLongExtra("com.facebook.katana.profile.id", -1);
                this.f12688b = intent.getStringExtra("profile_name");
                this.f12690d = intent.getExtras();
                this.f12689c = this.f12690d != null ? this.f12690d.getString("timeline_context_item_type") : null;
            }

            public final Parameters m12631a() {
                boolean z;
                if (this.f12687a > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                Preconditions.checkNotNull(this.f12688b);
                return new Parameters(this);
            }
        }

        public Parameters(Builder builder) {
            this.f12691a = builder.f12687a;
            this.f12692b = builder.f12688b;
            this.f12693c = builder.f12689c;
            this.f12694d = builder.f12690d;
        }
    }

    public ProfileLoadRequest(Parameters parameters) {
        this.f12695a = parameters;
    }

    public final long m12632a() {
        return this.f12695a.f12691a;
    }

    public final String m12633b() {
        return this.f12695a.f12692b;
    }

    public final Bundle m12634c() {
        return this.f12695a.f12694d != null ? this.f12695a.f12694d : new Bundle();
    }

    public final int m12635e() {
        return this.f12696b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (m12632a() != ((ProfileLoadRequest) obj).m12632a()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) m12632a();
    }
}
