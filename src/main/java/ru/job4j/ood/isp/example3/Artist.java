package ru.job4j.ood.isp.example3;

/**
 * Данный интерфейс имеет лишние метододы,
 * решение разделить интерфейс на мелкие составные
 * так как классы, которые будут реализвать этот интерфейс
 * могут не истпользовать все методы из за ненадобности.
 *
 */
public interface Artist {
    void playSound();

    void singASong();

    void playARole();

    void playBDSM();

    void playStrip();
}
