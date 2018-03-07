package com.facebook.richdocument.model.data.impl;

import android.os.Bundle;
import com.facebook.richdocument.model.data.BlockData;
import javax.annotation.Nullable;

/* compiled from: photo_url */
public abstract class BaseBlockData implements BlockData {
    private final Bundle f5671a;
    private final int f5672b;
    private final String f5673c;

    /* compiled from: photo_url */
    public abstract class BaseBlockDataBuilder<T extends BlockData> {
        public final int f5675a;
        private String f5676b;

        public abstract T mo288b();

        public BaseBlockDataBuilder(int i) {
            this.f5675a = i;
        }

        public String mo287a() {
            return this.f5676b;
        }

        public BaseBlockDataBuilder mo286a(String str) {
            this.f5676b = str;
            return this;
        }
    }

    public BaseBlockData(BaseBlockDataBuilder baseBlockDataBuilder) {
        this.f5672b = baseBlockDataBuilder.f5675a;
        this.f5673c = baseBlockDataBuilder.mo287a();
        this.f5671a = new Bundle();
    }

    public BaseBlockData(String str, int i) {
        this.f5673c = str;
        this.f5672b = i;
        this.f5671a = new Bundle();
    }

    public BaseBlockData(int i) {
        this.f5672b = i;
        this.f5673c = null;
        this.f5671a = new Bundle();
    }

    public final Bundle iQ_() {
        return this.f5671a;
    }

    public final int mo272n() {
        return this.f5672b;
    }

    @Nullable
    public String mo271l() {
        return this.f5673c;
    }
}
