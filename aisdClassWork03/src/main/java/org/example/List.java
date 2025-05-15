package org.example;
//<T> - переменная типа данных
public interface List <T> {    /**
 * метод добавляет элемент в список *в конец*
 *
 */
void add(T x);
    /**
     * метод добавляет элемент в позицию i
     */
    void add(T x, int i) throws IndexOutOfBoundsException;
    /**
     * удаление оп индексу i и возвращение удаленного элемента
     */
    T remove(int i) throws IndexOutOfBoundsException;

    /**
     * длина списка
     */

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
    Node<T> get();


}
