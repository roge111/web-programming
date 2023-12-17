package ru.batargin.weblab3.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name = "results")
@FieldDefaults(level = AccessLevel.PRIVATE) //делает модификатор доступа ко всем полям приватным
@Getter  // генерирует get
@Setter// генерирует set
@NoArgsConstructor // автоматическая генерация непараметризованного контруктора
public class Result implements Serializable, Cloneable {

    @Id
    @SequenceGenerator(name = "sequence_generator", sequenceName = "id_sequence", allocationSize = 1)//sequenceName это имя последовательности в БД. Генерирует длинные значения
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator") // создает последовательность
    int id;
    double x, y, r = 1;
    @Transient
    boolean successful;
    long time;

    public String getSuccessString() {
        return successful ? "Да" : "Нет";
    }

    public String getFormattedTime() {
        return new SimpleDateFormat("dd.MM.yy HH:mm:ss")
                .format(new Date(time));
    }

    @Override
    public Result clone() {
        Result cloned = new Result();
        cloned.x = x;
        cloned.y = y;
        cloned.r = r;
        return cloned;
    }
}
