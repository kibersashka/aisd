package org.example;

public interface StaсkImpl<T> {
    /**
     *
     */
    void add(T x);

    /**
     * удаление
     */
    void remove();

    /**
     * получение элемента
     * @return
     */
    T get();
    /**
     * удаление всех
     */
    void clear();

    /**
     * размер
     * @return
     */
    int size();


}
