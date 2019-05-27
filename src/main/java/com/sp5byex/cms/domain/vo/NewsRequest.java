package com.sp5byex.cms.domain.vo;

import com.sp5byex.cms.domain.models.Category;
import com.sp5byex.cms.domain.models.Tag;
import lombok.Data;

import java.util.Set;

@Data
public class NewsRequest {

  String title;

  String content;

  Set<Category> categories;

  Set<Tag> tags;
}
