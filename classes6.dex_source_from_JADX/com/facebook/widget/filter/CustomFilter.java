package com.facebook.widget.filter;

/* compiled from: reshareMessage */
public interface CustomFilter {

    /* compiled from: reshareMessage */
    public interface Delayer {
        long m8348a();
    }

    /* compiled from: reshareMessage */
    public interface FilterListener {
        void mo1517a(int i);

        void mo1518a(FilteringState filteringState);
    }

    /* compiled from: reshareMessage */
    public class FilterResults {
        public Object f5739a;
        public int f5740b;
    }

    /* compiled from: reshareMessage */
    public enum FilteringState {
        FILTERING,
        FINISHED
    }

    void mo389a(CharSequence charSequence);

    void mo390a(CharSequence charSequence, FilterListener filterListener);

    FilteringState mo391b();
}
