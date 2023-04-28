package components;

import interfaces.Programmer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Middle")
public class Middle implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Middle java developer writing code...");
    }
}