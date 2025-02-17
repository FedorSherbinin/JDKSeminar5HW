# Philosophers Dinner

Этот проект реализует классическую задачу о философах за обеденным столом с использованием многопоточности в Java. В задаче пять философов сидят за круглым столом, перед каждым из них тарелка спагетти и вилки лежат между каждой парой философов. Каждый философ может либо есть, либо размышлять. Философ может есть только тогда, когда у него есть две вилки — одна слева и одна справа.

### Описание классов

- **`Fork`**: Интерфейс и реализация для вилок. Реализует операции захвата и освобождения вилок.
- **`Philosopher`**: Интерфейс для философов, расширяющий `Runnable`. Обеспечивает методы для размышления и еды.
- **`PhilosopherImpl`**: Реализация философа, которая управляет вилками и логикой еды и размышлений.
- **`Main`**: Главный класс для запуска программы. Создает философов, вилки и запускает их в отдельных потоках.
