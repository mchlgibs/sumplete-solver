package com.artofsoftwaredevelopment;

import java.util.Collection;
import java.util.HashSet;

public class IndexSet extends HashSet<Integer> {
    public IndexSet() {
    }

    public IndexSet(Collection<? extends Integer> c) {
        super(c);
    }
}
