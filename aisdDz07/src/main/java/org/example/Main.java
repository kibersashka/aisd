package org.example;

import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String len = "12013456789";
        boolean[] arr = new boolean[len.length()];
        int l = 0;
        int r = len.length();
        for(int i = 0; i < r; i++){
            arr[i] = res(String.valueOf(i + 1), len);
            if(!arr[i]){
                System.out.println(i + 1);
                break;
            }
        }




    }
    public static boolean res(String count, String len){
        int l = 0;
        int r = len.length() - 1;
        String res = "";
        int y = 0;
        if(len.contains(String.valueOf(count))){
            return true;
        }
        while(l != r && y < count.length()){
            if(len.charAt(l) == count.charAt(y)){
                y++;

                res += len.charAt(l);
                if(res.equals(count)){
                    return true;
                }
            }
            l++;

        }
        return false;
    }
}
/*
Для решения этой задачи нужно найти первое натуральное число N, которое нельзя получить из цифр числа X путем вычеркивания некоторых цифр (без изменения порядка оставшихся).

### Идея решения
1. **Генерация чисел по порядку**: Начнем с числа 1 и будем последовательно проверять, можно ли его получить из цифр X.
2. **Проверка возможности формирования числа**:
   - Для каждого числа N преобразуем его в строку.
   - Проверим, можно ли найти последовательность цифр числа N в X, идущих подряд в том же порядке (без необходимости быть последовательными, но сохраняя порядок).
3. **Первое недостижимое число**: Как только найдем первое число, которое нельзя составить из цифр X, это и будет искомое N.

### Пример
**Входные данные:**
```
12013456789
```
**Проверка:**
- 1 → "1" → можно (первая цифра).
- 2 → "2" → можно (третья цифра).
- ...
- 22 → "22" → нельзя (в X нет двух двоек подряд).
- Значит, N = 22.

### Алгоритм
1. Преобразуем X в строку для удобства обработки.
2. Начнем перебирать числа N = 1, 2, 3, ...
3. Для каждого N:
   - Преобразуем N в строку.
   - Проверим, является ли эта строка подпоследовательностью строки X.
   - Если нет, возвращаем N как ответ.

### Оптимизация
- Для больших X (до 10^1000) важно эффективно проверять подпоследовательности, чтобы не превысить лимиты времени.
- Можно использовать метод двух указателей: один для цифр X, другой для цифр N.

### Реализация на Python
```python
def find_min_unobtainable(X):
    X_str = str(X)
    N = 1
    while True:
        N_str = str(N)
        i = 0
        for c in X_str:
            if i < len(N_str) and c == N_str[i]:
                i += 1
        if i != len(N_str):
            return N
        N += 1

X = int(input())
print(find_min_unobtainable(X))
```

### Объяснение
- **Функция `find_min_unobtainable`**:
  - Преобразует X в строку `X_str`.
  - Начинает с N = 1 и для каждого N проверяет, можно ли его цифры найти в `X_str` в том же порядке.
  - Если цифры N не найдены в нужном порядке, возвращает N.
- **Проверка подпоследовательности**:
  - Использует два указателя: один идет по цифрам X, другой по цифрам N.
  - Если все цифры N найдены в X в правильном порядке, увеличивает N и продолжает поиск.

Этот метод эффективно находит первое недостижимое число, перебирая числа по порядку и проверяя их возможность быть сформированными из X.
 */