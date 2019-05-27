package com.sp5byex.cms.domain.models;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Tag {

    String value;
}
