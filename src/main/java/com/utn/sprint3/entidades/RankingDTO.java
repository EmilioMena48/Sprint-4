package com.utn.sprint3.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RankingDTO implements Serializable {

    Long id;
    String username;
    Integer Pedido;


}