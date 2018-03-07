package com.facebook.nux;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.time.Clock;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@JsonDeserialize(using = NuxHistoryDeserializer.class)
/* compiled from: isRotated */
public class NuxHistory {
    private long f12215a;
    private int f12216b;
    @JsonProperty("isCompleted")
    boolean isCompleted;
    @JsonProperty("lastAppearanceTime")
    long lastAppearanceTime;
    @JsonProperty("numAppearances")
    long numAppearances;

    public NuxHistory() {
        this(0, 0, false);
    }

    private NuxHistory(int i, long j, boolean z) {
        this.numAppearances = (long) i;
        this.lastAppearanceTime = j;
        this.isCompleted = z;
        this.f12216b = 3;
        this.f12215a = 600000;
    }

    public final NuxHistory m19135a(long j) {
        this.lastAppearanceTime = j;
        return this;
    }

    public final void m19138a() {
        this.numAppearances++;
    }

    public final NuxHistory m19137a(boolean z) {
        this.isCompleted = z;
        return this;
    }

    public final NuxHistory m19136a(Clock clock) {
        this.lastAppearanceTime = clock.a();
        return this;
    }

    public final boolean m19139b(Clock clock) {
        if (!this.isCompleted && this.numAppearances < ((long) this.f12216b) && clock.a() - this.lastAppearanceTime > this.f12215a) {
            return true;
        }
        return false;
    }
}
