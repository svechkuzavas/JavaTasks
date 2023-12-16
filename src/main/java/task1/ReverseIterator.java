package task1;

import java.util.Iterator;
import java.util.List;

public class ReverseIterator<T> implements Iterator<T> {

    private final List<T> mSourceList;
    private int mCurrentIndex;

    public ReverseIterator(List<T> sourceList) {
        mSourceList = sourceList;
        mCurrentIndex = sourceList.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return mCurrentIndex >= 0;
    }

    @Override
    public T next() {
        mCurrentIndex -= 1;
        return mSourceList.get(mCurrentIndex + 1);
    }
}
