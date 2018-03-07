package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

/* compiled from: can_viewer_edit_host */
public abstract class ViewMatcher {

    /* compiled from: can_viewer_edit_host */
    final class Empty extends ViewMatcher implements Serializable {
        static final Empty f6269a = new Empty();
        private static final long serialVersionUID = 1;

        private Empty() {
        }

        public final boolean mo729a(Class<?> cls) {
            return false;
        }
    }

    /* compiled from: can_viewer_edit_host */
    final class Multi extends ViewMatcher implements Serializable {
        private static final long serialVersionUID = 1;
        private final Class<?>[] _views;

        public Multi(Class<?>[] clsArr) {
            this._views = clsArr;
        }

        public final boolean mo729a(Class<?> cls) {
            for (Class<?> cls2 : this._views) {
                if (cls == cls2 || cls2.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: can_viewer_edit_host */
    final class Single extends ViewMatcher implements Serializable {
        private static final long serialVersionUID = 1;
        private final Class<?> _view;

        public Single(Class<?> cls) {
            this._view = cls;
        }

        public final boolean mo729a(Class<?> cls) {
            return cls == this._view || this._view.isAssignableFrom(cls);
        }
    }

    public abstract boolean mo729a(Class<?> cls);

    public static ViewMatcher m11858a(Class<?>[] clsArr) {
        if (clsArr == null) {
            return Empty.f6269a;
        }
        switch (clsArr.length) {
            case 0:
                return Empty.f6269a;
            case 1:
                return new Single(clsArr[0]);
            default:
                return new Multi(clsArr);
        }
    }
}
