package com.facebook.ads;

public class NativeAdView {

    public enum Type {
        HEIGHT_100(-1, 100),
        HEIGHT_120(-1, 120),
        HEIGHT_300(-1, 300),
        HEIGHT_400(-1, 400);
        
        private final int f13947a;
        private final int f13948b;

        private Type(int i, int i2) {
            this.f13947a = i;
            this.f13948b = i2;
        }

        public final int getHeight() {
            return this.f13948b;
        }

        public final int getValue() {
            switch (this.f13948b) {
                case 100:
                    return 1;
                case 120:
                    return 2;
                case 300:
                    return 3;
                case 400:
                    return 4;
                default:
                    return -1;
            }
        }

        public final int getWidth() {
            return this.f13947a;
        }
    }
}
