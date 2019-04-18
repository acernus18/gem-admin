package org.maples.gem.admin.repository;

import org.junit.Assert;
import org.junit.Test;
import org.maples.gem.admin.AdminApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;

public class GemstoneMapperTest extends AdminApplicationTests {

    @Autowired
    private GemstoneMapper gemstoneMapper;

    @Test
    public void test() {
        Assert.assertFalse(gemstoneMapper.selectAll().isEmpty());
    }
}