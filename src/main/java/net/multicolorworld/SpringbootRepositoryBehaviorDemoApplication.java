package net.multicolorworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@SpringBootApplication
@Controller
public class SpringbootRepositoryBehaviorDemoApplication {

    @Autowired
    HogeRepository hogeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRepositoryBehaviorDemoApplication.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    public List<Hoge> getHogeList() {
        Hoge hoge = new Hoge(0, "hoge");
        hogeRepository.save(hoge);

        return hogeRepository.findAll();
    }

    @RequestMapping("/id")
    @ResponseBody
    public List<Hoge> getHogeListOnlyId() {
        List<Hoge> hoges = hogeRepository.findAllOnlyId();
        //これは通る
        //ただしhogesはこの時点ですでにIntegerのListになっているので型がおかしい気がする

        for (Hoge hoge : hoges) { //ここでInteger->Hogeのキャストが発生して死ぬ
            System.out.println(hoge);
        }

        return hoges;
    }
}
