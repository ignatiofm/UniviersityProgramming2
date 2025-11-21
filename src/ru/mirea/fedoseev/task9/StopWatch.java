package ru.mirea.fedoseev.task9;

/**
 * Задание 6: Класс StopWatch для представления секундомера
 *
 * UML Диаграмма:
 * ┌────────────────────────────┐
 * │       StopWatch            │
 * ├────────────────────────────┤
 * │ - startTime: long          │
 * │ - endTime: long            │
 * ├────────────────────────────┤
 * │ + StopWatch()              │
 * │ + getStartTime(): long     │
 * │ + getEndTime(): long       │
 * │ + start(): void            │
 * │ + stop(): void             │
 * │ + getElapsedTime(): long   │
 * └────────────────────────────┘
 */
public class StopWatch {
    private long startTime;
    private long endTime;

    /**
     * Безаргументный конструктор, инициализирует startTime текущим временем
     */
    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    /**
     * Getter для startTime
     * @return время старта в миллисекундах
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Getter для endTime
     * @return время окончания в миллисекундах
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * Метод start() сбрасывает startTime до текущего времени
     */
    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    /**
     * Метод stop() присваивает endTime текущее время
     */
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    /**
     * Метод getElapsedTime() возвращает прошедшее время на секундомере в миллисекундах
     * @return прошедшее время в миллисекундах
     */
    public long getElapsedTime() {
        return endTime - startTime;
    }

    @Override
    public String toString() {
        return "StopWatch[startTime=" + startTime + ", endTime=" + endTime +
                ", elapsedTime=" + getElapsedTime() + "ms]";
    }
}
