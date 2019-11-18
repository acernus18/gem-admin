package org.maples.gem.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminApplicationTests {
    @Test
    public void test() {
        log.info("{}", System.getProperty("java.io.tmpdir"));
    }
}

