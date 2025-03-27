
# 📚 Алгоритмы сортировки и поиска для пользовательских классов

## 📝 Описание проекта

Данный проект это консольное Java-приложение, которое реализует:

- алгоритмы **сортировки выбором** (Selection Sort) и **бинарного поиска**;
- поддержку **дженериков**;
- **паттерн "Стратегия"** для выбора способа сортировки;
- **собственную коллекцию** (`CustomArrayList`);
- **валидацию данных** при вводе вручную, из файла и при рандомной генерации;
- **пользовательский интерфейс** в виде циклического текстового меню.

---

## Функционал

### ✅ Основные возможности:

- 🔢 Сортировка: **Selection Sort**  или **Сортировка по четным/нечетным числовым полям** для реализованных классов.
- 🔍 Поиск: **бинарный поиск** по отсортированным коллекциям.
- 🧠 Паттерны: реализация **паттерна "Стратегия"** для выбора способа сортировки.
- 🏗️ Builder: все классы используют паттерн **Builder** (вручную, без Lombok).
- 📑 Валидация: встроенная проверка всех вводимых данных.

---

## Пользовательские классы
### 1. 🚍 **Автобус (`Bus`)**
- Номер (`int`)
- Модель (`String`)
- Пробег (`double`)

### 2. 👤 **Пользователь (`User`)**
- Имя (`String`)
- Пароль (`String`)
- Почта (`String`)

### 3. 🎓 **Студент (`Student`)**
- Номер группы (`int`)
- Средний балл (`double`)
- Номер зачетной книжки (`int`)

---

## Реализованные компоненты

### 📦 Кастомная коллекция: `CustomArrayList<T>`
- Добавление элементов
- Получение по индексу
- Удаление по индексу

### 📊 Сортировка: `SelectionSort` 
- Универсальный алгоритм сортировки с использованием дженериков.
- Работа с `Comparable`.

### 🔎 Поиск: `BinarySearch`
- Универсальный бинарный поиск по отсортированному массиву.

### 🎯 Паттерн "Стратегия"
- Интерфейс `DataFillingStrategy<T>`
- Реализации:
  - `FileFillingStrategy<T>`
  - `ManualFillingStrategy<T>`
  - `RandomFillingStrategy<T>`

### ✅ Валидация данных

- 🔢 Проверка типов данных
- ❌ Отрицательные значения (например, пробег)
- ✉️ Проверка email
- 📜 Контроль формата строк

## Дополнительные возможности

### 🔢 Сортировка по чётным/нечётным числовым полям
- Элементы с **чётными значениями сортируются**
- Элементы с **нечётными значениями остаются на месте**
- Поддержка **любого числового поля** (пробег, средний балл, возраст и т.д.)

## Пользовательский интерфейс 

🖥️ Программа предоставляет **циклическое текстовое меню** с возможностями:

#### 1. Заполнить массив данных

- **1.1 Выбор типа данных:**
  - 🚌 Автобусы  
  - 🎓 Студенты  
  - 👤 Пользователи  

- **1.2 Выбор способа заполнения:**
  - ✍️ Ввод вручную (с указанием количества)
  - 📂 Загрузка из файла (с вводом пути к файлу)
  - 🎲 Случайная генерация (с указанием количества)

### 2. Отсортировать данные

- 📊 Сортировка выбором или кастомная сортировка 

### 3. Найти элемент

- 🔎 Ввод параметров элемента для поиска  
- ⚡ **Бинарный поиск** по выбранному полю

### 4. Выйти из программы

- ❌ Завершение работы программы


## 👥 Авторы

- Румянцева Ольга (**Team**  **Lead**)
- Кушникова Евгения 
- Ковалева Алина 
- Матвеев Алексей
- Королев Кирилл
