package com.artofsoftwaredevelopment;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class IndexSet extends HashSet<Integer> {
    public IndexSet() {
    }

    public IndexSet(Collection<? extends Integer> c) {
        super(c);
    }

    public static IndexSet union(List<IndexSet> listOfSets) {
        IndexSet result = new IndexSet();
        for (IndexSet set: listOfSets) {
            result.addAll(set);
        }
        return result;
    }

    public static IndexSet intersection(List<IndexSet> listOfSets) {
        IndexSet result = new IndexSet(listOfSets.get(0));
        for (IndexSet set: listOfSets) {
            result.retainAll(set);
        }
        return result;
    }
}
