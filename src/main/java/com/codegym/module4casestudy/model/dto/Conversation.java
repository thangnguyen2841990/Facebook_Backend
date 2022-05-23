package com.codegym.module4casestudy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conversation {
    List<MessagerDTO> listMessager;
}
