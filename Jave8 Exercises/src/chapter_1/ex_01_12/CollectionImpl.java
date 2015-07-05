package chapter_1.ex_01_12;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

public class CollectionImpl<E> implements Collection<E>, AtherStream<E> {

    //この処理を追記しないとコンパイルエラーとなる
    public Stream<E> stream() {
        //明示的にCollectionクラスのデフォルトメソッドを指定
        return Collection.super.stream();
    }

    public int size() {
        // TODO 自動生成されたメソッド・スタブ
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public boolean contains(Object o) {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public boolean add(E e) {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public boolean remove(Object o) {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public void clear() {
        // TODO 自動生成されたメソッド・スタブ

    }

}
