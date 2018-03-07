package com.facebook.videocodec.codecs;

/* compiled from: reviews_click */
public class Constants {

    /* compiled from: reviews_click */
    public enum MediaCodecInputType {
        BUFFERS,
        SURFACE
    }

    /* compiled from: reviews_click */
    public enum MediaCodecProcessingType {
        DECODER("decoder"),
        ENCODER("encoder");
        
        public final String value;

        private MediaCodecProcessingType(String str) {
            this.value = str;
        }

        public final boolean isDecoder() {
            return this.value.equals(DECODER.value);
        }

        public final boolean isEncoder() {
            return this.value.equals(ENCODER.value);
        }
    }

    /* compiled from: reviews_click */
    public enum MediaCodecType {
        CODEC_VIDEO_VP8("video/x-vnd.on2.vp8"),
        CODEC_VIDEO_VP9("video/x-vnd.on2.vp9"),
        CODEC_VIDEO_H264("video/avc"),
        CODEC_VIDEO_MPEG4("video/mp4v-es"),
        CODEC_VIDEO_H263("video/3gpp"),
        CODEC_AUDIO_AMR_NB("audio/3gpp"),
        CODEC_AUDIO_AMR_WB("audio/amr-wb"),
        CODEC_AUDIO_MP3("audio/mpeg"),
        CODEC_AUDIO_AAC("audio/mp4a-latm"),
        CODEC_AUDIO_VORBIS("audio/vorbis");
        
        public final String value;

        private MediaCodecType(String str) {
            this.value = str;
        }
    }
}
