package com.fasterxml.jackson.annotation;

/* compiled from: collections_typeahead_report_duplicates */
public class ObjectIdGenerators {

    /* compiled from: collections_typeahead_report_duplicates */
    public abstract class Base<T> extends ObjectIdGenerator<T> {
        protected final Class<?> _scope;

        protected Base(Class<?> cls) {
            this._scope = cls;
        }

        public final Class<?> mo634a() {
            return this._scope;
        }

        public boolean mo635a(ObjectIdGenerator<?> objectIdGenerator) {
            return objectIdGenerator.getClass() == getClass() && objectIdGenerator.mo634a() == this._scope;
        }
    }

    /* compiled from: collections_typeahead_report_duplicates */
    public abstract class None extends ObjectIdGenerator<Object> {
    }

    /* compiled from: collections_typeahead_report_duplicates */
    public abstract class PropertyGenerator extends Base<Object> {
        private static final long serialVersionUID = 1;

        protected PropertyGenerator(Class<?> cls) {
            super(cls);
        }
    }
}
