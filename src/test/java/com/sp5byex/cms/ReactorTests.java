package com.sp5byex.cms;

import com.sp5byex.cms.domain.models.Category;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;


public class ReactorTests {
  @Test
  public void coldTest() {
    Category cat = new Category();
    cat.setName("sports");
    Category cat2 = new Category();
    cat2.setName("music");
    Flux.just(cat, cat2)
      .doOnNext(System.out::println);
  }

  @Test
  public void coldWithSubscriberTest() {
    Category cat = new Category();
    cat.setName("sports");
    Category cat2 = new Category();
    cat2.setName("music");
    Flux.just(cat, cat2)
      .doOnNext(System.out::println)
      .subscribe();
  }

  @Test
  public void hotTest() {
    UnicastProcessor<String> hotSrc = UnicastProcessor.create();
    Flux<Category> hotPublisher = hotSrc.publish()
      .autoConnect()
      .map(str -> {
        Category cat = new Category();
        cat.setName(str);
        return cat;
      });
    hotPublisher.subscribe(cat -> System.out.println("Subscriber 1: " + cat));
    hotSrc.onNext("sports");
    hotSrc.onNext("cars");
    hotPublisher.subscribe(cat -> System.out.println("Subscriber 2: " + cat));
    hotSrc.onNext("games");
    hotSrc.onNext("elecs");
    hotSrc.onComplete();
  }
}
