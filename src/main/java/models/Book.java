package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
public class Book extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

}
