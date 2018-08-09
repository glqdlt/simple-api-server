package com.fourones.simpleapiserver.persistence.simpleMemoryDB.entity.account;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "SIMPLE_DATABASE")
@Getter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;
    private String id;
    private String password;
    private Date regDate;

}
