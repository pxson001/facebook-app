package com.facebook.richdocument.view.transition;

/* compiled from: other_dismiss_action */
public final class MediaTransitionState implements TransitionState<MediaTransitionState> {
    public static final MediaTransitionState f6977a = new MediaTransitionState(PresentationMode.COLLAPSED, Orientation.PORTRAIT, 1.0f);
    public static final MediaTransitionState f6978b = new MediaTransitionState(PresentationMode.EXPANDED, Orientation.PORTRAIT, 1.0f);
    public static final MediaTransitionState f6979c = new MediaTransitionState(PresentationMode.COLLAPSED, Orientation.LANDSCAPE_LEFT, 1.0f);
    public static final MediaTransitionState f6980d = new MediaTransitionState(PresentationMode.COLLAPSED, Orientation.LANDSCAPE_RIGHT, 1.0f);
    public final PresentationMode f6981e;
    public final Orientation f6982f;
    public final float f6983g;

    /* compiled from: other_dismiss_action */
    public enum Orientation {
        PORTRAIT(0),
        LANDSCAPE_LEFT(90),
        LANDSCAPE_RIGHT(-90);
        
        int mDegree;

        private Orientation(int i) {
            this.mDegree = i;
        }

        public final int getDegree() {
            return this.mDegree;
        }

        public final boolean isLandscape() {
            return this == LANDSCAPE_LEFT || this == LANDSCAPE_RIGHT;
        }
    }

    /* compiled from: other_dismiss_action */
    public enum PresentationMode {
        COLLAPSED,
        EXPANDED
    }

    public final TransitionState mo422a(TransitionState transitionState, float f) {
        MediaTransitionState mediaTransitionState = (MediaTransitionState) transitionState;
        if (f == 0.0f) {
            return this;
        }
        if (f == 1.0f) {
            return mediaTransitionState;
        }
        this(mediaTransitionState.f6981e, mediaTransitionState.f6982f, f);
        return this;
    }

    public MediaTransitionState(PresentationMode presentationMode, Orientation orientation, float f) {
        this.f6981e = presentationMode;
        this.f6982f = orientation;
        this.f6983g = f;
    }

    public final MediaTransitionState m7272e() {
        MediaTransitionState mediaTransitionState = f6978b;
        if (this.f6981e == PresentationMode.EXPANDED) {
            return mediaTransitionState;
        }
        switch (this.f6982f) {
            case PORTRAIT:
                return f6977a;
            case LANDSCAPE_LEFT:
                return f6979c;
            case LANDSCAPE_RIGHT:
                return f6980d;
            default:
                return mediaTransitionState;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaTransitionState mediaTransitionState = (MediaTransitionState) obj;
        if (this.f6981e.equals(mediaTransitionState.f6981e) && this.f6982f.equals(mediaTransitionState.f6982f) && this.f6983g == mediaTransitionState.f6983g) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6981e.hashCode() + ((this.f6982f.hashCode() + (Float.valueOf(this.f6983g).hashCode() * 31)) * 31);
    }
}
