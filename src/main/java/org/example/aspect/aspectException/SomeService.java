package org.example.aspect.aspectException;

import org.springframework.stereotype.Service;

/**
 * @author walker
 * @since 2022/11/24 18:53
 */
@Service
public class SomeService {

    @AnnotationLog
    public void test() {
        System.out.println("some service");
    }
}
