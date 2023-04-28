package components;

import interfaces.Programmer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Junior")
public class Junior implements Programmer {

    @Override
    public void doCoding() {
        System.out.println("Junior java developer writing code...");
    }
////    @Value("Junior java developer writing code...")
//    @Value("${some.message}")
//    private String message;
//
//    public Junior() {
//    }
//
//    //    @Value("Junior java developer writing code...")
////    public void setMessage(String message) {
////        this.message = message;
////        System.out.println("lalalala");
////    }
//
//
////    private final String prop;
//
////    @Autowired
////    public Junior(@Value("${some.message}") String message) {
////        this.message = message;
////        System.out.println("================== " + message + "================== ");
////    }

//    @Override
//    public void doCoding() {
//        System.out.println(message);
//    }
}
