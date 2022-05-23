package com.codegym.module4casestudy.model.dto;

import com.codegym.module4casestudy.model.entity.ReplyComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListReply {
    private List<ReplyComment> listReply;
}
