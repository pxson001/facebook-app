package com.facebook.feedback.reactions.ui;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint.Style;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.feedback.reactions.ui.anim.ReactionsAnimationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@AutoGenJsonDeserializer
@JsonIgnoreProperties
/* compiled from: set_cover_photo */
public class VectorGraphicConfig {
    @JsonProperty("canvas_size")
    public float[] mCanvasSize;
    @JsonProperty("name")
    private String mName;
    @JsonProperty("paint_map")
    public ImmutableMap<String, PaintConfig> mPaintMapConfig;
    @JsonProperty("states")
    private State[] mStates;
    @JsonProperty("vector_count")
    public int mVectorCount;

    @JsonIgnoreProperties
    /* compiled from: set_cover_photo */
    public class AnimationWave {
        @JsonProperty("range0")
        public float mRange0;
        @JsonProperty("range1")
        public float mRange1;
    }

    @JsonIgnoreProperties
    /* compiled from: set_cover_photo */
    public class PaintConfig {
        @JsonProperty("cap")
        public String mCap;
        @JsonProperty("color")
        private String mColor;
        @JsonProperty("style")
        public Style mStyle;
        @JsonProperty("width")
        public int mWidth;

        public final int m4589c() {
            return Color.parseColor(this.mColor);
        }
    }

    @JsonIgnoreProperties
    /* compiled from: set_cover_photo */
    public class State {
        @JsonProperty("rotWave")
        public AnimationWave mRotationAnimationWave;
        @JsonProperty("vectors")
        public VectorLine[] mVectorLines;
        @JsonProperty("xWave")
        public AnimationWave mXAnimationWave;
        @JsonProperty("yWave")
        public AnimationWave mYAnimationWave;

        public final VectorLine[] m4590a() {
            return this.mVectorLines;
        }

        public final AnimationWave m4591b() {
            return this.mXAnimationWave;
        }

        public final AnimationWave m4592c() {
            return this.mYAnimationWave;
        }

        public final AnimationWave m4593d() {
            return this.mRotationAnimationWave;
        }
    }

    @JsonIgnoreProperties
    /* compiled from: set_cover_photo */
    public class VectorLine {
        public ImmutableMap<Style, PaintConfig> f3957a;
        @JsonProperty("animation")
        private ReactionsAnimationType animationType;
        @JsonProperty("fromControlX")
        private int fromControlX;
        @JsonProperty("fromControlY")
        private int fromControlY;
        @JsonProperty("fromX")
        public int fromX;
        @JsonProperty("fromY")
        private int fromY;
        @JsonProperty("offsetX")
        public int mOffsetX;
        @JsonProperty("offsetY")
        public int mOffsetY;
        @JsonProperty("paints")
        private String[] paints;
        @JsonProperty("toControlX")
        private int toControlX;
        @JsonProperty("toControlY")
        private int toControlY;
        @JsonProperty("toX")
        private int toX;
        @JsonProperty("toY")
        private int toY;

        public final int m4595a() {
            return this.mOffsetX;
        }

        public final int m4596b() {
            return this.mOffsetY;
        }

        public final int m4597c() {
            return this.fromX;
        }

        public final int m4598d() {
            return this.fromY;
        }

        public final int m4599e() {
            return this.toX;
        }

        public final int m4600f() {
            return this.toY;
        }

        public final int m4601g() {
            return this.fromControlX;
        }

        public final int m4602h() {
            return this.fromControlY;
        }

        public final int m4603i() {
            return this.toControlX;
        }

        public final int m4604j() {
            return this.toControlY;
        }

        public final ReactionsAnimationType m4605k() {
            return this.animationType;
        }

        public final ImmutableMap<Style, PaintConfig> m4606l() {
            return this.f3957a;
        }

        public static void m4594a(VectorLine vectorLine, Map map) {
            Builder builder = ImmutableMap.builder();
            for (Object obj : vectorLine.paints) {
                PaintConfig paintConfig = (PaintConfig) map.get(obj);
                builder.b(paintConfig.mStyle, paintConfig);
            }
            vectorLine.f3957a = builder.b();
        }
    }

    public final int m4609a() {
        return this.mVectorCount;
    }

    public final State m4610a(int i) {
        return this.mStates[i];
    }

    public static VectorGraphicConfig m4607a(FbObjectMapper fbObjectMapper, Resources resources, String str) {
        try {
            InputStream open = resources.getAssets().open(str);
            VectorGraphicConfig vectorGraphicConfig = (VectorGraphicConfig) fbObjectMapper.a(open, VectorGraphicConfig.class);
            open.close();
            vectorGraphicConfig.m4608d();
            return vectorGraphicConfig;
        } catch (IOException e) {
            return null;
        }
    }

    private void m4608d() {
        for (State state : this.mStates) {
            for (VectorLine a : state.mVectorLines) {
                VectorLine.m4594a(a, this.mPaintMapConfig);
            }
        }
    }
}
