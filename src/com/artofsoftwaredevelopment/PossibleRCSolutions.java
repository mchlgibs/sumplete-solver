package com.artofsoftwaredevelopment;

import java.util.ArrayList;

public class PossibleRCSolutions extends ArrayList<IndexSet> {
    public static PossibleRCSolutions getAllPosibilities(int size) {
        PossibleRCSolutions result = new PossibleRCSolutions();

        final IndexSet emptySet = new IndexSet();
        result.add(emptySet);

        for (int i = 0; i < size; i++) {
            PossibleRCSolutions previous = result;
            result = new PossibleRCSolutions();

            for (IndexSet set : previous) {
                IndexSet setWithoutI = set;

                IndexSet setWithI = new IndexSet(setWithoutI);
                setWithI.add(i);

                result.add(setWithI);
                result.add(setWithoutI);
            }
        }
        return result;
    }

    public void filterWith(int index) {
        removeIf((set) -> !set.contains(index));
    }

    public void filterWithout(int index) {
        removeIf((set) -> set.contains(index));
    }
}
