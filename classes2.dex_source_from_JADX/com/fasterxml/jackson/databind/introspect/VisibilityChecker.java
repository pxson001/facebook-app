package com.fasterxml.jackson.databind.introspect;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* compiled from: story_gallery_survey_feed_unit_impression */
public interface VisibilityChecker<T extends VisibilityChecker<T>> {

    @JsonAutoDetect(creatorVisibility = Visibility.ANY, fieldVisibility = Visibility.PUBLIC_ONLY, getterVisibility = Visibility.PUBLIC_ONLY, isGetterVisibility = Visibility.PUBLIC_ONLY, setterVisibility = Visibility.ANY)
    /* compiled from: story_gallery_survey_feed_unit_impression */
    public class Std implements VisibilityChecker<Std>, Serializable {
        public static final Std f4042a = new Std((JsonAutoDetect) Std.class.getAnnotation(JsonAutoDetect.class));
        private static final long serialVersionUID = -7073939237187922755L;
        protected final Visibility _creatorMinLevel;
        protected final Visibility _fieldMinLevel;
        protected final Visibility _getterMinLevel;
        protected final Visibility _isGetterMinLevel;
        protected final Visibility _setterMinLevel;

        public final boolean mo1029a(AnnotatedField annotatedField) {
            return m6994a(annotatedField.a);
        }

        public final boolean mo1031a(AnnotatedMethod annotatedMethod) {
            return m6996a(annotatedMethod.a);
        }

        public final boolean mo1033b(AnnotatedMethod annotatedMethod) {
            return m6997b(annotatedMethod.a);
        }

        public final boolean mo1035c(AnnotatedMethod annotatedMethod) {
            return m6998c(annotatedMethod.a);
        }

        public final /* synthetic */ VisibilityChecker mo1026a(Visibility visibility) {
            return m7000g(visibility);
        }

        public final /* synthetic */ VisibilityChecker mo1032b(Visibility visibility) {
            return m7001h(visibility);
        }

        public final /* synthetic */ VisibilityChecker mo1034c(Visibility visibility) {
            return m7002i(visibility);
        }

        public final /* synthetic */ VisibilityChecker mo1036d(Visibility visibility) {
            return m7003j(visibility);
        }

        public final /* synthetic */ VisibilityChecker mo1037e(Visibility visibility) {
            return m7004k(visibility);
        }

        public static Std m6993a() {
            return f4042a;
        }

        private Std(JsonAutoDetect jsonAutoDetect) {
            this._getterMinLevel = jsonAutoDetect.getterVisibility();
            this._isGetterMinLevel = jsonAutoDetect.isGetterVisibility();
            this._setterMinLevel = jsonAutoDetect.setterVisibility();
            this._creatorMinLevel = jsonAutoDetect.creatorVisibility();
            this._fieldMinLevel = jsonAutoDetect.fieldVisibility();
        }

        private Std(Visibility visibility, Visibility visibility2, Visibility visibility3, Visibility visibility4, Visibility visibility5) {
            this._getterMinLevel = visibility;
            this._isGetterMinLevel = visibility2;
            this._setterMinLevel = visibility3;
            this._creatorMinLevel = visibility4;
            this._fieldMinLevel = visibility5;
        }

        private Std(Visibility visibility) {
            if (visibility == Visibility.DEFAULT) {
                this._getterMinLevel = f4042a._getterMinLevel;
                this._isGetterMinLevel = f4042a._isGetterMinLevel;
                this._setterMinLevel = f4042a._setterMinLevel;
                this._creatorMinLevel = f4042a._creatorMinLevel;
                this._fieldMinLevel = f4042a._fieldMinLevel;
                return;
            }
            this._getterMinLevel = visibility;
            this._isGetterMinLevel = visibility;
            this._setterMinLevel = visibility;
            this._creatorMinLevel = visibility;
            this._fieldMinLevel = visibility;
        }

        public final VisibilityChecker mo1027a(JsonAutoDetect jsonAutoDetect) {
            if (jsonAutoDetect != null) {
                return m7000g(jsonAutoDetect.getterVisibility()).m7001h(jsonAutoDetect.isGetterVisibility()).m7002i(jsonAutoDetect.setterVisibility()).m7003j(jsonAutoDetect.creatorVisibility()).m7004k(jsonAutoDetect.fieldVisibility());
            }
            return this;
        }

