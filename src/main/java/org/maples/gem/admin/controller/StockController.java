package org.maples.gem.admin.controller;

import com.alibaba.fastjson.JSONObject;
import org.maples.gem.admin.model.Gemstone;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @PostMapping("/append")
    public void append(@RequestBody List<Gemstone> gemstones) {

    }

    @PostMapping("/delete")
    public void delete(@RequestBody List<Integer> gemstonesID) {

    }

    @PostMapping("/modify")
    public void modify(@RequestBody List<Gemstone> gemstones) {

    }

    @PostMapping("/retrieve")
    public Object retrieve(@RequestBody JSONObject conditions) {
        return null;
    }
}
