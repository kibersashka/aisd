package org.example;
//<T> - переменная типа данных
public interface StaсkImpl<T> {    /**
 * метод добавляет элемент в список *в конец*
 *
 */
void add(T x);
    /**
     * метод добавляет элемент в позицию i
     */
    void add(T x, int i) throws IndexOutOfBoundsException;
    /**
     *
     *
     * удаление оп индексу i и возвращение удаленного элемента
     */
    void remove();
    T get();
    /**
     * длина списка
     */
    void clear();

    int size();
    /**
     * обращение по индексу
     * Integer --->>> null
     */
    T get(int i) throws IndexOutOfBoundsException;

    /**
     *
     * sortirovka
     * acs - направление сортировки
     * true - возрастание
     */


}