        private static Std m6999f(Visibility visibility) {
            if (visibility == Visibility.DEFAULT) {
                return f4042a;
            }
            return new Std(visibility);
        }

        public final VisibilityChecker mo1028a(PropertyAccessor propertyAccessor, Visibility visibility) {
            switch (C02251.f4198a[propertyAccessor.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    return m7000g(visibility);
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    return m7002i(visibility);
                case 3:
                    return m7003j(visibility);
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    return m7004k(visibility);
                case 5:
                    return m7001h(visibility);
                case 6:
                    return m6999f(visibility);
                default:
                    return this;
            }
        }

        private Std m7000g(Visibility visibility) {
            Visibility visibility2;
            if (visibility == Visibility.DEFAULT) {
                visibility2 = f4042a._getterMinLevel;
            } else {
                visibility2 = visibility;
            }
            return this._getterMinLevel == visibility2 ? this : new Std(visibility2, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
        }

        private Std m7001h(Visibility visibility) {
            Visibility visibility2;
            if (visibility == Visibility.DEFAULT) {
                visibility2 = f4042a._isGetterMinLevel;
            } else {
                visibility2 = visibility;
            }
            return this._isGetterMinLevel == visibility2 ? this : new Std(this._getterMinLevel, visibility2, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
        }

        private Std m7002i(Visibility visibility) {
            Visibility visibility2;
            if (visibility == Visibility.DEFAULT) {
                visibility2 = f4042a._setterMinLevel;
            } else {
                visibility2 = visibility;
            }
            return this._setterMinLevel == visibility2 ? this : new Std(this._getterMinLevel, this._isGetterMinLevel, visibility2, this._creatorMinLevel, this._fieldMinLevel);
        }

        private Std m7003j(Visibility visibility) {
            Visibility visibility2;
            if (visibility == Visibility.DEFAULT) {
                visibility2 = f4042a._creatorMinLevel;
            } else {
                visibility2 = visibility;
            }
            return this._creatorMinLevel == visibility2 ? this : new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, visibility2, this._fieldMinLevel);
        }

        private Std m7004k(Visibility visibility) {
            Visibility visibility2;
            if (visibility == Visibility.DEFAULT) {
                visibility2 = f4042a._fieldMinLevel;
            } else {
                visibility2 = visibility;
            }
            return this._fieldMinLevel == visibility2 ? this : new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, visibility2);
        }

        private boolean m6995a(Member member) {
            return this._creatorMinLevel.isVisible(member);
        }

        public final boolean mo1030a(AnnotatedMember annotatedMember) {
            return m6995a(annotatedMember.j());
        }

        private boolean m6994a(Field field) {
            return this._fieldMinLevel.isVisible(field);
        }

        private boolean m6996a(Method method) {
            return this._getterMinLevel.isVisible(method);
        }

        private boolean m6997b(Method method) {
            return this._isGetterMinLevel.isVisible(method);
        }

        private boolean m6998c(Method method) {
            return this._setterMinLevel.isVisible(method);
        }

        public String toString() {
            return "[Visibility: getter: " + this._getterMinLevel + ", isGetter: " + this._isGetterMinLevel + ", setter: " + this._setterMinLevel + ", creator: " + this._creatorMinLevel + ", field: " + this._fieldMinLevel + "]";
        }
    }

    /* compiled from: story_gallery_survey_feed_unit_impression */
    /* synthetic */ class C02251 {
        static final /* synthetic */ int[] f4198a = new int[PropertyAccessor.values().length];

        static {
            try {
                f4198a[PropertyAccessor.GETTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4198a[PropertyAccessor.SETTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4198a[PropertyAccessor.CREATOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4198a[PropertyAccessor.FIELD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4198a[PropertyAccessor.IS_GETTER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4198a[PropertyAccessor.ALL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    T mo1026a(Visibility visibility);

    T mo1027a(JsonAutoDetect jsonAutoDetect);

    T mo1028a(PropertyAccessor propertyAccessor, Visibility visibility);

    boolean mo1029a(AnnotatedField annotatedField);

    boolean mo1030a(AnnotatedMember annotatedMember);

    boolean mo1031a(AnnotatedMethod annotatedMethod);

    T mo1032b(Visibility visibility);

    boolean mo1033b(AnnotatedMethod annotatedMethod);

    T mo1034c(Visibility visibility);

    boolean mo1035c(AnnotatedMethod annotatedMethod);

    T mo1036d(Visibility visibility);

    T mo1037e(Visibility visibility);
}
